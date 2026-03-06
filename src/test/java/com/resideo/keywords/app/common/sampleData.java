package com.resideo.keywords.app.common;

import java.io.File;
import java.io.PrintWriter;

import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.LCC_Admin;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.cucumber.java.en.Given;

public class sampleData extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public sampleData(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
		
		} catch (Exception e) {
		}
		return flag;
	}

	@Given(value = "sample data fro")
	@Override
	@KeywordStep(gherkins = "^sample data fro$")
	public boolean keywordSteps() {
//	
//		String macID = StatCommands.getInstance().cattCommandsStub
//				.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
		String macID = "48A2E64C90F2";
		System.out.println(macID);
				LCC_Admin.getdeviceInfo(testCase, inputs, macID);
//				LCC_Admin.checkAndDelete_GDRInfo(testCase, inputs, macID);
		
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

//		

		return flag;
	}

}
