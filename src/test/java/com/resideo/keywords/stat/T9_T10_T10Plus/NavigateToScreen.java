package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.time.Duration;
import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.screens_Gui.ScreenNavigationUtils;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class NavigateToScreen extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public NavigateToScreen(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^user navigate to (.+)$")
	@Override
	@KeywordStep(gherkins = "^user navigate to (.+)$")
	public boolean keywordSteps() throws KeywordException {
		String screenName = exampleData.get(0);
		if (testCase.isTestSuccessful()) {
			try {

				flag = ScreenNavigationUtils.screenNavigationFromAnyScreen(testCase, exampleData.get(0).toUpperCase());

				if (flag) {
					Keyword.ReportStep_Pass(testCase, "Successfully screen navigated to this screen " + screenName);
					flag = true;
				} else {
					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to navigate from any screen");
					flag = false;
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"screen navigated is failed to navigate to this screen " + screenName);
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}
