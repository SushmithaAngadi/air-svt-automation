package com.resideo.keywords.firstAlertapp.diy_common;

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
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.NavigateToAnyScreeninFA;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;

import io.cucumber.java.en.Given;

public class AddNewDeviceForInitiateDIY extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	FirstAlertDIYScreen diy;
	public boolean flag = true;

	public AddNewDeviceForInitiateDIY(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  </b>");
		if (testCase.isTestSuccessful()) {
			diy = new FirstAlertDIYScreen(testCase);
			if (NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, testCase.getTestCaseInputs(), "DASHBOARD")) {
				try {
					String device = SuiteConstants
							.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
					 if (device.contains("FUJI") ||device.toUpperCase().contains("DENALI")) {
						if (diy.isDeviceNameDisplayingOnDashBoard()) {
							Keyword.ReportStep_Pass(testCase, "<b> The Device is Already registered,So deleteing it. </b>");
							flag = flag && FirstAlert_DIYUtils.deleteDevice(testCase);
						}else {
							Keyword.ReportStep_Pass(testCase, "<b> The Device is Not registered in previous trail. </b>");
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}else {
				flag=false;
			}
		}

		return flag;
	}

	@Given(value = "Add new device to Configure in First Alert App")
	@Override
	@KeywordStep(gherkins = "^Add new device to Configure in First Alert App$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for select Device from List  </b>");
		if (testCase.isTestSuccessful()) {
			flag = FirstAlert_DIYUtils.selectPerferedDeviceforDIYFromList(testCase, diy);
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