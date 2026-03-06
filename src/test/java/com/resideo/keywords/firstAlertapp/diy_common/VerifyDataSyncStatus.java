package com.resideo.keywords.firstAlertapp.diy_common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.api.dfc.TabascoUtils;
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
import com.resideo.utils.resideo_app.LyricUtils;

import io.cucumber.java.en.Given;

public class VerifyDataSyncStatus extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	private FirstAlertDIYScreen diy;
	public boolean flag = true;

	public VerifyDataSyncStatus(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Executing pre conditon for data sync check</b>");
		if (testCase.isTestSuccessful()) {
			diy = new FirstAlertDIYScreen(testCase);
			if (diy.isExpectedScreen(testCase, "dashboard")) {
				flag=true;
			}else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not in the dashboard screen");
				flag=false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		if(!flag)
		{
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not in the dashboard screen");
		}
		return flag;
	}

	@Given(value = "^user verifies for data synch after registration on First Alert APP$")
	@Override
	@KeywordStep(gherkins = "^user verifies for data synch after registration on First Alert APP$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing waiting for data sync complete </b>");
		if (testCase.isTestSuccessful()) {
			try {
				flag = flag && FirstAlert_DIYUtils.dataSyncProcessAndStatus(testCase, 3,
						SystemState.getStatus().getTstatName());

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
		if(flag) {
//			try {
//				TabascoUtils tb=new TabascoUtils(inputs);
//				if(tb.getConnectionToken()) {
//					tb.unRegisterDeviceFromCloud(testCase, tb, "/deviceManagement/v1/unregister", "5CFCE1277F4B");
//				}
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		return flag;
	}
}