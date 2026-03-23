package com.honeywell.keywords.firstAlertapp.humdehum;

import java.util.ArrayList;

import cucumber.api.java.en.Given;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAHumDehumVentUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.mqtt.MqttManager;

public class SetVerifyVentModeInFA extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String app_stat;
	String ventilationstatus;
	String setOrVerify;
	String ventSettings;
	String ventStatusValue;

	public SetVerifyVentModeInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing preCondition</b>");
				if (MqttManager.getVentStatusInSystem(testCase)) {
					flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "VENTILATION");
				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to get the status of vent from Mqtt, check if vent is disabled in thermostat.");
				}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
					"Since previous Scenario/Keyword steps failed or not connected with stat");
		}
		return flag;
	}
	
	/**
	 user "sets" ventilation "Mode" as "On" in FA App
	 user "Verifies" ventilation "Mode" as "On" in FA App
	 */
	
	@Given(value = "^user (.+) ventilation (.+) as (.+) in FA App$")
	@Override
	@KeywordStep(gherkins = "^user (.+) ventilation (.+) as (.+) in FA App$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			try {
				setOrVerify = exampleData.get(0).toUpperCase().trim();
				ventSettings = exampleData.get(1).toUpperCase().trim();
				ventStatusValue = exampleData.get(2).toUpperCase().trim();
						if (ventSettings.contains("MODE")) {
							flag = FAHumDehumVentUtils.changeVentSettings(testCase, setOrVerify, ventStatusValue);
						} else if (ventSettings.contains("BOOSTER TIMER")) {
							flag = FAHumDehumVentUtils.setOrVerifyVentilationTimer(testCase, setOrVerify, ventStatusValue);
						}
					if (flag) {
						ReportStep_Pass(testCase,
								"Edit Ventilation " + ventSettings + " : Keyword successfully executed");
					} else {
						flag = false;
						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Change System Mode : Keyword failed during execution");
					}
			} catch (Exception e) {
				flag = false;
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Change ventilation Mode : Error Occured while executing Keyword : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
					"Skipping " + this.getClass().getName() + " execution");
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
					"Since previous Scenario/Keyword steps failed or not connected with stat");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing postCondition for the class: SetVerifyVentModeInFA</b>");
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario Keyword steps failed.");
		}
		return flag;
	}

}