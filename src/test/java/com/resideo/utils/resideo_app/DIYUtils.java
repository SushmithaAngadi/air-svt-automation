package com.resideo.utils.resideo_app;

import java.time.Duration;
import java.util.HashMap;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.keywords.app.diy_common.ThermostatLocationName;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.relay.RelayConfiguration;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.resideo_app.screen.WireSenseDIYScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg.PairingPinMode;

import com.resideo.commons.mobile.W3CTouchActions;

public class DIYUtils {
//WiFiNegativeScenario.feature   Jasper_Senior_DIY.feature
	private static String getMessagefromWacMode = null;
	private static boolean isWacModeSucess = false;

	public static void setwacModeWifiMessage(String message) {
		getMessagefromWacMode = message;
	}

	public static String getWacModeWifiMessage() {
		return getMessagefromWacMode;
	}

	public static void setisWacModeSucess(boolean message) {
		isWacModeSucess = message;
	}

	public static boolean getisWacModeSucess() {
		return isWacModeSucess;
	}

	public static boolean iOS_scrollTable_ToCell(TestCases testCase, String label) {
		if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeTable", testCase, 20)) {
			try {
				CustomDriver mobileDriver = testCase.getMobileDriver();
				RemoteWebElement parent = (RemoteWebElement) mobileDriver.findElement(By.className("XCUIElementTypeTable")); // identifying
																											// the
																											// parent
																											// Table
				String parentID = parent.getId();
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("element", parentID);

				// Use the predicate that provides the value of the label attribute

				scrollObject.put("predicateString", "label == '" + label + "'");
				mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
				return true;
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Exception Occured in iOS_scrollText_ByPredicateString(TestCases testCase, By by, String label):: "
								+ e);
				return false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to see List of devices in add new device");
			return false;
		}

	}

	public static boolean iOS_scrollTable_ToCell(TestCases testCase, String elementName, String label) {
		try {
			CustomDriver mobileDriver = testCase.getMobileDriver();
			RemoteWebElement parent = (RemoteWebElement) mobileDriver.findElement(By.className("XCUIElementTypeTable")); // identifying the
																										// parent Table
			String parentID = parent.getId();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", parentID);

			// Use the predicate that provides the value of the label attribute

			scrollObject.put("predicateString", elementName + " == '" + label + "'");
			mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured in iOS_scrollText_ByPredicateString(TestCases testCase, By by, String label):: "
							+ e);
			return false;
		}
	}

	public static boolean iOS_scrollText_ByPredicateString(TestCases testCase, By by, String label) {
		try {
			CustomDriver mobileDriver = testCase.getMobileDriver();
			RemoteWebElement parent = (RemoteWebElement) mobileDriver.findElement(by); // identifying the parent Table
			String parentID = parent.getId();
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("element", parentID);

			// Use the predicate that provides the value of the label attribute

			scrollObject.put("predicateString", label);
			mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured in iOS_scrollText_ByPredicateString(TestCases testCase, By by, String label):: "
							+ e);
			return false;
		}

	}

	@SuppressWarnings("rawtypes")
	public static boolean scrolltoExpectedDeviceforDIY(TestCases testCase, DIYScreen diy) {
		boolean flag = false;

		if (diy.islistOfDeviceAvailable()) {

			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

				Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

				int x = (int) (dimens.getWidth() * 0.5);
				int endY = (int) (dimens.getHeight() * 0.2);
				int startY = (int) (dimens.getHeight() * 0.75);
				for (int i = 0; i <= 3; i++) {

					if (diy.isExpectedDeviceIsVisibleInList(5)) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully Scroll to Expected Device");
						break;
					} else {
						W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(4000));
					}
				}
				if (flag) {

					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
							"Not able to scroll to expected Device");
					flag = false;
				}

			} else {
				flag = iOS_scrollTable_ToCell(testCase, diy.getDeviceNameForIos());
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Device list not visible, may be API performance issue or internet slow");
			flag = false;
		}
		return flag;
	}

	public static boolean changeCountryForDIYIntiate(TestCases testCase, String countryName) {
		boolean flag = false;
		DIYScreen diy = new DIYScreen(testCase);
		flag = diy.clickOnChangeCountry();
		flag = flag && diy.selectCountryOnSearchList(listOfCountryName(testCase, countryName));
		return flag;
	}

	public static String listOfCountryName(TestCases testCase, String countryName) {
		String countryNa = countryName.toUpperCase();
		if (countryNa.contains("UNITED STATE") || countryNa.contains("UNITEDSTATE")
				|| countryNa.contains("UNITED_STATE")) {
			return "United States";
		} else if (countryNa.contains("UNITED KINGDOM") || countryNa.contains("UNITEDKINGDOM")
				|| countryNa.contains("UNITED_KINGDOM")) {
			return "United Kingdom";
		} else if (countryNa.contains("CANADA")) {
			return "Canada";
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Country name not listed, Country name User entered is ::: > " + countryNa);
			return null;
		}
	}

	public static boolean selectdeviceforDIYByUserExpects(TestCases testCase, DIYScreen diy, String device) {
		boolean flag = false;
		try {
//			String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
//					.trim();
			switch (device) {
			case "JASPER_SENIOR_NA_TRADE": {
				flag = diy.selectT6ProWifiThermostat();
				break;
			}
			case "JASPER_SENIOR_NA_RETAIL": {
				flag = diy.selectT5WifiThermostat();
				break;
			}
			case "JASPER_SENIOR_EMEA_WIRED": {
				flag = diy.selectT6WiredThermostat();
				break;
			}
			case "JASPER_SENIOR_EMEA_WIRELESS": {
				flag = diy.selectT6RWirelessThermostat();
				break;
			}
			case "FLYCATCHER_TRADE":
			case "FLYCATCHER_RETAIL":
			case "FLYCATCHER": {
				flag = diy.selectT9orT10Pro();
				break;
			}
			case "CASPIAN": {
				flag = diy.selectL5LeakProtectionValve();
				break;
			}
			case "THOR_TRADE":
			case "THOR_RETAIL":
			case "THOR": {
				flag = diy.selectT9orT10Pro();
				break;
			}
			case "HOUDINI_TRADE": {
				flag = diy.selectHoudini_TradeThermostat();
				break;
			}
			case "HOUDINI_RETAIL": {
				flag = diy.selectHoudini_RetailThermostat();
				break;
			}
			default: {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Invalid Device for Registration : check country, Is device is aplicable in selected country "
								+ device);
				flag = false;
				break;
			}

			}

		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Keyword step : Exception raised : " + e);
		}
		return flag;
	}

	public static String getDeviceNameFromProp(TestCases testCase) {
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
			case "FLYCATCHER": {
				return "T9 or T10 Pro";
			}
			case "THOR": {
				return "T9+ or T10+";
			}
			case "CASPIAN": {
				return "L5 Leak Protection Valve";
			}
			case "WATER_LEAK_DETECTOR": {
				return "Wi-Fi Water Leak and Freeze Detector";
			}
			default: {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Invalid Device for Registration" + device);
				return null;
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Keyword step : Exception raised : " + e.toString());
			return null;
		}
	}

//	public static boolean checkCountryNeedtoChange(TestCases testCase, DIYScreen diy, String device) {
//		boolean flag = false;
//		if (testCase.getPlatform().toUpperCase().contains("ANDROID") && MobileUtils.isMobElementExists("XPATH",
//				"//*[contains(@text,'Allow Honeywell Home to access this device’s location')]", testCase, 1)) {
//			flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'While using the app')]");
//		}
//		String defaultCountrSelected = diy.isexpectDeviceApplicableInDefaultCountry(device);
//
//		if (defaultCountrSelected.equals("Default")) {
//			Keyword.ReportStep_Pass(testCase, "User Prefered country is selected Default");
//			flag = true;
//		} else if (defaultCountrSelected.equals("NonDefault")) {
//			if (diy.clickOnChangeCountry()) {
//				Keyword.ReportStep_Pass(testCase, "Clicked on change country button from list of device screen");
//				if (diy.selectCountryOnSearchList(diy.getCountryNameForInstallFromProjectSpecific())) {
//					Keyword.ReportStep_Pass(testCase, "Country Changed");
//					flag = true;
//				} else {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to select Country");
//					flag = false;
//				}
//
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Country name");
//				flag = false;
//			}
//		} else {
//			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
//					"Invalid Device for Registration : check country, Is device is aplicable on selected country");
//			flag = false;
//		}
//		return flag;
//	}

	public static boolean changeCountry(TestCases testCase, DIYScreen diy, String device) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID") && MobileUtils.isMobElementExists("XPATH",
				"//*[contains(@text,'Allow Honeywell Home to access this device’s location')]", testCase, 1)) {
			flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@text,'While using the app')]");
		}
		try {
			String deviceRegion = SuiteConstants
					.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHOOSE_COUNTRY_DEVICE_NEED_TO_INSTALL")
					.trim();
			boolean isUserCountrySelected = diy.checkCountrySelected(deviceRegion);
			if (!isUserCountrySelected) {
				if (diy.clickOnChangeCountry()) {
					Keyword.ReportStep_Pass(testCase, "Clicked on change country button from list of device screen");
					if (diy.selectCountryOnSearchList(diy.getCountryNameForInstallFromProjectSpecific())) {
						Keyword.ReportStep_Pass(testCase, "Country Changed");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to select Country");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Country name");
					flag = false;
				}
			} else {
				flag = true;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Select country list page should be present but not in expected screen");
		}

		return flag;
	}

	public static boolean performInitialInstallation_Jasper(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		flag = diy.isTheThermostatInstalled_NA_EMEA();
		flag = flag && diy.clickOnYesButton();
		flag = flag && diy.isThermostatDisplayingTemperature();
		HomeUtils.printLogforSteps(testCase, flag, "Is it displaying a temperature Screen ?.,> > ");
		flag = flag && diy.clickOnYesButton();
		flag = flag && diy.isStartThermostatNetwork();
		HomeUtils.printLogforSteps(testCase, flag, "Start Thermostat Network Screen ?.,> > ");
		flag = flag && diy.clickOnNextButtonwithFluent();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = flag && diy.isConnectToYourThermostatWifiNetwork();
			HomeUtils.printLogforSteps(testCase, flag, "Connect to your Thermostat's Wi-Fi Network Screen ?.,> > ");
			flag = flag && diy.clickOnNextButtonwithFluent();
		} else {
			if (diy.isLocalNetworkPopUP()) {
				HomeUtils.printLogforSteps(testCase, flag, "Is Local Network PopUP Screen ?.,");
				flag = flag && diy.clickOnEnableLocalNetwork_iOS(testCase);
				HomeUtils.printLogforSteps(testCase, flag, "Enabled check box for Accept Local Network PopUp ?.,");
				flag = flag && diy.clickOnNextLocalNetwork_iOS();
				if (flag && MobileUtils.isMobElementExists("NAME", "Connect", testCase)) {
					flag = diy.clickOnNextButton("Successfully confirmed Connect screen and clicked on Next Button");
				} else {
					flag = false;
					HomeUtils.printLogforSteps(testCase, flag,
							"Connect Screen is not available after local network accepted");
				}
			} else {
				flag = false;
				HomeUtils.printLogforSteps(testCase, flag, "Not able to find local Network screen for AP Mode");
			}
		}
		return flag;
	}

//	public static boolean performInitialInstallation(TestCases testCase, DIYScreen diy) {
//		boolean flag = false;
//		flag = diy.isTheThermostatInstalled_NA_EMEA();
//		flag = flag && diy.clickOnYesButton();
//		flag = flag && diy.isThermostatDisplayingTemperature();
//		HomeUtils.printLogforSteps(testCase, flag, "Is it displaying a temperature Screen ?.,> > ");
//		flag = flag && diy.clickOnYesButton();
//		flag = flag && diy.isStartThermostatNetwork();
//		HomeUtils.printLogforSteps(testCase, flag, "Start Thermostat Network Screen ?.,> > ");
//		flag = flag && diy.clickOnNextButtonwithFluent();
//		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
//			flag = flag && diy.isConnectToYourThermostatWifiNetwork();
//			HomeUtils.printLogforSteps(testCase, flag, "Connect to your Thermostat's Wi-Fi Network Screen ?.,> > ");
//			flag = flag && diy.clickOnNextButtonwithFluent();
//		} else {
//			if (diy.isLocalNetworkPopUP()) {
//				HomeUtils.printLogforSteps(testCase, flag, "Is Local Network PopUP Screen ?.,");
//				flag = flag && diy.clickOnEnableLocalNetwork_iOS(testCase);
//				HomeUtils.printLogforSteps(testCase, flag, "Enabled check box for Accept Local Network PopUp ?.,");
//				flag = flag && diy.clickOnNextLocalNetwork_iOS();
//				if (flag && MobileUtils.isMobElementExists("NAME", "Connect", testCase)) {
//					flag = diy.clickOnNextButton("Successfully confirmed Connect screen and clicked on Next Button");
//				} else {
//					flag = false;
//					HomeUtils.printLogforSteps(testCase, flag,
//							"Connect Screen is not available after local network accepted");
//				}
//			} else {
//				flag = false;
//				HomeUtils.printLogforSteps(testCase, flag, "Not able to find local Network screen for AP Mode");
//			}
//		}
//		return flag;
//	}

	public static boolean setupThermostat_DIY_Jasper_Houdini_Caspian(TestCases testCase, DIYScreen diy,
			String ble_AP_Mode) {
		boolean flag = false;
		String scrName = diy.diyScreenNavigation();
		if (scrName.contains("resideo app 3 step")) {
			if (diy.clickOnAddThermsotatGetStartedButton()) {
				Keyword.ReportStep_Pass(testCase, "Screen Name is " + scrName + " . clicked on Get started button");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Resideo 3 step instruction visible but not able to click on Get started button");
				flag = false;
			}
			scrName = diy.diyScreenNavigation();
		}

		if (scrName.contains("thermostat on wall")) {
			if (diy.clickOnYesButton()) {
				Keyword.ReportStep_Pass(testCase, "Screen Name is " + scrName + " . clicked on yes button");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"thermostat on wall instruction visible but not able to click on yes button");
				flag = false;
			}
			scrName = diy.diyScreenNavigation();
		}

		if (SystemState.getStatus().isfromStartSetup() && diy.isExpectedScreen_DIY("displaying thermostat")) {
			flag = connectThermostat_broadCastType_from_StartSetup(testCase, diy, ble_AP_Mode);

		} else if (!SystemState.getStatus().isfromStartSetup() && diy.isExpectedScreen_DIY("displaying thermostat")) {

			flag = connectThermostat_broadCastType_from_HomeScreen(testCase, diy, ble_AP_Mode);
		}

		return flag;
	}

	public static boolean connectThermostat_broadCastType_from_StartSetup(TestCases testCase, DIYScreen diy,
			String ble_AP_Mode) {
		boolean flag = false;
		try {
			if (diy.clickOn_NoButton()) {
				Keyword.ReportStep_Pass(testCase,
						"Screen Name:: Is it displaying a temperature?. clicked on No button");
				String deviceModel = SuiteConstants
						.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
						.toUpperCase();
				if (deviceModel.contains("JASPER_SENIOR_NA_TRADE") && diy.isExpectedScreen_DIY("are you contractor")) {
					if (diy.clickOn_NoButton()) {
						if (diy.isExpectedScreen_DIY("continue with full setup")) {
							flag = diy.clickONConfirmContinuewithFullSetup();
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Continue with full setup popup not viisble");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Are you a professional contractor visible but not able to click on No button");
						flag = false;
					}
				}
				if (diy.isExpectedScreen_DIY("displaying network name")) {
					Keyword.ReportStep_Pass(testCase,
							"Screen Name:: Is your thermostat displaying a network name like the example below?. clicked on Yes button");
					if (diy.clickOnYesButton()) {
						if (diy.isExpectedScreen_DIY("displaying ble")) {
							if (ble_AP_Mode.contains("BLE")) {
								if (diy.clickOnYesButton()) {
									Keyword.ReportStep_Pass(testCase,
											"Screen Name:: Is your thermostat displaying bLE at the top?. clicked on Yes button");
									flag = true;
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Is your thermostat displaying bLE at the top? instruction visible but not able to click on yes button");
									flag = false;
								}
							} else {
								if (diy.clickOn_NoBleButton()) {
									Keyword.ReportStep_Pass(testCase,
											"Screen Name:: Is your thermostat displaying bLE at the top?. clicked on No button");
									if (testCase.getPlatform().toUpperCase().contains("IOS")) {
										if (diy.isExpectedScreen_DIY("enable ap mode")) {
											flag = diy.clickOnNextButton();
											if (diy.isExpectedScreen_DIY("connect to thermostat network")) {
												flag = true;
											} else {
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Press and hold the thermostat name for 5 seconds screen is not visible");
												flag = false;
											}
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Press and hold the thermostat name for 5 seconds screen is not visible");
											flag = false;
										}
									} else {
										if (diy.isExpectedScreen_DIY("connect to thermostat network")) {
											flag = diy.clickOnNextButton();
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Press and hold the thermostat name for 5 seconds screen is not visible");
											flag = false;
										}
									}
								} else {
									Keyword.ReportStep_Fail(testCase, 0,
											"unable to click on No button in Ble selection screen");
									flag = false;
								}
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Is your thermostat displaying bLE at the top? not visible");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Is your thermostat displaying a network name like the example below? instruction visible but not able to click on yes button");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Is your thermostat displaying a network name like the example below? not visible");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Is it displaying a temperature? instruction visible but not able to click on No button");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in  connectThermostat_broadCastType_from_StartSetupdue to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean connectThermostat_broadCastType_from_HomeScreen(TestCases testCase, DIYScreen diy,
			String ble_AP_Mode) {
		boolean flag = false;
		if (diy.clickOnYesButton()) {
			if (diy.isExpectedScreen_DIY("start thermostat network")) {
				if (diy.clickOnNextButtonwithFluent()) {

					if (testCase.getPlatform().toUpperCase().contains("IOS")) {
						if (diy.isExpectedScreen_DIY("local network permission")) {
							if (diy.clickOnEnableLocalNetwork_iOS(testCase)) {
								if (diy.clickOnNextLocalNetwork_iOS()) {
									flag = true;
								} else {
									Keyword.ReportStep_Fail(testCase, 0,
											"Not able to click on Next Button from Local network screen");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail(testCase, 0,
										"Local network Screen is available but not able to select radio button");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, 0, "Local network permission Screen is not visible");
							flag = false;
						}
					}
					if (diy.isExpectedScreen_DIY("displaying ble")) {
						if (ble_AP_Mode.contains("BLE")) {
							if (diy.clickOnYesButton()) {
								Keyword.ReportStep_Pass(testCase,
										"Screen Name:: Is your thermostat displaying bLE at the top?. clicked on Yes button");
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Is your thermostat displaying bLE at the top? instruction visible but not able to click on yes button");
								flag = false;
							}
						} else {
							if (diy.clickOn_NoBleButton()) {
								Keyword.ReportStep_Pass(testCase,
										"Screen Name:: Is your thermostat displaying bLE at the top?. clicked on No button");
								if (testCase.getPlatform().toUpperCase().contains("IOS")) {
									if (diy.isExpectedScreen_DIY("enable ap mode")) {
										flag = diy.clickOnNextButton();
										if (diy.isExpectedScreen_DIY("connect to thermostat network")) {
											flag = true;
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Press and hold the thermostat name for 5 seconds screen is not visible");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Press and hold the thermostat name for 5 seconds screen is not visible");
										flag = false;
									}
								} else {
									if (diy.isExpectedScreen_DIY("connect to thermostat network")) {
										flag = diy.clickOnNextButton();
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Press and hold the thermostat name for 5 seconds screen is not visible");
										flag = false;
									}
								}
							} else {
								Keyword.ReportStep_Fail(testCase, 0,
										"unable to click on No button in Ble selection screen");
								flag = false;
							}
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Is your thermostat displaying bLE at the top? not visible");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, 0,
							"Not able to click on Next Button in Press the center temperature on your thermostat for 5 seconds "
									+ "until you see LYRIC or TSTAT appear on the thermostat screen, then tap NEXT to continue.");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Press the center temperature on your thermostat for 5 seconds until you see "
								+ "LYRIC or TSTAT appear on the thermostat screen, then tap NEXT to continue. not visible");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Is it displaying a temperature? instruction visible but not able to click on Yes button");
			flag = false;

		}

		return flag;
	}

	public static boolean performInitialInstallation_Jasper(TestCases testCase, DIYScreen diy, String ble_AP_Mode) {
		boolean flag = false;
		if (diy.isTheThermostatInstalled_NA_EMEA()) {
			if (diy.clickOnYesButton()) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, 0, "Not able to click on yes Button in Thermostat on wall screen .");
				flag = false;
			}
		} else {
			flag = false;
		}

		if (diy.isThermostatDisplayingTemperature()) {
			HomeUtils.printLogforSteps(testCase, true, "Is it displaying a temperature Screen ?.,> > ");
			if (diy.clickOnYesButton()) {
				if (diy.isStartThermostatNetwork()) {
					HomeUtils.printLogforSteps(testCase, true, "Start Thermostat Network Screen ?.,> > ");
					if (diy.clickOnNextButtonwithFluent()) {
						if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
							flag = true;
						} else {
							if (diy.isLocalNetworkPopUP()) {
								HomeUtils.printLogforSteps(testCase, true, "Is Local Network PopUP Screen ?.,");
								if (diy.clickOnEnableLocalNetwork_iOS(testCase)) {
									HomeUtils.printLogforSteps(testCase, true,
											"Enabled check box for Accept Local Network PopUp ?.,");
									if (diy.clickOnNextLocalNetwork_iOS()) {
										flag = true;
									} else {
										Keyword.ReportStep_Fail(testCase, 0,
												"Not able to click on Next Button from Local network screen");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, 0,
											"Local network Screen is available but not able to select radio button");
									flag = false;
								}
							}
						}
						flag = Enter_BroadCast_APP(testCase, diy, ble_AP_Mode);
					} else {
						Keyword.ReportStep_Fail(testCase, 0,
								"Not able to click on Next Button in Start thermostat Network screen .");
						flag = false;
					}
				} else {

					Keyword.ReportStep_Fail(testCase, 0,
							"In App not in exact screen. Expected screen is: Is Start thermostat network ");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, 0,
						"Not able to click on yes Button in Is thermostat displaying temperature .");
				flag = false;
			}
		} else {

			Keyword.ReportStep_Fail(testCase, 0,
					"In App not in exact screen. Expected screen is: Is thermostat Displaying Temperature ");
			flag = false;
		}

//			} else {
//				Keyword.ReportStep_Fail(testCase, 0, "Not able to click on yes Button in Thermostat on wall screen .");
//				flag = false;
//			}
//		} else {
//			flag = false;
//		}

		return flag;
	}

	public static boolean performInitialInstallation_Houdini(TestCases testCase, DIYScreen diy, String ble_AP_Mode) {
		boolean flag = false;
		if (diy.isTheThermostatInstalled_NA_EMEA()) {
			if (diy.clickOnYesButton()) {
				if (diy.isUSEAPPScreen()) {
					HomeUtils.printLogforSteps(testCase, true,
							"Is your thermostat displaying the message USE APP with blinking Bluetooth and Wi-Fi icons?.,> > ");
					if (diy.clickOnYesButton()) {
						Keyword.ReportStep_Pass(testCase, "Mobile deviec started searching BLE Enabled Houdini Devies");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, 0,
								"Not able to click on yes Button in Is thermostat displaying temperature .");
						flag = false;
					}
				} else {

					Keyword.ReportStep_Fail(testCase, 0,
							"In App not in exact screen. Expected screen is: Is thermostat Displaying Temperature ");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, 0, "Not able to click on yes Button in Thermostat on wall screen .");
				flag = false;
			}

		} else {
			flag = false;
		}

		return flag;
	}

	public static boolean Enter_BroadCast_APP(TestCases testCase, DIYScreen diy, String bLE_AP) {
		boolean flag = false;
		System.out.println();
		if (diy.IsBleIsON()) {
			HomeUtils.printLogforSteps(testCase, true, "Is your thermostat displaying bLE at the top?.,> > ");
			if (bLE_AP.contains("BLE")) {
				if (diy.clickOnYesBleButton()) {
					flag = true;
					HomeUtils.printLogforSteps(testCase, true, "Ble yes button clicked");
				} else {

					Keyword.ReportStep_Fail(testCase, 0,
							"Not able to click on Yes Button in Is your thermostat displaying BLE at the top?.,> .");
					flag = false;
				}

			} else {

				if (diy.clickOn_NoBleButton()) {
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						if (diy.isConnectToYourThermostatWifiNetwork()) {
							HomeUtils.printLogforSteps(testCase, true,
									"Connect to your Thermostat's Wi-Fi Network Screen ?.,> > ");
							if (diy.clickOnNextButtonwithFluent()) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, 0,
										"unable to click on Next button in Connect to your thermostat's wifi network screen");
								flag = false;
							}
						} else {

							Keyword.ReportStep_Fail(testCase, 0,
									"Connect to your thermostat wifi network screen is not visible");
							flag = false;
						}

					} else {
						if (MobileUtils.isMobElementExists("NAME", "Connect", testCase)) {
							if (diy.clickOnNextButton(
									"Successfully confirmed Connect screen and clicked on Next Button")) {
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, 0,
										"unable to click on next button in Confirm connect screen");
								flag = false;
							}
						} else {
							flag = false;
							HomeUtils.printLogforSteps(testCase, flag,
									"Connect Screen is not available after local network accepted");
						}
					}
				} else {
					Keyword.ReportStep_Fail(testCase, 0, "unable to click on No button in Ble selection screen");
					flag = false;
				}

			}
		} else {
			Keyword.ReportStep_Fail(testCase, 0,
					"In App not in exact screen. Expected screen is: Is your thermostat displaying BLE on the top? ");
			flag = false;

		}
		return flag;

	}

	public static boolean connectToBle_ExactThermostat(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		String device_UnderTest = null;

		try {
			device_UnderTest = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured in connectToBle_ExactThermostat(TestCases testCase, DIYScreen diy) due to :"
							+ e);
			flag = false;
		}

		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(240));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageSource = testCase.getMobileDriver().getPageSource();
					if (pageSource.toUpperCase().contains("Looking for thermostat".toUpperCase())) {
//						System.out.println("Looking for thermostat ........");
						return false;
					} else if (pageSource.toUpperCase().contains("Pairing to thermostat".toUpperCase())) {
						System.out.println("Pairing to thermostat ........");
						return false;
					} else if (pageSource.toUpperCase().contains("Contacting thermostat".toUpperCase())) {
						System.out.println("Contacting thermostat ........");
						return false;
					} else if (pageSource.toUpperCase().contains("Connected to Thermostat".toUpperCase())) {
						SystemState.getStatus().isSingleDevice(true);
						System.out.println("Connected to Thermostat");
						return true;
					} else if (pageSource.toUpperCase().contains("Enter Code".toUpperCase())) {
						SystemState.getStatus().isSingleDevice(true);
						SystemState.getStatus().isSetupCodeShows(true);
						System.out.println("Connected to Thermostat, its showing to enter code");
						return true;
					} else if (pageSource.toUpperCase().contains("Multiple devices found".toUpperCase())) {
						System.out.println("multiple device found");
						Keyword.ReportStep_Pass(testCase, "Multiple Device Found");
						SystemState.getStatus().isMultipleDevice(true);
						return true;
					} else if (pageSource.toUpperCase().contains("No Thermostat Found".toUpperCase())) {
						System.out.println("No Thermostat Found.....");
						SystemState.getStatus().isDeviceNotFound(true);
						return true;
					} else if (pageSource.toUpperCase().contains("Device Disconnected".toUpperCase())) {
						System.out.println("Device Disconnected.....");
						Keyword.ReportStep_Fail(testCase, 0, "Device Disconnected, shows in app");
						SystemState.getStatus().isDeviceNotFound(true);
						return true;

					} else if (pageSource.toUpperCase().contains("Pairing Failed".toUpperCase())) {
						System.out.println("Pairing Failed.....");
						SystemState.getStatus().isPairingFailed(true);
						return true;
					} else {
//						System.out.println("Device is scanning.........");
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured due to :" + e);
					return false;
				}
			}
		});
		String resideoProMacId_ble = diy.getResideoProMacId_ble();
		String pin = null;
		if (SystemState.getStatus().isSetupCodeShows()) {
//			pin = StatCommands.getInstance().cattCommandsStub
//					.getHoudiniDisplayText(HoudiniDisplayTextMsg.newBuilder()
//							.setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build())
//					.getStrVal().replace(" ", "").trim();
		}

		if (isEventReceived && SystemState.getStatus().isSingleDevice()) {

			if (device_UnderTest.contains("JASPER") && StatCommonCommandUtils.getMulti_textIn_Jasper(testCase,
					"CONNECTING", null, "Thermostat Connected to Mobile")) {
				flag = ConnectWIthBleInAPP(testCase, diy);

			} else if (device_UnderTest.contains("HOUDINI") && LyricUtils.isNumeric(pin)) {
				flag = ConnectWIthBleInAPP_Houdini(testCase, diy, pin);
			} else {
				flag = false;
				String text = null;
				if (device_UnderTest.contains("JASPER")) {
					text = StatCommands.getInstance().cattCommandsStub
							.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
									.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
							.getStrVal();
				} else {
//					text = StatCommands.getInstance().cattCommandsStub.getHoudiniDisplayText(HoudiniDisplayTextMsg
//							.newBuilder().setDisplayArea(HoudiniDisplayArea.VerifiedArea_Multitext).build())
//							.getStrVal();
				}

				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
						"Thermostat not connected to mobile phone, But Mobile shows connected, Thermostat displays "
								+ text);
			}
		} else if (isEventReceived && SystemState.getStatus().isDeviceNotFound()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device not found in BLE mode");
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().isPairingFailed()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Pairing failed between stat and mobile");
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().isMultipleDevice()) {
			if (diy.isThermostatAvailableInList(resideoProMacId_ble)) {
				if (diy.clickOnThermostat_List_macID(resideoProMacId_ble)) {
					Keyword.ReportStep_Pass(testCase, "Sucessfully connected to Tstat from Multiple device screen");
					flag = ConnectWIthBleInAPP(testCase, diy);
				} else {
					Keyword.ReportStep_Fail(testCase, 0,
							"Not able to select exact device from multiple device found screen");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, 0,
						"Not able to find Exact device in list from Multiple deivce screen");
				flag = false;
			}
		}
		return flag;
	}

	public static boolean ConnectWIthBleInAPP(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		if (diy.isConnectedToThermostat()) {

			if (diy.clickOnNextButton("Clicked on Confirgured next button before pin screen")) {

				if (diy.set4_DigitPin()) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, 0,
							"Failed to set 4 digit pin in app side , Need to check in Wifi logs to get more details");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, 0,
						"Failed to click on Next button in connected to thermostat screen");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, 0, "Connected to thermostat screen not availble in app screen");
			flag = false;
		}

		return flag;
	}

	public static boolean ConnectWIthBleInAPP_Houdini(TestCases testCase, DIYScreen diy, String pin) {
		boolean flag = false;
		if (diy.enter_4Digit_pin_Houdini(pin)) {
			if (diy.isThermostatConnectedToYourPhone(60)) {
				if (diy.clickOnNextButton("Thermostat connected with phone")) {
					if (diy.isAnswerAFewQuestionToConfigure(60)) {
						if (diy.clickOnNextButton("Thermostat connected with phone")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, 0, "Not able to click on Next Button");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, 0,
								"Answer a few questions to configure your thermostat screen not visible");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, 0, "Not able to click on Next Button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, 0, "is your thermostat connected to your phone screen not visible");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, 0,
					"Failed to set 4 digit pin in app side , Need to check in Wifi logs to get more details");
			flag = false;
		}
		return flag;
	}

	public static boolean performInstallationFromInstallerInvitation(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = diy.isTheThermostatOnWall();
			HomeUtils.printLogforSteps(testCase, flag, "Is the Thermostat on the wall Screen ?.,> > ");
			flag = flag && diy.clickOnYesButton();
			flag = flag && diy.isThermostatDisplayingTemperature();
			HomeUtils.printLogforSteps(testCase, flag, "Is it displaying a temperature Screen ?.,> > ");
			flag = flag && diy.clickOnYesButton();
			flag = flag && diy.isStartThermostatNetwork();
			HomeUtils.printLogforSteps(testCase, flag, "Start Thermostat Network Screen ?.,> > ");
			flag = flag && diy.clickOnNextButtonwithFluent();
			flag = flag && diy.isConnectToYourThermostatWifiNetwork();
			HomeUtils.printLogforSteps(testCase, flag, "Connect to your Thermostat's Wi-Fi Network Screen ?.,> > ");
			flag = flag && diy.clickOnNextButtonwithFluent();
		} else {

//			Implement for IOS

		}
		return flag;
	}

	public static boolean connectToJasperThermostatWifi(TestCases testCase, TestCaseInputs inputs, DIYScreen diy,
			String TstatName_Wifi) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = diy.connectWithThermostatWifiOnAndroid(TstatName_Wifi);
		} else {
			flag = diy.ConnectToWifiUsingAPMode(inputs);
		}
		if (diy.clickOnNextButton("Clicked on Confirgured next button before pin screen")) {
			if (diy.set4_DigitPin()) {
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to set 4 digit pin");
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"not able click on Confirgured next button before pin screen");
		}
		return flag;
	}

	public static String getjasperThermostatNameForWifiConnect(TestCases testCase, TestCaseInputs inputs) {
		String StatName = null;
		String initialname = null;
		try {
			initialname = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal();

			String macID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();

			if ((initialname != null && initialname.toUpperCase().contains("TSTAT"))
					|| (initialname != null && initialname.toUpperCase().contains("LYRIC"))) {
				String[] initialna = initialname.split(" ");
				String statWord = initialna[0].toUpperCase().charAt(0)
						+ initialna[0].substring(1, initialna[0].length()).toLowerCase();

				String substring = macID.substring(6, 12);
				StatName = statWord + " " + substring;
				Keyword.ReportStep_Pass(testCase, "Broadcasted Thermostat Wi-Fi name is " + StatName);
				System.out.println(StatName);
				SystemState.getStatus().setTstatName(StatName);

				inputs.setInputValue("LOCATION1_DEVICE1_NAME", StatName);
			} else {
				if (initialname.contains("CONNECTING")) {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
							"Thermostat Shows connecting in the screen");
					StatName = null;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
							"Thermostat went to Other state, Thermostat displays " + initialname);
					StatName = null;
				}
			}
		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Message shown in Thermostat " + initialname);
		}
		return StatName;
	}

	public static String get_T9_T10_T10Plus_ThermostatNameForRoom(TestCases testCase) {
		String StatName = null;
		try {
			String macID = "";
			while (macID.contains("00000000") || macID.isEmpty()) {
				Thread.sleep(1000);
				macID = StatCommands.getInstance().cattCommandsStub
						.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();
			}

			if (macID != null && !macID.isEmpty()) {
				String substring = macID.substring(6, 12);
				StatName = "Tstat" + " " + substring;
				Keyword.ReportStep_Pass(testCase, "Device name for T9, T10 pro, T10 plus is " + StatName);
				System.out.println(StatName);
				SystemState.getStatus().setTstatName(StatName.trim());
				testCase.getTestCaseInputs().setInputValue("LOCATION1_DEVICE1_NAME", StatName.trim());
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device mac ID is not available");
			}
		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
		}
		return StatName;
	}

	public static String getDeviceMacID_deviceName_Caspian(TestCases testCase, TestCaseInputs inputs,
			String initalWordForDeviceName) {
		String StatName = null;
		try {
//			String macID = StatCommands.getInstance().cattCommandsStub
//					.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();
//			String macID = "48A2E61D8AEB";
			String macID = "48A2E636B741";
			String substring = macID.substring(6, 12);
			StatName = initalWordForDeviceName + " " + substring;
			Keyword.ReportStep_Pass(testCase, "Broadcasted Thermostat Wi-Fi name is " + StatName);
			System.out.println(StatName);
			SystemState.getStatus().setTstatName(StatName);
			SystemState.getStatus().macIDName(macID);
			inputs.setInputValue("LOCATION1_DEVICE1_NAME", StatName);
		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
		}
		return StatName;
	}

	public static String getDeviceMacID_deviceName_Houdini(TestCases testCase, TestCaseInputs inputs,
			String initalWordForDeviceName) {
		String StatName = null;
		try {

			String macID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();
			String substring = macID.substring(6, 12);
			StatName = initalWordForDeviceName + " " + substring;
			Keyword.ReportStep_Pass(testCase, "Broadcasted Thermostat Wi-Fi name is " + StatName);
			System.out.println(StatName);
			SystemState.getStatus().setTstatName(StatName);
			SystemState.getStatus().macIDName(macID);
			inputs.setInputValue("LOCATION1_DEVICE1_NAME", StatName);
		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
		}
		return StatName;
	}

	public static boolean ISUPerformInDif(DIYScreen diy, String ISUType, String ISUValue) {
		boolean flag = false;
		switch (ISUType.toUpperCase()) {
		case "OUTDOOR AIR SENSOR": {
			flag = diy.ISUOutDoorSensor(ISUValue);
			break;
		}
		case "HEATING SYSTEM": {
			flag = diy.ISUHeatingSystem(ISUValue);
			break;
		}
		case "FUEL SOURCE": {
			flag = diy.ISUFuelSource(ISUValue);
			break;
		}
		case "REVERSING VALVE": {
			flag = diy.ISUReversingValve(ISUValue);
			break;
		}
		case "COMPRESSOR STAGE": {
			flag = diy.ISUCompressorStages(ISUValue);
			break;
		}
		case "COOLING STAGE": {
			flag = diy.ISUCooling_HeatingStages(ISUValue);
			break;
		}
		case "HEATING STAGE": {
			flag = diy.ISUCooling_HeatingStages(ISUValue);
			break;
		}
		case "AUXE TERMINAL CONTROL": {
			flag = diy.ISUAUXPerE_TerminalControl(ISUValue);
			break;
		}
		case "BACKUP HEAT": {
			flag = diy.ISUBackupHeat(ISUValue);
			break;
		}
		case "BACKUP HEAT STAGES": {
			flag = diy.ISUBackUPHeatStages(ISUValue);
			break;
		}
		case "EMERGENCY HEAT": {
			flag = diy.ISUEmergencyHeat(ISUValue);
			break;
		}
		case "BACKUP HEAT UPSTAGE TIMER": {
			flag = diy.ISUBackUpHeatUpStageTimer(ISUValue);
			break;
		}
		case "OUTDOOR HEAT LOCKOUT": {
			flag = diy.ISUOutdoorHeatLockout(ISUValue);
			break;
		}
		case "BACKUP HEAT DROOP": {
			flag = diy.ISUBackUpHeatDroop(ISUValue);
			break;
		}
		case "COMPRESSOR LOCKOUT": {
			flag = diy.ISUCompressorLockout(ISUValue);
			break;
		}
		case "FAN OPERATION IN HEAT": {
			flag = diy.ISUFanOperationInHeat(ISUValue);
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 1": {
			flag = diy.setCyclePerHourForStage(ISUValue);
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 2": {
			flag = diy.setCyclePerHourForStage(ISUValue);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 1": {
			flag = diy.setCyclePerHourForStage(ISUValue);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 2": {
			flag = diy.setCyclePerHourForStage(ISUValue);
			break;
		}
		case "COMPRESSOR CYCLES PER HOUR-STAGE 1": {
			flag = diy.ISUCompressorCyclesPerHour_Stage(ISUValue);
			break;
		}
		case "COMPRESSOR CYCLES PER HOUR-STAGE 2": {
			flag = diy.ISUCompressorCyclesPerHour_Stage(ISUValue);
			break;

		}
		case "BACKUP HEAT CYCLE PER HOUR": {
			flag = diy.ISUBackUpHeatCyclePerHour(ISUValue);
			break;

		}
		case "EMERGENCY HEAT CYCLE PER HOUR": {
			flag = diy.ISUEmergencyHeatCyclePerHour(ISUValue);
			break;

		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			flag = diy.ISUExternalFossilFuelKit(ISUValue);
			break;
		}
		case "INDOOR SENSOR": {
			flag = diy.ISUIndoorSensor(ISUValue);
			break;
		}
		case "INDOOR SENSOR TYPE": {
			flag = diy.ISUIndoorSensorType(ISUValue);
			break;
		}
		case "VENTILATION TYPE": {
			flag = diy.ISUVentilationType(ISUValue);
			break;
		}
		case "VENTILATION CONTROL METHOD": {
			flag = diy.ISUVentilationControlMethod(ISUValue);
			break;
		}
		case "VENTILATION FAN CONTROL": {
			flag = diy.ISUVentilationFanControl(ISUValue);
			break;
		}
		case "TEMPERATURE SENSOR": {
			flag = diy.ISUTemperatureSensorSelection(ISUValue);
			break;
		}
		case "LANGUAGE": {
			flag = diy.ISULanguage(ISUValue);
			break;
		}
		case "CLOCK": {
			flag = diy.ISUClockFormat(ISUValue);
			break;
		}
		case "TEMPERATURE SCALE": {
			flag = diy.ISUTemprtatureFormat(ISUValue);
			break;
		}
		case "C WIRE ADAPTER": {
			flag = diy.ISU_C_WireAdapter(ISUValue);
			break;
		}
		default: {
			flag = false;
			break;
		}

		}

		return flag;
	}

	public static boolean isISUPerformScreen(TestCases testCase, DIYScreen diy, String ISUType) {
		boolean flag = false;
		switch (ISUType.toUpperCase()) {
		case "OUTDOOR AIR SENSOR": {
			flag = diy.isOutDoorSensorScreen();
			break;
		}
		case "HEATING SYSTEM": {
			flag = diy.isHeatingSystemScreen();
			break;
		}
		case "FUEL SOURCE": {
			flag = diy.isFuelSourceScreen();
			break;
		}
		case "REVERSING VALVE": {
			flag = diy.isReversingValveScreen();
			break;
		}
		case "COMPRESSOR STAGE": {
			flag = diy.isCompressorStageScreen();
			break;
		}
		case "COOLING STAGE": {
			flag = diy.isCoolingStageScreen();
			break;
		}
		case "HEATING STAGE": {
			flag = diy.isHeatingStageScreen();
			break;
		}
		case "AUXE TERMINAL CONTROL": {
			flag = diy.isAuxETerminalControlScreen();
			break;
		}
		case "BACKUP HEAT": {
			flag = diy.isBackUpHeatScreen();
			break;
		}
		case "BACKUP HEAT STAGES": {
			flag = diy.isBackUpHeatStagesScreen();
			break;
		}
		case "EMERGENCY HEAT": {
			flag = diy.isEmergencyHeatScreen();
			break;
		}
		case "BACKUP HEAT UPSTAGE TIMER": {
			flag = diy.isBackupHeatUpStageTimerScreen();
			break;
		}
		case "OUTDOOR HEAT LOCKOUT": {
			flag = diy.isOutdoorHeatLockout();
			break;
		}
		case "BACKUP HEAT DROOP": {
			flag = diy.isBackupHeatDroopScreen();
			break;
		}
		case "COMPRESSOR LOCKOUT": {
			flag = diy.isCompressorLockoutScreen();
			break;
		}
		case "FAN OPERATION IN HEAT": {
			flag = diy.isFanOperationinHeatScreen();
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 1": {
			flag = diy.isCoolCyclesPerHourStage1Screen();
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 2": {
			flag = diy.isCoolCyclesPerHourStage2Screen();
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 1": {
			flag = diy.isHeatCyclePerHourStage1Screen();
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 2": {
			flag = diy.isHeatCyclePerHourStage2Screen();
			break;
		}
		case "COMPRESSOR CYCLES PER HOUR-STAGE 1": {
			flag = diy.isCompressorCyclePerHourStage1Screen();
			break;
		}
		case "COMPRESSOR CYCLES PER HOUR-STAGE 2": {
			flag = diy.isCompressorCyclePerHourStage2Screen();
			break;

		}
		case "BACKUP HEAT CYCLE PER HOUR": {
			flag = diy.isBackupHeatCyclesPerHourScreen();
			break;

		}
		case "EMERGENCY HEAT CYCLE PER HOUR": {
			flag = diy.isEmergencyHeatCyclesPerHourScreen();
			break;

		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			flag = diy.isExternalFossilFuelKitScreen();
			break;
		}
		case "INDOOR SENSOR": {
			flag = diy.isIndoorSensorScreen();
			break;
		}
		case "INDOOR SENSOR TYPE": {
			flag = diy.isIndoorSensorTypeScreen();
			break;
		}
		case "VENTILATION TYPE": {
			flag = diy.isVentilationTypeScreen();
			break;
		}
		case "VENTILATION CONTROL METHOD": {
			flag = diy.isVentilationControlMethodScreen();
			break;
		}
		case "VENTILATION FAN CONTROL": {
			flag = diy.isVentilationFanControlScreen();
			break;
		}
		case "TEMPERATURE SENSOR": {
			flag = diy.isTemperatureSensorSelectionScreen();
			break;
		}
		case "LANGUAGE": {
			flag = diy.isLanguageScreen();
			break;
		}
		case "CLOCK": {
			flag = diy.isClockFormatScreen();
			break;
		}
		case "TEMPERATURE SCALE": {
			flag = diy.isTempratureFormat();
			break;
		}
		case "C WIRE ADAPTER": {
			flag = diy.is_C_WireAdapter();
			break;
		}
		default: {
			flag = false;
			break;
		}

		}
		HomeUtils.printLogforSteps(testCase, flag,
				"User should be able to see this ISU Screen >>>" + ISUType + " .  Is User in Prefered Screen >>> ");
		return flag;

	}

	public static String _Do_Action_ThermostatConnectedWithExpectedNetwork(TestCases testCase, DIYScreen diy) {
		String status = "failed";
		try {
			String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			if (diy.isWifiAlreadyConfigured()) {
				if (diy.isWifiConfiguredExact_Wifi(wifiSSID)) {
					Keyword.ReportStep_Pass(testCase, "WIFI configured with expected wifi name as " + wifiSSID);
					if (diy.clickOnWifiConfiguredNoButton()) {
						status = "already configured";
						Keyword.ReportStep_Pass(testCase,
								"Wifi configured but its not same as expeteced, wifi reconfiguration will initiate");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on No button in wifi configured screen");
						status = "failed";
					}
				} else {
					if (diy.clickOnWifiConfiguredYesButton()) {
						status = "change";
						Keyword.ReportStep_Pass(testCase,
								"Wifi configured but its not same as expeteced, wifi reconfiguration will initiate");
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Yes button in wifi configured screen");
						status = "failed";
					}
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Wifi configured screen not visible");
				status = "not configured";
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
			status = "exception";
		}
		return status;
	}

	public static String _Do_Action_ThermostatConnectedWithExpectedNetwork(TestCases testCase, DIYScreen diy,
			boolean isMandatory, boolean isfactoryReset) {
		String status = "failed";
		try {
			String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			if (isfactoryReset) {
				if (diy.isWifiAlreadyConfigured()) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"App showing wifi is configured, but in factory device or fresh device should not have wifi details");
					status = "should not connect with wifi";
				} else {
					Keyword.ReportStep_Pass(testCase, "Wifi configured screen not visible");
					status = "not configured";
				}
			} else {
				if (diy.isWifiAlreadyConfigured()) {
					if (!isMandatory) {
						if (diy.isWifiConfiguredExact_Wifi(wifiSSID)) {
							Keyword.ReportStep_Pass(testCase, "WIFI configured with expected wifi name as " + wifiSSID);
							if (diy.clickOnWifiConfiguredNoButton()) {
								status = "already configured";
								Keyword.ReportStep_Pass(testCase,
										"Wifi configured but it same as expeteced, wifi reconfiguration will not initiate");
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on No button in wifi configured screen");
								status = "failed";
							}
						} else {
							if (diy.clickOnWifiConfiguredYesButton()) {
								status = "change";
								Keyword.ReportStep_Pass(testCase,
										"Wifi configured but its not same as expeteced, wifi reconfiguration will initiate");
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on Yes button in wifi configured screen");
								status = "failed";
							}
						}
					} else {
						if (diy.clickOnWifiConfiguredYesButton()) {
							status = "change";
							Keyword.ReportStep_Pass(testCase,
									"Wifi configured but its not same as expeteced, wifi reconfiguration will initiate");
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Yes button in wifi configured screen");
							status = "failed";
						}
					}

				} else {
					Keyword.ReportStep_Pass(testCase, "Wifi configured screen not visible");
					status = "not configured";
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
			status = "exception";
		}
		return status;
	}

	public static boolean chooseNetworktoConnectYourThermostat(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		boolean isrefreshdone = false;
		try {
			String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
			String wifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD")
					.trim();
			for (int i = 5; i >= 0; i--) {
				if (diy.isEnsure24GHZNetworkPopUp(1)) {
					Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible");
					if (diy.clickOn24GHZPopUpOKButton()) {
						Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible and clicked OK Button");
					} else {
						Keyword.ReportStep_Pass(testCase, "2.4 GHZ popup Visible and but not clicked OK Button");
					}
				}
				diy.getAllAvailableWifiName();
				if (diy.isexpectedwifiNetworkPresent(wifiSSID)) {
					if (diy.clickOnChooseaNetworkConnectTOThermostatWifi(wifiSSID)) {
						if (diy.clickOnNextButton("Clicked on WifiNetwork name next button")) {
							if (diy.setWifiPasswordinAddNewWifi(wifiPassword)) {
								LyricUtils.hideKeyboard(testCase);
								flag = diy.clickOnNextButton("Clicked on Wifi Password next button");
								break;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"successfully wifi password in textbox, Wifi name :: " + wifiPassword);
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on button");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on wifi ssid name, Wifi name is :: " + wifiSSID);
						flag = false;
					}
				} else {
					isrefreshdone = diy.clickOnRefreshButton();
					Keyword.ReportStep_Pass(testCase,
							"Expected wifi is not visible, Is refresh the wifi scan list ?" + isrefreshdone);
					flag = false;
				}
			}
			if (!flag) {
				try {
					if (diy.clickOnAddWifiNetworkButton()) {
						if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
							if (diy.setWifinetworkName(wifiSSID)) {
								flag = LyricUtils.hideKeyboard(testCase);
								if (diy.clickOnWifiSecurityList()) {
									if (diy.clickOnSecurityTypeFromList()) {
										if (diy.setWifiSecuityPasswordInManual(wifiPassword)) {
											LyricUtils.hideKeyboard(testCase);
											flag = true;
											System.out.println("Wifi manually set " + flag);
											Keyword.ReportStep_Pass(testCase,
													"Manually selected Wifi Name :: " + wifiSSID
															+ " , Wifi password :: " + wifiPassword
															+ " , in add network");
										} else {
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Not able to set Wifi Password");
											flag = false;
										}
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to select Securitytype in list");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click On Security list");
									flag = false;
								}

							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set Wifi SSID Name");
								flag = false;
							}
						} else {
							if (diy.clickOnSecurityTypeFromList()) {
								if (MobileUtils.setValueToElement(testCase, "XPATH", "//XCUIElementTypeTextField[1]",
										wifiSSID)) {
									if (MobileUtils.setValueToElement(testCase, "XPATH",
											"//XCUIElementTypeSecureTextField[1]", wifiPassword)) {
										flag = LyricUtils.hideKeyboard(testCase);
										flag = true;
										System.out.println("Wifi manually set " + flag);
										Keyword.ReportStep_Pass(testCase, "Manually selected Wifi Name :: " + wifiSSID
												+ " , Wifi password :: " + wifiPassword + " , in add network");
									} else {
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Wifi ssid Password not able to set");
										flag = false;
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Wifi ssid Name not able to set");
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able  to click on Wifi security network manually");
								flag = false;
							}
						}
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able  to click on add network manually");
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
					flag = false;
				}
				flag = diy.clickOnNextButton("Clicked on Wifi Password next button");
			}
			if (flag)
				Keyword.ReportStep_Pass(testCase, "Successfully connected to wifi, waiting for confirmation");

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
			flag = false;
		}
		return flag;
	}

	public static boolean confirmWifiConfigurationIsCompleted(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(4));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						String source = testCase.getMobileDriver().getPageSource();
						if (source.contains("Choose Location")) {
							return true;
						} else if (source.contains("Connect to device")) {
							if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Connect']", testCase, 1)) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Connect']");
								return false;
							}
							return false;
						} else if (source.contains("Try again")) {
							MobileUtils.clickOnElement(testCase, "ID", "button2");
							return false;
						} else if (source.contains("Wi-Fi Network Error")) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"WIFI Network Error");
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								MobileUtils.clickOnElement(testCase, "ID", "button2");
							} else {
								MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "OK");
							}
							SystemState.getStatus().isWifiNetworkError(true);
							return true;
						} else if (source.toUpperCase().contains("Wi-Fi Error".toUpperCase())) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Wi-Fi Error");
							SystemState.getStatus().isWifiNetworkError(true);
							return true;
						} else if (source.toUpperCase().contains("Connection Loss".toUpperCase())) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Connection loss error occcured");
							SystemState.getStatus().isWifiNetworkError(true);
							return true;
						} else if (source.contains("Something came up")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							return false;
						} else if (source.contains("Couldn't connect. Check your network connection and try again.")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							return false;
						} else if (source.contains("SETTINGS")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='SETTINGS']");
							diy.connectWithThermostatWifiOnAndroidWithAfterCredential(
									SystemState.getStatus().getTstatName(), "Connecting to Wi-Fi");
							return false;
						} else if (source.contains("Connect to the thermostat Wi-Fi network")) {
							diy.ConnectToWifiUsingAPModeRetryScenario();
							return false;
						} else if (source.contains("Settings") && source.contains("MY NETWORKS")
								&& source.contains("Wi-Fi") && source.contains("XCUIElementTypeSwitch")) {
							diy.ConnectToWifiUsingAPModeRetryScenario_failureScenario();
							return false;
						} else {
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception occured in confirmWifiConfigurationIsCompleted() because of Timeout and more details "
										+ e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
						return false;
					} catch (Exception e) {
						e.printStackTrace();
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exception Occured in confirmWifiConfigurationIsCompleted() Due to " + e);
						return false;
					}
				}
			});
			if (SystemState.getStatus().isWifiNetworkError()) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"During WIFI configuration Error Occured< Error WIfi network Error");
			} else if (!SystemState.getStatus().isWifiNetworkError() && isEventReceived) {
				flag = true;
				Keyword.ReportStep_Pass(testCase,
						"Sucessfully Wifi Configuration completed and DIY will continue on Stat Location installation");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"During WIFI configuration Error Occured");
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in confirmWifiConfigurationIsCompleted() because of Timeout and more details "
							+ e.getMessage());
			flag = false;
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured in confirmWifiConfigurationIsCompleted() Due to " + e);
			flag = false;
		}
		return flag;
	}

	public static boolean chooseLocationStatNeedToInstall(TestCases testCase, DIYScreen diy, String LocationName) {
		boolean flag = false;

		if (diy.isExpectedLocationIsListed(LocationName)) {
			flag = diy.clickOnLocationNameFromTheList(LocationName);
		} else {
			flag = diy.clickOnCreateLocation();
			flag = diy.setThermostatLocationName(LocationName);
			if (flag && diy.isZipCode()) {
				flag = diy.setThermostatLocationZipCode("55401");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Zip Code Screen not Visible");
				flag = false;
			}
		}
		return flag;
	}

	public static boolean choosePairingTypeT9_T10_T10Plus(TestCases testCase, DIYScreen diy, String pairingType) {
		boolean flag = false;
		if (diy.isPrepareThermostatScreen()) {
			if (diy.clickOnYesButton()) {
				if (diy.isQRCodeScreen()) {
					if (pairingType.contains("QR SCAN")) {
						if (diy.clickOnYesButton()) {
							if (diy.isScanQRCodeScreen()) {
								Keyword.ReportStep_Pass(testCase,
										"Scan QR Code screen is visible, Camera ready to scan QR Code");
								flag = true;
							} else if (diy.isRegisteringDevice()) {
								Keyword.ReportStep_Pass(testCase,
										"QR Code screen Completed, Registration process started");
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"not able to find QR Code Screen.");
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on Yes Button in QR Code screen");
							flag = false;
						}
					} else {
						if (diy.clickOn_NoButton()) {
							if (diy.clickOnYesTheyMatchBtn()) {
								Keyword.ReportStep_Pass(testCase,
										"AP Mode is ON, Device will start looking for Thermostat");
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on No Button in Compare wifi networks screen");
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to click on No Button in QR Code screen");
							flag = false;
						}
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"QR Code screen is not visible in APP");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Yes Button in Prepare thermostat screen");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"prepare thermostat screen is not visible in APP");
			flag = false;
		}
		return flag;
	}

	public static boolean chooseNameYourThermostat(TestCases testCase, DIYScreen diy) {
		boolean flag = diy.setThermostatName();
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (diy.isEnteredDeviceName()) {
				if (diy.setThermostatName_secondIterate()) {
					Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in second time");
					flag = true;
					if (diy.isEnteredDeviceName()) {
						if (diy.setThermostatName_secondIterate()) {
							Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in second time");
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to entered second time device name");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in Second time");
						flag = true;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to entered second time device name");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in first time");
				flag = true;
			}
		} else {
			if (diy.isAlreadyDeviceNameExistPopup()) {
				if (diy.setThermostatName_secondIterate()) {
					Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in second time");
					flag = true;
					if (diy.isAlreadyDeviceNameExistPopup()) {
						if (diy.setThermostatName_secondIterate()) {
							Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in third time");
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Not able to entered third time device name");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in Second time");
						flag = true;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Not able to entered second time device name");
					flag = false;
				}
			} else {
//				System.out.println(testCase.getMobileDriver().getPageSource());
				Keyword.ReportStep_Pass(testCase, "Device Name entered successfully in first time");
				flag = true;
			}
		}
		return flag;
	}

	public static boolean completeRegistrationFlow(TestCases testCase) {
		boolean flag = false;
		DIYScreen diy = new DIYScreen(testCase);
		flag = diy.RegisteringDevice();
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(6));
			fWait.ignoring(NullPointerException.class);
			fWait.ignoring(NoSuchElementException.class);
			fWait.ignoring(TimeoutException.class);
			System.out.println("started registration");
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {

//						if (!SystemState.getStatus().isflightmodecompleted() && diy.isTurnOffFlightMode()) {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						if (pageSource.contains("REGISTRATION ERROR")) {
							SystemState.getStatus().setRegError(true);
//							SystemState.getStatus().Reg_failureCount()==2 SystemState.getStatus().Reg_failureCount(2);
							return true;
						} else if (pageSource.contains("NO INTERNET CONNECTION")) {
							SystemState.getStatus().unKnownMesssageShow("NO INTERNET CONNECTION");
							return true;
						} else if (diy.isTurnOffFlightMode()) {
							diy.clickOnSkipTurnOffFlightMode();
//							SystemState.getStatus().isflightmodecompleted(true);
							return false;
						} else if (diy.isEnableGeofenceScreen()) {
							diy.clickOnSkipRebeatesButton();
//						SystemState.getStatus().isRebateDRcompleted(true);
							return false;
						} else if (diy.isRebatesDRScreen()) {
							System.out.println("rebate screen");
							diy.clickOnSkipRebeatesButton();
//							SystemState.getStatus().isRebateDRcompleted(true);
							return false;
						} else if (diy.isCongratulationScreen()) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								return diy.clickOnYesButton();
							} else {
								return diy.clickOnDoneButton();
							}
						} else {
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
						e.printStackTrace();
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
						return false;
					}

				}
			});
			if (SystemState.getStatus().isRegError()) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Registration error");
			} else if (SystemState.getStatus().unKnownMesssageShow().contains("NO INTERNET CONNECTION")
					&& isEventReceived) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"NO INTERNET CONNECTION popup showing during registration");
			} else if (isEventReceived) {
				flag = true;
				Keyword.ReportStep_Pass(testCase,
						"Sucessfully Completed Registration Flow, Registration Completed and Data sync is initiated");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "During Registration Error Occured");
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured in RegisteringDevice() because of Timeout and more details " + e.getMessage());
			return false;
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured completeRegistrationFlow(TestCases testCase, DIYScreen diy) due to "
							+ e.getMessage());
			flag = false;
		}
//		SystemState.getStatus().isflightmodecompleted(false);
		return flag;
	}

	public static boolean isDeleteThermostatLoadFinish(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(45));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					if (diy.isDeleteThermostatDeleteLoadingPopup()) {
						return false;
					} else if (diy.isDeleteThermostatDeleteErrorPopup()) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to delete thermostat, Retrying to delete...");
						return false;
					} else if (diy.isDashboard(1)) {
						System.out.println("Dashboard is visible...");
						return true;
					} else {
						System.out.println("Deleting thermostat .....");
						return false;
					}

				} catch (Exception e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"During Delete thermostat, Exception Occured Due to " + e);
					return false;
				}

			}
		});
		if (isEventReceived) {
			Keyword.ReportStep_Pass(testCase, "Successfully thermostat is deleted from APP");
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Delete Thermostat failed");
			flag = false;
		}
		return flag;
	}

	public static boolean connectToTheCaspianValve(TestCases testCase, DIYScreen diy) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(120));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageSource = testCase.getMobileDriver().getPageSource();
					if (pageSource.toUpperCase()
							.contains("L5 Wi-Fi Water Leak Shutoff Valve is connected to your phone".toUpperCase())) {
						System.out.println("Connected to Valve");
						return true; // Connecting to valve
					} else if (pageSource.toUpperCase().contains("CONNECTING TO VALVE".toUpperCase())) {
						System.out.println("Trying to connect with valve");
						return false;
					} else {
//						System.out.println(pageSource);
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured due to :" + e);
					return false;
				}
			}
		});
		if (isEventReceived) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Connect with valve screen Appeared");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to connect with Caspian Valve");
		}
		return flag;

	}

	public static boolean preparingAndConenctWithCaspianValveUsingBle(TestCases testCase, DIYScreen diy,
			String methodType) {
		boolean flag = false;
		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(120));
		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
			public Boolean apply(Boolean driver) {
				try {
					String pageSource = testCase.getMobileDriver().getPageSource();
					if (pageSource.toUpperCase().contains("Looking for valves".toUpperCase())) {
						System.out.println("Looking for valves ........");
						return false;
					} else if (pageSource.toUpperCase().contains("Connect to the valve".toUpperCase())) {
						SystemState.getStatus().isSingleDevice(true);
						System.out.println("Valve Found, Connect to the Valve");
						return true;
					} else if (pageSource.toUpperCase().contains("Multiple devices found".toUpperCase())) {
						System.out.println("multiple device found");
						Keyword.ReportStep_Pass(testCase, "Multiple Device Found");
						SystemState.getStatus().isMultipleDevice(true);
						return true;
					} else if (pageSource.toUpperCase().contains("L5 Leak Protection Valve not found".toUpperCase())) {
						System.out.println("Device not Found, Failed to find.....");
						SystemState.getStatus().isDeviceNotFound(true);
						return true;
					} else {
//						System.out.println(pageSource);
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured due to :" + e);
					return false;
				}
			}
		});
		if (isEventReceived && SystemState.getStatus().isSingleDevice()) {
			flag = true;
		} else if (isEventReceived && SystemState.getStatus().isDeviceNotFound()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device not found in BLE mode");
			flag = false;
		} else if (isEventReceived && SystemState.getStatus().isMultipleDevice()) {
			if (diy.isCaspianValveAvailableInList())
				flag = diy.clickOnCaspianValveAvailableInList();
			else
				flag = false;
		}
		if (flag) {
			flag = shortActionForConnectValve(testCase, diy, methodType);
		}
		return flag;
	}

	public static boolean shortActionForConnectValve(TestCases testCase, DIYScreen diy, String methodType) {
		boolean flag = false;
		if (methodType.toUpperCase().contains("CATT")) {
			if (StatCommonCommandUtils.caspianValveButtonCommand(testCase, "SHORT")) {
				flag = connectToTheCaspianValve(testCase, diy);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Valve Catt Command Failed, Need to check in GRPC");
				flag = false;
			}
		} else {

			if (RelayConfiguration.CaspianCommandControl(testCase, "CONNECT")) {
				flag = connectToTheCaspianValve(testCase, diy);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION, "Valve Arduino Command Failed");
				flag = false;
			}

		}

		return flag;
	}

	public static boolean WaitForDeviceToBeDetected(TestCases testCase, TestCaseInputs inputs, DIYScreen diy) {
		boolean flag = true;
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(4));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
//						String pgsrc = testCase.getMobileDriver().getPageSource();
						System.out.println("		  Waiting for device...");
						Keyword.ReportStep_Pass(testCase, "Waiting for device...");
						if (diy.isDeviceDetected(2)) {
							System.out.println("		  Device detected");
							Keyword.ReportStep_Pass(testCase, "Device detected.");
							return true;
						} else if (diy.isLocalNetworkPopUP()) {
							diy.clickOnEnableLocalNetwork_iOS(testCase);
							diy.clickOnNextLocalNetwork_iOS();
							return false;
						}
						/////////////////////////////// List of Device/////////////////////////////////
						else if (diy.isMorethanOneDeviceDetected(5)) {
							System.out.println("More than one device detected..");
							Keyword.ReportStep_Pass(testCase, "More than one device detected...");
//							System.out.println(pgsrc);
							return true;
						}
						/////////////////////////////////////////////////////////////////////////////////
						else if (diy.isPreparingToAddLableVisible(2)) {
							Keyword.ReportStep_Pass(testCase, "Preparing to add T10");
							System.out.println("		  Preparing to add T10");
							return false;
						} else if (diy.isThermostatready(2)) {
							Keyword.ReportStep_Pass(testCase, "Device not detected, retrying to connect...");
							MobileUtils.isMobElementExists("id", "Password", testCase, 120);
							if (diy.isYesBtnVisible(2))
								diy.clickOnYesButton();
							if (diy.isYesTheyMatchBtnVisible(2))
								diy.clickOnYesTheyMatchBtn();
							return false;
						} else if (diy.isUnableToDetectDevice(2)) {
							System.out.println("		  Unable to find thermostat");
							Keyword.ReportStep_Pass(testCase, "Unable to find thermostat. Retrying...");

							if (diy.clickOnBackButton())
								if (diy.isYesTheyMatchBtnVisible(2))
									diy.clickOnYesTheyMatchBtn();

							return false;
						} else if (diy.isChooseLocationTitleVisible(2)) {
							System.out.println("		  Device not found, navigated back to choose location screen");
							Keyword.execute(ThermostatLocationName.class, testCase, inputs);
							return false;
						} else
							return false;
					} catch (Exception e) {
						return false;
					}
				}
			});
			if (isEventReceived) {
				if (diy.isYesBtnVisible(5)) {
					diy.clickOnYesButton();
				} else {
					if (diy.isSetUpBtnVisibleForDevice(inputs.getInputValue("LOCATION1_DEVICE1_NAME").toString(), 5)) {
						diy.clickOnSetUpBtn(inputs.getInputValue("LOCATION1_DEVICE1_NAME").toString());
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"SetUp/Yes Button is not visible");
						flag = false;
					}
				}
				if (diy.isPinLayoutisPresent_flycathcer(30)) {
					System.out.println("Navigated to security screen to enter PIN");
					Keyword.ReportStep_Pass(testCase, "Navigated to security screen to enter PIN");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to navigate to security screen");
					flag = false;
				}
			}
		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Timed out while loading. Wait time : 4 minutes");
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Device not connected to WiFi Properly");
			System.out.println("		  Timed out while loading. Wait time : 4 minutes");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
			System.out.println("		  Error Occured : " + e.getMessage());
		}

		return flag;
	}

	public static boolean EnterSecurityPin(DIYScreen diy) {
		char[] pinFromThermostat = diy.getPinFromThermostat(PairingPinMode.RADIO);
		return diy.set4_DigitPin(pinFromThermostat);
	}

	public static boolean gotoDashBoard(TestCases testCase) {
		boolean flag = true;
		DIYScreen diy = new DIYScreen(testCase);
//		if(diy.isDashboard(1)) {
//			flag = true;
//		}else if(pm.isFanButtonVisible()|| pm.isModeButtonVisible()){
//			flag = MobileUtils.pressBackButton(testCase, "Navigate from Primary card to dashBoard");
//		}

		while (!diy.isDashboard(1)) {
			flag = MobileUtils.pressBackButton(testCase, "Navigate to dashBoard");
		}

		return flag;
	}

	public static boolean configureWireSensing(TestCases testCase, String[] wiresensingData) {
		boolean flag = false;

		WireSenseDIYScreen ws = new WireSenseDIYScreen(testCase);
		for (String wireData : wiresensingData) {

			switch (wireData) {
			case "A-L":
//				if (!ws.is_AL_A_Checked()) {
				flag = ws.clickOn_AL_A_CheckBX();
//				}
				break;
			case "R":
//				if (!ws.is_R_Checked()) {
				flag = ws.clickOn_R_CheckBX();
//				}
				break;
			case "C":
//				if (!ws.is_C_Checked()) {
				flag = ws.clickOn_C_CheckBX();
//				}
				break;
			case "Rc":
//				if (!ws.is_Rc_Checked()) {
				flag = ws.clickOn_Rc_CheckBX();
//				}
				break;
			case "E":
//				if (!ws.is_E_Checked()) {
				flag = ws.clickOn_E_CheckBX();
//				}
				break;
			case "W":
//				if (!ws.is_W_Checked()) {
				flag = ws.clickOn_W_CheckBX();
//				}
				break;
			case "G":
//				if (!ws.is_G_Checked()) {
				flag = ws.clickOn_G_CheckBX();
//				}
				break;
			case "W2":
//				if (!ws.is_W2_Checked()) {
				flag = ws.clickOn_W2_CheckBX();
//				}
				break;
			case "K":
//				if (!ws.is_K_Checked()) {
				flag = ws.clickOn_K_CheckBX();
//				}
				break;
			case "Y1":
//				if (!ws.is_Y1_Checked()) {
				flag = ws.clickOn_Y1_CheckBX();
//				}
				break;
			case "O_B":
//				if (!ws.is_O_B_Checked()) {
				flag = ws.clickOn_O_B_CheckBX();
//				}
				break;
			case "Y2":
//				if (!ws.is_Y2_Checked()) {
				flag = ws.clickOn_Y2_CheckBX();
//				}
				break;
			default:
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Data not available, User tried Wire is " + wireData);
				flag = false;
				break;
			}

		}
		if (flag && ws.clickOnValidateWiring()) {
			flag = ws.ClickOnValidWireSensing();
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to click on Validate wiring Button");
			flag = false;
		}
		return flag;
	}

}
