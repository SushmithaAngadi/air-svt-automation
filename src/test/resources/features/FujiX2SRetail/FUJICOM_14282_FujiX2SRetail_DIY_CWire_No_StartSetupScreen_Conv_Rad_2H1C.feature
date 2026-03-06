@FUJICOM_14282_FujiX2SRetail_DIY_CWire_No_StartSetupScreen_Conv_Rad_2H1C
Feature: FUJI Devices Registration on First Alert app using BLE flow
  Switches needs to be On : W, G, Y, W2
  
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Conv_Gas_StdEff_2H1C
	Scenario: FUJICOM-14283_FUJI DIY registration  from Startup Screen state_Conv_StdEffGas_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	
	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Conv_Gas_HighEffGas_2H1C
	Scenario: FUJICOM-14284_FUJI DIY registration using FA app from Startup Screen state_Conv_HighEff_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP

	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Conv_Oil_2H1C
	Scenario: FUJICOM-14285_FUJI DIY registration using FA app from Startup Screen state_Conv_Oil_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	
	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Conv_Gas_HotWaterFanCoil_2H1C
	Scenario: FUJICOM-14286_FUJI DIY registration using FA app from Startup Screen state_Conv_HotWaterFanCoil_2H1C	
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER FAN COIL"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Conv_Electric_2H1C
	Scenario: FUJICOM-14287_FUJI DIY registration using FA app from Startup Screen state_Conv_Electric_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "ELECTRIC"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
#	
#
# 
##	*********************************************************************************
#
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Radiant_HotWater_2H1C
	Scenario: FUJICOM-14288_FUJI DIY registration using FA app from Startup Screen state_Radiant_HotWater_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic heat" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
		
	

	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_Radiant_Steam_2H1C
	Scenario: FUJICOM-14289_FUJI DIY registration using FA app from Startup Screen state_Radiant_Steam_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "STEAM"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic heat" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP



	
