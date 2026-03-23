package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.AmpedRouterScreen;

public class AmpedRouterUtils {

	public static String getRouterSettings_RTA15_R2000G(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("149")) {
						requestValue = "149";
					} else if (parameterArray[i].contains("153")) {
						requestValue = "153";
					} else if (parameterArray[i].contains("157")) {
						requestValue = "157";
					} else if (parameterArray[i].contains("161")) {
						requestValue = "161";
					} else if (parameterArray[i].contains("165")) {
						requestValue = "165";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "9";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					} else if (parameterArray[i].contains("36")) {
						requestValue = "36 ";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 ";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44 ";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48";
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
					} else if (parameterArray[i].contains("AUTO_DFS")) {
						requestValue = "Auto(DFS)";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("AUTHENTICATION MODE")
						&& requestParameter.contains("AUTHENTICATION MODE")) {
					requestValue = parameterArray_Value[i].replace("Authentication Mode is", "").trim();
					break;
				} else if (parameterArray[i].contains("AUTHENTICATION")
						&& requestParameter.contains("AUTHENTICATION")) {
					requestValue = parameterArray_Value[i].replace("Authentication is", "").trim();
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B ONLY")) {
						requestValue = "2.4 GHz (B)";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "2.4 GHz (G)";
					} else if (parameterArray[i].contains("N ONLY") && parameterArray[i].contains("2")) {
						requestValue = "2.4 GHz (N)";
					} else if (parameterArray[i].contains("B_G_N")) {
						requestValue = "2.4 GHz (G+N)";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "2.4 GHz (N)";
					} else if (parameterArray[i].contains("G_N")) {
						requestValue = "2.4 GHz (G+N)";
					} else if (parameterArray[i].contains("A_N")) {
						requestValue = "5 GHz (A+N)";
					} else if (parameterArray[i].contains("N ONLY") && parameterArray[i].contains("5")) {
						requestValue = "5 GHz (N)";
					} else if (parameterArray[i].contains("A ONLY")) {
						requestValue = "5 GHz (A)";
					} else if (parameterArray[i].contains("AC ONLY") && parameterArray[i].contains("5")) {
						requestValue = "5 GHz (AC)";
					} else if (parameterArray[i].contains("N_A_C ONLY") && parameterArray[i].contains("5")) {
						requestValue = "5 GHz (N+A+C)";
					} else if (parameterArray[i].contains("A_N_AC ONLY") && parameterArray[i].contains("5")) {
						requestValue = "5 GHz (A+N+AC)";
					}
					break;
				} else if (parameterArray[i].contains("ENCRYPTION KEY")
						&& requestParameter.contains("ENCRYPTION KEY")) {
					requestValue = parameterArray_Value[i].replace("Encryption Key is", "").trim();
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
						requestValue = "40MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20MHz";
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
					if (parameterArray[i].contains("DISABLE") || parameterArray[i].contains("DISABLE")) {
						requestValue = " Disable ";
					} else if (parameterArray[i].contains("WEP") || parameterArray[i].contains("WEP")) {
						requestValue = " WEP ";
					} else if (parameterArray[i].contains("WPA MIXED") || parameterArray[i].contains("WPA MIXED")) {
						requestValue = " WPA-Mixed ";
					} else if (parameterArray[i].contains("WPA2") || parameterArray[i].contains("WPA2")) {
						requestValue = " WPA2 ";
					} else if (parameterArray[i].contains("WPA") || parameterArray[i].contains("WPA")) {
						requestValue = " WPA ";
					}
					break;
				} else if (parameterArray[i].contains("IS SSID") && requestParameter.contains("IS SSID")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disabled";
					} else {
						requestValue = "Enable";
					}
					break;
				} else if (parameterArray[i].contains("IS DHCP") && requestParameter.contains("IS DHCP")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("SERVER") || parameterArray[i].contains("ENABL")) {
						requestValue = "Server";
					} else if (parameterArray[i].contains("CLIENT")) {
						requestValue = "Client";
					} else if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
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
					requestValue = parameterArray_Value[i].replace("DHCP Start IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP END IP ADD")
						&& requestParameter.contains("DHCP END IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP End IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS IP ADD") && requestParameter.contains("RADIUS IP ADD")) {
					requestValue = parameterArray_Value[i].replace("Radius IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PASS") && requestParameter.contains("RADIUS PASS")) {
					requestValue = parameterArray_Value[i].replace("Radius Password is", "").trim();
					break;
				} else if (parameterArray[i].contains("PRE SHARED KEY FORMAT")
						&& requestParameter.contains("PRE SHARED KEY FORMAT")) {
					if (parameterArray[i].contains("PASSPHRASE")) {
						requestValue = "Passphrase";
					} else {
						requestValue = "HEX (64 characters)";
					}
					break;
				} else if (parameterArray[i].contains("KEY LENG") && requestParameter.contains("KEY LENG")) {
					if (parameterArray[i].contains("64")) {
						requestValue = " 64-bit";
					} else {
						requestValue = "128-bit";
					}
					break;
				} else if (parameterArray[i].contains("KEY FORMAT") && requestParameter.contains("KEY FORMAT")) {
					if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII (5 characters)";
					} else {
						requestValue = "Hex (10 characters)";
					}
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

	public static String PageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "R20000G":
			switch (screenName) {
			case "BASIC SETTINGS":
				pagecontainer = "Manually configure the settings for your home wireless network.".toUpperCase();
				break;
			case "SECURITY SETTINGS 2.4GHZ":
				pagecontainer = "Configure the Security Settings for your 2.4GHz wireless network.".toUpperCase();
				break;
			case "SECURITY SETTINGS 5GHZ":
				pagecontainer = "Configure the Security Settings for your 5.0GHz wireless network.".toUpperCase();
				break;
			case "PRIMARY NETWOEK":
				pagecontainer = "This page allows configuration of the Primary Wireless Network and its security settings."
						.toUpperCase();
				break;
			case "HOME SCREEN":
				pagecontainer = "The Amped Wireless High Power Wireless-N Gigabit Dual Band Router provides high speed, long range wireless Internet access for your home or office. The Smart Setup Wizard will guide you through the setup process to get you up and running."
						.toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "Adjust the Local Network IP Settings for the High Power Router.".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "RTA15":
			switch (screenName) {
			case "BASIC SETTINGS":
				pagecontainer = "Manually configure the settings for your Wi-Fi network.".toUpperCase();
				break;
			case "SECURITY SETTINGS 2.4GHZ":
				pagecontainer = "Configure the Security Settings for your 2.4GHz Wi-Fi network.".toUpperCase();
				break;
			case "SECURITY SETTINGS 5GHZ":
				pagecontainer = "Configure the Security Settings for your 5.0GHz Wi-Fi network.".toUpperCase();
				break;
			case "PRIMARY NETWOEK":
				pagecontainer = "This page allows configuration of the Primary Wi-Fi network and its security settings."
						.toUpperCase();
				break;
			case "HOME SCREEN":
				pagecontainer = "High Power 700mW Dual Band AC Wi-Fi Router".toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "Adjust the Local Network IP Settings for the Router.".toUpperCase();
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
						if (pageSource.toUpperCase().contains(PageSource(screenName, routerModel))) {
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

	public static boolean changeRouterSettingsInAmped(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();
			String baseURL = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL").toUpperCase();

			switch (routerModel) {
			case "R20000G":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://192.168.3.1", "/home.asp", "HOME SCREEN", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}

				flag = _R20000G_Model_chaneRouterSettings(testCase, screenName, baseURL, routerModel,
						getRouterSettings_RTA15_R2000G(dataOptions, "FREQUENCY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "BANDWIDTH"),
						getRouterSettings_RTA15_R2000G(dataOptions, "CHANNEL"),
						getRouterSettings_RTA15_R2000G(dataOptions, "MODE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "ENCRYPTION"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PRE SHARED KEY FORMAT"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PASSWORD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "IS SSID"),
						getRouterSettings_RTA15_R2000G(dataOptions, "SSID NAME"),
						getRouterSettings_RTA15_R2000G(dataOptions, "IS DHCP"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP LEASE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP START IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP END IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "SECURITY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PASSPHRASE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "AUTHENTICATION"),
						getRouterSettings_RTA15_R2000G(dataOptions, "KEY LENGTH"),
						getRouterSettings_RTA15_R2000G(dataOptions, "KEY FORMAT"),
						getRouterSettings_RTA15_R2000G(dataOptions, "ENCRYPTION KEY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "AUTHENTICATION MODE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "RADIUS IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "RADIUS PASS"));

				if (flag) {
					String security = getRouterSettings_RTA15_R2000G(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "RTA15":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://192.168.3.1", "/home.asp", "HOME SCREEN", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}

				flag = _RTA15_Model_chaneRouterSettings(testCase, screenName, baseURL, routerModel,
						getRouterSettings_RTA15_R2000G(dataOptions, "FREQUENCY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "BANDWIDTH"),
						getRouterSettings_RTA15_R2000G(dataOptions, "CHANNEL"),
						getRouterSettings_RTA15_R2000G(dataOptions, "MODE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "ENCRYPTION"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PRE SHARED KEY FORMAT"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PASSWORD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "IS SSID"),
						getRouterSettings_RTA15_R2000G(dataOptions, "SSID NAME"),
						getRouterSettings_RTA15_R2000G(dataOptions, "IS DHCP"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP LEASE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP START IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "DHCP END IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "SECURITY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "PASSPHRASE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "AUTHENTICATION"),
						getRouterSettings_RTA15_R2000G(dataOptions, "KEY LENGTH"),
						getRouterSettings_RTA15_R2000G(dataOptions, "KEY FORMAT"),
						getRouterSettings_RTA15_R2000G(dataOptions, "ENCRYPTION KEY"),
						getRouterSettings_RTA15_R2000G(dataOptions, "AUTHENTICATION MODE"),
						getRouterSettings_RTA15_R2000G(dataOptions, "RADIUS IP ADD"),
						getRouterSettings_RTA15_R2000G(dataOptions, "RADIUS PASS"));

				if (flag) {
					String security = getRouterSettings_RTA15_R2000G(dataOptions, "SECURITY");
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

	public static boolean _R20000G_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String bandwidth, String channel, String Mode, String encryption,
			String PreSharedKeyFormat, String password, String is_ssid, String ssid_name, String is_dhcpEnable,
			String LeaseTime, String dhcpStartIP, String dhcpEndIP, String security, String passPhrase,
			String authontication, String keyLength, String keyFormat, String EncryptionKey, String authonticationMode,
			String RadiusIPAdd, String RadiusPass) {
		boolean flag = false;
		AmpedRouterScreen ampedScreen = new AmpedRouterScreen(testCase);

		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		if (screenName.contains("DHCP")) {
			if (changeWebPage(testCase, baseURL, "/03_00_00_lan.asp", "DHCP", routerModel)) {
				if (is_dhcpEnable == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change DHCP.");
				} else if (ampedScreen.changeDHCP(is_dhcpEnable)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed DHCP to ." + is_dhcpEnable);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change DHCP from dhcp settings");
					flag = false;
				}
				if (dhcpStartIP == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change DHCP Start IP.");
				} else if (ampedScreen.setDHCPStartIPAdd(dhcpStartIP)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed DHCPStartIPAdd to ." + dhcpStartIP);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change DHCPStartIPAdd from dhcp settings");
					flag = false;
				}
				if (dhcpEndIP == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change DHCP End IP.");
				} else if (ampedScreen.setDHCPEndIPAdd(dhcpEndIP)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed DHCPEndIPAdd to ." + dhcpEndIP);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change DHCPEndIPAdd from dhcp settings");
					flag = false;
				}
				if (LeaseTime == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change DHCP Lease time.");
				} else if (ampedScreen.setLeaseTime(LeaseTime)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed LeaseTime to ." + LeaseTime);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change LeaseTime from dhcp settings");
					flag = false;
				}
			}
		} else if (screenName.contains("BASIC SETTING")) {
			if (frequency.contains("2.4")) {
				flag = changeWebPage(testCase, baseURL, "/02_00_02_basic.asp#", "BASIC SETTINGS", routerModel);
				flag = flag & ampedScreen.clickOnBasicSettings2G();
			} else {
				flag = changeWebPage(testCase, baseURL, "/02_00_00_basic.asp#", "BASIC SETTINGS", routerModel);
				flag = flag & ampedScreen.clickOnBasicSettings5G();
			}
			if (Mode == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
			} else if (ampedScreen.selectMode(Mode)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed Mode to ." + Mode);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change Mode from basic settings");
				flag = false;
			}
			if (is_ssid == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
			} else {
				if (is_ssid.contains("YES") && !ampedScreen.isBroadCastSSIDGEnabled()) {
					flag = flag && ampedScreen.clickOnBroadCastSSID();
					Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
				} else if (is_ssid.contains("NO") && ampedScreen.isBroadCastSSIDGEnabled()) {
					flag = flag && ampedScreen.clickOnBroadCastSSID();
					Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
				} else if (is_ssid.contains("YES") && ampedScreen.isBroadCastSSIDGEnabled()) {
					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already enabled ");
				} else {
					Keyword.ReportStep_Pass(testCase, "broadcast SSID is already disabled ");
				}
			}
			if (ssid_name == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change SSID Name.");
			} else if (ampedScreen.setSSIDName(ssid_name)) {
				flag = true;
				WebController.changeWifiSSID_Password(ssid_name, null, null, null);
				Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
				flag = false;
			}
			if (bandwidth == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change bandwidth.");
			} else if (ampedScreen.changeBandwidth(bandwidth)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Successfuly changed the bandwidth to :" + bandwidth);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change bandwidth");
				flag = false;
			}
			if (channel == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change channel.");
			} else if (ampedScreen.changeChannel(channel)) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to change channel from Basic settings");
				flag = false;
			}
			flag = flag && ampedScreen.switchToDefaultFrame();
		} else if (screenName.contains("SECURITY SETTING")) {
			if (frequency.contains("2.4")) {
				flag = changeWebPage(testCase, baseURL, "/02_02_02_sec.asp", "SECURITY SETTINGS 2.4GHZ", routerModel);
				flag = flag & ampedScreen.clickOnSecuritySettings2G();
			} else {
				flag = changeWebPage(testCase, baseURL, "/02_02_00_sec.asp", "SECURITY SETTINGS 5GHZ", routerModel);
				flag = flag & ampedScreen.clickOnSecuritySettings5G();
			}
			flag = ampedScreen.switchToDefaultFrame();
			flag = flag & ampedScreen.switchToSSIDAuthModeFrame();
			if (security == null) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "No need to change security Type.");
			} else if (security.toUpperCase().contains("DIS") && ampedScreen.selectSecurity(security)) {
				flag = true;
				WebController.changeWifiSSID_Password(null, null, "NONE", null);
			} else if (security.contains("WEP") && ampedScreen.selectSecurity(security)) {
				flag = true;
				WebController.changeWifiSSID_Password(null, null, security, null);
				if (ampedScreen.enable_disable_802_1xAuth("DISABLE")) {
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to Disable the 802.1x Authentication");
				}
				if (authontication == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change authontication Type.");
				} else if (ampedScreen.selectWEPAuthontication(authontication)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, null, null, authontication);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change authontication from security settingss");
					flag = false;
				}
				if (keyLength == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change keyLength.");
				} else if (ampedScreen.changeWEPKeyLength(keyLength)) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WEP keyLength from security settingss");
					flag = false;
				}
				if (keyFormat == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change keyFormat.");
				} else if (ampedScreen.changeWEPKeyFormat(keyFormat)) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WEP keyFormat from security settingss");
					flag = false;
				}
				if (EncryptionKey == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change EncryptionKey.");
				} else if (ampedScreen.setWEPEncryptionKey(EncryptionKey)) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change WEP EncryptionKey from security settingss");
					flag = false;
				}
			} else if (security.contains("WPA") && ampedScreen.selectSecurity(security)) {
				WebController.changeWifiSSID_Password(null, null, security, null);
				if (authonticationMode.toUpperCase().contains("ENTERPRISE")
						&& ampedScreen.selectAutonticationModeWAP(authonticationMode)) {
					WebController.changeWifiSSID_Password(null, null, null, "AES");
					if (ampedScreen.setWPARadiusIPAdd(RadiusIPAdd)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to set RadiusIPAdd");
						flag = false;
					}
					if (ampedScreen.setWPARadiusPass(RadiusPass)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to set RadiusPass");
						flag = false;
					}
				} else if (authonticationMode.toUpperCase().contains("PERSONAL")
						&& ampedScreen.selectAutonticationModeWAP(authonticationMode)) {
					WebController.changeWifiSSID_Password(null, null, null, "AES");
					if (password == null) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "No need to change password.");
					} else if (ampedScreen.setPassword(password)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change password from security settingss");
						flag = false;
					}
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid security Type");
				flag = false;
			}
			flag = flag && ampedScreen.switchToDefaultFrame();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid screen");
			flag = false;
		}

		if (flag) {
			if (ampedScreen.clickonApplybutton(screenName)) {
				if (ampedScreen.acceptAlert()) {
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to Accept the Alert");
				}
				if (ampedScreen.clickOnRebootNoeBtn()) {
					flag = true;
					ampedScreen.iselementPresent(30);
					Keyword.ReportStep_Pass(testCase, "Settings Applied");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"not able to click on Reboot Now button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		}
		return flag;
	}

	public static boolean _RTA15_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String frequency, String bandwidth, String channel, String Mode, String encryption,
			String PreSharedKeyFormat, String password, String is_ssid, String ssid_name, String is_dhcpEnable,
			String LeaseTime, String dhcpStartIP, String dhcpEndIP, String security, String passPhrase,
			String authontication, String keyLength, String keyFormat, String EncryptionKey, String authonticationMode,
			String RadiusIPAdd, String RadiusPass) {
		boolean flag = false;
		AmpedRouterScreen ampedScreen = new AmpedRouterScreen(testCase);
		try {
			routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL");
			if (!baseURL.contains("http")) {
				baseURL = "http://" + baseURL;
			}
			if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, baseURL, "/03_00_00_lan.asp", "DHCP", routerModel)) {
					if (is_dhcpEnable == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP.");
					} else if (ampedScreen.changeDHCP(is_dhcpEnable)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed DHCP to ." + is_dhcpEnable);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP from dhcp settings");
						flag = false;
					}
					if (dhcpStartIP == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP Start IP.");
					} else if (ampedScreen.setDHCPStartIPAdd(dhcpStartIP)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed DHCPStartIPAdd to ." + dhcpStartIP);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCPStartIPAdd from dhcp settings");
						flag = false;
					}
					if (dhcpEndIP == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP End IP.");
					} else if (ampedScreen.setDHCPEndIPAdd(dhcpEndIP)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed DHCPEndIPAdd to ." + dhcpEndIP);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCPEndIPAdd from dhcp settings");
						flag = false;
					}
					if (LeaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP Lease time.");
					} else if (ampedScreen.setLeaseTime(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "changed LeaseTime to ." + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change LeaseTime from dhcp settings");
						flag = false;
					}
				}
			} else if (screenName.contains("BASIC SETTING")) {
				if (frequency.contains("2.4")) {
					flag = changeWebPage(testCase, baseURL, "/02_00_02_basic.asp#", "BASIC SETTINGS", routerModel);
					flag = flag & ampedScreen.clickOnBasicSettings2G();
				} else {
					flag = changeWebPage(testCase, baseURL, "/02_00_00_basic.asp#", "BASIC SETTINGS", routerModel);
					flag = flag & ampedScreen.clickOnBasicSettings5G();
				}
				if (Mode == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
				} else if (ampedScreen.selectMode(Mode)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed Mode to ." + Mode);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Mode from basic settings");
					flag = false;
				}
				if (is_ssid == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
				} else {
					if (is_ssid.contains("YES") && !ampedScreen.isBroadCastSSIDGEnabled()) {
						flag = flag && ampedScreen.clickOnBroadCastSSID();
						Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
					} else if (is_ssid.contains("NO") && ampedScreen.isBroadCastSSIDGEnabled()) {
						flag = flag && ampedScreen.clickOnBroadCastSSID();
						Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
					} else if (is_ssid.contains("YES") && ampedScreen.isBroadCastSSIDGEnabled()) {
						Keyword.ReportStep_Pass(testCase, "broadcast SSID is already enabled ");
					} else {
						Keyword.ReportStep_Pass(testCase, "broadcast SSID is already disabled ");
					}
				}
				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change SSID Name.");
				} else if (ampedScreen.setSSIDName(ssid_name)) {
					flag = true;
					WebController.changeWifiSSID_Password(ssid_name, null, null, null);
					Keyword.ReportStep_Pass(testCase, "Successfuly changed the SSID to :" + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change SSID Names");
					flag = false;
				}
				if (bandwidth == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change bandwidth.");
				} else if (ampedScreen.changeBandwidth(bandwidth)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfuly changed the bandwidth to :" + bandwidth);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change bandwidth");
					flag = false;
				}
				if (channel == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
				} else if (ampedScreen.changeChannel(channel)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "changed channel to ." + channel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change channel from Basic settings");
					flag = false;
				}

			} else if (screenName.contains("SECURITY SETTING")) {
				if (frequency.contains("2.4")) {
					flag = changeWebPage(testCase, baseURL, "/02_02_02_sec.asp", "SECURITY SETTINGS 2.4GHZ",
							routerModel);
					flag = flag & ampedScreen.clickOnSecuritySettings2G();
				} else {
					flag = changeWebPage(testCase, baseURL, "/02_02_00_sec.asp", "SECURITY SETTINGS 5GHZ", routerModel);
					flag = flag & ampedScreen.clickOnSecuritySettings5G();
				}
				flag = ampedScreen.switchToDefaultFrame();
				flag = flag & ampedScreen.switchToSSIDAuthModeFrame();
				if (security == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change security Type.");
				} else if (security.toUpperCase().contains("DIS") && ampedScreen.selectSecurity(security)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, null, "NONE", null);
				} else if (security.contains("WEP") && ampedScreen.selectSecurity(security)) {
					flag = true;
					WebController.changeWifiSSID_Password(null, null, security, null);
					if (ampedScreen.enable_disable_802_1xAuth("DISABLE")) {
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to Disable the 802.1x Authentication");
					}
					if (authontication == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change authontication Type.");
					} else if (ampedScreen.selectWEPAuthontication(authontication)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, null, authontication);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change authontication from security settingss");
						flag = false;
					}
					if (keyLength == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change keyLength.");
					} else if (ampedScreen.changeWEPKeyLength(keyLength)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP keyLength from security settingss");
						flag = false;
					}
					if (keyFormat == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change keyFormat.");
					} else if (ampedScreen.changeWEPKeyFormat(keyFormat)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP keyFormat from security settingss");
						flag = false;
					}
					if (EncryptionKey == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change EncryptionKey.");
					} else if (ampedScreen.setWEPEncryptionKey(EncryptionKey)) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change WEP EncryptionKey from security settingss");
						flag = false;
					}
				} else if (security.contains("WPA") && ampedScreen.selectSecurity(security)) {
					WebController.changeWifiSSID_Password(null, null, security, null);
					if (authonticationMode.toUpperCase().contains("ENTERPRISE")
							&& ampedScreen.selectAutonticationModeWAP(authonticationMode)) {
						WebController.changeWifiSSID_Password(null, null, null, "AES");
						if (ampedScreen.setWPARadiusIPAdd(RadiusIPAdd)) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set RadiusIPAdd");
							flag = false;
						}
						if (ampedScreen.setWPARadiusPass(RadiusPass)) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set RadiusPass");
							flag = false;
						}
					} else if (authonticationMode.toUpperCase().contains("PERSONAL")
							&& ampedScreen.selectAutonticationModeWAP(authonticationMode)) {
						WebController.changeWifiSSID_Password(null, null, null, "AES");
						if (password == null) {
							flag = true;
							WebController.changeWifiSSID_Password(null, password, null, null);
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (ampedScreen.setPassword(password)) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password from security settingss");
							flag = false;
						}
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid security Type");
					flag = false;
				}
				flag = flag && ampedScreen.switchToDefaultFrame();
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid screen");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			return flag;
		}

		if (flag) {
			if (ampedScreen.clickonApplybutton_RTA15(screenName)) {
				if (security != null
						&& (security.toUpperCase().contains("WEP")
								|| (security.trim().equals("WPA") && PreSharedKeyFormat != null
										&& PreSharedKeyFormat.toUpperCase().contains("PASSPHRASE")))
						&& ExpectedConditions.alertIsPresent() != null) {
					if (ampedScreen.acceptAlert()) {
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to Accept the Alert");
					}
				}
				if (ampedScreen.clickOnRebootNoeBtn_RTA15()) {
					flag = true;
					ampedScreen.iselementPresent(30);
					Keyword.ReportStep_Pass(testCase, "Settings Applied");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"not able to click on Reboot Now button");
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