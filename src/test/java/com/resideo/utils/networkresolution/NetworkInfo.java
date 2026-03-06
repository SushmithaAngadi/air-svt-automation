package com.resideo.utils.networkresolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class NetworkInfo {

	public static String getDHCP_GatewayIP() {
		String defaultgatewayIP = null;
		try {
			boolean foundIP = false;
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("IP of my system is : " + ip.getHostAddress());
			String ipAddress = ip.getHostAddress();
			try {
				String command = "netsh interface ipv4 show config";
				Process proc = Runtime.getRuntime().exec(command);
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String s;
				String currentIPConfiguration_Name = null;
				while ((s = stdInput.readLine()) != null) {
					if (s.contains("Configuration")) {
						if (!foundIP) {
							currentIPConfiguration_Name = s.replace("Configuration for interface", "").trim();
						}
					}
					if (s.contains(ipAddress)) {
						foundIP = true;
						break;
					}
				}
				if (foundIP) {
					try {
						command = "netsh interface ipv4 show config " + currentIPConfiguration_Name;
						proc = Runtime.getRuntime().exec(command);
						stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
						String DNSIP = null;
						while ((s = stdInput.readLine()) != null) {
							if (s.contains("Default Gateway:")) {
								defaultgatewayIP = s.replace("Default Gateway:", "").trim();
							} else if (s.contains("DNS servers")) {
								DNSIP = s.replace("DNS servers configured through DHCP:", "").trim();
							}
						}
						System.out.println("Default gateway ::: IP :::" + defaultgatewayIP);
						System.out.println("Default DNS ::: IP :::" + DNSIP);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

		}
		return defaultgatewayIP;

	}

}
