@General_Vizio_XWR100_Router_Settings
Feature: Thor Amped Router settings for wifi testing 

@Vizio_XWR100_DHCP_Enable_Disable
Scenario: DHCP Enable Disable

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to NO" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_DHCP_IP
Scenario: WIFI Router DHCP IP address

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;START IP is 10" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;START IP is 20" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;START IP is 30" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;START IP is 40" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;START IP is 50" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Vizio_XWR100_DHCP_LEASE_TIME
Scenario: WIFI Router DHCP Lease Time

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;LEASE TIME is 11" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;LEASE TIME is 12" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;LEASE TIME is 13" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;LEASE TIME is 14" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "IS_DHCP to YES;LEASE TIME is 15" in "DHCP" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_SSID_NAME_24GHz
Scenario: WIFI Router SSID 24GHz

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO 24ghz;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169571" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24ghz" ,password "2736169571" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is vizio;SECURITY_TYPE is WPA2 PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "vizio" ,password "2736169572" and security type as "WPA2 PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO24;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169574" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO24" ,password "2736169574" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	

@Vizio_XWR100_SECURITY_TYPE_24GHZ
Scenario: WIFI Router SECURITY TYPE 24GHZ

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO 24ghz;SECURITY_TYPE is Disable" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24ghz" ,password "" and security type as "Disable"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is vizio;SECURITY_TYPE is WPA2 PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "vizio" ,password "2736169572" and security type as "WPA2 PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;SSID name is VIZIO24;SECURITY_TYPE is WEP64;PASSWORD is 2736169574" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO24" ,password "2736169574" and security type as "WEP64"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_SSID_NAME_5GHz
Scenario: WIFI Router SSID 5GHz

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;IS_SSID to YES" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO 5ghz;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169571" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 5ghz" ,password "2736169571" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is vizio;SECURITY_TYPE is WPA2 PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "vizio" ,password "2736169572" and security type as "WPA2 PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO5;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169574" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO5" ,password "2736169574" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_SECURITY_TYPE_5GHZ
Scenario: WIFI Router SECURITY TYPE 5GHZ

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;IS_SSID to YES" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO 5ghz;SECURITY_TYPE is Disable" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 5ghz" ,password "" and security type as "Disable"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is vizio;SECURITY_TYPE is WPA2 PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "vizio" ,password "2736169572" and security type as "WPA2 PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169573" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO5;SECURITY_TYPE is WEP64;PASSWORD is 2736169574" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO5" ,password "2736169574" and security type as "WEP64"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_SSID_ENABLE_AND_DISABLE_24GHZ
Scenario: WIFI Router SSID ENABLE AND DISABLE 24GHZ

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to YES;SSID name is VIZIO 24GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169572" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO 24GHZ" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 2.4;IS_SSID to NO" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Vizio_XWR100_SSID_ENABLE_AND_DISABLE_5GHZ
Scenario: WIFI Router SSID ENABLE AND DISABLE 5GHZ

	Given start wifi intigeration with switch and turn on "vizio" router and the model is "XWR100" 
	Given Launch browser and login to the router
	When user edit router settings as "FREQUENCY is 5;SSID name is VIZIO;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169573" in "BASIC WIRELESS" router screen
	Then configure the thermostat "valid" wifi ssid name "VIZIO" ,password "2736169572" and security type as "WPA PERSONAL"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;IS_SSID to YES" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;IS_SSID to YES;SSID name is VIZIO 5GHZ;SECURITY_TYPE is WPA PERSONAL;PASSWORD is 2736169574" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "FREQUENCY is 5;IS_SSID to NO" in "BASIC WIRELESS" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	