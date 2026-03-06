package com.resideo.keywords.app.jasperDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ConnectingToHoneywell extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public ConnectingToHoneywell(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		return flag;
	}

	@Given(value = "wait for connecting to honeywell")
	@Override
	@KeywordStep(gherkins = "^wait for connecting to honeywell$")
	public boolean keywordSteps() {
		try {
			if (testCase.isTestSuccessful()) {
				Keyword.ReportStep_Pass(testCase,
						"<b> Start Executing Keyword for Waiting for connecting to honeywell screen </b>");
				flag = flag && DIYUtils.completeRegistrationFlow(testCase);
				if (flag) {
					Keyword.ReportStep_Pass(testCase, "Connecting to honeywell Suucess");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed connecting to Honeywell");
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		if (!flag) {
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Excution failed , take a screenshot");
		}
		return flag;

	}

}
