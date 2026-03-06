package com.resideo.utils.web;

import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;

public class WebController {

	public static WebController instance = null;

	public static WebController getWebinstance() {
		if (instance == null) {
			instance = new WebController();
		}
		return instance;
	}
	
	private static String routerName;
	private static String routerModel;
	private static boolean isloggedIn;

	private static String router_SSID_Name = "Home";
	private static String router_SSID_Password = "Home@123.";
	private static String router_SSID_securityType = "WPA2_MIXED_PSK";
	private static String router_SSID_securityEncryption = null;
	private static WifiSecurityMode securityType;

	public static void initWifiRouterSettings() {
		isloggedIn = false;
		router_SSID_Name = "Home";
		router_SSID_Password = "Home@123.";
		router_SSID_securityType = "WPA2_MIXED_PSK";
		router_SSID_securityEncryption = null;
		securityType = WifiSecurityMode.WPA2_MIXED_PSK;
	}

	public static void routerName(String router_name) {
		routerName = router_name;
	}

	public static String routerName() {
		return routerName;
	}

	public static void routerModel(String router_model) {
		routerModel = router_model;
	}

	public static String routerModel() {
		return routerModel;
	}

	public static void isloggedIn(boolean is_loggedIn) {
		isloggedIn = is_loggedIn;
	}

	public static boolean isloggedIn() {
		return isloggedIn;
	}

	public static void router_SSID_Name(String router_SSIDName) {
		router_SSID_Name = router_SSIDName;
	}

	public static String router_SSID_Name() {
		return router_SSID_Name;
	}

	public static void router_SSID_Password(String router_SSIDPassword) {
		router_SSID_Password = router_SSIDPassword;
	}

	public static String router_SSID_Password() {
		return router_SSID_Password;
	}

	public static void router_SSID_securityType(String router_SSIDsecurityType) {
		router_SSID_securityType = router_SSIDsecurityType;
	}

	public static String router_SSID_securityType() {
		return router_SSID_securityType;
	}

	public static void router_SSID_securityEncryption(String router_SSID_security_Encryption) {
		router_SSID_securityEncryption = router_SSID_security_Encryption;
	}

	public static String router_SSID_securityEncryption() {
		return router_SSID_securityEncryption;
	}

	public static void securityType(WifiSecurityMode security_Type) {
		securityType = security_Type;
	}

	public static WifiSecurityMode securityType() {
		return securityType;
	}

	public static void changeWifiSSID_Password(String ssidName, String ssidPass, String securityType,
			String securityEncryptionType) {
		if (ssidName != null) {
			if (!ssidName.isEmpty()) {
				router_SSID_Name = ssidName;
			}
		}
		if (ssidPass != null) {
			if (!ssidPass.isEmpty()) {
				router_SSID_Password = ssidPass;
			}
		}
		if (securityType != null) {
			if (!securityType.isEmpty()) {
				router_SSID_securityType = securityType;
			}
		}
		if (securityEncryptionType != null) {
			if (!securityEncryptionType.isEmpty()) {
				router_SSID_securityEncryption = securityEncryptionType;
			}
		}
	}
	
	public static WifiSecurityMode getSecurityType(String securityType_Name) {
		WifiSecurityMode wifisecurity = WifiSecurityMode.NONE;
 
		if (securityType_Name.contains("NONE")) {
			wifisecurity = WifiSecurityMode.NONE;
		} else if (securityType_Name.contains("WEP")) {
			if (securityType_Name.contains("WEP") && securityType_Name.contains("SHARE")) {
				wifisecurity = WifiSecurityMode.WEP_Shared;
			}
			else {
				wifisecurity = WifiSecurityMode.WEP_PSK;
			}
 
		} else if (securityType_Name.contains("WPA") && !securityType_Name.contains("WPA2")
				&& !securityType_Name.contains("ENTER")) {
 
			if (securityType_Name.contains("TKIP")) {
				wifisecurity = WifiSecurityMode.WPA_TKIP_PSK;
			} else if (securityType_Name.contains("AES")) {
				wifisecurity = WifiSecurityMode.WPA_AES_PSK;
			} else if (securityType_Name.contains("MIXED")) {
				wifisecurity = WifiSecurityMode.WPA_MIXED_PSK;
			} else {
				wifisecurity = WifiSecurityMode.WPA_MIXED_PSK;
			}
 
		} else if (securityType_Name.contains("WPA2") && !securityType_Name.contains("ENTER")) {
 
			if (securityType_Name.contains("TKIP") && !securityType_Name.contains("AES")) {
				wifisecurity = WifiSecurityMode.WPA2_TKIP_PSK;
			} else if (securityType_Name.contains("AES") && !securityType_Name.contains("TKIP")) {
				wifisecurity = WifiSecurityMode.WPA2_AES_PSK;
			} else {
				wifisecurity = WifiSecurityMode.WPA2_MIXED_PSK;
			}
 
		} else if (securityType_Name.contains("WPA") && !securityType_Name.contains("WPA2")
				&& securityType_Name.contains("ENTER")) {
 
			if (securityType_Name.contains("TKIP")) {
				wifisecurity = WifiSecurityMode.WPA_TKIP_Enterprise;
			} else if (securityType_Name.contains("AES")) {
				wifisecurity = WifiSecurityMode.WPA_AES_Enterprise;
			} else {
				wifisecurity = WifiSecurityMode.WPA_MIXED_Enterprise;
			}
		} else if (securityType_Name.contains("WPA2") && securityType_Name.contains("ENTER")) {
 
			if (securityType_Name.contains("TKIP")) {
				wifisecurity = WifiSecurityMode.WPA2_TKIP_Enterprise;
			} else if (securityType_Name.contains("AES")) {
				wifisecurity = WifiSecurityMode.WPA2_AES_Enterprise;
			} else {
				wifisecurity = WifiSecurityMode.WPA2_MIXED_Enterprise;
			}
 
		} else if (securityType_Name.contains("IBSS")) {
			wifisecurity = WifiSecurityMode.IBSS_Enabled;
 
		} else if (securityType_Name.contains("WPS") && securityType_Name.contains("SEC")) {
			wifisecurity = WifiSecurityMode.WPS_Open;
 
		} else if (securityType_Name.contains("WPS")) {
			wifisecurity = WifiSecurityMode.WPS_Secure;
 
		} else {
			wifisecurity = WifiSecurityMode.WPA2_MIXED_PSK;
		}
 
		return wifisecurity;
	}

	public static WifiSecurityMode securityType_nonRoutermode(String securityType) {
		WifiSecurityMode security = null;
		if (securityType.contains("WPA2_MIXED") || securityType.contains("WPA2_TKIP_AES")) {
			security = WifiSecurityMode.WPA2_MIXED_PSK;
		} else if (securityType.contains("WPA2_AES")) {
			security = WifiSecurityMode.WPA2_AES_PSK;
		} else if (securityType.contains("WPA2_TKIP")) {
			security = WifiSecurityMode.WPA2_TKIP_PSK;
		} else if (securityType.contains("WPA_MIXED") || securityType.contains("WPA_TKIP_AES")) {
			security = WifiSecurityMode.WPA_MIXED_PSK;
		} else if (securityType.contains("WPA_AES")) {
			security = WifiSecurityMode.WPA_AES_PSK;
		} else if (securityType.contains("WPA_TKIP")) {
			security = WifiSecurityMode.WPA_TKIP_PSK;
		} else if (securityType.contains("WEP")) {
			security = WifiSecurityMode.WEP_PSK;
		} else if (securityType.contains("OPEN") || securityType.contains("NONE")) {
			security = WifiSecurityMode.NONE;
		} else {
			security = WifiSecurityMode.WPA2_MIXED_PSK;
		}
		return security;
	}
	

 
 
	
	

//	public static void setPreconditionToRouter(TestCases testCase, String typeOfOperation, String routerData) {
//
//		String[] routerDataArray = routerData.split(",");
//		String testcaseType = typeOfOperation.toUpperCase();
//
//		if (testcaseType.contains("MODE AND CHANNEL")) {
//
//		} else {
//
//		}
//
//	}

}
