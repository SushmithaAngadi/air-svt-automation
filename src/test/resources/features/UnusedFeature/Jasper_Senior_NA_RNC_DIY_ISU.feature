@Jasper_Senior_NA_RNC_DIY_registration_BLE_AP_Mixed @--xrayid:HTA-919 
Feature: HTA_919 Jasper Devices Registration 

@T6ProWiFi_NA_RNC_DIY_cool_only_2_stage @--xrayid:HTA-920 
Scenario: HTA_920 Jasper or Phoenix registration using Ble Mode in Resideo APP with cool only 2 stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "bLE" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_A002 
Scenario: Jasper or Phoenix registration using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_A003 
Scenario: Jasper or Phoenix registration using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_cool_only_one_stage_A004 
Scenario: Jasper or Phoenix registration using AP Mode in Resideo APP with cool only 2 stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_A005 
Scenario: Jasper or Phoenix registration using AP Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_A006 
Scenario: Jasper or Phoenix registration using AP Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_A007 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_A008 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_A009 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "Ble" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_cool_only_one_stage_A0013 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_A0014 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_BLE_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_A0015 
Scenario: Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-NO WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_cool_only_one_stage_A0016 
Scenario: Jasper or Phoenix registration from Homescreen using AP Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP Mode" 
	Then connect with thermostat in "AP Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_A0017 
Scenario: Jasper or Phoenix registration from Homescreen using AP Mode in Resideo APP with Conventional with Gas High efficiency 2 Heat and 2 cool stage with default settings-HS-NO WAC-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP Mode" 
	Then connect with thermostat in "AP Mode" 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T6ProWiFi_NA_RNC_DIY_AP_heatPump_GEOTHERMAL_O_2Cool_2Heat_Independent_GAS_STANDARD_A0018 
Scenario: Jasper or Phoenix registration from Homescreen using AP Mode in Resideo APP with Heat Pump with Geothermal 3 Heat and 2 cool stage with default settings-HS-NO WAC-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "AP" in device for Registration from "Home" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP Mode" 
	Then connect with thermostat in "AP Mode" 
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
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
