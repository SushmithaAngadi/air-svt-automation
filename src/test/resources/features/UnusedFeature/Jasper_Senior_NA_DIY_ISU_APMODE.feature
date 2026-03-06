@Jasper_Senior_DIY_registration_APMODE
Feature: Jasper Devices Registration 

#@T5_WifiThermostat_JasperNARetail_DIY_cool_only_one_stage 
#Scenario: T6 Pro Wi-Fi DIY-Happy Path 
#	Given user launches and logs in to the Honeywell Home application 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration 
#	And Perform installation setup for bLE mode 
#	Then Connect with Thermostat Network using bLE  
#	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
#	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
#	
@HTA_468 
@T6ProWiFi_JasperNATrade_DIY_cool_only_one_stage_HTA_468 
Scenario: HTA-468 Jasper device registration using AP mode on Honeywell home app with cool only one stage configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 

@HTA_469 
@T6ProWiFi_JasperNATrade_DIY_cool_only_two_stage_HTA_469 
Scenario: HTA-469 Jasper device registration using AP mode on Honeywell home app with cool only two stage configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
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
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_470 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas-HighEfficiency_heat-Only_HTA_470 
Scenario: HTA-470 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as gas High efficiency 1H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_471 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_heat-Only_HTA_471 
Scenario: HTA-471 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as gas standard efficiency 1H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_472 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_heat-Only_HTA_472 
Scenario: HTA-472 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Oil 1H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_473 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_heat-Only_EquipmentControl_HTA_473 
Scenario: HTA-473 Jasper device registration Using AP mode on Resideo App with Heating system as Conventional forced air and fuel as Electric 1H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_474 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_heat-Only_ThermostatContol_HTA_474 
Scenario: HTA-474 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 1H0C Fan operation thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_475 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_heat-Only_ThermostatContol_HTA_475 
Scenario: HTA-475 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H0C Fan operation thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_476 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_heat-Only_EquipmentControl_HTA_476 
Scenario: HTA-476 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H0C Fan operation Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_477 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas-HighEfficiency_oneHeat-oneCool_HTA_477 
Scenario: HTA-477 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas high efficiency 1H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_478 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_oneHeat-oneCool_HTA_478 
Scenario: HTA-478 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas standard efficiency 1H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_479 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_oneHeat-oneCool_HTA_479 
Scenario: HTA-479 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as oil 1H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_480 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_oneHeat-oneCool_EquipmentControl_HTA_480 
Scenario: HTA-480 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 1H1C Fan operation Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_481 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_oneHeat-oneCool_EquipmentControl_HTA_481 
Scenario: HTA-481 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H1C Fan operation Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_482 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_oneHeat-oneCool_ThermostatContol_HTA_482 
Scenario: HTA-482 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 1H1C Fan operation Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_483 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_oneHeat-oneCool_ThermostatContol_HTA_483 
Scenario: HTA-483 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H1C Fan operation Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_484 
@T6ProWiFi_JasperNATrade_DIY_BOILER_HotWater_heatOnly_HTA_484 
Scenario: HTA-484 Jasper device registration using AP mode on Honeywell home app with Heating system as Boiler and fuel as Hot water Heat Only configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "BOILER" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_485 
@T6ProWiFi_JasperNATrade_DIY_BOILER_STEAM_HeatOnly_HTA_485 
Scenario: HTA-485 Jasper device registration using AP mode on Honeywell home app with Heating system as Boiler and fuel as Steam Heat Only configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "BOILER" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "STEAM" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_486 
@T6ProWiFi_JasperNATrade_DIY_BOILER_HotWater_OneHeat-OneCool_HTA_486 
Scenario: HTA_486 Jasper device registration using AP mode on Honeywell home app with Heating system as Boiler and fuel as Hot water 1H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "BOILER" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_487 
@T6ProWiFi_JasperNATrade_DIY_BOILER_STEAM_OneHeat-OneCool_HTA_487 
Scenario: HTA-487 Jasper device registration using AP mode on Honeywell home app with Heating system as Boiler and fuel as Steam 1H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "BOILER" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "STEAM" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	#-----------------------tow heat only---------------------------------------
	
@HTA_488 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas_HighEfficiency_TwoHeatOnly_HTA_488 
Scenario: HTA-488 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as gas High efficiency 2H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_489 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_TwoHeatOnly_HTA_489 
Scenario: 
HTA-489 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_490 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_TwoHeatOnly_HTA_490 
Scenario: 
HTA-490 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Oil 2H0C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_491 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeatOnly_EquipmentControl_HTA_491 
Scenario: 
HTA-491 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H0C Fan operation as Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_492 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeatOnly_ThermostatContol_HTA_492 
Scenario: 
HTA-492 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H0C Fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_493 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeatOnly_ThermostatContol_HTA_493 
Scenario: 
HTA-493 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H0C Fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_494 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeatOnly_EquipmentControl_HTA_494 
Scenario: 
HTA-494 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H0C Fan operation as Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "NONE" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	#-------------------------two heat one cool-------------------------------
	
@HTA_495 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas-HighEfficiency_TwoHeat_oneCool_HTA_495 
Scenario: 
HTA-495 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas high efficiency 2H1C configuration 

	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_496 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_TwoHeat_oneCool_HTA_496 
Scenario: 
HTA-496 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_497 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_TwoHeat_oneCool_HTA_497 
Scenario: 
HTA-497 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Oil 2H1C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_498 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_oneCool_EquipmentControl_HTA_498 
Scenario: 
HTA-498Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H1C Fan operation as Equipment Controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_499 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeat_oneCool_EquipmentControl_HTA_499 
Scenario: 
HTA-499 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H1C Fan operation as Equipment Controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_500 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_oneCool_ThermostatContol_HTA_500 
Scenario: 
HTA-500 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H1C Fan operation as Thermostat Controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_501 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeat_oneCool_ThermostatContol_HTA_501 
Scenario: 
HTA-501 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H1C Fan operation as Thermostat Controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED"
	
	#------------------------one heat two cool--------------------------------
	
@HTA_502 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas-HighEfficiency_OneHeat_TwoCool_HTA_502 
Scenario: 
HTA-502 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas High efficiency 1H2C configuration 

	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_503 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_OneHeat_TwoCool_HTA_503 
Scenario: 
HTA-503 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas standard efficiency 1H2C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_504 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_OneHeat_TwoCool_HTA_504 
Scenario: 
HTA-504 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Oil 1H2C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_505 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_OneHeat_TwoCool_EquipmentControl_HTA_505 
Scenario: 
HTA-505 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 1H2C Fan operation as Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_506 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_OneHeat_TwoCool_EquipmentControl_HTA_506 
Scenario: 
HTA-506 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H2C Fan operation as Equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_507 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_OneHeat_TwoCool_ThermostatContol_HTA_507 
Scenario: 
HTA-507 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 1H2C Fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_508 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_OneHeat_TwoCool_ThermostatContol_HTA_508 
Scenario: 
HTA-508 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H2C Fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	#----------------------------two heat two cool------------------------------------
	
@HTA_509 
@T6ProWiFi_JasperNATrade_DIY_conventional_Gas-HighEfficiency_TwoHeat_TwoCool_HTA_509 
Scenario: 
HTA-509 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas high efficiency 2H2C configuration 

	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
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
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_510 
@T6ProWiFi_JasperNATrade_DIY_conventional_gas-standard_TwoHeat_TwoCool_HTA_510 
Scenario: 
HTA-510 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H2C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_511 
@T6ProWiFi_JasperNATrade_DIY_conventional_OIL_TwoHeat_TwoCool_HTA_511 
Scenario: 
HTA-511 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Oil 2H2C configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "OIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_512 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_TwoCool_EquipmentControl_HTA_512 
Scenario: 
HTA-512 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H2C fan operation as equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_513 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeat_TwoCool_EquipmentControl_HTA_513 
Scenario: 
HTA-513 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H2C fan operation as equipment controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_514 
@T6ProWiFi_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_TwoCool_ThermostatContol_HTA_514 
Scenario: 
HTA-514 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Electric 2H2C fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_515 
@T6ProWiFi_JasperNATrade_DIY_conventional_Hotwater-fancOIL_TwoHeat_TwoCool_ThermostatContol_HTA_515 
Scenario: 
HTA-515 Jasper device registration using AP mode on Honeywell home app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H2C fan operation as Thermostat controls configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED"
	
	#-------------------------heat pump----------------------------------------	
	
@HTA_516 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_coolOnly_stage1_HTA_516 
Scenario: 
HTA-516 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 1H1C reversing valve O OB ON COOL configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "NONE" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_517 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_coolOnly_stage2_HTA_517 
Scenario: 
HTA-517 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H2C reversing valve O OB ON COOL configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "NONE" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_518 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_HTA_518 
Scenario: 
HTA-518 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal Together configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_519 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_HTA_519 
Scenario: 
HTA-519 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve O OB ON COOL with AuxE terminal Independent configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_520 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_HTA_520 
Scenario: 
HTA-520 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
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
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_521 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_1Cool_2Heat_together_HTA_521 
Scenario: 
HTA-521 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_522 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_together_HTA_522 
Scenario: 
HTA-522 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_523 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_1Cool_2Heat_GAS_STANDARD_independent_HTA_523 
Scenario: 
HTA-523 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Gas or Oil forced air configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_524 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_GAS_STANDARD_independent_HTA_524 
Scenario:
HTA_524 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Gas or Oil forced air configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
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
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_525 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_1Cool_2Heat_together_dual-fuel_HTA_525 
Scenario: 
HTA-525 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OTHERS" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_526 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_together_dual-fuel_HTA_526 
Scenario:
HTA_526 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal together and backup heat as Gas standard Emergency heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_527 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_Independent_dual-fuel_HTA_527 
Scenario: 
HTA-527 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve O OB ON HEAT with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "1" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OTHERS" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	
@HTA_528 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_1Cool_2Heat_Independent_dual-fuel_HTA_528 
Scenario: 
HTA-528 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
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
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_529 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Together_HTA_529 
Scenario: 
HTA-529 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_530 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Together_HTA_530 
Scenario: 
HTA-530 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_531 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Independent_HTA_531 
Scenario: 
HTA-531 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_532 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Independent_HTA_532 
Scenario: 
HTA-532 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Electric Emergency heat Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_533 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Together_Gas-Oil_HTA_533 
Scenario: 
HTA-533 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas Standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_534 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Together_HTA_534 
Scenario: 
HTA-534 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas Standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_535 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Independent_GAS_STANDARD_HTA_535 
Scenario: HTA-535 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas Standard Emergency heat as Gas or Oil forced configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_536 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Independent_GAS_STANDARD_HTA_536 
Scenario: HTA-536 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas Standard  Emergency heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "COMFORT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_537 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Together_GasStandard_HTA_537 
Scenario:  HTA-537 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OTHERS" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_538 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Together_HTA_538 
Scenario: 
HTA-538 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Together and backup heat as Gas Standard configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@HTA_539 
@T6ProWiFi_JasperNATrade_DIY_heatPump_AitToAir_O_2Cool_3Heat_Independent_GAS_STANDARD_HTA_539 
Scenario: 
HTA-539 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas Standard Emergency heat as Electric airconfiguration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OTHERS" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	
@HTA_540 
@T6ProWiFi_JasperNATrade_DIY_heatPump_GEOTHERMAL_O_2Cool_3Heat_Independent_GAS_STANDARD_HTA_540 
Scenario: 
HTA-540 Jasper device registration using AP mode on Honeywell home app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve O OB ON COOL with AuxE terminal Independent and backup heat as Gas Standard Emergency heat as Electric configuration 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
	Then Set ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
	Then Set ISUType "COMPRESSOR STAGE" to ISUValue "2" 
	Then Set ISUType "HEATING STAGE" to ISUValue "1" 
	Then Set ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set ISUType "BACKUP HEAT DROOP" to ISUValue "OTHERS" 
	Then Set ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "EMERGENCY HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
