package com.resideo.utils.resideo_app;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.CommonState;
import com.resideo.system.utils.SystemState;
import com.resideo.system.utils.TrailData;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;

public class PrimaryCardUtils {

	public static boolean closeAllInstructionPopup(TestCases testCase) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		DIYScreen diy = new DIYScreen(testCase);
		String deviceName = SystemState.getStatus().getTstatName().trim();
		System.out.println("device name " + deviceName);
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(100));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
//					System.out.println(pageSource);
						String screenName = getScreenData(testCase, pageSource, deviceName);
						if (screenName.equals("instruction popup")) {
							if (pm.instructionPopupNextButton()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on Next Button");
							}
							return false;
						} else if (diy.isUnknownPopUP()) {
							diy.clickOnUnknownPopUP("dashboard");
							return false;
						} else if (screenName.equals("dashboard")) {
							return true;
						} else {
							return false;
						}
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "Null Pointer exception due to late loading screen");
						return false;
					} catch (TimeoutException e) {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + 6
//										+ " minutes");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
//										+ e.getMessage());
						return false;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase, "navigation is successful");
				flag = true;
			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//						"Failed to close popup");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase,
					"Exception occurred closeAllInstructionPopup(TestCases testCase) due to " + e.getMessage());
//		Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//				"Exception occurred closeAllInstructionPopup(TestCases testCase) due to "
//						+ e.getMessage());
			return false;
		}
		return flag;
	}

	public static boolean deleteThermostat(TestCases testCase) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		DIYScreen diy = new DIYScreen(testCase);
		String deviceName = testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(8));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
//						System.out.println(pageSource);
						String screenName = getScreenData(testCase, pageSource, deviceName);
						if (screenName.equals("instruction popup")) {
							if (pm.instructionPopupNextButton()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on Next Button");
							}
							return false;
						} else if (diy.isUnknownPopUP()) {
							diy.clickOnUnknownPopUP("Primarycard");
							return false;
						} else if (!SystemState.getStatus().isDeletePerformed() && screenName.equals("dashboard")) {
							if (pm.clickOnDeviceNameFromDashboard(deviceName)) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on device card");
							}
							return false;
						} else if (screenName.equals("demand")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "OK");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							}
							return false;
						} else if (screenName.equals("welcome back")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/btn_dont_ask']");
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							}
							return false;
						} else if (screenName.equals("new thermostat")) {
							if (pm.clickOnNotNowBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							}
							return false;
						} else if (screenName.equals("welcome back new thermostat")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/btn_dont_ask']");
							}
							return false;
						} else if (screenName.equals("primary card")) {
							if (pm.clickOnPrimaryCardSettingBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on settings");
							}
							return false;
						} else if (screenName.equals("thermostat settings")) {
							if (pm.clickOnThermostatConfigurationBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on thermostat configuration");
							}
							return false;
						} else if (screenName.equals("thermostat configuration")) {
							if (pm.clickOnDeleteThermostatBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on delete thermostat");
							}
							return false;
						} else if (screenName.equals("delete popup")) {
							if (pm.clickOnDeleteBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on delete in popup");
							}
							SystemState.getStatus().isDeletePerformed(true);
							return false;
						} else if (screenName.equals("integerated remove popup")) {
							if (pm.clickOnRemoveBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on Remove in popup");
							}
							SystemState.getStatus().isDeletePerformed(true);
							return false;
						} else if (screenName.equals("reset wifi") || screenName.equals("alert")
								|| screenName.equals("brightness")) {
							pm.settingsAfterFeatureBackButton();
							return false;
						} else if (screenName.equals("homekit error")) {
							MobileUtils.clickOnElement(testCase, "name", "OK", false);
							MobileUtils.clickOnElement(testCase, "name", "Skip", false);
							return false;
						} else if (screenName.equals("homekit")) {
							MobileUtils.clickOnElement(testCase, "name", "Skip", false);
							return false;
						} else if (pageSource.contains("ABOUT REBATES")
								&& pageSource.contains("PUT MONEY BACK INTO YOUR POCKET")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']");
								} else {
									MobileUtils.pressBackButton(testCase,
											"Pressed Back Button, Navigate up didnt work");
								}
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to find Cause");
									Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());
								}
							}
							return false;

//						} else if (screenName.equals("alert")) {
//							pm.settingsAfterFeatureBackButton();
//							return false;
//						} else if (screenName.equals("brightness")) {
//							pm.settingsAfterFeatureBackButton();
//							return false;
						} else if (SystemState.getStatus().isDeletePerformed() && screenName.equals("dashboard")) {
							Keyword.ReportStep_Pass(testCase, "Device deleted from APP , Device name is " + deviceName);
							return true;

						} else if (screenName.equals("unknown")) {
							return false;
						} else {
							return false;
						}
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "Null Pointer exception due to late loading screen");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + 6
										+ " minutes");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase, "Unregistration is completed sucessfully");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"unregistration failed following devoce name " + deviceName);
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
							+ e.getMessage());
			return false;
		}
		return flag;
	}

	public static boolean navigateToThermostatConfiguration(TestCases testCase, String heatingSystem,
			String heatingStages, String coolingStages) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		DIYScreen diy = new DIYScreen(testCase);
		String deviceName = testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(8));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
//						System.out.println(pageSource);
						String screenName = getScreenData(testCase, pageSource, deviceName);
						if (screenName.equals("instruction popup")) {
							if (pm.instructionPopupNextButton()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on Next Button");
							}
							return false;
						} else if (diy.isUnknownPopUP()) {
							diy.clickOnUnknownPopUP("Primarycard");
							return false;
						} else if (!SystemState.getStatus().isDeletePerformed() && screenName.equals("dashboard")) {
							if (pm.clickOnDeviceNameFromDashboard(deviceName)) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on device card");
							}
							return false;
						} else if (screenName.equals("demand")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "OK");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							}
							return false;
						} else if (screenName.equals("welcome back")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/btn_dont_ask']");
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							}
							return false;
						} else if (screenName.equals("new thermostat")) {
							if (pm.clickOnNotNowBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on not now");
							}
							return false;
						} else if (screenName.equals("welcome back new thermostat")) {
							if (testCase.getPlatform().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/btn_dont_ask']");
							}
							return false;
						} else if (screenName.equals("primary card")) {
							if (pm.clickOnPrimaryCardSettingBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on settings");
							}
							return false;
						} else if (screenName.equals("thermostat settings")) {
							if (pm.clickOnThermostatConfigurationBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"Current screen is " + screenName + " its clicked on thermostat configuration");
							}
							return false;
						} else if (screenName.equals("thermostat configuration")) {
							isDeviceConfiguration_Valid(testCase, heatingSystem, heatingStages, coolingStages);
							return true;
						} else if (screenName.equals("reset wifi") || screenName.equals("alert")
								|| screenName.equals("brightness")) {
							pm.settingsAfterFeatureBackButton();
							return false;
						} else if (screenName.equals("homekit error")) {
							MobileUtils.clickOnElement(testCase, "name", "OK", false);
							MobileUtils.clickOnElement(testCase, "name", "Skip", false);
							return false;
						} else if (screenName.equals("homekit")) {
							MobileUtils.clickOnElement(testCase, "name", "Skip", false);
							return false;
						} else if (screenName.equals("dashboard")) {
							Keyword.ReportStep_Pass(testCase, "Device deleted from APP , Device name is " + deviceName);
							return false;
						} else if (screenName.equals("unknown")) {
							return false;
						} else {
							return false;
						}
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "Null Pointer exception due to late loading screen");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + 6
										+ " minutes");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase, "Unregistration is completed sucessfully");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"unregistration failed following devoce name " + deviceName);
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
							+ e.getMessage());
			return false;
		}
		return flag;
	}

	public static boolean isDeviceConfiguration_Valid(TestCases testCase, String heatingSystem, String heatingStages,
			String coolingStages) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		String heating_System = pm.getHeatingSystem();
		String heating_Stages = pm.getHeatingStages();
		String cooling_Stages = pm.getCoolingStages();
		if (heatingSystem.toUpperCase().equals(heating_System.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured System is " + heating_System);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Heating system is " + heatingSystem + ", Actual heating system is " + heating_System);
			flag = false;
		}
		if (heatingStages.toUpperCase().equals(heating_Stages.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured heating stages is " + heatingStages);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Heating system is " + heatingStages + ", Actual heating system is " + heating_Stages);
			flag = false;
		}
		if (coolingStages.toUpperCase().equals(cooling_Stages.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured Cooling stages is " + cooling_Stages);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Heating system is " + coolingStages + ", Actual heating system is " + cooling_Stages);
			flag = false;
		}
		return flag;
	}

	public static String getScreenData(TestCases testCase, String pageSource, String deviceName) {

		String screenName = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

			if (pageSource.contains("MAIN MENU".toUpperCase())
					&& pageSource.contains("dashboard_recyclerview".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase())) {
				screenName = "dashboard";

			} else if (pageSource.contains("welcome back".toUpperCase())
					&& pageSource.contains("get started".toUpperCase())
					&& pageSource.contains("remind me later".toUpperCase())) {
				screenName = "welcome back";
			} else if (pageSource.contains("Access More Information".toUpperCase())
					|| pageSource.contains("Quick Controls".toUpperCase())
					|| pageSource.contains("Status Area".toUpperCase())
					|| pageSource.contains("Indoor Temperature Reading".toUpperCase())
					|| pageSource.contains("Browse Status".toUpperCase())
					|| (pageSource.contains("Temp Stepper".toUpperCase())
							&& pageSource.contains("Quickly change the temperature".toUpperCase()))
					|| (pageSource.contains("Mode".toUpperCase())
							&& pageSource.contains("Change thermostat mode".toUpperCase()))
					|| (pageSource.contains("Fan".toUpperCase())
							&& pageSource.contains("Change the fan mode".toUpperCase()))
					|| (pageSource.contains("Schedule".toUpperCase())
							&& pageSource.contains("View, edit or create a new schedule".toUpperCase()))
					|| (pageSource.contains("Runtime".toUpperCase())
							&& pageSource.contains("View runtime data for your system".toUpperCase()))
					|| (pageSource.contains("More".toUpperCase())
							&& pageSource.contains("See more controls, including Schedule and Runtime.".toUpperCase()))
					|| (pageSource.contains("Priority".toUpperCase()) && pageSource.contains(
							"Creates an average temperature in your home based on specific rooms. This allows you to prioritize comfort where you want."
									.toUpperCase()))
					|| pageSource.contains("Tap for More".toUpperCase())) {
				screenName = "instruction popup";
			} else if (pageSource.contains("Welcome Back".toUpperCase())
					&& pageSource.contains("Get Started".toUpperCase())
					&& pageSource.contains("Remind me later".toUpperCase())) {
				screenName = "welcome back new thermostat";
			} else if (pageSource.contains("Welcome to your new thermostat".toUpperCase())
					&& pageSource.contains("Get Started".toUpperCase())
					&& pageSource.contains("Not Now".toUpperCase())) {
				screenName = "new thermostat";
			} else if (pageSource.contains("Savings Event scheduled".toUpperCase())
					&& pageSource.contains("ok".toUpperCase())) {
				screenName = "demand";
			} else if (pageSource.contains("action_settings".toUpperCase())
					&& pageSource.contains("Navigate Up".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase())) {
				screenName = "primary card";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("Navigate Up".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "thermostat settings";
			} else if (!pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase())
					&& !pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "alert";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())) {
				screenName = "brightness";
			} else if (pageSource.contains("Installation".toUpperCase())
					&& pageSource.contains("Start thermostat network".toUpperCase())
					&& !pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "reset wifi";
			} else if (pageSource.contains("Delete".toUpperCase())
					&& pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("Delete ".toUpperCase() + deviceName.toUpperCase())) {
				screenName = "delete popup";
			} else if (pageSource.contains("DEVICE INFORMATION".toUpperCase())
					&& pageSource.contains("Delete Thermostat".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("Navigate Up".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "thermostat configuration";
			} else if (pageSource.contains("MAIN MENU".toUpperCase())
					&& pageSource.contains("dashboard_recyclerview".toUpperCase())
					&& !pageSource.contains(deviceName.toUpperCase())) {
//				screenName = "dashboard after device deleted";
				screenName = "dashboard";
			} else if (pageSource.contains("action_settings".toUpperCase())
					&& pageSource.contains("Navigate Up".toUpperCase())
					&& pageSource.contains("Cloud Connection Error".toUpperCase())) {
				screenName = "primary card";

			} else {
				screenName = "unknown";
			}
		} else {

			if (pageSource.contains("MENU".toUpperCase()) && pageSource.contains("Location Name".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase())) {
				screenName = "dashboard";
			} else if (pageSource.contains("Access More Information".toUpperCase())
					|| pageSource.contains("Quick Controls".toUpperCase())
					|| pageSource.contains("Status Area".toUpperCase())
					|| pageSource.contains("Indoor temperature reading".toUpperCase())
					|| (pageSource.contains("Temp stepper".toUpperCase())
							&& pageSource.contains("Quickly change the temperature".toUpperCase()))
					|| (pageSource.contains("Mode".toUpperCase())
							&& pageSource.contains("Change thermostat mode".toUpperCase()))
					|| (pageSource.contains("Fan".toUpperCase())
							&& pageSource.contains("Change the fan mode".toUpperCase()))
					|| (pageSource.contains("Schedule".toUpperCase())
							&& pageSource.contains("View, edit or create a new schedule".toUpperCase()))
					|| (pageSource.contains("Runtime".toUpperCase())
							&& pageSource.contains("View runtime data for your system".toUpperCase()))
					|| pageSource.contains("Browse Status".toUpperCase())
					|| (pageSource.contains("More".toUpperCase())
							&& pageSource.contains("See more controls, including Schedule and Runtime.".toUpperCase()))
					|| (pageSource.contains("Priority".toUpperCase()) && pageSource.contains(
							"Creates an average temperature in your home based on specific rooms. This allows you to prioritize comfort where you want."
									.toUpperCase()))
					|| pageSource.contains("Tap for More".toUpperCase())
					|| pageSource.contains("Quick Controls".toUpperCase())
					|| pageSource.contains("Status Area".toUpperCase())
					|| pageSource.contains("Indoor Temperature Reading".toUpperCase())
					|| pageSource.contains("Browse Status".toUpperCase())
					|| (pageSource.contains("Temp Stepper".toUpperCase())
							&& pageSource.contains("Quickly change the temperature".toUpperCase()))
					|| (pageSource.contains("Mode".toUpperCase())
							&& pageSource.contains("Change thermostat mode".toUpperCase()))
					|| (pageSource.contains("Fan".toUpperCase())
							&& pageSource.contains("Change the fan mode".toUpperCase()))
					|| (pageSource.contains("Schedule".toUpperCase())
							&& pageSource.contains("View, edit or create a new schedule".toUpperCase()))
					|| (pageSource.contains("Runtime".toUpperCase())
							&& pageSource.contains("View runtime data for your system".toUpperCase()))
					|| (pageSource.contains("More".toUpperCase())
							&& pageSource.contains("See more controls, including Schedule and Runtime.".toUpperCase()))
					|| (pageSource.contains("Priority".toUpperCase()) && pageSource.contains(
							"Creates an average temperature in your home based on specific rooms. This allows you to prioritize comfort where you want."
									.toUpperCase()))
					|| pageSource.contains("Tap for More".toUpperCase())) {
				screenName = "instruction popup";
			} else if (pageSource.contains("welcome back".toUpperCase())
					&& pageSource.contains("get started".toUpperCase())
					&& pageSource.contains("remind me later".toUpperCase())) {
				screenName = "welcome back";
			} else if (pageSource.contains("Savings Event scheduled".toUpperCase())
					&& pageSource.contains("ok".toUpperCase())) {
				screenName = "demand";
			} else if (pageSource.contains("Welcome to your new Thermostat".toUpperCase())
					&& pageSource.contains("Get Started".toUpperCase())
					&& pageSource.contains("Not Now".toUpperCase())) {
				screenName = "new thermostat";
			} else if (pageSource.contains("action_settings".toUpperCase()) && pageSource.contains("Back".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase())) {
				screenName = "primary card";
			} else if (pageSource.contains("Settings".toUpperCase())
					&& pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("Back".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "thermostat settings";
			} else if (pageSource.contains("Delete".toUpperCase())
					&& pageSource.contains("Are you sure you want to delete".toUpperCase())
					&& pageSource.contains("Delete ".toUpperCase() + deviceName.toUpperCase())) {
				screenName = "delete popup";
			} else if (pageSource.contains("Remove".toUpperCase())
					&& pageSource.contains("THIS THERMOSTAT IS INTEGRATED WITH YOUR".toUpperCase())
					&& pageSource.contains("remove ".toUpperCase() + deviceName.toUpperCase())) {
				screenName = "integerated remove popup";
			} else if (pageSource.contains("DEVICE INFORMATION".toUpperCase())
					&& pageSource.contains("Delete Thermostat".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("BACK".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "thermostat configuration";
			} else if (pageSource.contains("Delete Thermostat".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("BACK".toUpperCase())
					&& pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "thermostat configuration";
			} else if (pageSource.contains("MENU".toUpperCase()) && pageSource.contains("Location Name".toUpperCase())
					&& !pageSource.contains(deviceName.toUpperCase())) {
//				screenName = "dashboard after device deleted";
				screenName = "dashboard";
			} else if (pageSource.contains("appSettingsIcon".toUpperCase())
					&& pageSource.contains("btn close normal".toUpperCase())
					&& pageSource.contains("Cloud Connection Error".toUpperCase())) {
				screenName = "primary card";
			} else if (pageSource.contains("Manage Alerts".toUpperCase())
					&& pageSource.contains(deviceName.toUpperCase()) && pageSource.contains("BACK".toUpperCase())
					&& !pageSource.contains("Settings".toUpperCase())
					&& !pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "alert";
			} else if (pageSource.contains("HomeKit".toUpperCase())
					&& pageSource.contains("Terms Of Service".toUpperCase())
					&& pageSource.contains("Skip".toUpperCase()) && pageSource.contains("Next".toUpperCase())
					&& pageSource.contains("Adding Device To HomeKit Failed".toUpperCase())) {
				screenName = "homekit error";
			} else if (pageSource.contains("HomeKit".toUpperCase())
					&& pageSource.contains("Terms Of Service".toUpperCase())
					&& pageSource.contains("Skip".toUpperCase()) && pageSource.contains("Next".toUpperCase())) {
				screenName = "homekit";
			} else if (pageSource.contains("Brightness".toUpperCase())
					&& pageSource.contains("Sleep Brightness Mode".toUpperCase())) {
				screenName = "brightness";
			} else if (pageSource.contains("Installation".toUpperCase()) && pageSource.contains("Cancel".toUpperCase())
					&& pageSource.contains("Start thermostat network".toUpperCase())
					&& !pageSource.contains("Thermostat Configuration".toUpperCase())) {
				screenName = "reset wifi";
			} else {
				screenName = "unknown";
			}
		}
		System.out.println(screenName);
		return screenName;
	}

	public static boolean closeAppLaunchPopups(TestCases testCase, String deviceName) {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(3));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
//						String presentScreenName = login.getPresentScreenName();
						String pageSource = testCase.getMobileDriver().getPageSource();
//						System.out.println(pageSource);
						if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF RESIDEO APP")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Close']", false, false);
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']", false, false);
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Planned Maintenance".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Okay']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Okay']", false, false);
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Okay']",
										false, false);
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Disable App Hibernation".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Not Now']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Not Now']", false, false);
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Not Now']", false, false);
							}
							return false;
						} else if (pageSource.toUpperCase().contains("What do you think of Honeywell".toUpperCase())
								&& pageSource.toUpperCase().contains("CLOSE")) {
							if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Close']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']", false, false);
							}
							return false;
						} else if (pageSource.contains("com.android.packageinstaller:id/permission_allow_button")) {
							MobileUtils.clickOnElement(testCase, "id",
									"com.android.packageinstaller:id/permission_allow_button", false, false);
							return false;
						} else if (pageSource.contains("name=\"OK\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "OK", false, false);
							return false;
						} else if (pageSource.contains("name=\"Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Allow", false, false);
							return false;
						} else if (pageSource.contains("name=\"Always Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Always Allow", false, false);
							return false;
						} else if (pageSource.contains("name=\"Next\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Next", false, false);
							return false;
						} else if (pageSource.contains("name=\"Done\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Done", false, false);
							return false;
						} else if (pageSource.contains("btn_close")) {
							MobileUtils.clickOnElement(testCase, "id", "btn_close", false, false);
							return false;
						} else if (pageSource.contains("text=\"Ignore\"") || pageSource.contains("name=\"Ignore\"")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='Ignore']", false, false);
							else
								MobileUtils.clickOnElement(testCase, "name", "Ignore", false, false);
							return false;
						} else if (pageSource.contains("Would Like to Access Your Home Data")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "OK", false, false);
							return false;
						} else if (pageSource.contains("Would Like to Send You Notifications")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow", false, false);
							return false;
						} else if (pageSource.contains(" to use your location")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow While Using App", false, false);
							return false;
						} else if (pageSource.contains("Status Area")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								;
							MobileUtils.clickOnElement(testCase, "name", "Next", false, false);
							return false;
						} else if (pageSource.contains("Tap for More")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								;
							MobileUtils.clickOnElement(testCase, "name", "Done", false, false);
							return false;
						} else if (pageSource.toUpperCase()
								.contains("Would Like to Access Your Home Data".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "OK", false, false);
							return false;
						} else if (pageSource.contains("text=\"Not Now\"") || pageSource.contains("Not Now")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not Now", false, false);
							return false;
						} else if (pageSource.contains("Increase Security")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								if (MobileUtils.isMobElementExists("NAME", "No", testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "name", "No", false, false);
								}
							return false;
						} else if (pageSource.contains("Would Like to Send You Notifications")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow", false, false);
							return false;
						} else if (pageSource.contains("to use your location?".toUpperCase())
								|| pageSource.contains("name=\"Not now\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow While Using App", false, false);
							return false;
						} else if (pageSource.contains("Passcode verification failed due to a validation error")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']", false, false);
							Keyword.ReportStep_Pass(testCase, "<b style=\"color:red\"> Validation error popup </b>");
							return false;
						} else if (pageSource.contains("Honeywell Home app")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']", false, false);
							return false;
						} else if (pageSource.contains("text=\"Honeywell Home Unexpectedly Quit\"")
								|| pageSource.contains("Honeywell Unexpectedly Quit")
								|| pageSource.contains("SEND REPORT") || pageSource.contains("DON'TSEND")
								|| pageSource.contains("ALWAYS SEND") || pageSource.contains("text=\"Always Send\"")
								|| pageSource.contains("text=\"ALWAYS SEND\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								testCase.getMobileDriver().switchTo().alert().dismiss();
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"App crashed due to 'Honeywell Unexpectedly Quit'");
								return false;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"App crashed due to 'Honeywell Unexpectedly Quit'");
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='ALWAYS SEND' or @text='Always Send']", false, false);
								return false;
							}

						} else if (pageSource.toUpperCase().contains("ABOUT REBATES")
								&& pageSource.toUpperCase().contains("PUT MONEY BACK INTO YOUR POCKET")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']");
								} else {
									MobileUtils.pressBackButton(testCase,
											"Pressed Back Button, Navigate up didnt work");
								}
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to find Cause");
									Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());
								}
							}
							return false;
						} else if (pageSource.toUpperCase().contains("MENU".toUpperCase())
								&& pageSource.toUpperCase().contains("Location Name".toUpperCase())
								&& pageSource.toUpperCase().contains(deviceName.toUpperCase())) {
							return true;
						} else if (pageSource.toUpperCase().contains("MAIN MENU".toUpperCase())
								&& pageSource.toUpperCase().contains("dashboard_recyclerview".toUpperCase())
								&& pageSource.toUpperCase().contains(deviceName.toUpperCase())) {
							return true;
						} else {

							return false;
						}
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (TimeoutException e) {
						return false;
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"App popup failed");
					} catch (Exception e) {
						return false;
					}
				}
			});
			if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "App Popups are closed");
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Closing App Popups failed");
			}
		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups Timed out while loading. Wait time : 2 minutes");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups error Occured : " + e.getMessage());
		}

		return flag;
	}

	public static boolean dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(UserTimeout));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String status = pm.getCommonDataValidationMessage(deviceName);
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
//						System.out.println(testCase.getMobileDriver().getPageSource());
						if (pageSource.toUpperCase().contains("ABOUT REBATES")
								&& pageSource.toUpperCase().contains("PUT MONEY BACK INTO YOUR POCKET")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']");
								} else {
									MobileUtils.pressBackButton(testCase,
											"Pressed Back Button, Navigate up didnt work");
								}
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to find Cause");
									Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());
								}
							}
							return false;
						} else if (pageSource.contains("Disable App Hibernation".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Not Now']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'Not Now')]");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Not Now')]");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Planned Maintenance".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Okay']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Okay']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Okay']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Server Under".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Retry']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Retry']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Retry']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF RESIDEO APP")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Close']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {

							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Close')]");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("ABOUT REBATES")
								&& pageSource.toUpperCase().contains("PUT MONEY BACK INTO YOUR POCKET")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']");
								} else {
									MobileUtils.pressBackButton(testCase,
											"Pressed Back Button, Navigate up didnt work");
								}
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to find Cause");
									Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());
								}
							}
							return false;
						} else if (pm.isNotNowBtnClosed()) {
							SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard(true);
							return false;
						} else if (status == null) {
							System.out.println("Null occurred and will retry..");
							return false;
						} else if (status.isEmpty()) {
							System.out.println("Empty string .... retry ....");
							return false;
						} else if (status.contains("SYNCING WITH THERMOSTAT")) {
							System.out.println("SYNCING WITH THERMOSTAT....");
							return false;
						} else if (status.contains("CLOUD CONNECTION ERROR")) {
							System.out.println("CLOUD CONNECTION ERROR");
							SystemState.getStatus().isThermostatCloudSynError(true);
							return true;
						} else if (status.contains("SYSTEM IS OFFLINE")) {
							System.out.println("SYSTEM IS OFFLINE");
							SystemState.getStatus().isThermostatOfflineSince(true);
							return true;
						} else if (status.contains("INSIDE")) {
							System.out.println("INSIDE");
							SystemState.getStatus().isThermostatOnlineSince(true);
							return true;
						} else if (status.trim().contains("")) {
							System.out.println("Empty string");
							return false;
						} else {
							System.out.println("none of the above");
							return false;
						}
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "Null Pointer exception due to late loading screen");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + UserTimeout
										+ " minutes");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			if (success && SystemState.getStatus().isThermostatCloudSynError()) {
				Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
						"Device Status is " + pm.getCommonDataValidationMessage(deviceName) + " . ");
				flag = dataSync_NextVerification(testCase, 5, deviceName);
			} else if (success && (SystemState.getStatus().isThermostatOfflineSince()
					|| SystemState.getStatus().isThermostatOnlineSince())) {
				Keyword.ReportStep_Pass(testCase,
						"Device Status is " + pm.getCommonDataValidationMessage(deviceName) + " . ");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "None of the Above, status from app is "
						+ pm.getCommonDataValidationMessage(deviceName) + ", check the screenshot for more details");
				flag = false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + UserTimeout
							+ " minutes");
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
							+ e.getMessage());
			return false;
		}
		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard() == false) {
				if (MobileUtils.isMobElementExists("name", "Not Now", testCase, 10)) {
					MobileUtils.clickOnElement(testCase, "name", "Not Now");
					Keyword.ReportStep_Pass(testCase, "Not Now Button popup showed After some delay");
				}
			}
		}
		return flag;
	}

	public static boolean dataSync_NextVerification(TestCases testCase, int UserTimeout, String deviceName) {
		boolean flag = false;
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(6));
		fWait.withTimeout(Duration.ofMinutes(UserTimeout));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String status = pm.getCommonDataValidationMessage(deviceName);
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						if (pageSource.toUpperCase().contains("ABOUT REBATES")
								&& pageSource.toUpperCase().contains("PUT MONEY BACK INTO YOUR POCKET")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@content-desc='Navigate up' or @content-desc='navigate Up' or @content-desc='navigate up' or @content-desc='Navigate Up']");
								} else {
									MobileUtils.pressBackButton(testCase,
											"Pressed Back Button, Navigate up didnt work");
								}
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']",
										testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//*[@name='BACK' or @name='Back' or @name='back' or @name='nav bar back']");
								} else {
									Keyword.ReportStep_Pass(testCase, "Not able to find Cause");
									Keyword.ReportStep_Pass(testCase, testCase.getMobileDriver().getPageSource());
								}
							}
							return false;
						} else if (pageSource.contains("Disable App Hibernation".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Not Now']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'Not Now')]");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Not Now')]");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Planned Maintenance".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Okay']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Okay']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Okay']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Server Under".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Retry']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Retry']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Retry']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF RESIDEO APP")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Close']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {

							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'Close')]");
							}
							return false;
						} else if (pm.isNotNowBtnClosed()) {
							SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard(true);
							return false;
						} else if (status == null) {
							System.out.println("Null occurred and will retry..");
							return false;
						} else if (status.isEmpty()) {
							System.out.println("Empty string .... retry ....");
							return false;
						} else if (status.contains("SYNCING WITH THERMOSTAT")) {
							System.out.println("SYNCING WITH THERMOSTAT....");
							return false;
						} else if (status.contains("CLOUD CONNECTION ERROR")) {
							SystemState.getStatus().isThermostatCloudSynError(true);
							return false;
						} else if (status.contains("SYSTEM IS OFFLINE")) {
							System.out.println("SYSTEM IS OFFLINE");
							SystemState.getStatus().isThermostatCloudSynError(false);
							SystemState.getStatus().isThermostatOfflineSince(true);
							return true;
						} else if (status.contains("INSIDE")) {
							System.out.println("INSIDE");
							SystemState.getStatus().isThermostatCloudSynError(false);
							SystemState.getStatus().isThermostatOnlineSince(true);
							return true;
						} else if (status.trim().contains("")) {
							System.out.println("Empty string");
							return false;
						} else {
							System.out.println("none of the above");
							return false;
						}
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "Null Pointer exception due to late loading screen");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Data Sync Initialized : Data Sync Timed out while loading. Wait time : " + UserTimeout
										+ " minutes");
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
										+ e.getMessage());
						return false;
					}
				}

			});

			if (SystemState.getStatus().isThermostatCloudSynError()) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Device Status is " + pm.getCommonDataValidationMessage(deviceName) + " . ");
				flag = false;
			} else if (success && (SystemState.getStatus().isThermostatOfflineSince()
					|| SystemState.getStatus().isThermostatOnlineSince())) {
				Keyword.ReportStep_Pass(testCase,
						"Device Status is " + pm.getCommonDataValidationMessage(deviceName) + " . ");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "None of the Above, status from app is "
						+ pm.getCommonDataValidationMessage(deviceName) + ", check the screenshot for more details");
				flag = false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Cloud Connection error verified, timeout exception, wait time is " + UserTimeout + " minutes");
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Cloud Connection error verified, timeout exception, wait time is " + UserTimeout + " minutes");
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
							+ e.getMessage());
			return false;
		}

		if (testCase.getPlatform().toUpperCase().contains("IOS")) {
			if (SystemState.getStatus().isNotNowButtonClickedAfterRegistrationInDashboard() == false) {
				if (MobileUtils.isMobElementExists("name", "Not Now", testCase, 10)) {
					MobileUtils.clickOnElement(testCase, "name", "Not Now");
					Keyword.ReportStep_Pass(testCase, "Not Now Button popup showed After some delay");
				}
			}
		}
		return flag;

	}

	public static boolean dataSyncIsCompletedFlycathcer(TestCases testCase, TestCaseInputs inputs) {
		PrimaryCardScreen pr = new PrimaryCardScreen(testCase);

		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Master Bedroom']",
					"Thermostat name is clicked from Dashboard device list");
		} else {
			flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[@value='Master Bedroom']",
					"Thermostat name is clicked from Dashboard device list");
		}
		flag = flag && pr.isDataSyncIsCompleted();
		return flag;
	}

	public static boolean verifySetpointFromAPP(TestCases testCase, PrimaryCardScreen pm, Duration duration,
			float setPoint, String verification) {

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofMillis(200));
		fWait.withTimeout(duration);
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					float currentSetpoint = Float.valueOf(pm.getCurrentSetpoint());
					if (currentSetpoint == setPoint) {
						if (verification.contains("VERIFY")) {
							TrailData.getStatus().verifyTime(String.valueOf(System.currentTimeMillis()));
							TrailData.getStatus().changeToValue(String.valueOf(currentSetpoint));
						}
						Keyword.ReportStep_Pass(testCase,
								"APP Setpoint Change Verified from : "
										+ CommonState.getStatus().APPCurrentSetPointBeforeTrailStart() + " , To : "
										+ currentSetpoint);
						return true;
					} else {
						// System.out.println("setpoint not match, waiting for
						// set....");
						return false;
					}
				} catch (Exception e) {
					System.out.println("exception raised due to " + e.getMessage());
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception Raised due to " + e.getMessage());
					return false;
				}
			}
		});

		return isEventReceived;
	}

	public static boolean isPrimaryCardVisible(TestCases testCase, PrimaryCardScreen pm) {
		// PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		if (pm.isModeButtonVisible() && pm.isFanButtonVisible()) {
			Keyword.ReportStep_Pass(testCase, "Primary Card is visible");
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Fan and Mode Button not visible");
			return false;
		}

	}

	public static String currentMove(float currentSetpoint, float expectedSetpoint) {
		String value = "";
		if (expectedSetpoint > currentSetpoint) {
			value = "UP_" + expectedSetpoint;
		} else {
			value = "DOWN_" + expectedSetpoint;
		}

		if (CommonState.getStatus().getCurrentTempScale().contains("F")) {
			String[] valu = value.split("_");
			int i = (int) expectedSetpoint;
			String val = valu[0] + "_" + i;
			return val;

			// String[] split = value.split(".
			// return split[0];
		} else {
			return value;
		}
	}

	public static boolean changeSetpointInApp(TestCases testCase, PrimaryCardScreen pm, float setSetPoint) {
		boolean flag = false;
		String currentSetpoint = pm.getCurrentSetpoint();
		int currentSetpointInInt = Integer.valueOf(currentSetpoint);
		String findUporDownTemp = currentMove(currentSetpointInInt, CommonState.getStatus().randomSetPoint());
		String[] split = findUporDownTemp.split("_");
		String currentPointNeedtoSet = split[1];
		if (findUporDownTemp.contains("UP")) {
			while (!MobileUtils.getMobElement(testCase, "ID", "current_temp_value").getDomAttribute("text")
					.equals(currentPointNeedtoSet)) {
				flag = MobileUtils.clickOnElement(testCase, "ID", "stat_temp_stepper_up", false, false);
			}
		} else {
			while (!MobileUtils.getMobElement(testCase, "ID", "current_temp_value").getDomAttribute("text")
					.equals(currentPointNeedtoSet)) {
				flag = MobileUtils.clickOnElement(testCase, "ID", "stat_temp_stepper_down", false, false);
			}
		}
		if (flag) {
			TrailData.getStatus().changeTime(String.valueOf(System.currentTimeMillis()));
			Keyword.ReportStep_Pass(testCase,
					"APP Setpoint changed from >> " + currentSetpoint + " :: to >> " + currentPointNeedtoSet);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not Able to Setpoint changed from >> "
					+ currentSetpoint + " :: change to >> " + currentPointNeedtoSet);
		}
		return flag;
	}

	public static boolean changeSystemModeInApp(TestCases testCase, PrimaryCardScreen pm, String mode) {
		boolean flag = true;
		if (pm.isModeButtonVisible()) {
			flag = pm.clickOnModeButton();
			flag = flag && pm.selectModeFromModeScreen(mode);
		} else {
			flag = false;
		}
		return flag;
	}

	public static boolean verifySystemModeChangesInApp(TestCases testCase, PrimaryCardScreen pm, Duration duration,
			String mode) {
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofMillis(200));
		fWait.withTimeout(duration);
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String currentMode = pm.getCurrentModeFromPrimaryCard();
					if (currentMode.toUpperCase().equals(mode.toUpperCase())) {
						TrailData.getStatus().verifyTime(String.valueOf(System.currentTimeMillis()));
						TrailData.getStatus().changeToValue(mode);
						Keyword.ReportStep_Pass(testCase,
								"APP mode changed from " + CommonState.getStatus().APPCurrentModeBeforeTrailStart()
										+ " :: to >> " + currentMode + " ..");
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return false;
				}
			}
		});
		return isEventReceived;
	}

	public static boolean handleNotNowPopupForiOS(TestCases testCase) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofSeconds(5));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (MobileUtils.isMobElementExists("NAME", "Not Now", testCase, 1)) {
							return MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
						} else {
							System.out.println("Wait for PopUP");
							return false;
						}
					} catch (Exception e) {
						return true;
					}
				}
			});
			if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "Popup Closed successful or Popup Not Displayed");
				return true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not Now Popup failed to click");
				return false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Not able to find popup, Skipping .....");
			return true;
		}
	}

	public static boolean deleteParticularThermostatFromAccount(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;

		flag = NavigateToAnyScreen.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "THERMOSTAT CONFIGURATION");
		PrimaryCardScreen pm = new PrimaryCardScreen(testCase);
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

			flag = flag && pm.clickOnDeleteThermostatButton();
			if (pm.isDeleteThermostatPopupButton()) {
				flag = flag && pm.clickOnDeletePopUpButton();
			} else {
				flag = flag && pm.clickOnDeleteThermostatButton();
				if (pm.isDeleteThermostatPopupButton()) {
					flag = flag && pm.clickOnDeletePopUpButton();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Delete Popup Screen timeout, retried 2 time with 30 second timeout");
					flag = false;
				}
			}
			flag = flag && pm.isDashboardScreen();
		} else {

			flag = pm.clickOnIOSDeletePopUpButton();
			System.out.println("Deleted status " + flag);

			flag = flag && pm.isDashboardScreen();
			System.out.println("dashboard status " + flag);
		}
		return flag;
	}

}
