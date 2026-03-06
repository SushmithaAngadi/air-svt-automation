//package com.resideo.keywords.stat.T9_T10_T10Plus;
//
//import java.util.ArrayList;
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordException;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.report.FailType;
//import com.resideo.utils.relay.RelayConfiguration;
//import com.resideo.utils.stat.screens_Gui.GUI_Screen_Utils;
//import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;
//
//import io.cucumber.java.en.Given;
//
//public class AddEIM_IAS_OAS_Sensors extends Keyword {
//
//	private TestCases testCase;
//	ArrayList<String> exampleData;
//	public boolean flag = false;
//	String option;
//
//	public AddEIM_IAS_OAS_Sensors(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
//		this.testCase = testCase;
//		this.exampleData = data;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() throws KeywordException {
//		option = exampleData.get(0);
//		if (!option.toUpperCase().contains("NO")) {
//			ReportStep_Pass(testCase, "Intiating unerollment started");
//			RelayConfiguration.resetAllSensor();
//			ReportStep_Pass(testCase, "unerollment Completed");
//		}
//
//		return flag = true;
//	}
//
//	@Given(value = "^User enroll (.+) with Thermostat$")
//	@Override
//	@KeywordStep(gherkins = "^User enroll (.+) with Thermostat$")
//	public boolean keywordSteps() throws KeywordException {
//
////		String screenName = exampleData.get(1);
//		SetUpDevice_T9_T10_T0Plus gui = new SetUpDevice_T9_T10_T0Plus();
//		try {
//			if (gui.isEIMScreen()) {
//				if (option.toUpperCase().contains("NO")) {
//					flag = gui.clickOnEIMEnroll_unEnroll("NO");
//				} else if (option.toUpperCase().contains("EIM,OAS,IAS")) {
//					if (gui.clickOnEIMEnroll_unEnroll("YES, I HAVE AN EIM")) {
//						flag = GUI_Screen_Utils.addEIM_sensors(testCase, option);
//					} else {
//						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//								"EIM screen Yes I have an EIM is not visible");
//						flag = false;
//					}
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//							"NO OR YES, I HAVE AN EIM options only applicable, Please select Available options");
//					flag = false;
//				}
//			} else {
//				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//						"EIM screen is not visible");
//				flag = false;
//			}
//		} catch (Exception e) {
//			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
//			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//					"User enroll following sensor " + option + " ,failed");
//			flag = false;
//		}
//		return flag;
//	}
//
//	@Override
//	@AfterKeyword
//	public boolean postCondition() {
//
//		return flag = true;
//	}
//}
