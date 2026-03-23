package com.honeywell.keywords.api.geofence;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.api.command_control.Geofence_APIUtils;
import com.honeywell.utils.app.NavigateToAnyScreen;
import cucumber.api.java.en.Given;

public class UpdateGeofenceLocationParamIn_App extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public UpdateGeofenceLocationParamIn_App(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre Condition</b>");
		try {
			flag = NavigateToAnyScreen.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "GEOFENCE SETTINGS");
		} catch (Exception e) {
		}
		return flag;
	}

	@Given(value = "^update geofence location info in app$")
	@Override
	@KeywordStep(gherkins = "^update geofence location info in app$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (testCase.isTestSuccessful()) {
			flag = Geofence_APIUtils.update_Geofence_LocationInAPP_or_API(testCase, inputs, "APP");
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

		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
		flag = NavigateToAnyScreen.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");

		return flag;
	}

}
