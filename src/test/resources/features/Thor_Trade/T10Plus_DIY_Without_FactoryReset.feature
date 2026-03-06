@Thor_DIY_realDevice_WithoutFactoryReset @--xrayid:HTA-2741
Feature: Thor Registration without factory reset
	Register the Thor device using user DIY flow 

	
@HTA_2743_Thor_Diy_RealDevice_GUI_WihtoutFactoryReset_QR_Flow @--xrayid:HTA-2743
Scenario: HTA_27430 DIY on Thor Happy Path with initial installation in GUI and reg in QR code
	
	Then User set Room name as "default" 
	Given User open QR Code from Connect app screen
	Then user launches and logs in to the Resideo application 
	And Add new device for Registration 
	And user select location name as "Home" 
	Then user pairing device using "QR Scanner" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 

@HTA_2742_Thor_Diy_RealDevice_GUIWihtoutFactoryReset_AP_Flow @--xrayid:HTA-2742
Scenario: HTA_2742 DIY on Thor Happy Path with initial installation in GUI and reg in AP mode
	
	Then User set Room name as "default" 
	Given User open QR Code from Connect app screen
	And user launches and logs in to the Resideo application
	Then Add new device for Registration
	And user select location name as "Home" 
	Then user pairing device using "AP mode" 
	Then wait for connecting to honeywell 
	Then user waits for data synch after registration 
	And Verify Registration status in Stat GUI 
	Then delete Registered thermostat in app 
	And check thermostat is unregister"true" in cloud, if not delete from cloud using cloud wrapper API 
	Then verify stat is unregistered from cloud 