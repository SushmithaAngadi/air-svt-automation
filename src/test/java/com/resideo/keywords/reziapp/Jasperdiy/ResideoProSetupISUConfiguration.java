package com.resideo.keywords.reziapp.Jasperdiy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideoPro_app.ReziDIYUtils;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;

import io.cucumber.java.en.Then;

public class ResideoProSetupISUConfiguration extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue ="";
	ReziDIYScreen diy;
	private TestCaseInputs inputs;
	
	public ResideoProSetupISUConfiguration(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}


	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {

			try {
				diy = new ReziDIYScreen(testCase);
				ISUType = exampleData.get(0);
				ISUValue = exampleData.get(1);
				Keyword.ReportStep_Pass(testCase,
						"<b>Executing Pre-Condition Will check this ISU Type ::::" + ISUType + " </b>");

				flag = flag && ReziDIYUtils.isISUPerformScreen(testCase, diy, ISUType,40);
//				flag = flag && ReziDIYUtils.isISUPerformExpectedScreen(testCase, diy, ISUType,30);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;

	}

	@Then(value = "Set Rezi App ISUType (.+) to ISUValue (.+)")
	@Override
	@KeywordStep(gherkins = "^Set Rezi App ISUType (.+) to ISUValue (.+)$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String ISUType = exampleData.get(0);
			String ISUValue = exampleData.get(1);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				flag = flag && ReziDIYUtils.ISUPerformInDif(testCase, diy, ISUType, ISUValue);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
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
		System.out.println("Exceution is "+flag);
		if(flag) {
			Keyword.ReportStep_Pass(testCase, "ISU configuration is Done, ISU Type is  "+ISUType +"ISU Value is "+ISUValue);
		}else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "ISU configuration is Failed, ISU Type is  "+ISUType +"ISU Value is "+ISUValue);
		}
		
		return flag;
	}
}