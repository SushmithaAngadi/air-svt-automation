package com.resideo.keywords.firstAlertapp.diy_common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;

import io.cucumber.java.en.Given;

public class PerformInstallationStepsForDIY extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public PerformInstallationStepsForDIY(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase,
				"<b>Start Executing Pre Condition for Initial Installation steps </b>");

		return flag;
	}

	@Given(value = "^Perform initial installation setup for (.+) mode in First Alert APP$")
	@Override
	@KeywordStep(gherkins = "^Perform initial installation setup for (.+) mode in First Alert APP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Perform Resideo Pro initial installtion setup  </b>");
		if (testCase.isTestSuccessful()) {
			flag = flag && FirstAlert_DIYUtils.performInitialInstallationForDIY(testCase, exampleData.get(0).toUpperCase());
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
		System.out.println("Exceution is " + flag);
		return flag;
	}

}
