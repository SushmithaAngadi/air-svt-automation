package com.resideo.keywords.app.jasperDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ConnectThermostatWithMobile extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	private TestCaseInputs inputs;
	public boolean flag = true;
	String ISUValue = "";
	DIYScreen diy;

	public ConnectThermostatWithMobile(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b>Start Executing Pre Condition for Connect to Thermostat Wifi Network </b>");
			diy = new DIYScreen(testCase);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^connect with thermostat in (.+)$")
	@Override
	@KeywordStep(gherkins = "^connect with thermostat in (.+)$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Connect to thermostat wifi  </b>");
			try {
				String deviceNeedToInstall = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
				String TstatName_Wifi = SystemState.getStatus().getTstatName();
				if (deviceNeedToInstall.contains("JASPER_SENIOR_NA_TRADE")
						|| deviceNeedToInstall.contains("JASPER_SENIOR_NA_RETAIL")
						|| deviceNeedToInstall.contains("JASPER_SENIOR_EMEA")
						|| deviceNeedToInstall.contains("HOUDINI")) {
					if (!deviceNeedToInstall.contains("HOUDINI")
							&& exampleData.get(0).toUpperCase().contains("AP MODE")) {
						flag = flag && DIYUtils.connectToJasperThermostatWifi(testCase, inputs, diy, TstatName_Wifi);
						if (flag)
							Keyword.ReportStep_Pass(testCase,
									"HH App Sucessfully connected thermostat Wifi in Wifi Settings and Pin configuration done");
						else
							ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Wifi and Pin configuration scenario failed");
					} else {
						if (DIYUtils.connectToBle_ExactThermostat(testCase, diy)) {
							Keyword.ReportStep_Pass(testCase,
									"Resideo App Sucessfully connected thermostat With BLE and Pin configuration done");
							flag = true;
						} else {
							ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"BLE and Pin configuration scenario failed");
							flag = false;
						}
					}
				} else {
					System.out.println("Device not availble ");
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
		if (flag) {
			if (exampleData.get(0).toUpperCase().contains("AP MODE")) {
				for (int i = 0; i < 4; i++) {
					String pageSource = testCase.getMobileDriver().getPageSource();
					if (pageSource.toUpperCase().contains("WIFI") || (pageSource.contains("com.android.settings")
							|| pageSource.toUpperCase().contains("WI-FI"))) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failure Occured in Previous Test Scenario, Hence closing Wifi screen");
						flag = MobileUtils.pressBackButton(testCase);
					} else if (pageSource.toUpperCase().contains("com.resideo.android")) {
						break;
					}
				}
			}
		}
		return flag;
	}

}