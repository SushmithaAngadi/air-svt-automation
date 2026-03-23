package com.resideo.utils.resideoPro_app;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideo_app.HomeUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;

public class ReziDIYUtils {
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

	public static boolean selectdeviceforDIYByUserExpects(TestCases testCase, ReziDIYScreen diy) {
		boolean flag = false;
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
				flag = diy.clickOnT9T10Thermostat();
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

	public static boolean performInitialInstallation(TestCases testCase, ReziDIYScreen diy, String modeOfConnect) {
		boolean flag = false;
		if (diy.isStartSetupScreen()) {
			flag = true;
		} else {
			Keyword.ReportStep_Pass(testCase, "Second retry to select device");
			if (selectdeviceforDIYByUserExpects(testCase, diy)) {
				if (diy.isStartSetupScreen()) {
					flag = true;
				} else {
					Keyword.ReportStep_Pass(testCase, "third retry to select device");
					if (selectdeviceforDIYByUserExpects(testCase, diy)) {
						if (diy.isStartSetupScreen()) {
							flag = true;
						} else {
							HomeUtils.printLogforSteps(testCase, false,
									"Not able tp find start setup screen in resideo pro app");
							flag = false;
						}
					}
				}
			}
		}
		HomeUtils.printLogforSteps(testCase, flag, "Is the Thermostat Start Setup Screen ?.,> > ");
		flag = flag && diy.clickOnNextButton();
		flag = flag && diy.isuseAppScreen();
		HomeUtils.printLogforSteps(testCase, flag, "Is it Use App Screen ?.,> > ");
		flag = flag && diy.clickOnNextButton();
		flag = flag && diy.isNetworkNameScreen();
		HomeUtils.printLogforSteps(testCase, flag, "Is it Network Name screen ?.,> > ");
		flag = flag && diy.clickOnNextButton();
//		flag = flag && diy.isLongPressScreen();
//		HomeUtils.printLogforSteps(testCase, flag, "Is it Long press screen ?.,> > ");
//		flag = flag && diy.clickOnNextButton();
		flag = flag && diy.isBlueToothScreen();
		HomeUtils.printLogforSteps(testCase, flag, "Is it Bluetooth Screen ?.,> > ");
		if (modeOfConnect.contains("AP MODE")) {
			flag = flag && diy.clickOnNoButton();
		} else {
			flag = flag && diy.clickOnYesButton();
		}

		return flag;
	}

	public static boolean connectToJasperThermostatWifi(TestCases testCase, ReziDIYScreen diy) {
		boolean flag = false;
//		DIYScreen diy1 = new DIYScreen(testCase);
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (diy.isOpenWIFISettingsButton(15)) {
				if (diy.clickOnOpenWIFISettingsButton()) {
					if (diy.connectWithThermostatWifiOnAndroid(SystemState.getStatus().getTstatName())) {
						if (diy.set4_DigitPin()) {
							Keyword.ReportStep_Pass(testCase, "Pin configured Successfuly");
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to do 4 digit Security PIN configuration");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to see Security PIN configuration");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to click on Open iOS Settings Button");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to see Open iOS Settings Button");
				flag = false;
			}
		} else {
			if (diy.isOpenWIFISettingsButton(5)) {
				if (diy.ConnectToWifiUsingAPMode_iOS()) {
					if (diy.set4_DigitPin()) {
						Keyword.ReportStep_Pass(testCase, "Pin configured Successfuly");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to do 4 digit Security PIN configuration");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to see Security PIN configuration");
					flag = false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to see Open iOS Settings Button");
				flag = false;
			}
		}
		return flag;
	}

	public static boolean connectToJasperThermostatBle(TestCases testCase, ReziDIYScreen diy) {
		boolean flag = false;

		if (diy.SelectBLEDevicefromBluetooth()) {
			Keyword.ReportStep_Pass(testCase, "Device Selected from list");
			if (diy.set4_DigitPin()) {
				Keyword.ReportStep_Pass(testCase, "security passcode entered and waiting for isu screen");
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "not able to enter security Code");
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Select device from Scan list is failed");
			flag = false;
		}
		return flag;
	}

	public static String getjasperThermostatNameForWifiConnect(TestCases testCase) {
		String StatName = null;
		String initialname = null;
		try {
			initialname = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal();

			String macID = StatCommands.getInstance().cattCommandsStub
					.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();

			String[] initialna = initialname.split(" ");

			String initialLetter = initialna[0].substring(0, 1).toUpperCase();
			String remLetter = initialna[0].substring(1).toLowerCase();
			String substring = macID.substring(6, 12);
			StatName = initialLetter + remLetter + " " + substring;
			Keyword.ReportStep_Pass(testCase, "Broadcasted Thermostat Wi-Fi name is " + StatName);
			System.out.println(StatName);
			SystemState.getStatus().setTstatName(StatName);

		} catch (Exception E) {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Exception Occured due to " + E.getMessage());
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Message shown in Thermostat " + initialname);
		}
		return StatName;
	}

	public static boolean ISUPerformInDif(TestCases testCase, ReziDIYScreen diy, String ISUType, String ISUValue) {
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
		case "COMPRESSOR STAGES": {
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
		case "BACKUP HEAT LOCKOUT": {
			flag = diy.ISUBackUpHeatLockout(ISUValue);
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
			flag = diy.setCyclePerHourForStage(ISUValue, 6);
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 2": {
			flag = diy.setCyclePerHourForStage(ISUValue, 6);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 1": {
			flag = diy.setCyclePerHourForStage(ISUValue, 12);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 2": {
			flag = diy.setCyclePerHourForStage(ISUValue, 12);
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
		case "EMERGENCY HEAT CYCLES PER HOUR": {
			flag = diy.ISUEmergencyHeatCyclePerHour(ISUValue, 12);

			break;
		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			flag = diy.ISUExternalFossilFuelKit(ISUValue);

			break;
		}
		case "STAGING CONTROL": {
			flag = diy.ISUStagingControlBackupHeatDifferential(ISUValue);
			break;
		}
		case "STAGING CONTROL HIGH COOL STAGE":
		case "STAGING CONTROL HIGH HEAT STAGE": {
			flag = diy.ISUStagingControlHighCoolStage(ISUValue);
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
		case "TEMPERATURE SENSOR SELECTION": {
			flag = diy.ISUTemperatureSensorSelection(ISUValue);

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
		case "NUMBER OF BEDROOMS": {
			flag = diy.ISUNumberOfBedrooms(ISUValue);

			break;
		}
		case "SIZE OF HOUSE": {
			flag = diy.ISUSizeOfHouse(ISUValue);

			break;
		}
		case "VENTILATION RATE": {
			flag = diy.ISUVentilationRate(ISUValue);

			break;
		}
		case "VENTILATION PRIORITY": {
			flag = diy.ISUVentilationPriority(ISUValue);

			break;
		}
		case "VENTILATION: LOW-TEMPERATURE LOCKOUT": {
			flag = diy.ISUVentilationLowTemperatureLockout(ISUValue);

			break;
		}
		case "VENTILATION: HIGH-TEMPERATURE LOCKOUT": {
			flag = diy.ISUVentilationHighTemperatureLockout(ISUValue);

			break;
		}
		case "VENTILATION: HIGH-DEW POINT LOCKOUT": {
			flag = diy.ISUVentilationHighDewPointLockout(ISUValue);

			break;
		}
		case "VENTILATION PERCENT ON TIME": {
			flag = diy.ISUVentilationPercentOnTIme(ISUValue);

			break;
		}
		case "VENTILATION FAN CONTROL": {
			flag = diy.ISUVentilationFanControl(ISUValue);

			break;
		}
		case "SCHEDULING OPTIONS": {
			flag = diy.ISUSchedulingOptions(ISUValue);
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
		case "FINISH WITH HIGH COOL STAGE": {
			flag = diy.ISUFinishWithHighCoolStage(ISUValue);
			break;
		}
		case "FINISH WITH HIGH HEAT STAGE": {
			flag = diy.ISUFinishWithHighHeatStage(ISUValue);
			break;
		}
		case "COMPRESSOR MINIMUM OFF TIME": {
			flag = diy.ISUCompressorMinimumOffTime(ISUValue);
			break;
		}

		case "EXTENDED FAN RUN TIME IN COOL": {
			flag = diy.ISUExtendedFanRunTimeInCool(ISUValue);
			break;
		}
		case "EXTENDED FAN RUN TIME IN HEAT": {
			flag = diy.ISUExtendedFanRunTimeInHeat(ISUValue);
			break;
		}
		case "ADAPTIVE INTELLIGENT RECOVERY": {
			flag = diy.ISUAdaptiveIntelligentRecovery(ISUValue);
			break;
		}
		case "HUMIDIFIER PAD REPLACEMENT REMINDER": {
			flag = diy.ISUHumidifierPadReplacementReminder(ISUValue);
			break;
		}
		case "DEHUMIDIFIER FILTER REPLACEMENT REMINDER": {
			flag = diy.ISUDehumidifierFilterReplacementReminder(ISUValue);
			break;
		}
		case "AUTO CHANGEOVER DIFFERENTIAL": {
			flag = diy.ISUAutoChangeoverDifferential(ISUValue);
			break;
		}
		case "VENTILATION LOW TEMPERATURE LOCKOUT": {
			flag = diy.ISUVentilationLowTemperatureLockout(ISUValue);
			break;
		}
		case "VENTILATION HIGH TEMPERATURE LOCKOUT": {
			flag = diy.ISUVentilationHighTemperatureLockout(ISUValue);
			break;
		}
		case "VENTILATION HIGH DEW POINT LOCKOUT": {
			flag = diy.ISUVentilationHighDewPointLockout(ISUValue);
			break;
		}
		case "VENTILATION CORE REMINDER": {
			flag = diy.ISUVentilationCoreReminder(ISUValue);
			break;
		}
		case "VENTILATION FILTER REMINDER": {
			flag = diy.ISUVentilationFilterReminder(ISUValue);
			break;
		}
		case "VENTILATOR FILTER CLEANING REMINDER": {
			flag = diy.ISUVentialtorFilterCleaningReminder(ISUValue);
			break;
		}
		case "NUMBER OF UV DEVICES": {
			flag = diy.ISUNumberOfUVDevices(ISUValue);
			break;
		}
		case "INACTIVE BACKLIGHT LEVEL": {
			flag = diy.ISUinActiveBacklightLevel(ISUValue);
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
		case "TEMPERATURE DISPLAY OFFSET": {
			flag = diy.ISUTemperatureDisplayOffset(ISUValue);
			break;
		}
		case "INDOOR TEMPERATURE DISPLAY OFFSET": {
			flag = diy.ISUTemperatureDisplayOffset(ISUValue);
			break;
		}
		case "AIR FILTER REPLACEMENT REMINDER": {
			flag = diy.ISUAirFilterReplacementReminder(ISUValue);
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
		case "UV BULB REPLACEMENT REMINDER": {
			flag = diy.ISUUVBulbReplacementReminder(ISUValue);
			break;
		}
		default: {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
					"ISU TYPE is not valid, pls check this ISU value is valid or not :" + ISUType);
			break;
		}
		}
		flag = diy.clickOnNextButton();
		if (flag) {
			Keyword.ReportStep_Pass(testCase,
					"Successfully ISU set, ISU Type is : " + ISUType + " , ISU Value : " + ISUValue);
		}

		return flag;
	}

	public static boolean isISUPerformExpectedScreen(TestCases testCase, ReziDIYScreen diy, String ISUType,
			int timeOut) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(1));
		fWait.withTimeout(Duration.ofSeconds(timeOut));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (isISUPerformScreen(testCase, diy, ISUType, 1)) {
							return true;
						} else {
							return false;
						}
					} catch (StaleElementReferenceException e) {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Not Able to find Exact screen, Exception is raised, exception is " + e);
						return false;
					} catch (NoSuchElementException e) {
//						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//								"Not Able to find Exact screen, Exception is raised, exception is " + e);
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not Able to find Exact screen, Exception is raised due to timeout, exception is " + e);
						return false;

					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not Able to find Exact screen, Exception is raised, exception is " + e);
						return false;
					}
				}
			});
			if (success) {
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not Able to find Exact screen");
			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not Able to find Exact screen, Exception is raised, exception is " + e);
		}

		return flag;

	}

	public static boolean isISUPerformScreen(TestCases testCase, ReziDIYScreen diy, String ISUType, int timeOut) {
		boolean flag = false;
		switch (ISUType.toUpperCase()) {
		case "OUTDOOR AIR SENSOR": {
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
		case "COOLING STAGE": {
			flag = diy.isCoolingStageScreen(timeOut);
			break;
		}
		case "HEATING STAGE": {
			flag = diy.isHeatingStageScreen(timeOut);
			break;
		}
		case "AUXE TERMINAL CONTROL": {
			flag = diy.isAuxETerminalControlScreen(timeOut);
			break;
		}
		case "BACKUP HEAT": {
			flag = diy.isBackUpHeatScreen(timeOut);
			break;
		}
		case "BACKUP HEAT STAGES": {
			flag = diy.isBackUpHeatStagesScreen(timeOut);
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
		case "OUTDOOR HEAT LOCKOUT": {
			flag = diy.isOutdoorHeatLockout(timeOut);
			break;
		}
		case "BACKUP HEAT LOCKOUT": {
			flag = diy.isBackupHatLockOutScreen(timeOut);
			break;
		}
		case "BACKUP HEAT DROOP": {
			flag = diy.isBackupHeatDroopScreen(timeOut);
			break;
		}
		case "COMPRESSOR LOCKOUT": {
			flag = diy.isCompressorLockoutScreen(timeOut);
			break;
		}
		case "FAN OPERATION IN HEAT": {
			flag = diy.isFanOperationinHeatScreen(timeOut);
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 1": {
			flag = diy.isCoolCyclesPerHourStage1Screen(timeOut);
			break;
		}
		case "COOL CYCLE PER HOUR-STAGE 2": {
			flag = diy.isCoolCyclesPerHourStage2Screen(timeOut);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 1": {
			flag = diy.isHeatCyclePerHourStage1Screen(timeOut);
			break;
		}
		case "HEAT CYCLE PER HOUR-STAGE 2": {
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
		case "BACKUP HEAT CYCLE PER HOUR": {
			flag = diy.isBackupHeatCyclesPerHourScreen(timeOut);
			break;

		}
		case "EMERGENCY HEAT CYCLES PER HOUR": {
			flag = diy.isEmergencyHeatCyclesPerHourScreen(timeOut);
			break;

		}
		case "EXTERNAL FOSSIL FUEL KIT": {
			flag = diy.isExternalFossilFuelKitScreen(timeOut);
			break;
		}
		case "STAGING CONTROL": {
			flag = diy.isStagingControlBackupHeatDifferential(timeOut);
			break;
		}
		case "STAGING CONTROL HIGH COOL STAGE":
		case "STAGING CONTROL HIGH HEAT STAGE": {
			flag = diy.isStagingControlHighCoolStageScreen(timeOut);
			break;
		}
		case "INDOOR SENSOR": {
			flag = diy.isIndoorSensorScreen(timeOut);
			break;
		}
		case "INDOOR SENSOR TYPE": {
			flag = diy.isIndoorSensorTypeScreen(timeOut);
			break;
		}
		case "VENTILATION TYPE": {
			flag = diy.isVentilationTypeScreen(timeOut);
			break;
		}
		case "VENTILATION CONTROL METHOD": {
			flag = diy.isVentilationControlMethodScreen(timeOut);
			break;
		}
		case "VENTILATION FAN CONTROL": {
			flag = diy.isVentilationFanControlScreen(timeOut);
			break;
		}
		case "TEMPERATURE SENSOR": {
			flag = diy.isTemperatureSensorSelectionScreen(timeOut);
			break;
		}
		case "SCHEDULING OPTIONS": {
			flag = diy.isSchedulingOptionsScreen(timeOut);
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
		case "FINISH WITH HIGH COOL STAGE": {
			flag = diy.isFinishWithHighCoolStageScreen(timeOut);
			break;
		}
		case "FINISH WITH HIGH HEAT STAGE": {
			flag = diy.isFinishWithHighHeatStageScreen(timeOut);
			break;
		}
		case "COMPRESSOR MINIMUM OFF TIME": {
			flag = diy.isCompressorMinimumOffTimeScreen(timeOut);
			break;
		}

		case "EXTENDED FAN RUN TIME IN COOL": {
			flag = diy.isExtendedFanRunTimeInCoolScreen(timeOut);
			break;
		}
		case "EXTENDED FAN RUN TIME IN HEAT": {
			flag = diy.isExtendedFanRunTimeInHeatScreen(timeOut);
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
		case "HUMIDIFIER PAD REPLACEMENT REMINDER": {
			flag = diy.isHumdifierPadReplacementReminderScreen(timeOut);
			break;
		}
		case "DEHUMIDIFIER FILTER REPLACEMENT REMINDER": {
			flag = diy.isDehumidifierFilterReplacementReminder(timeOut);
			break;
		}
		case "AUTO CHANGEOVER DIFFERENTIAL": {
			flag = diy.isAutoChangeoverDifferentialScreen(timeOut);
			break;
		}

		case "VENTILATION RATE": {
			flag = diy.isVentilationRateScreen(timeOut);
			break;
		}
		case "VENTILATION PRIORITY": {
			flag = diy.isVentilationPriorityScreen(timeOut);
			break;
		}
		case "VENTILATION LOW TEMPERATURE LOCKOUT": {
			flag = diy.iSVentilationLowTemperatureLockoutScreen(timeOut);
			break;
		}
		case "VENTILATION HIGH TEMPERATURE LOCKOUT": {
			flag = diy.iSVentilationHighTemperatureLockoutScreen(timeOut);
			break;
		}
		case "VENTILATION HIGH DEW POINT LOCKOUT": {
			flag = diy.isVentilationHighDewPointLockout(timeOut);
			break;
		}
		case "VENTILATION CORE REMINDER": {
			flag = diy.isVentilationCoreReminderScreen(timeOut);
			break;
		}
		case "VENTILATION FILTER REMINDER": {
			flag = diy.isVentilationFilterReminderScreen(timeOut);
			break;
		}
		case "VENTILATOR FILTER CLEANING REMINDER": {
			flag = diy.isVentilationFilterCleaningReminderScreen(timeOut);
			break;
		}
		case "NUMBER OF UV DEVICES": {
			flag = diy.isNumberOfUVDevicesScreen(timeOut);
			break;
		}
		case "INACTIVE BACKLIGHT LEVEL": {
			flag = diy.isInavtiveBacklightLevelScreen(timeOut);
			break;
		}
		case "CLOCK FORMAT": {
			flag = diy.isClockFormatScreen(timeOut);
			break;
		}
		case "UV BULB REPLACEMENT REMINDER": {
			flag = diy.isUVBulbReplacementReminder(timeOut);
			break;
		}
		case "DAYLIGHT SAVING TIME": {
			flag = diy.isDayLightSavingTimescreen(timeOut);
			break;
		}

		case "TEMPERATURE DISPLAY OFFSET": {
			flag = diy.isTemperatureDisplayOffsetScreen(timeOut);
			break;
		}
		case "INDOOR TEMPERATURE DISPLAY OFFSET": {
			flag = diy.isIndoorTemperatureDisplayOffsetScreen(timeOut);
			break;
		}
		case "AIR FILTER REPLACEMENT REMINDER": {
			flag = diy.isAirFilterReplacementReminder(timeOut);
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

	public static boolean verifyStat_App_connect_untilTimeOut(TestCases testCase,
			int exact_ble_AP_disConnection_Timeout, int maximumWaitTimeOut, int extreme_Timeout, int timeOutInMins) {
		boolean flag = false;
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(3));
		fWait.withTimeout(Duration.ofMinutes(timeOutInMins));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						String timeStatus = currentStatusOfConnection_live(exact_ble_AP_disConnection_Timeout,
								maximumWaitTimeOut, extreme_Timeout);
						if (timeStatus.equals("completed")) {
							if (pageSource.contains("Connection Interrupted".toUpperCase())
									&& pageSource.contains("Reconnect".toUpperCase())) {
								Keyword.ReportStep_Pass(testCase, "Time Completed and Disconnect Popup displaying");
								SystemState.getStatus().isDisconnected(true);
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase,
										"Time Completed but there is no PopUp, Wait for 1 mins");
								System.out.print(timeStatus);
								return false;
							}
						} else if (timeStatus.equals("overdue")
								&& !pageSource.contains("Connection Interrupted".toUpperCase())
								&& !pageSource.contains("Reconnect".toUpperCase())) {
							SystemState.getStatus().isDisconnected(false);
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Resideo Pro App not disconnected even 30 mins Time Over, Test Failed");
							return true;
						} else if (timeStatus.equals("overdue")
								&& pageSource.contains("Connection Interrupted".toUpperCase())
								&& pageSource.contains("Reconnect".toUpperCase())) {
							SystemState.getStatus().isDisconnected(true);
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Resideo Pro App disconnected but took morethan 30 mins Time Over Time extend for "
											+ SystemState.getStatus().remaining_DisconnectionTime()
											+ " seconds , Test Failed");
							return true;
						} else if (timeStatus.equals("incomplete")) {
							if (pageSource.contains("Connection Interrupted".toUpperCase())
									&& pageSource.contains("Reconnect".toUpperCase())) {
								SystemState.getStatus().isDisconnected(true);
								return true;
							} else {
								System.out.print(".");
								return false;
							}

						} else {
							System.out.println("unknown....");
							return false;
						}
					} catch (StaleElementReferenceException e) {
						return false;
					} catch (NullPointerException e) {
						return false;
					} catch (NoSuchElementException e) {
						return false;
					} catch (TimeoutException e) {
						return false;
					} catch (Exception e) {
						return false;
					}
				}
			});

			if (success && !SystemState.getStatus().isDisconnected()
					&& !SystemState.getStatus().ble_AP_Connection_Status().contains("overdue")) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Device is not disconnected and 31 mins crossed");

			} else if (success && SystemState.getStatus().isDisconnected()
					&& SystemState.getStatus().ble_AP_Connection_Status().contains("incomplete")) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Broadcast Connection is disconnected, Disconnected before 30 mins");
				flag = false;
			} else if (success && SystemState.getStatus().isDisconnected()
					&& SystemState.getStatus().ble_AP_Connection_Status().contains("overdue")) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Broadcast Connection is disconnected, Disconnected After 30 mins");
				flag = false;

			} else if (success && SystemState.getStatus().isDisconnected()
					&& SystemState.getStatus().ble_AP_Connection_Status().contains("completed")) {
				Keyword.ReportStep_Pass(testCase,
						"Broadcast Connection is disconnected, Disconnected between 30 mins to 31 mins");
				flag = true;
			} else {
				if (success) {
					Keyword.ReportStep_Pass(testCase,
							"is App disconnected " + SystemState.getStatus().isDisconnected());
					Keyword.ReportStep_Pass(testCase,
							"30 mins Timer is " + SystemState.getStatus().ble_AP_Connection_Status());
					flag = true;
				} else {
					Keyword.ReportStep_Pass(testCase,
							"is App disconnected " + SystemState.getStatus().isDisconnected());
					Keyword.ReportStep_Pass(testCase,
							"30 mins Timer is " + SystemState.getStatus().ble_AP_Connection_Status());
					flag = false;
				}
			}

		} catch (StaleElementReferenceException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		} catch (NoSuchElementException e) {
			return false;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception is occured in public static boolean verifyStat_App_connect_untilTimeOut() due to "
							+ e.getMessage());
			return false;
		}
		return flag;
	}

	public static String currentStatusOfConnection_live(int exact_ble_AP_disConnection_Timeout, int maximumWaitTimeOut,
			int extreme_Timeout) {
		String status = null;

		long pairingStartedTime = SystemState.getStatus().pairingStartTime();
		long currentTime = System.currentTimeMillis() / 1000;
		long progressTime = currentTime - pairingStartedTime;
		SystemState.getStatus().remaining_DisconnectionTime(progressTime);
		System.out.print(progressTime);
//		if (progressTime == 1800) {
		if (progressTime == exact_ble_AP_disConnection_Timeout) {
			status = "completed";
		} else if (progressTime > maximumWaitTimeOut) {
			status = "overdue";
		} else if (progressTime >= extreme_Timeout) {
			status = "overdue";
		} else if (progressTime < exact_ble_AP_disConnection_Timeout) {
			status = "incomplete";
		} else if (progressTime <= maximumWaitTimeOut && progressTime <= extreme_Timeout) {
			status = "completed";
		}
//		System.out.println(status);
		SystemState.getStatus().ble_AP_Connection_Status(status);
		return status;
	}

	public static boolean doConfigureOnDevice(TestCases testCase, ReziDIYScreen diy) {
		boolean flag = false;
		if (diy.isconfigureOnDeviceScreen(10)) {
			if (diy.clickOnNextButton()) {
				if (diy.isFindQR_Screen(10)) {
					if (diy.clickOnNextButton()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Navigated to QR Scan Screen");
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Next from Configure on device screen");
					}
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find QR Code screen");
				}

			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on Next from Configure on device screen");
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to find Configure on device screen");
		}

		return flag;
	}

	public static boolean ScanQR_code_EnterMacManual(TestCases testCase, ReziDIYScreen diy, String qr_manualMac) {
		boolean flag = false;
		try {
			String macID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "MAC_ID");
			if (diy.isScanQRCode_Screen(10)) {

				if (qr_manualMac.contains("MANUAL")) {

					if (diy.clickOnEnterMacManuallyButton()) {

						if (diy.isEnterMacAddressScreen(10)) {

							if (diy.clickOnEnterMacManuallyTextBox()) {

								if (diy.enterMacIDManually(macID.toUpperCase())) {
									if (diy.clickOnNextButton()) {
										flag = true;
										Keyword.ReportStep_Pass(testCase, "Sucessfully Entered mac ID manually");
									} else {
										flag = false;
										Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Not able to click on Next from Enter mac Manually text box from QR scan code screen");
									}
								} else {
									flag = false;
									Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to set mac ID on Enter mac Manually text box from QR scan code screen");
								}
							} else {
								flag = false;
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to click on Enter mac Manually text box from QR scan code screen");
							}
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to find Enter mac Manually on mac Address screen");
						}
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to click on Enter mac Manually from QR scan code screen");
					}
				} else {
					flag = true;
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to find Configure on device screen");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to find Configure on device screen");
		}
		return flag;
	}

}
