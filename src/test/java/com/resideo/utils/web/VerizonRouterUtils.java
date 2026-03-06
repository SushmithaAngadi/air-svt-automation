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
import com.resideo.utils.web.screens.VerizonRouterScreen;

public class VerizonRouterUtils {

	public static String PageSource(String screenName, String RouterModel) {
		String pagecontainer = null;
		switch (RouterModel) {
		case "MI424WR":
			switch (screenName) {
			case "HOME SETTINGS":
				pagecontainer = "MAIN";
				break;
			case "ADVANCED SECURITY SETTINGS":
				pagecontainer = "ADVANCED SECURITY SETTINGS";
				break;
			case "SECURITY SETTING":
				pagecontainer = "BASIC SECURITY SETTINGS";
				break;
			case "DHCP":
				pagecontainer = "IP ADDRESS DISTRIBUTION";
				break;
			default:
				pagecontainer = "";
				break;
			}
		}
		return pagecontainer;
	}

	public static String getRouterSettings_MI4242R(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
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
						requestValue = "Automatic";
					}
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID NAME is", "").trim();
					break;
				} else if (parameterArray[i].contains("WIRELESS_STATUS")
						&& requestParameter.contains("WIRELESS_STATUS")) {
					if (parameterArray[i].contains("OFF")) {
						requestValue = "OFF";
					} else {
						requestValue = "ON";
					}
					break;
				} else if (parameterArray[i].contains("ADV_WEP_MODE") && requestParameter.contains("ADV_WEP_MODE")) {
					if (parameterArray[i].contains("WEP ONLY")) {
						requestValue = "WEP Only";
					} else if (parameterArray[i].contains("802.1X")) {
						requestValue = "802.1X";
					}
					break;
				} else if (parameterArray[i].contains("WEP_STATUS") && requestParameter.contains("WEP_STATUS")) {
					if (parameterArray[i].contains("OFF")) {
						requestValue = "OFF";
					} else {
						requestValue = "ON";
					}
					break;
				} else if (parameterArray[i].contains("WEP_BIT") && requestParameter.contains("WEP_BIT")) {
					if (parameterArray[i].contains("64_40")) {
						requestValue = "64/40 bit";
					} else if (parameterArray[i].contains("128_104")) {
						requestValue = "128/104 bit";
					}
					break;
				} else if (parameterArray[i].contains("WEP_LENGTH") && requestParameter.contains("WEP_LENGTH")) {
					if (parameterArray[i].contains("64_40")) {
						requestValue = "64/40 bit";
					} else if (parameterArray[i].contains("128_104")) {
						requestValue = "128/104 bit";
					}
					break;
				} else if (parameterArray[i].contains("WEP_MODE") && requestParameter.contains("WEP_MODE")) {
					if (parameterArray[i].contains("HEX")) {
						requestValue = "Hex";
					} else if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					}
					break;
				} else if (parameterArray[i].contains("KEY_CODE") && requestParameter.contains("KEY_CODE")) {
					requestValue = parameterArray_Value[i].replace("KEY_CODE is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA")) {
						requestValue = "WPA";
					} else if (parameterArray[i].contains("WPA2")) {
						requestValue = "WPA2";
					}
					break;
				} else if (parameterArray[i].contains("AUTHENTICATION_WPA")
						&& requestParameter.contains("AUTHENTICATION_WPA")) {
					if (parameterArray[i].contains("PRESHARED KEY")) {
						requestValue = "Pre-Shared Key";
					} else if (parameterArray[i].contains("802.1X")) {
						requestValue = "802.1X";
					}
					break;
				} else if (parameterArray[i].contains("ENCRY_ALGO") && requestParameter.contains("ENCRY_ALGO")) {
					if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP_AES")) {
						requestValue = "TKIP and AES";
					}
					break;
				} else if (parameterArray[i].contains("WPA_PSK_MODE") && requestParameter.contains("WPA_PSK_MODE")) {
					if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					} else if (parameterArray[i].contains("HEX")) {
						requestValue = "Hex";
					}
					break;
				} else if (parameterArray[i].contains("ENTRY_METHOD") && requestParameter.contains("ENTRY_METHOD")) {
					if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					} else if (parameterArray[i].contains("HEX")) {
						requestValue = "Hex";
					}
					break;
				}else if (parameterArray[i].contains("WPA_KEY") && requestParameter.contains("WPA_KEY")) {
					requestValue = parameterArray_Value[i].replace("WPA_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("WEP_KEY") && requestParameter.contains("WEP_KEY")) {
					requestValue = parameterArray_Value[i].replace("WEP_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_IP") && requestParameter.contains("RADIUS_IP")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_PORT") && requestParameter.contains("RADIUS_PORT")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_PORT is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS_SHARED_KEY")
						&& requestParameter.contains("RADIUS_SHARED_KEY")) {
					requestValue = parameterArray_Value[i].replace("RADIUS_SHARED_KEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("NETWORK_AUTH") && requestParameter.contains("NETWORK_AUTH")) {
					if (parameterArray[i].contains("OPEN SYSTEM")) {
						requestValue = "Open System Authentication";
					} else if (parameterArray[i].contains("SHARED KEY")) {
						requestValue = "Shared Key Authentication";
					} else if (parameterArray[i].contains("BOTH")) {
						requestValue = "Both";
					}
					break;
				} else if (parameterArray[i].contains("IS_DHCP") && requestParameter.contains("IS_DHCP")) {
					if (parameterArray[i].contains("DISABLE")) {
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("DHCP_SERVER")) {
						requestValue = "DHCP Server";
					} else if (parameterArray[i].contains("DHCP_RELAY")) {
						requestValue = "DHCP Relay";
					}
					break;
				}else if (parameterArray[i].contains("START_IP") && requestParameter.contains("START_IP")) {
					requestValue = parameterArray_Value[i].replace("START_IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("END_IP") && requestParameter.contains("END_IP")) {
					requestValue = parameterArray_Value[i].replace("END_IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("LEASE TIME") && requestParameter.contains("LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("LEASE TIME is", "").trim();
					break;
				}
			}
		}
		return requestValue;
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
						String pageSource = driver.getPageSource().toUpperCase();
						if(pageSource.contains("NO MORE THAN 5 SESSIONS AT A TIME ARE ALLOWED")) {
							
							return false; 
						}else {
							if (pageSource.contains(PageSource(screenName, RouterModel))) {
								return true;
							} else
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

	public static boolean changeRouterSettingsInVerizon(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "ROUTER_MODEL")
					.toUpperCase().trim();
			switch (routerModel) {
			case "MI424WR":
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
				flag = _MI42424_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings_MI4242R(dataOptions, "CHANNEL"),
						getRouterSettings_MI4242R(dataOptions, "SSID NAME"),
						getRouterSettings_MI4242R(dataOptions, "WIRELESS_STATUS"),
						getRouterSettings_MI4242R(dataOptions, "WEP_STATUS"),
						getRouterSettings_MI4242R(dataOptions, "WEP_BIT"),
						getRouterSettings_MI4242R(dataOptions, "WEP_MODE"),
						getRouterSettings_MI4242R(dataOptions, "KEY_CODE"),
						getRouterSettings_MI4242R(dataOptions, "SECURITY"),
						getRouterSettings_MI4242R(dataOptions, "AUTHENTICATION_WPA"),
						getRouterSettings_MI4242R(dataOptions, "ENCRY_ALGO"),
						getRouterSettings_MI4242R(dataOptions, "WPA_PSK_MODE"),
						getRouterSettings_MI4242R(dataOptions, "WPA_KEY"),
						getRouterSettings_MI4242R(dataOptions, "RADIUS_IP"),
						getRouterSettings_MI4242R(dataOptions, "RADIUS_PORT"),
						getRouterSettings_MI4242R(dataOptions, "RADIUS_SHARED_KEY"),
						getRouterSettings_MI4242R(dataOptions, "ADV_WEP_MODE"),
						getRouterSettings_MI4242R(dataOptions, "NETWORK_AUTH"),
						getRouterSettings_MI4242R(dataOptions, "WEP_LENGTH"),
						getRouterSettings_MI4242R(dataOptions, "ENTRY_METHOD"),
						getRouterSettings_MI4242R(dataOptions, "WEP_KEY"),
						getRouterSettings_MI4242R(dataOptions, "IS_DHCP"),
						getRouterSettings_MI4242R(dataOptions, "START_IP"),
						getRouterSettings_MI4242R(dataOptions, "END_IP"),
						getRouterSettings_MI4242R(dataOptions, "LEASE TIME"));

				if (flag) {
					String security = getRouterSettings_MI4242R(dataOptions, "SECURITY");
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

	private static boolean _MI42424_Model_chaneRouterSettings(TestCases testCase, String screenName, String channel,
			String ssid_name, String wireless_status, String wep_status, String wep_bit, String wep_mode,
			String key_code, String security, String auth_wpa, String encry_algo, String wpa_psk_mode, String wpa_key,
			String radius_ip, String radius_port, String radius_password, String adv_wep_mode, String network_auth,
			String wep_length, String entry_method, String wep_key,String is_dhcp, String start_ip, String end_ip, String lease_time) {
		boolean flag = true;
		VerizonRouterScreen verizonScreen = new VerizonRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.WEB_APP, "ROUTER_MODEL")
					.toUpperCase();
			flag = flag && verizonScreen.clickOnWirlessSetting_MI42424();
			if (flag && screenName.contains("ADVANCED SECURITY SETTINGS")) {
				if (verizonScreen.clickAdvancedSecuritySettings_MI42424()
						&& changeWebPage(testCase, null, null, "ADVANCED SECURITY SETTINGS", routerModel)) {
					if (security == null) {
						Keyword.ReportStep_Pass(testCase, "No need to change security");
						flag = true;
					} else if (security.toUpperCase().contains("WPA") && verizonScreen.SetSecurity_MI42424(security)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfuly changed the security " + security);
						if (auth_wpa == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change auth_wpa");
						} else if (verizonScreen.SetAuthWPA_MI42424(auth_wpa)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"Successfuly changed the Authentication in WPA to :" + auth_wpa);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change auth_wpa in WPA");
							flag = false;
						}
						if (encry_algo == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change encry_algo.");
						} else if (verizonScreen.SetEncryAlgo_WPA_MI42424(encry_algo)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly changed the Encry a to :" + encry_algo);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change encry_algo");
							flag = false;
						}
						if (wpa_psk_mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change wpa_psk_mode");
						} else if (verizonScreen.SetWPA_PSK_MODE_MI42424(wpa_psk_mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"Successfuly changed the WPA PSK MODE to :" + wpa_psk_mode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change wpa_psk_mode");
							flag = false;
						}
						if (wpa_key == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change WPA key");
						} else if (verizonScreen.SetWPAkey_MI42424(wpa_psk_mode, wpa_key)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly changed the WEP Key to :" + wpa_key);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change WPA Key");
							flag = false;
						}
						if (radius_ip == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
						} else if (verizonScreen.setRadiusIP_MIM424WR(radius_ip)) {
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
						} else if (verizonScreen.setRadiusPort_MIM424WR(radius_port)) {
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
						} else if (verizonScreen.setRadiusPassword_MIM424WR(radius_password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusPassword to " + radius_password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusPassword in Wireless setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("WEP") && verizonScreen.SetSecurity_MI42424(security)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfuly changed the security " + security);
						if (adv_wep_mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change adv_wep_mode.");
						} else if (verizonScreen.setAdvanceWEP_MIM424WR(adv_wep_mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change WEP Mode to " + adv_wep_mode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change WEP MODE in advanced setting");
							flag = false;
						}
						if (network_auth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change network_auth.");
						} else if (verizonScreen.setNetworkAuth_MIM424WR(network_auth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change network_auth to " + network_auth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change network_auth");
							flag = false;
						}
						if (wep_length == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change wep_length");
						} else if (verizonScreen.setWEPLength_MIM424WR(wep_length)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change wep_length to " + wep_length);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change wep_length");
							flag = false;
						}if (entry_method == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change entry_method.");
						} else if (verizonScreen.setEntryMethod_MIM424WR(entry_method)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change entry_method to " + entry_method);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change network_auth");
							flag = false;
						}
						if (wep_key == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change wep_key");
						} else if (verizonScreen.setWEPKey_MIM424WR(wep_key,wep_length, entry_method)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change wep_key to " + wep_key);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change wep_key");
							flag = false;
						}if (radius_ip == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
						} else if (verizonScreen.setRadiusIP_WEP_MIM424WR(radius_ip)) {
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
						} else if (verizonScreen.setRadiusPort_WEP_MIM424WR(radius_port)) {
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
						} else if (verizonScreen.setRadiusPassword_MIM424WR(radius_password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change RadiusPassword to " + radius_password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change RadiusPassword in Wireless setting");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Security in Advanced settings");
						flag = false;
					}
				}
			} else if (flag && screenName.contains("SECURITY SETTING")) {
				if (verizonScreen.clickBasicSecuritySettings_MI42424()
						&& changeWebPage(testCase, null, null, "SECURITY SETTING", routerModel)) {
					if (wireless_status == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Wirless status.");
					} else if (verizonScreen.setWirlessStatus_MI42424(wireless_status)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"Successfuly changed the wireless status to :" + wireless_status);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Wireless status");
						flag = false;
					}
					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (verizonScreen.changeChannel_MI42424(channel)) {
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
					} else if (verizonScreen.setSSIDName_MI42424(ssid_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
						flag = false;
					}
					if (wep_status == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change WEP STATUS.");
					} else if (verizonScreen.SetWEPStatus_MI42424(wep_status)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfuly changed the WEP STATUS to :" + wep_status);
						if (wep_bit == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change wep_bit");
						} else if (verizonScreen.SetWEPBit_MI42424(wep_bit)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly changed the WEP STATUS to :" + wep_bit);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change wep_bit");
							flag = false;
						}
						if (wep_mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change WEP Mode.");
						} else if (verizonScreen.SetWEPMode_MI42424(wep_mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly changed the WEP STATUS to :" + wep_mode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change WEP Mode");
							flag = false;
						}
						if (key_code == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change key_code");
						} else if (verizonScreen.SetKeyCode_MI42424(key_code, wep_bit, wep_mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly changed the WEP STATUS to :" + key_code);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change key_code");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change WEP STATUS");
						flag = false;
					}
				}
			}else if (flag && screenName.contains("DHCP")) {
				flag = flag && verizonScreen.clickOnAdvanced_MI42424();
				flag = flag && verizonScreen.EnterDHCPSettings_MI42424();
				if (verizonScreen.clickIPAddressAllocation_MI42424()
						&& changeWebPage(testCase, null, null, "DHCP", routerModel)) {
					flag = flag && verizonScreen.clickEdit_MI42424();
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change IS_DHCP.");
					} else if (verizonScreen.IS_DHCP_MI424WR(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "IS_DHCP is set to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP setting");
						flag = false;
					}
					if (start_ip == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change starting ip address.");
					} else if (verizonScreen.setstartip_MI424WR(start_ip)) {
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
					} else if (verizonScreen.setendip_MI424WR(end_ip)) {
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
					} else if (verizonScreen.setvalueinDHCPLeaseTime__MI424WR(lease_time)) {
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
				if (verizonScreen.ClickOnApplyBtn()) {
					if (verizonScreen.clickAttentionApply_MIM424WR(screenName)) {
						if(verizonScreen.ClickClose(screenName)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Attention Apply Button Clicked");
						}else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to click close after apply button");
							flag = false;
						}
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Attention Apply Button Clicked");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click attention apply button");
						flag = false;
					}
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