package com.honeywell.keywords.firstAlertapp.humdehum;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAHumDehumVentUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.firstAlertapp.screen.FAPrimaryCardScreen;
import com.honeywell.utils.mqtt.MqttManager;

import cucumber.api.java.en.Given;

public class VerifyHumDehumEnableStateInFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String expStatus;
	String humDehumVent;
	FAPrimaryCardScreen pm;

	public VerifyHumDehumEnableStateInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing preCondition</b>");
		if (testCase.isTestSuccessful() && flag) {
			Keyword.ReportStep_Pass(testCase, "successfully verified preCondition");
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
	
	/** Then user verifies that "Humidification" is "Enabled" in the FA App
	 * Then user verifies that "Humidification" is "Disabled" in the FA App
	 * Then user verifies that "Dehumidification" is "Enabled" in the FA App
	 * Then user verifies that "Dehumidification" is "Disabled" in the FA App
	**/

	@Given(value = "^user verifies that (.+) is (.+) in the FA App$")
	@Override
	@KeywordStep(gherkins = "^user verifies that (.+) is (.+) in the FA App$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing KeywordSteps</b>");
			try {
				pm = new FAPrimaryCardScreen(testCase);
				humDehumVent = exampleData.get(0);
				expStatus = exampleData.get(1);
				if (humDehumVent.toUpperCase().contains("HUM")) {
					if (FAHumDehumVentUtils.verifyHumDehumToggleStatusInFA(testCase, humDehumVent, expStatus)) {
						Keyword.ReportStep_Pass(testCase,
								"Successfully verified stat " + humDehumVent + " status as: " + expStatus);
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Mismatch in the stat " + humDehumVent + " status expected is: " + expStatus);
					}
				} else if (humDehumVent.toUpperCase().contains("VENT")) {
					if (MqttManager.getVentStatusInSystem(testCase)) {
						flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase,
								testCase.getTestCaseInputs(), "VENTILATION") && pm.clickOnHumDehumVentCrossBtn();;
					}
					if (!flag) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								" Ventilation Mode is disabled, check thermostat and app");
					}
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occurred due to " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful() & flag) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing postCondition for the class: VerifyHumDehumEnableStateInFA</b>");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

}