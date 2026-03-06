package com.resideo.utils.networksimulator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
	
	/*
	private DatagramSocket socket;
	private InetAddress address;

	private byte[] buf;

	public EchoClient() {
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName("192.168.1.120");
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public EchoClient(String ip) throws SocketException, UnknownHostException {
		socket = new DatagramSocket();
		address = InetAddress.getByName(ip);
	}

//	public String sendEcho(String msg) {
//		buf = msg.getBytes();
//		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
//		try {
//			socket.send(packet);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	public boolean sendEcho(String msg) {
		buf = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
		try {
			socket.send(packet);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public void close() {
		socket.close();
	}
	*/
	
	private DatagramSocket socket;
	private InetAddress address1;
	private InetAddress address2;
	private InetAddress address3;
	private InetAddress address4;
	private InetAddress address5;

	private byte[] buf;

	public EchoClient(String ip1,String ip2,String ip3,String ip4,String ip5) {
		try {
			socket = new DatagramSocket();
			address1 = InetAddress.getByName(ip1);
			address2 = InetAddress.getByName(ip2);
			address3 = InetAddress.getByName(ip3);
			address4 = InetAddress.getByName(ip4);
			address5 = InetAddress.getByName(ip5);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public void sendEcho(String msg) {
		buf = msg.getBytes();
		DatagramPacket packet1 = new DatagramPacket(buf, buf.length, address1, 4445);
		DatagramPacket packet2 = new DatagramPacket(buf, buf.length, address2, 4445);
		DatagramPacket packet3 = new DatagramPacket(buf, buf.length, address3, 4445);
		DatagramPacket packet4 = new DatagramPacket(buf, buf.length, address4, 4445);
		DatagramPacket packet5 = new DatagramPacket(buf, buf.length, address5, 4445);
		try {
			socket.send(packet1);
			socket.send(packet2);
			socket.send(packet3);
			socket.send(packet4);
			socket.send(packet5);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close() {
		socket.close();
	}
}