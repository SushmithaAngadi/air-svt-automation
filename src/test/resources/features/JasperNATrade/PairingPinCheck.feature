@Jasper_phoenix_AP_Ble_Pairing_A001
Feature: As a User Checking multiple Pairing Trail through AP or Ble

@T6ProWiFi_ReziApp_Jasper_Phoenix_APMode_Pairing_A001_A01
Scenario: A001_A01 T6 Pro pairing On AP Mode in rezi APP
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP MODE"
	Then Connect with Thermostat "AP" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	
@T6ProWiFi_ReziApp_Jasper_Phoenix_BleMode_Pairing_A001_A02
Scenario: A001_A02 T6 Pro pairing On Ble Mode in rezi APP
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "Ble MODE"
	Then Connect with Thermostat "BLE" in Rezi App
	Then Select Required option is "CONFIGURATION" in Rezi App  

@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A03 
Scenario: A001_A03 Jasper or Phoenix registration using Ble Mode in Resideo APP with cool only 2 stage with default settings-SS-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	
@T6ProWiFi_NATrade_DIY_AP_cool_only_one_stage_A001_A04 
Scenario: A001_A04 Jasper or Phoenix registration using AP Mode in Resideo APP with cool only 2 stage with default settings-SS-AP Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	
@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A05
Scenario: A001_A05 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SCHEDULE_OFF" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	When Do you want to confirm ISU or Need to Edit ? "NO"
	
@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A06 
Scenario: A001_A06 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP  

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SCHEDULE_OFF" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP Mode" 
	Then Add new device for Registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 