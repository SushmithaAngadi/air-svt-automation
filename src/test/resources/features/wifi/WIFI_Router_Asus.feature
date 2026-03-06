@General_Asus_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper Asus Router settings for wifi testing 


#@Asus_RTAC68U_Wifi_Router_Change_SSID_Password_2_4Ghz_demo 
#Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band demo3 asus 
#
#	Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "channel to 13" in "advance wireless settings" router screen 
#	Then verify the connection status as "disconnected" from thermostat IP
	
	
@Asus_RTAC68U_Wifi_Router_Change_SSID_24Ghz
Scenario: Asus_RTAC68U_Wifi_Router_Change_SSID_24Ghz

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Asus_24;security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Asus_24" ,password "Home@123." and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is asus24GHZ;security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "asus24GHZ" ,password "Home@123." and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	@Asus_RTAC68U_Wifi_Router_Change_Password_24Ghz
Scenario: Asus_RTAC68U_Wifi_Router_Change_Password_24Ghz

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is home123" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "home123" and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is asus@24" in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "asus@24" and security type as " WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Asus_RTAC68U_Wifi_Router_wifi_N_Only_channel_24Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_wifi_N_Only_channel_24Ghz

  Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	@Asus_RTAC68U_Wifi_Router_wifi_Auto_channel_24Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_wifi_Auto_channel_24Ghz

  Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@Asus_RTAC68U_Wifi_Router_wifi_Legacy_channel_24Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_wifi_Legacy_channel_24Ghz

  Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Asus_RTAC68U_Wifi_Router_with_Bandwidth_2_4Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_with_Bandwidth_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 40 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 20_40 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 40 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 20_40 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
#@Asus_RTAC68U_Wifi_Router_Security_type_WEP_NONE_2_4Ghz 
#Scenario: verify connectivity with Wifi_Router_Security_type_WEP_NONE_2_4Ghz 
#
    #Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
#	Then user edit router settings as "security to Open System;WEP Encryption to None" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "" and security type as "Open System_WEP_None" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "12345" and security type as "Open System_WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "A1B2C3D4E5" and security type as "Open System_WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System;WEP Encryption to WEP-128;password is 48495051525354555657" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "48495051525354555657" and security type as "Open System_WEP_128" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System;WEP Encryption to WEP-128;password is 2A5FCD801B94E76D89A3BC5247" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "2A5FCD801B94E76D89A3BC5247" and security type as "Open System_WEP_128" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "12345" and security type as "Open System_WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "A1B2C3D4E5" and security type as "Open System_WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key;WEP Encryption to WEP-128;password is 48495051525354555657" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "48495051525354555657" and security type as "Shared Key_WEP_64" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key;WEP Encryption to WEP-128;password is 2A5FCD801B94E76D89A3BC5247" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "2A5FCD801B94E76D89A3BC5247" and security type as "Shared key_WEP_128" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Asus_RTAC68U_Wifi_Router_Security_type_WPA_24Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_Security_type_WPA_24Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA2-Personal_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA-Personal; WPA Encryption to TKIP;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA Encryption_TKIP" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to TKIP_AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "ASUS" ,password "Home@123." and security type as "WPA Encryption_TKIP_AES" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
	
@Asus_RTAC68U_Wifi_Router_Security_type_WPA2_24Ghz 
Scenario: Asus_RTAC68U_Wifi_Router_Security_type_WPA2_24Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
#@Asus_RTAC68U_Wifi_Router_Security_type_WEP_NONE_2_4Ghz_Hidden_SSID 
#Scenario: 
#	verify connectivity with Wifi_Router_Security_type_WEP_NONE_2_4Ghz Hidden SSID 
#
    #Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "is SSID to Yes;SSID name is ASUS_24" in "advance wireless settings" router screen 
#	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
#	Then user edit router settings as "security to Open System; WEP Encryption to None" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System; WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System; WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System; WEP Encryption to WEP-128;password is 48495051525354555657" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Open System; WEP Encryption to WEP-128;password is 2A5FCD801B94E76D89A3BC5247" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key; WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key; WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key; WEP Encryption to WEP-128;password is 48495051525354555657" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "security to Shared key; WEP Encryption to WEP-128;password is 2A5FCD801B94E76D89A3BC5247" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
#	Then user edit router settings as "security to Open System" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
#	Then user edit router settings as "security to Open System" in "advance wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Security_type_WPA_2_4Ghz_Hidden_SSID 
Scenario: 
	verify connectivity with Wifi_Router_Security_type_WPA_2_4Ghz Hidden SSID 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is SSID to Yes;SSID name is ASUS_24" in "advance wireless settings" router screen 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA-Personal; WPA Encryption to TKIP;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to TKIP_AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to TKIP_AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to TKIP_AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA-Auto-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Security_type_WPA2_2_4Ghz_Hidden_SSID 
Scenario: 
	verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz Hidden_SSID 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;is SSID to Yes;SSID name is ASUS_24" in "advance wireless settings" router screen 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "security to WPA2-Personal; WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Asus_24;security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "SSID name is ASUS" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA2-Personal;password is home@123." in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	#Then verify Link local IP "169." in WIFI log
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Asus_RTAC68U_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DHCPLease time is 600" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Asus_RTAC68U_Wifi_Router_Change_DNS_IP1_2_valid_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_DNS_IP1_2_valid_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DNS IP1 is 8.8.4.4" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	#Then verify "DNS-Srv Addr:8.8.4.4" in WIFI log 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DNS_IP1_2_invalid_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_DNS_IP1_2_invalid_2_4Ghz 

    Given start wifi intigeration with switch and turn on "asus" router and the model is "RTAC68U"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DNS IP1 is 12.1.168.192" in "DHCP settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as "" 
	#Then verify "DNS-Srv Addr:12.1.168.192" in WIFI log 
	#Then verify google ip "DNS-Srv Addr:8.8.8.8" in WIFI lof
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
      