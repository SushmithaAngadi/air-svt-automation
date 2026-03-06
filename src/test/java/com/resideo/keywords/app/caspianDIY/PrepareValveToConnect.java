package com.resideo.keywords.app.caspianDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class PrepareValveToConnect extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	String device;

	public boolean flag = true;

	public PrepareValveToConnect(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		diy = new DIYScreen(testCase);
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  </b>");
		if (testCase.isTestSuccessful()) {
			if (diy.isPrepareValveToConnectScreen()) {
				ReportStep_Pass(testCase, "Expected screen 'Prepare Valve to Connect' is visible");
			} else {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected screen 'Prepare Valve to Connect' is not visible");
				flag = false;
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}

		return flag;
	}

	@Given(value = "Prepare Valve to Connect")
	@Override
	@KeywordStep(gherkins = "^Prepare Valve to Connect$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {

			flag = diy.clickOnNextButton("Successfully Clicked on Prepare Valve Next Button");
			
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