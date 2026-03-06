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
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ConnectWithWiFi_WithCondition extends Keyword {
	/*
	 * Keyword 2 valid type Then "always" configure the thermostat wifi Then
	 * "skip if its already" configure the thermostat wifi
	 */
	private TestCases testCase;
//	private TestCaseInputs inputs;
	ArrayList<String> exampleData;
	DIYScreen diy;
	String device;
	public boolean flag = true;
	String wifiConnected_Status;

	public ConnectWithWiFi_WithCondition(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
//		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
					.toUpperCase();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  </b>");
			diy = new DIYScreen(testCase);
			boolean iswifiNeedconfigured = false;
			boolean isFactoryReset = false;
			if (exampleData.get(0).toUpperCase().contains("ALWAYS")) {
				iswifiNeedconfigured = true;
			} else if (exampleData.get(0).toUpperCase().contains("SKIP")
					&& exampleData.get(0).toUpperCase().contains("ALREADY")) {
				iswifiNeedconfigured = false;
			}

			if (exampleData.get(1).toUpperCase().contains("YES") && exampleData.get(1).toUpperCase().contains("TRUE")) {
				isFactoryReset = true;
			} else if (exampleData.get(1).toUpperCase().contains("NO")
					&& exampleData.get(1).toUpperCase().contains("FALSE")) {
				isFactoryReset = false;
			}

			wifiConnected_Status = DIYUtils._Do_Action_ThermostatConnectedWithExpectedNetwork(testCase, diy,
					iswifiNeedconfigured, isFactoryReset);
			if (wifiConnected_Status.equals("change") || wifiConnected_Status.equals("not configured")) {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")
						|| testCase.getPlatform().toUpperCase().contains("IOS")
						|| device.contains("CASPIAN") && diy.isEnsure24GHZNetworkPopUp()) {
					if (diy.isEnsure24GHZNetworkPopUp(1)) {
						Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible");
						if (diy.clickOn24GHZPopUpOKButton()) {
							Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible and clicked OK Button");
						} else {
							Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible and but not clicked OK Button");
						}
					}
				}
			} else if (wifiConnected_Status.contains("should not connect with wifi") && isFactoryReset) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"failed due to wifi already configured, app should show the wifi scan list for factory device");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^(.+) configure the thermostat wifi, is device factory reset (.+)$")
	@Override
	@KeywordStep(gherkins = "^(.+) configure the thermostat wifi, is device factory reset (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Connect with WI-FI network  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				if (wifiConnected_Status.equals("change") || wifiConnected_Status.equals("not configured")) {
					flag = flag && DIYUtils.chooseNetworktoConnectYourThermostat(testCase, diy);
				}
				flag = flag && DIYUtils.confirmWifiConfigurationIsCompleted(testCase, diy);
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able connect with wifi, Exception occured, Exception is :" + e);
				flag = false;

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

		return flag;
	}

}