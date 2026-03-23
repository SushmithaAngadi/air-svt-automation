package com.resideo.keywords.networkSimulator;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.web.KeepAppActive;

import io.cucumber.java.en.Given;

public class NetworkTraffic extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	KeepAppActive appActive;
	public boolean flag = true;
	String deviceName;

	public NetworkTraffic(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			System.out.println(testCase.getTestCaseName());
			
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "Create Network Traffic on Thermostat IP")
	@Override
	@KeywordStep(gherkins = "^Create Network Traffic on Thermostat IP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for select Device from List  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				appActive = new KeepAppActive(testCase);
				appActive.start();
//				NetworkSimulationByUDP.startListenerClient(testCase, 56000, 20, 5);
				if (appActive.isAlive())
					appActive.requestStop();
			} catch (Exception e) {
				e.printStackTrace();
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception occured, Exception is :" + e.toString());
				flag = false;
				if (appActive.isAlive())
					appActive.requestStop();
			}

		} else {
			if (appActive.isAlive())
				appActive.requestStop();
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		return flag;
	}

}