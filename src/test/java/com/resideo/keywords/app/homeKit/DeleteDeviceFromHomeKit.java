package com.resideo.keywords.app.homeKit;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.HomeKitUtils;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset.ResetMode;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class DeleteDeviceFromHomeKit extends Keyword {

	private TestCases testCase;

	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	String deviceName;
	public boolean flag = true;

	public DeleteDeviceFromHomeKit(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
//			SystemState.getStatus().getLast6CharDeviceMacID("");
			flag = HomeKitUtils.navigateToHomeKitPrimaryCard(testCase);
			try {
				deviceName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim();
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^delete device from homekit$")
	@Override
	@KeywordStep(gherkins = "^delete device from homekit$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			flag = HomeKitUtils.deleteDeviceInHomeKit(testCase, deviceName);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful()) {
			if (HomeKitUtils.isDeviceExist(testCase)) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Device is visible in Homekit app dashboard after delete, wait time 10 seconds");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		try {
			if (!testCase.isTestSuccessful() && SystemState.getStatus().isStationMode()) {
				if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.contains("JASPER")) {
					if (StatCommands.getInstance().cattCommandsStub
							.jasperHomeKitResetUI(String_Msg.newBuilder().setStrVal("RESET_HOMEKIT").build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Home kit reset successful");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								" Homekit reset failed ");
						flag = false;
					}
				} else if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.contains("THOR")) {
					if (StatCommands.getInstance().cattCommandsStub
							.unCheckReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_HOMEKIT_RESET).build())
							.getBoolVal()) {
						Keyword.ReportStep_Pass(testCase, "Home kit reset successful");
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								" Homekit reset failed ");
						flag = false;
					}
				}
			}
		} catch (Exception e) {
		}
		return flag;
	}
}
