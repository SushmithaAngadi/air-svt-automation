package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import java.util.HashMap;

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

import cucumber.api.java.en.When;

public class EditVacationSettings extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String vacationData;
	String screenName;
	int updateTimer;
	String min_sec_hr;
	String start_end;
	String deviceName;

	public EditVacationSettings(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		vacationData = exampleData.get(0).toUpperCase();
		screenName = exampleData.get(1).toUpperCase();
		if (testCase.isTestSuccessful()) {
			if (vacationData.contains("TIME")) {
				if (vacationData.contains("END")) {
					HashMap<String, String> time_Vacation = FAVacationUtils.getTime_Vacation(vacationData, "END");
					updateTimer = Integer.parseInt(time_Vacation.get("TIME"));
					min_sec_hr = time_Vacation.get("TYPE");
					start_end = "END";
				} else if (vacationData.contains("START")) {
					HashMap<String, String> time_Vacation = FAVacationUtils.getTime_Vacation(vacationData, "START");
					updateTimer = Integer.parseInt(time_Vacation.get("TIME"));
					min_sec_hr = time_Vacation.get("TYPE");
					start_end = "START";
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Keyword data is wrong, check the data " + vacationData);
					flag = false;
				}
			}
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "VACATION SETTING");
			return flag;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}
	
	// When user edit running vacation settings as "end time to 15 min" from "vacation" screen in FA App
	// When user edit running vacation settings as "Cool to 65" from "vacation" screen in FA App
	
	@When(value = "^user edit running vacation settings as (.+) from (.+) screen in FA App$")
	@Override
	@KeywordStep(gherkins = "^user edit running vacation settings as (.+) from (.+) screen in FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			deviceName = inputs.getInputValue("LOCATION1_DEVICE1_NAME");
			if (vacationData.contains("TIME")) {
				flag = FAVacationUtils.editVacationStartEndDate(testCase, inputs, start_end, updateTimer, min_sec_hr);
			} else {
				if (screenName.contains("VACATION")) {
					flag = FAVacationUtils.editVacationInVacationSettingScreen(testCase, deviceName,
							vacationData);
				}else if(screenName.contains("PRIMARY")) {
					flag = FAVacationUtils.editVacationData_fromPrimaryCard(testCase, deviceName, 
							vacationData);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Incorrect screenName is given: " + screenName);
					return false;
				}
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (flag) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		}
		return flag;
	}

}