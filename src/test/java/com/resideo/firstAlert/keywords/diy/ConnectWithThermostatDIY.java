package com.resideo.keywords.firstAlertapp.diy_common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;

import io.cucumber.java.en.Given;

public class ConnectWithThermostatDIY extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	String flowType;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public ConnectWithThermostatDIY(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		flowType = exampleData.get(0).toUpperCase();
		SystemState.getStatus().ble_Ap_flow(flowType);
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b>Start Executing Pre Condition for Connect to Thermostat in " + exampleData.get(0) + " mode </b>");
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Connect with Thermostat in (.+) mode in First Alert App$")
	@Override
	@KeywordStep(gherkins = "^Connect with Thermostat in (.+) mode in First Alert App$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Perform Resideo Pro initial installtion setup  </b>");

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing Connect to thermostat in " + exampleData.get(0) + " mode </b>");
			try {
				String deviceNeedToInstall = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
				if (deviceNeedToInstall.contains("JASPER_SENIOR_NA_TRADE")
						|| deviceNeedToInstall.contains("JASPER_SENIOR_NA_RETAIL")) {
					if (flowType.contains("BLE")) {
						flag = flag && FirstAlert_DIYUtils.ConnectThermostatOnBLE(testCase,deviceNeedToInstall);
					} else {
						flag = flag && FirstAlert_DIYUtils.connectToJasperFujiOnWifi(testCase);
					}
					if (flag)
						Keyword.ReportStep_Pass(testCase, "First alert APP Sucessfully connected to thermostat "
								+ exampleData.get(0) + "  and Pin configuration done");
					else
						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Wifi and Pin configuration scenario failed");
				} else if (deviceNeedToInstall.contains("FUJI")||deviceNeedToInstall.contains("DENALI")||deviceNeedToInstall.contains("GLENEAGLES")) {
					if (flowType.contains("BLE")) {
						flag = flag && FirstAlert_DIYUtils.ConnectThermostatOnBLE(testCase,deviceNeedToInstall);
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
								"Device doesn't support the method which is requested " + flowType);
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Device Need to add in methods, flow need to determine");
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
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
		System.out.println("Exceution is " + flag);
		return flag;
	}

}
