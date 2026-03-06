package com.resideo.keywords.reziapp.Jasperdiy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.ReziDIYUtils;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class PerformInitialInstallationSteps extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;

	public boolean flag = true;
	ArrayList<String> exampleData;

	public PerformInitialInstallationSteps(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase,
				"<b>Start Executing Pre Condition for Initial Installation, Local network option Handles in Precondition for IOS  </b>");
		if (testCase.isTestSuccessful()) {
			diy = new ReziDIYScreen(testCase);
		}

		return flag;
	}

	@Given(value = "^Perform Resideo Pro initial installtion setup using (.+)$")
	@Override
	@KeywordStep(gherkins = "^Perform Resideo Pro initial installtion setup using (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Perform Resideo Pro initial installtion setup  </b>");
		if (testCase.isTestSuccessful()) {
			flag = flag && ReziDIYUtils.performInitialInstallation(testCase, diy,exampleData.get(0).trim().toUpperCase());
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
		System.out.println("Exceution is "+flag);
		return flag;
	}

}