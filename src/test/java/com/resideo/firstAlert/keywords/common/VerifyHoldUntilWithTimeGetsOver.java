package com.honeywell.keywords.firstAlertapp.common;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import cucumber.api.java.en.Given;

public class VerifyHoldUntilWithTimeGetsOver extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	private TestCaseInputs inputs;
	String holdtype;

	public VerifyHoldUntilWithTimeGetsOver(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
				"PRIMARY CARD");

		return flag;
	}

//	Then wait for the current hold to get over

	@Given(value = "^wait for the current hold to get over$")
	@Override
	@KeywordStep(gherkins = "^wait for the current hold to get over$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = flag && FAPrimaryCardUtils.setHoldUntilWithSpecificTimeAndVerify(testCase);
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Exception occured in, Due to " + e);
				flag = false;
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
				"DASHBOARD");
		return flag;
	}
}
