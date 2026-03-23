package com.honeywell.keywords.api.demandResponse;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.api.demandresponse.DemandResponseUtils;
import com.honeywell.utils.stat.KeepAppActive;
import cucumber.api.java.en.When;

public class CancelDemandResponse extends Keyword {

	private TestCases testCase;
	TestCaseInputs inputs;
	public boolean flag = true;
	private KeepAppActive appActive;

	public CancelDemandResponse(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		try {
			appActive = new KeepAppActive(testCase);
			appActive.start();
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@When(value = "^cancel demand response from the cloud as a contractor$")
	@Override
	@KeywordStep(gherkins = "^cancel demand response from the cloud as a contractor$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = DemandResponseUtils.CancelDemandResponse(testCase);
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Exception occured in, Due to " + e);
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() throws KeywordException {
		if (appActive.isAlive()) {
			appActive.requestStop();
			System.out.println("APP is Acctive , Requested to Stop Service");
		}
		return flag;
	}
}
