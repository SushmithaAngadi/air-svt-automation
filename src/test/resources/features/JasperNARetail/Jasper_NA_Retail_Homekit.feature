#@HomeKit_Automation_Jasper_NA_Retail 
#Feature: Home Kit Automation for Jasper NA_Retail
#
#@Add_Jasper_NA_Retail_Thermostat_in_HomeKit_StartUp_Screen_with_DataSync 
#Scenario: Jasper Retail Thermostat Paring through HomeKit App with data sync from start up screen
#
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	And User BroadCast "wac" in device for Registration from "Start setup" Screen 
#	Given user launches Home Kit application 
#	Then Check stat is paired with HomeKit 
#	Then Initiate HomeKit in "wac" Thermostat from Add Accessory "without direct scan"
##	Then Initiate HomeKit in "wac" Thermostat from Add Accessory
#	Then Pair Thermostat using "code" in Homekit 
#	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
#	Then Delete Device from HomeKit 
#	
#@Add_Jasper_NA_Retail_Thermostat_in_HomeKit_temp_Home_screen_with_DataSync 
#Scenario: Jasper Retail Thermostat Paring through HomeKit App with data sync from home screen 
#
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	And User BroadCast "wac" in device for Registration from "Home" Screen 
#	Given user launches Home Kit application 
#	Then Check stat is paired with HomeKit 
#	Then Initiate HomeKit in "wac" Thermostat from Add Accessory 
#	Then Pair Thermostat with Homekit 
#	Then Select Default location and Device Name, Complete AccessorySetup 
#	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
#	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
#	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
#	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
#	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
#	Then Delete Device from HomeKit 
#	
#@Add_Jasper_NA_Retail_Thermostat_in_HomeKit_with_DataSync 
#Scenario: Jasper Retail Thermostat Paring through HomeKit App with data sync in station mode
#
#	Given user launches Home Kit application 
#	Then Check stat is paired with HomeKit 
#	Then Initiate HomeKit in "wac" Thermostat from Add Accessory "without direct scan"
#	Then Pair Thermostat using "code" in Homekit 
#	Then Select Default location and Device Name, Complete AccessorySetup 
##	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
##	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
##	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
##	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
##	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
##	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
##	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
##	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
#	Then Delete Device from HomeKit