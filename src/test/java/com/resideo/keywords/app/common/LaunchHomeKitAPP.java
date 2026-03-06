package com.resideo.keywords.app.common;

import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommonCommandUtils;

import io.cucumber.java.en.Given;

public class LaunchHomeKitAPP extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public LaunchHomeKitAPP(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "CHOOSE_APP_NEED_TO_INSTALL", "HOMEKIT"));
			SystemState.getStatus().initForDiy();
		} catch (Exception e) {
		}
		return flag;
	}

	@Given(value = "^user launches Home Kit application$")
	@Override
	@KeywordStep(gherkins = "^user launches Home Kit application$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			LyricUtils.launchApplication(testCase, inputs);
//			HomeKitUtils.location(testCase);
//			SystemState.getStatus().getLast6CharDeviceMacID("2C58DF");
//			CustomDriver driver = testCase.getMobileDriver();
//			driver.activateApp("com.apple.Home");
//			closeApp();
//			driver.activateApp("com.resideo.acs.lyric.enterprise");
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
		StatCommonCommandUtils.get6CharMacId();
		return flag;
	}

}
