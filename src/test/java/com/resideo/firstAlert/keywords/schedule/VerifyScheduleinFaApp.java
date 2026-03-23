package com.honeywell.keywords.firstAlertapp.schedule;

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

public class VerifyScheduleinFaApp extends Keyword {

	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;
	ArrayList<String> keywordData;
	String periodData;
	String periodName;
	String scheduleType;
	String verifyFrom;

	public VerifyScheduleinFaApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		verifyFrom = exampleData.get(0).toUpperCase();
		scheduleType = exampleData.get(1).toUpperCase();
		periodName = exampleData.get(2).toUpperCase();
		periodData = exampleData.get(3).toUpperCase();

		if (testCase.isTestSuccessful()) {
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to get to the Schedule screen. Precondition Failed " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

//	Then user verifies from "schedule screen, Primary card, thermostat" running "Everyday" schedule with "current" period with "default" settings in FA App
//	Then user verifies from "schedule screen, Primary card, thermostat" running "Everyday" schedule with "current" period with "non default" settings in FA App
//	Then user verifies from "Schedule Screen,PrimaryCard Screen,thermostat" running "Everyday Single view" schedule with "current" period with "non default" settings in FA App
//	Then user verifies from "Schedule Screen,PrimaryCard Screen,thermostat" running "Geofence with sleep" schedule with "current" period with "non default" settings in FA App
//	Then user verifies from "Schedule Screen,PrimaryCard Screen,thermostat" running "Geofence with sleep" schedule with "current" period with "default" settings in FA App

//	Edit
//	Then user verifies from "Schedule Screen,PrimaryCard Screen,thermostat" running "EveryDay" schedule with "Current" period with  "edited values" settings in FA App
//	Then user verifies from "Schedule Screen,PrimaryCard Screen,thermostat" running "EveryDay" schedule with "Current" period with  "certain values" settings in FA App

	@Given(value = "^user verifies from (.+) running (.+) schedule with (.+) period with(.+) settings in FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies from (.+) running (.+) schedule with (.+) period with(.+) settings in FA App$")

	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				String default_orNonDefault_orEdit = null;
				if (periodData.contains("NON DEFAULT")) {
					default_orNonDefault_orEdit = "NON DEFAULT";
				} else if (periodData.contains("DEFAULT")) {
					default_orNonDefault_orEdit = "DEFAULT";
				} else if (periodData.contains("EDIT")) {
					default_orNonDefault_orEdit = "EDIT";
				} else if (periodData.contains("CERTAIN")) {
					default_orNonDefault_orEdit = "CERTAIN";
				} else {
					default_orNonDefault_orEdit = "NOT APPLICABLE";
				}
				if (scheduleType.contains("GEO")) {
					flag = FAScheduleUtils.verifyGeofenceRunningData(testCase, verifyFrom, inputs, periodName,
							default_orNonDefault_orEdit, scheduleType);
				} else {
					flag = FAScheduleUtils.verifyCurrentScheduleData(testCase, verifyFrom, scheduleType, periodName,
							default_orNonDefault_orEdit, periodData);
				}
			} catch (Exception e) {
				e.printStackTrace();
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
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "PRIMARY CARD");
		return flag;
	}

}
