@FUJICOM_14222_FujiX2SRetail_DIY_CWire_No_StartSetupScreen_CoolOnly_1C_2C
Feature: FUJI Devices Registration on First Alert app using BLE flow
#   Switches needs to be On :G, Y -- G, Y, Y2

	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_CoolOnly_1C
	Scenario: FUJICOM-14248_FUJI DIY registration using FA app from Startup Screen state_CoolOnly_1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_CoolOnly_2C
	Scenario: FUJICOM-14249_FUJI DIY registration using FA app from Startup Screen state_CoolOnly_2C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Other" with "0" heat and "2" cool stages in FA App
	Then Delete registered device from First alert APP


#********************************************************************************************************
##	
##	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Configuration_default
##	Scenario: FUJI DIY registration using first alert app from Home Screen state
##	And user broadcast FUJI device for registration from "HOME" screen 
##	Given user launches and logs in to the "first alert" app
##	Then Add new device to Configure in First Alert App
##	Then Setup Device "Location and name" for DIY
##	Then Perform initial installation setup for "BLE" mode in First Alert APP
##	Then Connect with Thermostat in "Ble" mode in First Alert App
##	Then First Alert app "always" configure the ISU, is device factory reset "NO"
##	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
##	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
##	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
##	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
##	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
##	Then First Alert app wifi "skip" configure the wifi, is device factory reset "NO"
##	#Then user verifies for data synch after registration on First Alert APP
##	#Then Delete registered device from First alert APP
#
#
#
#
##@FujiX2SRetail_2H2C_DIY_FromStartSetup
##Scenario: FUJI DIY registration using first alert app from factory reset state
##	And user broadcast FUJI device for registration from "START SETUP" screen 
##	Given user launches and logs in to the "first alert" app
##	Then Add new device to Configure in First Alert App
##	Then Setup Device "Location and name" for DIY
##	Then Perform initial installation setup for "BLE" mode in First Alert APP
##	Then Connect with Thermostat in "Ble" mode in First Alert App
##	Then First Alert app "always" configure the ISU, is device factory reset "YES"
##	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
##	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
##	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
###	#Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
##	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
###	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
###	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
###	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
##	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
##	#Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "HIGH EFFICIENCY GAS FORCED AIR"
##	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
##	Then user verifies for data synch after registration on First Alert APP
##	Then Delete registered device from First alert APP
##	
##	
##	
#	
