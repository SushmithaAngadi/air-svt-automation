@ReziApp_Jasper_Senior_DIY_HTA_A00
Feature: Jasper Devices Registration on Resideo pro app using BLE flow 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_Ble_3H_2C_HP_Air_HTA_A01
Scenario: T6 Pro Wi-Fi DIY-Happy Path heat pump 3h2c resideo pro ble and resideo ble with wac enabled
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And user broadCast "AP" in device for registration from "start setup" screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "Ble MODE"
	Then Connect with Thermostat "Ble" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "Default" , and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	Then Add new device for Registration 
#	And perform initial installtion setup in "BLE MODE" 
#	Then connect with thermostat in "BLE MODE" 
#	Then Confirm ISU summary 
#	Then "always" configure the thermostat wifi, is device factory reset "yes" 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_Ble_AP_3H_2C_HP_Air_HTA_A02
Scenario: T6 Pro Wi-Fi DIY-Happy Path Heatpump reisdeo pro ble resideo Ap mode with ble flow
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE" 
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
	####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_AP_3H_2C_HP_Air_HTA_A03
Scenario: T6 Pro Wi-Fi DIY-Happy Path Heat pump 3h2c reisdeo pro ble and resideo app ap mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE" 
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
	####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	
@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A04
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo ble mode and reisdeo ble mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE" 
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A05
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo pro ble resideo app ap mode with ble flow
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE" 
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application  
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A06 
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo pro ble resideo App ap mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "BLE MODE" 
	Then Connect with Thermostat "BLE" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_Ble_3H_2C_HP_Air_HTA_A07
Scenario: T6 Pro Wi-Fi DIY-Happy Path heat pump 3h2c resideo pro Ap and resideo ble with wac enabled
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "AP Mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
	####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_Ble_AP_3H_2C_HP_Air_HTA_A08
Scenario: T6 Pro Wi-Fi DIY-Happy Path Heatpump reisdeo pro Ap resideo Ap mode with ble flow
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "AP Mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
	####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_Rezi_Ble_Resideo_AP_3H_2C_HP_Air_HTA_A09
Scenario: T6 Pro Wi-Fi DIY-Happy Path Heat pump 3h2c reisdeo pro AP and resideo app ap mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "Ap mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	#	################################### Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS STANDARD" 
	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	#	######################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
	####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	
@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A010
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo Ap mode and reisdeo ble mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "AP Mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A011
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo pro Ap resideo app ap mode with ble flow
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "AP mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application  
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "BLE MODE" 
	Then connect with thermostat in "BLE MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_A012
Scenario: T6 Pro Wi-Fi DIY-Happy Path conventional 2h2c resideo pro Ap resideo App ap mode
	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	Given user launches and logs in to the Rezi APP 
	And User BroadCast the device for Registration from "Start setup" Screen 
	Then Add new device for Configuration in Rezi App 
	And Perform Resideo Pro initial installtion setup using "AP Mode" 
	Then Connect with Thermostat "AP Mode" in Rezi App 
	Then Select Required option is "CONFIGURATION" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Confirm ISU summary in Rezi App 
	################ Advanced Settings=====================================================	
	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1" 
	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "DEFAULT" 
	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "DEFAULT" 
	Then Confirm ISU summary in Rezi App 
	####################### Diagnostics Test =======================================================
	Then Select Required option is "DIAGNOSTICS" in Rezi App 
	Then Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
	Then Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
	Then Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
	Then Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
	Then Finish Installer Diagnostic Test 
	########################Then Select Required option is "CUSTOMER INFO" in Rezi App 
	########################And Check the Existing customer "fly Qa", and Send Invite to the Customer 
	And Disconnect Tstat from Resideo Pro 
	Then Close the "Resideo Pro" Application 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
	Given user launches and logs in to the Honeywell Home application 
	Then Add new device for Registration 
	And perform initial installtion setup in "AP MODE" 
	Then connect with thermostat in "AP MODE" 
	Then Confirm ISU summary 
	Then "always" configure the thermostat wifi, is device factory reset "yes" 
	And user select location name as "Home" 
	And choose "Default" thermostat name 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 

