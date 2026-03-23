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
import com.resideo.utils.web.screens.VizioRouterScreen;

public class VizioRouterUtils {

	private static String getRouterSettings_XWR100(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
						requestValue = "2.4";
					} else {
						requestValue = "5";
					}
					break;
				} else if (parameterArray[i].contains("SECURITY_KEY") && requestParameter.contains("SECURITY_KEY")) {
					requestValue = parameterArray_Value[i].replace("SECURITY_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("IS_DHCP") && requestParameter.contains("IS_DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("IS_SSID") && requestParameter.contains("IS_SSID")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("LEASE TIME is", "").trim();
					break;
				} else if (parameterArray[i].contains("START IP") && requestParameter.contains("START IP")) {
					requestValue = parameterArray_Value[i].replace("START IP is", "").trim();
					break;
				}else if (parameterArray[i].contains("SECURITY_TYPE") && requestParameter.contains("SECURITY_TYPE")) {
					if (parameterArray[i].contains("DISABLE")) {
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("WPA2 PERSONAL")) {
						requestValue = "WPA2 Personal";
					} else if (parameterArray[i].contains("WPA PERSONAL")) {
						requestValue = "WPA Personal";
					} else if (parameterArray[i].contains("WEP128")) {
						requestValue = "WEP 128 bits";
					} else if (parameterArray[i].contains("WEP64")) {
						requestValue = "WEP 64 bits";
					}
					break;
				}
			}
		}
		return requestValue;
	}

	public static String PageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "XWR100":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "DUAL-BAND HD WIRELESS INTERNET ROUTER";
				break;
			case "BASIC WIRELESS":
				pagecontainer = "OPTIMIZED FOR HD VIDEO STREAMING, THIS NETWORK TYPICALLY HAS GOOD COVERAGE FOR MOST HOMES AND OPERATES AT 5GHZ.";
				break;
			case "DHCP":
				pagecontainer = "LAN SETTINGS";
				break;
			default:
				pagecontainer = "";
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
						String pageSource = driver.getPageSource();
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

	public static boolean changeRouterSettingsInVizio(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "XWR100":
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
				flag = _XWR100_Model_chaneRouterSettings(testCase, screenName, baseurl, routerModel,
						getRouterSettings_XWR100(dataOptions, "FREQUENCY"),
						getRouterSettings_XWR100(dataOptions, "SSID NAME"),
						getRouterSettings_XWR100(dataOptions, "SECURITY_TYPE"),
						getRouterSettings_XWR100(dataOptions, "SECURITY_KEY"),
						getRouterSettings_XWR100(dataOptions, "IS_SSID"),
						getRouterSettings_XWR100(dataOptions, "IS_DHCP"),
						getRouterSettings_XWR100(dataOptions, "START IP"),
						getRouterSettings_XWR100(dataOptions, "LEASE TIME"));
				if (flag) {
					String security = getRouterSettings_XWR100(dataOptions, "SECURITY");
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

	private static boolean _XWR100_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String ssid_name,
			String security_type, String security_key, String is_ssid,
			String is_dhcp, String start_ip, String lease_time) {
		boolean flag = true;
		VizioRouterScreen VizioScreen = new VizioRouterScreen(testCase);
		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (screenName.contains("BASIC WIRELESS")) {
			if (changeWebPage(testCase, baseURL, "/adv_edit_wireless.htm", "BASIC WIRELESS", routerModel)) {
				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to SSID NAME.");
				} else if (VizioScreen.changeSSID_XWR100(ssid_name, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed ssid name to " + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change SSID NAME from Basic settings");
					flag = false;
				}
				if (security_type == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Security Type");
				} else if (VizioScreen.SecurityType_XWR100(security_type, frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Security type changed to " + security_type);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change security type");
					flag = false;
				}
				if (security_key == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change security key");
				} else if (VizioScreen.SecurityKey_XWR100(security_key,frequency)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Security Key changed to " + security_key);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change security key");
					flag = false;
				}
				if (is_ssid == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change ssid enable /disable .");
				} else if (VizioScreen.enable_disable_ssid_XWR100(is_ssid, frequency)) {
					Keyword.ReportStep_Pass(testCase, "Changed SSID Mode to :" + is_ssid);
					flag = true;

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change ssid enable/disable settings");
					flag = false;
				}
			}
		}  else if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/adv_edit_router_lan_settings.htm", "DHCP", routerModel)) {
				if (is_dhcp == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
				} else if (VizioScreen.enable_disable_DHCP_HW2R1(is_dhcp)) {
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
				} else if (VizioScreen.setstartip_HW2R1(start_ip)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "DHCP START IP is set to " + start_ip);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Starting IP Address in DHCP setting");
					flag = false;
				}
				if (lease_time == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
				} else if (VizioScreen.setvalueinDHCPLeaseTime_XWR100(lease_time)) {
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
			if (VizioScreen.clickonApplybutton_XWR100(screenName)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Save Button Clicked");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on Apply1 button");
				flag = false;
			}
		}
		return flag;
	}

}