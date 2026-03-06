@HomeKit_Automation_Thor_10_plus_enhancement_HTA_1425 @--xrayid:HTA-1425 
Feature: HTA_1425 Home Kit Automation for Thor 10 plus enhancement 

@HTA_HKA_T10Pro_Add_Flycatcher_Thermostat_in_HomeKit_ISU_configured_with_registration_Station_Mode_DataSync_HTA_Registered 
@--xrayid:HTA-1632 
Scenario: HTA_1632 T10 pro HomeKit Paring with ISU configured with Registration Station mode with Data Sync 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Outdoor temperature" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "configure wifi" from "wifi configuration" screen 
	Then User select GUI option "Connect app" from "connect app" screen 
	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches and logs in to the Resideo application 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "Station Mode" Thermostat from Add Accessory 
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@HTA_1632_Add_Thor_Thermostat_in_HomeKit_ISU_configured_with_registration_Station_Mode_DataSync_HTA_Registered_witout_factory_reset 
@--xrayid:HTA-1632 
Scenario: HTA_1632 T10 plus HomeKit Paring with ISU configured with Registration Station mode with Data Sync 

	Given user launches and logs in to the Resideo application 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "Station Mode" Thermostat from Add Accessory 
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_with_registration_AP_Mode_DataSync_HTA_Registered 
@--xrayid:HTA-1427 
Scenario: 
	HTA_1427 T10 plus HomeKit Paring with ISU configured with Registration AP mode with Data Sync 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Residential" from "Application" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	Then User select GUI option "configure wifi" from "wifi configuration" screen 
	Then User select GUI option "Connect app" from "connect app" screen 
	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches and logs in to the Resideo application 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory 
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_with_registration_AP_Mode_DataSync_HTA_Registered 
@--xrayid:HTA-1427 
Scenario: 
	HTA_1427 T10 plus HomeKit Paring with ISU configured with Registration AP mode with Data Sync 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory 
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Residential" from "Application" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	Then User select GUI option "configure wifi" from "Setup Later" screen 
	Then User select GUI option "Connect app" from "connect app" screen 
	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches and logs in to the Resideo application 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory 
	Then Pair Thermostat using "QR Scan" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
	
@Add_Thor_Thermostat_in_HomeKit_ISU_configured_without_registration_AP_Mode_DataSync_HTA_Registered_No_Sensor 
@--xrayid:HTA-1427 
Scenario: 
	HTA_1427 T10 plus HomeKit Paring with ISU configured without Registration Station mode with Data Sync no sensor 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Residential" from "Application" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enroll "EIM,OAS,IAS" with Thermostat 
	#	Then User select GUI option "Setup Later" from "Redlink" screen 
	#	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No"
	#	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet"
	#	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	#	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	#	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2"
	#	Then User select GUI option "Done" from "ISU" screen 
	#	Then User select GUI option "Exit setup" from "Exit installer setup" screen
	#	Then User select GUI option "configure wifi" from "wifi configuration" screen
	#	Then User select GUI option "Connect app" from "connect app" screen
	#	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen
	#	Given user launches and logs in to the Resideo application 
	#	Then Add new device for Registration 
	#	And user select location name as "Home" 
	#	Then user pairing device using "QR Scan" 
	#	Then wait for connecting to honeywell 
	#	Then user waits for data synch after registration 
	#	And Verify Registration status in Stat GUI
	#	Given user launches Home Kit application 
	#	Then Check stat is paired with HomeKit 
	#	Then Initiate HomeKit in "AP Mode" Thermostat from Add Accessory 
	#	Then Pair Thermostat using "QR Scan" in Homekit 
	#	Then Select Default location and Device Name, Complete AccessorySetup 
	#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	#	Then Delete Device from HomeKit
	#	Then delete Registered thermostat in app 
	#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	#	Then verify stat is unregistered from cloud 	
	
	
	
	
	#Home kit Parameter: 
	#
	#Station mode: 
	#
	#Factory reset>>>> Wifi connected >>>>> Tstat name should be in Homekit
	#
	#AP mode:
	#Factory reset >>>> No Wifi connected >>> Tstat Name should be in homekit
	#
	#Station mode: 
	#
	#Homekit reset>>>> Wifi connected >>>>> Tstat name should be in Homekit
	
	