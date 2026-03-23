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
import com.honeywell.utils.firstAlertapp.FAVacationUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Then;

public class WaitForVacationToStartEnd extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public WaitForVacationToStartEnd(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			try {
				if (NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "VACATION SETTING")) {
					if (FAVacationUtils.isVacationOn(testCase)) {
						if (NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"not able to navigate to primarycard");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Vacation is off, so no need to further continue, precondition is vacation should be ON before this keyword....");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"not able to navigate to Vacation settings");
					flag = false;
				}

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Navigate / confirm vacation screen failed due to Exception : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Then(value = "^user wait for (.+) to (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user wait for (.+) to (.+) in FA App$")
	public boolean keywordSteps() throws KeywordException {
		String function = exampleData.get(0).toUpperCase();
		String start_End = exampleData.get(1).toUpperCase();
		if (testCase.isTestSuccessful()) {
			try {
				if (function.contains("VACATION")) {
					flag = FAVacationUtils.waitForVacationToStart_or_End(testCase, start_End);
				} else {
					flag = false;
					ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Keyword failed due to function not matching with the requirement:" + function);
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
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
		Keyword.ReportStep_Pass(testCase, "Executed Post Condition");
		return flag;
	}
}