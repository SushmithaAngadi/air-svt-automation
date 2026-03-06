@General_Cisco_router_Settings_with_NA_Thermostats
Feature: Thor Cisco Router settings for wifi testing 


@Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PErsonal @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PErsonal

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	


@Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PErsonal @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PErsonal 

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA2 Personal;Encryption is AES_TKIP;password is Home@123;Key Renewal is 3000" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA2_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	


#@Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_Enterprise
#Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_Enterprise for 2_4 Ghz band demo2 Cisco 
#
#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
#	Given Launch browser and login to the router 
#	Then user edit router settings as "security to WPA2 Enterprise;Encryption is AES_TKIP;Radius Server is 10.0.0.1;Radius port is 24" in "wireless security settings" router screen  
#	Then user edit router settings as "mode to B ONLY;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA2_Enterprise_AES_TKIP"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 4 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 3 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#
#@Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_Enterprise
#Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_Enterprise for 2_4 Ghz band demo2 Cisco 
#
#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
#	Given Launch browser and login to the router 
#	Then user edit router settings as "security to WPA Enterprise;Radius Server is 10.0.0.1;Radius port is 24" in "wireless security settings" router screen 
#	Then user edit router settings as "mode to G ONLY;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Enterprise"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 6 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 7 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Cisco_WRT120N_Wifi_Router_wifi_SecurtyType_Disable @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_wifi_SecurtyType_Disable

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router
	Then user edit router settings as "security to Disable" in "wireless security settings" router screen 
	Then user edit router settings as "mode to BG-Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Cisco_WRT120N_Wifi_Router_Change_WPA_Personal_SSID_24Ghz @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_Change_WPA_Personal_SSID_24Ghz

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;Encryption is AES_TKIP;password is Home@123;Key Renewal is 3000" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to N ONLY;IS SSID to YES ;SSID name is CISCO_auto;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_auto" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "mode to N ONLY;IS SSID to YES ;SSID name is CISCO2GHZ;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO2GHZ" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Cisco_WRT120N_Wifi_Router_Change_WPA2_Personal_Password_24Ghz @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_Change_WPA2_Personal_Password_24Ghz

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA2 Personal;Encryption is AES_TKIP;password is Home@123;Key Renewal is 3000" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA2_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "security to WPA2 Personal;Encryption is AES_TKIP;password is cisco@24;Key Renewal is 3000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "cisco@24" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "security to WPA2 Personal;Encryption is AES_TKIP;password is cisco24;Key Renewal is 3000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "cisco24" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
@Cisco_WRT120N_Wifi_Router_20MHz_channel_2_4Ghz @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_20MHz_channel_2_4Ghz 

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Auto for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@Cisco_WRT120N_Wifi_Router_40MHz_channel_2_4Ghz  @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_40MHz_channel_2_4Ghz 

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to Autofor 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9for 40MHz;BandWidth to 40MHz" in "basic wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Cisco_WRT120N_Wifi_Router_Change_DHCP_disable_2_4Ghz @Cisco_WRT120N_24GHZ
Scenario: Cisco_WRT120N_Wifi_Router_Change_DHCP_disable_2_4Ghz 

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N"
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;Client Lease Time is 1" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
  Then user edit router settings as "is DHCP to YES;Client Lease Time is 300" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
	@Cisco_WRT120N_Wifi_Router_Change_StartIPAddress_2_4Ghz @Cisco_WRT120N_24GHZ
Scenario: verify connectivity with Wifi_Router_Change_StartIPAddress_2_4Ghz 


	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;Start IP Address is 192.162.1.5" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Cisco_WRT120N_Wifi_Router_Change_MaxNoUSers_2_4Ghz @Cisco_WRT120N_24GHZ
Scenario: verify connectivity with Wifi_Router_Change_MaxNoUSers_2_4Ghz 

	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
	Given Launch browser and login to the router 
	Then user edit router settings as "security to WPA Personal;password is Home@123;Key Renewal is 4100" in "wireless security settings" router screen 
	Then user edit router settings as "mode to Mixed;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 5 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123" and security type as "WPA_Personal_Mixed"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;Max No Users is 53" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	

#	@Cisco_WRT120N_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP @Cisco_WRT120N_24GHZ
#Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 2_4 Ghz band demo2 Cisco 
#
#	Given start wifi intigeration with switch and turn on "cisco" router and the model is "WRT120N" 
#	Given Launch browser and login to the router 
#	Then user edit router settings as "security to WEP;Encryption is 64 bit;password is Home@123" in "wireless security settings" router screen 
#	Then user edit router settings as "mode to G Only;IS SSID to YES ;SSID name is CISCO_WRT120N;BandWidth to 20MHz;channel to 1 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "CISCO_WRT120N" ,password "Home@123." and security type as "WEP_Encryption"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 2 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 3 for 20MHz;BandWidth to 20MHz" in "basic wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	