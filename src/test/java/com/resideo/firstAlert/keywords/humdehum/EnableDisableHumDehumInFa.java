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

public class EnableDisableHumDehumInFa extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String enableDisable;
	String humDehum;

	public EnableDisableHumDehumInFa(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing preCondition</b>");
		if (testCase.isTestSuccessful() && flag) {
			Keyword.ReportStep_Pass(testCase, "successfully verified preCondition");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
	
	/** When user sets "Humidification" status to "Enable" in the FA App
		When user sets "Humidification" status to "Disable" in the FA App
		When user sets "Dehumidification" status to "Enable" in the FA App
		When user sets "Dehumidification" status to "Disable" in the FA App
	**/

	@Given(value = "^user sets (.+) status to (.+) in the FA App$")
	@Override
	@KeywordStep(gherkins = "^user sets (.+) status to (.+) in the FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
			try {
				humDehum = exampleData.get(0);
				enableDisable = exampleData.get(1);
				if (FAHumDehumVentUtils.enableDisableHumDehumInFA(testCase, humDehum, enableDisable)) {
					Keyword.ReportStep_Pass(testCase,
							"Successfully set stat " + humDehum + " status to: " + enableDisable);
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Unable to set stat " + humDehum + " status to: " + enableDisable);
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
			Keyword.ReportStep_Pass(testCase, "<b>Executing postCondition for the class: EnableDisableHumDehumInFa</b>");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

}