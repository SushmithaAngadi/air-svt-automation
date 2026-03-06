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
import com.resideo.system.utils.ResilientSleep;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.WifiStatus_Thermostat;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;
import com.resideo.utils.web.WebController;

import io.cucumber.java.en.Then;

public class ConnectToWiFi extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	ArrayList<String> exampleData;

	public ConnectToWiFi(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {

		return flag;
	}

//	configure the thermostat "invalid" wifi ssid name "use router data" ,password "" and security type as ""
	@Then(value = "^configure the thermostat (.+) wifi ssid name (.+) ,password (.+) and security type as (.+)$")
	@Override
	@KeywordStep(gherkins = "^configure the thermostat (.+) wifi ssid name (.+) ,password (.+) and security type as (.+)$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				boolean isValid = true;
				Duration timeout = Duration.ofMinutes(2);
				if (exampleData.get(0).toUpperCase().contains("INVALID")) {
					isValid = false;
					timeout = Duration.ofMinutes(1);
				}

				String ssidName = exampleData.get(1);
				String ssidPassword = exampleData.get(2);
//				WifiSecurityMode ssidSecurity = WebController.securityType_nonRoutermode(exampleData.get(3));
//				if (ssidName.toUpperCase().contains("ROUTER")) {
//					ssidName = WebController.router_SSID_Name();
//					ssidPassword = WebController.router_SSID_Password();
//					ssidSecurity = WebController.securityType();
//				}
				
//				WifiSecurityMode ssidSecurity = WebController.securityType_nonRoutermode(exampleData.get(3));
				WifiSecurityMode ssidSecurity = null;
				if (ssidName.toUpperCase().contains("ROUTER")) {
					ssidName = WebController.router_SSID_Name();
					ssidPassword = WebController.router_SSID_Password();
					ssidSecurity = WebController.securityType();
				} else {
					ssidSecurity = WebController.getSecurityType(exampleData.get(3).toUpperCase());
				}

				if (ssidSecurity.toString().contains("WEP")) {
					ssidPassword = WebController.router_SSID_Password();
				}
				StatCommands.getInstance().cattCommandsStub
						.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(true).build());
				ResilientSleep.silentSleep(45000);
				StatCommands.getInstance().cattCommandsStub
						.setNetworkSecurity(WifiSecurityModeMsg.newBuilder().setMode(ssidSecurity).build());
				ResilientSleep.silentSleep(2000);
				StatCommands.getInstance().cattCommandsStub
						.setNetworkName(String_Msg.newBuilder().setStrVal(ssidName).build());
				ResilientSleep.silentSleep(2000);
				StatCommands.getInstance().cattCommandsStub
						.setNetworkPassword(String_Msg.newBuilder().setStrVal(ssidPassword).build());
				ResilientSleep.silentSleep(2000);
				Keyword.ReportStep_Pass(testCase, "Network configurations...");
				Keyword.ReportStep_Pass(testCase, "Network name : " + ssidName.trim());
				Keyword.ReportStep_Pass(testCase, "Network password : " + ssidPassword.trim());
				Keyword.ReportStep_Pass(testCase, "Network security type : " + ssidSecurity.toString());
				Thread.sleep(2000);
				StatCommands.getInstance().cattCommandsStub
						.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(false).build());

				ResilientSleep.silentSleep(45000);
				flag = WifiStatus_Thermostat.getWifiConfigurationStatus(testCase, timeout, isValid, ssidName);
				
				if(flag) {
					WebController.changeWifiSSID_Password(ssidName, ssidPassword, ssidSecurity.toString(), null);
				}

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to set network configuration");
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
			}
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