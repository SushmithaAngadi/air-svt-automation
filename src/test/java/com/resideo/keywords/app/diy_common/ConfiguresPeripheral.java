package com.resideo.keywords.app.diy_common;

import java.util.ArrayList;


import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;

import io.cucumber.java.en.Given;

/*
* @link
* @notes : Relay table need to seperate from this class
* #Valid : Change format string to json
* @Event : Change Router time as per page load, use retry flow for reducing time consume.
* 
*/

public class ConfiguresPeripheral extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	private TestCaseInputs inputs;
	public boolean flag = true;

	public ConfiguresPeripheral(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	/**
	*Then user configures "USING NXT?" to "YES" in the Firstalert app 
	*Then user configures "DEMAND CONTROL" to "WIRED VIA NXT" in the Firstalert app
	**/
	
//	user configures "USING NXT" to "YES" in the Firstalert app
	
	@Given(value = "^user configures (.+) to (.+) in the Firstalert app$")
	@Override
	@KeywordStep(gherkins = "^user configures (.+) to (.+) in the Firstalert app$")
	public boolean keywordSteps() throws KeywordException {
		flag=false;
		String screenNameToconfigure = exampleData.get(0).toUpperCase();
		String valueToConfigure = exampleData.get(1).toUpperCase();
		if (testCase.isTestSuccessful()) {
			if (screenNameToconfigure.contains("NXT")) {
				flag = FirstAlert_DIYUtils.ConfigureTheDevice(testCase,"NXT",valueToConfigure);
			} else if (screenNameToconfigure.contains("DEMAND CONTROL")) {
				flag = FirstAlert_DIYUtils.ConfigureTheDevice(testCase,"DEMAND CONTROL",valueToConfigure);
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

