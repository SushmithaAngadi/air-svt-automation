package com.honeywell.keywords.api.demandResponse;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.SuiteConstants;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.api.demandresponse.DemandResponseUtils;
import com.honeywell.utils.app.HomeUtils;
import com.honeywell.utils.stat.KeepAppActive;
import cucumber.api.java.en.When;

public class PushDemandResponse extends Keyword {

	public boolean flag = true;
	public TestCases testCase;
	public TestCaseInputs inputs;
	ArrayList<String> exampleData;
	public String Expectedlabel = "SAVINGS EVENT UNTIL";
	String browserName = "CH";
	private DemandResponseUtils dc;
	private KeepAppActive appActive;

	public PushDemandResponse(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.inputs = inputs;
		this.exampleData = exampleData;
		dc = new DemandResponseUtils(inputs);
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		try {
			appActive = new KeepAppActive(testCase);
			appActive.start();
//			flag = flag && dc.enrollDemandResponseInWeb(testCase, browserName, HomeUtils.getMacID());
			flag = flag && dc.enrollDemandResponseInWeb(testCase, browserName,
					SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

//	When trigger demand response as "optoutable" , "temp offset" it should start in "1 mins" no of phases "3" with "heat1 to -2, cool1 to 2"
	@When(value = "^trigger demand response as (.+) , (.+) it should start in (.+) mins, no of phases (.+) with (.+)$")
	@Override
	@KeywordStep(gherkins = "^trigger demand response as (.+) , (.+) it should start in (.+) mins, no of phases (.+) with (.+)$")
	public boolean keywordSteps() throws KeywordException {

		String isOptable = "true";
		String tempOffset_dutyCyle = exampleData.get(1).toUpperCase();
		String start_time = exampleData.get(2).toUpperCase();
		String phases = exampleData.get(3).toUpperCase();
		String data_DR = exampleData.get(4).toUpperCase();

		if (exampleData.get(0).toUpperCase().contains("NOT")) {
			isOptable = "false";
		}

		if (testCase.isTestSuccessful()) {
			try {
				flag = DemandResponseUtils.setDemandResponse_(testCase, tempOffset_dutyCyle, phases,
						Integer.parseInt(start_time), data_DR, isOptable,
						String.valueOf((int) (Math.random() * (100000 - 1000 + 1) + 1000)));
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
