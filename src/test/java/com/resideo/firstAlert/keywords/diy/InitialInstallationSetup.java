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
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class PerfromInitialInstall_AP_Ble_Mode extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	private TestCaseInputs inputs;
	public boolean flag = true;
	String AP_bLE_Mode = "";
	DIYScreen diy;

	public PerfromInitialInstall_AP_Ble_Mode(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase,
				"<b>Start Executing Pre Condition for Initial Installation, Local network option Handles in Precondition for IOS  </b>");
		if (testCase.isTestSuccessful()) {
			diy = new DIYScreen(testCase);
			if (testCase.getPlatform().toUpperCase().contains("IOS")) {
				if (diy.isLocalNetworkPopUP()) {
					HomeUtils.printLogforSteps(testCase, flag, "Is Local Network PopUP Screen ?.,");
					flag = flag && diy.clickOnEnableLocalNetwork_iOS(testCase);
					HomeUtils.printLogforSteps(testCase, flag, "Enabled check box for Accept Local Network PopUp ?.,");
					flag = flag && diy.clickOnNextLocalNetwork_iOS();
				}
			}
		}
		return flag;
	}

	@Given(value = "^perform initial installtion setup in (.+)$")
	@Override
	@KeywordStep(gherkins = "^perform initial installtion setup in (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Initial installation  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				String device = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
						.toUpperCase();
				if (device.contains("JASPER_SENIOR")) {
//					flag = flag && DIYUtils.performInitialInstallation_Jasper(testCase, diy, exampleData.get(0).toUpperCase());
					flag = flag && DIYUtils.setupThermostat_DIY_Jasper_Houdini_Caspian(testCase, diy,
							exampleData.get(0).toUpperCase());
				} else if (device.contains("HOUDINI")) {
					if (diy.isAddThermostatResideoAPP()) {
						flag = diy.clickOnAddThermsotatGetStartedButton();
					}
					flag = flag && DIYUtils.performInitialInstallation_Houdini(testCase, diy,
							exampleData.get(0).toUpperCase());
				} else {
					flag = flag && DIYUtils.performInitialInstallation_Jasper(testCase, diy);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		System.out.println("Exceution is " + flag);
		return flag;
	}

}