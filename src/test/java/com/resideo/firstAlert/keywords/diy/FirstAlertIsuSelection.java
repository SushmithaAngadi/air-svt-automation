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

public class FirstAlertIsuSelection extends Keyword{

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue ="";
	FirstAlertDIYScreen diy;
	private TestCaseInputs inputs;

	public FirstAlertIsuSelection(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {

			try {
				diy = new FirstAlertDIYScreen(testCase);
				ISUType = exampleData.get(0);
				ISUValue = exampleData.get(1);
				Keyword.ReportStep_Pass(testCase,
						"<b>Executing Pre-Condition Will check this ISU Type ::::" + ISUType + " </b>");

				flag = flag && FirstAlert_DIYUtils.isISUPerformScreen(testCase, diy, ISUType,40);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Set configuration on First Alert APP ISUType (.+) to ISUValue (.+)$")
	@Override
	@KeywordStep(gherkins = "^Set configuration on First Alert APP ISUType (.+) to ISUValue (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Perform Resideo Pro initial installtion setup  </b>");

		if (testCase.isTestSuccessful()) {

			String ISUType = exampleData.get(0);
			String ISUValue = exampleData.get(1);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				flag = flag && FirstAlert_DIYUtils.ISUPerformInDif(testCase, diy, ISUType, ISUValue);

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
		System.out.println("Exceution is "+flag);
		if(flag) {
			Keyword.ReportStep_Pass(testCase, "ISU configuration is Done, ISU Type is  "+ISUType +"ISU Value is "+ISUValue);
		}else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "ISU configuration is Failed, ISU Type is  "+ISUType +"ISU Value is "+ISUValue);
		}
		return flag;
	}



}
