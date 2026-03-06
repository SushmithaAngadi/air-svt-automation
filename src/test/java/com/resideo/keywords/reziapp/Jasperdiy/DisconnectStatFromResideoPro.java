package com.resideo.keywords.reziapp.Jasperdiy;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.CustomerUtils;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideoPro_app.screen.ReziSystemTestScreen;

import io.cucumber.java.en.Given;

public class DisconnectStatFromResideoPro extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ReziDIYScreen diy;

	public boolean flag = true;

	public DisconnectStatFromResideoPro(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		return flag;
	}

	@Given(value = "^Disconnect Tstat from Resideo Pro$")
	@Override
	@KeywordStep(gherkins = "^Disconnect Tstat from Resideo Pro$")
	public boolean keywordSteps() {
		
		if (testCase.isTestSuccessful()) {
			diy = new ReziDIYScreen(testCase);
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword for ISU COnfirmation  </b>");
			
			if(SystemState.getStatus().ble_Ap_flow().contains("BLE") ||!SystemState.getStatus().isThermostat_DisconnectedAlready()) {
				if (CustomerUtils.disconnectStatFromResideoPro(testCase, diy)) {
					Keyword.ReportStep_Pass(testCase, "is Thermostat disconnected from Resideo Pro ?  " + flag);
					flag = true;
				} else {
					flag = false;
					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Scenario failed Thermostat Disconnect from Resideo pro");
				}
			}else {
				Keyword.ReportStep_Pass(testCase, "Thermostat doesn't need to disconnect, Already disconnected");
				flag = true;
			}
			
//			if (SystemState.getStatus().ble_AP_Connection_Status() != null) {
//				if (SystemState.getStatus().ble_AP_Connection_Status().contains("BLE")) {
//					if (CustomerUtils.disconnectStatFromResideoPro(testCase, diy)) {
//						Keyword.ReportStep_Pass(testCase, "is Thermostat disconnected from Resideo Pro ?  " + flag);
//						flag = true;
//					} else {
//						flag = false;
//						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Scenario failed Thermostat Disconnect from Resideo pro");
//					}
//
//				} else if (SystemState.getStatus().ble_AP_Connection_Status().contains("AP")) {
//					Keyword.ReportStep_Pass(testCase, "Thermostat doesn't need to disconnect");
//					flag = true;
//				}
//			} else {
//				if (CustomerUtils.disconnectStatFromResideoPro(testCase, diy)) {
//					Keyword.ReportStep_Pass(testCase, "is Thermostat disconnected from Resideo Pro ?  " + flag);
//					flag = true;
//				} else {
//					flag = false;
//					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Scenario failed Thermostat Disconnect from Resideo pro");
//				}
//			}

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
		if (testCase.isTestSuccessful()) {
			if (diy.IswelcomeToResideoPro(80)) {
				ReportStep_Pass(testCase, "Sucessfully Navigated to Welcome Screen");
				flag = true;
			} else {
				flag = false;
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Welcome screen not visible");
			}

		} else {
			flag = false;
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario failed Thermostat Disconnect from Resideo pro");
		}
		System.out.println(testCase.getMobileDriver().getPageSource());
		return flag;
	}

}