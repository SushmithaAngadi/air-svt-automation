package com.resideo.utils.stat.jasper_common;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg.Jasper_Buttons;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperEmeaDisplaySegmentMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperNaDisplaySegmentMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.JasperNaDisplaySegmentMsg.DisplaySegment;

public class Jasper_Houdini_BroadCast_Utils {

	public static boolean setBroadCastMode_EMEA_From_TempScreen(TestCases testCase, String typeOfMode) {
		boolean flag = false;
		flag = NavigateScreen_T5_T6_NA_EMEA.navigateTOHomeScreen_Jasper_EMEA(testCase);

		if (flag && StatCommands.getInstance().cattCommandsStub
				.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg.newBuilder()
						.setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU).build())
				.getBoolVal()) {
			flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D).setDurationInMillisecond(5000).build())
					.getBoolVal();
			if (getMulti_textIn_EMEA_Display(testCase, "TSTAT", "LYRIC", "Sucessfully Text Visible in Display")) {
				Keyword.ReportStep_Pass(testCase, "Thermostat started WAC Mode");
				flag = true;
			} else {
				flag = false;
			}
			if (flag) {
				if (typeOfMode.equalsIgnoreCase("WAC MODE")) {
					flag = true;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Failed to enable WAC Mode");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Thermostat not in Home Screen");
			flag = false;
		}

		if (flag) {
			if (typeOfMode.equalsIgnoreCase("AP MODE")) {

				if (StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
						.addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(5000).build()).getBoolVal()) {
					if (getMulti_textIn_EMEA_Display(testCase, "TSTAT", null, "Sucessfully Text Visible in Display")) {
						Keyword.ReportStep_Pass(testCase, "Thermostat started AP Mode");
						flag = true;
					} else {
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Failed to enable AP Mode");
					flag = false;
				}
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Failed to enable Wac Mode, due to AP Mode Failed");
			flag = false;
		}
		return flag;
	}

	public static boolean getMulti_textIn_EMEA_Display(TestCases testCase, String expectedText1, String expectedText2,
			String message) {
		boolean flag = false;
		try {

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(flag);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(2));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String text = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal();
						if (text != null) {
							if (text.toUpperCase().contains(expectedText1)) {
								Keyword.ReportStep_Pass(testCase, message + " : " + text);
								return true;
							}
							if (expectedText2 != null && text.toUpperCase().contains(expectedText2)) {
								Keyword.ReportStep_Pass(testCase, message + " : " + text);
								return true;
							} else {
//								Keyword.ReportStep_Pass(testCase,
//										"Stat is enabled to broadcast. But Stat device name while broadcasting is not as expected. Displayed text : "
//												+ text);
								System.out.println("Display Text is not same");
								return false;
							}
						} else {
//							Keyword.ReportStep_Pass(testCase,
//									"Failed to get stat device name once device is enabled for broadcast. Retrying...");
							System.out.println("From AAT Is null");
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
								"Failed to enable device broadcast with timeout : 2min");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase,
								"Failed to get stat device name once device is enabled for broadcast. Retrying...");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
								"Exception Raised in getMulti_textIn_EMEA_Display(TestCases testCase, String expectedText1, String expectedText2,String message) due to : "
										+ e.getMessage());
						return false;
					}
				}
			});

			flag = isEventReceived;

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised in getMulti_textIn_EMEA_Display(TestCases testCase, String expectedText1, String expectedText2,String message) due to : "
							+ e.getMessage());
		}
		return flag;
	}

	public static boolean setBroadcastInAnyscreen_EMEA(TestCases testCase, String type_mode) {
		boolean flag = false;
		if (NavigateScreen_T5_T6_NA_EMEA.jasperEmea_Navigate_StartSetup_inAny_screen_Home(testCase)) {

			if (setBroadCastMode_EMEA_From_TempScreen(testCase, type_mode)) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, 0, "Failed to Broadcast");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, 0, "Failed to navigate from Any screen");
			flag = false;
		}

		return flag;
	}

	public static boolean JasperEmeaStartSetup(TestCases testCase, String deviceUnderTest) {
		boolean flag = false;

		StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build());
		Keyword.ReportStep_Pass(testCase, "Initiated Start Setup");

		String statDispText = StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
						.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
				.getStrVal().trim();

		if (statDispText.contains("LANGUAGE")) {
			StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
			Keyword.ReportStep_Pass(testCase, "Language selection screen");

			statDispText = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal().trim();

			if (statDispText.contains("ENGLISH")) {
				StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
						.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
				Keyword.ReportStep_Pass(testCase, "English language selected");

				statDispText = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
						.getStrVal().trim();

				if (statDispText.contains("CLOCK")) {
					StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
							.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
					Keyword.ReportStep_Pass(testCase, "Clock selection screen");

					statDispText = StatCommands.getInstance().cattCommandsStub
							.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
									.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
							.getStrVal().trim();

					if (statDispText.contains("HOURS")) {
						StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
								.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
						Keyword.ReportStep_Pass(testCase, "24 Hours clock format selected");

						statDispText = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal().trim();

						if (statDispText.contains("HOURS")) {
							StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
									.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
							Keyword.ReportStep_Pass(testCase, "Default hours value selected");

							statDispText = StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
											.setTextArea(DisplayArea.Multitext)
											.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
									.getStrVal().trim();

							if (statDispText.contains("MINUTES")) {
								StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
										.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
								Keyword.ReportStep_Pass(testCase, "Default minutes value selected");

								statDispText = StatCommands.getInstance().cattCommandsStub
										.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
												.setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
										.getStrVal().trim();

								if (statDispText.contains("YEAR")) {
									StatCommands.getInstance().cattCommandsStub
											.setButtonsClick(ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
													.setDurationInMillisecond(100).build());
									Keyword.ReportStep_Pass(testCase, "Default year value selected");

									statDispText = StatCommands.getInstance().cattCommandsStub.jasperGetDisplayText(
											JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
													.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars)
													.build())
											.getStrVal().trim();

									if (statDispText.contains("MONTH")) {
										StatCommands.getInstance().cattCommandsStub.setButtonsClick(
												ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
														.setDurationInMillisecond(100).build());
										Keyword.ReportStep_Pass(testCase, "Default month value selected");

										statDispText = StatCommands.getInstance().cattCommandsStub.jasperGetDisplayText(
												JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
														.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars)
														.build())
												.getStrVal().trim();

										if (statDispText.contains("DAY")) {

											StatCommands.getInstance().cattCommandsStub.setButtonsClick(
													ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
															.setDurationInMillisecond(100).build());

											Keyword.ReportStep_Pass(testCase, "Default day value selected");

											if (deviceUnderTest.contains("EMEA_WIRELESS")) {
												statDispText = StatCommands.getInstance().cattCommandsStub
														.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
																.setTextArea(DisplayArea.Multitext)
																.setTextMethod(
																		DisplayMethod.AlphabeticalUpperAndSpecialChars)
																.build())
														.getStrVal().trim();

												if (statDispText.contains("BINDING")) {
													flag = false;
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Jasper EMEA Wireless stat is not bound. Cannot proceed with Start Setup");
													return false;
												}
											}

											StatCommands.getInstance().cattCommandsStub.setButtonsClick(
													ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_H)
															.setDurationInMillisecond(100).build());

											Keyword.ReportStep_Pass(testCase, "Installer Configuration is cancelled");

											if (StatCommands.getInstance().cattCommandsStub
													.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
															.newBuilder()
															.setSegment(
																	com.resideo.utils.stat.cattgrpccommands.JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU)
															.build())
													.getBoolVal()) {

												Keyword.ReportStep_Pass(testCase, "Navigated to Home Screen");

												StatCommands.getInstance().cattCommandsStub.setButtonsClick(
														ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D)
																.setDurationInMillisecond(5000).build());

												Keyword.ReportStep_Pass(testCase,
														"Long press on Indoor Temperature is done");
												flag = true;
											} else {
												Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
														FailType.FUNCTIONAL_FAILURE,
														"Failed to navigate to Home screen");
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
													FailType.FUNCTIONAL_FAILURE,
													"Stat is not in preferred screen : Expected 'DAY'. Observed : "
															+ statDispText);
											flag = false;
										}

									} else {
										Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
												FailType.FUNCTIONAL_FAILURE,
												"Stat is not in preferred screen : Expected 'MONTH'. Observed : "
														+ statDispText);
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Stat is not in preferred screen : Expected 'YEAR'. Observed : "
													+ statDispText);
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Stat is not in preferred screen : Expected 'MINUTES'. Observed : "
												+ statDispText);
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Stat is not in preferred screen : Expected 'HOURS'. Observed : " + statDispText);
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Stat is not in preferred screen : Expected default clock format '24 HOURS'. Observed : "
										+ statDispText);
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Stat is not in preferred screen : Expected setting 'CLOCK'. Observed : " + statDispText);
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Stat is not in preferred screen : Expected default langauge 'ENGLISH'. Observed : "
								+ statDispText);
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Stat is not in preferred screen : Expected setting 'LANGAUGE'");
			flag = false;
		}

		return flag;
	}

	public static boolean JasperNAStartSetup(TestCases testCase) {
		boolean flag = false;
		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D).setDurationInMillisecond(100).build())
				.getBoolVal();

		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(100).build())
				.getBoolVal();

		if (StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplaySegmentState(
						JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_YES).build())
				.getBoolVal()) {
			Keyword.ReportStep_Pass(testCase, "Initiated Start Setup");
			flag = flag && StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build())
					.getBoolVal();
		}

		return flag;
	}

//	public static boolean defaultISU_setup(TestCases testCase) {
//		boolean flag = false;
//		int i = 0;
//	}

	public static boolean _BroadCastJasper_fromStartSetup(TestCases testCase, String deviceUnderTest,
			String broadcastType) {
		boolean flag = false;
		if (deviceUnderTest.contains("JASPER_SENIOR_NA_TRADE")) {
			flag = JasperNA_Trade_StartSetup_broadCast(testCase);
		} else if (deviceUnderTest.contains("JASPER_SENIOR_NA_RETAIL")) {
			flag = JasperNA_Retail_StartSetup(testCase, broadcastType);
		} else if (deviceUnderTest.contains("JASPER_SENIOR_EMEA")) {
			if (NavigateScreen_T5_T6_NA_EMEA.JasperEmeaStartSetup(testCase, deviceUnderTest, false, false)) {
				Keyword.ReportStep_Pass(testCase, deviceUnderTest + " Enabled Broadcast, continue to do DIY");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, 0,
						"not able to set to broadcast, failed pls check the automation logs and GRPC logs for more details");
				flag = false;
			}
//			if (NavigateScreen_T5_T6_NA_EMEA.jasperEmea_Navigate_StartSetup_inAny_screen_Home(testCase)) {
//				Keyword.ReportStep_Pass(testCase, "EMEA Navigate to home screen is sucessfull");
//				flag = setBroadCastMode_EMEA_From_TempScreen(testCase, broadcastType);
//			} else {
//				Keyword.ReportStep_Fail(testCase, 0, "Set to home screen from Emea failed");
//				flag = false;
//			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Not the expected device under test : " + deviceUnderTest);
		}
		return flag;
	}

	public static boolean _BroadCastJasper_fromHomeScreen(TestCases testCase, String deviceUnderTest,
			String broadcastType) {
		boolean flag = false;
		if (deviceUnderTest.contains("JASPER_SENIOR_NA")) {
			String statDispText = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal().trim();
			boolean isHomeScreen = StatCommands.getInstance().cattCommandsStub
					.isJasperHomeScreen(String_Msg.newBuilder().build()).getStrVal().contains("true");

			if (statDispText != null && !isHomeScreen && statDispText.contains("START SETUP")) {
				flag = NavigateScreen_T5_T6_NA_EMEA.JasperNADefault_ISU_Setup(testCase, deviceUnderTest);
			}
			flag = StatCommonCommandUtils.setHomeScreenjasper(testCase, 10);

			if (flag) {
				flag = jasper_NA_broadCast(testCase, broadcastType);
			}

		} else if (deviceUnderTest.contains("JASPER_SENIOR_EMEA")) {
			if (NavigateScreen_T5_T6_NA_EMEA.jasperEmea_Navigate_StartSetup_inAny_screen_Home(testCase)) {
				Keyword.ReportStep_Pass(testCase, "EMEA Navigate to home screen is sucessfull");
				flag = setBroadCastMode_EMEA_From_TempScreen(testCase, broadcastType);
			} else {
				Keyword.ReportStep_Fail(testCase, 0, "Set to home screen from Emea failed");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Not the expected device under test : " + deviceUnderTest);
		}
		return flag;
	}

	@Deprecated
	public static boolean jasper_NA_broadCast_old(TestCases testCase, String setAP_Wac) {
		boolean flag = false;
		try {
			if (setAP_Wac.toUpperCase().contains("AP MODE")) {
				String setBroadcastMode = StatCommonCommandUtils.setBroadcastMode(testCase, 1, 10000,
						Jasper_Buttons.BUTTON_D, 30);
				if (setBroadcastMode.toUpperCase().contains("TSTAT")
						|| setBroadcastMode.toUpperCase().contains("LYRIC")) {
					setBroadcastMode = StatCommonCommandUtils.setBroadcastMode(testCase, 0, 10000,
							Jasper_Buttons.BUTTON_B, 50);
					if (setBroadcastMode.toUpperCase().contains("TSTAT")
							|| setBroadcastMode.toUpperCase().contains("LYRIC")) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Changed to AP Mode Sucessfully");
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Check the Thermostat Whether can able to Broadcasr , Text displays in stat is : "
										+ StatCommonCommandUtils.getThermostatText());
					}

				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Check the Thermostat Whether can able to Broadcast , Text displays in stat is : "
									+ StatCommonCommandUtils.getThermostatText());
				}
			} else if (setAP_Wac.toUpperCase().contains("WAC MODE") || setAP_Wac.toUpperCase().contains("BLE MODE")) {

				if (!StatCommands.getInstance().cattCommandsStub.isJasperHomeScreen(String_Msg.newBuilder().build())
						.getStrVal().contains("true")) {
					if (StatCommonCommandUtils.setHomeScreenjasper(testCase, 10)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Navigate to Home Screen");
					} else {
						flag = false;
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to navigate to Home Screen");
					}
				}
				String broadcastMode = StatCommonCommandUtils.setBroadcastMode(testCase, 1, 6000,
						Jasper_Buttons.BUTTON_D, 50);
				if (broadcastMode.contains("LYRIC") || broadcastMode.contains("TSTAT")) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Changed to " + setAP_Wac + " Sucessfully");
				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Check the Thermostat Whether can able to Broadcast , Text displays in stat is : "
									+ StatCommonCommandUtils.getThermostatText());
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"User Expected is not available");

			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
		}

		return flag;
	}

	public static boolean jasper_NA_broadCast(TestCases testCase, String setAP_Wac) {
		boolean flag = false;

		String setBroadcastMode = StatCommonCommandUtils.setBroadcastMode(testCase, 1, 10000, Jasper_Buttons.BUTTON_D,
				30);
		if (setBroadcastMode.toUpperCase().contains("TSTAT") || setBroadcastMode.toUpperCase().contains("LYRIC")) {
			if (setAP_Wac.toUpperCase().contains("WAC") || setAP_Wac.toUpperCase().contains("BLE")) {
				Keyword.ReportStep_Pass(testCase, "Changed to " + setAP_Wac + " Sucessfully");
				flag = true;
			} else if (setAP_Wac.toUpperCase().contains("AP")) {

				setBroadcastMode = StatCommonCommandUtils.setBroadcastMode(testCase, 0, 10000, Jasper_Buttons.BUTTON_B,
						50);
				if (setBroadcastMode.toUpperCase().contains("TSTAT")
						|| setBroadcastMode.toUpperCase().contains("LYRIC")) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Changed to " + setAP_Wac + " Sucessfully");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Check the Thermostat Whether can able to Broadcasr , Text displays in stat is : "
									+ StatCommonCommandUtils.getThermostatText());
				}
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Check the Thermostat Whether can able to Broadcast , Text displays in stat is : "
							+ StatCommonCommandUtils.getThermostatText());
		}

		return flag;
	}

	public static boolean ConfirmJapserDeviceBroadcasting(TestCases testCase) {
		boolean flag = false;
		KeepAppActive appActive = new KeepAppActive(testCase);
		appActive.start();
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(3));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String text = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal();
						if (text != null) {
							if (text.toUpperCase().contains("LYRIC") || text.toUpperCase().contains("OPEN")
									|| text.toUpperCase().contains("HONEYWELL")
									|| text.toUpperCase().contains("TSTAT")) {
								Keyword.ReportStep_Pass(testCase, "Device started to broadcast as : " + text);
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Waiting for device to broadcast... : " + text);
								return false;
							}
						} else {
							Keyword.ReportStep_Pass(testCase, "Waiting for device to broadcast...");
							return false;
						}

					} catch (Exception e) {
						return false;
					}
				}
			});

			flag = isEventReceived;

		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Pass(testCase, "Failed to enable device broadcast with timeout : 3min");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised : " + e.getMessage());
		}

		appActive.requestStop();

		if (appActive.isAlive())
			appActive.requestStop();

		return flag;
	}

	public static boolean ConfirmJapserDeviceBroadcasting_Retail(TestCases testCase) {
		boolean flag = false;
		KeepAppActive appActive = new KeepAppActive(testCase);
		appActive.start();
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(3));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String text = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal();

						if (text != null) {

							if (text.toUpperCase().contains("LYRIC")) {
								String macID = StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build())
										.getStrVal();
								String substring = macID.substring(6, 12);
								SystemState.getStatus().setTstatName("Tstat" + " " + substring);
								Keyword.ReportStep_Pass(testCase, "Device started to broadcast as : " + text);
								return true;
							} else if (text.toUpperCase().contains("TSTAT")) {
								String macID = StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build())
										.getStrVal();
								String substring = macID.substring(6, 12);
								SystemState.getStatus().setTstatName("Tstat" + " " + substring);
								Keyword.ReportStep_Pass(testCase, "Device started to broadcast as : " + text);
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Waiting for device to broadcast... : " + text);
								return false;
							}
						} else {
							Keyword.ReportStep_Pass(testCase, "Waiting for device to broadcast...");
							return false;
						}

					} catch (Exception e) {
						return false;
					}
				}
			});

			flag = isEventReceived;

		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Pass(testCase, "Failed to enable device broadcast with timeout : 3min");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised : " + e.getMessage());
		}

		appActive.requestStop();

		if (appActive.isAlive())
			appActive.requestStop();

		return flag;
	}

	public static boolean JasperNA_Trade_StartSetup_broadCast(TestCases testCase) {
		boolean flag = false;
		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D).setDurationInMillisecond(100).build())
				.getBoolVal();
		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(100).build())
				.getBoolVal();

		if (StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplaySegmentState(
						JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_YES).build())
				.getBoolVal()) {
			Keyword.ReportStep_Pass(testCase, "Initiated Start Setup");
			flag = flag && StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build())
					.getBoolVal();

		}

		return flag;
	}

//	public static boolean houdini_startSetup(TestCases testCase) {
//		boolean flag = false;
//		if (StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
//				.addHdButton(Houdini_Buttons.BUTTON_BOTTOM_MIDDLE).setDurationInMillisecond(100).build())
//				.getBoolVal()) {
//			String strr = StatCommands.getInstance().cattCommandsStub.getHoudiniDisplayText(HoudiniDisplayTextMsg
//					.newBuilder().setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build()).getStrVal().trim();
//			if (strr.contains("USE APP TO CON") || strr.contains("THERMOSTAT") || strr.contains("US APP TO CON")
//					|| strr.contains("CONFIGURE") || strr.contains("APP")) {
//				if (StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
//						.addHdButton(Houdini_Buttons.BUTTON_BOTTOM_MIDDLE).setDurationInMillisecond(100).build())
//						.getBoolVal()) {
//					strr = StatCommands.getInstance().cattCommandsStub
//							.getHoudiniDisplayText(HoudiniDisplayTextMsg.newBuilder()
//									.setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build())
//							.getStrVal().trim();
//					if (strr.contains("USE APP")) {
//						Keyword.ReportStep_Pass(testCase, "Device In Broadcast Mode");
//						flag = true;
//					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
//								"Not able to see 'USE APP' Text in Thermostat Screen");
//						flag = false;
//					}
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
//							"Not able to press bottom center button, check in CATT Command action");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
//						"Not able to see scroll text 'Use APP to configure Thermostat'");
//				flag = false;
//			}
//		} else {
//			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
//					"Not able to press bottom center button, check in CATT Command action");
//			flag = false;
//		}
//		return flag;
//	}

	public static boolean JasperNA_Retail_StartSetup(TestCases testCase, String setAP_Wac) {
		boolean flag = false;
		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D).setDurationInMillisecond(100).build())
				.getBoolVal();
		flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(
				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(100).build())
				.getBoolVal();

		if (StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplaySegmentState(
						JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_YES).build())
				.getBoolVal()) {
			Keyword.ReportStep_Pass(testCase, "Initiated Start Setup");
			flag = flag && StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build())
					.getBoolVal();
			if (flag && StatCommonCommandUtils.getMulti_textIn_Jasper(testCase, "TSTAT", "LYRIC",
					"Sucessfully Text Visible in Display")) {
				if (setAP_Wac.toUpperCase().contains("AP")) {
					if (StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
							.addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(5000).build())
							.getBoolVal()) {
						if (StatCommonCommandUtils.getMulti_textIn_Jasper(testCase, "TSTAT", null,
								"Sucessfully Text Visible in Display")) {
							Keyword.ReportStep_Pass(testCase, "Thermostat started AP Mode");
							flag = true;
						} else {
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Failed to enable AP Mode");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Pass(testCase, "Changed to " + setAP_Wac + " Sucessfully");
					flag = true;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
						"Not able to find TSTAT/ LYRIC text in Thermostat Display");
				flag = false;
			}
		}

		return flag;
	}

}
