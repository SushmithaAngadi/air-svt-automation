@General_Amped_R2000G_router_Settings_with_NA_Thermostats
Feature: Thor Amped_R2000G Router settings for wifi testing 


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi standard with wifi SecurtyType WPA 24Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA"
  #Then verify the connection status as "connected" from thermostat IP
  #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA2_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi standard with wifi SecurtyType WPA2 24Ghz  

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 2.4GHz;security to WPA2;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA2"
  #Then verify the connection status as "connected" from thermostat IP
  #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;security to WPA2;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA2" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA_Mixed_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi standard with wifi SecurtyType WPA Mixed 24Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
#When user edit router settings as "frequency to 2.4GHz;security to WPA Mixed;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA Mixed" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency to 2.4GHz;security to WPA Mixed;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA Mixed" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

#@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WEP_24Ghz @Amped_R2000G_24GHZ
#Scenario: Amped_R2000G_24GHZ verify wifi standard with wifi_SecurtyType_WEP_24Ghz  
#
#	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 2.4GHz;security to WEP;Authentication is Open System;Key Length is 64bit;Key Format is ASCII;Encryption Key is Home1 " in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home1" and security type as "WEP" 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 2.4GHz;Bandwidth to 20MHz;channel to 3;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 4;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 5;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency to 2.4GHz;security to WEP;Authentication is Shared Key;Key Length is 64bit;Key Format is ASCII;Encryption Key is Resid " in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Resid" and security type as "WEP" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 2.4GHz;Bandwidth to 20MHz;channel to 2;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 4;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 3;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency to 2.4GHz;security to WEP;Authentication is Auto;Key Length is 64bit;Key Format is ASCII;Encryption Key is abcde " in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "abcde" and security type as "WEP" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 2.4GHz;Bandwidth to 40MHz;channel to 7;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 9;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 2.4GHz;channel to 10;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_Disable_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi standard with wifi SecurtyType Disable 24Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
#When user edit router settings as "frequency to 2.4GHz;security to WPA Mixed;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency to 2.4GHz;security to Disable" in "wireless security settings" router screen
Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "" and security type as "NONE" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

	
@Amped_R2000G_Wifi_Router_Change_SSID_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify connectivity with SSID 24Ghz

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
When user edit router settings as "frequency to 2.4GHz;security to WPA Mixed;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA Mixed" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_24" in "wireless basic settings" router screen
		Then configure the thermostat "valid" wifi ssid name "Amped_24" ,password "Home@123." and security type as "WPA Mixed" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G" in "wireless basic settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA Mixed" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	@Amped_R2000G_Wifi_Router_Change_Password_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify connectivity with Password 24Ghz

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is 12345" in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "12345" and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@Amped_R2000G_Wifi_Router_standard_wifi_channel_B_G_N_24Ghz  @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with B_G_N channels for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	@Amped_R2000G_Wifi_Router_standard_wifi_channel_G_N_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with channels G_N for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G_N" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	@Amped_R2000G_Wifi_Router_standard_wifi_channel_B_G_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with channels B_G for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	
	@Amped_R2000G_Wifi_Router_standard_wifi_channel_B_ONLY_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with channels B ONLY for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B ONLY ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B ONLY" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	
	@Amped_R2000G_Wifi_Router_standard_wifi_channel_G_ONLY_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with channels G ONLY for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G ONLY ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G ONLY" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	
	
	@Amped_R2000G_Wifi_Router_standard_wifi_channel_N_ONLY_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify wifi Router standard with channels N ONLY for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz N ONLY ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz N ONLY" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "wireless basic settings" router screen 
	Then verify the connection status as "connected" from thermostat IP 
	
	
	
@Amped_R2000G_Wifi_Router_standard_with_Bandwidth_24Ghz @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify connectivity with standard with Bandwidth for 24 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R2000G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N" in "wireless basic settings" router screen 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G_N" in "wireless basic settings" router screen
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G" in "wireless basic settings" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B ONLY" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz G ONLY" in "wireless basic settings" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz N ONLY" in "wireless basic settings" router screen
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	
@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA_5Ghz @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify wifi standard with wifiSecurtyType WPA 5Ghz

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA2_5Ghz @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify wifi standard with wifi SecurtyType WPA2 5Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 5GHz;security to WPA2;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
When user edit router settings as "frequency to 5GHz;security to WPA2;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA2" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WPA_Mixed_5Ghz @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify wifi standard with wifi SecurtyType WPA Mixed 5Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to WPA Mixed;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;security to WPA Mixed;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA Mixed" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

#@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_WEP_5Ghz @Amped_R2000G_5GHZ
#Scenario: verify wifi standard with wifi_SecurtyType_WEP_5Ghz 
#
#	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
#When user edit router settings as "frequency to 5GHz;security to WEP;Authentication is Open System;Key Length is 64bit;Key Format is ASCII;Encryption Key is Home1 " in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 5GHz;Bandwidth to 20MHz;channel to 36;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 44;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 48;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency to 5GHz;security to WEP;Authentication is Shared Key;Key Length is 64bit;Key Format is ASCII;Encryption Key is Resid " in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 5GHz;Bandwidth to 20MHz;channel to 149;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 153;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 161;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#When user edit router settings as "frequency to 5GHz;security to WEP;Authentication is Auto;Key Length is 64bit;Key Format is ASCII;Encryption Key is abcde " in "wireless security settings" router screen
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	When user edit router settings as "frequency to 5GHz;Bandwidth to 40MHz;channel to 36;" in "wireless basic settings" router screen
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 44;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	When user edit router settings as "frequency to 5GHz;channel to 48;" in "wireless basic settings" router screen 
#	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Amped_R2000G_Wifi_Router_standard_wifi_SecurtyType_Disable_5Ghz @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify wifi standard with wifiSecurtyType Disable 5Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N_AC ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
#	When user edit router settings as "frequency to 5GHz;security to WPA Mixed;Authentication Mode is Enterprise;Radius IP Address is 192.168.3.107;Radius Password is Home@123." in "wireless security settings" router screen 
#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
#	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;Bandwidth to 20MHz;channel to 36;" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to Disable" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "" and security type as "NONE"
	Then verify the connection status as "connected" from thermostat IP
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


	
@Amped_R2000G_Wifi_Router_Change_SSID_5Ghz @Amped_R2000G_5GHZ @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify connectivity with different SSID 5GHZ

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is router_Amp;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "router_Amp" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;SSID name is amped;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
		Then configure the thermostat "valid" wifi ssid name "amped" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
	@Amped_R2000G_Wifi_Router_Change_Password_5Ghz @Amped_R2000G_5GHZ
Scenario: Amped_R2000G_5GHZ verify connectivity with different Password 5GHZ

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amp_5G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is home@345" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amp_5G" ,password "home@345" and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is password!" in "wireless security settings" router screen
	Then configure the thermostat "valid" wifi ssid name "Amp_5G" ,password "password!" and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Amped_R2000G_Wifi_Router_standard_with_Bandwidth_5Ghz @Amped_R2000G_5GHZ
Scenario: verify connectivity with standard with Bandwidth for 5 Ghz band 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 5Ghz A ONLY" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 5Ghz N ONLY" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 5Ghz AC ONLY" in "wireless basic settings" router screen
	Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 5Ghz A_N_AC" in "wireless basic settings" router screen
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "wireless basic settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Amped_R2000G_Wifi_Router_Change_DHCP_disable @Amped_R2000G_24GHZ
Scenario: Amped_R2000G_24GHZ verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
  When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
  Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to Auto;DHCP Lease Time is 1" in "DHCP settings" router screen 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	Then verify the connection status as "disconnected" from thermostat IP 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP  
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to Auto;DHCP Lease Time is 600" in "DHCP settings" router screen 
	
	@Amped_R2000G_Wifi_Router_Change_DHCP_disable @Amped_R2000G_5GH
Scenario: Amped_R2000G_5GH verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5GHz;SSID name is Amped_R20005G;is SSID to YES;mode to 5Ghz A_N ;Bandwidth to 20MHz;channel to Auto;" in "wireless basic settings" router screen
	When user edit router settings as "frequency to 5GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen
  Then configure the thermostat "valid" wifi ssid name "Amped_R20005G" ,password "Home@123." and security type as "WPA" 
	Then verify the connection status as "connected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
	Then user edit router settings as "is DHCP to Auto;DHCP Lease Time is 1" in "DHCP settings" router screen 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	Then verify the connection status as "disconnected" from thermostat IP 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen
	Then verify the connection status as "connected" from thermostat IP  
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to Auto;DHCP Lease Time is 600" in "DHCP settings" router screen 
	
	
	
#@Amped_R2000G_Wifi_Router_Change_DHCP_lease_time
#Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 
#
#	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
  #When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to Auto;DHCP Lease Time is 600" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	#Then user verify after "300" seconds in WIFI log for IPRenewal message
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
#	@Amped_R2000G_Wifi_Router_Change_StartIPAddress
#Scenario: verify connectivity with Wifi_Router_Change_StartIPAddress_2_4Ghz 
#
#	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
  #When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;DHCP Start IP Address is 192.168.3.2" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	#Then user verify after "300" seconds in WIFI log for IPRenewal message
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	
#	@Amped_R2000G_Wifi_Router_Change_EndIPAddress
#Scenario: verify connectivity with Wifi_Router_Change_EndIPAddress_2_4Ghz 
#
#	Given start wifi intigeration with switch and turn on "amped" router and the model is "R2000G" 
#	Given Launch browser and login to the router 
#	When user edit router settings as "frequency to 2.4GHz;SSID name is Amped_R2000G;is SSID to YES;mode to 2.4Ghz B_G_N ;Bandwidth to 20MHz;channel to Auto" in "wireless basic settings" router screen
  #When user edit router settings as "frequency to 2.4GHz;security to WPA;Authentication Mode is Personal;Pre Shared Key Format is Passphrase; password is Home@123." in "wireless security settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	Then user edit router settings as "is DHCP to YES;DHCP End IP Address is 192.168.3.102" in "DHCP settings" router screen 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#	#Then user verify after "300" seconds in WIFI log for IPRenewal message
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	