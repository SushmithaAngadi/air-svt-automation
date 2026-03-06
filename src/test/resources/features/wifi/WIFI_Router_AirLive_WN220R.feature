@General_AirLive_WN220R_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper AirLive Router settings for wifi testing 

@AirLive_WN220R_Wifi_Router_Change_SSID_Password_24Ghz_demo
Scenario: AirLive_WN220R_Wifi_Router_Change_SSID_Password_24Ghz_demo

    #	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
  Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is airlive;security to WPA_PSK;password is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "airlive" ,password "Home@123." and security type as "WPA_PSK_AES"
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
@AirLive_WN220R_Wifi_Router_Security_type_NONE_24Ghz 
Scenario: AirLive_WN220R_Wifi_Router_Security_type_NONE_24Ghz 

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to NONE;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
	  	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to G ONLY;security to None " in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "" and security type as "NONE"
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N;security to None " in "wireless settings" router screen 
	   Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "" and security type as "NONE"
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B ONLY;security to None " in "wireless settings" router screen 
	   Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "" and security type as "NONE"
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@AirLive_WN220R_Wifi_Router_Security_type_WPA_PSK_24Ghz 
Scenario: AAirLive_WN220R_Wifi_Router_Security_type_WPA_PSK_24Ghz 

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	  When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "wireless settings" router screen  
Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen  
Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

		
@AirLive_WN220R_Wifi_Router_Security_type_WPA_24Ghz 
Scenario: AirLive_WN220R - verify connectivity with Wifi_Router_Security_type_WPA_24Ghz

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "channel to 5" in "wireless settings" router screen  
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless settings" router screen  
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen  
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@AirLive_WN220R_Wifi_Router_Security_type_WPA2_24Ghz 
Scenario: AirLive_WN220R_Wifi_Router_Security_type_WPA2_24Ghz 

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA2;ENCRYPTION to AES;Radius IP is 192.168.10.1;Radius Port is 1812" in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA2_AES"
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "wireless settings" router screen  
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "wireless settings" router screen  
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "wireless settings" router screen  
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@AirLive_WN220R_Wifi_Router_Security_type_WPA_PSK_WPA2_PSK_24Ghz 
Scenario: AirLive_WN220R_Wifi_Router_Security_type_WPA_PSK_WPA2_PSK_24Ghz 

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK_WPA2_PSK;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_WPA2_PSK_AES"
	  	Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless settings" router screen  
	 	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen  
	  	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen  
	  	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@AirLive_WN220R_Wifi_Router_Security_type_WPA_WPA2_24Ghz 
Scenario: AirLive_WN220R_Wifi_Router_Security_type_WPA_WPA2_24Ghz 

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_WPA2;Radius IP is 192.168.10.1;Radius Port is 1813" in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_WPA2_AES"
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless settings" router screen  
	   	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen  
	   	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen  
	 	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz_BGN_Channels
Scenario: AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen
		  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B_G_N;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Auto" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	@AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz_ModeG_ONLY
Scenario: AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen
		  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to G Only;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Auto" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
	@AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz_ModeB_ONLY_Channels
Scenario: AirLive_WN220R_Wifi_Router_standard_bgn_wifi_channels_24Ghz

	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen
		  Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to B Only;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Auto" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 8" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 9" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 10" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 11" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
#@Airlive_WN220R_DNS
#Scenario: Airlive_WN220R_DNS
#
#	Given Launch browser and login to the router
#	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen
#		Then configure the thermostat "valid" wifi ssid name "AirLive" ,password "Home@123." and security type as "WPA_PSK_AES"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "IS_DNS is YES;PROVIDER IS TZO;HOST NAME is Amazon;DNS EMAIL is abc@gmail.com;DNS_KEY is Resideo@" in "DNS" router screen 
#			Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "IS_DNS is YES;PROVIDER IS NO_IP;HOST NAME is Google;DNS EMAIL is bdc@gmail.com;DNS_KEY is Resideo@" in "DNS" router screen 
#			Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

#	
#@AirLive_WN220R_Wifi_Router_Change_DHCP_disable_24Ghz 
#Scenario: AirLive_WN220R_Wifi_Router_Change_DHCP_disable_24Ghz 
#
#	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
#	Given Launch browser and login to the router 
  #When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#		Then verify the connection status as "connected" from thermostat IP
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
#	 Then verify the connection status as "disconnected" from thermostat IP
#	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
#		Then verify the connection status as "connected" from thermostat IP
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	
#	
#@AirLive_WN220R_Wifi_Router_Change_DHCP_lease_time_24Ghz 
#Scenario: AirLive_WN220R_Wifi_Router_Change_DHCP_lease_time_24Ghz 
#
#	#	Given start wifi intigeration with switch and turn on "airlive" router and the model is "WN220R" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "SSID name is AirLive;is SSID to YES;mode to B_G_N;channel to Auto;security to WPA_PSK;ENCRYPTION to AES;PreShare Key Mode is ASCII;password is Home@123." in "wireless settings" router screen 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""  
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen
#	Then user edit router settings as "DHCPLease time is 600" in "DHCP settings" router screen 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
