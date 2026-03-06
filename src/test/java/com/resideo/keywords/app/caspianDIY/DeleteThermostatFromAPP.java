package com.resideo.keywords.app.caspianDIY;

import java.time.Duration;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.CaspianUtils;
import com.resideo.utils.stat.StatCommonCommandUtils;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class DeleteThermostatFromAPP extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;

	public boolean flag = true;

	public DeleteThermostatFromAPP(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
//		if (testCase.isTestSuccessful()) {
//
//			Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition </b>");
//
//		} else {
//			flag = false;
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
//					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
//		}
		return flag;
	}

	@Given(value = "User delete caspian device from user Account")
	@Override
	@KeywordStep(gherkins = "^User delete caspian device from user Account$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful() || SystemState.getStatus().isCaspainCloudSynError()
				|| SystemState.getStatus().isCaspainConnectionError()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing : Delete thermostat from thermostat configuration</b>");
			flag = CaspianUtils.deleteCaspianDeviceFromAccount(testCase);
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
			Keyword.ReportStep_Pass(testCase,
					"<b>Start Executing Post Condition , check deleted thermostat is in dahboard or not </b>");
			SystemState.getStatus().IsDeviceDeletedFromApp(flag);
			flag = true;
		}
		if (flag == false) {
			String pageSource = testCase.getMobileDriver().getPageSource();
			if (pageSource.toUpperCase().contains("WIFI")
					|| (pageSource.contains("com.android.settings") && pageSource.toUpperCase().contains("WI-FI"))) {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Failure Occured in Previous Test Scenario, Hence closing Wifi screen");
				flag = MobileUtils.pressBackButton(testCase);
			}
		}

		StatCommonCommandUtils.ThreadLock(testCase, Duration.ofMinutes(2));
		ReportStep_Pass(testCase, "Is Test is Passed or not " + flag);
//		testCase.setCurrentKeywordStatus(flag);
		if (!testCase.isTestSuccessful()) {

			SystemState.getStatus().isPreviousTrailFailed(true);
		}

		return flag;
	}
}
