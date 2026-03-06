@General_DLink_824VUP_router_Settings_with_NA_Thermostats
Feature: Thor Amped Router settings for wifi testing 


@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_None_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_None_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is None" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2" ,password "Home@123." and security type as "None" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	

@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA3_PERSONAL_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA3_PERSONAL_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	

@DLink_DIR1750_Wifi_Router_SecurtyType_WPA2_WPA3_PERSONALL_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_SecurtyType_WPA2_WPA3_PERSONALL_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	
	
	@DLink_DIR1750_Wifi_Router_WPA2_WPA3_PERSONALL_SSID_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_WPA2_WPA3_PERSONALL_SSID_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is dlink2G;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "dlink2G" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is Dlink2GHZ;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Dlink2GHZ" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	@DLink_DIR1750_Wifi_Router_WPA2_WPA3_PERSONALL_Password_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_WPA2_WPA3_PERSONALL_Password_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Dlink@2" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Dlink@2" and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Dlink@Home" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Dlink@Home" and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	


@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_PERSONAL_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_PERSONAL_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	


@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA_WPA2_PERSONAL_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA_WPA2_PERSONAL_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK;Channel is 2;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	


@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_G_N_channels_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_G_N_channels_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_G_channels_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_G_channels_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B_G" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_G_N_channels_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_G_N_channels_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G_N" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_Only_channels_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_B_Only_channels_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B ONLY" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_G_Only_channels_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_G_Only_channels_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G ONLY" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_N_Only_channels_24Ghz @DLink_DIR1750_24GHZ
#Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_N_Only_channels_24Ghz
#
#	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to N ONLY" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency is 2.4Ghz;Channel is 1" in "wireless settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency is 2.4Ghz;Channel is 2" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency is 2.4Ghz;Channel is 3" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 4" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 5" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 6" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 7" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 8" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 9" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 10" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 2.4Ghz;Channel is 11" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	


@DLink_DIR1750_Wifi_Router_wifi_bandwidth_24Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_bandwidth_24Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B_G;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G_N;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B ONLY;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G ONLY;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to N ONLY;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20_40 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B_G;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G_N;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to B ONLY;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to G ONLY;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 2.4Ghz;Channel is Auto;mode to N ONLY;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_None_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_None_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is 44;mode to A_N_AC;bandwidth is 20 MHz;security is None" in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "" and security type as "None" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	

@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA3_PERSONAL_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA3_PERSONAL_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is 44;mode to A_N_AC;bandwidth is 20 MHz;security is WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
	

@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_WPA3_PERSONALL_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_WPA3_PERSONALL_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is 44;mode to A_N_AC;bandwidth is 20 MHz;security is WPA2_WPA3_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	


@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_PERSONAL_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_WPA2_PERSONAL_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is 44;mode to A_N_AC;bandwidth is 20 MHz;security is WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	


@DLink_DIR1750_Wifi_Router_standard_SecurtyType_WPA_WPA2_PERSONAL_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_WPA2_PERSONAL_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is 44;mode to A_N_AC;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	



@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_bandwidth_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_bandwidth_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A_N_AC;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to A_N;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to A ONLY;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to N ONLY;bandwidth to 20 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A_N_AC;bandwidth is 20_40 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to A_N;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to N ONLY;bandwidth to 20_40 Mhz" in "wireless settings" router screen
		Then verify the connection status as "connected" from thermostat IP
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_N_AC_channels_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_N_AC_channels_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A_N_AC;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 5Ghz;Channel is 36" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 48" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 149" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 153" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 157" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 161" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 165" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_N_channels_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_N_channels_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to A_N" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 5Ghz;Channel is 36" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 48" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 149" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 153" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 157" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 161" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 165" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_Only_channels_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_A_Only_channels_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A ONLY;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to A ONLY" in "wireless settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency is 5Ghz;Channel is 36" in "wireless settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 40" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency is 5Ghz;Channel is 44" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 48" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 149" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 153" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 157" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 161" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
When user edit router settings as "frequency is 5Ghz;Channel is 165" in "wireless settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
	
#	@DLink_DIR1750_Wifi_Router_wifi_SecurtyType_N_Only_channels_5Ghz @DLink_DIR1750_5GHZ
#Scenario: DLink_DIR1750_Wifi_Router_wifi_SecurtyType_N_Only_channels_5Ghz
#
#	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to N ONLY;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency is 5Ghz;Channel is Auto;mode to N ONLY" in "wireless settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency is 5Ghz;Channel is 36" in "wireless settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency is 5Ghz;Channel is 40" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency is 5Ghz;Channel is 44" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 48" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 149" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 153" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 157" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 161" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency is 5Ghz;Channel is 165" in "wireless settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud



@DLink_DIR1750_Wifi_Router_wifi_DHCP_Settings_2Ghz @DLink_DIR1750_24GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_DHCP_Settings_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 2.4Ghz;IS SSID to YES;SSID name is DLINK2g;Channel is Auto;mode to B_G_N;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK2g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is DHCP to Yes ;DHCPLease time is 1" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "is DHCP to No" in "DHCP settings" router screen
#	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
  When user edit router settings as "is DHCP to Yes ;DHCPLease time is 10081" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




@DLink_DIR1750_Wifi_Router_wifi_DHCP_Settings_5Ghz @DLink_DIR1750_5GHZ
Scenario: DLink_DIR1750_Wifi_Router_wifi_DHCP_Settings_5Ghz

	Given start wifi intigeration with switch and turn on "dlink" router and the model is "DIR1750" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency is 5Ghz;IS SSID to YES;SSID name is DLINK5g;Channel is Auto;mode to A ONLY;bandwidth is 20 MHz;security is WPA_WPA2_PERSONAL;password is Home@123." in "wireless settings" router screen
	Then configure the thermostat "valid" wifi ssid name "DLINK5g" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "is DHCP to Yes ;DHCPLease time is 1" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "is DHCP to No" in "DHCP settings" router screen
#	And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
  Then verify the connection status as "disconnected" from thermostat IP
  When user edit router settings as "is DHCP to Yes ;DHCPLease time is 10081" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	

	
	
	
	
	