package com.resideo.keywords.app.caspianDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.CaspianUtils;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class ConnectWithCaspianDevice extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	String device;
	ArrayList<String> exampleData;

	public boolean flag = true;

	public ConnectWithCaspianDevice(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		diy = new DIYScreen(testCase);
		if (diy.isPrepareValveToConnectScreen()) {
			ReportStep_Pass(testCase, "Expected screen 'Prepare Valve to Connect' is visible");
			flag = diy.clickOnNextButton("Successfully Clicked on Prepare Valve Next Button");
		} else {
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Expected screen 'Prepare Valve to Connect' is not visible");
			flag = false;
		}

		return flag;
	}

	@Given(value = "Connect Capian valve with (.+) using (.+)")
	@Override
	@KeywordStep(gherkins = "^Connect Capian valve with (.+) using (.+)$")
	public boolean keywordSteps() {
		String ConnectMode = exampleData.get(0);
		String methodType = exampleData.get(1);
		if (testCase.isTestSuccessful()) {
			if (ConnectMode.toUpperCase().contains("BLE")) {
				flag = flag && DIYUtils.preparingAndConenctWithCaspianValveUsingBle(testCase, diy,methodType);
			} else if (ConnectMode.toUpperCase().contains("WIFI")) {
				flag = flag && CaspianUtils.ConnectWithCapianWIFI(testCase, diy,methodType);
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
			if (diy.isConnectToValveSucess(diy)) {
				flag = diy.clickOnNextButton(
						"Successfully clicked on Next Button in L5 Leak protection valve is connected to your phone");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected Success Screen not visible After Paring completed");
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;

	}

}