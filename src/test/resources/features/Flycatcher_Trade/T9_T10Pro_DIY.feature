@Flycathcer_Thor_DIY 
Feature: Flycatcher Thor Registration 
	Register the Flycatcher or Thor device by DIY flow 

@Flycatcher_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Flycathcer Happy Path with initial installation in GUI 

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
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP Mode" 
	Then wait for connecting to honeywell
	Then user waits for data synch after registration
	And Verify Registration status in Stat GUI
	When User verifies thermostat configuration as "Heatpump" with "1" heat stages and "1" cool stages
	Then delete Registered thermostat in app
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API
	Then verify stat is unregistered from cloud
	
	
@Flycatcher_Diy_RealDevice_Conventional_0C2H_GUI_install_HappyPath @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Flycathcer Happy Path with initial installation in GUI 

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
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Heat 2"
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Setup Later" from "Wifi" screen 
	Then User select GUI option "Done" from "Current Date" screen
	Then User set Room name as "default" 
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP Mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration
	And Verify Registration status in Stat GUI
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

@Flycatcher_Diy_RealDevice_HeatPump_2C3H_GUI_install_HappyPath @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Flycathcer Happy Path with initial installation in GUI 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Heat Pump" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Air to Air Heat Pump"
	Then User select GUI ISU Type "Reversing Valve" and ISU Name as "O OB on Cool"
	Then User select GUI ISU Type "Backup Equipment Stages" and ISU Name as "Compressor 2, Backup Heat 1"
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Setup Later" from "Wifi" screen 
	Then User select GUI option "Done" from "Current Date" screen
	Then User set Room name as "default" 
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP Mode"  
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration
	And Verify Registration status in Stat GUI
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
		
@Flycatcher_Diy_RealDevice_HeatPump_2C3H_GUI_install_HappyPath1 @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Flycathcer Happy Path with initial installation in GUI 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI option "Setup Later" from "Redlink" screen 
	Then User select GUI ISU Type "Outdoor Sensor type" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Heat Pump" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "Air to Air Heat Pump"
	Then User select GUI ISU Type "Reversing Valve" and ISU Name as "O OB on Cool"
	Then User select GUI ISU Type "Backup Equipment Stages" and ISU Name as "Compressor 2, Backup Heat 1"
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Setup Later" from "Wifi" screen 
	Then User select GUI option "Done" from "Current Date" screen
	Then User set Room name as "default" 
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP Mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration
	And Verify Registration status in Stat GUI
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud
	
@Flycatcher_Diy_RealDevice_HeatPump_2C2H_GUI_install_HappyPath_Retail @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Flycathcer Happy Path with initial installation in GUI 

 	Given reset stat to "FACTORY DEFAULTS" using CATT
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Retail Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Retail Room name" screen 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User select GUI ISU Type "Reversing Valve" and ISU Name as "O OB on Cool"
	Then User select GUI option "Next" from "ISU" screen
	Then User select GUI option "Setup Later" from "Retail Sensor" screen
	Then User select GUI option "Setup Later" from "Wifi" screen 
	Then User select GUI option "Done" from "Current Date" screen
	Then User select GUI option "Setup Later" from "Scheduling" screen 
	Then User set Room name as "default" 
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then pair device with security code 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration
	And Verify Registration status in Stat GUI
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

@Flycatcher_Diy_RealDevice_HappyPath @--xrayid:HTA-1094 
Scenario: HTA_1094 Flycatcher DIY-Happy Path 
	Given reset stat to "FACTORY DEFAULTS" using CATT
	Then user set room name as "default" 
	Given user launches and logs in to the Resideo application 
#	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then add new device for registration  
	And user select location name as "Home"
	Then user pairing device using "security code" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

#
#@Flycatcher_Diy_RealDevice_HappyPath @--xrayid:HTA-1094 
#Scenario: HTA_1094 Flycatcher DIY-Happy Path 
#	And Reset stat to "FACTORY DEFAULTS" using CATT 
#	Then User set Room name as "default" 
#	Given user launches and logs in to the Resideo application 
#	Then Setting AP mode on 
#	And Setting network configuration 
#	Then Initialize Stat MDNS using CATT 
#	Then Add new device for Registration 
#	And user select location name as "Home" 
#	Then pair device with security code 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration
#	And Verify Registration status in Stat GUI
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	
#	
