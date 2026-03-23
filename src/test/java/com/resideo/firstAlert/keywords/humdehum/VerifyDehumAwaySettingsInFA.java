package com.honeywell.keywords.firstAlertapp.humdehum;

import java.util.ArrayList;
import cucumber.api.java.en.When;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAHumDehumVentUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

public class VerifyDehumAwaySettingsInFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyDehumAwaySettingsInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing PreCondition</b>");
		if (testCase.isTestSuccessful()) {
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Navigate or confirm primary card screen failed due to Exception : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario or Keyword steps failed.");
		}
		Keyword.ReportStep_Pass(testCase, "<b>Executed PreCondition</b>");
		return flag;
	}
	/**
	And user verifies Dehumidification Away Mode "System Mode" as "Cool" in FA App
	And user verifies Dehumidification Away Mode "Fan Mode" as "Auto" in FA App
	And user verifies Dehumidification Away Mode "Dehumidification Setpoint" as "60" in FA App
	And user verifies Dehumidification Away Mode "Cool Setpoint" as "75" in FA App
	**/
	
	@When(value = "^user verifies Dehumidification Away Mode (.+) as (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies Dehumidification Away Mode (.+) as (.+) in FA App$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
		if (testCase.isTestSuccessful()) {
			try {
				String expectedType = exampleData.get(0);
				String expectedValue = exampleData.get(1);
				if (FAHumDehumVentUtils.verifyDehumAwayModeSettingsInFA(testCase, expectedType,
						expectedValue)) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully Verified " + expectedType + " as: " + expectedValue);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Mismatch between the app and stat, " + expectedType + " is : " + expectedValue);
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
						"Exception occured due to " + e.getMessage());
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}
}