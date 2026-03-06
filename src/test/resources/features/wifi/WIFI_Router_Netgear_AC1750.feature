@General_NETGEAR_WIFI5_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper NETGEAR Router settings for wifi testing 

#When user edit router settings as "frequency to 5GHz;SSID name is ASUS_5G;is SSID to No;mode to Auto;channel to Auto;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen
@NETGEAR_AC1750_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz_demo1 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band demo1_netgear 

	Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;mode to 2.4Ghz BGN;channel to Auto;password is Home@123." in "advance wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N" in "advance wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750_Wifi_Router_Change_SSID_Password_2_4Ghz_demo 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
    Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;channel to Auto;security to WPA2 AES;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	##Then verify the connection status as "connected" from thermostat IP 
	##And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR;security to WPA2 AES;password is Home@123." in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is home@123." in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123." in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@NETGEAR_AC1750_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;mode to BGN;channel to Auto;password is Home@123." in "advance wireless settings" router screen 
#	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N" in "advance wireless settings" router screen
#	##Then verify the connection status as "connected" from thermostat IP 
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
#	##Then verify the connection status as "connected" from thermostat IP
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
#	##Then verify the connection status as "connected" from thermostat IP
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
#	##Then verify the connection status as "connected" from thermostat IP
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
#	##Then verify the connection status as "connected" from thermostat IP
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
#	##Then verify the connection status as "connected" from thermostat IP
#	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen 
    #Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;mode to G" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;channel to 12" in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;channel to 13" in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP   
	
@NETGEAR_AC1750_Wifi_Router_Security_type_WEP_NONE_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WEP_NONE_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;channel to Auto;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "frequency to 2.4GHz;mode to G" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to None" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-128;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-128;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as  "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-128;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-128;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to None;mode to BGN" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to None;mode to N" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750_Wifi_Router_Security_type_WPA_WPA2_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;channel to Auto;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to G" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750_Wifi_Router_Security_type_WEP_NONE_2_4Ghz_Hidden_SSID 
Scenario: verify connectivity with Wifi_Router_Security_type_WEP_NONE_2_4Ghz_Hidden_SSID 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;security to WPA2 AES;channel to Auto;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "frequency to 2.4GHz;is SSID to No;mode to G" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to None" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Automatic;WEP Encryption to WEP-128;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-64;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-64;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as  "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-128;password is A1B2C3D4E5" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WEP;WEP Authentication to Shared Key;WEP Encryption to WEP-128;password is 12345" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to None;mode to BGN" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to None;mode to N" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750_Wifi_Router_Security_type_WPA_WPA2_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;channel to Auto;security to WPA2 AES;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;is SSID to No;mode to G" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to N" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2 MIXED;password is Home@123.;" in "advance wireless settings" router screen  
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;mode to BGN" in "advance wireless settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123.;" in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
    Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;channel to Auto;security to WPA2 AES;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	##Then verify the connection status as "connected" from thermostat IP 
	##And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR;security to WPA2 AES;password is Home@123." in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50" in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is home@123." in "advance wireless settings" router screen 
	#Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "frequency to 2.4GHz;security to WPA2 AES;password is Home@123." in "advance wireless settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@NETGEAR_AC1750__Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

    Given start wifi intigeration with switch and turn "on netgear" router and the model is "AC1750"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is NETGEAR50;is SSID to Yes;channel to Auto;security to WPA2 AES;mode to BGN;password is Home@123." in "advance wireless settings" router screen 
	#Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;is DHCP to No" in "DHCP settings" router screen 
	Then Set Stat Command to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
	#Then verify the connection status as "disconnected" from thermostat IP
	#Then verify Link local IP "169." in WIFI log
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	##Then verify the connection status as "connected" from thermostat IP
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
		