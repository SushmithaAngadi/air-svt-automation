package com.resideo.keywords.app.diy_common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.PrimaryCardUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class DeleteThermostatFromAPP extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	PrimaryCardScreen pm;
	DIYScreen diy;

	public boolean flag = true;

	public DeleteThermostatFromAPP(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		pm = new PrimaryCardScreen(testCase);
		diy = new DIYScreen(testCase);
		try {
			if (testCase.isTestSuccessful()) {
				String deviceName = testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");
				flag = PrimaryCardUtils.closeAppLaunchPopups(testCase, deviceName);
				if (diy.isUnknownPopUP(10)) {
					diy.clickOnUnknownPopUP("DAshboard");
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception raised : " + this.getClass().getName() + e.getMessage() + e.getStackTrace());
		}
		return flag;
	}

	@Given(value = "delete Registered thermostat in app")
	@Override
	@KeywordStep(gherkins = "^delete Registered thermostat in app$")
	public boolean keywordSteps() {
		try {
			if (testCase.isTestSuccessful()) {
				Keyword.ReportStep_Pass(testCase,
						"<b> Start Executing : Delete thermostat from thermostat configuration</b>");
//			flag = flag && PrimaryCardUtils.deleteParticularThermostatFromAccount(testCase,inputs);
				if (!SystemState.getStatus().isRegError()) {
					flag = flag && PrimaryCardUtils.deleteThermostat(testCase);
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception raised : " + e.getMessage() + e.getStackTrace());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b>Start Executing Post Condition , check deleted thermostat is in dahboard or not </b>");
			SystemState.getStatus().IsDeviceDeletedFromApp(flag);
		}
		if (!testCase.isTestSuccessful())

			StatCommands.getInstance().cattCommandsStub
					.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(false).build());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 3; i++) {
			String pageSource = testCase.getMobileDriver().getPageSource();
			if (pageSource.toUpperCase().contains("WIFI")
					|| (pageSource.contains("com.android.settings") || pageSource.toUpperCase().contains("WI-FI"))) {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Failure Occured in Previous Test Scenario, Hence closing Wifi screen");
				flag = MobileUtils.pressBackButton(testCase);
			} else {
				break;
			}

		}
		return flag;
	}
}
