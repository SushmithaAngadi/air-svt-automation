@HomeKit_Automation_Thor_10_plus_enhancement_HTA_1425 @--xrayid:HTA-1425 
Feature: HTA_1425 Home Kit Automation for Thor 10 plus enhancement 

@HTA_1632_Add_Thor_Thermostat_in_HomeKit_ISU_configured_with_registration_Station_Mode_DataSync_HTA_Registered 
@--xrayid:HTA-1632 
Scenario: 
	HTA_1632 T10 plus HomeKit Paring with ISU configured with Registration Station mode with Data Sync 

	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "0" ias with thermostat 
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 1 ,Heat 1" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	Then User select GUI option "configure wifi" from "wifi configuration" screen 
	Then User select GUI option "Connect app" from "connect app" screen 
	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "Station Mode" Thermostat from Add Accessory "with direct scan"
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit
	
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_with_registration_AP_Mode_DataSync_HTA_Registered 
@--xrayid:HTA-1427 
Scenario: 
	HTA_1427 T10 plus HomeKit Paring with ISU configured with Registration AP mode with Data Sync 

	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "0" ias with thermostat 
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 1 ,Heat 1" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	Then  User select GUI option "Setup later" from "wifi configuration" screen 
	Then  User select GUI option "Done" from "Current Date" screen 
	Then  User select GUI option "setup later" from "connect app" screen 
#	Then  User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory "without direct scan"
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_without_registration_AP_Mode_DataSync_HTA_Registered_No_Sensor 
@--xrayid:HTA-1427 
Scenario: HTA_1427 T10 plus HomeKit Paring with ISU configured without Registration AP or WAC mode with Data Sync no sensor 

	Given user launches Home Kit application
	Then Check stat is paired with HomeKit
	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory "without direct scan"
	Then Pair Thermostat using "QR Scan" in Homekit
	Then Select Default location and Device Name, Complete AccessorySetup
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_without_registration_AP_Mode_DataSync_HTA_Registered_No_Sensor_NoFactoryRst 
@--xrayid:HTA-1427 
Scenario: HTA_1427 T10 plus HomeKit Paring with ISU configured without Registration Station mode with Data Sync no sensor 

	Given User verify the thermostat having Wifi configuration, if not configure WIFI through AAT 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit
	Then Generate QR Code from Stat for homekit
	Then Initiate HomeKit in "QR Scan" Thermostat from Add Accessory "with direct scan"
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 