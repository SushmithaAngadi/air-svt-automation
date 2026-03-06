@Jasper_phoenix_AP_Ble_Pairing_Connect_disconnect_Timeout
Feature: As a User Checking multiple Pairing Trail through AP or Ble

@T6ProWiFi_ReziApp_Jasper_Phoenix_APMode_Pairing_Connect_disconnect_Timeout
Scenario: T6 Pro Check pairing status as connect and disconnect from startsetup ble mode without wac
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE"
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"

@T6ProWiFi_ReziApp_Jasper_Phoenix_APMode_Pairing_Connect_disconnect_Timeout
Scenario: T6 Pro Check pairing status as connect and disconnect from startsetup ble mode without wac
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP MODE"
	Then Connect with Thermostat "AP MODE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"

@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A05
Scenario: A001_A05 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "Ble Mode"  
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE"
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"
	
@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A05
Scenario: A001_A05 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE"  
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE"
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"


#	
@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A05
Scenario: A001_A05 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-WAC-BLE Mode APP 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE"  
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP MODE"
	Then Connect with Thermostat "AP MODE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"
#	

@T6ProWiFi_ReziApp_Jasper_Phoenix_APMode_Pairing_Connect_disconnect_Timeout
Scenario: T6 Pro Check pairing status as connect and disconnect from startsetup ble mode without wac
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"

@T6ProWiFi_ReziApp_Jasper_Phoenix_APMode_Pairing_Connect_disconnect_Timeout
Scenario: T6 Pro Check pairing status as connect and disconnect from startsetup ble mode without wac
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen
	Then Add new device for Registration 
	And perform initial installtion setup in "AP Mode" 
	Then connect with thermostat in "AP Mode" 
	Then Set ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"

@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A06 
Scenario: A001_A06 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP  

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "Ble Mode" 
	Then Add new device for Registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"

@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A06 
Scenario: A001_A06 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP  

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Then Add new device for Registration 
	And perform initial installtion setup in "Ble Mode" 
	Then connect with thermostat in "Ble Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"
	
	@T6ProWiFi_NATrade_DIY_BLE_cool_only_one_stage_A001_A06 
Scenario: A001_A06 Jasper or Phoenix registration from Homescreen using Ble Mode in Resideo APP with cool only 2 stage with default settings-HS-NO WAC-BLE Mode APP  

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	Given Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP Mode" 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP Mode" 
	Then connect with thermostat in "AP Mode" 
	When Do you want to confirm ISU or Need to Edit ? "NO" 
	When Device in broadcast, it "should not" disconnect from the app "before 30 mins"


