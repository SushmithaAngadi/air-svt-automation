@Jasper_Senior_NA_Retail_DIY_registration_BLE_AP_Mixed @--xrayid:HTA-919 
Feature: HTA_919 Jasper Devices Registration 

@T6ProWiFi_NA_Retail_DIY_cool_only_2_stage @--xrayid:HTA-920
Scenario: HTA_920 Jasper or Phoenix registration using Ble Mode in Resideo APP with cool only 2 stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And User BroadCast "bLE" in device for Registration from "Start setup" Screen
	Then Add new device for Registration 
	And perform initial installtion setup in "Ble mode" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
	Then Set ISUType "COOLING STAGE" to ISUValue "2" 
	When Do you want to confirm ISU or Need to Edit ? "Confirm" 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
