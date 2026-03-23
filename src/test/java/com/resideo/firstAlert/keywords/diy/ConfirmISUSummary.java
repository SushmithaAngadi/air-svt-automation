package com.resideo.keywords.firstAlertapp.diy_common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class ConfirmISUSummary extends Keyword{

	private TestCases testCase;
	private TestCaseInputs inputs;
	FirstAlertDIYScreen diy;

	public boolean flag = true;

	public ConfirmISUSummary(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing ISU Configured Confirmation </b>");
		if (testCase.isTestSuccessful()) {
			diy = new FirstAlertDIYScreen(testCase);
			flag = diy.isConfigurationSummary(40);
		}else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condition "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "Confirm ISU summary in FirstAlert APP")
	@Override
	@KeywordStep(gherkins = "^Confirm ISU summary in FirstAlert APP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU Confirmation  </b>");
		if (testCase.isTestSuccessful()) {
			flag = flag && diy.clickOnNextButton();
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
		try {
			String deviceName = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
			if (testCase.isTestSuccessful()) {
				if (deviceName.toUpperCase().contains("TRADE")) {
					Keyword.ReportStep_Pass(testCase, "<b> Start Executing post condition for ISU confirmation  </b>");
					if (diy.isOneMoreStepScreen()) {
						flag = diy.clickOnNextButton();
					} else {
						flag = false;
					}
				} else if (deviceName.toUpperCase().contains("RETAIL")) {
					flag = diy.ClickOnDoneButton();
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat on wall screen not visible");
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "ISU Summary not available : " + e.getMessage());
		}
		return flag;
	}


}
