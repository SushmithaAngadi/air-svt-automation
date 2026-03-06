package com.resideo.keywords.app.caspianDIY;

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
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class ChooseDefaultDeviceName extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String deviceName;
	String device_UnderTest;

	public ChooseDefaultDeviceName(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			device_UnderTest = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
			if (testCase.isTestSuccessful()) {
				Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for choose device Name  </b>");
				diy = new DIYScreen(testCase);
//			deviceName = DIYUtils.getDeviceMacID_deviceName(testCase, "VALVE");
				if (exampleData.get(0).trim().toUpperCase().contains("DEFAULT")) {
					if (device_UnderTest.contains("CASPIAN")) {
						deviceName = DIYUtils.getDeviceMacID_deviceName_Caspian(testCase, inputs,"VALVE");
					} else {
						deviceName = DIYUtils.getDeviceMacID_deviceName_Houdini(testCase,inputs, "Tstat");
					}

				} else {
					deviceName = exampleData.get(0).trim().toUpperCase();
				}

			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {

		}
		return flag;
	}

	@Given(value = "choose (.+) device name from list")
	@Override
	@KeywordStep(gherkins = "^choose (.+) device name from list$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for select Device from List  </b>");
		if (testCase.isTestSuccessful()) {
			try {
//				flag = diy.selectDeviceNameInAvailableList(
//						"Successfully selected this " + deviceName + " Name from List ");
				if (device_UnderTest.contains("CASPIAN")) {
					flag = diy.setCaspianName();
				} else {
					flag = diy.setUserSelectedRoomName();
				}

			} catch (Exception e) {
				e.printStackTrace();
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to register, Exception occured, Exception is :" + e.toString());
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