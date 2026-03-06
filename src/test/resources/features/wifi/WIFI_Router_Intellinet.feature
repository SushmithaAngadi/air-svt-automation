@General_Intellinet_router_Settings_with_NA_Thermostats
Feature: Thor Intellinet Router settings for wifi testing 
	
		
#@Intellinet_150N3G_Wifi_Router_wifi_SecurtyType_WEP_24Ghz
#Scenario: Intellinet_150N3G_Wifi_Router_wifi_SecurtyType_WEP_24Ghz 
#
  #Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
#	Given Launch browser and login to the router
#	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
#	When user edit router settings as "Encryption to WEP;WEP Key Length is 64 bit ;WEP KEy Format is ASCII;password is Home@" in "SECURITY SETTING" router screen 
#	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
#	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@" and security type as "WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Intellinet_150N3G_Wifi_Router_wifi_SecurtyType_WAP_PRE_SharedKey
Scenario: Intellinet_150N3G_Wifi_Router_wifi_SecurtyType_WAP_PRE_SharedKey 

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

#@Intellinet_150N3G_Wifi_Router_standard_bgn_wifi_SecurtyType_WAP_Radius
#Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PSK for 2_4 Ghz band demo2 Intellinet 
#
#	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
#	Given Launch browser and login to the router
#	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
#	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen 
#	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
#	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "" and security type as "WPA Radius" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Intellinet_150N3G_Wifi_Router_Change_SSID_24Ghz
Scenario: Intellinet_150N3G_Wifi_Router_Change_SSID_24Ghz 
Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is intelinet;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "intelinet" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is int_auto;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "int_auto" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Intellinet_150N3G_Wifi_Router_Change_Password_24Ghz
Scenario: Intellinet_150N3G_Wifi_Router_Change_Password_24Ghz 
	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Int@24" in "SECURITY SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Int@24" and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Password@1" in "SECURITY SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Password@1" and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



	
@Intellinet_150N3G_Wifi_Router_B_ONLY_channel_24Ghz 
Scenario: Intellinet_150N3G_Wifi_Router_B_ONLY_channel_24Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	@Intellinet_150N3G_Wifi_Router_G_ONLY_channel_24Ghz 
Scenario: Intellinet_150N3G_Wifi_Router_G_ONLY_channel_24Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to G ONLY;channel to 1" in "BASIC SETTING" router screen
	Then user edit router settings as "channel to 1" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
	@Intellinet_150N3G_Wifi_Router_N_ONLY_channel_24Ghz 
Scenario: Intellinet_150N3G_Wifi_Router_N_ONLY_channel_24Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to N ONLY;channel to 1" in "BASIC SETTING" router screen
	Then user edit router settings as "channel to 1" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
	@Intellinet_150N3G_Wifi_Router_BG_ONLY_channel_24Ghz 
Scenario: Intellinet_150N3G_Wifi_Router_BG_ONLY_channel_24Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to BG ONLY;channel to 1" in "BASIC SETTING" router screen
	Then user edit router settings as "channel to 1" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@Intellinet_150N3G_Wifi_Router_BGN_ONLY_channel_24Ghz 
Scenario: Intellinet_150N3G_Wifi_Router_BGN_ONLY_channel_24Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to BGN ONLY;channel to 1" in "BASIC SETTING" router screen
	Then user edit router settings as "channel to 1" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "BASIC SETTING" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
	
@Intellinet_150N3G_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen
	When user edit router settings as "Encryption to WPA PreSharedKey;WPA Unicast to AES;password is Home@123." in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then configure the thermostat "valid" wifi ssid name "Intellinet2G" ,password "Home@123." and security type as " WPA_PreSharedKey" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20_40Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to G ONLY;channel to 1" in "BASIC SETTING" router screen
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20_40Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to N ONLY;channel to 1" in "BASIC SETTING" router screen
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20_40Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to BG ONLY;channel to 1" in "BASIC SETTING" router screen
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20_40Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to BGN ONLY;channel to 1" in "BASIC SETTING" router screen
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to YES;BandWidth to 20_40Mhz" in "ADVANCE SETTING" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
@Intellinet_150N3G_Wifi_Router_Change_DHCP_24Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Intellinet_150N3G_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is Forever" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is HALF HOUR" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is ONE HOUR" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is TWO HOURS" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is HALF DAY" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is ONE DAY" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is TWO DAYS" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is ONE WEEK" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is TWO WEEKS" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Intellinet_150N3G_Wifi_Router_Change_StartIPAddress_2_4Ghz 
Scenario: verify connectivity with Change_StartIPAddress_2_4Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Start IP Address is 192.168.2.101" in "DHCP settings" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Intellinet_150N3G_Wifi_Router_Change_EndIPAddress_2_4Ghz 
Scenario: verify connectivity with Change_EndIPAddress_2_4Ghz  

	Given start wifi intigeration with switch and turn on "intellinet" router and the model is "150N3G" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is Intellinet2G;is SSID to YES;Mode to B ONLY;channel to Auto" in "BASIC SETTING" router screen 
	When user edit router settings as "Encryption to WPA Radius;WPA Unicast to TKIP;Radius IP Address is 192.168.2.1" in "SECURITY SETTING" router screen 
	When user edit router settings as "is SSID to YES;BandWidth to 20Mhz" in "ADVANCE SETTING" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP End IP Address is 192.168.2.201" in "DHCP settings" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	