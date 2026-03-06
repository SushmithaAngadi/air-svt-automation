@T9_T10_Negative_Scenarios 
Feature: Adaptive Recovery features 

@T9_T10_Thermostat_EnteringWrongSecurityPIN 
Scenario: FLY_NA_Entering Wrong Security Pin_Retail 
	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Then User set Room name as "default" 
	Given user launches and logs in to the Resideo application 
	Then Setting AP mode on 
	And Setting network configuration 
	Then Initialize Stat MDNS using CATT 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then pair device with "Wrong" security code for "3 attempts" 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then pair device with security code 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T9_T10_Thermostat_PowerCycle_DuringSecurityPIN_DIY 
Scenario: FLY_NA_Power Cycle on Stat at Security Pin during DIY_Retail 
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
	And Select the device from scan list 
	Then Power "OFF" the thermostat for "3" min 
	Given user launches and logs in to the Resideo application 
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
	
@T9_T10_Thermostat_PowerCycle_DuringDataSync 
Scenario: FLY_NA_Power Cycle on Stat while data sync during DIY_Retail 
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
	Then pair device with security code 
	Then wait for connecting to honeywell 
	Then Power "off" the device 
	Then User waits for "Cloud connection error" during data synch after registration 
	Then Power "ON" the device 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@T9_T10_Thermostat_PowerCycle_BeforeRegistartion 
Scenario: FLY_NA_Power Cycle on Stat Before Registration during DIY_Retail 
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
	Then pair device with security code 
	Then Power "off" the device 
	Then verify stat is unregistered from cloud 
	
	
	
	
	
	
	
    