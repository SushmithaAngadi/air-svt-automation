package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import cucumber.api.java.en.Then;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;


public class VerifyOverallIaqLevelInFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyOverallIaqLevelInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
			Keyword.ReportStep_Pass(testCase, "<b>Executing PreCondition</b>");
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "IAQ");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"ModifyFanMode Pre condition failed due to Exception : " + e.getMessage());
			}
		return flag;
	}
	
	/**
	 * And user checks the displayed IAQ level in FA App should be "Great"
	   And user checks the displayed IAQ level in FA App should be "Good"
	   And user checks the displayed IAQ level in FA App should be "Fair"
	   And user checks the displayed IAQ level in FA App should be "Poor"
	   And user checks the displayed IAQ level in FA App should be "Very Poor"
	 */
	
	@Then(value = "^user checks the displayed IAQ level in FA App should be (.+)$")
	@Override
	@KeywordStep(gherkins = "^user checks the displayed IAQ level in FA App should be (.+)$")
	public boolean keywordSteps() {
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keywordstep</b>");
			try {
				String expectedIaqLevel = exampleData.get(0);
				flag = FAPrimaryCardUtils.verifyOverallIAQLevel(testCase, expectedIaqLevel);
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Error Occured : " + e.getMessage());
			}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
			ReportStep_Pass(testCase, "VerifyOverallIaqLevelInFA : Keyword successfully executed");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}
}