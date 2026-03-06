package com.resideo.keywords.reziapp.thorDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.CustomerUtils;
import com.resideo.utils.resideoPro_app.ReziDIYUtils;
import com.resideo.utils.resideoPro_app.screen.CustomerInfoScreen;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import io.cucumber.java.en.Given;

public class EnrollThermostat extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;
	ReziDIYScreen diy;
	String userName;

	public EnrollThermostat(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			diy = new ReziDIYScreen(testCase);
			flag = ReziDIYUtils.doConfigureOnDevice(testCase, diy);

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
					"Exception Occured due to " + e.getMessage());
		}

		return flag;
	}

//	Enter mac Manually
	@Given(value = "^Enroll thermostat using (.+)$")
	@Override
	@KeywordStep(gherkins = "^Enroll thermostat using (.+)$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Enroll thermostat </b>");
			try {
				flag = ReziDIYUtils.ScanQR_code_EnterMacManual(testCase, diy, exampleData.get(0).toUpperCase());
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