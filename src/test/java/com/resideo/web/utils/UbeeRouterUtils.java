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
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.UbeeRouterScreen;

public class UbeeRouterUtils {

	public static String getRouterSettings_EVW320B_EVW321B_(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("104")) {
						requestValue = "104";
					} else if (parameterArray[i].contains("108")) {
						requestValue = "108";
					} else if (parameterArray[i].contains("112")) {
						requestValue = "112";
					} else if (parameterArray[i].contains("116")) {
						requestValue = "116";
					} else if (parameterArray[i].contains("120")) {
						requestValue = "120";
					} else if (parameterArray[i].contains("124")) {
						requestValue = "124";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "128";
					} else if (parameterArray[i].contains("132")) {
						requestValue = "132";
					} else if (parameterArray[i].contains("136")) {
						requestValue = "136";
					} else if (parameterArray[i].contains("140")) {
						requestValue = "140";
					} else if (parameterArray[i].contains("100")) {
						requestValue = "100";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12";
					} else if (parameterArray[i].contains("13")) {
						requestValue = "13";
					} else if (parameterArray[i].contains("36")) {
						requestValue = "36 ";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 ";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44 ";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48";
					} else if (parameterArray[i].contains("52")) {
						requestValue = "52";
					} else if (parameterArray[i].contains("56")) {
						requestValue = "56";
					} else if (parameterArray[i].contains("60")) {
						requestValue = "60";
					} else if (parameterArray[i].contains("64")) {
						requestValue = "64";
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
					} else if (parameterArray[i].contains("D")) {
						requestValue = "802.11d";
					} else if (parameterArray[i].contains("H")) {
						requestValue = "802.11h";
					}
					break;
				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("TKIP+AES") || parameterArray[i].contains("MIXED")) {
						requestValue = "TKIP+AES ";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES ";
					} else if (parameterArray[i].contains("64")) {
						requestValue = "WEP (64-bit)  ";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "WEP (128-bit)  ";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {

					if (parameterArray[i].contains("40")) {
						requestValue = "40 Mhz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 Mhz";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
						requestValue = "2.4 Ghz";
					} else {
						requestValue = "5 Ghz";
					}
					break;
				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
					requestValue = parameterArray_Value[i].replace("password is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("WPA2 PSK") || parameterArray[i].contains("WPA2 PSK")) {
						requestValue = "WPA2 PSK";
					} else if (parameterArray[i].contains("WPA PSK") || parameterArray[i].contains("WPA PSK")) {
						requestValue = "WPA PSK";
					} else if (parameterArray[i].contains("WPA2") || parameterArray[i].contains("WPA2")) {
						requestValue = "WPA2";
					} else if (parameterArray[i].contains("WPA") || parameterArray[i].contains("WPA")) {
						requestValue = "WPA";
					} else if (parameterArray[i].contains("WEP") || parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
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
					requestValue = parameterArray_Value[i].replace("DHCP Lease Time is ", "").trim();
					break;
				} else if (parameterArray[i].contains("PASSPHRASE") && requestParameter.contains("PASSPHRASE")) {
					requestValue = parameterArray_Value[i].replace("PassPhrase is ", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP START IP ADD")
						&& requestParameter.contains("DHCP START IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP Start IP Address is ", "").trim();
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

	public static String pageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "EVW320B":
			switch (screenName) {
			case "RADIO":
				pagecontainer = "This page allows configuration of the Wireless Radio including current country and channel number."
						.toUpperCase();
				break;
			case "PRIMARY NETWOEK":
				pagecontainer = "This page allows configuration of the Primary Wireless Network and its security settings."
						.toUpperCase();
				break;
			case "HOME SCREEN":
				pagecontainer = "Dit is de startpagina van uw modemrouter. De modemfabrikant biedt u de mogelijkheid om de instellingen"
						.toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "This page allows configuration and status of the optional internal DHCP server for the LAN."
						.toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "EVW321B":
			switch (screenName) {
			case "RADIO":
				pagecontainer = "This page allows configuration of the Wireless Radio including current channel number."
						.toUpperCase();
				break;
			case "PRIMARY NETWOEK":
				pagecontainer = "This page allows configuration of the Primary Wireless Network and its security settings."
						.toUpperCase();
				break;
			case "HOME SCREEN":
				pagecontainer = "\r\n"
						+ "				  		Dit is de startpagina van uw modemrouter. De modemfabrikant biedt u de mogelijkheid om de instellingen aan te passen. Alleen de standaardinstellingen \r\n"
						+ "				  		worden ondersteund door Ziggo. De uitgebreide instellingen kunt u wijzigen via de "
								.toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "This page allows configuration and status of the optional internal DHCP server for the LAN."
						.toUpperCase();
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
						if (pageSource.toUpperCase().contains(pageSource(screenName,routerModel))) {
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

	public static boolean changeRouterSettingsInUbee(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();
			String baseURL = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL").toUpperCase();

			switch (routerModel) {
			case "EVW320B":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://192.168.178.1", "/RgHome.asp", "HOME SCREEN", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _EVW320B_Model_chaneRouterSettings(testCase, screenName, baseURL, routerModel,
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "FREQUENCY"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "BANDWIDTH"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "CHANNEL"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "MODE"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "ENCRYPTION"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "PASSWORD"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "SSID NAME"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "IS DHCP"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "DHCP LEASE"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "DHCP START IP ADD"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "SECURITY"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "PASSPHRASE"));

				if (flag) {
					String security = getRouterSettings_EVW320B_EVW321B_(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "EVW321B":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://192.168.178.1", "/RgHome.asp", "HOME SCREEN", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _EVW321B_Model_chaneRouterSettings(testCase, screenName, baseURL, routerModel,
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "FREQUENCY"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "BANDWIDTH"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "CHANNEL"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "MODE"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "ENCRYPTION"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "PASSWORD"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "SSID NAME"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "IS DHCP"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "DHCP LEASE"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "DHCP START IP ADD"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "SECURITY"),
						getRouterSettings_EVW320B_EVW321B_(dataOptions, "PASSPHRASE"));

				if (flag) {
					String security = getRouterSettings_EVW320B_EVW321B_(dataOptions, "SECURITY");
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

	public static boolean _EVW320B_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String bandWidth, String channel, String Mode, String encryption,
			String password, String ssid_name, String is_dhcpEnable, String LeaseTime, String dhcpStartIP,
			String security, String passPhrase) {
		boolean flag = false;
		UbeeRouterScreen ubeeScreen = new UbeeRouterScreen(testCase);

		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (routerModel.contains("")) {

		}
		if (screenName.contains("WIRELESS") && screenName.contains("RADIO")) {
			if (changeWebPage(testCase, baseURL, "/wlanRadio.asp", "RADIO", routerModel)) {
				if (ubeeScreen.enable_disable_Wireless("Enabled")) {
					if (frequency == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
					} else if (ubeeScreen.changeFrequency(frequency)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed frequency to ." + frequency);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change frequency from wireless settings");
						flag = false;
					}
					if (bandWidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
					} else if (ubeeScreen.changeBandWidth(bandWidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed bandWidth to ." + bandWidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change bandWidth from wireless settings");
						flag = false;
					}

					if (Mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
					} else if (ubeeScreen.changeMode(Mode)) {
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
					} else if (ubeeScreen.changeChannel(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channel from Basic settings");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to set wireless to enable ");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to navogate wireless");
				flag = false;
			}
		} else if (screenName.contains("WIRELESS") && screenName.contains("PRIMARY NETWORK")) {
			if (changeWebPage(testCase, baseURL, "/wlanPrimaryNetwork.asp", "PRIMARY NETWOEK", routerModel)) {
				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change SSID Name.");
				} else if (ubeeScreen.setSSIDName(ssid_name)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
					flag = false;
				}
				if (security == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change security Type.");
				} else if (security.contains("WPA-PSK") || security.contains("WPA PSK")) {
					if (ubeeScreen.isWPA_PSK_Enable_Disable("Enable") && ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
						flag = true;
					} else {
						if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
							if (ubeeScreen.setWPA_PSKto("Enabled")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WPA PSK to enable");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set other security type to Disable");
							flag = false;
						}
					}
					WebController.changeWifiSSID_Password(null, null, security, null);
				} else if (security.contains("WPA2-PSK") || security.contains("WPA2 PSK")) {
					if (ubeeScreen.isWPA2_PSK_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
						flag = true;
					} else {
						if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
							if (ubeeScreen.setWPA2_PSKto("Enabled")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WPA2 PSK to enable");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set other security type to Disable");
							flag = false;
						}
					}
					WebController.changeWifiSSID_Password(null, null, security, null);
				} else if (security.contains("WPA2")) {
					if (ubeeScreen.isWPA_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWEP_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
						flag = true;
					} else {
						if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
							if (ubeeScreen.setWPA2to("Enabled")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WPA2 to enable");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set other security type to Disable");
							flag = false;
						}
					}
					WebController.changeWifiSSID_Password(null, null, security, null);
				} else if (security.contains("WPA")) {
					if (ubeeScreen.isWPA2_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWEP_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWPA_Enable_Disable("Disable")) {
						flag = true;
					} else {
						if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
							if (ubeeScreen.setWPAto("Enabled")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WPA to enable");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set other security type to Disable");
							flag = false;
						}
					}
					WebController.changeWifiSSID_Password(null, null, security, null);
				} else if (security.contains("WEP")) {
					if (ubeeScreen.isWEP_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_Enable_Disable("Disable")
							&& ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
							&& ubeeScreen.isWPA_Enable_Disable("Disable")) {
						flag = true;
					}
				}

				if (encryption == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Encryption.");
				} else if (security.contains("WPA") && ubeeScreen.selectEncryption(encryption)) {
					WebController.changeWifiSSID_Password(null, null, null, encryption.toUpperCase());
					flag = true;
				} else if (security.contains("WEP")) {
					if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
						if (encryption.contains("64")) {
							if (ubeeScreen.setWEPto(encryption)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, security, encryption);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WEP 64 bit.");
								flag = false;
							}
						} else if (encryption.contains("128")) {
							if (ubeeScreen.setWEPto(encryption)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, null, security, encryption);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set WEP 128 bit.");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid security Type");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set other security type to Disable");
						flag = false;
					}

					if (ubeeScreen.setPassPhrase(passPhrase)) {
						if (ubeeScreen.clikOnGenerate()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to sclick on Generate.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to setPassPhrase.");
						flag = false;
					}
					WebController.changeWifiSSID_Password(null, null, security, encryption);

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change encryption from security settings");
					flag = false;
				}
				if (password == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Password.");
				} else if (security.contains("PSK") && ubeeScreen.setPassword(password)) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change Password.");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navogate tot security settings for change Channel or Mode vs Band");
				flag = false;
			}

		} else if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/RgDhcp.asp", "DHCP", routerModel)) {
				if (is_dhcpEnable == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
				} else if (ubeeScreen.enable_disable_DHCP(is_dhcpEnable)) {
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
				} else if (ubeeScreen.setDHCPLeaseTime(LeaseTime)) {
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
				} else if (ubeeScreen.setDHCPStartIP(dhcpStartIP)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP dhcpStartIP to :" + dhcpStartIP);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp StartIP settings");
					flag = false;
				}
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen Name.");
			flag = false;
		}

		if (flag) {
			if (ubeeScreen.clickonApplybutton()) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Settings Applied");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		}
		return flag;
	}

	public static boolean _EVW321B_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String bandWidth, String channel, String Mode, String encryption,
			String password, String ssid_name, String is_dhcpEnable, String LeaseTime, String dhcpStartIP,
			String security, String passPhrase) {
		boolean flag = false;
		UbeeRouterScreen ubeeScreen = new UbeeRouterScreen(testCase);

		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (screenName.contains("WIRELESS") && screenName.contains("RADIO")) {
			if (frequency.contains("2.4 Ghz")) {
				flag = changeWebPage(testCase, baseURL, "/wlanRadio.asp", "RADIO", routerModel);
			} else if (frequency.contains("5 Ghz")) {
				flag = changeWebPage(testCase, baseURL, "/wlanRadio5G.asp", "RADIO", routerModel);
			}
			if (ubeeScreen.changeFrequency(frequency)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed frequency to ." + frequency);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change frequency from wireless settings");
				flag = false;
			}
			if (bandWidth == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
			} else if (ubeeScreen.changeBandWidth(bandWidth)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed bandWidth to ." + bandWidth);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change bandWidth from wireless settings");
				flag = false;
			}

			if (Mode == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
			} else if (ubeeScreen.changeMode(Mode)) {
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
			} else if (ubeeScreen.changeChannel(channel)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change channel from Basic settings");
				flag = false;
			}
		} else if (screenName.contains("WIRELESS") && screenName.contains("PRIMARY NETWORK")) {
			if (frequency.contains("2.4 Ghz")) {
				flag = changeWebPage(testCase, baseURL, "/wlanPrimaryNetwork.asp", "PRIMARY NETWOEK", routerModel);
			} else if (frequency.contains("5 Ghz")) {
				flag = changeWebPage(testCase, baseURL, "/wlanPrimaryNetwork5G.asp", "PRIMARY NETWOEK", routerModel);
			}

			if (ssid_name == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change SSID Name.");
			} else if (ubeeScreen.setSSIDName(ssid_name)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
				flag = false;
			}
			if (security == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change security Type.");
			} else if (security.contains("WPA-PSK") || security.contains("WPA PSK")) {
				if (ubeeScreen.isWPA_PSK_Enable_Disable("Enable") && ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA_Enable_Disable("Disable")
						&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
					flag = true;
				} else {
					if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
						if (ubeeScreen.setWPA_PSKto("Enabled")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WPA PSK to enable");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set other security type to Disable");
						flag = false;
					}
				}
				WebController.changeWifiSSID_Password(null, null, security, null);
			} else if (security.contains("WPA2-PSK") || security.contains("WPA2 PSK")) {
				if (ubeeScreen.isWPA2_PSK_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA_Enable_Disable("Disable")
						&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
					flag = true;
				} else {
					if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
						if (ubeeScreen.setWPA2_PSKto("Enabled")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WPA2 PSK to enable");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set other security type to Disable");
						flag = false;
					}
				}
				WebController.changeWifiSSID_Password(null, null, security, null);
			} else if (security.contains("WPA2")) {
				if (ubeeScreen.isWPA_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWPA2_Enable_Disable("Disable")) {
					flag = true;
				} else {
					if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
						if (ubeeScreen.setWPA2to("Enabled")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WPA2 to enable");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set other security type to Disable");
						flag = false;
					}
				}
				WebController.changeWifiSSID_Password(null, null, security, null);
			} else if (security.contains("WPA")) {
				if (ubeeScreen.isWPA2_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWEP_Enable_Disable("Disable") && ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWPA_Enable_Disable("Disable")) {
					flag = true;
				} else {
					if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
						if (ubeeScreen.setWPAto("Enabled")) {
							flag = ubeeScreen.clickOnAlertOK();
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WPA to enable");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set other security type to Disable");
						flag = false;
					}
				}
				WebController.changeWifiSSID_Password(null, null, security, null);
			} else if (security.contains("WEP")) {
				if (ubeeScreen.isWEP_Enable_Disable("Enable") && ubeeScreen.isWPA_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWPA2_Enable_Disable("Disable")
						&& ubeeScreen.isWPA2_PSK_Enable_Disable("Disable")
						&& ubeeScreen.isWPA_Enable_Disable("Disable")) {
					flag = true;
				}
			}

			if (encryption == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change Encryption.");
			} else if (security.contains("WPA") && ubeeScreen.selectEncryption(encryption)) {
				WebController.changeWifiSSID_Password(null, null, null, encryption.toUpperCase());
				flag = true;
			} else if (security.contains("WEP")) {
				if (ubeeScreen.setAllSecuritytypeTo("Disable")) {
					if (encryption.contains("64")) {
						if (ubeeScreen.setWEPto(encryption)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security, encryption);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WEP 64 bit.");
							flag = false;
						}
					} else if (encryption.contains("128")) {
						if (ubeeScreen.setWEPto(encryption)) {
							flag = true;
							WebController.changeWifiSSID_Password(null, null, security, encryption);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set WEP 128 bit.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid security Type");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to set other security type to Disable");
					flag = false;
				}

				if (ubeeScreen.setPassPhrase(passPhrase)) {
					if (ubeeScreen.clikOnGenerate()) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to sclick on Generate.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to setPassPhrase.");
					flag = false;
				}
				WebController.changeWifiSSID_Password(null, null, security, encryption);

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change encryption from security settings");
				flag = false;
			}
			if (password == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change Password.");
			} else if (security.contains("PSK") && ubeeScreen.setPassword(password)) {
				flag = true;
			}

		} else if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/RgDhcp.asp", "DHCP", routerModel)) {
				if (is_dhcpEnable == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change dhcp enable /disable .");
				} else if (ubeeScreen.enable_disable_DHCP(is_dhcpEnable)) {
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
				} else if (ubeeScreen.setDHCPLeaseTime(LeaseTime)) {
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
				} else if (ubeeScreen.setDHCPStartIP(dhcpStartIP)) {
					Keyword.ReportStep_Pass(testCase, "Changed DHCP dhcpStartIP to :" + dhcpStartIP);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change dhcp StartIP settings");
					flag = false;
				}
			}
		}
		if (flag) {
			if (ubeeScreen.clickonApplybutton()) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Settings Applied");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		}
		return flag;
	}
}