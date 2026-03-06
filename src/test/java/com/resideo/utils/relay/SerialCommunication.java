package com.resideo.utils.relay;

import java.io.PrintWriter;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class SerialCommunication extends WireSensingRelayConstant {
//	public static SerialPort port = null;

	public boolean intialSerialCommunication() {
		boolean flag = true;
		SerialPort[] ports = SerialPort.getCommPorts();

		for (int i = 0; i < ports.length; i++) {
			boolean isPortCanOpen = false;

			System.out.println(ports[i].toString());

			System.out.println(System.getProperty("os.name"));
			if (System.getProperty("os.name").toLowerCase().contains("mac")) {
				if (ports[i].getDescriptivePortName().contains("USB")) {
					isPortCanOpen = true;
				}
			} else {
				System.out.println("PortName id :: " + ports[i].toString().contains("USB"));
				if (ports[i].toString().contains("USB")) {
					isPortCanOpen = true;
				}
			}
			if (isPortCanOpen == true && ports[i].openPort()) {
				delay(4000);
				System.out.println("Port opened successfully.");
				String sendData = sendData(ports[i], "ArduinoUNO");
				if (sendData != null) {
					if (sendData.contains("true")) {
						port = ports[i];
						System.out.println(sendData);
						flag = true;
						String config = sendData(ports[i], "PinCount");
						System.out.println(config);
						String pinstart_end = sendData(ports[i], "PinStart_and_End");
						System.out.println(pinstart_end);
//						break;
					}
				} else {
					ports[i].closePort();
					System.out.println("Port Closed");
					flag = false;
				}
			}
		}
		return flag;
	}

	public static void pinEnable() {
//		System.out.println("");
		sendDataAfterDATA(port, "Relay_2:ON");
		sendDataAfterDATA(port, "Relay_2:OFF");
	}
	
	public static void main(String[] args) throws InterruptedException {
		SerialCommunication sc = new SerialCommunication();
		sc.intialSerialCommunication();
//		sc.directSirelPort();
//		sendDataAfterDATA(port, "0");
//		sendDataAfterDATA(port, "1");
//		sendDataAfterDATA(port, "4");
//		Thread.sleep(700);
//		sendDataAfterDATA(port, "4");
		pinEnable();
//		sendDataAfterDATA(port, "Relay-1_ON");
////		Thread.sleep(16000);
//		Thread.sleep(300);
//		sendDataAfterDATA(port, "Relay-1_OFF");
//		Thread.sleep(3000);
//		sendDataAfterDATA(port, "Relay-2_ON");
////		Thread.sleep(16000);
//		Thread.sleep(300);
//		sendDataAfterDATA(port, "Relay-2_OFF");
//		Thread.sleep(3000);
//		sendDataAfterDATA(port, "Relay-2_ON");
//		Thread.sleep(24000);
////		Thread.sleep(500);
//		sendDataAfterDATA(port, "Relay-2_OFF");
//		Thread.sleep(3000);
//		sendDataAfterDATA(port, "Relay-1_ON");
//		sendDataAfterDATA(port, "AllRelayON");
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
		sendDataAfterDATA(port, "Relay_2:ON");
		Thread.sleep(1500);
		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:OFF");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
//		sendDataAfterDATA(port, "Relay_2:ON");
//		Thread.sleep(1500);
//		Thread.sleep(4000);
//		sendDataAfterDATA(port, "ResetAll");
//		sendDataAfterDATA(port, "Relay_22:ON");
//		sendDataAfterDATA(port, "Relay_22:OFF");
//		sendDataAfterDATA(port, "Relay_23:ON");
//		sendDataAfterDATA(port, "Relay_23:OFF");
//		sendDataAfterDATA(port, "Relay_24:ON");
//		sendDataAfterDATA(port, "Relay_24:OFF");
//		sendDataAfterDATA(port, "Relay_25:ON");
//		sendDataAfterDATA(port, "Relay_25:OFF");
//		sendDataAfterDATA(port, "Relay_26:ON");
//		sendDataAfterDATA(port, "Relay_26:OFF");
//		sendDataAfterDATA(port, "Relay_27:ON");
//		sendDataAfterDATA(port, "Relay_27:OFF");
//		sendDataAfterDATA(port, "Relay_28:ON");
//		sendDataAfterDATA(port, "Relay_28:OFF");
//		sendDataAfterDATA(port, "Relay_29:ON");
//		sendDataAfterDATA(port, "Relay_29:OFF");
//		sendDataAfterDATA(port, "Relay_30:ON");
//		sendDataAfterDATA(port, "Relay_30:OFF");
//		sendDataAfterDATA(port, "Relay_31:ON");
//		sendDataAfterDATA(port, "Relay_31:OFF");
//		sendDataAfterDATA(port, "Relay_32:ON");
//		sendDataAfterDATA(port, "Relay_32:OFF");
//		sendDataAfterDATA(port, "Relay_33:ON");
//		sendDataAfterDATA(port, "Relay_33:OFF");
//		sendDataAfterDATA(port, "Relay_34:ON");
//		sendDataAfterDATA(port, "Relay_34:OFF");
//		sendDataAfterDATA(port, "Relay_35:ON");
//		sendDataAfterDATA(port, "Relay_35:OFF");
//		sendDataAfterDATA(port, "Relay_36:ON");
//		sendDataAfterDATA(port, "Relay_36:OFF");
//		sendDataAfterDATA(port, "22");
//		sendDataAfterDATA(port, "23");
//		sendDataAfterDATA(port, "24");
//		sendDataAfterDATA(port, "25");
//		sendDataAfterDATA(port, "26");
//		sendDataAfterDATA(port, "27");
//		sendDataAfterDATA(port, "28");
//		sendDataAfterDATA(port, "29");
//		sendDataAfterDATA(port, "30");
//		sendDataAfterDATA(port, "31");
//		sendDataAfterDATA(port, "32");
//		sendDataAfterDATA(port, "33");
//		sendDataAfterDATA(port, "34");
//		sendDataAfterDATA(port, "35");
//		sendDataAfterDATA(port, "36");
//		sendDataAfterDATA(port, "22");
//		sendDataAfterDATA(port, "23");
//		sendDataAfterDATA(port, "24");
//		sendDataAfterDATA(port, "25");
//		sendDataAfterDATA(port, "26");
//		sendDataAfterDATA(port, "27");
//		sendDataAfterDATA(port, "28");
//		sendDataAfterDATA(port, "29");
//		sendDataAfterDATA(port, "30");
//		sendDataAfterDATA(port, "31");
//		sendDataAfterDATA(port, "32");
//		sendDataAfterDATA(port, "33");
//		sendDataAfterDATA(port, "34");
//		sendDataAfterDATA(port, "35");
//		sendDataAfterDATA(port, "36");

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

	public static String sendDataAfterDATA(SerialPort port, String writeData1) {
		PrintWriter write1 = new PrintWriter(port.getOutputStream());
		write1.print(writeData1);
		write1.flush();
		write1.close();
		delay(1200);
		String data = recieveData(port);
		System.out.println(data);
		return data;
	}

	public static void SendDataParse(SerialPort port, String writeData1) {
		PrintWriter write1 = new PrintWriter(port.getOutputStream());
		write1.print(writeData1);
		write1.flush();
		write1.close();
	}

	public static void delay(long x) {
		try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String recieveData(SerialPort port) {
		String dataRead = null;
		@SuppressWarnings("resource")
		Scanner data = new Scanner(port.getInputStream());
		// while(usePort.bytesAvailable()<=0);
		while (data.hasNextLine()) {
			// System.out.println(data.nextLine());
			dataRead = data.nextLine();
		}
		return dataRead;
	}

}
