package com.resideo.keywords.app.common;

import java.io.File;
import java.io.PrintWriter;

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

import io.cucumber.java.en.Given;

public class LaunchHHApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public LaunchHHApp(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT,
					"CHOOSE_APP_NEED_TO_INSTALL", "HONEYWELL_HOME"));
			SystemState.getStatus().initforCaspianDiy();
			SystemState.getStatus().initForDiy();

//			inputs.setInputValue("COLLECT_LOGS", "true");
			if (inputs.isInputAvailable("COLLECT_LOGS")) {
				if (inputs.getInputValue("COLLECT_LOGS").equalsIgnoreCase("true")) {
					File appiumLogFile = new File(SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
							"APPIUM_LOG_FILE_PATH"));
					PrintWriter writer = new PrintWriter(appiumLogFile);
					writer.print("");
					writer.close();
				}
			}
		} catch (Exception e) {
		}
		return flag;
	}

	@Given(value = "user launches Honeywell Home application")
	@Override
	@KeywordStep(gherkins = "^user launches Honeywell Home application$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			LyricUtils.launchApplication(testCase, inputs);
//			HomeKitUtils.location(testCase);
			SystemState.getStatus().getLast6CharDeviceMacID("2C58DF");
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

		return flag;
	}

}
