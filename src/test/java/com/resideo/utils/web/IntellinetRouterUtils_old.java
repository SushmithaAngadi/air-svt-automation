//package com.resideo.utils.web;
//
//import java.io.IOException;
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.FluentWait;
//import java.util.function.Function;
//
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.web.screens.IntellinetRouterScreen;
//
//public class IntellinetRouterUtils_old {
//
//	public static String getRouterSettings(String data, String requestParameter) {
//		String requestValue = null;
//		if (data.toUpperCase().contains(requestParameter)) {
//			String[] parameterArray = data.toUpperCase().split(";");
//			String[] parameterArray_Value = data.split(";");
//			for (int i = 0; i < parameterArray.length; i++) {
//				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
//					if (parameterArray[i].contains("36")) {
//						requestValue = "36";
//					} else if (parameterArray[i].contains("40")) {
//						requestValue = "40";
//					} else if (parameterArray[i].contains("44")) {
//						requestValue = "44";
//					} else if (parameterArray[i].contains("48")) {
//						requestValue = "48";
//					} else if (parameterArray[i].contains("10")) {
//						requestValue = "10";
//					} else if (parameterArray[i].contains("11")) {
//						requestValue = "11";
//					} else if (parameterArray[i].contains("12")) {
//						requestValue = "12";
//					} else if (parameterArray[i].contains("13")) {
//						requestValue = "13";
//					} else if (parameterArray[i].contains("1")) {
//						requestValue = "1";
//					} else if (parameterArray[i].contains("2")) {
//						requestValue = "2";
//					} else if (parameterArray[i].contains("3")) {
//						requestValue = "3";
//					} else if (parameterArray[i].contains("4")) {
//						requestValue = "4";
//					} else if (parameterArray[i].contains("5")) {
//						requestValue = "5";
//					} else if (parameterArray[i].contains("6")) {
//						requestValue = "6";
//					} else if (parameterArray[i].contains("7")) {
//						requestValue = "7";
//					} else if (parameterArray[i].contains("8")) {
//						requestValue = "8";
//					} else if (parameterArray[i].contains("9")) {
//						requestValue = "9";
//					} else {
//						requestValue = "Auto";
//					}
//					break;
//				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
//					if (parameterArray[i].contains("AUTO")) {
//						requestValue = "Auto";
//					} else if (parameterArray[i].contains("N ONLY")) {
//						requestValue = "N Only";
//					} else if (parameterArray[i].contains("LEGACY")) {
//						requestValue = "Legacy";
//					} else {
//						requestValue = "N + AC";
//					}
//					break;
//				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
//					
//					if (parameterArray[i].contains("20_40_80")) {
//						requestValue = "20/40/80 MHz";
//					} else if (parameterArray[i].contains("20_40")) {
//						requestValue = "20/40 MHz";
//					} else if (parameterArray[i].contains("20")) {
//						requestValue = "20 MHz";
//					} else if (parameterArray[i].contains("40")) {
//						requestValue = "40 MHz";
//					} else if (parameterArray[i].contains("80")) {
//						requestValue = "80 MHz";
//					}
//					break;
//				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
//					if (parameterArray[i].contains("5")) {
//						requestValue = "5GHz";
//					} else {
//						requestValue = "2.4GHz";
//					}
//					break;
//				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
//					requestValue = parameterArray_Value[i].replace("password is", "").trim();
//					break;
//				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
//					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
//					break;
//				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
//					if (parameterArray[i].contains("Open System".toUpperCase())) {
//						requestValue = "Open System";
//					} else if (parameterArray[i].contains("WPA2-Personal".toUpperCase())) {
//						requestValue = "WPA2-Personal";
//					} else if (parameterArray[i].contains("WPA-Auto-Personal".toUpperCase())) {
//						requestValue = "WPA-Auto-Personal";
//					} else if (parameterArray[i].contains("Shared Key".toUpperCase())) {
//						requestValue = "Shared Key";
//					} else if (parameterArray[i].contains("WPA-Personal".toUpperCase())) {
//						requestValue = "WPA-Personal";
//					} else 
//					break;
//				} else if (parameterArray[i].contains("WEP ENCRYPTION") && requestParameter.contains("WEP ENCRYPTION")) {
//					if (parameterArray[i].contains("WEP-64")||parameterArray[i].contains("64")) {
//						requestValue = "WEP-64bits";
//					} else if (parameterArray[i].contains("WEP-128")||parameterArray[i].contains("128")) {
//						requestValue = "WEP-128bits";
//					} else if (parameterArray[i].contains("NONE")) {
//						requestValue = "None";
//					}
//					break;
//				} else if (parameterArray[i].contains("WEPKEY") && requestParameter.contains("WEPKEY")) {
//					if (parameterArray[i].contains("1")) {
//						requestValue = "1";
//					} else if (parameterArray[i].contains("2")) {
//						requestValue = "2";
//					} else if (parameterArray[i].contains("3")) {
//						requestValue = "3";
//					} else if (parameterArray[i].contains("4")) {
//						requestValue = "4";
//					}
//					break;
//				} else if (parameterArray[i].contains("WPA ENCRYPTION") && requestParameter.contains("WPA ENCRYPTION")) {
//					if (parameterArray[i].contains("TKIP_AES")) {
//						requestValue = "TKIP+AES";
//					} else if (parameterArray[i].contains("AES")) {
//						requestValue = "AES";
//					} else if (parameterArray[i].contains("TKIP")) {
//						requestValue = "TKIP";
//					} 
//					break;
//				} else if (parameterArray[i].contains("IS SSID") && requestParameter.contains("IS SSID")) {
//					if (parameterArray[i].contains("NO")||parameterArray[i].contains("FALSE")||parameterArray[i].contains("DISABLE")) {
//						requestValue = "NO";
//					} else {
//						requestValue = "YES";
//					}
//					break;
//				} else if (parameterArray[i].contains("NETWORK KEY ROTATION")
//						&& requestParameter.contains("NETWORK KEY ROTATION")) {
//					requestValue = parameterArray_Value[i].replace("NETWORK KEY ROTATION IS", "").trim();
//					break;
//				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
//					if (parameterArray[i].contains("NO")||parameterArray[i].contains("FALSE")||parameterArray[i].contains("DISABLE")) {
//						requestValue = "NO";
//					} else {
//						requestValue = "YES";
//					}
//					break;
//				} else if (parameterArray[i].contains("DHCP IP RANGE") && requestParameter.contains("DHCP IP RANGE")) {
//							requestValue = parameterArray_Value[i].replace("DHCP IP range is", "").trim();
//							break;
//			    } else if (parameterArray[i].contains("DNS IP1") && requestParameter.contains("DNS IP1")) {
//				            requestValue = parameterArray_Value[i].replace("DNS IP1 is", "").trim();
//				            break;
//			    } else if (parameterArray[i].contains("DHCPLEASE") && requestParameter.contains("DHCPLEASE")) {
//		            requestValue = parameterArray_Value[i].replace("DHCPLease time is", "").trim();
//		            break;
//	}
//			}
//		} else {
//			return null;
//		}
//		return requestValue;
//
//	}
//	
//	
//	public static boolean Applysettings(TestCases testCase) {
//		boolean flag = false;
//		try {
//			IntellinetRouterScreen router = new IntellinetRouterScreen(testCase);
//			if (router.ClickonApplybutton()) {
//				if (router.ClickonApplybutton()) {
//					if (router.ClickonOKbutton(70)) {
//						flag = true;
//						Keyword.ReportStep_Pass(testCase, "Settings Applied");
//					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"not able to click on apply button");
//						flag = false;
//					}
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
//				flag = false;
//			}
//		} catch (Exception e) {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Exception Occured due to " + e.getMessage());
//			flag = false;
//		}
//		return flag;
//	}
//
//	public static String PageSource(String screenName) {
//		String pagecontainer = null;
//		switch (screenName) {
//		case "BASIC SETTING":
//			pagecontainer = "This page allows you to define ESSID, and Channel for the wireless connection. These parameters are used for the wireless stations to connect"
//					.toUpperCase();
//
//			break;
//		case "ADVANCE SETTING":
//			pagecontainer = "Set the time zone of the Wireless Router. This information is used for log entries and firewall"
//					.toUpperCase();
//			break;
//		case "SECURITY SETTING":
//			pagecontainer = "This page allows you setup the wireless security. Turn on WEP or WPA by using Encryption Keys could prevent any unauthorized access to your wireless"
//					.toUpperCase();
//			break;
//		default:
//			pagecontainer = "";
//			break;
//		}
//
//		return pagecontainer;
//	}
//
//	public static boolean changeWebPage(TestCases testCase, String baseURL, String requestingPage, String screenName) {
//		WebDriver driver = testCase.getWebDriver();
//
//		try {
//			if (baseURL != null && requestingPage != null) {
//				driver.get(baseURL + requestingPage);
//			}
//			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
//			fWait.withTimeout(Duration.ofSeconds(30));
//			fWait.pollingEvery(Duration.ofSeconds(2));
//			fWait.ignoring(IOException.class);
//
//			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//				public Boolean apply(Boolean input) {
//					try {
//						String pageSource = driver.getPageSource();
//						if (pageSource.toUpperCase().contains(PageSource(screenName))) {
//							return true;
//						} else
//							return false;
//					} catch (Exception e) {
//						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//								"Fluent wait for Downtime Got Exception, Exception is ++>>> " + e.getMessage());
//						return false;
//					}
//				}
//
//			});
//			return isEventReceived;
//		} catch (Exception e) {
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Exception is occured due to " + e.getMessage());
//			return false;
//		}
//
//	}
//
//	public static boolean doRouterSettings(TestCases testCase, String baseURL, String channel, String mode,
//			String encryption, String wpaUniCast, String wep_keyLegth, String wep_keyFormat, String password,
//			String channelWidth, String is_ssidEnable) {
//		boolean flag = false;
////		String screenShouldSave = null;
//		IntellinetRouterScreen intRout = new IntellinetRouterScreen(testCase);
////		if (mode != null || channel != null) {
////			screenShouldSave = "BASIC SETTING";
////		}
////		if (encryption != null || wpaUniCast != null || password != null) {
////			screenShouldSave = "SECURITY SETTING";
////		}
////		if (channelWidth != null || is_ssidEnable != null) {
////			screenShouldSave = "ADVANCE SETTING";
////		}
//
//		if (mode != null || channel != null) {
//			if (changeWebPage(testCase, baseURL, "/wlbasic.asp", "BASIC SETTING")) {
//				if (mode == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
//				} else if (intRout.ChangeMode(mode)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change Mode from Basic settings");
//					flag = false;
//				}
//
//				if (mode == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
//				} else if (intRout.ChangeChannel(channel)) {
//					flag = false;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change channel from Basic settings");
//					flag = false;
//				}
//
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Not able to navogate tot Basic settings for change Channel or Mode vs Band");
//				flag = false;
//			}
//
//			if (flag) {
//				flag = intRout.ClickonApplybutton();
//			}
//
//		}
//
//		if (encryption != null || wpaUniCast != null || password != null || wep_keyLegth != null
//				|| wep_keyFormat != null) {
//			if (changeWebPage(testCase, baseURL, "/wlencrypt.asp", "SECURITY SETTING")) {
//				if (encryption == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
//				} else if (intRout.ChangeSecurity(encryption)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change encryption from security settings");
//					flag = false;
//				}
//
//				if (wpaUniCast == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change wpa unicast cipher suite.");
//				} else if (encryption.contains("WPA") && intRout.changeWPA_suite(wpaUniCast)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change wpa unicast cipher suite from security settings");
//					flag = false;
//				}
//
//				if (wep_keyLegth == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change WEP keylength.");
//				} else if (encryption.contains("WEP") && intRout.ChangeWEP_Keylength(wep_keyLegth)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change WEP Key length from security settings");
//					flag = false;
//				}
//
//				if (wep_keyFormat == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change WEP key format.");
//				} else if (encryption.contains("WEP") && intRout.ChangeWEPFormat(wep_keyFormat)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change WEP key format from security settings");
//					flag = false;
//				}
//
//				if (password == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change password.");
//				} else if (encryption.contains("WPA") && intRout.setValueinWPAPassword(password)) {
//					flag = true;
//				} else if (encryption.contains("WEP") && intRout.setValue_WepPassword(password)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change password from security settings");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Not able to navogate tot security settings for change Channel or Mode vs Band");
//				flag = false;
//			}
//			if (flag) {
//				flag = intRout.ClickonApplybutton();
//			}
//		}
//
//		if (channelWidth != null || is_ssidEnable != null) {
//			if (changeWebPage(testCase, baseURL, "/wladvance.asp", "ADVANCE SETTING")) {
//				if (channelWidth == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
//				} else if (intRout.enable_disableBandwidthCheckBox(channelWidth)) {
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change channelwidth from Advance settings");
//					flag = false;
//				}
//
//				if (is_ssidEnable == null) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
//				} else if (intRout.SSIDEnable_Disable(is_ssidEnable)) {
//					flag = false;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change broadcase SSID from Advance settings");
//					flag = false;
//				}
//
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Not able to navogate tot Basic settings for change Channel or Mode vs Band");
//				flag = false;
//			}
//			if (flag) {
//				flag = intRout.ClickonApplybutton();
//			}
//		}
//
//		if (flag) {
//			if (intRout.ClickonApplybutton()) {
//				if (intRout.ClickonOKbutton(70)) {
//					flag = true;
//					Keyword.ReportStep_Pass(testCase, "Settings Applied");
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
//				flag = false;
//			}
//		}
//		return flag;
//	}
//
//}