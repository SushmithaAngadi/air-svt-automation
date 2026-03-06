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
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg.Fuji_Buttons;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset_FJ;
import com.resideo.utils.stat.mqtt.MqttManager;

import io.cucumber.java.en.Given;

public class Broadcast_Denali extends Keyword {
	private TestCaseInputs inputs;
	private TestCases testCase;
	String deviceUnderTest;
	public boolean flag = true;
	ArrayList<String> exampleData;
	String screenName;
	String broadcastType;

	public Broadcast_Denali(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			return flag;
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	/*
	 * Given user broadCast the device from "Home Screen" 
	 * Given user broadCast the device from "Control Hub"
	 */
	@Given(value = "^user broadCast the device from (.+)$")
	@Override
	@KeywordStep(gherkins = "^user broadCast the device from (.+)$")
	public boolean keywordSteps() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (flag && testCase.isTestSuccessful()) {
			String enable_disable = exampleData.get(0).toUpperCase().trim();
			try {
					flag = MqttManager.enableDisableBroadCasting("TRUE",testCase,false);
				
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
		return flag;
	}

}