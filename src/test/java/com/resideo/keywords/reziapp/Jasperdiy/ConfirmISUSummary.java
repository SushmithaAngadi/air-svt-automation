package com.resideo.keywords.reziapp.Jasperdiy;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import io.cucumber.java.en.Given;

public class ConfirmISUSummary extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;

	public boolean flag = true;

	public ConfirmISUSummary(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
	
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing ISU Configured Confirmation </b>");
			diy = new ReziDIYScreen(testCase);
			flag = diy.isConfigurationSummary(40);
		}else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condition "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "Confirm ISU summary in Rezi App")
	@Override
	@KeywordStep(gherkins = "^Confirm ISU summary in Rezi App$")
	public boolean keywordSteps() {
		
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU COnfirmation  </b>");
			flag = flag && diy.clickOnFinishButton("Clicked on ISU confirmation Finish button");
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
		if (testCase.isTestSuccessful()) {
//			Keyword.ReportStep_Pass(testCase,
//					"<b style=\"color:blue\"> Executed Post Condition for Install device and its succeed </b>");
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing post condition for ISU confirmation  </b>");

			if (diy.isConfigurationComplete(30)) {
				return diy.clickOnOkButton("Clicked on Configuration completed OK button");
			} else {
				return false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat on wall screen not visible");
			return false;
		}
	}

}