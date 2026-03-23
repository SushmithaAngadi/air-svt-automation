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

public class VerifiesAdaptiveRecoveryinFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	public TestCaseInputs inputs;

	public VerifiesAdaptiveRecoveryinFA(TestCases testcase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		super("VerifiesAdaptiveRecovery");
		this.testCase = testcase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing PreCondition");
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Verifying Adptive Recovery screen o precondition failed : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;

	}

	@Given(value = "^user verify adaptive recovery status as (.+) in FA APP$")
	@Override
	@KeywordStep(gherkins = "^user verify adaptive recovery status as (.+) in FA APP$")
	public boolean keywordSteps() throws KeywordException {

		try {
			if (testCase.isTestSuccessful()) {
				Keyword.ReportStep_Pass(testCase, "Executing Keyword steps");
					flag = FAPrimaryCardUtils.VerifyAdptiveRecovery(testCase, exampleData.get(0).toUpperCase());

			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
			return flag;

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Verify adaptive recovery button failed on keyword steps due to Exception : " + e.getMessage());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful()) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;

	}

}
