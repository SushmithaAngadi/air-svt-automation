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

public class SetWindowProtectionLevelInFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String level;

	public SetWindowProtectionLevelInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing preCondition</b>");
		if (testCase.isTestSuccessful()) {
			flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "HUMIDIFICATION");
			Keyword.ReportStep_Pass(testCase, "Successfully verified preCondition");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
	
	/** When user modifies Window Protection level to "1" from FA App
	 * 	When user modifies Window Protection level to "10" from FA App
	**/

	@Given(value = "^user modifies Window Protection level to (.+) from FA App$")
	@Override
	@KeywordStep(gherkins = "^user modifies Window Protection level to (.+) from FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
			try {
				level = exampleData.get(0);
				if (FAHumDehumVentUtils.modifyWindowProtectionLevelInFA(testCase, Integer.parseInt(level))) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully set stat Window Protection level to " + level);
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Unable to set stat Window Protection level to " + level);
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
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing postCondition for the class: SetWindowProtectionLevelInFA</b>");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

}