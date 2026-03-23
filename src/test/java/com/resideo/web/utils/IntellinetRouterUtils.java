package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebUtils;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.IntellinetRouterScreen;

public class IntellinetRouterUtils {

	public static String getRouterSettings(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("1")) {
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
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12";
					} else {
						requestValue = "1";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B ONLY")) {
						requestValue = "2.4 GHz (B)";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "2.4 GHz (N)";
					} else if (parameterArray[i].contains("BG ONLY")) {
						requestValue = "2.4 GHz (B+G)";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "2.4 GHz (G)";
					} else if (parameterArray[i].contains("BGN ONLY")) {
						requestValue = "2.4 GHz (B+G+N)";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {

					if (parameterArray[i].contains("20_40") || parameterArray[i].toUpperCase().contains("AUTO")) {
						requestValue = "20/40 MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
						requestValue = "2.4GHz";
					}
					break;
				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
					requestValue = parameterArray_Value[i].replace("password is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("DISABLE") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else if (parameterArray[i].contains("WEP") || parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA PRESHAREDKEY")) {
						requestValue = "WPA pre-shared key";
					} else if (parameterArray[i].contains("WPA RADIUS")) {
						requestValue = "WPA RADIUS";
					}
					break;
				} else if (parameterArray[i].contains("WEP KEY LENGTH")
						&& requestParameter.contains("WEP KEY LENGTH")) {
					if (parameterArray[i].contains("64")) {
						requestValue = "64-bit";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "128-bit";
					}
					break;
				} else if (parameterArray[i].contains("WEP KEY FORMAT")
						&& requestParameter.contains("WEP KEY FORMAT")) {
					if (parameterArray[i].contains("HEX")) {
						requestValue = "Hex (10 Characters)";
					} else if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII (5 Characters)";
					}
					break;
				} else if (parameterArray[i].contains("WPA UNICAST") && requestParameter.contains("WPA UNICAST")) {
					if (parameterArray[i].contains("MIXED")) {
						requestValue = "MIXED";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					}
					break;
				} else if (parameterArray[i].contains("IS SSID") && requestParameter.contains("IS SSID")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("DHCP LEASE") && requestParameter.contains("DHCP LEASE")) {
					if (parameterArray[i].contains("HALF HOUR")) {
						requestValue = "Half an hour";
					} else if (parameterArray[i].contains("ONE HOUR")) {
						requestValue = "One hour";
					} else if (parameterArray[i].contains("TWO HOURS")) {
						requestValue = "Two hours";
					} else if (parameterArray[i].contains("HALF DAY")) {
						requestValue = "Half of a day";
					} else if (parameterArray[i].contains("ONE DAY")) {
						requestValue = "One day";
					} else if (parameterArray[i].contains("TWO DAYS")) {
						requestValue = "Two days";
					} else if (parameterArray[i].contains("ONE WEEK")) {
						requestValue = "One week";
					} else if (parameterArray[i].contains("TWO WEEKS")) {
						requestValue = "Two weeks";
					} else if (parameterArray[i].contains("FOREVER")) {
						requestValue = "Forever";
					}
					break;
				} else if (parameterArray[i].contains("DHCP START IP ADD")
						&& requestParameter.contains("DHCP START IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP Start IP Address is ", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP END IP ADD")
						&& requestParameter.contains("DHCP END IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP End IP Address is ", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS IP ADDRESS")
						&& requestParameter.contains("RADIUS IP ADDRESS")) {
					requestValue = parameterArray_Value[i].replace("Radius IP Address is", "").trim();
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

	public static boolean Applysettings(TestCases testCase) {
		boolean flag = false;
		try {
			IntellinetRouterScreen router = new IntellinetRouterScreen(testCase);
			if (router.ClickonApplybutton()) {
				if (router.ClickonApplybutton()) {
					if (router.ClickonOKbutton(70)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Settings Applied");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click on apply button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static String PageSource(String screenName) {
		String pagecontainer = null;
		switch (screenName) {
		case "BASIC SETTING":
			pagecontainer = "This page allows you to define ESSID, and Channel for the wireless connection. These parameters are used for the wireless stations to connect"
					.toUpperCase();

			break;
		case "ADVANCE SETTING":
			pagecontainer = "Set the time zone of the Wireless Router. This information is used for log entries and firewall"
					.toUpperCase();
			break;
		case "SECURITY SETTING":
			pagecontainer = "This page allows you setup the wireless security. Turn on WEP or WPA by using Encryption Keys could prevent any unauthorized access to your wireless"
					.toUpperCase();
			break;
		case "HOME SCREEN":
			pagecontainer = "WirelessRouter".toUpperCase();
			break;
		case "LAN SCREEN":
			pagecontainer = "You can enable the Wireless Router's DHCP server to dynamically allocate IP Addresses to your LAN client PCs. The Wireless Router must have an IP Address in the Local Area Network."
					.toUpperCase();
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
				driver.get(baseURL + requestingPage);
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

	public static boolean changeRouterSettingsInIntellient(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();
			String baseURL = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL").toUpperCase();

			switch (routerModel) {
			case "150N3G":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://192.168.2.1", "/index.asp", "HOME SCREEN")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}

				flag = doRouterSettings(testCase, screenName, baseURL, getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"), getRouterSettings(dataOptions, "ENCRYPTION"),
						getRouterSettings(dataOptions, "WPA UNICAST"), getRouterSettings(dataOptions, "WEP KEY LENGTH"),
						getRouterSettings(dataOptions, "WEP KEY FORMAT"), getRouterSettings(dataOptions, "PASSWORD"),
						getRouterSettings(dataOptions, "BANDWIDTH"), getRouterSettings(dataOptions, "IS SSID"),
						getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "RADIUS IP ADDRESS"), getRouterSettings(dataOptions, "WEP KEY"),
						getRouterSettings(dataOptions, "IS DHCP"), getRouterSettings(dataOptions, "DHCP LEASE"),
						getRouterSettings(dataOptions, "DHCP START IP ADD"),
						getRouterSettings(dataOptions, "DHCP END IP ADD"));

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
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

//	private static WifiSecurityMode _524445_Model_chaneRouterSecuritySettings(String securityType_request) {
//		WifiSecurityMode securityType = null;
//		String security_Type = WebController.router_SSID_securityType().toUpperCase();
//		if (securityType_request != null) {
//			security_Type = securityType_request;
//		} else {
//			if (security_Type != null) {
//				String encryption = WebController.router_SSID_securityEncryption().toUpperCase();
//				if (encryption != null) {
//					if (!encryption.isEmpty()) {
//						security_Type = security_Type + "_" + encryption;
//					}
//				}
//			} else {
//				securityType = null;
//			}
//		}
//		if (security_Type.contains("NONE") || security_Type.contains("DISABLED")) {
//			securityType = WifiSecurityMode.NONE;
//		} else if (security_Type.contains("WPA")) {
//			if (security_Type.contains("TKIP+AES") || security_Type.contains("MIXED")) {
//				securityType = WifiSecurityMode.WPA_MIXED_PSK;
//			} else if (security_Type.contains("TKIP")) {
//				securityType = WifiSecurityMode.WPA_TKIP_PSK;
//			} else if (security_Type.contains("AES")) {
//				securityType = WifiSecurityMode.WPA_AES_PSK;
//			}
//		} else if (security_Type.contains("WEP")) {
//			if (security_Type.contains("SHARED")) {
//				securityType = WifiSecurityMode.WEP_Shared;
//			} else {
//				securityType = WifiSecurityMode.WEP_PSK;
//			}
//		} else {
//			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//		}
//
//		return securityType;
//	}

	public static boolean doRouterSettings(TestCases testCase, String screenName, String baseURL, String channel,
			String Mode, String encryption, String wpaUniCast, String wep_keyLegth, String wep_keyFormat,
			String password, String channelWidth, String is_ssidEnable, String ssid_name, String RadiusIPAdd,
			String WEP_key, String is_dhcpEnable, String LeaseTime, String dhcpStartIP, String dhcpEndIP) {
		boolean flag = false;
		IntellinetRouterScreen intellinetScreen = new IntellinetRouterScreen(testCase);

		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (screenName.contains("BASIC SETTING")) {
			if (changeWebPage(testCase, baseURL, "/wlbasic.asp", "BASIC SETTING")) {
				if (Mode == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
				} else if (intellinetScreen.changeMode(Mode)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed Mode to ." + Mode);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Mode from Basic settings");
					flag = false;
				}

				if (channel == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
				} else if (intellinetScreen.changeChannel(channel)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change channel from Basic settings");
					flag = false;
				}
				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
				} else if (intellinetScreen.setSSIDName(ssid_name)) {
					flag = true;
					WebController.changeWifiSSID_Password(ssid_name, null, null, null);
					Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change channel from Basic settings");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navogate tot Basic settings for change Channel or Mode vs Band");
				flag = false;
			}
		} else if (screenName.contains("SECURITY SETTING")) {
			if (changeWebPage(testCase, baseURL, "/wlencrypt.asp", "SECURITY SETTING")) {
				if (encryption == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
				} else if (intellinetScreen.changeSecurity(encryption)) {
					WebController.changeWifiSSID_Password(null, null, encryption.toUpperCase(), null);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change encryption from security settings");
					flag = false;
				}
				if (encryption.toUpperCase().contains("WPA RADIUS")) {
					if (RadiusIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusIPAdd.");
					} else if (intellinetScreen.setRadiusIPAddress(RadiusIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successully set the Radius IP address.");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Radius IP Address from security settings");
						flag = false;
					}
				}
				if (encryption.toUpperCase().contains("WEP")) {

					if (wep_keyLegth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEP keylength.");
					} else if (intellinetScreen.changeWEP_Keylength(wep_keyLegth)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP Key length from security settings");
						flag = false;
					}

					if (WEP_key == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEP Key.");
					} else if (intellinetScreen.changeWEP_Key(WEP_key)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changes WEP Key to " + WEP_key);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP Key length from security settings");
						flag = false;
					}

					if (wep_keyFormat == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEP key format.");
					} else if (intellinetScreen.changeWEPFormat(wep_keyFormat)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP key format from security settings");
						flag = false;
					}
				}

				if (wpaUniCast == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change wpa unicast cipher suite.");
				} else if (encryption.contains("WPA") && intellinetScreen.changeWPA_suite(wpaUniCast)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, null, null, wpaUniCast.toUpperCase());
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change wpa unicast cipher suite from security settings");
					flag = false;
				}

				if (password == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change password.");
				} else if (encryption.toUpperCase().contains("WPA PR") && intellinetScreen.setValueinWPAPassword(password)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, password, null, null);
				} else if (encryption.contains("WEP") && intellinetScreen.setValue_WepPassword(password)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, password, null, null);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change password from security settings");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navogate tot security settings for change Channel or Mode vs Band");
				flag = false;
			}

		} else if (screenName.contains("ADVANCE SETTING")) {
			if (changeWebPage(testCase, baseURL, "/wladvance.asp", "ADVANCE SETTING")) {
				if (channelWidth == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
				} else if (intellinetScreen.changeChannelWidth(channelWidth)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Changed channel width to :" + channelWidth);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change channelwidth from Advance settings");
					flag = false;
				}

				if (is_ssidEnable == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
				} else if (intellinetScreen.SSIDEnable_Disable(is_ssidEnable)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Changed SSID to :" + is_ssidEnable);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change broadcase SSID from Advance settings");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navogate tot Basic settings for change Channel or Mode vs Band");
				flag = false;
			}
		} else if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/lan.asp", "DHCP")) {
				if (is_dhcpEnable == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
				} else if (intellinetScreen.DHCPEnable_Disable(is_dhcpEnable)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP to :" + is_dhcpEnable);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp enable/disable settings");
					flag = false;
				}
				if (LeaseTime == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp LeaseTime .");
				} else if (intellinetScreen.changeDHCPLeaseTime(LeaseTime)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP LeaseTime to :" + LeaseTime);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp LeaseTime settings");
					flag = false;
				}
				if (dhcpStartIP == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp StartIP .");
				} else if (intellinetScreen.setDHCPStartIP(dhcpStartIP)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP dhcpStartIP to :" + dhcpStartIP);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp StartIP settings");
					flag = false;
				}
				if (dhcpEndIP == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp EndIP .");
				} else if (intellinetScreen.setDHCPEndIP(dhcpEndIP)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP ENDing IP to :" + dhcpEndIP);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp DHCP ENDing IP  settings");
					flag = false;
				}
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen Name.");
			flag = false;
		}

		if (flag) {
			if (intellinetScreen.ClickonApplybutton()) {
				if (intellinetScreen.ClickonApplybutton()) {
					if (intellinetScreen.ClickonOKbutton(50)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Settings Applied");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click on apply button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		}
		return flag;
	}

}