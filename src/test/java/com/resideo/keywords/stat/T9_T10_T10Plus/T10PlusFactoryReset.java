package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.util.ArrayList;

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

public class T10PlusFactoryReset extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = false;

	public T10PlusFactoryReset(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^Reset the device to (.+) from GUI$")
	@Override
	@KeywordStep(gherkins = "^Reset the device to (.+) from GUI$")
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