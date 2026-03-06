package com.resideo.keywords.app.common;

import java.util.ArrayList;

import org.openqa.selenium.Point;
import org.openqa.selenium.html5.Location;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.api.dfc.TabascoUtils;
import com.resideo.utils.resideo_app.LyricUtils;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;

public class LoginToApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	String app;

	public boolean flag = true;

	public LoginToApp(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
		
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre Condition</b>");
		try {
			app= exampleData.get(0).toUpperCase();
			if(app.contains("FIRST")) {
				System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT,
						"CHOOSE_APP_NEED_TO_INSTALL", "RESIDEO_HOME"));
			}else if(app.contains("PRO")) {
				System.out.println(SuiteConstants.setConstantValue(SuiteConstantTypes.APP_NAME_FORMAT,
						"CHOOSE_APP_NEED_TO_INSTALL", "RESIDEO_PRO"));
			}
			SystemState.getStatus().initForDiy();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

//	Given user launches and logs in to the "first alert" app
	
	@Given(value = "^user launches and logs in to the (.+) app$")
	@Override
	@KeywordStep(gherkins = "^user launches and logs in to the (.+) app$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (testCase.isTestSuccessful()) {
			flag = LyricUtils.launchAndLoginTo_Application(testCase, inputs,app);
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
		Keyword.ReportStep_Pass(testCase, "<b>Executed Post Condition</b>");
		return flag;
	}

}
