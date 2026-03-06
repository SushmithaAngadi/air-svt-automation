package com.resideo.keywords.firstAlertapp.diy_common;

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
import com.resideo.utils.firstalert_app.FirstAlert_DIYUtils;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;

import io.cucumber.java.en.Given;

public class DeviceISUReconfigure extends Keyword {
	private TestCases testCase;
	ArrayList<String> exampleData;
	FirstAlertDIYScreen diy;
	String device;
	public boolean flag = true;
	String IsuConfigured_Status;

	public DeviceISUReconfigure(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for ISU reconfigure </b>");
		if (testCase.isTestSuccessful()) {
			try {
				device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim().toUpperCase();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			diy = new FirstAlertDIYScreen(testCase);
			if(device.contains("DENALI") && device.contains("RETAIL"))
			flag=diy.isTwoMoreStepScreen();
			
			boolean isIsuNeedconfigured = false;
			boolean isFactoryReset = false;
			if (exampleData.get(0).toUpperCase().contains("ALWAYS")) {
				isIsuNeedconfigured = true;
			} else if (exampleData.get(0).toUpperCase().contains("SKIP")
					|| exampleData.get(0).toUpperCase().contains("ALREADY")) {
				isIsuNeedconfigured = false;
			}

			if (exampleData.get(1).toUpperCase().contains("YES") || exampleData.get(1).toUpperCase().contains("TRUE")) {
				isFactoryReset = true;
			} else if (exampleData.get(1).toUpperCase().contains("NO")
					|| exampleData.get(1).toUpperCase().contains("FALSE")) {
				isFactoryReset = false;
			}
			if(device.contains("DENALI") || device.contains("GLENEAGLES"))
			IsuConfigured_Status = FirstAlert_DIYUtils.deviceIsuConfigureStatus(testCase, diy,
					isIsuNeedconfigured, isFactoryReset);
			if(!IsuConfigured_Status.toUpperCase().contains("SKIP")) {
				flag=flag && diy.clickOnNextButton();
			}
			if (IsuConfigured_Status.equals("change") || IsuConfigured_Status.equals("not configured")) {
				flag = true;
			} else if (IsuConfigured_Status.contains("should not be isu configured") && isFactoryReset) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"failed due to ISU already configured, app should show the ISU configuration");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^First Alert app (.+) configure the ISU, is device factory reset (.+)$")
	@Override
	@KeywordStep(gherkins = "^First Alert app (.+) configure the ISU, is device factory reset (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> ISU reconfigure  </b>");
		if (testCase.isTestSuccessful()) {
			try {
				if (IsuConfigured_Status.equals("change") || IsuConfigured_Status.equals("not configured")) {
					flag=diy.isTemperatureScaleScreen(4);
					if(!flag) {
						flag=diy.isLanguageScreen(4);
					}
				}else {
					flag=diy.isOneMoreStepScreen();
				}
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able connect with wifi, Exception occured, Exception is :" + e);
				flag = false;

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
