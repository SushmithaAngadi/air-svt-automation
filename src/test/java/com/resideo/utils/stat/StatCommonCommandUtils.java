package com.resideo.utils.stat;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.CommonState;
import com.resideo.system.utils.SystemState;
import com.resideo.system.utils.TrailData;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg.Jasper_Buttons;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.JasperNaDisplaySegmentMsg;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg.SetPoint;
import com.resideo.utils.stat.cattgrpccommands.SystemSwitchMsg.SystemSwitch;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.stat.jasper_common.NavigateScreen_T5_T6_NA_EMEA;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.SystemSwitchMsg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg;

public class StatCommonCommandUtils {

	enum CaspianButtonCommand {
		SHORTPRESS, LONGPRESS, EXTRALONGPRESS;
	}

	private static String displayText;

	public static void setThermostattext(String text) {
		displayText = text;
	}

	public static String getThermostatText() {
		return displayText;
	}

	public static boolean performAPModeScenario(TestCases testCase, int InterValTime, int repeat) {
		boolean flag = false;

		for (int i = 0; i < repeat; i++) {
			if (StatCommands.getInstance().cattCommandsStub.setButtonsClick(
					ButtonMsg.newBuilder().addJsButton(Jasper_Buttons.BUTTON_F).setDurationInMillisecond(6000).build())
					.toString().contains("true")) {
				try {
					Thread.sleep(12000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				Keyword.ReportStep_Pass(testCase, "AP Mode Initiate to Broadcast");

				flag = isAPMode(testCase, InterValTime, repeat, i);

				flag = flag && StatCommands.getInstance().cattCommandsStub
						.jasperSetHomeScr(String_Msg.newBuilder().setStrVal("").build()).toString().contains("true");

				StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayIsSegmentBlinking(JasperNaDisplaySegmentMsg.newBuilder().build()).toString()
						.contains("true");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"No able to initiate AP Mode in Thermostat");
				flag = false;
				break;
			}
		}
		return flag;

	}

	public static boolean isAPMode(TestCases testCase, int InterValTime, int repeat, int scenario) {
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(InterValTime));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String initialname = StatCommands.getInstance().cattCommandsStub
							.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
									.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
							.getStrVal().toString().trim();

					if (initialname.contains("LYRIC") || initialname.contains("TSTAT")) {
						return true;
					} else {
						System.out.println("Waiting for AP mode Start");
						return false;
					}
				} catch (Exception e) {
					System.out.println("Exception occred ," + e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived) {
			Keyword.ReportStep_Pass(testCase, "Thermostat in AP Mode, Trail NO :" + String.valueOf(scenario));
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Thermostat Try to Set AP mode but its failed , Waiting Time is =" + String.valueOf(InterValTime));
			return false;
		}
	}

	public static boolean IsApMode_T6_T10_T10Plus(TestCases testCase, int WaitTime) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(WaitTime));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					return StatCommands.getInstance().cattCommandsStub
							.getAPModeState(String_Msg.newBuilder().setStrVal("").build()).toString().contains("true");
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Stat Is Apmode verification Failed, Exception is " + e);
					return false;
				}
			}
		});
		if (isEventReceived) {
			Keyword.ReportStep_Pass(testCase, "Verified, The stat in AP Mode");
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"AP mpde failed waiting time is " + String.valueOf(WaitTime));
			flag = false;
		}
		return flag;
	}

	public static boolean IsApMode_T6_T10_T10Plus_Station(TestCases testCase, int WaitTime) {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(WaitTime));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (!StatCommands.getInstance().cattCommandsStub
								.getAPModeState(String_Msg.newBuilder().setStrVal("").build()).toString()
								.contains("true")) {
							Keyword.ReportStep_Pass(testCase, "AP mode is OFF");
							return true;
						} else
							return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Stat Is Apmode verification Failed, Exception is " + e);
						return false;
					}
				}
			});
			if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "Verified, The stat not in AP Mode");
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean navigateToWifiFromHomeScreen(TestCases testCase) {
		boolean flag = false;
		Boolean_Msg navigatingToWifiInFlycathcer = StatCommands.getInstance().cattCommandsStub
				.navigatingToWifiInFlycathcer(Boolean_Msg.newBuilder().build());
		if (navigatingToWifiInFlycathcer.getBoolVal()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean setAndVerifyAPMode(TestCases testCase) {
		boolean flag = false;

//		StatCommands.getInstance().cattCommandsStub.navigatingToWifiInFlycathcer(Boolean_Msg.newBuilder().build()).toString();
		Boolean_Msg clickOnButtonUsingCoordiantes = StatCommands.getInstance().cattCommandsStub
				.clickOnButtonUsingCoordiantes(String_Msg.newBuilder().setStrVal("150,450").build());

		// StatCommands.getInstance().cattCommandsStub.clickOnButtonUsingCoordiantes(String_Msg.newBuilder().setStrVal("0,0").build());
		boolean boolVal = clickOnButtonUsingCoordiantes.getBoolVal();
		Keyword.ReportStep_Pass(testCase, "Clicked on Change Network Button");
//		String string = StatCommands.getInstance().cattCommandsStub.clickOnLastBottomButtonInFlyCatcher(Boolean_Msg.newBuilder().build()).toString();
		flag = boolVal && IsApMode_T6_T10_T10Plus(testCase, 15);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean setHomeScreenjasper(TestCases testCase, int InterValTime) {
		try {
			String deviceNeedToInstall = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
			if (deviceNeedToInstall.contains("JASPER_SENIOR_NA")) {
				FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
				fWait.pollingEvery(Duration.ofSeconds(4));
				fWait.withTimeout(Duration.ofMinutes(InterValTime));
				Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean driver) {
						try {
							if (StatCommands.getInstance().cattCommandsStub
									.jasperSetHomeScr(String_Msg.newBuilder().build()).getBoolVal()) {
								return true;
							} else {
								System.out.println("Navigating to Home screen");
								return false;
							}
						} catch (Exception e) {
							System.out.println("Exception occred ," + e.getMessage());
							return false;
						}
					}
				});
				if (isEventReceived) {
					Keyword.ReportStep_Pass(testCase, "Thermostat in Home Screen");
					return true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Thermostat Not able to navigate to Home Screen");
					return false;
				}
			} else {
				return NavigateScreen_T5_T6_NA_EMEA.jasperEmea_Navigate_StartSetup_inAny_screen_Home(testCase);
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured setHomeScreenjasper(TestCases testCase, int InterValTime) due to :"
							+ e.getMessage());
			return false;
		}

	}

	public static String setBroadcastMode(TestCases testCase, int trailcount, int longpress, Jasper_Buttons btn,
			int timeOut) {

		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.withTimeout(Duration.ofSeconds(timeOut));
			if (StatCommands.getInstance().cattCommandsStub
					.setButtonsClick(
							ButtonMsg.newBuilder().addJsButton(btn).setDurationInMillisecond(longpress).build())
					.getBoolVal()) {
//				StatCommands.getInstance().cattCommandsStub
//						.setButtonsToHardwareControl(String_Msg.newBuilder().build());

				Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean driver) {
						try {
							String displayText = StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
											.setTextArea(DisplayArea.Multitext)
											.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
									.getStrVal().toString().trim().toUpperCase();

							if (displayText.contains("LYRIC") || displayText.contains("TSTAT")) {
								setThermostattext(displayText);
								return true;
							} else if (displayText.contains("OUTDOOR") || displayText.contains("REGISTER")
									|| displayText.contains("SET THE DATE") || displayText.contains("DATE AND")
									|| displayText.contains("TIME") || displayText.contains("DATE")) {
								StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
										.addJsButton(Jasper_Buttons.BUTTON_F).setDurationInMillisecond(200).build());
								return false;
							} else {
								System.out.println("Waiting for Tstat or Lyric Text");
								return false;
							}
						} catch (Exception e) {
							System.out.println("Exception occred ," + e.getMessage());
							return false;
						}
					}
				});
				if (isEventReceived) {
					Keyword.ReportStep_Pass(testCase,
							"Thermostat is in AP Mode, Stat Display text :" + getThermostatText());
					return getThermostatText();
				} else {
					boolean apModeState = StatCommands.getInstance().cattCommandsStub
							.getAPModeState(String_Msg.newBuilder().build()).getBoolVal();
					if (apModeState) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Thermostat is NOT in AP Mode, Stat Display text :" + getThermostatText());
						return getThermostatText();
					} else {
						return setBroadcastModeReconfirm(testCase, trailcount, longpress, btn);
					}

				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat is NOT in AP Mode, failed");
				return null;
			}
		} catch (Exception e) {
			return setBroadcastModeReconfirm(testCase, trailcount, longpress, btn);

		}

	}

	public static String setBroadcastModeReconfirm(TestCases testCase, int trailCount, int longpress,
			Jasper_Buttons btn) {
		boolean apModeState = StatCommands.getInstance().cattCommandsStub
				.getAPModeState(String_Msg.newBuilder().build()).getBoolVal();
		if (trailCount == 1 && !apModeState) {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.withTimeout(Duration.ofSeconds(60));
			if (StatCommands.getInstance().cattCommandsStub
					.setButtonsClick(
							ButtonMsg.newBuilder().addJsButton(btn).setDurationInMillisecond(longpress).build())
					.getBoolVal()) {
				StatCommands.getInstance().cattCommandsStub
						.setButtonsToHardwareControl(String_Msg.newBuilder().build());

				Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean driver) {
						try {
							String displayText = StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
											.setTextArea(DisplayArea.Multitext)
											.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
									.getStrVal().toString().trim().toUpperCase();

							if (displayText.contains("LYRIC") || displayText.contains("TSTAT")) {
								setThermostattext(displayText);
								return true;
							} else if (displayText.contains("OUTDOOR") || displayText.contains("REGISTER")
									|| displayText.contains("SET THE DATE") || displayText.contains("DATE AND")
									|| displayText.contains("TIME") || displayText.contains("DATE")) {
								StatCommands.getInstance().cattCommandsStub.setButtonsClick(ButtonMsg.newBuilder()
										.addJsButton(Jasper_Buttons.BUTTON_F).setDurationInMillisecond(200).build());
								return false;
							} else {
								System.out.println("Waiting for Tstat or Lyric Text");
								return false;
							}
						} catch (Exception e) {
							System.out.println("Exception occred ," + e.getMessage());
							return false;
						}
					}
				});
				if (isEventReceived) {
					Keyword.ReportStep_Pass(testCase,
							"Thermostat is in AP Mode, Stat Display text :" + getThermostatText());
					return getThermostatText();
				} else {
					apModeState = StatCommands.getInstance().cattCommandsStub
							.getAPModeState(String_Msg.newBuilder().build()).getBoolVal();
					if (apModeState) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Thermostat is in AP Mode, Stat Display text :" + getThermostatText());
						return getThermostatText();
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Thermostat is not in AP Mode, Stat Display text :" + getThermostatText());
						return null;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat is NOT in AP Mode, failed");
				return null;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat is NOT in AP Mode, failed");
			return null;
		}
	}

	public static String getHomeKitParingMode(TestCases testCase, String deviceNeedToInstall) {
		String homeKitPairingCode = "";
		KeepAppActive appActive = new KeepAppActive(testCase);
		appActive.start();
		if (deviceNeedToInstall.contains("JASPER")) {

			try {
				FluentWait<String> fWait = new FluentWait<String>("");
				fWait.pollingEvery(Duration.ofSeconds(10));
				fWait.withTimeout(Duration.ofSeconds(300));
				String homeKitCode = fWait.until(new Function<String, String>() {
					public String apply(String driver) {
						try {
							String homeKitPairingCode = StatCommands.getInstance().cattCommandsStub
									.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder()
											.setTextArea(DisplayArea.Multitext).build())
									.getStrVal();
							if (homeKitPairingCode.contains("□")) {
								return null;
							} else {
								return homeKitPairingCode;

							}
						} catch (Exception e) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Setpoint verification Failed, Due to exception, Exception is " + e.getMessage());
							return null;
						}
					}
				});

				homeKitPairingCode = homeKitCode;
			} catch (Exception e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception occured due to " + e.getMessage());
				homeKitPairingCode = null;
			}

//			for (int i = 0; i <= 60; i++) {
//				homeKitPairingCode = StatCommands.getInstance().cattCommandsStub
//						.jasperGetDisplayText(
//								JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext).build())
//						.getStrVal();
//				System.out.println(homeKitPairingCode);
//				if (homeKitPairingCode.contains("□")) {
//					try {
//						Thread.sleep(1000);
//						System.out.println("retry");
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//				} else {
//					iscodedisplyed = true;
//					break;
//
//				}
//			}

//			if (iscodedisplyed) {
//
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Code not able to read, Displayed code is " + homeKitPairingCode);
//				homeKitPairingCode = null;
//			}
		} else if (deviceNeedToInstall.contains("FLYCATCHER")) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Device not in list, Pls Check Device List for FLYCATHCER");
			homeKitPairingCode = null;
		} else if (deviceNeedToInstall.contains("THOR")) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Device not in list, Pls Check Device List for THOR");
			homeKitPairingCode = null;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Device not in list, Pls Check Device List");
			homeKitPairingCode = null;
		}

		appActive.requestStop();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (appActive.isAlive())
			appActive.requestStop();

		if (homeKitPairingCode != null && !homeKitPairingCode.isEmpty()) {
			Keyword.ReportStep_Pass(testCase,
					"Home Kit Pairing code Showing In thermosat, The code is " + homeKitPairingCode.trim());
			return homeKitPairingCode.trim().replace("-", "");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"HomeKit pairing code is not Visible in Thermostat");
			return null;
		}
	}

	public static String get6CharMacId() {
		String deviceName = null;
		String mac_ID = StatCommands.getInstance().cattCommandsStub
				.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
		int length = mac_ID.toCharArray().length;
		if (length > 12) {
			int first = length - 12;
			String substring = mac_ID.substring(first, length);
			deviceName = substring;
		} else {
			deviceName = mac_ID;
		}
		deviceName = deviceName.substring(6, 12);

		System.out.println("Device Name is " + deviceName);
		SystemState.getStatus().getLast6CharDeviceMacID(deviceName);
		return deviceName;
	}

	public static boolean caspianValveButtonCommand(TestCases testCase, String buttoncondition) {
		boolean flag = false;
		switch (buttoncondition.toUpperCase()) {
		case "SHORT": {
			flag = StatCommands.getInstance().cattCommandsStub.caspainButtonShortPress(String_Msg.newBuilder().build())
					.getBoolVal();
			break;
		}
		case "LONG": {
			flag = StatCommands.getInstance().cattCommandsStub.caspianSetPairingMode(String_Msg.newBuilder().build())
					.getBoolVal();
			break;
		}
		case "EXTRALONG": {
			flag = StatCommands.getInstance().cattCommandsStub.caspianDoManualHardReset(String_Msg.newBuilder().build())
					.getBoolVal();
			break;
		}
		default: {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Mismatch string, valid strings are SHORT,LONG,EXTRALONG, But User give String is  "
							+ buttoncondition);
			break;
		}

		}

		if (flag) {
			Keyword.ReportStep_Pass(testCase,
					"Successfully Connect button performed, User expectation is " + buttoncondition);
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"UnSuccessfully Connect button performed, User expectation is " + buttoncondition);
			return false;
		}

	}

//	public static int setToTempRaiser(int currentpoint, int givenPoint) {
//		int add = currentpoint + givenPoint;
//		int sub = currentpoint - givenPoint;
//		if (add <= 90 && add >= 50) {
//			return add;
//		} else if (sub >= 50 && sub <= 90) {
//			return sub;
//		} else {
//			return 70;
//		}
//	}

	public static String getStatMacID() {
		try {
			String mac_ID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
//		String macID = "48A2E64C90F2";
			int length = mac_ID.toCharArray().length;
			if (length > 12) {
				int first = length - 12;
				String substring = mac_ID.substring(first, length);
				return substring;
			} else {
				return mac_ID;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean setPoint_Heat_Cool(TestCases testCase, float setSetPoint) {
		boolean flag = false;
		String mode = CommonState.getStatus().StatCurrentModeBeforeTrailStart();
		if (mode.equalsIgnoreCase("heat"))
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_HEAT).setVal(setSetPoint).build());
		else if (mode.equalsIgnoreCase("cool"))
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_COOL).setVal(setSetPoint).build());
		else {
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Invalid Keyword Arguments");
			flag = false;
		}
		TrailData.getStatus().changeTime(String.valueOf(System.currentTimeMillis()));
		Keyword.ReportStep_Pass(testCase, "Setpoint changed from STAT, from : "
				+ CommonState.getStatus().StatCurrentSetPointBeforeTrailStart() + " , To : " + setSetPoint);
		flag = verifySetpointFromStat(testCase, Duration.ofSeconds(15), mode, setSetPoint, false);
		return flag;
	}

	public static boolean setPoint_Heat_Cool(TestCases testCase, String mode, float setSetPoint) {
		boolean flag = false;
		if (mode.equalsIgnoreCase("heat"))
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_HEAT).setVal(setSetPoint).build());
		else if (mode.equalsIgnoreCase("cool"))
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_COOL).setVal(setSetPoint).build());
		else {
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Invalid Keyword Arguments");
			flag = false;
		}
		flag = verifySetpointFromStat(testCase, Duration.ofSeconds(15), mode, setSetPoint, false);
		return flag;
	}

	public static boolean verifySetpointFromStat(TestCases testCase, Duration duration, String mode,
			float setThisSetPoint, boolean isReport) {
		boolean flag = false;

		float statCurrentSetPointBeforeTrailStart = CommonState.getStatus().StatCurrentSetPointBeforeTrailStart();
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(duration);
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				float currentStatSetPoint = 0;
				try {
					if (mode.equalsIgnoreCase("heat")) {
						currentStatSetPoint = StatCommands.getInstance().cattCommandsStub
								.getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_HEAT).build())
								.getFloatVal();
					} else if (mode.equalsIgnoreCase("cool")) {
						currentStatSetPoint = StatCommands.getInstance().cattCommandsStub
								.getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_COOL).build())
								.getFloatVal();
					}

					if (currentStatSetPoint == setThisSetPoint) {
						if (isReport) {
							TrailData.getStatus().changeToValue(String.valueOf(currentStatSetPoint));
							TrailData.getStatus().verifyTime(String.valueOf(System.currentTimeMillis()));
							Keyword.ReportStep_Pass(testCase, "Setpoint Verified from STAT, from : "
									+ statCurrentSetPointBeforeTrailStart + " ,  to : " + currentStatSetPoint);
							return true;
						} else {
							return true;
						}

					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "SetPoint verification failed from STAT, Current Setpoint is "+currentStatSetPoint);
						return false;
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Setpoint verification Failed, Due to exception, Exception is " + e.getMessage());
					return false;
				}
			}
		});

		if (isEventReceived) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Setpoint not changed in thermostat");

			flag = false;
		}

		return flag;
	}

	public static boolean verifySetpointFromStat(TestCases testCase, Duration duration, String mode, float setpoint) {
		boolean flag = false;

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(duration);
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				float currentStatSetPoint = 0;
				try {
					if (mode.equalsIgnoreCase("heat")) {
						currentStatSetPoint = StatCommands.getInstance().cattCommandsStub
								.getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_HEAT).build())
								.getFloatVal();
					} else if (mode.equalsIgnoreCase("cool")) {
						currentStatSetPoint = StatCommands.getInstance().cattCommandsStub
								.getSetpoint(SetPointMsg.newBuilder().setType(SetPoint.CONTROL_SETPOINT_COOL).build())
								.getFloatVal();
					}

					if (currentStatSetPoint == setpoint) {
						Keyword.ReportStep_Pass(testCase,
								"Setpoint Verified from STAT , Current setpoint is : " + currentStatSetPoint);
						return true;
					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "SetPoint verification failed from STAT, Current Setpoint is "+currentStatSetPoint);
						return false;
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Setpoint verification Failed, Due to exception, Exception is " + e.getMessage());
					return false;
				}
			}
		});

		if (isEventReceived) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Setpoint not changed in thermostat");

			flag = false;
		}

		return flag;
	}

	public static boolean setModeHeat_Cool(TestCases testCase, String mode) {
		boolean flag = false;
		flag = StatCommands.getInstance().cattCommandsStub
				.setSystemSwitch(
						SystemSwitchMsg.newBuilder().setSwitch(SystemSwitch.valueOf(mode.toUpperCase())).build())
				.getBoolVal();
		TrailData.getStatus().changeTime(String.valueOf(System.currentTimeMillis()));
		flag = flag && verifyModeHeat_Cool(testCase, Duration.ofSeconds(15), mode, false);
		return flag;
	}

	public static boolean verifyModeHeat_Cool(TestCases testCase, Duration duration, String mode, boolean report) {
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(duration);
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String Mode = StatCommands.getInstance().cattCommandsStub
							.getSystemSwitch(String_Msg.newBuilder().build()).getSwitch().toString();
					if (Mode.toUpperCase().contains(mode.toUpperCase())) {
						if (report) {
							TrailData.getStatus().verifyTime(String.valueOf(System.currentTimeMillis()));
							TrailData.getStatus().changeToValue(Mode);
						}
						return true;
					} else {
						System.out.println("Mode not changed yet");
						return false;
					}
				} catch (Exception e) {
					System.out.println("Exception raised due to " + e.getMessage());
					return false;
				}
			}
		});

		return isEventReceived;
	}

	@SuppressWarnings("unused")
	public static void ThreadLock(TestCases testCase, Duration dur) {
		try {
			KeepAppActive appActive = new KeepAppActive(testCase);
			appActive.start();
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(dur);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						MobileUtils.isMobElementExists("ID", "Device enrolment app thread lock", testCase);
						System.out.println("Thread lock in");
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			appActive.requestStop();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (appActive.isAlive())
				appActive.requestStop();

		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Thread expired and its exit in less time");
		}
		System.out.println("Thread lock out");
	}

	public static boolean getMulti_textIn_Jasper(TestCases testCase, String expectedText1, String expectedText2,
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

//	public static boolean getMulti_textIn_Houdini(TestCases testCase, String expectedText1, String expectedText2,
//			String message) {
//		boolean flag = false;
//		try {
//
//			FluentWait<Boolean> fWait = new FluentWait<Boolean>(flag);
//			fWait.pollingEvery(Duration.ofSeconds(5));
//			fWait.withTimeout(Duration.ofMinutes(2));
//			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//				public Boolean apply(Boolean flag1) {
//					try {
////						String text = StatCommands.getInstance().cattCommandsStub
////								.getHoudiniDisplayText(HoudiniDisplayTextMsg.newBuilder()
////										.setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build())
////								.getStrVal();
//						if (text != null) {
//							if (text.toUpperCase().contains(expectedText1)) {
//								Keyword.ReportStep_Pass(testCase, message + " : " + text);
//								return true;
//							}
//							if (expectedText2 != null && text.toUpperCase().contains(expectedText2)) {
//								Keyword.ReportStep_Pass(testCase, message + " : " + text);
//								return true;
//							} else {
////								Keyword.ReportStep_Pass(testCase,
////										"Stat is enabled to broadcast. But Stat device name while broadcasting is not as expected. Displayed text : "
////												+ text);
//								System.out.println("Display Text is not same");
//								return false;
//							}
//						} else {
////							Keyword.ReportStep_Pass(testCase,
////									"Failed to get stat device name once device is enabled for broadcast. Retrying...");
//							System.out.println("From AAT Is null");
//							return false;
//						}
//					} catch (TimeoutException e) {
//						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
//								"Failed to enable device broadcast with timeout : 2min");
//						return false;
//					} catch (StaleElementReferenceException e) {
//						Keyword.ReportStep_Pass(testCase,
//								"Failed to get stat device name once device is enabled for broadcast. Retrying...");
//						return false;
//					} catch (Exception e) {
//						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
//								"Exception Raised in getMulti_textIn_EMEA_Display(TestCases testCase, String expectedText1, String expectedText2,String message) due to : "
//										+ e.getMessage());
//						return false;
//					}
//				}
//			});
//
//			flag = isEventReceived;
//
//		} catch (Exception e) {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Exception Raised in getMulti_textIn_EMEA_Display(TestCases testCase, String expectedText1, String expectedText2,String message) due to : "
//							+ e.getMessage());
//		}
//		return flag;
//	}

	public static boolean setEnvironMentData(TestCases testCase, TestCaseInputs inputs, String data) {
		boolean flag = true;
		KeepAppActive appActive;
		try {
			if (data.contains("STAT_DETAILS")) {
				appActive = new KeepAppActive(testCase);
				appActive.start();
				flag = flag && setDeatilsToProjectSpecific();
				if (appActive.isAlive()) {
					appActive.requestStop();
				}
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION, "Exception Occurs +" + e);
		}
		return flag;
	}

	private static String macID;
	private static String deviceName;

	public static String getMacID() {
		return macID;
	}

	public static String getdeviceName() {
		return deviceName;
	}

	public static boolean setDeatilsToProjectSpecific() {
		boolean flag = false;

		try {
			String mac_ID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
			int length = mac_ID.toCharArray().length;
			if (length > 12) {
				int first = length - 12;
				String substring = mac_ID.substring(first, length);
				macID = substring;
			} else {
				macID = mac_ID;
			}
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID", mac_ID));
			String model_Name = StatCommands.getInstance().cattCommandsStub
					.getDeviceInformation(String_Msg.newBuilder().setStrVal("MODEL_NAME").build()).getStrVal();
			String deviceModelName = getDeviceModelName(model_Name);
			deviceName = deviceModelName;
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST",
					deviceModelName));
			String wifi_Version = StatCommands.getInstance().cattCommandsStub
					.getDeviceInformation(String_Msg.newBuilder().setStrVal("WIFI_VERSION").build()).getStrVal();
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"STAT_WIFI_BLE_VERSION", wifi_Version));
			String collection_Version = StatCommands.getInstance().cattCommandsStub
					.getDeviceInformation(String_Msg.newBuilder().setStrVal("COLLECTION_VERSION").build()).getStrVal();
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"STAT_COLLECTION_VERSION", collection_Version));
//			String tstat_Version = StatCommands.getInstance().cattCommandsStub
//					.getDeviceInformation(String_Msg.newBuilder().setStrVal("THERMOSTAT_VERSION").build()).getStrVal();
//			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
//					"STAT_FIRMWARE_VERSION", tstat_Version));
			String deviceCountryNeedtoInstall = getDeviceCountryNeedtoInstall(deviceModelName);
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"CHOOSE_COUNTRY_DEVICE_NEED_TO_INSTALL", deviceCountryNeedtoInstall));
			flag = true;
		} catch (Exception e) {
			flag = false;
			System.out.println(e);
		}

		return flag;
	}

	public static String getDeviceModelName(String name) {
		if (name.toUpperCase().contains("TH6220WF2006")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Good
		} else if (name.toUpperCase().contains("TH6320WF2003")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Better
		} else if (name.toUpperCase().contains("RCHT8610WF2006")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail_US
		} else if (name.toUpperCase().contains("RCHT8610WF2014")) {
			return "JASPER_SENIOR_NA_RETAIL_CA";// Retail_CA
		} else if (name.toUpperCase().contains("RCHT8610WF3005")) {
			return "JASPER_SENIOR_NA_RETAIL";// Apple
		} else if (name.toUpperCase().contains("RCHT8612WF2005")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail Cannada
		} else if (name.toUpperCase().contains("RTH8800WF202")) {
			return "JASPER_SENIOR_NA_RETAIL";// Retail Renew
		} else if (name.toUpperCase().contains("TH6220WF2007")) {
			return "JASPER_SENIOR_NA_TRADE";// Trade_Good_Wetsaw
		} else if (name.toUpperCase().contains("YT4710WF1003")) {
			return "JASPER_SENIOR_EMEA_WIRED";// EMEA_Wired
		} else if (name.toUpperCase().contains("YT4910WF4011")) {
			return "JASPER_SENIOR_EMEA_WIRELESS";// EMEA_Wireless
		} else if (name.toUpperCase().contains("THX321WF2001W")) {
			return "FLYCATCHER";// trade
		} else if (name.toUpperCase().contains("RCHT9610WFW2004")) {
			return "FLYCATCHER";// retail
		} else if (name.toUpperCase().contains("WM10845E100")) {
			return "CASPIAN";// EnerCare
		} else if (name.toUpperCase().contains("WM12845T100")) {
			return "CASPIAN";// Trade
		} else if (name.toUpperCase().contains("THX321WF3001W")) {
			return "THOR";// Trade
		} else if (name.toUpperCase().contains("RCHT9510WFW3001")) {
			return "THOR";// Retail
		} else if (name.toUpperCase().contains("TFP220WF1")) {
			return "HOUDINI";// Trade
		} else if (name.toUpperCase().contains("RFP210WF1")) {
			return "HOUDINI";// Retail
		} else {
			return null;
		}
	}

	public static String getDeviceCountryNeedtoInstall(String deviceModelName) {
		if (deviceModelName.contains("JASPER_SENIOR_NA_TRADE")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("JASPER_SENIOR_NA_RETAIL_CA")) {
			return "CANADA";
		} else if (deviceModelName.contains("JASPER_SENIOR_NA_RETAIL")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("JASPER_SENIOR_EMEA_WIRED")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("JASPER_SENIOR_EMEA_WIRELESS")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("FLYCATCHER")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("CASPIAN")) {
			return "UNITED_KINGDOM";
		} else if (deviceModelName.contains("THOR")) {
			return "UNITED_STATES";
		} else if (deviceModelName.contains("HOUDINI")) {
			return "UNITED_STATES";
		} else {
			return null;
		}
	}

	public static boolean isThermostatConnectedWith_Wifi(TestCases testCase) {
		boolean flag = false;
		try {
			String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(Duration.ofSeconds(20));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String ipAddress = StatCommands.getInstance().cattCommandsStub
								.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
								.getStrVal();
						String WifiName = StatCommands.getInstance().cattCommandsStub
								.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build())
								.getStrVal();

						SystemState.getStatus().currentIPAddress(ipAddress);
						SystemState.getStatus().currentWifiName(WifiName);

						if (ipAddress == null) {
							Keyword.ReportStep_Pass(testCase,
									"Wifi not connected, wait for sometime if thermostat try to connect to the wifi");
							SystemState.getStatus().isWifiConfigured(false);
							return false;
						} else if (ipAddress.contains("invalid")) {
							if (WifiName == null || WifiName.isEmpty()) {
								SystemState.getStatus().isWifiConfigured(false);
								Keyword.ReportStep_Pass(testCase, "WIFI not configured");
								return true;
							} else {
								SystemState.getStatus().isWifiConfigured(false);
								Keyword.ReportStep_Pass(testCase,
										"WIFI IP is invalid, wifi name is not empty or null, WIfi name is " + WifiName);
								return true;
							}

						} else if ((ipAddress.substring(0, 2).contains("0."))
								|| (ipAddress.substring(0, 1).contains("0"))) {
							SystemState.getStatus().isWifiConfigured(false);
							Keyword.ReportStep_Pass(testCase,
									"Wifi not connected, wait for sometime if thermostat try to connect to the wifi. IP from device is "
											+ ipAddress);
							return false;
						} else if (ipAddress.substring(0, 3).contains("169")) {
							SystemState.getStatus().isWifiConfigured(true);
							Keyword.ReportStep_Pass(testCase,
									"WIFI configured may be its in link local, IP address is " + ipAddress);
							return true;
						} else if (!ipAddress.substring(0, 3).contains("169") && WifiName.contains(wifiSSID)) {
							SystemState.getStatus().isWifiConfigured(true);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
							return true;
						} else if (WifiName.contains(wifiSSID)) {
							SystemState.getStatus().isWifiConfigured(true);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
							Keyword.ReportStep_Pass(testCase, "Thermostat wifi is not in link local");
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase, "Current IP address is " + ipAddress);
							Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + WifiName);
							SystemState.getStatus().isWifiConfigured(false);
							return false;
						}

					} catch (Exception e) {
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isWifiConfigured()) {
				flag = true;
			} else if (isEventReceived && !SystemState.getStatus().isWifiConfigured()) {
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Current IP address is " + SystemState.getStatus().currentIPAddress());
			Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + SystemState.getStatus().currentWifiName());
			flag = false;
		}
		return flag;
	}

	public static boolean connectwithWIfiUsing_AAT(TestCases testCase) {
		boolean flag = false;

		try {
			String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			String wifiSecurity = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SECURITY");
			String wifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD");

			StatCommands.getInstance().cattCommandsStub
					.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(true).build());

			Thread.sleep(5000);
			StatCommands.getInstance().cattCommandsStub
					.setNetworkName(String_Msg.newBuilder().setStrVal(wifiSSID).build());

			StatCommands.getInstance().cattCommandsStub
					.setNetworkPassword(String_Msg.newBuilder().setStrVal(wifiPassword).build());

			StatCommands.getInstance().cattCommandsStub
					.setNetworkSecurity(WifiSecurityModeMsg.newBuilder().setMode(securityMode(wifiSecurity)).build());

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(10));
			fWait.withTimeout(Duration.ofMinutes(1));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String ipAddress = StatCommands.getInstance().cattCommandsStub
								.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
								.getStrVal();
						String WifiName = StatCommands.getInstance().cattCommandsStub
								.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build())
								.getStrVal();

						SystemState.getStatus().currentIPAddress(ipAddress);
						SystemState.getStatus().currentWifiName(WifiName);

						if (ipAddress == null) {
							Keyword.ReportStep_Pass(testCase,
									"Wifi not connected, wait for sometime if thermostat try to connect to the wifi");
							SystemState.getStatus().isWifiConfigured(false);
							return false;
						} else if (ipAddress.contains("invalid")) {
							SystemState.getStatus().isWifiConfigured(false);
							Keyword.ReportStep_Pass(testCase, "Current ip address " + ipAddress);
							return false;
						} else if ((ipAddress.substring(0, 2).contains("0."))
								|| (ipAddress.substring(0, 1).contains("0"))) {
							Keyword.ReportStep_Pass(testCase,
									"Wifi not connected, wait for sometime if thermostat try to connect to the wifi. IP from device is "
											+ ipAddress);
							SystemState.getStatus().isWifiConfigured(false);
							return false;
						} else if (ipAddress.substring(0, 3).contains("169")) {
							SystemState.getStatus().isWifiConfigured(true);
							Keyword.ReportStep_Pass(testCase,
									"WIFI configured may be its in link local, IP address is " + ipAddress);
							return true;
						} else if ((!ipAddress.contains("invalid")) && (!ipAddress.substring(0, 3).contains("169"))
								&& (WifiName.contains(wifiSSID))) {
							SystemState.getStatus().isWifiConfigured(true);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
							Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
							return true;
						} else {
							Keyword.ReportStep_Pass(testCase, "Current IP address is " + ipAddress);
							Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + WifiName);
							SystemState.getStatus().isWifiConfigured(false);
							return false;
						}

					} catch (Exception e) {
						SystemState.getStatus().isWifiConfigured(false);
						return false;
					}
				}
			});
			if (isEventReceived && SystemState.getStatus().isWifiConfigured()) {
				flag = true;
			} else if (isEventReceived && !SystemState.getStatus().isWifiConfigured()) {
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Current IP address is " + SystemState.getStatus().currentIPAddress());
			Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + SystemState.getStatus().currentWifiName());
			flag = false;
		}
		return flag;
	}

	public static WifiSecurityMode securityMode(String wifiSecurity) {
		WifiSecurityMode secureMode = null;
		switch (wifiSecurity) {
		case "WEP_PSK":
			secureMode = WifiSecurityMode.WEP_PSK;
			break;
		case "WEP_Shared":
			secureMode = WifiSecurityMode.WEP_Shared;
			break;
		case "WPA_TKIP_PSK":
			secureMode = WifiSecurityMode.WPA_TKIP_PSK;
			break;
		case "WPA_AES_PSK":
			secureMode = WifiSecurityMode.WPA_AES_PSK;
			break;
		case "WPA_MIXED_PSK":
			secureMode = WifiSecurityMode.WPA_MIXED_PSK;
			break;
		case "WPA2_AES_PSK":
			secureMode = WifiSecurityMode.WPA2_AES_PSK;
			break;
		case "WPA2_TKIP_PSK":
			secureMode = WifiSecurityMode.WPA2_TKIP_PSK;
			break;
		case "WPA2_MIXED_PSK":
			secureMode = WifiSecurityMode.WPA2_MIXED_PSK;
			break;
		case "WPA_TKIP_Enterprise":
			secureMode = WifiSecurityMode.WPA_TKIP_Enterprise;
			break;
		case "WPA_AES_Enterprise":
			secureMode = WifiSecurityMode.WPA_AES_Enterprise;
			break;
		case "WPA_MIXED_Enterprise":
			secureMode = WifiSecurityMode.WPA_MIXED_Enterprise;
			break;
		case "WPA2_TKIP_Enterprise":
			secureMode = WifiSecurityMode.WPA2_TKIP_Enterprise;
			break;
		case "WPA2_AES_Enterprise":
			secureMode = WifiSecurityMode.WPA2_AES_Enterprise;
			break;
		case "WPA2_MIXED_Enterprise":
			secureMode = WifiSecurityMode.WPA2_MIXED_Enterprise;
			break;
		case "WPS_Open":
			secureMode = WifiSecurityMode.WPS_Open;
			break;
		default:
			secureMode = WifiSecurityMode.WPA2_AES_PSK;
			break;
		}

		return secureMode;
	}

}