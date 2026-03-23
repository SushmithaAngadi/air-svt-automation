package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.screens.TpLinkRouterScreen;

public class TpLinkRouterUtil {

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
					if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					} else if (parameterArray[i].contains("A_N_AC_AX_MIXED")) {
						requestValue = "802.11a/n/ac/ax mixed";
					} else if (parameterArray[i].contains("B_G_N_MIXED")) {
						requestValue = "802.11b/g/n mixed";
					} else if (parameterArray[i].contains("A_N_AC_MIXED")) {
						requestValue = "802.11a/n/ac mixed";
					} else if (parameterArray[i].contains("G_N_MIXED")) {
						requestValue = "802.11g/n mixed";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n only";
					} else if (parameterArray[i].contains("AX ONLY")) {
						requestValue = "802.11ax only";
					} else if (parameterArray[i].contains("B_G_N_AX_MIXED")) {
						requestValue = "802.11b/g/n/ax mixed";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					if (parameterArray[i].contains("20_40_80")) {
						requestValue = "20/40/80MHz";
					} else if (parameterArray[i].contains("20_40")) {
						requestValue = "20/40MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20MHz";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40MHz";
					} else if (parameterArray[i].contains("80")) {
						requestValue = "80MHz";
					} else if (parameterArray[i].contains("AUTO")) {
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
					requestValue = parameterArray_Value[i].replace("password is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("NONE") && parameterArray[i].contains("AX1800")) {
						requestValue = "None";
					} else if (parameterArray[i].contains("NONE".toUpperCase())) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WPA2 AES".toUpperCase())) {
						requestValue = "WPA2-PSK[AES]";
					} else if (parameterArray[i].contains("WPA2_WPA MIXED".toUpperCase())) {
						requestValue = "WPA2-PSK[AES]+WPA-PSK[TKIP]";
					} else if (parameterArray[i].contains("WPA3-Personal".toUpperCase())) {
						requestValue = "WPA3-Personal";
					} else if (parameterArray[i].contains("WPA3_WPA2 MIXED".toUpperCase())) {
						requestValue = "WPA3-Personal+WPA2-PSK[AES]";
					} else if (parameterArray[i].contains("WPA_WPA2_PERSONAL")) {
						requestValue = "WPA/WPA2-Personal";
					} else if (parameterArray[i].contains("WPA2_WPA3_PERSONAL")) {
						requestValue = "WPA2/WPA3-Personal";
					} else if (parameterArray[i].contains("WPA_WPA2_ENTERPRISE")) {
						requestValue = "WPA/WPA2-Enterprise";
					}
					break;
				} else if ((parameterArray[i].contains("WPA ENCRYPTION") || parameterArray[i].contains("ENCRYPTION"))
						&& (requestParameter.contains("WPA ENCRYPTION") || requestParameter.contains("ENCRYPTION"))) {
					if (parameterArray[i].contains("TKIP_AES")) {
						requestValue = "TKIP+AES";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					} else if (parameterArray[i].contains("MIXED")) {
						requestValue = "TKIP/AES";
					}
					break;
				} else if (parameterArray[i].contains("VERSION") && requestParameter.contains("VERSION")) {
					if (parameterArray[i].contains("WPA-PSK/WPA2-PSK")
							|| parameterArray[i].contains("WPA_PSK_WPA2_PSK")) {
						requestValue = "WPA-PSK/WPA2-PSK";
					} else if (parameterArray[i].contains("WPA2-PSK") || parameterArray[i].contains("WPA2_PSK")) {
						requestValue = "WPA2-PSK";
					} else if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					} else if (parameterArray[i].contains("WPA3-SAE") || parameterArray[i].contains("WPA3_SAE")) {
						requestValue = "WPA3-SAE";
					} else if (parameterArray[i].contains("WPA/WPA2") || parameterArray[i].contains("WPA_WPA2")) {
						requestValue = "WPA/WPA2";
					} else if (parameterArray[i].contains("WPA2")) {
						requestValue = "WPA2";
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
				} else if (parameterArray[i].contains("DNS IP2") && requestParameter.contains("DNS IP2")) {
					requestValue = parameterArray_Value[i].replace("DNS IP2 is", "").trim();
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

	public static boolean loginintoRouter(TestCases testCase, String password) {
		boolean flag = false;

		TpLinkRouterScreen tpLink = new TpLinkRouterScreen(testCase);
		tpLink.iselementPresent();
		flag = tpLink.setValueinPasswordTB(password);
		flag = flag && tpLink.clickOnLoginBtn();

		Keyword.ReportStep_Pass(testCase, "Successfully login into the TpLinkrouter Settings");

		return flag;
	}

	public static String PageSource(String screenName) {
		String pagecontainer = null;
		switch (screenName) {
		case "WIRELESS SETTING":
			pagecontainer = "Personalize settings for each band or enable Smart Connect to configure the same settings for all bands"
					.toUpperCase();
			break;
		case "HOME PAGE":
			pagecontainer = "Internet IP Address".toUpperCase();
			break;

		case "DHCP SETTING":
			pagecontainer = "Dynamically assign IP addresses to the devices connected to the router.".toUpperCase();
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
						if (pageSource.toUpperCase().contains(PageSource(screenName))) {
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

	public static boolean _AX1500_Model_changeRouterSettings(TestCases testCase, String baseURL, String screenName,
			String frequency, String is_ssid, String ssid_name, String security, String password, String bandwidth,
			String channel, String mode, String is_dhcp, String DNSip1, String DNSip2, String LeaseTime) {
		boolean flag = false;
		TpLinkRouterScreen tpLink = new TpLinkRouterScreen(testCase);

		try {
			if (tpLink.isTPLinkIDpopPresent()) {
				tpLink.clickonTPLinkIDpop();
			}
			if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, "https://" + baseURL, "/webpages/index.html?t=98abf2f8#dhcpServerAdv",
						"DHCP SETTING")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (tpLink.enable_disable_DHCP(is_dhcp)) {
						Thread.sleep(4000);
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
					} else if (tpLink.setvalueinDHCPLeaseTime(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}

					if (DNSip1 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (tpLink.setvalueinDNSServerIP_1(DNSip1)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DNS server set to " + DNSip1);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP in DNS server setting");
						flag = false;
					}

					if (DNSip2 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (tpLink.setvalueinDNSServerIP_2(DNSip2)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DNS server set to " + DNSip2);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP in DNS server setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else {
				if (changeWebPage(testCase, "https://" + baseURL, "/webpages/index.html?t=98abf2f8#wirelessSettingsAdv",
						"WIRELESS SETTING")) {
					if (tpLink.isSmartConnectionEnabled()) {
						tpLink.smartConnectCheckBox();
					}
					if (frequency == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
					} else if (tpLink.enable24GHZ_5GHZband(frequency)) {
						flag = true;
						Thread.sleep(4000);
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change frequency in Wireless setting");
						flag = false;
					}

					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4") && tpLink.enable_disable_SSID_24GhZ(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change Hide SSID to " + is_ssid);
					} else if (frequency.contains("5") && tpLink.enable_disable_SSID_5GhZ(is_ssid)) {
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
					} else if (frequency.contains("2.4") && tpLink.setvalueinSSID24(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else if (frequency.contains("5") && tpLink.enable_disable_SSID_5GhZ(ssid_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to write broadcase SSID in wireless settings");
						flag = false;
					}

					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security.");
					} else if (frequency.contains("2.4") && tpLink.changeSecurity24Ghz(security)) {
						Thread.sleep(4000);
						flag = true;
						WebController.changeWifiSSID_Password(null, null, security, null);
						Keyword.ReportStep_Pass(testCase, "Change security to " + security);
					} else if (frequency.contains("5") && tpLink.changeSecurity5Ghz(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change security to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change encryption from security settings");
						flag = false;
					}

					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password.");
					} else if (frequency.contains("2.4") && tpLink.setValueinPassword24(password)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
					} else if (frequency.contains("5") && tpLink.setValueinPassword5(password)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "Change password to " + password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change password from security settings");
						flag = false;
					}

					if (bandwidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
					} else if (frequency.contains("2.4") && tpLink.changeChannelWidth24Ghz(bandwidth)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else if (frequency.contains("5") && tpLink.changeChannelWidth5Ghz(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channelwidth in Wireless setting");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (frequency.contains("2.4") && tpLink.changeChannel24Ghz(channel)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else if (frequency.contains("5") && tpLink.changeChannel5Ghz(channel)) {
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
					} else if (frequency.contains("2.4") && tpLink.changeMode24Ghz(mode)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else if (frequency.contains("5") && tpLink.changeMode5Ghz(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (tpLink.clickOnSaveBtn()) {
				Thread.sleep(3000);
				if (tpLink.clickOnOkBtn()) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Settings saved");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Ok button.");

				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Settings are same no need to change the settings");
				flag = true;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean changeRouterSettingsInTPLink(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			// getRouterSettings(dataOptions, dataOptions);
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "AX1500":
				/*
				 * TestCases testCase, String baseURL, String screenName,String frequency,String
				 * is_ssid, String ssid_name, String security, String password, String
				 * bandwidth, String channel, String mode, String is_dhcp, String DNSip1, String
				 * DNSip2, String LeaseTime
				 */
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/webpages/index.html?t=98abf2f8#networkMap",
							"HOME SETTINGS")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _AX1500_Model_changeRouterSettings(testCase, baseurl, screenName,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "IS SSID"),
						getRouterSettings(dataOptions, "SSID NAME"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "BANDWIDTH"),
						getRouterSettings(dataOptions, "CHANNEL"), getRouterSettings(dataOptions, "MODE"),
						getRouterSettings(dataOptions, "IS DHCP"), getRouterSettings(dataOptions, "DNS IP1"),
						getRouterSettings(dataOptions, "DNS IP2"), getRouterSettings(dataOptions, "LEASETIME"));

				if (flag) {
					String security = getRouterSettings(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}

				break;
			case "AX1800":
				/*
				 * TestCases testCase, String baseURL, String screenName,String frequency,String
				 * is_ssid, String ssid_name, String security, String password, String
				 * bandwidth, String channel, String mode, String is_dhcp, String DNSip1, String
				 * DNSip2, String LeaseTime
				 */
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/webpages/index.html?t=29ba1aa0#networkMap",
							"HOME SETTINGS")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _AX1800_Model_changeRouterSettings(testCase, baseurl, screenName,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "IS SSID"),
						getRouterSettings(dataOptions, "SSID NAME"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "BANDWIDTH"),
						getRouterSettings(dataOptions, "CHANNEL"), getRouterSettings(dataOptions, "MODE"),
						getRouterSettings(dataOptions, "IS DHCP"), getRouterSettings(dataOptions, "DNS IP1"),
						getRouterSettings(dataOptions, "DNS IP2"), getRouterSettings(dataOptions, "DHCPLEASE"),
						getRouterSettings(dataOptions, "ENCRYPTION"), getRouterSettings(dataOptions, "VERSION"));

				if (flag) {
					String security = getRouterSettings(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "TLWR740N":
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

				flag = _TLWR740N_Model_changeRouterSettings(testCase, baseurl, screenName,
						getRouterSettings(dataOptions, "IS SSID"), getRouterSettings_TLWR740N(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "SECURITY"), getRouterSettings_TLWR740N(dataOptions, "PASSWORD"),
						getRouterSettings(dataOptions, "BANDWIDTH"), getRouterSettings_TLWR740N(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "MODE"), getRouterSettings(dataOptions, "ENCRYPTION"),
						getRouterSettings(dataOptions, "VERSION"), getRouterSettings(dataOptions, "WEP TYPE"),
						getRouterSettings(dataOptions, "WEP KEY FORMAR"), getRouterSettings(dataOptions, "WEP KEY1"),
						getRouterSettings(dataOptions, "RADIUS IP"), getRouterSettings(dataOptions, "RADIUS PORT"),
						getRouterSettings_TLWR740N(dataOptions, "IS DHCP"), getRouterSettings(dataOptions, "DHCPLEASE"),
						getRouterSettings(dataOptions, "DHCP START IP"),
						getRouterSettings_TLWR740N(dataOptions, "DHCP END IP")

				);

				if (flag) {
					String security = getRouterSettings_TLWR740N(dataOptions, "SECURITY");
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

	public static boolean _AX1800_Model_changeRouterSettings(TestCases testCase, String baseURL, String screenName,
			String frequency, String is_ssid, String ssid_name, String security, String password, String bandwidth,
			String channel, String mode, String is_dhcp, String DNSip1, String DNSip2, String LeaseTime,
			String encryption, String version) {
		boolean flag = false;
		TpLinkRouterScreen tpLink = new TpLinkRouterScreen(testCase);
		try {
			if (tpLink.isTPLinkIDpopPresent()) {
				tpLink.clickonTPLinkIDpop();
			}
			if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/webpages/index.html?t=29ba1aa0#dhcpServerAdv",
						"DHCP SETTING")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (tpLink.enable_disable_DHCP_AX1800(is_dhcp)) {
						Thread.sleep(4000);
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
					} else if (tpLink.setvalueinDHCPLeaseTime(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}

					if (DNSip1 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DNSip1 in DHCP setting.");
					} else if (tpLink.setvalueinDNSServerIP_1(DNSip1)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DNS server set to " + DNSip1);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP in DNS server setting");
						flag = false;
					}

					if (DNSip2 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to DNSip2 in change DHCP setting.");
					} else if (tpLink.setvalueinDNSServerIP_2(DNSip2)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DNS server set to " + DNSip2);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change IP in DNS server setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else {
				if (changeWebPage(testCase, "http://" + baseURL, "/webpages/index.html?t=29ba1aa0#wirelessSettingsAdv",
						"WIRELESS SETTING")) {
					if (tpLink.isSmartConnectionEnabled()) {
						tpLink.smartConnectCheckBox();
					}
					if (frequency == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change frequency.");
					} else if (tpLink.enable24GHZ_5GHZband(frequency)) {
						flag = true;
						Thread.sleep(4000);
						Keyword.ReportStep_Pass(testCase, "Change frequency to " + frequency);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change frequency in Wireless setting");
						flag = false;
					}

					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (frequency.contains("2.4") && tpLink.enable_disable_SSID_24GhZ(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change Hide SSID to " + is_ssid);
					} else if (frequency.contains("5") && tpLink.enable_disable_SSID_5GhZ(is_ssid)) {
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
					} else if (frequency.contains("2.4") && tpLink.setvalueinSSID24(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else if (frequency.contains("5") && tpLink.setvalueinSSID5(ssid_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to write broadcase SSID in wireless settings");
						flag = false;
					}

					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change security.");
					} else if (frequency.contains("2.4") && tpLink.changeSecurity24Ghz(security)) {
						Thread.sleep(4000);
						flag = true;
						WebController.changeWifiSSID_Password(null, null, security, null);
						Keyword.ReportStep_Pass(testCase, "Change security to " + security);
					} else if (frequency.contains("5") && tpLink.changeSecurity5Ghz(security)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, security, null);
						Keyword.ReportStep_Pass(testCase, "Change security to " + security);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change security from security settings");
						flag = false;
					}

					if (version == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change version.");
					} else if (security.contains("WPA/WPA2") && frequency.contains("2.4")
							&& tpLink.changeVersion24Ghz(version)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
					} else if (security.contains("WPA/WPA2") && frequency.contains("5")
							&& tpLink.changeVersion5Ghz(version)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "Change version to " + version);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change version from security settings");
						flag = false;
					}

					if (encryption == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change encryption.");
					} else if (security.contains("WPA/WPA2") && frequency.contains("2.4")
							&& tpLink.changeEncryption24Ghz(encryption, security.toUpperCase())) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, null, encryption);
					} else if (security.contains("WPA/WPA2") && frequency.contains("5")
							&& tpLink.changeEncryption5Ghz(encryption)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, null, null, encryption);
						Keyword.ReportStep_Pass(testCase, "Change encryption to " + encryption);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change encryption from security settings");
						flag = false;
					}

					if (password == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change password.");
					} else if (frequency.contains("2.4") && tpLink.setValueinPassword24_AX1800(password, security)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
					} else if (frequency.contains("5") && tpLink.setValueinPassword5_AX1800(password, security)) {
						flag = true;
						WebController.changeWifiSSID_Password(null, password, null, null);
						Keyword.ReportStep_Pass(testCase, "Change password to " + password);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change password from security settings");
						flag = false;
					}

					if (bandwidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
					} else if (frequency.contains("2.4") && tpLink.changeChannelWidth24Ghz(bandwidth)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else if (frequency.contains("5") && tpLink.changeChannelWidth5Ghz(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channelwidth in Wireless setting");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (frequency.contains("2.4") && tpLink.changeChannel24Ghz(channel)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
					} else if (frequency.contains("5") && tpLink.changeChannel5Ghz(channel)) {
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
					} else if (frequency.contains("2.4") && tpLink.changeMode24Ghz(mode)) {
						Thread.sleep(4000);
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else if (frequency.contains("5") && tpLink.changeMode5Ghz(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (tpLink.clickOnSaveBtn()) {
				Thread.sleep(3000);
				if (!screenName.contains("DHCP")) {
					if (tpLink.clickOnOkBtn()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Settings saved");
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Ok button.");

					}
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Settings are same no need to change the settings");
				flag = true;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode _AX1800_Model_chaneRouterSecuritySettings(String securityType_request) {
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
		} else if (security_Type.contains("WPA2")) {
			if (security_Type.contains("AES".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			}
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}

		return securityType;
	}

	public static String getRouterSettings_TLWR740N(String data, String requestParameter) {
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
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B_G_N_MIXED")) {
						requestValue = "11bgn mixed";
					} else if (parameterArray[i].contains("B_G_MIXED")) {
						requestValue = "11bg mixed";
					} else if (parameterArray[i].contains("N_ONLY")) {
						requestValue = "11n only";
					} else if (parameterArray[i].contains("B_ONLY")) {
						requestValue = "11b only";
					} else if (parameterArray[i].contains("G_ONLY")) {
						requestValue = "11g only";
					}
					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					if (parameterArray[i].contains("20")) {
						requestValue = "20MHz";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40MHz";
					} else if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
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
					} else if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("PSK")) {
						requestValue = "WPA-PSK/WPA2-PSK";
					} else if (parameterArray[i].contains("WPA")) {
						requestValue = "WPA/WPA2";
					}
					break;
				} else if (parameterArray[i].contains("WEP TYPE") && requestParameter.contains("WEP TYPE")) {
					if (parameterArray[i].contains("AUTOMATIC")) {
						requestValue = "Automatic";
					} else if (parameterArray[i].contains("OPEN")) {
						requestValue = "Open System";
					} else if (parameterArray[i].contains("SHARED")) {
						requestValue = "Shared Key";
					}
					break;
				} else if (parameterArray[i].contains("WEP KEY FORMAT")
						&& requestParameter.contains("WEP KEY FORMAT")) {
					if (parameterArray[i].contains("HEX")) {
						requestValue = "Hexadecimal";
					} else if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					}
					break;
				} else if (parameterArray[i].contains("WEP KEY1") && requestParameter.contains("WEP KEY1")) {
					requestValue = parameterArray_Value[i].replace("WEP Key1 is", "").trim();
					break;
				} else if ((parameterArray[i].contains("VERSION") || parameterArray[i].contains("VERSION"))) {
					if (parameterArray[i].contains("AUTOMATIC")) {
						requestValue = "Automatic";
					} else if (parameterArray[i].contains("WPA2")) {
						requestValue = "WPA2";
					} else if (parameterArray[i].contains("WPA")) {
						requestValue = "WPA";
					} else if (parameterArray[i].contains("WPA2_PSK")) {
						requestValue = "WPA2-PSK";
					} else if (parameterArray[i].contains("WPA_PSK")) {
						requestValue = "WPA-PSK";
					}
					break;
				} else if ((parameterArray[i].contains("ENCRYPTION") || parameterArray[i].contains("ENCRYPTION"))) {
					if (parameterArray[i].contains("AUTOMATIC")) {
						requestValue = "Automatic";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP")) {
						requestValue = "TKIP";
					}
					break;
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("Radius Server IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is", "").trim();
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
				} else if (parameterArray[i].contains("DHCP END IP") && requestParameter.contains("DHCP END IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP End IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP START IP") && requestParameter.contains("DHCP START IP")) {
					requestValue = parameterArray_Value[i].replace("DHCP Start IP is", "").trim();
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

	public static boolean _TLWR740N_Model_changeRouterSettings(TestCases testCase, String baseURL, String screenName,
			String is_ssid, String ssid_name, String security, String password, String bandwidth, String channel,
			String mode, String encryption, String version, String WEPtype, String WEPKeyFormat, String WEPKey1,
			String ReadiuIP, String RadiusPort, String is_dhcp, String LeaseTime, String DHCPStartIP,
			String DHCPEndIP) {
		boolean flag = false;
		TpLinkRouterScreen tpLink = new TpLinkRouterScreen(testCase);
		try {
			if (tpLink.isTPLinkIDpopPresent()) {
				tpLink.clickonTPLinkIDpop();
			}
			if (screenName.contains("DHCP")) {
				if (tpLink.clickOnDHCP_TLWR740N()) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (tpLink.enable_disable_DHCP_TLWR740N(is_dhcp)) {
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
					} else if (tpLink.setvalueinDHCPLeaseTime_TLWR740N(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP Lease time in DHCP setting");
						flag = false;
					}

					if (DHCPStartIP == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to DHCPStartIP.");
					} else if (tpLink.setDHCPStartIP_TLWR740N(DHCPStartIP)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCPStartIPis set to " + DHCPStartIP);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCPStartIP in DHCP setting");
						flag = false;
					}
					if (DHCPEndIP == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCPEndIP .");
					} else if (tpLink.setDHCPEndIP_TLWR740N(DHCPEndIP)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCPEndIP is set to " + DHCPEndIP);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCPEndIP in DHCP setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to DHCP setting page in router.");
					flag = false;
				}

			} else if (screenName.contains("BASIC SETTINGS")) {
				if (tpLink.clickOnWireless_TLWR740N()) {
					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
					} else if (tpLink.enable_disable_SSID_TLWR740N(is_ssid)) {
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
					} else if (tpLink.setvalueinSSID24_TLWR740N(ssid_name)) {
						flag = true;
						WebController.changeWifiSSID_Password(ssid_name, null, null, null);
						Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to write broadcase SSID in wireless settings");
						flag = false;
					}

					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel.");
					} else if (tpLink.changeChannel24Ghz__TLWR740N(channel)) {
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
					} else if (tpLink.changeMode24Ghz_TLWR740N(mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode in Wireless Setting");
						flag = false;
					}

					if (bandwidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel width.");
					} else if (tpLink.changeChannelWidth24Ghz_TLWR740N(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change channelwidth in Wireless setting");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to naviagate to Wireless setting page in router.");
					flag = false;
				}
			}
			if (tpLink.clickOnSaveBtn_TLWR740N()) {
				if (tpLink.AcceptRequest()) {
					flag = true;
					Thread.sleep(40000);
					Keyword.ReportStep_Pass(testCase, "Settings saved");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Ok button.");

				}

			} else {
				Keyword.ReportStep_Pass(testCase, "Settings are same no need to change the settings");
				flag = true;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

}

//public static WifiSecurityMode _TLWR740N_Model_chaneRouterSecuritySettings(String securityType_request) {
//	WifiSecurityMode securityType = null;
//	String security_Type = WebController.router_SSID_securityType().toUpperCase();
//	if (securityType_request != null) {
//		security_Type = securityType_request;
//	} else {
//		if (security_Type != null) {
//			String encryption = WebController.router_SSID_securityEncryption().toUpperCase();
//			if (encryption != null) {
//				if (!encryption.isEmpty()) {
//					security_Type = security_Type + "_" + encryption;
//				}
//			}
//		} else {
//			securityType = null;
//		}
//	}
//	if (security_Type.contains("NONE")) {
//		securityType = WifiSecurityMode.NONE;
//	} else if (security_Type.contains("WEP")) {
//		if (security_Type.contains("SHARED")) {
//			securityType = WifiSecurityMode.WEP_Shared;
//		} else {
//			securityType = WifiSecurityMode.WEP_PSK;
//		}
//	} else if (security_Type.contains("WPA2")) {
//		if (security_Type.contains("AES".toUpperCase())) {
//			securityType = WifiSecurityMode.WPA2_AES_PSK;
//		} else if (security_Type.contains("TKIP".toUpperCase())) {
//			securityType = WifiSecurityMode.WPA2_TKIP_PSK;
//		} else {
//			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//		}
//	} else if (security_Type.contains("WPA")) {
//		if (security_Type.contains("AES".toUpperCase())) {
//			securityType = WifiSecurityMode.WPA_AES_PSK;
//		} else if (security_Type.contains("TKIP".toUpperCase())) {
//			securityType = WifiSecurityMode.WPA_TKIP_PSK;
//		} else {
//			securityType = WifiSecurityMode.WPA_MIXED_PSK;
//		}
//	} else {
//		securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//	}
//
//	return securityType;
//}
//public static WifiSecurityMode _AX1500_Model_chaneRouterSecuritySettings(String securityType_request) {
////	security           Encryption        
////	open system        None              
////	open system        WEP-64
////	open system        WEP-128
////	Shared Key         WEP-64
////	Shared Key         WEP-128
////	WPA-Personal       TKIP
////	WPA-Auto-Personal  TKIP+AES
////	WPA-Auto-Personal  AES
////	WPA2-Personal      AES
//	WifiSecurityMode securityType = null;
//	String security_Type = WebController.router_SSID_securityType().toUpperCase();
//	if (securityType_request != null) {
//		security_Type = securityType_request;
//	} else {
//		if (security_Type != null) {
//			String encryption = WebController.router_SSID_securityEncryption().toUpperCase();
//			if (encryption != null) {
//				if (!encryption.isEmpty()) {
//					security_Type = security_Type + "_" + encryption;
//				}
//			}
//		} else {
//			securityType = null;
//		}
//	}
//	if (security_Type.contains("NONE")) {
//		securityType = WifiSecurityMode.NONE;
//	} else if (security_Type.contains("WEP")) {
//		if (security_Type.contains("SHARED")) {
//			securityType = WifiSecurityMode.WEP_Shared;
//		} else {
//			securityType = WifiSecurityMode.WEP_PSK;
//		}
//	} else if (security_Type.contains("WPA2 AES")) {
//		if (security_Type.contains("AES".toUpperCase())) {
//			securityType = WifiSecurityMode.WPA2_AES_PSK;
//		} else {
//			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//		}
//	} else if (security_Type.contains("WPA_WPA2 MIXED") || security_Type.contains("WPA/WPA2 MIXED")
//			|| security_Type.contains("WPA2")) {
//		securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//	} else {
//		securityType = WifiSecurityMode.WPA2_MIXED_PSK;
//	}
//
//	return securityType;
//}