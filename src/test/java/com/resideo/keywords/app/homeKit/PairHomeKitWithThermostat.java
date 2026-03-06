package com.resideo.keywords.app.homeKit;

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
import com.resideo.utils.resideo_app.HomeKitUtils;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class PairHomeKitWithThermostat extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	public boolean flag = true;
	String deviceNeedToInstall;

	ArrayList<String> exampleData;
	String deviceName;

	public PairHomeKitWithThermostat(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			homeKit = new HomeKitScreen(testCase);
			try {
				deviceNeedToInstall = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "^pair thermostat using (.+) in homekit$")
	@Override
	@KeywordStep(gherkins = "^pair thermostat using (.+) in homekit$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			String qr_Setupcode = exampleData.get(0).toUpperCase().trim();
			if (!SystemState.getStatus().isDirectScan()) {
				if ((deviceNeedToInstall.contains("THOR") || deviceNeedToInstall.contains("FLYCATCHER"))
						&& qr_Setupcode.contains("QR SCAN")) {
					flag = HomeKitUtils.PairingHomeKitWithQR(testCase, homeKit,
							SystemState.getStatus().getLast6CharDeviceMacID());
				} else {
					flag = HomeKitUtils.PairingHomeKit(testCase, homeKit, deviceNeedToInstall,
							SystemState.getStatus().getLast6CharDeviceMacID());
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Skipping pairing scenario, because already direct pairing finished");
				flag = true;
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
			flag = homeKit.isConnectingToThermostatCardVisible(4);
			Keyword.ReportStep_Pass(testCase, "is connecting to home kit, status is " + flag);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;

	}

}
