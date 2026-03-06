package com.resideo.keywords.app.diy_common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ThermostatLocationName extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	DIYScreen diy;
	String devicename;

	public ThermostatLocationName(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing precondition </b>");
			try {
				devicename = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim().toUpperCase();
				diy = new DIYScreen(testCase);
				if (devicename.contains("CASPIAN")) {
					if ((testCase.getPlatform().toUpperCase().contains("IOS") && diy.isLocalNetworkPopUP())) {
						HomeUtils.printLogforSteps(testCase, flag, "Is Local Network PopUP Screen ?.,");
						flag = flag && diy.clickOnEnableLocalNetwork_iOS(testCase);
						HomeUtils.printLogforSteps(testCase, flag,
								"Enabled check box for Accept Local Network PopUp ?.,");
						flag = flag && diy.clickOnNextLocalNetwork_iOS();
					}
				}
				if (diy.isChooseLocationScreen()) {
					Keyword.ReportStep_Pass(testCase, "User in Choose location, where thermosat need to setup");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Execution failed due to Location screen not visible After Wifi Connect, 3 mins Waiting timeout");
					flag = false;
				}
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.toString());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Given(value = "^user select location name as (.+)$")
	@Override
	@KeywordStep(gherkins = "^user select location name as (.+)$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {

			String locationName = exampleData.get(0);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				flag = DIYUtils.chooseLocationStatNeedToInstall(testCase, diy, locationName);
				if (flag) {
					SystemState.getStatus().IsThermostatLocationSet(flag);
					Keyword.ReportStep_Pass(testCase, "Location is choosen successfully");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Scenario steps failed");
				}

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

		return flag;
	}
}
