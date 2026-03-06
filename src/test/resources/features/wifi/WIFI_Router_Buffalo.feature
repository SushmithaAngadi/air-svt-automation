@General_Buffalo_router_Settings_with_NA_Thermostats
Feature: Thor Buffalo Router settings for wifi testing 


@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA_PSK_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA_PSK_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_Disable_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_Disable_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to NONE" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "" and security type as "NONE" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA_PSK_SSID_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA_PSK_SSID_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is buffalo_router;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "buffalo_router" ,password "Home@123." and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA_PSK_Password_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA_PSK_Password_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is home@;Key Renewal Interval is 4000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "home@" and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Buff@24;Key Renewal Interval is 4000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Buff@24" and security type as "WPA_PSK_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA2_PSK_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA2_PSK_24Ghz 

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA2_PSK_WPA_PSK_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WPA2_PSK_WPA_PSK_24Ghz 

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 5" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA2_PSK_WPA_PSK_SSID_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA2_PSK_WPA_PSK_SSID_24Ghz 

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is buffalo_wpa_wpa2;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "buffalo_wpa_wpa2" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA2_PSK_WPA_PSK_Password_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_WPA2_PSK_WPA_PSK_Password_24Ghz 

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is WPA2@24;Key Renewal Interval is 4000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "WPA2@24" and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Password@1;Key Renewal Interval is 4000" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Password@1" and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
		

#@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WEP_Shared_24Ghz @Buffalo_WZR600DHCP_24GHZ
#Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WEP_Shared_24Ghz

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
#	When user edit router settings as "frequency to 2.4GHz;security to WEP;Authentication is SHARED;Encryption is 64;Passphrase is Home@123." in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "" and security type as "WEP_Shared" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
#Then verify the connection status as "connected" from thermostat IP
#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


	@Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WEP_PSK_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_SecurtyType_WEP_PSK_24Ghz

#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;security to WEP;Authentication is Open;Encryption is 64;Passphrase is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "" and security type as "WEP_PSK" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



	
	
@Buffalo_WZR600DHCP_Wifi_Router_wifi_Mixed_channel_2_4Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_Mixed_channel_2_4Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
#	@Buffalo_WZR600DHCP_Wifi_Router_wifi_N_Only_channel_2_4Ghz  @Buffalo_WZR600DHCP_24GHZ
#Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_N_Only_channel_2_4Ghz 
#
#	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
#	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
#	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
#	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	


	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_B_Only_channel_2_4Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_B_Only_channel_2_4Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@Buffalo_WZR600DHCP_Wifi_Router_wifi_G_Only_channel_2_4Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_wifi_G_Only_channel_2_4Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
@Buffalo_WZR600DHCP_Wifi_Router_with_Bandwidth_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_with_Bandwidth_24Ghz

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20_40 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
#	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
#	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
#	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
#	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20_40 MHz" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20_40 MHz" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	
	
@Buffalo_WZR600DHCP_Wifi_Router_zChange_DHCP_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_zChange_DHCP_24Ghz
#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCPLease time is 1" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
  Then user edit router settings as "is DHCP to YES;DHCPLease time is 600" in "DHCP settings" router screen
  Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  

	
	@Buffalo_WZR600DHCP_Wifi_Router_zChange_StartIPAddress_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_zChange_StartIPAddress_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Start IP Address is 192.162.11.4" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	 
	
	@Buffalo_WZR600DHCP_Wifi_Router_zChange_MaxNoUSers_24Ghz @Buffalo_WZR600DHCP_24GHZ
Scenario: Buffalo_WZR600DHCP_Wifi_Router_zChange_MaxNoUSers_24Ghz 

	#Given start wifi intigeration with switch and turn on "buffalo" router and the model is "WZR-600DHP"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2_PSK_WPA_PSK;WPA Algorithms is TKIP_AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Buffalo2G" ,password "Home@123." and security type as "WPA2_PSK_WPA_PSK_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Max No Users is 53" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
 





