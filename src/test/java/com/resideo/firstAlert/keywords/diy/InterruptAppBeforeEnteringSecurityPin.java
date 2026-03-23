package com.resideo.keywords.firstAlertapp.diy_common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class InterruptAppBeforeEnteringSecurityPin extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	String flowType;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public InterruptAppBeforeEnteringSecurityPin(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition</b>");
		if (testCase.isTestSuccessful()) {
			flag = true;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}
	
	@Given(value = "^App is force killed before entering the security pin$")
	@Override
	@KeywordStep(gherkins = "^App is force killed before entering the security pin$")
	public boolean keywordSteps() {
	    if (testCase.isTestSuccessful()) {
	        Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
	        try {
	            String deviceNeedToInstall = SuiteConstants
	                    .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
	            if (deviceNeedToInstall.contains("FUJI")) {
	                FirstAlertDIYScreen faDiyScreen = new FirstAlertDIYScreen(testCase);
	                if (faDiyScreen.SelectBLEDevicefromBluetooth()) {
	                    if (FirstAlert_DIYUtils.forceKillApp(testCase)) {
	                        Keyword.ReportStep_Pass(testCase, "App is force killed successfully.");
	                        flag = true;
	                    } else {
	                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
	                                "Failed to force kill the app.");
	                        flag = false;
	                    }
	                } else {
	                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
	                            "Device is not selected from the list.");
	                    flag = false;
	                }
	            } else {
	            	Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Device Need to add in methods, flow need to determine");
					flag = false;
	            }
	        } catch (Exception e) {
	        	flag = false;
	            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
	                    "An error occurred while executing keyword steps: " + e.getMessage());
	        }
	    } else {
	    	flag = false;
	        Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, 
	                "Skipping " + this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
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
