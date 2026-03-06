package com.resideo.suiteExecutor;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

import org.apache.commons.math3.analysis.function.Add;

import com.resideo.commons.web.WebObject;
import com.resideo.utils.stat.StatCommands;
//import com.resideo.robotic_arm.supportConstant.ArmConstants;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.screenshotData;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;
import com.resideo.utils.stat.screens_Gui.GUI_Screen_Utils;
import com.resideo.utils.stat.screens_Gui.ScreenNavigationUtils;

public class StatCommanderVerification {

	public static void main(String[] args) throws UnknownHostException, SocketException {
//		getnamescreen();
//		boolean boolVal = StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_DEVICES_ASKTOADD).build()).getBoolVal();
//		System.out.println(boolVal);
//		
		
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY4ON").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY3ON").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayOff").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayON").build()).getBoolVal());
//		System.out.println(StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayOff").build()).getBoolVal());
		
//		try {
//			WebObject.updateWebConfigurationFiles();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		 boolVal = StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_INSTALLER_OPTIONS_ADD_EIM).build()).getBoolVal();
//		System.out.println(boolVal);
//		ScreenNavigationUtils.screenNavigationFromAnyScreen(null, "Add Redlink");
//		InetAddress IP = InetAddress.getLocalHost();
//		System.out.println("IP of my system is := " + IP.getHostAddress());
//		System.out.println("IP of my system hostname is := " + IP.getHostName());
//		System.out.println("IP of my system hostname is := " + IP.getCanonicalHostName());
//		System.out.println("IP of my system hostname is := " + IP.getAddress());
//		myPublicIp(IP.getHostAddress());
//		System.out.println(myPublicIp(IP.getHostAddress()));

//		try {
//			Process proc = Runtime.getRuntime().exec("ipconfig");
//
//            try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));) {
//
//                String line;
//                while ((line = stdInput.readLine()) != null) {
//                    if (line.trim().startsWith("default gateway")) {
//                        String ipaddress = line.substring(line.indexOf(":") + 1).trim(),
//                                routerurl = String.format("http://%s", ipaddress);
//
//                        // opening router setup in browser
//                        Desktop.getDesktop().browse(new URI(routerurl));
//                    }
//
//                    System.out.println(line);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//		try
//        {
//            //Variables to find out the Default Gateway IP(s)
//            String canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
//            String hostName = InetAddress.getLocalHost().getHostName();
//
//            //"subtract" the hostName from the canonicalHostName, +1 due to the "." in there
//            String defaultGatewayLeftover = canonicalHostName.substring(hostName.length() + 1);
//
//            //Info printouts
//            System.out.println("Info:\nCanonical Host Name: " + canonicalHostName + "\nHost Name: " + hostName + "\nDefault Gateway Leftover: " + defaultGatewayLeftover + "\n");
//            System.out.println("Default Gateway Addresses:\n" + printAddresses(InetAddress.getAllByName(defaultGatewayLeftover)));
//        } catch (UnknownHostException e)
//        {
//            e.printStackTrace();
//        }

//		 Enumeration<NetworkInterface> interfaces = NetworkInterface.
//				    getNetworkInterfaces();
//				    while (interfaces.hasMoreElements()) {
//				      NetworkInterface ni = interfaces.nextElement();
//				      System.out.println(ni);
//				    }
//				    
//		NetworkInterface eth0 = NetworkInterface.getByName("eth0");
//		Enumeration addresses = eth0.getInetAddresses();
//		while (addresses.hasMoreElements()) {
//			System.out.println(addresses.nextElement());
//		}
	}

	private static String printAddresses(InetAddress[] allByName) {
		if (allByName.length == 0) {
			return "";
		} else {
			String str = "";
			int i = 0;
			while (i < allByName.length - 1) {
				str += allByName[i] + "\n";
				i++;
			}
			return str + allByName[i];
		}
	}

	public static String myPublicIp(String ipAddress) {

		/* nslookup myip.opendns.com resolver1.opendns.com */
//		String command = "ipconfig";
		String ip4 = null;
		String ipAdressDns = "";
		try {
			String command = "netsh interface ipv4 show config";
			Process proc = Runtime.getRuntime().exec(command);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			boolean foundIP = false;
			String s;
			String currentIPConfiguration_Name = null;
			while ((s = stdInput.readLine()) != null) {
				ipAdressDns += s + "\n";
//				System.out.println(s);
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
					foundIP = false;
					String defaultgatewayIP = null;
					String DNSIP = null;
					while ((s = stdInput.readLine()) != null) {
						ipAdressDns += s + "\n";
//						System.out.println(s);
						if (s.contains("Default Gateway:")) {
							defaultgatewayIP = s.replace("Default Gateway:", "").trim();
						} else if (s.contains("DNS servers")) {
							DNSIP = s.replace("DNS servers configured through DHCP:", "").trim();
						}
					}
					System.out.println("Default gateway ::: IP :::"+defaultgatewayIP);
					System.out.println("Default DNS ::: IP :::"+DNSIP);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ipAdressDns;
	}

	public static void getnamescreen() {

		ArrayList<String> str = new ArrayList<>();
		str.add("HARI");
		str.add("HARI");
		str.add("HARI");
		str.add("HARI");
		str.add("HARI");
		str.add("HARI");
		str.add("HARI");
		str.add("HARIHARAN");

		ArrayList<String> duplicate = new ArrayList<>();
//		ArrayList<String> NonDuplicate = new ArrayList<>();
		HashSet<String> NonDuplicate = new HashSet<>();

		for (String string : str) {

			if (!NonDuplicate.contains(string)) {
				NonDuplicate.add(string);
			} else {
				duplicate.add(string);
			}

		}

		System.out.println(NonDuplicate);
		System.out.println(duplicate);

//		String txt = StatCommands.getInstance().cattCommandsStub.getTextsFromScreenParticualrArea(
//				screenshotData.newBuilder().setCapturePath(ArmConstants.stat_UI_Tmp_Asset).setXStartCordinate(2)
//						.setYStartCoordinate(230).setXEndCordinate(319).setYEndCoordinate(358).build())
//				.getStrVal();
//		
//		System.out.println(txt);
//		System.out.println("");
//		String strVal = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build()).getStrVal();
//		
//		System.out.println(strVal.substring(0,1)); //169
//		String deviceInfo = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build()).getStrVal();
//		if(deviceInfo==null) {
//			System.out.println("null");
//		}else if(deviceInfo.isEmpty()) {
//			System.out.println("empty");
//		}else {
//			System.out.println();
//		}
//		System.out.println();
//		StatCommands.getInstance().cattCommandsStub.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build());
//
////		for (int i = 0; i < 100; i++) {
//			StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build());
//			StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1OFF").build());
//			StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build());
//			StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2OFF").build());
//			
//		}
//		boolean boolVal = StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build()).getBoolVal();
//		System.out.println(boolVal);
//		boolVal = StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_QRCODE).build()).getBoolVal();
//		System.out.println(boolVal);
//		String Date =ArmConstants.stat_UI_Tmp_Asset+GUI_Screen_Utils.timestamp();
//		StatCommands.getInstance().cattCommandsStub.getScreenShot(
//				screenshotData.newBuilder().setCapturePath(Date).setXStartCordinate(75)
//						.setYStartCoordinate(255).setXEndCordinate(243).setYEndCoordinate(423).build())
//				.getStrVal().contains(Date);
//		
//		
//		String strVal = StatCommands.getInstance().cattCommandsStub.t0PlusGetCurrentScreen(String_Msg.newBuilder().build()).getStrVal();

//		StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayON").build());
//		StatCommands.getInstance().cattCommandsStub.changeArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayOff").build());

	}

}