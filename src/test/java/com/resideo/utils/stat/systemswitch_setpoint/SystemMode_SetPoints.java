package com.resideo.utils.stat.systemswitch_setpoint;

import java.time.Duration;

import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg;
import com.resideo.utils.stat.cattgrpccommands.SystemSwitchMsg;
import com.resideo.utils.stat.cattgrpccommands.SetPointMsg.SetPoint;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.SystemSwitchMsg.SystemSwitch;

public class SystemMode_SetPoints {

	public static boolean changeSetPoint(TestCases testCase, String mode, String setPoint) {
		boolean flag = false;
		float val = Float.parseFloat(setPoint);

		if (mode.toUpperCase().equalsIgnoreCase("HEAT")) {
			StatCommands.getInstance().cattCommandsStub.setSystemSwitch(
					SystemSwitchMsg.newBuilder().setSwitch(SystemSwitch.valueOf(mode.trim().toUpperCase())).build());
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_HEAT).setVal(val).build());
			Keyword.ReportStep_Pass(testCase, "Stat Set Point is set to " + val);
			flag = true;

		} else if (mode.toUpperCase().equalsIgnoreCase("COOL")) {
			StatCommands.getInstance().cattCommandsStub.setSystemSwitch(
					SystemSwitchMsg.newBuilder().setSwitch(SystemSwitch.valueOf(mode.trim().toUpperCase())).build());
			StatCommands.getInstance().cattCommandsStub
					.setSetpoint(SetPointMsg.newBuilder().setType(SetPoint.SETPOINT_COOL).setVal(val).build());
			Keyword.ReportStep_Pass(testCase, "Stat Set Point is set to " + val);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Invalid Keyword Input");
			flag = false;
		}

		return flag;
	}

	public static boolean changeSystemMode(TestCases testCase, String mode) {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			if (mode.toUpperCase().equalsIgnoreCase("HEAT")) {
				

				StatCommands.getInstance().cattCommandsStub.setSystemSwitch(SystemSwitchMsg.newBuilder()
						.setSwitch(SystemSwitch.valueOf(mode.trim().toUpperCase())).build());
				Keyword.ReportStep_Pass(testCase, "Stat System mode changed to " + mode);
				flag = true;

			} else if (mode.toUpperCase().equalsIgnoreCase("COOL")) {
				StatCommands.getInstance().cattCommandsStub.setSystemSwitch(SystemSwitchMsg.newBuilder()
						.setSwitch(SystemSwitch.valueOf(mode.trim().toUpperCase())).build());
				Keyword.ReportStep_Pass(testCase, "Stat System mode changed to " + mode);
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Invalid Keyword Input");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured in SystemMode_SetPoints.class, Method> changeSystemMode(), Due to "
							+ e.getMessage());
		}
		return flag;

	}

	public static boolean verifySystemMode(TestCases testCase, String mode) {
		boolean flag = false;
		System.out.println("Verify System mode from stat is " + mode);
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(flag);
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofSeconds(30));
		boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean flag1) {
				try {
					String systemSwitch = StatCommands.getInstance().cattCommandsStub
							.getSystemSwitch(String_Msg.newBuilder().build()).toString();
					if (systemSwitch.trim().toUpperCase().contains(mode.trim().toUpperCase())) {
						Keyword.ReportStep_Pass(testCase, "System mode working as expected, Running mode is " + mode);
						return true;
					} else {
						return false;
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised due to " + e.getMessage());
					return false;

				}
			}
		});
		if (isEventReceived) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"System Mode not sync between app and stat, Expected mode is " + mode);
			flag = false;
		}
		return flag;
	}

	public static boolean verifySetpoint(TestCases testCase, String mode, String expectedsetpoint) {
		boolean flag = false;

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(flag);
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofSeconds(30));
		boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean flag1) {
				try {
					SetPoint controlMessage = null;

					if (mode.trim().toUpperCase().contains("HEAT")) {
						controlMessage = SetPoint.CONTROL_SETPOINT_HEAT;
					} else {
						controlMessage = SetPoint.CONTROL_SETPOINT_COOL;
					}
					float setpoint = StatCommands.getInstance().cattCommandsStub
							.getSetpoint(SetPointMsg.newBuilder().setType(controlMessage).build()).getFloatVal();
					if (setpoint == Float.valueOf(expectedsetpoint)) {
						Keyword.ReportStep_Pass(testCase,
								"Expected setpoint sucessfully sync between stat and App, Setpoint is " + setpoint);
						return true;

					} else {
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to +" + e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"System Setpoint not sync between app and stat, Expected setpooint is " + expectedsetpoint);
			flag = false;
		}
		return flag;
	}
}
