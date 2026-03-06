package com.resideo.keywords.app.homeKit;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import io.cucumber.java.en.Given;

public class LaunchHomeKitApplication extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;

	public boolean flag = true;

	public LaunchHomeKitApplication(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		return flag;
	}

	@Given(value = "Launch and Confirm (.+) third party application")
	@Override
	@KeywordStep(gherkins = "^Launch and Confirm (.+) third party application$")
	public boolean keywordSteps() {
		String appName = exampleData.get(0);
		if (testCase.isTestSuccessful()) {
			if (appName.contains("HOME KIT")) {
				CustomDriver driver = testCase.getMobileDriver();
				driver.activateApp("com.apple.Home");
				flag = MobileUtils.isMobElementExists("NAME", "Tab Bar", testCase, 2)
						&& MobileUtils.isMobElementExists("NAME", "Automation", testCase, 2);
				ReportStep_Pass(testCase, "SucessFully Homekit App Launched");
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"User Expected Application not in List, Need to Implement, " + appName);
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
		return flag;

	}

}
