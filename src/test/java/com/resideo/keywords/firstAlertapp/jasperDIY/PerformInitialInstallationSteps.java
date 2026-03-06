//package com.resideo.keywords.firstAlertapp.jasperDIY;
//
//import java.util.ArrayList;
//
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
//
//import io.cucumber.java.en.Given;
//
//public class PerformInitialInstallationSteps extends Keyword {
//
//	private TestCases testCase;
//
//	public boolean flag = true;
//	ArrayList<String> exampleData;
//
//	public PerformInitialInstallationSteps(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
//		this.testCase = testCase;
//		this.exampleData = exampleData;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() {
////		Keyword.ReportStep_Pass(testCase,
////				"<b>Start Executing Pre Condition for Initial Installation, Local network option Handles in Precondition for IOS  </b>");
//
//		return flag;
//	}
//
//	@Given(value = "^Perform first alert app initial installtion setup from (.+) using (.+)$")
//	@Override
//	@KeywordStep(gherkins = "^Perform first alert app initial installtion setup from (.+) using (.+)$")
//	public boolean keywordSteps() {
//		Keyword.ReportStep_Pass(testCase, "<b> Perform first alert app initial installtion setup  </b>");
//		if (testCase.isTestSuccessful()) {
//			flag = FirstAlert_DIYUtils.T5_T6InitialInstallationSteps(testCase, exampleData.get(0).toUpperCase(),
//					exampleData.get(1).toUpperCase());
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
//		}
//
//		return flag;
//	}
//
//	@Override
//	@AfterKeyword
//	public boolean postCondition() {
//		System.out.println("Exceution is " + flag);
//		return flag;
//	}
//
//}