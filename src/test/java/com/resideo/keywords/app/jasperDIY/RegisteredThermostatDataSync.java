package com.resideo.keywords.app.jasperDIY;

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
import com.resideo.utils.resideo_app.PrimaryCardUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class RegisteredThermostatDataSync extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;

	public boolean flag = true;

	public RegisteredThermostatDataSync(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b>Executing pre conditon for closing popup</b>");
//			flag = flag && LyricUtils.closeCoachMarks(testCase);
			PrimaryCardUtils.closeAllInstructionPopup(testCase);
			PrimaryCardUtils.closeAppLaunchPopups(testCase, SystemState.getStatus().getTstatName());
			
			DIYScreen diy = new DIYScreen(testCase);
			if (diy.isUnknownPopUP()) {
				flag = diy.clickOnUnknownPopUP("Dashboard");
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Given(value = "user waits for data synch after registration")
	@Override
	@KeywordStep(gherkins = "^user waits for data synch after registration$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()&&flag) {
			try {
				Keyword.ReportStep_Pass(testCase, "<b> Start Executing waiting for data sync complete </b>");
				String device = null;

				device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim();

				if (device.contains("JASPER_SENIOR") || device.contains("CASPIAN")) {
					flag = flag && PrimaryCardUtils.dataSyncProcessAndStatus(testCase,10,SystemState.getStatus().getTstatName());

				} else if (device.contains("FLYCATCHER")||device.contains("THOR")) {
//					SystemState.getStatus().setTstatName("Master Bedroom");
//					flag = flag && PrimaryCardUtils.dataSyncIsCompletedFlycathcer(testCase, inputs);
					flag = flag && PrimaryCardUtils.dataSyncProcessAndStatus(testCase,10,SystemState.getStatus().getTstatName());
				}
				if (flag) {
					Keyword.ReportStep_Pass(testCase,
							"Data sync completed, next stat will delete from thermostat configuration screen for next trail");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Data sync failed, pls check screenshot for more information");
					SystemState.getStatus().isPreviousTrailFailed(flag);
				}
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured due to " + e);
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
