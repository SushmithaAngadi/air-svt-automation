package com.resideo.utils.web;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.web.screens.DLinkRouterScreen;

import io.grpc.netty.shaded.io.netty.handler.timeout.TimeoutException;

public class DLinkRouterUtils {

	public static boolean loginToRouter(TestCases testcase, String password) {
		boolean flag = false;

		DLinkRouterScreen dLink = new DLinkRouterScreen(testcase);
		flag = dLink.setPasswordTB(password);
		flag = flag && dLink.clickOnLoginBTN();

		Keyword.ReportStep_Pass(testcase, "Successfully login into the DLinkrouter Settings");

		return flag;
	}

	public static String pageSource(String screenName, String routerModel) {
		String pagecontainer = null;
		switch (routerModel) {
		case "RTAC68U":
			switch (screenName) {
			case "WIRELESS SETTING":
				pagecontainer = "Use this section to configure the wireless settings for your D-Link Router. Please make sure that any changes made in this section will need to be updated on your wireless device."
						.toUpperCase();
				break;
			case "HOME PAGE":
				pagecontainer = "Internet Connected".toUpperCase();
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "824VUP":
			switch (screenName) {
			case "WIRELESS SETTING":
				pagecontainer = "These are the wireless settings for the AP(Access Point) portion.".toUpperCase();
				break;
			case "HOME PAGE":
				pagecontainer = "Router ideal for home networking and small business networking".toUpperCase();
				break;
			case "DHCP":
				pagecontainer = "The DI-824VUP can be setup as a DHCP Server to distribute IP addresses to the LAN network."
						.toUpperCase();
				break;

			default:
				pagecontainer = "";
				break;
			}
		case "DIR1750":
			switch (screenName) {
			case "WIRELESS SETTING":
				pagecontainer = "USE THIS SECTION TO CONFIGURE THE WIRELESS SETTINGS FOR YOUR D-LINK ROUTER";
				break;
			case "HOME PAGE":
				pagecontainer = "INTERNET CONNECTED";
				break;
			case "DHCP":
				pagecontainer = "USE THIS SECTION TO CONFIGURE THE NETWORK SETTINGS FOR YOUR DEVICE";
				break;
			default:
				pagecontainer = "";
				break;
			}
		case "DIR890L":
			switch (screenName) {
			case "WIRELESS SETTING":
				pagecontainer = "USE THIS SECTION TO CONFIGURE THE WIRELESS SETTINGS FOR YOUR D-LINK ROUTER";
				break;
			case "HOME PAGE":
				pagecontainer = "INTERNET CONNECTED";
				break;
			case "DHCP":
				pagecontainer = "USE THIS SECTION TO CONFIGURE THE NETWORK SETTINGS FOR YOUR DEVICE";
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
						if (pageSource.toUpperCase().contains(pageSource(screenName, routerModel))) {
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

	public static boolean changeRouterSettingsInDLink(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			switch (routerModel) {
			case "824VUP":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "", "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
					}
				}
				flag = _824VUP_Model_chaneRouterSettings(testCase, screenName, baseurl, routerModel,
						getRouterSettings_824VUP(dataOptions, "CHANNEL"),
						getRouterSettings_824VUP(dataOptions, "SSID NAME"),
						getRouterSettings_824VUP(dataOptions, "SECURITY"),
						getRouterSettings_824VUP(dataOptions, "WEPENCRYPTION"),
						getRouterSettings_824VUP(dataOptions, "KEYMODE"),
						getRouterSettings_824VUP(dataOptions, "WEPKEY"),
						getRouterSettings_824VUP(dataOptions, "KEY LENG"),
						getRouterSettings_824VUP(dataOptions, "RADIUS IP"),
						getRouterSettings_824VUP(dataOptions, "RADIUS PORT"),
						getRouterSettings_824VUP(dataOptions, "RADIUS SHARED KEY"),
						getRouterSettings_824VUP(dataOptions, "IS SSID"),
						getRouterSettings_824VUP(dataOptions, "IS DHCP"),
						getRouterSettings_824VUP(dataOptions, "DHCP START IP ADD"),
						getRouterSettings_824VUP(dataOptions, "DHCP END IP ADD"),
						getRouterSettings_824VUP(dataOptions, "DHCP LEASE"),
						getRouterSettings_824VUP(dataOptions, "PRESHARED KEY"));

				if (flag) {
					String security = getRouterSettings_824VUP(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "DIR1750":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/Home.html", "HOME SETTINGS", routerModel)) {
						WebController.isloggedIn(true);
						flag = true;
					} else {
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				DLinkRouterScreen dLink = new DLinkRouterScreen(testCase);
				if (dLink.isAdminPasswordBoxPresent()) {
					flag = RouterControllUtils.LoginintoRouter(testCase,
							SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "USERNAME"),
							SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "PASSWORD"));
				}
				flag = _DIR1750_Model_changeRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_DIR1750(dataOptions, "FREQUENCY"),
						getRouterSettings_DIR1750(dataOptions, "CHANNEL"),
						getRouterSettings_DIR1750(dataOptions, "MODE"),
						getRouterSettings_DIR1750(dataOptions, "SECURITY"),
						getRouterSettings_DIR1750(dataOptions, "PASSWORD"),
						getRouterSettings_DIR1750(dataOptions, "SSID NAME"),
						getRouterSettings_DIR1750(dataOptions, "IS SSID"),
						getRouterSettings_DIR1750(dataOptions, "IS DHCP"),
						getRouterSettings_DIR1750(dataOptions, "BANDWIDTH"),
						getRouterSettings_DIR1750(dataOptions, "STARTING IP ADD"),
						getRouterSettings_DIR1750(dataOptions, "ENDING IP ADD"),
						getRouterSettings_DIR1750(dataOptions, "DHCPLEASE"));
				if (flag) {
					String security = getRouterSettings_DIR1750(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "DIR890L":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/Home.html", "HOME PAGE", routerModel)) {
						WebController.isloggedIn(true);
						flag = true;
					} else {
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				if (!flag && !WebController.isloggedIn()) {
					flag = flag && RouterControllUtils.LoginintoRouter(testCase, null,
							SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "PASSWORD"));
				}
				flag = _DIR890L_Model_changeRouterSettings(testCase, screenName, baseurl,
						getRouterSettings_DIR890L(dataOptions, "FREQUENCY"),
						getRouterSettings_DIR890L(dataOptions, "CHANNEL"),
						getRouterSettings_DIR890L(dataOptions, "MODE"),
						getRouterSettings_DIR890L(dataOptions, "SECURITY"),
						getRouterSettings_DIR890L(dataOptions, "PASSWORD"),
						getRouterSettings_DIR890L(dataOptions, "SSID NAME"),
						getRouterSettings_DIR890L(dataOptions, "IS SSID"),
						getRouterSettings_DIR890L(dataOptions, "IS DHCP"),
						getRouterSettings_DIR890L(dataOptions, "BANDWIDTH"),
						getRouterSettings_DIR890L(dataOptions, "STARTING IP ADD"),
						getRouterSettings_DIR890L(dataOptions, "ENDING IP ADD"),
						getRouterSettings_DIR890L(dataOptions, "DHCPLEASE"));
				if (flag) {
					String security = getRouterSettings_DIR890L(dataOptions, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
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

	private static boolean _824VUP_Model_chaneRouterSettings(TestCases testCase, String screenName, String baseURL,
			String routerModel, String channel, String ssid_name, String security, String wep_encryption,
			String key_mode, String wep_key, String key_leng, String radiusip, String radiusport,
			String radius_shared_key, String is_ssid, String is_dhcp, String dhcp_start_ip_add, String dhcp_end_ip_add,
			String dhcplease, String preshared_key) {
		boolean flag = false;
		DLinkRouterScreen dlinkScreen = new DLinkRouterScreen(testCase);
		if (!baseURL.contains("http")) {
			baseURL = "http://" + baseURL;
		}
		try {
			if (checkPageLoadingComplete(testCase)) {
				if (screenName.contains("WIRELESS SETTINGS")) {
					flag = dlinkScreen.switchToDefaultFrame();
					flag = flag & dlinkScreen.switchToMainFrame_824VUP();
					if (dlinkScreen.clickOnWirelessTab_824VUP()) {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Wireless radio SSID.");
						} else if (dlinkScreen.is_ssid_824VUP(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change is_ssid to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change is_ssid in Wireless setting");
							flag = false;
						}
						if (channel == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change channel.");
						} else if (dlinkScreen.changeChannel_824VUP(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}
						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dlinkScreen.setvalueinSSID_824VUP(ssid_name)) {
							flag = true;
							WebController.changeWifiSSID_Password(ssid_name, null, null, null);
							Keyword.ReportStep_Pass(testCase, "Change SSIDname to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to write broadcase SSID in wireless settings");
							flag = false;
						}
						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (security.toUpperCase().contains("NONE")
								&& dlinkScreen.changeSecurity_824VUP(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);

						} else if (security.toUpperCase().contains("WEP")
								&& dlinkScreen.changeSecurity_824VUP(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (wep_encryption == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPKeyEncryption.");
							} else if (dlinkScreen.selectWEPKeyEncryption_824VUP(wep_encryption)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change WEPKeyEncryption to " + wep_encryption);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEPKeyEncryption in Wireless setting");
								flag = false;
							}
							if (key_mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Key Mode.");
							} else if (dlinkScreen.selectWEPKeyMode_824VUP(key_mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change KeyMode to " + key_mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Keymode in Wireless setting");
								flag = false;
							}
							if (wep_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change WEPKey1.");
							} else if (dlinkScreen.setWEPKey_824VUP(wep_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change WEPKey1 to " + wep_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change WEPKey in Wireless setting");
								flag = false;
							}

						} else if (security.toUpperCase().contains("802.1X")
								&& dlinkScreen.changeSecurity_824VUP(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (key_leng == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change KeyLength.");
							} else if (dlinkScreen.selectRadiusKeyLength_824VUP(key_leng)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change KeyLength to " + key_leng);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change KeyLength in Wireless setting");
								flag = false;
							}
							if (radiusip == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
							} else if (dlinkScreen.setRadiusIP_824VUP(radiusip)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + radiusip);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP in Wireless setting");
								flag = false;
							}
							if (radiusport == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
							} else if (dlinkScreen.setRadiusPort_824VUP(radiusport)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + radiusport);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort in Wireless setting");
								flag = false;
							}
							if (radius_shared_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
							} else if (dlinkScreen.setRadiusSharedKey_824VUP(radius_shared_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change radius shared key to " + radius_shared_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Radius Shared Key in Wireless setting");
								flag = false;
							}
						} else if (security.toUpperCase().contains("WPA-PSK")
								&& dlinkScreen.changeSecurity_824VUP(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (preshared_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change pre shared KEYMODE in WPA-PSK.");
							} else if (dlinkScreen.setPreSharedKey_824VUP(preshared_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase,
										"Change preshared key in WPA-PSK to " + preshared_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Pre Shared Key (WPA-PSK) in Wireless setting");
								flag = false;
							}
						} else if (security.toUpperCase().contains("WPA")
								&& dlinkScreen.changeSecurity_824VUP(security)) {
							WebController.changeWifiSSID_Password(null, null, security.toUpperCase(), null);
							if (radiusip == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusIP.");
							} else if (dlinkScreen.setRadiusIP_824VUP(radiusip)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change RadiusIP to " + radiusip);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusIP in Wireless setting");
								flag = false;
							}
							if (radiusport == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
							} else if (dlinkScreen.setRadiusPort_824VUP(radiusport)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change RadiusPort to " + radiusport);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change RadiusPort in Wireless setting");
								flag = false;
							}
							if (radius_shared_key == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change RadiusPort.");
							} else if (dlinkScreen.setRadiusSharedKey_824VUP(radius_shared_key)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change radius shared key to " + radius_shared_key);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Radius Shared Key in Wireless setting");
								flag = false;
							}
						}
					}
				} else if (screenName.contains("DHCP")) {
					flag = dlinkScreen.switchToDefaultFrame();
					flag = flag & dlinkScreen.switchToMainFrame_824VUP();
					if (dlinkScreen.clickOnWirelessSecurityTab_824VUP()) {
						if (is_dhcp == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
						} else if (dlinkScreen.enable_disable_DHCP_824VUP(is_dhcp)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change DHCP enable disable setting");
							flag = false;
						}
						if (dhcplease == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Lease time setting.");
						} else if (dlinkScreen.setvalueinDHCPLeaseTime_824VUP(dhcplease)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "DHCP LEASE time is set to " + dhcplease);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change DHCP Lease time in DHCP setting");
							flag = false;
						}
						if (dhcp_start_ip_add == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change DHCP Start IP.");
						} else if (dlinkScreen.setDHCPStartIPAdd_824VUP(dhcp_start_ip_add)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "changed DHCPStartIPAdd to ." + dhcp_start_ip_add);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change DHCPStartIPAdd from dhcp settings");
							flag = false;
						}
						if (dhcp_end_ip_add == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change DHCP End IP.");
						} else if (dlinkScreen.setDHCPEndIPAdd_824VUP(dhcp_end_ip_add)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "changed DHCPEndIPAdd to ." + dhcp_end_ip_add);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change DHCPEndIPAdd from dhcp settings");
							flag = false;
						}
					}
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			return flag;
		}
		if (flag) {
			if (dlinkScreen.clickonApplybutton_824VUP(screenName)) {
				if (security != null
						&& (security.toUpperCase().contains("WEP") || (security.trim().equals("WPA")
								&& preshared_key != null && preshared_key.toUpperCase().contains("PRESHARED KEY")))
						&& ExpectedConditions.alertIsPresent() != null) {
					if (dlinkScreen.acceptAlert_824VUP()) {
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to Accept the Alert");
					}
				} else if (dlinkScreen.clickOnContinueBTN_824VUP()) {
					flag = true;
					dlinkScreen.iselementPresent_824VUP(30);
					Keyword.ReportStep_Pass(testCase, "Settings Applied");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"not able to click on continue Now button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
				flag = false;
			}
		}
		return flag;
	}

	public static String getRouterSettings_824VUP(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("1")) {
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
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11";
					}
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {
					if (parameterArray[i].contains("None".toUpperCase())) {
						requestValue = "NONE";
					} else if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("802.1X".toUpperCase())) {
						requestValue = "802.1X";
					} else if (parameterArray[i].contains("WPA-PSK".toUpperCase())) {
						requestValue = "WPA-PSK";
					} else if (parameterArray[i].contains("WPA".toUpperCase())) {
						requestValue = "WPA";
					} else
						break;
				} else if (parameterArray[i].contains("WEPENCRYPTION") && requestParameter.contains("WEPENCRYPTION")) {
					if (parameterArray[i].contains("64")) {
						requestValue = "64 Bit";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "128 Bit";
					} else if (parameterArray[i].contains("256")) {
						requestValue = "256 Bit";
					}
					break;
				} else if (parameterArray[i].contains("KEYMODE") && requestParameter.contains("KEYMODE")) {
					if (parameterArray[i].contains("ASCII")) {
						requestValue = "ASCII";
					} else {
						requestValue = "HEX";
					}
					break;
				} else if (parameterArray[i].contains("WEPKEY") && requestParameter.contains("WEPKEY")) {
					requestValue = parameterArray_Value[i].replace("WEPKEY is", "").trim();
					break;
				} else if (parameterArray[i].contains("KEY LENG") && requestParameter.contains("KEY LENG")) {
					if (parameterArray[i].contains("64")) {
						requestValue = " 64-bit";
					} else {
						requestValue = "128-bit";
					}
					break;
				} else if (parameterArray[i].contains("RADIUS IP") && requestParameter.contains("RADIUS IP")) {
					requestValue = parameterArray_Value[i].replace("Radius IP is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS SHARED KEY")
						&& requestParameter.contains("RADIUS SHARED KEY")) {
					requestValue = parameterArray_Value[i].replace("RADIUS SHARED KEY is", "").trim();
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
				} else if (parameterArray[i].contains("DHCP START IP ADD")
						&& requestParameter.contains("DHCP START IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP Start IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP END IP ADD")
						&& requestParameter.contains("DHCP END IP ADD")) {
					requestValue = parameterArray_Value[i].replace("DHCP End IP Address is", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP LEASE") && requestParameter.contains("DHCP LEASE")) {
					if (parameterArray[i].contains("1 HOUR")) {
						requestValue = "1 HOUR";
					} else if (parameterArray[i].contains("2 HOURS")) {
						requestValue = "2 HOURS";
					} else if (parameterArray[i].contains("3 HOURS")) {
						requestValue = "3 HOURS";
					} else if (parameterArray[i].contains("1 WEEK")) {
						requestValue = "1 WEEK";
					} else if (parameterArray[i].contains("2 DAYS")) {
						requestValue = "2 DAYS";
					} else if (parameterArray[i].contains("3 DAYS")) {
						requestValue = "3 DAYS";
					} else if (parameterArray[i].contains("1 DAY")) {
						requestValue = "1 DAY";
					}
					break;
				} else if (parameterArray[i].contains("PRESHARED KEY") && requestParameter.contains("PRESHARED KEY")) {
					requestValue = parameterArray_Value[i].replace("PRESHARED KEY is", "").trim();
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;

	}

	public static boolean checkPageLoadingComplete(TestCases testCase) {
		Boolean flag = true;
		try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
			fwait.pollingEvery(Duration.ofSeconds(1));
			fwait.withTimeout(Duration.ofSeconds(60));
			fwait.ignoring(Exception.class);
			Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					String pageSource = driver.getPageSource();
					if (pageSource.toUpperCase().contains("THIS PAGE ISN'T WORKING")) {
						System.out.println("Page loading");
						driver.navigate().refresh();
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

	public static String getRouterSettings_DIR1750(String data, String requestParameter) {
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
				}
				if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {

					if (parameterArray[i].contains("20_40_80")) {
						requestValue = "Auto 20/40/80 MHz";
					} else if (parameterArray[i].contains("20_40")) {
						requestValue = "Auto 20/40 MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B_G_N")) {
						requestValue = "Mixed 802.11b/g/n";
					} else if (parameterArray[i].contains("A_N_AC")) {
						requestValue = "Mixed 802.11a/n/ac";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "Mixed 802.11b/g";
					} else if (parameterArray[i].contains("G_N")) {
						requestValue = "Mixed 802.11g/n";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "802.11b only";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "802.11g only";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n only";
					} else if (parameterArray[i].contains("A_N")) {
						requestValue = "Mixed 802.11a/n";
					} else if (parameterArray[i].contains("A ONLY")) {
						requestValue = "802.11a only";
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
					} else if (parameterArray[i].contains("WPA3_PERSONAL")) {
						requestValue = "WPA3-Personal";
					} else if (parameterArray[i].contains("WPA2_WPA3_PERSONAL")) {
						requestValue = "WPA2/WPA3-Personal";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA2-Personal";
					} else if (parameterArray[i].contains("WPA_WPA2_PERSONAL")) {
						requestValue = "WPA/WPA2-Personal";
					} else
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
				} else if (parameterArray[i].contains("DHCPLEASE") && requestParameter.contains("DHCPLEASE")) {
					requestValue = parameterArray_Value[i].replace("DHCPLease time is", "").trim();
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

	public static boolean _DIR1750_Model_changeRouterSettings(TestCases testCase, String screenName, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String bandWidth, String startIpAdd, String endIpAdd, String leaseTime) {
		boolean flag = true;
		DLinkRouterScreen dLink = new DLinkRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			if (screenName.contains("WIRELESS")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/WiFi.html", "WIRELESS SETTING", routerModel)) {
					if (dLink.enable_disableWifiMeshTogBTN("DISABLE")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Disabled the Wifi Mesh.");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to disable Wifi Mesh. ");
						flag = false;
					}
					if (dLink.enable_disableSmartConnectTogBTN("DISABLE")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Disabled the Smart connection.");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to disable Smart Connection ");
						flag = false;
					}
					if (frequency.contains("2.4")) {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dLink.is2GHzToggleBTNEnabledDisable(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID enable disable setting");
							flag = false;
						}

						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change ssid name.");
						} else if (dLink.setSSIDName2G_DIR1750(ssid_name)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Name setting is changed to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID Name disable setting");
							flag = false;
						}

						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (dLink.setPassword2G_DIR1750(password)) {
							flag = dLink.clickOnOkBtn();
							flag = flag && true;
							Keyword.ReportStep_Pass(testCase, "password is changed to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password disable setting");
							flag = false;
						}

						if (dLink.clickOnAdvancedSettings2GHz()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Advanced settings2GHz ");
							flag = false;
						}

						if (mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
						} else if (dLink.changeMode2GHzBTN(mode)) {
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
						} else if (dLink.changeWiFiChannel2GHzBTN(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}

						if (bandWidth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
						} else if (dLink.changebandWidth2GHzBTN(bandWidth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + bandWidth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change bandWidth in Wireless setting");
							flag = false;
						}

						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (dLink.changeSecurityMode2GHzBTN(security)) {
							flag = true;
							flag = dLink.clickOnOkBtn();
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change security in Wireless setting");
							flag = false;
						}

					} else {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dLink.is5GHzToggleBTNEnabledDisable(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID enable disable setting");
							flag = false;
						}

						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change ssid name.");
						} else if (dLink.setSSIDName5G_DIR1750(ssid_name)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Name setting is changed to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID Name disable setting");
							flag = false;
						}

						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (dLink.setPassword5G_DIR1750(password)) {
							flag = dLink.clickOnOkBtn();
							flag = flag && true;
							Keyword.ReportStep_Pass(testCase, "password is changed to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password disable setting");
							flag = false;
						}

						if (dLink.clickOnAdvancedSettings5GHz()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Advanced Settings ");
							flag = false;
						}
						if (mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
						} else if (dLink.changeMode5GHzBTN(mode)) {
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
						} else if (dLink.changeWiFiChannel5GHzBTN(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}

						if (bandWidth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
						} else if (dLink.changebandWidth5GHzBTN(bandWidth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + bandWidth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change bandWidth in Wireless setting");
							flag = false;
						}

						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (dLink.changeSecurityMode5GHzBTN(security)) {
							flag = dLink.clickOnOkBtn();
							flag = flag && true;
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change security in Wireless setting");
							flag = false;
						}

					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to navigate to WIRELESS SETTING screen.");
					flag = false;
				}

			} else if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/Network.html", "DHCP", routerModel)) {
					if (dLink.clickOnAdvancedSettingsDHCP()) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Advanced settings in DHCP Screen. ");
						flag = false;
					}
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast dhcp.");
					} else if (dLink.isDHCPToggleBTNEnabledDisable(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}
					if (startIpAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp startIpAdd.");
					} else if (dLink.setDHCPstartIpAdd_DIR1750(startIpAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP startIpAdd is changed to " + startIpAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP startIpAdd");
						flag = false;
					}

					if (endIpAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp endIpAdd.");
					} else if (dLink.setDHCPendIpAdd_DIR1750(endIpAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP endIpAdd is changed to " + endIpAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP endIpAdd.");
						flag = false;
					}

					if (leaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp leaseTime.");
					} else if (dLink.setDHCPleaseTime_DIR1750(leaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP leaseTime is changed to :" + leaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP leaseTime.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to navigate to DHCP screen.");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen name.");
				flag = false;
			}
			if (flag) {
				if (dLink.clickOnSaveBTN()) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Save Button");
					if (dLink.clickOnOkPopUpBTN()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on Ok Button");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Ok Button");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Save Button");
					flag = false;
				}
			}

		} catch (

		Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static String getRouterSettings_DIR890L(String data, String requestParameter) {
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
				}
				if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {

					if (parameterArray[i].contains("20_40_80")) {
						requestValue = "Auto 20/40/80 MHz";
					} else if (parameterArray[i].contains("20_40")) {
						requestValue = "Auto 20/40 MHz";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {
					if (parameterArray[i].contains("B_G_N")) {
						requestValue = "Mixed 802.11b/g/n";
					} else if (parameterArray[i].contains("A_N_AC")) {
						requestValue = "Mixed 802.11a/n/ac";
					} else if (parameterArray[i].contains("B_G")) {
						requestValue = "Mixed 802.11b/g";
					} else if (parameterArray[i].contains("G_N")) {
						requestValue = "Mixed 802.11g/n";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "802.11b only";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "802.11g only";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n only";
					} else if (parameterArray[i].contains("A_N")) {
						requestValue = "Mixed 802.11a/n";
					} else if (parameterArray[i].contains("A ONLY")) {
						requestValue = "802.11a only";
					}
					break;
				} else if (parameterArray[i].contains("FREQUENCY") && requestParameter.contains("FREQUENCY")) {
					if (parameterArray[i].contains("2.4")) {
						requestValue = "2.4GHz";
					} else if (parameterArray[i].contains("PRIMARY")) {
						requestValue = "5GHz_PRIMARY";
					} else if (parameterArray[i].contains("SECONDARY")) {
						requestValue = "5GHz_SECONDARY";
					}
					break;
				} else if (parameterArray[i].contains("PASSWORD") && requestParameter.contains("PASSWORD")) {
					requestValue = parameterArray_Value[i].replace("PASSWORD is", "").trim();
					break;
				} else if (parameterArray[i].contains("SSID NAME") && requestParameter.contains("SSID NAME")) {
					requestValue = parameterArray_Value[i].replace("SSID name is", "").trim();
					break;
				} else if (parameterArray[i].contains("SECURITY") && requestParameter.contains("SECURITY")) {

					if (parameterArray[i].contains("NONE")) {
						requestValue = "None";
					} else if (parameterArray[i].contains("WPA3_PERSONAL")) {
						requestValue = "WPA3-Personal";
					} else if (parameterArray[i].contains("WPA_WPA2_PERSONAL")) {
						requestValue = "WPA/WPA2-Personal";
					} else if (parameterArray[i].contains("WPA2_WPA3_PERSONAL")) {
						requestValue = "WPA2/WPA3-Personal";
					} else if (parameterArray[i].contains("WPA2_PERSONAL")) {
						requestValue = "WPA2-Personal";
					} else if (parameterArray[i].contains("WEP")) {
						requestValue = "WEP";
					} else
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
				} else if (parameterArray[i].contains("DHCPLEASE") && requestParameter.contains("DHCPLEASE")) {
					requestValue = parameterArray_Value[i].replace("DHCPLease time is", "").trim();
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
		} else

		{
			return null;
		}
		return requestValue;

	}

	public static boolean _DIR890L_Model_changeRouterSettings(TestCases testCase, String screenName, String baseURL,
			String frequency, String channel, String mode, String security, String password, String ssid_name,
			String is_ssid, String is_dhcp, String bandWidth, String startIpAdd, String endIpAdd, String leaseTime) {
		boolean flag = true;
		DLinkRouterScreen dLink = new DLinkRouterScreen(testCase);
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase().trim();
			if (screenName.contains("WIRELESS")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/WiFi.html", "WIRELESS SETTING", routerModel)) {
					if (dLink.enable_disableSmartConnectTogBTN("DISABLE")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Disabled the Smart connection.");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to disable Smart Connection ");
						flag = false;
					}
					if (frequency.contains("2.4")) {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dLink.is2GHzToggleBTNEnabledDisable_890L(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID enable disable setting");
							flag = false;
						}

						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change ssid name.");
						} else if (dLink.setSSIDName2G_DIR1750(ssid_name)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Name setting is changed to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID Name disable setting");
							flag = false;
						}
						if (dLink.clickOnAdvancedSettings2GHz_890L()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Advanced settings2GHz ");
							flag = false;
						}

						if (mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
						} else if (dLink.changeMode2GHzBTN(mode)) {
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
						} else if (dLink.changeWiFiChannel2GHzBTN(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}

						if (bandWidth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
						} else if (dLink.changebandWidth2GHzBTN(bandWidth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + bandWidth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change bandWidth in Wireless setting");
							flag = false;
						}

						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (dLink.changeSecurityMode2GHzBTN(security)) {
							flag = true;
							flag = dLink.clickOnOkBtn();
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change security in Wireless setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (dLink.setPassword2G_DIR1750(password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "password is changed to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password disable setting");
							flag = false;
						}

					} else if (frequency.contains("PRIMARY")) {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dLink.is5GHzToggleBTNEnabledDisable_890L(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID enable disable setting");
							flag = false;
						}

						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change ssid name.");
						} else if (dLink.setSSIDName5G_DIR1750(ssid_name)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Name setting is changed to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID Name disable setting");
							flag = false;
						}

						if (dLink.clickOnAdvancedSettings5GHz_890L()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Advanced Settings ");
							flag = false;
						}
						if (mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
						} else if (dLink.changeMode5GHzBTN(mode)) {
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
						} else if (dLink.changeWiFiChannel5GHzBTN(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}

						if (bandWidth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
						} else if (dLink.changebandWidth5GHzBTN(bandWidth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + bandWidth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change bandWidth in Wireless setting");
							flag = false;
						}

						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (dLink.changeSecurityMode5GHzBTN(security)) {
							flag = dLink.clickOnOkBtn();
							flag = flag && true;
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change security in Wireless setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (dLink.setPassword5G_DIR1750(password)) {
							flag = dLink.clickOnOkBtn();
							flag = flag && true;
							Keyword.ReportStep_Pass(testCase, "password is changed to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password disable setting");
							flag = false;
						}

					} else if (frequency.contains("SECONDARY") && frequency.contains("5")) {
						if (is_ssid == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change broadcast ssid.");
						} else if (dLink.is5SGHzToggleBTNEnabledDisable(is_ssid)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Enable setting is changed to " + is_ssid);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID enable disable setting");
							flag = false;
						}

						if (ssid_name == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change ssid name.");
						} else if (dLink.setSSIDName5SG_890L(ssid_name)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "SSID Name setting is changed to " + ssid_name);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change SSID Name disable setting");
							flag = false;
						}

						if (dLink.clickOnAdvancedSettings5SGHz()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Advanced Settings ");
							flag = false;
						}

						if (channel == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change channel.");
						} else if (dLink.changeWiFiChannel5SGHzBTN(channel)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change channel in Wireless setting");
							flag = false;
						}

						if (bandWidth == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change bandWidth.");
						} else if (dLink.changebandWidth5SGHzBTN(bandWidth)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change channel to " + bandWidth);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change bandWidth in Wireless setting");
							flag = false;
						}
						if (mode == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
						} else if (dLink.changeMode5SGHzBTN(mode)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change Mode in Wireless Setting");
							flag = false;
						}

						if (security == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change security.");
						} else if (dLink.changeSecurityMode5SGHzBTN(security)) {
							Keyword.ReportStep_Pass(testCase, "Change security to " + security);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change security of 5S in Wireless setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "No need to change password.");
						} else if (dLink.setPassword5SG_890L(password)) {
							Keyword.ReportStep_Pass(testCase, "password is changed to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password disable setting");
							flag = false;
						}

					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to navigate to WIRELESS SETTING screen.");
					flag = false;
				}

			} else if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, "http://" + baseURL, "/Network.html", "DHCP", routerModel)) {
					if (dLink.clickOnAdvancedSettingsDHCP()) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Advanced settings in DHCP Screen. ");
						flag = false;
					}
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change broadcast dhcp.");
					} else if (dLink.isDHCPToggleBTNEnabledDisable(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP Enable setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}

					if (startIpAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp startIpAdd.");
					} else if (dLink.setDHCPstartIpAdd_DIR1750(startIpAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP startIpAdd is changed to " + startIpAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP startIpAdd");
						flag = false;
					}

					if (endIpAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp endIpAdd.");
					} else if (dLink.setDHCPendIpAdd_DIR1750(endIpAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP endIpAdd is changed to " + endIpAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP endIpAdd.");
						flag = false;
					}

					if (leaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change dhcp leaseTime.");
					} else if (dLink.setDHCPleaseTime_DIR1750(leaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP leaseTime is changed to :" + leaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP leaseTime.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to navigate to DHCP screen.");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Screen name.");
				flag = false;
			}
			if (flag) {
				if (dLink.clickOnSaveBTN()) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on Save Button");
					if (dLink.clickOnOkPopUpBTN_DIR890L()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on Ok Button");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Ok Button");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Save Button");
					flag = false;
				}
			}

		} catch (

		Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

}