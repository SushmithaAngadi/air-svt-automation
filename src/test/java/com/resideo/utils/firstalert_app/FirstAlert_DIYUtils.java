package com.resideo.utils.firstalert_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.firstalert_app.screen.FirstAlertDIYScreen;
import com.resideo.utils.firstalert_app.screen.NavigatingScreenToScreeninFA;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.mqtt.MqttManager;
import com.resideo.utils.stat.mqtt.MqttSerialController;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class FirstAlert_DIYUtils {

    static boolean isCWireadapter = false;
    private static char[] correctPin;

    public static boolean selectPerferedDeviceforDIYFromList(TestCases testCase, FirstAlertDIYScreen diy) {
        boolean flag = false;
        flag = diy.clickOnAddDeviceButton();
        try {
            String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                    .trim();
            switch (device) {
                case "JASPER_SENIOR_NA_TRADE": {
                    flag = diy.clickOnT5T6Thermostat();
                    break;
                }
                case "JASPER_SENIOR_NA_RETAIL": {
                    flag = diy.clickOnT5T6Thermostat();
                    break;
                }
                case "THOR":
                case "FLYCATCHER": {
                    flag = diy.clickOnT9T10T10PlusThermostat();
                    break;
                }
                case "FUJI_X2S_TRADE":
                case "FUJI_X2S_RETAIL": {
                    flag = diy.clickOnFujiThermostat();
                    break;
                }
                case "DENALI_TRADE":
                case "DENALI_RETAIL":{
                	 flag = diy.clickOnDenaliTradeThermostat();
                     break;
                }
                case "GLENEAGLES_TRADE":{
                	 flag = diy.clickOnGleneaglesControlHub();
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

            if(flag){
                diy.clickOnNextButton();
            }

        } catch (Exception e) {
            flag = false;
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Keyword step : Exception raised : " + e.getMessage());
        }
        return flag;
    }

    public static boolean setupLocationAndDeviceName(TestCases testCase, FirstAlertDIYScreen diy) {
        boolean flag = true;
        String device = null;
        HomeUtils.printLogforSteps(testCase, flag, "Is the Steps to add device screen visible ?.,> > ");
//        if (diy.isStepsToAddDeviceScreen()) {
            try {
                device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                        .trim().toUpperCase();
                flag = diy.clickOnNextButton();
                if (flag && device != null && (device.equals("THOR") || device.equals("FLYCATCHER"))) {
                    if (diy.isConfigureDeviceScreen()) {
                        flag = diy.clickOnNextButton();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
			if (device.contains("DENALI")) {
				if (!device.contains("RETAIL")) {
					String deviceName = MqttManager.getThermostatName(testCase);
					testCase.getTestCaseInputs().setInputValue("LOCATION1_DEVICE1_NAME", deviceName);
					SystemState.getStatus().setTstatName(deviceName);
				}else {
					SystemState.getStatus().setTstatName(testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME"));
				}
			} else {
				if (flag) {
					if (diy.isDeviceNameScreen()) {
						Keyword.ReportStep_Pass(testCase, "Device name screen is present.");
						String macID = null;
						try {
							macID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MQTT_OR_GRPC")
									.trim().toUpperCase().contains("MQTT")
											? MqttSerialController.getDeviceInformation("MACID")
											: StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
													DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build())
													.getStrVal();
						
						String substring = macID.substring(6, 12);
						if (device.contains("FUJI")) {
							SystemState.getStatus().setTstatName("FUJI " + substring);
							testCase.getTestCaseInputs().setInputValue("LOCATION1_DEVICE1_NAME", "FUJI " + substring);
							SystemState.getStatus().setTstatName("FUJI " + substring);
						}else if (device.contains("GLENEAGLES")) {
							SystemState.getStatus().setTstatName("GLENEAGLES " + substring);
							testCase.getTestCaseInputs().setInputValue("LOCATION1_DEVICE1_NAME", "GLENEAGLES " + substring);
							SystemState.getStatus().setTstatName("GLENEAGLES " + substring);
						}
						flag = diy.setDeviceName(SystemState.getStatus().getTstatName().trim());
						if (flag) {
							SystemState.getStatus().IsThermostatNameSet(flag);
							flag = diy.clickOnNextButton();
							Keyword.ReportStep_Pass(testCase, "Device Name is choosen successfully Device Name- "
									+ SystemState.getStatus().getTstatName().trim());
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Unable to Set the device name");
						}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not able to locate Device Name Screen.");
						flag = false;
					}
				}
			}

//        } else {
//            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//                    "Not able to see the Steps to add device screen");
//            flag = false;
//        }
        return flag;
    }

    public static boolean chooseLocationStatNeedToInstall(TestCases testCase, FirstAlertDIYScreen diy,
                                                          String LocationName) {
        boolean flag = false;
        if (diy.isLocationNameAvailable(LocationName)) {
            flag = diy.selectLocationName(LocationName);
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Location mentioned is not available in the existing location list");
            flag = false;
        }
        return flag;
    }

    public static boolean performInitialInstallationForDIY(TestCases testCase, String installationFlow) {
        boolean flag = false;
        try {
            String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                    .trim();
            switch (device) {
                case "JASPER_SENIOR_NA_TRADE":
                case "JASPER_SENIOR_NA_RETAIL": {
                    performIntialInstallationStepsForJasperDIY(testCase, installationFlow);
                    break;
                }
                case "THOR":
                case "FLYCATCHER": {
                    performIntialInstallationStepsForFlycatcher_ThorDIY(testCase, installationFlow);
                    break;
                }
                case "FUJI":
                case "FUJI_X2S_TRADE":
                case "FUJI_X2S_RETAIL": {
                    flag = performIntialInstallationStepsForFujiDIY(testCase, installationFlow);
                    break;
                }
                case "DENALI_TRADE":
                case "DENALI_RETAIL":{
                    flag = performIntialInstallationStepsForDenaliDIY(testCase, installationFlow);
                    break;
                }
                case "GLENEAGLES_TRADE":{
                    flag = performInitialInstallationStepsForGleneaglesDIY(testCase, installationFlow);
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
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Keyword step : Exception raised : " + e.getMessage());
        }

        return flag;
    }

    public static boolean performInitialInstallationStepsForGleneaglesDIY(TestCases testCase, String installationFlow) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (installationFlow.equalsIgnoreCase("BLE")) {
            if ((FaDiyScreen.isTextPresent("SmartHub")&& ((FaDiyScreen.isNextButton(1) && FaDiyScreen.clickOnNextButton())|| FaDiyScreen.clickOnYesButton()))|| (FaDiyScreen.isPrepareHardwareScreen() && FaDiyScreen.clickOnYesButton())|| (FaDiyScreen.isSetUpNxtSmartThermostatKitScreen() && FaDiyScreen.clickOnNextButton())) {
                HomeUtils.printLogforSteps(testCase, flag, "Is Prepare Hadware/Set Up NXT Thermostat Kit screen visible ?.,> > ");
                if (FaDiyScreen.isInitiateParingScreen() && FaDiyScreen.clickOnYesButton()) {
                    HomeUtils.printLogforSteps(testCase, flag, "Is Initiate Pairing screen visible ?.,> > ");
                    if (FaDiyScreen.isBluetoothScanScreen()) {
                        HomeUtils.printLogforSteps(testCase, flag, "Is the Bluetooth scan screen visible ?.,> > ");
                    }else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not in the Bluetooth Scan screen");
						flag = false;
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "Not in the expected screen - Connect App steps screen");
                    flag = false;
                }

            } else {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Not in the expected screen - Thermostat wall");
                flag = false;
            }
        } else {
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
                    "Gleneagles device supports only BLE flow check the input you have given as " + installationFlow);
            flag = false;
        }
        return flag;
    
	}

	public static boolean performIntialInstallationStepsForFujiDIY(TestCases testCase, String installationFlow) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (installationFlow.equalsIgnoreCase("BLE")) {
            if (FaDiyScreen.isThermostatOnWallScreen() && FaDiyScreen.clickOnYesButton()) {
                HomeUtils.printLogforSteps(testCase, flag, "Is the Thermostat on wall screen visible ?.,> > ");
                if (FaDiyScreen.isTemperatureDisplayScreen() && FaDiyScreen.clickOnYesButton()) {
                    HomeUtils.printLogforSteps(testCase, flag, "Is the temperature screen visible ?.,> > ");
                    if (FaDiyScreen.isConnectAppStepsFUJIScreen() && FaDiyScreen.clickOnNextButton()) {
                        HomeUtils.printLogforSteps(testCase, flag, "Is the Connect app steps screen visible ?.,> > ");
                        if (FaDiyScreen.isCheckDisplayForBleFUJIScreen() && FaDiyScreen.clickOnNextButton()) {
                            HomeUtils.printLogforSteps(testCase, flag,
                                    "Is the Check display for Ble screen visible ?.,> > ");
                            if (FaDiyScreen.isBluetoothScanScreen()) {
                                HomeUtils.printLogforSteps(testCase, flag,
                                        "Is the Bluetooth scan screen visible ?.,> > ");
                            }else {
                            	Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
        								"Not in the Bluetooth Scan screen");
        						flag = false;
                            }
                        } else {
                            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                                    "Not in the expected screen - Check display for Ble wall");
                            flag = false;
                        }
                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                                "Not in the expected screen - Connect App steps screen");
                        flag = false;
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "Not in the expected screen - Thermostat displaying temperature");
                    flag = false;
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Not in the expected screen - Thermostat wall");
                flag = false;
            }
        } else {
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
                    "FUJI device supports only BLE flow check the input you have given as " + installationFlow);
            flag = false;
        }
        return flag;
    }

    public static boolean performIntialInstallationStepsForJasperDIY(TestCases testCase, String installationFlow) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (installationFlow.equalsIgnoreCase("BLE")) {

        } else {

        }
        return flag;
    }

    public static boolean performIntialInstallationStepsForFlycatcher_ThorDIY(TestCases testCase,
                                                                              String installationFlow) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (installationFlow.equalsIgnoreCase("MDNS")) {

        } else {

        }
        return flag;
    }

    public static boolean ConnectThermostatOnBLE(TestCases testCase,String deviceNeedToInstall) {
        boolean flag = false;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (FaDiyScreen.SelectBLEDevicefromBluetooth()) {
            Keyword.ReportStep_Pass(testCase, "Device Selected from list");
            if(deviceNeedToInstall.contains("GLENEAGLES")) {
            	if( MqttManager.enableDisableBroadCasting("TRUE",testCase,true)) {
            		FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(40))
    						.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
    				boolean result = wait.until(new Function<TestCases, Boolean>() {
    					public Boolean apply(TestCases t) {
    						if(FaDiyScreen.isConnectingToThermostatSpinning()) {
    							Keyword.ReportStep_Pass(testCase, "Connecting..");
    							return false;
    						}else if(FaDiyScreen.isConnected()) {
    							Keyword.ReportStep_Pass(testCase, "Connected..");
    							return true;
    						}
							return false;
    					}
    				});
    				flag=result;
            	}else {
            		 Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to Set the Connectable to TRUE");
            	}
			} else {
				if (FaDiyScreen.set4_DigitPin()) {
					Keyword.ReportStep_Pass(testCase, "security passcode entered and waiting for isu screen");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to enter security Code");
					flag = false;
				}
			}
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Select device from Scan list is failed");
            flag = false;
        }
        return flag;
    }

    public static boolean connectToJasperFujiOnWifi(TestCases testCase) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);

        return flag;
    }

    public static boolean isISUPerformScreen(TestCases testCase, FirstAlertDIYScreen diy, String ISUType, int timeOut) {
        boolean flag = false;
        switch (ISUType.toUpperCase()) {
            case "OUTDOOR AIR SENSOR":
            case "OUTDOOR AIR": {
                flag = diy.isOutDoorSensorScreen(timeOut);
                break;
            }
            case "HEATING SYSTEM": {
                flag = diy.isHeatingSystemScreen(timeOut);
                break;
            }
            case "FUEL SOURCE": {
                flag = diy.isFuelSourceScreen(timeOut);
                break;
            }
            case "REVERSING VALVE": {
                flag = diy.isReversingValveScreen(timeOut);
                break;
            }
            case "COMPRESSOR STAGES": {
                flag = diy.isCompressorStageScreen(timeOut);
                break;
            }
            case "COOLING STAGES": {
                flag = diy.isCoolingStageScreen(timeOut);
                break;
            }
            case "HEATING STAGES": {
                flag = diy.isHeatingStageScreen(timeOut);
                break;
            }
            case "AUXE TERMINAL CONTROL": {
                flag = diy.isAuxETerminalControlScreen(timeOut);
                break;
            }
            case "AUX BACKUP HEAT": {
                flag = diy.isAuxBackUpHeatScreen(timeOut);
                break;
            }
            case "EMERGENCY HEAT": {
                flag = diy.isEmergencyHeatScreen(timeOut);
                break;
            }
            case "BACKUP HEAT UPSTAGE TIMER": {
                flag = diy.isBackupHeatUpStageTimerScreen(timeOut);
                break;
            }
            case "BACKUP HEAT LOCKOUT": {
                flag = diy.isBackupHatLockOutScreen(timeOut);
                break;
            }
            case "COMPRESSOR LOCKOUT": {
                flag = diy.isCompressorLockoutScreen(timeOut);
                break;
            }
            case "LOCKOUT FAN AFTER COOL CALL":
            case "LOCKOUT FAN AFTER A COOL CALL": {
                flag = diy.isLockOutFanAfterCoolScreen(timeOut);
                break;
            }
            case "FAN OPERATION IN HEAT": {
                flag = diy.isFanOperationinHeatScreen(timeOut);
                break;
            }
            case "HEAT CYCLE PER HOUR-STAGE 1": {
                flag = diy.isHeatCyclePerHourStage1Screen(timeOut);
                break;
            }
            case "HEAT CYCLE PER HOUR-STAGE 2":
            case "RADIANT HEAT CYCLES PER HOUR-STAGE 2":
            case "HEAT CYCLES PER HOUR-STAGE 2":{
                flag = diy.isHeatCyclePerHourStage2Screen(timeOut);
                break;
            }
            case "COMPRESSOR CYCLES PER HOUR-STAGE 1": {
                flag = diy.isCompressorCyclePerHourStage1Screen(timeOut);
                break;
            }
            case "COMPRESSOR CYCLES PER HOUR-STAGE 2": {
                flag = diy.isCompressorCyclePerHourStage2Screen(timeOut);
                break;

            }
            case "BACKUP HEAT CYCLE PER HOUR": 
            case "BACKUP HEAT CYCLES PER HOUR": {
                flag = diy.isBackupHeatCyclesPerHourScreen(timeOut);
                break;

            }
            case "EMERGENCY HEAT CYCLES PER HOUR": {
                flag = diy.isEmergencyHeatCyclesPerHourScreen(timeOut);
                break;

            }
            case "BACKUP HEAT DIFFERENTIAL": {
                flag = diy.isStagingControlBackupHeatDifferential(timeOut);
                break;
            }
            case "STAGING CONTROL HIGH COOL STAGE": {
                flag = diy.isStagingControlHighCoolStageScreen(timeOut);
                break;
            }
            case "STAGING CONTROL HIGH HEAT STAGE": {
                flag = diy.isStagingControlHighHeatStageScreen(timeOut);
                break;
            }
            case "TEMPERATURE SCALE": {
                flag = diy.isTemperatureScaleScreen(timeOut);
                break;
            }
            case "SYSTEM CHANGEOVER": {
                flag = diy.isSystemChangeOverScreen(timeOut);
                break;
            }
            case "COMPRESSOR MINIMUM OFF TIME":
            case "COMPRESSOR PROTECTION": {
                flag = diy.isCompressorMinimumOffTimeScreen(timeOut);
                break;
            }
            case "ADAPTIVE INTELLIGENT RECOVERY": {
                flag = diy.isAdaptiveIntelligentRecoveryScreen(timeOut);
                break;
            }
            case "MAXIMUM COOL SETPOINT": {
                flag = diy.isMaximumCoolSetPointScreen(timeOut);
                break;
            }
            case "MINIMUM COOL SETPOINT": {
                flag = diy.isMinimumCoolSetPointScreen(timeOut);
                break;
            }
            case "MAXIMUM HEAT SETPOINT": {
                flag = diy.isMaximumHeatSetPointScreen(timeOut);
                break;
            }
            case "MINIMUM HEAT SETPOINT": {
                flag = diy.isMinimumHeatSetPointScreen(timeOut);
                break;
            }
            case "NUMBER OF AIR FILTERS": {
                flag = diy.isNumberOfAirFiltersScreen(timeOut);
                break;
            }
            case "AUTO CHANGEOVER DIFFERENTIAL": {
                flag = diy.isAutoChangeoverDifferentialScreen(timeOut);
                break;
            }
            case "CLOCK FORMAT": {
                flag = diy.isClockFormatScreen(timeOut);
                break;
            }
            case "DAYLIGHT SAVING TIME": {
                flag = diy.isDayLightSavingTimescreen(timeOut);
                break;
            }
            case "INDOOR TEMPERATURE DISPLAY OFFSET": {
                flag = diy.isIndoorTemperatureDisplayOffsetScreen(timeOut);
                break;
            }

            case "BACKLIGHTING": {
                flag = diy.isBacklightingScreen(timeOut);
                break;
            }

            case "IDLE SCREEN SELECTION": {
                flag = diy.isIdleScreenSelectionScreen(timeOut);
                break;
            }

            case "IDLE SCREEN CUSTOMIZATION": {
                flag = diy.isIdleScreenCustomizationScreen(timeOut);
                break;
            }

            case "HOME SCREEN CUSTOMIZATION": {
                flag = diy.isHomeScreenCustomizationScreen(timeOut);
                break;
            }

            case "AIR FILTER 1 REPLACEMENT REMINDER": {
                flag = diy.isAirFilter1ReplacementReminder(timeOut);
                break;
            }

            case "AIR FILTER 2 REPLACEMENT REMINDER": {
                flag = diy.isAirFilter2ReplacementReminder(timeOut);
                break;
            }

            case "KEYPAD LOCKOUT": {
                flag = diy.isKeypadLockoutScreen(timeOut);
                break;
            }

            case "BACKLIGHT BRIGHTNESS": {
                flag = diy.isBackLightBrightnessScreen(timeOut);
                break;
            }
            case "COOL CYCLES PER HOUR-STAGE 1": {
                flag = diy.isCoolCyclePerHourStage1Screen(timeOut);
                break;
            }
            case "BACKUP HEAT STAGES": {
                flag = diy.isBackupHeatSatgesScreen(timeOut);
                break;
            }
            case "COOL STAGES": {
                flag = diy.isCoolSatgesScreen(timeOut);
                break;
            }
            case "ELECTRIC FORCED AIR HEAT STAGE":
            case "HEAT STAGES": {
                flag = diy.isHeatingStageScreen(timeOut);
                break;
            }
            case "CWIRE ADAPTER": {
                flag = diy.isCWireAdapterScreen(timeOut);
                break;
            }
            case "HEAT TYPE": {
                flag = diy.isHeatTypeScreen(timeOut);
                break;
            }
            case "FUEL SOURCE RETAIL": {
                flag = diy.isFuelSourceScreenRetail(timeOut);
                break;
            }
            case "EFFICIENCY RETAIL": {
                flag = diy.isEfficiencyScreen(timeOut);
                break;
            }

            case "BACKUP HEAT": {
                flag = diy.isBackupHeatScreen(timeOut);
                break;
            }

            case "CHECK CONFIGURATION": {
                flag = diy.isCheckConfigurationScreen(timeOut);
                break;
            }

            case "VERIFICATION RETAIL": {
                flag = diy.isVerificationScreenAvailable(timeOut);
                break;
            }

            case "HEATING STAGES RCH": {
                flag = diy.isHeatingSystemScreenRch(timeOut);
                break;

            }
            case "RADIANT HEAT STAGE": {
                flag = diy.isRadiantHeatStagesScreen(timeOut);
                break;
            }

            case "RADIANT HEAT CYCLES PER HOUR-STAGE 1":
            case "HEAT CYCLES PER HOUR-STAGE 1": {
                flag = diy.isRadiantHeatCyclesPerHourStage1Screen(timeOut);
                break;
            }
            case "COOL CYCLES PER HOUR-STAGE 2": {
                flag = diy.isCoolCyclePerHourStage2Screen(timeOut);
                break;
            }
            case "EXTENDED FAN RUN TIME IN HEAT": {
                flag = diy.isExtendedFanRunTimeInHeatScreen(timeOut);
                break;
            }
            case "AIR FILTER TYPE": {
                flag = diy.isAirFilterTypeScreen(timeOut);
                break;
            }
            case "HUMIDIFICATION PAD REPLACEMENT REMINDER": {
                flag = diy.isHumidificationPadReplacementReminderScreen(timeOut);
                break;
            }
            case "DEHUMIDIFIER FILTER REPLACEMENT REMINDER": {
                flag = diy.isDehumFilterReplReminderScreen(timeOut);
                break;
            }
            case "VENTILATION TYPE": {
                flag = diy.isVentilationTypeScreen(timeOut);
                break;
            }
            case "VENTILATION FILTER CLEANING REMINDER": {
                flag = diy.isVentFilterCleaningRemScreen(timeOut);
                break;
            }
            case "UV DEVICES": {
                flag = diy.isUVDevicesScreen(timeOut);
                break;
            }
            case "LANGUAGE": {
                flag = diy.isLanguageScreen(timeOut);
                break;
            }
            case "HUMIDIFIER TYPE": {
                flag = diy.isHumidifierTypeScreen(timeOut);
                break;
            }
            case "DEHUMIDIFICATION TYPE": {
                flag = diy.isDehumidifierTypeScreen(timeOut);
                break;
            }
            case "INDOOR HUMIDITY DISPLAY OFFSET": {
                flag = diy.isIndoorHumidityOffsetScreen(timeOut);
                break;
            }
            case "INDOOR AIR QUALITY EQUIPMENT": {
                flag = diy.isIndoorAirQualityEquipmentScreen(timeOut);
                break;
            }
            case "APPLICATION": {
                flag = diy.isApplicationtScreen(timeOut);
                break;
            }
            case "FLOOR SENSOR": {
                flag = diy.isFloorSensorScreen(timeOut);
                break;
            }
            case "BACKUP HEAT TYPE": {
                flag = diy.isBackupHeatTypeScreen(timeOut);
                break;
            }
            case "EXTENDED FAN RUN TIME IN COOL": {
                flag = diy.isExtendedFanRunTimeInCoolScreen(timeOut);
                break;
            }
            case "INDOOR HUMIDITY": {
                flag = diy.isIndoorHumidityScreen(timeOut);
                break;
            }
            case "OCCUPANCY SENSING": {
                flag = diy.isOccupancySensingScreen(timeOut);
                break;
            }
            case "TEMPERATURE BALANCING": {
                flag = diy.isTemperatureBalancingScreen(timeOut);
                break;
            }
            case "WIRED SENSORS": {
                flag = diy.isWiredSensorsScreen(timeOut);
                break;
            }
            case "FREEZE PROTECTION": {
                flag = diy.isFreezeProtectionScreen(timeOut);
                break;
            }
            case "DRY CONTACTS 1": {
                flag = diy.isDryContacts1Screen(timeOut);
                break;
            }
            case "DRY CONTACTS 2": {
                flag = diy.isDryContacts2Screen(timeOut);
                break;
            }
            case "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2": {
                flag = diy.isStagingControlPrimaryHeatDifferentialScreen(timeOut);
                break;
            }
            case "STAGING CONTROL COOL DIFFERENTIAL STAGE 2": {
                flag = diy.isStagingControlCoolDifferentialScreen(timeOut);
                break;
            }
            case "HEATING STAGE 3 WIRING":
            case "HEAT STAGE 3 WIRING":{
                flag = diy.isHeatingStage3WiringScreen(timeOut);
                break;
            }
            case "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3": {
                flag = diy.isStagingControlPrimaryHeatDifferential3Screen(timeOut);
                break;
            }
            case "HEAT CYCLE PER HOUR-STAGE 3": 
            case "HEAT CYCLES PER HOUR-STAGE 3": {
                flag = diy.isHeatCyclePerHourStage3Screen(timeOut);
                break;
            }
            case "MINIMUM NON-COMPRESSOR ON TIME":
            case "NON COMPRESSOR ON TIME":{
                flag = diy.isMinNonCompressorOnTimeScreen(timeOut);
                break;
            }
            case "RADIANT FLOOR HEAT SENSING": {
              	 flag = diy.isRadiantFloorHeatSensingScreen(timeOut);
                  break;
             }
            case "FLOOR SENSOR WIRING ASSIGNMENT":{
              	 flag = diy.isFloorSensorWiringAssignmentScreen(timeOut);
                  break;
             }
            case "MINIMUM FLOOR TEMPERATURE LIMITS":
            case "MINIMUM FLOOR TEMPERATURE LIMIT":{
             	 flag = diy.isMinFloorTempLimitScreen(timeOut);
                 break;
            }
            case "MAXIMUM FLOOR TEMPERATURE LIMITS":
            case "MAXIMUM FLOOR TEMPERATURE LIMIT":{
             	 flag = diy.isMaxFloorTempLimitScreen(timeOut);
                 break;
            }
            case "FLOOR ECONOMY MODE":{
             	 flag = diy.isFloorEconomyModeScreen(timeOut);
                 break;
            }
            case "CONTROL MODE": {
             	 flag = diy.isControlModeScreen(timeOut);
                 break;
            }
			case "EQUIPMENT TYPE": 
			case "EQUIPMENT TYPE RETAIL": {
				flag = diy.isEquipmentTypeScreen(timeOut);
				break;

			}
			case "HIGH TEMPERATURE ALERT":
            case "LOW TEMPERATURE ALERT":
            case "HIGH HUMIDITY ALERT":
            case "LOW HUMIDITY ALERT":{
                flag = diy.isISUScreenPresent(ISUType, timeOut);
                break;
            }
            case "OUTDOOR TEMPERATURE DISPLAY OFFSET": {
                flag = diy.isOutdoorTempOffsetScreen(timeOut);
                break;
            }
            case "OUTDOOR HUMIDITY DISPLAY OFFSET": {
                flag = diy.isOutdoorHumidityOffsetScreen(timeOut);
                break;
            }
			case "L TERMINAL ALERT": {
				flag = diy.isLTerminalAlertScreen(timeOut);
				break;
			}
			case "BACKUP HEAT WIRING": {
				flag = diy.isBackupHeatWiringScreen(timeOut);
				break;
			}
			case "HEAT PUMP STAGE 2 WIRING": {
				flag = diy.isHeatPumpStage2WiringScreen(timeOut);
				break;
			}
			case "HEAT STAGING CONTROL": {
				flag = diy.isHeatStagingControlScreen(timeOut);
				break;
			}
			case "BACKUP HEAT OPERATION": {
				flag = diy.isBackupHeatOperationScreen(2);
				break;
			}
			case "EMERGENCY HEAT OPERATION": {
				flag = diy.isEmergencyHeatOperationScreen(timeOut);
				break;
			}
			case "BACKUP HEAT STAGE 2 DIFFERENTIAL HP":
			case "BACKUP HEAT STAGE 2 DIFFERENTIAL": {
				flag = diy.isBackupHeatStage2DifferentialScreen(timeOut);
				break;
			}

			case "BACKUP HEAT CYCLES PER HOUR - STAGE 2": {
				flag = diy.isBackupHeatCyclesPerHourStage2Screen(timeOut);
				break;

			}
			case "EXTERNAL FOSSIL FUEL KIT": {
				flag = diy.isExternalFossilFuelKitScreen(timeOut);
				break;

			}
			case "COOL STAGING CONTROL": {
				flag = diy.isCoolStagingControlScreen(timeOut);
				break;
			}
			case "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL":
			case "STAGING CONTROL - COOL STAGE 2 DIFFERENTIAL": {
				flag = diy.isStagingControlCompressorCoolStage2DifferentialScreen(timeOut);
				break;
			}
			case "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2": {
				flag = diy.isStagingControlCompressorHeatDifferentialStage2Screen(timeOut);
				break;
			}

			case "CHANGEOVER SENSOR": {
				flag = diy.isChangeoverSensorScreen(timeOut);
				break;
			}
			case "DRY CONTACT SWITCH": {
				flag = diy.isDryContactSwitchScreen(timeOut);
				break;
			}
			case "CHANGEOVER SENSOR WIRING": {
				flag = diy.isChangeoverSensorWiringScreen(timeOut);
				break;
			}

			case "FAN COIL STAGES": {
				flag = diy.isFanCoilStagesScreen(timeOut);
				break;
			}
			case "FAN STAGES": {
				flag = diy.isFanStagesScreen(timeOut);
				break;
			}
			case "MEDIUM SPEED WIRING": {
				flag = diy.isFanMediumSpeedWiringScreen(timeOut);
				break;
			}
			case "HIGH SPEED WIRING": {
				flag = diy.isFanHighSpeedWiringScreen(timeOut);
				break;
			}
			case "ALLOWED FAN MODES": {
				flag = diy.isAllowedFanModesScreen(timeOut);
				break;
			}
			case "START FAN ON HIGH SPEED": {
				flag = diy.isStartFanonHighSpeedScreen(timeOut);
				break;
			}
			case "FAN RESET TIMER": {
				flag = diy.isFanResetTimerScreen(timeOut);
				break;
			}
			case "PIPE SENSOR THRESHOLD FOR COOLING": {
				flag = diy.isPipeSensorThresholdforCoolingScreen(timeOut);
				break;
			}
			case "PIPE SENSOR THRESHOLD FOR HEATING": {
				flag = diy.isPipeSensorThresholdforHeatingScreen(timeOut);
				break;
			}
			case "FAN COIL HEAT STAGE": {
				flag = diy.isFanCoilHeatStageScreen(timeOut);
				break;
			}
			case "COOL STAGE 3 WIRING": {
				flag = diy.isCoolStage3WiringScreen(timeOut);
				break;
			}
			case "COOL STAGE 4 WIRING": {
				flag = diy.isCoolStage4WiringScreen(timeOut);
				break;
			}
			case "FAN COIL HEAT STAGE 3 WIRING": {
				flag = diy.isFanCoilHeatStage3WiringScreen(timeOut);
				break;
			}

			case "STAGING CONTROL - COOL STAGE 3 DIFFERENTIAL": {
				flag = diy.isStagingControlCompressorCoolStage3DifferentialScreen(timeOut);
				break;
			}
			case "STAGING CONTROL - COOL STAGE 4 DIFFERENTIAL": {
				flag = diy.isStagingControlCompressorCoolStage4DifferentialScreen(timeOut);
				break;
			}

			case "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 2": {
				flag = diy.iSStagingControlFanCoilHeatDifferentialStage2(timeOut);
				break;
			}
			case "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 3": {
				flag = diy.iSStagingControlFanCoilHeatDifferentialStage3(timeOut);
				break;
			}
			case "COOL CYCLES PER HOUR-STAGE 3": {
				flag = diy.isCoolCyclePerHourStage3Screen(timeOut);
				break;
			}

			case "COOL CYCLES PER HOUR-STAGE 4": {
				flag = diy.isCoolCyclePerHourStage4Screen(timeOut);
				break;
			}
			case "FAN COIL HEAT CYCLES PER HOUR-STAGE 1": {
				flag = diy.isFanCoilHeatCyclePerHourStage1Screen(timeOut);
				break;
			}

			case "FAN COIL HEAT CYCLES PER HOUR-STAGE 2": {
				flag = diy.isFanCoilHeatCyclePerHourStage2Screen(timeOut);
				break;
			}

			case "FAN COIL HEAT CYCLES PER HOUR-STAGE 3": {
				flag = diy.isFanCoilHeatCyclePerHourStage3Screen(timeOut);
				break;
			}
			case "BACKUP HEAT DIFFERENTIAL HP": {
				flag = diy.isStagingControlBackupHeatDifferential(timeOut);
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

    public static boolean ISUPerformInDif(TestCases testCase, FirstAlertDIYScreen diy, String ISUType,
                                          String ISUValue) {
        boolean flag = false;
        try {
            String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                    .trim().toUpperCase();
            switch (ISUType.toUpperCase()) {
                case "OUTDOOR AIR SENSOR":
                case "OUTDOOR AIR": {
                    flag = diy.ISUOutDoorSensor(ISUValue);
                    break;
                }
                case "HEATING SYSTEM": {
                    if (device.contains("DENALI")) {
                        flag = diy.ISUHeatingSystemFromDrpDwn(ISUValue);
                    } else {
                        flag = diy.ISUHeatingSystem(ISUValue);
                    }
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
                case "COMPRESSOR STAGES": {
                    flag = diy.ISUCompressorStages(ISUValue);

                    break;
                }
                case "COOLING STAGES": {
                    flag = diy.ISUCooling_HeatingStages(ISUValue);
                    break;
                }
                case "HEATING STAGES": {
                    flag = diy.ISUCooling_HeatingStages(ISUValue);
                    break;
                }
                case "AUXE TERMINAL CONTROL": {
                    flag = diy.ISUAUXPerE_TerminalControl(ISUValue);

                    break;
                }
                case "AUX BACKUP HEAT": {
                    flag = diy.ISUAuxBackupHeat(ISUValue);
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
                case "BACKUP HEAT LOCKOUT": {
                     flag = diy.turnOffOnTempAlert(testCase, ISUType, ISUValue);
                    break;
                }
                case "COMPRESSOR LOCKOUT": {
                	flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                    break;
                }
                case "LOCKOUT FAN AFTER COOL CALL":
                case "LOCKOUT FAN AFTER A COOL CALL": {
                    flag = diy.ISULockOutFanAfterCoolCall(ISUValue);
                    break;
                }
                case "FAN OPERATION IN HEAT": {
                    flag = diy.ISUFanOperationInHeat(ISUValue);
                    break;
                }
                case "HEAT CYCLE PER HOUR-STAGE 1":
                case "HEAT CYCLE PER HOUR-STAGE 2":
                case "HEAT CYCLE PER HOUR-STAGE 3":
                case "HEAT CYCLES PER HOUR-STAGE 3": {
                    flag = diy.setCyclePerHourForStage(ISUValue, 12);
                    break;
                }
                case "COMPRESSOR CYCLES PER HOUR-STAGE 1": {
                    flag = diy.ISUCompressorCyclesPerHour_Stage1(ISUValue);
                    break;
                }
                case "COMPRESSOR CYCLES PER HOUR-STAGE 2": {
                	flag = diy.ISUCompressorCyclesPerHour_Stage1(ISUValue);
                    break;
                }
                case "BACKUP HEAT CYCLE PER HOUR": 
                case "BACKUP HEAT CYCLES PER HOUR": {
                	flag = diy.setISUBackUpHeatCyclePerHour(ISUValue);
                    break;
                }
                case "EMERGENCY HEAT CYCLES PER HOUR": {
                  flag = diy.setISUEmergencyHeatCyclePerHour(ISUValue);

                    break;
                }
                case "STAGING CONTROL HIGH COOL STAGE":
                case "STAGING CONTROL HIGH HEAT STAGE": {
                    flag = diy.ISUStagingControlHighCoolHeatStage(ISUValue);
                    break;
                }
                case "TEMPERATURE SCALE": {
                    flag = diy.ISUTemperatureScale(ISUValue);
                    break;
                }
                case "SYSTEM CHANGEOVER": {
                    flag = diy.ISUSystemChangeOver(ISUValue);
                    break;
                }
                case "COMPRESSOR MINIMUM OFF TIME":
                case "COMPRESSOR PROTECTION": {
                    flag = diy.ISUCompressorMinimumOffTime(ISUValue);
                    break;
                }
                case "ADAPTIVE INTELLIGENT RECOVERY": {
                    flag = diy.ISUAdaptiveIntelligentRecovery(ISUValue);
                    break;
                }
                case "AUTO CHANGEOVER DIFFERENTIAL": {
                    flag = diy.ISUAutoChangeoverDifferential(ISUValue);

                    break;
                }
                case "CLOCK FORMAT": {
                    flag = diy.ISUClockFormat(ISUValue);
                    break;
                }
                case "DAYLIGHT SAVING TIME": {
                    flag = diy.ISUDayLightSavingTime(ISUValue);
                    break;
                }
                case "INDOOR TEMPERATURE DISPLAY OFFSET":
                case "OUTDOOR TEMPERATURE DISPLAY OFFSET":{
                    flag = diy.ISUTemperatureDisplayOffset(ISUValue);
                    break;
                }
                case "AIR FILTER 1 REPLACEMENT REMINDER": {
                    flag = diy.ISUAirFilterReplacementReminderDrpDwn(ISUValue);
                    break;
                }
                case "AIR FILTER 2 REPLACEMENT REMINDER": {
                    flag = diy.ISUAirFilterReplacementReminderDrpDwn(ISUValue);
                    break;
                }
                case "MAXIMUM COOL SETPOINT": {
                    flag = diy.ISUMaximumCoolSetPoint(ISUValue);
                    break;
                }
                case "MINIMUM COOL SETPOINT": {
                    flag = diy.ISUMinimumCoolSetPoint(ISUValue);
                    break;
                }
                case "MAXIMUM HEAT SETPOINT": {
                    flag = diy.ISUMaximumHeatSetPoint(ISUValue);
                    break;
                }
                case "MINIMUM HEAT SETPOINT": {
                    flag = diy.ISUMinimumHeatSetPoint(ISUValue);
                    break;
                }
                case "NUMBER OF AIR FILTERS": {
                    flag = diy.ISUNumberOfAirFilters(ISUValue);
                    break;
                }

                case "BACKLIGHTING": {
                    flag = diy.ISUBacklighting(ISUValue);
                    break;
                }

                case "IDLE SCREEN SELECTION": {
                    flag = diy.ISUIdleScreenSelection(ISUValue);
                    break;
                }

                case "IDLE SCREEN CUSTOMIZATION": {
                    flag = diy.ISUIdleScreenCustomization(ISUValue);
                    break;
                }

                case "HOME SCREEN CUSTOMIZATION": {
                    flag = diy.ISUHomeScreenCustomization(ISUValue);
                    break;
                }

                case "KEYPAD LOCKOUT": {
                    flag = diy.ISUKeypadLockout(ISUValue);
                    break;
                }

                case "BACKLIGHT BRIGHTNESS": {
                    flag = diy.ISUBackLightBrightness(ISUValue);
                    break;
                }
                case "COOL CYCLES PER HOUR-STAGE 1": {
                    flag = diy.ISUCompressorCyclesPerHour_Stage(ISUValue);
                    break;
                }
                case "BACKUP HEAT STAGES": {
                    flag = diy.ISUCooling_HeatingStages(ISUValue);
                    break;
                }
                case "COOL STAGES": {
                    flag = diy.ISUCooling_HeatingStages(ISUValue);
                    break;
                }
                case "ELECTRIC FORCED AIR HEAT STAGE":
                case "HEAT STAGES":
                case "FAN COIL HEAT STAGE" : {
                    flag = diy.ISUCooling_HeatingStages(ISUValue);
                    break;
                }

                case "CWIRE ADAPTER": {
                    flag = diy.cWireAdapter(ISUValue);
                    if (ISUValue.contains("NO")) {
                        isCWireadapter = false;
                    } else if (ISUValue.contains("YES")) {
                        isCWireadapter = true;
                    }
                    break;
                }

                case "HEAT TYPE": {
                    flag = diy.heatType(ISUValue);
                    break;
                }

                case "FUEL SOURCE RETAIL":
                case "EQUIPMENT TYPE RETAIL":{
                    flag = diy.fuelSourceRetail(ISUValue);
                    break;
                }

                case "EFFICIENCY RETAIL": {
                    flag = diy.efficiencyRetail(ISUValue);
                    break;
                }

                case "BACKUP HEAT": {
                    flag = diy.electricHeatStripsRetail(ISUValue);
                    break;
                }

                case "CHECK CONFIGURATION": {
                    flag = true;
                    break;
                }

                case "VERIFICATION RETAIL": {
                    flag = diy.verificationRetail(ISUValue);
                    break;
                }
                
                case "HEATING SYSTEM RETAIL ADV SETUP": {
                    flag = diy.ISUHeatingSystem(ISUValue);
                    break;
                }
                
                case "HEATING STAGES RCH": {
                    flag = diy.iSUCooling_HeatingStagesRCH(ISUValue);
                    break;
                }
                case "RADIANT HEAT STAGE": {
                    flag = diy.ISURadiantHeatStages(ISUValue);
                    break;
                }
                case "COOL CYCLES PER HOUR-STAGE 2": {
                    flag = diy.ISUCompressorCyclesPerHour_Stage(ISUValue);
                    break;
                }
                case "RADIANT HEAT CYCLES PER HOUR-STAGE 1":
                case "HEAT CYCLES PER HOUR-STAGE 1": {
                	flag = diy.setCyclePerHourForHeatStage(ISUValue);
                    break;
                }
                case "RADIANT HEAT CYCLES PER HOUR-STAGE 2": 
                case "HEAT CYCLES PER HOUR-STAGE 2": {
                    flag = diy.setCyclePerHourForStage(ISUValue, 12);
                    break;
                }
                case "EXTENDED FAN RUN TIME IN HEAT":
                case "EXTENDED FAN RUN TIME IN COOL": {
                  flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                    break;
                }
                case "AIR FILTER TYPE": {
                    flag = diy.selectAirFilterType(ISUValue);
                    break;
                }
                case "HUMIDIFICATION PAD REPLACEMENT REMINDER": {
                    flag = diy.selectHumPadReplReminder(ISUValue);
                    break;
                }
                case "DEHUMIDIFIER FILTER REPLACEMENT REMINDER": {
                    flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                    break;
                }
                case "VENTILATION TYPE": {
                    flag = diy.selectVentilationType(ISUValue);
                    break;
                }
                case "VENTILATION FILTER CLEANING REMINDER": {
                    flag = diy.selectVentFilterCleaningReminder(ISUValue);
                    break;
                }
                case "UV DEVICES": {
                    flag = diy.selectUvDevices(ISUValue);
                    break;
                }
                case "LANGUAGE": {
                    flag = diy.setLanguage(ISUValue);
                    break;
                }
                case "HUMIDIFIER TYPE": {
                    flag = diy.selectHumidifierType(ISUValue);
                    break;
                }
                case "DEHUMIDIFICATION TYPE": {
                    flag = diy.selectDehumidifierType(ISUValue);
                    break;
                }
                case "INDOOR HUMIDITY DISPLAY OFFSET":
                case "OUTDOOR HUMIDITY DISPLAY OFFSET":{
                	flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                    break;
                }
                case "INDOOR AIR QUALITY EQUIPMENT": {
                    flag = diy.selectIndoorAirQualityEquipment(ISUValue);
                    break;
                }
                case "APPLICATION": {
                    flag = diy.selectApplication(ISUValue);
                    break;
                }
                case "FLOOR SENSOR": {
                    flag = diy.selectFloorSensor(ISUValue);
                    break;
                }
                case "BACKUP HEAT TYPE": {
                    flag = diy.selectISUValue(testCase, ISUValue);
                    break;
                }
                case "INDOOR HUMIDITY": {
                    flag = diy.selectYesOrNo(ISUValue);
                    break;
                }
                case "OCCUPANCY SENSING": {
                    flag = diy.selectOccupancySensing(ISUValue);
                    break;
                }
                case "TEMPERATURE BALANCING": {
                    flag = diy.selectTemperatureBalancing(ISUValue);
                    break;
                }
                case "WIRED SENSORS": {
                    flag = diy.selectWiredSensors(ISUValue);
                    break;
                }
                case "FREEZE PROTECTION": {
                  flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                    break;
                }
                case "DRY CONTACTS 1": {
                    flag = diy.selectDryContacts1(ISUValue);
                    break;
                }
                case "DRY CONTACTS 2": {
                    flag = diy.selectDryContacts2(ISUValue);
                    break;
                }
                case "HUMIDIFIER PAD REPLACEMENT REMINDER": {
                    flag = diy.selectISUValue(testCase, ISUValue);
                    break;
                }
                case "SERVICE NEEDED ALERT WIRING": {
                    flag = diy.selectISUValue(testCase, ISUValue);
                    break;
                }
                case "DAY LIGHT SAVING TIME":
                case "RETURN AIR TEMPERATURE SENSOR":
                case "HEATING STAGE 3 WIRING":
                case "HEAT STAGE 3 WIRING": {
                    flag = diy.selectISUValue(testCase, ISUValue);
                    break;
                }
                case "MINIMUM NON-COMPRESSOR ON TIME": 
                case "NON COMPRESSOR ON TIME":{
                	 flag = diy.setMinNonCompressorOnTime(testCase, ISUValue);
                    break;
                }
                case "RADIANT FLOOR HEAT SENSING":
                case "CONTROL MODE": {
               	 flag = diy.selectRadiantFloorHeatSensing(testCase, ISUValue);
                   break;
                }
                case "FLOOR SENSOR WIRING ASSIGNMENT":{
               	 flag = diy.setFloorSensorWiringAssignment(testCase, ISUValue);
                   break;
                }
                case "MINIMUM FLOOR TEMPERATURE LIMITS":
                case "MINIMUM FLOOR TEMPERATURE LIMIT":{
                 	 flag = diy.setMinFloorTempLimit(testCase, ISUValue);
                     break;
                }
                case "MAXIMUM FLOOR TEMPERATURE LIMITS":
                case "MAXIMUM FLOOR TEMPERATURE LIMIT":{
                 	 flag = diy.setMaxFloorTempLimit(testCase, ISUValue);
                     break;
                }
                case "FLOOR ECONOMY MODE":{
                  	 flag = diy.ISUStagingControlHighCoolHeatStage(ISUValue);
                      break;
                 }
                case "EQUIPMENT TYPE": {            
                    flag = diy.ISUEquipmentType(ISUValue);
                    break;
                }
                case "HIGH TEMPERATURE ALERT":
                case "LOW TEMPERATURE ALERT":{
                	flag = diy.turnOffOnTempAlert(testCase, ISUType, ISUValue);
                     break;
                }
                case "HIGH HUMIDITY ALERT":
                case "LOW HUMIDITY ALERT":{
                	flag = diy.clickDropDownAndSelectISUValue(testCase, ISUValue);
                	break;

                }
				case "L TERMINAL ALERT": {
					flag = diy.ISULTerminalAlert(ISUValue);
					break;
				}
				case "BACKUP HEAT WIRING": {
					flag = diy.ISUBackupHeatWiring(ISUValue);
					break;
				}
				case "HEAT PUMP STAGE 2 WIRING": {
					flag = diy.ISUHeatPumpStage2Wiring(ISUValue);
					break;
				}
				case "HEAT STAGING CONTROL": {
					flag = diy.ISUHeatStagingControl(ISUValue);
					break;
				}
				case "BACKUP HEAT OPERATION": {
					flag = diy.ISUBackupHeatOperation(ISUValue);
					break;
				}
				case "EMERGENCY HEAT OPERATION": {
					flag = diy.ISUEmergencyHeatOperation(ISUValue);
					break;
				}

				case "BACKUP HEAT CYCLES PER HOUR - STAGE 2": {
					flag = diy.setISUBackUpHeatCyclePerHourStage2(ISUValue);
					break;
				}
				case "EXTERNAL FOSSIL FUEL KIT": {
					flag = diy.ISUExternalFossilFuelKit(ISUValue);
					break;
				}
				case "COOL STAGING CONTROL": {
					flag = diy.ISUHeatStagingControl(ISUValue);
					break;
				}
				case "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL":
				case "STAGING CONTROL - COOL STAGE 2 DIFFERENTIAL":
				case "STAGING CONTROL - COOL STAGE 3 DIFFERENTIAL":
				case "STAGING CONTROL - COOL STAGE 4 DIFFERENTIAL": {
					flag = diy.ISUStagingControlCompressorCoolStage2Differential(ISUValue);
					break;
				}
				case "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2": {
					flag = diy.ISUStagingControlCompressorHeatDifferentialStage2(ISUValue);
					break;
				}
				case "CHANGEOVER SENSOR": {
					flag = diy.ISUChangeoverSensor(ISUValue);
					break;
				}
				case "DRY CONTACT SWITCH": {
					flag = diy.ISUDryContactSwitch(ISUValue);
					break;
				}
				case "CHANGEOVER SENSOR WIRING": {
					flag = diy.ISUChangeoverSensorWiring(ISUValue);
					break;
				}
				case "FAN COIL STAGES": {
					flag = diy.ISUFanCoilStages(ISUValue);
					break;
				}
				case "FAN STAGES": {
					flag = diy.setISUFanStages(ISUValue);
					break;
				}
				case "MEDIUM SPEED WIRING": {
					flag = diy.ISUMediumSpeedWiring(ISUValue);
					break;
				}
				case "HIGH SPEED WIRING": {
					flag = diy.ISUHighSpeedWiring(ISUValue);
					break;
				}
				case "ALLOWED FAN MODES": {
					flag = diy.ISUAllowedFanModes(ISUValue);
					break;
				}
				case "START FAN ON HIGH SPEED": {
					flag = diy.ISUStartFanonHighSpeed(ISUValue);
					break;
				}
				case "FAN RESET TIMER": {
					flag = diy.ISUFanResetTimer(ISUValue);
					break;
				}
				case "PIPE SENSOR THRESHOLD FOR COOLING": {
					flag = diy.ISUPipeSensorThresholdforCooling(ISUValue);
					break;
				}
				case "PIPE SENSOR THRESHOLD FOR HEATING": {
					flag = diy.ISUPipeSensorThresholdforHeating(ISUValue);
					break;
				}
				case "COOL STAGE 3 WIRING":
				case "COOL STAGE 4 WIRING": {
					flag = diy.ISUCoolStage3Wiring(ISUValue);
					break;
				}

				case "FAN COIL HEAT STAGE 3 WIRING": {
					flag = diy.ISUFanCoilHeatStage3Wiring(ISUValue);
					break;
				}

				case "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 2":
				case "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 3":
				case "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 4": {
					flag = diy.ISUStagingControlCompressorCoolStage2Differential(ISUValue);
					break;
				}
				case "COOL CYCLES PER HOUR-STAGE 3":
				case "COOL CYCLES PER HOUR-STAGE 4": {
					flag = diy.ISUCompressorCyclesPerHour_Stage(ISUValue);
					break;
				}
				case "FAN COIL HEAT CYCLES PER HOUR-STAGE 1":
				case "FAN COIL HEAT CYCLES PER HOUR-STAGE 2":
				case "FAN COIL HEAT CYCLES PER HOUR-STAGE 3": {
					flag = diy.ISUFanCoilHeatCyclePerHour_Stage(ISUValue);
					break;
				}

				case "BACKUP HEAT DIFFERENTIAL":
				case "BACKUP HEAT STAGE 2 DIFFERENTIAL": {
					flag = diy.setISUBackupHeatDifferentialFanCoil(ISUValue);
					break;
				}
				case "BACKUP HEAT DIFFERENTIAL HP": 
                case "BACKUP HEAT STAGE 2 DIFFERENTIAL HP" : {
                    flag = diy.setISUBackupHeatDifferentialHP(ISUValue);

                    break;

                }
                case "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2":
                case "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3":
                case "STAGING CONTROL COOL DIFFERENTIAL STAGE 2":{
                	flag = diy.ISUBackupHeatStage2Differential(ISUValue);
                	break;
                }
                default: {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                            "ISU TYPE is not valid, pls check this ISU value is valid or not :" + ISUType);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (flag) {
            flag = diy.clickOnNextButton();
            Keyword.ReportStep_Pass(testCase,
                    "Successfully ISU set, ISU Type is : " + ISUType + " , ISU Value : " + ISUValue);
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE, "Not able to set the ISU value");
            flag = false;
        }

        return flag;
    }

    public static String _Do_Action_ThermostatConnectedWithExpectedNetwork(TestCases testCase, FirstAlertDIYScreen diy,
                                                                           boolean isMandatory, boolean isfactoryReset) {
        String status = "failed";
        try {
            if (isfactoryReset) {
                if (diy.isSelectDifferentWifiNetworkPopUp(3)) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "App showing wifi is configured, but in factory device or fresh device should not have wifi details");
                    status = "should not connect with wifi";
                } else {
                    Keyword.ReportStep_Pass(testCase, "Wifi configured screen not visible");
                    status = "not configured";
                }
            } else {
                if (diy.isSelectDifferentWifiNetworkPopUp(3)) {
                    if (!isMandatory) {
                        if (diy.clickOnNoButton()) {
                            status = "already configured";
                            Keyword.ReportStep_Pass(testCase,
                                    "Wifi configured but it same as expeteced, wifi reconfiguration will not initiate");
                        } else {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                    "Not able to click on No button in wifi configured screen");
                            status = "failed";
                        }
                    } else {
                        if (diy.clickOnYesButton()) {
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

    public static String deviceIsuConfigureStatus(TestCases testCase, FirstAlertDIYScreen diy, boolean isMandatory,
                                                  boolean isfactoryReset) {
        String status = "failed";
        try {
        	 String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                     .trim().toUpperCase();
            if (isfactoryReset) {
                if (diy.isNeedToKeepCurrentConfigurationPopUp()) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "App showing ISU is configured, but in factory device or fresh device should not have ISU Configuration");
                    status = "should not be isu configured";
                } else {
                    Keyword.ReportStep_Pass(testCase, "ISU configured popup not visible");
                    status = "not configured";
                }
            } else {
            	if(device.contains("GLENEAGLES")) {
            		if(isMandatory) {
            			
            		}else {
            			diy.clickonSkipBtn();
            			Keyword.ReportStep_Pass(testCase, "Skip is Selected in Two More Step Screen.");
						status = "skiped";
            		}
            	}else if(device.contains("DENALI") && device.contains("TRADE")) {
            		status = "already configured";
            		 Keyword.ReportStep_Pass(testCase,
                             "Since it is without factory reset , isu is already configured from device side.");
					} else {
						if (diy.isNeedToKeepCurrentConfigurationPopUp() ) {
							if (!isMandatory) {
								if (diy.clickOnYesButton()) {
									status = "already configured";
									Keyword.ReportStep_Pass(testCase,
											"using ISU configured, ISU reconfiguration will not initiate");
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on YES button in ISU configured screen");
									status = "failed";
								}
							} else {
								if (diy.clickOnNoButton()) {
									status = "change";
									Keyword.ReportStep_Pass(testCase,
											"ISU configured but its will reinitiate configuration freshly");
									if (device.contains("DENALI") && device.contains("RETAIL")) {
										diy.selectRoomName();
									}
								} else {
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to click on No button in ISU configured screen");
									status = "failed";
								}
							}
						} else {
							Keyword.ReportStep_Pass(testCase, "ISU configured popup not visible");
							status = "not configured";
						}
					}
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
            status = "exception";
        }
        return status;
    }

    public static boolean dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) {
        boolean flag = false;
        System.out.println(deviceName);
        FirstAlertDIYScreen diy = new FirstAlertDIYScreen(testCase);
        FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
        fWait.pollingEvery(Duration.ofSeconds(2));
        fWait.withTimeout(Duration.ofMinutes(UserTimeout));
        try {
            Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (diy.isDeviceSyncComplete(deviceName)) {
                            SystemState.getStatus().isThermostatOnlineSince(true);
                            System.out.println("Data Sync complete...");
                            return true;
                        } else if (diy.isDeviceSyncInProgress(deviceName)) {
                            System.out.println("DATA SYNC IN PROGRESS...");
                            return false;
                        } else if (diy.isDeviceSyncError(deviceName)) {
                            System.out.println("DATA SYNC ERROR");
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "DATA SYNC ERROR.");
                            return true;
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

            if (success) {
                Keyword.ReportStep_Pass(testCase, "Data sync completed...");
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Data sync didn't complete after waiting for " + UserTimeout + " minutes");
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
        return flag;
    }

    public static boolean deleteDevice(TestCases testCase) {
        boolean flag = false;
        String deviceName = testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");
        FirstAlertDIYScreen diy = new FirstAlertDIYScreen(testCase);
        FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
        fWait.pollingEvery(Duration.ofSeconds(1));
        fWait.withTimeout(Duration.ofMinutes(3));
        try {
            Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
                        String screenName = LyricUtils.getScreenName_FirstAlert(pageSource);
                        if (SystemState.getStatus().isDeletePerformed() && screenName.equals("dashboard")) {
                            Keyword.ReportStep_Pass(testCase, "Device deleted from APP , Device name is " + deviceName);
                            return true;
                        } else if (screenName.equals("dashboard")) {
                            if (diy.ClickOnDeviceNameOnDashboard()) {
                                if (diy.isSettingsIconPresent()) {
                                    if (diy.ClickOnSettingsIcon()) {
                                        Keyword.ReportStep_Pass(testCase, "Clicked on Setting icon.");
                                    }
                                }
                                Keyword.ReportStep_Pass(testCase,
                                        "Current screen is " + screenName + " its clicked on settings");
                            }
                            return false;
                        } else if (screenName.equals("primary card")) {
                            if (diy.ClickOnSettingsIcon()) {
                                Keyword.ReportStep_Pass(testCase,
                                        "Current screen is " + screenName + " its clicked on settings");
                            }
                            return false;
                        } else if (screenName.equals("device settings")) {
                            if (diy.ClickOnDeleteButton()) {
                                if (diy.isDeleteErrorPresent()) {
                                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                            "Received a Delete Error Message,After Deleteing the device");
                                    diy.clickOnOkButton();
                                } else {
                                    Keyword.ReportStep_Pass(testCase,
                                            "Current screen is " + screenName + " its clicked on delete thermostat");
                                }
                            }
                            return false;
                        } else if (screenName.equals("delete popup")) {
                            if (diy.ClickOnConfirmDeleteButton()&& diy.clickOnYesButton() && diy.ClickOnDoneButton()) {
                                Keyword.ReportStep_Pass(testCase,
                                        "Current screen is " + screenName + " its clicked on delete in popup");
                            }
                            SystemState.getStatus().isDeletePerformed(true);
                            return false;
                        }else if (screenName.equals("unknown")) {
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

    public static boolean executeIncorrectPinFlow(TestCases testCase, FirstAlertDIYScreen diy, String attemptType,
                                                  String expectedMessage) {
        boolean isSuccessful = false;
        try {
            if (!enterIncorrectSecurityPin(testCase, diy, attemptType) || !diy.clickOnOkButton()) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to enter incorrect pin or click OK on attempt: " + attemptType);
                isSuccessful = false;
            }
            Keyword.ReportStep_Pass(testCase,
                    "Entered incorrect security pin and clicked on OK for attempt: " + attemptType);
            WebElement errorMessageElement = null;
            switch (attemptType.toLowerCase()) {
                case "first":
                    errorMessageElement = diy.getIncorrectPinErrorMsg1();
                    break;
                case "second":
                    errorMessageElement = diy.getIncorrectPinErrorMsg2();
                    break;
                case "third":
                    errorMessageElement = diy.getConnectionFailedMsg();
                    break;
                default:
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Invalid attempt type: " + attemptType);
                    isSuccessful = false;
            }
            if (errorMessageElement == null || !errorMessageElement.isDisplayed()) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Error message is not displayed for " + attemptType + " attempt.");
                isSuccessful = false;
            }
            String actualErrorMessage = errorMessageElement.getDomAttribute("content-desc").toUpperCase();
            if (actualErrorMessage.contains(expectedMessage.toUpperCase())) {
                Keyword.ReportStep_Pass(testCase,
                        "Verified error message for " + attemptType + " attempt: " + expectedMessage);
                isSuccessful = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Unexpected error message for "
                        + attemptType + " attempt. Expected: " + expectedMessage + ", but got: " + actualErrorMessage);
                isSuccessful = false;
            }
            if (attemptType.equalsIgnoreCase("Third")) {
                if (!diy.clickOnTryAgainButton()) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Failed to click 'Try Again' button.");
                    isSuccessful = false;
                }

                Keyword.ReportStep_Pass(testCase, "Clicked 'Try Again' button successfully.");
                if (!diy.isChooseDeviceScreen()) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Failed to navigate to Add Device screen after clicking 'Try Again' button.");
                    isSuccessful = false;
                }

                Keyword.ReportStep_Pass(testCase, "Successfully navigated to Add Device screen.");
            }
        } catch (NoSuchElementException e) {
            isSuccessful = false;
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "No such element found while verifying message on attempt: " + attemptType + ". " + e.getMessage());
        } catch (Exception e) {
            isSuccessful = false;
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "An unexpected exception occurred while handling attempt: " + attemptType + ". " + e.getMessage());
        }
        return isSuccessful;
    }

    public static boolean enterIncorrectSecurityPin(TestCases testCase, FirstAlertDIYScreen diy, String attemptType) {
        boolean isSuccessful = false;
        try {
            if (attemptType.equalsIgnoreCase("First") && correctPin == null) {
                correctPin = diy.getPinFromThermostat("FUJI");
                if (correctPin == null || correctPin.length == 0) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Failed to retrieve a valid correct pin from the device.");
                    return false;
                }
            }
            char[] incorrectPin = generateRandomIncorrectPin(correctPin);
            System.out.println("Incorrect Pin: " + new String(incorrectPin));
            if (diy.isSecurityCodeScreen()) {
                if (diy.getSecurityPinElements().size() - 1 == incorrectPin.length) {
                    Actions actions = new Actions(testCase.getMobileDriver());
                    for (int i = 1; i < diy.getSecurityPinElements().size(); i++) {
                        actions.sendKeys(diy.getSecurityPinElements().get(i), String.valueOf(incorrectPin[i - 1]));
                    }
                    actions.perform();
                    isSuccessful = true;
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Mismatch between number of input fields and pin digits.");
                }
            }
        } catch (NoSuchElementException e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "No such element found while entering security pin: " + e.getMessage());
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "An unexpected exception occurred while entering the security pin: " + e.getMessage());
        }

        return isSuccessful;
    }

    private static char[] generateRandomIncorrectPin(char[] correctPin) {
        Random random = new Random();
        char[] randomPin;
        do {
            int randomNumber = random.nextInt(10000);
            String formattedPin = String.format("%04d", randomNumber);
            randomPin = formattedPin.toCharArray();
        } while (new String(randomPin).equals(new String(correctPin)));
        System.out.println("Generated Random Incorrect Pin: " + new String(randomPin));
        return randomPin;
    }

    public static boolean forceKillApp(TestCases testCase) {
        boolean flag = false;
        try {
            String platform = testCase.getMobileDriver().getPlatformName().toLowerCase();
            String android_Package = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.MOBILE_APP, "RESIDEO_HOME_Android_Package_Name").trim();
            String ios_Bundle = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.MOBILE_APP, "RESIDEO_HOME_IOS_Bundle_ID").trim();
            if (platform.equals("android")) {
                testCase.getMobileDriver().terminateApp(android_Package);
                flag = true;
            } else if (platform.equals("ios")) {
                testCase.getMobileDriver().terminateApp(ios_Bundle);
                flag = true;
            } else {
                System.out.println("Unsupported platform: " + platform);
                flag = false;
            }
        } catch (Exception e) {
            System.out.println("Error while force stopping app: " + e.getMessage());
            flag = false;
        }
        return flag;
    }

    public static boolean exitDIYProcessBeforeISUSetup(TestCases testCase, FirstAlertDIYScreen diy, String exitType) {
        boolean flag = false;
        try {
            if (diy.clickOnExitButton()) {
                if (exitType.equalsIgnoreCase("Exit")) {
                    if (diy.isExitSetupPopup() && diy.clickOnExitSetup() && diy.isChooseDeviceScreen()) {
                        Keyword.ReportStep_Pass(testCase, "Exit DIY registration process is successful.");
                        flag = true;
                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Failed to exit the ISU Setup: Choose Device Screen not displayed.");
                        flag = false;
                    }
                } else if (exitType.equalsIgnoreCase("Continue")) {
                    flag = diy.clickContinueButton();
                    if (flag) {
                        Keyword.ReportStep_Pass(testCase,
                                "Continued from exit setup pop-up the DIY registration process successfully.");
                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Failed to continue the DIY registration process.");
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Invalid exit type specified: " + exitType);
                    flag = false;
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click on the Exit button.");
                flag = false;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred while handling exit process: " + e.getMessage());
            flag = false;
        }
        return flag;
    }

    public static boolean modifyAdvancedSetupNew(TestCases testCase) {
        boolean flag = false;
        try {
            FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
            if (FaDiyScreen.isTemperatureDisplayScreen() && FaDiyScreen.clickOnYesButton()) {
                Keyword.ReportStep_Pass(testCase, "Temperature screen visible");
                if (FaDiyScreen.isConnectAppScreen() && FaDiyScreen.clickOnNextButton()) {
                    Keyword.ReportStep_Pass(testCase, "Connect App screen visible...");

                    if (FaDiyScreen.isCheckDisplayScreen() && FaDiyScreen.clickOnNextButton()) {
                        flag = true;
                        Keyword.ReportStep_Pass(testCase, "Check Display screen visible...");

                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                                "Not in the expected screen - Check Display screen not visible..");
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "Not in the expected screen - Connect app screen is not visible..");
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Not in the expected screen - Tempereature screen is not visible..");
            }

        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
                            + e.getMessage());
            return false;
        }
        return flag;
    }

    public static boolean setAndVerifyWirings(TestCases testCase, String wirings, boolean isValid) {
        // For C wire adapter , If it is YES then the (Y and G) or (K) should select by
        // default
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        boolean flag = false;
        String[] wireArray = wirings.toUpperCase().split(",");
        ArrayList<String> wirelist = new ArrayList<>(Arrays.asList(wireArray));
        if (isCWireadapter) {
            if (!(isWireSelected(testCase, "K") || isWireSelected(testCase, "Y1") && isWireSelected(testCase, "G"))) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "C Wire Adapter is YES, So Y and Gtogether or K induvidual relay should be ON. ");
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Status of Y:" + isWireSelected(testCase, "Y") + ", Status of G :"
                                + isWireSelected(testCase, "G") + ", Status of K :" + isWireSelected(testCase, "K"));
                return false;
            }
            if (isWireSelected(testCase, "K")) {
                if (isWireSelected(testCase, "G")) {
                    flag = FaDiyScreen.clickOnG();
                }
                if (isWireSelected(testCase, "Y1")) {
                    flag = FaDiyScreen.clickOnY1();
                }
            } else if (isWireSelected(testCase, "G") && isWireSelected(testCase, "Y1")) {
                if (isWireSelected(testCase, "K")) {
                    flag = FaDiyScreen.clickOnG();
                }
            }
        }
        if (wirelist.contains("A-L/A") != isWireSelected(testCase, "A-L/A")) {
            flag = FaDiyScreen.clickOnAL_A();
        }
        if (wirelist.contains("R") != isWireSelected(testCase, "R")) {
            flag = FaDiyScreen.clickOnR();
        }
        if (wirelist.contains("C") != isWireSelected(testCase, "C")) {
            flag = FaDiyScreen.clickOnC();
        }
        if ((wirelist.contains("RC")) != isWireSelected(testCase, "Rc")) {
            flag = FaDiyScreen.clickOnRc();
        }
        if (wirelist.contains("E") != isWireSelected(testCase, "E")) {
            flag = FaDiyScreen.clickOnE();
        }
        if ((wirelist.contains("W") || wirelist.contains("W1")) != isWireSelected(testCase, "W")) {
            flag = FaDiyScreen.clickOnW();
        }
        if (!isCWireadapter) {
            if (wirelist.contains("G") != isWireSelected(testCase, "G")) {
                flag = FaDiyScreen.clickOnG();
            }
            if (wirelist.contains("K") != isWireSelected(testCase, "K")) {
                flag = FaDiyScreen.clickOnK();
            }
            if ((wirelist.contains("Y1") || wirelist.contains("Y")) != isWireSelected(testCase, "Y1")) {
                flag = FaDiyScreen.clickOnY1();
            }
        } else {
            Keyword.ReportStep_Pass(testCase, "C Wire Adapter is YES, So Y and G or K should be default selected");
        }
        if (wirelist.contains("W2") != isWireSelected(testCase, "W2")) {
            flag = FaDiyScreen.clickOnW2();
        }
        if ((wirelist.contains("O/B") || wirelist.contains("O_B") || wirelist.contains("OB")) != isWireSelected(
                testCase, "O/B")) {
            flag = FaDiyScreen.clickOnOB();
        }
        if (wirelist.contains("Y2") != isWireSelected(testCase, "Y2")) {
            flag = FaDiyScreen.clickOnY2();
        }
        if (FaDiyScreen.clickOnValidateWiringBtn()) {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(2));
            fWait.withTimeout(Duration.ofMinutes(1));
            try {
                Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
                    public Boolean apply(CustomDriver driver) {
                        try {
                            if (FaDiyScreen.isWiresAreValid(1)) {
                                SystemState.getStatus().isThermostatOnlineSince(true);
                                System.out.println("Wire are Validated.");
                                return true;
                            } else if (FaDiyScreen.isValidatingCombination(1)) {
                                System.out.println("Validating wire combination...");
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
                                    "Wire Validating Initialized : Wire Validating Timed out while loading. Wait time : 3 minutes");
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

                if (success && isValid) {
                    Keyword.ReportStep_Pass(testCase, "Wire are Validated.");
                    flag = FaDiyScreen.clickOnNextButton();
                } else if (!success && !isValid) {
                    Keyword.ReportStep_Pass(testCase, "Wires are not valid...");
                    flag = true;
                } else {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not a valid wiring.");
                }
            } catch (TimeoutException e) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Wire Validating Initialized : Wire Validating Timed out while loading.");
            } catch (StaleElementReferenceException e) {
                Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
                return false;
            } catch (Exception e) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Exception occurred dataSyncProcessAndStatus(TestCases testCase, int UserTimeout, String deviceName) due to "
                                + e.getMessage());
                return false;
            }
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click on Validate Wiring");
            flag = false;
        }

        return flag;
    }

    public static boolean performIntialInstallationStepsForDenaliDIY(TestCases testCase, String installationFlow) {
        boolean flag = true;
        FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
        if (installationFlow.equalsIgnoreCase("BLE")) {
            if (FaDiyScreen.isThermostatOnWallScreen() && FaDiyScreen.clickOnYesButton()) {
                HomeUtils.printLogforSteps(testCase, flag, "Is the Thermostat on wall screen visible ?.,> > ");
                if (FaDiyScreen.isConnectAppStepsDenaliScreen() && FaDiyScreen.clickOnYesButton()) {
                    HomeUtils.printLogforSteps(testCase, flag, "Is the Connect app steps screen visible ?.,> > ");
                    if (FaDiyScreen.isBluetoothScanScreen()) {
                        HomeUtils.printLogforSteps(testCase, flag, "Is the Bluetooth scan screen visible ?.,> > ");
                    }else {
                    	Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Not in the Bluetooth Scan screen");
						flag = false;
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "Not in the expected screen - Connect App steps screen");
                    flag = false;
                }

            } else {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Not in the expected screen - Thermostat wall");
                flag = false;
            }
        } else {
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
                    "Denali device supports only BLE flow check the input you have given as " + installationFlow);
            flag = false;
        }
        return flag;
    }

    public static boolean isWireSelected(TestCases testCase, String wire) {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        if ((navigateTo.scrollToExpectedElementVertically("XPATH",
                "(//android.view.View[@content-desc='" + wire + "']/*)[1]", "DOWN"))
                || navigateTo.scrollToExpectedElementVertically("XPATH",
                "(//android.view.View[@content-desc='" + wire + "']/*)[1]", "UP")) {
            return MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[@content-desc='" + wire + "']/android.widget.ImageView", testCase, 1);
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                    "Requested Wire is Not present ,Requested Wire : " + wire);
            return false;
        }
    }

	public static boolean ConfigureTheDevice(TestCases testCase, String screenNameToconfigure,
			String valueToConfigure) {
		boolean flag = false;
		FirstAlertDIYScreen FaDiyScreen = new FirstAlertDIYScreen(testCase);
		if (screenNameToconfigure.contains("NXT")) {
			if (FaDiyScreen.isUsingNxtScreenPresent()) {
				Keyword.ReportStep_Pass(testCase, "Using Nxt Screen is Present.");
				if (FaDiyScreen.selectYesOrNo(valueToConfigure)) {
					flag = FaDiyScreen.clickOnNextButton();
					if (flag && valueToConfigure.contains("YES") && FaDiyScreen.isInstallNxtScreen()
							&& FaDiyScreen.clickOnNextButton()) {
						if (FaDiyScreen.BindNxtScreen()) {
							FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(40))
									.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
							boolean result = wait.until(new Function<TestCases, Boolean>() {
								public Boolean apply(TestCases t) {
									if (FaDiyScreen.isSuccess()) {
										Keyword.ReportStep_Pass(testCase, "Success Pop Up in NXT Binding.");
										return true;
									} else if (FaDiyScreen.isConnectingToThermostatSpinning()) {
										Keyword.ReportStep_Pass(testCase, "Connecting..");
										return false;
									}
									return false;
								}
							});
							flag = result;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Bind Nxt Screen is not Present.");
						}
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to select the req Option :" + valueToConfigure);
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Using Nxt Screen is not Present.");
			}
		} else if (screenNameToconfigure.contains("DEMAND CONTROL")) {
//			if (FaDiyScreen.isDemandControlScreenPresent()) {
//				Keyword.ReportStep_Pass(testCase, "Demand Control Screen is Present.");
//				if (FaDiyScreen.selectDemandControlOpt(valueToConfigure)) {
//					flag = FaDiyScreen.clickOnNextButton();
					flag=true;
					if (flag && valueToConfigure.contains("EIM") && FaDiyScreen.isInstallControlModuleScreen()
							&& FaDiyScreen.clickOnNextButton()) {
						if (FaDiyScreen.BindControlModuleScreen()) {
							FluentWait<TestCases> wait = new FluentWait<>(testCase).withTimeout(Duration.ofSeconds(40))
									.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
							boolean result = wait.until(new Function<TestCases, Boolean>() {
								public Boolean apply(TestCases t) {
									if (FaDiyScreen.isSuccess()) {
										Keyword.ReportStep_Pass(testCase, "Success Pop Up in EIM Binding.");
										return true;
									} else if (FaDiyScreen.isConnectingToThermostatSpinning()) {
										Keyword.ReportStep_Pass(testCase, "Connecting..");
										return false;
									}
									return false;
								}
							});
							flag = result;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Bind Control Module Screen is not Present.");
						}
					}

//				}
//			} else {
//				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Demand Control Screen is not Present.");
//			}
		}
		return flag;
	}
}