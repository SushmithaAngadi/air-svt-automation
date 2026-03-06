#@ReziApp_Jasper_Senior_DIY
#Feature: Jasper Devices Registration on Resideo pro app using BLE flow
#
#
#
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Independent_GAS_STANDARD_HTA_5709
#Scenario: T6 Pro Wi-Fi DIY-Happy Path 
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Configuration in Rezi App 
#	And Perform Resideo Pro initial installtion setup 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
##	################################### Advanced Settings=====================================================	
##	Then Select Required option is "ADVANCED SETTINGS" in Rezi App 
##	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "MON TO FRI AND SAT TO SUN" 
##	Then Set Rezi App ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
##	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
##	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
##	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
##	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
##	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
##	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
##	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
##	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD"
##	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR"
##	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT" 
##	Then Set Rezi App ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
##	Then Set Rezi App ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "FINISH WITH HIGH COOL STAGE" to ISUValue "YES"
##	Then Set Rezi App ISUType "FINISH WITH HIGH HEAT STAGE" to ISUValue "YES"
##	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT" 
##	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
##	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
##	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
##	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
##	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
##	Then Set Rezi App ISUType "MAXIMUM COOL SETPOINT" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "MINIMUM COOL SETPOINT" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "MINIMUM HEAT SETPOINT" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE"
##	Then Set Rezi App ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
##	Then Set Rezi App ISUType "AIR FILTER REPLACEMENT REMINDER" to ISUValue "30 CALENDAR DAYS"
##	Then Set Rezi App ISUType "HUMIDIFIER PAD REPLACEMENT REMINDER" to ISUValue "6 CALENDAR MONTHS"
##	Then Set Rezi App ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "12 CALENDAR MONTHS"
##	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE"
##	Then Set Rezi App ISUType "VENTILATION FILTER REMINDER" to ISUValue "DEFAULT"
##	Then Set Rezi App ISUType "NUMBER OF UV DEVICES" to ISUValue "1"
##	Then Set Rezi App ISUType "UV BULB REPLACEMENT REMINDER" to ISUValue "6 CALENDAR MONTHS"
##	Then Set Rezi App ISUType "INACTIVE BACKLIGHT LEVEL" to ISUValue "5"
##	Then Set Rezi App ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
##	Then Set Rezi App ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
##	Then Set Rezi App ISUType "TEMPERATURE DISPLAY OFFSET" to ISUValue "3"
##	Then Confirm ISU summary in Rezi App 
##	######################### Diagnostics Test =======================================================
##	Then Select Required option is "DIAGNOSTICS" in Rezi App 
##	Then Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
##	Then Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
##	Then Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
##	Then Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
##	Then Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
##	Then Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
##	Then Check system test configuration has  Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
##	Then Finish Installer Diagnostic Test 
#####################	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#####################	And Check the Existing customer "fly Qa", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "BLE MODE"
#	Given user launches and logs in to the Honeywell Home application 
#	Then Add new device for Registration 
#	And perform initial installtion setup in "BLE MODE" 
#	Then connect with thermostat in "BLE MODE" 
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_607	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Independent_GAS_STANDARD_HTA_607 
#Scenario: HTA-607 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing
#	Given user launches and logs in to the Rezi APP 
##	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And Perform Resideo Pro initial installtion setup 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
##	#Diagnostics Test =======================================================
##	Then Select Required option is "DIAGNOSTICS" in Rezi App 
##	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
##	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
##	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
##	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
##	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
##	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
##	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
##	Then Finish Installer Diagnostic Test 
##	Then Select Required option is "CUSTOMER INFO" in Rezi App 
##	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
##	And Disconnect Tstat from Resideo Pro 
##	Then Close the "Resideo Pro" Application 
##	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
##	Given user launches and logs in to the Honeywell Home application 
##	When User Accept Invitation then Connect To Thermostat Wifi Network 
##	Then connect with thermostat in "AP MODE"
##	Then Confirm ISU summary 
##	Then Connect with WiFi 
##	And user select location name as "Home" 
##	And choose "Default" thermostat name 
##	Then wait for connecting to honeywell 
##	Then user waits for data synch after registration 
##	Then delete Registered thermostat in app 
##	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
##	Then verify stat is unregistered from cloud 
##	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_541	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_cool_only_one_stage_HTA_541 
#Scenario: HTA-541 Jasper device registration using bLE mode on Resideo pro app with cool only one stage configuration
#	Given user launches and logs in to the Rezi APP 
##	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App
#	And Perform Resideo Pro initial installtion setup
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
##	# Diagnostics Test =======================================================
##	Then Select Required option is "DIAGNOSTICS" in Rezi App 
##	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
##	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
##	Then Finish Installer Diagnostic Test 
##	Then Select Required option is "CUSTOMER INFO" in Rezi App 
##	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
##	And Disconnect Tstat from Resideo Pro 
##	Then Close the "Resideo Pro" Application 
##	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
##	Given user launches and logs in to the Honeywell Home application 
##	When User Accept Invitation then Connect To Thermostat Wifi Network 
##	Then connect with thermostat in "AP MODE"
##	Then Confirm ISU summary 
##	Then Connect with WiFi 
##	And user select location name as "Home" 
##	And choose "Default" thermostat name 
##	Then wait for connecting to honeywell 
##	Then user waits for data synch after registration 
##	Then delete Registered thermostat in app 
##	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
##	Then verify stat is unregistered from cloud 
##	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_542
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_cool_only_two_stage_HTA_542 
#Scenario: HTA-542 Jasper device registration using bLE mode on Resideo pro app with cool only two stage configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_543	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_GasHighEfficiency_heatOnly_HTA_543 
#Scenario: HTA-543 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as gas High efficiency 1H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_544	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gasStandard_heatOnly_HTA_544 
#Scenario: HTA-544 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as gas standard efficiency 1H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_545	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_heatOnly_HTA_545 
#Scenario: HTA-545 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Oil 1H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_546	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_heatOnly_EquipmentControl_HTA_546
#Scenario: HTA-546 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_547	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_heatOnly_ThermostatContol_HTA_547 
#Scenario: HTA-547 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H0C Fan operation thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_548	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_HotwaterFancOIL_heatOnly_ThermostatContol_HTA_548 
#Scenario: HTA-548 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H0C Fan operation thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_549	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater-fancOIL_heatOnly_EquipmentControl_HTA_549 
#Scenario: HTA-549 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H0C Fan operation Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_550	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_GasHighEfficiency_oneHeat_oneCool_HTA_550 
#Scenario: HTA-550 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas high efficiency 1H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#@HTA_551	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gasStandard_oneHeat_oneCool_HTA_551 
#Scenario: HTA-551 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas standard efficiency 1H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_552
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_oneHeat_oneCool_HTA_552 
#Scenario: HTA-552 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as oil 1H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_553	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_oneHeat_oneCool_EquipmentControl_HTA_553 
#Scenario: HTA-553 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H1C Fan operation Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_554	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_HotwaterFancOIL_oneHeat_oneCool_EquipmentControl_HTA_554 
#Scenario: HTA-554 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H1C Fan operation Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_555	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_oneHeat_oneCool_ThermostatContol_HTA_555 
#Scenario: HTA-555 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H1C Fan operation Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_556
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_HotwaterFancOIL_oneHeat_oneCool_ThermostatContol_HTA_556 
#Scenario: HTA-556 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H1C Fan operation Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#	#------------------------------------------two heat only-------------------------------
#
#@HTA_557
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_GasHighEfficiency_TwoHeatOnly_HTA_557 
#Scenario: HTA-557 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas high efficiency 2H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_558
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gasStandard_TwoHeatOnly_HTA_558 
#Scenario: HTA-558 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_559	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_TwoHeatOnly_HTA_559 
#Scenario: HTA-559 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Oil 2H0C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#@HTA_560	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeatOnly_EquipmentControl_HTA_560 
#Scenario: HTA-560 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H0C Fan operation as Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#@HTA_561	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeatOnly_ThermostatContol_HTA_561 
#Scenario: HTA-561 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H0C Fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_562	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeatOnly_ThermostatContol_HTA_562 
#Scenario: HTA-562 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H0C Fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_563	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeat_Only_EquipmentControl_HTA_563 
#Scenario: HTA-563 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H0C Fan operation as Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#	#--------------------------------------two heat one cool-------------------------------
#
#@HTA_564	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Gas_HighEfficiency_TwoHeat_oneCool_HTA_564 
#Scenario: HTA-564 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas high efficiency 2H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#@HTA_565	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_oneCool_HTA_565 
#Scenario: HTA-565 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#@HTA_566	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_TwoHeat_oneCool_HTA_566 
#Scenario: HTA-566 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Oil 2H1C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_567	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_oneCool_EquipmentControl_HTA_567 
#Scenario: HTA-567 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H1C Fan operation as Equipment Controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_568	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeat_oneCool_EquipmentControl_HTA_568 
#Scenario: HTA-568 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H1C Fan operation as Equipment Controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_569	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_oneCool_ThermostatContol_HTA_569 
#Scenario: HTA-569 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H1C Fan operation as Thermostat Controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#
#@HTA_570	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeat_oneCool_ThermostatContol_HTA_570 
#Scenario: HTA-570 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H1C Fan operation as Thermostat Controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	
#	#--------------------------------------one heat two cool-------------------------------
#
#@HTA_571	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Gas_HighEfficiency_OneHeat_TwoCool_HTA_571 
#Scenario: HTA-571 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas High efficiency 1H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_572	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_OneHeat_TwoCool_HTA_572 
#Scenario: HTA-572 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas standard efficiency 1H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_573	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_OneHeat_TwoCool_HTA_573 
#Scenario: HTA-573 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Oil 1H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_574	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_OneHeat_TwoCool_EquipmentControl_HTA_574 
#Scenario: HTA-574 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H2C Fan operation as Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_575	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_OneHeat_TwoCool_EquipmentControl_HTA_575 
#Scenario: HTA-575 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H2C Fan operation as Equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_576	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_OneHeat_TwoCool_ThermostatContol_HTA_576 
#Scenario: HTA-576 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 1H2C Fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_577	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_OneHeat_TwoCool_ThermostatContol_HTA_577 
#Scenario: HTA-577 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 1H2C Fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "1" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#	#------------------------------------------two heat two cool---------------------------
#
#@HTA_578	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Gas_HighEfficiency_TwoHeat_TwoCool_HTA_578 
#Scenario: HTA-578 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas high efficiency 2H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_579	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_gas_standard_TwoHeat_TwoCool_HTA_579 
#Scenario: HTA-579 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Gas standard efficiency 2H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_580	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_OIL_TwoHeat_TwoCool_HTA_580 
#Scenario: HTA-580 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Oil 2H2C configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "OIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_581	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_TwoCool_EquipmentControl_HTA_581 
#Scenario: HTA-581 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H2C fan operation as equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_582	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeat_TwoCool_EquipmentControl_HTA_582 
#Scenario: HTA-582 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H2C fan operation as equipment controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_583	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_ELECTRIC_TwoHeat_TwoCool_ThermostatContol_HTA_583
#Scenario: HTA-583 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Electric 2H2C fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	
#@HTA_584	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_conventional_Hotwater_fancOIL_TwoHeat_TwoCool_ThermostatContol_HTA_584 
#Scenario: HTA-584 Jasper device registration using bLE mode on Resideo pro app with Heating system as Conventional forced air and fuel as Hot water fan coil 2H2C fan operation as Thermostat controls configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL" 
#	Then Set Rezi App ISUType "COOLING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "HEATING STAGE" to ISUValue "2" 
#	Then Set Rezi App ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COOL CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	# Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "HEAT" stage "1" turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	And Check system test configuration has "HEAT" stage "2" turned on in Rezi App with relay "W_OB:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	##Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#
#@HTA_585	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_O_1Heat_1cool_stage1_HTA_585 
#Scenario: HTA-585 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 1H1C reversing valve O OB ON COOL configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	#w_ob turned on all demand is there 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_586	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AirToAir_O_coolOnly_stage2_HTA_586 
#Scenario: HTA-586 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H2C reversing valve B OB ON HEAT configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_587	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_1Cool_2Heat_HTA_587 
#Scenario: HTA-587 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve B OB ON HEAT with AuxE terminal Together configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_588
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_HTA_588 
#Scenario: HTA-588 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_589	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_1Cool_2Heat_HTA_589 
#Scenario: HTA-589 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false"
#
#@HTA_590
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AirToAir_B_1Cool_2Heat_together_HTA_590 
#Scenario: HTA-590 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_591	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_1Cool_2Heat_together_HTA_591 
#Scenario: HTA-591 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_592	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_GAS_STANDARD_independent_HTA_592 
#Scenario: HTA-592 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Gas or Oil forced air configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_593	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_1Cool_2Heat_GAS_STANDARD_independent_HTA_593 
#Scenario: HTA-593 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Gas or Oil forced air configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_594	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_together_dual-fuel_HTA_594 
#Scenario: HTA-594 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_595	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_1Cool_2Heat_Independent_dual-fuel_HTA_595 
#Scenario: HTA-595 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_596	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_1Cool_2Heat_Independent_dual-fuel_HTA_596 
#Scenario: HTA-596 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 2H1C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas standard Emergency heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_597	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Together_HTA_597 
#Scenario: HTA-597 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_598	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Together_HTA_598 
#Scenario: HTA-598 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_599	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Independent_HTA_599 
#Scenario: HTA-599 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_600	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Independent_HTA_600 
#Scenario: HTA-600 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Electric Emergency heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_601	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Together_Gas-Oil_HTA_601 
#Scenario: HTA-601 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_602	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Together_HTA_602 
#Scenario: HTA-602 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas Standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_603	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Independent_GAS_STANDARD_HTA_603
#Scenario: HTA-603 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas Standard Emergency heat as Gas or Oil forced airconfiguration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_604	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Independent_GAS_STANDARD_HTA_604 
#Scenario: HTA-604 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas Standard Emergency heat as Electric configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "ELECTRIC" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "EXTERNAL FOSSIL FUEL KIT" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G:Y2:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E:G" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#@HTA_605	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_AitToAir_B_2Cool_3Heat_Together_Gas-Oil_thermostatControl_HTA_605 
#Scenario: HTA-605 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Air to Air 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas Standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#
#@HTA_606	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Together_HTA_606
#Scenario: HTA-606 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Together and backup heat as Gas Standard configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#
#@HTA_608	
#@T6ProWiFi_ReziApp_JasperNATrade_DIY_heatPump_GEOTHERMAL_B_2Cool_3Heat_Independent_GAS_STANDARD_HTA_608 
#Scenario: HTA-608 Jasper device registration using bLE mode on Resideo pro app with Heating system as Heat pump and fuel as Geothermal 3H2C reversing valve B OB ON HEAT with AuxE terminal Independent and backup heat as Gas Standard  Emergency heat as Gas or Oil forced air configuration
#	Given user launches and logs in to the Rezi APP 
#	And User BroadCast the device for Registration from "Start setup" Screen 
#	Then Add new device for Registration in Rezi App 
#	And perform initial installtion setup in Rezi App 
#	Then Connect with Thermostat "BLE" in Rezi App 
#	Then Select Required option is "CONFIGURATION" in Rezi App 
#	Then Set Rezi App ISUType "SCHEDULING OPTIONS" to ISUValue "ALL DAYS SAME" 
#	Then Set Rezi App ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET" 
#	Then Set Rezi App ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP" 
#	Then Set Rezi App ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL" 
#	Then Set Rezi App ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT" 
#	Then Set Rezi App ISUType "COMPRESSOR STAGES" to ISUValue "2" 
#	Then Set Rezi App ISUType "BACKUP HEAT STAGES" to ISUValue "1" 
#	Then Set Rezi App ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT" 
#	Then Set Rezi App ISUType "BACKUP HEAT" to ISUValue "GAS STANDARD" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT" to ISUValue "GAS OR OIL-FORCED AIR" 
#	Then Set Rezi App ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "Thermostat" 
#	Then Set Rezi App ISUType "BACKUP HEAT DROOP" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "OUTDOOR HEAT LOCKOUT" to ISUValue "OFF" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "DEFAULT" 
#	Then Set Rezi App ISUType "INDOOR SENSOR" to ISUValue "NONE" 
#	Then Set Rezi App ISUType "VENTILATION TYPE" to ISUValue "NONE" 
#	Then Confirm ISU summary in Rezi App 
#	#Diagnostics Test =======================================================
#	Then Select Required option is "DIAGNOSTICS" in Rezi App 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "1" turned on in Rezi App with relay "W_OB:Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR HEAT" stage "2" turned on in Rezi App with relay "W_OB:Y:G:Y2" in Thermostat 
#	And Check system test configuration has "BACKUP HEAT" stage "1" turned on in Rezi App with relay "W_OB:W2_AUX" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "1" turned on in Rezi App with relay "Y:G" in Thermostat 
#	And Check system test configuration has "COMPRESSOR COOL" stage "2" turned on in Rezi App with relay "Y:G:Y2" in Thermostat 
#	And Check system test configuration has "EMERGENCY HEAT" stage "1" turned on in Rezi App with relay "W_OB:E" in Thermostat 
#	Then Check system test configuration has "FAN" mode turned on in Rezi App with relay "W_OB:G" in Thermostat 
#	Then Finish Installer Diagnostic Test 
#	Then Select Required option is "CUSTOMER INFO" in Rezi App 
#	And Check the Existing customer "hhprod2@grr.la", and Send Invite to the Customer 
#	And Disconnect Tstat from Resideo Pro 
#	Then Close the "Resideo Pro" Application 
#	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "AP MODE" 
#	Given user launches and logs in to the Honeywell Home application 
#	When User Accept Invitation then Connect To Thermostat Wifi Network 
#	Then connect with thermostat in "AP MODE"
#	Then Confirm ISU summary 
#	Then Connect with WiFi 
#	And user select location name as "Home" 
#	And choose "Default" thermostat name 
#	Then wait for connecting to honeywell 
#	Then user waits for data synch after registration 
#	Then delete Registered thermostat in app 
#	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
#	Then verify stat is unregistered from cloud 
#	And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
#	
#	