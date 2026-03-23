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
import com.resideo.utils.firstalert_app.NavigateToAnyScreeninFA;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class ConfirmISUSummaryRetailAdvSetup extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	FirstAlertDIYScreen diy;

	public boolean flag = true;

	public ConfirmISUSummaryRetailAdvSetup(TestCases testCase, TestCaseInputs inputs) {
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
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condition "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "Confirm ISU summary in Retail Advance Setup in FirstAlert APP")
	@Override
	@KeywordStep(gherkins = "^Confirm ISU summary in Retail Advance Setup in FirstAlert APP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU Confirmation on Retail  </b>");
		if (testCase.isTestSuccessful()) {
//			flag = true;
			flag = flag && diy.clickOnNextButton();
			System.out.println("Clicked on Next Button");

			flag = flag
					&& NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DEVICE SETTING");
			flag = flag && NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
			Keyword.ReportStep_Pass(testCase, "ISU Configured Confirmation for Retail is  " + flag);
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

			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase,
						testCase.getTestCaseInputs(), "DASHBOARD");

			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.toString());
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Unexpected exception occurred: " + e.toString());
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
