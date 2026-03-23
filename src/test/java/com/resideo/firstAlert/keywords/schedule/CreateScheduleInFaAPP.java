package com.honeywell.keywords.firstAlertapp.schedule;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.SuiteConstants;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.app.ScheduleUtils;
import com.honeywell.utils.firstAlertapp.FAScheduleUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class CreateScheduleInFaAPP extends Keyword {
	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public CreateScheduleInFaAPP(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "SCHEDULE");

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
//	When user create a schedule as "EveryDay" with "4" period with "default" settings in FA App and "save" changes
//	When user create a schedule as "EveryDay" with "4" period with "non default" settings in FA App and "save" changes
//	When user create a schedule as "Geofence with sleep" with "3" period with "default" settings in FA App and "save" changes
//	When user create a schedule as "Geofence with sleep" with "3" period with "non default" settings in FA App and "save" changes
//  When user create a schedule as "WeekDay and WeekEnd" with "4" period with "Wake: Heat: 68,Cool:76,Time:7:00 Am;Away: Heat: PLUS 2,Cool:MINUS 3,Time:PLUS 15 MIN;Home: Heat: 65,Cool:75,Time:9:00 PM;Sleep: Heat: PLUS 2,Cool:MINUS 2,Time:MINUS 45 MIN" settings in FA App and "save" changes	

	@Given(value = "^user create a schedule as (.+) with (.+) period with (.+) settings in FA App and (.+) changes$")
	@Override
	@KeywordStep(gherkins = "^user create a schedule as (.+) with (.+) period with (.+) settings in FA App and (.+) changes$")
	public boolean keywordSteps() throws KeywordException {
		String scheduleType = exampleData.get(0).toUpperCase();
		String noOfPeriod = exampleData.get(1).toUpperCase();
		String default_nondefault = exampleData.get(2).toUpperCase();
		boolean save_dontSave = false;
		if (exampleData.get(3).toUpperCase().contains("SAVE") && (!exampleData.get(3).toUpperCase().contains("DONT"))) {
			save_dontSave = true;
		}
		try {
			if (testCase.isTestSuccessful()) {
				String deviceName = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();

				if (deviceName.toUpperCase().contains("FUJI") || deviceName.toUpperCase().contains("DENALI")) {
					flag = FAScheduleUtils.createEditGeofenceTimeBasedSchedule(testCase, scheduleType, "CREATE", noOfPeriod,
							default_nondefault, save_dontSave);
				}else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "The device is not Fuji or Denali.");
				}

			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since exception occured due to " + e.getMessage());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (flag && testCase.isTestSuccessful()) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		}

		return flag;
	}
}
