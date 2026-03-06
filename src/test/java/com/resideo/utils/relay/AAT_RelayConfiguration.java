package com.resideo.utils.relay;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.ArduinoRelayFunction;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.ArduinoRelayFunction.RequestType;

public class AAT_RelayConfiguration {

	public enum sensorType {
		EIM, OAS, IAS
	}

	public static boolean EIM_Sensor_CommandControl(TestCases testCase, String eqipmentName, String action) {
		boolean flag = false;
		try {

			if (StatCommands.getInstance().cattCommandsStub
					.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build())
					.getBoolVal()) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to find Sensor hardware");
				flag = false;
			}

			if (flag && eqipmentName.contains("EIM")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in EIM, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in EIM, due to relay open issue");
					flag = false;
				}
			} else if (flag && eqipmentName.contains("OAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in OAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in OAS, due to relay open issue");
					flag = false;
				}
			} else if (flag && eqipmentName.contains("1IAS") || flag && eqipmentName.equals("IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY3ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY3OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						System.out.println();
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 1 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 1 IAS, due to relay open issue");
					flag = false;
				}
			} else if (flag && eqipmentName.contains("2IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY4ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY4OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 2 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 2 IAS, due to relay open issue");
					flag = false;
				}
			} else if (flag && eqipmentName.contains("3IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY5ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY5OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 3 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 3 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("4IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY6ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY6OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 4 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 4 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("5IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY7ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY7OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 5 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 5 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("6IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY8ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY8OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 6 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 6 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("7IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY9ON").build()).getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY9OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 7 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 7 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("8IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY10ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY10OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 8 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 8 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("9IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY11ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY11OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 9 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 9 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("10IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY12OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 10 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 10 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("11IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY13ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY13OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 11 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 11 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("12IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY14ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY14OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 12 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 12 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("13IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY15ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY15OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 13 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 13 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("14IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY16ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY16OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 14 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 14 IAS, due to relay open issue");
					flag = false;
				}

			} else if (flag && eqipmentName.contains("15IAS")) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY17ON").build())
						.getBoolVal()) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY17OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in 15 IAS, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in 15 IAS, due to relay open issue");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
						"Need to add some sensor, requesting sensor name is not present");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured during arduino interaction , Exception is " + e.getStackTrace());
			flag = false;
		}
		return flag;
	}

	public static boolean resetIAS_OAS(TestCases testCase, int oasCount, int iasCount) {
		boolean flag = false;
		try {
			if (StatCommands.getInstance().cattCommandsStub
					.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build())
					.getBoolVal()) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to find Sensor hardware");
				flag = false;
			}
			if (oasCount > 0) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build()).getBoolVal()) {
					Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset start");
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to do reset in OAS, due to relay open issue");
					flag = false;
				}
			}
			if (iasCount > 0) {
				int x = 3;
				for (int i = 0; i < iasCount; i++) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY" + x + "ON").build())
							.getBoolVal()) {
						x = x + 1;
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset start");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in " + (i + 1) + " IAS, due to relay open issue");
						flag = false;
					}
				}
			}
			Thread.sleep(11000);
			if (oasCount > 0) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2OFF").build())
						.getBoolVal()) {
					Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset Done");
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to do reset in OAS, due to relay close issue");
					flag = false;
				}
			}
			if (iasCount > 0) {
				int x = 3;
				for (int i = 0; i < iasCount; i++) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY" + x + "OFF").build())
							.getBoolVal()) {
						x = x + 1;
						Keyword.ReportStep_Pass(testCase,
								"Successfully Command Sent to Device for " + "Reset Finished");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in " + (i + 1) + " IAS, due to relay close issue");
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to do sensor reset, Due to Exception, Exception message is " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean resetEIM(TestCases testCase) {
		boolean flag = false;
		try {
			if (StatCommands.getInstance().cattCommandsStub
					.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build())
					.getBoolVal()) {
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1ON").build()).getBoolVal()) {
					Thread.sleep(15000);
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY1OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for reset");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to enable pairing mode in EIM, due to relay close issue");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to enable pairing mode in EIM, due to relay open issue");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to find Sensor hardware");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to do sensor reset, Due to Exception, Exception message is " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean resetALLSensor(TestCases testCase, String action) {
		boolean flag = false;
		if (StatCommands.getInstance().cattCommandsStub
				.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build())
				.getBoolVal()) {
			if (StatCommands.getInstance().cattCommandsStub
					.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayON").build()).getBoolVal()) {
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (StatCommands.getInstance().cattCommandsStub
						.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("AllRelayOff").build())
						.getBoolVal()) {
					Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + action);
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to reset to EIM, OAS and IAS due to relay close issue");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Not able to reset to EIM, OAS and IAS, due to relay open issue");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to reset Sensor hardware");
			flag = false;
		}
//		try {
////			Thread.sleep(20000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return flag;

	}

	public static boolean resetIAS_OASWithContinueFlow(TestCases testCase, boolean needToDeleteTogether, int oasCount,
			int iasCount) {
		boolean flag = false;
		try {
			if (StatCommands.getInstance().cattCommandsStub
					.pingArduino(ArduinoRelayFunction.newBuilder().setRequest(RequestType.DIY_Request).build())
					.getBoolVal()) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to find Sensor hardware");
				flag = false;
			}

			if (needToDeleteTogether) {
				if (oasCount > 0) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset start");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in OAS, due to relay open issue");
						flag = false;
					}
				}
				if (iasCount > 0) {
					int x = 3;
					for (int i = 0; i < iasCount; i++) {
						if (StatCommands.getInstance().cattCommandsStub
								.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY" + x + "ON").build())
								.getBoolVal()) {
							x = x + 1;
							Keyword.ReportStep_Pass(testCase,
									"Successfully Command Sent to Device for " + "Reset start");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to do reset in " + (i + 1) + " IAS, due to relay open issue");
							flag = false;
						}
					}
				}
				Thread.sleep(11000);
				if (oasCount > 0) {
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset Done");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in OAS, due to relay close issue");
						flag = false;
					}
				}
				if (iasCount > 0) {
					int x = 3;
					for (int i = 0; i < iasCount; i++) {
						if (StatCommands.getInstance().cattCommandsStub.changeT10PlusDIYArduinoRelayStatus(
								String_Msg.newBuilder().setStrVal("RELAY" + x + "OFF").build()).getBoolVal()) {
							x = x + 1;
							Keyword.ReportStep_Pass(testCase,
									"Successfully Command Sent to Device for " + "Reset Finished");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to do reset in " + (i + 1) + " IAS, due to relay close issue");
							flag = false;
						}
					}
				}
			} else {

				if (oasCount > 0) {

					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2ON").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset start");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in OAS, due to relay open issue");
						flag = false;
					}
					Thread.sleep(15000);
					if (StatCommands.getInstance().cattCommandsStub
							.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY2OFF").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Successfully Command Sent to Device for " + "Reset Done");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Not able to do reset in OAS, due to relay close issue");
						flag = false;
					}
				}

				if (oasCount > 0 && iasCount > 0) {
					Thread.sleep(30000);
				}
				if (iasCount > 0) {
					int x = 3;
					for (int i = 0; i < iasCount; i++) {
						if (StatCommands.getInstance().cattCommandsStub
								.changeT10PlusDIYArduinoRelayStatus(String_Msg.newBuilder().setStrVal("RELAY" + x + "ON").build())
								.getBoolVal()) {
							Keyword.ReportStep_Pass(testCase,
									"Successfully Command Sent to Device for " + "Reset start");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to do reset in " + (i + 1) + " IAS, due to relay open issue");
							flag = false;
						}
						Thread.sleep(15000);
						if (StatCommands.getInstance().cattCommandsStub.changeT10PlusDIYArduinoRelayStatus(
								String_Msg.newBuilder().setStrVal("RELAY" + x + "OFF").build()).getBoolVal()) {
							x = x + 1;
							Keyword.ReportStep_Pass(testCase,
									"Successfully Command Sent to Device for " + "Reset Finished");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to do reset in " + (i + 1) + " IAS, due to relay close issue");
							flag = false;
						}
						Thread.sleep(30000);
					}
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to do sensor reset, Due to Exception, Exception message is " + e.getMessage());
			flag = false;
		}
		return flag;
	}

}