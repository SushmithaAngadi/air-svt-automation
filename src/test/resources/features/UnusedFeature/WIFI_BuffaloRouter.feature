@General_Buffalo_router_Settings_with_NA_Thermostats
Feature: Thor Buffalo Router settings for wifi testing 


@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_EAP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-EAP;WPA Algorithms is TKIP;Key Renewal Interval is 5000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PSK for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_EAP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-EAP;WPA Algorithms is AES;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_WPA_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK/WPA-PSK;WPA Algorithms is AES" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 5" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK/WPA-PSK;Authentication is shared;password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 5" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Buffalo_WZR600DHCP_Wifi_Router_Change_SSID_Password_2_4Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz demo new_ 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Buffalo_24;security to WPA2-PSK;password is Home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "SSID name is Buffalo" in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA2-PSK;password is home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "security to WPA2-PSK;password is Home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Buffalo_WZR600DHCP_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Password for 2.4Ghz

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo_24" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is home@123." in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is Home@123." in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is 600" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Buffalo_WZR600DHCP_Wifi_Router_Change_StartIPAddress_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_StartIPAddress_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Start IP Address is 192.162.1.101" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Buffalo_WZR600DHCP_Wifi_Router_Change_MaxNoUSers_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_MaxNoUSers_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo2G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Max No Users is 53" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-PSK;WPA Algorithms is TKIP;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_EAP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA-EAP;WPA Algorithms is TKIP;Key Renewal Interval is 5000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_PSK for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_EAP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-EAP;WPA Algorithms is AES;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 1" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_WPA_PSK_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA2_EAP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK/WPA-PSK;WPA Algorithms is AES" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 5" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_2_4Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WEP for 2_4 Ghz band demo2 Buffalo 

	Given start wifi intigeration with switch and turn "on Buffalo" router and the model is "WZR600DHCP" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK/WPA-PSK;Authentication is shared;password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed;channel to 5" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Buffalo_WZR600DHCP_Wifi_Router_Change_SSID_Password_2_4Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz demo new_ 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Buffalo_24;security to WPA2-PSK;password is Home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "SSID name is Buffalo" in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA2-PSK;password is home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "security to WPA2-PSK;password is Home@123." in "wireless basic settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 36" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 40" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 44" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 48" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 149" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 153" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 157" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 161" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 165" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
		Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 36" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 40" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 44" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 48" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 149" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 153" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 157" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 161" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 165" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to B Only" in "wireless basic settings" router screen 
		Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 36" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 40" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 44" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 48" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 149" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 153" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 157" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 161" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 165" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
		Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 36" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 40" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 44" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 48" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 149" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 153" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 157" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 161" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 165" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to Mixed" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to N Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;Networkmode to G Only" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20/40 MHz" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Buffalo_WZR600DHCP_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Password for 2.4Ghz

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo_24" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo" in "wireless basic settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is home@123." in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;password is Home@123." in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Buffalo_WZR600DHCP_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Client Lease Time is 600" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Buffalo_WZR600DHCP_Wifi_Router_Change_StartIPAddress_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_StartIPAddress_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Start IP Address is 192.162.1.101" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Buffalo_WZR600DHCP_Wifi_Router_Change_MaxNoUSers_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_MaxNoUSers_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Buffalo5G;is SSID to YES;Networkmode to Mixed;channel to Auto" in "wireless basic settings" router screen 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2-PSK;WPA Algorithms is AES;password is Home@123.;Key Renewal Interval is 4000" in "wireless security settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;Max No Users is 53" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	

	