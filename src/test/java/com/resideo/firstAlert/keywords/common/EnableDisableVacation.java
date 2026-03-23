package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAVacationUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.When;

public class EnableDisableVacation extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String on_off = null;
	String default_nonDefault = null;
	String screenName = null;

	public EnableDisableVacation(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing Pre condition:");
			flag = true;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
//  When user "enable" vacation with "default" settings from "Vacation" screen in FA app
//	When user "enable" vacation with "non default" settings from "Vacation" screen in FA app
//	When user "disable" vacation with "default" settings from "Vacation" screen in FA app
//	When user "disable" vacation with "default" settings from "Primary Card" screen in FA app
//	When user "disable" vacation with "default" settings from "dashboard" screen in FA app
//	When user "disable" vacation with "non default" settings from "Vacation" screen in FA app
//	When user "disable" vacation with "non default" settings from "Primary Card" screen in FA app
//	When user "disable" vacation with "non default" settings from "dashboard" screen in FA app

	@When(value = "^user (.+) vacation with (.+) settings from (.+) screen in FA app$")
	@Override
	@KeywordStep(gherkins = "^user (.+) vacation with (.+) settings from (.+) screen in FA app$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "Executing keyword steps:");
			on_off = exampleData.get(0).toUpperCase();
			default_nonDefault = exampleData.get(1).toUpperCase();
			screenName = exampleData.get(2).toUpperCase();
			try {
				String deviceName = inputs.getInputValue("LOCATION1_DEVICE1_NAME");
				flag = FAVacationUtils.start_EndVacationInVacationSettingScreen(testCase, on_off, deviceName,
						default_nonDefault, screenName);
			} catch (Exception e) {
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
		Keyword.ReportStep_Pass(testCase, "Executing post condition:");
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}

}
