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
import com.resideo.utils.web.screens.HawkingRouterScreen;

public class HawkingRouterUtils {

	public static String getRouterSettings_HW2R1150M_HAW2R1300N(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("10")) {
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
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("BAND") && requestParameter.contains("BAND")) {
					if (parameterArray[i].contains("N ONLY")) {
						requestValue = "2.4 GHz (N)";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "2.4 GHz (G)";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "2.4 GHz (B)";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "2.4 GHz (B+G)";
					} else if (parameterArray[i].contains("B_G_N")) {
						requestValue = "2.4 GHz (B+G+N)";
					}
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA PRE-SHAREDKEY")) {
						requestValue = "WPA pre-shared key";
					} else if (parameterArray[i].contains("WPA RADIUS")) {
						requestValue = "WPA RADIUS";
					}
					break;
				} else if (parameterArray[i].contains("KEYLENGTH") && requestParameter.contains("KEYLENGTH")) {
					if (parameterArray[i].contains("64")) {
						requestValue = "64-bit";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "128-bit";
					}
					break;
				} else if (parameterArray[i].contains("KEYFORMAT") && requestParameter.contains("KEYFORMAT")) {
					if (parameterArray[i].contains("HEX64")) {
						requestValue = "Hex (10 Chr.)";
					} else if (parameterArray[i].contains("HEX128")) {
						requestValue = "Hex (26 Chr.)";
					} else if (parameterArray[i].contains("ASCII64")) {
						requestValue = "ASCII (5 Chr.)";
					} else if (parameterArray[i].contains("ASCII128")) {
						requestValue = "ASCII (13 Chr.)";
					}
					break;
				} else if (parameterArray[i].contains("WPASUITE") && requestParameter.contains("WPASUITE")) {
					if (parameterArray[i].contains("WPA_TKIP")) {
						requestValue = "WPA(TKIP)";
					} else if (parameterArray[i].contains("WPA2_AES")) {
						requestValue = "WPA2(AES)";
					} else if (parameterArray[i].contains("WPA2 MIXED")) {
						requestValue = "WPA2 Mixed";
					}
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("ENRADIUS") && requestParameter.contains("ENRADIUS")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					if (parameterArray[i].contains("FOREVER")) {
						requestValue = "Forever";
					} else if (parameterArray[i].contains("OHE HOUR")) {
						requestValue = "One hour";
					} else if (parameterArray[i].contains("TWO HOURS")) {
						requestValue = "Two hours";
					} else if (parameterArray[i].contains("HALF OF A DAY")) {
						requestValue = "Half of a day";
					} else if (parameterArray[i].contains("ONE DAY")) {
						requestValue = "One day";
					} else if (parameterArray[i].contains("TWO DAYS")) {
						requestValue = "Two days";
					} else if (parameterArray[i].contains("ONE WEEK")) {
						requestValue = "One week";
					} else if (parameterArray[i].contains("TWO WEEKS")) {
						requestValue = "Two weeks";
					}
					break;
				} else if (parameterArray[i].contains("RADIUSIP") && requestParameter.contains("RADIUSIP")) {
					requestValue = parameterArray_Value[i].replace("RADIUSIP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUSPORT") && requestParameter.contains("RADIUSPORT")) {
					requestValue = parameterArray_Value[i].replace("RADIUSPORT is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUSPASSWORD")
						&& requestParameter.contains("RADIUSPASSWORD")) {
					requestValue = parameterArray_Value[i].replace("RADIUSPASSWORD is", "").trim();
					break;
				} else if (parameterArray[i].contains("WEPKEY") && requestParameter.contains("WEPKEY")) {
					requestValue = parameterArray_Value[i].replace("WEPKEY1 is", "").trim();
					break;
				} else if (parameterArray[i].contains("PRESHAREDKEY") && requestParameter.contains("PRESHAREDKEY")) {
					requestValue = parameterArray_Value[i].replace("PRESHAREDKEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("WPAFORMAT") && requestParameter.contains("WPAFORMAT")) {
					if (parameterArray[i].contains("PASSPHRASE")) {
						requestValue = "Passphrase";
					} else if (parameterArray[i].contains("HEX")) {
						requestValue = "Hex (64 Chr.)";
					}
					break;
				} else if (parameterArray[i].contains("STARTIP") && requestParameter.contains("STARTIP")) {
					requestValue = parameterArray_Value[i].replace("STARTIP is", "").trim();
					break;
				} else if (parameterArray[i].contains("ENDIP") && requestParameter.contains("ENDIP")) {
					requestValue = parameterArray_Value[i].replace("ENDIP is", "").trim();
					break;
				}  else if (parameterArray[i].contains("IS_DNS") && requestParameter.contains("IS_DNS")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("DISABLE")) {
						requestValue = "Disable";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("PROVIDER") && requestParameter.contains("PROVIDER")) {
					if (parameterArray[i].contains("3322")) {
						requestValue = "3322(qdns)";
					} else if (parameterArray[i].contains("DHS")) {
						requestValue = "DHS";
					} else if (parameterArray[i].contains("DYN_DNS")) {
						requestValue = "DynDNS";
					} else if (parameterArray[i].contains("ODS")) {
						requestValue = "ODS";
					} else if (parameterArray[i].contains("TZO")) {
						requestValue = "TZO";
					} else if (parameterArray[i].contains("GNU")) {
						requestValue = "GnuDIP";
					} else if (parameterArray[i].contains("DY_NS")) {
						requestValue = "DyNS";
					} else if (parameterArray[i].contains("ZONE")) {
						requestValue = "ZoneEdit";
					} else if (parameterArray[i].contains("CYBER")) {
						requestValue = "CyberGate";
					}
					break;
				} else if (parameterArray[i].contains("DOMAIN") && requestParameter.contains("DOMAIN")) {
					requestValue = parameterArray_Value[i].replace("DOMAIN is", "").trim();
					break;
				} else if (parameterArray[i].contains("ACCOUNT") && requestParameter.contains("ACCOUNT")) {
					requestValue = parameterArray_Value[i].replace("ACCOUNT is", "").trim();
					break;
				} else if (parameterArray[i].contains("DNS_KEY") && requestParameter.contains("DNS_KEY")) {
					requestValue = parameterArray_Value[i].replace("DNS_KEY is", "").trim();
					break;
				}
			}
		}
		return requestValue;
	}

	public static String PageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "HW2R1150M":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "TO SET UP YOUR HI-GAIN WIRELESS-N DUAL RADIO SMART REPEATER YOU WILL NEED TO FIRST SCAN FOR AN";
				break;
			case "BASIC WIRELESS":
				pagecontainer = "THIS PAGE ALLOWS YOU TO DEFINE ESSID, AND CHANNEL FOR THE WIRELESS CONNECTION.";
				break;
			case "SECURITY SETTINGS":
				pagecontainer = "SECURE YOUR HOME WIRELESS NETWORK BELOW. TURN ON WEP OR WPA BY USING ENCRYPTION KEYS COULD PREVENT ANY UNAUTHORIZED ACCESS TO YOUR HOME WIRELESS NETWORK.";
				break;
			case "DHCP":
				pagecontainer = "WIRELESS-N DUAL RADIO SMART REPEATER'S DHCP SERVER  TO DYNAMICALLY ALLOCATE IP ADDRESSES TO YOUR LAN CLIENT PCS";
				break;
			case "DNS":
				pagecontainer = "DYNAMICDNS (DDNS) ALLOWS USERS TO MAP THE STATIC DOMAIN NAME TO A DYNAMIC IP ADDRESS.";
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "HAW2R1300N":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "WELCOME TO THE SETUP WIZARD";
				break;
			case "BASIC WIRELESS":
				pagecontainer = "THIS PAGE ALLOWS YOU TO DEFINE ESSID, AND CHANNEL FOR THE WIRELESS CONNECTION.";
				break;
			case "SECURITY SETTINGS":
				pagecontainer = "SECURE YOUR HOME WIRELESS NETWORK BELOW. TURN ON WEP OR WPA BY USING ENCRYPTION KEYS COULD PREVENT ANY UNAUTHORIZED ACCESS TO YOUR HOME WIRELESS NETWORK.";
				break;
			case "DHCP":
				pagecontainer = "THE  DUAL RADIO SMART REPEATER MUST HAVE AN IP ADDRESS IN THE LOCAL AREA NETWORK.";
				break;
			case "DNS":
				pagecontainer = "DYNAMICDNS (DDNS) ALLOWS USERS TO MAP THE STATIC DOMAIN NAME TO A DYNAMIC IP ADDRESS.";
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
						String pageSource = driver.getPageSource().toUpperCase();
						String a = PageSource(screenName, routerModel);
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

	public static boolean changeRouterSettingsInHawking(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "HW2R1150M":
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
				flag = _HW2R1150M_HAW2R1300N_Model_chaneRouterSettings(testCase, screenName, baseurl, routerModel,
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "BAND"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SSID NAME"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "CHANNEL"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SECURITY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ENRADIUS"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "KEYLENGTH"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "KEYFORMAT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "TXKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WEPKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WPASUITE"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WPAFORMAT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "PRESHAREDKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSPORT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSPASSWORD"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "IS DHCP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "LEASE TIME"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "STARTIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ENDIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "IS_DNS"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "PROVIDER"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "DOMAIN"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ACCOUNT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "DNS_KEY"));
				if (flag) {
					String security = getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "HAW2R1300N":
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
				flag = _HW2R1150M_HAW2R1300N_Model_chaneRouterSettings(testCase, screenName, baseurl, routerModel,
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "BAND"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SSID NAME"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "CHANNEL"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SECURITY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ENRADIUS"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "KEYLENGTH"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "KEYFORMAT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "TXKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WEPKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WPASUITE"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "WPAFORMAT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "PRESHAREDKEY"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSPORT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "RADIUSPASSWORD"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "IS DHCP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "LEASE TIME"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "STARTIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ENDIP"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "IS_DNS"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "PROVIDER"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "DOMAIN"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "ACCOUNT"),
						getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "DNS_KEY"));
				if (flag) {
					String security = getRouterSettings_HW2R1150M_HAW2R1300N(dataOptions, "SECURITY");
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

	public static boolean _HW2R1150M_HAW2R1300N_Model_chaneRouterSettings(TestCases testCase, String screename, String baseURL,
			String routerModel, String band, String ssid_name, String channel, String security, String enable_radius,
			String wepkey_length, String wepkey_format, String txkey, String wep_key, String wpa_suite,
			String wpa_format, String presharedkey, String radius_ip, String radius_port, String radius_password,
			String is_dhcp, String LeaseTime, String startip, String endip, String is_dns, String provider,
			String domain, String account, String dns_key) {
		boolean flag = true;
		HawkingRouterScreen HawkingScreen = new HawkingRouterScreen(testCase);
		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (screename.contains("BASIC WIRELESS")) {
			if (routerModel.contains("HW2R1150M")) {
				flag = changeWebPage(testCase, baseURL, "/hw2r1_01_04_01_basic.asp", "BASIC WIRELESS", routerModel);
			} else if (routerModel.contains("HAW2R1300N")) {
				flag = changeWebPage(testCase, baseURL, "/haw2r1_01_04_01_basic.asp", "BASIC WIRELESS", routerModel);
			}
			if (band == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
			} else if (HawkingScreen.changeBand_HW2R1150M_HAW2R1300N(band)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed frequency to ." + band);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change frequency from Basic settings");
				flag = false;
			}
			if (channel == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change channel.");
			} else if (HawkingScreen.changeChannel_HW2R1150M_HAW2R1300N(channel)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed channel to " + channel);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change channel from Basic settings");
				flag = false;
			}
			if (ssid_name == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change SSID Name.");
			} else if (HawkingScreen.setSSIDName_HW2R1150M_HAW2R1300N(ssid_name)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
				flag = false;
			}
		} else if (screename.contains("SECURITY SETTINGS")) {
			if (routerModel.contains("HW2R1150M")) {
				flag = changeWebPage(testCase, baseURL, "/hw2r1_01_04_03_security.asp", "SECURITY SETTINGS",
						routerModel);
			} else if (routerModel.contains("HAW2R1300N")) {
				flag = changeWebPage(testCase, baseURL, "/haw2r1_01_04_03_security.asp", "SECURITY SETTINGS",
						routerModel);
			}
			if (security == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change security");
			} else if (security.toUpperCase().contains("DISABLE")
					&& HawkingScreen.changeSecurity_HW2R1150M_HAW2R1300N(security)) {
				if (enable_radius == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Enable Radius Authentication.");
				} else if (HawkingScreen.setEnableradius_HW2R1150M_HAW2R1300N(enable_radius)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfuly changed the enable radius to :" + enable_radius);
					if (radius_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
					} else if (HawkingScreen.setRadiusIP_HW2R1150M_HAW2R1300N(radius_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + radius_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusIP in Wireless setting");
						flag = false;
					}
					if (radius_port == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
					} else if (HawkingScreen.setRadiusPort_HW2R1150M_HAW2R1300N(radius_port)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + radius_port);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusPort in Wireless setting");
						flag = false;
					}
					if (radius_password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusPassword.");
					} else if (HawkingScreen.setRadiusPassword_HW2R1150M_HAW2R1300N(radius_password)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusPassword to " + radius_password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusPassword in Wireless setting");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Enable Radius");
					flag = false;
				}
			} else if (security.toUpperCase().contains("WEP") && HawkingScreen.changeSecurity_HW2R1150M_HAW2R1300N(security)) {
				if (wepkey_length == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change KeyLength.");
				} else if (HawkingScreen.selectWEPKeyLength_HW2R1150M_HAW2R1300N(wepkey_length)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change KeyLength to " + wepkey_length);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change KeyLength in Wireless setting");
					flag = false;
				}
				if (wepkey_format == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change KeyForamt.");
				} else if (HawkingScreen.KeyFormat_HW2R1150M_HAW2R1300N(wepkey_format)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change Key format to " + wepkey_format);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Key Foramt in Wireless setting");
					flag = false;
				}
				if (txkey == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Tx key.");
				} else if (HawkingScreen.TxKey_HW2R1150M_HAW2R1300N(txkey)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change Tx key to " + txkey);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Tx Key in Wireless setting");
					flag = false;
				}
				if (wep_key == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change WEPKey1.");
				} else if (HawkingScreen.setWEPKey1_HW2R1150M_HAW2R1300N(wep_key)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change WEPKey1 to " + wep_key);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WEPKey1 in Wireless setting");
					flag = false;
				}
				if (enable_radius == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Enable Radius Authentication.");
				} else if (HawkingScreen.setEnableradius_HW2R1150M_HAW2R1300N(enable_radius)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfuly changed the enable radius to :" + enable_radius);
					if (radius_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
					} else if (HawkingScreen.setRadiusIP_HW2R1150M_HAW2R1300N(radius_ip)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + radius_ip);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusIP in Wireless setting");
						flag = false;
					}
					if (radius_port == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
					} else if (HawkingScreen.setRadiusPort_HW2R1150M_HAW2R1300N(radius_port)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + radius_port);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusPort in Wireless setting");
						flag = false;
					}
					if (radius_password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change RadiusPassword.");
					} else if (HawkingScreen.setRadiusPassword_HW2R1150M_HAW2R1300N(radius_password)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change RadiusPassword to " + radius_password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change RadiusPassword in Wireless setting");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Enable Radius");
					flag = false;
				}
			} else if (security.toUpperCase().contains("WPA PRE-SHARED KEY")
					&& HawkingScreen.changeSecurity_HW2R1150M_HAW2R1300N(security)) {
				if (wpa_suite == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change WPA Suite.");
				} else if (HawkingScreen.WPASUITE_HW2R1150M_HAW2R1300N(wpa_suite)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change WPA SUITE to " + wpa_suite);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WPA Suite in Wireless setting");
					flag = false;
				}
				if (wpa_format == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Wpa Format.");
				} else if (HawkingScreen.WPAFormat_HW2R1150M_HAW2R1300N(wpa_format)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change Key format to " + wpa_format);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change wpa Key Foramt in Wireless setting");
					flag = false;
				}
				if (presharedkey == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Wpa Format.");
				} else if (HawkingScreen.PresharedKey_HW2R1150M_HAW2R1300N(presharedkey)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change Key format to " + presharedkey);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Key Foramt in Wireless setting");
					flag = false;
				}
			} else if (security.toUpperCase().contains("WPA RADIUS")
					&& HawkingScreen.changeSecurity_HW2R1150M_HAW2R1300N(security)) {
				if (wpa_suite == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change WPA Suite.");
				} else if (HawkingScreen.WPASUITE_HW2R1150M_HAW2R1300N(wpa_suite)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change WPA SUITE to " + wpa_suite);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WPA Suite in Wireless setting");
					flag = false;
				}
				if (radius_ip == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
				} else if (HawkingScreen.setRadiusIP_HW2R1150M_HAW2R1300N(radius_ip)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + radius_ip);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change RadiusIP in Wireless setting");
					flag = false;
				}
				if (radius_port == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
				} else if (HawkingScreen.setRadiusPort_HW2R1150M_HAW2R1300N(radius_port)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + radius_port);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change RadiusPort in Wireless setting");
					flag = false;
				}
				if (radius_password == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change RadiusPassword.");
				} else if (HawkingScreen.setRadiusPassword_HW2R1150M_HAW2R1300N(radius_password)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change RadiusPassword to " + radius_password);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change RadiusPassword in Wireless setting");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Security Settings");
				flag = false;
			}
		} else if (screename.contains("DHCP")) {
			if (routerModel.contains("HW2R1")) {
				flag = changeWebPage(testCase, baseURL, "/hw2r1_01_03_00_homenet.asp", "DHCP", routerModel);
			} else if (routerModel.contains("HAW2R1")) {
				flag = changeWebPage(testCase, baseURL, "/haw2r1_01_03_00_homenet.asp", "DHCP", routerModel);
			}
			if (is_dhcp == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
			} else if (HawkingScreen.enable_disable_DHCP_HW2R1150M_HAW2R1300N(is_dhcp)) {
				Keyword.ReportStep_Pass(testCase, "Changed DHCP to :" + is_dhcp);
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change dhcp enable/disable settings");
				flag = false;
			}
			if (startip == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change starting ip address.");
			} else if (HawkingScreen.setstartip_HW2R1150M_HAW2R1300N(startip)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "DHCP START IP is set to " + startip);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change Starting IP Address in DHCP setting");
				flag = false;
			}
			if (endip == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change end ip address.");
			} else if (HawkingScreen.setendip_HW2R1150M_HAW2R1300N(endip)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "DHCP START IP is set to " + endip);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change ending IP Address in DHCP setting");
				flag = false;
			}
			if (LeaseTime == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
			} else if (HawkingScreen.setvalueinDHCPLeaseTime_HW2R1150M_HAW2R1300N(LeaseTime)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change DHCP Lease time in DHCP setting");
				flag = false;
			}
		}else if(screename.contains("DNS")){
			if(routerModel.contains("HW2R1300M")) {
				flag = changeWebPage(testCase, baseURL, "/haw2r1_01_02_02_ddns.asp", "DNS", routerModel);
			}else if(routerModel.contains("HAW2R1300N")) {
				flag = changeWebPage(testCase, baseURL, "/hw2r1_01_02_02_ddns.asp", "DNS", routerModel);
			}
			if (is_dns == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change is_dns");
			} else if (HawkingScreen.is_dns_Hawking(is_dns)) {
				Keyword.ReportStep_Pass(testCase, "Changed is_dns to :" + is_dns);
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change is_dns settings");
				flag = false;
			}
			if (provider == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change provider in dns settings");
			} else if (HawkingScreen.set_Provider(provider)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "provider is set to " + provider);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change provider in DNS setting");
				flag = false;
			}
			if (domain == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change domain");
			} else if (HawkingScreen.SetDomain(domain)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "domain is set to " + domain);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change domain in DNS setting");
				flag = false;
			}
			if (account == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change account");
			} else if (HawkingScreen.SetAccount(account)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "account is set to " + account);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to account in DNS setting");
				flag = false;
			}
			if (dns_key == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change account");
			} else if (HawkingScreen.SetDnsKey(dns_key)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "dns_key is set to " + dns_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to dns_key in DNS setting");
				flag = false;
			}
		}
		if (flag) {
			if (HawkingScreen.clickonApplybutton1_HW2R1150M_HAW2R1300N(screename)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Apply Button1 Clicked");
				if (HawkingScreen.clickonApplybutton2_HW2R1150M_HAW2R1300N(screename)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Apply Button2 Clicked");
					if (HawkingScreen.clickonOk_HW2R1150M_HAW2R1300N(screename)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Ok Button Clicked");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click on Apply2 button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"not able to click on Apply2 button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on Apply1 button");
				flag = false;
			}
		}
		return flag;
	}

}