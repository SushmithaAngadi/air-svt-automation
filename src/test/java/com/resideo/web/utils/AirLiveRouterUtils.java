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
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.AirLiveRouterScreen;

public class AirLiveRouterUtils {
	public static String getRouterSettings(String data, String requestParameter) {
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
				} else if (parameterArray[i].contains("WEP KEY MODE") && requestParameter.contains("WEP KEY MODE")) {
					if (parameterArray[i].contains("HEX")) {
						requestValue = "HEX";
					} else if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {

					if (parameterArray[i].contains("B_G_N")) {
						requestValue = "B_G_N";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "G ONLY";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "B ONLY";
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
					if (parameterArray[i].contains("NONE")) {
						requestValue = "None";
					} else if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("RADIUS")) {
						requestValue = "802.1x and RADIUS";
					} else if (parameterArray[i].contains("WPA_PSK_WPA2_PSK")) {
						requestValue = "WPA-PSK / WPA2-PSK";
					} else if (parameterArray[i].contains("WPA_WPA2")) {
						requestValue = "WPA / WPA2";
					} else if (parameterArray[i].contains("WPA_PSK")) {
						requestValue = "WPA-PSK";
					} else if (parameterArray[i].contains("WPA")) {
						requestValue = "WPA";
					} else if (parameterArray[i].contains("WPA2_PSK")) {
						requestValue = "WPA2-PSK";
					} else if (parameterArray[i].contains("WPA2")) {
						requestValue = "WPA2";
					}
					break;
				} else if (parameterArray[i].contains("KEY LENGTH") && requestParameter.contains("KEY LENGTH")) {
					if (parameterArray[i].contains("64")) {
						requestValue = "64 bits";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "128 bits";
					}
					break;

				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else {
						requestValue = "MIXED";
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
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("Lease time is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("Radius IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is", "").trim();
					break;
				} else if (parameterArray[i].contains("PRESHARED KEY MODE")
						&& requestParameter.contains("PRESHARED KEY MODE")) {
					requestValue = parameterArray_Value[i].replace("PreShared Key Mode is", "").trim();
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
			pagecontainer = "Wireless Router".toUpperCase();
			break;

		case "WIRELESS SETTING":
			pagecontainer = "Wireless Setting".toUpperCase();
			break;
		case "DHCP SETTING":
			pagecontainer = "DHCP Server".toUpperCase();
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

	public static boolean changeRouterSettingsInAirLive(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "WN220N":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "", "HOME SETTINGS")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _WN220N_Model_chaneRouterSettings(testCase, screenName, baseurl,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "IS SSID"), getRouterSettings(dataOptions, "IS DHCP"),
						getRouterSettings(dataOptions, "WEP KEY MODE"), getRouterSettings(dataOptions, "ENCRYPTION"),
						getRouterSettings(dataOptions, "WEP KEY1"), getRouterSettings(dataOptions, "LEASE TIME"),
						getRouterSettings(dataOptions, "RADIUS IP"), getRouterSettings(dataOptions, "RADIUS PORT"),
						getRouterSettings(dataOptions, "PRESHARED KEY MODE"),
						getRouterSettings(dataOptions, "KEY LENGTH"));

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
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in changeRouterSettingsInAirLive(TestCases testCase, String screenName, String dataOptions)  due to "
							+ e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode _WN220N_Model_chaneRouterSecuritySettings(String securityType_request) {
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
		} else if (security_Type.contains("WPA") && security_Type.contains("WPA2")) {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		} else if (security_Type.contains("WPA2")) {
			if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			} else if (security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_TKIP_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			}
		} else if (security_Type.contains("WPA")) {
			if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_AES_PSK;
			} else if (security_Type.contains("TKIP".toUpperCase())) {
				securityType = WifiSecurityMode.WPA_TKIP_PSK;
			} else {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			}
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_Enterprise;
		}

		return securityType;
	}

	public static boolean _WN220N_Model_chaneRouterSettings(TestCases testCase, String screename, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String WEPKeyMode, String Encrpytion, String WEPKey1, String LeaseTime,
			String RadiusIP, String RadiusPort, String PresharedKeyMode, String KeyLength) {
		boolean flag = true;
		AirLiveRouterScreen AirLiveScreen = new AirLiveRouterScreen(testCase);
		try {
			if (screename.contains("WIRELESS SETTINGS")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/wpa.htm?rc=", "WIRELESS SETTINGS")) {
					if (!AirLiveScreen.enable_disable_Wireless("Enable")) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Wireless settings to Enable");
						flag = false;
					}

					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (AirLiveScreen.enable_disable_SSID(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change Hide SSID to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change broadcase SSID in Wireless setting");
						flag = false;
					}

					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (AirLiveScreen.setvalueinSSID(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to write broadcase SSID in wireless settings");
						flag = false;
					}

					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (AirLiveScreen.changeMode(mode)) {
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
					} else if (AirLiveScreen.changeChannel(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel in Wireless setting");
						flag = false;
					}

					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security.");

					} else if (security.toUpperCase().contains("NONE") && AirLiveScreen.changeSecurity(security)) {
						WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
						Keyword.ReportStep_Pass(testCase, "Change security to " + security);

					} else if (security.toUpperCase().contains("WEP") && AirLiveScreen.changeSecurity(security)) {
						WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);

						if (WEPKeyMode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change WEPKeyMode.");
						} else if (AirLiveScreen.selectWEPKeyMode(WEPKeyMode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change WEPKeyMode to " + WEPKeyMode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change WEPKeyMode in Wireless setting");
							flag = false;
						}
						if (KeyLength == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change KeyLength.");
						} else if (AirLiveScreen.selectWEPKeyLength(KeyLength)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change KeyLength to " + KeyLength);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change KeyLength in Wireless setting");
							flag = false;
						}
						if (WEPKey1 == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change WEPKey1.");
						} else if (AirLiveScreen.setWEPKey1(WEPKey1)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change WEPKey1 to " + WEPKey1);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change WEPKey1 in Wireless setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("RADIUS") && AirLiveScreen.changeSecurity(security)) {
						WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
						if (KeyLength == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change KeyLength.");
						} else if (AirLiveScreen.selectRadiusKeyLength(KeyLength)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change KeyLength to " + KeyLength);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change KeyLength in Wireless setting");
							flag = false;
						}
						if (RadiusIP == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
						} else if (AirLiveScreen.setRadiusIP(RadiusIP)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + RadiusIP);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusIP in Wireless setting");
							flag = false;
						}
						if (RadiusPort == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
						} else if (AirLiveScreen.setRadiusPort(RadiusPort)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + RadiusPort);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusPort in Wireless setting");
							flag = false;
						}
					} else if ((security.toUpperCase().contains("WPA-PSK")
							|| security.toUpperCase().contains("WPA2-PSK")
							|| security.toUpperCase().contains("WPA-PSK / WPA2-PSK"))
							&& AirLiveScreen.changeSecurity(security)) {
						WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
						if (!security.contains("WPA-PSK / WPA2-PSK")) {
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion.");
							} else if (AirLiveScreen.selectWPA_PSK_Encrpytion(Encrpytion)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change Encrpytion to " + Encrpytion);
								WebController.changeWifiSSID_Password(null, null, null, Encrpytion.toUpperCase());
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion in Wireless setting");
								flag = false;
							}
						} else {
							WebController.changeWifiSSID_Password(null, null, null, "MIXED");
						}
						if (PresharedKeyMode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change PresharedKeyMode.");
						} else if (AirLiveScreen.selectPresharedKeyMode(PresharedKeyMode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change PresharedKeyMode to " + PresharedKeyMode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change PresharedKeyMode in Wireless setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (AirLiveScreen.setValueinPassword_WPAPSK(password)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, password, null, null);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password from security settings");
							flag = false;
						}
					} else if ((security.toUpperCase().contains("WPA") || security.toUpperCase().contains("WPA2")
							|| security.toUpperCase().contains("WPA / WPA2"))
							&& AirLiveScreen.changeSecurity(security)) {
						WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);

						if (!security.contains("WPA / WPA2")) {
							if (Encrpytion == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Encrpytion.");
							} else if (AirLiveScreen.selectWPA_PSK_Encrpytion(Encrpytion)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, null, Encrpytion.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "Change Encrpytion to " + Encrpytion);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Encrpytion in Wireless setting");
								flag = false;
							}
						} else {
							WebController.changeWifiSSID_Password(null, null, null, "MIXED");
						}
						if (RadiusIP == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
						} else if (AirLiveScreen.setRadiusIP(RadiusIP)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + RadiusIP);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusIP in Wireless setting");
							flag = false;
						}
						if (RadiusPort == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
						} else if (AirLiveScreen.setRadiusPort(RadiusPort)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + RadiusPort);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusPort in Wireless setting");
							flag = false;
						}
					}

				}
			} else if (screename.contains("DHCP SETTINGS")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/dhcp.htm?rc=", "DHCP SETTINGS")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (AirLiveScreen.enable_disable_DHCP(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}
					if (LeaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
					} else if (AirLiveScreen.setvalueinDHCPLeaseTime(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen name");
				flag = false;
			}
			if (flag) {
				if (AirLiveScreen.clickOnSaveBtn()) {
					flag = true;
					if (AirLiveScreen.ClickOnReboot()) {
						if (AirLiveScreen.clickOnAlertOK()) {
							Keyword.ReportStep_Pass(testCase, "Settings saved");
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Alert.");
						}
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Reboot Btn.");
					}

				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Ok button.");

				}
			}
		} catch (Exception e) {

		}
		return flag;
	}

}