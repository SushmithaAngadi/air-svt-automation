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
import com.honeywell.utils.firstAlertapp.FAScheduleUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import cucumber.api.java.en.Given;

public class verifyScheduleStateFromFAApp extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	private TestCaseInputs inputs;
	String scheduleState;
	String screenName;
	ArrayList<String> exampleData;

	public verifyScheduleStateFromFAApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		scheduleState = exampleData.get(0).toUpperCase();
		screenName = exampleData.get(1).toUpperCase();
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
		return flag;
	}

	//user verifies "Schedule Off" from "Schedule Screen" in FA App
	//user verifies "Schedule On" from "PrimaryCard Screen" in FA App

	@Given(value = "^user verifies (.+) from (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies (.+) from (.+) in FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = flag && FAScheduleUtils.verifyScheduleOnOffState(testCase, inputs, scheduleState,screenName);
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		return flag;
	}
}