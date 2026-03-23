package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.app.PrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.FADeviceDetailsUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class VerifyThermostatConfiguration extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyThermostatConfiguration(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing precondition </b>");
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DEVICE DETAILS");
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.toString());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

//	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	@Given(value = "^user verifies thermostat configuration as (.+) with (.+) heat and (.+) cool stages in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies thermostat configuration as (.+) with (.+) heat and (.+) cool stages in FA App$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {

			String systemType = exampleData.get(0);
			String heatStages = exampleData.get(1);
			String coolStages = exampleData.get(2);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				flag = FADeviceDetailsUtils.isDeviceConfiguration_Valid(testCase, systemType, heatStages, coolStages);
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e);
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		return flag;
	}
}
