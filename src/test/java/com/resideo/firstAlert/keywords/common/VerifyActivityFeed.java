package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FA_AlertUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class VerifyActivityFeed extends Keyword {

	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;
	private boolean isAlertVerified = false;

	public VerifyActivityFeed(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		System.out.println("started pre condition");
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre-Condition</b>");

		if (testCase.isTestSuccessful()) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}
	
	//user verifies <alert> alert in "Dashboard" of FA App
	
	@Given(value = "^user verifies (.+) alert in (.+) of FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies (.+) alert in (.+) of FA App$")
	public boolean keywordSteps() {
		String AlertMsg = exampleData.get(0).toUpperCase();
		String verifyFrom = exampleData.get(1).toUpperCase();
		try {
			if (testCase.isTestSuccessful()) {
				isAlertVerified = FA_AlertUtils.VerifyAlertMessage(testCase, AlertMsg, verifyFrom);
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception raised : " + e.getMessage());
		}
		return isAlertVerified;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
		if (testCase.isTestSuccessful()) {
			if (isAlertVerified) {
				flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}
		}
		return flag;
	}
}
