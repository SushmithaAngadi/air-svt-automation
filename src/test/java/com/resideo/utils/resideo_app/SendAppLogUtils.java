package com.resideo.utils.resideo_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

public class SendAppLogUtils {

	public static SendAppLogUtils instance = null;

	public static SendAppLogUtils getInstance() {
		if (instance == null)
			instance = new SendAppLogUtils();
		return instance;
	}

	/*
	 * Send App log if Previous Trail failed
	 */

	public static boolean sendiOSAppLog(TestCases testCase, TestCaseInputs inputs, String toAddress) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {

			boolean flat = NavigateToAnyScreen.navigateFromAnyScreenToExpectScreen(testCase, inputs, "ABOUT THE APP");

			if (flat) {
				Keyword.ReportStep_Pass(testCase, "Navigate successfully to About the app");
				break;
			} else {
				System.out.println("retry to navigate");
			}
		}

		if (MobileUtils.isMobElementExists("XPATH",
				"//XCUIElementTypeStaticText[contains(@name,'Send_Feedback_Button')]", testCase, 6)) {
			if (MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeStaticText[contains(@name,'Send_Feedback_Button')]")) {
				threadLock(3000);
				@SuppressWarnings("unused")
				String pageSource = testCase.getMobileDriver().getPageSource();
				String[] coordinatesForParticularUDID = CommonUtils
						.getCoordinatesForParticularUDID(testCase, inputs, "To Address").split("_");
				int to_XCord = Integer.parseInt(coordinatesForParticularUDID[0]);
				int to_YCord = Integer.parseInt(coordinatesForParticularUDID[1]);
				MobileUtils.clickOnCoordinate(testCase, to_XCord, to_YCord);
				MobileUtils.getMobElement(testCase, "NAME", "Mail.toField").sendKeys(toAddress);
				coordinatesForParticularUDID = CommonUtils.getCoordinatesForParticularUDID(testCase, inputs, "Send")
						.split("_");
				int send_XCord = Integer.parseInt(coordinatesForParticularUDID[0]);
				int send_YCord = Integer.parseInt(coordinatesForParticularUDID[1]);
				MobileUtils.clickOnCoordinate(testCase, send_XCord, send_YCord);

				if (MobileUtils.isMobElementExists("XPATH",
						"//XCUIElementTypeStaticText[contains(@name,'Send_Feedback_Button')]", testCase, 6)) {
					Keyword.ReportStep_Pass(testCase, "App Log send successfully, Sent Mail ID is " + toAddress);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find Feedback Button button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Feedback Button button");
				flag = false;
			}
		} else {

			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find Feedback Button");
			flag = false;
		}

		return flag;
	}

	public static void threadLock(int sleep) {
		try {
			Thread.sleep(sleep);
		} catch (Exception e) {
			System.out.println("Exception raised in SendAppLogUtils.threadLock() method, Exceptions are " + e);
		}
	}

}
