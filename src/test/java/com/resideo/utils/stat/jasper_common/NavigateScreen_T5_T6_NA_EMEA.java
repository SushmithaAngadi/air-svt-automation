package com.resideo.utils.stat.jasper_common;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg.Jasper_Buttons;
import com.resideo.utils.stat.cattgrpccommands.EMEAAlertMsg;
import com.resideo.utils.stat.cattgrpccommands.EMEAAlertMsg.AlertState;
import com.resideo.utils.stat.cattgrpccommands.EMEAAlertMsg.AlertType;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.JasperNaDisplaySegmentMsg.DisplaySegment;
import com.resideo.utils.stat.cattgrpccommands.JasperEmeaDisplaySegmentMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperNaDisplaySegmentMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

public class NavigateScreen_T5_T6_NA_EMEA {

	public static boolean navigateTOHomeScreen_Jasper_EMEA(TestCases testCase) {
		boolean flag = false;
		if (StatCommands.getInstance().cattCommandsStub.setEMEAAlert(EMEAAlertMsg.newBuilder()
				.setAlert(AlertType.ALERT_THERMOSTAT_UNKNOWN_TIME).setState(AlertState.ALERTS_STATE_INACTIVE).build())
				.getBoolVal()) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "failed to cancel Alert from EMEA");
			flag = false;
		}

		if (!StatCommands.getInstance().cattCommandsStub.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
				.newBuilder().setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU).build()).getBoolVal()) {
			flag = StatCommands.getInstance().cattCommandsStub
					.setButtonsClick(
							ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_D).setDurationInMillisecond(100).build())
					.getBoolVal();
		}
		int i = 5;
		while (!StatCommands.getInstance().cattCommandsStub.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
				.newBuilder().setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU).build()).getBoolVal()) {
			if (StatCommands.getInstance().cattCommandsStub.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
					.newBuilder().setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_BACK).build())
					.getBoolVal()) {
				StatCommands.getInstance().cattCommandsStub.setButtonsClick(
						ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_F).setDurationInMillisecond(100).build());
			} else if (StatCommands.getInstance().cattCommandsStub
					.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg.newBuilder()
							.setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_CANCEL).build())
					.getBoolVal()) {
				StatCommands.getInstance().cattCommandsStub.setButtonsClick(
						ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_H).setDurationInMillisecond(100).build());
			} else if (StatCommands.getInstance().cattCommandsStub
					.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg.newBuilder()
							.setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_CONFIRM).build())
					.getBoolVal()) {
				StatCommands.getInstance().cattCommandsStub.setButtonsClick(
						ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
			}
			if (StatCommands.getInstance().cattCommandsStub.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
					.newBuilder().setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU).build())
					.getBoolVal()) {
				flag = true;
				break;
			}

			if (i <= 0)
				break;

			i--;
		}
		flag = StatCommands.getInstance().cattCommandsStub
				.setEMEAAlert(EMEAAlertMsg.newBuilder().setAlert(AlertType.ALERT_THERMOSTAT_UNKNOWN_TIME)
						.setState(
								com.resideo.utils.stat.cattgrpccommands.EMEAAlertMsg.AlertState.ALERTS_STATE_INACTIVE)
						.build())
				.getBoolVal();

		if (StatCommands.getInstance().cattCommandsStub.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
				.newBuilder().setSegment(JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU).build()).getBoolVal()) {
			flag = true;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, "Navigate to Home screen Failed");
		}
		return flag;
	}

	public static boolean JasperEmeaStartSetup(TestCases testCase, String deviceUnderTest,boolean isSkipStartUpBroadCast,
			boolean isCancel_setupInBroadCast) {
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
				StatCommands.getInstance().cattCommandsStub.setButtonsClick(
						ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
				Keyword.ReportStep_Pass(testCase, "English language selected");

				statDispText = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
						.getStrVal().trim();

				if (statDispText.contains("CLOCK")) {
					StatCommands.getInstance().cattCommandsStub.setButtonsClick(
							ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
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
									StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
											.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
									Keyword.ReportStep_Pass(testCase, "Default year value selected");

									statDispText = StatCommands.getInstance().cattCommandsStub.jasperGetDisplayText(
											JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
													.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars)
													.build())
											.getStrVal().trim();

									if (statDispText.contains("MONTH")) {
										StatCommands.getInstance().cattCommandsStub
												.setButtonsClick(ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
														.setDurationInMillisecond(100).build());
										Keyword.ReportStep_Pass(testCase, "Default month value selected");

										statDispText = StatCommands.getInstance().cattCommandsStub.jasperGetDisplayText(
												JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
														.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars)
														.build())
												.getStrVal().trim();

										if (statDispText.contains("DAY")) {
											StatCommands.getInstance().cattCommandsStub
													.setButtonsClick(ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
															.setDurationInMillisecond(100).build());
											Keyword.ReportStep_Pass(testCase, "Default day value selected");

											statDispText = StatCommands.getInstance().cattCommandsStub
													.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
															.setTextArea(DisplayArea.Multitext)
															.setTextMethod(
																	DisplayMethod.AlphabeticalUpperAndSpecialChars)
															.build())
													.getStrVal().trim();
											if (statDispText.contains("SYSTEM TYPE")) {

												StatCommands.getInstance().cattCommandsStub.setButtonsClick(
														ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
																.setDurationInMillisecond(100).build());
												Keyword.ReportStep_Pass(testCase, "Default System type selected");

												statDispText = StatCommands.getInstance().cattCommandsStub
														.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
																.setTextArea(DisplayArea.Multitext)
																.setTextMethod(
																		DisplayMethod.AlphabeticalUpperAndSpecialChars)
																.build())
														.getStrVal().trim();

												if (statDispText.contains("HEAT ONLY")||statDispText.contains("HEAT + H/W")) {

													StatCommands.getInstance().cattCommandsStub.setButtonsClick(
															ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
																	.setDurationInMillisecond(100).build());
													Keyword.ReportStep_Pass(testCase, "Default system type selected");

													if (Jasper_Houdini_BroadCast_Utils.getMulti_textIn_EMEA_Display(testCase,
															"INSTALLER", "SETUP",
															"Thermostat shows Installer setup Wifi with Honeywell Home")) {
														
														if(isSkipStartUpBroadCast) {
															StatCommands.getInstance().cattCommandsStub.setButtonsClick(
																	ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_H)
																			.setDurationInMillisecond(100).build());
															Keyword.ReportStep_Pass(testCase,
																	"Default system type selected");
															flag = true;
														}else {
															StatCommands.getInstance().cattCommandsStub.setButtonsClick(
																	ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
																			.setDurationInMillisecond(100).build());
															Keyword.ReportStep_Pass(testCase,
																	"Default system type selected");

															statDispText = StatCommands.getInstance().cattCommandsStub
																	.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
																			.setTextArea(DisplayArea.Multitext)
																			.setTextMethod(
																					DisplayMethod.AlphabeticalUpperAndSpecialChars)
																			.build())
																	.getStrVal().trim();
															if (deviceUnderTest.contains("EMEA_WIRELESS")) {
																statDispText = StatCommands.getInstance().cattCommandsStub
																		.jasperGetDisplayText(JasperDisplayTextMsg
																				.newBuilder()
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
																}
															}

															if (Jasper_Houdini_BroadCast_Utils.getMulti_textIn_EMEA_Display(testCase,
																	"TSTAT", "LYRIC", "Thermostat in Broadcast Mode")) {
																Keyword.ReportStep_Pass(testCase,
																		"Thermostat started AP Mode");
																flag = true;
															} else {
																Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
																		"Failed to enable AP Mode, In thermostat displays "
																				+ statDispText);
																flag = false;
															}
														}
														
													
													} else {
														Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
																FailType.FUNCTIONAL_FAILURE,
																"Failed to Navigate to Installer setup Wifi configuration screen, In thermostat displays "
																		+ statDispText);
														flag = false;
													}
												} else {
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Failed to Navigate to System sub system, In thermostat displays "
																	+ statDispText);
													flag = false;
												}
											}else if (Jasper_Houdini_BroadCast_Utils.getMulti_textIn_EMEA_Display(testCase,
													"HONEYWELL", "INSTALLER",
													"Thermostat shows Installer setup Wifi with Honeywell Home")||Jasper_Houdini_BroadCast_Utils.getMulti_textIn_EMEA_Display(testCase,
															"HOME", "INSTALL",
															"Thermostat shows Installer setup Wifi with Honeywell Home")) {
												
												if(isSkipStartUpBroadCast) {
													StatCommands.getInstance().cattCommandsStub.setButtonsClick(
															ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_H)
																	.setDurationInMillisecond(100).build());
													Keyword.ReportStep_Pass(testCase,
															"Default system type selected");
													flag = true;
												}else {
													StatCommands.getInstance().cattCommandsStub.setButtonsClick(
															ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
																	.setDurationInMillisecond(100).build());
													Keyword.ReportStep_Pass(testCase,
															"Default system type selected");

													statDispText = StatCommands.getInstance().cattCommandsStub
															.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
																	.setTextArea(DisplayArea.Multitext)
																	.setTextMethod(
																			DisplayMethod.AlphabeticalUpperAndSpecialChars)
																	.build())
															.getStrVal().trim();
													if (deviceUnderTest.contains("EMEA_WIRELESS")) {
														statDispText = StatCommands.getInstance().cattCommandsStub
																.jasperGetDisplayText(JasperDisplayTextMsg
																		.newBuilder()
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
														}
													}

													if (Jasper_Houdini_BroadCast_Utils.getMulti_textIn_EMEA_Display(testCase,
															"TSTAT", "LYRIC", "Thermostat in Broadcast Mode")) {
														Keyword.ReportStep_Pass(testCase,
																"Thermostat started AP Mode");
														flag = true;
													} else {
														Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
																"Failed to enable AP Mode, In thermostat displays "
																		+ statDispText);
														flag = false;
													}
												}
											}
											else {
												Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
														FailType.FUNCTIONAL_FAILURE,
														"Failed navigate to System type screen, In thermostat displays "
																+ statDispText);
												flag = false;
											}

											if (isCancel_setupInBroadCast &&!isSkipStartUpBroadCast) {

												StatCommands.getInstance().cattCommandsStub.setButtonsClick(
														ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_H)
																.setDurationInMillisecond(100).build());
												Keyword.ReportStep_Pass(testCase,
														"Installer Configuration is cancelled");

												if (StatCommands.getInstance().cattCommandsStub
														.jasperEmeaGetDisplaySegmentState(JasperEmeaDisplaySegmentMsg
																.newBuilder()
																.setSegment(
																		com.resideo.utils.stat.cattgrpccommands.JasperEmeaDisplaySegmentMsg.DisplaySegment.SEG_MENU)
																.build())
														.getBoolVal()) {
													Keyword.ReportStep_Pass(testCase, "Navigated to menu sucessfully");
													flag = true;
//												Keyword.ReportStep_Pass(testCase, "Navigated to Home Screen");
//												StatCommands.getInstance().cattCommandsStub.setButtonsClick(
//														ButtonMsg.newBuilder().addButton(Button.BUTTON_D)
//																.setDurationInMillisecond(5000).build());
//												Keyword.ReportStep_Pass(testCase,
//														"Long press on Indoor Temperature is done");
//												flag = true;
												} else {
													Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase,
															FailType.FUNCTIONAL_FAILURE,
															"Failed to navigate to Home screen");
													flag = false;
												}
											} else {
												Keyword.ReportStep_Pass(testCase,
														"BraodCast mode enabled as per user requirement");
												flag = true;
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

	public static boolean jasperEmea_Navigate_StartSetup_inAny_screen_Home(TestCases testCase) {
		boolean flag = false;
//		StatCommands.getInstance().cattCommandsStub.setButtonsClick(
//				ButtonMsg.newBuilder().addButton(Button.BUTTON_E).setDurationInMillisecond(100).build());
		String statDispText = StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
						.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
				.getStrVal().trim();
		if (statDispText != null && statDispText.contains("SETUP")) {
			flag = JasperEmeaStartSetup(testCase, statDispText, true,false);
		} else {
			flag = navigateTOHomeScreen_Jasper_EMEA(testCase);
		}
		return flag;
	}

	public static boolean JasperNADefault_ISU_Setup(TestCases testCase, String deviceName) {
		boolean flag = false;
//		boolean condition=true;
//		StatCommands.getInstance().cattCommandsStub.setButtonsClick(
//				ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());

		String statDispText = StatCommands.getInstance().cattCommandsStub
				.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
						.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
				.getStrVal().trim();

		if (statDispText.contains("START SETUP")) {

			StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_B).setDurationInMillisecond(100).build());

			statDispText = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal().trim();

			if (StatCommonCommandUtils.getMulti_textIn_Jasper(testCase, "USE APP", "CONFIGURE",
					"Thermostat shows :: Use app to configure thermostat")) {

				StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
						.addJsButton(Jasper_Buttons.BUTTON_C).setDurationInMillisecond(100).build());

				statDispText = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
						.getStrVal().trim();
				while (!statDispText.contains("FINISH SETUP")) {

					if (StatCommands.getInstance().cattCommandsStub.jasperGetDisplaySegmentState(
							JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_ARROW_RIGHT).build())
							.getBoolVal()) {
						StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
								.addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build());
						statDispText = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal().trim();
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Right Arrow segment is not visible");
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Text Display on the thermostat is " + statDispText);
						flag = false;
					}
				}

				if (statDispText.contains("FINISH SETUP")) {
					/*
					 * Jasper Retail shows Wifi Setup screen , so handle in wifi setup as NO.
					 */
					if (deviceName.contains("JASPER_SENIOR_NA_RETAIL")) {
						StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
								.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
						if (StatCommonCommandUtils.getMulti_textIn_Jasper(testCase, "SETUP WIFI", null,
								"Thermostat shows :: Setup WIfi")) {

							flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
									.addJsButton(Jasper_Buttons.BUTTON_C).setDurationInMillisecond(100).build())
									.getBoolVal();
							statDispText = StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
											.setTextArea(DisplayArea.Multitext)
											.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
									.getStrVal().trim();

						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Setup Wifi Text not display");
							flag = false;
						}

					} else {
						try {
							StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
									.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build());
							Thread.sleep(6000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
					while (StatCommands.getInstance().cattCommandsStub.jasperGetDisplaySegmentState(
							JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_SELECT).build())
							.getBoolVal()) {
						flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
								.addJsButton(Jasper_Buttons.BUTTON_G).setDurationInMillisecond(100).build())
								.getBoolVal();
						statDispText = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal().trim();
					}
					statDispText = StatCommands.getInstance().cattCommandsStub
							.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
									.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
							.getStrVal().trim();
					if (flag && StatCommands.getInstance().cattCommandsStub
							.jasperGetDisplaySegmentState(
									JasperNaDisplaySegmentMsg.newBuilder().setSegment(DisplaySegment.SEG_YES).build())
							.getBoolVal()) {
						flag = StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
								.addJsButton(Jasper_Buttons.BUTTON_E).setDurationInMillisecond(100).build())
								.getBoolVal();
						statDispText = StatCommands.getInstance().cattCommandsStub
								.jasperGetDisplayText(
										JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
								.getStrVal().trim();

						if (statDispText.contains("FORMAT")) {

							while (StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplaySegmentState(JasperNaDisplaySegmentMsg.newBuilder()
											.setSegment(DisplaySegment.SEG_SELECT).build())
									.getBoolVal()) {

								flag = StatCommands.getInstance().cattCommandsStub
										.setButtonsClick(ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_G)
												.setDurationInMillisecond(100).build())
										.getBoolVal();
								statDispText = StatCommands.getInstance().cattCommandsStub
										.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
												.setTextArea(DisplayArea.Multitext)
												.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
										.getStrVal().trim();
							}

							flag = StatCommands.getInstance().cattCommandsStub
									.isJasperHomeScreen(String_Msg.newBuilder().build()).getStrVal().contains("true");
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find Clock Format");
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Text Display on the thermostat is " + statDispText);
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find yes button");
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Text Display on the thermostat is " + statDispText);
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Finish setup is not visible");
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Text Display on the thermostat is " + statDispText);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Use app to configure thermostat");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Text Display on the thermostat is " + statDispText);
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Start setup is not displaying on the thermostat");
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Text Display on the thermostat is " + statDispText);
			flag = false;
		}

		return flag;
	}

}
