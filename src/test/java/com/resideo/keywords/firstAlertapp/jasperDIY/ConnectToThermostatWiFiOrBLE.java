//package com.resideo.keywords.firstAlertapp.jasperDIY;
//
//import java.util.ArrayList;
//
//import com.resideo.commons.coreframework.AfterKeyword;
//import com.resideo.commons.coreframework.BeforeKeyword;
//import com.resideo.commons.coreframework.Keyword;
//import com.resideo.commons.coreframework.KeywordStep;
//import com.resideo.commons.coreframework.SuiteConstants;
//import com.resideo.commons.coreframework.TestCaseInputs;
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
//import com.resideo.commons.mobile.MobileUtils;
//import com.resideo.commons.report.FailType;
//import com.resideo.system.utils.SystemState;
//import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
//import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
//
//import io.cucumber.java.en.Given;
//
//public class ConnectToThermostatWiFiOrBLE extends Keyword {
//
//	private TestCases testCase;
//	FirstAlertDIYScreen diy;
//	public boolean flag = true;
//	ArrayList<String> exampleData;
//	String flowType;
//
//	public ConnectToThermostatWiFiOrBLE(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
//		this.testCase = testCase;
//		this.exampleData = exampleData;
//	}
//
//	@Override
//	@BeforeKeyword
//	public boolean preCondition() {
//		flowType = exampleData.get(0).toUpperCase();
//		SystemState.getStatus().ble_Ap_flow(flowType);
//		if (testCase.isTestSuccessful()) {
//			diy = new FirstAlertDIYScreen(testCase);
//			Keyword.ReportStep_Pass(testCase,
//					"<b>Start Executing Pre Condition for Connect to Thermostat " + exampleData.get(0) + " </b>");
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
//		}
//		return flag;
//	}
//
//	@Given(value = "^Connect with Thermostat (.+) in first alert App$")
//	@Override
//	@KeywordStep(gherkins = "^Connect with Thermostat (.+) in first alert App$")
//	public boolean keywordSteps() {
//
//		if (testCase.isTestSuccessful()) {
//			Keyword.ReportStep_Pass(testCase,
//					"<b> Start Executing Connect to thermostat " + exampleData.get(0) + "  </b>");
//			try {
//				String deviceNeedToInstall = SuiteConstants
//						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
//
//				if (deviceNeedToInstall.contains("JASPER_SENIOR_NA_TRADE")
//						|| deviceNeedToInstall.contains("JASPER_SENIOR_NA_RETAIL")) {
//					if (flowType.contains("BLE")) {
//						flag = flag && FirstAlert_DIYUtils.connectToJasperThermostatBle(testCase, diy);
//					} else {
//						flag = flag && FirstAlert_DIYUtils.connectToJasperThermostatWifi(testCase, diy);
//					}
//
//					if (diy.isTwoMoreSteps(10)) {
//						if (diy.clickonNextButton()) {
//							flag = true;
//						} else {
//							flag = false;
//							ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//									"Failed to click on next button, in two more step screen");
//						}
//					} else {
//						flag = false;
//						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Failed to confirm pairing success, two more step screen is not visible");
//					}
//
//					if (flag)
//						Keyword.ReportStep_Pass(testCase, "Resideo Pro APP Sucessfully connected to thermostat "
//								+ exampleData.get(0) + "  and Pin configuration done");
//					else
//						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Wifi and Pin configuration scenario failed");
//				} else {
//					System.out.println("Device not availble ");
//					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
//							"Device Need to add in methods, flow need to determine");
//					flag = false;
//				}
//
//			} catch (Exception e) {
//				flag = false;
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
//			}
//
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
//
//		if (!testCase.isTestSuccessful()) {
//			if (flag) {
//				if (exampleData.get(0).toUpperCase().contains("AP MODE")) {
//					for (int i = 0; i < 4; i++) {
//						String pageSource = testCase.getMobileDriver().getPageSource();
//						if (pageSource.toUpperCase().contains("WIFI") || (pageSource.contains("com.android.settings")
//								|| pageSource.toUpperCase().contains("WI-FI")
//								|| pageSource.toUpperCase().contains("com.apple.Preferences"))) {
//							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//									"Failure Occured in Previous Test Scenario, Hence closing Wifi screen");
//							flag = MobileUtils.pressBackButton(testCase);
//						} else if (pageSource.toUpperCase().contains("com.resideo.android")
//								|| pageSource.toUpperCase().contains("com.resideo.rezi_pro")
//								|| pageSource.toUpperCase().contains("com.resideo.wick")
//								|| pageSource.toUpperCase().contains("com.resideo.firstalert")) {
//							break;
//						}
//					}
//				}
//			}
//		}
//
//		SystemState.getStatus().ble_AP_Connection_Status(flowType);
//
//		System.out.println("Exceution is " + flag);
//		return flag;
//	}
//
//}