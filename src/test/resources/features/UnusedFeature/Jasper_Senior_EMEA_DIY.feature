@Jasper_Senior_EMEA_DIY_without_FactoryReset 
Feature: Jasper Devices Registration Automation with Factory reset EMEA devices Registration 

@T6R_WiFi_Jasper_EMEA_DIY_AP_Mode 
Scenario: T5 Pro wireless or wired AP Mode DIY-Happy Path 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
	
@T6R_WiFi_Jasper_EMEA_DIY_BLE_Mode 
Scenario: T5 Pro wireless or wired BLE Mode DIY-Happy Path 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Honeywell Home application 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then Connect with WiFi 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@T6R_WiFi_Jasper_EMEA_DIY_BLE_Mode_Without_FactoryReset
Scenario: T5 Pro wireless or wired BLE Mode DIY-Happy Path without factory reset

    Given user launches and logs in to the Honeywell Home application
    When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE"
    Then Add new device for Registration
    And perform initial installtion setup in "BLE MODE"
    Then connect with thermostat in "BLE MODE"
    Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH"
    Then Set ISUType "CLOCK" to ISUValue "12HOUR"
    Then Confirm ISU summary
    Then Connect with WiFi
    And user select location name as "Home"
    And choose "Default" thermostat name
    Then wait for connecting to honeywell
    Then user waits for data synch after registration
    Then delete Registered thermostat in app
    And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API
    Then verify stat is unregistered from cloud
    #And set stat to "factory default" with thread state is "true" and thread need to continue "false"
    #    Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED"