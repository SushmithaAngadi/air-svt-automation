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

public class ExitDIYRegistration extends Keyword {
	private TestCases testCase;
	ArrayList<String> exampleData;
	FirstAlertDIYScreen diy;
	String device;
	public boolean flag = true;
	String IsuConfigured_Status;

	public ExitDIYRegistration(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition</b>");
		if (testCase.isTestSuccessful()) {
			diy = new FirstAlertDIYScreen(testCase);
			flag = diy.isTwoMoreStepScreen();		
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^user perform registration flow in First Alert app by clicking (.+) on Exit Setup pop-up screen$")
	@Override
	@KeywordStep(gherkins = "^user perform registration flow in First Alert app by clicking (.+) on Exit Setup pop-up screen$")
	public boolean keywordSteps() {
	    boolean flag = false;
	    Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Steps for Exit DIY Registration Setup </b>");
	    if (testCase.isTestSuccessful()) {
	        String exitType = exampleData.get(0); 
	        try {
	        	flag = FirstAlert_DIYUtils.exitDIYProcessBeforeISUSetup(testCase, diy, exitType);
	        } catch (Exception e) {
	        	flag = false;
	            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, 
	                    "An exception occurred during the Exit DIY registration process: " + e.getMessage());
	        }
	    } else {
	        Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, 
	                "Skipping " + this.getClass().getName() + " execution, as previous scenario/keyword steps failed.");
	        flag = false;
	    }
	    return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executed Post Condition</b>");
		return flag;
	}

}
