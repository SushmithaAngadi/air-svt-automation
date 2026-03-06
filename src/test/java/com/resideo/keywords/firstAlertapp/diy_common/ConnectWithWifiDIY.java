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
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ConnectWithWifiDIY extends Keyword {
	private TestCases testCase;
	ArrayList<String> exampleData;
	FirstAlertDIYScreen diy;
	String device;
	public boolean flag = true;
	String wifiConnected_Status;
	boolean isInvalidPIN=false;
	Integer setValue =-1;

	public ConnectWithWifiDIY(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for Connect with WI-FI network  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				diy = new FirstAlertDIYScreen(testCase);
				if(diy.isOneMoreStepScreenAvailable(10)) {
					flag = flag && diy.clickOnNextButton();
				}
			diy = new FirstAlertDIYScreen(testCase);
			boolean isFactoryReset = false;
			boolean iswifiNeedconfigured = exampleData.get(0).toUpperCase().contains("ALWAYS") ? true : false;
			if (exampleData.get(1).toUpperCase().contains("INCORRECT") ) {
				isInvalidPIN=true;
				setValue =Integer.parseInt(exampleData.get(1).replaceAll("\\D+", " ").trim().replaceAll(" +", " "));
			}
			if (exampleData.get(2).toUpperCase().contains("YES") || exampleData.get(1).toUpperCase().contains("TRUE")) {
				isFactoryReset = true;
			} else if (exampleData.get(2).toUpperCase().contains("NO")
					|| exampleData.get(2).toUpperCase().contains("FALSE")) {
				isFactoryReset = false;
			}

			wifiConnected_Status = FirstAlert_DIYUtils._Do_Action_ThermostatConnectedWithExpectedNetwork(testCase, diy,
					iswifiNeedconfigured, isFactoryReset);
			if (wifiConnected_Status.equals("change") || wifiConnected_Status.equals("not configured")) {
				flag = true;
			} else if (wifiConnected_Status.contains("should not connect with wifi") && isFactoryReset) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"failed due to wifi already configured, app should show the wifi scan list for factory device");
				flag = false;
			}
			} catch (Exception e) {
				System.out.println(e.getMessage());
				setValue=0;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		
		return flag;
		
	}

	@Given(value = "^First Alert app wifi (.+) configure the wifi with (.+), is device factory reset (.+)$")
	@Override
	@KeywordStep(gherkins = "^First Alert app wifi (.+) configure the wifi with (.+), is device factory reset (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Connect with WI-FI network  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				if (wifiConnected_Status.equals("change") || wifiConnected_Status.equals("not configured")) {
					flag = flag && FirstAlertDIYScreen.chooseNetworktoConnectYourThermostat(testCase, diy, isInvalidPIN,setValue);
				}
				flag = flag && FirstAlertDIYScreen.confirmWifiConfigurationIsCompleted(testCase, diy);
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