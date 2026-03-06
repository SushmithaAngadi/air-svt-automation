package com.resideo.keywords.arduino;

import java.util.ArrayList;
import java.util.Date;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.relay.RelayConfiguration;
import io.cucumber.java.en.Given;

//User try mulitple "Wifi" reset using "Arduino"
public class SwitchReset extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String switchName;
	String hardwareName;

	public SwitchReset(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			switchName = exampleData.get(0).toUpperCase();
			hardwareName = exampleData.get(0).toUpperCase();
			RelayConfiguration.getSerialPort().openPort();
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Given(value = "^User try mulitple (.+) reset using (.+)$")

	@Override
	@KeywordStep(gherkins = "^User try mulitple (.+) reset using (.+)$")
	public boolean keywordSteps() {
//		if (testCase.isTestSuccessful()) {
			for (int i = 0; i < 3; i++) {
				RelayConfiguration.RelayCommand(60000);
				try {
					System.out.println(new Date());
					Thread.sleep(300000);
					System.out.println(new Date());
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					RelayConfiguration.getSerialPort().closePort();
				}
				System.out.println("Trail count is " + (i + 1));
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
		return flag;
	}
}
