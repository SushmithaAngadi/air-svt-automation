package com.resideo.keywords.app.caspianDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class CheckDeviceRegisterInHHApp extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;

	public boolean flag = true;

	public CheckDeviceRegisterInHHApp(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			diy = new DIYScreen(testCase);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "Check Caspian device registered in account")
	@Override
	@KeywordStep(gherkins = "^Check Caspian device registered in account$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b>Check Caspian Device Register in User Account </b>");
		if (testCase.isTestSuccessful()) {
			if (diy.isSucessIsVisible()) {
				flag = diy
						.clickOnNextButton("Your L5 Leak Protection Valve is now configured and added to your account");

			} else if (diy.isDeviceregisterScreen()) {

				flag = diy
						.clickOnNextButton("Your L5 Leak Protection Valve is now configured and added to your account");
			} else {
				System.out.println("next button not available");
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
		if (diy.isSkipTurnOffFlightMode()) {
			flag = diy.clickOnSkipTurnOffFlightMode();
		}
//		Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());

		return flag;
	}

}