@Thermostat_Wifi_reconfiguration_BGN_Feature 
Feature: Wifi mode reconfiguration changes in router and check from thermostat, Tstat should not go for Link Local 


@Thermostat_Wifi_reconfiguration_B_modeChanges @--xrayid:HTA-1166 
Scenario: Wifi standard  configuration change to 802 BGN mode in router and check the connectivity 
#	Given Launch browser and login to the router 
	#	Then configure the router Bandwidth is "2.4Ghz" Secuirty type is "WPA2 AES" mode is "802.11 B" standard
	Then change router configuration for "mode and channel" configuration change to "bandwith:2.4ghz,Security type:WPA2 AES,ssid name:Home1auto,ssid password:Home@123." 
	And Turn on the Device 
	Then do registartion through common DIY 
	And verify the setpoint changes from App and device 
	Then change router setting "channel" to "1" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "2" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "3" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "4" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "5" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "6" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "7" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "8" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "9" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "10" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "11" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then Check the connection between router and device, it should be "disconnected" 
	Given open the browser and configure the router Bandwidth is "2.4Ghz" Secuirty type is "WPA2 AES" mode is "802.11 G" standard 
	Then do registartion through common DIY 
	And verify the setpoint changes from App and device 
	Then change router setting channel to "1" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "2" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "3" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "4" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "5" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "6" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "7" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "8" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "9" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "10" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "11" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then Check the connection between router and device, it should be "disconnected" 
	Given open the Router browser and configure the router to "802.11N" standard 
	Then do registartion through common DIY 
	And verify the setpoint changes from App and device 
	Then change router setting channel to "1" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "2" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "3" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "4" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "5" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "6" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "7" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "8" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "9" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "10" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "11" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then Check the connection between router and device, it should be "disconnected" 
	Given open the Router browser and configure the router to "802.11BG" standard 
	Then do registartion through common DIY 
	And verify the setpoint changes from App and device 
	Then change router setting channel to "1" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "2" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "3" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "4" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "5" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "6" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "7" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "8" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "9" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "10" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "11" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then Check the connection between router and device, it should be "disconnected" 
	Given open the Router browser and configure the router to "802.11BGN" standard 
	Then do registartion through common DIY 
	And verify the setpoint changes from App and device 
	Then change router setting channel to "1" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "2" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "3" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "4" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "5" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "6" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "7" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "8" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "9" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "10" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device 
	Then change router setting channel to "11" 
	Then Check the connection between router and device, it should be "connected" in 5 mins 
	And verify the setpoint changes from API and device