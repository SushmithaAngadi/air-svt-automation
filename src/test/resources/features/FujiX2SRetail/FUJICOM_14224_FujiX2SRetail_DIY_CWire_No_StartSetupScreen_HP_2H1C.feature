@FUJICOM_14224_FujiX2SRetail_DIY_CWire_No_StartSetupScreen_HP_2H1C
Feature: FUJI Devices Registration on First Alert app using BLE flow
#   Switches needs to be On : O/B, G, Y, W2, E
	
	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_HP_WarmAir_ElectricHeat_2H1C
	Scenario: FUJICOM-14252_FUJI DIY registration using FA app from Startup Screen state_HP_WarmAir_ElectricHeat_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC HEAT STRIPS"
	Then Confirm Check Configuration in FirstAlert APP
	Then Set configuration on First Alert APP ISUType "VERIFICATION RETAIL" to ISUValue "WARM AIR"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	

	@FujiX2SRetail_DIY_CWire_No_FromStartUpScreen_HP_CoolAir_ElectricHeat_2H1C
	Scenario: FUJICOM-14253_FUJI DIY registration using FA app from Startup Screen state_HP_CoolAir_ElectricHeat_2H1C
	And user broadcast FUJI device for registration from "START SETUP" screen 
	Given user launches and logs in to the "first alert" app
	Then Add new device to Configure in First Alert App
	Then Setup Device "Location and name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then First Alert app "always" configure the ISU, is device factory reset "YES"
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC HEAT STRIPS"
	Then Confirm Check Configuration in FirstAlert APP
	Then Set configuration on First Alert APP ISUType "VERIFICATION RETAIL" to ISUValue "COOL AIR"
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "YES"
	Then user verifies for data synch after registration on First Alert APP
	When user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
	Then Delete registered device from First alert APP
	
	