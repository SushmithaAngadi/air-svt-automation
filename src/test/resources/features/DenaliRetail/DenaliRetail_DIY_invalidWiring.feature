@Denali_Retail_DIY
Feature: FUJI Devices Registration on First Alert app using BLE flow
	
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Oil_1H1C_SkipISU_invalidWiringScreenFrom_App @--xrayid:DENALI-4047
	Scenario: DENALI-4047 Denali DIY from Home Screen state Conv_Oil_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "skip" configure the ISU, is device factory reset "NO"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  




@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Oil_1H1C_invalidWiringScreenFrom_App_Skip_ISU_skii_WIFI @--xrayid:DENALI-4047
	Scenario: DENALI-4047 Denali DIY from Home Screen state Conv_Oil_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "skip" configure the ISU, is device factory reset "NO"   
	And First Alert app wifi "skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP 
	
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Oil_1H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4047
	Scenario: DENALI-4047 Denali DIY from Home Screen state Conv_Oil_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "Y,W,G" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  
 
  
 

	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Electric_1H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4048
	Scenario: DENALI-4048 Denali DIY from Home Screen state Conv_Electric_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "Y,W,G" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  

	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_1H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4049
	Scenario: DENALI-4049 Denali DIY from Home Screen state Conv_StdEffGas_1H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  

	


	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_1H2C_invalidWiringScreenFrom_App  @--xrayid:DENALI-4050
	Scenario: DENALI-4050 Denali DIY from Home Screen state Conv_HighEff_1H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  


	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_1H2C_invalidWiringScreenFrom_App  @--xrayid:DENALI-4051
	Scenario: DENALI-4051 Denali DIY from Home Screen state Conv_Oil_1H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  
		
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_1H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4052
	Scenario: DENALI-4052 Denali DIY from Home Screen state Rad_HW_1H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  
#	

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_1H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4053
	Scenario: DENALI-4053 Denali DIY from Home Screen state Rad_Steam_1H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP 
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4054
	Scenario: DENALI-4054 Denali DIY from Home Screen state Conv_StdEffGas_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  
	


	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4055
	Scenario: DENALI-4055 Denali DIY from Home Screen state Conv_HighEff_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  


	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4056
	Scenario: DENALI-4056 Denali DIY from Home Screen state Conv_Oil_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  
		
		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Electric_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4057
	Scenario: DENALI-4057 Denali DIY from Home Screen state Conv_Elec_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP 
		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4058
	Scenario: DENALI-4058 Denali DIY from Home Screen state Rad_HW_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP  

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_2H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4059
	Scenario: DENALI-4059 Denali DIY from Home Screen state Rad_Steam_2H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP


	
@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4060
	Scenario: DENALI-4060 Denali DIY from Home Screen state Conv_Gas_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4061
	Scenario: DENALI-4061 Denali DIY from Home Screen state Conv_HighEff_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  


	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4062
	Scenario: DENALI-4062 Denali DIY from Home Screen state Conv_Oil_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP  
			
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Electric_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4063
	Scenario: DENALI-4063 Denali DIY from Home Screen state Conv_Elec_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP
 
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4064
	Scenario: DENALI-4064 Denali DIY from Home Screen state Rad_HW_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP
	

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_2H2C_invalidWiringScreenFrom_App @--xrayid:DENALI-4065
	Scenario: DENALI-4065 Denali DIY from Home Screen state Rad_Steam_2H2C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	Then Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_1H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4066
	Scenario: DENALI-4066 Denali DIY from Home Screen state Conv_StdEffGas_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	Then Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	And user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP
	


	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_1H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4067
	Scenario: DENALI-4067 Denali DIY from Home Screen state Conv_HighEff_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	Then Add new device to Configure in First Alert App  
	Then Setup Device "Location and name" for DIY  
	Then Perform initial installation setup for "BLE" mode in First Alert APP  
	Then Connect with Thermostat in "Ble" mode in First Alert App  
	Then First Alert app "always" configure the ISU, is device factory reset "NO"  
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	Then user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	Then Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	Then Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP


		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_1H1C_invalidWiringScreenFrom_App @--xrayid:DENALI-4068
	Scenario: DENALI-4068 Denali DIY from Home Screen state Rad_HW_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	Then Add new device to Configure in First Alert App  
	Then Setup Device "Location and name" for DIY  
	Then Perform initial installation setup for "BLE" mode in First Alert APP  
	Then Connect with Thermostat in "Ble" mode in First Alert App  
	Then First Alert app "always" configure the ISU, is device factory reset "NO"  
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	Then user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	Then Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP


	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_1H1C_invalidWiringScreenFrom_App  @--xrayid:DENALI-4069
	Scenario: DENALI-4069 Denali DIY from Home Screen state Rad_Steam_1H1C with invalid Wiring Screen From App
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	Then Add new device to Configure in First Alert App  
	Then Setup Device "Location and name" for DIY  
	Then Perform initial installation setup for "BLE" mode in First Alert APP  
	Then Connect with Thermostat in "Ble" mode in First Alert App  
	Then First Alert app "always" configure the ISU, is device factory reset "NO"  
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	Then user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	Then Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	Then Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP

	@DenaliRetail_DIY_CWire_Yes_FromHomeScreen_CoolOnly_1C @--xrayid:DENALI-4070
	Scenario: DENALI-4070 Denali DIY from Home Screen state CoolOnly_1C
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	Then Add new device to Configure in First Alert App  
	Then Setup Device "Location and name" for DIY  
	Then Perform initial installation setup for "BLE" mode in First Alert APP  
	Then Connect with Thermostat in "Ble" mode in First Alert App  
	Then First Alert app "always" configure the ISU, is device factory reset "NO"  
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	Then Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"  
	Then Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	When user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App  
	Then Delete registered device from First alert APP

@DenaliRetail_DIY_CWireNo_FromHomeScreen_Conv_Oil_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4596
	Scenario: DENALI-4596 Denali DIY from Home Screen state Conv_Oil_1H1C manual wire configuration from app and skip configurations 
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "Y,W,G" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP  
	When user broadCast the device from "Home" Screen
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
	And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Electric_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4597
	Scenario: DENALI-4597 Denali DIY from Home Screen state Conv_Electric_1H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "Y,W,G" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
  And user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_1H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4598
	Scenario: DENALI-4598 Denali DIY from Home Screen state Conv_StdEffGas_1H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP 
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP	
  And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_1H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4599
	Scenario: DENALI-4599 Denali DIY from Home Screen state Conv_HighEff_1H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_1H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4600
	Scenario: DENALI-4600 Denali DIY from Home Screen state Conv_Oil_1H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP	
	And user verifies thermostat configuration as "Gas" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_1H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4601
	Scenario: DENALI-4601 Denali DIY from Home Screen state Rad_HW_1H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"   
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
 
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_1H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4602
	Scenario: DENALI-4602 Denali DIY from Home Screen state Rad_Steam_1H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP 
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4603
	Scenario: DENALI-4603 Denali DIY from Home Screen state Conv_StdEffGas_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"    
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP  
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4604
	Scenario: DENALI-4604 Denali DIY from Home Screen state Conv_HighEff_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"      
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4605
	Scenario: DENALI-4605 Denali DIY from Home Screen state Conv_Oil_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"      
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP  
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP	
	And user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Electric_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4606
	Scenario: DENALI-4606 Denali DIY from Home Screen state Conv_Elec_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP 
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Electric Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4607
	Scenario: DENALI-4607 Denali DIY from Home Screen state Rad_HW_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_2H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4608
	Scenario: DENALI-4608 Denali DIY from Home Screen state Rad_Steam_2H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home" Screen
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "w,W2,G,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4609
	Scenario: DENALI-4609 Denali DIY from Home Screen state Conv_Gas_StdEff_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen" 
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4610
	Scenario: DENALI-4610 Denali DIY from Home Screen state Conv_HighEff_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen" 
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
  
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Oil_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4611
	Scenario: DENALI-4611 Denali DIY from Home Screen state Conv_Oil_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "OIL"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP  
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP		
	And user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_Electric_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4612
	Scenario: DENALI-4612 Denali DIY from Home Screen state Conv_Elec_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "ELECTRIC"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4613
	Scenario: DENALI-4613 Denali DIY from Home Screen state Rad_HW_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
  
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_2H2C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4614
	Scenario: DENALI-4614 Denali DIY from Home Screen state Rad_Steam_2H2C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "W,W2,G,Y,Y2" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App  
	And Delete registered device from First alert APP
	
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_StdEff_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4615
	Scenario: DENALI-4615 Denali DIY from Home Screen state Conv_StdEffGas_1H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "STANDARD EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP

	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Conv_Gas_HighEffGas_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4616
	Scenario: DENALI-4616 Denali DIY from Home Screen state Conv_HighEff_1H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen" 
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "FORCED AIR"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "GAS"  
	And Set configuration on First Alert APP ISUType "EFFICIENCY RETAIL" to ISUValue "HIGH EFFIECIENCY"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
		
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_HotWater_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4617
	Scenario: DENALI-4617 Denali DIY from Home Screen state Rad_HW_1H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "HOT WATER"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
  When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
  And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
  
	@DenaliRetail_DIY_CWire_No_FromHomeScreen_Radiant_Steam_1H1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4618
	Scenario: DENALI-4618 Denali DIY from Home Screen state Rad_Steam_1H1C manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "NO"  
	And user selects "G,W,Y" wiring and verify that it is "valid" wiring  
	And Set configuration on First Alert APP ISUType "HEAT TYPE" to ISUValue "RADIANT"  
	And Set configuration on First Alert APP ISUType "EQUIPMENT TYPE RETAIL" to ISUValue "STEAM"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP
	
		
	@DenaliRetail_DIY_CWire_Yes_FromHomeScreen_CoolOnly_1C_Manual_WireConfigFrom_App_AndSkipConfigurations @--xrayid:DENALI-4619
	Scenario: DENALI-4619 Denali DIY from Home Screen CoolOnly single stage manual wire configuration from app and skip configurations
	Given user launches and logs in to the "first alert" app 
	And user broadCast the device from "Home Screen"  
	And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App  
	And First Alert app "always" configure the ISU, is device factory reset "NO"  
	And Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"  
	And Set configuration on First Alert APP ISUType "CWIRE ADAPTER" to ISUValue "YES"  
	And Set configuration on First Alert APP ISUType "INDOOR AIR QUALITY EQUIPMENT" to ISUValue "NONE"  
	And First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP  
	And user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP	
	When user broadCast the device from "Home" Screen
  And Add new device to Configure in First Alert App  
	And Setup Device "Location and name" for DIY  
	And Perform initial installation setup for "BLE" mode in First Alert APP  
	And Connect with Thermostat in "Ble" mode in First Alert App
 	And First Alert app "Skip" configure the ISU, is device factory reset "NO"
  And First Alert app wifi "Skip" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	And user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App  
	And Delete registered device from First alert APP

	