@General_Netgear_RBR20_router_Settings
Feature: Jasper Netgear Router settings for wifi testing 

	
@Netgear_RBR20_Wifi_Router_verify_channels_24Ghz
Scenario: Netgear_RBR20_Wifi_Router_verify_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "FREQUENCY is 2.4Ghz;SSID NAME is Netgear;channel to Auto;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Netgear_RBR20_Wifi_Router_Channels_5ghz
Scenario: Netgear_RBR20_Wifi_Router_Channels_5ghz

	#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID NAME is Netgear5Ghz;channel to 44;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 48" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Netgear_RBR20_Wifi_Router_verify_Security_Type
Scenario: Netgear_RBR20_Wifi_Router_verify_Security_Type

	#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "FREQUENCY is 2.4Ghz;SSID NAME is Netgear;channel to Auto;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID NAME is netgear;security to WPA2_PSK_AES;PASSWORD is home123@." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID NAME is NETGEAR;security is None" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Netgear_RBR20_Wifi_Router_verify_DHCP_Settings
Scenario: Netgear_RBR20_Wifi_Router_verify_DHCP_Settings

	#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "FREQUENCY is 2.4Ghz;SSID NAME is Netgear;channel to Auto;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP to YES;START IP is 9;END IP is 100" in "DHCP" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP to YES;START IP is 10;END IP is 101" in "DHCP" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP to NO" in "DHCP" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Netgear_RBR20_Wifi_Router_verify_SSID_NAME
Scenario: Netgear_RBR20_Wifi_Router_verify_SSID_NAME

	#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "FREQUENCY is 2.4Ghz;SSID NAME is Netgear;channel to Auto;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID NAME is NETGEAR-ORBI" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID NAME is NETGEAR-Mesh" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Netgear_RBR20_Wifi_Router_DNS
Scenario: Netgear_RBR20_Wifi_Router_DNS

#Given start wifi intigeration with switch and turn on "netgear" router and the model is "RBR20"
	Given Launch browser and login to the router 
	When user edit router settings as "FREQUENCY is 2.4Ghz;SSID NAME is Netgear;channel to Auto;security to WPA_WPA2;PASSWORD is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "HOST NAME is Yahoo;DNS EMAIL is Test@gmail.com;DNS_KEY is Resideo@." in "DNS" router screen
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "HOST NAME is Yahoo;DNS EMAIL is abc@gmail.com;DNS_KEY is Resideo@" in "DNS" router screen
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	