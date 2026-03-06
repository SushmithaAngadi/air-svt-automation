@FUJICOM_14261_FujiX2SRetail_DIY_CWire_No_HomeScreen_Conv_Rad_1H1C
Feature: FUJI Devices Registration on First Alert app using BLE flow
#   Switches needs to be On : W, G, Y

	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_1H1C
	Scenario: 	FUJICOM-14254_FUJI DIY registration using FA app from Home Screen state_Conv_StdEffGas_1H1C
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
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	


	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_1H1C
	Scenario: FUJICOM-14262_FUJI DIY registration using FA app from Home Screen state_Conv_HighEff_1H1C
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
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS"
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP


	
	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_1H1C
	Scenario: FUJICOM-14263_FUJI DIY registration using FA app from Home Screen state_Conv_Oil_1H1C
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
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	

	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HotWaterFanCoil_1H1C
	Scenario: FUJICOM-14264_FUJI DIY registration using FA app from Home Screen state_Conv_HWFC_1H1C
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
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
		
	
	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Electric_1H1C
	Scenario: FUJICOM-14265_FUJI DIY registration using FA app from Home Screen state_Conv_Elec_1H1C
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
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "ELECTRIC"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
 
##	*********************************************************************************

		
	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_1H1C
	Scenario: FUJICOM-14266_FUJI DIY registration using FA app from Home Screen state_Rad_HW_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
#	

	@FujiX2SRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_1H1C
	Scenario: FUJICOM-14267_FUJI DIY registration using FA app from Home Screen state_Rad_Steam_1H1C
	And user broadcast FUJI device for registration from "HOME" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "NO"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "STEAM"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP

#	
