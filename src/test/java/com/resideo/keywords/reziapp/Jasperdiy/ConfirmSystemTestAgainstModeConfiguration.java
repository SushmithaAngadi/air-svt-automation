package com.resideo.keywords.reziapp.Jasperdiy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.ReziSystemTestUtils;

import io.cucumber.java.en.Given;

public class ConfirmSystemTestAgainstModeConfiguration extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public ConfirmSystemTestAgainstModeConfiguration(TestCases testCase, TestCaseInputs inputs,
			ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;

	}

	@Given(value = "Check system test configuration has (.+) mode turned on in Rezi App with relay (.+) in Thermostat")
	@Override
	@KeywordStep(gherkins = "^Check system test configuration has (.+) mode turned on in Rezi App with relay (.+) in Thermostat$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String ISUType = exampleData.get(0);
			String[] relayStatus = exampleData.get(1).split(":");
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {

				flag = ReziSystemTestUtils.extraSystemTest(testCase, ISUType, relayStatus, exampleData.get(1));

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
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

		return flag;
	}
}