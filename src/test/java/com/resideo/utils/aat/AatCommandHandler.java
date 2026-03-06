package com.resideo.utils.aat;

import com.fazecast.jSerialComm.SerialPort;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * AAT serial command handler.
 *
 * Responsibilities: 1) Open and manage the serial port for AAT communication.
 * 2) Build and send AAT CHANGE / QUERY frames over MCI sub-protocol framing. 3)
 * Read responses from the serial stream, decode (byte-unstuff), validate
 * (length/CRC), and provide response data to higher-level controller methods.
 *
 * Notes: - This class assumes a single active AAT serial connection per test
 * run (activePort/input are static). - It maintains a per-instance message
 * counter (msgNumber) used in transmitted frames and ACK validation.
 */
public class AatCommandHandler {

	/**
	 * Serial input stream from the active port (static because only one AAT port is
	 * expected per run).
	 */
	private static InputStream input;

	/**
	 * AAT message counter (0-255). Incremented for each built frame (CHANGE/QUERY),
	 * used to correlate device ACKs with transmitted messages.
	 */
	private int msgNumber = 0;

	/** Active serial port used for all AAT writes/reads. */
	private static SerialPort activePort;

	/**
	 * CRC lookup tables (nibble-based) used by the device protocol. CRC is computed
	 * over the AAT header/body bytes (before stuffing).
	 */
	private static final int[] R1 = { 0x00, 0x5E, 0xBC, 0xE2, 0x61, 0x3F, 0xDD, 0x83, 0xC2, 0x9C, 0x7E, 0x20, 0xA3,
			0xFD, 0x1F, 0x41 };
	private static final int[] R2 = { 0x00, 0x9D, 0x23, 0xBE, 0x46, 0xDB, 0x65, 0xF8, 0x8C, 0x11, 0xAF, 0x32, 0xCA,
			0x57, 0xE9, 0x74 };

	/**
	 * Queue containing RAW AAT frames (still stuffed) captured from the serial
	 * stream that matched the expected MsgID for a request.
	 */
	private final BlockingQueue<byte[]> aatResponseQueue = new LinkedBlockingQueue<>();

	/**
	 * Queue containing decoded frames that failed validation or were not the
	 * expected MsgID. Useful for debugging noise/unrelated frames.
	 */
	private final BlockingQueue<byte[]> aatBadResponseQueue = new LinkedBlockingQueue<>();

	/**
	 * Opens the serial port used for AAT communication and initializes the static
	 * activePort/input.
	 *
	 * Behavior: - Scans available COM ports. - Selects the port by matching
	 * description text (TTL-232R-3V3-AJ). - Configures
	 * baud/parity/stopbits/timeouts and opens the port.
	 *
	 * @return true if port is found and opened successfully, otherwise false.
	 */
	public static boolean openPort() {
		SerialPort[] ports = SerialPort.getCommPorts();
		System.out.println("Scanning available COM ports...");
		for (SerialPort port : ports) {
			System.out.println("Found: " + port.getSystemPortName() + " | " + port.getPortDescription());
		}

		SerialPort found = null;
		for (SerialPort port : ports) {
			if (port.getPortDescription().toLowerCase().contains("ttl-232r-3v3-aj")) {
				found = port;
				break;
			}
		}

		if (found == null) {
			System.out.println("No suitable serial port detected for AAT Communication!");
			return false;
		}

		System.out
				.println("Auto-selected port: " + found.getSystemPortName() + " (" + found.getPortDescription() + ")");

		int baudRate = 115200;
		int dataBits = 8;
		int stopBits = SerialPort.ONE_STOP_BIT;
		int parity = SerialPort.NO_PARITY;
		int readTimeoutMs = 20;
		int writeTimeoutMs = 20;

		found.setComPortParameters(baudRate, dataBits, stopBits, parity);
		found.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, readTimeoutMs, writeTimeoutMs);

		if (!found.openPort()) {
			System.out.println("Failed to open: " + found.getSystemPortName());
			return false;
		}

		activePort = found;
		input = found.getInputStream();
		System.out.println("Port OPENED: " + found.getSystemPortName());
		return true;
	}

	/**
	 * Validates whether the AAT active port is ready for use.
	 *
	 * @return true if activePort is not null and open, else false.
	 */
	public static boolean isActivePortOpen() {
		if (activePort != null && activePort.isOpen()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Drains any pending bytes from the serial input stream.
	 *
	 * Purpose: - Avoid stale/previous noise affecting current request/response
	 * capture. - Called before sending CHANGE/QUERY to start from a clean read
	 * boundary.
	 */
	private void clearSerialInput() {
		try {
			if (input == null)
				return;
			while (input.available() > 0) {
				input.read();
			}
		} catch (Exception ignored) {
		}
	}

	/**
	 * Clears only internal response/bad-response queues.
	 *
	 * Purpose: - Ensures the next response read is correlated to the most recent
	 * request. - Keeps queue state deterministic for consumers (getAATResponse /
	 * getAATResponseDataOfMsgID).
	 */
	private void clearQueuesOnly() {
		aatResponseQueue.clear();
		aatBadResponseQueue.clear();
	}

	/**
	 * Builds a complete MCI-wrapped AAT frame that is ready to transmit on serial.
	 *
	 * Steps: 1) Increment msgNumber (0..255). 2) Construct AAT payload block
	 * (msgType/cpuId/msgNumber/msgIdType/msgId/ancCount/payload + CRC). 3) Apply
	 * AAT byte-stuffing (escape HEADER/FOOTER/STUFF_PREFIX). 4) Apply MCI
	 * byte-stuffing (escape MCI HEADER/STUFF_PREFIX). 5) Wrap with MCI header +
	 * subprotocol + AAT header/footer markers.
	 *
	 * @param msgIdType AAT message type (CHANGE/QUERY/RESPONSE/EVENT) value.
	 * @param msgId     Protocol message id (e.g., System Mode Change/Query).
	 * @param payload   Ancillary data bytes (can be null).
	 * @return encoded/stuffed frame bytes ready for writeBytes().
	 */
	private byte[] buildAATFrame(byte msgIdType, int msgId, byte[] payload) throws IOException {

		if (payload == null)
			payload = new byte[0];

		msgNumber = (msgNumber + 1) & 0xFF;

		ByteArrayOutputStream frame = new ByteArrayOutputStream();
		frame.write(ThermostatConstant.AAT.MSG_TYPE);
		frame.write(ThermostatConstant.AAT.CPU_ID);
		frame.write(msgNumber);
		frame.write(msgIdType);
		frame.write((msgId >> 8) & 0xFF);
		frame.write(msgId & 0xFF);
		frame.write((payload.length >> 8) & 0xFF);
		frame.write(payload.length & 0xFF);
		frame.write(payload);

		byte crc = computeCRC(frame.toByteArray());
		frame.write(crc);

		byte[] stuffedAAT = applyAATByteStuff(frame.toByteArray());
		byte[] stuffedMCI = applyMCIByteStuff(stuffedAAT);

		ByteArrayOutputStream finalFrame = new ByteArrayOutputStream();
		finalFrame.write(ThermostatConstant.MCI.HEADER);
		finalFrame.write(ThermostatConstant.MCI.AUTOMATED_TEST);
		finalFrame.write(ThermostatConstant.AAT.HEADER);
		finalFrame.write(stuffedMCI);
		finalFrame.write(ThermostatConstant.AAT.FOOTER);

		return finalFrame.toByteArray();
	}

	/**
	 * Sends an AAT CHANGE message (fire command) and verifies device CHANGE ACK
	 * response.
	 *
	 * Flow: - Verify active port is open. - Up to 3 attempts: 1) clear input +
	 * queues 2) build and write CHANGE frame 3) wait for CHANGE_ACK_RESPONSE
	 * (MsgId=0x0011) 4) decode + validate ACK fields (MsgIDType, MsgId, MsgNumber,
	 * acked Change MsgId)
	 *
	 * @param msgId     Change command msg id (e.g., SYSTEM_MODE_CHANGE).
	 * @param payload   Change payload bytes.
	 * @param timeoutMs Max time to wait for ACK on each attempt.
	 * @return true if write succeeded and ACK validated; false otherwise.
	 */
	public boolean AATChange(int msgId, byte[] payload, int timeoutMs) {
		try {
			if (!isActivePortOpen()) {
				System.err.println("AATChange failed: activePort is null or not open. Call openPort() first.");
				return false;
			}

			for (int attempt = 1; attempt <= 3; attempt++) {
				clearSerialInput();
				clearQueuesOnly();

				byte[] output = buildAATFrame((byte) ThermostatConstant.AAT.MSG_ID_TYPE.CHANGE.value, msgId, payload);
				final int sentMsgNumber = msgNumber & 0xFF;

				System.out.println("AAT CHANGE -> " + toHex(output) + " | ACK attempt=" + attempt);

				int written = activePort.writeBytes(output, output.length);
				if (written != output.length) {
					System.err.println("AATChange write failed: wrote " + written + "/" + output.length
							+ " bytes | ACK attempt=" + attempt);

					if (attempt < 3) {
						TimeUnit.MILLISECONDS.sleep(200);
						continue;
					}
					return false;
				}

				try {
					// reads the serial stream until it finds a valid AAT frame whose MsgID ==
					// 0x0011 (CHANGE ACK)
					byte[] rawAck = waitForAATResponse(timeoutMs,
							ThermostatConstant.ResponseMsgId.CHANGE_ACK_RESPONSE.value);
					aatResponseQueue.offer(rawAck);
					System.out.println("AAT ACK  <- " + toHex(rawAck) + " | ACK attempt=" + attempt);

					byte[] decodedAck = decodeAatBytes(rawAck);
					// If validateChangeAck throws, we retry
					validateChangeAck(decodedAck, msgId, sentMsgNumber);
					return true; // ACK verified
				} catch (Exception ackErr) {
					System.err.println("AATChange ACK failed on attempt " + attempt + ": " + ackErr.getMessage());
					if (attempt < 3) {
						TimeUnit.MILLISECONDS.sleep(200);
					} else {
						return false;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.err.println("AATChange failed for msgId=" + msgId + " : " + e.getMessage());
			return false;
		}
	}

	/**
	 * Validates a decoded CHANGE ACK (MsgID=0x0011) frame from the thermostat.
	 *
	 * Validations: - Frame structure/CRC/length (isValidDecodedAatFrame) -
	 * MsgIDType is RESPONSE - MsgID is CHANGE_ACK_RESPONSE - MsgNumber matches the
	 * message number used when sending the CHANGE - AncillaryCount is at least 2
	 * and contains the acked Change MsgID (MSB+LSB)
	 *
	 * Any failure: - Puts frame into aatBadResponseQueue for debug - Throws
	 * exception to trigger retry logic in AATChange()
	 */
	private void validateChangeAck(byte[] decoded, int expectedChangeMsgId, int expectedMsgNumber) throws Exception {
		if (!isValidDecodedAatFrame(decoded)) {
			aatBadResponseQueue.offer(decoded);
			throw new Exception("Invalid CHANGE ACK frame (CRC/length) | Frame: " + toHex(decoded));
		}

		int msgIdType = decoded[ThermostatConstant.AAT.MSG_ID_TYPE_IDX] & 0xFF;
		if (msgIdType != ThermostatConstant.AAT.MSG_ID_TYPE.RESPONSE.value) {
			aatBadResponseQueue.offer(decoded);
			throw new Exception("CHANGE ACK has wrong MsgIDType=" + msgIdType + " | Frame: " + toHex(decoded));
		}

		int respMsgId = ((decoded[ThermostatConstant.AAT.MSG_ID_IDX] & 0xFF) << 8)
				| (decoded[ThermostatConstant.AAT.MSG_ID_IDX + 1] & 0xFF);

		if (respMsgId != (ThermostatConstant.ResponseMsgId.CHANGE_ACK_RESPONSE.value & 0xFFFF)) {
			aatBadResponseQueue.offer(decoded);
			throw new Exception("Expected CHANGE_ACK_RESPONSE MsgID=0x0011 but got 0x"
					+ String.format("%04X", respMsgId) + " | Frame: " + toHex(decoded));
		}

		int respMsgNumber = decoded[ThermostatConstant.AAT.MSG_NUMBER_IDX] & 0xFF;
		if (respMsgNumber != (expectedMsgNumber & 0xFF)) {
			// Minimal ACK behavior observed on some cases (RESET_CHANGE): MsgNumber can be 0
			if (respMsgNumber == 0) {
				System.out.println("CHANGE ACK MsgNumber mismatch (expected " + expectedMsgNumber + " but got "
						+ respMsgNumber + ") → accepting minimal ACK | Frame: " + toHex(decoded));
			} else {
				aatBadResponseQueue.offer(decoded);
				throw new Exception("CHANGE ACK MsgNumber mismatch → expected " + expectedMsgNumber + " but got "
						+ respMsgNumber + " | Frame: " + toHex(decoded));
			}
		}

		int ancCount = ((decoded[ThermostatConstant.AAT.ANCILLARY_COUNT_IDX] & 0xFF) << 8)
				| (decoded[ThermostatConstant.AAT.ANCILLARY_COUNT_IDX + 1] & 0xFF);

		if (ancCount < 2) {
			// Minimal ACK behavior observed: no ancillary bytes (cannot validate acked msgId)
			System.out.println("CHANGE ACK ancCount < 2 → ancCount=" + ancCount + " → accepting minimal ACK | Frame: "
					+ toHex(decoded));
			return;
		}

		int dataIdx = ThermostatConstant.AAT.ANCILLARY_DATA_IDX;
		int ackedMsgId = ((decoded[dataIdx] & 0xFF) << 8) | (decoded[dataIdx + 1] & 0xFF);

		if (ackedMsgId != (expectedChangeMsgId & 0xFFFF)) {
			aatBadResponseQueue.offer(decoded);
			throw new Exception(
					"CHANGE ACK does not match change MsgID → expected 0x" + String.format("%04X", expectedChangeMsgId)
							+ " but got 0x" + String.format("%04X", ackedMsgId) + " | Frame: " + toHex(decoded));
		}

		System.out.println("CHANGE ACK verified for MsgID=0x" + String.format("%04X", expectedChangeMsgId)
				+ " MsgNumber=" + expectedMsgNumber);
	}
	/**
	 * Sends an AAT QUERY command and waits for the corresponding RESPONSE frame.
	 *
	 * Notes: - Expected response MsgID is (queryMsgId + 1) as per the protocol
	 * behavior. - Retries up to 3 times if waiting for response fails
	 * (timeout/noise). - On success, stores RAW response frame into
	 * aatResponseQueue for consumer methods.
	 *
	 * @param msgId     Query command msg id.
	 * @param payload   Query payload (often empty).
	 * @param timeoutMs Max time to wait for a matching response frame.
	 * @return true if response received and enqueued; false otherwise.
	 */
	public boolean AATQuery(int msgId, byte[] payload, int timeoutMs) {
		int attempt = 0;
		try {
			if (!isActivePortOpen()) {
				System.err.println("AATQuery failed: activePort is null or not open. Call openPort() first.");
				return false;
			}

			while (attempt <= 2) {
				attempt++;
				clearSerialInput();
				clearQueuesOnly();

				byte[] output = buildAATFrame((byte) ThermostatConstant.AAT.MSG_ID_TYPE.QUERY.value, msgId, payload);
				System.out.println("AAT QUERY -> " + toHex(output));

				int written = activePort.writeBytes(output, output.length);
				if (written != output.length) {
					System.err
							.println("AATQuery failed: writeBytes wrote " + written + "/" + output.length + " bytes.");
					return false;
				}

				int expectedResponseMsgId = (msgId + 1) & 0xFFFF;

				try {
					byte[] rawAat = waitForAATResponse(timeoutMs, expectedResponseMsgId);
					boolean offered = aatResponseQueue.offer(rawAat);
					if (!offered) {
						System.err.println(
								"AATQuery failed: could not enqueue response (aatResponseQueue.offer returned false).");
						return false;
					}
					System.out.println("AAT RESP <- " + toHex(rawAat));
					return true;
				} catch (Exception e) { // Retry only for timeouts / response wait issues
					System.err.println(
							"AATQuery attempt #" + attempt + " failed waiting for response: " + e.getMessage());
					if (attempt > 2) {
						return false;
					}
					TimeUnit.MILLISECONDS.sleep(150);
				}
			}
			return false;
		} catch (Exception e) {
			System.err.println("AATQuery failed for msgId=" + msgId + " : " + e.getMessage());
			return false;
		}
	}

	/**
	 * Reads the serial stream until a valid AAT frame is found for the expected
	 * response MsgID.
	 *
	 * Scanner state machine: - Wait for MCI header '[' (0x5B) - Wait for MCI
	 * subprotocol '2' (AUTOMATED_TEST) - Wait for AAT header '<' (0x3C) - Validate
	 * next two bytes are MsgType=0x00 and CPU_ID=0x00 (filters ASCII/log noise) -
	 * Capture bytes until AAT footer '>' (0x3E), decode, validate, and match
	 * expected MsgID
	 *
	 * @param timeoutMs     Maximum time allowed for scanning/capture.
	 * @param expectedMsgId Expected decoded MsgID that this call is waiting for.
	 * @return RAW captured AAT frame as received (stuffed), starting with '<' and
	 *         ending with '>'.
	 * @throws Exception if timeout occurs before a matching frame is received.
	 */
	private byte[] waitForAATResponse(int timeoutMs, int expectedMsgId) throws Exception {
		long start = System.currentTimeMillis();
		int state = 0;
		ByteArrayOutputStream rawAat = new ByteArrayOutputStream();

		while (System.currentTimeMillis() - start < timeoutMs) {

			if (input == null || input.available() <= 0) {
				TimeUnit.MILLISECONDS.sleep(1);
				continue;
			}

			int b = input.read();
			if (b < 0)
				continue;
			int v = b & 0xFF;

			switch (state) {
			case 0:
				if (v == (ThermostatConstant.MCI.HEADER & 0xFF))
					state = 1;
				break;
			case 1:
				if (v == (ThermostatConstant.MCI.AUTOMATED_TEST & 0xFF)) {
					state = 2;
				} else {
					state = 0;
				}
				break;
			case 2:
				if (v != (ThermostatConstant.AAT.HEADER & 0xFF)) {
					state = 0;
					break;
				}
				int msgType = readByteWithTimeout(start, timeoutMs);
				int cpuId = readByteWithTimeout(start, timeoutMs);

				if (msgType != 0x00 || cpuId != 0x00) {
					state = 0;
					break;
				}

				rawAat.reset();
				rawAat.write(ThermostatConstant.AAT.HEADER);
				rawAat.write(msgType);
				rawAat.write(cpuId);

				// Read until real footer 0x3E (AAT_FOOTER)
				int cap = 1024;
				while (System.currentTimeMillis() - start < timeoutMs && cap-- > 0) {
					int c = readByteWithTimeout(start, timeoutMs);
					rawAat.write(c);
					if (c == (ThermostatConstant.AAT.FOOTER & 0xFF)) {
						byte[] raw = rawAat.toByteArray();

						byte[] decoded = decodeAatBytes(raw);

						if (!isValidDecodedAatFrame(decoded)) {
							aatBadResponseQueue.offer(decoded);
							state = 0;
							break;
						}

						int msgId = ((decoded[5] & 0xFF) << 8) | (decoded[6] & 0xFF);
						if (msgId != (expectedMsgId & 0xFFFF)) {
							aatBadResponseQueue.offer(decoded);
							state = 0;
							break;
						}
						return raw;
					}
				}
				state = 0;
				break;
			}
		}
		throw new Exception("AAT Response Timeout (expected MsgID=0x" + String.format("%04X", expectedMsgId) + ")");
	}

	/**
	 * Reads a single byte from serial within the overall timeout window.
	 *
	 * Used by waitForAATResponse() while capturing a frame to avoid blocking
	 * forever if the device stops responding mid-frame.
	 */
	private int readByteWithTimeout(long start, int timeoutMs) throws Exception {
		while (System.currentTimeMillis() - start < timeoutMs) {
			if (input != null && input.available() > 0) {
				int b = input.read();
				if (b >= 0)
					return b & 0xFF;
			}
			TimeUnit.MILLISECONDS.sleep(1);
		}
		throw new Exception("Timed out while reading serial byte");
	}

	/**
	 * Validates a decoded AAT frame for: - Minimum length - Header/footer
	 * correctness - MsgType/CPU_ID expected values - AncillaryCount vs expected
	 * total frame length - CRC correctness
	 *
	 * @param decoded decoded (byte-unstuffed) AAT frame bytes.
	 * @return true if frame passes all validations, false otherwise.
	 */
	private boolean isValidDecodedAatFrame(byte[] decoded) {
		if (decoded == null)
			return false;
		if (decoded.length < ThermostatConstant.AAT.AAT_MIN_FRAME_LEN)
			return false;
		if (decoded[0] != ThermostatConstant.AAT.HEADER)
			return false;
		if (decoded[decoded.length - 1] != ThermostatConstant.AAT.FOOTER)
			return false;

		if ((decoded[1] & 0xFF) != 0x00)
			return false; // MsgType
		if ((decoded[2] & 0xFF) != 0x00)
			return false; // CPU_ID

		int ancCount = ((decoded[7] & 0xFF) << 8) | (decoded[8] & 0xFF);
		if (ancCount < 0 || ancCount > ThermostatConstant.AAT.AAT_MAX_FRAME_LEN)
			return false;

		int expectedLen = ancCount + ThermostatConstant.AAT.AAT_MIN_FRAME_LEN;
		if (decoded.length != expectedLen)
			return false;

		byte crcCalc = computeCRC(Arrays.copyOfRange(decoded, 1, decoded.length - 2));
		byte crcFrame = decoded[decoded.length - 2];

		return crcCalc == crcFrame;
	}

	/**
	 * Retrieves one decoded response frame from the response queue.
	 *
	 * Behavior: - Polls the raw queue with a short timeout. - Decodes AAT
	 * byte-stuffing. - Validates CRC/length; invalid frames are pushed into
	 * aatBadResponseQueue.
	 *
	 * @return decoded AAT frame, or null if none available / frame invalid.
	 */
	public byte[] getAATResponse() throws Exception {
		byte[] raw = aatResponseQueue.poll(200, TimeUnit.MILLISECONDS);
		if (raw == null)
			return null;

		byte[] decoded = decodeAatBytes(raw);

		if (!isValidDecodedAatFrame(decoded)) {
			aatBadResponseQueue.offer(decoded);
			System.err.println("Bad AAT frame | Frame: " + toHex(decoded));
			return null;
		}

		return decoded;
	}

	/**
	 * Convenience helper to return only the ancillary data bytes from the next
	 * response.
	 *
	 * @return response data bytes (ancillary) or null if no response.
	 */
	public byte[] getAATResponseData() throws Exception {
		byte[] resp = getAATResponse();
		if (resp == null)
			return null;
		int len = ((resp[7] & 0xFF) << 8) | (resp[8] & 0xFF);
		return Arrays.copyOfRange(resp, 9, 9 + len);
	}

	/**
	 * Reads responses until one matches the expected MsgID, then returns its
	 * ancillary data.
	 *
	 * Use case: - When multiple frames can be observed on serial, this method
	 * filters until the required response for a specific query is found.
	 *
	 * @param expectedMsgId decoded MsgID to match.
	 * @param timeoutMs     maximum time to search for the matching response.
	 * @return ancillary data bytes for the matched response.
	 * @throws Exception if expected MsgID was not observed within timeout.
	 */
	public byte[] getAATResponseDataOfMsgID(int expectedMsgIdType, int expectedMsgId, int timeoutMs) throws Exception {
		long start = System.currentTimeMillis();
		while (true) {
			byte[] resp = getAATResponse();

			if (resp == null) {
				if (System.currentTimeMillis() - start >= timeoutMs) {
					throw new Exception("Response not found! expected MsgIDType=" + expectedMsgIdType + ", MsgID=0x"
							+ String.format("%04X", expectedMsgId));
				}
				continue;
			}

			int respMsgIdType = resp[4] & 0xFF;
			int respId = ((resp[5] & 0xFF) << 8) | (resp[6] & 0xFF);

			if (respMsgIdType == (expectedMsgIdType & 0xFF) && respId == (expectedMsgId & 0xFFFF)) {
				int len = ((resp[7] & 0xFF) << 8) | (resp[8] & 0xFF);
				return Arrays.copyOfRange(resp, 9, 9 + len);
			}

			// Keep non-matching frames separately
			aatBadResponseQueue.offer(resp);

			if (System.currentTimeMillis() - start >= timeoutMs) {
				throw new Exception("Response not found! expected MsgIDType=" + expectedMsgIdType + ", MsgID=0x"
						+ String.format("%04X", expectedMsgId));
			}
		}
	}

	/**
	 * Decodes AAT byte-stuffing.
	 *
	 * Replaces protocol escape sequences back to real bytes: - 31 C3 -> '<' - 31 C1
	 * -> '>' - 31 CE -> '1'
	 *
	 * @param arr RAW stuffed AAT frame bytes.
	 * @return decoded AAT bytes (still may contain MCI-escaped bytes if present in
	 *         payload).
	 */
	private byte[] decodeAatBytes(byte[] arr) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		for (int i = 0; i < arr.length; i++) {
			byte b = arr[i];
			// 31 C3 -> '<'
			if (i < arr.length - 1 && b == ThermostatConstant.AAT.STUFF_PREFIX
					&& arr[i + 1] == ThermostatConstant.AAT.HEADER_REPLACE[1]) {
				out.write(ThermostatConstant.AAT.HEADER);
				i++;
				// 31 C1 -> '>'
			} else if (i < arr.length - 1 && b == ThermostatConstant.AAT.STUFF_PREFIX
					&& arr[i + 1] == ThermostatConstant.AAT.FOOTER_REPLACE[1]) {
				out.write(ThermostatConstant.AAT.FOOTER);
				i++;
				// 31 CE -> '1'
			} else if (i < arr.length - 1 && b == ThermostatConstant.AAT.STUFF_PREFIX
					&& arr[i + 1] == ThermostatConstant.AAT.STUFF_PREFIX_REPLACE[1]) {
				out.write(ThermostatConstant.AAT.STUFF_PREFIX);
				i++;
			} else {
				out.write(b);
			}
		}
		return out.toByteArray();
	}

	/**
	 * Utility method for cases where BOTH AAT and MCI decoding is required. (Not
	 * currently used by the core request/response flow but kept for
	 * debugging/utility.)
	 */
	private byte[] decodeMciAatBytes(byte[] arr) {
		return decodeMciBytes(decodeAatBytes(arr));
	}

	/**
	 * Decodes MCI byte-stuffing inside a byte array.
	 *
	 * Replaces: - %^ -> '[' - %* -> '%'
	 */
	private byte[] decodeMciBytes(byte[] arr) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		for (int i = 0; i < arr.length; i++) {
			byte b = arr[i];
			// %^ -> '['
			if (i < arr.length - 1 && b == ThermostatConstant.MCI.STUFF_PREFIX
					&& arr[i + 1] == ThermostatConstant.MCI.HEADER_REPLACE[1]) {
				out.write(ThermostatConstant.MCI.HEADER);
				i++;
				// %* -> '%'
			} else if (i < arr.length - 1 && b == ThermostatConstant.MCI.STUFF_PREFIX
					&& arr[i + 1] == ThermostatConstant.MCI.STUFF_PREFIX_REPLACE[1]) {
				out.write(ThermostatConstant.MCI.STUFF_PREFIX);
				i++;
			} else {
				out.write(b);
			}
		}
		return out.toByteArray();
	}

	/**
	 * Applies AAT byte-stuffing so that reserved bytes do not appear raw in the
	 * stream. This ensures header/footer markers are unambiguous when device scans
	 * the serial stream.
	 */
	private byte[] applyAATByteStuff(byte[] arr) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		for (byte b : arr) {
			if (b == ThermostatConstant.AAT.HEADER)
				out.write(ThermostatConstant.AAT.HEADER_REPLACE);
			else if (b == ThermostatConstant.AAT.FOOTER)
				out.write(ThermostatConstant.AAT.FOOTER_REPLACE);
			else if (b == ThermostatConstant.AAT.STUFF_PREFIX)
				out.write(ThermostatConstant.AAT.STUFF_PREFIX_REPLACE);
			else
				out.write(b);
		}
		return out.toByteArray();
	}

	/**
	 * Applies MCI byte-stuffing so that reserved MCI bytes do not break framing.
	 * Called after AAT stuffing, before wrapping with MCI header and subprotocol
	 * byte.
	 */
	private byte[] applyMCIByteStuff(byte[] arr) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();

		for (byte b : arr) {
			if (b == ThermostatConstant.MCI.HEADER)
				out.write(ThermostatConstant.MCI.HEADER_REPLACE);
			else if (b == ThermostatConstant.MCI.STUFF_PREFIX)
				out.write(ThermostatConstant.MCI.STUFF_PREFIX_REPLACE);
			else
				out.write(b);
		}
		return out.toByteArray();
	}

	/**
	 * Computes the CRC byte using the protocol's nibble-table algorithm.
	 *
	 * @param arr bytes over which CRC is computed (protocol-specific range).
	 * @return CRC byte.
	 */
	private byte computeCRC(byte[] arr) {
		int crc = 0xFF;
		for (byte b : arr) {
			int tmp = (b ^ crc) & 0xFF;
			crc = R1[tmp & 0x0F] ^ R2[(tmp >> 4) & 0x0F];
		}
		return (byte) crc;
	}

	/**
	 * Utility: converts bytes into hex string for logging. Helpful during protocol
	 * debugging.
	 */
	public String toHex(byte[] a) {
		StringBuilder sb = new StringBuilder();
		for (byte b : a)
			sb.append(String.format("%02X ", b));
		return sb.toString();
	}
	
	/**
	 * Reads directly from serial stream and returns the raw AAT frame when MsgID and MsgIdType matches.
	 */
	public byte[] waitForAATMsgId(int expectedMsgId, int expectedMsgIdType, int timeoutMs) throws Exception {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < timeoutMs) {

			int remaining = (int) (timeoutMs - (System.currentTimeMillis() - start));
			if (remaining <= 0)
				break;

			byte[] raw = waitForAATResponse(remaining, expectedMsgId); // reuse your existing method
			if (raw == null)
				continue;

			byte[] decoded = decodeAatBytes(raw);
			if (!isValidDecodedAatFrame(decoded)) {
				aatBadResponseQueue.offer(decoded);
				continue;
			}

			int msgIdType = decoded[ThermostatConstant.AAT.MSG_ID_TYPE_IDX] & 0xFF;
			if (msgIdType == (expectedMsgIdType & 0xFF)) {
				return raw;
			}
			aatBadResponseQueue.offer(decoded);
		}

		throw new Exception("Response not found! expected MsgIDType=" + expectedMsgIdType + ", MsgID=0x"
				+ String.format("%04X", expectedMsgId));
	}
}