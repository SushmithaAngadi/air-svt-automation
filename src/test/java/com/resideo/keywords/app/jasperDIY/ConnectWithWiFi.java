package com.resideo.keywords.app.jasperDIY;

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

public class ConnectWithWiFi extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	String device;
	public boolean flag = true;
	String wifiConnected_Status;

	public ConnectWithWiFi(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
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

			wifiConnected_Status = DIYUtils._Do_Action_ThermostatConnectedWithExpectedNetwork(testCase, diy);
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
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "Connect with WiFi")
	@Override
	@KeywordStep(gherkins = "^Connect with WiFi$")
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