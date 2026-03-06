package com.resideo.keywords.app.caspianDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.api.ufc.TitanUtils;

import io.cucumber.java.en.Given;

public class UnregisterAndVerifyDeviceFromTitan extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public UnregisterAndVerifyDeviceFromTitan(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}

	@Given(value = "Verify and unregister Caspian Device from Cloud")
	@Override
	@KeywordStep(gherkins = "^Verify and unregister Caspian Device from Cloud$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing : Verify Caspian Device is Unregister</b>");

		try {
//			String macID = SystemState.getStatus().macIDName();
//			String macID ="48A2E61D8AEB";
			String macID ="48A2E636B741";
			flag = TitanUtils.unregisterDeviceFromTitanCloud(testCase, inputs, macID);

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to :" + e.getMessage());
			flag = false;
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		
		
		return flag;
	}
}
