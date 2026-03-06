@General_WD_MyNetN900_Router_Settings
Feature: Thor Amped Router settings for wifi testing
 
 
@WD_MyNetN900_standard_wifi_SSID_NAME_24Ghz
Scenario: verify wifi standard with wifi_SSID_NAME_24GHz

 	Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is  2.4Ghz;SSID NAME is Western Digital 24Ghz" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "Western Digital 24Ghz" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is  2.4Ghz;SSID NAME is Western Digital" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "Western Digital" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 	Then user edit router settings as "Frequency is  2.4Ghz;SSID NAME is WD Router" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD Router" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

@WD_MyNetN900_standard_wifi_SSID_NAME_5Ghz
Scenario: verify wifi standard with wifi_SSID_NAME_5GHz

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is home@1234." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is  5Ghz;SSID NAME is Western Digital 5Ghz" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "Western Digital 5Ghz" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is  5Ghz;SSID NAME is Western Digital" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "Western Digital" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 	Then user edit router settings as "Frequency is  5Ghz;SSID NAME is WD Router" in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD Router" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 
@WD_MyNetN900_Network_Mode_24Ghz
Scenario: WD_MyNetN900_Network_Mode_24Ghz

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is B ONLY" in "Basic Wireless" router screen
			Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is G ONLY" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is N ONLY" in "Basic Wireless" router screen
			Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is B_G" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is G_N" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is B_G_N" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
	
@WD_MyNetN900_Network_Mode_5Ghz
Scenario: WD_MyNetN900_Network_Mode_5ghz

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is home@1234." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is A ONLY" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is N ONLY" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is A_N" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@WD_MyNetN900_CH_WIDTH_24GHZ
Scenario: WD_MyNetN900_CH_WIDTH_24GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is N ONLY;CH_WIDTH is 20 Mhz" in "Basic Wireless" router screen
			Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is G_N;CH_WIDTH is 20_40;" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;NETWORK_MODE is B_G_N;CH_WIDTH is 20 Mhz;" in "Basic Wireless" router screen
			Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@WD_MyNetN900_CH_WIDTH_5GHZ
Scenario: WD_MyNetN900_CH_WIDTH_5GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is home@1234." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is N ONLY;CH_WIDTH is 20 Mhz" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is A_N;CH_WIDTH is 20_40;" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;NETWORK_MODE is A_N;CH_WIDTH is 20 Mhz;" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@WD_MyNetN900_CHANNEL_24GHZ
Scenario: WD_MyNetN900_CHANNEL_24GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 2.4Ghz;CHANNEL is AUTO" in "Basic Wireless" router screen
			Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 1" in "Basic Wireless" router screen
	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 2" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 3" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 4" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 5" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 6" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 7" in "Basic Wireless" router screen
	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 8" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 9" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 10" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 11" in "Basic Wireless" router screen
	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@WD_MyNetN900_CHANNEL_5GHZ
Scenario: WD_MyNetN900_CHANNEL_5GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is home@1234." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "home@1234." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 5Ghz;CHANNEL is AUTO" in "Basic Wireless" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 165" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 161" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 157" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 153" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 149" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 48" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 44" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 40" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Frequency is 5Ghz;CHANNEL is 36" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@WD_MyNetN900_CHANNEL_SECURITY_TYPE_24GHZ
Scenario: WD_MyNetN900_CHANNEL_SECURITY_TYPE_24GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;CHANNEL is 1;SECURITY is WPA_WPA2_PERSONAL;PASSWORD is home@123." in "Basic Wireless" router screen
 	Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
#	
#@WD_MyNetN900_Security_type_24Ghz_Enterprise 
#Scenario: WD_MyNetN900_Security_type_24Ghz_Enterprise
#
 #Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
#	Given Launch browser and login to the router
#	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
#		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
#		Then verify the connection status as "connected" from thermostat IP
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "Frequency is 2.4Ghz;CHANNEL is 2;SECURITY is WPA2_ENTERPRISE;Radius IP is 192.168.6.2;Radius Port is 1912;RADIUS_SHARED_KEY is home123@" in "Basic Wireless" router screen
 #	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#		Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "Frequency is 2.4Ghz;SECURITY is WPA_WPA2_ENTERPRISE;Radius IP is 192.168.6.5;Radius Port is 1915;RADIUS_SHARED_KEY is home123@" in "Basic Wireless" router screen
 #	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP
	
@WD_MyNetN900_CHANNEL_SECURITY_TYPE_5GHZ
Scenario: WD_MyNetN900_CHANNEL_SECURITY_TYPE_5GHZ

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Frequency is 5Ghz;CHANNEL is 165;SSID NAME is WD-5;SECURITY is WPA_WPA2_PERSONAL;PASSWORD is home@123." in "Basic Wireless" router screen
 	Then configure the thermostat "valid" wifi ssid name "WD-5" ,password "home@123." and security type as "WPA_WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud	
	
#@WD_MyNetN900_Security_type_5Ghz_Enterprise 
#Scenario: WD_MyNetN900_Security_type_5Ghz_Enterprise
#
 #Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
#	Given Launch browser and login to the router
#	When user edit router settings as "Frequency is 5Ghz;SSID NAME is WD-5;SECURITY is WPA2_PERSONAL;PASSWORD is home@1234." in "Basic Wireless" router screen
#		Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#		Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "Frequency is 5Ghz;CHANNEL is 36;SECURITY is WPA2_ENTERPRISE;Radius IP is 192.168.6.2;Radius Port is 1912;RADIUS_SHARED_KEY is home123@" in "Basic Wireless" router screen
 #	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#		Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "Frequency is 5Ghz;CHANNEL is 44;SECURITY is WPA_WPA2_ENTERPRISE;Radius IP is 192.168.6.5;Radius Port is 1915;RADIUS_SHARED_KEY is home123@" in "Basic Wireless" router screen
 #	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP
	
@WD_MyNetN900__WIFI_ROUTER_DHCP_SETTINGS_ENABLE_DISABLE
Scenario: WD_MyNetN900__WIFI_ROUTER_DHCP_SETTINGS_ENABLE_DISABLE

	Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP is NO" in "DHCP" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud	
	When user edit router settings as "IS DHCP is YES" in "DHCP" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud	
	When user edit router settings as "IS DHCP is YES;DHCP START IP is 2;DHCP END IP is 8" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud	


@WD_MyNetN900__WIFI_ROUTER_DHCP_SETTINGS
Scenario: WD_MyNetN900__WIFI_ROUTER_DHCP_SETTINGS

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	Given Launch browser and login to the router
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "DHCP START IP is 3" in "DHCP" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "DHCP END IP is 4" in "DHCP" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "LEASE TIME is 15" in "DHCP" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
@WD_MyNetN900_WIFI_Router_IS_SSID
Scenario: WD_MyNetN900_WIFI_Router_IS_SSID

 Given start wifi intigeration with switch and turn on "westerndigital" router and the model is "MyNetN900" 
	When user edit router settings as "Frequency is 2.4Ghz;SSID NAME is WD-24;SECURITY is WPA2_PERSONAL;PASSWORD is Home@123." in "Basic Wireless" router screen
		Then configure the thermostat "valid" wifi ssid name "WD-24" ,password "Home@123." and security type as "WPA2_PERSONAL" 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4Ghz;IS SSID to YES" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5Ghz;IS SSID to YES" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4Ghz;IS SSID to NO" in "Basic Wireless" router screen
 		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5Ghz;IS SSID to NO" in "Basic Wireless" router screen
 	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	