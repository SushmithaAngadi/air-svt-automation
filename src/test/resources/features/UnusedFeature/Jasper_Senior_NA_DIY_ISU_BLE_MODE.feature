@Jasper_Senior_DIY_registration_BLE 
Feature: Jasper Devices Registration 

 
@T6ProWiFi_JasperNATrade_DIY_BLE_cool_only_one_stage
Scenario: HTA-468 Jasper device registration using AP mode on Honeywell home app with cool only one stage configuration 
	Given user launches and logs in to the Honeywell Home application 
#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
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
	
	
	@T6ProWiFi_Jasper_Retail_DIY_BLE_cool_only_one_stage_1218 
Scenario: HTA-1218 Jasper Retail device registration using AP mode on Honeywell home app with cool only one stage configuration 
	Given user launches and logs in to the Honeywell Home application 
	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
#	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set ISUType "VENTILATION TYPE" to ISUValue "NONE" 
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
	