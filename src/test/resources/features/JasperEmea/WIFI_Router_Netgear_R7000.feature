@General_Netgear_R7000_router_Settings 
Feature: Jasper Netgear Router settings for wifi testing 


@Netgear_R7000_Wifi_Router_verify_channels_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_verify_channels_2_DOT_4Ghz 

#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
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
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "wireless settings" router screen 
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
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "wireless settings" router screen 
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
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
@Netgear_R7000_Wifi_Router_Security_type_NONE_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_NONE_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 2.4GHz;mode toG;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_Security_type_WEP_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_WEP_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WEP;WEP AUTH is Automatic;ENCRYPTION is 64 bit ;WEP Key1 is 0123456789" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 2.4GHz;mode toG;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_Security_type_TKIP_AES_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_TKIP_AES_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 2.4GHz;mode toG;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_Security_type_AES_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_AES_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode toG;channel to Auto;security to WPA_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 2.4GHz;mode toG;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Netgear_R7000_Wifi_Router_Security_type_Enterprise_24Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_Enterprise_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to Enterprise;WPA Encryption is AES;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_verify_wifi_channels_5Ghz 
Scenario: Netgear_R7000_Wifi_Router_verify_wifi_channels_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
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
	Then user edit router settings as "frequency to 5GHz;channel to 100" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 104" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 108" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 112" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 132" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 136" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;mode to Up to 289 Mbps for 5GHz;channel to 36" in "wireless settings" router screen 
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
	Then user edit router settings as "frequency to 5GHz;channel to 100" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 104" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 108" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 112" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 132" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 136" in "wireless settings" router screen 
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
	Then user edit router settings as "frequency to 5GHz;channel to 100" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 104" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 108" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 112" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 132" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 136" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
@Netgear_R7000_Wifi_Router_Security_type_NONE_5Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_NONE_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;mode to G for 5GHz;channel to 44;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 5GHz;mode to Up to 289 Mbps for 5GHz;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_Security_type_TKIP_AES_5Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_TKIP_AES_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 5GHz;mode to Up to 289 Mbps for 5GHz;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Netgear_R7000_Wifi_Router_Security_type_AES_5Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_AES_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;mode to G for 5GHz;channel to 44;security to WPA_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 5GHz;mode to Up to 289 Mbps for 5GHZ;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Netgear_R7000_Wifi_Router_Security_type_Enterprise_5Ghz 
Scenario: Netgear_R7000_Wifi_Router_Security_type_Enterprise_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;mode to Up to 1300 Mbps for 5GHz;channel to 44;security to Enterprise;WPA Encryption is AES;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Netgear_R7000_Wifi_Router_Change_DHCP 
Scenario: Netgear_R7000_Wifi_Router_Change_DHCP 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "R7000" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "is DHCP to NO" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then user edit router settings as "is DHCP to Yes;DHCP Start IP Address is 192.168.1.101;DHCP End IP Address is 192.168.1.109" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	
   