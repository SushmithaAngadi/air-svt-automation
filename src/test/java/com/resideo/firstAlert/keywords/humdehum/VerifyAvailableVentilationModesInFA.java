package com.honeywell.keywords.firstAlertapp.humdehum;

import java.util.ArrayList;
import cucumber.api.java.en.Then;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAHumDehumVentUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

public class VerifyAvailableVentilationModesInFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public VerifyAvailableVentilationModesInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "VENTILATION");
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
	Then user verifies ventilation modes are "Auto, On, Off" in FAApp
	**/
	
	@Then(value = "^user verifies ventilation modes are (.+) in FAApp$")
	@Override
	@KeywordStep(gherkins = "^user verifies ventilation modes are (.+) in FAApp$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
		if (testCase.isTestSuccessful()) {
			String[] expectedSystemModes = null;
			String options = exampleData.get(0).toUpperCase();
			if (options.contains(",")) {
				expectedSystemModes = options.split(",");
			} else if (options.contains("_")) {
				expectedSystemModes = options.split("_");
			}
			try {
				flag = flag && FAHumDehumVentUtils.verifyVentModeOptions(testCase, expectedSystemModes);
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