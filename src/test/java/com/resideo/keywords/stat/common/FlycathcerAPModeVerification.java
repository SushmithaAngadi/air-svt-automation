package com.resideo.keywords.stat.common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset.ResetMode;

import io.cucumber.java.en.Given;

public class FlycathcerAPModeVerification extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public FlycathcerAPModeVerification(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		if (!SystemState.getStatus().IsNavigateToWifiSCreenINFlycathcer()) {
			try {
				StatCommands.getInstance().cattCommandsStub.setReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_SYSTEM_RESET_PRESERVE_NVM).build());
				Thread.sleep(8000);
				flag =StatCommonCommandUtils.navigateToWifiFromHomeScreen(testCase);
				SystemState.getStatus().IsNavigateToWifiSCreenINFlycathcer(true);
				ReportStep_Pass(testCase, "Navigate from Home screen to Wifi");
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device GRPC Commands Failed ::"+e.getMessage());
				flag = false;
			}
		}else {
			flag = true;
			ReportStep_Pass(testCase, "Already stat in Wifi Screen");
		}
		return flag;
	}

	@Given(value = "^User need to perform AP mode in Flycathcer$")
	@Override
	@KeywordStep(gherkins = "^User need to perform AP mode in Flycathcer$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
			flag = StatCommonCommandUtils.setAndVerifyAPMode(testCase);
			
			}catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device GRPC Commands Failed ::"+e.getMessage());
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device AP mode failed");
			SystemState.getStatus().setStatDeletedFromApp(false);
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		if( StatCommands.getInstance().cattCommandsStub
				.clickOnBackButtonTopLeftInFlyCatcher(Boolean_Msg.newBuilder().build()).getBoolVal()) {
			Keyword.ReportStep_Pass(testCase, "Device Back to wifi settings screen");
			return true;
		}else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device Back button not working");
			return false;
		}
	}

}
