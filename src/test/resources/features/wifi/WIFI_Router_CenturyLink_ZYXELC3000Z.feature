@General_CenturyLink_ZYXELC3000Z_router_Settings_with_NA_Thermostats_with_AAT 
Feature: Jasper CenturyLink Router settings for wifi testing 
	
@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_B_G_N_channels_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_B_G_N_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 1;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 2;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 3;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 4;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 7;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 8;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 9;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 10;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 11;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_G_N_channels_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_G_N_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 1;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 2;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 3;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 4;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 7;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 8;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 9;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 10;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 11;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_Only_channels_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_Only_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to N ONLY;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 1;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 2;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 3;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 4;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 7;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 8;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 9;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 10;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 11;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_B_G_channels_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_B_G_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 1;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 2;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 3;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 4;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 7;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 8;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 9;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 10;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 11;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
	@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_G_Only_channels_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_G_Only_channels_24Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to G ONLY;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 1;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 2;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 3;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 4;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 7;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 8;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 9;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 10;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 11;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
  

@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_NONE_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_NONE_24Ghz 

#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Security to None" in "Radio setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 5;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to 6;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_24Ghz  @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_24Ghz

#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to N Only;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to G Only;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA2_PERSONAL_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA2_PERSONAL_24Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Channel to Auto;mode to B_G;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_SSID_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_SSID_24Ghz
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is cent24" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "cent24" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is CENTURY_24" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CENTURY_24" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_SSID_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_SSID_24Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is cent24_auto" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "cent24_auto" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is CENTURY_AUTO" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CENTURY_AUTO" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_Password_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_Password_24Ghz
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is cent@2024" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "cent@2024" and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is CENT96" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "CENT96" and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_Password_24Ghz @CenturyLink_ZYXELC3000Z_24GHZ 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_Password_24Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 2.4GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;is SSID to YES;SSID name is centurylink" in "SSID setup" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 2.4GHz;Security to WPA2_Personal;password is cent@router" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink" ,password "cent@router" and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_DHCP_Settings_24GHZ @CenturyLink_ZYXELC3000Z_24GHZ 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_DHCP_Settings

#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 24GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 24GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 24GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;" in "DHCP SETTINGS" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "frequency to 24GHz;is DHCP to No ;" in "DHCP SETTINGS" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;Lease time is 1 day" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;DHCP Starting IP address is 192.168.0.2;DHCP Ending IP address is 192.168.0.102" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	
	
	
		
@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_AC_channels_5Ghz
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_AC_channels_5Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "wireless ettings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 36;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 40;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 44;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 48;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 149;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 153;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 157;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 161;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_Only_channels_5Ghz
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_N_Only_channels_5Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "wireless ettings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N Only;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 36;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 40;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 44;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 48;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 149;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 153;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 157;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 161;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
  

@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_NONE_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_NONE_5Ghz 
	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Security to None;" in "wireless security" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "" and security type as "None"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 40;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 44;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 36;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 48;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA2_PERSONAL_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_Security_type_WPA2_PERSONAL_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "Wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 40;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to 44;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_SSID_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_SSID_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5GHZ" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5GHZ" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is CENT5Ghz" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CENT5Ghz" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_SSID_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_SSID_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centWPA2" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centWPA2" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is CeNlInk" in "Basic settings" router screen
	Then configure the thermostat "valid" wifi ssid name "CeNlInk" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_Password_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA2_Personal_Password_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@" and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is cent1234567" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "cent1234567" and security type as "WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_Password_5Ghz 
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_WPA_WPA2_Personal_Password_5Ghz 
#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink5" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA_WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "centurylink5" ,password "Home@123." and security type as "WPA_WPA2_Personal"
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	
	
	
		
		
		
	Then user edit router settings as "frequency to 5GHz;is SSID to YES;SSID name is CenturyLink5Ghz" in "SSID setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;is SSID to YES;" in "SSID setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;is SSID to YES;SSID name is centurylink_auto" in "SSID setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@CenturyLink_ZYXELC3000Z_Wifi_Router_verify_channels_5Ghz
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_verify_channels_5Ghz

	#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 5GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;Security to WPA2_Personal;password is Home@123." in "wireless ettings" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 5GHz;Channel to Auto;mode to N_AC;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
@CenturyLink_ZYXELC3000Z_Wifi_Router_DHCP_Settings
Scenario: CenturyLink_ZYXELC3000Z_Wifi_Router_DHCP_Settings

#Given start wifi intigeration with switch and turn on "centurylink" router and the model is "ZYXELC3000Z"
	Given Launch browser and login to the router 
	Then user edit router settings as "frequency to 24GHz;Wireless Radio to enable;SSID name is centurylink" in "Basic settings" router screen
	Then user edit router settings as "frequency to 24GHz;Security to WPA2_Personal;password is Home@123." in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;Channel to Auto;mode to B_G_N;" in "Radio setup" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to No ;" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;Lease time is 10 Days" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "frequency to 24GHz;is DHCP to Yes ;DHCP Starting IP address is 192.168.0.2;DHCP Ending IP address is 192.168.0.12" in "DHCP SETTINGS" router screen
	Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
