package com.honeywell.keywords.firstAlertapp.humdehum;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAHumDehumVentUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class VerifyWindowProtectionLevelInFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String expLevel;

	public VerifyWindowProtectionLevelInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing preCondition</b>");
		if (testCase.isTestSuccessful() && flag) {
			flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "HUMIDIFICATION");
			Keyword.ReportStep_Pass(testCase, "Successfully verified preCondition");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
	
	/** Then user verifies Window Protection level value "1" in FA App
	 * 	Then user verifies Window Protection level value "10" in FA App
	**/

	@Given(value = "^user verifies Window Protection level value (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies Window Protection level value (.+) in FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
			try {
				expLevel = exampleData.get(0);
				if (FAHumDehumVentUtils.verifyWindowProtectionLevelInFA(testCase, Integer.parseInt(expLevel))) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully verified stat Window Protection level as " + expLevel);
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Mismatch in the stat Window Protection level expected is: " + expLevel);
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occurred due to " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful() & flag) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing postCondition for the class: VerifyWindowProtectionLevelInFA</b>");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

}