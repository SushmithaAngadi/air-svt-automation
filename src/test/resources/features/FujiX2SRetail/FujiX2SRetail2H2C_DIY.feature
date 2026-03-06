@Fuji_X2S_RETAIL_2H2C_DIY_Feature
Feature: FUJI Devices Registration on First Alert app using BLE flow

#@FujiX2SRetail_2H2C_DIY_FromStartSetup
#Scenario: FUJI DIY registration using first alert app from factory reset state
#	And user broadcast FUJI device for registration from "START SETUP" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "YES"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
##	#Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
#	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
##	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "ELECTRIC"
##	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "HOT WATER FAN COIL"
##	#Then Set configuration on First Alert APP ISUType "FUEL SOURCE" to ISUValue "OIL"
#	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
#	#Then Set configuration on First Alert APP ISUType "AUX BACKUP HEAT" to ISUValue "HIGH EFFICIENCY GAS FORCED AIR"
#	Then First Alert app wifi "always" configure the wifi, is device factory reset "YES"
#	Then user verifies for data synch after registration on First Alert APP
#	Then Delete registered device from First alert APP
#	
#	
#	
#	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Reconfiguration
#	Scenario: FUJI DIY registration using first alert app from Home Screen state
#	And user broadcast FUJI device for registration from "HOME" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "NO"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
#	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
#	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
#	Then First Alert app wifi "always" configure the wifi, is device factory reset "NO"
#	Then user verifies for data synch after registration on First Alert APP
#	Then Delete registered device from First alert APP
#	
#	
#	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Configuration_default
#	Scenario: FUJI DIY registration using first alert app from Home Screen state
#	And user broadcast FUJI device for registration from "HOME" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "NO"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
#	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
#	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
#	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
#	#Then user verifies for data synch after registration on First Alert APP
#	#Then Delete registered device from First alert APP


@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Reconfiguration_Conv_HotWaterFanCoil
	Scenario: FUJI DIY registration using first alert app from Home Screen state
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER FAN COIL"
	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	
	
 
 
#	
#	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Reconfiguration_Radint_HotWater
#	Scenario: FUJI DIY registration using first alert app from Home Screen state
#	And user broadcast FUJI device for registration from "HOME" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "NO"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
#	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
#	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
#	Then user verifies for data synch after registration on First Alert APP
#	Then Delete registered device from First alert APP
#	
#	
#	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Reconfiguration_Radint_Steam
#	Scenario: FUJI DIY registration using first alert app from Home Screen state
#	And user broadcast FUJI device for registration from "HOME" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "NO"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
#	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "STEAM"
#	Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
#	Then user verifies for data synch after registration on First Alert APP
#	Then Delete registered device from First alert APP

#	@FujiX2SRetail_2H2C_DIY_FromHomeScreen_Reconfiguration_HP_ElectricHeat
#	Scenario: FUJI DIY registration using first alert app from Home Screen state
#	And user broadcast FUJI device for registration from "HOME" screen 
#	Given user launches and logs in to the "first alert" app
#	Then Add new device to Configure in First Alert App
#	Then Setup Device "Location and name" for DIY
#	Then Perform initial installation setup for "BLE" mode in First Alert APP
#	Then Connect with Thermostat in "Ble" mode in First Alert App
#	Then First Alert app "always" configure the ISU, is device factory reset "NO"
#	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
#	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
#	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC HEAT STRIPS"
#	Then Confirm "CHECK CONFIGURATION" Screen in FirstAlert APP
#	Then Set configuration on First Alert APP ISUType "VERIFICATION RETAIL" to ISUValue "WARM AIR"
#	#Then Set configuration on First Alert APP ISUType "VERIFICATION RETAIL" to ISUValue "COOL AIR"
#	#Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO"
#	#Then user verifies for data synch after registration on First Alert APP
#	#Then Delete registered device from First alert APP
#	
