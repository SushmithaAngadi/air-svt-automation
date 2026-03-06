//package com.resideo.keywords.stat.diy;
//
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordException;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.SuiteConstants;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.resideo_app.DIYUtils;
//import com.resideo.utils.stat.StatCommands;
//import com.resideo.utils.stat.cattgrpccommands.HoudiniDisplayTextMsg;
//import com.resideo.utils.stat.cattgrpccommands.HoudiniDisplayTextMsg.HoudiniDisplayArea;
//import com.resideo.utils.stat.jasper_common.Jasper_Houdini_BroadCast_Utils;
//
//import io.cucumber.java.en.Given;
//
//public class PerformHoudiniStartSetup extends Keyword {
//	private TestCaseInputs inputs;
//	private TestCases testCase;
//	public boolean flag = true;
//	String deviceUnderTest;
//
//	public PerformHoudiniStartSetup(TestCases testCase, TestCaseInputs inputs) {
//		this.inputs = inputs;
//		this.testCase = testCase;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() throws KeywordException {
//		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre Condition</b>");
//		if (testCase.isTestSuccessful()) {
//			String strr = StatCommands.getInstance().cattCommandsStub.getHoudiniDisplayText(HoudiniDisplayTextMsg
//					.newBuilder().setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build()).getStrVal().trim();
//			if (strr.toUpperCase().contains("START SETUP")) {
//				Keyword.ReportStep_Pass(testCase, "Thermostat is in expected screen : START SETUP");
//				flag = true;
//			} else {
//				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Stat is not in expected screen, Current screen text Area is " + strr);
//				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//						"is Stat Factory Reset was not successfull ?..");
//				flag = false;
//			}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
//		return flag;
//	}
//
//	@Given(value = "^User perform Houdini thermostat start setup$")
//	@Override
//	@KeywordStep(gherkins = "^User perform Houdini thermostat start setup$")
//	public boolean keywordSteps() throws KeywordException {
//		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
//		if (flag && testCase.isTestSuccessful()) {
//			try {
//				deviceUnderTest = SuiteConstants
//						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
//						.toUpperCase();
//
//				if (deviceUnderTest.contains("HOUDINI")) {
//					if (!Jasper_Houdini_BroadCast_Utils.houdini_startSetup(testCase)) {
//						flag = false;
//						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Not able to set broadcast mode in thermostat");
//					}
//				} else {
//					flag = false;
//					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
//							"Not the expected device under test : " + deviceUnderTest);
//				}
//			} catch (Exception e) {
//				flag = false;
//				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Exception raised : " + e.getMessage());
//			}
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
//
//		return flag;
//	}
//
//	@Override
//	@AfterKeyword
//	public boolean postCondition() {
//		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition</b>");
//		if (testCase.isTestSuccessful() && flag) {
//			String TstatName_Wifi = DIYUtils.getDeviceMacID_deviceName_Houdini(testCase, inputs, "Tstat");
//			Keyword.ReportStep_Pass(testCase, "Need to find this Device Name: " + TstatName_Wifi);
//			flag = true;
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword/ steps failed.");
//		}
//		System.out.println("Exceution is " + flag);
//
//		return flag;
//	}
//
//}
