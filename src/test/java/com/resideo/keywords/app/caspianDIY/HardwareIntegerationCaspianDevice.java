package com.resideo.keywords.app.caspianDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.relay.RelayConfiguration;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.stat.KeepAppActive;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class HardwareIntegerationCaspianDevice extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	DIYScreen diy;
	KeepAppActive appActive;

	public HardwareIntegerationCaspianDevice(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		appActive = new KeepAppActive(testCase);

		appActive.start();
		return flag;
	}

	@Given(value = "^Perform Button action on Caspian Device by using Arduino, Action is (.+)$")
	@Override
	@KeywordStep(gherkins = "^Perform Button action on Caspian Device by using Arduino, Action is (.+)$")
	public boolean keywordSteps() {
//		if (testCase.isTestSuccessful() && flag) {

		String action = exampleData.get(0);
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		try {
			flag = RelayConfiguration.CaspianCommandControl(testCase, action);
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception raised : " + e.getMessage());
		}

//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
//		RelayConfiguration.getSerialPort().closePort();
		if (flag) {
			ReportStep_Pass(testCase, "Successfully Reset");
		} else {
			ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Not Able to Reset , reset Caspian Device Filed");
		}
		appActive.requestStop();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (appActive.isAlive())
			appActive.requestStop();

		return flag;
	}
}
