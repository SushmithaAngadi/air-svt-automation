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

public class LaunchAndLoginToResideoApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public LaunchAndLoginToResideoApp(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
//			Thread.sleep(50000);
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

	@Given(value = "user launches and logs in to the Resideo application")
	@Override
	@KeywordStep(gherkins = "^user launches and logs in to the Resideo application$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			flag = flag && LyricUtils.launchAndLoginToApplication(testCase, inputs);
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

//		NavigateToAnyScreen.sampletester(testCase);

//		String[] arr = {"ADD NEW DEVICE SCREEN","PRIMARYCARD","MANAGE ALERT","ADDRESS SETTING","THERMOSTAT SETTING","MODE SETTING","FAN SETTING","HAMBERGER MENU","MODE SETTING","THERMOSTAT SETTING","PRIMARYCARD","ABOUT THE APP","","SLEEP BRIGHTNESS","CONNECTED SERVICE","VACATION SETTING","THERMOSTAT CONFIGURATION","PRIMARYCARD","MODE SETTING","ACCOUNT DETAILS","SLEEP BRIGHTNESS"};
//		
//		for (int i = 0; i < arr.length; i++) {
//			NavigateToAnyScreen.navigateFromAnyScreenToExpectScreen(testCase, inputs, arr[i]);
//		}
//		
//		
//		SystemState.getStatus().setTstatName("Tstat 31AD74");

		return flag;
	}

}
