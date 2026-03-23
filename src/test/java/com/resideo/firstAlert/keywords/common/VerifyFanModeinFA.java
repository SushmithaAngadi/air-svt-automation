package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import cucumber.api.java.en.When;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.firstAlertapp.screen.NavigatingScreenToScreeninFA;


public class VerifyFanModeinFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyFanModeinFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing PreCondition</b>");
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"ModifyFanMode Pre condition failed due to Exception : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@When(value = "^user verifies fan mode is set to (.+) in FA APP$")
	@Override
	@KeywordStep(gherkins = "^user verifies fan mode is set to (.+) in FA APP$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keywordstep</b>");
			try {
				String expectedMode = exampleData.get(0);
				flag = FAPrimaryCardUtils.verifyCurrentFanMode(expectedMode.toUpperCase(), testCase);
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Error Occured : " + e.getMessage());
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
		if (testCase.isTestSuccessful() && flag) {
			ReportStep_Pass(testCase, "VerifyFanMode : Keyword successfully executed");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		} else {
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "VerifyFanMode : Keyword failed during execution");
		}
		return flag;
	}
}
