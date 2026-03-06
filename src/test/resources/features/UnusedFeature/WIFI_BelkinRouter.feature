@General_Belkin_router_Settings_with_NA_Thermostats
Feature: Thor Belkin Router settings for wifi testing 

@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_WPA2_Personal_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PERSONAL for 2_4 Ghz band demo2 Belkin 

#	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 7;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only;channel to 1" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 2_4 Ghz band demo2 Belkin 

#	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SECURITY to 64bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 8;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN;channel to 1" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;mode to BGN;channel to 5" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128_BIT_24Ghz
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_Enterprise for 2_4 Ghz band demo2 Belkin 

#	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SECURITY to 128bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 4;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only;channel to 1" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128BIT_24Ghz
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_WPA_Mixed_Personal for 2_4 Ghz band demo2 Belkin 

#	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SECURITY to Disabled." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 4;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to Mixed;channel to 5" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Belkin_F9K1102v1_Wifi_Router_Change_SSID_Password_2_4Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_SECURITY_type_WPA2_2_4Ghz demo new_ 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 2;mode to G" in "channel and ssid" router screen
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Belkin_24;password is Home@123." in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Belkin" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;schannel to 4" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to Off" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	Then user edit router settings as "frequency to 2.4GHz;mode to BNG" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

	
@Belkin_F9K1102v1_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Password for 2.4Ghz

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	Then user edit router settings as "frequency to 2.4GHz;mode to BNG" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Belkin_24;password is Home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Belkin" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is Home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 


@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_WPA2_Personal_5Ghz 
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PERSONAL for 5Ghz  band demo2 Belkin 

#	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;channel to 40;mode to a" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only;channel to 1" in "channel and ssid" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 2" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 3" in "channel and ssid" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_5Ghz 
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 5Ghz  band demo2 Belkin 

	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;SECURITY to 64bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;channel to 48;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to BGN;channel to 36" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;mode to BGN;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 2" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 3" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_64BIT_5Ghz 
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_Enterprise for 5Ghz  band demo2 Belkin 

	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;SECURITY to 128bit WEP;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;channel to 40;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to G Only;channel to 44" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_128BIT_5Ghz 
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_WPA_Mixed_Personal for 5Ghz  band demo2 Belkin 

	Given start wifi intigeration with switch and turn "on Belkin" router and the model is "F9K1102v1" 
	Given Launch browser and login to the router 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;SECURITY to Disabled;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;channel to 40;mode to G" in "channel and ssid" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to Mixed;channel to 36" in "channel and ssid" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Belkin_F9K1102v1_Wifi_Router_Change_SSID_Password_5Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_SECURITY_type_WPA2_5Ghz demo new_ 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 5Ghz ;SSID name is Belkin;is SSID to No;channel to 36;mode to G" in "channel and ssid" router screen
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;SSID name is Belkin_24;password is Home@123." in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;SSID name is Belkin" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;schannel to 44" in "channel and ssid" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_wifi_channel_5Ghz 
Scenario: verify wifi standard b_g_n with channels for 5Ghz  band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to AN" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to A Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5Ghz ;mode to Off" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;channel to Auto" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 36" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 40" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 44" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;channel to 48" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Belkin_F9K1102v1_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz 
Scenario: verify connectivity with standard a_n with Bandwidth for 5Ghz  band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	Then user edit router settings as "frequency to 5Ghz ;mode to AN" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20/40 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;mode to N Only" in "channel and ssid" router screen 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;bandwidth to 20/40 MHz" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

	
@Belkin_F9K1102v1_Wifi_Router_Change_SSID_Password_5Ghz 
Scenario: verify connectivity with Password for 5Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz ;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen  
	Then user edit router settings as "frequency to 5Ghz ;mode to AN" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;SSID name is Belkin_24;password is Home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;SSID name is Belkin" in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;password is home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 5Ghz ;password is Home@123." in "channel and ssid" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

	
@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 7;mode to G" in "channel and ssid" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Belkin_F9K1102v1_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 4;mode to N" in "channel and ssid" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Forever" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is 1 Hour" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Hours" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Day" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is One Day" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Days" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is One Week" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Two Weeks" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is Half Hour" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Belkin_F9K1102v1_Wifi_Router_Change_StartIPAddress_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_StartIPAddress_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 4;mode to N" in "channel and ssid" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Starting IP Address is 192.168.2.1" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Belkin_F9K1102v1_Wifi_Router_Change_EndingIPAddress_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_MaxNoUSers_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2-Personal;password is Home@123." in "SECURITY" router screen 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Belkin;is SSID to No;channel to 4;mode to N" in "channel and ssid" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Ending IP Address is 192.168.2.101" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	