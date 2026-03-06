package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.util.ArrayList;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.relay.AAT_RelayConfiguration;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class UnEnroll_IAS_OAS_Sensors extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	int oasCount;
	int iasCount;
	SetUpDevice_T9_T10_T0Plus gui;
	boolean isRandomTimeNeed = false;

	public UnEnroll_IAS_OAS_Sensors(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		oasCount = Integer.valueOf(exampleData.get(0));
        iasCount = Integer.valueOf(exampleData.get(1));
		return flag;
	}

	@Given(value = "^user unenrolls (.+) oas and (.+) ias with eim and thermostat, is random unpairing time needed (.+)$")
	@Override
	@KeywordStep(gherkins = "^user enrolls (.+) oas and (.+) ias with eim and thermostat, is random unpairing time needed (.+)$")
	public boolean keywordSteps() throws KeywordException {
//		if (testCase.isTestSuccessful()) {
			try {
				flag = AAT_RelayConfiguration.resetIAS_OASWithContinueFlow(testCase, false, oasCount, iasCount);
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				flag = false;
			}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		return flag = true;
	}
}
