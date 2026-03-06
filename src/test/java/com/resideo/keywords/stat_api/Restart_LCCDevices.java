package com.resideo.keywords.stat_api;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.api.dfc.CustomCommands;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import io.cucumber.java.en.Given;

public class Restart_LCCDevices extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;
	public boolean flag = true;

	public Restart_LCCDevices(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}

	@Given(value = "^Restart devices from LCC$")
	@Override
	@KeywordStep(gherkins = "^Restart devices from LCC$")
	public boolean keywordSteps() {
//		, "B82CA0630D88"
		CustomCommands.doRestart_OverApi(testCase, inputs, "48A2E65CEA38","48A2E66B9FDF","48A2E66B9F68","B82CA0351285","B82CA06BBEB5","48A2E66B9FBC");
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;

	}

}
