package com.resideo.keywords.firstAlertapp.diy_common;

import org.openqa.selenium.Point;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.NavigateToAnyScreeninFA;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
import com.resideo.utils.resideo_app.LyricUtils;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

public class DeleteRegisteredDevice extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	private FirstAlertDIYScreen diy;
	public boolean flag = true;

	public DeleteRegisteredDevice(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing pre conditon for delete device</b>");
			diy = new FirstAlertDIYScreen(testCase);
			try {
				flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase,
						testCase.getTestCaseInputs(), "DASHBOARD");
				System.out.println("already in dashboard");
				if (diy.isDeviceNameDisplayingOnDashBoard()) {
					Keyword.ReportStep_Pass(testCase, "<b>Device name is displayed on the Dashboard.</b>");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Device name is not displaying on Dashboard");
				}
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.toString());
			}
		return flag;
		
	}

	@Given(value = "^Delete registered device from First alert APP$")
	@Override
	@KeywordStep(gherkins = "^Delete registered device from First alert APP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase,
				"<b> Start Executing : Delete thermostat from thermostat configuration</b>");
		try {
				if ((!SystemState.getStatus().isRegError() && !SystemState.getStatus().isDeviceNotRegisteredError()) || diy.isDeviceNameDisplayingOnDashBoard()) {
					flag = flag && FirstAlert_DIYUtils.deleteDevice(testCase);
				}else {
					Keyword.ReportStep_Pass(testCase, "DId not pass the condition: (!SystemState.getStatus().isRegError() && !SystemState.getStatus().isDeviceNotRegisteredError()) || diy.isDeviceNameDisplayingOnDashBoard()");
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
		return flag;
	}

}