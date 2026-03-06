package com.resideo.keywords.stat.diy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.jasper_common.Jasper_Houdini_BroadCast_Utils;

import io.cucumber.java.en.Given;

public class BroadCast_T5_T6_NA_EMEA extends Keyword {
	private TestCaseInputs inputs;
	private TestCases testCase;
	String deviceUnderTest;
	public boolean flag = true;
	ArrayList<String> exampleData;
	String screenName;
	String broadcastType;

	public BroadCast_T5_T6_NA_EMEA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {

		broadcastType = exampleData.get(0).toUpperCase().trim();
		screenName = exampleData.get(1).toUpperCase().trim();
		Keyword.ReportStep_Pass(testCase, "<b>Executing Pre Condition from the keyword, User BroadCast " + broadcastType
				+ " in device for Registration from " + screenName + " Screen </b>");
		if (testCase.isTestSuccessful()) {
			if (screenName.contains("HOME")) {

			} else {
				String strr = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
						.getStrVal();
				if (strr.toUpperCase().contains("SETUP") || strr.toUpperCase().contains("SET")) {
					Keyword.ReportStep_Pass(testCase, "Thermostat is in expected screen : SETUP");
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Stat is not in expected screen : SETUP");
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Stat Factory Reset was not successfull");
					flag = false;
				}
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Given(value = "^user broadcast (.+) in device for registration from (.+) screen$")
	@Override
	@KeywordStep(gherkins = "^user broadcast (.+) in device for registration from (.+) screen$")
	public boolean keywordSteps() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (flag && testCase.isTestSuccessful()) {
			try {
				deviceUnderTest = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
						.toUpperCase();
				if (screenName.contains("HOME")) {
					SystemState.getStatus().isfromStartSetup(false);
					flag = Jasper_Houdini_BroadCast_Utils._BroadCastJasper_fromHomeScreen(testCase, deviceUnderTest,
							broadcastType);
				} else {
					SystemState.getStatus().isfromStartSetup(true);
					flag = Jasper_Houdini_BroadCast_Utils._BroadCastJasper_fromStartSetup(testCase, deviceUnderTest,
							broadcastType);
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
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
		Keyword.ReportStep_Pass(testCase, "<b>Executing Post Condition from the keyword, User BroadCast "
				+ broadcastType + " in device for Registration from " + screenName + " Screen </b>");
		if (testCase.isTestSuccessful() && flag) {
			if (screenName.contains("START") && broadcastType.contains("BLE")
					&& deviceUnderTest.contains("JASPER_SENIOR_NA_RETAIL")) {
				if (Jasper_Houdini_BroadCast_Utils.ConfirmJapserDeviceBroadcasting_Retail(testCase)) {
					Keyword.ReportStep_Pass(testCase, "Device successfully started to broadcast");
					flag = true;
					Keyword.ReportStep_Pass(testCase,
							"Need to find this Device Name: " + SystemState.getStatus().getTstatName());
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Unable to verify device broadcast");
				}
			} else if (deviceUnderTest.contains("JASPER")) {
				if (Jasper_Houdini_BroadCast_Utils.ConfirmJapserDeviceBroadcasting(testCase)) {
					Keyword.ReportStep_Pass(testCase, "Device successfully started to broadcast");
					flag = true;
					String TstatName_Wifi = DIYUtils.getjasperThermostatNameForWifiConnect(testCase, inputs);
					Keyword.ReportStep_Pass(testCase, "Need to find this Device Name: " + TstatName_Wifi);
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Unable to verify device broadcast");
				}
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		System.out.println("Exceution is " + flag);

		return flag;
	}

}
