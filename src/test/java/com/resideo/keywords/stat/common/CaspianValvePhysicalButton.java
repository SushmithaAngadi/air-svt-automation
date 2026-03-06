package com.resideo.keywords.stat.common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.relay.RelayConfiguration;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.cucumber.java.en.Given;

public class CaspianValvePhysicalButton  extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue ="";
	DIYScreen diy;
	KeepAppActive appActive;
	public CaspianValvePhysicalButton(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		appActive = new KeepAppActive(testCase);

		appActive.start();
		return flag;

	}

	@Given(value = "Perform Button action on Caspian Device, Action is (.+)")
	@Override
	@KeywordStep(gherkins = "^Perform Button action on Caspian Device, Action is (.+)$")
	public boolean keywordSteps() {
//		if (testCase.isTestSuccessful() && flag) {

			String ISUType = exampleData.get(0);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				if(ISUType.toUpperCase().equals("HARD_RESET")) {
					flag = flag && StatCommands.getInstance().cattCommandsStub.caspianDoManualHardReset(String_Msg.newBuilder().setStrVal("").build()).getBoolVal();
				}else if(ISUType.toUpperCase().equals("PAIRING")) {
					flag = flag && StatCommands.getInstance().cattCommandsStub.caspianSetPairingMode(String_Msg.newBuilder().setStrVal("").build()).getBoolVal();
				}else if(ISUType.toUpperCase().equals("VALVE_CONTROL")) {
					flag = flag && StatCommands.getInstance().cattCommandsStub.caspainButtonShortPress(String_Msg.newBuilder().setStrVal("").build()).getBoolVal();
				}else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,"Not Added Button Action name in Code, User Requested Action is "+ISUType);
				}
				
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e);
			}

//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
//					"Scenario steps failed already, hence skipping the verification");
//		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		System.out.println("Exceution is "+flag);
		appActive.requestStop();

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (appActive.isAlive())
			appActive.requestStop();
		return flag;
	}
}
