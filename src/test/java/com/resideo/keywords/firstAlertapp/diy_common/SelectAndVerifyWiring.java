package com.resideo.keywords.firstAlertapp.diy_common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class SelectAndVerifyWiring extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue = "";
	FirstAlertDIYScreen diy;
	private TestCaseInputs inputs;

	public SelectAndVerifyWiring(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
			try {
				if (FaDiyScreen.isInvalidWiring(4)) {
					if(FaDiyScreen.isManuallyEnterWiresPresent()) {
					flag = flag && FaDiyScreen.clickOnManuallyEnterWires();
					}else {
						flag =false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,"Invalid Wiring Screen is not present");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,"Invalid Wiring Screen is not present");
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception raised : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^user selects (.+) wiring and verify that it is (.+) wiring$")
	@Override
	@KeywordStep(gherkins = "^user selects (.+) wiring and verify that it is (.+) wiring$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {

			String wirings = exampleData.get(0);
			boolean isValid = exampleData.get(1).toUpperCase().contains("INVALID") ? false : true;
			try {
				flag = flag && FirstAlert_DIYUtils.setAndVerifyWirings(testCase, wirings, isValid);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
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
	public boolean postCondition() {
		return flag;
	}

}
