@Thor_DIY_realDevice_HTA-1638_HTA_1633 @--xrayid:HTA-1638 @--xrayid:HTA-1633 
Feature: Thor Registration 
	Register the Thor device using user DIY flow 

	
@HTA_2022_diy_Thor_Diy_Conventional_2C2H_GUI_install_HappyPath_with_ALL_redlinkDevice_QRCode 
@--xrayid:HTA-2022 
Scenario: HTA_2022 DIY on Thor Happy Path with GUI ISU and 1 EIM 1 IAS and 1 OAS reg QR Code 

	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default"
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "1" eim, "1" oas and "1" ias with thermostat, is random paring time needed "no"
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
	
	
@HTA_2024_diy_Thor_Diy_Conventional_2C2H_GUI_install_HappyPath_with_ALL_redlinkDevice_APMode 
@--xrayid:HTA-2024 
Scenario: HTA_2024 DIY on Thor Happy Path with GUI ISU and 1 EIM 1IAS and 1OAS reg AP mode 

	And Reset stat to "Factory reset" using Thermostat UI Navigation 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Residential" from "Application" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "1" eim, "1" oas and "1" ias with thermostat, is random paring time needed "no"
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Internet" 
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional forced air heat" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "High Efficiency Gas Forced Air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2" 
	Then User select GUI ISU Type "Changeover" and ISU Name as "Automatic" 
	Then User select GUI ISU Type "Changeover Differential" and ISU Name as "Default" 
	Then User select GUI ISU Type "Advanced Setup" and ISU Name as "Basic Options" 
	Then User select GUI option "Done" from "ISU" screen 
	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	Then User select GUI option "configure wifi" from "wifi configuration" screen 
	Then User select GUI option "Connect app" from "connect app" screen 
	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	Given user launches and logs in to the Resideo application 
	Then Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "AP Mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	
	
	
	#	@--xrayid:HTA-2022 
	#Scenario: HTA_2022 DIY on Thor Happy Path with GUI ISU and 1 EIM 1 IAS and 1 OAS reg QR Code 
	#
	#And Reset stat to "Factory reset" using Thermostat UI Navigation 
	#
	#	And Reset stat to "Factory reset" using Thermostat UI Navigation
	#	Given User select GUI option "Get Started" from "Welcome" screen 
	#	Then User select GUI option "English" from "Language" screen 
	#	Then User select GUI option "Residential" from "Application" screen 
	#	Then User select GUI option "Bedroom" from "Room Type" screen 
	#	Then User select GUI option "Master Bedroom" from "Room name" screen 
	#	Then User set Room name as "default" 
	#	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	#	Then User enrolls "1" eim, "1" oas and "1" ias with thermostat, is random paring time needed "no"
	#	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	#	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Internet" 
	#	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional forced air heat" 
	#	Then User select GUI ISU Type "Equipment Type" and ISU Name as "High Efficiency Gas Forced Air" 
	#	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 2 ,Heat 2" 
	#	Then User select GUI ISU Type "Changeover" and ISU Name as "Automatic" 
	#	Then User select GUI ISU Type "Changeover Differential" and ISU Name as "Default" 
	#	Then User select GUI ISU Type "Advanced Setup" and ISU Name as "Basic Options" 
	#	Then User select GUI option "Done" from "ISU" screen 
	#	Then User select GUI option "Exit setup" from "Exit installer setup" screen 
	#	Then User select GUI option "configure wifi" from "wifi configuration" screen 
	#	Then User select GUI option "Connect app" from "connect app" screen 
	#	Then User select GUI option "yes, i have the app" from "is resideo app installed" screen 
	#	Given user launches and logs in to the Resideo application 
	#	Then Add new device for Registration 
	#	And user select location name as "Home" 
	#	Then user pairing device using "QR Scanner" 
	#	Then wait for connecting to honeywell 
	#	Then user waits for data synch after registration 
	#	And Verify Registration status in Stat GUI 
	#	Then User verifies thermostat configuration as "Gas" with "2" heat stages and "2" cool stages 
	#	Then delete Registered thermostat in app 
	#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	#	Then verify stat is unregistered from cloud 
	