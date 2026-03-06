@General_Netgear_R6250_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper Netgear Router settings for wifi testing 

	
@Netgear_R6250_Wifi_Router_verify_ModeG_channels_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_ModeG_channels_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2G;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2G" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
  And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to G;channel to Auto" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@Netgear_R6250_Wifi_Router_verify_ModeN_channels_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_ModeN_channels_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2G;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2G" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
  And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		
		@Netgear_R6250_Wifi_Router_verify_ModeBGN_channels_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_ModeBGN_channels_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2G;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2G" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
  And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




  

@Netgear_R6250_Wifi_Router_Security_type_NONE_24Ghz  @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_NONE_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2G;is SSID to No;mode to G;channel to Auto;security to None" in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear2G" ,password "" and security type as "None"
	  Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	  Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
#@Netgear_R6250_Wifi_Router_Security_type_WEP_24Ghz  @Netgear_R6250_24GHZ
#Scenario: Netgear_R6250_Wifi_Router_Security_type_WEP_24Ghz 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WEP;WEP AUTH is Automatic;ENCRYPTION is 64 bit ;password is Home@123." in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WEP_Automatic"
#	Then user edit router settings as "frequency to 2.4GHz;mode toG;security to None" in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_AES_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_AES_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@Netgear_R6250_Wifi_Router_WPA_TKIP_AES_SSID_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_WPA_TKIP_AES_SSID_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is netgear24GHZ;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netgear24GHZ" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is netGEAR24;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netGEAR24" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Netgear_R6250_Wifi_Router_WPA_TKIP_AES_Password_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_WPA_TKIP_AES_Password_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is home123" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "home123" and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is net@24GHZ" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "net@24GHZ" and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_R6250_Wifi_Router_Security_type_WPA_AES_24Ghz @Netgear_R6250_24GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_AES_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode toG;channel to Auto;security to WPA_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
#	@Netgear_R6250_Wifi_Router_Security_type_Enterprise_24Ghz @Netgear_R6250_24GHZ
#Scenario: Netgear_R6250_Wifi_Router_Security_type_Enterprise_24Ghz 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2;is SSID to No;mode to G;channel to Auto;security to Enterprise;WPA Encryption is AES;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear2" ,password "Home@123." and security type as "WPA_Enterprise_AES"
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




	
	
@Netgear_R6250_Wifi_Router_verify_wifi_1300Mbps_channels_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_wifi_1300Mbps_channels_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;mode to Up to 1300 Mbps for 5GHz;channel to 36" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		
	@Netgear_R6250_Wifi_Router_verify_wifi_600Mbps_channels_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_wifi_600Mbps_channels_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 600 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;mode to Up to 600 Mbps for 5GHz;channel to 36" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		@Netgear_R6250_Wifi_Router_verify_wifi_289Mbps_channels_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_verify_wifi_289Mbps_channels_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 289 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;mode to Up to 289 Mbps for 5GHz;security to None" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
  

@Netgear_R6250_Wifi_Router_Security_type_NONE_5Ghz  @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_NONE_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to G for 5GHz;channel to 44;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
#@Netgear_R6250_Wifi_Router_Security_type_WEP_5Ghz @Netgear_R6250_5GHZ
#Scenario: Netgear_R6250_Wifi_Router_Security_type_WEP_5Ghz
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps  for 5GHz;channel to 44;security to WEP;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WEP"
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



	@Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_AES5Ghz  @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_AES_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_TKIP_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_R6250_Wifi_Router_WPA_TKIP_SSID_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_WPA_TKIP_SSID_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	When user edit router settings as "frequency to 5GHz;SSID name is netFIVE;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netFIVE" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	When user edit router settings as "frequency to 5GHz;SSID name is NETGEAR5GHZ;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "NETGEAR5GHZ" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	@Netgear_R6250_Wifi_Router_WPA_TKIP_Password_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_WPA_TKIP_Password_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Netgear@5" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Netgear@5" and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is home@123" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "home@1235" and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	@Netgear_R6250_Wifi_Router_Security_type_WPA_AES_5Ghz @Netgear_R6250_5GHZ
Scenario: Netgear_R6250_Wifi_Router_Security_type_WPA_AES_5Ghz

	Given start wifi intigeration with switch and turn "Netgear" router and the model is "R6250"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to G for 5GHz;channel to 44;security to WPA_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "WPA_AES"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#	@Netgear_R6250_Wifi_Router_Security_type_Enterprise_5Ghz @Netgear_R6250_5GHZ
#Scenario: Netgear_R6250_Wifi_Router_Security_type_Enterprise_5Ghz 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 5GHz;SSID name is Netgear5;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to Enterprise;WPA Encryption is AES;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear5" ,password "Home@123." and security type as "Enterprise_WPA_AES"
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	
#@Netgear_R6250_Wifi_Router_Change_DHCP 
#Scenario: Netgear_R6250_Wifi_Router_Change_DHCP 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R6250"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#	Then user edit router settings as "is DHCP to NO" in "DHCP settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#	Then user edit router settings as "is DHCP to Yes;DHCP Start IP Address is 192.168.1.101;DHCP End IP Address is 192.168.1.109" in "DHCP settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#		Then verify the connection status as "connected" from thermostat IP 
#	#Then verify "DNS-Srv Addr:12.1.168.192" in WIFI log 
#	#Then verify google ip "DNS-Srv Addr:8.8.8.8" in WIFI lof
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud    

   