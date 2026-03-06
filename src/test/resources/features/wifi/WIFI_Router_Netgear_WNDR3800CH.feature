@General_Netgear_WNDR3800CH_router_Settings
Feature: Jasper Netgear Router settings for wifi testing 

@Netgear_WNDR3800CH_Wifi_Router_verify_WPA2_PSK_AES_SSID_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_WPA2_PSK_AES_SSID_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear2G;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear2G" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is netgeart2GHZ;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netgeart2GHZ" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_WPA2_PSK_AES_SSID_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_WPA2_PSK_AES_SSID_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Net2G;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Net2G" ,password "Home@123." and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is netgeart2GHZWifi;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netgeart2GHZWifi" ,password "Home@123." and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_SSID_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_SSID_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is netgearNetwork;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "netgearNetwork" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Net@wifi;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Net@wifi" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Netgear_WNDR3800CH_Wifi_Router_verify_Password_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_Password_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is h#2023" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "h#2023" and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_WPA2_PSK_AES_Password_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_WPA2_PSK_AES_Password_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Netgear24" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Netgear24" and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is net!2024" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "net!2024" and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_Password_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_WPA_PSK_TKIP_Password_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is net@TKIP" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "net@TKIP" and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Net#123" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Net#123" and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithModeG_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithModeG_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
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
	
	
	@Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithMode130Mbps_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithMode130Mbps_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to Up to 130 Mbps;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
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
	
	
@Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithModeBGN_24Ghz @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_channelsWithModeBGN_24Ghz

  Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
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
	
  

@Netgear_WNDR3800CH_Wifi_Router_Security_type_NONE_24Ghz  @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_NONE_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to No;mode to G;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_AES_24Ghz  @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_AES_24Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP_WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP_WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_24Ghz  @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_AES_24Ghz  @Netgear_WNDR3800CH_24GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_AES_24Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#	@Netgear_WNDR3800CH_Wifi_Router_Change_DHCP_Enable_Disable_24GHZ @Netgear_WNDR3800CH_24GHZ
#Scenario: Netgear_WNDR3800CH_Wifi_Router_Change_DHCP_Enable_Disable_24GHZ
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
#	Given Launch browser and login to the router
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to NO" in "DHCP settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#	@Netgear_WNDR3800CH_Wifi_Router_Change_DHCP_StartIpAdd_EndIpAdd_24GHZ @Netgear_WNDR3800CH_24GHZ
#Scenario: Netgear_WNDR3800CH_Wifi_Router_Change_DHCP_StartIpAdd_EndIpAdd_24GHZ
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
#	Given Launch browser and login to the router
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes;DHCP Start IP Address is 192.168.1.101;DHCP End IP Address is 192.168.1.109" in "DHCP settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#@Netgear_WNDR3800CH_Wifi_Router_Security_type_WEP_24Ghz @Netgear_WNDR3800CH_24GHZ
#Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_WEP_24Ghz 

#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
#	Given Launch browser and login to the router
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 8;security to None" in "wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WEP;WEP AUTH is Automatic;ENCRYPTION is 64 bit ;password is 0123456789" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "0123456788" and security type as "WEP_Automatic"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;channel to Auto;security to WEP;WEP AUTH is Shared Key;ENCRYPTION is 64 bit ;password is 0123456789" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "0123456789" and security type as "WEP_Shared Key"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 8;security to None" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	
#	@Netgear_WNDR3800CH_Wifi_Router_Security_type_Enterprise_24Ghz @Netgear_WNDR3800CH_24GHZ 
#Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_Enterprise_24Ghz 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
#	Given Launch browser and login to the router
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;;security to None" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_WPA2_ENTERPRISE;WPA Encryption is AES for WNDR3800CH;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_Encryption_AES"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@Netgear_WNDR3800CH_Wifi_Router_verify_wifi_channels_5Ghz @Netgear_WNDR3800CH_5GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_verify_wifi_channels_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	  Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;to Up to 54 Mbps for 5GHz;channel to 36" in "wireless settings" router screen
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
	Then user edit router settings as "frequency to 5GHz;channel to 149" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 153" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 157" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 161" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;to Up to 130 Mbps for 5GHz;channel to 36" in "wireless settings" router screen
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
	Then user edit router settings as "frequency to 5GHz;channel to 149" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 153" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 157" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 161" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;to Up to 300 Mbps for 5GHz;channel to 36" in "wireless settings" router screen
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
	Then user edit router settings as "frequency to 5GHz;channel to 149" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 153" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 157" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 161" in "wireless settings" router screen 
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  

@Netgear_WNDR3800CH_Wifi_Router_Security_type_NONE_5Ghz  @Netgear_WNDR3800CH_5GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_NONE_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123" and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;to Up to 130 Mbps for 5GHz;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES; for 5GHz;channel to 44;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;to Up to 130 Mbps for 5GHz;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES; for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123" and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_AES_5Ghz  @Netgear_WNDR3800CH_5GHZ
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_AES_5Ghz 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA_TKIP_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_TKIP_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;to Up to 130 Mbps for 5GHz;security to None" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_5Ghz @Netgear_WNDR3800CH_5GHZ 
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_TKIP_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@Netgear_WNDR3800CH_Wifi_Router_Security_type_AES_5Ghz @Netgear_WNDR3800CH_5GHZ 
Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_AES_5Ghz

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES; for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
#	@Netgear_WNDR3800CH_Wifi_Router_Security_type_Enterprise_5Ghz @Netgear_WNDR3800CH_5GHZ 
#Scenario: Netgear_WNDR3800CH_Wifi_Router_Security_type_Enterprise_5Ghz 
#
#	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to Enterprise;WPA Encryption is AES;Radius IP is 1.1.1.1;Radius port is 1813;password is Home@123." in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "Enterprise"
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 36" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 5GHz;channel to 44" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Netgear_WNDR3800CH_Wifi_Router_Change_DHCP  @Netgear_WNDR3800CH_5GHZ @Netgear_WNDR3800CH_24GHZ 
Scenario: Netgear_WNDR3800CH_Wifi_Router_Change_DHCP 

	Given start wifi intigeration with switch and turn on "netgear" router and the model is "WNDR3800CH"
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5GHz;SSID name is Netgear;is SSID to YES;to Up to 300 Mbps for 5GHz;channel to 44;security to WPA2_PSK_AES;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA2_PSK_AES"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
  When user edit router settings as "frequency to 2.4GHz;SSID name is Netgear;is SSID to YES;;channel to Auto;security to WPA_PSK_TKIP;password is Home@123." in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Netgear" ,password "Home@123." and security type as "WPA_PSK_TKIP"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to NO" in "DHCP settings" router screen 
	Then verify the connection status as "disconnected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes;DHCP Start IP Address is 192.168.1.101;DHCP End IP Address is 192.168.1.109" in "DHCP settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	


   