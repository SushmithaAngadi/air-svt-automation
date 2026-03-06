@Denali_Registration
Feature: FUJI Devices Registration on First Alert app using BLE flow

	@Denali_Retail_Registration_CWire_No_FromHomeScreen_Conv_Oil_1H1C
	Scenario: Denali DIY from Home Screen state Conv_Oil_1H1C with invalid Wiring Screen From App
	Given user broadCast the device from "Home Screen"  
	And user launches and logs in to the "first alert" app  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "Y,W,G" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	