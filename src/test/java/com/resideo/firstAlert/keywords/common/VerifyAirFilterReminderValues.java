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

import cucumber.api.java.en.Then;

public class VerifyAirFilterReminderValues extends Keyword {

	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public VerifyAirFilterReminderValues(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre-Condition</b>");
		if (testCase.isTestSuccessful()) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(),
					"REMINDER MANAGEMENT");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	// Then user verifies "Air Filter Reminder 1" displays "10" "Run Time Days" in FA App

	@Then(value = "^user verifies (.+) displays (.+) (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies (.+) displays (.+) (.+) in FA App$")
	public boolean keywordSteps() {
		String filterName = exampleData.get(0).toUpperCase();
		String filterValue = exampleData.get(1).toUpperCase();
		String timeUnit = exampleData.get(2).toUpperCase();
		try {
			if (testCase.isTestSuccessful()) {
				flag = FA_AlertUtils.verifyAirFilterReminder(testCase, filterName, filterValue, timeUnit);
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
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
		if (testCase.isTestSuccessful()) {
			if (flag) {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}
		}
		return flag;
	}
}