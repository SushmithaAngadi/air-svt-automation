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

import cucumber.api.java.en.Given;

public class VerifyAvailableSystemModes extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public VerifyAvailableSystemModes(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre_Condition</b>");
		if (testCase.isTestSuccessful()) {
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"ModifySystemMode Pre condition failed due to Exception : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

//	user verifies available system modes are "Heat, Cool, Off, Auto" in FA App
	@Given(value = "^user verifies available system modes are (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies available system modes are (.+) in FA App$")
	public boolean keywordSteps() throws KeywordException {

		Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
		if (testCase.isTestSuccessful()) {
			String[] expectedSystemModes=null;
			String options = exampleData.get(0).toUpperCase();
			if(options.contains(",")) {
				expectedSystemModes= options.split(",");
			}else if(options.contains("_")) {
				expectedSystemModes= options.split("_");
			}
			try {
				flag = flag && FAPrimaryCardUtils.verifySystemModeOptions(testCase, expectedSystemModes);
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
