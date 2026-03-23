package com.honeywell.keywords.api.setpointchanges;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.app.BrightnessUtils;
import com.honeywell.utils.app.NavigateToAnyScreen;
import com.honeywell.utils.stat.StatCommonCommandUtils;

import cucumber.api.java.en.When;

public class ChangeAndVerifyTheSetpoint extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	private TestCaseInputs inputs;
	String changegFrom =null;
	String brightnessValue=null;

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

	@When(value = "^user change the (.+) setpoint from cloud using (.+)$")
	@Override
	@KeywordStep(gherkins = "^user change the (.+) setpoint from cloud using (.+)$")
	public boolean keywordSteps() {
		
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		try {
			if (testCase.isTestSuccessful()) {

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