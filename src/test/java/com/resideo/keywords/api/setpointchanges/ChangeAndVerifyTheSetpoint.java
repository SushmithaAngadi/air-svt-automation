package com.resideo.keywords.api.setpointchanges;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.api.command_control.ChilAPI_Command_Control;
import com.resideo.utils.api.command_control.DeviceServiceAPI_Command_Control;
import com.resideo.utils.api.tcc.ThermostatAPIUtils;

import io.cucumber.java.en.When;

public class ChangeAndVerifyTheSetpoint extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	private TestCaseInputs inputs;
	String changegFrom = null;
	String brightnessValue = null;

	public ChangeAndVerifyTheSetpoint(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;

	}

	@When(value = "^user change the (.+) setpoint from cloud using (.+) ,thermostat (.+) sync with cloud$")
	@Override
	@KeywordStep(gherkins = "^user change the (.+) setpoint from cloud using (.+) ,thermostat (.+) sync with cloud$")
	public boolean keywordSteps() {

		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		try {
			if (testCase.isTestSuccessful()) {
				boolean isSyncCanApply = true;
				if (exampleData.get(2).toUpperCase().contains("NOT")) {
					isSyncCanApply = false;
				}
				String macID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID")
						.toUpperCase().trim();
				if (exampleData.get(1).toUpperCase().contains("TCC")) {
					flag = ThermostatAPIUtils.change_VerifyTheSetPointfromThermostat(testCase, inputs, macID,
							isSyncCanApply);
				} else if (exampleData.get(1).toUpperCase().contains("DEVICE")
						&& exampleData.get(1).toUpperCase().contains("SERVICE")) {
					flag = DeviceServiceAPI_Command_Control.change_VerifyTheSetPointfromThermostat(testCase, inputs, macID,
							isSyncCanApply);
				} else {
					flag = ChilAPI_Command_Control.change_VerifyTheSetPointfromThermostat(testCase, inputs, macID,
							isSyncCanApply);
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
		return flag;
	}
}