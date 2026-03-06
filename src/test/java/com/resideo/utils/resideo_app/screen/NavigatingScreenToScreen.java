package com.resideo.utils.resideo_app.screen;

import org.openqa.selenium.Dimension;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

public class NavigatingScreenToScreen extends MobileScreens {

	private static final String screenName = "ScreenNavigation";

	public NavigatingScreenToScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public String getScreenName() {
		String screenName = null;
		String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
//		System.out.println(pageSource);
		
		if (pageSource == null) {
			try {
				Thread.sleep(1000);
				pageSource = testCase.getMobileDriver().getPageSource();
				if (pageSource == null) {
					Thread.sleep(2000);
					pageSource = testCase.getMobileDriver().getPageSource();
				}
			} catch (InterruptedException e) {
			}
		}
		
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (pageSource.contains("Main Menu".toUpperCase()) && pageSource.contains("dashboard".toUpperCase())
					&& pageSource.contains("Location".toUpperCase())) {
				screenName = "DASHBOARD";
			} else if (pageSource.contains("Add New Device".toUpperCase())
					&& pageSource.contains("SELECT A DEVICE TO INSTALL".toUpperCase())
					&& pageSource.contains("Change Country".toUpperCase())) {
				screenName = "ADD NEW DEVICE SCREEN";
			} else if (pageSource.contains("toolbar_device_name".toUpperCase())
					&& pageSource.contains("settings".toUpperCase())
					&& pageSource.contains("view_thermostat_current_temperature".toUpperCase())) {
				screenName = "PRIMARYCARD";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("thermostat_settings".toUpperCase())
					&& pageSource.contains("Configuration".toUpperCase())) {
				screenName = "THERMOSTAT SETTING";
			} else if (pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains("stat_alert_settings_list".toUpperCase())) {
				screenName = "MANAGE ALERT";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())) {
				screenName = "SLEEP BRIGHTNESS";
			} else if (pageSource.contains("Thermostat Configuration".toUpperCase())
					&& pageSource.contains("CONFIGURATION".toUpperCase())
					&& pageSource.contains("DEVICE INFORMATION".toUpperCase())) {
				screenName = "THERMOSTAT CONFIGURATION";
			} else if (pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("message".toUpperCase()) && pageSource.contains("Delete".toUpperCase())) {
				screenName = "DELETE DEVICE";
			} else if (pageSource.contains("A Specific Time".toUpperCase())
					&& pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove hold".toUpperCase())) {
				screenName = "SCHEDULE HOLD OPTIONS";
			} else if (!pageSource.contains("A Specific Time".toUpperCase())
					&& !pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove hold".toUpperCase())) {
				screenName = "GEOFENCE HOLD OPTIONS";
			} else if (pageSource.contains("Change Mode".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "MODE SETTING";
			} else if (pageSource.contains("CHANGE MODE".toUpperCase())
					&& pageSource.contains("info_list".toUpperCase())
					&& pageSource.contains("Information".toUpperCase())) {
				screenName = "MODE INFORMATION";
			} else if (pageSource.contains("Change Fan".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "FAN SETTING";
			} else if (pageSource.contains("CHANGE FAN".toUpperCase())
					&& pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("info_list".toUpperCase())) {
				screenName = "FAN INFORMATION";
			} else if (pageSource.contains("Schedule".toUpperCase())
					&& pageSource.contains("GROUPED DAYS".toUpperCase())
					&& pageSource.contains("SINGLE DAY".toUpperCase())) {
				screenName = "TIMEBASED SCHEDULE";
			} else if (pageSource.contains("Schedule".toUpperCase())
					&& pageSource.contains("WHEN I’M HOME".toUpperCase())
					&& pageSource.contains("WHEN I’M AWAY".toUpperCase())) {
				screenName = "GEOFENCE SCHEDULE";
			} else if (pageSource.contains("AUTOMATION".toUpperCase())
					&& pageSource.contains("HOME DETAILS".toUpperCase()) && pageSource.contains("ACCOUNT".toUpperCase())
					&& pageSource.contains("Activity History".toUpperCase())) {
				screenName = "HAMBERGER MENU";
			} else if (pageSource.contains("Geofence".toUpperCase())
					&& pageSource.contains("Geofence This Location".toUpperCase())
					&& pageSource.contains("Geofence Radius".toUpperCase())) {
				screenName = "GEOFENCE SETTINGS";
			} else if (pageSource.contains("Vacation".toUpperCase())
					&& pageSource.contains("Vacation Settings".toUpperCase())
					&& pageSource.contains("WHEN ARE YOU GOING ON VACATION".toUpperCase())
					&& pageSource.contains("REVIEW YOUR VACATION SETTINGS".toUpperCase())) {
				screenName = "VACATION SETTING";
			} else if ((pageSource.contains("Activity History".toUpperCase())
					&& pageSource.contains("Edit".toUpperCase()))
					|| (pageSource.contains("Activity History".toUpperCase())
							&& pageSource.contains("No Messages".toUpperCase()))) {
				screenName = "ACTIVITY HISTORY";
			} else if (pageSource.contains("Edit".toUpperCase()) && pageSource.contains("DELETE LOCATION".toUpperCase())
					&& pageSource.contains("location_details".toUpperCase())) {
				screenName = "ADDRESS SETTING";
			} else if (pageSource.contains("Account Details".toUpperCase())
					&& pageSource.contains("Delete Account".toUpperCase())) {
				screenName = "ACCOUNT DETAILS";
			} else if (pageSource.contains("Connected Services".toUpperCase())
					&& pageSource.contains("connected_partners_list".toUpperCase())) {
				screenName = "CONNECTED SERVICE";
			} else if (pageSource.contains("About the app".toUpperCase())
					&& pageSource.contains("Send Logs".toUpperCase()) && pageSource.contains("Version".toUpperCase())
					&& pageSource.contains("Rate the app".toUpperCase())) {
				screenName = "ABOUT THE APP";
			} else if (pageSource.contains("Today’s Forecast".toUpperCase())
					&& pageSource.contains("weather_current_temperature".toUpperCase())) {
				screenName = "FORECAST SCREEN";

			} else if (pageSource.contains("Welcome to your new Thermostat".toUpperCase())
					|| pageSource.contains("Welcome to your new thermostat".toUpperCase())) {
				screenName = "NEW DEVICE REGISTERED";
			} else if (pageSource.contains("Welcome to your new Thermostat".toUpperCase())
					|| pageSource.contains("Welcome to your new thermostat".toUpperCase())) {
				screenName = "NEW DEVICE REGISTERED";
			} else {
				screenName = "NOT IDENTIFIED";
			}

		} else {

			if ((pageSource.contains("menu".toUpperCase()) && pageSource.contains("dashboard_device".toUpperCase())
					&& pageSource.contains("Add New Device".toUpperCase()))
					|| (pageSource.contains("menu".toUpperCase())
							&& pageSource.contains("Add New Device".toUpperCase()))) {
				screenName = "DASHBOARD";
			} else if (pageSource.contains("Add New Device".toUpperCase())
					&& pageSource.contains("Select a device to install".toUpperCase())) {
				screenName = "ADD NEW DEVICE SCREEN";
			} else if (pageSource.contains("CurrentTemperature".toUpperCase())
					&& pageSource.contains("action_settings".toUpperCase())) {
				screenName = "PRIMARYCARD";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("Thermostat Settings".toUpperCase())
					&& pageSource.contains("COMFORT SETTINGS".toUpperCase())) {
				screenName = "THERMOSTAT SETTING";
			} else if (pageSource.contains("Manage Alerts".toUpperCase()) && pageSource.contains("ALERTS".toUpperCase())
					&& !pageSource.contains("Settings".toUpperCase())) {
				screenName = "MANAGE ALERT";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())
					&& !pageSource.contains("Configuration".toUpperCase())
					&& !pageSource.contains("Settings".toUpperCase())) {
				screenName = "SLEEP BRIGHTNESS";
			} else if (pageSource.contains("DEVICE INFORMATION".toUpperCase())
					&& pageSource.contains("SYSTEM CONFIGURATION".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "THERMOSTAT CONFIGURATION";
			} else if (pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("Delete".toUpperCase())) {
				screenName = "DELETE DEVICE";
			} else if (pageSource.contains("A Specific Time".toUpperCase())
					&& pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove Hold".toUpperCase())) {
				screenName = "SCHEDULE HOLD OPTIONS";
			} else if (pageSource.contains("Remove Hold".toUpperCase())
					&& !pageSource.contains("Permanently".toUpperCase())
					&& !pageSource.contains("A Specific Time".toUpperCase())) {
				screenName = "GEOFENCE HOLD OPTIONS";
			} else if (pageSource.contains("Change Mode".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "MODE SETTING";
			} else if (pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("CHANGE MODE".toUpperCase())) {
				screenName = "MODE INFORMATION";
			} else if (pageSource.contains("Change Fan".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "FAN SETTING";
			} else if (pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("CHANGE FAN".toUpperCase())) {
				screenName = "FAN INFORMATION";
			} else if (pageSource.contains("Schedule".toUpperCase()) && pageSource.contains("Options".toUpperCase())
					&& pageSource.contains("GROUPED DAYS".toUpperCase())
					&& pageSource.contains("SINGLE DAY".toUpperCase())) {
				screenName = "TIMEBASED SCHEDULE";
			} else if (pageSource.contains("WHEN I'M HOME".toUpperCase())
					&& pageSource.contains("WHEN I'M AWAY".toUpperCase())) {
				screenName = "GEOFENCE SCHEDULE";
			} else if (pageSource.contains("AUTOMATION".toUpperCase())
					&& pageSource.contains("Automation Details".toUpperCase())
					&& pageSource.contains("ACCOUNT".toUpperCase())) {
				screenName = "HAMBERGER MENU";
			} else if (pageSource.contains("Geofence".toUpperCase())
					&& pageSource.contains("Geofence this Location".toUpperCase())) {
				screenName = "GEOFENCE SETTINGS";
			} else if (pageSource.contains("Vacation".toUpperCase())
					&& pageSource.contains("Vacation Settings".toUpperCase())
					&& pageSource.contains("When are you going on vacation".toUpperCase())
					&& pageSource.contains("Review your vacation settings".toUpperCase())) {
				screenName = "VACATION SETTING";
			} else if (pageSource.contains("Activity History".toUpperCase())
					&& pageSource.contains("AUTOMATION".toUpperCase()) && !pageSource.contains("Users".toUpperCase())) {
				screenName = "ACTIVITY HISTORY";
			} else if (pageSource.contains("Edit".toUpperCase())
					&& pageSource.contains("Delete Location".toUpperCase())) {
				screenName = "ADDRESS SETTING";
			} else if (pageSource.contains("Account Details".toUpperCase())
					&& pageSource.contains("Delete Account".toUpperCase())) {
				screenName = "ACCOUNT DETAILS";
			} else if (pageSource.contains("Connected Services".toUpperCase())
					&& !pageSource.contains("Account Details".toUpperCase())
					&& !pageSource.contains("Users".toUpperCase())) {
				screenName = "CONNECTED SERVICE";
			} else if (pageSource.contains("About the app".toUpperCase())
					&& pageSource.contains("Send Logs".toUpperCase())
					&& pageSource.contains("Acknowledgements".toUpperCase())) {
				screenName = "ABOUT THE APP";
			} else if (pageSource.contains("Today's Forecast".toUpperCase())) {
				screenName = "FORECAST SCREEN";
			} else if (pageSource.contains("HomeKit".toUpperCase()) && !pageSource.contains("Settings".toUpperCase())
					&& !pageSource.contains("Thermostat Settings".toUpperCase())
					&& !pageSource.contains("COMFORT SETTINGS".toUpperCase())) {
				screenName = "HOMEKIT";
			} else {

				screenName = "NOT IDENTIFIED";
			}

		}
		if (screenName.contains("NOT IDENTIFIED")) {
			pageSource = testCase.getMobileDriver().getPageSource();
			if (pageSource.contains("Don't Ask Again".toUpperCase())) {
				clickOnDontAskAgain();
			} else if (pageSource.contains("Cancel".toUpperCase())) {
				if (clickOnCancelBTN()) {
					if (isCancelSetup()) {
						clickOnYesButton();
					}
				}
			} else if (pageSource.contains("Indoor Temperature Reading".toUpperCase())
					|| pageSource.contains("Temp Stepper".toUpperCase())
					|| pageSource.contains("Change thermostat mode".toUpperCase())
					|| pageSource.contains("Change the fan mode your system is".toUpperCase())
					|| pageSource.contains("View, edit or create a new schedule for your thermostat".toUpperCase())) {
				clickOnNextButton();
			} else if (pageSource.contains("View runtime data for your system".toUpperCase())) {
				clickOnDoneButton();
			} else if (pageSource.contains("Pro Invitation".toUpperCase())) {
				clickOnDismissButton();
			} else if (pageSource.contains("Welcome to your new Thermostat".toUpperCase())
					|| pageSource.contains("Welcome to your new thermostat".toUpperCase())) {
				clickOnNotNowButton();
			} else if (pageSource.contains("Navigate Up".toUpperCase())) {
				if (clickOnNavigateUp()) {
				} else {
					if (isCancelSetup()) {
						clickOnYesButton();
					}
				}
			} else if (pageSource.contains("Back".toUpperCase())) {
				clickOnBack();
			}
			screenName = getScreenName();
		}
		return screenName;
	}

	public String getScreenName_SkipNaviagte() {
		String screenName = null;
		
		String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
		if (pageSource == null) {
			try {
				Thread.sleep(1000);
				pageSource = testCase.getMobileDriver().getPageSource();
				if (pageSource == null) {
					Thread.sleep(2000);
					pageSource = testCase.getMobileDriver().getPageSource();
				}
			} catch (InterruptedException e) {
			}
		}
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (pageSource.contains("Main Menu".toUpperCase()) && pageSource.contains("dashboard".toUpperCase())
					&& pageSource.contains("Location".toUpperCase())) {
				screenName = "DASHBOARD";
			} else if (pageSource.contains("Add New Device".toUpperCase())
					&& pageSource.contains("SELECT A DEVICE TO INSTALL".toUpperCase())
					&& pageSource.contains("Change Country".toUpperCase())) {
				screenName = "ADD NEW DEVICE SCREEN";
			} else if (pageSource.contains("toolbar_device_name".toUpperCase())
					&& pageSource.contains("settings".toUpperCase())
					&& pageSource.contains("view_thermostat_current_temperature".toUpperCase())) {
				screenName = "PRIMARYCARD";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("thermostat_settings".toUpperCase())
					&& pageSource.contains("Configuration".toUpperCase())) {
				screenName = "THERMOSTAT SETTING";
			} else if (pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains("stat_alert_settings_list".toUpperCase())) {
				screenName = "MANAGE ALERT";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())) {
				screenName = "SLEEP BRIGHTNESS";
			} else if (pageSource.contains("Thermostat Configuration".toUpperCase())
					&& pageSource.contains("CONFIGURATION".toUpperCase())
					&& pageSource.contains("DEVICE INFORMATION".toUpperCase())) {
				screenName = "THERMOSTAT CONFIGURATION";
			} else if (pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("message".toUpperCase()) && pageSource.contains("Delete".toUpperCase())) {
				screenName = "DELETE DEVICE";
			} else if (pageSource.contains("A Specific Time".toUpperCase())
					&& pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove hold".toUpperCase())) {
				screenName = "SCHEDULE HOLD OPTIONS";
			} else if (!pageSource.contains("A Specific Time".toUpperCase())
					&& !pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove hold".toUpperCase())) {
				screenName = "GEOFENCE HOLD OPTIONS";
			} else if (pageSource.contains("Change Mode".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "MODE SETTING";
			} else if (pageSource.contains("CHANGE MODE".toUpperCase())
					&& pageSource.contains("info_list".toUpperCase())
					&& pageSource.contains("Information".toUpperCase())) {
				screenName = "MODE INFORMATION";
			} else if (pageSource.contains("Change Fan".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "FAN SETTING";
			} else if (pageSource.contains("CHANGE FAN".toUpperCase())
					&& pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("info_list".toUpperCase())) {
				screenName = "FAN INFORMATION";
			} else if (pageSource.contains("Schedule".toUpperCase())
					&& pageSource.contains("GROUPED DAYS".toUpperCase())
					&& pageSource.contains("SINGLE DAY".toUpperCase())) {
				screenName = "TIMEBASED SCHEDULE";
			} else if (pageSource.contains("Schedule".toUpperCase())
					&& pageSource.contains("WHEN I’M HOME".toUpperCase())
					&& pageSource.contains("WHEN I’M AWAY".toUpperCase())) {
				screenName = "GEOFENCE SCHEDULE";
			} else if (pageSource.contains("AUTOMATION".toUpperCase())
					&& pageSource.contains("HOME DETAILS".toUpperCase()) && pageSource.contains("ACCOUNT".toUpperCase())
					&& pageSource.contains("Activity History".toUpperCase())) {
				screenName = "HAMBERGER MENU";
			} else if (pageSource.contains("Geofence".toUpperCase())
					&& pageSource.contains("Geofence This Location".toUpperCase())
					&& pageSource.contains("Geofence Radius".toUpperCase())) {
				screenName = "GEOFENCE SETTINGS";
			} else if (pageSource.contains("Vacation".toUpperCase())
					&& pageSource.contains("Vacation Settings".toUpperCase())
					&& pageSource.contains("WHEN ARE YOU GOING ON VACATION".toUpperCase())
					&& pageSource.contains("REVIEW YOUR VACATION SETTINGS".toUpperCase())) {
				screenName = "VACATION SETTING";
			} else if ((pageSource.contains("Activity History".toUpperCase())
					&& pageSource.contains("Edit".toUpperCase()))
					|| (pageSource.contains("Activity History".toUpperCase())
							&& pageSource.contains("No Messages".toUpperCase()))) {
				screenName = "ACTIVITY HISTORY";
			} else if (pageSource.contains("Edit".toUpperCase()) && pageSource.contains("DELETE LOCATION".toUpperCase())
					&& pageSource.contains("location_details".toUpperCase())) {
				screenName = "ADDRESS SETTING";
			} else if (pageSource.contains("Account Details".toUpperCase())
					&& pageSource.contains("Delete Account".toUpperCase())) {
				screenName = "ACCOUNT DETAILS";
			} else if (pageSource.contains("Connected Services".toUpperCase())
					&& pageSource.contains("connected_partners_list".toUpperCase())) {
				screenName = "CONNECTED SERVICE";
			} else if (pageSource.contains("About the app".toUpperCase())
					&& pageSource.contains("Send Logs".toUpperCase()) && pageSource.contains("Version".toUpperCase())
					&& pageSource.contains("Rate the app".toUpperCase())) {
				screenName = "ABOUT THE APP";
			} else if (pageSource.contains("Today’s Forecast".toUpperCase())
					&& pageSource.contains("weather_current_temperature".toUpperCase())) {
				screenName = "FORECAST SCREEN";
			} else {
				screenName = "NOT IDENTIFIED";
			}

		} else {

			if ((pageSource.contains("menu".toUpperCase()) && pageSource.contains("dashboard_device".toUpperCase())
					&& pageSource.contains("Add New Device".toUpperCase()))
					|| (pageSource.contains("menu".toUpperCase())
							&& pageSource.contains("Add New Device".toUpperCase()))) {
				screenName = "DASHBOARD";
			} else if (pageSource.contains("Add New Device".toUpperCase())
					&& pageSource.contains("Select a device to install".toUpperCase())) {
				screenName = "ADD NEW DEVICE SCREEN";
			} else if (pageSource.contains("CurrentTemperature".toUpperCase())
					&& pageSource.contains("action_settings".toUpperCase())) {
				screenName = "PRIMARYCARD";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("Thermostat Settings".toUpperCase())
					&& pageSource.contains("COMFORT SETTINGS".toUpperCase())) {
				screenName = "THERMOSTAT SETTING";
			} else if (pageSource.contains("Manage Alerts".toUpperCase()) && pageSource.contains("ALERTS".toUpperCase())
					&& !pageSource.contains("Settings".toUpperCase())) {
				screenName = "MANAGE ALERT";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())
					&& !pageSource.contains("Configuration".toUpperCase())
					&& !pageSource.contains("Settings".toUpperCase())) {
				screenName = "SLEEP BRIGHTNESS";
			} else if (pageSource.contains("DEVICE INFORMATION".toUpperCase())
					&& pageSource.contains("SYSTEM CONFIGURATION".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "THERMOSTAT CONFIGURATION";
			} else if (pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("Delete".toUpperCase())) {
				screenName = "DELETE DEVICE";
			} else if (pageSource.contains("A Specific Time".toUpperCase())
					&& pageSource.contains("Permanently".toUpperCase())
					&& pageSource.contains("Remove Hold".toUpperCase())) {
				screenName = "SCHEDULE HOLD OPTIONS";
			} else if (pageSource.contains("Remove Hold".toUpperCase())
					&& !pageSource.contains("Permanently".toUpperCase())
					&& !pageSource.contains("A Specific Time".toUpperCase())) {
				screenName = "GEOFENCE HOLD OPTIONS";
			} else if (pageSource.contains("Change Mode".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "MODE SETTING";
			} else if (pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("CHANGE MODE".toUpperCase())) {
				screenName = "MODE INFORMATION";
			} else if (pageSource.contains("Change Fan".toUpperCase()) && pageSource.contains("Info".toUpperCase())) {
				screenName = "FAN SETTING";
			} else if (pageSource.contains("Information".toUpperCase())
					&& pageSource.contains("CHANGE FAN".toUpperCase())) {
				screenName = "FAN INFORMATION";
			} else if (pageSource.contains("Schedule".toUpperCase()) && pageSource.contains("Options".toUpperCase())
					&& pageSource.contains("GROUPED DAYS".toUpperCase())
					&& pageSource.contains("SINGLE DAY".toUpperCase())) {
				screenName = "TIMEBASED SCHEDULE";
			} else if (pageSource.contains("WHEN I'M HOME".toUpperCase())
					&& pageSource.contains("WHEN I'M AWAY".toUpperCase())) {
				screenName = "GEOFENCE SCHEDULE";
			} else if (pageSource.contains("AUTOMATION".toUpperCase())
					&& pageSource.contains("Automation Details".toUpperCase())
					&& pageSource.contains("ACCOUNT".toUpperCase())) {
				screenName = "HAMBERGER MENU";
			} else if (pageSource.contains("Geofence".toUpperCase())
					&& pageSource.contains("Geofence this Location".toUpperCase())) {
				screenName = "GEOFENCE SETTINGS";
			} else if (pageSource.contains("Vacation".toUpperCase())
					&& pageSource.contains("Vacation Settings".toUpperCase())
					&& pageSource.contains("When are you going on vacation".toUpperCase())
					&& pageSource.contains("Review your vacation settings".toUpperCase())) {
				screenName = "VACATION SETTING";
			} else if (pageSource.contains("Activity History".toUpperCase())
					&& pageSource.contains("AUTOMATION".toUpperCase()) && !pageSource.contains("Users".toUpperCase())) {
				screenName = "ACTIVITY HISTORY";
			} else if (pageSource.contains("Edit".toUpperCase())
					&& pageSource.contains("Delete Location".toUpperCase())) {
				screenName = "ADDRESS SETTING";
			} else if (pageSource.contains("Account Details".toUpperCase())
					&& pageSource.contains("Delete Account".toUpperCase())) {
				screenName = "ACCOUNT DETAILS";
			} else if (pageSource.contains("Connected Services".toUpperCase())
					&& !pageSource.contains("Account Details".toUpperCase())
					&& !pageSource.contains("Users".toUpperCase())) {
				screenName = "CONNECTED SERVICE";
			} else if (pageSource.contains("About the app".toUpperCase())
					&& pageSource.contains("Send Logs".toUpperCase())
					&& pageSource.contains("Acknowledgements".toUpperCase())) {
				screenName = "ABOUT THE APP";
			} else if (pageSource.contains("Today's Forecast".toUpperCase())) {
				screenName = "FORECAST SCREEN";
			} else if (pageSource.contains("HomeKit".toUpperCase()) && !pageSource.contains("Settings".toUpperCase())
					&& !pageSource.contains("Thermostat Settings".toUpperCase())
					&& !pageSource.contains("COMFORT SETTINGS".toUpperCase())) {
				screenName = "HOMEKIT";
			} else {

				screenName = "NOT IDENTIFIED";
			}

		}
		return screenName;
	}

	public boolean isCancelSetup() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Cancel Setup')]", testCase, 1);
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeAlert[contains(@label,'Cancel Setup')]",
					testCase, 1)) {
				return true;
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//XCUIElementTypeStaticText[contains(@label,'Cancel Setup')]", testCase, 1)) {
				return true;
			} else {
				return false;
			}
		}

	}

	public boolean isYesButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'YES')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@label,'Yes')]", testCase, 1);
		}
	}

	public boolean clickOnYesButton() {

		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'YES')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@label,'Yes')]");
		}
	}

	public boolean isNavigateUp() {
		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Navigate Up", testCase, 1);
	}

	public boolean clickOnNavigateUp() {
		return MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "Navigate Up");
	}

	public boolean isBack() {
		return MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Back", testCase, 1);
	}

	public boolean clickOnBack() {
		return MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "Back");
	}

	public boolean isCancelBTN() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@resource-id,'diy_cancel_button')]", testCase,
					1);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@label='Cancel']", testCase, 1);
		}
	}

	public boolean clickOnCancelBTN() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@resource-id,'diy_cancel_button')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@label='Cancel']");
		}
	}

	public boolean isNextButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Next')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("NAME", "Next", testCase, 1);
		}
	}

	public boolean clickOnNextButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Next')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Next");
		}
	}

	public boolean isNotNowButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[@text='Not Now']", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("NAME", "Not Now", testCase, 1);
		}
	}

	public boolean clickOnNotNowButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Not Now']");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
		}
	}

	public boolean isDoneButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Done')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("NAME", "Done", testCase, 1);
		}
	}

	public boolean clickOnDoneButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Done')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
	}

	public boolean clickOnDismissButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'DISMISS')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Dismiss");
		}
	}

	public boolean isDontAskAgain() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@resource-id,'btn_dont_ask')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("NAME", "Don't Ask Again", testCase, 1);
		}
	}

	public boolean clickOnDontAskAgain() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@resource-id,'btn_dont_ask')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
		}
	}

	public boolean clickOnBackButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackButton");
	}

	public boolean clickOnCross_CloseButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CrossAndCloseBTN");
	}

	public boolean clickOnCancelButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelBTN");
	}

	public boolean clickOnCancelButtonMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SpecialCancelButton");
	}

	public boolean clickOnAddNewButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddNewDeviceBTN");
	}

	public boolean clickOnDeviceNameFromDashboard(String deviceName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@resource-id,'device_name') and @text='" + deviceName + "']");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeButton[@value='" + deviceName + "']");
		}
	}

	public String getLocationNameFromDashboard() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getAttribute(testCase, "XPATH",
					"//android.widget.ImageButton[@content-desc='Main Menu']/following-sibling::android.widget.LinearLayout//android.widget.TextView",
					"text");
		} else {
			return MobileUtils.getAttribute(testCase, "XPATH",
					"//XCUIElementTypeButton[@name='menu']/preceding-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText",
					"name");
		}
	}

	public boolean clickOnLocationListFromDashboard() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//android.widget.ImageButton[@content-desc='Main Menu']/following-sibling::android.widget.LinearLayout//android.widget.TextView");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeButton[@name='menu']/preceding-sibling::XCUIElementTypeOther//XCUIElementTypeStaticText");
		}
	}

	public boolean clickOnLocationNameFromDropDown(String locationName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@resource-id,'item_dropdown') and @text='" + locationName + "']");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeStaticText[@value='" + locationName + "']");
		}
	}

	public boolean clickOnLocationNameFromDashboard(String locationName) {
		String currentLocationName = getLocationNameFromDashboard();
		if (!currentLocationName.contains(locationName)) {
			if (clickOnLocationListFromDashboard()) {
				return clickOnLocationNameFromDropDown(locationName);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Location not available in this account, Expecting Locations is " + locationName);
				return false;
			}
		} else {
			Keyword.ReportStep_Pass(testCase, "Already Location Selected, Location name is " + locationName);
			return true;
		}
	}

	public boolean clickOnThermostatSettingsButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatSettingBTN");
	}

	public boolean clickOnManageAlertButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ManageAlertsBTN");
	}

	public boolean clickOnSleepBrightnessModeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SleepBrightnessModeBTN");
	}

	public boolean clickOnResetWiFiButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ResetWiFiBTN");
	}

	public boolean clickOnThermostatConfigurationButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatConfigurationBTN", false, false);
	}

	public boolean clickOnHambererSecondaryMenuButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HambererSecondaryMenuBTN");
	}

	public boolean clickOnGeofenceButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "GeofenceBTN");
	}

	public boolean clickOnVacationButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "VacationBTN");
	}

	public boolean clickOnActivityHistoryButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ActivityHistoryBTN");
	}

	public boolean clickOnUsersButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "UsersBTN");
	}

	public boolean clickOnAddressButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddressBTN");
	}

	public boolean clickOnAccountDetailsButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AccountDetailsBTN");
	}

	public boolean clickOnConnectedServicesButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ConnectedServicesBTN");
	}

	public boolean clickOnDiagnosticsButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DiagnosticsBTN");
	}

	public boolean clickOnAbouttheappButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AbouttheappBTN");
	}

	public boolean clickOnLogOutButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LogOutBTN");
	}

	public boolean clickOnHomeKitUsersButton() {
		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeKitUsersBTN");
		} else {
			return false;
		}
	}

	public boolean clickOnSystemModeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemModeBTN");
	}

	public boolean clickOnFanModeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanModeBTN");
	}

	public boolean clickOnScheduleModeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ScheduleBTN");
	}

	public boolean backNavigation(String presentScreen) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			switch (presentScreen) {

			case "ADD NEW DEVICE SCREEN": {
				return clickOnBackButton();
			}
			case "PRIMARYCARD": {
				return clickOnBackButton();
			}
			case "THERMOSTAT SETTING": {
				return clickOnBackButton();
			}
			case "MANAGE ALERT": {
				return clickOnBackButton();
			}
			case "SLEEP BRIGHTNESS": {
				return clickOnBackButton();
			}
			case "THERMOSTAT CONFIGURATION": {
				return clickOnBackButton();
			}
			case "DELETE DEVICE": {
				return clickOnCancelButtonMode();
			}
			case "SCHEDULE HOLD OPTIONS": {
				return clickOnCancelButton();
			}
			case "GEOFENCE HOLD OPTIONS": {
				return clickOnCancelButton();
			}
			case "MODE SETTING": {
				return clickOnCross_CloseButton();
			}
			case "MODE INFORMATION": {
				return clickOnBackButton();
			}
			case "FAN SETTING": {
				return clickOnCross_CloseButton();
			}
			case "FAN INFORMATION": {
				return clickOnBackButton();
			}
			case "TIMEBASED SCHEDULE": {
				return clickOnBackButton();
			}
			case "GEOFENCE SCHEDULE": {
				return clickOnBackButton();
			}
			case "HAMBERGER MENU": {
				return clickOnBackButton();
			}
			case "GEOFENCE SETTINGS": {
				return clickOnBackButton();
			}
			case "VACATION SETTING": {
				return clickOnBackButton();
			}
			case "ACTIVITY HISTORY": {
				return clickOnBackButton();
			}
			case "ADDRESS SETTING": {
				return clickOnBackButton();
			}
			case "ACCOUNT DETAILS": {
				return clickOnBackButton();
			}
			case "CONNECTED SERVICE": {
				return clickOnBackButton();
			}
			case "ABOUT THE APP": {
				return clickOnBackButton();
			}
			case "FORECAST SCREEN": {
				return clickOnBackButton();
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Screen Not available in backNavigation() method");
				return false;
			}

			}
		} else {

			switch (presentScreen) {

			case "ADD NEW DEVICE SCREEN": {
				return clickOnCancelButton();
			}
			case "PRIMARYCARD": {
				return clickOnBackButton();
			}
			case "THERMOSTAT SETTING": {
				return clickOnBackButton();
			}
			case "MANAGE ALERT": {
				return clickOnBackButton();
			}
			case "SLEEP BRIGHTNESS": {
				return clickOnBackButton();
			}
			case "THERMOSTAT CONFIGURATION": {
				return clickOnBackButton();
			}
			case "DELETE DEVICE": {
				return clickOnCancelButtonMode();
			}
			case "SCHEDULE HOLD OPTIONS": {
				return clickOnCancelButton();
			}
			case "GEOFENCE HOLD OPTIONS": {
				return clickOnCancelButton();
			}
			case "MODE SETTING": {
				return clickOnCross_CloseButton();
			}
			case "MODE INFORMATION": {
				return clickOnBackButton();
			}
			case "FAN SETTING": {
				return clickOnCross_CloseButton();
			}
			case "FAN INFORMATION": {
				return clickOnBackButton();
			}
			case "TIMEBASED SCHEDULE": {
				return clickOnBackButton();
			}
			case "GEOFENCE SCHEDULE": {
				return clickOnBackButton();
			}
			case "HAMBERGER MENU": {
				return clickOnBackButton();
			}
			case "GEOFENCE SETTINGS": {
				return clickOnBackButton();
			}
			case "VACATION SETTING": {
				return clickOnBackButton();
			}
			case "ACTIVITY HISTORY": {
				return clickOnBackButton();
			}
			case "ADDRESS SETTING": {
				return clickOnBackButton();
			}
			case "ACCOUNT DETAILS": {
				return clickOnBackButton();
			}
			case "CONNECTED SERVICE": {
				return clickOnBackButton();
			}
			case "ABOUT THE APP": {
				return clickOnBackButton();
			}
			case "FORECAST SCREEN": {
				return clickOnBackButton();
			}
			default: {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Screen Not available in backNavigation() method");
				return false;
			}

			}

		}

	}

	public boolean navigateToDashboard(String screenName) {
		boolean flag = false;
		switch (screenName) {
		case "DASHBOARD": {
			flag = true;
			break;
		}
		case "ADD NEW DEVICE SCREEN": {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = clickOnBackButton();
			} else {
				flag = clickOnCancelButton();
			}
			break;
		}
		case "PRIMARYCARD": {
			flag = clickOnBackButton();
			break;
		}
		case "THERMOSTAT SETTING": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "MANAGE ALERT": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "SLEEP BRIGHTNESS": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "THERMOSTAT CONFIGURATION": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "DELETE DEVICE": {
			flag = clickOnCancelButtonMode();
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "SCHEDULE HOLD OPTIONS": {
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "GEOFENCE HOLD OPTIONS": {
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "MODE SETTING": {
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "MODE INFORMATION": {
			flag = clickOnBackButton();
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "FAN SETTING": {
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "FAN INFORMATION": {
			flag = clickOnBackButton();
			flag = clickOnCross_CloseButton();
			flag = clickOnBackButton();
			break;
		}
		case "TIMEBASED SCHEDULE": {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = clickOnBackButton();
			} else {
				flag = clickOnCross_CloseButton();
			}
			flag = clickOnBackButton();
			break;
		}
		case "GEOFENCE SCHEDULE": {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = clickOnBackButton();
			} else {
				flag = clickOnCross_CloseButton();
			}
			flag = clickOnBackButton();
			break;
		}
		case "HAMBERGER MENU": {
			flag = clickOnBackButton();
			break;
		}
		case "GEOFENCE SETTINGS": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "VACATION SETTING": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "ACTIVITY HISTORY": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "ADDRESS SETTING": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "ACCOUNT DETAILS": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "CONNECTED SERVICE": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "ABOUT THE APP": {
			flag = clickOnBackButton();
			flag = clickOnBackButton();
			break;
		}
		case "FORECAST SCREEN": {
			flag = clickOnBackButton();
			break;
		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToDashboard() method");
			flag = false;
			break;
		}

		}
		return flag;

	}

	public boolean navigateToAddNewScreen(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("ADD NEW DEVICE SCREEN")) {
			flag = true;
		} else if (presentScreenName.contains("DASHBOARD")) {
			flag = clickOnAddNewButton();
		} else {
			flag = navigateToDashboard(presentScreenName);
			flag = clickOnAddNewButton();
		}
		return flag;
	}

	public boolean closePopUpInPrimaryCards(int trailCount) {
		boolean flag = false;
		String pageSource = testCase.getMobileDriver().getPageSource();
		if (pageSource.contains("Don't Ask Again")) {
			if (isDontAskAgain()) {
				clickOnDontAskAgain();
			}
			flag = closePopUpInPrimaryCards(trailCount + 1);
		} else if (pageSource.contains("Cancel")) {

			if (isCancelBTN()) {
				if (clickOnCancelBTN()) {
					if (isCancelSetup()) {
						clickOnYesButton();
					}
				}
			}
			flag = closePopUpInPrimaryCards(trailCount + 1);
		} else if (pageSource.contains("Indoor Temperature Reading") || pageSource.contains("Temp Stepper")
				|| pageSource.contains("Change thermostat mode")
				|| pageSource.contains("Change the fan mode your system is")
				|| pageSource.contains("View, edit or create a new schedule for your thermostat")) {
			if (isNextButton()) {
				clickOnNextButton();
			}
			flag = closePopUpInPrimaryCards(trailCount + 1);
		} else if (pageSource.contains("View runtime data for your system")) {
			if (isDoneButton()) {
				clickOnDoneButton();
			}
		} else if (pageSource.contains("Welcome to your new Thermostat")
				|| pageSource.contains("Welcome to your new thermostat")) {

			if (isNotNowButton()) {
				clickOnNotNowButton();
			}
			flag = closePopUpInPrimaryCards(trailCount + 1);
		} else if (pageSource.contains("action_settings")) {
			if (trailCount > 1) {
				flag = true;

			} else {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (trailCount == 1) {
					flag = closePopUpInPrimaryCards(trailCount + 1);
				}
			}

		} else {
			flag = false;
		}
		return flag;
	}

	public boolean navigateToPrimaryCard(String presentScreenName, String deviceName, String locationName) {

		boolean flag = false;

		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN")) {

			flag = navigateToDashboard(presentScreenName);
			flag = flag && clickOnLocationNameFromDashboard(locationName);
			flag = flag && clickOnDeviceNameFromDashboard(deviceName);
			flag = flag && closePopUpInPrimaryCards(1);

		} else if (presentScreenName.contains("PRIMARYCARD")) {
			flag = true;
		} else if (presentScreenName.contains("THERMOSTAT SETTING")) {
			flag = clickOnBackButton();
		} else if (presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")) {
			flag = clickOnBackButton();
			flag = flag && clickOnBackButton();
		} else if (presentScreenName.contains("DELETE DEVICE")) {
			flag = clickOnCancelButtonMode();
			flag = flag && clickOnBackButton();
			flag = flag && clickOnBackButton();
		} else if (presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS")) {
			flag = clickOnCancelButton();
		} else if (presentScreenName.contains("MODE SETTING") || presentScreenName.contains("FAN SETTING")) {
			flag = clickOnCross_CloseButton();
		} else if (presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE")) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = clickOnBackButton();
			} else {
				flag = clickOnCross_CloseButton();
			}
		} else if (presentScreenName.contains("MODE INFORMATION") || presentScreenName.contains("FAN INFORMATION")) {
			flag = clickOnBackButton();
			flag = flag && clickOnCross_CloseButton();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in NavigateToPrimaryCard() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToSystemMode(String presentScreenName, String deviceName, String locationName) {

		boolean flag = false;

		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("THERMOSTAT SETTING") || presentScreenName.contains("MANAGE ALERT")
				|| presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("FAN SETTING")
				|| presentScreenName.contains("TIMEBASED SCHEDULE") || presentScreenName.contains("GEOFENCE SCHEDULE")
				|| presentScreenName.contains("MODE INFORMATION") || presentScreenName.contains("FAN INFORMATION")
				|| presentScreenName.contains("DELETE DEVICE")) {

			flag = navigateToPrimaryCard(presentScreenName, deviceName, locationName);

			flag = flag && clickOnSystemModeButton();
		} else if (presentScreenName.contains("MODE SETTING")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in NavigateToPrimaryCard() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToFanMode(String presentScreenName, String deviceName, String locationName) {

		boolean flag = false;

		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("THERMOSTAT SETTING") || presentScreenName.contains("MANAGE ALERT")
				|| presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("TIMEBASED SCHEDULE") || presentScreenName.contains("GEOFENCE SCHEDULE")
				|| presentScreenName.contains("MODE INFORMATION") || presentScreenName.contains("FAN INFORMATION")
				|| presentScreenName.contains("DELETE DEVICE")) {

			flag = navigateToPrimaryCard(presentScreenName, deviceName, locationName);
			flag = flag && clickOnFanModeButton();
		} else if (presentScreenName.contains("FAN SETTING")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in NavigateToPrimaryCard() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToSchedule(String presentScreenName, String deviceName, String locationName) {

		boolean flag = false;

		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("THERMOSTAT SETTING") || presentScreenName.contains("MANAGE ALERT")
				|| presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("DELETE DEVICE")) {

			flag = navigateToPrimaryCard(presentScreenName, deviceName, locationName);
			flag = flag && clickOnScheduleModeButton();
		} else if (presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in NavigateToPrimaryCard() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToThermostatSettings(String presentScreenName, String deviceName, String locationName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION")) {
			flag = navigateToPrimaryCard(presentScreenName, deviceName, locationName);
			flag = flag && clickOnThermostatSettingsButton();
		} else if (presentScreenName.contains("THERMOSTAT SETTING")) {
			flag = true;
		} else if (presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")) {
			flag = clickOnBackButton();
		} else if (presentScreenName.contains("DELETE DEVICE")) {
			flag = clickOnCancelButtonMode();
			flag = flag && clickOnBackButton();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in NavigateToThermostatSettings() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToManageAlert(String presentScreenName, String deviceName, String locationName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")
				|| presentScreenName.contains("DELETE DEVICE")) {

			flag = navigateToThermostatSettings(presentScreenName, deviceName, locationName);
			flag = flag && clickOnManageAlertButton();
		} else if (presentScreenName.contains("MANAGE ALERT")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToManageAlert() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToSleepBrightness(String presentScreenName, String deviceName, String locationName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION") || presentScreenName.contains("DELETE DEVICE")
				|| presentScreenName.contains("MANAGE ALERT")) {

			flag = navigateToThermostatSettings(presentScreenName, deviceName, locationName);
			flag = flag && clickOnSleepBrightnessModeButton();
		} else if (presentScreenName.contains("SLEEP BRIGHTNESS")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToSleepBrightness() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToResetWiFi(String presentScreenName, String deviceName, String locationName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION") || presentScreenName.contains("DELETE DEVICE")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")) {

			flag = navigateToThermostatSettings(presentScreenName, deviceName, locationName);
			flag = flag && clickOnResetWiFiButton();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToResetWiFi() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToThermostatConfiguration(String presentScreenName, String deviceName, String locationName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ADDRESS SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("CONNECTED SERVICE") || presentScreenName.contains("ABOUT THE APP")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")) {

			flag = navigateToThermostatSettings(presentScreenName, deviceName, locationName);
			flag = flag && clickOnThermostatConfigurationButton();
		} else if (presentScreenName.contains("THERMOSTAT CONFIGURATION")) {
			flag = true;
		} else if (presentScreenName.contains("DELETE DEVICE")) {
			flag = clickOnCancelButtonMode();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToSecondaryMenu(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("THERMOSTAT CONFIGURATION")) {

			flag = navigateToDashboard(presentScreenName);
			flag = flag && clickOnHambererSecondaryMenuButton();
		} else if (presentScreenName.contains("HAMBERGER MENU")) {
			flag = true;
		} else if (presentScreenName.contains("GEOFENCE SETTINGS") || presentScreenName.contains("VACATION SETTING")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {
			flag = clickOnBackButton();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToGeofence(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("VACATION SETTING")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnGeofenceButton();

		} else if (presentScreenName.contains("GEOFENCE SETTINGS")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToVacation(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnVacationButton();
		} else if (presentScreenName.contains("VACATION SETTING")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToActivityHistory(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnActivityHistoryButton();
		} else if (presentScreenName.contains("ACTIVITY HISTORY")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToAddress(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ACCOUNT DETAILS")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnAddressButton();
		} else if (presentScreenName.contains("ADDRESS SETTING")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToAccountDetails(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnAccountDetailsButton();
		} else if (presentScreenName.contains("ACCOUNT DETAILS")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToConnectedService(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("ACTIVITY HISTORY")
				|| presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			flag = flag && clickOnConnectedServicesButton();
		} else if (presentScreenName.contains("CONNECTED SERVICE")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean navigateToABoutTheApp(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ACTIVITY HISTORY")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			if (scrollToExpectedElement("AbouttheappBTN")) {
				flag = clickOnAbouttheappButton();
			} else {
				flag = false;
			}
		} else if (presentScreenName.contains("ABOUT THE APP")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean clickOnlogOut(String presentScreenName) {
		boolean flag = false;
		if (presentScreenName.contains("DASHBOARD") || presentScreenName.contains("ADD NEW DEVICE SCREEN")
				|| presentScreenName.contains("FORECAST SCREEN") || presentScreenName.contains("PRIMARYCARD")
				|| presentScreenName.contains("SCHEDULE HOLD OPTIONS")
				|| presentScreenName.contains("GEOFENCE HOLD OPTIONS") || presentScreenName.contains("MODE SETTING")
				|| presentScreenName.contains("FAN SETTING") || presentScreenName.contains("TIMEBASED SCHEDULE")
				|| presentScreenName.contains("GEOFENCE SCHEDULE") || presentScreenName.contains("MODE INFORMATION")
				|| presentScreenName.contains("FAN INFORMATION") || presentScreenName.contains("THERMOSTAT SETTING")
				|| presentScreenName.contains("MANAGE ALERT") || presentScreenName.contains("SLEEP BRIGHTNESS")
				|| presentScreenName.contains("HAMBERGER MENU") || presentScreenName.contains("GEOFENCE SETTINGS")
				|| presentScreenName.contains("VACATION SETTING") || presentScreenName.contains("ADDRESS SETTING")
				|| presentScreenName.contains("ACCOUNT DETAILS") || presentScreenName.contains("CONNECTED SERVICE")
				|| presentScreenName.contains("ACTIVITY HISTORY") || presentScreenName.contains("ABOUT THE APP")) {

			flag = navigateToSecondaryMenu(presentScreenName);
			if (scrollToExpectedElement("LogOutBTN")) {
				flag = clickOnAbouttheappButton();
			} else {
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Screen Not available in navigateToThermostatConfiguration() method");
			flag = false;
		}
		return flag;
	}

	public boolean scrollToExpectedElement(String objName) {
		boolean flag = false;
		try {
			Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

			int x = (int) (dimens.getWidth() * 0.5);
			int endY = (int) (dimens.getHeight() * 0.2);
			int startY = (int) (dimens.getHeight() * 0.75);
			for (int i = 0; i <= 3; i++) {
				if (MobileUtils.isMobElementExists(objectDefinition, testCase, objName)) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully Scroll to Expected Element => , " + objName);
					break;
				} else {
					testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
				}
			}
			if (!flag) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to scroll to " + objName);
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e + "  =====>>>>Not able to scroll to " + objName);
			flag = false;
		}
		return flag;
	}

}
