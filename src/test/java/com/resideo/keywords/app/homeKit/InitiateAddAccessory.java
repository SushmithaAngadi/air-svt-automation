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
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;

import io.cucumber.java.en.Given;

public class InitiateAddAccessory extends Keyword {

	ArrayList<String> exampleData;
	private TestCases testCase;
	private TestCaseInputs inputs;
	HomeKitScreen homeKit;
	String deviceName;
	boolean isDirectAccess = false;
	public boolean flag = true;

	public InitiateAddAccessory(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			try {
				if (exampleData.get(1).toUpperCase().contains("WITH DIRECT SCAN")) {
					isDirectAccess = true;
				}
				String deviceNeedToInstall = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();

				if (!exampleData.get(0).toUpperCase().contains("AP MODE")) {
					SystemState.getStatus().isStationMode(true);
					if (deviceNeedToInstall.contains("THOR") || deviceNeedToInstall.contains("FLYCATCHER")) {
						if (StatCommonCommandUtils.IsApMode_T6_T10_T10Plus_Station(testCase, 20)) {
							Keyword.ReportStep_Pass(testCase, "Device not in AP Mode, Further process will proceed");
							flag = true;
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
									"Device not in AP Mode, Requested device is " + deviceNeedToInstall);
							flag = false;
						}
					}
				} else {

					if (!StatCommonCommandUtils.IsApMode_T6_T10_T10Plus(testCase, 1)) {
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder()
								.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build());
						StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(NavigateTo.newBuilder()
								.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build());
						if (StatCommands.getInstance().cattCommandsStub
								.t10PlusNavigateTo(NavigateTo.newBuilder()
										.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_WIFI_SELECTNETWORK).build())
								.getBoolVal()) {
							if (StatCommonCommandUtils.IsApMode_T6_T10_T10Plus(testCase, 1)) {
								Keyword.ReportStep_Pass(testCase, "Device in AP Mode, Further process will proceed");
								flag = true;
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
										"Device not in AP Mode, Requested device is " + deviceNeedToInstall);
								flag = false;
							}
						} else {
							ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Navigation failed");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Pass(testCase,
								"Already device in AP mode, will continue to perform homekit pairing.");
						flag = true;
					}

				}

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

	@Given(value = "^initiate homekit in (.+) thermostat from add accessory (.+)$")
	@Override
	@KeywordStep(gherkins = "^initiate homekit in (.+) thermostat from add accessory (.+)$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {
			flag = HomeKitUtils.AddThermostatInAddAccessory(testCase, inputs, homeKit, deviceName, isDirectAccess);
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
