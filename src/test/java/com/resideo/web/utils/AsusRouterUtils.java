package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.AsusRouterScreen;

public class AsusRouterUtils {

	public static String getRouterSettings(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("36")) {
						requestValue = "36";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12";
					} else if (parameterArray[i].contains("13")) {
						requestValue = "13";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "1";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "2";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "3";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "4";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "5";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "6";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "7";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "8";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "9";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "N Only";
					} else if (parameterArray[i].contains("LEGACY")) {
						requestValue = "Legacy";
					} else {
						requestValue = "N + AC";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					
					if (parameterArray[i].contains("20_40_80")) {
						requestValue = "20/40/80 MHz";
					} else if (parameterArray[i].contains("20_40")) {
						requestValue = "20/40 MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 MHz";
					} else if (parameterArray[i].contains("80")) {
						requestValue = "80 MHz";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("5")) {
						requestValue = "5GHz";
					} else {
						requestValue = "2.4GHz";
					}
					break;
				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
					requestValue = parameterArray_Value[i].replace("password is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("Open System".toUpperCase())) {
						requestValue = "Open System";
					} else if (parameterArray[i].contains("WPA2-Personal".toUpperCase())) {
						requestValue = "WPA2-Personal";
					} else if (parameterArray[i].contains("WPA-Auto-Personal".toUpperCase())) {
						requestValue = "WPA-Auto-Personal";
					} else if (parameterArray[i].contains("Shared Key".toUpperCase())) {
						requestValue = "Shared Key";
					} else if (parameterArray[i].contains("WPA-Personal".toUpperCase())) {
						requestValue = "WPA-Personal";
					} else 
					break;
				} else if (parameterArray[i].contains("WEP ENCRYPTION") && requestParameter.contains("WEP ENCRYPTION")) {
					if (parameterArray[i].contains("WEP-64")||parameterArray[i].contains("64")) {
						requestValue = "WEP-64bits";
					} else if (parameterArray[i].contains("WEP-128")||parameterArray[i].contains("128")) {
						requestValue = "WEP-128bits";
					} else if (parameterArray[i].contains("NONE")) {
						requestValue = "None";
					}
					break;
				} else if (parameterArray[i].contains("WEPKEY") && requestParameter.contains("WEPKEY")) {
					if (parameterArray[i].contains("1")) {
						requestValue = "1";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "2";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "3";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "4";
					}
					break;
				} else if (parameterArray[i].contains("WPA ENCRYPTION") && requestParameter.contains("WPA ENCRYPTION")) {
					if (parameterArray[i].contains("TKIP_AES")) {
						requestValue = "TKIP+AES";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					} 
					break;
				} else if (parameterArray[i].contains("IS SSID") && requestParameter.contains("IS SSID")) {
					if (parameterArray[i].contains("NO")||parameterArray[i].contains("FALSE")||parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("NETWORK KEY ROTATION")
						&& requestParameter.contains("NETWORK KEY ROTATION")) {
					requestValue = parameterArray_Value[i].replace("NETWORK KEY ROTATION IS", "").trim();
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO")||parameterArray[i].contains("FALSE")||parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("DHCP IP RANGE") && requestParameter.contains("DHCP IP RANGE")) {
							requestValue = parameterArray_Value[i].replace("DHCP IP range is", "").trim();
							break;
			    } else if (parameterArray[i].contains("DNS IP1") && requestParameter.contains("DNS IP1")) {
				            requestValue = parameterArray_Value[i].replace("DNS IP1 is", "").trim();
				            break;
			    } else if (parameterArray[i].contains("DHCPLEASE") && requestParameter.contains("DHCPLEASE")) {
		            requestValue = parameterArray_Value[i].replace("DHCPLease time is", "").trim();
		            break;
	}
			}
		} else {
			return null;
		}
		return requestValue;

	}
	
	public static String PageSource(String screenName) {
		String pagecontainer = null;
		switch (screenName) {

		case "HOME SETTINGS":
			pagecontainer = "Internet status:".toUpperCase();
			break;

		case "WIRELESS SETTING":
			pagecontainer = "Set up the wireless related information below.".toUpperCase();
			break;

		case "DHCP SETTING":
			pagecontainer = "LAN - DHCP Server".toUpperCase();
			break;

		default:
			pagecontainer = "";
			break;
		}

		return pagecontainer;
	}

	public static boolean changeWebPage(TestCases testCase, String baseURL, String requestingPage, String screenName) {
		WebDriver driver = testCase.getWebDriver();
		try {
			if (baseURL != null && requestingPage != null) {
				String geturl = baseURL + requestingPage.trim();
				if (!geturl.toUpperCase().contains("HTTP")) {
					geturl = "http://" + geturl;
				}
				driver.get(geturl);
			}
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.withTimeout(Duration.ofSeconds(30));
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.ignoring(IOException.class);

			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {
						String pageSource = driver.getPageSource();
						if (pageSource.toUpperCase().contains(PageSource(screenName))) {
							return true;
						} else
							return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Fluent wait for Downtime Got Exception, Exception is ++>>> " + e.getMessage());
						return false;
					}
				}

			});
			return isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception is occured due to " + e.getMessage());
			return false;
		}

	}

	public static boolean _RTAC68U_Model_chaneRouterSettings(TestCases testCase, String baseurl, String screenName,
			String frequency, String channel, String mode, String bandwidth, String security, String WPAencrpytion,
			String WEPencrpytion, String WEPkey, String password, String ssid_name, String is_ssid,
			String networkeyrotation, String is_dhcp, String dhcpIpRange, String DNSip1, String LeaseTime) {
		boolean flag = false;
		AsusRouterScreen asus = new AsusRouterScreen(testCase);
		try {
//			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			// if (changeWebPage(testCase, baseurl, "", "HOME SETTINGS")) {
			if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, baseurl, "/Advanced_DHCP_Content.asp", "DHCP SETTING")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (asus._RTAC68U_DHCPEnable_Disable(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}
					if (dhcpIpRange == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (asus._RTAC68U_setvalueinDHCP_IP_PoolRange(dhcpIpRange)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP IP range set to " + dhcpIpRange);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP range in DHCP setting");
						flag = false;
					}

					if (DNSip1 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (asus._RTAC68U_setvalueinDNSServerIP_1(DNSip1)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DNS server set to " + DNSip1);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP in DNS server setting");
						flag = false;
					}

					if (LeaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
					} else if (asus._RTAC68U_setvalueinDHCPLeaseTime(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}
			} else {
				if (changeWebPage(testCase, baseurl, "/Advanced_Wireless_Content.asp", "WIRELESS SETTING")) {
					if (frequency == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
					} else if (asus._RTAC68U_select_frequency(frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change frequency in Wireless setting");
						flag = false;
					}

					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (asus._RTAC68U_select_WirelessMode(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (asus._RTAC68U_select_Channel(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}

					if (bandwidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
					} else if (asus._RTAC68U_select_bandwidth(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channelwidth in Wireless setting");
						flag = false;
					}

					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
					} else if (asus._RTAC68U_SSIDEnable_Disable(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change SSID to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change broadcase SSID in Wireless setting");
						flag = false;
					}

					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
					} else if (asus._RTAC68U_setvalueinSSID(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to write broadcase SSID in wireless settings");
						flag = false;
					}

					if (networkeyrotation == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
					} else if (asus._RTAC68U_setvalueinNetworkKey(networkeyrotation)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change networkeyrotation to " + networkeyrotation);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change networkeyrotation settings");
						flag = false;
					}

					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security.");
					} else if (asus._RTAC68U_select_Security(security)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, security, null);
						Keyword.ReportStep_Pass(testCase, "Change security to " + security);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change encryption from security settings");
						flag = false;
					}

					if (WPAencrpytion == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WPAencrpytion suite.");
					} else if (security.contains("WPA") && asus._RTAC68U_changeWPAEncrpytion(WPAencrpytion)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, null, WPAencrpytion);
						Keyword.ReportStep_Pass(testCase, "Change WPAencrpytion to " + WPAencrpytion);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WPA encryption in wireless settings");
						flag = false;
					}

					if (WEPencrpytion == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEPencrpytion.");
					} else if ((security.contains("Open System") || security.contains("Shared Key"))
							&& asus._RTAC68U_changeWEPEncrpytion(WEPencrpytion)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, null, WEPencrpytion);
						Keyword.ReportStep_Pass(testCase, "Change WEPencrpytion to " + WEPencrpytion);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change WEP ");
						flag = false;
					}

					if (WEPkey == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEP key format.");
					} else if (asus._RTAC68U_changeWEPKeyIndex(WEPkey)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change WEPkey to " + WEPkey);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP key format from security settings");
						flag = false;
					}

					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password.");
					} else if (security.contains("WPA") && asus._RTAC68U_setValueinWPAPasswordTB(password)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
					} else if ((security.contains("Open System") || security.contains("Shared Key"))
							&& asus._RTAC68U_setValueinWEP1PasswordTB(password)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "Change password to " + password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change password from security settings");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (asus._RTAC68U_clickApplyBT()) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Settings saved");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Ok button.");
			}
			/*
			 * } else { Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
			 * "Not able to change Home setting page"); flag = false; }
			 */
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean changeRouterSettingsInAsus(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			// getRouterSettings(dataOptions, dataOptions);
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();

			switch (routerModel) {
			case "RTAC68U":
				/*
				 * Router details String frequency, String channel, String mode, String
				 * bandwidth, String security, String WPAencrpytion, String WEPencrpytion,
				 * String WEPkey, String password, String SSIDvalue, String is_ssidEnable,
				 * String networkeyrotation String baseurl =
				 * SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
				 */
				String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, baseurl, "", "HOME SETTINGS")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _RTAC68U_Model_chaneRouterSettings(testCase, baseurl, screenName,
						getRouterSettings(dataOptions, "FREQUENCY"),
						getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"),
						getRouterSettings(dataOptions, "BANDWIDTH"),
						getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "WPA ENCRYPTION"),
						getRouterSettings(dataOptions, "WEP ENCRYPTION"),
						getRouterSettings(dataOptions, "WEPKEY"),
						getRouterSettings(dataOptions, "PASSWORD"),
						getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "IS SSID"),
						getRouterSettings(dataOptions, "NETWORK KEY ROTATION"),
						getRouterSettings(dataOptions, "IS DHCP"),
						getRouterSettings(dataOptions, "DHCP IP RANGE"),
						getRouterSettings(dataOptions, "DNS IP1"),
						getRouterSettings(dataOptions, "DHCPLEASE"));

				if (flag) {
					String security = getRouterSettings(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;

			default:
				break;
			}
		} catch (Exception e) {

		}
		return flag;
	}

	public static WifiSecurityMode _RTAC68U_Model_chaneRouterSecuritySettings(String securityType_request) {
//		security           Encryption        
//		open system        None              
//		open system        WEP-64
//		open system        WEP-128
//		Shared Key         WEP-64
//		Shared Key         WEP-128
//		WPA-Personal       TKIP
//		WPA-Auto-Personal  TKIP+AES
//		WPA-Auto-Personal  AES
//		WPA2-Personal      AES
		WifiSecurityMode securityType = null;
		String security_Type = WebController.router_SSID_securityType().toUpperCase();
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
		if (security_Type.contains("open system".toUpperCase())) {
			if (security_Type.contains("None".toUpperCase())) {
				securityType = WifiSecurityMode.NONE;
			} else if (security_Type.contains("WEP-64".toUpperCase())) {
				securityType = WifiSecurityMode.WEP_PSK;
			} else if (security_Type.contains("WEP-128".toUpperCase())) {
				securityType = WifiSecurityMode.WEP_PSK;
			} else {
				securityType = WifiSecurityMode.WEP_PSK;
			}
		} else if (security_Type.contains("Shared Key".toUpperCase())) {
			if (security_Type.contains("WEP-64".toUpperCase())) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else if (security_Type.contains("WEP-128".toUpperCase())) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else {
				securityType = WifiSecurityMode.WEP_Shared;
			}
		} else if (security_Type.contains("WPA-Personal".toUpperCase())) {
			if (security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_TKIP_PSK;
			} else if (security_Type.contains("TKIP_AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			} else if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			} else {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			}
		} else if (security_Type.contains("WPA2-Personal".toUpperCase())) {
			if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			}
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}
		return securityType;
	}
}