package com.resideo.keywords.reziapp.common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.ReziDIYUtils;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import io.cucumber.java.en.Given;

public class Connect_Disconnect_Ble_TimeOut extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public Connect_Disconnect_Ble_TimeOut(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			diy = new ReziDIYScreen(testCase);
			Keyword.ReportStep_Pass(testCase,
					"<b>Start Executing Pre Condition for Connect to Thermostat " + exampleData.get(0) + " </b>");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Device in broadcast, it (.+) disconnect from the app (.+)$")
	@Override
	@KeywordStep(gherkins = "^Device in broadcast, it (.+) disconnect from the app (.+)$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing Connect to thermostat " + exampleData.get(0) + "  </b>");
			try {
				flag = ReziDIYUtils.verifyStat_App_connect_untilTimeOut(testCase, 1800, 1860, 1860, 40);

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

		if (!testCase.isTestSuccessful()) {

		}

		System.out.println("Exceution is " + flag);
		return flag;
	}

}