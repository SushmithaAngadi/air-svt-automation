package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.web.screens.WDRouterScreen;

public class WDRouterUtils {

	public static String getRouterSettings_MyNetN900(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
						requestValue = "2.4";
					} else {
						requestValue = "5";
					}
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("WPA_WPA2_PERSONAL")) {
						requestValue = "WPA/WPA2 - Personal";
					} else if (parameterArray[i].contains("WPA_WPA2_ENTERPRISE")) {
						requestValue = "WPA/WPA2 - Enterprise";
					} else if (parameterArray[i].contains("WPA_PERSONAL")) {
						requestValue = "WPA - Personal";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA2 - Personal";
					} else if (parameterArray[i].contains("WPA_ENTERPRISE")) {
						requestValue = "WPA - Enterprise";
					} else if (parameterArray[i].contains("WPA2_ENTERPRISE")) {
						requestValue = "WPA2 - Enterprise";
					} else if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					}
					break;
				} else if (parameterArray[i].contains("NETWORK_MODE") && requestParameter.contains("NETWORK_MODE")) {
					if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n only";
					} else if (parameterArray[i].contains("A_N")) {
						requestValue = "Mixed 802.11 a+n";
					} else if (parameterArray[i].contains("A ONLY")) {
						requestValue = "802.11a only";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "802.11b only";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "802.11g only";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n only";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "Mixed 802.11 b+g";
					} else if (parameterArray[i].contains("G_N")) {
						requestValue = "Mixed 802.11 g+n";
					} else if (parameterArray[i].contains("B_G_N")) {
						requestValue = "Mixed 802.11 b+g+n";
					}
					break;
				} else if (parameterArray[i].contains("CH_WIDTH") && requestParameter.contains("CH_WIDTH")) {
					if (parameterArray[i].contains("20_40")) {
						requestValue = "20/40 MHz(Auto)";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					}
					break;
				} else if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("165")) {
						requestValue = "5.825 GHz - CH 165";
					} else if (parameterArray[i].contains("161")) {
						requestValue = "5.805 GHz - CH 161";
					} else if (parameterArray[i].contains("157")) {
						requestValue = "5.785 GHz - CH 157";
					} else if (parameterArray[i].contains("153")) {
						requestValue = "5.765 GHz - CH 153";
					} else if (parameterArray[i].contains("149")) {
						requestValue = "5.745 GHz - CH 149";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "5.240 GHz - CH 48";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "5.220 GHz - CH 44";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "5.200 GHz - CH 40";
					} else if (parameterArray[i].contains("36")) {
						requestValue = "5.180 GHz - CH 36";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "2.462 GHz - CH 11";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "2.457 GHz - CH 10";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "2.412 GHz - CH 1";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "2.417 GHz - CH 2";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "2.422 GHz - CH 3";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "2.427 GHz - CH 4";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "2.432 GHz - CH 5";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "2.437 GHz - CH 6";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "2.442 GHz - CH 7";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "2.447 GHz - CH 8";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "2.452 GHz - CH 9";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
					requestValue = parameterArray_Value[i].replace("PASSWORD is", "").trim();
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
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
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("Radius IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_SHARED_KEY")
						&& requestParameter.contains("RADIUS_SHARED_KEY")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_SHARED_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP START IP") && requestParameter.contains("DHCP START IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP START IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP END IP") && requestParameter.contains("DHCP END IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP END IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("LEASE TIME is", "").trim();
					break;
				}
			}
		}
		return requestValue;
	}

	public static String PageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "MyNetN900":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "WELCOME TO MY NET N900 ROUTER";
				break;
			case "WIRLESS SETTING":
				pagecontainer = "WIRELESS / WIRELESS SETUP";
				break;
			case "DHCP":
				pagecontainer = "LAN / DHCP SERVER SETTINGS";
				break;
			}
		}
		return pagecontainer;
	}

	public static boolean changeWebPage(TestCases testCase, String baseURL, String requestingPage, String screenName,
			String routerModel) {
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
						String pageSource = driver.getPageSource().toUpperCase();
						if (pageSource.toUpperCase().contains(PageSource(screenName, routerModel))) {
							return true;
						} else {
							return false;
						}
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

	public static boolean changeRouterSettingsInWD(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "WEB_URL");
			switch (routerModel) {
			case "MyNetN900":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "", "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _MyNetN900_Model_chaneRouterSettings(testCase, screenName, baseurl, routerModel,
						getRouterSettings_MyNetN900(dataOptions, "FREQUENCY"),
						getRouterSettings_MyNetN900(dataOptions, "SSID NAME"),
						getRouterSettings_MyNetN900(dataOptions, "SECURITY"),
						getRouterSettings_MyNetN900(dataOptions, "PASSWORD"),
						getRouterSettings_MyNetN900(dataOptions, "RADIUS IP"),
						getRouterSettings_MyNetN900(dataOptions, "RADIUS PORT"),
						getRouterSettings_MyNetN900(dataOptions, "RADIUS_SHARED_KEY"),
						getRouterSettings_MyNetN900(dataOptions, "NETWORK_MODE"),
						getRouterSettings_MyNetN900(dataOptions, "CH_WIDTH"),
						getRouterSettings_MyNetN900(dataOptions, "CHANNEL"),
						getRouterSettings_MyNetN900(dataOptions, "IS SSID"),
						getRouterSettings_MyNetN900(dataOptions, "IS DHCP"),
						getRouterSettings_MyNetN900(dataOptions, "DHCP START IP"),
						getRouterSettings_MyNetN900(dataOptions, "DHCP END IP"),
						getRouterSettings_MyNetN900(dataOptions, "LEASE TIME"));
				if (flag) {
					String security = getRouterSettings_MyNetN900(dataOptions, "SECURITY");
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
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in changeRouterSettingsInAirLive(TestCases testCase, String screenName, String dataOptions)  due to "
							+ e.getMessage());
			flag = false;
		}
		return flag;
	}

	private static boolean _MyNetN900_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String ssid_name, String security, String password, String radius_ip,
			String radius_port, String radius_shared_key, String network_mode, String channel_width, String channel,
			String is_ssid, String is_dhcp, String start_ip, String end_ip, String lease_time) {
		boolean flag = true;
		WDRouterScreen WdScreen = new WDRouterScreen(testCase);
		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}

		if (screenName.contains("BASIC WIRELESS")) {
			if (changeWebPage(testCase, baseURL, "/wlan.php", "WIRLESS SETTING", routerModel)) {
				if (WdScreen.enable_Frequency_MyNetN900("Enable", frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Enabled frequency.");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enable frequency ");
					flag = false;
				}
				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to SSID NAME.");
				} else if (WdScreen.changeSSID_MyNetN900(ssid_name, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed ssid name to " + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change SSID NAME from Basic settings");
					flag = false;
				}
				if (is_ssid == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to SSID Broadcast.");
				} else if (WdScreen.changeSSIDBroadcast_MyNetN900(is_ssid, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed ssid Broadcast to " + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change SSID Broadcast from Basic settings");
					flag = false;
				}
				if (network_mode == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Security Type");
				} else if (WdScreen.NetworkMode_MyNetN900(network_mode, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Network Mode changed to " + network_mode);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Network Mode");
					flag = false;
				}
				if (channel_width == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Channel width");
				} else if (WdScreen.ChannelWidth_MyNetN900(channel_width, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Channel width changed to " + channel_width);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change channel width");
					flag = false;
				}
				if (channel == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Channel");
				} else if (WdScreen.Channel_MyNetN900(channel, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Channel changed to " + channel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change channel");
					flag = false;
				}
				if (security == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Security Type");
				} else if ((security.contains("WPA - Personal")
						|| (security.contains("WPA2 - Personal") || (security.contains("WPA/WPA2 - Personal"))))
						&& WdScreen.SecurityType_MyNetN900(security, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Security type changed to " + security);
					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password");
					} else if (WdScreen.password_MyNetN900(password, frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Password changed to " + password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change password");
						flag = false;
					}
				} else if ((security.contains("WPA - Enterprise")
						|| (security.contains("WPA2 - Enterprise") || (security.contains("WPA/WPA2 - Enterprise"))))
						&& WdScreen.SecurityType_MyNetN900(security, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Security type changed to " + security);
					if (radius_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change radius ip");
					} else if (WdScreen.RadiusIp_MyNetN900(radius_ip, frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Radius IP changed to " + radius_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Radius IP");
						flag = false;
					}
					if (radius_port == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Radius Port");
					} else if (WdScreen.Radius_Port_MyNetN900(radius_port, frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Radius Port changed to " + radius_port);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to Change Radius Port");
						flag = false;
					}
					if (radius_shared_key == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change radius_shared_key");
					} else if (WdScreen.Radius_Key_MyNetN900(radius_shared_key, frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "radius_shared_key changed to " + radius_shared_key);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change radius_shared_key");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change security type");
					flag = false;
				}
			}
		} else if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/lan_server.php", "DHCP", routerModel)) {
				if (is_dhcp == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
				} else if (WdScreen.enable_disable_DHCP_MyNetN900(is_dhcp)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP to :" + is_dhcp);
					flag = true;

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp enable/disable settings");
					flag = false;
				}
				if (start_ip == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change starting ip address.");
				} else if (WdScreen.setstartip_MyNetN900(start_ip)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "DHCP START IP is set to " + start_ip);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Starting IP Address in DHCP setting");
					flag = false;
				}
				if (end_ip == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change ending ip address.");
				} else if (WdScreen.setendip_MyNetN900(end_ip)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "DHCP END IP is set to " + end_ip);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change End IP Address in DHCP setting");
					flag = false;
				}
				if (lease_time == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
				} else if (WdScreen.setvalueinDHCPLeaseTime_MyNetN900(lease_time)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + lease_time);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change DHCP Lease time in DHCP setting");
					flag = false;
				}
			}
		}

		if (flag) {
			if (WdScreen.clickonApplybutton_MyNetN900(screenName)) {
				if (WdScreen.clickContbutton_MyNetN900(screenName)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Continue Button Clicked");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click Continue button");
					flag = false;
				}
				if (WdScreen.acceptAlert()) {
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to Accept the Alert");
				}
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Save Button Clicked");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click Save button");
				flag = false;
			}

		}
		return flag;
	}

}