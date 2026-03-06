package com.resideo.keywords.device.integration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SerialInterfaceArduino;
import com.resideo.utils.aat.AATManager;
import com.resideo.utils.aat.ThermostatController;
import com.fazecast.jSerialComm.SerialPort;


import io.cucumber.java.en.Given;

public class Start_Wifi_Integration_Jinterface extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public Start_Wifi_Integration_Jinterface(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {

		return flag;
	}

	/**
	*Then user sets the "IAS Sensor" to "Enrolling mode"
	*Then user sets the "OAS Sensor" to "Enrolling mode"
	**/
	
	@Given(value = "^user sets the (.+) to (.+)$")
	@Override
	@KeywordStep(gherkins = "^user sets the (.+) to (.+)$")
	public boolean keywordSteps() throws KeywordException {
		flag=false;
		String deviceName = exampleData.get(0).toUpperCase();
		String mode = exampleData.get(1).toUpperCase();
		if (testCase.isTestSuccessful()) {
			try {
				String relayNo = null;
				if (deviceName.contains("IAS")) {
					relayNo = "1";
				} else if (deviceName.contains("OAS")) {
					relayNo = "2";
				} else if (deviceName.contains("NXT")) {
					relayNo = "3";
				} else if (deviceName.contains("EIM") && mode.contains("BIND")) {
					relayNo = "4";
				} else if (deviceName.contains("EIM") && mode.contains("RESET")) {
					relayNo = "6";
				} else {
					System.out.println("This device not mapped to a relay number");
					Keyword.ReportStep_Pass(testCase,
							"This device not mapped to a relay number, Device name: " + deviceName);
				}
				if (deviceName.contains("IAS") || deviceName.contains("OAS")) {
					// Not required in DIY ,It is available in System Test Repo
				}else if (deviceName.contains("NXT") && mode.contains("BIND")) {
					ThermostatController thermostatController = new ThermostatController(AATManager.getHandler());
					//Using AAT Button Actions
					thermostatController.changeButtonState(testCase, "HOLD BUTTON");
					TimeUnit.SECONDS.sleep(2);
					thermostatController.changeButtonState(testCase, "HOLD BUTTON");
					TimeUnit.SECONDS.sleep(2);
					flag=true;
				}else if (deviceName.contains("EIM") && (mode.contains("BIND") || mode.contains("RESET"))) {
					SerialInterfaceArduino.sendCommand(SerialInterfaceArduino.getActiveArduinoPort(), relayNo + "EIMBIND", "");
					TimeUnit.SECONDS.sleep(4);
					flag=true;
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				flag = false;
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
