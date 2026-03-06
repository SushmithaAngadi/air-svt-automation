package com.resideo.keywords.app.caspianDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.stat.KeepAppActive;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class StartBLEModePairing  extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue ="";
	DIYScreen diy;
	KeepAppActive appActive;
	public StartBLEModePairing(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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

	@Given(value = "User set to (.+) mode in Caspain device, long press for (.+) seconds")
	@Override
	@KeywordStep(gherkins = "^User set to (.+) mode in Caspain device, long press for (.+) seconds$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String ISUType = exampleData.get(0);
			String ISUValue = exampleData.get(1);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
//				RelayConfiguration.getStatus();
//				flag =RelayConfiguration.initializeSerialCommunication(15);
//				flag = flag && RelayConfiguration.setBleMode_confirmBLEinCaspian(testCase, Integer.valueOf(ISUValue));
				
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e);
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
