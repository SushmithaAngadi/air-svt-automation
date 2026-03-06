package com.resideo.keywords.reziapp.Jasperdiy;

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
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class SelectOptionAfterPairing extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public SelectOptionAfterPairing(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			diy = new ReziDIYScreen(testCase);

			flag = diy.isConnectedScreenForISUBegin();

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Select Required option is (.+) in Rezi App$")
	@Override
	@KeywordStep(gherkins = "^Select Required option is (.+) in Rezi App$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing Connect to thermostat " + exampleData.get(0) + "  </b>");
			try {
				switch (exampleData.get(0).toUpperCase()) {
				case "CONFIGURATION": {
					flag = diy.clickOnConfiguration();
					break;
				}
				case "ADVANCED SETTINGS": {
					flag = diy.clickOnAdvanceSettings();
					break;
				}
				case "DIAGNOSTICS": {
					flag = diy.clickOnDiagnostics();
					break;
				}
				case "CUSTOMER INFO": {
					flag = diy.clickOnCustomerInfo();
					break;
				}
				default: {
					ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"User Expected Option not available, Please check user the list of options support, User expected is :"
									+ exampleData.get(0).toUpperCase());
					flag = false;
					break;
				}
				}

				if (flag)
					Keyword.ReportStep_Pass(testCase,
							" Rezi APP Option Choosen from Connected Screen, Choosen Option is :"
									+ exampleData.get(0).toUpperCase());
				else
					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Rezi APP Option Choosen from Connected Thermostat scenario failed");

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
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
		System.out.println("Exceution is " + flag);
		return flag;
	}

}