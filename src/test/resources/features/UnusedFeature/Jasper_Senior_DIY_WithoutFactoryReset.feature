@Jasper_Senior_DIY_without_FactoryReset_Master
Feature: Jasper Devices Registration Automation Wihtout Factory reset 
	Jasper NA & EMEA devices Registration

@T6ProWiFi_JasperNATrade_DIY_BLE_without_Factory_reset
Scenario: T6 Pro Wi-Fi BLE DIY-Happy Path without Factory reset ble with wac ble flow
Given User BroadCast "BLE MODE" in device for Registration from "HOME" Screen
	Then user launches and logs in to the Resideo application  
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
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


@T6ProWiFi_JasperNATrade_DIY_AP_without_Factory_reset_Android
Scenario: T6 Pro Wi-Fi BLE DIY-Happy Path without Factory reset wac with AP mode flow Android only
Given User BroadCast "BLE MODE" in device for Registration from "HOME" Screen
	Then user launches and logs in to the Resideo application  
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
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

@T6ProWiFi_JasperNATrade_DIY_AP_without_Factory_reset_IOS
Scenario: T6 Pro Wi-Fi BLE DIY-Happy Path without Factory reset AP without wac AP mode flow
Given User BroadCast "AP MODE" in device for Registration from "HOME" Screen
	Then user launches and logs in to the Resideo application  
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	When Do you want to confirm ISU or Need to Edit ? "Edit" 
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
