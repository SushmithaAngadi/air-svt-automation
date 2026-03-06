package com.resideo.utils.web;

import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;

public class WebCommonUtils {

	public static WifiSecurityMode changeRouterSecuritySettings(String securityType_request) {
		WifiSecurityMode securityType = null;
//		String security_Type = WebController.router_SSID_securityType().toUpperCase();
		String security_Type = WebController.router_SSID_securityType() == null ? null: WebController.router_SSID_securityType().toUpperCase();
		if (securityType_request != null) {
			security_Type = securityType_request;
		} else {
			if (security_Type != null) {
				String encryption = WebController.router_SSID_securityEncryption().toUpperCase();
				if (encryption != null) {
					if (!encryption.isEmpty()) {
						security_Type = security_Type + "_" + encryption;
					}
				}
			} else {
				securityType = null;
			}
		}
		if (security_Type.contains("NONE")) {
			securityType = WifiSecurityMode.NONE;
		} else if (security_Type.contains("WEP")) {
			if (security_Type.contains("SHARED")) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else {
				securityType = WifiSecurityMode.WEP_PSK;
			}
		} else if (security_Type.contains("WPA_WPA2") || security_Type.contains("WPA/WPA2 MIXED")) {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		} else if (security_Type.contains("WPA2")) {
			if (security_Type.contains("AES".toUpperCase()) && security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			} else if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			} else if (security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_TKIP_PSK;
			}
		} else if (security_Type.contains("WPA")) {
			if (security_Type.contains("AES".toUpperCase()) && security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			} else if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_AES_PSK;
			} else if (security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_TKIP_PSK;
			}
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}

		return securityType;
	}

}