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

public class EnableDisableFilterReminderNotification extends Keyword {

	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = false;
	ArrayList<String> exampleData;
	public boolean enableState;

	public EnableDisableFilterReminderNotification(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(),
					"REMINDER MANAGEMENT");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}
	
	//Then user verifies "Air Filter Reminder 1" push notification "Enabled" in FA App
	
	@Given(value = "^user verifies (.+) push notification (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies (.+) push notification (.+) in FA App$")
	public boolean keywordSteps() {
		String filterName = exampleData.get(0).toUpperCase();
		if (exampleData.get(1).toUpperCase().contains("ENABLE")) {
			enableState = true;
		} else {
			enableState = false;
		}
		try {
			if (testCase.isTestSuccessful()) {
				flag = FA_AlertUtils.enableDisableFilterPushNotification(testCase, filterName, enableState);
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}
		} catch (Exception e) {
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
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		}
		return flag;
	}
}
