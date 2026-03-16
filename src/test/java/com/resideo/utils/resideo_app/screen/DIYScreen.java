package com.resideo.utils.resideo_app.screen;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomAndroidDriver;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.CustomIOSDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg.PairingPinMode;

import org.openqa.selenium.WebElement;
import com.resideo.commons.mobile.W3CTouchActions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@SuppressWarnings("unused")
public class DIYScreen extends MobileScreens {

	private static final String screenName = "DIYScreen";

	public DIYScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isAddnewDeviceListofDevices() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectDeviceInstallScreen", 2);
	}

	public boolean isUnknownPopUP() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "UnknownPopUP", 1);
	}

	public boolean isUnknownPopUP(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "UnknownPopUP", timeOut);
	}

	public boolean clickOnUnknownPopUP(String where) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "UnknownPopUP",
				"Clicked on Unknown PopUP from " + where);
	}

	public boolean clickOnDismissButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'DISMISS')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", "Dismiss");
		}
	}
	
	public boolean isDashboard(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DashboardHembergerButton", timeout);
		// && MobileUtils.isMobElementExists(objectDefinition, testCase,
		// "AddNewDeviceFromDashboard", 1);
	}

	public boolean isAllowLocationScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsAllowLocationScreen", 2);
	}

	public boolean clickOnWhileUsingTheAppButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "WhileUsingTheAppButton",
				"Clicked on While using the app button");
	}

	public boolean clickOnOnlyThisTimeButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OnlyThisTimeButton",
				"Clicked on Only this time button");
	}

	public boolean clickOnDenyButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DenyButton", "Clicked on deny button");
	}

	public boolean IsAllowLocationPopUPScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsAllowLocationPopUPScreen", 1);
	}

	public boolean clickOnTurnOnLocationButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "TurnOnLocationButton",
				"Clicked on Allow Location Access button");
	}

	public boolean clickOnDontAllowLocationButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DontAllowLocationButton",
				"Clicked on Don't Allow Location Access button");
	}

	public boolean acceptBluetoothNotification() {// name =OK
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AcceptBluetoothNotificationPopup");
	}

	public boolean isBluetoothNotification() {//
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsBluetoothNotification", 1);
	}

	public boolean clickOnAddNewDeviceFromDashboard() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddNewDeviceFromDashboard",
				"Clicked on Dahsboard Add New Plus button");
	}

	public boolean selectDeviceFromList(String deviceName) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, deviceName);
	}

	public boolean selectT5WifiThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T5WifiThermostat",
				"Sucessfully selected T5 Wifi Thermostat");
	}

	public boolean selectT6ProWifiThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T6ProWifiThermostat",
				"Sucessfully selected T6 Pro Wifi Thermostat");
	}

	public boolean selectT6WiredThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T6WiredThermostat",
				"Sucessfully selected T6 Wired Thermostat");
	}

	public boolean selectT6RWirelessThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T6RWirelessThermostat",
				"Sucessfully selected T6R Wifi Thermostat");
	}

	public boolean selectT9orT10Pro() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T9orT10Pro",
				"Sucessfully selected T9 or T10 Pro or T10Plus Thermostat");
	}

	public boolean selectT10Plus() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "T9orT10Pro",
				"Sucessfully selected T9 or T10 Pro Thermostat");
	}

	public boolean selectHoudini_TradeThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HoudiniTrade",
				"Sucessfully selected Houdini Trade Thermostat");
	}

	public boolean selectHoudini_RetailThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HoudiniRetail",
				"Sucessfully selected Houdini Retail Thermostat");
	}

	public boolean selectLyricRoundWifiThermostat() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LyricRoundWifiThermostat",
				"Sucessfully selected Lyric Round Wifi Thermostat");
	}

	public boolean selectWifiWaterLeakAndFreezeDetector() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "WiFiWaterLeakAndFreezeDetector",
				"Sucessfully selected Wifi Water leak and freeze detector");
	}

	public boolean selectL5LeakProtectionValve() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "L5LeakProtectionValve",
				"Sucessfully selected L5 Leak Protection Valve");
	}

	public boolean checkCountrySelected(String country) {
		boolean flag = false;

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(30));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();

						if (pgsrc.contains("T5 WI-FI THERMOSTAT") || pgsrc.contains("D6 PRO WI-FI DUCTLESS CONTROLLER")
								|| pgsrc.contains("IMPORT THERMOSTAT FROM TOTAL CONNECT COMFORT (TCC)")
								|| pgsrc.contains("LYRIC ROUND WI-FI THERMOSTAT")
								|| pgsrc.contains("LYRIC SMART CONTROLLER") || pgsrc.contains("T6R WIRELESS THERMOSTAT")
								|| pgsrc.contains("T6 WIRED THERMOSTAT") || pgsrc.contains("T6 PRO WI-FI THERMOSTAT")
								|| pgsrc.contains("LYRIC ROUND WI-FI THERMOSTAT")
								|| pgsrc.contains("PRO WI-FI THERMOSTAT") || pgsrc.contains("T9 OR T10")
								|| pgsrc.contains("T9 OR T10 / T10+ PRO WI-FI THERMOSTAT")
								|| pgsrc.contains("T9 / T9+ or T10 / T10+ Pro Wi-Fi Thermostat")
								|| pgsrc.contains("C2 WI-FI SECURITY CAMERA")
								|| pgsrc.contains("C1 WI-FI SECURITY CAMERA") || pgsrc.contains("FOCUS PRO")
								|| pgsrc.contains("FOCUS PRO 7000")
								|| pgsrc.contains("L1 WIFI WATER LEAK AND FREEZE DETECTOR")
								|| pgsrc.contains("L2 WIFI WATER SENSOR AND SWITCH")
								|| pgsrc.contains("WI-FI WATER LEAK AND FREEZE DETECTOR")
								|| pgsrc.contains("SMART HOME SECURITY")) {
							Keyword.ReportStep_Pass(testCase, "List of devices are visible");
							System.out.println("Device list visible");
							if (pgsrc.contains("UNITED STATES") && country.contains("UNITED_STATES")) {
								SystemState.getStatus().isExpectedCountrySelected(true);
							} else if (pgsrc.contains("UNITED KINGDOM") && country.contains("UNITED_KINGDOM")) {
								SystemState.getStatus().isExpectedCountrySelected(true);
							} else if (pgsrc.contains("CANADA") && country.contains("CANADA")) {
								SystemState.getStatus().isExpectedCountrySelected(true);
							} else {
								SystemState.getStatus().isExpectedCountrySelected(false);
								Keyword.ReportStep_Pass(testCase,
										"Expected country is not by default, country will change according to devuce");
							}
							return true;
						} else {
							System.out.println("trying to device list...");
							return false;
						}

					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "StaleElementReferenceException raised, skipping....");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "TimeoutException raised, skipping....");
						return false;
					} catch (NullPointerException e) {
						Keyword.ReportStep_Pass(testCase, "NullPointerException raised, skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Pass(testCase, "Exception raised due to " + e.getMessage());
						return false;
					}
				}
			});
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "StaleElementReferenceException raised, skipping....");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "TimeoutException raised, skipping....");
			flag = false;
		} catch (NullPointerException e) {
			Keyword.ReportStep_Pass(testCase, "NullPointerException raised, skipping....");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			flag = false;
		}
		return SystemState.getStatus().isExpectedCountrySelected();
	}

	public boolean clickOnChangeCountry() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ChangeCountry", 30)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeCountry");
		} else {
			return false;
		}
	}

	public boolean selectCountryOnSearchList(String countryName) {
		boolean flag = false;
		HashMap<Object, Object> countrypass = new HashMap<Object, Object>();
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CountrySearchBox", 15)) {
			if (MobileUtils.setValueToElement(objectDefinition, testCase, "CountrySearchBox", countryName,
					"Country entered into searchbox ::: " + countryName)) {
				if (MobileUtils.clickOnElement(objectDefinition, testCase, "SelectSearchFirstMatchingElement",
						"Sucessfully clicked on first matching country in country list screen")) {
					if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectDeviceInstallScreen", 15)) {
						flag = true;
						SystemState.getStatus().isCountryselectedBeforeTrail(true);
						countrypass.put("iscountrySelected", true);
						countrypass.put("selectedCountry", countryName);
					} else {
						if (MobileUtils.isMobElementExists(objectDefinition, testCase, "EulaNewAgreementAccept", 15)) {
							flag = MobileUtils.clickOnElement(objectDefinition, testCase, "EulaNewAgreementAccept",
									"sucessfully Accepted EULA Aggreement after country selection");
						}
						SystemState.getStatus().isCountryselectedBeforeTrail(true);
						countrypass.put("iscountrySelected", true);
						countrypass.put("selectedCountry", countryName);
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Not ablet to click on Country name below search list, try the element is correct or not?. this method will click on first mathcing list ");
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Not ablet to enter Country name in search box, try the element is correct or not?. ");
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"select country from list of country screen is not visible, wait time is 15 seconds");
		}
		return flag;
	}

	public boolean islistOfDeviceAvailable() {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(30));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();
					if (pgsrc.contains("T5 WI-FI THERMOSTAT") || pgsrc.contains("D6 PRO WI-FI DUCTLESS CONTROLLER")
							|| pgsrc.contains("IMPORT THERMOSTAT FROM TOTAL CONNECT COMFORT (TCC)")
							|| pgsrc.contains("LYRIC ROUND WI-FI THERMOSTAT")
							|| pgsrc.contains("LYRIC SMART CONTROLLER") || pgsrc.contains("T6R WIRELESS THERMOSTAT")
							|| pgsrc.contains("T6 WIRED THERMOSTAT") || pgsrc.contains("T6 PRO WI-FI THERMOSTAT")
							|| pgsrc.contains("LYRIC ROUND WI-FI THERMOSTAT") || pgsrc.contains("PRO WI-FI THERMOSTAT")
							|| pgsrc.contains("T9 OR T10") || pgsrc.contains("T9 OR T10 / T10+ PRO WI-FI THERMOSTAT")
							|| pgsrc.contains("T9 / T9+ or T10 / T10+ Pro Wi-Fi Thermostat")
							|| pgsrc.contains("T9 or T10 / T10+ Pro Wi-Fi Thermostat")
							|| pgsrc.contains("C2 WI-FI SECURITY CAMERA") || pgsrc.contains("C1 WI-FI SECURITY CAMERA")
							|| pgsrc.contains("FOCUS PRO") || pgsrc.contains("FOCUS PRO 7000")
							|| pgsrc.contains("L1 WIFI WATER LEAK AND FREEZE DETECTOR")
							|| pgsrc.contains("L2 WIFI WATER SENSOR AND SWITCH")
							|| pgsrc.contains("WI-FI WATER LEAK AND FREEZE DETECTOR")
							|| pgsrc.contains("SMART HOME SECURITY")) {
						Keyword.ReportStep_Pass(testCase, "List of devices are visible");
						System.out.println("Device list visible");
						return true;
					} else {
						System.out.println("Device list is not visible, trying againg to find");
						return false;
					}
				}
			});
			return success;
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 180 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public String getCountryNameForInstallFromProjectSpecific() {
		String deviceRegion = null;
		String countryName = null;
		try {
			deviceRegion = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHOOSE_COUNTRY_DEVICE_NEED_TO_INSTALL")
					.trim();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Select country list page should be present but not in expected screen");
		}
		switch (deviceRegion) {
		case "UNITED_STATES":
			countryName = "United States";
			break;
		case "UNITED_KINGDOM":
			countryName = "United Kingdom";
			break;
		case "CANADA":
			countryName = "Canada";
			break;
		default:
			countryName = null;
		}

		return countryName;
	}

	public boolean isLocalNetworkPopUP() {
		return MobileUtils.isMobElementExists("NAME", "Local Network", testCase, 1)
				&& MobileUtils.isMobElementExists("NAME", "iOS Settings", testCase, 1);
	}

	public boolean clickOnEnableLocalNetwork_iOS(TestCases testCase) {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='check off']");
	}

	public boolean clickOnNextLocalNetwork_iOS() {
		CustomIOSDriver driver = ((CustomIOSDriver) testCase.getMobileDriver());
		WebElement nextbt = driver.findElement(By.name("Next"));
		if (nextbt.isEnabled()) {
			nextbt.click();
			return true;
		} else {
			return false;
		}
	}

	public boolean clickOnYesButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
	}

	public boolean clickOn_NoBleButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NoBleButton");
	}

	public boolean clickOnYesTheyMatchBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "YesTheyMatchBtn");
	}

	public boolean clickOn_NoButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
	}

	public boolean clickONCancelButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButton");
	}

	public boolean clickONConfirmContinuewithFullSetup() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ConfirmContinuewithFullSetup");
	}

	public boolean clickOnNextButtonwithFluent() {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofMillis(200));
		fWait.withTimeout(Duration.ofSeconds(30));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "NextButton");
						return ele.isEnabled();
					} else {
						return MobileUtils.isMobElementExists(objectDefinition, testCase, "NextButton", 1);
					}
				}
			});
			if (success) {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton",
						"Next Button enabled, clicked on Next Button ");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Next Button not Enabled / not in visible ");
				return false;
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 180 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

//	public boolean clickOnNextButton() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
//	}
	public boolean clickOnNextButton(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton", message);
	}

	public boolean clickOnNextButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
	}

	public boolean clickOnEditButton(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "EditButton", message);
	}

	public boolean clickOnYes_ReconfigureButton(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "YesReconfigureButton", message);
	}

	public WebElement getNextButtonVisibility() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "NextButton");
	}

	public boolean isReconfigurePopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsReconfigurePopUp", 30);
	}

	public boolean isConnectToYourThermostatWifiNetwork() {
		return isExpectedStringPresent("Select your Lyric or TStat network from your phone's",
				"Connect to your thermostat's Wi-Fi network");
	}

	public boolean isExpectedStringPresent(String predicateString, String expectedNameForLogs) {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(180));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					String source = testCase.getMobileDriver().getPageSource();
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						return source.contains(expectedNameForLogs) && source.contains(predicateString);
					} else {
						return false;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase,
						"Expected screen present ::: Screen name is >> " + expectedNameForLogs);
				return true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Expected Screen not Enabled / not in visible ");
				return false;
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 180 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public boolean connectWithThermostatWifiOnAndroid(String DeviceName) {

		boolean flag = false;
		boolean isDeviceConnected = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + DeviceName + "')]//*[contains(@content-desc,'Settings')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName + "']",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;

			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;

			} else {
				Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

				int x = (int) (dimens.getWidth() * 0.5);
				int endY = (int) (dimens.getHeight() * 0.2);
				int startY = (int) (dimens.getHeight() * 0.75);

				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofSeconds(1));
				fWait.withTimeout(Duration.ofMinutes(3));
				try {
					Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {

							if (MobileUtils.isMobElementExists("xpath", "//*[contains(@content-desc,'" + DeviceName
									+ "')]//*[contains(@content-desc,'Settings')]", testCase, 1))
								return true;
							else if (MobileUtils.isMobElementExists("XPATH",
									"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
											+ "']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH",
									"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
											+ ",Connected (no)']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("xpath", "//*[@text='" + DeviceName + "']",
									testCase, 1)) {
								Keyword.ReportStep_Pass(testCase, "Required broadcasting device found");
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='" + DeviceName + "']");
								return true;
							} else if (MobileUtils.isMobElementExists("xpath",
									"//*[@text='Add network' or @text='Add Network']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='Add network' or @text='Add Network']");

								if (MobileUtils.isMobElementExists("xpath",
										"//*[@text='Enter the SSID' or @text='Enter the ssid']", testCase, 2)) {
									MobileUtils.setValueToElement(testCase, "xpath",
											"//*[@text='Enter the SSID' or @text='Enter the ssid']", "" + DeviceName,
											DeviceName + " Neteowrk is added.");

									MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='SAVE' or @text='Save']");

								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Unable to find text box to enter SSID");
								}
								return true;
							} else if (MobileUtils.isMobElementExists("id", "header_view_subtitle", testCase, 2)) {
								if (MobileUtils.getMobElement(testCase, "id", "header_view_subtitle").getText()
										.equalsIgnoreCase("Connected to Thermostat")) {
									return true;
								} else
									return false;
							} else {
//								testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
								return false;
							}
						}
					});

					isDeviceConnected = success;
				} catch (org.openqa.selenium.TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to time out : 180 seconds" + e.getLocalizedMessage());
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to : " + e.getMessage());
				}
			}
			if (MobileUtils.isMobElementExists("ID", "header_view_subtitle", testCase, 6)
					&& MobileUtils.getMobElement(testCase, "id", "header_view_subtitle").getText()
							.equalsIgnoreCase("Connected to Thermostat")) {
				flag = true;
			} else {
				String page = testCase.getMobileDriver().getPageSource().toUpperCase();
				if ((isDeviceConnected
						&& MobileUtils.isMobElementExists("xpath",
								"//*[contains(@content-desc,'" + DeviceName
										+ "')]//*[contains(@content-desc,'Settings')]",
								testCase, 8))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH",
								"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
										+ "']",
								testCase, 8))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH",
								"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
										+ ",Connected (no')]",
								testCase, 8))
						|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
								+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
								testCase, 8))
						|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
								+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
								testCase, 2))
						|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'"
								+ DeviceName
								+ "')]/following-sibling::android.widget.TextView[contains(@text,'Connected to device')]",
								testCase, 5))
						|| (page.contains("FORGET") && page.contains("DISCONNECT") && page.contains("SHARE")
								&& page.contains(DeviceName.toUpperCase()))) {
					int i = 5;
					do {
						MobileUtils.pressBackButton(testCase);

						if (MobileUtils.isMobElementExists("id", "header_view_subtitle", testCase, 15)) {
							if (MobileUtils.getMobElement(testCase, "id", "header_view_subtitle").getText()
									.equalsIgnoreCase("Connected to Thermostat")) {
								flag = true;
								break;
							}
						}

						i--;
					} while (i >= 0);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to connect Stat Wifi");
					flag = false;
				}

			}
		}
		if (flag) {
			Keyword.ReportStep_Pass(testCase, "Succcessfully connected to Thermostat WIFI, Wifi Name is " + DeviceName);
		}
		return flag;

	}

	public boolean connectWithThermostatWifiOnAndroidWithAfterCredential(String DeviceName, String expectedString) {

		boolean flag = false;
		boolean isDeviceConnected = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + DeviceName + "')]//*[contains(@content-desc,'Settings')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName + "']",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
					testCase, 2)) {
				Keyword.ReportStep_Pass(testCase, "Since broadcasting device is saved, connected automatically");
				isDeviceConnected = true;
			} else {
				Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

				int x = (int) (dimens.getWidth() * 0.5);
				int endY = (int) (dimens.getHeight() * 0.2);
				int startY = (int) (dimens.getHeight() * 0.75);

				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofSeconds(1));
				fWait.withTimeout(Duration.ofMinutes(4));

				try {
					Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
						public Boolean apply(CustomDriver driver) {

							if (MobileUtils.isMobElementExists("xpath", "//*[contains(@content-desc,'" + DeviceName
									+ "')]//*[contains(@content-desc,'Settings')]", testCase, 1))
								return true;
							else if (MobileUtils.isMobElementExists("XPATH",
									"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
											+ "']",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("xpath", "//*[@text='" + DeviceName + "']",
									testCase, 2)) {
								Keyword.ReportStep_Pass(testCase, "Required broadcasting device found");

								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='" + DeviceName + "']");

								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
									+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
									testCase, 1)) {
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH",
									"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
											+ ",Connected (no')]",
									testCase)) {
								return true;
							} else if (MobileUtils.isMobElementExists("xpath",
									"//*[@text='Add network' or @text='Add Network']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='Add network' or @text='Add Network']");

								if (MobileUtils.isMobElementExists("xpath",
										"//*[@text='Enter the SSID' or @text='Enter the ssid']", testCase, 2)) {
									MobileUtils.setValueToElement(testCase, "xpath",
											"//*[@text='Enter the SSID' or @text='Enter the ssid']", DeviceName,
											DeviceName + " Neteowrk is added.");

									MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='SAVE' or @text='Save']");

								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Unable to find text box to enter SSID");
								}
								return false;
							} else {
//								testCase.getMobileDriver().swipe(x, startY, x, endY, 2000);
								return false;
							}
						}
					});

					isDeviceConnected = success;
				} catch (org.openqa.selenium.TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to time out : 180 seconds" + e.getLocalizedMessage());
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Connect to stat failed due to : " + e.getMessage());
				}
			}

			if ((isDeviceConnected && MobileUtils.isMobElementExists("xpath",
					"//*[contains(@content-desc,'" + DeviceName + "')]//*[contains(@content-desc,'Settings')]",
					testCase, 8))
					|| (isDeviceConnected
							&& MobileUtils.isMobElementExists("XPATH",
									"//*[@resource-id='com.android.settings:id/connected_list']//*[@text='" + DeviceName
											+ "']",
									testCase))
					|| (isDeviceConnected
							&& MobileUtils.isMobElementExists("XPATH",
									"//android.widget.LinearLayout[contains(@content-desc,'" + DeviceName
											+ ",Connected (no)']",
									testCase))
					|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
							+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'Connected')]",
							testCase, 8))
					|| (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + DeviceName
							+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.TextView[contains(@text,'No data connection')]",
							testCase, 2))
					|| (isDeviceConnected && MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'" + DeviceName
							+ "')]/following-sibling::android.widget.TextView[contains(@text,'Connected to device')]",
							testCase, 5))) {
				int i = 5;
				do {
					MobileUtils.pressBackButton(testCase);

					if (MobileUtils.isMobElementExists("id", "header_view_subtitle", testCase, 2)) {
						if (MobileUtils.getMobElement(testCase, "id", "header_view_subtitle").getText()
								.equalsIgnoreCase(expectedString)) {
							flag = true;
							break;
						}
					}

					i--;
				} while (i >= 0);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to connect Stat Wifi");
				flag = false;
			}

		}
		return flag;

	}

	public static boolean isWacModeEnabled(TestCases testCase, String deviceName) {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(180));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					if (MobileUtils.getMobElement(testCase, "NAME", "Find your thermostat's Wi-Fi Connection")
							.isDisplayed()) {
						return MobileUtils.isMobElementExists("Name", deviceName, testCase);
					} else
						return false;
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase,
						"System Found Thermostat in WAC Mode, System Will for Accesscory Setups");
				return true;
			} else {
				Keyword.ReportStep_Pass(testCase,
						"Not able to found Thermostat in WAC Mode, System Will try to continue with AP Mode");
				return false;
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 180 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public String wacModeDeviceName(String deviceName) {
		String[] split = deviceName.split(" ");
		return split[0].trim() + "-" + split[1].trim();
	}

	public boolean clickOnWacModeDeviceName(String deviceName) {
		return MobileUtils.clickOnElement(testCase, "NAME", deviceName);
	}

	public boolean clickOnwifiNameOnWacMode() {
		String device = null;
		try {
			device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
		}
		return MobileUtils.clickOnElement(testCase, "NAME", device);
	}

	public boolean clickonShowMoreWacModewifi() {
		return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'Show Other Network')]");
	}

	public boolean performAccessorySetupSelectWifi() {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofMillis(200));
		fWait.withTimeout(Duration.ofSeconds(100));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (MobileUtils.isMobElementExists("XPATH",
								"//*[contains(@name,'This accessory will be set up to join')]", testCase, 1)) {
//						if (MobileUtils.getMobElement(testCase, "XPATH",
//								"//*[contains(@name,'This accessory will be set up to join')]").()) {
							if (isExpectedWifiForWacMode()) {
								DIYUtils.setisWacModeSucess(true);
								return MobileUtils.clickOnElement(testCase, "NAME", "Next");
							} else {
								if (clickonShowMoreWacModewifi()) {
									if (clickOnwifiNameOnWacMode()) {
										DIYUtils.setisWacModeSucess(true);

										return MobileUtils.clickOnElement(testCase, "NAME", "Next");
									} else {
										Keyword.ReportStep_Pass(testCase,
												"WIFI not available in List, Expected wifi name is >>> "
														+ SuiteConstants
																.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
																		"WIFI_SSID")
																.trim());
//										DIYUtils.setwacModeWifiMessage("WIFI not available in List");
										return false;
									}
								} else {
									if (clickOnwifiNameOnWacMode()) {
										DIYUtils.setisWacModeSucess(true);
										return MobileUtils.clickOnElement(testCase, "NAME", "Next");
									} else {
										Keyword.ReportStep_Pass(testCase,
												"WIFI not available in List, Expected wifi name is >>> "
														+ SuiteConstants
																.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
																		"WIFI_SSID")
																.trim());
//										DIYUtils.setwacModeWifiMessage("WIFI not available in List");
										return false;
									}
								}
							}
						} else if (MobileUtils.isMobElementExists("XPATH",
								"//*[contains(@name,'Error connecting to your thermostat')]", testCase, 1)) {
							DIYUtils.setisWacModeSucess(false);
							return true;
						} else {
							DIYUtils.setisWacModeSucess(false);
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"failed due to : " + e.getMessage());
						return false;
					}
				}
			});
			if (DIYUtils.getisWacModeSucess() && success) {
				Keyword.ReportStep_Pass(testCase,
						"System Found Thermostat in WAC Mode, System Will for Accesscory Setups");
				return true;
			} else {
				Keyword.ReportStep_Pass(testCase,
						"Not able to found Thermostat in WAC Mode, System Will try to continue with AP Mode");
				return false;
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 100 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public boolean afterWifiSelectionINWacMode() {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(180));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Joining')]", testCase, 1))
							return false;
						else if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Waiting for')]", testCase,
								1))
							return false;
						else if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'This accessory joined')]",
								testCase))
							return MobileUtils.clickOnElement(testCase, "NAME", "Done");
						else
							return false;

					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"failed due to : " + e.getMessage());
						return false;
					}
				}
			});
			if (success) {
				Keyword.ReportStep_Pass(testCase,
						"System Found Thermostat in WAC Mode, System Finished for Accesscory Setups and Moved to Configure screen ");
				return true;
			} else {
				if (MobileUtils.isMobElementExists("XPATH",
						"//*[contains(@name,'An unexpected error occurred. Try again')]", testCase)) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
					return false;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
					return false;
				}

			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 180 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public boolean clickOniOSSettingsButton() {
		return MobileUtils.clickOnElement(testCase, "NAME", "iOS Settings");
	}

	public boolean isConfigureThermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NowConfigureThermostatSystem", 2);
	}

	public boolean isDeviceNameInWifiList(String wifiname, int timeOut) {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(3));
		fWait.withTimeout(Duration.ofSeconds(30));
		Boolean success = false;
		try {
			success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (MobileUtils.isMobElementExists("XPATH",
								"//*[contains(@name,'" + wifiname + ", Unsecured Network, Unsecure network')]",
								testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
												+ wifiname + "']",
										testCase, 1)) {
							Keyword.ReportStep_Pass(testCase, "Sucessfully COnnected to Thermostat wifi");
							testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
							Keyword.ReportStep_Pass(testCase,
									"Application Switched back to Honeywell Home Aplicaition");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH",
								"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + wifiname + "')]",
								testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name ,'NETWORKS')]/following-sibling::*[contains(@name,'"
												+ wifiname + "')]",
										testCase, 1)) {
							MobileUtils.clickOnElement(testCase, "NAME", wifiname,
									"sucessfully clicked on Thermostat Wi-Fi");
							return false;
						} else {
							return false;
						}

					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"failed due to : " + e.getMessage());
						return false;
					}
				}
			});
		} catch (StaleElementReferenceException e) {
			success = false;
		} catch (TimeoutException e) {
			success = false;

		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	public boolean ConnectToWifiUsingAPMode(TestCaseInputs inputs) {
		boolean flag = false;
		String wifiname = SystemState.getStatus().getTstatName();
//		System.out.println();
		if (isConnectTotheThermostatWiFiNetwork(3)) {
			testCase.getMobileDriver().activateApp("com.apple.Preferences");
			flag = MobileUtils.isMobElementExists("NAME", "Wi-Fi", testCase, 2);
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Connect to the Thermostat WIfi Network screen not visible");
		}
		if (MobileUtils.isMobElementExists("NAME", "OK", testCase, 2))
			MobileUtils.clickOnElement(testCase, "NAME", "OK", "Successfully clicked on OK button");
		if(MobileUtils.isMobElementExists("NAME", "Settings", testCase, 2)&&MobileUtils.isMobElementExists("NAME", "Wi-Fi", testCase, 2)&&MobileUtils.isMobElementExists("NAME", "Edit", testCase, 2)) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Already device in Wifi screen");
		}else {
			flag = flag && MobileUtils.clickOnElement(testCase, "NAME", "Wi-Fi",
					"Clicked on WIFI Settings in iOS Preference Settings Screen");
		}
		if (MobileUtils.isMobElementExists("NAME", "OK", testCase, 2))
			MobileUtils.clickOnElement(testCase, "NAME", "OK", "Successfully clicked on OK button");
		if (flag) {
			checkWifiScreenInOtherscreen(wifiname);
			if (scrollToWifiName(60, wifiname)) {
				if (isConfigureThermostat()) {
					Keyword.ReportStep_Pass(testCase, "Thermostat Configure Begins");
					return true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to see Thermostat Configure in App, Error occured please refer screenshot");
					return false;
				}
			} else {
				DIYUtils.iOS_scrollTable_ToCell(testCase, "name", wifiname);
				flag = scrollToWifiName(60, wifiname);
				if (flag && isConfigureThermostat()) {
					Keyword.ReportStep_Pass(testCase, "Thermostat Configure Begins");
					return true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to see Thermostat Configure in App, Error occured please refer screenshot");
					return false;
				}
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect Thermostat with APMODE WIfi, Error occured please refer screenshot");
			return false;
		}
	}

	public boolean checkWifiScreenInOtherscreen(String wifiName) {
		String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
		if (pageSource.contains("CANCEL") && pageSource.contains("ENTER PASSWORD")
				&& pageSource.contains("ENTER THE PASSWORD FOR")) {
			MobileUtils.clickOnElement(testCase, "name", "Cancel");
		}else if(pageSource.contains("Forget This Network".toUpperCase())&&pageSource.contains(wifiName)) {
			MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Wi-Fi']");
		}
		return false;
	}

	public boolean checkExactWifiScreen() {
		String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
		if(pageSource.contains("Forget This Network".toUpperCase())&&pageSource.contains("Tstat 9F38B4".toUpperCase())) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='Wi-Fi']");
		}
		return false;
	}
	
	public boolean scrollToWifiName(int duration, String wifiname) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		try {
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofSeconds(duration));
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						if(pageSource.contains(wifiname.toUpperCase())&&pageSource.contains("NO INTERNET")&&pageSource.contains("UNSECURED NETWORK")&&pageSource.contains("FORGET")){
							Keyword.ReportStep_Pass(testCase, "Sucessfully Connected to Thermostat wifi, Its already in Thermostat wifi detail Page");
							testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
							Keyword.ReportStep_Pass(testCase,
									"Application Switched back to Honeywell Home Aplicaition");
							return true;
						}else if(pageSource.contains(wifiname.toUpperCase())&&pageSource.contains("UNSECURED NETWORK")&&pageSource.contains("FORGET")){
							Keyword.ReportStep_Pass(testCase, "Sucessfully Connected to Thermostat wifi, Its already in Thermostat wifi detail Page");
							testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
							Keyword.ReportStep_Pass(testCase,
									"Application Switched back to Honeywell Home Aplicaition");
							return true;
						}else if (MobileUtils.isMobElementExists("XPATH",
								"//XCUIElementTypeCell[contains(@name,'" + wifiname
										+ "')]/XCUIElementTypeOther/XCUIElementTypeImage[@name='selected']",
								testCase, 2)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name,'" + wifiname + ", Unsecured Network, Unsecure network')]",
										testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
												+ wifiname + "']",
										testCase, 1)) {
							Keyword.ReportStep_Pass(testCase, "Sucessfully Connected to Thermostat wifi");
							testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
							Keyword.ReportStep_Pass(testCase,
									"Application Switched back to Honeywell Home Aplicaition");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH",
								"//XCUIElementTypeStaticText[contains(@name,'" + wifiname + "')]", testCase, 2)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + wifiname
												+ "')]",
										testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name ,'NETWORKS')]/following-sibling::*[contains(@name,'"
												+ wifiname + "')]",
										testCase, 1)) {
							MobileUtils.clickOnElement(testCase, "NAME", wifiname,
									"sucessfully clicked on Thermostat Wi-Fi");
							return false;
						}else if (checkExactWifiScreen()) {
							return true;
						} else if (checkWifiScreenInOtherscreen(wifiname)) {
							return false;
						} else {
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			flag = success;

		} catch (TimeoutException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	@SuppressWarnings("rawtypes")
	public void scrollDown() {
		Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

		int x = (int) (dimens.getWidth() * 0.5);
		int endY = (int) (dimens.getHeight() * 0.2);
		int startY = (int) (dimens.getHeight() * 0.75);
		W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(500));
	}

	@SuppressWarnings("rawtypes")
	public void scrollUp() {
		Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

		int x = (int) (dimens.getWidth() * 0.5);
		int endY = (int) (dimens.getHeight() * 0.2);
		int startY = (int) (dimens.getHeight() * 0.75);
		W3CTouchActions.swipe(testCase.getMobileDriver(), x, endY, x, startY, Duration.ofMillis(500));
	}

	public boolean ConnectToWifiUsingAPModeRetryScenario() {
		boolean flag = false;
		String wifiname = SystemState.getStatus().getTstatName();
		if (isConnectTotheThermostatWiFiNetwork(3)) {
			testCase.getMobileDriver().activateApp("com.apple.Preferences");
			flag = MobileUtils.isMobElementExists("NAME", "Wi-Fi", testCase, 2);
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Connect to the Thermostat WIfi Network screen not visible");
		}
		if (!MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeNavigationBar[@name='Wi-Fi']", testCase, 3)) {
			flag = flag && MobileUtils.clickOnElement(testCase, "NAME", "Wi-Fi",
					"Clicked on WIFI Settings in iOS Preference Settings Screen");
		}
		if (flag) {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());

			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofSeconds(180));
			try {
				Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
					public Boolean apply(CustomDriver driver) {
						try {
							if (MobileUtils.isMobElementExists("XPATH",
									"//*[contains(@name,'" + wifiname + ", Unsecured Network, Unsecure network')]",
									testCase, 1)
									|| MobileUtils.isMobElementExists("XPATH",
											"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
													+ wifiname + "']",
											testCase, 1)) {
								Keyword.ReportStep_Pass(testCase, "Sucessfully Connected to Thermostat wifi");
								testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
								Keyword.ReportStep_Pass(testCase, "Application Switched back to Resideo Aplicaition");
								return true;
							} else if (MobileUtils.isMobElementExists("XPATH",
									"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + wifiname
											+ "')]",
									testCase, 1)
									|| MobileUtils.isMobElementExists("XPATH",
											"//*[contains(@name ,'NETWORKS')]/following-sibling::*[contains(@name,'"
													+ wifiname + "')]",
											testCase, 1)) {
								MobileUtils.clickOnElement(testCase, "NAME", wifiname,
										"sucessfully clicked on Thermostat Wi-Fi");
								return false;
							} else {
								return false;
							}

						} catch (Exception e) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"failed due to : " + e.getMessage());
							return false;
						}
					}
				});

				if (success) {
					if (flag) {
						Keyword.ReportStep_Pass(testCase, "Thermostat Configure Begins");
						return true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
						return false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to connect Thermostat with APMODE WIfi, Error occured please refer screenshot");
			return false;
		}

	}

	public boolean ConnectToWifiUsingAPModeRetryScenario_failureScenario() {
		boolean flag = false;
		String wifiname = SystemState.getStatus().getTstatName();
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());

		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofSeconds(180));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (MobileUtils.isMobElementExists("XPATH",
								"//*[contains(@name,'" + wifiname + ", Unsecured Network, Unsecure network')]",
								testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[@name='selected']/parent::XCUIElementTypeOther/preceding-sibling::XCUIElementTypeStaticText[@name='"
												+ wifiname + "']",
										testCase, 1)) {
							Keyword.ReportStep_Pass(testCase, "Sucessfully Connected to Thermostat wifi");
							testCase.getMobileDriver().activateApp("com.resideo.acs.lyric.enterprise");
							Keyword.ReportStep_Pass(testCase, "Application Switched back to Resideo Aplicaition");
							return true;
						} else if (MobileUtils.isMobElementExists("XPATH",
								"//*[@name ='MY NETWORKS']/following-sibling::*[contains(@name,'" + wifiname + "')]",
								testCase, 1)
								|| MobileUtils.isMobElementExists("XPATH",
										"//*[contains(@name ,'NETWORKS')]/following-sibling::*[contains(@name,'"
												+ wifiname + "')]",
										testCase, 1)) {
							MobileUtils.clickOnElement(testCase, "NAME", wifiname,
									"sucessfully clicked on Thermostat Wi-Fi");
							return false;
						} else {
							return false;
						}

					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"failed due to : " + e.getMessage());
						return false;
					}
				}
			});

			if (success) {
				if (flag) {
					Keyword.ReportStep_Pass(testCase, "Thermostat Configure Begins");
					return true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
					return false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to connect Thermostat with Wacmode WIfi, Error occured please refer screenshot");
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}

	public boolean clickOnLockOutOff() {
		boolean flag = false;
		flag = MobileUtils.clickOnElement(objectDefinition, testCase, "OutdoorHeatLockoutOFF");
		return flag;
	}

	public boolean clickOnLockOutOthers() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OutdoorHeatLockoutOthers");
	}

	public boolean clickOnComfort() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatDroopComfort");
	}

	public boolean enter_4Digit_pin_Houdini(String pin) {
		boolean flag = false;
		try {
			char[] pinFromThermostat = pin.toCharArray();
			if (isHoudini_4Digit_PinLayoutisPresent()) {
				List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase, "4DigitPinBox");
				for (int i = 0; i < mobElements.size(); i++) {
					mobElements.get(i).sendKeys(String.valueOf(pinFromThermostat[i]));
					flag = true;
				}
			}
			if (flag) {
				Keyword.ReportStep_Pass(testCase,
						"Sucessfully set pin into mobile the 4Digit pins are <<< " + pin + " >>>");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enter pin in APP");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in set4_DigitPin() due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public boolean set4_DigitPin() {
		boolean flag = false;
		String deviceNeedToInstall = null;
		char[] pinFromThermostat = null;
		try {
			deviceNeedToInstall = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in set4_DigitPin() due to " + e.getMessage());
			flag = false;
		}
		if (isPinLayoutisPresent()) {
			pinFromThermostat = getPinFromThermostat(deviceNeedToInstall);
			List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase, "4DigitPinBox");
			for (int i = 0; i < mobElements.size(); i++) {
				mobElements.get(i).sendKeys(String.valueOf(pinFromThermostat[i]));
				flag = true;
			}
		}
		if (flag) {
			SystemState.getStatus().pairingStartTime(System.currentTimeMillis() / 1000);
			Keyword.ReportStep_Pass(testCase,
					"Pairing completed, current time stamp is " + SystemState.getStatus().pairingStartTime());
			Keyword.ReportStep_Pass(testCase,
					"Sucessfully set pin into mobile the 4Digit pins are <<< " + pinFromThermostat[0]
							+ pinFromThermostat[1] + pinFromThermostat[2] + pinFromThermostat[3] + " >>>");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enter pin in APP");
		}
		return flag;
	}

	public boolean set4_DigitPin(char[] pinFromThermostat) {
		boolean flag = false;
		if (isPinLayoutisPresent_flycathcer(45)) {
			List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase, "4DigitPinBox");
			if (mobElements.size() > 3) {

				for (int i = 0; i < mobElements.size(); i++) {
					mobElements.get(i).sendKeys(String.valueOf(pinFromThermostat[i]));
					flag = true;
				}
			} else {
				mobElements.get(0).sendKeys(new String(pinFromThermostat));
				flag = true;
			}
		}
		if (flag) {
			Keyword.ReportStep_Pass(testCase,
					"Sucessfully set pin into mobile the 4Digit pins are <<< " + pinFromThermostat[0]
							+ pinFromThermostat[1] + pinFromThermostat[2] + pinFromThermostat[3] + " >>>");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enter pin in APP");
		}
		return flag;
	}

	public static char[] getPinFromThermostat(String deviceModel) {
		String pin = "";
		String finalPin = "";
		int total = 10;
		String Counter = "";
		String previousPin = SystemState.getStatus().getPreviousPin();
		for (int i = 0; i <= total; i++) {

			if (deviceModel.contains("JASPER")) {
				pin = StatCommands.getInstance().cattCommandsStub
						.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
								.setTextMethod(DisplayMethod.Numbers).build())
						.getStrVal().toString().trim().toUpperCase().replace(" ", "").trim();
			} else if (deviceModel.contains("HOUDINI")) {
//				pin = StatCommands.getInstance().cattCommandsStub
//						.getHoudiniDisplayText(HoudiniDisplayTextMsg.newBuilder()
//								.setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build())
//						.getStrVal().toUpperCase().replace(" ", "").trim();
			} else {
				pin = StatCommands.getInstance().cattCommandsStub
						.getPairingPin(PairingPinMsg.newBuilder().setPinMode(PairingPinMode.RADIO).build()).getStrVal();
			}
			if (pin.equals("") || pin.toUpperCase().contains("INVALID")) {

				System.out.println("Retry Pin, Pin is:: " + pin);
			} else if (!SystemState.getStatus().getPreviousPin().isEmpty() && previousPin.contains(pin)) {
				System.out.println("Same pin Found, Retry Pin, Pin is:: " + pin);
			} else {
				if (i == 4 || i == 8) {
					Counter = pin;
				} else if (Counter.contains(pin) && (!pin.isEmpty())) {
					finalPin = pin;
					System.out.println(finalPin);
					SystemState.getStatus().setPreviousPin(finalPin);
					break;
				}
			}
		}

		return finalPin.toCharArray();
	}

	public char[] getPinFromThermostat(PairingPinMode pinMode) {
		String pin = "";
		String finalPin = "";
		int total = 5;
		String previousPin = SystemState.getStatus().getPreviousPin();
		for (int i = 0; i <= total; i++) {

			pin = StatCommands.getInstance().cattCommandsStub
					.getPairingPin(PairingPinMsg.newBuilder().setPinMode(pinMode).build()).getStrVal();

			System.out.println("Current Pin is " + pin);
			System.out.println("Previous Pin is " + previousPin);
			if (pin.equals("") || pin.toUpperCase().contains("INVALID")) {

				System.out.println("Retry Pin, Pin is:: " + pin);
			} else if (!SystemState.getStatus().getPreviousPin().isEmpty() && previousPin.contains(pin)) {
				System.out.println("Same pin Found, Retry Pin, Pin is:: " + pin);
			} else {
				finalPin = pin;
				System.out.println(finalPin);
				SystemState.getStatus().setPreviousPin(finalPin);
				break;
			}

		}

		return finalPin.toCharArray();
	}

	public String getISUTitle() {
		String getattribute = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
			getattribute = "text";
		else
			getattribute = "label";

		return MobileUtils.getDomAttribute(testCase, objectDefinition, "", getattribute);

	}

	public boolean ISUOutDoorSensor(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NO": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorNo");
		}
		case "WIRED": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorWired");
		}
		case "INTERNET": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorInternet");
		}
		default:
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available in OutDoor Air Sensor, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
	}

	public boolean ISUHeatingSystem(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "CONVENTIONAL FORCED AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalForcedAir");
		}
		case "HEAT PUMP": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPump");
		}
		case "BOILER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Boiler");
		}
		case "NONE COOL ONLY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneCoolOnly");
		}
		default:
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
	}

	public boolean ISUFuelSource(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "GAS STANDARD EFFICIENCY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasStandardEfficiency");
		}
		case "GAS HIGH EFFICIENCY": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasHighEfficiency");
		}
		case "OIL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalOil");
		}
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalElectric");
		}
		case "HOT WATER FAN COIL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalHotWaterFanCoil");
		}
		case "AIR TO AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpAirToAir");
		}
		case "GEOTHERMAL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpGeothermal");
		}
		case "HOT WATER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerHotWater");
		}
		case "STEAM": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerSteam");
		}
		default: {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User Expected ISU Value not available For Fuel Source System, User Expected ISU Value is :"
							+ ISUValue);
			return false;
		}
		}
	}

	public boolean setCyclePerHourForStage(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {

			String getattribute = null;
			if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
				getattribute = "text";
			else
				getattribute = "label";
			int percycle = Integer.valueOf(ISUValue);
			for (int i = 2; i >= 0; i--) {
				if (getPerCycleBarValue(getattribute).contains(ISUValue)) {
					Keyword.ReportStep_Pass(testCase, "Sucessfuly set to " + ISUValue + "  Cycles Per Hour");
					flag = true;
					break;
				} else {
					flag = MobileUtils.setValueToElement(objectDefinition, testCase, "SeekBarCycle",
							String.valueOf(percycle - 1),
							"Compressor Cycles Per Hour per Stage -1,  Set to ::" + String.valueOf(percycle));
					flag = false;
				}
			}
		}
		flag = flag && clickOnNextButton("clicked on Cycle/Hour stage next button");
		return flag;
	}

	public String getPerCycleBarValue(String tagname) {
		return MobileUtils.getDomAttribute(testCase, objectDefinition, "SeekBarCycleValue", tagname);
	}

	public boolean ISUIndoorSensor(String ISUValue) {
		if (ISUValue.toUpperCase().equals("NONE")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensorNone");
		} else if (ISUValue.toUpperCase().equals("INDOOR")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensorInDoor");
		} else {
			return false;
		}
	}

	public boolean ISULanguage(String ISUValue) {
		if (ISUValue.toUpperCase().equals("ENGLISH")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "LanguageEnglish");
		} else if (ISUValue.toUpperCase().equals("FRANCE")) {
			Keyword.ReportStep_Fail(testCase, 0, "ISU Value Not implemented other than language : English");
			return false;
		} else {
			return false;
		}
	}

	public boolean ISUClockFormat(String ISUValue) {
		if (ISUValue.toUpperCase().equals("12HOUR")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "12HrOption");
		} else if (ISUValue.toUpperCase().equals("24HOUR")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "24HrOption");
		} else {
			return false;
		}
	}

	public boolean ISUTemprtatureFormat(String ISUValue) {
		if (ISUValue.toUpperCase().equals("FAHRENHEIT")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Fahrenheit");
		} else if (ISUValue.toUpperCase().equals("CELSIUS")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Celsius");
		} else {
			return false;
		}
	}

	public boolean ISU_C_WireAdapter(String ISUValue) {
		if (ISUValue.toUpperCase().equals("YES")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "CWireAdapterYes");
		} else if (ISUValue.toUpperCase().equals("NO")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "CWireAdapterNO");
		} else {
			return false;
		}
	}

	public boolean ISUIndoorSensorType(String ISUValue) {
		if (ISUValue.toUpperCase().equals("10K")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensor10K");
		} else if (ISUValue.toUpperCase().equals("20K")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorSensor20K");
		} else {
			return false;
		}
	}

	public boolean ISUTemperatureSensorSelection(String ISUValue) {
		if (ISUValue.toUpperCase().equals("AVERAGE")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorAverage");
		} else if (ISUValue.toUpperCase().equals("THERMOSTAT ONLY")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorThermostatOnly");
		} else if (ISUValue.toUpperCase().equals("WIRED ONLY")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureSensorWiredOnly");
		} else {
			return false;
		}
	}

	public boolean ISUVentilationType(String ISUValue) {
		if (ISUValue.toUpperCase().equals("NONE")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypeNone");
		} else if (ISUValue.toUpperCase().equals("ERV_HRV")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypeERVHRV");
		} else if (ISUValue.toUpperCase().equals("PASSIVE(FAN ONLY)")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationTypePassiveFanOnly");
		} else if (ISUValue.toUpperCase().equals("FRESH AIR DAMPER")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentailationTypeFreshAirDamper");
		} else {
			return false;
		}
	}

	public boolean ISUCooling_HeatingStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "NONE": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "StageNone");
		}
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
		}
		default:
			return false;
		}

	}

	public boolean ISUCompressorStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
		}
		default:
			return false;
		}
	}

	public boolean ISUVentilationControlMethod(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ASHRAE 2010": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodASHRAE2010");
		}
		case "ASHRAE 2013": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodASHRAE2013");
		}
		case "PERCENT ON TIME": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationControlMethodPercentOnTime");
		}

		default:
			return false;
		}
	}

	public boolean ISUVentilationFanControl(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "THERMOSTAT CONTROL FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationFanControlThermostatControlsFan");
		}
		case "EQUIPMENT CONTROL FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilationFanControlEquipmentControlsFan");
		}
		default:
			return false;
		}
	}

	public boolean ISUFanOperationInHeat(String ISUValue) {

		switch (ISUValue.toUpperCase()) {
		case "EQUIPMENT CONTROLS FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FanOperationinHeatEquipmentControlsFan");
		}
		case "THERMOSTAT CONTROLS FAN": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "FanOperationinHeatThermostatControlsFan");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUReversingValve(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "REVERSING VALVE O OB ON COOL": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnCool");
		}
		case "REVERSING VALVE B OB ON HEAT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnHeat");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUAUXPerE_TerminalControl(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "DRIVE BOTH AUX AND E TOGETHER": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxETerminalControlDriveBothAuxE");
		}
		case "AUX AND E ARE INDEPENDENT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxETerminalControlDriveAuxEIndependent");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUBackupHeat(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatElectric");
		}
		case "GAS STANDARD": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatGasStandard");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUBackUpHeatDroop(String ISUValue) {
		boolean flag = false;
		switch (ISUValue.toUpperCase()) {
		case "COMFORT": {
			flag = clickOnComfort();
			break;
		}
		case "OTHERS": {
			flag = clickOnLockOutOthers();
			break;
		}
		default: {
			flag = false;
			break;
		}
		}
		flag = flag && clickOnNextButton("Clicked on backup heat droop next button");
		return flag;
	}

	public boolean ISUBackUpHeatUpStageTimer(String ISUValue) {
		boolean flag = true;
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			flag = clickOnLockOutOff();
			break;
		}
		case "OTHERS": {
			flag = clickOnLockOutOthers();
			break;
		}
		default: {
			flag = false;
			break;
		}
		}
		flag = flag && clickOnNextButton("Clicked on backup heat up stage timer next button");
		return flag;

	}

	public boolean ISUCompressorLockout(String ISUValue) {
		boolean flag = false;
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			flag = clickOnLockOutOff();
			break;
		}
		case "OTHERS": {
			flag = clickOnLockOutOthers();
			break;
		}
		default: {
			flag = false;
			break;
		}
		}
		flag = flag && clickOnNextButton("Clicked on Compressor Lockout next button");
		return flag;
	}

	public boolean ISUOutdoorHeatLockout(String ISUValue) {
		boolean flag = false;
		switch (ISUValue.toUpperCase()) {
		case "OFF": {
			flag = clickOnLockOutOff();
			break;
		}
		case "OTHERS": {
			flag = clickOnLockOutOthers();
			break;
		}
		default: {
			flag = false;
			break;
		}
		}
		flag = flag && clickOnNextButton("Clicked on Outdoor Heat lockout next button");
		return flag;
	}

	public boolean ISUExternalFossilFuelKit(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "THERMOSTAT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ExternalFossilFuelKitThermostat");
		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ExternalFossilFuelKitBtton");
		}
		default: {
			return false;
		}
		}
	}

	public boolean ISUCompressorCyclesPerHour_Stage(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {

			String getattribute = null;
			if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
				getattribute = "text";
			else
				getattribute = "label";
			int percycle = Integer.valueOf(ISUValue);
			for (int i = 2; i >= 0; i--) {
				if (getPerCycleBarValue(getattribute).contains(ISUValue)) {
					Keyword.ReportStep_Pass(testCase, "Sucessfuly set to " + ISUValue + "  Cycles Per Hour");
					flag = true;
					break;
				} else {
					flag = MobileUtils.setValueToElement(objectDefinition, testCase, "SeekBarCycle",
							String.valueOf(percycle - 1),
							"Compressor Cycles Per Hour per Stage -1,  Set to ::" + String.valueOf(percycle));
					flag = false;
				}
			}
		}
		flag = flag && clickOnNextButton("Clicked on Compressor cycle/hour stage>> next button");
		return flag;
	}

	public boolean ISUBackUpHeatCyclePerHour(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {

			String getattribute = null;
			if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
				getattribute = "text";
			else
				getattribute = "label";
			int percycle = Integer.valueOf(ISUValue);
			for (int i = 2; i >= 0; i--) {
				if (getPerCycleBarValue(getattribute).contains(ISUValue)) {
					Keyword.ReportStep_Pass(testCase, "Sucessfuly set to " + ISUValue + "  Cycles Per Hour");
					flag = true;
					break;
				} else {
					flag = MobileUtils.setValueToElement(objectDefinition, testCase, "SeekBarCycle",
							String.valueOf(percycle - 1),
							"Compressor Cycles Per Hour per Stage -1,  Set to ::" + String.valueOf(percycle));
					flag = false;
				}
			}

		}
		flag = flag && clickOnNextButton("Clicked on BackUp Heat/hour next button");
		return flag;
	}

	public boolean ISUEmergencyHeat(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "ELECTRIC": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatElectric");
		}
		case "GAS OR OIL-FORCED AIR": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatGasOilForcedAir");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUBackUPHeatStages(String ISUValue) {
		switch (ISUValue.toUpperCase()) {
		case "1": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStages1");
		}
		case "2": {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatStages2");
		}
		default: {
			return false;
		}
		}

	}

	public boolean ISUEmergencyHeatCyclePerHour(String ISUValue) {
		boolean flag = false;
		if (ISUValue.toUpperCase().contains("DEFAULT")) {
			flag = true;
		} else {

			String getattribute = null;
			if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
				getattribute = "text";
			else
				getattribute = "label";
			int percycle = Integer.valueOf(ISUValue);
			for (int i = 2; i >= 0; i--) {
				if (getPerCycleBarValue(getattribute).contains(ISUValue)) {
					Keyword.ReportStep_Pass(testCase, "Sucessfuly set to " + ISUValue + "  Cycles Per Hour");
					flag = true;
					break;
				} else {
					flag = MobileUtils.setValueToElement(objectDefinition, testCase, "SeekBarCycle",
							String.valueOf(percycle - 1),
							"Compressor Cycles Per Hour per Stage -1,  Set to ::" + String.valueOf(percycle));
					flag = false;
				}
			}

		}
		flag = flag && clickOnNextButton("Clicked on Emergency Heat/hour next button");
		return flag;
	}

	public boolean clickOn24GHZPopUpOKButton() {
		boolean flag = false;
		System.out.println();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "PopUpOkButton", "2.4GHz Popup closed",
					false);
		} else {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "PopUpOkButton", false);
			if (mobElement.isDisplayed()) {
				Actions ac = new Actions(testCase.getMobileDriver());
				ac.click(mobElement).perform();
				flag = true;
			} else {
				flag = false;
			}

		}
		return flag;
	}

	public boolean clickOnChooseaNetworkConnectTOThermostatWifi(String wifiName) {
//		String wifiName = null;
//		try {
//			wifiName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
//		} catch (Exception e) {
//		}
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.TextView[@text='" + wifiName + "']",
					"Successfully clicked on WIFI name from WIFI list, wifi name is " + wifiName);
		} else {
			return MobileUtils.clickOnElement(testCase, "NAME", wifiName);
		}

	}

	public boolean clickOnAddWifiNetworkButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddWifiNetworkButton");
	}

	public boolean setWifinetworkName(String wifiName) {
//		String wifiName = null;
//		try {
//			wifiName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
//		} catch (Exception e) {
//		}
		return MobileUtils.setValueToElement(objectDefinition, testCase, "ADDWifiNetworkEditNameTB", wifiName);
	}

	public boolean clickOnWifiSecurityList() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddWifiSecuityTypeListBox");
	}

	@SuppressWarnings("rawtypes")
	public boolean clickOnSecurityTypeFromList() {
		boolean flag = false;
		List<String> wifiList = new ArrayList<String>();
		String objectDefinition_selected = "";

		CustomDriver mobileDriver = testCase.getMobileDriver();
		try {
			String wifi_Security = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SECURITY")
					.trim();
			switch (wifi_Security) {
			case "WPA2_PERSONAL_MIXED":
				objectDefinition_selected = "WifiSecurityNameWPA2PesonalMIXED";
				break;
			case "WPA2_PERSONAL_TKIP":
				objectDefinition_selected = "WifiSecurityNameWPA2PersonalTKIP";
				break;
			case "WPA2_PERSONAL_AES":
				objectDefinition_selected = "WifiSecurityNameWPA2PersonalAES";
				break;
			default:
				objectDefinition_selected = "WifiSecurityNameWPA2PersonalAES";
				break;
			}
			Keyword.ReportStep_Pass(testCase, "Security Type will select :: " + objectDefinition_selected);

			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

				List<WebElement> mobElements = MobileUtils.getMobElements(testCase, "XPATH",
						"//*[contains(@resource-id,'spinner_drop_down_text')]");
				Dimension size = mobileDriver.manage().window().getSize();
				int anchor = (int) (size.width / 2);
				for (int i = 0; i <= 3; i++) {

					try {
						System.out.println();
						mobElements = MobileUtils.getMobElements(testCase, "XPATH",
								"//*[contains(@resource-id,'spinner_drop_down_text')]");

						for (WebElement webElement : mobElements) {
							wifiList.add(webElement.getText());
						}
						int y = mobElements.get(0).getLocation().y;
						int end = mobElements.get(mobElements.size() - 2).getLocation().y;

						Keyword.ReportStep_Pass(testCase, "List of Wifi available in Android");
						Keyword.ReportStep_Pass(testCase, wifiList.toString());
						wifiList.clear();
						if (MobileUtils.isMobElementExists(objectDefinition, testCase, objectDefinition_selected, 2)) {
							flag = MobileUtils.clickOnElement(objectDefinition, testCase, objectDefinition_selected);
							break;
						} else {
							W3CTouchActions.swipe(testCase.getMobileDriver(), anchor, end, anchor, y, Duration.ofMillis(4000));
						}

//					new TouchAction(mobileDriver).longPress(point(anchor, end)).moveTo(point(anchor, y)).release()
//							.perform();

					} catch (Exception e) {
						System.out.println(e.getMessage());
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occured clickOnSecurityTypeFromList() due to ::" + e);
						flag = false;
					}
				}
			} else {
				List<WebElement> mobElements = MobileUtils.getMobElements(testCase, "XPATH",
						"//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeStaticText");
				Dimension size = mobileDriver.manage().window().getSize();
				int anchor = (int) (size.width / 2);
				for (int i = 0; i <= 3; i++) {

					try {
						mobElements = MobileUtils.getMobElements(testCase, "XPATH",
								"//XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeStaticText");

						for (WebElement webElement : mobElements) {
							wifiList.add(webElement.getDomAttribute("name"));
						}

						int y = mobElements.get(0).getLocation().y;
						int end = mobElements.get(mobElements.size() - 2).getLocation().y;

						Keyword.ReportStep_Pass(testCase, "List of Wifi available in Android");
						Keyword.ReportStep_Pass(testCase, wifiList.toString());
						wifiList.clear();
						if (MobileUtils.isMobElementExists(objectDefinition, testCase, objectDefinition_selected, 2)) {
							flag = MobileUtils.clickOnElement(objectDefinition, testCase, objectDefinition_selected);
							break;
						} else {
							W3CTouchActions.swipe(testCase.getMobileDriver(), anchor, end, anchor, y, Duration.ofMillis(4000));
						}

//					new TouchAction(mobileDriver).longPress(point(anchor, end)).moveTo(point(anchor, y)).release()
//							.perform();

					} catch (Exception e) {
						System.out.println(e.getMessage());
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occured clickOnSecurityTypeFromList() due to ::" + e);
						flag = false;
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured clickOnSecurityTypeFromList() due to ::" + e);
			flag = false;
		}
		return flag;
	}

	public boolean setWifiPasswordinAddNewWifi(String wifiPassword) {
//		String wifiPassword = null;
//		try {
//			wifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD").trim();
//		} catch (Exception e) {
//		}
		return MobileUtils.setValueToElement(objectDefinition, testCase, "WifiPasswordEditBox", wifiPassword);
	}

	public boolean clickOnRefreshButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "WifiRefreshButton");
	}

	public boolean setThermostatLocationName(String Location) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(Location);
			((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
			flag = true;
		} else {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Create Custom Name");
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(Location);
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
		return flag;
	}

	public boolean setThermostatLocationZipCode(String LocationZipCode) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(LocationZipCode);
			((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
			flag = true;
		} else {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Create Custom Name");
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(LocationZipCode);
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
		return flag;
	}

	public boolean setWifiSecuityPasswordInManual(String wifiPassword) {
//		String wifiPassword = null;
//		try {
//			wifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD").trim();
//		} catch (Exception e) {
//		}
		return MobileUtils.setValueToElement(testCase, "ID", "password_edittext", wifiPassword);
	}

	public boolean clickOnCreateLocation() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CreateNewLocaitonButton");

	}

	public boolean setThermostatName() {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName().trim());
			((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
			flag = true;
		} else {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Create Custom Name");
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName());
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
		return flag;
	}

	public boolean setThermostatName_secondIterate() {
		String attachedeviceName = RandomStringUtils.randomAlphanumeric(2).toUpperCase();
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName().trim() + attachedeviceName);
			((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
			flag = true;

		} else {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Create Custom Name");
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName() + attachedeviceName);
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
		return flag;
	}

	public boolean isPrepareThermostatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isPrepareThermostatScreen", 3);
	}

	public boolean isQRCodeScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isQRCodeScreen", 3);
	}

	public boolean isScanQRCodeScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isScanQRCodeScreen", 10);
	}

	public boolean isEnteredDeviceName() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomThermostatName", 6);
		} else {
			return MobileUtils.isMobElementExists("NAME", "Create Custom Name", testCase, 1);
		}
	}

	public boolean isAlreadyDeviceNameExistPopup() {
		if (MobileUtils.isMobElementExists("XPATH",
				"//*[contains(@name,'A device with this name already exists in this location')]", testCase, 2)) {
			return MobileUtils.clickOnElement(testCase, "NAME", "OK");
		} else {
			return false;
		}
	}

	@SuppressWarnings("rawtypes")
	public boolean setCaspianName() {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName().trim());
			W3CTouchActions.tap(testCase.getMobileDriver(), 1309, 2581);
			flag = true;

		} else {
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Create Custom Name");
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CustomThermostatName");
			mobElement.click();
			mobElement.sendKeys(SystemState.getStatus().getTstatName());
			flag = MobileUtils.clickOnElement(testCase, "NAME", "Done");
		}
		return flag;
	}

	@SuppressWarnings("rawtypes")
	public boolean setUserSelectedRoomName() {
		boolean flag = false;
		String roomName = SystemState.getStatus().getTstatName().trim();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

			int x = (int) (dimens.getWidth() * 0.5);
			int endY = (int) (dimens.getHeight() * 0.2);
			int startY = (int) (dimens.getHeight() * 0.75);
			for (int i = 0; i <= 3; i++) {
				if (isAddRoomNameButton()) {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Successfully Scroll to CustomName box");
					break;
				} else {
					W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(4000));
				}
			}
			if (clickOnAddCustomRoomName()) {
				if (MobileUtils.setValueToElement(objectDefinition, testCase, "AddRoomNameButton", roomName,
						"Set Room name as " + roomName)) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to set custom Room Name as " + roomName);
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on custom Room Name Text Box");
				flag = false;
			}

			flag = LyricUtils.CloseKeyboard(testCase);
		} else {
			if (clickOnAddCustomRoomName()) {
				if (MobileUtils.setValueToElement(testCase, "XPATH", "//XCUIElementTypeTextField", roomName,
						"Set Room name as " + roomName)) {
					if (MobileUtils.clickOnElement(testCase, "NAME", "Done")) {
						Keyword.ReportStep_Pass(testCase, "Successfully set custom Room name as " + roomName);
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Enter or done Button in keyboard");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to set custom Room Name as " + roomName);
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on custom Room Name Text Box");
				flag = false;
			}
		}
		return flag;
	}

	public boolean selectDeviceNameInAvailableList(String message) {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SelectFirstDeviceNameInAvailableList", message);
	}

	public String getFirstAvailableDeviceNameFromList() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getMobElement(objectDefinition, testCase, "SelectFirstDeviceNameInAvailableList")
					.getText();
		} else {
			return MobileUtils.getMobElement(objectDefinition, testCase, "SelectFirstDeviceNameInAvailableList")
					.getDomAttribute("value");
		}
	}

	public boolean clickOnLocationNameFromTheList(String LocationName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='" + LocationName + "']",
					"selected Location name is " + LocationName);
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='" + LocationName + "']",
					"selected Location name is " + LocationName);
		}
	}

	public boolean RegisteringDevice() {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(5));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						if (pageSource.contains("REGISTRATION ERROR")) {
							Keyword.ReportStep_Fail(testCase, 0, "Registration error");
							SystemState.getStatus().setRegError(true);
							return true;
						} else if (isRebatesDRScreen()) {
//							clickOnSkipRebeatesButton();
//							SystemState.getStatus().isRebateDRcompleted(true);
							System.out.println("Rebate screen visible and it skipped.....");
							return true;
						} else if (isSucessIsVisible()) {
							System.out.println("Success screen visible.....");
							return true;

						} else if (isConnectingToHoneywellHome(1)) {
							System.out.println("connecting to honeywell home.....");
							return false;
						} else {
//							System.out.println("Trying to find sucess screen.....");
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occured in RegisteringDevice() because of Timeout and more details "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed due to exception raised, Is Sucess screen not visible: Exception is ::" + e);
						return false;
					}
				}
			});
//			System.out.println("came out from registration");
			if (SystemState.getStatus().isRegError()) {
				flag = false;
			} else if (isEventReceived && isRebatesDRScreen()) {
				System.out.println("Rebate screen");
				Keyword.ReportStep_Pass(testCase, "Rebate screen is visible, Will Skip");
				flag = true;
			} else if (isEventReceived && isSucessIsVisible()) {
				System.out.println("sucess screen");
				Keyword.ReportStep_Pass(testCase, "Success screen is visible, Will Proceed next");
				flag = clickOnNextButton("Clicked on next button in success screen after Registration");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed due to Expected screen not visible, Is Sucess screen not visible");
				flag = false;
			}

		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in RegisteringDevice() because of Timeout and more details " + e.getMessage());
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in RegisteringDevice() due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean isRegisteringDevice() {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofSeconds(15));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						if (pageSource.contains("REGISTERING DEVICE")) {
							return true;
						} else {
							System.out.println("Trying to Registering device.....");
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occured in RegisteringDevice() because of Timeout and more details "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed due to exception raised, Is Sucess screen not visible: Exception is ::" + e);
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in RegisteringDevice() because of Timeout and more details " + e.getMessage());
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in RegisteringDevice() due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public boolean clickOnAddCustomRoomName() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddRoomNameButton");
	}

	public boolean clickOnDoneButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
	}

	public boolean clickOnSkipTurnOffFlightMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SkipTurningOffFlightModeButton",
				"Skip Turning off flight mode successfully");
	}

	public boolean clickOnSkipRebeatesButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SkipButton", "Skip Rebeates successfully");
	}

	public boolean clickOnNotNowButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NotNowButton");
	}

	public boolean clickOnErrorPopUpDeleteOkButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ErrorPopUpDeleteOkButton");
	}

	public boolean clickOnPopUpOkButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "PopUpOkButton");
	}

	public boolean clickOnAcceptResideoProInvitation() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AcceptResideoProInvitation");
	}

	public boolean clickOnSetUpBtn(String deviceName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[@text='" + deviceName + "']/following-sibling::android.widget.Button");
		else if (testCase.getPlatform().toUpperCase().contains("IOS"))
			return MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeStaticText[@value='" + deviceName
					+ "']/following-sibling::XCUIElementTypeButton");
		else
			return false;
	}

	public boolean clickOnUseWifiInsteadBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "UseWifiInsteadBtn");
	}

	public boolean clickOnOpenWiFiSettingBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OpenWiFiSettingBtn");
	}

	public boolean clickOnCaspianValveAvailableInList() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@text,'" + SystemState.getStatus().getTstatName() + "')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'" + SystemState.getStatus().getTstatName() + "')]");
		}

	}

	public boolean isThermostatAvailableInList() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@text,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 3);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@name,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 3);
		}

	}

	public boolean clickOnThermostat_List_macID(String macID) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'" + macID + "')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + macID + "')]");
		}
	}

	public boolean isThermostatAvailableInList(String macID) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'" + macID + "')]", testCase, 3);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + macID + "')]", testCase, 3);
		}
	}

	public boolean clickOnThermostat_List() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@text,'" + SystemState.getStatus().getTstatName() + "')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[contains(@name,'" + SystemState.getStatus().getTstatName() + "')]");
		}

	}

	public String getResideoProMacId_ble() {
		String macID = StatCommands.getInstance().cattCommandsStub
				.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();

		String finalMac = "";
		String[] arrayMacID = macID.split("(?<=\\G.{2})");

		for (int i = 0; i < arrayMacID.length; i++) {
			if (i == 0) {
				finalMac = finalMac + arrayMacID[i];
//			} else if (i > array.length) {
//				String string = array[i];
//				System.out.println(string);
//				de = de + array[i];
			} else {
				finalMac = finalMac + ":" + arrayMacID[i];
			}
		}

		System.out.println(finalMac);

		return finalMac;
//		return macID.substring(6, 12);

	}

	public boolean clickOnYesBleButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "YesBleButton");
	}

	public boolean clickOnAddThermsotatGetStartedButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AddThermsotatGetStartedButton");
	}

	public boolean clickOnLanguageEnglish() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LanguageEnglish");
	}

	public boolean clickOn12HrOption() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "12HrOption");
	}

	public boolean clickOn24HrOption() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "24HrOption");
	}

	// public boolean clickOn() {
//	return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//}
//	public boolean clickOn() {
//	return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//}
//	public boolean clickOn() {
//	return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//}
//	public boolean clickOn() {
//	return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//}

	public boolean getAllAvailableWifiName() {
		try {
			ArrayList<String> wifilist = new ArrayList<String>();
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

				if (MobileUtils.isMobElementExists("XPATH", "//*[contains(@resource-id,'list_item_display_text')]",
						testCase, 1)) {
					List<WebElement> wifinameButton = MobileUtils.getMobElements(testCase, "XPATH",
							"//*[contains(@resource-id,'list_item_display_text')]");

					for (WebElement webElement : wifinameButton) {
						String wifiName = webElement.getDomAttribute("text");
						wifilist.add(wifiName);
					}
					Keyword.ReportStep_Pass(testCase, "List of Available wifi" + wifilist);
				}

			} else {
				if (MobileUtils.isMobElementExists("XPATH",
						"//XCUIElementTypeCollectionView/XCUIElementTypeCell /XCUIElementTypeStaticText", testCase,
						1)) {
					List<WebElement> wifinameButton = MobileUtils.getMobElements(testCase, "XPATH",
							"//XCUIElementTypeCollectionView/XCUIElementTypeCell /XCUIElementTypeStaticText");

					for (WebElement webElement : wifinameButton) {
						String wifiName = webElement.getDomAttribute("name");
						wifilist.add(wifiName);
					}
					Keyword.ReportStep_Pass(testCase, "List of Available wifi" + wifilist);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAddThermostatResideoAPP() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsAddThermostatResideoAPP", 3);
	}

	public boolean isExpectedWifiForWacMode() {
		String device = null;
		;
		try {
			device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
		}
		return MobileUtils.isMobElementExists("NAME", device, testCase, 1);
	}

	public boolean isTheThermostatOnWall() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatonWall");
	}

	public String diyScreenNavigation() {
		String screenName = null;
		String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();
		if (pgsrc.contains("ADD THERMOSTAT") && pgsrc.contains("ADD YOUR THERMOSTAT TO THE RESIDEO APP")
				&& pgsrc.contains("GET STARTED")) {
			screenName = "resideo app 3 step";
		} else if (pgsrc.contains("IS THE THERMOSTAT ON THE WALL") && pgsrc.contains("YES") && pgsrc.contains("NO")) {
			screenName = "thermostat on wall";
		} else if (pgsrc
				.contains("IS YOUR THERMOSTAT DISPLAYING THE MESSAGE USE APP WITH BLINKING BLUETOOTH AND WI-FI ICONS")
				&& pgsrc.contains("YES") && pgsrc.contains("NO")) {
			screenName = "thermostat displaying use app";
		} else if (pgsrc.contains("CHOOSE LOCATION") && pgsrc.contains("CANCEL")
				&& pgsrc.contains("CREATE NEW LOCATION")) {
			screenName = "select location";
		} else if (pgsrc.contains("SELECT ROOM") && pgsrc.contains("WHERE IS YOUR THERMOSTAT LOCATED")) {
			screenName = "select room";
		} else if (pgsrc.contains("IS IT DISPLAYING A TEMPERATURE") && pgsrc.contains("YES") && pgsrc.contains("NO")
				&& pgsrc.contains("CANCEL") && pgsrc.contains("INSTALLATION")) {
			screenName = "displaying thermostat";
		} else if (pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING A NETWORK NAME LIKE THE EXAMPLE BELOW")
				&& pgsrc.contains("YES") && pgsrc.contains("NO") && pgsrc.contains("CANCEL")
				&& pgsrc.contains("INSTALLATION") && !pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING BLE AT THE TOP")
				&& !pgsrc.contains("PRESS AND HOLD THE THERMOSTAT NETWORK NAME FOR 5 SECONDS")
				&& !(pgsrc.contains("CONNECT TO THE THERMOSTAT WI-FI NETWORK")
						|| pgsrc.contains("CONNECT TO YOUR THERMOSTAT'S WI-FI NETWORK"))) {
			screenName = "displaying network name";
		} else if (pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING BLE AT THE TOP") && pgsrc.contains("YES")
				&& pgsrc.contains("NO") && pgsrc.contains("CANCEL") && pgsrc.contains("INSTALLATION")) {
			screenName = "displaying ble";
		} else if (pgsrc.contains("CONNECT") && pgsrc.contains("NEXT") && pgsrc.contains("CANCEL")
				&& pgsrc.contains("PRESS AND HOLD THE THERMOSTAT NETWORK NAME FOR 5 SECONDS")) {
			screenName = "enable ap mode";
		} else if (pgsrc.contains("CONNECT") && (pgsrc.contains("CANCEL") || pgsrc.contains("NEXT"))
				&& (pgsrc.contains("CONNECT TO THE THERMOSTAT WI-FI NETWORK")
						|| pgsrc.contains("CONNECT TO YOUR THERMOSTAT'S WI-FI NETWORK"))) {
			screenName = "connect to thermostat network";
		} else if (pgsrc.contains("START THERMOSTAT NETWORK")
				&& pgsrc.contains(
						"PRESS THE CENTER TEMPERATURE ON YOUR THERMOSTAT FOR 5 SECONDS UNTIL YOU SEE LYRIC OR TSTAT")
				&& pgsrc.contains("INSTALLATION") && pgsrc.contains("CANCEL")) {
			screenName = "start thermostat network";
		} else if (pgsrc.contains("LOCAL NETWORK") && pgsrc.contains("IOS SETTINGS")
				&& pgsrc.contains("I HAVE ENABLED LOCAL NETWORK")
				&& pgsrc.contains("SEARCHING FOR DEVICES REQUIRES LOCAL NETWORK PERMISSIONS")) {
			screenName = "local network permission";
		} else if (pgsrc.contains("TURN ON PRECISE LOCATION") && pgsrc.contains("TURN ON LOCATION")
				&& pgsrc.contains("NOT NOW")) {
			screenName = "turn on location";
		} else if (pgsrc.contains("HAS THE WIRELESS RECEIVER BOX AND THERMOSTAT BEEN INSTALLED")
				&& pgsrc.contains("YES") && pgsrc.contains("NO") && pgsrc.contains("CANCEL")
				&& pgsrc.contains("INSTALLATION")) {
			screenName = "thermostat on wall";
		} else if (pgsrc.contains("CONTINUE WITH FULL SETUP") && pgsrc.contains("CANCEL")
				&& pgsrc.contains("CONFIRM")) {
			screenName = "continue with full setup";
		} else if (pgsrc.contains("ARE YOU A PROFESSIONAL CONTRACTOR") && pgsrc.contains("YES") && pgsrc.contains("NO")
				&& pgsrc.contains("CANCEL")) {
			screenName = "are you contractor";
//            } else if (pgsrc.contains("") && pgsrc.contains("") && pgsrc.contains("") && pgsrc.contains("")) {
		} else {
			screenName = "unknown";
		}
		return screenName;
	}

	public boolean isExpectedScreen_DIY(String expectScreen) {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(30));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					String screenNavigation = diyScreenNavigation();
					if (screenNavigation.equals(expectScreen)) {
						return true;
					} else {
						System.out.println(
								"Expected screen::" + expectScreen + " , Current screen :: " + screenNavigation);
						return false;
					}
				}
			});
			return success;
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 30 seconds" + e.getLocalizedMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public boolean isTheThermostatInstalled_NA_EMEA() {
		boolean flag = false;
		try {
			String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
			if (device.toUpperCase().contains("JASPER_SENIOR_NA") || device.toUpperCase().contains("HOUDINI")) {
				if (isTheThermostatOnWall()) {
					HomeUtils.printLogforSteps(testCase, true, "Is the Thermostat on the wall Screen ?");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, 0,
							"In App not in exact screen. Expected screen is: Is Thermostat on Wall? ");
					flag = false;
				}
//					else {
//					Keyword.ReportStep_Fail(testCase, 0,
//							"In App not in exact screen. Expected screen is: Is Thermostat on Wall? ");
//					flag = false;
//				}
//else {
//					Keyword.ReportStep_Fail(testCase, 0,
//							"In App not in exact screen. Expected screen is: Is Thermostat on Wall? ");
//					flag = false;
//				}

			} else if (device.toUpperCase().contains("JASPER_SENIOR_EMEA")) {

				if (isWirelessReceiverBoxInstalled()) {
					HomeUtils.printLogforSteps(testCase, true, "Is the Thermostat on the wall Screen ?");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Has the wireless receiver box and thermostat been installed screen not visible");
					flag = false;
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, 0,
						"User expected device not in Jasper Family or check the Project specifi Device Under test list for Device names, User requested device name is "
								+ device);

			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, 0,
					"Exception occured in isTheThermostatInstalled_NA_EMEA() due to " + e.getMessage());
		}
		return flag;
	}

	public boolean isThermostatDisplayingTemperature() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DisplayingThermostat");
	}

	public boolean isUSEAPPScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsUSEAPPScreen");
	}

	public boolean isStartThermostatNetwork() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "StartThermostatNetwork");
	}

	public boolean isConnectTotheThermostatWiFiNetwork(int timeOut) {
		return MobileUtils.isMobElementExists("NAME", "Connect to the thermostat Wi-Fi network", testCase, timeOut)
				|| MobileUtils.isMobElementExists("NAME", "iOS Settings", testCase, timeOut);
	}

	public boolean isSkipTurnOffFlightMode() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SkipTurningOffFlightModeButton", 1);
	}

	public boolean isExpectedDeviceIsVisibleInList(int timout) {
		try {
			String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim();
			switch (device) {
			case "JASPER_SENIOR_NA_TRADE": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T6ProWifiThermostat", timout);
			}
			case "JASPER_SENIOR_NA_RETAIL": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T5WifiThermostat", timout);
			}
			case "JASPER_SENIOR_EMEA_WIRED": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T6WiredThermostat", timout);
			}
			case "JASPER_SENIOR_EMEA_WIRELESS": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T6RWirelessThermostat", timout);
			}
			case "THOR_TRADE": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9orT10Pro", timout);
			}
			case "THOR_RETAIL": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9orT10Pro", timout);
			}
			case "FLYCATCHER_TRADE": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9orT10Pro", timout);
			}
			case "FLYCATCHER_RETAIL": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9orT10Pro", timout);
			}
			case "CASPIAN": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "L5LeakProtectionValve", timout);
			}
			case "WATER_LEAK_DETECTOR": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "WiFiWaterLeakAndFreezeDetector",
						timout);
			}
			case "HOUDINI_TRADE": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "HoudiniTrade", 1);
			}
			case "HOUDINI_RETAIL": {
				return MobileUtils.isMobElementExists(objectDefinition, testCase, "HoudiniRetail", 1);
			}
			default: {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Invalid Device for Registration " + device);
				return false;
			}

			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Keyword step : Exception raised : " + e.getMessage());
			return false;
		}
	}

	public String getDeviceNameForIos() {
		try {
			String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim();
			switch (device) {
			case "JASPER_SENIOR_NA_TRADE": {
				return "T6 Pro Wi-Fi Thermostat";
			}
			case "JASPER_SENIOR_NA_RETAIL": {
				return "T5 Wi-Fi Thermostat";
			}
			case "JASPER_SENIOR_EMEA_WIRED": {
				return "T6 Wired Thermostat";
			}
			case "JASPER_SENIOR_EMEA_WIRELESS": {
				return "T6R Wireless Thermostat";
			}
			case "FLYCATCHER_TRADE":
			case "FLYCATCHER_RETAIL":
			case "FLYCATCHER": {
				return "T9 or T10 / T10+ Pro Wi-Fi Thermostat";
			}
			case "THOR_TRADE":
			case "THOR_RETAIL":
			case "THOR": {
				return "T9 or T10 / T10+ Pro Wi-Fi Thermostat";
			}
			case "CASPIAN": {
				return "L5 Wi-Fi Water Leak Shutoff Valve";
			}
			case "HOUDINI_TRADE": {
				return "Focus Pro 7000";
			}
			case "HOUDINI_RETAIL": {
				return "Focus Pro";
			}
			case "WATER_LEAK_DETECTOR": {
				return "Wi-Fi Water Leak and Freeze Detector";
			}
			default: {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Invalid Device for Registration " + device);
				return "";
			}

			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Keyword step : Exception raised : " + e.getMessage());
			return null;
		}
	}

	public boolean isWifiConnectionWasSuccessfull(TestCases testCase) {
//		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofMinutes(5));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {

					String source = testCase.getMobileDriver().getPageSource();
					if (source.contains("com.resideo.android.lyric:id/progressBar")) {
						Keyword.ReportStep_Pass(testCase, "Connecting to Wifi.........");
						return false;
					} else if (source.contains("Connect to device")) {
						MobileUtils.clickOnElement(testCase, "XPATH", "//*[@resource-id='android:id/button1']");
						return false;
					} else if (source.contains("Please connect try again.") && source.contains("SETTINGS")) {
						// went to please tryagain cick on settings
						if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
							Keyword.ReportStep_Fail(testCase, FailType.NO_FAILURE,
									"Please Tryagain occured , connecting to Thermostat Wifi again for wifi configuration");
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@resource-id='android:id/button1']");
							if (connectWithThermostatWifiOnAndroid(SystemState.getStatus().getTstatName())) {
								Keyword.ReportStep_Pass(testCase, "connected to thermostat Wifi back");
								return false;
							}
							return false;
						} else {
							connectWithThermostatWifiOnAndroid(SystemState.getStatus().getTstatName());
							return false;
						}
					} else if (isChooseLocationTitleVisible(1)) {
						Keyword.ReportStep_Pass(testCase, "Connection with WiFi is successful.");
						return true;
					} else if (isFinishedScreenVisible(1)) {
						Keyword.ReportStep_Pass(testCase, "Connection with WiFi is successful.");
						return true;
					} else
						return false;
				} catch (Exception e) {
					System.out.println("Exception raied while waiting for connect to WiFi : " + e.getMessage());
					return false;
				}
			}
		});

		return isEventReceived;

	}

	public boolean isChooseLocationScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ChooseLocationScreen", 300);
	}

	public boolean isCongratulationScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CongratulationScreen");
	}

	public boolean isRebatesDRScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FindRebatesScreen", 1);
	}

	public boolean isEnableGeofenceScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isEnableGeofenceScreen", 1);
	}

	public boolean isTurnOffFlightMode() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SkipTurningOffFlightModeScreen", 1);
	}

	public boolean isSucessIsVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SuccessHHConnected", 1);
	}

	public boolean isDeviceregisterScreen() {
		return MobileUtils.isMobElementExists("NAME",
				"Your L5 Leak Protection Valve is now configured and added to your account.", testCase, 3);
	}

	public boolean isConnectingToHoneywellHome(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToHoneywellHome", timeout);
	}

	public boolean isChooseYourThermostatName() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NameYourThermostatNameScreen", 1);
	}

	public boolean IsChooseNameScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsChooseNameScreen", 1);
	}

	public boolean isExpectedLocationIsListed(String LocationName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[@text='" + LocationName + "']", testCase);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[@name='" + LocationName + "']", testCase);
		}
	}

	public boolean isChooseLocationTitleVisible(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ChooseLocationHeader", timeout);
	}

	public boolean isFinishedScreenVisible(int timeOut) {
		return MobileUtils.isMobElementExists("xpath", "//*[@text='Finished' or @text='FINISHED']", testCase);
	}

	public boolean isOutDoorSensorScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutDoorSensorScreen", 20);
	}

	public boolean isHeatingSystemScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingSystemScreen", 20);
	}

	public boolean isFuelSourceScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FuelSourceScreen", 20);
	}

	public boolean isCoolingStageScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolingStageScreen", 20);
	}

	public boolean isHeatingStageScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingStageScreen", 20);
	}

	public boolean isReversingValveScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ReversingValveScreen", 20);
	}

	public boolean isCompressorStageScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorStageScreen", 20);
	}

	public boolean isAuxETerminalControlScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AuxETerminalControlScreen", 20);
	}

	public boolean isBackUpHeatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackUpHeatScreen", 20);
	}

	public boolean isEmergencyHeatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatScreen", 20);
	}

	public boolean isExternalFossilFuelKitScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExternalFossilFuelKitScreen", 20);
	}

	public boolean isOutdoorHeatLockout() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutdoorHeatLockout", 20);
	}

	public boolean isCompressorCyclePerHourStage1Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage1Screen", 20);
	}

	public boolean isBackupHeatDroopScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatDroopScreen", 20);
	}

	public boolean isCompressorLockoutScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorLockoutScreen", 20);
	}

	public boolean isBackupHeatUpStageTimerScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatUpStageTimerScreen", 20);
	}

	public boolean isCompressorCyclePerHourStage2Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage2Screen", 20);
	}

	public boolean isFanOperationinHeatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanOperationinHeatScreen", 20);
	}

	public boolean isBackupHeatCyclesPerHourScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatCyclesPerHourScreen", 20);
	}

	public boolean isIndoorSensorScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorSensorScreen", 20);
	}

	public boolean isIndoorSensorTypeScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorSensorTypeScreen", 20);
	}

	public boolean isTemperatureSensorSelectionScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "TemperatureSensorSelectionScreen", 20);
	}

	public boolean isLanguageScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsLanguageScreen", 20);
	}

	public boolean isClockFormatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsClockFormatScreen", 20);
	}

	public boolean isTempratureFormat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsTemprtatureFormatScreen", 20);
	}

	public boolean is_C_WireAdapter() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CWireAdapterScreen", 20);
	}

	public boolean isVentilationTypeScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationTypeScreen", 20);
	}

	public boolean isVentilationControlMethodScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationControlMethodScreen", 20);
	}

	public boolean isVentilationFanControlScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationFanControlScreen", 20);
	}

	public boolean isNumberofBedroomScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "NumberofBedroomScreen", 20);
	}

	public boolean isVentilationRateScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationRateScreen", 20);
	}

	public boolean isVentilationPriorityScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationPriorityScreen", 20);
	}

	public boolean isBackUpHeatStagesScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackUpHeatStagesScreen", 20);
	}

	public boolean isEmergencyHeatCyclesPerHourScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatCyclesPerHourScreen", 20);
	}

//	public boolean isConfigurationSummary(int timeout) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfigurationSummary", timeout);
//	}

	public boolean isConfigurationSummary() {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofSeconds(80));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String pageScr = testCase.getMobileDriver().getPageSource().toUpperCase();
						if (pageScr.contains("Confirm Configuration".toUpperCase())
								|| pageScr.contains("Configuration Summary".toUpperCase())) {
							Keyword.ReportStep_Pass(testCase, "Confirm ISU configuration visible");
							return true;
						} else {
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Exception Raised. Exception is " + e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Confirm ISU Configuration failed");
			flag = false;
		}
		return flag;
	}

	public boolean isConfigurationComplete() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfigurationComplete", 15);
	}

	public boolean isEnsure24GHZNetworkPopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Ensure24GHZNetworkPopUp", 20);
	}

	public boolean isEnsure24GHZNetworkPopUp(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Ensure24GHZNetworkPopUp", timeOut);
	}

	public boolean isChooseaNetworkToConnectyourThermostatScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase,
				"ChooseaNetworkToConnectyourThermostatScreen");
	}

	public boolean isexpectedwifiNetworkPresent(String wifiName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//android.widget.TextView[@text='" + wifiName + "']",
					testCase, 2);

		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[@name='" + wifiName + "']", testCase, 2);
		}
	}

	public boolean isWifiAlreadyConfigured() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@text,'Your Thermostat is already connected') or contains(@text,'Your thermostat is already connected') or contains(@text,'your thermostat is already connected')]",
					testCase, 2);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@name,'Your Thermostat is already connected') or contains(@name,'Your thermostat is already connected') or contains(@name,'your thermostat is already connected')]",
					testCase, 2);
		}
	}

	public boolean isWifiConfiguredExact_Wifi(String wifiName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'" + wifiName + "')]", testCase, 2);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + wifiName + "')]", testCase, 2);
		}
	}

	public boolean clickOnWifiConfiguredYesButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "WifiConfiguredYesButton");
	}
	
	public boolean clickOnWifiConfiguredNoButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "WifiConfiguredNoButton");
	}
	
	public boolean isThermostatLocationScreenVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}

	public boolean isCoolCyclesPerHourStage1Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage1Screen");
	}

	public boolean isCoolCyclesPerHourStage2Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage2Screen");
	}

	public boolean isHeatCyclePerHourStage1Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage1Screen");
	}

	public boolean isHeatCyclePerHourStage2Screen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage2Screen");
	}

	public boolean isIsWelcomeToYourNewThermostatscreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsWelcomeToYourNewThermostatscreen");
	}

	public boolean isDeleteThermostatDeleteLoadingPopup(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDeleteThermostatDeleteLoadingPopup",
				timeout);
	}

	public boolean isDeleteThermostatDeleteLoadingPopup() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDeleteThermostatDeleteLoadingPopup", 1);
	}

	public boolean isDeleteThermostatDeleteErrorPopup() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isDeleteThermostatDeleteErrorPopup", 1);
	}

	public boolean isisNoL5LeakProtectionVlaveFoundPopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isNoL5LeakProtectionVlaveFoundPopUp");
	}

	public boolean isPrepareValveToConnectScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isPrepareValveToConnectScreen", 6);
	}

	public boolean isLookingForValveProgressBar() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsLookingForValveProgressBar");
	}

	public boolean isSelectFirstDeviceNameInAvailableList() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectFirstDeviceNameInAvailableList", 1);
	}

	public boolean isProInvitation() {
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(10));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageScr = testCase.getMobileDriver().getPageSource().toUpperCase();
					if (pageScr.contains("PRO INVITATION")) {
						Keyword.ReportStep_Pass(testCase, "Installer Invitation is Displayed");
						return true;
					} else {
						return false;
					}
				} catch (TimeoutException e) {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Exception Raised. Exception is " + e.getMessage());
					return false;
				}
			}
		});

		return isEventReceived;

	}

	public boolean IsBleIsON() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsBleIsON");
	}

	public boolean isConnectedToThermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsConnectedToThermostat", 20);
	}

	public boolean isThermostatConnectedToYourPhone(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsThermostatConnectedToPhoneScreen",
				timeout);
	}

	public boolean isAnswerAFewQuestionToConfigure(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsAnswerAFewQuestionToConfigure", timeout);
	}

	public boolean is() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}

	public boolean isWirelessReceiverBoxInstalled() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsWirelessReceiverBoxInstalled", 3);
	}

	public boolean isAddRoomNameButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AddRoomNameButton", 1);
	}
//	
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}

	public boolean isZipCode() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsZipCode", 10);
	}

	public boolean clickOnBackButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackButton");
	}

	public boolean isInvitationFromResideoPro(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsInvitationFromResideoPro", timeOut);
	}

	public boolean isDeviceDetected(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeviceDetectedLable", timeout);
	}

	public boolean isMorethanOneDeviceDetected(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "MultipleDeviceDetectedLable", timeout);
	}

	public boolean isPreparingToAddLableVisible(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "PreparingToAddDevice", timeout);
	}

	public boolean isThermostatready(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsStatReadyLable", timeout);
	}

	public boolean isYesBtnVisible(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "YesButton", timeout);
	}

	public boolean isYesTheyMatchBtnVisible(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "YesTheyMatchBtn", timeout);
	}

	public boolean isUnableToDetectDevice(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "UnableToFindStatLable", timeout);
	}

	public boolean isSetUpBtnVisibleForDevice(String deviceName, int timeout) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@text='" + deviceName + "']/following-sibling::android.widget.Button", testCase, timeout);
		else if (testCase.getPlatform().toUpperCase().contains("IOS"))
			return MobileUtils.isMobElementExists("XPATH",
					"//XCUIElementTypeStaticText[@value='" + deviceName + "']/following-sibling::XCUIElementTypeButton",
					testCase, timeout);
		else
			return false;
	}

	public boolean isPinLayoutisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "4DigitPinScreen", 80);
	}

	public boolean isHoudini_4Digit_PinLayoutisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "Houdini4DigitPinScreen", 80);
	}

	public boolean isPinLayoutisPresent_flycathcer(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "PinConfigurationScreenForFlycatcher",
				timeout);
	}

	public boolean isConnectWithTheValveScreen(int timeout) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "isConnectWithTheValveScreen", timeout);
	}

	public boolean isUseWifiInsteadBtn() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "UseWifiInsteadBtn", 2);
	}

	public boolean isCaspianValveAvailableInList() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@text,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 3);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@name,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 3);
		}

	}

	public boolean isOpenWiFiSettingBtn(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OpenWiFiSettingBtn", timeOut);
	}

	public boolean isConnectToValveScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsConnectToValveScreen", 3);

	}

	public boolean isConnectToValveSucess(DIYScreen diy) {
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(120));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageSource = testCase.getMobileDriver().getPageSource();
					if (pageSource.toUpperCase()
							.contains("L5 Wi-Fi Water Leak Shutoff Valve is connected to your phone".toUpperCase())) {
						return true;
					} else {
						System.out.println("Trying to Connect with valve");
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to " + e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived) {
			Keyword.ReportStep_Pass(testCase,
					"Sucessfully L5 Wi-Fi Water Leak Shutoff Valve is connected to your phone");
			return true;

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to conenct with L5 Leak Protection valve");
			return false;
		}
	}

	public boolean isConnectingCaspainToWifi() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@text,'Connecting L5 Leak Protection Valve to Wi-Fi')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@name,'Connecting " + SystemState.getStatus().getTstatName() + " to Wi-Fi')]",
					testCase, 1);
		}

	}

	public boolean isRegisteringCaspianDeviceSpinner() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Registering Device')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Registering device')]", testCase, 1);
		}
	}

	public boolean isL5ValveConnectedWithWifiAndRegisteredSucessfully() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@text,'Your L5 Leak Protection Valve is now configured and added to your account')]",
					testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@name,'Your L5 Leak Protection Valve is now configured and added to your account')]",
					testCase, 1);
		}
	}

	public boolean isCommunicationErrorInCaspian() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@text,'Communication Error')]", testCase, 1);
		} else {
			return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'Communication Error')]", testCase, 1);
		}
	}

	public boolean isWifiReconfigurationInAndroid() {
		boolean flag = false;
		String source = testCase.getMobileDriver().getPageSource();
		if (source.contains("Connect to device")) {
			if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Connect']", testCase, 1)) {
				MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Connect']");
				flag = true;
			}
		} else if (source.contains("Try again")) {
			MobileUtils.clickOnElement(testCase, "ID", "button2");
			flag = true;
		} else if (source.contains("Something came up")) {
			MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
			flag = true;
		} else if (source.contains("Couldn't connect. Check your network connection and try again.")) {
			MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
			flag = true;
		} else if (source.contains("SETTINGS")) {
			MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='SETTINGS']");
			connectWithThermostatWifiOnAndroidWithAfterCredential(SystemState.getStatus().getTstatName(),
					"Connecting L5 Leak Protection Valve to Wi-Fi");
			flag = true;
		}
		return flag;
	}

//	public boolean isCommunicationError() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//		
//	}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//		
//	}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//		
//	}

//	public boolean 

}
