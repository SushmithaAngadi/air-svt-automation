package com.resideo.keywords.app.jasperDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ChooseDeviceName extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	DIYScreen diy;

	public ChooseDeviceName(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {

			try {
				diy = new DIYScreen(testCase);
				if (diy.isChooseYourThermostatName()) {
					Keyword.ReportStep_Pass(testCase, "Expected screen is present: , Screen name is Name your Thermostat");
				}else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "User Expected Screen is not visible, check the screenshot for more info");
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

	@Given(value = "^choose (.+) thermostat name$")
	@Override
	@KeywordStep(gherkins = "^choose (.+) thermostat name$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String deviceName = exampleData.get(0);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {

				if(deviceName.toUpperCase().contains("DEFAULT")) {
					flag = flag && DIYUtils.chooseNameYourThermostat(testCase, diy);
					if(flag) {
						SystemState.getStatus().IsThermostatNameSet(flag);
					}
				}else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,"Need to add Non Default Thermostat name");
				}
				if(flag) {
					Keyword.ReportStep_Pass(testCase, "Choosen Device name is "+SystemState.getStatus().getTstatName()+" selected successfully");
				}else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,"Need to add Non Default Thermostat name");
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
		if (!diy.isChooseYourThermostatName()) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Choosen Device name is "+SystemState.getStatus().getTstatName()+" selected successfully");
		}else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,"Scenario Failed, check the enter device name screen should not be visible");
			flag = false;
		}
		
		return flag;
	}
}
