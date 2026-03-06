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
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.screen.HomeKitScreen;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;
import com.resideo.utils.stat.cattgrpccommands.screenshotData;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;
import com.resideo.utils.stat.systemswitch_setpoint.SystemMode_SetPoints;
//import com.resideo.robotic_arm.supportConstant.ArmConstants;

public class HomeKitUtils {

	public static boolean AddThermostatInAddAccessory(TestCases testCase, TestCaseInputs input, HomeKitScreen homeKit,
			String deviceName) {
		boolean flag = false;
		if (homeKit.isAddIconVisible()) {
			flag = homeKit.clickOnAddIcon();
			System.out.println("Clicked add button , is " + flag);
			flag = flag && homeKit.clickOnAddAccessory();
			System.out.println("Clicked add accessory button , is " + flag);
			if (homeKit.isIDontHaveCodeTOScan()) {
				if (homeKit.clickOnIDontHaveCodeTOScan()) {
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on I dont have code button");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on i dont have code button");
				}
			} else if (homeKit.isHyperlink_moreOption()) {
				if (homeKit.clickOnHyperlink_moreOption()) {
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on can code");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on i dont have code button");
				}
			} else {
				if (homeKit.clickOnCoordinate(
						CommonUtils.getCoordinatesForParticularUDID(testCase, input, "More Option"))) {
					Keyword.ReportStep_Pass(testCase, "Successfully clicked on More option button");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on more option button");
				}
			}
			try {
				if (homeKit.isSelectAnAccessorySearchScreen(4) || homeKit.isConnectingToThermostatCardVisible()) {
					flag = homeKit.waitForDeviceAvailableinAddAccessory(5, deviceName);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Search an Accessory to Add to Home is not available");
					flag = false;
				}
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Search an Accessory to Add to Home is not available, Exception occured due to "
								+ e.getMessage());
				flag = false;
			}
		} else {
			System.out.println("Add button failed");
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Add Icon visible not available in Add Accessory Screen");
		}

		return flag;
	}

	public static boolean AddThermostatInAddAccessory(TestCases testCase, TestCaseInputs input, HomeKitScreen homeKit,
			String deviceName, boolean isdirectScan) {
		boolean flag = false;
		if (homeKit.isAddIconVisible()) {
			flag = homeKit.clickOnAddIcon();
			System.out.println("Clicked add button , is " + flag);
			flag = flag && homeKit.clickOnAddAccessory();
			System.out.println("Clicked add accessory button , is " + flag);
			if (isdirectScan) {
				flag = true;
				SystemState.getStatus().isDirectScan(true);
				if (homeKit.isAddToApple_BridgepopUP()) {
					flag = homeKit.clickOnAddToApple_BridgepopUP();
					Keyword.ReportStep_Pass(testCase, "Bridge popup shown and it handled");
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Bridge Popup is not visible to confirm add to Homekit Home");
					flag = false;
				}
			} else {
				if (homeKit.isIDontHaveCodeTOScan()) {
					if (homeKit.clickOnIDontHaveCodeTOScan()) {
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on I dont have code button");
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on i dont have code button");
					}
				} else if (homeKit.isHyperlink_moreOption()) {
					if (homeKit.clickOnHyperlink_moreOption()) {
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on scan code more option");
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on More option button");
					}
				} else {
					if (homeKit.clickOnCoordinate(
							CommonUtils.getCoordinatesForParticularUDID(testCase, input, "More Option"))) {
						Keyword.ReportStep_Pass(testCase, "Successfully clicked on More option button");
						flag = true;
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on more option button");
					}
				}
				try {
					if (homeKit.isSelectAnAccessorySearchScreen(4) || homeKit.isConnectingToThermostatCardVisible()) {
						flag = homeKit.waitForDeviceAvailableinAddAccessory(2, deviceName);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Search an Accessory to Add to Home is not available");
						flag = false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Search an Accessory to Add to Home is not available, Exception occured due to "
									+ e.getMessage());
					flag = false;
				}
			}

		} else {
			System.out.println("Add button failed");
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Add Icon visible not available in Add Accessory Screen");
		}

		return flag;
	}

	public static boolean PairingHomeKit(TestCases testCase, HomeKitScreen homeKit, String getDeviceNeedtoInstall,
			String deviceName) {
		boolean flag = false;

		flag = homeKit.clickOnDeviceNameFromAccessoryScreen(deviceName);
		if (homeKit.isAddAccessorytoNetwork()) {
			flag = flag && homeKit.clickOnAllowButton();
		}
		if (flag && homeKit.isEnterHomeKitSetupCode()) {
			if (homeKit.setValueHomeKitCode(
					StatCommonCommandUtils.getHomeKitParingMode(testCase, getDeviceNeedtoInstall))) {
				if (homeKit.clickOnContinue()) {
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on continue button Setup code screen HK");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to enter passcode in Setup code screen HK");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Enter HomeKit Setup Code Screen is not available");
			flag = false;
		}
		return flag;
	}

	public static boolean PairingHomeKitWithQR(TestCases testCase, HomeKitScreen homeKit, String deviceName) {
		boolean flag = false;

		flag = homeKit.clickOnDeviceNameFromAccessoryScreen(deviceName);
		if (homeKit.isAddAccessorytoNetwork()) {
			flag = flag && homeKit.clickOnAllowButton();
		}

		if (flag && homeKit.isEnterHomeKitSetupCode()) {

			if (homeKit.clickOnUseCamera()) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, 0, "Use Camera Button not available / Not able to click");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Enter HomeKit Setup Code Screen is not available");
			flag = false;
		}
		return flag;
	}

	public static boolean selectLocationAndDeviceNameFinalize(TestCases testCase, HomeKitScreen homeKit) {
		boolean flag = false;
		try {
			if (homeKit.waitForThermostatLocationAndDeviceName(6)) {
				flag = homeKit.clickOnContinue();
				if (homeKit.isThermostatNameScreen()) {
					flag = homeKit.clickOnContinue();
					if (flag && homeKit.isThermostatAddedtoHomeScreen()) {
						flag = homeKit.clickOnDone();
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not Able to navigate to Thermostat Added to Home Screen ");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not Able to navigate to select Thermostat Name Screen ");
				}

			} else {
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to >" + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean enrollHomekit_ThermostatName_andSensorName(TestCases testCase, HomeKitScreen homeKit,
			Duration timeout) {
		SystemState.getStatus().initForHomeKit();
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(timeout);
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();

					if (pgsrc.contains("Unable to Add Accessory".toUpperCase())) {
						System.out.println("Unable to Add Accessory...");
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Unable to Add Accessory in Homekit");
						SystemState.getStatus().isUnableToAddedAccessory(true);
						return true;
					} else if (pgsrc.contains("Connecting to Bridge".toUpperCase())) {
						System.out.println("Connecting to Bridge......");
						return false;
					} else if (pgsrc.contains("Bridge Location".toUpperCase())) {
						System.out.println("Bridge Location name entered ");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully clicked on Bridge connection name");
							}
						}
						return false;
					} else if (pgsrc.contains("Bridge Name".toUpperCase())) {
						System.out.println("Bridge name entered ");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully clicked on Bridge name");
							}
						}
						return false;
					} else if (pgsrc.contains("Bridge Added".toUpperCase())) {
						System.out.println("Bridge Added to Homekit");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Bridge Added to Homekit ");
							}
						}
						return false;
					} else if (pgsrc.contains("Air Sensor".toUpperCase())
							&& pgsrc.contains("sensor is connected".toUpperCase())) {
						System.out.println("sensor is connected...");
							String sensor_header = MobileUtils
									.getMobElement(testCase, "XPATH",
											"//XCUIElementTypeTextView[contains(@name,'Air Sensor')]")
									.getAttribute("label");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
							Keyword.ReportStep_Pass(testCase, sensor_header + " added successfully");
							}
						}
						return false;
					} else if (pgsrc.contains("Sensor Location".toUpperCase())) {
						System.out.println("Sensor Location..");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Sensor Location selected");
							}
						}
						return false;

					} else if (pgsrc.contains("Sensor Name".toUpperCase())) {
						System.out.println("Sensor Name..");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Sensor name selected");
							}
						}
						return false;
					} else if (pgsrc.contains("Sensor Details".toUpperCase())) {
						System.out.println("Sensor Details..");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully details confirmed");
							}
						}
						return false;
					} else if (pgsrc.contains("Sensors Added to ".toUpperCase())
							|| pgsrc.contains("Sensor Added to ".toUpperCase())) {
						System.out.println("Sensor Added to HomeKit..");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
							Keyword.ReportStep_Pass(testCase, "Sensor added to Home kit successfully");
							}
						}
						return false;

					} else if (pgsrc.contains("thermostat is connected".toUpperCase())
							&& pgsrc.contains("Identify".toUpperCase())) {
						System.out.println("Thermostat is connected...");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Thermostat connected with homekit");
							}
						}
						return false;
					} else if (pgsrc.contains("Thermostat Location".toUpperCase())
							&& pgsrc.contains("Identify".toUpperCase())) {
						System.out.println("Thermostat in Location...");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Thermostat location selected");
							}
						}
						return false;

					} else if (pgsrc.contains("Thermostat Name".toUpperCase())
							&& pgsrc.contains("Use the name provided".toUpperCase())) {
						if (MobileUtils.isMobElementExists("NAME", "Clear text", testCase, 3)) {
							if (MobileUtils.clickOnElement(testCase, "NAME", "Clear text")) {
								if (MobileUtils.setValueToElement(testCase, "XPATH", "//XCUIElementTypeTextField",
										"Tstat-" + SystemState.getStatus().getLast6CharDeviceMacID())) {
									if (MobileUtils.isMobElementExists("XPATH",
											"//XCUIElementTypeButton[@name='Continue']", testCase, 1)) {
										if (MobileUtils.clickOnElement(testCase, "XPATH",
												"//XCUIElementTypeButton[@name='Continue']", false, false)) {
											Keyword.ReportStep_Pass(testCase, "Successfully Thermostat name selected");
										}
									}
								}
							}
						}
						return false;
					} else if (pgsrc.contains("Thermostat Details".toUpperCase())
							&& pgsrc.contains("Use the name provided".toUpperCase())) {
						System.out.println("Thermostat Details...");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Continue']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Continue']", false, false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Thermostat details are verified");
							}
						}
						return false;
					} else if (pgsrc.contains("Uncertified Accessory".toUpperCase())
							&& pgsrc.contains("Add Anyway".toUpperCase())) {
						System.out.println("Uncertified Accessory...");
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Uncertified accessory error occured");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Cancel']", testCase,
								1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Cancel']")) {
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"failed to cancel for uncertified");
							}
						} else if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[label='Cancel']",
								testCase, 1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@label='Cancel']")) {

							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"failed to cancel for uncertified");
							}
						}
						SystemState.getStatus().isUncertifiedDevice(true);
						return true;

					} else if (pgsrc.contains("Thermostat Added to".toUpperCase())) {
						System.out.println("Thermostat Added to Home...");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Done']", testCase,
								1)) {
						if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//XCUIElementTypeButton[@name='Done']",false,false)) {
								Keyword.ReportStep_Pass(testCase, "Successfully Thermostat Added to My Home");
							}
						}
						return true;
					} else if (pgsrc.contains("Accessory Already Added".toUpperCase())) {
						System.out.println("Accessory Already Added...");
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"failed to Add Accessory , because homekit app says its already added");
						if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='OK']", testCase,
								1)) {
							if (MobileUtils.clickOnElement(testCase, "XPATH", "//XCUIElementTypeButton[@name='OK']")) {
							}
						}
						SystemState.getStatus().isPairedDevice_HK(true);
						return true;
					}
					else {
						return false;
					}
				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception raised due to " + e.getMessage());
					return false;
				}
			}
		});
		if (isEventReceived && SystemState.getStatus().isUnableToAddedAccessory()) {
			return false;
		} else if (isEventReceived && SystemState.getStatus().isUncertifiedDevice()) {
			return false;

		} else if (isEventReceived && SystemState.getStatus().isPairedDevice_HK()) {
			return false;
		} else if (isEventReceived) {
			Keyword.ReportStep_Pass(testCase,
					"HomeKit configuration done, user can change setpoint and mode from Homekit app");
			return true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to navigate to Thermostat Location Screen");
			return false;
		}
	}

	public static boolean selectLocationAndDeviceNameFinalize_Bridge(TestCases testCase, HomeKitScreen homeKit) {
		boolean flag = false;
		try {
			if (homeKit.waitForThermostatLocationAndDeviceName(6)) {
				flag = homeKit.clickOnContinue();
				if (flag && homeKit.isBridgeNameScreen()) {
					flag = homeKit.clickOnContinue();
					if (flag && homeKit.isBridgeAddedtoHomeScreen()) {
						flag = homeKit.clickOnContinue();
						if (flag && homeKit.isT10PlusThermostatConnected()) {
							flag = homeKit.clickOnContinue();
							if (flag && homeKit.isThermostatLocation()) {
								flag = homeKit.clickOnContinue();
								if (flag && homeKit.isThermostatNameScreen()) {
									if (flag && MobileUtils.isMobElementExists("NAME", "Clear text", testCase, 3)) {
										if (flag && MobileUtils.clickOnElement(testCase, "NAME", "Clear text")) {
											if (flag && MobileUtils.setValueToElement(testCase, "XPATH",
													"//XCUIElementTypeTextField",
													"Tstat-" + SystemState.getStatus().getLast6CharDeviceMacID())) {
												flag = homeKit.clickOnContinue();
												if (flag && MobileUtils.isMobElementExists("NAME", "Thermostat Details",
														testCase, 3)) {
													flag = homeKit.clickOnContinue();
													if (flag && homeKit.isThermostatAddedtoHomeScreen()) {
														flag = homeKit.clickOnDone();
													} else {
														flag = false;
														Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
																"Not Able to navigate to Thermostat Added to Home Screen ");
													}
												} else {

													flag = false;
													Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
															"Not Able to find Thermostat details screen");
												}

											} else {
												flag = false;
												Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
														"Not Able to send to text box, Device Name is " + "Tstat"
																+ SystemState.getStatus().getLast6CharDeviceMacID());
											}

										} else {
											flag = false;
											Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
													"Not Able to click on clear text");
										}

									} else {
										flag = false;
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not Able to navigate to Thermostat Location Screen ");
									}
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not Able to navigate to thermostat name Screen ");
								}

							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not Able to navigate to Thermostat Location Screen ");
							}

						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not Able to navigate to T10 plus Thermostat Connected or not Screen ");
						}
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not Able to navigate to Thermostat Added to Home Screen ");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not Able to navigate to select Thermostat Name Screen ");
				}

			} else {
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Occured due to >" + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean deleteDeviceInHomeKit(TestCases testCase, String deviceName) {
		boolean flag = false;
		HomeKitScreen homeKit = new HomeKitScreen(testCase);
		if (homeKit.isDeviceSettings(2)) {
			if (homeKit.clickOnSettings()) {
				if (deviceName.contains("THOR") || deviceName.contains("FLYCATCHER")) {
					flag = homeKit.clickOnRemoveBridgeInHomeKit();
				} else {
					flag = homeKit.clickOnRemoveAccessoryInHomeKit();
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Unable to click on Settings Button");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device Setting Icon Not visible");
			flag = false;
		}
		return flag;
	}

	public static boolean changeSystemModeFromHomeKitVerifyFromStat(TestCases testCase, String mode) {
		boolean flag = false;
		try {
			HomeKitScreen homeKit = new HomeKitScreen(testCase);
			flag = homeKit.changeModeFromHomeKit(mode.toUpperCase());
			flag = flag && SystemMode_SetPoints.verifySystemMode(testCase, mode);
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised, in changeSystemModeFromHomeKitVerifyFromStat()" + e.getMessage());
		}
		return flag;
	}

	public static boolean changeSystemModeFromStatVerifyFromHomeKit(TestCases testCase, String mode) {
		boolean flag = false;
		try {
			HomeKitScreen homeKit = new HomeKitScreen(testCase);
			flag = SystemMode_SetPoints.changeSystemMode(testCase, mode);
			flag = homeKit.verifyModeFromHomeKit(mode);
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised, in changeSystemModeFromStatVerifyFromHomeKit()" + e.getMessage());
		}
		return flag;
	}

	public static boolean changeSetPointFromHomeKitVerifyFromStat(TestCases testCase, TestCaseInputs inputs,
			String mode, String setPoint) {
		boolean flag = false;
		try {
			HomeKitScreen homeKit = new HomeKitScreen(testCase);
			flag = homeKit.changeSetpointFromHomeKit(inputs, setPoint);
			flag = flag && SystemMode_SetPoints.verifySetpoint(testCase, mode, setPoint);
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised, in changeSetPointFromHomeKitVerifyFromStat() " + e.getMessage());
		}
		return flag;
	}

	public static boolean ChangeSetPointFromStatVerifyFromHomeKit(TestCases testCase, String mode, String setPoint) {
		boolean flag = false;
		try {
			HomeKitScreen homeKit = new HomeKitScreen(testCase);
			flag = SystemMode_SetPoints.changeSetPoint(testCase, mode, setPoint);
			flag = flag && homeKit.verifySetpointFromHomeKit(mode, setPoint);
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised, in ChangeSetPointFromStatVerifyFromHomeKit() " + e.getMessage());
		}
		return flag;
	}

	public static boolean navigateToHomeKitPrimaryCard(TestCases testCase) {
		boolean flag = false;
		HomeKitScreen homeKit = new HomeKitScreen(testCase);
		if (homeKit.isHomeKitScreen(20)) {
			System.out.println("Is homekit screen confirmed");
			flag = homeKit.clickOnDeviceNameFromAccessoryScreen(SystemState.getStatus().getLast6CharDeviceMacID());
		} else if (homeKit.isDeviceSettings(20)) {
			flag = true;
		} else {
			flag = false;
		}
		System.out.println("Navigate to home kit primary card is " + flag);
		return flag;
	}

	public static boolean isDeviceExist(TestCases testCase) {
		HomeKitScreen homeKit = new HomeKitScreen(testCase);
		return !homeKit.isDeviceNamePresentInHomeKitHomeScreen(SystemState.getStatus().getLast6CharDeviceMacID(), 30);
	}

	public static void location(TestCases testCase) {
		// TODO: Selenium 4 removed HTML5 geolocation methods (location()/setLocation()).
		// Use CDP command "Emulation.setGeolocationOverride" for Chrome/Edge, or
		// Appium's mobile:setGeolocation for mobile drivers.
		// Example for Chrome CDP:
		//   Map<String, Object> params = new HashMap<>();
		//   params.put("latitude", 11.672127);
		//   params.put("longitude", 78.229691);
		//   params.put("accuracy", 1);
		//   ((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", params);
		System.out.println("location() method disabled - Selenium 4 removed HTML5 geolocation API");
	}

	public static boolean generateQR_CodeFromStat_Homekit(TestCases testCase) {
		boolean flag = false;
		StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
				NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build());
		if (StatCommands.getInstance().cattCommandsStub
				.t10PlusNavigateTo(
						NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build())
				.getBoolVal()) {

			if (StatCommands.getInstance().cattCommandsStub
					.t10PlusNavigateTo(
							NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_QRCODE).build())
					.getBoolVal()) {

				SetUpDevice_T9_T10_T0Plus t10Plus = new SetUpDevice_T9_T10_T0Plus();
				if (!t10Plus.isTextIsPresentInScreen(testCase, Duration.ofSeconds(5), 42, 147, 275, 190, 1,
						"Too Many Attempts")) {
					if (!t10Plus.isTextIsPresentInScreen(testCase, Duration.ofSeconds(5), 42, 147, 275, 190, 1,
							"Wi-Fi Required")) {
						if (t10Plus.isTextIsPresentInScreen(testCase, Duration.ofSeconds(5), 65, 12, 255, 44, 1,
								"Connect HomeKit")) {

							StatCommands.getInstance().cattCommandsStub.getScreenShot(screenshotData.newBuilder()
									.setCapturePath("ArmConstants.stat_UI_Tmp_Asset").setXStartCordinate(55)
									.setYStartCoordinate(115).setXEndCordinate(265).setYEndCoordinate(365).build());
							Keyword.ReportStep_Pass(testCase, "QR Code screenshot Captured");
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Error occured, Device shows Wifi required");
							flag = false;
						}

					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Error occured, Device shows Wifi required");
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Error occured, Device shows Too Many Attempts");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navigate to Home kit screen");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to navigate to Home screen");
			flag = false;
		}

		return flag;
	}

}
