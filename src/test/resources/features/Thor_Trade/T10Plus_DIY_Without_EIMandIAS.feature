@Thor_DIY_realDevice 
Feature: Thor Registration 
	Register the Thor device using user DIY flow 

	
@HTA_2020_Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath 
@--xrayid:HTA-2020 
Scenario: HTA_2020 DIY on Thor Happy Path with initial installation in GUI and reg in QR code 

	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "0" ias with thermostat, is random paring time needed "no"  
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "no" 
	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Wireless" 
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
	Then user pairing device using "QR Scanner" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
@HTA_2021_Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath 
@--xrayid:HTA-2021 
Scenario: HTA_2021 DIY on Thor Happy Path with initial installation in GUI and reg in AP mode 

#	And Reset stat to "FACTORY DEFAULTS" using CATT 
	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "0" ias with thermostat, is random paring time needed "no"  
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "no" 
	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Wireless" 
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
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 