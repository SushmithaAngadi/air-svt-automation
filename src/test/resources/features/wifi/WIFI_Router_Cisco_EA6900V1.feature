@General_Cisco_router_Settings_with_NA_Thermostats
Feature: Thor Cisco Router settings for wifi testing

@Cisco_EA6900V1_Wifi_Router_Change_SSID_Name_5ghz
Scenario: verify connectivity with SSID NAME 5Ghz

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 36;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID name is Cisco_5" in "advance wireless settings" router screen 
 	Then configure the thermostat "valid" wifi ssid name "Cisco_5" ,password "" and security type as ""
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID name is Cisco" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "" and security type as ""
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Cisco_EA6900V1_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with SSID NAME for 2.4Ghz

#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 1;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Cisco_24" in "advance wireless settings" router screen 
 	Then configure the thermostat "valid" wifi ssid name "Cisco_24" ,password "" and security type as ""
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Cisco" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco_24" ,password "" and security type as ""
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_Enterprise_2_4Ghz
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_Enterprise for 2_4 Ghz 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to 4;security to WPA2 Enterprise;Radius Server is 1.1.1.1;Radius Port is 1;Shared Key is CISCO" in "advance wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO" ,password "Home@123." and security type as "WPA2 Enterprise"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only;channel to 1" in "advance wireless settings" router screen
 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 2_4 Ghz band 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to 6;security to WEP;WEPENCRYPTION is 64" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "CISCO" ,password "Home@123." and security type as "WEP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to Mixed;channel to 1" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PERSONAL_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PERSONAL for 2_4 Ghz 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to Auto;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "CISCO" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N Only;channel to 1" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
	@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PERSONAL_5Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PERSONAL for 5 Ghz

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is CISCO;is SSID to No;mode to Mixed;channel to Auto;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "CISCO" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;bandwidth is Auto;mode to Mixed;channel to 36" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to N Only;channel to 5;security to WPA2 Personal;password is Password@1" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "CISCO" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
 	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 	Then user edit router settings as "frequency to 2.4GHz;mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
 	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to 802.11g Only" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
 	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_channel_5Ghz
Scenario: verify wifi standard b_g_n with channels for 5 Ghz band 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Cisco;is SSID to No;mode to AC ONLY;channel to 48;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	 Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;mode to Mixed" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 5GHz;channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "advance wireless settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_WPA_Mixed_Enterprise_5Ghz
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_WPA_Mixed_Enterprise for 5 Ghz

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Cisco;is SSID to No;mode to AC ONLY;channel to 44;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;mode to Mixed;channel to 36" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Cisco_EA6900V1_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz
Scenario: verify connectivity with standard b_g_n with Bandwidth for 5Ghz band 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Cisco;is SSID to No;mode to Mixed;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to Auto" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 80 MHz" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;mode to AC Only" in "advance wireless settings" router screen
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen 
	 	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 80 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Cisco_EA6900V1_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Mixed;channel to Auto;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to N ONLY" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;mode to G Only" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

@Cisco_EA6900V1_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_Enterprise_5Ghz
Scenario: verify wifi standard b_g_n with SecurtyType_WPA2_Enterprise for 5 Ghz 

#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Cisco;is SSID to No;mode to AC ONLY;channel to 36;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Cisco_EA6900V1_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 8;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	 
@Cisco_EA6900V1_Wifi_Router_Change_DHCP_Client_Lease_Time
Scenario: Cisco_EA6900V1_Wifi_Router_Change_DHCP_Client_Lease_Time

#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 8;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to YES;Client Lease Time is 600" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
@Cisco_EA6900V1_Wifi_Router_Change_DHCP_IP_Address
Scenario: Cisco_EA6900V1_Wifi_Router_Change_DHCP_IP_Address_MaxUsers

#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 8;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to YES;Start IP Address is 10.138.73.100" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Start IP Address is 10.138.73.200" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  

@Cisco_EA6900V1_Wifi_Router_Change_DHCP_MaxUser
Scenario: Cisco_EA6900V1_Wifi_Router_Change_DHCP_MaxUser

	#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 8;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to YES;Max No Users is 53" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to YES;Max No Users is 20" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to YES;Max No Users is 40" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
@Cisco_EA6900V1_Wifi_Router_Change_DHCP_DNS_IP
Scenario: Cisco_EA6900V1_Wifi_Router_Change_DNS_IP

	#Given start wifi intigeration with switch and turn on "cisco" router and the model is "EA6900V1" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Cisco;is SSID to No;mode to Auto;channel to 8;security to WPA2 Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Cisco" ,password "Home@123." and security type as "WPA2 Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DNS IP is 192.168.2.1" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DNS IP is 192.168.2.2" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

