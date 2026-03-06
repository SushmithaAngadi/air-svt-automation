@HomeKit_Automation_Jasper_NA 
Feature: Home Kit Automation for Jasper NA 

@Add_T6_Thermostat_in_HomeKit_with_DataSync_start_setup_wac_factory_reset
Scenario: T6 Pro Thermostat wac pairing through HomeKit App with data sync factory reset start setup

	And set stat to "factory defaults" with thread state is "true" and thread need to continue "false"
	Given user launches Home Kit application
	Then check stat is paired with homeKit
	Then initiate homekit in "wac" thermostat from add accessory "without direct scan"
	Then pair thermostat using "code" in homekit 
	Then select default location and device name, complete accessory setup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then delete device from homekit

@Add_T6_Thermostat_in_HomeKit_with_DataSync_wac_factory_reset
Scenario: T6 Pro Thermostat wac pairing through HomeKit App with data sync factory reset

	And set stat to "factory defaults" with thread state is "true" and thread need to continue "false"
	And user broadcast "Ble" in device for registration from "Home" screen
	Given user launches Home Kit application
	Then check stat is paired with homeKit
	Then initiate homekit in "wac" thermostat from add accessory "without direct scan"
	Then pair thermostat using "code" in homekit 
	Then select default location and device name, complete accessory setup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then delete device from homekit

@Add_T6_Thermostat_in_HomeKit_with_DataSync_factory_reset_station_mode
Scenario: T6 Pro Thermostat Paring through HomeKit App with data sync Station Mode

	And set stat to "factory defaults" with thread state is "true" and thread need to continue "false"
	And Setting network configuration
	Given user launches Home Kit application
	Then check stat is paired with homeKit
	Then initiate homekit in "wac" thermostat from add accessory "without direct scan"
	Then pair thermostat using "code" in homekit 
	Then select default location and device name, complete accessory setup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then delete device from homekit

@Add_T6_Thermostat_in_HomeKit_with_Without_Factory_Reset_StationMode
Scenario: T6 Pro Thermostat Paring through HomeKit App without factory reset station mode

	And Setting network configuration
	Given user launches Home Kit application
	Then check stat is paired with homeKit
	Then initiate homekit in "wac" thermostat from add accessory "without direct scan"
	Then pair thermostat using "code" in homekit 
	Then select default location and device name, complete accessory setup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then delete device from homekit
	
@Add_T6_Thermostat_in_HomeKit_with_DataSync_without_factory_reset_wac
Scenario: T6 Pro Thermostat Paring through HomeKit App with data sync without factory reset in wac

	
	And user broadcast "Ble" in device for registration from "Home" screen
	Given user launches Home Kit application
	Then check stat is paired with homeKit
	Then initiate homekit in "wac" thermostat from add accessory "without direct scan"
	Then pair thermostat using "code" in homekit 
	Then select default location and device name, complete accessory setup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then delete device from homekit