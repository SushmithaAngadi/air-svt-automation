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
import com.honeywell.utils.firstAlertapp.screen.FAPrimaryCardScreen;

import cucumber.api.java.en.Given;

public class ModifiesSetpointLimitsinFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	public TestCaseInputs inputs;

	public ModifiesSetpointLimitsinFA(TestCases testcase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testcase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing PreCondition");

			if (NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "SETPOINT LIMITS")) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Navigating to Setpoint Limit Screen");
				System.out.println("Navigating to Setpoint Limit Screen");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to Navigate to Setpoint Limit Screen.");

			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;

	}

	// When user modifies "HEAT" setpoint "MAX" limit is "86" in FA APP

	@Given(value = "^user modifies (.+) setpoint (.+) limit is (.+) in FA APP$")
	@Override
	@KeywordStep(gherkins = "^user modifies (.+) setpoint (.+) limit is (.+) in FA APP$")
	public boolean keywordSteps() throws KeywordException {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing Keyword steps");
			try {
				String systemType = exampleData.get(0).trim().toUpperCase();
				String max_min = exampleData.get(1).trim().toUpperCase();
				String setpoint = exampleData.get(2).trim();

				FAPrimaryCardScreen pm = new FAPrimaryCardScreen(testCase);

				flag = FAPrimaryCardUtils.modifySetpointLimitsinFAApp(testCase, inputs, systemType, max_min, setpoint);
				System.out.println("Executed modifying keyword");

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Verify setpoint limit button failed on keyword steps due to Exception : " + e.getMessage());
			}
			return flag;

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
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing PostCondition");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

}
