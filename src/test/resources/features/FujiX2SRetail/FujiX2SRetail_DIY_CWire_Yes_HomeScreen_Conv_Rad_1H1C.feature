@FujiX2SRetail_DIY_CWire_Yes_HomeScreen_Conv_Rad_1H1C
Feature: FUJI Devices Registration on First Alert app using BLE flow
#   Switches needs to be On : W (Y, G are considered for C Wire)

	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_Gas_StdEff_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Conv_Gas_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
	#Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP


	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_HighEffGas_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Conv_HighEff_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP


	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_Oil_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Conv_Oil_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP


	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_HotWaterFanCoil_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Conv_HWFC_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER FAN COIL"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP

	
	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_Electric_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Conv_Elec_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "ELECTRIC"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP

 
##	*********************************************************************************

		
	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_Radiant_HotWater_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Rad_HW_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP



	@FujiX2SRetail_DIY_CWire_Yes_FromHomeScreen_Conv_Radiant_Steam_1H1C
	Scenario: FUJI DIY registration using FA app from Home Screen state_Rad_Steam_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "STEAM"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP

