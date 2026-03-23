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
import com.honeywell.utils.app.Modify_Verify_ThermostatSystem_FanModeUtils;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class ModifyAdaptiveRecoveryinFA extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public ModifyAdaptiveRecoveryinFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre Condition</b>");
		if (testCase.isTestSuccessful() && flag) {
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"VerifyFanMode Pre condition failed due to Exception : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^user set adaptive recovery (.+) from FA APP$")
	@Override
	@KeywordStep(gherkins = "^user set adaptive recovery (.+) from FA APP$")
	public boolean keywordSteps() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (testCase.isTestSuccessful() && flag) {
			String on_off = exampleData.get(0).toUpperCase();
			flag = FAPrimaryCardUtils.ModifyAdptiveRecovery(testCase, on_off);
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
		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
		return flag;
	}
}
