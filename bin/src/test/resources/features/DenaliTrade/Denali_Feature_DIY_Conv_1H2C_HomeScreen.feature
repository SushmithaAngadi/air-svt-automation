 @Denali_Feature_DIY_Conv_1H2C_HomeScreen
Feature: Denali_DIY_Conv_1H2C_HomeScreen

 @Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5535
Scenario: Denali_Trade_DIY_1_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_ConfigureWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"
Then Set configuration on First Alert APP ISUType "LANGUAGE" to ISUValue "ENGLISH"
Then Set configuration on First Alert APP ISUType "APPLICATION" to ISUValue "RESIDENTIAL" 
Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NONE" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
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
Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
#Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" #DOUBT 
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
Scenario: Denali_Trade_DIY_2_FromHomeScreen_Conventional_Gas_High_Eff_1H2C_ConfigureISU_ConfigureWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"

Then Set configuration on First Alert APP ISUType "LANGUAGE" to ISUValue "ENGLISH"
Then Set configuration on First Alert APP ISUType "APPLICATION" to ISUValue "RESIDENTIAL" 
Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NONE" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
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
Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
#Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" #DOUBT 
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
Scenario: Denali_Trade_DIY_3_FromHomeScreen_Conventional_Oil_1H2C_ConfigureISU_ConfigureWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"

Then Set configuration on First Alert APP ISUType "LANGUAGE" to ISUValue "ENGLISH"
Then Set configuration on First Alert APP ISUType "APPLICATION" to ISUValue "RESIDENTIAL" 
Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NONE" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
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
Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
#Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" #DOUBT 
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


 @Denali_Trade_DIY_3_2_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_ConfigureWiFi @--xrayid:HTA-5538
Scenario: Denali_Trade_DIY_3_2_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_ConfigureWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_3_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_SkipWiFi @--xrayid:HTA-5539
Scenario: Denali_Trade_DIY_3_3_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_SkipISU_SkipWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "skip" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
Then Delete registered device from First alert APP


 @Denali_Trade_DIY_3_4_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_SkipWiFi @--xrayid:HTA-5540
Scenario: Denali_Trade_DIY_3_4_FromHomeScreen_Conventional_Gas_Std_Eff_1H2C_ConfigureISU_SkipWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"
Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
Then user verifies for data synch after registration on First Alert APP
And user verifies thermostat configuration as "Gas" with "1" heat and "3" cool stages in FA App
Then Delete registered device from First alert APP



 @Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H2C_ConfigureISU_ConfigureWiFi @--xrayid:HTA-5541
Scenario: Denali_Trade_DIY_4_FromHomeScreen_Conventional_Electric_1H2C_ConfigureISU_ConfigureWiFi
Given user launches and logs in to the first alert app
Given user broadCast the device from "Home" Screen 
Then Add new device to Configure in First Alert App
Then Setup Device Location and Device name for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then First Alert app "always" configure the ISU, is device factory reset "NO"

Then Set configuration on First Alert APP ISUType "LANGUAGE" to ISUValue "ENGLISH"
Then Set configuration on First Alert APP ISUType "APPLICATION" to ISUValue "RESIDENTIAL" 
Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR" 
Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NONE" 
Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
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
Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
#Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" #DOUBT 
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



