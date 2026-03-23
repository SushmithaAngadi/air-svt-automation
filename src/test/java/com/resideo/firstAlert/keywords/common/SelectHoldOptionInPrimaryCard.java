package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
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

public class SelectHoldOptionInPrimaryCard extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String holdtype;

	public SelectHoldOptionInPrimaryCard(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		holdtype = exampleData.get(0).toUpperCase();
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(),
				"PRIMARY CARD");

		return flag;
	}

//	Then user selects "PERMANENTLY" option in Primary card of FA App
//	Then user verifies "REMOVE HOLD" label in Primary card of FA App

	@Given(value = "^user selects (.+) option in Primary card of FA App$")
	@Override
	@KeywordStep(gherkins = "^user selects (.+) option in Primary card of FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = flag && FAPrimaryCardUtils.selectHoldOption(testCase, holdtype);
				TimeUnit.SECONDS.sleep(5);
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(),
				"DASHBOARD");
		return flag;
	}
}
