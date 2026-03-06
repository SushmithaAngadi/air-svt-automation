package com.resideo.keywords.stat.wifi;

import java.time.Duration;
import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.WifiStatus_Thermostat;
import com.resideo.utils.web.WebController;
import io.cucumber.java.en.Then;

public class CheckWifi_IP_Status extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public CheckWifi_IP_Status(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {

		return flag;
	}

	@Then(value = "^verify the connection status as (.+) from thermostat IP$")
	@Override
	@KeywordStep(gherkins = "^verify the connection status as (.+) from thermostat IP$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			String router_SSID_Name = WebController.router_SSID_Name();
			boolean iswifiConnected = true;
			Duration timeout = Duration.ofMinutes(2);
			if (exampleData.get(0).toUpperCase().contains("DIS")) {
				iswifiConnected = false;
				timeout = Duration.ofMinutes(1);
			}
			flag = WifiStatus_Thermostat.getWifiConfigurationStatus(testCase, timeout, iswifiConnected,
					router_SSID_Name);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}
