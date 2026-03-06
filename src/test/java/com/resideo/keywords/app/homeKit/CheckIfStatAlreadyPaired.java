package com.resideo.keywords.app.homeKit;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.HomeKitUtils;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;
import com.resideo.utils.stat.StatCommonCommandUtils;

import io.cucumber.java.en.Given;
@SuppressWarnings("unused")
public class CheckIfStatAlreadyPaired extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	String deviceName;
	public boolean flag = true;

	public CheckIfStatAlreadyPaired(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		return flag;
	}

	@Given(value = "check stat is paired with homeKit")
	@Override
	@KeywordStep(gherkins = "^check stat is paired with homeKit$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			try {
				String deviceName = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
				homeKit = new HomeKitScreen(testCase);
				if (homeKit.isDeviceNamePresentInHomeKitHomeScreen(StatCommonCommandUtils.get6CharMacId(), 2)) {
					flag = HomeKitUtils.navigateToHomeKitPrimaryCard(testCase);
					flag = flag && HomeKitUtils.deleteDeviceInHomeKit(testCase, deviceName);
				} else {
					Keyword.ReportStep_Pass(testCase, "Expected Device Not Paired with Homekit");
				}
			} catch (Exception e) {

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
		if (testCase.isTestSuccessful()) {
			flag = HomeKitUtils.isDeviceExist(testCase);
		} else {

			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;

	}

}
