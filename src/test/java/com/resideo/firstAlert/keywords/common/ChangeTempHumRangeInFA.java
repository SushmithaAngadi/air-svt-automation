package com.honeywell.keywords.firstAlertapp.common;

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
import com.honeywell.utils.app.screens.ThermostatSettingsScreen;
import com.honeywell.utils.firstAlertapp.FA_AlertUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.firstAlertapp.screen.FA_AlertScreen;
import com.honeywell.utils.mqtt.MqttManager;
import com.honeywell.utils.stat.StatCommands;
import com.honeywell.utils.stat.cattgrpccommands.String_Msg;
import cucumber.api.java.en.Given;

public class ChangeTempHumRangeInFA extends Keyword {

	ArrayList<String> exampleData;
	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	ThermostatSettingsScreen settings;
	FA_AlertScreen alertScreen;
	public int indoorHumidity;
	String alertRange = null;
	String deviceName = null;

	public ChangeTempHumRangeInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
		this.alertScreen = new FA_AlertScreen(testCase);

	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre-Condition</b>");
		if (testCase.isTestSuccessful()) {
			try {
				deviceName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim().toUpperCase();
				flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
						"ALERT MANAGEMENT");
			} catch (Exception e) {
				System.out.println("Exception occured due to : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

//	user "Activate" the "High Indoor Temperature" Alert From FA App
//	user "Deactivate" the "High Indoor Temperature" Alert From FA App
//	user "Activate" the "Low Indoor Temperature" Alert From FA App
//	user "Deactivate" the "Low IndoorTemperature" Alert From FA App
//	user "Activate" the "High Indoor Humidity" Alert From FA App
//	user "Deactivate" the "High Indoor Humidity" Alert From FA App
//	user "Activate" the "Low Indoor Humidity" Alert From FA App
//	user "Deactivate" the "Low Indoor Humidity" Alert From FA App
//	user "Enable" the "Indoor Temperature" Alert From FA App
//	user "Disable" the "Indoor Humidity" Alert From FA App
//	user "Enable" the "Indoor Humidity" Alert From FA App
//	user "Disable" the "Indoor Temperature" Alert From FA App

	@Given(value = "^user (.+) the (.+) Alert From FA App$")
	@Override
	@KeywordStep(gherkins = "^user (.+) the (.+) Alert From FA App$")
	public boolean keywordSteps() throws KeywordException {
		String alertState = exampleData.get(0).toUpperCase();
		String alertType = exampleData.get(1).toUpperCase();
		String tempscale;
		try {
			if (testCase.isTestSuccessful()) {
				if (alertState != null && alertType != null) {
					if (alertType.contains("TEMPERATURE")
							&& (alertState.contains("ACTIVATE") || alertState.contains("DEACTIVATE"))) {
						alertRange = alertType.contains("HIGH") ? "HIGH" : "LOW";
						tempscale = FA_AlertUtils.getTempScale(testCase);
						System.out.println("tempscale is : " + tempscale);
						flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
								"ALERT MANAGEMENT");
						float indoorTemp = 0;
						if (deviceName.toUpperCase().contains("DENALI")) {
							indoorTemp = Float.parseFloat(MqttManager.getIndoorTemp(testCase))/100;
						} else if (deviceName.toUpperCase().contains("FUJI")) {
							indoorTemp = StatCommands.getInstance().cattCommandsStub
									.getIndoorTempVariable(String_Msg.newBuilder().build()).getFloatVal();
						}
						System.out.println("indoorTemp is : " + indoorTemp);
						flag = flag
								&& FA_AlertUtils.SetTempAlert(testCase, alertState, alertRange, indoorTemp, tempscale);
					} else if (alertType.contains("HUMIDITY")
							&& (alertState.contains("ACTIVATE") || alertState.contains("DEACTIVATE"))) {
						alertRange = alertType.contains("HIGH") ? "HIGH" : "LOW";
						flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
								"PRIMARY CARD");
						int indoorHumidity = Integer.parseInt(alertScreen.getCurrentHumValue());
						System.out.println("indoorHumidity is : " + indoorHumidity);
						flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
								"ALERT MANAGEMENT");
						flag = flag && FA_AlertUtils.SetHumAlert(testCase, alertState, alertRange, indoorHumidity);
					} else if (alertType.contains("TEMPERATURE")
							&& (alertState.contains("ENABLE") || alertState.contains("DISABLE"))) {
						flag = flag && FA_AlertUtils.ChangeTempAlertStateTo(testCase, alertState);
					} else if (alertType.contains("HUMIDITY")
							&& (alertState.contains("ENABLE") || alertState.contains("DISABLE"))) {
						flag = flag && FA_AlertUtils.ChangeHumAlertStateTo(testCase, alertState);
					} else {
						flag = false;
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Invalid keyword inputs...");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Blank keyword inputs...");
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Scenario steps failed already, hence skipping the verification");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception raised : " + e.getMessage());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
		if (testCase.isTestSuccessful()) {
			flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}
}