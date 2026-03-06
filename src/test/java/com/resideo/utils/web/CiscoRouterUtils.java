package com.resideo.utils.web;

import java.io.IOException;
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
import com.resideo.utils.web.screens.CiscoRouterScreen;

public class CiscoRouterUtils {

	public static boolean changeRouterSettingsInCisco(TestCases testCase, String screenName, String options) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL")
					.toUpperCase();

			switch (routerModel) {
			case "EA6900V1":
				flag = _EA6900V1_Model_chaneRouterSettings(testCase, screenName, getRouterSettings(options, "FREQUENCY"),
						getRouterSettings(options, "CHANNEL"), getRouterSettings(options, "MODE"),
						getRouterSettings(options, "SECURITY"), getRouterSettings(options, "PASSWORD"),
						getRouterSettings(options, "SSID NAME"), getRouterSettings(options, "IS SSID"),
						getRouterSettings(options, "IS DHCP"), getRouterSettings(options, "WEPENCRYPTION"),
						getRouterSettings(options, "RADIUS SERVER"), getRouterSettings(options, "RADIUS PORT"),
						getRouterSettings(options, "SHARED KEY"), getRouterSettings(options, "START IP ADDRESS"),
						getRouterSettings(options, "MAX NO USERS"), getRouterSettings(options, "CLIENT LEASE TIME"),
						getRouterSettings(options, "BANDWIDTH"), getRouterSettings(options, "DNS IP"));
				if (flag) {
					String security = getRouterSettings(options, "SECURITY");
					if (security != null) {
						if (!security.isEmpty()) {
							WebController.securityType(WebCommonUtils.changeRouterSecuritySettings(security));
						}
					}
				}
				break;
			case "WRT120N":
				String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "http://" + baseurl, "/index.stm?title=Setup-Basic%20Setup",
							"HOME SETTINGS")) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}
				flag = _WRT120N_Model_chaneRouterSettings(testCase, baseurl, screenName,
						getRouterSettings_WRT120N(options, "FREQUENCY"), getRouterSettings_WRT120N(options, "IS SSID"),
						getRouterSettings_WRT120N(options, "SSID NAME"), getRouterSettings_WRT120N(options, "SECURITY"),
						getRouterSettings_WRT120N(options, "PASSWORD"), getRouterSettings_WRT120N(options, "BANDWIDTH"),
						getRouterSettings_WRT120N(options, "CHANNEL"), getRouterSettings_WRT120N(options, "MODE"),
						getRouterSettings_WRT120N(options, "IS DHCP"), getRouterSettings_WRT120N(options, "DNS IP1"),
						getRouterSettings_WRT120N(options, "DNS IP2"), getRouterSettings_WRT120N(options, "LEASETIME"),
						getRouterSettings_WRT120N(options, "MAX NUMBER"),
						getRouterSettings_WRT120N(options, "START IP ADD"),
						getRouterSettings_WRT120N(options, "ENCRYPTION"),
						getRouterSettings_WRT120N(options, "KEY RENEW"),
						getRouterSettings_WRT120N(options, "RADIUS SERVER"),
						getRouterSettings_WRT120N(options, "RADIUS PORT"));
				if (flag) {
					String security = getRouterSettings(options, "SECURITY");
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
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception occurred due to " + e.getMessage());
			return false;
		}
		return flag;
	}

	private static WifiSecurityMode _EA6900V1_Model_chaneRouterSecuritySettings(String securityType_request) {
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
		if (security_Type.contains("NONE")) {
			securityType = WifiSecurityMode.NONE;
		} else if (security_Type.contains("WEP")) {
			if (security_Type.contains("SHARED")) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else {
				securityType = WifiSecurityMode.WEP_PSK;
			}
		} else if (security_Type.contains("WPA2")) {
			if (security_Type.contains("PERSONAL".toUpperCase())) {
				securityType = WifiSecurityMode.WPA2_TKIP_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_TKIP_Enterprise;
			}
		} else if (security_Type.contains("WPA_WPA2 MIXED") || security_Type.contains("WPA/WPA2 MIXED")) {
			if (security_Type.contains("PERSONAL")) {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			} else {
				securityType = WifiSecurityMode.WPA2_MIXED_Enterprise;
			}

		}

		return securityType;
	}

	private static boolean _EA6900V1_Model_chaneRouterSettings(TestCases testCase, String screenName, String frequency,
			String channel, String mode, String security, String password, String ssid_name, String is_ssid,
			String is_dhcp, String WepEncryption, String RadiusServerValaue, String RadiusPortValue, String SharedKey,
			String StartIPAddress, String MaxNoUsers, String ClientLeaseTime,  String bandwidth, String DnsIPAddress){
		boolean flag = true;
		CiscoRouterScreen ciscoScreen = new CiscoRouterScreen(testCase);
		try {
			if (checkPageLoadingComplete(testCase)) {
				if (screenName.contains("WIRELESS SETTINGS")) {
					if (ciscoScreen.clickOnWireless()) {
						if (ciscoScreen.clickOnBasicWirelessTab()) {
							if (security == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change security.");
							} else {
								if (frequency.toUpperCase().contains("2.4")) {
									if (security.toUpperCase().contains("NONE")) {
										if (ciscoScreen.clickOnSecurity2GType("None")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "NONE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as none");
										}
									} else if (security.toUpperCase().contains("WEP")) {
										if (ciscoScreen.clickOnSecurity2GType("WEP")) {
											if (ciscoScreen.acceptWarning()) {
												flag = true;
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Failed to accept the Warning for WEP");
											}
											if (WepEncryption.toUpperCase().contains("64")) {
												if (ciscoScreen.clickOnWepEncryption2G("40 / 64-bit (10 hex digits)")) {
													flag = true;
													WebController.changeWifiSSID_Password(null, null, null, "WEP-64");
												}
											} else if (WepEncryption.toUpperCase().contains("128")) {
												if (ciscoScreen
														.clickOnWepEncryption2G("104 / 128-bit (26 hex digits)")) {
													flag = true;
													WebController.changeWifiSSID_Password(null, null, null, "WEP-128");
												}
											}
											if (ciscoScreen.clickOnGenerate2G()) {
												Keyword.ReportStep_Pass(testCase,
														"Succesfuly clicked on Generate button.");
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Failed to click on Generate button");
											}

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wep");
										}
									} else if (security.toUpperCase().contains("WPA2 PERSONAL")) {
										if (ciscoScreen.clickOnSecurity2GType("WPA2 Personal")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 PERSONAL", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 Personal");
										}
									} else if (security.toUpperCase().contains("WPA2 ENTERPRISE")) {
										if (ciscoScreen.clickOnSecurity2GType("WPA2 Enterprise")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 ENTERPRISE", null);

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 Enterprise");
										}
										if (RadiusServerValaue != null) {
											if (ciscoScreen.setRadiusServer2G(RadiusServerValaue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Server is null");
										}
										if (RadiusPortValue != null) {
											if (ciscoScreen.setRadiusPort2G(RadiusPortValue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Port is null");
										}

										if (SharedKey != null) {
											if (ciscoScreen.setSharedKey2G(SharedKey)) {
												Keyword.ReportStep_Pass(testCase, "Succesfully changed Shared Key.");
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Shared Keys is null");
										}

									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED PERSONAL")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED PERSONAL")) {
										if (ciscoScreen.clickOnSecurity2GType("WPA2/WPA Mixed Personal")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA_WPA2 MIXED PERSONAL",
													null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wpa wpa2 mixed");
										}

									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED ENTERPRISE")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED ENTERPRISE")) {
										if (ciscoScreen.clickOnSecurity2GType("WPA2/WPA Mixed Enterprise")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null,
													"WPA_WPA2 MIXED ENTERPRISE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wpa wpa2 mixed Enterprise");
										}
										if (RadiusServerValaue != null) {
											if (ciscoScreen.setRadiusServer2G(RadiusServerValaue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Server is null");
										}
										if (RadiusPortValue != null) {
											if (ciscoScreen.setRadiusPort2G(RadiusPortValue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Port");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Port is null");
										}

										if (SharedKey != null) {
											if (ciscoScreen.setSharedKey2G(SharedKey)) {
												Keyword.ReportStep_Pass(testCase, "Succesfully changed Shared Key.");
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Shared Key is null");
										}

									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Cisco router with this model doesn't support " + security
														+ " Security option");
										return false;
									}
								} else if (frequency.toUpperCase().contains("5")) {
									if (security.toUpperCase().contains("NONE")) {
										if (ciscoScreen.clickOnSecurity5GType("None")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "NONE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as none");
										}
									} else if (security.toUpperCase().contains("WEP")) {
										if (ciscoScreen.clickOnSecurity5GType("WEP")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WEP", null);
											if (ciscoScreen.acceptWarning()) {
												flag = true;
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Failed to accept the Warning");
											}
											if (WepEncryption.toUpperCase().contains("64")) {
												if (ciscoScreen.clickOnWepEncryption5G("40 / 64-bit (10 hex digits)")) {
													flag = true;
													WebController.changeWifiSSID_Password(null, null, null, "WEP-64");
												}
											} else if (WepEncryption.toUpperCase().contains("128")) {
												if (ciscoScreen
														.clickOnWepEncryption5G("104 / 128-bit (26 hex digits)")) {
													flag = true;
													WebController.changeWifiSSID_Password(null, null, null, "WEP-128");
												}
											}
											if (ciscoScreen.clickOnGenerate5G()) {
												Keyword.ReportStep_Pass(testCase,
														"Succesfuly clicked on Generate button.");
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Failed to click on Generate button");
											}

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wep");
										}
									} else if (security.toUpperCase().contains("WPA2 PERSONAL")) {
										if (ciscoScreen.clickOnSecurity5GType("WPA2 Personal")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 AES", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 Personal");
										}
									} else if (security.toUpperCase().contains("WPA2 ENTERPRISE")) {
										if (ciscoScreen.clickOnSecurity5GType("WPA2 Enterprise")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA2 AES", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as WPA2 Enterprise");
										}
										if (RadiusServerValaue != null) {
											if (ciscoScreen.setRadiusServer5G(RadiusServerValaue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Server is null.");
										}
										if (RadiusPortValue != null) {
											if (ciscoScreen.setRadiusPort5G(RadiusPortValue)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Radius Port is null.");
										}

										if (SharedKey != null) {
											if (ciscoScreen.setSharedKey5G(SharedKey)) {
												Keyword.ReportStep_Pass(testCase, "Succesfully changed Shared Key.");
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Value of Shared Key is null.");
										}

									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED PERSONAL")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED PERSONAL")) {
										if (ciscoScreen.clickOnSecurity5GType("WPA2/WPA Mixed Personal")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, "WPA_WPA2 MIXED", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wpa wpa2 mixed");
										}

									} else if (security.toUpperCase().contains("WPA/WPA2 MIXED ENTERPRISE")
											|| security.toUpperCase().contains("WPA_WPA2 MIXED ENTERPRISE")) {
										if (ciscoScreen.clickOnSecurity5GType("WPA2/WPA Mixed Enterprise")) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null,
													"WPA_WPA2 MIXED ENTERPRISE", null);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as wpa wpa2 mixed Enterprise");
										}
										if (ciscoScreen.setRadiusServer5G(RadiusServerValaue)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set Radius Server");
										}
										if (ciscoScreen.setRadiusPort5G(RadiusPortValue)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set Radius Server");
										}
										if (SharedKey == null) {
											Keyword.ReportStep_Pass(testCase, "No need to change share key.");
										} else {
											if (ciscoScreen.setSharedKey5G("")) {
												Keyword.ReportStep_Pass(testCase, "Succesfully changed Shared Key.");
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Radius Server");
											}
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Cisco router with this model doesn't support " + security
														+ " Security option");
										return false;
									}
								}
							}

							if (channel == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change channel.");
							} else if (frequency.contains("2.4") && ciscoScreen.select2GChannelNumber(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
							} else if (frequency.contains("5") && ciscoScreen.select5GChannelNumber(channel)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change channel to " + channel);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change channel in Wireless Setting");
								flag = false;
							}
							if (mode == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change Mode.");
							} else if (frequency.contains("2.4") && ciscoScreen.select2GModeType(mode)) {
								Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
							} else if (frequency.contains("5") && ciscoScreen.select5GModeType(mode)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change mode to " + mode);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change Mode in Wireless Setting");
								flag = false;
							}

							if (is_ssid == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
							} else if (frequency.toUpperCase().contains("2.4GHZ")) {
								if (is_ssid.contains("YES") && !ciscoScreen.isBroadCastSSID2GEnabled()) {
									flag = flag && ciscoScreen.clickOnBroadCastSSID2G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
								} else if (is_ssid.contains("NO") && ciscoScreen.isBroadCastSSID2GEnabled()) {
									flag = flag && ciscoScreen.clickOnBroadCastSSID2G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
								} else if (is_ssid.contains("YES") && ciscoScreen.isBroadCastSSID2GEnabled()) {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already enabled for 2.4 GHZ band");
								} else {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already disabled for 2.4 GHZ band");
								}
							} else if (frequency.toUpperCase().contains("5GHZ")) {
								if (is_ssid.contains("YES") && !ciscoScreen.isBroadCastSSID5GEnabled()) {
									flag = flag && ciscoScreen.clickOnBroadCastSSID5G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 5 GHZ band");
								} else if (is_ssid.contains("NO") && ciscoScreen.isBroadCastSSID5GEnabled()) {
									flag = flag && ciscoScreen.clickOnBroadCastSSID5G();
									Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 5 GHZ band");
								} else if (is_ssid.contains("YES") && ciscoScreen.isBroadCastSSID5GEnabled()) {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already enabled for 5 GHZ band");
								} else {
									Keyword.ReportStep_Pass(testCase,
											"broadcast SSID is already disabled for 5 GHZ band");
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Please provide valid frequency band");
								flag = false;
							}
							if (password == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change password.");

							} else if (frequency.contains("2.4") && security.toUpperCase().contains("PERSONAL")
									&& ciscoScreen.setValueinPasswordPersonal24(password)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
							} else if (frequency.contains("5") && security.toUpperCase().contains("PERSONAL")
									&& ciscoScreen.setValueinPasswordPersonal5(password)) {
								flag = true;
								WebController.changeWifiSSID_Password(null, password, null, null);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change password from security settings");
								flag = false;
							}
							if (bandwidth == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change channel.");
							} else if (frequency.contains("2.4") && ciscoScreen.select2Gbandwidth(bandwidth)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
							} else if (frequency.contains("5") && ciscoScreen.select5Gbandwidth(bandwidth)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Change bandwidth to " + bandwidth);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change bandwidth in Wireless Setting");
								flag = false;
							}
							if (ssid_name == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to ssid_name password.");
							} else if (frequency.contains("2.4") && ciscoScreen.setvalueinSSID24(ssid_name)) {
								flag = true;
								WebController.changeWifiSSID_Password(ssid_name, null, null, null);
							} else if (frequency.contains("5") && ciscoScreen.setvalueinSSID5(ssid_name)) {
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
									"Not able to naviagate to Basic setting page in router.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to naviagate to Wireless setting tab in router.");
						flag = false;
					}
				} else if (screenName.contains("DHCP")) {
					if (ciscoScreen.clickOnConnectivity()) {
						if (ciscoScreen.clickOnLocalNetworkTab()) {
							if (is_dhcp == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
							} else if (ciscoScreen.enable_disable_DHCP(is_dhcp)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change DHCP enable disable setting");
								flag = false;
							}
							if (StartIPAddress == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change Start IP Adress.");
							} else {
								if (ciscoScreen.setStartIpAdress(StartIPAddress)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Start IP Adress.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Start IP Adress.");
								}
							}
							if (MaxNoUsers == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change Maximun number of users.");
							} else {
								if (ciscoScreen.setMaxNoUsers(MaxNoUsers)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Maximun number of users.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Maximun number of users.");
								}
							}
							if (ClientLeaseTime == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change Client Lease Time.");
							} else {
								if (ciscoScreen.setClientLeaseTime(ClientLeaseTime)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Client Lease Time.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Client Lease Time.");
								}
							}
							if (DnsIPAddress == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change DNS IP Adress.");
							} else if (ciscoScreen.setDnsIpAdress(DnsIPAddress)) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "Sucessfully changed DNS IP Adress.");
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to change DNS IP Adress.");
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Local Network Tab");
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Connectivity.");
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to naviagate to load page in router.");
				flag = false;
			}
			if (flag) {
				if (applyChangesMade(testCase)) {
					flag = true;
					if (screenName.contains("WIRELESS SETTINGS")) {

						if (ciscoScreen.UpdateNetworkSettings()) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to click on Yes button");
							flag = false;
						}
					}
					if (ciscoScreen.clickOnOkBtn()) {
						Keyword.ReportStep_Pass(testCase, "Settings Applied");
						checkPageLoadingComplete(testCase);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click on Ok button");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to click on apply button");
					flag = false;
				}
			}
			return flag;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;

	}

	public static boolean applyChangesMade(TestCases testCase) {
		CiscoRouterScreen ciscoScreen = new CiscoRouterScreen(testCase);
		boolean flag = true;
		if (ciscoScreen.clickOnApplyChangesBTN()) {
			Keyword.ReportStep_Pass(testCase, "Successfully Applied the changes");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "unable to apply changes");
		}
		return flag;
	}

	public static String getRouterSettings_WRT120N(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("10") && parameterArray[i].contains("20MHZ")) {
						requestValue = "10 - 2.457GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 11")  ) {
						requestValue = "11 - 2.462GHz";
					} else if (parameterArray[i].contains("40MHZ") &&parameterArray[i].contains("CHANNEL TO 3") ) {
						requestValue = "3";
					} else if (parameterArray[i].contains("40MHZ") &&parameterArray[i].contains("CHANNEL TO 4") ) {
						requestValue = "4";
					} else if (parameterArray[i].contains("40MHZ") &&parameterArray[i].contains("CHANNEL TO 5") ) {
						requestValue = "5";
					} else if (parameterArray[i].contains("40MHZ") &&parameterArray[i].contains("CHANNEL TO 6") ) {
						requestValue = "6";
					} else if (parameterArray[i].contains("40MHZ") &&parameterArray[i].contains("CHANNEL TO 7") ) {
						requestValue = "7";
					} else if (parameterArray[i].contains("40MHZ") && parameterArray[i].contains("CHANNEL TO 8")) {
						requestValue = "8";
					} else if (parameterArray[i].contains("40MHZ") && parameterArray[i].contains("CHANNEL TO 9") ) {
						requestValue = "9";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 1")) {
						requestValue = "1 - 2.412GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 2") ) {
						requestValue = "2 - 2.417GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 3")) {
						requestValue = "3 - 2.422GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 4") ) {
						requestValue = "4 - 2.427GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 5") ) {
						requestValue = "5 - 2.432GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 6") ) {
						requestValue = "6 - 2.437GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 7") ) {
						requestValue = "7 - 2.442GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 8")) {
						requestValue = "8 - 2.447GHz";
					} else if (parameterArray[i].contains("20MHZ") && parameterArray[i].contains("CHANNEL TO 9") ) {
						requestValue = "9 - 2.452GHz";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {

					if (parameterArray[i].contains("MIXED")) {
						requestValue = "Mixed";
					} else if (parameterArray[i].contains("BG MIXED")) {
						requestValue = "BG-Mixed";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "Wireless-G Only";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "Wireless-B Only";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "Wireless-N Only";
					} else if (parameterArray[i].contains("DISABLE")) {
						requestValue = " Disabled";
					}

					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto (20MHz or 40MHz)";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20MHz only";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40MHz only";
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
					if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP ";
					} else if (parameterArray[i].contains("WPA2 Personal".toUpperCase())) {
						requestValue = "WPA2 Personal";
					} else if (parameterArray[i].contains("WPA2 Enterprise".toUpperCase())) {
						requestValue = "WPA2 Enterprise";
					} else if (parameterArray[i].contains("WPA Personal".toUpperCase())) {
						requestValue = "WPA Personal";
					} else if (parameterArray[i].contains("WPA Enterprise".toUpperCase())) {
						requestValue = "WPA Enterprise";
					} else if (parameterArray[i].contains("RADIUS")) {
						requestValue = "RADIUS";
					} else if (parameterArray[i].contains("DISABLE")) {
						requestValue = "Disabled";
					}
					break;

				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("AES_TKIP")) {
						requestValue = "TKIP or AES";
					} else if (parameterArray[i].contains("AES")) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("64")) {
						requestValue = "40 / 64-bit (10 hex digits)";
					} else if (parameterArray[i].contains("128")) {
						requestValue = "104 / 128-bit (26 hex digits)";
					}
					break;

				} else if (parameterArray[i].contains("RADIUS SERVER") && requestParameter.contains("RADIUS SERVER")) {
					requestValue = parameterArray_Value[i].replace("Radius Server is ", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is ", "").trim();
					break;
				} else if (parameterArray[i].contains("SHARED KEY") && requestParameter.contains("SHARED KEY")) {
					requestValue = parameterArray_Value[i].replace("Shared Key is ", "").trim();
					break;
				} else if (parameterArray[i].contains("START IP ADDRESS")
						&& requestParameter.contains("START IP ADDRESS")) {
					requestValue = parameterArray_Value[i].replace("Start IP Address is ", "").trim();
					break;
				} else if (parameterArray[i].contains("MAX NO USERS") && requestParameter.contains("MAX NO USER")) {
					requestValue = parameterArray_Value[i].replace("Max No Users is ", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCP LEASE TIME")
						&& requestParameter.contains("DHCP LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("DHCP Lease Time is ", "").trim();
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
				} else if (parameterArray[i].contains("DNS IP1") && requestParameter.contains("DNS IP1")) {
					requestValue = parameterArray_Value[i].replace("DNS IP1 is", "").trim();
					break;
				} else if (parameterArray[i].contains("KEY RENEW") && requestParameter.contains("KEY RENEW")) {
					requestValue = parameterArray_Value[i].replace("Key Renewal is", "").trim();
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;
	}

	public static String getRouterSettings(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("36")) {
						requestValue = "36 - 5.180 GHz";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 - 5.200 GHz";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44 - 5.220 GHz";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48 - 5.240 GHz";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10 - 2.457 GHz";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11 - 2.462 GHz";
					} else if (parameterArray[i].contains("12")) {
						requestValue = "12 - 2.467 GHz";
					} else if (parameterArray[i].contains("13")) {
						requestValue = "13 - 2.472 GHz";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "1 - 2.412 GHz";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "2 - 2.417 GHz";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "3 - 2.422 GHz";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "4 - 2.427 GHz";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "5 - 2.432 GHz";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "6 - 2.437 GHz";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "7 - 2.442 GHz";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "8 - 2.447 GHz";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "9 - 2.452 GHz";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("MODE") && requestParameter.contains("MODE")) {

					if (parameterArray[i].contains("MIXED")) {
						requestValue = "Mixed";
					} else if (parameterArray[i].contains("G ONLY")) {
						requestValue = "802.11g Only";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "802.11n Only";
					} else if (parameterArray[i].contains("AC ONLY")) {
						requestValue = "802.11ac Only";
					}

					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {

					if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "20 MHz Only";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 MHz";
					} else if (parameterArray[i].contains("80")) {
						requestValue = "80 MHz";
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
					if (parameterArray[i].contains("NONE".toUpperCase())) {
						requestValue = "None";
					} else if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA2 Personal".toUpperCase())) {
						requestValue = "WPA2 Personal";
					} else if (parameterArray[i].contains("WPA2 Enterprise".toUpperCase())) {
						requestValue = "WPA2 Enterprise";
					} else if (parameterArray[i].contains("WPA2/WPA Mixed Personal".toUpperCase())) {
						requestValue = "WPA2/WPA Mixed Personal";
					} else if (parameterArray[i].contains("WPA2/WPA Mixed Enterprise".toUpperCase())) {
						requestValue = "WPA2/WPA Mixed Enterprise";
					}
					break;

				} else if (parameterArray[i].contains("WEPENCRYPTION") && requestParameter.contains("WEPENCRYPTION")) {
					if (parameterArray[i].contains("WEP-64") || parameterArray[i].contains("64")) {
						requestValue = "40 / 64-bit (10 hex digits)";
					} else if (parameterArray[i].contains("WEP-128") || parameterArray[i].contains("128")) {
						requestValue = "104 / 128-bit (26 hex digits)";
					}
					break;

				} else if (parameterArray[i].contains("RADIUS SERVER") && requestParameter.contains("RADIUS SERVER")) {
					requestValue = parameterArray_Value[i].replace("Radius Server is ", "").trim();
					break;
				} else if (parameterArray[i].contains("RADIUS PORT") && requestParameter.contains("RADIUS PORT")) {
					requestValue = parameterArray_Value[i].replace("Radius Port is ", "").trim();
					break;
				} else if (parameterArray[i].contains("SHARED KEY") && requestParameter.contains("SHARED KEY")) {
					requestValue = parameterArray_Value[i].replace("Shared Key is ", "").trim();
					break;
				} else if (parameterArray[i].contains("START IP ADDRESS")
						&& requestParameter.contains("START IP ADDRESS")) {
					requestValue = parameterArray_Value[i].replace("Start IP Address is ", "").trim();
					break;
				} else if (parameterArray[i].contains("MAX NO USERS") && requestParameter.contains("MAX NO USER")) {
					requestValue = parameterArray_Value[i].replace("Max No Users is ", "").trim();
					break;
				} else if (parameterArray[i].contains("CLIENT LEASE TIME")
						&& requestParameter.contains("CLIENT LEASE TIME")) {
					requestValue = parameterArray_Value[i].replace("Client Lease Time is ", "").trim();
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
				} else if (parameterArray[i].contains("DNS IP1") && requestParameter.contains("DNS IP1")) {
					requestValue = parameterArray_Value[i].replace("DNS IP1 is", "").trim();
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

	public static boolean checkPageLoadingComplete(TestCases testCase) {
		Boolean flag = true;
		CiscoRouterScreen ciscoScreen = new CiscoRouterScreen(testCase);
		try {
			FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testCase.getWebDriver());
			fwait.pollingEvery(Duration.ofSeconds(1));
			fwait.withTimeout(Duration.ofSeconds(60));
			fwait.ignoring(Exception.class);
			Boolean success = fwait.until(new Function<WebDriver, Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					if (ciscoScreen.isPageLoading()) {
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

	public static boolean _WRT120N_Model_chaneRouterSettings(TestCases testCase, String baseURL, String screenName,
			String frequency, String is_ssid, String ssid_name, String security, String password, String bandwidth,
			String channel, String Mode, String is_dhcp, String DNSip1, String DNSip2, String LeaseTime,
			String MAxNoUser, String StartIpAdd, String encryption, String KeyRenew, String radiusServer,
			String radiusPort) {
		CiscoRouterScreen ciscoScreen_WRT120N = new CiscoRouterScreen(testCase);
		boolean flag = false;
		try {
			String baseurl = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "WEB_URL");
			if (screenName.contains("DHCP")) {
				if (changeWebPage(testCase, "http://" + baseurl, "/index.stm?title=Setup-Basic%20Setup",
						"HOME SETTINGS")) {
					if (is_dhcp == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
					} else if (ciscoScreen_WRT120N.enable_disable_DHCP_WRT120N(is_dhcp)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP setting is changed to " + is_dhcp);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP enable disable setting");
						flag = false;
					}
					if (LeaseTime == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change LeaseTime in DHCP setting.");
					} else if (ciscoScreen_WRT120N.setLeaseTime_WRT120N(LeaseTime)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP  LeaseTime is changed to " + LeaseTime);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP LeaseTime setting");
						flag = false;
					}
					if (MAxNoUser == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change MAxNoUser in DHCP setting.");
					} else if (ciscoScreen_WRT120N.setMAxNoUser_WRT120N(MAxNoUser)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP  MAxNoUser is changed to " + MAxNoUser);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP MAxNoUser setting");
						flag = false;
					}
					if (StartIpAdd == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change StartIpAdd in DHCP setting.");
					} else if (ciscoScreen_WRT120N.setStartIpAdd_WRT120N(StartIpAdd)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP  StartIpAdd is changed to " + StartIpAdd);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP StartIpAdd setting");
						flag = false;
					}
					if (DNSip1 == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change DNSip1 in DHCP setting.");
					} else if (ciscoScreen_WRT120N.setDNSip1_WRT120N(DNSip1)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "DHCP  DNSip1 is changed to " + DNSip1);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change DHCP DNSip1 setting");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to navigate to DHCP Screen");
					flag = false;
				}
			} else if (screenName.contains("BASIC WIRELESS")) {
				if (changeWebPage(testCase, "http://" + baseurl,
						"/index.stm?title=Wireless-Basic%20Wireless%20Settings", "BASIC WIRELESS")) {
					if (!ciscoScreen_WRT120N.clickOnManual_WIFIProtected("MANUAL")) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Manual Radio Button in Basic Wireless Settings Screen");
						flag = false;
					}
					if (Mode == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change Mode in Basic Wireless setting.");
					} else if (ciscoScreen_WRT120N.setMode_WRT120N(Mode)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Mode is changed to " + Mode);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Mode setting");
						flag = false;
					}
					if (is_ssid == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"No need to change SSID BroadCast settings in Basic Wireless setting.");
					} else if (ciscoScreen_WRT120N.SSIDBroadCast_WRT120N(is_ssid)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed is_ssid to " + is_ssid);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change is_ssid setting");
						flag = false;
					}
					if (ssid_name == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change ssid_name in Basic Wireless setting.");
					} else if (ciscoScreen_WRT120N.setSSIDName_WRT120N(ssid_name)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed ssid_name to " + ssid_name);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change ssid_name in setting");
						flag = false;
					}
					if (bandwidth == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change bandwidth in Basic Wireless setting.");
					} else if (ciscoScreen_WRT120N.selectBandwidth_WRT120N(bandwidth)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed bandwidth to " + bandwidth);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change bandwidth in setting");
						flag = false;
					}
					if (channel == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "No need to change channel in Basic Wireless setting.");
					} else if (bandwidth.contains("20") && ciscoScreen_WRT120N.selectStandardChannel_WRT120N(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed channel to " + channel);
					} else if (bandwidth.contains("40") && ciscoScreen_WRT120N.selectWideChannel_WRT120N(channel)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed channel to " + channel);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change bandwidth in setting");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to navigate to Basic Setting Screen");
				}
			} else if (screenName.contains("SECURITY")) {
				if (changeWebPage(testCase, "http://" + baseurl, "/index.stm?title=Wireless-Wireless%20Security",
						"SECURITY")) {
					if (security == null) {
						flag = true;
						Keyword.ReportStep_Pass(testCase,
								"No need to change security Type in Wireless Security setting.");
					} else if (security.contains("WEP") && ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						if (!ciscoScreen_WRT120N.acceptAlert()) {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to Accept the Alert");
						}
						if (encryption == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change encryption in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.selectEncryption_WRT120N(encryption)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed encryption to " + encryption);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change encryption in setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change password in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setPasswordWEP_WRT120N(password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed password to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password in setting");
							flag = false;
						}
						if (ciscoScreen_WRT120N.clickOnGenerate()) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Successfuly clicked on Generate button");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Generate Button");
							flag = false;
						}
					} else if (security.toUpperCase().contains("WPA PERSONAL")
							&& ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						if (!ciscoScreen_WRT120N.acceptAlert()) {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to Accept the Alert");
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change password in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setPassword_WRT120N(password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed password to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password in setting");
							flag = false;
						}
						if (KeyRenew == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change KeyRenew in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setKeyRenew_WRT120N(KeyRenew)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed KeyRenew to " + KeyRenew);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change KeyRenew in setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("WPA2 PERSONAL")
							&& ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						if (encryption == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change encryption in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.selectEncryptionWPA2_WRT120N(encryption)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed encryption to " + encryption);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change encryption in setting");
							flag = false;
						}
						if (password == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change password in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setPassword_WRT120N(password)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed password to " + password);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change password in setting");
							flag = false;
						}
						if (KeyRenew == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change KeyRenew in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setKeyRenew_WRT120N(KeyRenew)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed KeyRenew to " + KeyRenew);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change KeyRenew in setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("WPA ENTERPRISE")
							&& ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						if (!ciscoScreen_WRT120N.acceptAlert()) {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to Accept the Alert");
						}
						if (radiusServer == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change radiusServer in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setRadiusServer_WRT120N(radiusServer)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed radiusServer to " + radiusServer);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change radiusServer in setting");
							flag = false;
						}
						if (radiusPort == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change radiusPort in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setRadiusPort_WRT120N(radiusPort)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed radiusPort to " + radiusPort);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change radiusPort in setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("WPA2 ENTERPRISE")
							&& ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						if (encryption == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change encryption in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.selectEncryptionWPA2_WRT120N(encryption)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed encryption to " + encryption);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change encryption in setting");
							flag = false;
						}
						if (radiusServer == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change radiusServer in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setRadiusServer_WRT120N(radiusServer)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed radiusServer to " + radiusServer);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change radiusServer in setting");
							flag = false;
						}
						if (radiusPort == null) {
							flag = true;
							Keyword.ReportStep_Pass(testCase,
									"No need to change radiusPort in Wireless Security setting.");
						} else if (ciscoScreen_WRT120N.setRadiusPort_WRT120N(radiusPort)) {
							flag = true;
							Keyword.ReportStep_Pass(testCase, "Changed radiusPort to " + radiusPort);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to change radiusPort in setting");
							flag = false;
						}
					} else if (security.toUpperCase().contains("DIS")
							&& ciscoScreen_WRT120N.selectSecurity_WRT120N(security)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfuly changed Security Type to" + security);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid Security Type");
						flag = false;
					}
				}
			}
			if (flag) {
				if (ciscoScreen_WRT120N.clickOnSaveSettings()) {
					flag = true;
					ciscoScreen_WRT120N.iselementPresent(25);
					Keyword.ReportStep_Pass(testCase, "Successfuly clicked on save settings.");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on save settings.");
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

	public static String PageSource(String screenName) {
		String pagecontainer = null;
		switch (screenName) {
		case "HOME PAGE":
			pagecontainer = "Wireless-N Home Router".toUpperCase();
			break;
		case "BASIC WIRELESS":
			pagecontainer = "Configuration View:".toUpperCase();
			break;
		case "SECURITY":
			pagecontainer = "Security Mode:".toUpperCase();
			break;
		default:
			pagecontainer = "";
			break;
		}

		return pagecontainer;
	}

}