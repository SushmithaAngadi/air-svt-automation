package com.resideo.utils.stat.mqtt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import com.fazecast.jSerialComm.SerialPort;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;

public class MqttSerialController {

	private static SerialPort activePort;

	public static boolean connectToMqttPort() {

		boolean isConnected = false;
		String response = null;

		// Serial port parameters
		int baudRate = 115200;
		int dataBits = 8;
		int stopBits = SerialPort.ONE_STOP_BIT;
		int parity = SerialPort.NO_PARITY;
		InputStream inputStream = null;
		OutputStream outputStream = null;

		// Timeouts
		int readTimeout = 2000; // 2 seconds
		int writeTimeout = 2000; // 2 seconds

		try {
			SerialPort[] serialPorts = SerialPort.getCommPorts();
			if (serialPorts.length == 0) {
				System.out.println("No serial ports found.");
				return false;
			}

			for (SerialPort port : serialPorts) {
				if (port.getPortDescription().toUpperCase().contains("FT4232H-56Q MINIMODULE B") || port.getPortDescription().toUpperCase().contains("USB-SERIAL CONTROLLER D")) {
				activePort = port;
				System.out.print("Attempting to connect : " + port.getSystemPortName() + ",");
				port.setComPortParameters(baudRate, dataBits, stopBits, parity);
				port.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING | SerialPort.TIMEOUT_WRITE_BLOCKING,
						readTimeout, writeTimeout);
				outputStream = port.getOutputStream();
				inputStream = port.getInputStream();

				if (!port.openPort()) {
					System.out.print("Failed to open the port: " + port.getSystemPortName() + "\n");
					continue;
				}else {
					System.out.println("Connected To: " + port.getSystemPortName());
				}
				// sending username
				return sendUsernameAndPassword();
			}
			}
		} catch (Exception ex) {
			activePort = null;
			System.out.println("An error occurred: " + ex.getMessage());
		}
		return isConnected;
	}

	public static InputStream getInputStram() {
		if (activePort != null && activePort.isOpen()) {
			return activePort.getInputStream();
		} else {
			System.out.println("Cannot send InputStream. No active port or the port is closed.");
			return null;
		}
	}

	// Method to check if a remembered port is open
	public static boolean isActivePortOpen() {
		if (activePort != null && activePort.isOpen()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean sendCommandToPort(String command) {
		int maxRetries = 2;
		int attempt = 0;
		while (attempt <= maxRetries) {
			try {
				if (isActivePortOpen()) {
					activePort.getOutputStream().write((command + "\n").getBytes());
					activePort.getOutputStream().flush();
					return true;
				} else {
					System.out.println("Port is not active. Attempting to reconnect...");
					closeActivePort();
					connectToMqttPort();
				}
			} catch (Exception e) {
				System.out.println("\nFailed to send command (Attempt " + (attempt + 1) + "): " + e.getMessage());
				connectToMqttPort();
			}
			attempt++;
		}
		System.out.println("Failed to send command after " + maxRetries + " retries.");

		return false;
	}

	public static void closeActivePort() {
		if (activePort != null && activePort.isOpen()) {
			activePort.closePort();
			System.out.println("Closed port: " + activePort.getSystemPortName());
		} else {
			System.out.println("No active port to close.");
		}
		activePort = null;
	}

	public static String readSerialResponse(InputStream inputStream) {
		String escapeSeqPattern = "\\x1b\\[[0-9;]*[mHfK]";
		try {
			if (inputStream.available() > 0) {
				byte[] buffer = new byte[inputStream.available()];
				inputStream.read(buffer);

				String response = new String(buffer, "UTF-8");
				// Use regular expressions to remove escape sequences
				response = response.replaceAll("\\p{Cntrl}", "");
				return response.replaceAll(escapeSeqPattern, "");

			}
		} catch (IOException e) {
			System.out.println("Error reading serial port: " + e.getMessage());
		}
		return null;
	}

	public static String getDeviceInformation(String requiredParameter) {
		String requiredInfo = null;

		if (isActivePortOpen()) {
			try {
				do {
					if (sendCommandToPort("sysinfo")) {
						TimeUnit.SECONDS.sleep(4);
						InputStream inputStream = activePort.getInputStream();
						String response = waitForSerialResponse(inputStream, 8000);
						if (response != null) {
							response = response.toUpperCase();
							if (response.contains("CORRUPT HISTORY FILE")) {
								continue;
							}
							if (requiredParameter.contains("MACID") || requiredParameter.contains("MAC_ID")) {
								try {
									requiredInfo = response.split("PANEL MAC:")[1].trim().split(" ")[0].trim()
											.subSequence(0, 12).toString();
								} catch (ArrayIndexOutOfBoundsException ex) {
									System.out.println("Panel MAC not found in the response.");
								}
							} else if (requiredParameter.contains("FWVERSION")
									|| requiredParameter.contains("VERSION ID")) {
								try {
									requiredInfo = response.split("VERSION ID:")[1].trim().split(" ")[0].trim()
											.subSequence(0, 9).toString();
								} catch (ArrayIndexOutOfBoundsException ex) {
									System.out.println("Fw Version not found in the response.");
								}
							}
						} else {
							System.out.println("No response received from the port.");
						}
					}
				} while (requiredInfo == null);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		return requiredInfo;
	}

	public static String waitForSerialResponse(InputStream inputStream, int timeoutMs) throws IOException {
		int elapsed = 0;
		int waitInterval = 100;
		StringBuilder response = new StringBuilder();

		String escapeSeqPattern = "\\x1b\\[[0-9;]*[mHfK]";
		while (elapsed < timeoutMs) {
			if (inputStream.available() > 0) {
				byte[] buffer = new byte[inputStream.available()];
				inputStream.read(buffer);

				// Convert and clean the data
				String partialResponse = new String(buffer, "UTF-8").replaceAll("\\p{Cntrl}", "")
						.replaceAll(escapeSeqPattern, "");
				response.append(partialResponse);

				if (response.toString().contains("@GRIP")) {
				}
			}
			try {
				Thread.sleep(waitInterval); // Short wait between polls
				elapsed += waitInterval;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new IOException("Waiting for response interrupted.", e);
			}
		}

		return response.length() > 0 ? response.toString() : null;
	}
	
	public static String waitForSerialResponse(InputStream inputStream, int timeoutMs,String reqOutput) throws IOException {
		int elapsed = 0;
		int waitInterval = 100;
		StringBuilder response = new StringBuilder();

		String escapeSeqPattern = "\\x1b\\[[0-9;]*[mHfK]";
		while (elapsed < timeoutMs) {
			if (inputStream.available() > 0) {
				byte[] buffer = new byte[inputStream.available()];
				inputStream.read(buffer);

				// Convert and clean the data
				String partialResponse = new String(buffer, "UTF-8").replaceAll("\\p{Cntrl}", "")
						.replaceAll(escapeSeqPattern, "");
				response.append(partialResponse);
//				System.out.println(response);
				if (response.toString().toUpperCase().contains(reqOutput.toUpperCase())) {
					break;
				}
			}
			try {
				Thread.sleep(waitInterval); // Short wait between polls
				elapsed += waitInterval;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new IOException("Waiting for response interrupted.", e);
			}
		}

		return response.length() > 0 ? response.toString() : null;
	}

	public static boolean sendUsernameAndPassword() {
		if (isActivePortOpen()) {
			try {
				InputStream inputStream = activePort.getInputStream();
				if (sendCommandToPort("root")) {
					String response;
					response = waitForSerialResponse(inputStream, 2000).toUpperCase();
 
					if (response.contains("ROOT@")) {
						return true;
					} else if (response.contains("PASSWORD")) {
						if (sendCommandToPort("root")) {
							response = waitForSerialResponse(inputStream, 7000);
							System.out.println();
							System.out.println("sendUsernameAndPassword, response is :" + response);
							if (response.toUpperCase().contains("JUMBO ROOTFS ENABLED")
									|| response.toUpperCase().contains("QUEUED START JOB")) {
								try {
									TimeUnit.SECONDS.sleep(4);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
								for (int attempt = 0; attempt < 3; attempt++) {
									if (sendCommandToPort(" cd /honeywell/runtime")) {
										sendCommandToPort(" cd /honeywell/runtime");
										sendCommandToPort("pwd");
										String pwdResponse = waitForSerialResponse(inputStream, 5000);
										System.out.println("pwd response: " + pwdResponse);
										if (pwdResponse.contains("/honeywell/runtime")) {
											String command = "if ! pgrep -f \"MqttSubscribeManager.sh\" > /dev/null; then\n"
													+ "    ./MqttSubscribeManager.sh &\n" + "fi";
											sendCommandToPort(command);
											sendCommandToPort("systemctl stop gui-process");
											sendCommandToPort("systemctl stop gui-process");
											do {
												response = waitForSerialResponse(inputStream, 8000);
											} while (response.contains("CORRUPT HISTORY FILE"));
											return true;
										}
									}
								}
							}
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static String getAuthCode() {
		boolean flag = false;
		String pin = null;
		InputStream inputStream = activePort.getInputStream();
		int count = 0;
		String infoFromMsg = null;
		if (isActivePortOpen()) {
			try {
				do {
					count++;
					flag = false;
					infoFromMsg = waitForSerialResponse(inputStream, 10000);
					if (infoFromMsg.contains("@/BLEManager/AuthCode")) {
						if (infoFromMsg != null && !infoFromMsg.isEmpty()) {
							pin = infoFromMsg.split("@/BLEManager/AuthCode")[1].trim().split("\n")[0].split("\"")[1];
							flag = true;
						}

					} else {
						System.out.println(
								"Didnt get a response on Topic @/BLEManager/AuthCode,Retrying count :" + count);
					}
				} while (flag == false && count < 5);
			} catch (Exception e) {
				System.out.println("Exception:" + e.getMessage());
			}
		} else {
			System.out.println("Device Port is closed");
		}
		return pin;
	}
	
	public static void sendLogs() {
		try {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
			String formattedDateTime = now.format(formatter);
			sendCommandToPort(
					"sendlogs " + SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID") + "_"
							+ formattedDateTime.replaceAll(" ", "_"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}