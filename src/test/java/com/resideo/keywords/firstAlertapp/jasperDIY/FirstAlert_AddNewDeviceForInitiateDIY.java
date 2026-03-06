//package com.resideo.keywords.firstAlertapp.jasperDIY;
//
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.resideoPro_app.ReziDIYUtils;
//import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
//import io.cucumber.java.en.Given;
//
//public class FirstAlert_AddNewDeviceForInitiateDIY extends Keyword {
//
//	private TestCases testCase;
//	private TestCaseInputs inputs;
//	ReziDIYScreen diy;
//	public boolean flag = true;
//
//	public FirstAlert_AddNewDeviceForInitiateDIY(TestCases testCase, TestCaseInputs inputs) {
//		this.inputs = inputs;
//		this.testCase = testCase;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() {
//
//		if (testCase.isTestSuccessful()) {
//			Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  </b>");
//			diy = new ReziDIYScreen(testCase);
//			if (diy.isExpectedScreen(testCase, "dashboard")) {
//				flag = diy.clickOnSetupProductButton();
//			}
//		}
//
//		return flag;
//	}
//
//	@Given(value = "Add new device for Configuration in first alert app")
//	@Override
//	@KeywordStep(gherkins = "^Add new device for Configuration in first alert app$")
//	public boolean keywordSteps() {
//
//		if (testCase.isTestSuccessful()) {
//			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for select Device from List  </b>");
//			flag = ReziDIYUtils.selectdeviceforDIYByUserExpects(testCase, diy);
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
//		if (testCase.isTestSuccessful()) {
//			Keyword.ReportStep_Pass(testCase, "<b>Start Executing Post Condition for Install device  </b>");
////		if ((testCase.getPlatform().toUpperCase().contains("ANDROID") && diy.isTheThermostatOnWall()) || (testCase.getPlatform().toUpperCase().contains("IOS")&& diy.isLocalNetworkPopUP())) {
////			Keyword.ReportStep_Pass(testCase, "<b style=\"color:blue\"> Executed Post Condition for Install device and its succeed </b>");
////			flag = true;
////			
////		}else {
////			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Thermostat on wall screen not visible");
////			flag = false;
////		}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
//		}
//		System.out.println("Exceution is " + flag);
//		return flag;
//
//	}
//
//}