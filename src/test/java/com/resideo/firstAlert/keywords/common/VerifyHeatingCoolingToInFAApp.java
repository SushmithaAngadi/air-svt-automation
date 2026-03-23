package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Then;

public class VerifyHeatingCoolingToInFAApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public VerifyHeatingCoolingToInFAApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre_Condition</b>");
		if (testCase.isTestSuccessful()) {
			flag = true;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

//	Then user verifies "Heating To" text in "PrimaryCard and DashBoard" in FA App
//	Then user verifies "Cooling To" text in "PrimaryCard and DashBoard" in FA App
//	Then user verifies "Cooling To" text in "PrimaryCard" in FA App
//	Then user verifies "Heating To" text in "DashBoard" in FA App

	@Then(value = "^user verifies (.+) in (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies (.+) in (.+) in FA App$")
	public boolean keywordSteps() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
		if (testCase.isTestSuccessful()) {
			String coolingorHeatingText = exampleData.get(0).toUpperCase();
			String verifyFrom = exampleData.get(1).toUpperCase();
			try {
				flag = FAPrimaryCardUtils.verifyHeatingOrCoolingText(testCase, coolingorHeatingText, verifyFrom);
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}

}
