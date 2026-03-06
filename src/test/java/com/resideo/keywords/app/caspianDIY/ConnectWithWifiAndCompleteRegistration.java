package com.resideo.keywords.app.caspianDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.CaspianUtils;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class ConnectWithWifiAndCompleteRegistration extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	static String device;

	public boolean flag = true;

	public ConnectWithWifiAndCompleteRegistration(TestCases testCase, TestCaseInputs inputs) {
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
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")
					|| device.contains("CASPIAN") && diy.isEnsure24GHZNetworkPopUp()) {
				flag = flag && diy.clickOn24GHZPopUpOKButton();
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "Connect Caspian to WiFi and Complete Registration")
	@Override
	@KeywordStep(gherkins = "^Connect Caspian to WiFi and Complete Registration$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase,
				"<b> Start Executing Keyword Step for Connect Caspian to WiFi and Complete Registration  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				if (DIYUtils.chooseNetworktoConnectYourThermostat(testCase, diy)) {
					if (CaspianUtils.confirmWifiConfigurationIsCompletedInCaspian(testCase, diy)) {
						flag = CaspianUtils.completeRegistrationInCaspian(testCase, diy);
					} else {
						flag = false;
					}
				} else {
					flag = false;
				}

			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able connect with wifi, Exception occured, Exception is :" + e);
				flag = false;

			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (flag && diy.isTurnOffFlightMode()) {
			flag = diy.clickOnSkipTurnOffFlightMode();
		}
		if (diy.isSucessIsVisible()) {
			flag = diy.clickOnNextButton("Your L5 Leak Protection Valve is now configured and added to your account");

		} else if (diy.isDeviceregisterScreen()) {

			flag = diy.clickOnNextButton("Your L5 Leak Protection Valve is now configured and added to your account");
		} else {
			System.out.println("next button not available");
		}
		if (diy.isSkipTurnOffFlightMode()) {
			flag = diy.clickOnSkipTurnOffFlightMode();
		}

		return flag;
	}

}