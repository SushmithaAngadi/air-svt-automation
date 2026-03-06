package com.resideo.keywords.stat.T9_T10_T10Plus;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class RegistrationStatu_GUI extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public RegistrationStatu_GUI(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^Verify Registration status in Stat GUI$")
	@Override
	@KeywordStep(gherkins = "^Verify Registration status in Stat GUI$")
	public boolean keywordSteps() throws KeywordException {
		try {
			if (testCase.isTestSuccessful()) {
				SetUpDevice_T9_T10_T0Plus gui = new SetUpDevice_T9_T10_T0Plus();
				flag = gui.IsRegistration_Success(testCase);
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to find Registration success massage in stat, Exception occured due to "
							+ e.getMessage());
			flag = false;
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		return flag;
	}

}
