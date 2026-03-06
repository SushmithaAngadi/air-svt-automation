package com.resideo.keywords.app.common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.cucumber.java.en.Given;

public class CloseParticularApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public CloseParticularApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Close the (.+) Application$")
	@Override
	@KeywordStep(gherkins = "^Close the (.+) Application$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing Connect to thermostat " + exampleData.get(0) + "  </b>");
			try {

				testCase.getMobileDriver().quit();

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
		if (testCase.isTestSuccessful()) {
		System.out.println("Exceution is " + flag);
//		StatCommands.getInstance().cattCommandsStub.disconnectStat(String_Msg.newBuilder().setStrVal("").build());
//		StatCommands.setInstance(null);
		}
		return flag;
	}

}