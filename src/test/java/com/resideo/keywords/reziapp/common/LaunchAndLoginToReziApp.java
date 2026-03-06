package com.resideo.keywords.reziapp.common;

import java.io.File;
import java.io.PrintWriter;

import com.resideo.utils.api.device_Information.*;
import com.resideo.utils.api.dfc.CHILUtil;
import com.resideo.utils.resideo_app.LyricUtils;
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

import io.cucumber.java.en.Given;

public class LaunchAndLoginToReziApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public LaunchAndLoginToReziApp(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
//			Thread.sleep(120000);
			SystemState.getStatus().initforResideoProWithResieoHome();
//			inputs.setInputValue("COLLECT_LOGS", "true");
			System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "CHOOSE_APP_NEED_TO_INSTALL", "RESIDEO_PRO"));
			
			
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

	@Given(value = "^user launches and logs in to the Rezi APP$")
	@Override
	@KeywordStep(gherkins = "^user launches and logs in to the Rezi APP$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			try {
				String userName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CONTRACTOR_USERNAME");
				String password = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CONTRACTOR_PASSWORD");
				flag = flag && LyricUtils.launchAndLoginToReziApplication(testCase, inputs,userName,password);
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Excution Blocked due to Exception, Exception message is :" + e.getMessage());
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
		if (flag) {
			ReportStep_Pass(testCase, "Sucessfully login into Rezi App");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

}
