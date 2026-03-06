package com.resideo.keywords.app.houdini;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.WireSenseDIYScreen;

import io.cucumber.java.en.Given;

public class ConfigureManualWireSensing extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	String[] wireSensingData;
	WireSenseDIYScreen ws;

	public boolean flag = true;

	public ConfigureManualWireSensing(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		wireSensingData = exampleData.get(0).split(",");
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Configure manual wire sensing</b>");
			ws = new WireSenseDIYScreen(testCase);
			
			if(ws.isManualWiringBtn(20)) {
				if(ws.clickOnManualWiringBtn()) {
					Keyword.ReportStep_Pass(testCase, "Clicked on manual wire sense Button");
					flag = true;
				}else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Manual Wire button not able to click");
					flag = false;
				}
			}
			
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condition "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "^Configure manual wire sensing as (.+)$")
	@Override
	@KeywordStep(gherkins = "^Configure manual wire sensing as (.+)$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {

			flag = DIYUtils.configureWireSensing(testCase, wireSensingData);
			
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