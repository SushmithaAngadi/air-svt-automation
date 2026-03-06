@HomeKit_Automation_Jasper_NA 
Feature: Home Kit Automation for Jasper NA 

@Add_Jasper_NA_Thermostat_in_HomeKit_with_DataSync
Scenario: Jasper Thermostat Paring through HomeKit App with data sync

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And User BroadCast "wac" in device for Registration from "Start setup" Screen 
	Given user launches Home Kit application
	Then Check stat is paired with HomeKit
	Then Initiate HomeKit in "station mode" Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then Delete Device from HomeKit

@Add_Jasper_NA_Thermostat_in_HomeKit_without_DataSync
Scenario: Jasper Thermostat Paring through HomeKit App without data sync

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches Honeywell Home application 
	Then Launch and Confirm "HOME KIT" third party application 
	Then Check stat is paired with HomeKit 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "WAC MODE" 
	Then Initiate HomeKit Select Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	Then Delete Device from HomeKit
		
@Add_Jasper_EMEA_Thermostat_in_HomeKit_with_DataSync
Scenario: Jasper Thermostat Paring through HomeKit App with data sync

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SCHEDULE_OFF" with thread state is "true" and thread need to continue "false" 
	Given user launches Honeywell Home application 
	Then Launch and Confirm "HOME KIT" third party application 
	Then Check stat is paired with HomeKit 
	When Set Jasper EMEA Thermostat to Broadcast Mode, Mode type is "WAC MODE" 
	Then Initiate HomeKit Select Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit	

@Add_Thor_Thermostat_in_HomeKit_with_DataSync
Scenario: Thor Thermostat Paring through HomeKit App with data sync

#	And Reset stat to "FACTORY DEFAULTS" using CATT 
#	Given user launches and logs in to the Honeywell Home application 
#	Then Setting AP mode on 
#	And Setting network configuration 
#	Then Initialize Stat MDNS using CATT 
	Given user launches Honeywell Home application 
#	Then Launch and Confirm "HOME KIT" third party application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "AP mode" Thermostat from Add Accessory
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit	
	
	
@Add_Thor_Thermostat_in_HomeKit_with_DataSync_FactoryReset_UI
Scenario: Thor Thermostat Paring through HomeKit App with data sync

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Standard efficiency gas forced air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2"
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Setup Later" from "Wifi" screen 
	Then User select GUI option "Done" from "Current Date" screen
	Then User set Room name as "default" 
	Then Setting AP mode on 
	And Setting network configuration 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "station mode" Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit	
	
	
@Add_Thor_Thermostat_in_HomeKit_with_DataSync_Without_factoryReset_UI
Scenario: Thor Thermostat Paring through HomeKit App with data sync

	Then User set Room name as "default" 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "station mode" Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "69" from "HOMEKIT" ,Verify from "STAT" 
	Then Delete Device from HomeKit	
	