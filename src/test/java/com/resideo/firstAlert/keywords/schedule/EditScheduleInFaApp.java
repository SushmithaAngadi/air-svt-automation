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
import com.honeywell.utils.firstAlertapp.FAScheduleUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;

import cucumber.api.java.en.Given;

public class EditScheduleInFaApp extends Keyword {
	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public EditScheduleInFaApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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

//	Then user edit the schedule for "EveryDay Current" period with "Heat: PLUS 2,Cool:MINUS 2,Time:PLUS 15 MIN" values and "save" changes
//	Then user edit the schedule for "EveryDay Previous" period with "Heat: PLUS 2,Cool:MINUS 2,Time:PLUS 15 MIN" values and "save" changes
//	Then user edit the schedule for "EveryDay NExt" period with "Heat: PLUS 2,Cool:MINUS 2,Time:PLUS 15 MIN" values and "save" changes
//	Then user edit the schedule for "WeekDay Wake" period with "Heat: PLUS 2,Cool:MINUS 2,Time:PLUS 15 MIN" values and "save" changes
//	Then user edit the schedule for "Monday Home" period with "Heat: MINUS 4,Cool:PLUS 4,Time:MINUS 30 MIN" values and "save" changes
//	Then user edit the schedule for "WeekEnd Home" period with "Heat: MINUS 4,Cool:PLUS 4,Time:MINUS 30 MIN" values and "save" changes

	@Given(value = "^user edit the schedule for (.+) period with (.+) values and (.+) changes$")
	@Override
	@KeywordStep(gherkins = "^user edit the schedule for (.+) period with (.+) values and (.+) changes$")
	public boolean keywordSteps() throws KeywordException {
		String dayPeriod = exampleData.get(0).toUpperCase();
		String valuesToEdit = exampleData.get(1).toUpperCase();
		boolean save_dontSave = false;
		if (exampleData.get(2).toUpperCase().contains("SAVE") && (!exampleData.get(2).toUpperCase().contains("DONT"))) {
			save_dontSave = true;
		}
		try {
			if (testCase.isTestSuccessful()) {
				String deviceName = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();

				if (deviceName.toUpperCase().contains("FUJI")) {
					flag = FAScheduleUtils.createEditGeofenceTimeBasedSchedule(testCase, dayPeriod, "EDIT", null,
							valuesToEdit, save_dontSave);
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
