@Gleneagles_DIY_Feature
Feature: Gleneagles Devices DIY feature


@Gleneagles_DIY 
Scenario: Gleneagles DIY SkipNxtBinding SkipEIMBinding skip ISU Configure WIFI
	Given user launches and logs in to the "Resideo Pro" app

@Gleneagles_DIY_SkipNxtBinding_SkipEIMBinding_skip_ISU_Configure_WIFI @--xrayid:LZ62319-8653
Scenario: Gleneagles DIY SkipNxtBinding SkipEIMBinding skip ISU Configure WIFI
	Given user launches and logs in to the "first alert" app
	Given user broadCast the device from "Control Hub" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then user configures "USING NXT" to "NO" in the Firstalert app
	Then user configures "DEMAND CONTROL" to "NONE" in the Firstalert app
	Then First Alert app "skip" configure the ISU, is device factory reset "NO"
	Then First Alert app wifi "always" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	

@Gleneagles_DIY_BindNxt_SkipEIMBinding_skip_ISU_Configure_WIFI @--xrayid:LZ62319-8654
Scenario: Gleneagles DIY BindNxt SkipEIMBinding skip ISU Configure WIFI
	Given user launches and logs in to the "first alert" app
	Then user runs "AAT" command "reset" 
	Given user broadCast the device from "Control Hub" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then user sets the "NXT" to "BINDING MODE" 
	Then user configures "USING NXT" to "YES" in the Firstalert app
	Then user configures "DEMAND CONTROL" to "NONE" in the Firstalert app
	Then First Alert app "skip" configure the ISU, is device factory reset "NO"
	Then First Alert app wifi "always" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	
	
@Gleneagles_DIY_SkipNxtBinding_BindEIM_skip_ISU_Configure_WIFI @--xrayid:LZ62319-8655
Scenario: Gleneagles DIY SkipNxtBinding BindEIM skip ISU Configure WIFI
	Given user launches and logs in to the "first alert" app
	Then user sets the "EIM" to "RESET MODE" 
	Given user broadCast the device from "Control Hub" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then user configures "USING NXT" to "NO" in the Firstalert app
	Then user sets the "EIM" to "BINDING MODE" 
	Then user configures "DEMAND CONTROL" to "WIRED VIA EIM" in the Firstalert app
	Then First Alert app "skip" configure the ISU, is device factory reset "NO"
	Then First Alert app wifi "always" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	
	
@Gleneagles_DIY_BindNxt_BindEIM_skip_ISU_Configure_WIFI @--xrayid:LZ62319-8656
Scenario: Gleneagles DIY BindNxt BindEIM skip ISU Configure WIFI 
	Given user launches and logs in to the "first alert" app
	Then user runs "AAT" command "reset" 
	Then user sets the "EMEA EIM" to "RESET MODE"
	Given user broadCast the device from "Control Hub" 
	Then Add new device to Configure in First Alert App
	Then Setup Device "name" for DIY
	Then Perform initial installation setup for "BLE" mode in First Alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then user sets the "NXT" to "BINDING MODE" 
	Then user configures "USING NXT" to "YES" in the Firstalert app
	Then user sets the "EIM" to "BINDING MODE" 
	Then user configures "DEMAND CONTROL" to "WIRED VIA EIM" in the Firstalert app
	Then First Alert app "skip" configure the ISU, is device factory reset "NO"
	Then First Alert app wifi "always" configure the wifi with "CORRECT Password", is device factory reset "NO"
	Then user verifies for data synch after registration on First Alert APP
	Then Delete registered device from First alert APP
	
	
		