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
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class SetupLocationAndDeviceName extends Keyword{

	private TestCases testCase;
	private TestCaseInputs inputs;
	FirstAlertDIYScreen diy;
	public boolean flag = true;
	private ArrayList<String> exampleData;

	public SetupLocationAndDeviceName(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  by setting location and Device name</b>");
		if (testCase.isTestSuccessful()) {
			diy=new FirstAlertDIYScreen(testCase);
//			if (!diy.isStepsToAddDeviceScreen()) {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not in the Expected screen");
//				flag=false;
//			}
		}

		return flag;
	}

//	Setup Device "name" for DIY
	
	@Given(value = "^Setup Device (.+) for DIY$")
	@Override
	@KeywordStep(gherkins = "^Setup Device (.+) for DIY$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for setup of Device name and location name</b>");
		if (testCase.isTestSuccessful()) {
			flag = FirstAlert_DIYUtils.setupLocationAndDeviceName(testCase, diy);
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
		return flag;

	}



	
	
	
}
