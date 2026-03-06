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
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.NavigateToAnyScreen;
import com.resideo.utils.resideo_app.PrimaryCardUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class AddNewDeviceForInitiateDIY extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	String device;

	public boolean flag = true;

	public AddNewDeviceForInitiateDIY(TestCases testCase, TestCaseInputs inputs) {
		this.inputs = inputs;
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		boolean isunknownPopup = false;
		if (testCase.isTestSuccessful()) {
			try {
				device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.trim().toUpperCase();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
			diy = new DIYScreen(testCase);
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for DIY Start  </b>");

			if (testCase.getPlatform().toUpperCase().contains("IOS")) {
				flag = PrimaryCardUtils.handleNotNowPopupForiOS(testCase);

			}
			if (testCase.getMobileDriver().getPageSource().toUpperCase().contains("Pro Invitation".toUpperCase())) {
				diy.clickOnDismissButton();
			}
			
			if (!isunknownPopup) {
				if (diy.isUnknownPopUP()) {
					isunknownPopup = diy.clickOnUnknownPopUP("Dashboard");
				}
			}
//			if (diy.isDashboard(5)) {
//
			System.out.println("in dashboard , need to navigate");
				flag = NavigateToAnyScreen.NavigateAndVerify_IsExpectedScreen(testCase, inputs,
						"ADD NEW DEVICE SCREEN");
//
//			} else if (diy.isAddnewDeviceListofDevices()) {
//				if (!isunknownPopup) {
//					if (diy.isUnknownPopUP()) {
//						isunknownPopup = diy.clickOnUnknownPopUP("Dashboard");
//					}
//				}
//				flag = true;
//			}
			if (testCase.getPlatform().toUpperCase().contains("IOS")) {
				if (diy.isBluetoothNotification()) {
					flag = diy.acceptBluetoothNotification();
					ReportStep_Pass(testCase, "Bluettoth Notification Accepted");
				}
			}
			if (!isunknownPopup) {
				if (diy.isUnknownPopUP()) {
					isunknownPopup = diy.clickOnUnknownPopUP("Dashboard");
				}
			}
			if (DIYUtils.changeCountry(testCase, diy, device)) {
				flag = flag && DIYUtils.scrolltoExpectedDeviceforDIY(testCase, diy);
			} else {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not ablt  to select country from the list");
				flag = false;
			}
			
		}

		return flag;
	}

	@Given(value = "^add new device for registration$")
	@Override
	@KeywordStep(gherkins = "^add new device for registration$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase, "<b> Start Executing Keyword Step for select Device from List  </b>");
			flag = flag && DIYUtils.selectdeviceforDIYByUserExpects(testCase, diy,device);
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
			try {
				Keyword.ReportStep_Pass(testCase, "<b>Start Executing Post Condition for Install device  </b>");
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					if (diy.isAllowLocationScreen()) {
						flag = diy.clickOnTurnOnLocationButton();
					}
					if (diy.IsAllowLocationPopUPScreen()) {
						flag = diy.clickOnWhileUsingTheAppButton();
					}
				}

				if (device.contains("JASPER_SENIOR_NA")) {

					if (diy.isAddThermostatResideoAPP()) {
						flag = flag && diy.clickOnAddThermsotatGetStartedButton();
					}
//					if ((testCase.getPlatform().toUpperCase().contains("ANDROID") && diy.isTheThermostatOnWall())
////							|| (testCase.getPlatform().toUpperCase().contains("IOS") && diy.isLocalNetworkPopUP())) {
//							|| (testCase.getPlatform().toUpperCase().contains("IOS") && diy.isTheThermostatOnWall())) {
//						Keyword.ReportStep_Pass(testCase,
//								"<b style=\"color:blue\"> Executed Post Condition for Install device and its succeed </b>");
//						flag = true;
//
//					} else {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Thermostat on wall screen not visible in Android or local network screen not visible in iOS");
//						flag = false;
//					}

				} else if (device.contains("JASPER_SENIOR_EMEA")) {

					if (diy.isAddThermostatResideoAPP()) {
						flag = diy.clickOnAddThermsotatGetStartedButton();
					}
					if (diy.isWirelessReceiverBoxInstalled()) {

						Keyword.ReportStep_Pass(testCase,
								"<b style=\"color:blue\"> Executed Post Condition for Install device and its succeed </b>");
						flag = true;
					}
//					else {
//
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Has the wireless receiver box and thermostat been installed screen not visible");
//						flag = false;
//					}

				} else if (device.contains("CASPIAN")) {
					if ((testCase.getPlatform().toUpperCase().contains("ANDROID") && diy.isChooseLocationScreen())
							|| (testCase.getPlatform().toUpperCase().contains("IOS") && diy.isChooseLocationScreen())) {
						Keyword.ReportStep_Pass(testCase,
								"<b style=\"color:blue\"> Executed Post Condition for select Install device  </b>");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Location screen not visible in Android or local network screen not visible in iOS");
						flag = false;
					}

				} else if (device.contains("FLYCATCHER")) {
					
				} else if (device.contains("HOUDINI")) {
					
				} else {

				}

			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Location screen not visible in Android or local network screen not visible in iOS, Exception occured, Exception is :"
								+ e.getMessage());
				flag = false;
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		System.out.println("Exceution is " + flag);
		return flag;

	}

}