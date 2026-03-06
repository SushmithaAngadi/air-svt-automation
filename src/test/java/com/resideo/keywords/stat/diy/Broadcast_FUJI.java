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

import io.cucumber.java.en.Given;

public class Broadcast_FUJI extends Keyword {
	private TestCaseInputs inputs;
	private TestCases testCase;
	String deviceUnderTest;
	public boolean flag = true;
	ArrayList<String> exampleData;
	String screenName;
	String broadcastType;

	public Broadcast_FUJI(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		screenName = exampleData.get(0).toUpperCase().trim();
		Keyword.ReportStep_Pass(testCase,
				"<b>Executing Pre Condition from the keyword, User BroadCast FUJI device for Registration from "
						+ screenName + " Screen </b>");
		if (testCase.isTestSuccessful()) {
			try {
				if (screenName.contains("HOME")) {
					flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
							Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_SYSTEM_RESET_DEFAULT_NVM).build())
							.getBoolVal();
				} else {
					flag = StatCommands.getInstance().cattCommandsStub.setResetFJ(
							Stat_Reset_FJ.newBuilder().setResetMode(Stat_Reset_FJ.ResetMode.AAT_FACTORY_RESET).build())
							.getBoolVal();
				}
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Given(value = "^user broadcast FUJI device for registration from (.+) screen$")
	@Override
	@KeywordStep(gherkins = "^user broadcast FUJI device for registration from (.+) screen$")
	public boolean keywordSteps() throws KeywordException {
		Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
		if (flag && testCase.isTestSuccessful()) {
			try {
				deviceUnderTest = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
						.toUpperCase();

				if (deviceUnderTest.contains("FUJI")) {
					if (screenName.contains("HOME")) {
						SystemState.getStatus().isfromStartSetup(false);
						flag = StatCommands.getInstance().cattCommandsStub
								.setButtonsClick(
										ButtonMsg.newBuilder().addFjButton(Fuji_Buttons.BUTTON_LEFT_MIDDLE).build())
								.getBoolVal();
						flag = flag && StatCommands.getInstance().cattCommandsStub
								.setButtonsClick(
										ButtonMsg.newBuilder().addFjButton(Fuji_Buttons.BUTTON_RIGHT_DOWN).build())
								.getBoolVal();
						flag = flag && StatCommands.getInstance().cattCommandsStub
								.setButtonsClick(
										ButtonMsg.newBuilder().addFjButton(Fuji_Buttons.BUTTON_LEFT_BOTTOM).build())
								.getBoolVal();

					} else {
						SystemState.getStatus().isfromStartSetup(true);
						flag = StatCommands.getInstance().cattCommandsStub
								.setButtonsClick(
										ButtonMsg.newBuilder().addFjButton(Fuji_Buttons.BUTTON_LEFT_MIDDLE).build())
								.getBoolVal();
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
							"This keyword supports only FUJI device");
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
		return flag;
	}

}
