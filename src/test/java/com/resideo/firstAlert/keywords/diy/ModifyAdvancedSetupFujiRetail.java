package com.resideo.keywords.firstAlertapp.diy_common;

import java.util.ArrayList;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.NavigateToAnyScreeninFA;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class ModifyAdvancedSetupFujiRetail extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	private FirstAlertDIYScreen diy;
	public boolean flag = true;

	public ModifyAdvancedSetupFujiRetail(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@BeforeKeyword
	@Override

	public boolean preCondition() throws KeywordException {

		Keyword.ReportStep_Pass(testCase, "<b>Executing pre conditon for navigating Advance Setup</b>");
		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "ADVANCED SETUP");

		return flag;

	}

	@Given(value = "^user select advanced setup in First alert APP$")
	@Override
	@KeywordStep(gherkins = "^user select advanced setup in First alert APP$")
	public boolean keywordSteps() throws KeywordException {
		try {
			if (testCase.isTestSuccessful()) {

				Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
				flag = FirstAlert_DIYUtils.modifyAdvancedSetupNew(testCase);

			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
			return flag;

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Modify advanced setup button failed on keyword steps due to Exception : " + e.getMessage());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}

//	public boolean postCondition() {
//		flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
//		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
//		return flag;
//	}
}
