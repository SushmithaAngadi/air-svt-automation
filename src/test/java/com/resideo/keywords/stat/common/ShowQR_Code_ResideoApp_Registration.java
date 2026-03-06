package com.resideo.keywords.stat.common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.screens_Gui.GUI_Screen_Utils;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class ShowQR_Code_ResideoApp_Registration extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;

	public ShowQR_Code_ResideoApp_Registration(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}

	@Given(value = "^User open QR Code from Connect app screen$")
	@Override
	@KeywordStep(gherkins = "^User open QR Code from Connect app screen$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			flag = GUI_Screen_Utils.showQRScanCodeToRegistration(testCase);
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
