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
import com.honeywell.utils.app.LyricUtils;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

public class ModifySystemModeinFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public ModifySystemModeinFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
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

	@When(value = "^user changes system mode to (.+) in FA APP and (.+) changes$")
	@Override
	@KeywordStep(gherkins = "^user changes system mode to (.+) in FA APP and (.+) changes$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
		if (testCase.isTestSuccessful()) {
			try {
				String mode = exampleData.get(0);
				flag = FAPrimaryCardUtils.ChangeSystemSwitch(testCase, mode.toUpperCase());

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
