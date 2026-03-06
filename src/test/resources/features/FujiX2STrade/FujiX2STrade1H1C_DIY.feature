@Fuji_X2S_TRADE_1H1C_DIY_Feature
Feature: FUJI Devices Registration on First Alert app using BLE flow

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_HeatPump_Air_To_Air
  Scenario: FUJI DIY registration using first alert app from Home Screen state Heat Pump Air to Air for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "1 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "20 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Conventional_Gas_High_Efficiency
  Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Gas High Efficiency for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStatSetupScreen_HeatPump_Air_To_Air
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Heat Pump Air to Air for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "AIR TO AIR"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "1 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "NO"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "20 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetupScreen_Conventional_Gas_High_Efficiency
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Conventional Gas High Efficiency for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Conventional_Electric
  Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Electric for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "ELECTRIC FORCED AIR HEAT STAGE" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "EQUIPMENT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetupScreen_Conventional_Electric
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Conventional Electric for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "3"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_HeatPump_Geothermal
  Scenario: FUJI DIY registration using first alert app from Home Screen state Heat Pump Geothermal for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "1 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "20 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetupScreen_HeatPump_Geothermal
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Heat Pump Geothermal for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GEOTHERMAL"
    Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "1 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "87"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "20 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Boiler_Radiant_Heat
  Scenario: FUJI DIY registration using first alert app from Home Screen state Boiler Hotwater Radiant Heat for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetupScreen_Boiler_Radiant_Heat
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Boiler Hotwater Radiant Heat for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_None_Cool_Only
  Scenario: FUJI DIY registration using first alert app from Home Screen state None Cool_Only for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetupScreen_None_Cool_Only
  Scenario: FUJI DIY registration using first alert app Factory Reset State None Cool Only for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_user_exits_registration_flow
  Scenario: FUJI DIY registration From Home Screen exits DIY flow after entering security pin Heat Pump for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Exit" on Exit Setup pop-up screen

  @FujiX2STrade_1H1C_DIY_FromStartSetup_user_exits_registration_flow
  Scenario: FUJI DIY registration from Factory Reset State by exiting DIY flow after entering security pin with Heat Pump for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Exit" on Exit Setup pop-up screen

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_user_continues_registration_flow
  Scenario: FUJI DIY Registration From Home Screen Continue from Exit Setup Pop-up after Entering Security Pin for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Continue" on Exit Setup pop-up screen
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "15 CALENDAR MONTHS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromStartSetup_user_continues_registration_flow
  Scenario: FUJI DIY Registration From Factory Reset State Continue from Exit Setup Pop-up after Entering Security Pin for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then user perform registration flow in First Alert app by clicking "Continue" on Exit Setup pop-up screen
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "24 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-1.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Entering_Incorrect_Security_Pin
  Scenario: FUJI DIY registration using First Alert App From Home Screen by entering Incorrect security pin Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then user enters an incorrect security pin on the First Alert app for the "First" time and taps on OK and verify "2 attempts remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Second" time and taps on OK and verify "1 attempt remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Third" time and taps on OK and verify "Connection Failed"

  @FujiX2STrade_1H1C_DIY_FromStartSetup_Entering_Incorrect_Security_Pin
  Scenario: FUJI DIY registration using First Alert App From Factory Reset State by entering Incorrect security pin Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then user enters an incorrect security pin on the First Alert app for the "First" time and taps on OK and verify "2 attempts remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Second" time and taps on OK and verify "1 attempt remaining"
    Then user enters an incorrect security pin on the First Alert app for the "Third" time and taps on OK and verify "Connection Failed"

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Interruption_Before_Entering_security_pin
  Scenario: FUJI DIY registration using First Alert App from Home Screen interruption Before entering security pin with Heat Pump for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then App is force killed before entering the security pin

  @FujiX2STrade_1H1C_DIY_FromHomeScreen_Boiler_Steam
  Scenario: FUJI DIY registration using first alert app from Home Screen state Boiler Steam for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP

    @FujiX2STrade_1H1C_DIY_FromStartSetup_Boiler_Steam
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Boiler Steam for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "STEAM"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_FromHomeScreen_Conventional_Fan_Coil
  Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Hotwater Fan Coil for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_FromStartSetup_Conventional_Fan_Coil
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Conventional Hotwater Fan Coil for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Electric Heat" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_FromHomeScreen_Conventional_Oil
  Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Oil for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "NO"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
     @FujiX2STrade_1H1C_DIY_FromStartSetup_Conventional_Oil
  Scenario: FUJI DIY registration using first alert app From Factory Reset State Conventional Oil for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR MINIMUM OFF TIME" to ISUValue "5 MINUTES"
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_FromHomeScreen_Conventional_Gas_Standard_Efficiency
  Scenario: FUJI DIY registration using first alert app from Home Screen state Conventional Gas Standard Efficiency for Fuji 1H1C Device.
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
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP
    
    @FujiX2STrade_1H1C_DIY_FromStartSetup_Conventional_Gas_Standard_Efficiency
  Scenario: FUJI DIY registration using first alert app from Factory Reset State Conventional Gas Standard Efficiency for Fuji 1H1C Device.
    And user broadcast FUJI device for registration from "START SETUP" screen
    Given user launches and logs in to the "first alert" app
    Then Add new device to Configure in First Alert App
    Then Setup Device "Location and name" for DIY
    Then Perform initial installation setup for "BLE" mode in First Alert APP
    Then Connect with Thermostat in "Ble" mode in First Alert App
    Then First Alert app "always" configure the ISU, is device factory reset "YES"
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
    Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
    Then user verifies for data synch after registration on First Alert APP
    When user verifies thermostat configuration as "Gas" with "1" heat and "0" cool stages in FA App
    Then Delete registered device from First alert APP 

  @FujiX2STrade_1H1C_DIY_ConfigureWifi_WithIncorrectPassword
  Scenario: FUJI DIY Wifi Configuration using first alert app with Incorrect Password.
    #And user broadcast FUJI device for registration from "HOME" screen
    Given user launches and logs in to the "first alert" app
    #Then Add new device to Configure in First Alert App
    #Then Setup Device "Location and name" for DIY
    #Then Perform initial installation setup for "BLE" mode in First Alert APP
    #Then Connect with Thermostat in "Ble" mode in First Alert App
    #Then First Alert app "always" configure the ISU, is device factory reset "NO"
    #Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    #Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    #Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS STANDARD EFFICIENCY"
    #Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
    #Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    #Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    #Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    #Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "88"
    #Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "41"
    #Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "DISABLED"
    #Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1"
    #Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    #Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
    #Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
    #Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
    #Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
    #Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
    #Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "24 HOUR"
    #Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    #Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    #Then Confirm ISU summary in FirstAlert APP
    Then First Alert app wifi "ALWAYS" configure the wifi with "INCORRECT PASSWORD for 4 times", is device factory reset "NO"
    When user verifies for data synch after registration on First Alert APP