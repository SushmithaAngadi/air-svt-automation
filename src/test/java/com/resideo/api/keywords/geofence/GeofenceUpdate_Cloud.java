package com.honeywell.keywords.api.geofence;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.api.command_control.Geofence_APIUtils;
import cucumber.api.java.en.Given;

public class GeofenceUpdate_Cloud extends Keyword {
	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;
	String device;

	public GeofenceUpdate_Cloud(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
//		if (testCase.isTestSuccessful()) {
//			try {
//
//			} catch (Exception e) {
//				flag = false;
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Not able to get to the Schedule screen. Precondition Failed " + e.getMessage());
//			}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
//		}
		return flag;
	}

	@Given(value = "^user change (.+) time to (.+) time$")
	@Override
	@KeywordStep(gherkins = "^user change (.+) time to (.+) time$")
	public boolean keywordSteps() throws KeywordException {
//		String parameter = exampleData.get(0).toUpperCase();
		String function = exampleData.get(1).toUpperCase();

		if (testCase.isTestSuccessful()) {

			if (function.contains("CURRENT RUNNING")) {
				flag = Geofence_APIUtils.put_update_Geofence_Chil(testCase, inputs, false, true, "CURRENT RUNNING",
						true);
			} else {
				flag = Geofence_APIUtils.put_update_Geofence_Chil(testCase, inputs, false, true, "PAST", true);
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

		return flag;
	}
}
