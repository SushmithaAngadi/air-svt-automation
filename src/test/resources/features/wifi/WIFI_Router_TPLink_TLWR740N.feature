@General_TPLINK_TLWR740N_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper TPLINK Router settings for wifi testing 


@TPLINK_TLWR740N_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz_demo2 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band demo2 tp link 

#	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to G Only;channel to 1" in "basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@TPLINK_TLWR740N_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band

#	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen  
#	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B Only" in "basic settings" router screen
#	#	Then verify the connection status as "connected" from thermostat IP 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 12" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 13" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to G ONLY" in "basic settings" router screen 
	Then user edit router settings as "channel to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "channel to 12" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "channel to 13" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "mode to N ONLY" in "basic settings" router screen 
	Then user edit router settings as "channel to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 12" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 13" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_MOXED" in "basic settings" router screen 
	Then user edit router settings as "channel to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 12" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 13" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N_MOXED" in "basic settings" router screen 
	Then user edit router settings as "channel to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 12" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 13" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  
	
@TPLINK_TLWR740N_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band3 

#	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as  "mode to B Only" in "basic settings" router screen 
	Then user edit router settings as "bandwidth to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 20 MHz" in "basic settings" router screen 
    #	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 40 MHz" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
#	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N_MIXED" in "basic settings" router screen 
	Then user edit router settings as "bandwidth to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 20 MHz" in "basic settings" router screen 
    #	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 40 MHz" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
#	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to G ONLY" in "basic settings" router screen 
		Then user edit router settings as "bandwidth to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 20 MHz" in "basic settings" router screen 
    #	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 40 MHz" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
#	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
Then user edit router settings as "mode to N ONLY" in "basic settings" router screen 
		Then user edit router settings as "bandwidth to Auto" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 20 MHz" in "basic settings" router screen 
    #	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "bandwidth to 40 MHz" in "basic settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
#	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@TPLINK_TLWR740N_Wifi_Router_Security_type_NONE_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WEP_NONE_2_4Ghz 

	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to None" in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "mode to AX ONLY;security to None" in "basic settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N_MIXED;security to None" in "basic settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N_AX_MIXED;security to None" in "basic settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@TPLINK_TLWR740N_Wifi_Router_Security_type_WPA_WPA2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

  #Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_ONLY;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Open system;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA2;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@TPLINK_TLWR740N_Wifi_Router_Security_type_WPA_PSK_WPA2_PSK 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

  #Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_ONLY;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Open system;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA2;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@TPLINK_TLWR740N_Wifi_Router_Security_type_WEP
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

  #Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_ONLY;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Open system;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "security to WPA_WPA2;Version to WPA2;ENCRYPTION to TKIP;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

	

	
@TPLINK_TLWR740N_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N_MIXED;channel to Auto" in "basic settings" router screen 
	When user edit router settings as "security to WPA_WPA2;Version to Automatic;ENCRYPTION to AES;password is Home@123." in "security settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""  
	#	Then verify the connection status as "connected" from thermostat IP 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "DHCPLease time is 600" in "DHCP settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	##	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@TPLINK_TLWR740N_Wifi_Router_Change_DHCP_StartIP_EndIP
Scenario: verify connectivity with Wifi_Router_Change_DNS_IP1_2_valid_2_4Ghz 

#	Given start wifi intigeration with switch and turn  on "tplink" router and the model is "TLWR740N"
	Given Launch browser and login to the router 
#	When user edit router settings as "SSID name is TPLINK;is SSID to No;mode to B_G_N MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "basic settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	Then verify the connection status as "connected" from thermostat IP   
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "DHCP Start IP is is 8.8.4.4" in "DHCP settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "DHCP End IP 8.8.8.8" in "DHCP settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	Then verify the connection status as "connected" from thermostat IP  
	#Then verify "DNS-Srv Addr:8.8.4.4" in WIFI log 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

	
	
	