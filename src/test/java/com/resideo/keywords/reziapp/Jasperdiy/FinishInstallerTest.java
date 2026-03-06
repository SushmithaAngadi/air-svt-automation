package com.resideo.keywords.reziapp.Jasperdiy;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideoPro_app.screen.ReziSystemTestScreen;

import io.cucumber.java.en.Given;

public class FinishInstallerTest  extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziSystemTestScreen systemtestscreen;

	public boolean flag = true;

	public FinishInstallerTest(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}

	@Given(value = "Finish Installer Diagnostic Test")
	@Override
	@KeywordStep(gherkins = "^Finish Installer Diagnostic Test$")
	public boolean keywordSteps() {
		
		if (testCase.isTestSuccessful()) {
			systemtestscreen = new ReziSystemTestScreen(testCase);
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU COnfirmation  </b>");
			flag = flag && systemtestscreen.clickOnDoneButton();
			Keyword.ReportStep_Pass(testCase, "ISU Configured Confirmation is  "+flag);
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
		return flag;
	}

}