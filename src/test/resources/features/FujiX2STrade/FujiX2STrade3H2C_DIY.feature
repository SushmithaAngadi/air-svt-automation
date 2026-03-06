@Fuji_X2S_TRADE_3H2C_DIY_Feature
Feature: FUJI Devices Registration on First Alert app using BLE flow

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Heat_Pump_Air_To_Air_3H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 3H2C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_DIY_FromStartSetup_Heat_Pump_Air_To_Air_3H2C
  Scenario: FUJI DIY registration using first alert app from factory reset state 3H2C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

	@FujiX2STrade_3H2C_DIY_FromHomeScreen_Heat_Pump_Air_To_Air_2H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H1C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
  @FujiX2STrade_3H2C_DIY_FromStartSetup_Heat_Pump_Air_To_Air_2H1C
  Scenario: FUJI DIY registration using first alert app from Factory Reset state 2H1C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

	@FujiX2STrade_DIY_FromHomeScreen_Heat_Pump_Air_To_Air_1H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_DIY_FromStartSetup_Heat_Pump_Air_To_Air_1H1C
  Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Heat Pump Air to Air for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
		
		@FujiX2STrade_3H2C_DIY_FromHomeScreen_Heat_Pump_Geothermal_2H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen 2H1C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Heat_Pump_Geothermal_2H1C
  Scenario: FUJI DIY registration using first alert app from factory reset state for 2H1C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Heat_Pump_Geothermal_3H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen 3H2C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Heat_Pump_Geothermal_3H2C
  Scenario: FUJI DIY registration using first alert app from factory reset state for 3H2C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "DRIVE BOTH AUX AND E TOGETHER"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Heat_Pump_Geothermal_1H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen 3H2C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Heat_Pump_Geothermal_1H1C
  Scenario: FUJI DIY registration using first alert app from factory reset state for 1H1C Heat Pump Geothermal for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "50 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "3.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
			
  @FujiX2STrade_3H2C_DIY_FromHomeScreen_user_exits_registration_flow
  Scenario: FUJI DIY registration From Home Screen user exits DIY flow after entering security pin Heat Pump for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Exit" on Exit Setup pop-up screen

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_user_continues_registration_flow_Heat_Pump
  Scenario: FUJI DIY Registration From Home Screen Continue from Exit Setup Pop-up after Entering Security Pin with Heat Pump for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Continue" on Exit Setup pop-up screen
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "SKIP" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Entering_Incorrect_Security_Pin_Cool_Only
  Scenario: FUJI DIY registration using First Alert App From Home Screen by enterring Incorrect security pin Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then user enters an incorrect security pin on the First Alert app for the "First" time and taps on OK and verify "2 attempts remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Second" time and taps on OK and verify "1 attempt remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Third" time and taps on OK and verify "Connection Failed"

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Interruption_Before_Entering_security_pin
  Scenario: FUJI DIY registration using First Alert App from Home Screen interruption Before entering security pin with Heat Pump for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then App is force killed before entering the security pin
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "SKIP" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_user_exits_registration_flow
  Scenario: FUJI DIY registration from factory reset state by exiting DIY flow after entering security pin with Heat Pump for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Exit" on Exit Setup pop-up screen

  @FujiX2STrade_3H2C_DIY_FromStartSetup_user_continues_registration_flow
  Scenario: FUJI DIY Registration From factory reset state by Continue from Exit Setup Popup after Entering Pin Heat Pump for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Continue" on Exit Setup pop-up screen
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AUXE TERMINAL CONTROL" to ISUValue "AUX AND E ARE INDEPENDENT"
    Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT" to ISUValue "STANDARD EFFICIENCY GAS FORCED AIR"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT UPSTAGE TIMER" to ISUValue "45 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR LOCKOUT" to ISUValue "35.0DEG F"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT LOCKOUT" to ISUValue "DEFAULT"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLE PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "EMERGENCY HEAT CYCLES PER HOUR" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "3" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Entering_Incorrect_Security_Pin_Cool_Only
  Scenario: FUJI DIY registration First Alert App from factory reset state by entering Incorrect security pin for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then user enters an incorrect security pin on the First Alert app for the "First" time and taps on OK and verify "2 attempts remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Second" time and taps on OK and verify "1 attempt remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Third" time and taps on OK and verify "Connection Failed"

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_High_Efficiency_2H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_High_Efficiency_2H2C
  Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_High_Efficiency_2H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H1C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_High_Efficiency_2H1C
  Scenario: FUJI DIY registration using first alert app from factory reset state 2H1C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_High_Efficiency_1H0C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H0C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_High_Efficiency_1H0C
  Scenario: FUJI DIY registration using first alert app from factory reset state 1H0C Conventional Gas High Efficiency for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Radiant_Heat_1H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Radiant_Heat_1H1C
  Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

	@FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Radiant_Heat_2H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Radiant_Heat_2H2C
  Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Radiant_Heat_2H0C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H0C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Radiant_Heat_2H0C
  Scenario: FUJI DIY registration using first alert app from factory reset state 2H0C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
     Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Radiant_Heat_1H0C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H0C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Radiant_Heat_1H0C
  Scenario: FUJI DIY registration using first alert app from factory reset state 1H0C Boiler Hotwater Radiant Heat for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_1_Cool_Only
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1 Cool Only for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_1_Cool_Only
  Scenario: FUJI DIY registration using first alert app From factory reset state 1 Cool Only for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_2Cool_Only
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2Cool Only for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromStartSetup_2Cool_Only
  Scenario: FUJI DIY registration using first alert app From factory reset state 2Cool Only for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "4"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_HotWater_Fan_Coil_1H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

   @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Hotwater_Fan_Coil_1H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
	@FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_HotWater_Fan_Coil_2H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

   @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Hotwater_Fan_Coil_2H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_HotWater_Fan_Coil_2H1C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 2H1C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

   @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Hotwater_Fan_Coil_2H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H1C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_HotWater_Fan_Coil_1H2C
  Scenario: FUJI DIY registration using first alert app from Home Screen state 1H2C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP

   @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Hotwater_Fan_Coil_1H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H2C Conventional Fan Coil for Fuji 3H2C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
	
	@FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Oil_2H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Oil_2H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Oil_2H1C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H1C Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Oil_2H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H1C Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "Off"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
	
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Oil_1H0C
    Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Oil_1H0C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H0C Conventional Oil for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_Standard_Efficiency_2H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_Standard_Efficiency_2H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_Standard_Efficiency_1H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 1H2C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_Standard_Efficiency_1H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H2C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Gas_Standard_Efficiency_1H1C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Gas_Standard_Efficiency_1H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Conventional Gas Standard Efficiency for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "1 MINUTE"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Steam_2H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Steam_2H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Steam_2H1C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H1C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Steam_2H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H1C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Boiler_Steam_1H1C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Boiler_Steam_1H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Boiler Steam for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Electric_2H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H2C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Electric_2H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H2C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Electric_1H2C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 1H2C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Electric_1H2C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H2C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH COOL STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
    Then Delete registered device from First alert APP
    
     @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Electric_2H0C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 2H0C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Electric_2H0C
    Scenario: FUJI DIY registration using first alert app from factory reset state 2H0C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "STAGING CONTROL HIGH HEAT STAGE" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 2" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "2" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromHomeScreen_Conventional_Electric_1H1C
    Scenario: FUJI DIY registration using first alert app from Home Screen state 1H1C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_3H2C_DIY_FromStartSetup_Conventional_Electric_1H1C
    Scenario: FUJI DIY registration using first alert app from factory reset state 1H1C Conventional Electric for Fuji 3H2C Device.
     And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "OUTDOOR AIR SENSOR" to ISUValue "INTERNET"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "3 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "20 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "99"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_ConfigureWifi_WithIncorrectPassword
    Scenario: FUJI DIY Wifi Configuration using first alert app with Incorrect Password.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "24 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT", is device factory reset "NO"
    When user verifies for data synch after registration on First Alert APP