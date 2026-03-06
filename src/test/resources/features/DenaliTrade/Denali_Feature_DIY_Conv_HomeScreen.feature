 @Denali_Feature_DIY_Conv_HomeScreen
Feature: Denali_DIY_Conv_1H1C_HomeScreen

@Denali_Trade_DIY_1_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_skipISU_ConfigureWiFi @--xrayid:HTA-5521
Scenario: HTA-5521_Denali_Trade_DIY_1_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_ConfigureISU_ConfigureWiFi

Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"

Then First Alert app wifi "ALREADY" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


@Denali_Trade_DIY_1_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5521
Scenario: HTA-5521_Denali_Trade_DIY_1_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


@Denali_Trade_DIY_1_2_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_SkipISU_ConfigureWiFi @--xrayid:HTA-5522
Scenario: HTA-5522_Denali_Trade_DIY_1_2_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_SkipISU_ConfigureWiFi
Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_3_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_SkipISU_SkipWiFi @--xrayid:HTA-5523
Scenario: HTA-5523_Denali_Trade_DIY_1_3_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_SkipISU_SkipWiFi

Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert xAPP
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_4_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_ConfigureISU_SkipWiFi @--xrayid:HTA-5524
Scenario: HTA-5524_Denali_Trade_DIY_1_4_FromHomeScreen_Conventional_Gas_Std_Eff_1H1C_ConfigureISU_SkipWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_1H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5525
Scenario: HTA-5525_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_1H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_1H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5526
Scenario: HTA-5526_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_1H1C_ConfigureISU_ConfigureWiFi

Given user launches and logs in to the "first alert" app
And user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"
Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5527
Scenario: HTA-5527_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5535
Scenario: HTA-5535_Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_ConfigureWiFi
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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5536
Scenario: HTA-5536_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_1H2C_ConfigureISU_ConfigureWiFi
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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5537
Scenario: HTA-5537_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_1H2C_ConfigureISU_ConfigureWiFi
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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_2_FromHomeScreen_Conventional_Oil_1H2C_SkipISU_ConfigureWiFi @--xrayid:HTA-5538
Scenario: HTA-5538_Denali_Trade_DIY_3_2_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_ConfigureWiFi
Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_3_FromHomeScreen_Conventional_Oil_1H2C_SkipISU_SkipWiFi @--xrayid:HTA-5539
Scenario: HTA-5539_Denali_Trade_DIY_3_3_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_SkipWiFi
Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_4_FromHomeScreen_Conventional_Oil_1H2C_ConfigureISU_SkipWiFi @--xrayid:HTA-5540
Scenario: HTA-5540_Denali_Trade_DIY_3_4_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_SkipWiFi
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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
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
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5541
Scenario: HTA-5541_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H2C_ConfigureISU_ConfigureWiFi
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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_2H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5528
Scenario: HTA-5528_Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_2H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5529
Scenario: HTA-5529_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_2_2_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_SkipISU_ConfigureWiFi @--xrayid:HTA-5530
Scenario: HTA-5530_Denali_Trade_DIY_2_2_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_SkipISU_ConfigureWiFi

Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_2_3_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_SkipISU_SkipWiFi @--xrayid:HTA-5531
Scenario: HTA-5531_Denali_Trade_DIY_2_3_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_SkipISU_SkipWiFi

Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_2_4_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_ConfigureISU_SkipWiFi @--xrayid:HTA-5532
Scenario: HTA-5532_Denali_Trade_DIY_2_4_FromHomeScreen_Conventional_Gas_High_Eff_2H1C_ConfigureISU_SkipWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_2H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5533
Scenario: HTA-5533_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_2H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_2H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5534
Scenario: HTA-5534_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_2H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP

 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_2H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5542
Scenario: HTA-5542_Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_2H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_2H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5543
Scenario: HTA-5543_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_2H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_2H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5544
Scenario: HTA-5544_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_2H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_2H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5545
Scenario: HTA-5545_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_2H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_4_2_FromHomeScreen_Conventional_Electric_2H2C_SkipISU_ConfigureWiFi @--xrayid:HTA-5546
Scenario: HTA-5546_Denali_Trade_DIY_4_2_FromHomeScreen_Conventional_Gas_Std_Eff_2H2C_SkipISU_ConfigureWiFi
Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_4_3_FromHomeScreen_Conventional_Electric_2H2C_SkipISU_SkipWiFi @--xrayid:HTA-5547
Scenario: HTA-5547_Denali_Trade_DIY_4_3_FromHomeScreen_Conventional_Gas_Std_Eff_2H2C_SkipISU_SkipWiFi

Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_4_4_FromHomeScreen_Conventional_Electric_2H2C_ConfigureISU_SkipWiFi @--xrayid:HTA-5548
Scenario: HTA-5548_Denali_Trade_DIY_4_4_FromHomeScreen_Conventional_Gas_Std_Eff_2H2C_ConfigureISU_SkipWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "9"
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
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_3H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5549
Scenario: HTA-5549_Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_3H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_3H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5550
Scenario: HTA-5550_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_3H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_3H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5551
Scenario: HTA-5551_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_3H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_3H1C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5552
Scenario: HTA-5552_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_3H1C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 3" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "3" heat and "1" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_3H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5553
Scenario: HTA-5553_Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_3H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS STANDARD EFFICIENCY"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_3H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5554
Scenario: HTA-5554_Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_3H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "GAS HIGH EFFICIENCY"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_3H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5555
Scenario: HTA-5555_Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_3H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "OIL"
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
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "5"
Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 3" to ISUValue "5"
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
And user verifies thermostat configuration as "Gas" with "3" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_3H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5556
Scenario: HTA-5556_Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_3H2C_ConfigureISU_ConfigureWiFi

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
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEATING STAGE 3 WIRING" to ISUValue "Thermostat U"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0DEG"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL COOL DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 2" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "STAGING CONTROL PRIMARY HEAT DIFFERENTIAL STAGE 3" to ISUValue "DEFAULT"
Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "OFF"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "9"
Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 3" to ISUValue "9"
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
And user verifies thermostat configuration as "Electric Heat" with "3" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP







