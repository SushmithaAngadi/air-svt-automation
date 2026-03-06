@HomeKit_Automation_Jasper_EMEA
Feature: Home Kit Automation for Jasper EMEA

		
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
