package com.resideo.keywords.app.homeKit;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.HomeKitUtils;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;
import com.resideo.utils.stat.StatCommonCommandUtils;
import io.cucumber.java.en.Given;

public class HomekitQRCodeGenerate extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	String deviceName;
	public boolean flag = true;

	public HomekitQRCodeGenerate(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			try {

			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e);
			}

			homeKit = new HomeKitScreen(testCase);
			deviceName = StatCommonCommandUtils.get6CharMacId();
			SystemState.getStatus().homeKitDeviceName("Tstat-" + deviceName.trim());
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^Generate QR Code from Stat for homekit$")
	@Override
	@KeywordStep(gherkins = "^Generate QR Code from Stat for homekit$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			flag = HomeKitUtils.generateQR_CodeFromStat_Homekit(testCase);
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
