package com.resideo.keywords.app.homeKit;

import java.time.Duration;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.HomeKitUtils;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;

import io.cucumber.java.en.Given;

public class ChooseLocationDeviceNameToComplete extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	public boolean flag = true;
	String deviceNeedToInstall;

	public ChooseLocationDeviceNameToComplete(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			homeKit = new HomeKitScreen(testCase);
			try {
				deviceNeedToInstall = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
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

	@Given(value = "^select default location and device name, complete accessory setup$")
	@Override
	@KeywordStep(gherkins = "^select default location and device name, complete accessory setup$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			if (deviceNeedToInstall.contains("THOR") || deviceNeedToInstall.contains("FLYCATCHER")) {
				flag = HomeKitUtils.enrollHomekit_ThermostatName_andSensorName(testCase, homeKit,
						Duration.ofMinutes(15));
			} else {
//				flag = HomeKitUtils.selectLocationAndDeviceNameFinalize(testCase, homeKit);
				flag = HomeKitUtils.enrollHomekit_ThermostatName_andSensorName(testCase, homeKit, Duration.ofMinutes(5));
			}
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

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;

	}

}
