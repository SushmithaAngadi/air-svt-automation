 @Denali_Feature_DIY_HP_HomeScreen
Feature: Denali_DIY_HP_HomeScreen


# Set 1 : Denali_Feature_DIY_HP_1H1C_No_BackupHeat_HomeScreen

	@Denali_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_No_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5664
	Scenario: Denali_5664_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_No_BackupHeat_ConfigureISU_ConfigureWiFi

		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		

		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "AIR TO AIR"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"

		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue ""
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
		Then Delete registered device from First alert APP
		
		
		
	@Denali_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_1H1C_No_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5665
	Scenario: Denali_5665_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_1H1C_No_BackupHeat_ConfigureISU_ConfigureWiFi
	
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		

		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GEOTHERMAL"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"

		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"

		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue ""
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
		Then Delete registered device from First alert APP
		
# Set 2 : 	Denali_Feature_DIY_HP_1H1C_1_BackupHeat_HomeScreen

	@Denali_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_1_BackupHeat_Aux_E_Together_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5666
	Scenario: Denali_5666_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_1_BackupHeat_Aux_E_Together_ConfigureISU_ConfigureWiFi
		 
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		

		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "AIR TO AIR"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "Thermostat Aux"

		
		Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "ELECTRIC FORCED AIR"
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"

		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL HP" to ISUValue "COMFORT" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9" 
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
		
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
		Then Confirm ISU summary in FirstAlert APP 
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
		Then user verifies for data synch after registration on First Alert APP 
		And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App 
		Then Delete registered device from First alert APP 
		
		
	@Denali_Trade_DIY_2_FromHomeScreen_HP_GeoThermal_B_Heat_1H1C_1_BackupHeat_Aux_E_Independent_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5667
	Scenario: Denali_5667_Trade_DIY_2_FromHomeScreen_HP_GeoThermal_B_Heat_1H1C_1_BackupHeat_Aux_E_Independent_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GEOTHERMAL"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "Thermostat Aux"

		Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "HOT WATER FAN COIL"
		
		Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "OIL FORCED AIR"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT OPERATION" to ISUValue "Allowed to Run with Primary Heat"
		Then Set configuration on First Alert APP ISUType "Emergency Heat Operation" to ISUValue "Not Allowed to Run with Primary Heat"
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"

		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "Off"
		
#		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT_BALANCE POINT" to ISUValue "OFF" 
		# or
		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "5"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
		#
#		Then Set configuration on First Alert APP ISUType "Minimum Compressor Off Time" to ISUValue "5"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue ""  
		
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
		Then Delete registered device from First alert APP
		
		
		
		
# Set 3 : 	Denali_Feature_DIY_HP_1H1C_2_BackupHeat_HomeScreen		
		
		
		
 @Denali_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_2_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5668
Scenario: Denali_5668_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_1H1C_2_BackupHeat_ConfigureISU_ConfigureWiFi

		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		

		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "AIR TO AIR"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "Thermostat Aux"
		Then Set configuration on First Alert APP ISUType "HEAT PUMP STAGE 2 WIRING" to ISUValue "THERMOSTAT U" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "ELECTRIC FORCED AIR"
		
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL HP" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGE 2 DIFFERENTIAL HP" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "Off"

		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
#
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR - STAGE 2" to ISUValue "9" # need to develop
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		  
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "3" heat and "1" cool stages in FA App
		Then Delete registered device from First alert APP
		
		
		 @Denali_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_1H1C_2_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5669
		Scenario: Denali_5669_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_1H1C_2_BackupHeat_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GEOTHERMAL"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "Thermostat Aux"
		Then Set configuration on First Alert APP ISUType "HEAT PUMP STAGE 2 WIRING" to ISUValue "THERMOSTAT U" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "HIGH EFFICIENCY GAS FORCED AIR"
		Then Set configuration on First Alert APP ISUType "EXTERNAL FOSSIL FUEL KIT" to ISUValue "THERMOSTAT CONTROLS BACKUP HEAT"
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
		
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
#		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL HP" to ISUValue "2 DEG"
#		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGE 2 DIFFERENTIAL HP" to ISUValue "3 DEG"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGE 2 DIFFERENTIAL" to ISUValue "2.5 DEG" 
		
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF"

		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR - STAGE 2" to ISUValue "3" # need to develop
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		  
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "3" heat and "1" cool stages in FA App
		Then Delete registered device from First alert APP
		
		
	# Set 4 : 	Denali_Feature_DIY_HP_2H2C_2_BackupHeat_HomeScreen	
	
		 @Denali_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_2H2C_2_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5855
		Scenario: Denali_5855_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_2H2C_2_BackupHeat_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		

		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
 		Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "AIR TO AIR"
 		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "Thermostat Aux"
		Then Set configuration on First Alert APP ISUType "HEAT PUMP STAGE 2 WIRING" to ISUValue "THERMOSTAT U" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "ELECTRIC FORCED AIR"
		
		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"	
		
		Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL HP" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGE 2 DIFFERENTIAL HP" to ISUValue "COMFORT"

		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "Off"
#		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT_ BALANCE POINT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR - STAGE 2" to ISUValue "9" 
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"
	
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90"
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50"
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		  
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "4" heat and "2" cool stages in FA App
		Then Delete registered device from First alert APP
		
		 @Denali_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_2H2C_2_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5856
		Scenario: Denali_5856_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_2H2C_2_BackupHeat_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GEOTHERMAL"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT WIRING" to ISUValue "THERMOSTAT AUX"
		Then Set configuration on First Alert APP ISUType "HEAT PUMP STAGE 2 WIRING" to ISUValue "THERMOSTAT U" 
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "ELECTRIC FORCED AIR"

		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
  		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
  		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"

		Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT"

#		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL HP" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGE 2 DIFFERENTIAL HP" to ISUValue "COMFORT"

		Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
#"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR - STAGE 2" to ISUValue "9"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF"	 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		 
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "4" heat and "2" cool stages in FA App
		Then Delete registered device from First alert APP
		
		
# Set 5 : 	Denali_Feature_DIY_HP_2H2C_0_BackupHeat_HomeScreen
		
		 @Denali_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_2H2C_0_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5857
		Scenario: Denali_5857_Trade_DIY_1_FromHomeScreen_HP_A2A_O_Cool_2H2C_0_BackupHeat_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		
		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "AIR TO AIR"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "None"

		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
  		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
  		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
  		
  		Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT"
		
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
#"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "2" cool stages in FA App
		Then Delete registered device from First alert APP
		
		 @Denali_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_2H2C_0_BackupHeat_ConfigureISU_ConfigureWiFi @--xrayid:DENALI-5858
		Scenario: Denali_5858_Trade_DIY_2_FromHomeScreen_HP_Geothermal_B_Heat_2H2C_0_BackupHeat_ConfigureISU_ConfigureWiFi
		
		Given user launches and logs in to the "first alert" app
		Given user runs "MQTT" command "factory reset without WIFI"
		Given user broadCast the device from "Home Screen" 
		Then Add new device to Configure in First Alert App
		Then Setup Device "Location and name" for DIY
		Then Perform initial installation setup for "BLE" mode in First Alert APP
		Then Connect with Thermostat in "Ble" mode in First Alert App
		Then First Alert app "always" configure the ISU, is device factory reset "NO"
		
 
		Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
		Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
		
		Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
		Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GEOTHERMAL"
		Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
		
		Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
		Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "None"

		Then Set configuration on First Alert APP ISUType "L TERMINAL ALERT" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK"
  		Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
  		Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
  		
  		Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
		Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR COOL STAGE 2 DIFFERENTIAL" to ISUValue "COMFORT"
		Then Set configuration on First Alert APP ISUType "STAGING CONTROL - COMPRESSOR HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT"
		
		Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
#"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "3"
		Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"

		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
		
		Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
		Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
		Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
		Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
		Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
		
		Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
		Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF"
		Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
		
		Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
		Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
		Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F"
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%"  
		Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES"
		Then Confirm ISU summary in FirstAlert APP
		
		Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
		Then user verifies for data synch after registration on First Alert APP
		And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "2" cool stages in FA App
		Then Delete registered device from First alert APP
		