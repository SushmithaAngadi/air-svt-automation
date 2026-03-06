package com.resideo.utils.relay;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortEvent;
import com.google.protobuf.BytesValue;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;

@SuppressWarnings("resource")
public class RelayConfiguration {

	private static SerialPort currentPort;
	private static int pinStart;
	private static int pinEnd;
	private static int totalconfiguredPin;

	public static void setSerialPort(SerialPort port) {
		currentPort = port;

	}

	public static SerialPort getSerialPort() {
		if (currentPort == null) {
			initializeSerialCommunication(15);
			if (currentPort != null) {
				return currentPort;
			} else {
				initializeSerialCommunication(15);
				return currentPort;
			}
		} else {
			return currentPort;
		}
	}

	public static void setPinStart(int startpin) {
		pinStart = startpin;

	}

	public static int getPinStart() {
		return pinStart;
	}

	public static void setPinend(int endPin) {
		pinEnd = endPin;

	}

	public static int getPinEnd() {
		return pinEnd;
	}

	public static void setTotalPinConfigured(int totalpin) {
		totalconfiguredPin = totalpin;

	}

	public static int getTotalPinConfigured() {
		return totalconfiguredPin;
	}

	public static boolean initializeSerialCommunication(int requirepinCount) {
		boolean flag = false;
		boolean isPortCanOpen = false;

		int BaudRate = 9600;
		int DataBits = 8;
		int StopBits = SerialPort.ONE_STOP_BIT;
		int Parity = SerialPort.NO_PARITY;

		SerialPort[] ports = SerialPort.getCommPorts();
		for (SerialPort serialPort : ports) {
			System.out.println(serialPort.getDescriptivePortName());
			if (serialPort.toString().contains("USB") || serialPort.toString().contains("Arduino")) {
				isPortCanOpen = true;
			}
			if (isPortCanOpen && serialPort.openPort()) {
				serialPort.setComPortParameters(BaudRate, DataBits, StopBits, Parity);
				delay(4000);
				// Set Read Time outs
				serialPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_BLOCKING, 1000, 0);
				boolean sendData = isArduino(serialPort, "ArduinoUNO", "true");
				if (sendData) {
					currentPort = serialPort;
					flag = true;
					break;
				} else {
					serialPort.closePort();
					System.out.println("Port Closed");
					flag = false;
				}
			}
		}
		return flag;
	}

	public static SerialPort getSerialPorts() {
		SerialPort serialPorter=null;
		boolean isPortCanOpen = false;
		int BaudRate = 115200;
		int DataBits = 8;
		int StopBits = SerialPort.ONE_STOP_BIT;
		int Parity = SerialPort.NO_PARITY;

		SerialPort[] ports = SerialPort.getCommPorts();
		for (SerialPort serialPort : ports) {
			System.out.println(serialPort.getDescriptivePortName());
			if (serialPort.toString().contains("USB") || serialPort.toString().contains("Arduino")) {
				isPortCanOpen = true;
			}
			if (isPortCanOpen && serialPort.openPort()) {
				serialPort.setComPortParameters(BaudRate, DataBits, StopBits, Parity);
				serialPorter.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
				serialPorter = serialPort;
			}
		}
		return serialPorter;
	}
	
	
	public static void delay(long x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static boolean isArduino(SerialPort port, String writeData, String responseMessage) {

		PrintWriter write1 = new PrintWriter(port.getOutputStream());
		write1.print(writeData);
		write1.flush();
		write1.close();
		return dataReceived(port, responseMessage);
	}

	public static String sendData(SerialPort port, String writeData1) {

		PrintWriter write1 = new PrintWriter(port.getOutputStream());
		write1.print(writeData1);
		write1.flush();
		write1.close();
		delay(4000);
		String data = recieveData(port);
		System.out.println(data);
		return data;
	}

	public static String sendData(SerialPort port, String writeData1, int timeout) {

		PrintWriter write1 = new PrintWriter(port.getOutputStream());
		write1.print(writeData1);
		write1.flush();
		write1.close();
		delay(timeout);
//		dataReceived(port, writeData1);
		return null;
	}

	public static String recieveData(SerialPort port) {
		String dataRead = null;
		Scanner data = new Scanner(port.getInputStream());
		// while(usePort.bytesAvailable()<=0);
		while (data.hasNextLine()) {
			// System.out.println(data.nextLine());
			dataRead = data.nextLine();
		}
		return dataRead;
	}

	public static boolean dataReceived(SerialPort port, String data) {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofMillis(500));
			fWait.withTimeout(Duration.ofSeconds(5));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						String receiveData = recieveData(port);
						if (receiveData == null || receiveData.isEmpty()) {
							return false;
						} else {
							if (receiveData.toUpperCase().contains(data.toUpperCase())) {
								System.out.println("Action confirmed for "+receiveData);
								return true;
							} else {
								System.out.println(receiveData);
								return false;
							}
						}
					} catch (Exception e) {
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static synchronized void serialEvent(SerialPort port, SerialPortEvent oEvent) {
		if (oEvent.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
			return;
		byte[] newData = new byte[port.bytesAvailable()];
		int numRead = port.readBytes(newData, newData.length);
		System.out.println("Read " + numRead + " bytes.");
	}

	
	public static synchronized void serialEvent(SerialPort port) {
		byte[] newData = new byte[port.bytesAvailable()];
		int numRead = port.readBytes(newData, newData.length);
		System.out.println("Read " + numRead + " bytes.");
		String string = new String(newData);
        System.out.println(string);
	}
	
	public static void getPinDetails(String pinconf) {
		String[] split = pinconf.split(",");
		String[] startpinext = split[0].split("=");
		String[] endpinext = split[1].split("=");
		setPinStart(Integer.valueOf(startpinext[1]));
		setPinend(Integer.valueOf(endpinext[1]));
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		initializeSerialCommunication(25);
//		sendData(getSerialPort(), "Relay_4:ON", 1000);
//		sendData(getSerialPort(), "Relay_4:OFF",1000);
//		Thread.sleep(5000);
//		EIM_Sensor_CommandControl(null, "EIM", "PAIRING");
//		EIM_Sensor_CommandControl(null, "OAS", "PAIRING");
//		EIM_Sensor_CommandControl(null, "IAS", "PAIRING");
	
		
		
//		SerialPort serialPorts = getSerialPorts();
//		serialPorts.getOutputStream().write(1.BytesValue());
		
//		for (Integer i = 0; i < 2; ++i) {			
//			serialPorts.getOutputStream().write(i.byteValue());
//			serialPorts.getOutputStream().flush();
//			Thread.sleep(1000);
//			serialEvent(serialPorts);
//		      System.out.println("Sent number: " + i);
//		    }		
		
//		writeBytes(bytes, bytes.length);
//		for (int i = 0; i < 100; i++) {
//			
//		}
		for (int i = 0; i < 10; i++) {
			sendData(getSerialPort(), "AllRelayON", 2000);
			Thread.sleep(500);
			sendData(getSerialPort(), "AllRelayOff", 1500);
		}
		
//		Thread.sleep(700);
//		sendData(getSerialPort(), "Relay_3:ON", 1500);
////		sendData(getSerialPort(), "Relay_3:OFF");
//		sendData(getSerialPort(), "Relay_4:ON", 1500);
////		sendData(getSerialPort(), "Relay_4:OFF");
//		sendData(getSerialPort(), "Relay_5:ON", 1500);
////		sendData(getSerialPort(), "Relay_5:OFF");
//		sendData(getSerialPort(), "Relay_2:ON", 1500);
////		sendData(getSerialPort(), "Relay_6:OFF");
//		sendData(getSerialPort(), "ResetAll", 1500);
//		currentPort.closePort();

	}

	public static boolean setBleMode_confirmBLEinCaspian(TestCases testCase, int timeout) {
		try {
			String sendData = sendData(getSerialPort(), "Relay_3:ON", 2000);
			if (sendData.contains("PIN :3 ON")) {
				Keyword.ReportStep_Pass(testCase, "Successfully Relay Turned On");
				Thread.sleep(timeout * 1000);
				String sendData2 = sendData(getSerialPort(), "Relay_3:OFF");
				if (sendData2.contains("PIN :3 OFF")) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully Relay Turned OFF After BLE Mode Turned On, pressing time in Seconds :"
									+ timeout);
					return true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"After BLE mode turned On, Not able to turn oFF");
					currentPort.closePort();
					return false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"After BLE mode turned On, Not able to turn oFF");
				currentPort.closePort();
				return false;
			}

		} catch (InterruptedException e) {
			currentPort.closePort();
			e.printStackTrace();
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured during arduino interaction , Exception is " + e);
			return false;
		}

	}

	public static boolean resetCaspianDevice(TestCases testCase, int timeout) {
		try {
			String sendData = sendData(getSerialPort(), "Relay_3:ON", 2000);
			if (sendData.contains("PIN :3 ON")) {
				Keyword.ReportStep_Pass(testCase, "Successfully Relay Turned On");
				Thread.sleep(timeout * 1000);
				String sendData2 = sendData(getSerialPort(), "Relay_3:OFF");
				if (sendData2.contains("PIN :3 OFF")) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully Relay Turned OFF, Button press time is Seconds :" + timeout);
					return true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"After BLE mode turned On, Not able to turn oFF");
					currentPort.closePort();
					return false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"After BLE mode turned On, Not able to turn oFF");
				currentPort.closePort();
				return false;
			}

		} catch (InterruptedException e) {
			currentPort.closePort();
			e.printStackTrace();
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured during arduino interaction , Exception is " + e);
			return false;
		}

	}

	public static boolean CaspianCommandControl(TestCases testCase, String action) {
		int timeout = 0;
		int newCommandTimeOut = 0;
		try {
			if (action.contains("CONNECT")) {
				timeout = 700;
				newCommandTimeOut = 1400;
			} else if (action.contains("PAIRING")) {
				timeout = 4000;
				newCommandTimeOut = 1700;
			} else if (action.contains("HARD_RESET")) {
				timeout = 17000;
				newCommandTimeOut = 1700;
			}

			String sendData = sendData(getSerialPort(), "Relay_3:ON", newCommandTimeOut);
			if (sendData.contains("PIN :3 ON")) {
				Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
				Thread.sleep(timeout);
				String sendData2 = sendData(getSerialPort(), "Relay_3:OFF");
				if (sendData2.contains("PIN :3 OFF")) {
					Keyword.ReportStep_Pass(testCase, "Successfully Command sent to device for physical Button Action");
					return true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"After BLE mode turned On, Not able to turn oFF");
					currentPort.closePort();
					return false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"After BLE mode turned On, Not able to turn oFF");
				currentPort.closePort();
				return false;
			}

		} catch (InterruptedException e) {
			currentPort.closePort();
			e.printStackTrace();
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured during arduino interaction , Exception is " + e.getStackTrace());
			return false;
		}

	}

	public static boolean resetAllSensor() {
		boolean flag = false;

		sendData(getSerialPort(), "Relay_2:ON", 2000);
		sendData(getSerialPort(), "Relay_3:ON", 2000);
		sendData(getSerialPort(), "Relay_4:ON", 2000);
		sendData(getSerialPort(), "Relay_5:ON", 2000);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendData(getSerialPort(), "ResetAll", 1500);

		return flag;
	}

	/*
	 * public static boolean EIM_Sensor_CommandControl(TestCases testCase, String
	 * eqipmentName, String action) { int timeout = 0; int newCommandTimeOut = 0;
	 * try { if (action.contains("CONNECT")) { timeout = 700; newCommandTimeOut =
	 * 1400; } else if (action.contains("PAIRING")) { timeout = 300;
	 * newCommandTimeOut = 700; } else if (action.contains("HARD_RESET")) { timeout
	 * = 25000; newCommandTimeOut = 1700; }
	 * 
	 * if (eqipmentName.contains("EIM")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_2:ON", 700); if (sendData
	 * == null || sendData.contains("PIN :2 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(300); String sendData2 = sendData(getSerialPort(),
	 * "Relay_2:OFF"); if (sendData == null || sendData2.contains("PIN :2 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("OAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_3:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :3 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_3:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :3 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("0IAS") || eqipmentName.equals("IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_4:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :4 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_4:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :4 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("1IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_5:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :5 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_5:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :5 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("2IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_6:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :6 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_6:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :6 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("3IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_7:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :7 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_7:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :7 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("4IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_8:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :8 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_8:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :8 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("5IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_9:ON", newCommandTimeOut);
	 * if (sendData == null || sendData.contains("PIN :9 ON")) {
	 * Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for "
	 * + action); Thread.sleep(timeout); String sendData2 =
	 * sendData(getSerialPort(), "Relay_9:OFF"); if (sendData == null ||
	 * sendData2.contains("PIN :9 OFF")) { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("6IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_10:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :10 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_10:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :10 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("7IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_11:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :11 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_11:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :11 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("8IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_12:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :12 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_12:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :12 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("9IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_13:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :13 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_13:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :13 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("10IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_14:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :14 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_14:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :14 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("11IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_15:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :15 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_15:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :15 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else if
	 * (eqipmentName.contains("12IAS")) {
	 * 
	 * String sendData = sendData(getSerialPort(), "Relay_16:ON",
	 * newCommandTimeOut); if (sendData == null || sendData.contains("PIN :16 ON"))
	 * { Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command Sent to Device for " + action); Thread.sleep(timeout);
	 * String sendData2 = sendData(getSerialPort(), "Relay_16:OFF"); if (sendData ==
	 * null || sendData2.contains("PIN :16 OFF")) {
	 * Keyword.ReportStep_Pass(testCase,
	 * "Successfully Command sent to device for physical Button Action"); return
	 * true; } else { Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "After pairing mode turned On, Not able to turn oFF");
	 * currentPort.closePort(); return false; } } else {
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION, "Invalid Command and equipment name");
	 * currentPort.closePort(); return false; } } catch (InterruptedException e) {
	 * currentPort.closePort(); e.printStackTrace();
	 * Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
	 * FailType.FRAMEWORK_CONFIGURATION,
	 * "Exception Occured during arduino interaction , Exception is " +
	 * e.getStackTrace()); return false; }
	 * 
	 * }
	 */
	public static boolean RelayCommand() {
		try {
			String sendData = sendData(getSerialPort(), "Relay_3:ON", 1600);
			if (sendData.contains("PIN :3 ON")) {
				System.out.println("Relay ON");
//                Thread.sleep(100);
				String sendData2 = sendData(getSerialPort(), "Relay_3:OFF");
				if (sendData2.contains("PIN :3 OFF")) {
					System.out.println("Relay OFF");
					return true;
				} else {
					System.out.println("Relay not able to OFF");
					currentPort.closePort();
					return false;
				}
			} else {
				System.out.println("Not able to turn ON Relay");
				currentPort.closePort();
				return false;
			}
		} catch (Exception e) {
			currentPort.closePort();
			e.printStackTrace();
			System.out.println("Exception Occured due to " + e.getMessage());
			return false;
		}
	}

	public static boolean RelayCommand(int timeout) {
		try {
			System.out.println("Before Power OFF" + new Date());
			String sendData = sendData(getSerialPort(), "Relay_3:ON", 1600);
			if (sendData.contains("PIN :3 ON")) {
				System.out.println("Relay ON");
				Thread.sleep(timeout);
				String sendData2 = sendData(getSerialPort(), "Relay_3:OFF");
				if (sendData2.contains("PIN :3 OFF")) {
					System.out.println("Relay OFF");
					System.out.println("After Power ON" + new Date());
					return true;
				} else {
					System.out.println("Relay not able to OFF");
					currentPort.closePort();
					System.out.println(new Date());
					return false;
				}
			} else {
				System.out.println("Not able to turn ON Relay");
				currentPort.closePort();
				System.out.println(new Date());
				return false;
			}
		} catch (Exception e) {
			currentPort.closePort();
			e.printStackTrace();
			System.out.println("Exception Occured due to " + e.getMessage());
			System.out.println(new Date());
			return false;
		}

	}

}