@Thor_DIY_realDevice 
Feature: Thor Registration 
	Register the Thor device using user DIY flow 

@Thor_Diy_Conventional_2C2H_GUI_install_HappyPath_witout_EIM_With_1IAS_QR @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Thor with 1 IAS only no eim using qr scan registration 

	And Reset stat to "Factory reset" using Thermostat UI Navigation
	Given User select GUI option "Get Started" from "Welcome" screen
	Then User select GUI option "English" from "Language" screen
	Then User select GUI option "Bedroom" from "Room Type" screen
	Then User select GUI option "Master Bedroom" from "Room name" screen
	Then User set Room name as "default"
#	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit"
#	Then User enrolls "0" eim, "0" oas and "1" ias with thermostat, is random paring time needed "no" 
#	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No"
#	Then User select GUI ISU Type "Outdoor sensor type" and ISU Name as "Internet"
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
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud
	
@Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath_witout_EIM_With_1IAS_AP @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Thor with 1 IAS only no eim using AP mode registration 

	And Reset stat to "Factory reset" using Thermostat UI Navigation
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "1" ias with thermostat, is random paring time needed "no" 
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
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

@Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Thor Happy Path with initial installation in GUI 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "1" ias with thermostat, is random paring time needed "no" 
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
	Then user pairing device using "QR Scanner" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	


@Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath @--xrayid:HTA-1095 
Scenario: HTA_1094 DIY on Thor Happy Path with initial installation in GUI 

	And Reset stat to "FACTORY DEFAULTS" using CATT 
	Given User select GUI option "Get Started" from "Welcome" screen 
	Then User select GUI option "English" from "Language" screen 
	Then User select GUI option "Bedroom" from "Room Type" screen 
	Then User select GUI option "Master Bedroom" from "Room name" screen 
	Then User set Room name as "default" 
	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
	Then User enrolls "0" eim, "0" oas and "1" ias with thermostat, is random paring time needed "no" 
	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Internet"
	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional forced air heat" 
	Then User select GUI ISU Type "Equipment Type" and ISU Name as "High Efficiency Gas Forced Air" 
	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 1 ,Heat 1"
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
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 	
	
	
#	@Thor_Diy_RealDevice_Conventional_2C2H_GUI_install_HappyPath @--xrayid:HTA-1095 
#Scenario: HTA_1094 DIY on Thor Happy Path with initial installation in GUI 
#
#	And Reset stat to "FACTORY DEFAULTS" using CATT 
#	Given User select GUI option "Get Started" from "Welcome" screen 
#	Then User select GUI option "English" from "Language" screen 
#	Then User select GUI option "Bedroom" from "Room Type" screen 
#	Then User select GUI option "Master Bedroom" from "Room name" screen 
#	Then User set Room name as "default" 
#	Then User select GUI ISU Type "Temp Scale" and ISU Name as "Fahrenheit" 
#	Then User enrolls "0" eim, "0" oas and "1" ias with thermostat, is random paring time needed "no" 
#	Then User select GUI ISU Type "Floor Sensor" and ISU Name as "No" 
#	Then User select GUI ISU Type "Outdoor Temperature" and ISU Name as "Internet"
#	Then User select GUI ISU Type "System Type" and ISU Name as "Conventional forced air heat" 
#	Then User select GUI ISU Type "Equipment Type" and ISU Name as "High Efficiency Gas Forced Air" 
#	Then User select GUI ISU Type "Equipment Stages" and ISU Name as "Cool 1 ,Heat 1"
#	Then User select GUI ISU Type "Changeover" and ISU Name as "Automatic"
#	
#	
#	Then User select GUI ISU Type "Backup Heat" and ISU Name as "Electric Forced Air" 
#	Then User select GUI ISU Type "Backup Heat Stages" and ISU Name as "Heat 1" 
#	Then User select GUI ISU Type "Fan Control" and ISU Name as "Thermostat Controls Fan" 
#	Then User select GUI ISU Type "Control Mode" and ISU Name as "Air and Floor" 
#	Then User select GUI ISU Type "Changeover" and ISU Name as "Automatic" 
#	Then User select GUI ISU Type "Changeover Differential" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Advanced Setup" and ISU Name as "Basic Options" 
#	Then User select GUI ISU Type "finish with high heat stage" and ISU Name as "No" 
#	Then User select GUI ISU Type "backup heat differential in staging control" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Cool cycles per hour in cycle rates" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Radiant heat cycles per hour in cycle rates" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Backup heat cycles per hour in cycle rates" and ISU Name as "Default" 
#	Then User select GUI ISU Type "minimum compressor off time" and ISU Name as "0" 
#	Then User select GUI ISU Type "minimum non compressor on time" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Extended Fan run times" and ISU Name as "Default" 
#	Then User select GUI ISU Type "Adaptive intelligent recovery" and ISU Name as "yes" 
#	Then User select GUI ISU Type "Temperature range stops" and ISU Name as "yes" 
#	Then User select GUI ISU Type "Keypad lockout" and ISU Name as "default" 
#	Then User select GUI ISU Type "Sensor are wired to your system" and ISU Name as "default" 
#	Then User select GUI ISU Type "Wired floor temperature sensor" and ISU Name as "default" 
#	Then User select GUI ISU Type "Dry contacts" and ISU Name as "default" 
#	Then User select GUI ISU Type "filter type" and ISU Name as "default" 
#	Then User select GUI ISU Type "number of air filters" and ISU Name as "default" 
#	Then User select GUI ISU Type "air filter replacement reminder" and ISU Name as "default" 
#	Then User select GUI ISU Type "type of humidifier" and ISU Name as "bypass or fan powered" 
#	Then User select GUI ISU Type "which sensor will be used for humidification control" and ISU Name as "default" 
#	Then User select GUI ISU Type "what terminals are wired to the humidifier" and ISU Name as "default" 
#	Then User select GUI ISU Type "humidification windows protection" and ISU Name as "on" 
#	Then User select GUI ISU Type "system modes allowing humidification" and ISU Name as "default" 
#	Then User select GUI ISU Type "humidification control" and ISU Name as "default" 
#	Then User select GUI ISU Type "humidifier pad replacement reminder" and ISU Name as "default" 
#	Then User select GUI ISU Type "type of dehumidifier" and ISU Name as "whole house dehumidifier" 
#	Then User select GUI ISU Type "which sensor will be used for dehumidification control" and ISU Name as "default" 
#	Then User select GUI ISU Type "what terminals are wired to the dehumidifier" and ISU Name as "default" 
#	Then User select GUI ISU Type "system modes allowing dehumidification" and ISU Name as "default" 
#	Then User select GUI ISU Type "dehumidification fan control" and ISU Name as "default" 
#	Then User select GUI ISU Type "dehumidification lockout" and ISU Name as "default" 
#	Then User select GUI ISU Type "dehumidification away mode" and ISU Name as "default" 
#	Then User select GUI ISU Type "dehumidifier filter replacement reminder" and ISU Name as "default" 
#	Then User select GUI ISU Type "type of ventilation" and ISU Name as "ERV HRV" 
#	Then User select GUI ISU Type "what terminals are wired to the ventilation" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation control method" and ISU Name as "percent on time" 
#	Then User select GUI ISU Type "ventilation fan control" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation percent on time" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation condition lockouts" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation lockouts on Humidification or Dehumidification" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation on high indoor humidity" and ISU Name as "default" 
#	Then User select GUI ISU Type "ventilation reminders" and ISU Name as "default" 
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
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 	