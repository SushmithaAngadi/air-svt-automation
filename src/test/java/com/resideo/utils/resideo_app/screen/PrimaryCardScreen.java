package com.resideo.utils.resideo_app.screen;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.system.utils.TrailData;

public class PrimaryCardScreen extends MobileScreens {

	private static final String screenName = "Primarycard";

	public PrimaryCardScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean closePopUpIfAnyInPrimaryCard() {
		SystemState.getStatus().isfirstTimeChecking(true);
		SystemState.getStatus().isNotnowUnPerformed(true);
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(2));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageSource = testCase.getMobileDriver().getPageSource();
					// System.out.println(pageSource);
					if (pageSource == null) {
						return false;
					} else if (SystemState.getStatus().isfirstTimeChecking()) {
						System.out.println(SystemState.getStatus().isfirstTimeChecking());
						Thread.sleep(6000);
						SystemState.getStatus().isfirstTimeChecking(false);
						System.out.println(SystemState.getStatus().isfirstTimeChecking());
						return false;
					} else if (pageSource.isEmpty()) {
						System.out.println("page is empty");
						return false;
					} else if (pageSource.contains("Indoor Temperature Reading") || pageSource.contains("Temp Stepper")
							|| pageSource.contains("Change thermostat mode")
							|| pageSource.contains("Change the fan mode your system is")) {
						MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
						return false;
					} else if (pageSource.contains("View, edit or create a new schedule for your thermostat")) {
						MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
						return false;
					} else if (pageSource.contains("Welcome to your new thermostat")) {
						MobileUtils.clickOnElement(objectDefinition, testCase, "NotNowButton");
						return false;
					} else if (SystemState.getStatus().isNotnowUnPerformed()
							&& pageSource.contains("Welcome to your new Thermostat")) {
						MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
						SystemState.getStatus().isNotnowUnPerformed(false);
						return false;
						// } else if (pageSource.contains("Not Now")) {
						// MobileUtils.clickOnElement(objectDefinition,
						// testCase, "NotNowButton");
						// return false;
					} else if (pageSource.contains("Welcome Back") || pageSource.contains("Welcome back")) {
						MobileUtils.clickOnElement(objectDefinition, testCase, "DontskAgainButton");
						return false;
					} else if (pageSource.contains("action_settings") || pageSource.contains("Navigate Up")) {
						System.out.println("Settings Button visible");
						return true;
					} else {
						return false;
					}

				} catch (Exception e) {
					return false;
				}
			}
		});

		System.out.println("Not now Popup Closed or not , Status is " + isEventReceived);
		return isEventReceived;
	}

	public boolean closePrimaryCardSetup() {
		boolean flag = false;
		try {
			for (int i = 0; i <= 25; i++) {
				String pageSource = testCase.getMobileDriver().getPageSource();
				if (pageSource == null) {
					return false;
				} else if (pageSource.contains("Indoor Temperature Reading") || pageSource.contains("Temp Stepper")
						|| pageSource.contains("Change thermostat mode")
						|| pageSource.contains("Change the fan mode your system is")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
				} else if (pageSource.contains("View, edit or create a new schedule for your thermostat")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
				} else if (pageSource.contains("Welcome to your new thermostat")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "NotNowButton");
				} else if (pageSource.contains("Welcome to your new Thermostat")) {
					MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
				} else if (pageSource.contains("Welcome Back") || pageSource.contains("Welcome back")) {
					MobileUtils.clickOnElement(objectDefinition, testCase, "DontskAgainButton");
				} else if (pageSource.contains("action_settings") || pageSource.contains("Navigate Up")) {
					System.out.println("Settings Button visible");
					// issetupComplete = true;
					flag = true;
					break;
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured in closePrimaryCardSetup() methos, error is " + e);
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					testCase.getMobileDriver().getPageSource());
		}
		return flag;
	}

	public boolean clickOnPrimaryCardSettingButton() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "PrimarycardSettingsButton", 10)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "PrimarycardSettingsButton");
		} else {
			Keyword.ReportStep_Fail(testCase, 0, "Primary card Setting button is not available");
			return false;
		}

	}

	public boolean isPrimarycardSettingsButton(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "PrimarycardSettingsButton", timeout);
	}

	public boolean clickOnThermostatConfiguartion() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatconfigurationButton", 4)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatconfigurationButton");
		} else {
			if (clickOnPrimaryCardSettingButton()) {
				if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatconfigurationButton", 4)) {
					return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatconfigurationButton");
				} else {
					Keyword.ReportStep_Fail(testCase, 0, "Thermostat Configuration button not visible");
					return false;
				}
			} else {

				Keyword.ReportStep_Fail(testCase, 0, "In Primary card, setting button not able to do action");
				return false;
			}
		}

	}

	public boolean clickOnDeleteThermostatButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteThermostatButton");
	}

	public boolean clickOnDeletePopUpButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteThermostatPopupButton");
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

	public boolean clickOnIOSDeletePopUpButton() {
		boolean flag = false;
		if (testCase.getPlatform().contains("IOS")) {
			if (MobileUtils.isMobElementExists("NAME", "Delete Thermostat", testCase, 9)) {
				if (MobileUtils.clickOnElement(testCase, "NAME", "Delete Thermostat")) {
					if (MobileUtils.isMobElementExists("XPATH", "//*[@name='DELETE']", testCase, 9)) {

						Actions action = new Actions(testCase.getMobileDriver());
						action.moveToElement(testCase.getMobileDriver().findElement(By.name("DELETE")));
						action.click();
						action.perform();
						flag = true;
					} else {
						if (MobileUtils.isMobElementExists("NAME", "Delete Thermostat", testCase, 9)) {
							if (MobileUtils.clickOnElement(testCase, "NAME", "Delete Thermostat")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='DELETE']", testCase, 9)) {
									if (MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='DELETE']")) {
										flag = true;
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to click on delete popup button");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to find delete popup button");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on Delete Thermostat button");
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find on Delete Thermostat button in second iteration");
							flag = false;
						}
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Delete thermostat button not available to click");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Delete thermostat not available");
				flag = false;
			}

		} else {
		}

		return flag;
	}

	public boolean isDeletePopUpButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeleteThermostatPopupButton", 4);
	}

	public boolean isDeleteThermostatPopupButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDeleteThermostatPopUp", 4);
	}

	public boolean isDashboardScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDashboardScreen", 120);
	}

	public boolean isDashboardScreen(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDashboardScreen", timeOut);
	}

	public boolean isDashboardScreen_FluentWait() {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofSeconds(80));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDashboardScreen", 1)) {
							return true;
						} else {
							System.out.println("Waiting for Dashboard");
							return false;
						}
					} catch (Exception e) {
						return true;
					}
				}
			});
			if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "After deleted , Dashboard Screen Appeared");
				return true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Dashboard not able find");
				return false;
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Time Out Exception not able to find Dashboard");
//			Keyword.ReportStep_Pass(testCase, "Time Out Exception not able to find Dashboard");
			return true;
		}
	}

	public boolean isDataSyncIsCompleted() {
		DIYScreen diy = new DIYScreen(testCase);
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(10));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {

					if (testCase.getPlatform().contains("IOS")) {
						String pageSource = testCase.getMobileDriver().getPageSource();
						if (pageSource == null || pageSource.isEmpty()) {
							System.out.println("page source null or empty");
							return false;
						} else if (pageSource.contains("\"name=\"Welcome to your new Thermostat\"")) {
							diy.clickOnNotNowButton();
							return false;
						} else if (pageSource.contains("name=\"SYNCING WITH THERMOSTAT\"")) {
							Keyword.ReportStep_Pass(testCase, "Syncing with thermostat...");
							return false;
						} else if (pageSource.contains("name=\"Welcome back\"")) {
							Keyword.ReportStep_Pass(testCase, "Welcome back...");
							MobileUtils.clickOnElement(testCase, "NAME", "Don't Ask Again");
							return false;
						} else if (pageSource.contains("name=\"STATUS UNAVAILABLE\"")) {
							Keyword.ReportStep_Pass(testCase, "Status Unavailable...");
							return false;
						} else if (pageSource.contains(
								"name=\"SYSTEM IS OFF\" label=\"SYSTEM IS OFF\" enabled=\"true\" visible=\"true\"")) {
							Keyword.ReportStep_Pass(testCase, "Thermostat Data Sync Completed");
							return true;
						} else if (pageSource.contains("name=\"SYSTEM IS OFFLINE\"")) {
							Keyword.ReportStep_Pass(testCase, "System is Offline. Rechecking...");
							return false;
						} else {
							return false;
						}
					} else {
						String pageSource = testCase.getMobileDriver().getPageSource();
						if (pageSource == null || pageSource.isEmpty()) {
							System.out.println("page source null or empty");
							return false;
						} else if (pageSource.contains("com.resideo.android.lyric:id/sync_progress")
								&& pageSource.contains("com.resideo.android.lyric:id/device_view")) {
							return false;
						} else if (pageSource.contains("com.resideo.android.lyric:id/data_sync_progress")
								&& pageSource.contains("com.resideo.android.lyric:id/data_sync_title")) {
							System.out.println("Syncing with thermostat...");
							return false;
						} else if (pageSource.contains("name=\"STATUS UNAVAILABLE\"")) {
							Keyword.ReportStep_Pass(testCase, "Status Unavailable...");
							return false;
						} else if (pageSource.contains("TROUBLESHOOT")
								|| pageSource.contains("Cloud Connection Error")) {
							return false;
						} else if (pageSource.contains("fragment_thermostat_temp_container")
								&& pageSource.contains("stepper_layout")) {
							Keyword.ReportStep_Pass(testCase, "Thermostat Data Sync Completed");
							return true;
						} else if (pageSource.contains("SYSTEM IS OFF") && pageSource.contains("MODE")
								&& pageSource.contains("FAN")) {
							Keyword.ReportStep_Pass(testCase, "Thermostat Data Sync Completed");
							return true;
						} else if (pageSource.contains("name=\"SYSTEM IS OFFLINE\"")) {
							Keyword.ReportStep_Pass(testCase, "System is Offline. Rechecking...");
							return true;
						} else if (pageSource.contains("Welcome Back") && pageSource.contains("btn_dont_ask")) {
							MobileUtils.clickOnElement(testCase, "XPATH",
									"//*[@resource-id='com.resideo.android.lyric:id/btn_dont_ask']");
							return false;
						} else if (pageSource.contains("com.resideo.android.lyric:id/welcome_text")
								&& pageSource.contains("btn_not_now")) {
							MobileUtils.clickOnElement(testCase, "XPATH",
									"//*[@resource-id='com.resideo.android.lyric:id/btn_not_now']");
							return false;

						} else {
							return false;
						}
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured due to " + e);
					return false;
				}
			}
		});
		return isEventReceived;
	}

	public boolean isModeButtonVisible() {
		return MobileUtils.isMobElementExists("Xpath", "//*[@text='MODE']", testCase, 2);
	}

	public boolean isFanButtonVisible() {
		return MobileUtils.isMobElementExists("Xpath", "//*[@text='FAN']", testCase, 2);
	}

	public String getCurrentSetpoint() {
		return MobileUtils.getMobElement(testCase, "ID", "current_temp_value").getAttribute("text");
	}

	public boolean clickOnModeButton() {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='MODE']/parent::android.widget.LinearLayout");
	}

	public boolean selectModeFromModeScreen(String mode) {
		boolean flag = false;
		if (mode.toUpperCase().equals("HEAT")) {
			flag = MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[@text='HEAT']/parent::android.widget.LinearLayout");
		} else if (mode.toUpperCase().equals("COOL")) {
			flag = MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[@text='COOL']/parent::android.widget.LinearLayout");
		} else {
			flag = true;
		}
		flag = flag && MobileUtils.clickOnElement(testCase, "ID", "save_action_sheet_btn");
		TrailData.getStatus().changeTime(String.valueOf(System.currentTimeMillis()));
		return flag;
	}

	public String getCurrentModeFromPrimaryCard() {
		return MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='MODE']").getAttribute("content-desc");
	}

	public boolean handleNotNowPopupInFluentWait() {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofSeconds(20));
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
			Keyword.ReportStep_Pass(testCase, "Time Out Exception came due to noat able to find");
			return true;
		}
	}

	public boolean isExactDevicePresent() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@text='" + SystemState.getStatus().getTstatName() + "']", testCase, 4);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@value,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 4);
		}
	}

	public boolean clickOnExactDeviceName() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[@text='" + SystemState.getStatus().getTstatName() + "']");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeButton[contains(@value,'" + SystemState.getStatus().getTstatName() + "')]");
		}

	}

	public String getDeviceCloudStatusFromDashboard() {
		String status = null;
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + SystemState.getStatus().getTstatName()
						+ "']/following-sibling::android.widget.TextView", testCase, 1)) {
					status = MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='"
							+ SystemState.getStatus().getTstatName() + "']/following-sibling::android.widget.TextView")
							.getText();
				} else if (MobileUtils.isMobElementExists("XPATH",
						"//android.widget.TextView[contains(@resource-id,'secondary_text')]", testCase, 1)) {
					status = MobileUtils.getMobElement(testCase, "XPATH",
							"//android.widget.TextView[contains(@resource-id,'secondary_text')]").getText();

				} else {
					status = null;
				}

			} else {
				status = MobileUtils.getMobElement(testCase, "XPATH", "//XCUIElementTypeButton[@value='"
						+ SystemState.getStatus().getTstatName() + "']/following-sibling::XCUIElementTypeStaticText")
						.getAttribute("value");
			}
		} catch (Exception e) {
			System.out.println("Exception Raised due to " + e.getStackTrace());
			status = null;
		}
		return status;
	}

	public String getDeviceDataStatusFromDashboard() {
		String status = null;
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + SystemState.getStatus().getTstatName()
						+ "']/following-sibling::android.widget.TextView", testCase, 1)) {
					status = MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='"
							+ SystemState.getStatus().getTstatName() + "']/following-sibling::android.widget.TextView")
							.getText();
				} else if (MobileUtils.isMobElementExists("XPATH",
						"//android.widget.TextView[contains(@resource-id,'secondary_text')]", testCase, 1)) {
					status = MobileUtils.getMobElement(testCase, "XPATH",
							"//android.widget.TextView[contains(@resource-id,'secondary_text')]").getText();

				} else {
					status = null;
				}

			} else {

				status = MobileUtils.getMobElement(testCase, "XPATH", "//XCUIElementTypeButton[@value='"
						+ SystemState.getStatus().getTstatName()
						+ "']/following-sibling::XCUIElementTypeOther/XCUIElementTypeButton/following-sibling::XCUIElementTypeStaticText")
						.getAttribute("name");
			}
		} catch (Exception e) {
			System.out.println("Exception Raised due to " + e.getStackTrace());
			status = null;
		}
		return status;
	}

	// public boolean isDataSyncProgressBar(String deviceName) {
	// if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
	// return MobileUtils.isMobElementExists("XPATH", "//*[@text='" + deviceName
	// +
	// "']/parent::android.widget.LinearLayout//following-sibling::android.widget.RelativeLayout//android.widget.ProgressBar",
	// testCase);
	// } else {
	//
	// }
	// }

	public String getDataSyncTroubleshoot(String deviceName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='" + deviceName
					+ "']/parent::android.widget.LinearLayout//following-sibling::android.widget.RelativeLayout/android.widget.TextView")
					.getAttribute("text");
		} else {

			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@value='" + deviceName
									+ "']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText")
					.getAttribute("value");
		}
	}

	// *[@text='My Thermostat']/following-sibling::android.widget.TextView
	public String dataSyncProgressStatus(String deviceName) {
		// *[@value='My
		// Thermostat']/following-sibling::XCUIElementTypeStaticText
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@text='" + deviceName + "']/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {

			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@value='" + deviceName + "']/following-sibling::XCUIElementTypeStaticText")
					.getAttribute("value");
		}
	}

	public boolean isCloudConnectionError(String deviceName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@text='" + deviceName
							+ "']/following-sibling::android.widget.TextView[@text='CLOUD CONNECTION ERROR']",
					testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@value='" + deviceName
							+ "']/following-sibling::XCUIElementTypeStaticText[@value='Cloud Connection Error']",
					testCase, 1);
		}
	}

	public boolean isDataSyncingInProgress(String deviceName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@text='" + deviceName
							+ "']/following-sibling::android.widget.TextView[@text='SYNCING WITH THERMOSTAT']",
					testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@value='" + deviceName
							+ "']/following-sibling::XCUIElementTypeStaticText[@value='SYNCING WITH THERMOSTAT']",
					testCase, 1);
		}
	}

	public boolean isNotNowBtnClosed() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Not Now']", testCase, 1)) {
				MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Not Now']");
				return false;
			} else {
				return false;
			}
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Not Now']", testCase, 1)) {
				return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Not Now']");
			} else {
				return false;
			}
		}
	}

	public String getCommonDataValidationMessage(String deviceName) {
		String getCurrentReport = "";
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH",
						"//*[@text='" + deviceName + "']/following-sibling::android.widget.TextView", testCase, 2)) {
					getCurrentReport = MobileUtils.getMobElement(testCase, "XPATH",
							"//*[@text='" + deviceName + "']/following-sibling::android.widget.TextView", false, false)
							.getAttribute("text");
				} else {
					getCurrentReport = null;
				}
			} else {
				if (MobileUtils.isMobElementExists("XPATH",
						"//*[@value='" + deviceName + "']/following-sibling::XCUIElementTypeStaticText", testCase, 2)) {
					getCurrentReport = MobileUtils.getMobElement(testCase, "XPATH",
							"//*[@value='" + deviceName + "']/following-sibling::XCUIElementTypeStaticText", false,
							false).getAttribute("value");
				} else {
					getCurrentReport = null;
				}
			}
			if (getCurrentReport == null) {
				return null;
			} else if (getCurrentReport.contains("Cloud Connection Error")
					|| getCurrentReport.contains("CLOUD CONNECTION ERROR")) {
				return "CLOUD CONNECTION ERROR";
			} else if (getCurrentReport.contains("SYSTEM IS OFFLINE")) {
				return "SYSTEM IS OFFLINE";
			} else if (getCurrentReport.contains("INSIDE")) {
				return "INSIDE";
			} else if (getCurrentReport.contains("SYNCING WITH THERMOSTAT")
					|| getCurrentReport.contains("SYNCING WITH THERMOSTAT")) {
				return "SYNCING WITH THERMOSTAT";
			} else {
				return getCurrentReport;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public boolean instructionPopupNextButton() {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = MobileUtils.clickOnElement(testCase, "ID", "com.resideo.android.lyric:id/btn_positive_got_it",
					false, false);
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Next']", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Next']", false,
						false);
			} else if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Done']", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Done']", false,
						false);
			}
		}
		return flag;
	}

	public boolean clickOnNotNowBtn() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "ID", "com.resideo.android.lyric:id/btn_not_now", false,
					false);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Not Now']", false,
					false);
		}
	}

	public boolean clickOnPrimaryCardSettingBtn() {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = MobileUtils.clickOnElement(testCase, "ID", "com.resideo.android.lyric:id/action_settings", false,
					false);
		} else {
			if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='action_settings']", testCase,
					1)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='action_settings']",
						false, false);
			} else if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='appSettingsIcon']",
					testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='appSettingsIcon']",
						false, false);
			}
		}
		return flag;
	}

	public boolean clickOnThermostatConfigurationBtn() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Thermostat Configuration']", false, false);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeStaticText[@value='Thermostat Configuration']", false, false);
		}
	}

	public boolean clickOnDeleteBtn() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='DELETE']", false, false);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='DELETE']", false,
					false);
		}
	}

	public boolean clickOnRemoveBtn() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Remove']", false, false);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Remove']", false,
					false);
		}
	}

	public boolean settingsAfterFeatureBackButton() {
		String backButton = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Navigate Up", testCase, 1)) {
				backButton = "Navigate Up";
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Navigate up", testCase, 1)) {
				backButton = "Navigate up";
			}
		} else {
			if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "BACK", testCase, 1)) {
				backButton = "BACK";
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Back", testCase, 1)) {
				backButton = "Back";
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "back", testCase, 1)) {
				backButton = "back";
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "nav bar back", testCase, 1)) {
				backButton = "nav bar back";
			}
		}
		return MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", backButton);
	}

	public boolean clickOnDeleteThermostatBtn() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Delete Thermostat']", false, false);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Delete Thermostat']",
					false, false);
		}
	}

	public String getFirmwareVersion() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH",
					"//*[@text='Firmware Version']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {
			return MobileUtils.getMobElement(testCase, "NAME", "Firmware_Version_subTitle").getAttribute("value");
		}
	}

	public String getMacID() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH",
					"//*[@text='MAC ID']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {
			return MobileUtils.getMobElement(testCase, "NAME", "MAC_ID_subTitle").getAttribute("value");
		}
	}

	public String getHeatingSystem() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH",
					"//*[@text='Heating System']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {
			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@value='Heating System']/following-sibling::XCUIElementTypeStaticText")
					.getAttribute("value");
		}
	}

	public String getHeatingStages() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH",
					"//*[@text='Heating Stages']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {
			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@value='Heating Stages']/following-sibling::XCUIElementTypeStaticText")
					.getAttribute("value");
		}
	}

	public String getCoolingStages() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(testCase, "XPATH",
					"//*[@text='Cooling Stages']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView")
					.getAttribute("text");
		} else {
			return MobileUtils
					.getMobElement(testCase, "XPATH",
							"//*[@value='Cooling Stages']/following-sibling::XCUIElementTypeStaticText")
					.getAttribute("value");
		}
	}

}
