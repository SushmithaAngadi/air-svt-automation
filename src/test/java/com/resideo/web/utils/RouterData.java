package com.resideo.utils.web.data;

public class RouterData {

	private static RouterData instance = null;

	public static RouterData getRouterInstance() {
		if (instance == null)
			instance = new RouterData();
		return instance;
	}

	private static String routername;

	public static RouterData getRouterInstance(String routerName) {
		routername = routerName;
		if (instance == null)
			instance = new RouterData();
		return instance;
	}

//	public static void checkTplinkData(String routerBandwidth, String SecurityType, String channel)

	/*
	 * routerBandwidthType = 2.4ghz or 5ghz securityType = wpa / wpa2 / wpa3 / mixed
	 * Security version = ? (based on Router) option able to see in TP link ax 1800
	 * Encryption = ? Tkip or AES based on router Channel width = 20MHZ, 40MHZ or
	 * auto based on router channel = 1 to 13 (will change based on router and based
	 * on bandwidth) Mode = g / n / b based on Router
	 * 
	 */

//	public static boolean assginData(String routerBandwidthType, String securityType, String securityVersion,
//			String encryptionType, String mode, String channel, String channelwidthFrequency) {
//
//	}

	String getRouterBandwidth() {

//		if(routername.contains("TPLINK")) {
//			
//		}else if(routername.contains("INTELLINET")) {
//			
//		}else if()
//		
		return null;
	}

}
