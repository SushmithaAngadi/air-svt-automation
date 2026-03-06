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
import com.resideo.utils.web.screens.CenturyLinkRouterScreen;

public class CenturyLinkRouterUtils {

	public static String getRouterSettings(String data, String requestParameter) {
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
						requestValue = "Auto Detect";
					}
					break;
				} else if (parameterArray[i].contains("POWER LEVEL") && requestParameter.contains("POWER LEVEL")) {
					if (parameterArray[i].contains("100")) {
						requestValue = "100% ";
					} else if (parameterArray[i].contains("90")) {
						requestValue = "90% ";
					} else if (parameterArray[i].contains("80")) {
						requestValue = "80% ";
					} else if (parameterArray[i].contains("70")) {
						requestValue = "70% ";
					} else if (parameterArray[i].contains("60")) {
						requestValue = "60% ";
					} else if (parameterArray[i].contains("50")) {
						requestValue = "50% ";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40% ";
					} else if (parameterArray[i].contains("30")) {
						requestValue = "30% ";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20% ";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10% ";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B_G_N")) {
						requestValue = "802.11b or 802.11g or 802.11n";
					} else if (parameterArray[i].contains("N_AC")) {
						requestValue = "802.11n or 802.11ac";
					} else if (parameterArray[i].contains("G_N")) {
						requestValue = "802.11g or 802.11n  ";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n Only ";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "802.11b or 802.11g";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "802.11g Only";
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
						requestValue = "Security Off";
					} else if (parameterArray[i].contains("WPA_WPA2_PERSONAL")) {
						requestValue = "WPA - WPA2 Personal";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA2 - Personal";
					}
					break;
				} else if (parameterArray[i].contains("MMIO") && requestParameter.contains("MMIO")) {
					if (parameterArray[i].contains("NO") || parameterArray[i].contains("FALSE")
							|| parameterArray[i].contains("DISABLE")) {
						requestValue = "NO";
					} else {
						requestValue = "YES";
					}
					break;
				} else if (parameterArray[i].contains("AGGREGATION") && requestParameter.contains("AGGREGATION")) {
					if (parameterArray[i].contains("MPDU")) {
						requestValue = "MPDU";
					} else if (parameterArray[i].contains("MSDU")) {
						requestValue = "MSDU";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "Disabled";
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
				} else if (parameterArray[i].contains("WIRELESS RADIO")
						&& requestParameter.contains("WIRELESS RADIO")) {
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
				} else if (parameterArray[i].contains("STARTING IP ADD")
						&& requestParameter.contains("STARTING IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP Starting IP address is", "").trim();
					break;
				} else if (parameterArray[i].contains("ENDING IP ADD") && requestParameter.contains("ENDING IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP Ending IP address is", "").trim();
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
			pagecontainer = "CENTURYLINK.COM";
			break;

		case "BASIC SETTING":
			pagecontainer = "BASIC SETTINGS IS USED TO ENABLE OR DISABLE THE WIRELESS RADIO OR CHANGE THE NETWORK NAME";
			break;

		case "WIRELESS SETTING":
			pagecontainer = "SECURE YOUR WIRELESS TRAFFIC AS IT TRANSMITS THROUGH THE AIR";
			break;

		case "DHCP SETTING":
			pagecontainer = "DHCP SETTINGS DEFINE THE LAN ADDRESSING PARAMETERS FOR YOUR MODEM TO ALLOCATE IP ADDRESSES TO LAN DEVICES";
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

	public static boolean changeRouterSettingsInCenturyLink(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "ZYXELC3000Z":
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
				flag = _ZYXELC3000Z_Model_chaneRouterSettings(testCase, screenName, baseurl,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "IS SSID"), getRouterSettings(dataOptions, "IS DHCP"),
						getRouterSettings(dataOptions, "LEASE TIME"), getRouterSettings(dataOptions, "CHANNEL WIDTH"),
						getRouterSettings(dataOptions, "POWER LEVEL"), getRouterSettings(dataOptions, "AGGREGATION"),
						getRouterSettings(dataOptions, "MMIO"), getRouterSettings(dataOptions, "STARTING IP ADD"),
						getRouterSettings(dataOptions, "ENDING IP ADD"));

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
					"Exception occured in changeRouterSettingsInCenturyLink(TestCases testCase, String screenName, String dataOptions)  due to "
							+ e.getMessage());
			flag = false;
		}
		return flag;
	}

//	public static WifiSecurityMode _ZYXELC3000Z_Model_chaneRouterSecuritySettings(String securityType_request) {
//		WifiSecurityMode securityType = null;
//		String security_Type = (WebController.router_SSID_securityType() != null)
//				? WebController.router_SSID_securityType().toUpperCase()
//				: null;
//		if (securityType_request != null) {
//			security_Type = securityType_request;
//		} else {
//			if (security_Type != null) {
//				String encryption = (WebController.router_SSID_securityEncryption() != null)
//						? WebController.router_SSID_securityEncryption().toUpperCase()
//						: null;
//				if (encryption != null) {
//					if (!encryption.isEmpty()) {
//						security_Type = security_Type + "_" + encryption;
//					}
//				}
//			} else {
//				securityType = null;
//			}
//		}
//		if (security_Type.contains("NONE")) {
//			securityType = WifiSecurityMode.NONE;
//		} else if (security_Type.contains("WEP")) {
//			if (security_Type.contains("SHARED")) {
//				securityType = WifiSecurityMode.WEP_Shared;
//			} else {
//				securityType = WifiSecurityMode.WEP_PSK;
//			}
//		} else if (security_Type.contains("WPA") && security_Type.contains("WPA2")) {
//			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//		} else if (security_Type.contains("WPA2")) {
//			if (security_Type.contains("AES".toUpperCase())) {
//				securityType = WifiSecurityMode.WPA2_AES_PSK;
//			} else if (security_Type.contains("TKIP".toUpperCase())) {
//				securityType = WifiSecurityMode.WPA2_TKIP_PSK;
//			} else {
//				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//			}
//		} else if (security_Type.contains("WPA")) {
//			if (security_Type.contains("AES".toUpperCase())) {
//				securityType = WifiSecurityMode.WPA_AES_PSK;
//			} else if (security_Type.contains("TKIP".toUpperCase())) {
//				securityType = WifiSecurityMode.WPA_TKIP_PSK;
//			} else {
//				securityType = WifiSecurityMode.WPA_MIXED_PSK;
//			}
//		} else {
//			securityType = WifiSecurityMode.WPA2_MIXED_Enterprise;
//		}
//
//		return securityType;
//	}

	public static boolean _ZYXELC3000Z_Model_chaneRouterSettings(TestCases testCase, String screename, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String LeaseTime, String channelWidth, String powerLevel,
			String aggregation, String is_MMIO, String DhcpStartIPAdd, String DhcpEndIPAdd) {
		boolean flag = true;
		CenturyLinkRouterScreen CenturyLinkScreen = new CenturyLinkRouterScreen(testCase);
		try {
			if (screename.contains("BASIC")) {
				if (frequency.contains("2.4")) {
					flag = flag && changeWebPage(testCase, "http://" + baseURL, "/wirelesssetup_basicsettings.html",
							"BASIC SETTINGS");
				} else {
					flag = flag && changeWebPage(testCase, "http://" + baseURL, "/wirelesssetup_basicsettings.html",
							"BASIC SETTINGS");
				}
				if (!CenturyLinkScreen.enable_disable_Wireless("Enable")) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Wireless settings to Enable");
					flag = false;
				}

				if (ssid_name == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
				} else if (CenturyLinkScreen.setvalueinSSID_ZYXELC3000Z(ssid_name)) {
					flag = true;
					WebController.changeWifiSSID_Password(ssid_name, null, null, null);
					Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to write broadcase SSID in wireless settings");
					flag = false;
				}
			} else if (screename.contains("WIRELESS")) {
				if (frequency.contains("2.4")) {
					flag = flag && changeWebPage(testCase, "http://" + baseURL,
							"/wirelesssetup_wirelesssecurity_refresh.wl?wlSsidIdx=0", "BASIC SETTINGS");
				} else {
					flag = flag && changeWebPage(testCase, "http://" + baseURL,
							"/wirelesssetup_wirelesssecurity_refresh5g.wl?wlSsidIdx=0", "BASIC SETTINGS");
				}
				if (security == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change security.");

				} else if (security.toUpperCase().contains("OFF")
						&& CenturyLinkScreen.selectSecurity_ZYXELC3000Z(security)) {
					WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
					Keyword.ReportStep_Pass(testCase, "Change security to " + security);

				} else if (security.toUpperCase().contains("WPA")
						&& CenturyLinkScreen.selectSecurity_ZYXELC3000Z(security)) {
					WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);

					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password.");
					} else if (CenturyLinkScreen.clickOnCustomSecurityKey_ZYXELC3000Z()
							&& CenturyLinkScreen.setValueinPassword_ZYXELC3000Z(password)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "Changed Password to " + security);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change password from security settings");
						flag = false;
					}
				}

			} else if (screename.contains("RADIO")) {
				if (frequency.contains("2.4")) {
					flag = flag && changeWebPage(testCase, "http://" + baseURL, "/wirelesssetup_radiosetup.html",
							"BASIC SETTINGS");
				} else {
					flag = flag && changeWebPage(testCase, "http://" + baseURL, "/wirelesssetup_radiosetup5g.html",
							"BASIC SETTINGS");
				}

				if (channel == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
				} else if (CenturyLinkScreen.selectChannel_ZYXELC3000Z(channel)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change channel in Wireless setting");
					flag = false;
				}

				if (powerLevel == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
				} else if (CenturyLinkScreen.selectPowerLevel_ZYXELC3000Z(powerLevel)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change powerLevel to " + powerLevel);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change powerLevel in Wireless Setting");
					flag = false;
				}
				if (channelWidth == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change channel.");
				} else if (CenturyLinkScreen.selectChannelWidth_ZYXELC3000Z(channelWidth)) {
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
				} else if (CenturyLinkScreen.selectMode_ZYXELC3000Z(mode)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change Mode in Wireless Setting");
					flag = false;
				}

				if (aggregation == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
				} else if (CenturyLinkScreen.selectAggregation_ZYXELC3000Z(aggregation)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Changed aggregation to " + aggregation);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change aggregation in Wireless Setting");
					flag = false;
				}
				if (is_MMIO == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change broadcast MMIO.");
				} else if (CenturyLinkScreen.enable_disable_MMIO_ZYXELC3000Z(is_MMIO)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Change Hide MMIO to " + is_MMIO);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to change broadcase MMIO in Radio Setup");
					flag = false;
				}

			} else if (screename.contains("SSID")) {
				if (frequency.contains("2.4")) {
					flag = flag && changeWebPage(testCase, "http://" + baseURL,
							"/wirelesssetup_ssidsetup_refresh.wl?wlSsidIdx=0", "SSID SETUP");
				} else {
					flag = flag && changeWebPage(testCase, "http://" + baseURL,
							"/wirelesssetup_ssidsetup_refresh5g.wl?wlSsidIdx=0", "SSID SETUP");
				}

				if (is_ssid == null) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
				} else if (CenturyLinkScreen.enable_disable_SSID_ZYXELC3000Z(is_ssid)) {
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
				} else if (CenturyLinkScreen.setvalueinSSIDName_ZYXELC3000Z(ssid_name)) {
					flag = true;
					WebController.changeWifiSSID_Password(ssid_name, null, null, null);
					Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to write broadcase SSID in wireless settings");
					flag = false;
				}

			} else if (screename.contains("DHCP")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/advancedsetup_dhcpsettings.html", "DHCP SETTINGS")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (CenturyLinkScreen.enable_disable_DHCP_ZYXELC3000Z(is_dhcp)) {
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
					} else if (CenturyLinkScreen.setvalueinDHCPLeaseTime_ZYXELC3000Z(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}

					if (DhcpStartIPAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DhcpStartIPAdd.");
					} else if (CenturyLinkScreen.setDHCPStartIP_ZYXELC3000Z(DhcpStartIPAdd)) {
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
					} else if (CenturyLinkScreen.setDHCPEndIP_ZYXELC3000Z(DhcpEndIPAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DhcpEndIPAdd setting is changed to " + DhcpEndIPAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DhcpEndIPAdd");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen name");
				flag = false;
			}
			if (flag) {
				if (CenturyLinkScreen.clickOnSaveBtn(screename, frequency)) {
					if (CenturyLinkScreen.isOkBtnPresent()) {
						if (CenturyLinkScreen.clickOnOkBtn()) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Confirm popup Occured,Settings saved");
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click Ok button.");
						}
					} else {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Confirm popup did not Occured, Settings saved");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click apply button.");

				}
			}
		} catch (Exception e) {

		}
		return flag;
	}

}