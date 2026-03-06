@Netgear_RAX100_WIFI_ROUTER_NETGEAR
Feature: Thor Amped Router settings for wifi tes


@Netgear_RAX10_Wifi_Router_24Ghz_SSID_NAME @Netgear_RAX10_24GHZ
Scenario: Netgear_RAX10_Wifi_Router_24Ghz_SSID_NAME

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID NAME is NETGEAR" in "wireless settings" router screen
		 Then configure the thermostat "valid" wifi ssid name "NETGEAR" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID NAME is NetGear" in "wireless settings" router screen
		 Then configure the thermostat "valid" wifi ssid name "NetGear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID NAME is netgear" in "wireless settings" router screen
	 Then configure the thermostat "valid" wifi ssid name "netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;SSID NAME is netgear15" in "wireless settings" router screen
		 Then configure the thermostat "valid" wifi ssid name "netgear15" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
	 
@Netgear_RAX10_Wifi_Router_verify_channels_24Ghz @Netgear_RAX10_24GHZ
Scenario: Netgear_RAX10_Wifi_Router_verify_channels_24Ghz

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless settings" router screen 
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

	

@Netgear_RAX10_Wifi_Router_verify_channels_5Ghz
Scenario: Netgear_RAX10_Wifi_Router_verify_channels_5Ghz

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID NAME is Netgear;CHANNEL to 128,Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen
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
	Then user edit router settings as "frequency to 5GHz;channel to 52" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 56" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
		
@Netgear_RAX10_Wifi_Router_MODE_24GHZ   @Netgear_RAX10_24GHZ
Scenario: Netgear_RAX10_Wifi_Router_MODE_24GHZ 

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID NAME is Netgear;MODE to 54 Mbps;channel to 4;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;MODE to 286 Mbps;" in "wireless settings" router screen 
	  Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;MODE to 600 Mbps;" in "wireless settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Netgear_RAX10_Wifi_Router_MODE_5GHZ 
Scenario: Netgear_RAX10_Wifi_Router_MODE_5GHZ 

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5 GHz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5 GHz;SSID NAME is Netgear;MODE to 1200 Mbps;channel to 44" in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5 GHz;MODE to 286 Mbps;" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5 GHz;MODE to 573 Mbps;" in "wireless settings" router screen 
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
	
@Netgear_RAX10_Wifi_Router_Change_DHCP  @Netgear_RAX10_24GHZ
Scenario: Netgear_RAX10_Wifi_Router_Change_DHCP 

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	 When user edit router settings as "frequency to 2.4GHz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  When user edit router settings as "IS DHCP to Disable" in "DHCP settings" router screen 
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  Then user edit router settings as "IS DHCP to Enable" in "DHCP settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP to Enable;START IP is 101;END IP is 109;LEASE TIME is 20" in "DHCP settings" router screen 
	  Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS DHCP to Enable;START IP is 105;END IP is 110;LEASE TIME is 21" in "DHCP settings" router screen 
	 Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Netgear_RAX10_Security_24Ghz  @Netgear_RAX10_24GHZ
Scenario: Netgear Security RAX10 24Ghz

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	 When user edit router settings as "frequency to 2.4GHz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Given Launch browser and login to the router 
	 When user edit router settings as "frequency to 2.4GHz;SSID NAME is NETGEAR;CHANNEL to Auto;Security is WPA_PERSONAL;PASSWORD is home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "NEATGEAR" ,password "home@123." and security type as "WPA_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

@Netgear_RAX10_Security_5Ghz
Scenario: Netgear Security RAX10 5GHZ

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	 When user edit router settings as "frequency to 5Ghz;SSID NAME is Netgear;CHANNEL to Auto;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Given Launch browser and login to the router 
	 When user edit router settings as "frequency to 5Ghz;SSID NAME is NETGEAR;CHANNEL to Auto;Security is WPA_PERSONAL;PASSWORD is home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "NEATGEAR" ,password "home@123." and security type as "WPA_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
@Netgear_RAX10_Wifi_Router_5Ghz_SSID_NAME
Scenario: Netgear_RAX10_Wifi_Router_5Ghz_SSID_NAME

	Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID NAME is Netgear;CHANNEL to 40;Security is WPA2_PERSONAL;PASSWORD is Home@123." in "wireless settings" router screen
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID NAME is NETGEAR" in "wireless settings" router screen
		Then configure the thermostat "valid" wifi ssid name "NETGEAR" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID NAME is NetGear" in "wireless settings" router screen
		Then configure the thermostat "valid" wifi ssid name "NetGear" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID NAME is netgear" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "netgear" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;SSID NAME is netgear15" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "netgear15" ,password "Home@123." and security type as "WPA2_PERSONAL"
	  	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
#@Netgear_WIFI_Security_WPA_WPA2_ENTERPRISE_24GHz
#Scenario: Netgear_WIFI_Security_WPA_WPA2_ENTERPRISE 24Ghz
#
 #Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
#	Given Launch browser and login to the router 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "Frequency is 2.4Ghz;Security is WPA_WPA2_ENTERPRISE;WPA_M0DE is WPA2_AES;RADIUS_PORT is 1912;RADIUS_SHARED_KEY is Home@123;RADIUS IP is 192.168.2.2" in "wireless settings" router screen
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "Frequency is 2.4Ghz;Security is WPA_WPA2_ENTERPRISE;WPA_M0DE is WPA_WPA2;RADIUS_PORT is 1812;RADIUS_SHARED_KEY is home@123;RADIUS IP is 192.168.2.5" in "wireless settings" router screen
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	
#@Netgear_WIFI_Security_WPA_WPA2_ENTERPRISE_5ghz
#Scenario: Netgear_WIFI_Security_WPA_WPA2_ENTERPRISE 5ghz
#
#Given start wifi intigeration with switch and turn "netgear" router and the model is "RAX10"
#	Given Launch browser and login to the router 
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "Frequency is 5Ghz;Security is WPA_WPA2_ENTERPRISE;WPA_M0DE is WPA2_AES;RADIUS_PORT is 1912;RADIUS_SHARED_KEY is Home@123;RADIUS IP is 192.168.2.2" in "wireless settings" router screen
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "Frequency is 5Ghz;Security is WPA_WPA2_ENTERPRISE;WPA_M0DE is WPA_WPA2;RADIUS_PORT is 1812;RADIUS_SHARED_KEY is home@123;RADIUS IP is 192.168.2.5" in "wireless settings" router screen
#	  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud