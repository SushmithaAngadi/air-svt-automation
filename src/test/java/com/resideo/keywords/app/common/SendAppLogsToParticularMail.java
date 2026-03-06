package com.resideo.keywords.app.common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideo_app.NavigateToAnyScreen;
import com.resideo.utils.resideo_app.SendAppLogUtils;

import io.cucumber.java.en.Then;

public class SendAppLogsToParticularMail extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public SendAppLogsToParticularMail(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}
	  
	@Then(value = "^Send App Log to (.+) ,If Testcase was (.+)$")
	@Override
	@KeywordStep(gherkins = "^Send App Log to (.+) ,If Testcase was (.+)$")
	public boolean keywordSteps() {
		String logMode = exampleData.get(1);
		String to_MailID = exampleData.get(0);
		if (SystemState.getStatus().isPreviousTrailFailed() && logMode.contains("FAILED")) {
			try {
				if (testCase.getPlatform().toUpperCase().contains("IOS")) {
					SendAppLogUtils.sendiOSAppLog(testCase, inputs, to_MailID);
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			}

		} else if(testCase.isTestSuccessful() ) {
			ReportStep_Pass(testCase, "App Log Skipping Due to Previous Testcase Passed");
			
			flag = true;
		}else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		SystemState.getStatus().isPreviousTrailFailed(false);
		NavigateToAnyScreen.navigateFromAnyScreenToExpectScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}

}