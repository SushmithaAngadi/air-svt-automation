@HomeKit_Automation_Jasper_NA 
Feature: Home Kit Automation for Jasper NA 

@Add_Jasper_NA_Retro_RNC_Thermostat_in_HomeKit_with_DataSync_WacMode_startSetup 
Scenario: 
	Jasper Retrofit and RNC Thermostat Paring through HomeKit App with data sync from start setup 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And User BroadCast "AP" in device for Registration from "Start setup" Screen 
	Given user launches Home Kit application 
	Then Check stat is paired with HomeKit 
	Then Initiate HomeKit in "wac" Thermostat from Add Accessory "without direct scan" 
	Then Pair Thermostat using "code" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then Delete Device from HomeKit 
	
@Add_Jasper_NA_Retro_RNC_Thermostat_in_HomeKit_with_DataSync_WacMode 
Scenario: 
	Jasper Retrofit and RNC Thermostat Paring through HomeKit App with data sync from Thermostat temperature 

	#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	#	And User BroadCast "wac" in device for Registration from "Home" Screen 
	Given user launches Home Kit application 
	#	Then Check stat is paired with HomeKit 
	#	Then Initiate HomeKit in "wac" Thermostat from Add Accessory "without direct scan" 
	#	Then Pair Thermostat using "code" in Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then Delete Device from HomeKit 
	
@Add_Jasper_NA_Retro_RNC_Thermostat_in_HomeKit_with_DataSync_StationMode_ES 
Scenario:
Jasper Retrofit and RNC Thermostat Paring through HomeKit App with data sync via station mode 

#	Given User verify the thermostat having Wifi configuration, if not configure WIFI through AAT 
	Given user launches Home Kit application 
#	Then Check stat is paired with HomeKit 
#	Then Initiate HomeKit in "Station mode" Thermostat from Add Accessory "without direct scan" 
#	Then Pair Thermostat using "code" in Homekit 
#	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then Delete Device from HomeKit 
	
	