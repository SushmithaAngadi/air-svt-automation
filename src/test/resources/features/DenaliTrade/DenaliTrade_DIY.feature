@Denali_Feature
Feature: Denali Devices features

@Denali_DIY_Trade_HeatingSystem_ConventionalForcedAir
Scenario: Denali DIY Trade with Heating System Conventional Forced Air
	Given user launches and logs in to the "first alert" app
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "LANGUAGE" to ISUValue "ENGLISH"
    Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
    Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
    Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "GAS HIGH EFFICIENCY"
    Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "89"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "3 CALENDAR MONTHS"
    Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
    Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
    Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
    Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "-2.0DEG F"
    Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "2%"
    Then Confirm ISU summary in FirstAlert APP
    And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP


@Denali_DIY_flowForApp807
Scenario: Denali DIY  
Given user launches and logs in to the "first alert" app
Given user broadCast the device from "Home Screen" 
Then Add new device to Configure in First Alert App
Then Setup Device "Location and name" for DIY
Then Perform initial installation setup for "BLE" mode in First Alert APP
Then Connect with Thermostat in "Ble" mode in First Alert App
Then user verifies for data synch after registration on First Alert APP
Then Delete registered device from First alert APP

@Denali_DIY_Trade_flowForApp941 
Scenario: Denali DIY Trade
	Given user launches and logs in to the "first alert" app
	Given user broadCast the device from "Home Screen" 
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
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "51"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "89"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "42"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "3 CALENDAR MONTHS"
    Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
    Then Confirm ISU summary in FirstAlert APP
    And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
		
@Denali_DIY_Trade_flowForApp900
Scenario: Denali DIY Trade
	Given user launches and logs in to the "first alert" app
	Given user broadCast the device from "Home Screen" 
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
    Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
    Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
    Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "2 DEG"
    Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER COOL CALL" to ISUValue "25 MINUTES"
    Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "HEAT CYCLE PER HOUR-STAGE 1" to ISUValue "6"
    Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5 MINUTES" 
    Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "5 MINUTES" 
    Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
    Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "98"
    Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50"
    Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "50"
    Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
    Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
    Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
    Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "2"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "90 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "AIR FILTER 2 REPLACEMENT REMINDER" to ISUValue "60 RUN TIME DAYS"
    Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF"
    Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE"
    Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "3 CALENDAR MONTHS"
    Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0"
    Then Confirm ISU summary in FirstAlert APP
    And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	@Denali_DIY_Trade_flow @--xrayid:DENALI-4495
	Scenario: Denali DIY Trade
	Given user launches and logs in to the "first alert" app
	Given user broadCast the device from "Home Screen" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
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
  Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
  Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
  Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN"
  Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
  Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NONE" 
  Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
  Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG"
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
  Then Set configuration on First Alert APP ISUType "KEYPAD LOCKOUT" to ISUValue "ENABLED"
  Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
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
	Then Delete registered device from First alert APP
  
	