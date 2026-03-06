package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.NetGearRouterScreen;

public class NetGearRouterUtils {

	public static String PageSource(String screenName, String RouterModel) {
		String pagecontainer = null;
		switch (RouterModel) {
		case "AC1750":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "R6400v2".toUpperCase();
				break;
			case "WIRELESS SETTING":
				pagecontainer = "Wireless Setup".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "R6250":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "R6250".toUpperCase();
				break;
			case "WIRELESS SETTINGS":
				pagecontainer = "Region Selection".toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "Device Name".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "WNDR3800CH":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "WNDR3800CH".toUpperCase();
				break;
			case "WIRELESS SETTING":
				pagecontainer = "Wireless Setup".toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "LAN Setup".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "R7000":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "Nighthawk R7000".toUpperCase();
				break;
			case "WIRELESS SETTING":
				pagecontainer = "Enable Smart Connect - Let the router intelligently select the best WiFi band 2.4 GHz or 5 GHz"
						.toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "Use Router as DHCP Server".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "RAX10":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "AX1800 WIFI ROUTER RAX10";
				break;
			case "WIRELESS SETTING":
				pagecontainer = "REGION SELECTION";
				break;
			case "DHCP":
				pagecontainer = "LAN SETUP";
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "RBR20":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "ROUTER FIRMWARE VERSION";
				break;
			case "WIRELESS SETTING":
				pagecontainer = "WIRELESS SETTINGS";
				break;
			case "DHCP":
				pagecontainer = "LAN SETUP";
				break;
			case "DNS":
				pagecontainer = "DYNAMIC DNS";
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "WNDR4300V2":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "WNDR4300V2";
				break;
			case "WIRELESS SETTING":
				pagecontainer = "Wireless Setup".toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "LAN Setup".toUpperCase();
				break;
			case "DNS":
				pagecontainer = "DYNAMIC DNS";
				break;
			default:
				pagecontainer = "";
				break;
			}
		default:
			pagecontainer = "";
			break;
		}
		return pagecontainer;
	}

	public static String getRouterSettings_AC1750(String data, String requestParameter) {
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
					} else if (parameterArray[i].contains("60")) {
						requestValue = "60";
					} else if (parameterArray[i].contains("149")) {
						requestValue = "149";
					} else if (parameterArray[i].contains("153")) {
						requestValue = "153";
					} else if (parameterArray[i].contains("157")) {
						requestValue = "157";
					} else if (parameterArray[i].contains("161")) {
						requestValue = "161";
					} else if (parameterArray[i].contains("165")) {
						requestValue = "165";
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

					if (parameterArray[i].toUpperCase().contains("5GHZ")) {

						if (parameterArray[i].contains("AUTO")) {
							requestValue = "Auto";
						} else if (parameterArray[i].contains("BGN")) {
							requestValue = "Up to 289 Mbps";
						} else if (parameterArray[i].contains("N")) {
							requestValue = "Up to 600 Mbps";
						} else if (parameterArray[i].contains("AC")) {
							requestValue = "Up to 1300 Mbps";
						}
					} else {
						if (parameterArray[i].contains("AUTO")) {
							requestValue = "Auto";
						} else if (parameterArray[i].contains("BGN")) {
							requestValue = "Up to 217 Mbps";
						} else if (parameterArray[i].contains("G")) {
							requestValue = "Up to 54 Mbps";
						} else if (parameterArray[i].contains("N")) {
							requestValue = "Up to 450 Mbps";
						}
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
					if (parameterArray[i].contains("NONE".toUpperCase())) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA2 AES".toUpperCase())) {
						requestValue = "WPA2 AES";
					} else if (parameterArray[i].contains("WPA_WPA2 MIXED".toUpperCase())) {
						requestValue = "WPA/WPA2 MIXED";
					}
					break;

				} else if (parameterArray[i].contains("WEPENCRYPTION") && requestParameter.contains("WEPENCRYPTION")) {
					if (parameterArray[i].contains("WEP-64") || parameterArray[i].contains("64")) {
						requestValue = "WEP-64bits";
					} else if (parameterArray[i].contains("WEP-128") || parameterArray[i].contains("128")) {
						requestValue = "WEP-128bits";
					}
					break;

				} else if (parameterArray[i].contains("WEPAUTH") && requestParameter.contains("WEPAUTH")) {
					if (parameterArray[i].contains("automatic".toUpperCase())) {
						requestValue = "Automatic";
					} else if (parameterArray[i].contains("sharedkey".toUpperCase())) {
						requestValue = "Shared Key";
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

	public static String getRouterSettings_R6250_WNDR3800CH_R7000(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("100")) {
						requestValue = "100";
					} else if (parameterArray[i].contains("104")) {
						requestValue = "104";
					} else if (parameterArray[i].contains("108")) {
						requestValue = "108";
					} else if (parameterArray[i].contains("112")) {
						requestValue = "112";
					} else if (parameterArray[i].contains("149")) {
						requestValue = "149";
					} else if (parameterArray[i].contains("153")) {
						requestValue = "153";
					} else if (parameterArray[i].contains("157")) {
						requestValue = "157";
					} else if (parameterArray[i].contains("161")) {
						requestValue = "161";
					} else if (parameterArray[i].contains("36")) {
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
						requestValue = "01";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "02";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "03";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "04";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "05";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "06";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "07";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "08";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "09";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {

					if (parameterArray[i].toUpperCase().contains("5GHZ")) {

						if (parameterArray[i].contains("AUTO")) {
							requestValue = "Auto";
						} else if (parameterArray[i].contains("289")) {
							requestValue = "Up to 289 Mbps";
						} else if (parameterArray[i].contains("600")) {
							requestValue = "Up to 600 Mbps";
						} else if (parameterArray[i].contains("1300")) {
							requestValue = "Up to 1300 Mbps";
						} else if (parameterArray[i].contains("450")) {
							requestValue = "Up to 450 Mbps";
						} else if (parameterArray[i].contains("300")) {
							requestValue = "Up to 300 Mbps";
						} else if (parameterArray[i].contains("130")) {
							requestValue = "Up to 130 Mbps";
						} else if (parameterArray[i].contains("54")) {
							requestValue = "Up to 54 Mbps";
						}
					} else {
						if (parameterArray[i].contains("AUTO")) {
							requestValue = "Auto";
						} else if (parameterArray[i].contains("B_G_N") || parameterArray[i].contains("300")) {
							requestValue = "Up to 300 Mbps";
						} else if (parameterArray[i].contains("G") || parameterArray[i].contains("54")) {
							requestValue = "Up to 54 Mbps";
						} else if (parameterArray[i].contains("N") || parameterArray[i].contains("145")) {
							requestValue = "Up to 145 Mbps";
						} else if (parameterArray[i].contains("289")) {
							requestValue = "Up to 289 Mbps";
						} else if (parameterArray[i].contains("600")) {
							requestValue = "Up to 600 Mbps";
						}
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
					if (parameterArray[i].contains("NONE".toUpperCase())) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA_PSK_TKIP_WPA2_PSK_AES")) {
						requestValue = "WPA_PSK_TKIP_WPA2_PSK_AES";
					} else if (parameterArray[i].contains("WPA_PSK_TKIP")) {
						requestValue = "WPA_PSK_TKIP";
					} else if (parameterArray[i].contains("WPA2_PSK_AES")) {
						requestValue = "WPA2_PSK_AES";
					} else if (parameterArray[i].contains("WPA_WPA2_ENTERPRISE")) {
						requestValue = "WPA_WPA2_ENTERPRISE";
					}
					break;

				} else if (parameterArray[i].contains("WPA ENCRYPTION")
						&& requestParameter.contains("WPA ENCRYPTION")) {
					if (parameterArray[i].contains("WNDR3800CH")) {
						if (parameterArray[i].contains("MIXED") || parameterArray[i].contains("TKIP_AES")) {
							requestValue = "WPA [TKIP] + WPA2 [AES]";
						} else if (parameterArray[i].contains("TKIP")) {
							requestValue = "WPA [TKIP]";
						} else if (parameterArray[i].contains("AES")) {
							requestValue = "WPA2 [AES]";
						}
						break;
					}
					if (parameterArray[i].contains("MIXED") || parameterArray[i].contains("TKIP_AES")) {
						requestValue = "WPA-PSK [TKIP] + WPA2-PSK [AES]";
					} else if (parameterArray[i].contains("TKIP")) {
						requestValue = "WPA-PSK [TKIP]";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "WPA2-PSK [AES]";
					}
					break;

				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("WEP-64") || parameterArray[i].contains("64")) {
						requestValue = "64-bit";
					} else if (parameterArray[i].contains("WEP-128") || parameterArray[i].contains("128")) {
						requestValue = "128-bit";
					}
					break;

				} else if (parameterArray[i].contains("WEP AUTH") && requestParameter.contains("WEP AUTH")) {
					if (parameterArray[i].contains("automatic".toUpperCase())) {
						requestValue = "Automatic";
					} else if (parameterArray[i].contains("SHAREDKEY")
							|| parameterArray[i].contains("SHARED KEY".toUpperCase())) {
						requestValue = "Shared Key";
					}
					break;

				} else if (parameterArray[i].contains("WEP KEY1") && requestParameter.contains("WEP KEY1")) {
					requestValue = parameterArray_Value[i].replace("WEP Key1 is", "").trim();
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
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("INTERVAL") && requestParameter.contains("INTERVAL")) {
					requestValue = parameterArray_Value[i].replace("Key Update Interval is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("Radius IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is", "").trim();
					break;
				} else if (parameterArray[i].contains("INTERVAL") && requestParameter.contains("INTERVAL")) {
					requestValue = parameterArray_Value[i].replace("Key Update Interval is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP START IP") && requestParameter.contains("DHCP START IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP Start IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP END IP") && requestParameter.contains("DHCP END IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP End IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("IS_DNS") && requestParameter.contains("IS_DNS")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("HOST NAME") && requestParameter.contains("HOST NAME")) {
					requestValue = parameterArray_Value[i].replace("HOST NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("DNS EMAIL") && requestParameter.contains("DNS EMAIL")) {
					requestValue = parameterArray_Value[i].replace("DNS EMAIL is", "").trim();
					break;
				} else if (parameterArray[i].contains("DNS_KEY") && requestParameter.contains("DNS_KEY")) {
					requestValue = parameterArray_Value[i].replace("DNS_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("SERVICE") && requestParameter.contains("SERVICE")) {
					if (parameterArray[i].contains("NO")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

	public static boolean applyChangesMade(TestCases testCase) {
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		boolean flag = true;
		if (netgearScreen.clickOnApplyChangesBTN()) {
			Keyword.ReportStep_Pass(testCase, "Successfully Applied the changes");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "unable to apply changes");
		}
		return flag;
	}

	public static boolean changeWebPage(TestCases testCase, String baseURL, String requestingPage, String screenName,
			String RouterModel) {
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
						if (pageSource.toUpperCase().contains(PageSource(screenName, RouterModel))) {
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

	public static boolean checkPageLoadingComplete(TestCases testCase) {
		Boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
			fwait.pollingEvery(Duration.ofSeconds(1));
			fwait.withTimeout(Duration.ofSeconds(60));
			fwait.ignoring(Exception.class);
			Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (netgearScreen.isPageLoading()) {
						System.out.println("Page loading");
						Keyword.ReportStep_Pass(testCase, "Page is loading");
						return false;
					} else {
						return true;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase, "Page load completed");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Page is not loaded properly after waiting for 60 Sec");
				flag = false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Page is not loaded properly after waiting for 60 Sec");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occurred Page Load due to " + e.getMessage());
			flag = false;
		}
		return flag;

	}

	public static boolean _AC1750_Model_chaneRouterSettings(TestCases testCase, String screename, String frequency,
			String channel, String mode, String security, String password, String ssid_name, String is_ssid,
			String is_dhcp, String WEPAuth, String WEPencrpytion) {
		boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			if (checkPageLoadingComplete(testCase)) {
				if (screename.contains("WIRELESS SETTINGS")) {
					if (netgearScreen.clickOnBasicTab()) {
						if (netgearScreen.clickOnBasicWirelessBTN()) {
							flag = netgearScreen.switchToBodyContentFrame();
							if (frequency == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
							}
							if (security == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change security.");
							} else {
								if (frequency.toUpperCase().contains("2.4")) {
									if (security.toUpperCase().contains("NONE")) {
										if (netgearScreen.clickOnNoneSecurity2G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "NONE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as none");
										}
									} else if (security.toUpperCase().contains("WEP")) {
										if (netgearScreen.clickOnWEPSecurity2G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WEP", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wep");
										}
									} else if (security.toUpperCase().contains("WPA2 AES")) {
										if (netgearScreen.clickOnAESSecurity2G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 AES", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 AES");
										}
									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED")) {
										if (netgearScreen.clickOnWpaWpa2MixedSecurity2G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA_WPA2 MIXED", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wpa wpa2 mixed");
										}

										if (WEPAuth == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change WEPencrpytion.");
										} else if ((security.contains("WEP"))
												&& netgearScreen.changeWEPAuthenctication(WEPAuth)) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, null, WEPAuth);
											Keyword.ReportStep_Pass(testCase, "Change WEPencrpytion to " + WEPAuth);
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Not able to change WEP ");
											flag = false;
										}

										if (WEPencrpytion == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change WEPencrpytion.");
										} else if ((security.contains("WEP"))
												&& netgearScreen.changeWEPEncryption(WEPencrpytion)) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, null, WEPencrpytion);
											Keyword.ReportStep_Pass(testCase,
													"Change WEPencrpytion to " + WEPencrpytion);
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Not able to change WEP ");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"NetGear router with this model doesn't support " + security
														+ " Security option");
										flag = flag && netgearScreen.switchToDefaultFrame();
										return false;
									}
								} else if (frequency.toUpperCase().contains("5")) {
									if (security.toUpperCase().contains("NONE")) {
										if (netgearScreen.clickOnNoneSecurity5G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "NONE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as none");
										}
									} else if (security.toUpperCase().contains("WPA2 AES")) {
										if (netgearScreen.clickOnAESSecurity5G()) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 AES", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 AES");
										}
									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED")) {
										if (netgearScreen.clickOnWpaWpa2MixedSecurity5G()) {
											if (netgearScreen.clickOnMixedAlertOKSecurity5G()) {
												flag = true;
												WebController.changeWifiSSID_Password(null, null, "WPA_WPA2 MIXED",
														null);
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set security as WPA2 AES");
											}
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 AES");
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"NetGear router with this model doesn't support " + security
														+ " Security option");
										flag = flag && netgearScreen.switchToDefaultFrame();
										return false;
									}
								}
							}

							if (channel == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change channel.");
							} else if (frequency.contains("2.4") && netgearScreen.select2GChannelNumber(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
							} else if (frequency.contains("5") && netgearScreen.select5GChannelNumber(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change channel in Wireless Setting");
								flag = false;
							}
							if (mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
							} else if (frequency.contains("2.4") && netgearScreen.select2GModeType(mode)) {
								if (netgearScreen.isWpaWpa2MixedSecurity5G()) {
									netgearScreen.clickOnWpaWpa2MixedSecurity5G();
								}
								if (netgearScreen.clickOnMixedAlertOKSecurity5G()) {
									flag = true;
								}
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
							} else if (frequency.contains("5") && netgearScreen.select5GModeType(mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Mode in Wireless Setting");
								flag = false;
							}

							if (is_ssid == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
							} else if (frequency.toUpperCase().contains("2.4GHZ")) {
								if (is_ssid.contains("YES") && !netgearScreen.isBroadCastSSID2GEnabled()) {
									flag = flag && netgearScreen.clickOnBroadCastSSID2G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
								} else if (is_ssid.contains("NO") && netgearScreen.isBroadCastSSID2GEnabled()) {
									flag = flag && netgearScreen.clickOnBroadCastSSID2G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
								} else if (is_ssid.contains("YES") && netgearScreen.isBroadCastSSID2GEnabled()) {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already enabled for 2.4 GHZ band");
								} else {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already disabled for 2.4 GHZ band");
								}
							} else if (frequency.toUpperCase().contains("5GHZ")) {
								if (is_ssid.contains("YES") && !netgearScreen.isBroadCastSSID5GEnabled()) {
									flag = flag && netgearScreen.clickOnBroadCastSSID5G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 5 GHZ band");
								} else if (is_ssid.contains("NO") && netgearScreen.isBroadCastSSID5GEnabled()) {
									flag = flag && netgearScreen.clickOnBroadCastSSID5G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 5 GHZ band");
								} else if (is_ssid.contains("YES") && netgearScreen.isBroadCastSSID5GEnabled()) {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already enabled for 5 GHZ band");
								} else {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already disabled for 5 GHZ band");
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Please provide valid frequency band");
								flag = false;
							}
							if (password == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change password.");
							} else if (frequency.contains("2.4") && security.contains("WPA")
									&& netgearScreen.setValueinPassword24(password)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
							} else if (frequency.contains("5") && netgearScreen.setValueinPassword5(password)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "Change password to " + password);
							} else if (frequency.contains("2.4") && security.contains("WEP")
									&& netgearScreen.setValueinWEP1PasswordTB(password)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change password from security settings");
								flag = false;
							}
							if (ssid_name == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to ssid_name password.");
							} else if (frequency.contains("2.4") && netgearScreen.setvalueinSSID24(ssid_name)) {
								flag = true;
								WebController.changeWifiSSID_Password(ssid_name, null, null, null);
							} else if (frequency.contains("5") && netgearScreen.setvalueinSSID5(ssid_name)) {
								flag = true;
								WebController.changeWifiSSID_Password(ssid_name, null, null, null);
								Keyword.ReportStep_Pass(testCase, "Change ssid_name to " + ssid_name);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change ssid_name from security settings");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to naviagate to Basic setting page in router.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to naviagate to Wireless setting tab in router.");
						flag = false;
					}
				} else {
					if (screename.contains("DHCP")) {
						if (netgearScreen.clickOnAdvanceTab()) {
							if (netgearScreen.clickOnAdvSetupBT()) {
								if (netgearScreen.clickOnAdvLANSetupBT()) {
									if (is_dhcp == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
									} else if (netgearScreen.enable_disable_DHCP(is_dhcp)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change DHCP enable disable setting");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to naviagate to adv LAN setting tab tab in router.");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to naviagate to adv setting tab tab in router.");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to naviagate to adv setting in router.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to naviagate to DHCP setting tab in router.");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to naviagate to load page in router.");
				flag = false;
			}
			if (flag) {
				if (applyChangesMade(testCase)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Settings Applied");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
					flag = false;
				}
			}
			flag = flag && netgearScreen.switchToDefaultFrame();
			return flag;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode _AC1750_Model_chaneRouterSecuritySettings(String securityType_request) {
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
		if (security_Type.contains("NONE")) {
			securityType = WifiSecurityMode.NONE;
		} else if (security_Type.contains("WEP")) {
			if (security_Type.contains("SHARED")) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else {
				securityType = WifiSecurityMode.WEP_PSK;
			}
		} else if (security_Type.contains("WPA2 AES")) {
			if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			}
		} else if (security_Type.contains("WPA_WPA2 MIXED") || security_Type.contains("WPA/WPA2 MIXED")) {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}

		return securityType;
	}

	public static boolean changeRouterSettingsInNetgear(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "AC1750":
				/*
				 * String screename,, String frequency, String channel, String mode, String
				 * security, String password, String ssid_name, String is_ssid, String is_dhcp *
				 * WEPAuth, String WEPencrpytion
				 */
//				String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _AC1750_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings_AC1750(dataOptions, "FREQUENCY"),
						getRouterSettings_AC1750(dataOptions, "CHANNEL"), getRouterSettings_AC1750(dataOptions, "MODE"),
						getRouterSettings_AC1750(dataOptions, "SECURITY"),
						getRouterSettings_AC1750(dataOptions, "PASSWORD"),
						getRouterSettings_AC1750(dataOptions, "SSID NAME"),
						getRouterSettings_AC1750(dataOptions, "IS SSID"),
						getRouterSettings_AC1750(dataOptions, "IS DHCP"),
						getRouterSettings_AC1750(dataOptions, "WEPAUTH"),
						getRouterSettings_AC1750(dataOptions, "WEPENCRYPTION"));

				if (flag) {
					String security = getRouterSettings_AC1750(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "R6250":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _R6250_Model_chaneRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "FREQUENCY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "CHANNEL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "MODE"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "PASSWORD"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SSID NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS SSID"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS DHCP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP AUTH"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "INTERVAL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS PORT"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WPA ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP START IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP END IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS_DNS"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "HOST NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS EMAIL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS_KEY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SERVICE"));

				if (flag) {
					String security = getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;

			case "WNDR3800CH":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _WNDR3800CH_Model_changeRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "FREQUENCY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "CHANNEL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "MODE"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "PASSWORD"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SSID NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS SSID"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS DHCP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP AUTH"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "INTERVAL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS PORT"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WPA ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP START IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP END IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP KEY1"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS_DNS"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "HOST NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS EMAIL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS_KEY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SERVICE"));

				if (flag) {
					String security = getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "R7000":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _R7000_Model_changeRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "FREQUENCY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "CHANNEL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "MODE"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "PASSWORD"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SSID NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS SSID"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS DHCP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP AUTH"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "INTERVAL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS PORT"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WPA ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP START IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP END IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP KEY1"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS_DNS"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "HOST NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS EMAIL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS_KEY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SERVICE"));

				if (flag) {
					String security = getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "RAX10":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _RAX10_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings_RAX10(dataOptions, "FREQUENCY"),
						getRouterSettings_RAX10(dataOptions, "CHANNEL"), getRouterSettings_RAX10(dataOptions, "MODE"),
						getRouterSettings_RAX10(dataOptions, "SECURITY"),
						getRouterSettings_RAX10(dataOptions, "IS SSID"),
						getRouterSettings_RAX10(dataOptions, "SSID NAME"),
						getRouterSettings_RAX10(dataOptions, "PASSWORD"),
						getRouterSettings_RAX10(dataOptions, "WPA_M0DE"),
						getRouterSettings_RAX10(dataOptions, "RADIUS_PORT"),
						getRouterSettings_RAX10(dataOptions, "RADIUS IP"),
						getRouterSettings_RAX10(dataOptions, "RADIUS_SHARED_KEY"),
						getRouterSettings_RAX10(dataOptions, "IS DHCP"),
						getRouterSettings_RAX10(dataOptions, "START IP"),
						getRouterSettings_RAX10(dataOptions, "END IP"),
						getRouterSettings_RAX10(dataOptions, "LEASE TIME"));

				if (flag) {
					String security = getRouterSettings_AC1750(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(_AC1750_Model_chaneRouterSecuritySettings(null));
						}
					}
				}

				break;
			case "WNDR4300V2":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, null, null, "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _WNDR3800CH_Model_changeRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "FREQUENCY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "CHANNEL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "MODE"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "PASSWORD"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SSID NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS SSID"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS DHCP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP AUTH"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "INTERVAL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "RADIUS PORT"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WPA ENCRYPTION"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP START IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DHCP END IP"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "WEP KEY1"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "IS_DNS"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "HOST NAME"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS EMAIL"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "DNS_KEY"),
						getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SERVICE"));
				if (flag) {
					String security = getRouterSettings_R6250_WNDR3800CH_R7000(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "RBR20":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/adv_index.htm", "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _RBR20_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings_RBR20(dataOptions, "FREQUENCY"),
						getRouterSettings_RBR20(dataOptions, "CHANNEL"),
						getRouterSettings_RBR20(dataOptions, "SECURITY"),
						getRouterSettings_RBR20(dataOptions, "SSID NAME"),
						getRouterSettings_RBR20(dataOptions, "PASSWORD"),
						getRouterSettings_RBR20(dataOptions, "IS DHCP"),
						getRouterSettings_RBR20(dataOptions, "START IP"),
						getRouterSettings_RBR20(dataOptions, "END IP"), getRouterSettings_RBR20(dataOptions, "IS DNS"),
						getRouterSettings_RBR20(dataOptions, "HOST NAME"),
						getRouterSettings_RBR20(dataOptions, "DNS EMAIL"),
						getRouterSettings_RBR20(dataOptions, "DNS_KEY"));

				if (flag) {
					String security = getRouterSettings_AC1750(dataOptions, "SECURITY");
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

	public static String getRouterSettings_RAX10(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("128")) {
						requestValue = "128(DFS)";
					} else if (parameterArray[i].contains("124")) {
						requestValue = "124(DFS)";
					} else if (parameterArray[i].contains("120")) {
						requestValue = "120(DFS)";
					} else if (parameterArray[i].contains("116")) {
						requestValue = "116(DFS)";
					} else if (parameterArray[i].contains("112")) {
						requestValue = "112(DFS)";
					} else if (parameterArray[i].contains("108")) {
						requestValue = "108(DFS)";
					} else if (parameterArray[i].contains("104")) {
						requestValue = "104(DFS)";
					} else if (parameterArray[i].contains("100")) {
						requestValue = "100(DFS)";
					} else if (parameterArray[i].contains("64")) {
						requestValue = "64(DFS)";
					} else if (parameterArray[i].contains("60")) {
						requestValue = "60(DFS)";
					} else if (parameterArray[i].contains("56")) {
						requestValue = "56(DFS)";
					} else if (parameterArray[i].contains("52")) {
						requestValue = "52(DFS)";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40";
					} else if (parameterArray[i].contains("36")) {
						requestValue = "36";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12";
					} else if (parameterArray[i].contains("13")) {
						requestValue = "13";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "01";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "02";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "03";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "04";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "05";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "06";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "07";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "08";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "09";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].toUpperCase().contains("5GHZ")) {
						if (parameterArray[i].contains("573")) {
							requestValue = "Up to 573 Mbps";
						} else if (parameterArray[i].contains("286")) {
							requestValue = "Up to 286 Mbps";
						} else if (parameterArray[i].contains("1200")) {
							requestValue = "Up to 1200 Mbps";
						}
					} else {
						if (parameterArray[i].contains("54")) {
							requestValue = "Up to 54 Mbps";
						} else if (parameterArray[i].contains("286")) {
							requestValue = "Up to 286 Mbps";
						} else if (parameterArray[i].contains("600")) {
							requestValue = "Up to 600 Mbps";
						}

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
					requestValue = parameterArray_Value[i].replace("PASSWORD is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("NONE")) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA2-Personal [AES]";
					} else if (parameterArray[i].contains("WPA_PERSONAL")
							|| parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA-Personal [TKIP] + WPA2-Personal [AES]";
					} else if (parameterArray[i].contains("WPA_WPA2_ENTERPRISE")) {
						requestValue = "WPA/WPA2 Enterprise";
					} else if (parameterArray[i].contains("WPA3_PERSONAL")) {
						requestValue = "WPA3-Personal";
					}
					break;
				} else if (parameterArray[i].contains("WPA_M0DE") && requestParameter.contains("WPA_M0DE")) {
					if (parameterArray[i].contains("WPA2_AES")) {
						requestValue = "WPA2 [AES]";
					} else if (parameterArray[i].contains("WPA_WPA2")) {
						requestValue = "WPA [TKIP] + WPA2 [AES]";
					}
					break;
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("RADIUS IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_PORT") && requestParameter.contains("RADIUS_PORT")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_PORT is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_SHARED_KEY")
						&& requestParameter.contains("RADIUS_SHARED_KEY")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_SHARED_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("START IP") && requestParameter.contains("START IP")) {
					requestValue = parameterArray_Value[i].replace("START IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("END IP") && requestParameter.contains("END IP")) {
					requestValue = parameterArray_Value[i].replace("END IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("LEASE TIME is", "").trim();
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
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
				}
			}
		}
		return requestValue;
	}

	private static boolean _RAX10_Model_chaneRouterSettings(TestCases testCase, String screenName, String frequency,
			String channel, String mode, String security, String is_ssid, String ssid_name, String password,
			String wpa_mode, String radius_port, String radius_ip, String radius_shared_key, String is_dhcp,
			String start_ip, String end_ip, String lease_time) {
		boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
			flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToTopFrame();
			flag = flag && netgearScreen.clickOnSetupInAdvanceSetup_WNDR3800CH_R7000();
			if (flag && screenName.contains("DHCP")) {
				if (netgearScreen.clickLanSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change is_dhcp Enable disable setting.");
					} else if (netgearScreen.enable_disable_dhcp_RAX10(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dhcp Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_dhcp enable disable setting");
						flag = false;
					}

					if (start_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (netgearScreen.setDHCPStartIP_R6250_WNDR3800CH_R7000(start_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpStartIPAdd Enable setting is changed to " + start_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpStartIPAdd");
						flag = false;
					}
					if (end_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpEndIPAdd.");
					} else if (netgearScreen.setDHCPEndIP_R6250_WNDR3800CH_R7000(end_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpEndIPAdd setting is changed to " + end_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpEndIPAdd");
						flag = false;
					}
					if (lease_time == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Lease Time.");
					} else if (netgearScreen.setLeaseTime_RAX10(lease_time)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Lease Time setting is changed to " + lease_time);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Lease time");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else if (flag && screenName.contains("WIRELESS")) {
				if (netgearScreen.clickOnWirelessSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4") && netgearScreen.enableDisableSSID2G_R6250(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else if (frequency.contains("5") && netgearScreen.enableDisableSSID2G_R6250(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change SSID enable disable setting");
						flag = false;
					}

					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.setSSIDName2G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else if (frequency.contains("5")
							&& netgearScreen.setSSIDName5G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Name ");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.selectChannel2G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else if (frequency.contains("5")
							&& netgearScreen.selectChannel5G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}

					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (frequency.contains("2.4") && netgearScreen.selectMode2G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else if (frequency.contains("5") && netgearScreen.selectMode5G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}
					flag = flag && netgearScreen.switchToDefaultFrame();
					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security in setting.");
					} else if (frequency.contains("5")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity5G_RAX10(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("Enterprise"))
								&& netgearScreen.selectSecurity5G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (wpa_mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WPA MODE in setting.");
							} else if (netgearScreen.select_WPA_Mode_5G_RAX10(wpa_mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + wpa_mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA MODE in 5G");
								flag = false;
							}
							if (radius_ip == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Radius ip in setting.");
							} else if (netgearScreen.setRadiusIP5G_R6250(radius_ip)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + radius_ip);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP in 5G");
								flag = false;
							}
							if (radius_port == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort5G_RAX10(radius_port)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + radius_port);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (radius_shared_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusSharedKey5G_RAX10(radius_shared_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"Radius Shared key is changed to " + radius_shared_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Radius Shared Key ");
								flag = false;
							}
						} else if ((security.contains("WPA2")) && netgearScreen.selectSecurity5G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "WPA2 password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA2 password ");
								flag = false;
							}
						} else if ((security.contains("WPA3")) && netgearScreen.selectSecurity5G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "WPA3 password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA3 password 5G");
								flag = false;
							}
						} else if ((security.contains("TKIP")
								|| (security.contains("AES")) && netgearScreen.selectSecurity5G_RAX10(security))) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "TKIP & AES password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change TKIP & AES password ");
								flag = false;
							}
						}
					} else if (frequency.contains("2.4")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity2G_RAX10(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("Enterprise"))
								&& netgearScreen.selectSecurity2G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (wpa_mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WPA MODE in setting.");
							} else if (netgearScreen.select_WPA_Mode_RAX10(wpa_mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + wpa_mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA MODE");
								flag = false;
							}
							if (radius_ip == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Radius ip in setting.");
							} else if (netgearScreen.setRadiusIP2G_R6250(radius_ip)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + radius_ip);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP ");
								flag = false;
							}
							if (radius_port == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort2G_RAX10(radius_port)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + radius_port);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (radius_shared_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusSharedKey2G_RAX10(radius_shared_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"Radius Shared key is changed to " + radius_shared_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Radius Shared Key ");
								flag = false;
							}
						} else if ((security.contains("WPA2")) && netgearScreen.selectSecurity2G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "WPA2 password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA2 password ");
								flag = false;
							}
						} else if ((security.contains("WPA3")) && netgearScreen.selectSecurity2G_RAX10(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "WPA3 password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA3 password ");
								flag = false;
							}
						} else if ((security.contains("TKIP")
								|| (security.contains("AES")) && netgearScreen.selectSecurity2G_RAX10(security))) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Security changed to " + security);
								Keyword.ReportStep_Pass(testCase, "TKIP & AES password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change TKIP & AES password ");
								flag = false;
							}
						}
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to naviagate to Wireless setting page in router.");
				flag = false;
			}
			flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
			if (flag) {
				if (netgearScreen.ClickOnSaveBtn_handleAlert(screenName)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Apply Button");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Apply Button");
					flag = false;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean _R6250_Model_chaneRouterSettings(TestCases testCase, String screename, String baseurl,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String WEPAuth, String Encrpytion, String WPAEnterpriseInterval,
			String RadiusIP, String RadiusPort, String WPAEncrpytion, String DhcpStartIPAdd, String DhcpEndIPAdd,
			String is_dns, String host_name, String email, String passkey, String service) {
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);

		boolean flag = false;
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
			if (checkPageLoadingComplete(testCase)) {
				if (screename.contains("WIRELESS SETTINGS")) {
					if (changeWebPage(testCase, "http://" + baseurl, "/WLG_wireless_dual_band_r10.htm",
							"WIRELESS SETTINGS", routerModel)) {
						flag = netgearScreen.selectRegion("United States");
						if (frequency.contains("2.4")) {
							if (is_ssid == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change SSID Enable disable setting.");
							} else if (netgearScreen.enableDisableSSID2G_R6250(is_ssid)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change SSID enable disable setting");
								flag = false;
							}
							if (ssid_name == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change SSID name setting.");
							} else if (netgearScreen.setSSIDName2G_R6250_WNDR3800CH_R7000(ssid_name)) {
								flag = true;
								WebController.changeWifiSSID_Password(ssid_name, null, null, null);
								Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change SSID Name ");
								flag = false;
							}
							if (channel == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change channel in setting.");
							} else if (netgearScreen.selectChannel2G_R6250_WNDR3800CH_R7000(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "channel is changed to " + channel);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change channel ");
								flag = false;
							}
							if (mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change mode in setting.");
							} else if (netgearScreen.selectMode2G_R6250_WNDR3800CH_R7000(mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "mode is changed to " + mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change mode ");
								flag = false;
							}
							if (security == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change security in setting.");
							} else {
								if (security.contains("NONE") && netgearScreen.selectSecurity2G_R6250(security)) {
									flag = true;
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
								} else if (security.contains("WEP") && netgearScreen.selectSecurity2G_R6250(security)) {
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									if (WEPAuth == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change WEPAuth in setting.");
									} else if (netgearScreen.selectWEPAuth2G_R6250_WNDR3800CH_R7000(WEPAuth)) {
										flag = true;
										WebController.changeWifiSSID_Password(null, null, null, WEPAuth.toUpperCase());
										Keyword.ReportStep_Pass(testCase, "WEPAuth is changed to " + WEPAuth);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change modeWEPAuth ");
										flag = false;
									}
									if (Encrpytion == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
									} else if (netgearScreen.selecWEPencrpytion2G_R6250_WNDR3800CH_R7000(Encrpytion)) {
										flag = true;

										Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change Encrpytion ");
										flag = false;
									}
									if (password == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
									} else if (netgearScreen.setWEPPassword2G_R6250(password)) {
										if (netgearScreen.clickOnGenerateBtn()) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "WEP password is changed to " + password);
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Not able to click on Generate ");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WEP password ");
										flag = false;
									}
								} else if ((security.contains("TKIP") || security.contains("AES"))
										&& netgearScreen.selectSecurity2G_R6250(security)) {
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									if (password == null) {
										flag = true;
										WebController.changeWifiSSID_Password(null, password, null, null);
										Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
									} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WPA password ");
										flag = false;
									}
								} else if ((security.contains("ENTERPRISE"))
										&& netgearScreen.selectSecurity2G_R6250(security)) {
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									if (WPAEncrpytion == null) {
										flag = true;
										WebController.changeWifiSSID_Password(null, null, null,
												WPAEncrpytion.toUpperCase());
										Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
									} else if (netgearScreen.selecWPAencrpytion2G_R6250(WPAEncrpytion)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + WPAEncrpytion);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WPAEncrpytion ");
										flag = false;
									}
									if (WPAEnterpriseInterval == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"No need to change WPAEnterpriseInterval in setting.");
									} else if (netgearScreen
											.setWPAEnterpriseInterval2G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WPAEnterpriseInterval ");
										flag = false;
									}
									if (RadiusIP == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"No need to change WPAEnterpriseInterval in setting.");
									} else if (netgearScreen.setRadiusIP2G_R6250(RadiusIP)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change RadiusIP ");
										flag = false;
									}
									if (RadiusPort == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
									} else if (netgearScreen.setRadiusPort2G_R6250(RadiusPort)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change RadiusPort ");
										flag = false;
									}
								}
							}
						} else {
							if (is_ssid == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change SSID Enable disable setting.");
							} else if (netgearScreen.enableDisableSSID5G_R6250_WNDR3800CH_R7000(is_ssid)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change SSID enable disable setting");
								flag = false;
							}
							if (ssid_name == null) {
								flag = true;
								WebController.changeWifiSSID_Password(ssid_name, null, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change SSID name setting.");
							} else if (netgearScreen.setSSIDName5G_R6250_WNDR3800CH_R7000(ssid_name)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change SSID Name ");
								flag = false;
							}
							if (channel == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change channel in setting.");
							} else if (netgearScreen.selectChannel5G_R6250_WNDR3800CH_R7000(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "channel is changed to " + channel);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change channel ");
								flag = false;
							}
							if (mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change mode in setting.");
							} else if (netgearScreen.selectMode5G_R6250_WNDR3800CH_R7000(mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "mode is changed to " + mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change mode ");
								flag = false;
							}
							if (security == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change security in setting.");
							} else {
								if (security.contains("NONE") && netgearScreen.selectSecurity5G_R6250(security)) {
									flag = true;
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
								} else if ((security.contains("TKIP") || security.contains("AES"))
										&& netgearScreen.selectSecurity5G_R6250(security)) {
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									if (password == null) {
										flag = true;
										WebController.changeWifiSSID_Password(null, password, null, null);
										Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
									} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WPA password ");
										flag = false;
									}
								} else if ((security.contains("ENTERPRISE"))
										&& netgearScreen.selectSecurity5G_R6250(security)) {
									WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
									if (Encrpytion == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
									} else if (netgearScreen.selecWPAencrpytion5G_R6250(Encrpytion)) {
										flag = true;
										WebController.changeWifiSSID_Password(null, null, null,
												Encrpytion.toUpperCase());
										Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change Encrpytion ");
										flag = false;
									}
									if (WPAEnterpriseInterval == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"No need to change WPAEnterpriseInterval in setting.");
									} else if (netgearScreen
											.setWPAEnterpriseInterval5G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change WPAEnterpriseInterval ");
										flag = false;
									}
									if (RadiusIP == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase,
												"No need to change WPAEnterpriseInterval in setting.");
									} else if (netgearScreen.setRadiusIP5G_R6250(RadiusIP)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change RadiusIP ");
										flag = false;
									}
									if (RadiusPort == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
									} else if (netgearScreen.setRadiusPort5G_R6250(RadiusPort)) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to change RadiusPort ");
										flag = false;
									}
								}
							}
						}
					}
				} else if (changeWebPage(testCase, "http://" + baseurl, "/LAN_lan.htm", "DHCP", routerModel)) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change is_dhcp Enable disable setting.");
					} else if (netgearScreen.enableDisableis_dhcp_R6250_WNDR3800CH_R7000(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dhcp Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_dhcp enable disable setting");
						flag = false;
					}
					if (DhcpStartIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (netgearScreen.setDHCPStartIP_R6250_WNDR3800CH_R7000(DhcpStartIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"DhcpStartIPAdd Enable setting is changed to " + DhcpStartIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpStartIPAdd");
						flag = false;
					}
					if (DhcpEndIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpEndIPAdd.");
					} else if (netgearScreen.setDHCPEndIP_R6250_WNDR3800CH_R7000(DhcpEndIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpEndIPAdd setting is changed to " + DhcpEndIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpEndIPAdd");
						flag = false;
					}
				}
				if (flag) {
					if (netgearScreen.ClickOnSaveBtn_handleAlert(screename)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on Apply Button");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Apply Button");
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean _WNDR3800CH_Model_changeRouterSettings(TestCases testCase, String screenName, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String WEPAuth, String Encrpytion, String WPAEnterpriseInterval,
			String RadiusIP, String RadiusPort, String WPAEncrpytion, String DhcpStartIPAdd, String DhcpEndIPAdd,
			String WEPKey1, String is_dns, String host_name, String email, String passkey, String service) {
		boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
			flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToTopFrame();
			flag = flag && netgearScreen.clickOnSetupInAdvanceSetup_WNDR3800CH_R7000();
			if (flag && screenName.contains("DHCP")) {
				if (netgearScreen.clickLanSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change is_dhcp Enable disable setting.");
					} else if (netgearScreen.enableDisableis_dhcp_R6250_WNDR3800CH_R7000(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dhcp Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_dhcp enable disable setting");
						flag = false;
					}
					if (DhcpStartIPAdd != null || DhcpEndIPAdd != null) {
						String ipAdd = DhcpStartIPAdd == null ? DhcpEndIPAdd : DhcpStartIPAdd;
						flag = netgearScreen.setIPAdrees_R6250_WNDR3800CH_R7000(ipAdd);
						Keyword.ReportStep_Pass(testCase,
								"Changed thr IP Adrees according to the Starting IP Address or Ending IP Address");
					} else {
						Keyword.ReportStep_Pass(testCase, "Failed to change the IP Address");
						flag = true;
					}

					if (DhcpStartIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (netgearScreen.setDHCPStartIP_R6250_WNDR3800CH_R7000(DhcpStartIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"DhcpStartIPAdd Enable setting is changed to " + DhcpStartIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpStartIPAdd");
						flag = false;
					}
					if (DhcpEndIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpEndIPAdd.");
					} else if (netgearScreen.setDHCPEndIP_R6250_WNDR3800CH_R7000(DhcpEndIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpEndIPAdd setting is changed to " + DhcpEndIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpEndIPAdd");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else if (flag && screenName.contains("WIRELESS")) {
				if (netgearScreen.clickOnWirelessSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();

					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.enableDisableSSID2G_WNDR3800CH_R7000(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else if (frequency.contains("5")
							&& netgearScreen.enableDisableSSID5G_R6250_WNDR3800CH_R7000(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change SSID enable disable setting");
						flag = false;
					}

					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.setSSIDName2G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else if (frequency.contains("5")
							&& netgearScreen.setSSIDName5G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Name ");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.selectChannel2G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else if (frequency.contains("5")
							&& netgearScreen.selectChannel5G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}

					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (frequency.contains("2.4") && netgearScreen.selectMode2G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else if (frequency.contains("5") && netgearScreen.selectMode5G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}
					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security in setting.");
					} else if (frequency.contains("2.4")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("TKIP") || security.contains("AES"))
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						} else if (security.contains("WEP")
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WEPAuth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPAuth in setting.");
							} else if (netgearScreen.selectWEPAuth2G_R6250_WNDR3800CH_R7000(WEPAuth)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WEPAuth.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "WEPAuth is changed to " + WEPAuth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change modeWEPAuth ");
								flag = false;
							}
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWEPencrpytion2G_R6250_WNDR3800CH_R7000(Encrpytion)) {
								flag = true;

								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WEPKey1 == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEP Key1 in setting.");
							} else if (netgearScreen.setWEPKey12G_R6250_WNDR3800CH_R7000(WEPKey1)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WEP Key is changed to " + WEPKey1);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEP password ");
								flag = false;
							}
						} else if ((security.contains("ENTERPRISE"))
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WPAEncrpytion == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WPAEncrpytion.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWPAencrpytion2G_WNDR3800CH_R7000(WPAEncrpytion)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + WPAEncrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEncrpytion ");
								flag = false;
							}
							if (WPAEnterpriseInterval == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen
									.setWPAEnterpriseInterval2G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEnterpriseInterval ");
								flag = false;
							}
							if (RadiusIP == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen.setRadiusIP2G_WNDR3800CH_R7000(RadiusIP)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP ");
								flag = false;
							}
							if (RadiusPort == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort2G_WNDR3800CH_R7000(RadiusPort)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPA Enterprise Shared secret key in setting.");
							} else if (netgearScreen.setWPAEnterprisePassword2G_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPA/WPA2 Enterprise Share secret key is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						}
					} else if (frequency.contains("5")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("TKIP") || security.contains("AES"))
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						} else if (security.contains("WEP")
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WEPAuth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPAuth in setting.");
							} else if (netgearScreen.selectWEPAuth5G_R6250(WEPAuth)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WEPAuth.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "WEPAuth is changed to " + WEPAuth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change modeWEPAuth ");
								flag = false;
							}
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWEPencrpytion5G_R6250(Encrpytion)) {
								flag = true;

								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WEPKey1 == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWEPKey15G_R6250(WEPKey1)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WEP password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEP password ");
								flag = false;
							}
						} else if ((security.contains("ENTERPRISE"))
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWPAencrpytion5G_WNDR3800CH_R7000(Encrpytion)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, Encrpytion.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WPAEnterpriseInterval == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen
									.setWPAEnterpriseInterval5G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEnterpriseInterval ");
								flag = false;
							}
							if (RadiusIP == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen.setRadiusIP5G_WNDR3800CH_R7000(RadiusIP)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP ");
								flag = false;
							}
							if (RadiusPort == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort5G_WNDR3800CH_R7000(RadiusPort)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPA Enterprise Shared secret key in setting.");
							} else if (netgearScreen.setWPAEnterprisePassword5G_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPA/WPA2 Enterprise Share secret key is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						}
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (flag) {
				netgearScreen.isElemetPresent(5);
				if (netgearScreen.ClickOnSaveBtn_handleAlert(screenName)) {
					netgearScreen.isElemetPresent(5);
					flag = netgearScreen.ClickOnSaveBtn_handleAlert(screenName);
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Apply Button");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Apply Button");
					flag = false;
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean _R7000_Model_changeRouterSettings(TestCases testCase, String screenName, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String WEPAuth, String Encrpytion, String WPAEnterpriseInterval,
			String RadiusIP, String RadiusPort, String WPAEncrpytion, String DhcpStartIPAdd, String DhcpEndIPAdd,
			String WEPKey1, String is_dns, String host_name, String email, String passkey, String service) {
		boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();
			flag = flag && netgearScreen.switchToDefaultFrame();
			flag = flag && netgearScreen.clickOnSetupInAdvanceSetup_WNDR3800CH_R7000();
			if (flag && screenName.contains("DHCP")) {
				if (netgearScreen.clickLanSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToPage2Frame();
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change is_dhcp Enable disable setting.");
					} else if (netgearScreen.enableDisableis_dhcp_R6250_WNDR3800CH_R7000(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dhcp Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_dhcp enable disable setting");
						flag = false;
					}
					if (DhcpStartIPAdd != null || DhcpEndIPAdd != null) {
						String ipAdd = DhcpStartIPAdd == null ? DhcpEndIPAdd : DhcpStartIPAdd;
						flag = netgearScreen.setIPAdrees_R6250_WNDR3800CH_R7000(ipAdd);
						Keyword.ReportStep_Pass(testCase,
								"Changed thr IP Adrees according to the Starting IP Address or Ending IP Address");
					} else {
						Keyword.ReportStep_Pass(testCase, "Failed to change the IP Address");
						flag = true;
					}

					if (DhcpStartIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (netgearScreen.setDHCPStartIP_R6250_WNDR3800CH_R7000(DhcpStartIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"DhcpStartIPAdd Enable setting is changed to " + DhcpStartIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpStartIPAdd");
						flag = false;
					}
					if (DhcpEndIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpEndIPAdd.");
					} else if (netgearScreen.setDHCPEndIP_R6250_WNDR3800CH_R7000(DhcpEndIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpEndIPAdd setting is changed to " + DhcpEndIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpEndIPAdd");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else if (flag && screenName.contains("WIRELESS")) {
				if (netgearScreen.clickOnWirelessSetup_WNDR3800CH_R7000()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToPage2Frame();
					flag = flag && netgearScreen.selectRegion("United States");
					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.enableDisableSSID2G_WNDR3800CH_R7000(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else if (frequency.contains("5")
							&& netgearScreen.enableDisableSSID5G_R6250_WNDR3800CH_R7000(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change SSID enable disable setting");
						flag = false;
					}

					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.setSSIDName2G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else if (frequency.contains("5")
							&& netgearScreen.setSSIDName5G_R6250_WNDR3800CH_R7000(ssid_name)) {
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Name ");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (frequency.contains("2.4")
							&& netgearScreen.selectChannel2G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else if (frequency.contains("5")
							&& netgearScreen.selectChannel5G_R6250_WNDR3800CH_R7000(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}

					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (frequency.contains("2.4") && netgearScreen.selectMode2G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else if (frequency.contains("5") && netgearScreen.selectMode5G_R6250_WNDR3800CH_R7000(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}
					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security in setting.");
					} else if (frequency.contains("2.4")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("TKIP") || security.contains("AES"))
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword2G_R6250_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						} else if (security.contains("WEP")
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WEPAuth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPAuth in setting.");
							} else if (netgearScreen.selectWEPAuth2G_R6250_WNDR3800CH_R7000(WEPAuth)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WEPAuth.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "WEPAuth is changed to " + WEPAuth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change modeWEPAuth ");
								flag = false;
							}
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWEPencrpytion2G_R6250_WNDR3800CH_R7000(Encrpytion)) {
								flag = true;

								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WEPKey1 == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEP Key1 in setting.");
							} else if (netgearScreen.setWEPKey12G_R6250_WNDR3800CH_R7000(WEPKey1)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WEP Key is changed to " + WEPKey1);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEP password ");
								flag = false;
							}
						} else if ((security.contains("ENTERPRISE"))
								&& netgearScreen.selectSecurity2G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WPAEncrpytion == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WPAEncrpytion.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWPAencrpytion2G_WNDR3800CH_R7000(WPAEncrpytion)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + WPAEncrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEncrpytion ");
								flag = false;
							}
							if (WPAEnterpriseInterval == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen
									.setWPAEnterpriseInterval2G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEnterpriseInterval ");
								flag = false;
							}
							if (RadiusIP == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen.setRadiusIP2G_WNDR3800CH_R7000(RadiusIP)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP ");
								flag = false;
							}
							if (RadiusPort == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort2G_WNDR3800CH_R7000(RadiusPort)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPA Enterprise Shared secret key in setting.");
							} else if (netgearScreen.setWPAEnterprisePassword2G_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPA/WPA2 Enterprise Share secret key is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						}
					} else if (frequency.contains("5")) {
						if (security.contains("NONE") && netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "security is changed to " + security);
						} else if ((security.contains("TKIP") || security.contains("AES"))
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWPAPassword5G_R6250(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WPA password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						} else if (security.contains("WEP")
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (WEPAuth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPAuth in setting.");
							} else if (netgearScreen.selectWEPAuth5G_R6250(WEPAuth)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, WEPAuth.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "WEPAuth is changed to " + WEPAuth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change modeWEPAuth ");
								flag = false;
							}
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWEPencrpytion5G_R6250(Encrpytion)) {
								flag = true;

								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WEPKey1 == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change password in setting.");
							} else if (netgearScreen.setWEPKey15G_R6250(WEPKey1)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "WEP password is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEP password ");
								flag = false;
							}
						} else if ((security.contains("ENTERPRISE"))
								&& netgearScreen.selectSecurity5G_WNDR3800CH_R7000(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion in setting.");
							} else if (netgearScreen.selecWPAencrpytion5G_WNDR3800CH_R7000(Encrpytion)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, Encrpytion.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "Encrpytion is changed to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion ");
								flag = false;
							}
							if (WPAEnterpriseInterval == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen
									.setWPAEnterpriseInterval5G_R6250_WNDR3800CH_R7000(WPAEnterpriseInterval)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPAEnterpriseInterval is changed to " + WPAEnterpriseInterval);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPAEnterpriseInterval ");
								flag = false;
							}
							if (RadiusIP == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPAEnterpriseInterval in setting.");
							} else if (netgearScreen.setRadiusIP5G_WNDR3800CH_R7000(RadiusIP)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusIP is changed to " + RadiusIP);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP ");
								flag = false;
							}
							if (RadiusPort == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort in setting.");
							} else if (netgearScreen.setRadiusPort5G_WNDR3800CH_R7000(RadiusPort)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "RadiusPort is changed to " + RadiusPort);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort ");
								flag = false;
							}
							if (password == null) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
								Keyword.ReportStep_Pass(testCase,
										"No need to change WPA Enterprise Shared secret key in setting.");
							} else if (netgearScreen.setWPAEnterprisePassword5G_WNDR3800CH_R7000(password)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"WPA/WPA2 Enterprise Share secret key is changed to " + password);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WPA password ");
								flag = false;
							}
						}
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (flag) {
				if (netgearScreen.ClickOnSaveBtn_handleAlert(screenName)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Apply Button");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Apply Button");
					flag = false;
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode _R6250_WNDR3800CH_Model_chaneRouterSecuritySettings(String securityType_request) {
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

	public static String getRouterSettings_RBR20(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("48")) {
						requestValue = "48";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40";
					} else if (parameterArray[i].contains("36")) {
						requestValue = "36";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12";
					} else if (parameterArray[i].contains("13")) {
						requestValue = "13";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "01";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "02";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "03";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "04";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "05";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "06";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "07";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "08";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "09";
					} else {
						requestValue = "Auto";
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
					requestValue = parameterArray_Value[i].replace("PASSWORD is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("NONE")) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WPA2_PSK_AES")) {
						requestValue = "WPA2-PSK [AES]";
					} else if (parameterArray[i].contains("WPA_WPA2")) {
						requestValue = "WPA-PSK [TKIP] + WPA2-PSK [AES]";
					}
					break;
				} else if (parameterArray[i].contains("START IP") && requestParameter.contains("START IP")) {
					requestValue = parameterArray_Value[i].replace("START IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("END IP") && requestParameter.contains("END IP")) {
					requestValue = parameterArray_Value[i].replace("END IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("IS DNS") && requestParameter.contains("IS DNS")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("HOST NAME") && requestParameter.contains("HOST NAME")) {
					requestValue = parameterArray_Value[i].replace("HOST NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("DNS EMAIL") && requestParameter.contains("DNS EMAIL")) {
					requestValue = parameterArray_Value[i].replace("DNS EMAIL is", "").trim();
					break;
				} else if (parameterArray[i].contains("DNS_KEY") && requestParameter.contains("DNS_KEY")) {
					requestValue = parameterArray_Value[i].replace("DNS_KEY is", "").trim();
					break;
				}
			}
		}
		return requestValue;
	}

	private static boolean _RBR20_Model_chaneRouterSettings(TestCases testCase, String screenName, String frequency,
			String channel, String security, String ssid_name, String password, String is_dhcp, String start_ip,
			String end_ip, String is_dns, String host_name, String email, String passkey) {
		boolean flag = true;
		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "ROUTER_MODEL")
					.toUpperCase();
			flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToTopFrame();
			flag = flag && netgearScreen.clickAdvanceSetup_RBR20();
			flag = flag && netgearScreen.clickSetup_RBR20();
			if (flag && screenName.contains("DHCP")) {
				if (netgearScreen.clickLanSetup_RBR20()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change is_dhcp Enable disable setting.");
					} else if (netgearScreen.enableDisableis_dhcp_RBR20(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dhcp Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_dhcp enable disable setting");
						flag = false;
					}
					if (start_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (netgearScreen.setDHCPStartIP_RBR20(start_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "start_ip Enable setting is changed to " + start_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change start_ip");
						flag = false;
					}
					if (end_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change end_ip.");
					} else if (netgearScreen.setDHCPEndIP_RBR20(end_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "end_ip setting is changed to " + end_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change end_ip");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}
			} else if (flag && screenName.contains("WIRELESS")) {
				if (netgearScreen.clickOnWirelessSetup_RBR20()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
					if (frequency == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
					}
					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (netgearScreen.selectChannel_RBR20(channel, frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}
					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (security.toUpperCase().contains("NONE")) {
						if (netgearScreen.clickOnNoneSecurity_RBR20()) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, "NONE", null);
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to set security as none");
						}
					} else if (security.toUpperCase().contains("WPA2-PSK [AES]")) {
						if (netgearScreen.clickOnWPA2_PSK_RBR20()) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, "WPA2-PSK [AES]", null);
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to set security as wep");
						}
					} else if (security.toUpperCase().contains("WPA-PSK [TKIP] + WPA2-PSK [AES]")) {
						if (netgearScreen.clickOnWPA_WPA2()) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, "WPA-PSK [TKIP] + WPA2-PSK [AES]", null);
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to set security WPA_WPA2");
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change security in Wireless setting");
						flag = false;
					}
					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (netgearScreen.setSSIDName_RBR20(ssid_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "SSID Name is changed to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Name ");
						flag = false;
					}
					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password");
					} else if (netgearScreen.setPassword_RBR20(password)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Password is changed to " + password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change password");
						flag = false;
					}
				}
			} else if (flag && screenName.contains("DNS")) {
				if (netgearScreen.clickOnAdvSetup_WNDR4300v2_RBR20()
						&& changeWebPage(testCase, null, null, screenName, routerModel)) {
					flag = flag && netgearScreen.clickDNS_WNDR4300v2_RBR20();
					flag = flag && netgearScreen.switchToDefaultFrame() && netgearScreen.switchToFormFrame();
					if (is_dns == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Email");
					} else if (netgearScreen.setIsDns_RBR20(is_dns)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "is_dns is changed to " + is_dns);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change is_dns");
						flag = false;
					}
					if (host_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Host Name.");
					} else if (netgearScreen.setHostName_RBR20(host_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "HOST Name is changed to " + host_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Host name ");
						flag = false;
					}
					if (email == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Email");
					} else if (netgearScreen.setEmail_RBR20(email)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Email is changed to " + email);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change E-Mail");
						flag = false;
					}
					if (passkey == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change passkey");
					} else if (netgearScreen.setPassKey_RBR20(passkey)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Pass Key is changed to " + passkey);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change passkey");
						flag = false;
					}

				}
			}

			if (flag) {
				if (netgearScreen.ClickOnApply_handleAlert(screenName)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Apply Button");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Apply Button");
					flag = false;
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}
}

//public static boolean changeRouterSettingsInNetgear(TestCases testCase, String dataOptions) {
//	boolean flag = false;
//	try {
//		// WebCommonUtils.getRouterSettings(dataOptions, dataOptions);
//		String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
//				.toUpperCase();
//
//		switch (routerModel) {
//		case "AX1500":
//			/*
//			TestCases testCase,String frequency, String channel, String mode, String security,
//		 String password, String ssid_name, boolean is_ssid)
//			 */
//			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
//			if (!WebController.isloggedIn()) {
//				if (changeWebPage(testCase, baseurl, "", "HOME SETTINGS")) {
//					WebController.isloggedIn(true);
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to change Home setting page");
//					flag = false;
//					WebController.isloggedIn(false);
//				}
//			}
//			flag = _AC1750_Model_chaneRouterSettings(testCase,
//					WebCommonUtils.getRouterSettings(dataOptions, "FREQUENCY"),
//					WebCommonUtils.getRouterSettings(dataOptions, "CHANNEL"),
//					WebCommonUtils.getRouterSettings(dataOptions, "MODE"),
//			        WebCommonUtils.getRouterSettings(dataOptions, "SECURITY"),
//					WebCommonUtils.getRouterSettings(dataOptions, "PASSWORD"),
//					WebCommonUtils.getRouterSettings(dataOptions, "SSID NAME"),
//					WebCommonUtils.getRouterSettings(dataOptions, "IS SSID"));
//
//			if (flag) {
//				String security = WebCommonUtils.getRouterSettings(dataOptions, "SECURITY");
//				if (security != null) {
//					if (!security.isEmpty()) {
//						WebController.securityType(_AX1500_Model_chaneRouterSecuritySettings(null));
//					}
//				}
//			}
//
//			break;
//
//		default:
//			break;
//		}
//	} catch (Exception e) {
//
//	}
//	return flag;
//}

//package com.resideo.utils.web;
//
//import java.time.Duration;
//import java.util.function.Function;
//
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.FluentWait;
//
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.web.screens.NetGearRouterScreen;
//
//public class NetGearRouterUtils {
//
//	final static String[] Modes2G = { "Up to 54 Mbps", "Up to 217 Mbps", "Up to 450 Mbps" };
//	final static String[] Modes5G = { "Up to 289 Mbps", "Up to 600 Mbps", "Up to 1300 Mbps" };
//
//	public static boolean changeChannel(TestCases testCase, String Channel, String frequencyBand) {
//		boolean flag = true;
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		if (checkPageLoadingComplete(testCase)) {
//			flag = netgearScreen.switchToBodyContentFrame();
//
//			if (frequencyBand.toUpperCase().equals("2.4GHZ")) {
//				flag = flag && netgearScreen.select2GChannelNumber(Channel);
//			} else if (frequencyBand.toUpperCase().equals("5GHZ")) {
//				flag = flag && netgearScreen.select5GChannelNumber(Channel);
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Please provide valid frequency band");
//				flag = false;
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Page Load Did not complete");
//			flag = false;
//		}
//		flag = flag && netgearScreen.switchToDefaultFrame();
//		return flag;
//	}
//
//	public static boolean changeMode(TestCases testCase, String mode, String frequencyBand) {
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		boolean flag = true;
//		if (checkPageLoadingComplete(testCase)) {
//			flag = netgearScreen.switchToBodyContentFrame();
//			if (frequencyBand.toUpperCase().equals("2.4GHZ")) {
//				if (mode.toUpperCase().equals("G")) {
//					mode = Modes2G[0];
//				} else if (mode.toUpperCase().equals("BGN") || mode.toUpperCase().equals("B/G/N")) {
//					mode = Modes2G[1];
//				} else if (mode.toUpperCase().equals("N")) {
//					mode = Modes2G[2];
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"NetGear router with this model doesn't support " + mode + " mode");
//					flag = flag && netgearScreen.switchToDefaultFrame();
//					return false;
//				}
//				flag = flag && netgearScreen.select2GModeType(mode);
//			} else if (frequencyBand.toUpperCase().equals("5GHZ")) {
//				if (mode.toUpperCase().equals("BGN")) {
//					mode = Modes5G[0];
//				} else if (mode.toUpperCase().equals("N")) {
//					mode = Modes5G[1];
//				} else if (mode.toUpperCase().equals("AC")) {
//					mode = Modes5G[2];
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"NetGear router with this model doesn't support " + mode + " mode");
//					flag = flag && netgearScreen.switchToDefaultFrame();
//					return false;
//				}
//				flag = flag && netgearScreen.select5GModeType(mode);
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Please provide valid frequency band");
//				flag = false;
//
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Page Load Did not complete");
//			flag = false;
//		}
//		flag = flag && netgearScreen.switchToDefaultFrame();
//		return flag;
//	}
//
//	public static boolean changeSecurityoption(TestCases testCase, String securityOpt, String frequencyBand) {
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		boolean flag = true;
//		if (checkPageLoadingComplete(testCase)) {
//			flag = netgearScreen.switchToBodyContentFrame();
//
//			if (frequencyBand.toUpperCase().equals("2.4GHZ")) {
//
//				if (securityOpt.toUpperCase().equals("NONE")) {
//					flag = flag && netgearScreen.clickOnNoneSecurity2G();
//				} else if (securityOpt.toUpperCase().equals("WEP")) {
//					flag = flag && netgearScreen.clickOnWEPSecurity2G();
//				} else if (securityOpt.toUpperCase().equals("WPA2 AES")) {
//					flag = flag && netgearScreen.clickOnAESSecurity2G();
//				} else if (securityOpt.toUpperCase().equals("WPA/WPA2 MIXED")) {
//					flag = flag && netgearScreen.clickOnWpaWpa2MixedSecurity2G();
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"NetGear router with this model doesn't support " + securityOpt + " Security option");
//					flag = flag && netgearScreen.switchToDefaultFrame();
//					return false;
//				}
//
//			} else if (frequencyBand.toUpperCase().equals("5GHZ")) {
//				if (securityOpt.toUpperCase().equals("NONE")) {
//					flag = flag && netgearScreen.clickOnNoneSecurity5G();
//				} else if (securityOpt.toUpperCase().equals("WPA2 AES")) {
//					flag = flag && netgearScreen.clickOnAESSecurity5G();
//				} else if (securityOpt.toUpperCase().equals("WPA/WPA2 MIXED")) {
//					flag = flag && netgearScreen.clickOnWpaWpa2MixedSecurity5G();
//					flag = flag && netgearScreen.clickOnMixedAlertOKSecurity5G();
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"NetGear router with this model doesn't support " + securityOpt + " Security option");
//					flag = flag && netgearScreen.switchToDefaultFrame();
//					return false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Please provide valid frequency band");
//				flag = false;
//
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Page Load Did not complete");
//			flag = false;
//		}
//		flag = flag && netgearScreen.switchToDefaultFrame();
//		return flag;
//	}
//
//	public static boolean checkPageLoadingComplete(TestCases testCase) {
//		Boolean flag = true;
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		try {
//			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
//			fwait.pollingEvery(Duration.ofSeconds(1));
//			fwait.withTimeout(Duration.ofSeconds(60));
//			fwait.ignoring(Exception.class);
//			Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
//
//				@Override
//				public Boolean apply(WebDriver driver) {
//					if (netgearScreen.isPageLoading()) {
//						System.out.println("Page loading");
//						Keyword.ReportStep_Pass(testCase, "Page is loading");
//						return false;
//					} else {
//						return true;
//					}
//				}
//
//			});
//			if (success) {
//				Keyword.ReportStep_Pass(testCase, "Page load completed");
//				flag = true;
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Page is not loaded properly after waiting for 60 Sec");
//				flag = false;
//			}
//		} catch (TimeoutException e) {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Page is not loaded properly after waiting for 60 Sec");
//			flag = false;
//		} catch (Exception e) {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Exception occurred Page Load due to " + e.getMessage());
//			flag = false;
//		}
//
//		return flag;
//
//	}
//
//	public static boolean _SSIDbroadcastEnable_Disable(TestCases testCase, boolean _enableDisable_status,
//			String frequencyBand) {
//		boolean flag = true;
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		if (checkPageLoadingComplete(testCase)) {
//			flag = netgearScreen.switchToBodyContentFrame();
//
//			if (frequencyBand.toUpperCase().equals("2.4GHZ")) {
//				if (_enableDisable_status && !netgearScreen.isBroadCastSSID2GEnabled()) {
//					flag = flag && netgearScreen.clickOnBroadCastSSID2G();
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
//				} else if (!_enableDisable_status && netgearScreen.isBroadCastSSID2GEnabled()) {
//					flag = flag && netgearScreen.clickOnBroadCastSSID2G();
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
//
//				} else if (_enableDisable_status && netgearScreen.isBroadCastSSID2GEnabled()) {
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already enabled for 2.4 GHZ band");
//
//				} else {
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already disabled for 2.4 GHZ band");
//
//				}
//			} else if (frequencyBand.toUpperCase().equals("5GHZ")) {
//				if (_enableDisable_status && !netgearScreen.isBroadCastSSID5GEnabled()) {
//					flag = flag && netgearScreen.clickOnBroadCastSSID5G();
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 5 GHZ band");
//				} else if (!_enableDisable_status && netgearScreen.isBroadCastSSID5GEnabled()) {
//					flag = flag && netgearScreen.clickOnBroadCastSSID5G();
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 5 GHZ band");
//
//				} else if (_enableDisable_status && netgearScreen.isBroadCastSSID5GEnabled()) {
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already enabled for 5 GHZ band");
//
//				} else {
//					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already disabled for 5 GHZ band");
//
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Please provide valid frequency band");
//				flag = false;
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Page Load Did not complete");
//			flag = false;
//		}
//		flag = flag && netgearScreen.switchToDefaultFrame();
//		return flag;
//	}
//
//	public static boolean applyChangesMade(TestCases testCase) {
//		NetGearRouterScreen netgearScreen = new NetGearRouterScreen(testCase);
//		boolean flag = true;
//
//		if (netgearScreen.clickOnApplyChangesBTN()) {
//			Keyword.ReportStep_Pass(testCase, "Successfully Applied the changes");
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "unable to apply changes");
//		}
//		return flag;
//	}
//}