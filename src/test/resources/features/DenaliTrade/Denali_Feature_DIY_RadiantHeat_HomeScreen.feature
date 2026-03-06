@Denali_Feature_DIY_RadiantHeat_HomeScreen 
Feature: Denali_DIY_RadHeat_1H1C_HomeScreen 

@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadFloorHeat_1H1C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5574 
Scenario: HTA-5574_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadFloorHeat_1H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "WIRED" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT FLOOR HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "CONTROL MODE" to ISUValue "AIR AND FLOOR SENSORS" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
	Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "FLOOR TEMPERATURE SENSOR"
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR WIRING ASSIGNMENT" to ISUValue "THERMOSTAT S" 
	Then Set configuration on First Alert APP ISUType "MINIMUM FLOOR TEMPERATURE LIMITS" to ISUValue "72"
	Then Set configuration on First Alert APP ISUType "MAXIMUM FLOOR TEMPERATURE LIMITS" to ISUValue "85"
	Then Set configuration on First Alert APP ISUType "FLOOR ECONOMY MODE" to ISUValue "NO"  
	Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40deg" 
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
	And user verifies thermostat configuration as "Floor Heat" with "1" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_HWRadHeat_1H1C_ConfigureISU_ConfigureWiFin @--xrayid:HTA-5575 
Scenario: HTA-5575_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_HWRadHeat_1H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "MINIMUM NON-COMPRESSOR ON TIME" to ISUValue "OFF"  # new Screen
  Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40deg" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
	
@Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_HWRadHeat_1H1C_SkipISU_ConfigureWiFi
@--xrayid:HTA-5576 
Scenario: HTA-5576_Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_HWRadHeat_1H1C_SkipISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "skip" configure the ISU, is device factory reset "NO" 
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
	Then user verifies for data synch after registration on First Alert APP 
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_3_FromHomeScreen_RadiantHeat_Steam_1H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5577 
Scenario: HTA-5577_Denali_Trade_DIY_3_FromHomeScreen_RadiantHeat_Steam_1H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "STEAM" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "MINIMUM NON-COMPRESSOR ON TIME" to ISUValue "OFF" # new Screen
  Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40deg" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 

	
	@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_1H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5588 
Scenario: HTA-5588_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_1H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_1H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5589 
Scenario: HTA-5589_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_1H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_FromHomeScreen_RadiantHeat_HWRadFlrHt_1H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5590 
Scenario: HTA-5590_Denali_Trade_DIY_3_FromHomeScreen_RadiantHeat_HWRadFlrHt_1H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Hot Water Radiant Floor Heat" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "CONTROL MODE" to ISUValue "AIR SENSOR ONLY" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Floor Heat" with "1" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_2H1C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5578 
Scenario: HTA-5578_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_2H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_2H1C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5579 
Scenario: HTA-5579_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_2H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "START SETUP" Screen 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
	
@Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_Steam_2H1C_SkipISU_SkipWiFi
@--xrayid:HTA-5580 
Scenario: HTA-5580_Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_Steam_2H1C_SkipISU_SkipWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "skip" configure the ISU, is device factory reset "NO" 
	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO" 
	Then user verifies for data synch after registration on First Alert APP 
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
	@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_2H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5581 
Scenario: HTA-5581_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_2H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_2H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5582 
Scenario: HTA-5582_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_2H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "START SETUP" Screen 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
    Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
	
@Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_Steam_2H2C_ConfigureISU_SkipWiFi
@--xrayid:HTA-5583 
Scenario: HTA-5583_Denali_Trade_DIY_2_1_FromHomeScreen_RadiantHeat_Steam_2H2C_ConfigureISU_SkipWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO" 
	Then user verifies for data synch after registration on First Alert APP 
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_3H1C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5584 
Scenario: HTA-5584_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_3H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U"
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT" # "COMFORT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "3" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_3H1C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5585 
Scenario: HTA-5585_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_3H1C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT" # "COMFORT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "3" heat and "1" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	@Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_3H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5586 
Scenario: HTA-5586_Denali_Trade_DIY_1_FromHomeScreen_RadiantHeat_HWRadHeat_3H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT" # "COMFORT"
  	Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "3" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	
@Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_3H2C_ConfigureISU_ConfigureWiFi
@--xrayid:HTA-5587 
Scenario: HTA-5587_Denali_Trade_DIY_2_FromHomeScreen_RadiantHeat_Steam_3H2C_ConfigureISU_ConfigureWiFi 
	Given user launches and logs in to the "first alert" app 
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App 
	Then Setup Device "Location and name" for DIY 
	Then Perform initial installation setup for "BLE" mode in First Alert APP 
	Then Connect with Thermostat in "Ble" mode in First Alert App 
	Then First Alert app "always" configure the ISU, is device factory reset "NO" 
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
	Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "RADIANT HEAT" 
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "Steam" 
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U" 
	Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
	Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT" 
	Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT" # "COMFORT"
  Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "1" 
	Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
	Then Set configuration on First Alert APP ISUType "NON COMPRESSOR ON TIME" to ISUValue "Off" 
	Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
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
  Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "40DEG" 
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
	And user verifies thermostat configuration as "Hydronic Heat" with "3" heat and "2" cool stages in FA App 
	Then Delete registered device from First alert APP 
	
	