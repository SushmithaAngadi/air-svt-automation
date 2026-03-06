@Jasper_Senior_NA_RNC_DIY_registration_BLE_AP_Mixed_iOS 
Feature: iOS RNC T6 Devices Registration 

@T6ProWiFi_NA_RNC_DIY_cool_only_2_stage @--xrayid:HTA-920 
Scenario: iOS T6 Pro reg using Ble Mode in Resideo APP with cool only 2 stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble mode" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_iOS 
Scenario: iOS T6 pro Reg using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_iOS 
Scenario: iOS T6 pro Reg using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_cool_only_one_stage_iOS 
Scenario: iOS T6 pro Reg using AP Mode in Resideo APP with cool only 2 stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_iOS 
Scenario: iOS T6 pro Reg using AP Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_iOS
Scenario: iOS T6 pro Reg using AP Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_iOS
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_iOS
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_iOS
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_iOS 
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_iOS
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_iOS
Scenario: iOS T6 pro Reg from Homescreen using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_cool_only_one_stage_iOS
Scenario: iOS T6 pro Reg from Homescreen using AP Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP mode" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_conventional_Gas_HighEfficiency_TwoHeat_Two_Cool_iOS 
Scenario: iOS T6 pro Reg from Homescreen using AP Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ap mode" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_iOS
Scenario: iOS T6 pro Reg from Homescreen using AP Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "Ap mode" in device for registration from "Home" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_iOS_001
Scenario: iOS T6 pro reg from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	Given user launches and logs in to the Resideo application 
	And user broadcast "Ble" in device for registration from "Home" screen
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_iOS_002
Scenario: iOS T6 pro reg from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP 

	Given user launches and logs in to the Resideo application 
	And user broadcast "AP Mode" in device for registration from "Home" screen
	Then add new device for registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_iOS_003
Scenario: iOS T6 pro reg from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-AP Mode APP 

	Given user launches and logs in to the Resideo application 
	And user broadcast "AP Mode" in device for registration from "Home" screen
	Then add new device for registration 
	And perform initial installtion setup in "Ap MODE" 
	Then connect with thermostat in "Ap MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	