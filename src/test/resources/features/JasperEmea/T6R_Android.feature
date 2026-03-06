@Jasper_EMEA_DIY_Android 
Feature: Jasper EMEA DIY Android 

@Android_T6R_WiFi_Jasper_EMEA_DIY_AP_Mode_With_factoryreset_without_wac 
Scenario: Android Type-1 T6 EMEA wireless or wired AP Mode without wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Home Screen" screen 
	#And user broadcast "AP" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_AP_Mode_With_factoryreset_with_Wac 
Scenario: Android Type-2 T6 EMEA wireless or wired AP Mode with wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "ble" in device for registration from "Home Screen" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_With_factoryreset_BLE_Mode_with_wac 
Scenario: Android Type-3 T6 EMEA wireless or wired bLE Mode with wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "bLE" in device for registration from "Home Screen" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble mode" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_With_factoryreset_BLE_Mode_Without_Wac 
Scenario: Android Type-4 T6 EMEA wireless or wired bLE Mode without wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Home Screen" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ble mode" 
	Then connect with thermostat in "ble mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_AP_Mode_With_factoryreset_without_wac_1B 
Scenario: Android Type-1b T6 EMEA wireless or wired AP Mode without wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_AP_Mode_With_factoryreset_with_Wac_2B 
Scenario: Android Type-2b T6 EMEA wireless or wired AP Mode with wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_With_factoryreset_BLE_Mode_with_wac_3B 
Scenario: Android Type-3b T6 EMEA wireless or wired bLE Mode with wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "Ble mode" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_With_factoryreset_BLE_Mode_Without_Wac_4B 
Scenario: Android Type-4b T6 EMEA wireless or wired bLE Mode without wac with factory reset 

	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Resideo application 
	And user broadcast "AP" in device for registration from "Start setup" screen 
	Then add new device for registration 
	And perform initial installtion setup in "ble mode" 
	Then connect with thermostat in "ble mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_Without_factoryreset_AP_Mode_without_wac 
Scenario: Android Type-5 T6 EMEA wireless or wired AP Mode without wac without factory reset 

	And user broadcast "AP" in device for registration from "Home Screen" screen 
	Given user launches and logs in to the Resideo application 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_Without_factoryreset_AP_Mode_with_Wac 
Scenario: Android Type-6 T6 EMEA wireless or wired AP Mode with wac without factory reset 

	And user broadcast "ble" in device for registration from "Home Screen" screen 
	Given user launches and logs in to the Resideo application 
	Then add new device for registration 
	And perform initial installtion setup in "ap mode" 
	Then connect with thermostat in "ap mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_Without_factoryreset_BLE_Mode_with_wac 
Scenario: Android Type-7 T6 EMEA wireless or wired bLE Mode with wac without factory reset 

	And user broadcast "bLE" in device for registration from "Home Screen" screen 
	Given user launches and logs in to the Resideo application 
	Then add new device for registration 
	And perform initial installtion setup in "Ble mode" 
	Then connect with thermostat in "BLE MODE" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 
	
@Android_T6R_WiFi_Jasper_EMEA_DIY_Without_factoryreset_BLE_Mode_Without_Wac 
Scenario: Android Type-8 T6 EMEA wireless or wired bLE Mode without wac without factory reset 

	And user broadcast "AP" in device for registration from "Home Screen" screen 
	Given user launches and logs in to the Resideo application 
	Then add new device for registration 
	And perform initial installtion setup in "ble mode" 
	Then connect with thermostat in "ble mode" 
	Then Set ISUType "LANGUAGE" to ISUValue "ENGLISH" 
	Then Set ISUType "CLOCK" to ISUValue "12HOUR" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
	#	Then Send App Log to "comfort.automation@resideo.com" ,If Testcase was "FAILED" 