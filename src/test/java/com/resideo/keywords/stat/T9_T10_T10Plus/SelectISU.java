package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.time.Duration;
import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class SelectISU extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public SelectISU(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^User select GUI ISU Type (.+) and ISU Name as (.+)$")
	@Override
	@KeywordStep(gherkins = "^User select GUI ISU Type (.+) and ISU Name as (.+)$")
	public boolean keywordSteps() throws KeywordException {
		String option = exampleData.get(1);
		String screenName = exampleData.get(0);
		if (testCase.isTestSuccessful()) {

			SetUpDevice_T9_T10_T0Plus gui = new SetUpDevice_T9_T10_T0Plus();
			try {
				switch (screenName.toUpperCase()) {
				case "TEMP SCALE":
					flag = gui.clickOnTemperatureScale(option);
					break;
				case "OUTDOOR SENSOR TYPE":
					flag = gui.selectOutdoorTemperature(option);
					break;
				case "OUTDOOR TEMPERATURE":
					flag = gui.selectOutdoorTemperature_1060(option);
					break;
				case "SYSTEM TYPE":
					flag = gui.selectSystemType(option);
					break;
				case "EQUIPMENT TYPE":
					flag = gui.selectEquipmentType(option);
					break;
				case "REVERSING VALVE":
					flag = gui.selectReversingValve(option);
					break;
				case "FLOOR SENSOR":
					if (gui.isTextIsPresentInScreen(testCase, Duration.ofSeconds(30), 90, 3, 230, 30, 1,
							"Floor Sensor")) {
						flag = gui.selectFloorSensor(option.toUpperCase());
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Room type screen, Room type is " + option);
						flag = false;
					}
					break;
				case "BACKUP HEAT":
					if (gui.isBackupHeatScreen()) {
						flag = gui.selectBackUpHeatType(option);
					} else {
						ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Backup heat screen is not visible");
						flag = false;
					}

					break;
				case "BACKUP HEAT STAGES":
					flag = gui.setBackHeatStagesOnly(option.toUpperCase().replace("HEAT", "").trim());
					break;
				case "EQUIPMENT STAGES":
					String cool = null;
					String heat = null;
					if (option.toUpperCase().contains("COOL") && option.toUpperCase().contains("HEAT")) {
						String[] stages = option.toUpperCase().split(",");
						if (stages[0].contains("COOL")) {
							cool = stages[0].replace("COOL", "").trim();
						} else if (stages[0].contains("HEAT")) {
							heat = stages[0].replace("HEAT", "").trim();
						}

						if (stages[1].contains("COOL")) {
							cool = stages[1].replace("COOL", "").trim();
						} else if (stages[1].contains("HEAT")) {
							heat = stages[1].replace("HEAT", "").trim();
						}
					} else if (option.toUpperCase().contains("COOL") && !option.toUpperCase().contains("HEAT")) {
						cool = option.toUpperCase().replace("COOL", "").trim();
					} else if (!option.toUpperCase().contains("COOL") && option.toUpperCase().contains("HEAT")) {
						heat = option.toUpperCase().replace("HEAT", "").trim();
					}
					flag = gui.equipmentStages(cool, heat);
					break;
				case "BACKUP EQUIPMENT STAGES":
					String compressor = null;
					String backup_heat = null;
					if (option.toUpperCase().contains("COMPRESSOR") && option.toUpperCase().contains("BACKUP HEAT")) {
						String[] stages = option.toUpperCase().split(",");
						if (stages[0].contains("COMPRESSOR")) {
							compressor = stages[0].replace("COMPRESSOR", "").trim();
						} else if (stages[0].contains("BACKUP HEAT")) {
							backup_heat = stages[0].replace("BACKUP HEAT", "").trim();
						}

						if (stages[1].contains("COMPRESSOR")) {
							compressor = stages[1].replace("COMPRESSOR", "").trim();
						} else if (stages[1].contains("BACKUP HEAT")) {
							backup_heat = stages[1].replace("BACKUP HEAT", "").trim();
						}
					} else if (option.toUpperCase().contains("COMPRESSOR")
							&& !option.toUpperCase().contains("BACKUP HEAT")) {
						compressor = option.toUpperCase().replace("COMPRESSOR", "").trim();
					} else if (!option.toUpperCase().contains("COMPRESSOR")
							&& option.toUpperCase().contains("BACKUP HEAT")) {
						backup_heat = option.toUpperCase().replace("BACKUP HEAT", "").trim();
					}
					flag = gui.heatPump_equipmentStages(compressor, backup_heat);
					break;
				case "FAN CONTROL":
				case "FANCONTROL":
					flag = gui.selectFanControl(option);
					break;
				case "CONTROL MODE":
				case "CONTROLMODE":
					flag = gui.selectControlMode(option);
					break;
				case "CHANGEOVER":
				case "CHANGE OVER":
					flag = gui.selectChangOver(option);
					break;
				case "CHANGEOVER DIFFERENTIAL":
				case "CHANGE OVER DIFFERENTIAL":
					flag = gui.setChangeOverDifferential(option);
					break;
				case "ADVANCED SETUP":
				case "ADVANCEDSETUP":
					flag = gui.selectAdvanceSetup(option);
					break;
				case "FINISH WITH HIGH HEAT STAGE":
					if (gui.isSecondaryHeader_screen("Finish With High Heat Stage")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectStagingControlHighHeatStage(option);
						}
					} else {
						flag = false;
					}
					break;
				case "BACKUP HEAT DIFFERENTIAL IN STAGING CONTROL":
					if (gui.isSecondaryHeader_screen("Backup Heat Differential")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "COOL CYCLES PER HOUR IN CYCLE RATES":
					if (gui.isSecondaryHeader_screen("Cool Cycles Per Hour")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "RADIANT HEAT CYCLES PER HOUR IN CYCLE RATES":
					if (gui.isSecondaryHeader_screen("Radiant Heat Cycles Per Hour")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;

				case "BACKUP HEAT CYCLES PER HOUR IN CYCLE RATES":
					if (gui.isSecondaryHeader_screen("Backup Heat Cycles Per Hour")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "MINIMUM COMPRESSOR OFF TIME":

					if (gui.isSecondaryHeader_screen("Minimum Compressor Off Time")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectTemperatureControl_3240(option);
						}
					} else {
						flag = false;
					}

					break;
				case "MINIMUM NON COMPRESSOR ON TIME":
					if (gui.isSecondaryHeader_screen("Minimum Non")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "EXTENDED FAN RUN TIMES":
					if (gui.isSecondaryHeader_screen("Extended Fan Run Time")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "ADAPTIVE INTELLIGENT RECOVERY":
					if (gui.isSecondaryHeader_screen("Adaptive")) {
						flag = gui.selectAdaptiveIntelligentRecovery(option);
					} else {
						flag = false;
					}
					break;
				case "TEMPERATURE RANGE STOPS":
					if (gui.isSecondaryHeader_screen("Temperature Range Stops")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "KEYPAD LOCKOUT":
					if (gui.isPrimaryHeader_screen("Keypad Lockout")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "SENSOR ARE WIRED TO YOUR SYSTEM":
					if (gui.isSecondaryHeader_screen("WIRED")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "WIRED FLOOR TEMPERATURE SENSOR":
					if (gui.isSecondaryHeader_screen("Terminals are Wired")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectWiredFloorTemperatureSensor(option);
						}
					} else {
						flag = false;
					}
					break;
				case "DRY CONTACTS":
					if (gui.isPrimaryHeader_screen("Dry Contacts")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "FILTER TYPE":
				case "NUMBER OF AIR FILTERS":
				case "AIR FILTER REPLACEMENT REMINDER":
					if (gui.isPrimaryHeader_screen("Filtration")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;

				case "TYPE OF HUMIDIFIER":
					if (gui.isSecondaryHeader_screen("What type of hum")) {
						flag = gui.selectTypeOfHumidifier(option);
					} else {
						flag = false;
					}
					break;
				case "HUMIDIFIER PAD REPLACEMENT REMINDER":
					if (gui.isSecondaryHeader_screen("Pad Replacement")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "WHICH SENSOR WILL BE USED FOR HUMIDIFICATION CONTROL":
					if (gui.isSecondaryHeader_screen("Which Sensor will be used for")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "WHAT TERMINALS ARE WIRED TO THE HUMIDIFIER":
					if (gui.isSecondaryHeader_screen("Terminals are Wired to the")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectHumidifierTerminalareWired(option);
						}
					} else {
						flag = false;
					}
					break;
				case "HUMIDIFICATION WINDOWS PROTECTION":
					if (gui.isSecondaryHeader_screen("Window")) {
						flag = gui.selecHumidifierWindowsProtection(option);
					} else {
						flag = false;
					}
					break;
				case "SYSTEM MODES ALLOWING HUMIDIFICATION":
					if (gui.isSecondaryHeader_screen("System Modes Allowing")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "HUMIDIFICATION CONTROL":
					if (gui.isSecondaryHeader_screen("Control")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "TYPE OF DEHUMIDIFIER":
					if (gui.isSecondaryHeader_screen("What Type of Dehumidification")) {
						flag = gui.selectTypeOfDeHumidifier(option);
					} else {
						flag = false;
					}
					break;
				case "WHICH SENSOR WILL BE USED FOR DEHUMIDIFICATION CONTROL":
					if (gui.isSecondaryHeader_screen("Which Sensor will be used")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "WHAT TERMINALS ARE WIRED TO THE DEHUMIDIFIER":
					if (gui.isSecondaryHeader_screen("Terminals are Wired")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectDeHumidifierTerminalareWired(option);
						}
					} else {
						flag = false;
					}
					break;
				case "DEHUMIDIFIER FILTER REPLACEMENT REMINDER":
					if (gui.isSecondaryHeader_screen("Filter Replacement")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "SYSTEM MODES ALLOWING DEHUMIDIFICATION":
					if (gui.isSecondaryHeader_screen("System Modes Allowing")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "DEHUMIDIFICATION FAN CONTROL":
					if (gui.isSecondaryHeader_screen("Fan Control")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "DEHUMIDIFICATION LOCKOUT":
					if (gui.isSecondaryHeader_screen("Lockout")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "DEHUMIDIFICATION AWAY MODE":
					if (gui.isSecondaryHeader_screen("Away Mode")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "TYPE OF VENTILATION":
					if (gui.isPrimaryHeader_screen("Ventilation")) {
						flag = gui.selectTypeOfVentilation(option);
					} else {
						flag = false;
					}
					break;
				case "VENTILATOR FILTER CLEANING REMINDER":
					if (gui.isSecondaryHeader_screen("Filter Cleaning")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "WHAT TERMINALS ARE WIRED TO THE VENTILATION":
					if (gui.isSecondaryHeader_screen("Terminals are Wired")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectVentilationTerminalareWired(option);
						}
					} else {
						flag = false;
					}
					break;
				case "VENTILATION CONTROL METHOD":
					if (gui.isSecondaryHeader_screen("Control Method")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectVentilationControlMethod(option);
						}
					} else {
						flag = false;
					}
					break;
				case "VENTILATION FAN CONTROL":
					if (gui.isSecondaryHeader_screen("Fan Control")) {
						if (option.toUpperCase().contains("DEFAULT")) {
							flag = gui.clickOnRightArrow();
						} else {
							flag = gui.selectVentilationFanControl(option);
						}
					} else {
						flag = false;
					}
					break;
				case "VENTILATION PERCENT ON TIME":
					if (gui.isSecondaryHeader_screen("Percent On Time")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "VENTILATION CONDITION LOCKOUTS":
					if (gui.isSecondaryHeader_screen("Outdoor Condition Lockouts")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "VENTILATION LOCKOUTS ON HUMIDIFICATION OR DEHUMIDIFICATION":
					if (gui.isSecondaryHeader_screen("Lockout Ventilation")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "VENTILATION ON HIGH INDOOR HUMIDITY":
					if (gui.isSecondaryHeader_screen("Ventilate on High Indoor")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;
				case "VENTILATION REMINDERS":
					if (gui.isSecondaryHeader_screen("Ventilation Reminders")) {
						flag = gui.clickOnRightArrow();
					} else {
						flag = false;
					}
					break;

//			case "HEAT STAGING CONTROL":
//			case "HEAT STAGINGCONTROL":
//				flag = gui.selectStagingControlHighHeatStage(option);
//				break;
				default:
					break;
				}

				if (flag) {
					Keyword.ReportStep_Pass(testCase,
							"Isu type " + screenName + " , ISU Value is " + option + " ,Successfully saved");
					flag = true;
				} else {
					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Isu type " + screenName + " , ISU Value is " + option + " ,failed");
					flag = false;
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Isu type " + screenName + " , ISU Value is " + option + " ,failed");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}
