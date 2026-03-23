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
import com.resideo.utils.web.screens.BuffaloRouterScreen;

public class BuffaloRouterUtils {

	public static String getRouterSettings(String data, String requestParameter) {
		String requestValue = null;
		if (data.toUpperCase().contains(requestParameter)) {
			String[] parameterArray = data.toUpperCase().split(";");
			String[] parameterArray_Value = data.split(";");
			for (int i = 0; i < parameterArray.length; i++) {
				if (parameterArray[i].contains("CHANNEL") && requestParameter.contains("CHANNEL")) {
					if (parameterArray[i].contains("36")) {
						requestValue = "36 - 5180 MHz";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "40 - 5200 MHz";
					} else if (parameterArray[i].contains("44")) {
						requestValue = "44 - 5220 MHz";
					} else if (parameterArray[i].contains("48")) {
						requestValue = "48 - 5240 MHz";
					} else if (parameterArray[i].contains("149")) {
						requestValue = "149 - 5745 MHz";
					} else if (parameterArray[i].contains("153")) {
						requestValue = "153 - 5765 MHz";
					} else if (parameterArray[i].contains("157")) {
						requestValue = "157 - 5785 MHz";
					} else if (parameterArray[i].contains("161")) {
						requestValue = "161 - 5805 MHz";
					} else if (parameterArray[i].contains("165")) {
						requestValue = "165 - 5825 MHz";
					} else if (parameterArray[i].contains("10")) {
						requestValue = "10 - 2457 MHz";
					} else if (parameterArray[i].contains("11")) {
						requestValue = "11 - 2462 MHz";
					} else if (parameterArray[i].contains("1")) {
						requestValue = "1 - 2412 MHz";
					} else if (parameterArray[i].contains("2")) {
						requestValue = "2 - 2417 MHz";
					} else if (parameterArray[i].contains("3")) {
						requestValue = "3 - 2422 MHz";
					} else if (parameterArray[i].contains("4")) {
						requestValue = "4 - 2427 MHz";
					} else if (parameterArray[i].contains("5")) {
						requestValue = "5 - 2432 MHz";
					} else if (parameterArray[i].contains("6")) {
						requestValue = "6 - 2437 MHz";
					} else if (parameterArray[i].contains("7")) {
						requestValue = "7 - 2442 MHz";
					} else if (parameterArray[i].contains("8")) {
						requestValue = "8 - 2447 MHz";
					} else if (parameterArray[i].contains("9")) {
						requestValue = "9 - 2452 MHz";
					} else {
						requestValue = "Auto";
					}
					break;
				} else if (parameterArray[i].contains("WIRELESSMODE") && requestParameter.contains("WIRELESSMODE")) {

					if (parameterArray[i].contains("AUTO")) {
						requestValue = "Auto";
					} else if (parameterArray[i].contains("AP")) {
						requestValue = "AP";
					} else if (parameterArray[i].contains("CLIENT BRIDGE")) {
						requestValue = "Client Bridge (Routed)";
					} else if (parameterArray[i].contains("CLIENT")) {
						requestValue = "Client";
					} else if (parameterArray[i].contains("ADHOC")) {
						requestValue = "Adhoc";
					} else if (parameterArray[i].contains("WDS STATION")) {
						requestValue = "WDS Station";
					} else if (parameterArray[i].contains("WDS AP")) {
						requestValue = "WDS AP";
					}
					break;
				} else if (parameterArray[i].contains("NETWORKMODE") && requestParameter.contains("NETWORKMODE")) {

					if (parameterArray[i].contains("DISABLED")) {
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("MIXED")) {
						requestValue = "Mixed";
					} else if (parameterArray[i].contains("B ONLY")) {
						requestValue = "B-Only";
					} else if (parameterArray[i].contains("G OBLY")) {
						requestValue = "G-Only";
					} else if (parameterArray[i].contains("BG MIXED")) {
						requestValue = "BG-Mixed";
					} else if (parameterArray[i].contains("NG MIXED")) {
						requestValue = "NG-Mixed";
					} else if (parameterArray[i].contains("N ONLY")) {
						requestValue = "N-Only (2.4 GHz)";
					}

					break;
				} else if (parameterArray[i].contains("BANDWIDTH") && requestParameter.contains("BANDWIDTH")) {
					if (parameterArray[i].contains("20_40")) {
						requestValue = "Dynamic (20/40 MHz)";
					} else if (parameterArray[i].contains("20")) {
						requestValue = "Full (20 MHz)";
					} else if (parameterArray[i].contains("40")) {
						requestValue = "Turbo (40 MHz)";
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
						requestValue = "Disabled";
					} else if (parameterArray[i].contains("WEP".toUpperCase())) {
						requestValue = "WEP";
					} else if (parameterArray[i].contains("WPA-PSK".toUpperCase())) {
						requestValue = "WPA-PSK";
					} else if (parameterArray[i].contains("WPA-EAP".toUpperCase())) {
						requestValue = "WPA-EAP";
					} else if (parameterArray[i].contains("WPA2-PSK".toUpperCase())) {
						requestValue = "WPA2-PSK";
					} else if (parameterArray[i].contains("WPA2-EAP".toUpperCase())) {
						requestValue = "WPA2-EAP";
					} else if (parameterArray[i].contains("WPA2_PSK_WPA_PSK".toUpperCase())) {
						requestValue = "WPA2-PSK/WPA-PSK";
					} else if (parameterArray[i].contains("WPA2_EAP_WPA_EAP".toUpperCase())) {
						requestValue = "WPA2-EAP/WPA-EAP";
					}
					break;

				} else if (parameterArray[i].contains("WPA ALGO") && requestParameter.contains("WPA ALGO")) {
					if (parameterArray[i].contains("TKIP".toUpperCase())) {
						requestValue = "TKIP";
					} else if (parameterArray[i].contains("AES".toUpperCase())) {
						requestValue = "AES";
					} else if (parameterArray[i].contains("TKIP+AES")
							|| (parameterArray[i].contains("TKIP") && (parameterArray[i].contains("AES")))) {
						requestValue = "TKIP+AES";
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
				} else if (parameterArray[i].contains("KEY RENEWAL INTERVAL")
						&& requestParameter.contains("KEY RENEWAL INTERVAL")) {
					requestValue = parameterArray_Value[i].replace("Key Renewal Interval is", "").trim();
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
				} else if (parameterArray[i].contains("DNS IP1") && requestParameter.contains("DNS IP1")) {
					requestValue = parameterArray_Value[i].replace("DNS IP1 is ", "").trim();
					break;
				} else if (parameterArray[i].contains("DHCPLEASE") && requestParameter.contains("DHCPLEASE")) {
					requestValue = parameterArray_Value[i].replace("DHCPLease time is", "").trim();
					break;
				} else if (parameterArray[i].contains("AUTHENTICATION")
						&& requestParameter.contains("AUTHENTICATION")) {
					requestValue = parameterArray_Value[i].replace("Authentication is", "").trim();
					break;
				} else if (parameterArray[i].contains("ENCRYPTION") && requestParameter.contains("ENCRYPTION")) {
					if (parameterArray[i].contains("64")) {
						requestValue = "64 bits 10 hex digits";
					} else {
						requestValue = "128 bits 26 hex digits";
					}
					break;
				} else if (parameterArray[i].contains("PASSPHRASE") && requestParameter.contains("PASSPHRASE")) {
					requestValue = parameterArray_Value[i].replace("Passphrase is", "").trim();
					break;
				}
			}
		} else {
			return null;
		}
		return requestValue;

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
						if (pageSource.toUpperCase().contains("SETUP")
								&& pageSource.toUpperCase().contains("WIRELESS")) {
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

	public static boolean _AC1750_Model_chaneRouterSettings(TestCases testCase, String screename, String frequency,
			String channel, String NetworkMode, String security, String password, String ssid_name, String is_ssid,
			String is_dhcp, String WpaAlgo, String BandWidth, String KeyRenInterval, String WirelessMode,
			String StartIPAddress, String MaxNoUsers, String ClientLeaseTime, String staticDNS1, String Auth,
			String Encryption, String Passphrase) {
		boolean flag = true;
		BuffaloRouterScreen buffaloScreen = new BuffaloRouterScreen(testCase);
		try {
			if (checkPageLoadingComplete(testCase)) {
				if (screename.contains("WIRELESS")) {
					buffaloScreen.iselementPresent(12);
					if (buffaloScreen.clickOnWirelessTab()) {
						buffaloScreen.iselementPresent(3);
						if (screename.contains("WIRELESS BASIC SETTINGS")) {
							buffaloScreen.iselementPresent(3);
							if (buffaloScreen.clickOnBasicSettingsTab()) {
								if (frequency.contains("2.4")) {
									if (WirelessMode == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change security.");
									} else {
										if (buffaloScreen.selectWirelessMode2G(WirelessMode)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set WirelessMode as " + WirelessMode);
										}
									}
									if (NetworkMode == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change NetworkMode.");
									} else {
										buffaloScreen.iselementPresent(3);
										if (buffaloScreen.selectNetworkMode2G(NetworkMode)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set NetworkMode as " + NetworkMode);
										}
									}
									if (BandWidth == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change BandWidth.");
									} else {
										if (buffaloScreen.selectBandWidth2G(BandWidth)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set BandWidth as " + BandWidth);
										}
									}
									if (channel == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change channel.");
									} else {
										if (buffaloScreen.selectChannel2G(channel)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set channel as " + channel);
										}
									}
								} else {
									if (WirelessMode == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change security.");
									} else {
										if (buffaloScreen.selectWirelessMode5G(WirelessMode)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set WirelessMode as " + WirelessMode);
										}
									}
									if (NetworkMode == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change NetworkMode.");
									} else {
										if (buffaloScreen.selectNetworkMode5G(NetworkMode)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set NetworkMode as " + NetworkMode);
										}
									}
									if (BandWidth == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change BandWidth.");
									} else {
										if (buffaloScreen.selectBandWidth5G(BandWidth)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set BandWidth as " + BandWidth);
										}
									}
									if (channel == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change channel.");
									} else {
										if (buffaloScreen.selectChannel5G(channel)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set channel as " + channel);
										}
									}
								}

								if (is_ssid == null) {
									flag = true;
									Keyword.ReportStep_Pass(testCase, "No need to change broadcase essid.");
								} else if (frequency.toUpperCase().contains("2.4GHZ")) {
									if (is_ssid.contains("YES") && !buffaloScreen.isBroadCastSSID2GEnabled()) {
										flag = flag && buffaloScreen.clickOnBroadCastSSID2G();
										Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 2.4 GHZ band");
									} else if (is_ssid.contains("NO") && buffaloScreen.isBroadCastSSID2GEnabled()) {
										flag = flag && buffaloScreen.clickOnBroadCastSSID2GDisable();
										Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 2.4 GHZ band");
									} else if (is_ssid.contains("YES") && buffaloScreen.isBroadCastSSID2GEnabled()) {
										Keyword.ReportStep_Pass(testCase,
												"broadcast SSID is already enabled for 2.4 GHZ band");
									} else {
										Keyword.ReportStep_Pass(testCase,
												"broadcast SSID is already disabled for 2.4 GHZ band");
									}
								} else if (frequency.toUpperCase().contains("5GHZ")) {
									if (is_ssid.contains("YES") && !buffaloScreen.isBroadCastSSID5GEnabled()) {
										flag = flag && buffaloScreen.clickOnBroadCastSSID5G();
										Keyword.ReportStep_Pass(testCase, "broadcast SSID enabled for 5 GHZ band");
									} else if (is_ssid.contains("NO") && buffaloScreen.isBroadCastSSID5GEnabled()) {
										flag = flag && buffaloScreen.clickOnBroadCastSSID5GDisable();
										Keyword.ReportStep_Pass(testCase, "broadcast SSID disabled for 5 GHZ band");
									} else if (is_ssid.contains("YES") && buffaloScreen.isBroadCastSSID5GEnabled()) {
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
								if (ssid_name == null) {
									flag = true;
									Keyword.ReportStep_Pass(testCase, "No need to ssid_name password.");
								} else if (frequency.contains("2.4") && buffaloScreen.setvalueinSSID24(ssid_name)) {
									flag = true;
									WebController.changeWifiSSID_Password(ssid_name, null, null, null);
								} else if (frequency.contains("5") && buffaloScreen.setvalueinSSID5(ssid_name)) {
									flag = true;
									WebController.changeWifiSSID_Password(ssid_name, null, null, null);
									Keyword.ReportStep_Pass(testCase, "Change ssid_name to " + ssid_name);
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change ssid_name from security settings");
									flag = false;
								}
							}

						} else if (screename.contains("WIRELESS SECURITY SETTINGS")) {
							buffaloScreen.iselementPresent(3);
							if (buffaloScreen.clickOnWirelessSecurityTab()) {
								if (frequency.toUpperCase().contains("2.4")) {

									if (security == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change security.");
									} else if (security.toUpperCase().contains("WEP")) {
										buffaloScreen.iselementPresent(3);
										if (buffaloScreen.selectSecurity2GType(security)) {
											WebController.changeWifiSSID_Password(null, null, security.toUpperCase(),
													null);
											if (Auth == null) {
												flag = true;
												Keyword.ReportStep_Pass(testCase, "No need to change Authontication.");
												
											} else {
												if (Auth.toUpperCase().contains("SHARED")) {
													flag = buffaloScreen.setAuthToShared2G();
													WebController.changeWifiSSID_Password(null, null, null, "SHARED");
												} else {
													flag = buffaloScreen.setAuthToOpen2G();
													WebController.changeWifiSSID_Password(null, null, null, "PSK");
												}
											}
										}
										
										if (Encryption == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change Encryption.");
										} else {
											buffaloScreen.iselementPresent(3);
											if (buffaloScreen.selectEncryption2GType(Encryption)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Encryption as " + Encryption);
											}
										}
										if (Passphrase == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change Passphrase.");
										} else {
											if (buffaloScreen.setPassphrase2G(Passphrase)) {
												if (buffaloScreen.clickonGenerate2G()) {
													flag = true;
													WebController.changeWifiSSID_Password(null, buffaloScreen.getPasswordWEP(), null, null);
												} else {
													flag = false;
													Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
															"Not able to click on Generate");
												}
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Passphrase as " + Passphrase);
											}
										}

									} else {
										buffaloScreen.iselementPresent(3);
										if (buffaloScreen.selectSecurity2GType(security)) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "Security Type Set to:" + security);
											if (security.toUpperCase().contains("DISABLED")) {
												WebController.changeWifiSSID_Password(null, null, "NONE", null);
											} else {
												WebController.changeWifiSSID_Password(null, null,
														security.toUpperCase(), null);
											}

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as " + security);
										}
									}
									if (WpaAlgo == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change WpaAlgo.");
									} else {
										buffaloScreen.iselementPresent(3);
										if (buffaloScreen.selectWpaAlgo2GType(WpaAlgo)) {
											Keyword.ReportStep_Pass(testCase, "Encryption Type Set to:" + WpaAlgo);
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as " + security);
										}
									}
									if (password == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change password.");
									} else {
										buffaloScreen.iselementPresent(3);
										if (buffaloScreen.setSharedKey2G(password)) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "password Set to:" + password);
											WebController.changeWifiSSID_Password(null, null, null, password);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set password as " + password);
										}
									}
									if (KeyRenInterval == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change KeyRenInterval.");
									} else {
										if (buffaloScreen.setKeyRenInterval2G(KeyRenInterval)) {
											Keyword.ReportStep_Pass(testCase,
													"KeyRenInterval Set to:" + KeyRenInterval);
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set KeyRenInterval as " + KeyRenInterval);
										}
									}
								} else {
									if (security == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change security.");
									} else if (security.toUpperCase().contains("WEP")) {
										if (buffaloScreen.selectSecurity5GType(security)) {
											WebController.changeWifiSSID_Password(null, null, security.toUpperCase(),
													null);
											if (Auth == null) {
												flag = true;
												Keyword.ReportStep_Pass(testCase, "No need to change Authontication.");
												if (buffaloScreen.isAuthIsSharedKEy5G()) {
													WebController.changeWifiSSID_Password(null, null, null, "SHARED");
												} else {
													WebController.changeWifiSSID_Password(null, null, null, "PSK");
												}
											} else {
												if (Auth.toUpperCase().contains("SHARED")) {
													flag = buffaloScreen.setAuthToShared5G();
													WebController.changeWifiSSID_Password(null, null, null, "SHARED");
												} else {
													flag = buffaloScreen.setAuthToOpen5G();
													WebController.changeWifiSSID_Password(null, null, null, "PSK");
												}
												flag = buffaloScreen.clickOnKey1();
											}
										}
										if (Encryption == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change Encryption.");
										} else {
											if (buffaloScreen.selectEncryption5GType(Encryption)) {
												flag = true;
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Encryption as " + Encryption);
											}
										}
										if (Passphrase == null) {
											flag = true;
											Keyword.ReportStep_Pass(testCase, "No need to change Passphrase.");
										} else {
											if (buffaloScreen.setPassphrase5G(Passphrase)) {
												if (buffaloScreen.clickonGenerate5G()) {
													flag = true;
													WebController.changeWifiSSID_Password(null, buffaloScreen.getPasswordWEP(), null, null);
												} else {
													flag = false;
													Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
															"Not able to click on Generate");
												}
											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"not able to set Passphrase as " + Passphrase);
											}
										}

									} else {
										if (buffaloScreen.selectSecurity5GType(security)) {
											flag = true;
											if (security.toUpperCase().contains("DISABLED")) {
												WebController.changeWifiSSID_Password(null, null, "NONE", null);
											} else {
												WebController.changeWifiSSID_Password(null, null,
														security.toUpperCase(), null);
											}

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as " + security);
										}
									}

									if (WpaAlgo == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change WpaAlgo.");
									} else {
										if (buffaloScreen.selectWpaAlgo2GType(WpaAlgo)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set security as " + security);
										}
									}
									if (password == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change password.");
									} else {
										if (buffaloScreen.setSharedKey2G(password)) {
											flag = true;
											WebController.changeWifiSSID_Password(null, null, null, password);
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set password as " + password);
										}
									}
									if (KeyRenInterval == null) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "No need to change KeyRenInterval.");
									} else {
										if (buffaloScreen.setKeyRenInterval5G(KeyRenInterval)) {
											flag = true;
										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"not able to set KeyRenInterval as " + KeyRenInterval);
										}
									}

								}
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to click on wireless security");
							}

						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to naviagate to Wireless Security tab in router.");
						flag = false;
					}
				} else if (screename.contains("DHCP")) {
					if (buffaloScreen.clickOnBasicSetupTab()) {
						if (buffaloScreen.scrollToDhcp()) {
							if (is_dhcp == null) {
								flag = true;
								Keyword.ReportStep_Pass(testCase, "No need to change DHCP setting.");
							} else if (buffaloScreen.enable_disable_DHCP(is_dhcp)) {
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
								if (buffaloScreen.setStartIpAdress(StartIPAddress)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Start IP Adress.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Start IP Adress.");
								}
							}
							if (MaxNoUsers == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change Maximun number of users.");
							} else {
								if (buffaloScreen.setMaxNoUsers(MaxNoUsers)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Maximun number of users.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Maximun number of users.");
								}
							}
							if (ClientLeaseTime == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change Client Lease Time.");
							} else {
								if (buffaloScreen.setClientLeaseTime(ClientLeaseTime)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed Client Lease Time.");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change Client Lease Time.");
								}
							}
							if (staticDNS1 == null) {
								Keyword.ReportStep_Pass(testCase, "No need to change staticDNS1");
							} else {
								if (buffaloScreen.setstaticDNS1(staticDNS1)) {
									Keyword.ReportStep_Pass(testCase, "Sucessfully changed staticDNS1");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to change staticDNS1");
								}
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to scroll to DHCP.");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to naviagate to Basic Setup.");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Give screen name is not valid.");
					flag = false;
				}
				if (flag) {
					if (buffaloScreen.clickOnApplyChangesBTN()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Settings Applied");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"not able to click on apply button");
						flag = false;
					}
				}
				return flag;
			}
		} catch (

		Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean checkPageLoadingComplete(TestCases testCase) {
		Boolean flag = true;
		BuffaloRouterScreen buffaloScreen = new BuffaloRouterScreen(testCase);
		WebDriver driver = testCase.getWebDriver();
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

	public static WifiSecurityMode _AC1750_Model_chaneRouterSecuritySettings(String securityType_request) {
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
		if (security_Type.contains("NONE") || security_Type.contains("DISABLED")) {
			securityType = WifiSecurityMode.NONE;
		} else if (security_Type.contains("WPA2")) {
			if (security_Type.contains("TKIP+AES")) {
				securityType = WifiSecurityMode.WPA2_MIXED_PSK;
			} else if (security_Type.contains("TKIP")) {
				securityType = WifiSecurityMode.WPA2_TKIP_PSK;
			} else if (security_Type.contains("AES")) {
				securityType = WifiSecurityMode.WPA2_AES_PSK;
			}
		} else if (security_Type.contains("WPA")) {
			if (security_Type.contains("TKIP+AES")) {
				securityType = WifiSecurityMode.WPA_MIXED_PSK;
			} else if (security_Type.contains("TKIP")) {
				securityType = WifiSecurityMode.WPA_TKIP_PSK;
			} else if (security_Type.contains("AES")) {
				securityType = WifiSecurityMode.WPA_AES_PSK;
			}
		}

		else if (security_Type.contains("WEP")) {
			if (security_Type.contains("SHARED")) {
				securityType = WifiSecurityMode.WEP_Shared;
			} else {
				securityType = WifiSecurityMode.WEP_PSK;
			}
		} else {
			securityType = WifiSecurityMode.WPA2_MIXED_PSK;
		}

		return securityType;
	}

	public static boolean changeRouterSettingsInBuffalo(TestCases testCase, String screenName, String dataOptions) {
		boolean flag = false;
		try {
			String routerModel = SuiteConstants
					.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_MODEL").toUpperCase();

			switch (routerModel) {
			case "WZR-600DHP":
				if (!WebController.isloggedIn()) {
					if (changeWebPage(testCase, "192.168.11.1", "", null)) {
						WebController.isloggedIn(true);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to change Home setting page");
						flag = false;
						WebController.isloggedIn(false);
					}
				}

				flag = _AC1750_Model_chaneRouterSettings(testCase, screenName,
						getRouterSettings(dataOptions, "FREQUENCY"), getRouterSettings(dataOptions, "CHANNEL"),
						getRouterSettings(dataOptions, "NETWORKMODE"), getRouterSettings(dataOptions, "SECURITY"),
						getRouterSettings(dataOptions, "PASSWORD"), getRouterSettings(dataOptions, "SSID NAME"),
						getRouterSettings(dataOptions, "IS SSID"), getRouterSettings(dataOptions, "IS DHCP"),
						getRouterSettings(dataOptions, "WPA ALGO"), getRouterSettings(dataOptions, "BANDWIDTH"),
						getRouterSettings(dataOptions, "KEY RENEWAL INTERVAL"),
						getRouterSettings(dataOptions, "WIRELESSMODE"),
						getRouterSettings(dataOptions, "START IP ADDRESS"),
						getRouterSettings(dataOptions, "MAX NO USERS"), getRouterSettings(dataOptions, "DHCPLEASE"),
						getRouterSettings(dataOptions, "DNS IP1"), getRouterSettings(dataOptions, "AUTHENTICATION"),
						getRouterSettings(dataOptions, "ENCRYPTION"), getRouterSettings(dataOptions, "PASSPHRASE"));

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

		}
		return flag;
	}

}