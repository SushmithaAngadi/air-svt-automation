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

public class EnableDisableSchedule extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	private TestCaseInputs inputs;
	String scheduleState;
	String deviceType;
	ArrayList<String> exampleData;

	public EnableDisableSchedule(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
		return flag;
	}

	// user "enable" schedule from "FA APP"

	@Given(value = "^user (.+) schedule from (.+)$")
	@Override
	@KeywordStep(gherkins = "^user (.+) schedule from (.+)$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				scheduleState = exampleData.get(0).toUpperCase();
				deviceType = exampleData.get(1).toUpperCase();
				flag = flag && FAScheduleUtils.enableDisableSchedule(testCase, inputs, scheduleState, deviceType);
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