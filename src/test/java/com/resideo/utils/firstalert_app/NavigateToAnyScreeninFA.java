package com.resideo.utils.firstalert_app;

import org.openqa.selenium.StaleElementReferenceException;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.screen.FirstAlertLoginScreen;
import com.resideo.utils.firstalert_app.screen.NavigatingScreenToScreeninFA;
import com.resideo.utils.resideo_app.LyricUtils;

public class NavigateToAnyScreeninFA {

	public static boolean NavigateAndVerify_IsExpectedScreen(TestCases testCase, TestCaseInputs inputs,
			String expectedScreen) {
		boolean flag = false;
		String presentScreenName = "";
		NavigatingScreenToScreeninFA navigate = new NavigatingScreenToScreeninFA(testCase);
		try {
			for (int i = 0; i < 3; i++) {
				presentScreenName = navigate.getScreenName().toUpperCase();
				if (presentScreenName.contains(expectedScreen)) {
					flag = true;
					break;
				} else {
					try {
						flag = navigateFromAnyScreenToExpectScreen(testCase, inputs, expectedScreen);
						presentScreenName = navigate.getScreenName().toUpperCase();
					} catch (StaleElementReferenceException stale) {
						Keyword.ReportStep_Pass(testCase, "Stale Element exception captured due to screen navigation");
						presentScreenName = navigate.getScreenName().toUpperCase();
					}
				}
			}
			Keyword.ReportStep_Pass(testCase, "Current screen is " + presentScreenName);
			Keyword.ReportStep_Pass(testCase, "Current screen Navigation is " + flag);
		} catch (Exception e) {
			presentScreenName = navigate.getScreenName().toUpperCase();
			Keyword.ReportStep_Pass(testCase, "Exception Raised due to " + e.getMessage() + " Navigating to "
					+ expectedScreen + ", From this Screen " + presentScreenName);
		}
		return flag;
	}

	public static boolean navigateFromAnyScreenToExpectScreen(TestCases testCase, TestCaseInputs inputs,
			String expectedScreen) {
		NavigatingScreenToScreeninFA navigate = new NavigatingScreenToScreeninFA(testCase);
		boolean flag = false;
		String locationName = inputs.getInputValue("LOCATION1_NAME");
		String deviceName = inputs.getInputValue("LOCATION1_DEVICE1_NAME");
		String presentScreenName = navigate.getScreenName().toUpperCase();

		if (presentScreenName != null) {
			System.out.println(
					"Present Screen Name = " + presentScreenName + ">>>>> Navigate to this screen =" + expectedScreen);
			switch (expectedScreen) {
			case "DASHBOARD": {
				flag = navigate.navigateToDashboard(presentScreenName, locationName);
				break;
			}
			case "PRIMARY CARD":
			case "PRIMARYCARD": {
				flag = navigate.navigateToPrimaryCard(presentScreenName, deviceName, locationName);
				break;
			}
			case "DEVICE SETTING": {
				flag = navigate.navigateToDeviceSettings(presentScreenName, deviceName, locationName);
				break;
			}
			case "ALERT MANAGEMENT": {
				flag = navigate.navigateToAlertManagement(presentScreenName, deviceName, locationName);
				break;
			}
			case "ACCOUNT MENU": {
				flag = navigate.navigateToAccountMenu(presentScreenName, locationName);
				break;
			}
			case "VACATION SETTING": {
				flag = navigate.navigateToVacation(presentScreenName, locationName);
				break;
			}
			case "ACTIVITY FEED": {
				flag = navigate.navigateToActivityFeed(presentScreenName, locationName);
				break;
			}
			case "MY LOCATION": {
				flag = navigate.navigateToMyLocation(presentScreenName, locationName);
				break;
			}
			case "APP SETTINGS": {
				flag = navigate.navigateToAppSettings(presentScreenName, locationName);
				break;
			}
			case "DEVICE DETAILS": 
			case "DEVICEDETAILS":{
				flag = navigate.navigateToDeviceDetails(presentScreenName, deviceName, locationName);
				break;
			}
			case "SCHEDULE": {
				flag = navigate.navigateToScheduleScreen(presentScreenName, deviceName,locationName);
				break;
			}
			case "ADVANCED SETUP": {
				flag = navigate.navigateToAdvancedSetup(presentScreenName,deviceName, locationName);
				break;
			}
			case "MAIN SCREEN":
			case "SIGNIN SCREEN":{
				flag = LyricUtils.Loginto_FristAlert(testCase, inputs, new FirstAlertLoginScreen(testCase));
				break;
			}
			
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Screen Not available in  navigateFromAnyScreenToExpectScreen(TestCases testCase, TestCaseInputs inputs,\r\n"
						+ "			String expectedScreen) method");
				flag = false;
				break;
			}

			}
		} else {

			flag = false;

		}
		return flag;
	}

}
