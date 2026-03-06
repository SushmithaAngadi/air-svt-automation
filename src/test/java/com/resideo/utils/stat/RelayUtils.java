package com.resideo.utils.stat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.usb.UsbConst;
import javax.usb.UsbDevice;
import javax.usb.UsbEndpoint;
import javax.usb.UsbException;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbServices;

import jssc.SerialPort;
import jssc.SerialPortException;

public class RelayUtils {
	public static SerialPort port;

	public void PacketDataRelaySettings(String PortNumber) {
		if (PortNumber.length() > 0) {
			port = new SerialPort(PortNumber);
			try {
				if (port.openPort() == true) {
					System.out.println("Com Port " + PortNumber
							+ " opened successfully... System Try to connect with Master Serial Port");
				} else {
					System.exit(0);
				}
				port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
				port.writeString("\r");
				port.writeString("ver\r");
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
				port.writeString("\r");
				port.writeString("id set 00000005\r");
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
				port.writeString("\r");
				port.writeString("id get\r");
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
				port.writeString("\r");
				port.writeString("gpio set 1\r");
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
				port.writeString("\r");
				port.writeString("gpio clear 0\r");
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
				port.writeString("\r");
				port.writeString("gpio read 0\r");
				System.out.println(port.readString());
				port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
			} catch (SerialPortException ex) {
				System.out.println(ex);
			}

		} else {
			System.out.println("Usage: java USB relay port <Com Port>\nEg: " + PortNumber
					+ " USB Port is not Opening, Make sure Port is Correct");
		}
	}

	public void RelayON(String RelayNO){
		try {
			port.writeString("\r");
			port.writeString("relay on " + RelayNO + "\r");
			System.out.println("Info: <Relay ON Command is Passed> ");
			port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
			System.out.println("Info: <Relay Flashed Successfully and Relay is Turned ON> ");
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}

	public void RelayOFF(String RelayOFF){
		try {
			port.writeString("\r");
			port.writeString("relay off " + RelayOFF + "\r");
			System.out.println("Info: < Realy no : " + RelayOFF + " Turning OFF Command is Received By User");
			port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
			port.writeString("\r");
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
	}
	public void RelayRead(String relayRead) {
		try {
		port.writeString("relay read "+relayRead+ "\r");
		System.out.println("Info: < Serial Port is reading");
		port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
		port.writeString("\r");
		} catch (SerialPortException ex) {
			System.out.println(ex);
		}
		}
	public void RelayResetAll() {
		try {
		port.writeString("reset\r");
		System.out.println("Info: < Relay is Reset Position, User Stoped Relay and Relay Port is Closed");
		port.purgePort(SerialPort.PURGE_RXCLEAR & SerialPort.PURGE_TXCLEAR);
		System.out.println("Info: Relay Conditions Resetted and Back Forward Reset Done, relay Condition is 0>");
	} catch (SerialPortException ex) {
		System.out.println(ex);
	}
	}
	
	public static void main(String[] args) throws InterruptedException {
		RelayUtils relay = new RelayUtils();
		relay.PacketDataRelaySettings("com5");		
//				relay.RelayON("0");
//		Thread.sleep(1000);
//		relay.RelayOFF("0");
//		Thread.sleep(1000);
//		relay.RelayON("0");
//		Thread.sleep(1000);
		relay.RelayON("1");
//		Thread.sleep(1000);
//		relay.RelayON("2");
//		Thread.sleep(1000);
//		relay.RelayON("3");
//		Thread.sleep(1000);
//		relay.RelayON("4");
//		Thread.sleep(1000);
//		relay.RelayON("5");
//		Thread.sleep(1000);
//		relay.RelayON("6");
//		Thread.sleep(1000);
//		relay.RelayON("7");
//		Thread.sleep(1000);
//		relay.RelayON("8");
//		Thread.sleep(1000);
//		relay.RelayON("9");
//		Thread.sleep(1000);
//		relay.RelayON("10");
//		Thread.sleep(1000);
//		relay.RelayON("11");
//		Thread.sleep(1000);
		relay.RelayOFF("1");
//		Thread.sleep(1000);
//		relay.RelayOFF("2");
//		Thread.sleep(1000);
//		relay.RelayOFF("3");
		Thread.sleep(1000);
//		relay.RelayOFF("4");
//		Thread.sleep(1000);
//		relay.RelayOFF("5");
//		Thread.sleep(1000);
//		relay.RelayOFF("6");
//		Thread.sleep(1000);
//		relay.RelayOFF("7");
//		Thread.sleep(1000);
//		relay.RelayOFF("8");
//		Thread.sleep(1000);
//		relay.RelayOFF("9");
//		Thread.sleep(1000);
//		relay.RelayOFF("10");
//		Thread.sleep(1000);
//		relay.RelayOFF("11");
		relay.RelayResetAll();

	}

}
