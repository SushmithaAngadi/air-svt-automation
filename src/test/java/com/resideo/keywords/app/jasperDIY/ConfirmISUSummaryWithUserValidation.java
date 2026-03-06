package com.resideo.keywords.app.jasperDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ConfirmISUSummaryWithUserValidation extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	String confirmation;
	DIYScreen diy;

	public boolean flag = true;

	public ConfirmISUSummaryWithUserValidation(TestCases testCase, TestCaseInputs inputs,
			ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing ISU Configured Confirmation </b>");
			diy = new DIYScreen(testCase);
//			flag = diy.isConfigurationSummary(80);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condition "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "^Do you want to confirm ISU or Need to Edit ? (.+)$")
	@Override
	@KeywordStep(gherkins = "^Do you want to confirm ISU or Need to Edit ? (.+)$")
	public boolean keywordSteps() {

		confirmation = exampleData.get(0).toUpperCase().trim();

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU COnfirmation  </b>");

			if (diy.isConfigurationSummary()) {
				if (confirmation.contains("CONFIRM")) {
					if (diy.clickOnNextButton("Clicked on ISU confirmation next button")) {

					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click On Next Button from Confirm ISU Screen");
						flag = false;
					}
					Keyword.ReportStep_Pass(testCase, "ISU Configured Confirmation is  " + flag);
				} else {
					if (diy.clickOnEditButton("user choosen to recongiure ISU, Clicked on Edit button")) {

						if (diy.isReconfigurePopUp()) {

							if (diy.clickOnYes_ReconfigureButton(
									"user choosen to recongiure ISU, Clicked on Edit button")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click On yes Button from Confirm ISU Screen");
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Reconfigure popUp is not present");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click On Edit Button from Confirm ISU Screen");
						flag = false;
					}
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Confirm ISU Screen is not present");
				flag = false;
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
		if (flag) {
			// Keyword.ReportStep_Pass(testCase,
			// "<b style=\"color:blue\"> Executed Post Condition for Install
			// device and its succeed </b>");
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing post condition for ISU confirmation  </b>");
			if (confirmation.contains("CONFIRM")) {
				if (diy.isConfigurationComplete()) {
					flag = diy.clickOnNextButton("Clicked on Configuration completed next button");
				} else {
					flag = false;
				}
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat on wall screen not visible");
			flag = false;
		}
		return flag;
	}

}