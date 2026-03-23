package com.resideo.utils.resideo_app;

import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.NavigatingScreenToScreen;


public class NavigateToAnyScreen {

	public static boolean navigateFromAnyScreenToExpectScreen(TestCases testCase, TestCaseInputs inputs,
			String expectedScreen) {
		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (MobileUtils.isMobElementExists("NAME", "Not Now", testCase, 2)) {
				MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
			}
		}
		NavigatingScreenToScreen navigate = new NavigatingScreenToScreen(testCase);
		String locationName = inputs.getInputValue("LOCATION1_NAME");
		String deviceName = inputs.getInputValue("LOCATION1_DEVICE1_NAME");
//		String locationName = "Automation";
//		String deviceName = "Tstat 31AD74";
		String presentScreenName = null;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(5));
		String isEventReceived = fWait.until(new Function<CustomDriver, String>() {
			public String apply(CustomDriver driver) {
				try {
					String presentScreenName = navigate.getScreenName();
					if (presentScreenName != null && !presentScreenName.isEmpty()) {
						return presentScreenName;
					} else {
						System.out.println(presentScreenName);
						return null;
					}
				} catch (Exception e) {
					System.out.println(e);
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Screen Got Empty page or screen doesnt have particular data to parse it");
					return null;
				}
			}
		});
		presentScreenName = isEventReceived;
		if (presentScreenName != null) {
			System.out.println(
					"Present Screen Name = " + presentScreenName + ",,,,,,, go to this screen =" + expectedScreen);
			switch (expectedScreen) {
			case "DASHBOARD": {
				return navigate.navigateToDashboard(presentScreenName);
			}
			case "ADD NEW DEVICE SCREEN": {
				return navigate.navigateToAddNewScreen(presentScreenName);
			}
			case "PRIMARYCARD": {
				return navigate.navigateToPrimaryCard(presentScreenName, deviceName, locationName);
			}
			case "THERMOSTAT SETTING": {
				return navigate.navigateToThermostatSettings(presentScreenName, deviceName, locationName);
			}
			case "MANAGE ALERT": {
				return navigate.navigateToManageAlert(presentScreenName, deviceName, locationName);
			}
			case "SLEEP BRIGHTNESS": {
				return navigate.navigateToSleepBrightness(presentScreenName, deviceName, locationName);
			}
			case "THERMOSTAT CONFIGURATION": {
				return navigate.navigateToThermostatConfiguration(presentScreenName, deviceName, locationName);
			}
			case "MODE SETTING": {
				return navigate.navigateToSystemMode(presentScreenName, deviceName, locationName);
			}
			case "FAN SETTING": {
				return navigate.navigateToFanMode(presentScreenName, deviceName, locationName);
			}
			case "TIMEBASED SCHEDULE": {
				return navigate.navigateToSchedule(presentScreenName, deviceName, locationName);
			}
			case "GEOFENCE SCHEDULE": {
				return navigate.navigateToSchedule(presentScreenName, deviceName, locationName);
			}
			case "HAMBERGER MENU": {
				return navigate.navigateToSecondaryMenu(presentScreenName);
			}
			case "GEOFENCE SETTINGS": {
				return navigate.navigateToGeofence(presentScreenName);
			}
			case "VACATION SETTING": {
				return navigate.navigateToVacation(presentScreenName);
			}
			case "ACTIVITY HISTORY": {
				return navigate.navigateToActivityHistory(presentScreenName);
			}
			case "ADDRESS SETTING": {
				return navigate.navigateToAddress(presentScreenName);
			}
			case "ACCOUNT DETAILS": {
				return navigate.navigateToAccountDetails(presentScreenName);
			}
			case "CONNECTED SERVICE": {
				return navigate.navigateToConnectedService(presentScreenName);
			}
			case "ABOUT THE APP": {
				return navigate.navigateToABoutTheApp(presentScreenName);
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Screen Not available in backNavigation() method");
				return false;
			}

			}
		} else {

			return false;

		}

	}

	public static boolean NavigateAndVerify_IsExpectedScreen(TestCases testCase, TestCaseInputs inputs,
			String expectedScreen) {
		boolean flag = false;
		NavigatingScreenToScreen navigate = new NavigatingScreenToScreen(testCase);
	//		String presentScreenName = null;
	//		try {
	//			for (int i = 0; i < 6; i++) {
	//				presentScreenName = navigate.getScreenName_SkipNaviagte();
	//
	//				if (presentScreenName != null) {
		//				break;
		//			}
	//				Thread.sleep(3000);
	//			}
	//	} catch (Exception e) {
	//
		//}
			//
			String presentScreenName = navigate.getScreenName_SkipNaviagte();
		for (int i = 0; i < 6; i++) {
			try {
				if (presentScreenName.contains(expectedScreen)) {
					flag = true;
					break;
				} else {
					flag = navigateFromAnyScreenToExpectScreen_Alternate(testCase, inputs, navigate, expectedScreen);
					presentScreenName = navigate.getScreenName();
//					System.out.println("Present Screen name " + presentScreenName);
				}
			} catch (Exception e) {
				Keyword.ReportStep_Pass(testCase, "Exception raised due to " + e.getMessage()
						+ ",  Cause may be Internet slow or API not performance issue");
//				i = i - 1;
			}
		}

		return flag;

	}

	public static boolean navigateFromAnyScreenToExpectScreen_Alternate(TestCases testCase, TestCaseInputs inputs,
			NavigatingScreenToScreen navigate, String expectedScreen) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (MobileUtils.isMobElementExists("NAME", "Not Now", testCase, 2)) {
				MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
			}
		}
		String locationName = inputs.getInputValue("LOCATION1_NAME");
		String deviceName = inputs.getInputValue("LOCATION1_DEVICE1_NAME");
//		String locationName = "Home";
//		String deviceName = "Tstat 31AD74";
		String presentScreenName = navigate.getScreenName();

		if (presentScreenName != null) {
			System.out.println(
					"Present Screen Name = " + presentScreenName + ",,,,,,, go to this screen =" + expectedScreen);
			switch (expectedScreen) {

			case "ADD NEW DEVICE SCREEN": {
				flag = navigate.navigateToAddNewScreen(presentScreenName);
				break;
			}
			case "PRIMARYCARD": {
				flag = navigate.navigateToPrimaryCard(presentScreenName, deviceName, locationName);
				break;
			}
			case "THERMOSTAT SETTING": {
				flag = navigate.navigateToThermostatSettings(presentScreenName, deviceName, locationName);
				break;
			}
			case "MANAGE ALERT": {
				flag = navigate.navigateToManageAlert(presentScreenName, deviceName, locationName);
				break;
			}
			case "SLEEP BRIGHTNESS": {
				flag = navigate.navigateToSleepBrightness(presentScreenName, deviceName, locationName);
				break;
			}
			case "THERMOSTAT CONFIGURATION": {
				flag = navigate.navigateToThermostatConfiguration(presentScreenName, deviceName, locationName);
				break;
			}
			case "MODE SETTING": {
				flag = navigate.navigateToSystemMode(presentScreenName, deviceName, locationName);
				break;
			}
			case "FAN SETTING": {
				flag = navigate.navigateToFanMode(presentScreenName, deviceName, locationName);
				break;
			}
			case "TIMEBASED SCHEDULE": {
				flag = navigate.navigateToSchedule(presentScreenName, deviceName, locationName);
				break;
			}
			case "GEOFENCE SCHEDULE": {
				flag = navigate.navigateToSchedule(presentScreenName, deviceName, locationName);
				break;
			}
			case "HAMBERGER MENU": {
				flag = navigate.navigateToSecondaryMenu(presentScreenName);
				break;
			}
			case "GEOFENCE SETTINGS": {
				flag = navigate.navigateToGeofence(presentScreenName);
				break;
			}
			case "VACATION SETTING": {
				flag = navigate.navigateToVacation(presentScreenName);
				break;
			}
			case "ACTIVITY HISTORY": {
				flag = navigate.navigateToActivityHistory(presentScreenName);
				break;
			}
			case "ADDRESS SETTING": {
				flag = navigate.navigateToAddress(presentScreenName);
				break;
			}
			case "ACCOUNT DETAILS": {
				flag = navigate.navigateToAccountDetails(presentScreenName);
				break;
			}
			case "CONNECTED SERVICE": {
				flag = navigate.navigateToConnectedService(presentScreenName);
				break;
			}
			case "ABOUT THE APP": {
				flag = navigate.navigateToABoutTheApp(presentScreenName);
				break;
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Screen Not available in backNavigation() method");
				flag = false;
				break;
			}

			}
		} else {

			flag = false;

		}
		return flag;
	}

	/*
	 * AlertSettings_title AlertSettings_Image HomeKitSetUp_title HomeKitSetUp_Image
	 * brightMode_title brightMode_Image brightMode_value ResetWifi_title
	 * ResetWifi_Image ThermostatConfiguration_title ThermostatConfiguration_Image
	 * 
	 */
//	public static void sampletester(TestCases testCase) {
//		String pageSource = testCase.getMobileDriver().getPageSource();
//		System.out.println(pageSource);
//
//		WebElement tofield = MobileUtils.getMobElement(testCase, "NAME", "Mail.toField");
//		int topless = tofield.getRect().getY();
//		System.out.println(topless);
//		int wid = tofield.getSize().getWidth() / 2;
//
//		MobileUtils.clickOnCoordinate(testCase, wid, topless + topless);
//
//		MobileUtils.getMobElement(testCase, "NAME", "Mail.toField").sendKeys("comfort.automation@resideo.com");
//
//		WebElement sendbut = MobileUtils.getMobElement(testCase, "NAME", "Mail.sendButton");
//
//		int sendwid = sendbut.getSize().getWidth() / 2;
//		int sendx = sendbut.getRect().getX();
//		int xcor = sendwid + sendx;
//
//		int sendy = sendbut.getRect().getY();
//		int ycor = sendy + topless;
//
//		MobileUtils.clickOnCoordinate(testCase, xcor, ycor);
//
//		String i = "ter";
//
//	}

}
