@General_Belkin_F9K1102v1_router_Settings_
Feature: Thor Belkin Router settings for wifi testing 

@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_WPA2_Personal_2_4Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_WPA2_Personal_2_4Ghz

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only;channel to 1" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_SSID_2_4Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_SSID_2_4Ghz

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is BELKINrouter;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "BELKINrouter" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is belkin_24GHZ;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "belkin_24GHZ" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_Password_24Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_Password_24Ghz

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Belkin@24" in "SECURITY" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Belkin@24" and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is router@belkin" in "SECURITY" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "router@belkin" and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 




	


@Belkin_F9K1102v1_Wifi_Router_wifi_SecurtyType_Disabled_24Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_wifi_SecurtyType_Disabled_24Ghz

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SECURITY to Disabled." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 4;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "" and security type as "None" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

	

	
@Belkin_F9K1102v1_Wifi_Router_BGN_channel_2_4Ghz  @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_BGN_channel_2_4Ghz 
	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	  
	
	
	
	@Belkin_F9K1102v1_Wifi_Router_N_Only_channel_2_4Ghz  @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_N_Only_channel_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	
	@Belkin_F9K1102v1_Wifi_Router_G_Only_channel_2_4Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_G_Only_channel_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	
	@Belkin_F9K1102v1_Wifi_Router_Off_channel_2_4Ghz @Belkin_F9K1102v1_24GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_Off_channel_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to Off" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz @Belkin_F9K1102v1_24GHZ
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20_40 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20_40 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	#@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_24Ghz @Belkin_F9K1102v1_24GHZ
#Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_24Ghz
#
#	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SECURITY to 64bit WEP;password is Home@123." in "SECURITY" router screen 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 8;mode to G" in "channel and ssid" router screen
#	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "52246FFDF9" and security type as "WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N;channel to 1" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

#@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128_BIT_24Ghz @Belkin_F9K1102v1_24GHZ
#Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128_BIT_24Ghz
#
#	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SECURITY to 128bit WEP;password is Home@123." in "SECURITY" router screen 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 4;mode to G" in "channel and ssid" router screen
#	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WEP_128" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;mode to G Only;channel to 4" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	




@Belkin_F9K1102v1_Wifi_Router_SecurtyType_WPA_WPA2_Personal_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_SecurtyType_WPA_WPA2_Personal_5Ghz   

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only;channel to 36" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
	



@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;SECURITY to 64bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 48;mode to A" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WEP_64" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to B_G_N;channel to 36" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128BIT_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128BIT_5Ghz 

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;SECURITY to 128bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to A" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WEP_128" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_SSID_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_SSID_5Ghz    

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz ;SSID name is BELKIN_AUTO;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "BELKIN_AUTO" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz ;SSID name is belkin_auto;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "belkin_auto" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_Password_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_WPA_WPA2_Personal_Password_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Wifi@5GHZ" in "SECURITY" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Wifi@5GHZ" and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Router#Belkin" in "SECURITY" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Router#Belkin" and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Belkin_F9K1102v1_Wifi_Router_AN_channel_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_AN_channel_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to A_N" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
	
	
	@Belkin_F9K1102v1_Wifi_Router_N_Only_channel_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_N_Only_channel_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	@Belkin_F9K1102v1_Wifi_Router_A_Only_channel_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_A_Only_channel_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to A Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	 
	
	 @Belkin_F9K1102v1_Wifi_Router_Off_channel_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_Off_channel_5Ghz  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to Off" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz 

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to A Only" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to A_N" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20_40 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20_40 MHz" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 


	
@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_disable_24GHZ @Belkin_F9K1102v1_24GHZ 
Scenario: Belkin_F9K1102v1_Wifi_Router_Change_DHCP_disable_24GHZ

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin24;is SSID to YES;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin24" ,password "Home@123." and security type as "WPA_WPA2_Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Hour" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Weeks" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_disable_5GHZ @Belkin_F9K1102v1_5GHZ
Scenario: Belkin_F9K1102v1_Wifi_Router_Change_DHCP_disable_5GHZ

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1"  
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Hour" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
	Then verify the connection status as "disconnected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Weeks" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


	
#@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_lease_time_ 
#Scenario: Belkin_F9K1102v1_Wifi_Router_Change_DHCP_lease
#
#	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to YES;channel to 4;mode to N" in "channel and ssid" router screen
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Forever" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is 1 Hour" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Hours" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Day" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is One Day" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Days" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is One Week" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Weeks" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Hour" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	#Then user verify after "300" seconds in WIFI log for IPRenewal message
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	


	@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_StartIPAddress 
Scenario: Belkin_F9K1102v1_Wifi_Router_Change_DHCP_StartIPAddress  

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1"  
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Starting IP Address is 192.168.2.2" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	


	@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_EndingIPAddress 
Scenario: Belkin_F9K1102v1_Wifi_Router_Change_DHCP_EndingIPAddress

	Given start wifi intigeration with switch and turn on "belkin" router and the model is "F9K1102V1"  
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin5;is SSID to YES;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "Belkin5" ,password "Home@123." and security type as "WPA_WPA2-Personal" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Ending IP Address is 192.168.2.101" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	
	