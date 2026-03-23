package com.resideo.utils.web;

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
import com.resideo.utils.web.screens.BelkinRouterScreen;

public class BelkinRouterUtils {

	public static boolean changeRouterSettingsInBelkin(TestCases testCase, String screenName, String dataOptions) {

		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();
			switch (routerModel) {
			case "F9K1102V1":
				flag = _F9K1102v1_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "IS SSID"), getRouterSettings(dataOptions, "IS DHCP"),
						getRouterSettings(dataOptions, "AUTHENTICATION"),
						getRouterSettings(dataOptions, "STARTING IP ADDRESS"),
						getRouterSettings(dataOptions, "ENDING IP ADDRESS"),
						getRouterSettings(dataOptions, "LEASE TIME"));
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
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception occurred due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode _F9K1102v1_Model_chaneRouterSecuritySettings(String securityType_request) {
		WifiSecurityMode securityType = null;
		String security_Type = WebController.router_SSID_securityType().toUpperCase();
		if (securityType_request != null) {
			security_Type = securityType_request.toUpperCase();
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
		if (security_Type.contains("DISABLED")) {
			securityType = WifiSecurityMode.NONE;
		} else if (security_Type.contains("WEP")) {
			securityType = WifiSecurityMode.WEP_Shared;
		} else if (security_Type.contains("WPA_WPA2") || security_Type.contains("WPA/WPA2")) {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}
		return securityType;
	}

	public static boolean _F9K1102v1_Model_chaneRouterSettings(TestCases testCase, String screename, String frequency,
			String channel, String mode, String security, String password, String ssid_name, String is_ssid,
			String is_dhcp, String WPA_WPA_2_Auth, String Ip_Starting_Add, String Ip_Ending_Add,
			String dhcp_LeaseTime) {
		boolean flag = true;
		BelkinRouterScreen belkinScreen = new BelkinRouterScreen(testCase);
		try {
			if (screename.contains("SECURITY")) {
				if (security == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change security.");
				} else {
					flag = flag && belkinScreen.acceptAlert();
					flag = flag && belkinScreen.switchToDefaultFrame() && belkinScreen.switchToMainFrame();
					if (belkinScreen.clickOnSecurity()) {
						flag = flag && belkinScreen.acceptAlert();
						if (frequency.toUpperCase().contains("2.4")) {
							flag = flag & belkinScreen.switchToiFrame2Ghz();
						} else {
							flag = flag & belkinScreen.switchToiFrame5Ghz();
						}

						if (security.toUpperCase().contains("DISABLED")) {
							if (belkinScreen.clickOnSecurity2GType("Disabled")) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, "DISABLED", null);
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to set security as none");
							}
						} else if (security.toUpperCase().contains("64BIT WEP")) {
							if (belkinScreen.clickOnSecurity2GType("64bit WEP")) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, "64BIT WEP", null);
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to set security as 66bit wep");
							}
							if (belkinScreen.acceptAlert()) {
								flag = true;
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Failed to Accept the Alert");
							}
							if (belkinScreen.enable_disable_PassPhrase("YES")) {
								if (belkinScreen.setPassPhrase("BELKIN")) {
									flag = true;
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Failed to Set value for PassPhrase.");
								}
								if (belkinScreen.clickOnGenerate()) {
									flag = true;
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Failed to click on Generate Button.");
								}
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Failed to enable PassPhrase check box.");
							}
						} else if (security.toUpperCase().contains("128BIT WEP")) {
							if (belkinScreen.clickOnSecurity2GType("128bit WEP")) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, "128BIT WEP", null);
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to set security as 128bit WEP");
							}
							if (belkinScreen.acceptAlert()) {
								flag = true;
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Failed to Accept the Alert");
							}
							if (belkinScreen.enable_disable_PassPhrase("YES")) {
								if (belkinScreen.setPassPhrase("BELKIN")) {
									flag = true;
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Failed to Set value for PassPhrase.");
								}
								if (belkinScreen.clickOnGenerate()) {
									flag = true;
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Failed to click on Generate Button.");
								}
							}
						} else if (security.toUpperCase().contains("WPA/WPA2-PERSONAL (PSK)")
								|| security.toUpperCase().contains("WPA_WPA2-PERSONAL (PSK)")) {
							if (belkinScreen.clickOnSecurity2GType("WPA/WPA2-Personal (PSK)")) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, "WPA_WPA2-PERSONAL (PSK)", null);
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to set security as wpa wpa2 mixed");
							}

							if (WPA_WPA_2_Auth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPencrpytion.");
							} else if (((security.contains("WPA/WPA2-PERSONAL"))
									|| security.contains("WPA_WPA2-PERSONAL"))
									&& belkinScreen.changeWAPAuthenctication(WPA_WPA_2_Auth)) {
								flag = true;
								if (frequency.contains("2")) {
									if (WPA_WPA_2_Auth.contains("WPA-PSK")) {
										WebController.changeWifiSSID_Password(null, null, null, "TSK");
									} else if (WPA_WPA_2_Auth.contains("WPA2-PSK")) {
										WebController.changeWifiSSID_Password(null, null, null, "AES");
									} else if (WPA_WPA_2_Auth.contains("WPA-PSK+WPA2-PSK")) {
										WebController.changeWifiSSID_Password(null, null, null, "TSK_AES");
									}
								} else {
									WebController.changeWifiSSID_Password(null, null, null, "AES");
								}
								WebController.changeWifiSSID_Password(null, null, null, WPA_WPA_2_Auth.toUpperCase());
								Keyword.ReportStep_Pass(testCase, "Change WEPencrpytion to " + WPA_WPA_2_Auth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEP ");
								flag = false;
							}

							if (password == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change password.");
							} else {
								if (belkinScreen.setPreSharedKey(password)) {
									flag = true;
									Keyword.ReportStep_Pass(testCase, "Change password Succesfully.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Failed to change password ");
									flag = false;
								}
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Belkin router with this model doesn't support " + security + " Security option");
							flag = flag && belkinScreen.switchToDefaultFrame();
							return false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click on Security.");
						flag = flag && belkinScreen.switchToDefaultFrame();
						return false;
					}
				}
			} else if (screename.contains("CHANNEL AND SSID")) {
				flag = flag && belkinScreen.acceptAlert();
				flag = flag && belkinScreen.switchToDefaultFrame() && belkinScreen.switchToMainFrame();
				if (belkinScreen.clickOnChannelSssid()) {
					if (frequency.contains("5")) {
						flag = flag & belkinScreen.switchToiFrameId5Ghz();
					}
					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else {
						if (frequency.contains("2.4") && belkinScreen.select2GChannelNumber(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else if (frequency.contains("5") && belkinScreen.select5GChannelNumber(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless Setting");
							flag = false;
						}
					}
					if (mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else {
						if (frequency.contains("2.4") && belkinScreen.select2GModeType(mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
						} else if (frequency.contains("5") && belkinScreen.select5GModeType(mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change Mode in Wireless Setting");
							flag = false;
						}
					}
					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
					} else if (frequency.toUpperCase().contains("2.4GHZ")) {
						if (is_ssid.contains("YES") && !belkinScreen.isBroadCastSSID2GEnabled()) {
							flag = flag && belkinScreen.clickOnBroadCastSSID2G();
							Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
						} else if (is_ssid.contains("NO") && belkinScreen.isBroadCastSSID2GEnabled()) {
							flag = flag && belkinScreen.clickOnBroadCastSSID2G();
							Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
						} else if (is_ssid.contains("YES") && belkinScreen.isBroadCastSSID2GEnabled()) {
							Keyword.ReportStep_Pass(testCase, "broadcast SSID is already enabled for 2.4 GHZ band");
						} else {
							Keyword.ReportStep_Pass(testCase, "broadcast SSID is already disabled for 2.4 GHZ band");
						}
					}
					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to ssid_name password.");
					} else if (frequency.contains("2.4") && belkinScreen.setvalueinSSID24(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
					} else if (frequency.contains("5") && belkinScreen.setvalueinSSID5(ssid_name)) {
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
							"Not able to click on channel and ssid.");
					flag = false;
				}

			} else if (screename.contains("DHCP")) {
				flag = belkinScreen.switchToDefaultFrame();
				flag = flag & belkinScreen.switchToMainFrame();
				if (belkinScreen.clickOnLanSettings()) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (belkinScreen.enable_disable_DHCP(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}
					if (Ip_Starting_Add == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Ip_Starting_Add.");
					} else {
						if (belkinScreen.set_Ip_Starting_Add(Ip_Starting_Add)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Succesfully changed Ip_Starting_Add.");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change Ip_Starting_Add");
							flag = false;
						}
					}
					if (Ip_Ending_Add == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Ip_Ending_Add.");
					} else {
						if (belkinScreen.set_Ip_Ending_Add(Ip_Ending_Add)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Succesfully changed Ip_Ending_Add.");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change Ip_Ending_Add");
							flag = false;
						}
					}
					if (dhcp_LeaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp LeaseTime.");
					} else {
						if (belkinScreen.selectDhcpLeaseTime(dhcp_LeaseTime)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Succesfully changed dhcp LeaseTime.");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change dhcp LeaseTime");
							flag = false;
						}
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on LAN Settings.");
					flag = false;
				}
			}
			if (clickOnapplyChangesMade(testCase)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Succesfully changed setting.");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Apply Changes.");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception occurred due to " + e.getMessage());
			return false;
		}

		return flag;
	}

	private static boolean clickOnapplyChangesMade(TestCases testCase) {
		BelkinRouterScreen belkinScreen = new BelkinRouterScreen(testCase);
		boolean flag = belkinScreen.switchToDefaultFrame();
		flag = flag & belkinScreen.switchToMainFrame();
		if (belkinScreen.clickOnapplyChangesMade()) {
			try {
				Thread.sleep(42000);
				flag = flag && belkinScreen.acceptAlert();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (checkPageLoadingComplete(testCase)) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public static boolean checkPageLoadingComplete(TestCases testCase) {
		Boolean flag = true;
		BelkinRouterScreen belkinScreen = new BelkinRouterScreen(testCase);
		try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
			fwait.pollingEvery(Duration.ofSeconds(5));
			fwait.withTimeout(Duration.ofSeconds(60));
			fwait.ignoring(Exception.class);
			Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (belkinScreen.isApplyingChanges()) {
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
					if (parameterArray[i].contains("OFF")) {
						requestValue = "Off";
					} else if (parameterArray[i].contains("N")) {
						requestValue = "802.11n";
					} else if (parameterArray[i].contains("A")) {
						requestValue = "802.11a";
					} else if (parameterArray[i].contains("A_N")) {
						requestValue = "802.11a&802.11n";
					} else if (parameterArray[i].contains("G")) {
						requestValue = "802.11g";
					} else if (parameterArray[i].contains("B_G_N")) {
						requestValue = "802.11b&802.11g&802.11n";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					if (parameterArray[i].contains("20_40")) {
						requestValue = "20/40 MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					}
					break;
				} else if (parameterArray[i].contains("AUTHENTICATION")
						&& requestParameter.contains("AUTHENTICATION")) {
					if (parameterArray[i].contains("WPA-PSK+WPA2-PSK")) {
						requestValue = "WPA-PSK+WPA2-PSK";
					} else if (parameterArray[i].contains("WPA-PSK")) {
						requestValue = "WPA-PSK";
					} else if (parameterArray[i].contains("WPA2-PSK")) {
						requestValue = "WPA2-PSK";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("5")) {
						requestValue = "5GHz";
					} else if (parameterArray[i].contains("2.4")) {
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
					if (parameterArray[i].contains("DISABLED".toUpperCase())) {
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("64bit WEP".toUpperCase())) {
						requestValue = "64bit WEP";
					} else if (parameterArray[i].contains("128bit WEP".toUpperCase())) {
						requestValue = "128bit WEP";
					} else if (parameterArray[i].contains("WPA/WPA2-Personal".toUpperCase())
							|| parameterArray[i].contains("WPA_WPA2-Personal".toUpperCase())) {
						requestValue = "WPA/WPA2-Personal (PSK)";
					}
					break;

				} else if (parameterArray[i].contains("WPAAUTH") && requestParameter.contains("WPAAUTH")) {
					if (parameterArray[i].contains("WPA2-PSK".toUpperCase())) {
						requestValue = "WPA2-PSK";
					} else if (parameterArray[i].contains("WPA2-PSK".toUpperCase())) {
						requestValue = "WPA2-PSK";
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
				} else if (parameterArray[i].contains("DHCP STARTING IP ADDRESS")
						&& requestParameter.contains("STARTING IP ADDRESS")) {
					requestValue = parameterArray_Value[i].replace("DHCP Starting IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP ENDING IP ADDRESS")
						&& requestParameter.contains("ENDING IP ADDRESS")) {
					requestValue = parameterArray_Value[i].replace("DHCP Ending IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("LEASE") && requestParameter.contains("LEASE")) {
					if (parameterArray[i].contains("Forever".toUpperCase())) {
						requestValue = "Forever";
					} else if (parameterArray[i].contains("Half Hour".toUpperCase())) {
						requestValue = "Half Hour";
					} else if (parameterArray[i].contains("1 Hour".toUpperCase())) {
						requestValue = "1 Hour";
					} else if (parameterArray[i].contains("Two Hours".toUpperCase())) {
						requestValue = "Two Hours";
					} else if (parameterArray[i].contains("Half Day".toUpperCase())) {
						requestValue = "Half Day";
					} else if (parameterArray[i].contains("One Day".toUpperCase())) {
						requestValue = "One Day";
					} else if (parameterArray[i].contains("Two Days".toUpperCase())) {
						requestValue = "Two Days";
					} else if (parameterArray[i].contains("One Week".toUpperCase())) {
						requestValue = "One Week";
					} else if (parameterArray[i].contains("Two Weeks".toUpperCase())) {
						requestValue = "Two Weeks";
					}
					break;

				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

}