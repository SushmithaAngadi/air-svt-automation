@General_Hawking_HW2R1150M_Router_Settings
Feature: Thor Amped Router settings for wifi testing 


@Hawking_HW2R1150M_Wifi_Router_standard_wifi_SSID_NAME
Scenario: verify wifi standard with wifi_SSID_NAME

  Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
	Given Launch browser and login to the router
	When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 2" in "Basic Wireless" router screen
	When user edit router settings as "Security is WEP;KEYLENGTH is 128;KEYFORMAT is ASCII128;WEPKEY1 is Home@123abcdA" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is G ONLY;SSID name is Hawking;Channel to 3" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B ONLY;SSID name is Hawking;Channel to 4" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B_G;SSID name is Hawking@;Channel to 5" in "Basic Wireless" router screen

@Hawking_HW2R1150M_Wifi_Router_standard_wifi_Channel
Scenario: Verify Wifi Router Channels Hawking

#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
	Given Launch browser and login to the router
	When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
	When user edit router settings as "Security is WEP;KEYLENGTH is 128;KEYFORMAT is ASCII128;WEPKEY1 is Home@123abcdA" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is G ONLY;SSID name is Hawking;Channel to 2" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B ONLY;SSID name is Hawking;Channel to 3" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is G ONLY;SSID name is Hawking;Channel to 4" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 5" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B ONLY;SSID name is Hawking;Channel to 6" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B_G;SSID name is Hawking;Channel to 7" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B_G_N;SSID name is Hawking;Channel to 8" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is G ONLY;SSID name is Hawking;Channel to 9" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is B ONLY;SSID name is Hawking;Channel to 10" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 11" in "Basic Wireless" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "Band is G ONLY;SSID name is Hawking;Channel to Auto" in "Basic Wireless" router screen
	
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_WEP
Scenario: Verify Security type WEP

#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
	Given Launch browser and login to the router
	When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
	When user edit router settings as "Security is WEP;KEYLENGTH is 128;KEYFORMAT is ASCII128;WEPKEY1 is Home@123abcdA" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WEP;KEYLENGTH is 64;KEYFORMAT is ASCII64;WEPKEY1 is Home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WEP;KEYLENGTH is 128;KEYFORMAT is ASCII128;WEPKEY1 is Home@123abcdA" in "Security Settings" router screen

@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_WPA_RADIUS
Scenario: Verify Security type WPA Radius

#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
	Given Launch browser and login to the router
	When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
	When user edit router settings as "Security is WPA RADIUS;WPASUITE to WPA2 Mixed;RADIUSIP is 192.168.5.5;RADIUSPORT is 1819;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA RADIUS;WPASUITE to  WPA_TKIP;RADIUSIP is 192.168.5.5;RADIUSPORT is 1918;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA RADIUS;WPASUITE to WPA2 Mixed;RADIUSIP is 192.168.1.5;RADIUSPORT is 1819;RADIUSPASSWORD is home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA RADIUS;WPASUITE to WPA2_AES;RADIUSIP is 192.168.5.1;RADIUSPORT is 1918;RADIUSPASSWORD is home@123@" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA RADIUS;WPASUITE to WPA2 Mixed;RADIUSIP is 192.168.1.1;RADIUSPORT is 1918;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_WPA_PRESHAREDKEY
Scenario: Verify Security type WPA PRESHAREDKEY

#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
	Given Launch browser and login to the router
	When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
	When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2 Mixed;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is Home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA_TKIP;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is home123@" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2_AES;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is home@123" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_DHCP_Disable_Enable
Scenario: Verify Security type DHCP Disable Enable
	
	#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
		Given Launch browser and login to the router
		When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
		When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2 Mixed;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is Home@123" in "Security Settings" router screen
		Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
		When user edit router settings as "IS DHCP is No" in "DHCP" router screen
		Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
		When user edit router settings as "IS DHCP is Yes" in "DHCP" router screen
		Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
		
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_LeaseTime
Scenario: Verify Security type DHCP Lease Time
	
	#Given start wifi intigeration with switch and turn on "hawking" router and the model is "HW2R1150M" 
		Given Launch browser and login to the router
		When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
		When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2 Mixed;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		When user edit router settings as "IS DHCP is Yes;Lease Time is One Hour" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Forever" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Two Days" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is One Week" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Two Weeks" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Half of a day" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Two Hours" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is One Day" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_IP_Address
Scenario: Verify Security type IP address

#		Given start wifi intigeration with switch and turn "on Hawking" router and the model is "HW2R1150M" 
		Given Launch browser and login to the router
		When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
		When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2 Mixed;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		When user edit router settings as "IS DHCP is Yes;Lease Time is One Hour;STARTIP is 192.168.5.2;ENDIP is 192.168.5.5" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is One week;STARTIP is 192.168.5.3;ENDIP is 192.168.5.6" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "IS DHCP is Yes;Lease Time is Two Days;STARTIP is 192.168.5.4;ENDIP is 192.168.5.9" in "DHCP" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_WEP_ENABLERADIUS
Scenario: Verify Security type WEP ENABLE RADIUS

#		Given start wifi intigeration with switch and turn "on Hawking" router and the model is "HW2R1150M" 
		Given Launch browser and login to the router
		When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
		When user edit router settings as "security is WEP;KEYLENGTH is 64;KEYFORMAT is ASCII64;WEPKEY1 is Home@123;ENRADIUS is Enable;RADIUSIP is 192.168.5.5;RADIUSPORT is 1819;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "security is WEP;KEYLENGTH is 64;KEYFORMAT is ASCII64;WEPKEY1 is Home@123;ENRADIUS is Enable;RADIUSIP is 192.168.5.5;RADIUSPORT is 1918;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "security is WEP;ENRADIUS is Disable" in "Security Settings" router screen
	
@Hawking_HW2R1150M_Wifi_Router_standard_Security_Type_Disable
Scenario: Verify Security type WEP Disable

#		Given start wifi intigeration with switch and turn "on Hawking" router and the model is "HW2R1150M" 
		Given Launch browser and login to the router
		When user edit router settings as "Band is N ONLY;SSID name is Hawking;Channel to 1" in "Basic Wireless" router screen
		When user edit router settings as "Security is WPA PRE-SHAREDKEY;WPASUITE to WPA2 Mixed;WPAFORMAT is PASSPHRASE;PRESHAREDKEY is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		When user edit router settings as "security is DISABLE;ENRADIUS is Disable" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "security is DISABLE;ENRADIUS is Enable;RADIUSIP is 192.168.5.2;RADIUSPORT is 1819;RADIUSPASSWORD is Home@123" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "security is DISABLE;ENRADIUS is Enable;RADIUSIP is 192.168.5.3;RADIUSPORT is 1918;RADIUSPASSWORD is home@123" in "Security Settings" router screen
#		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "security is DISABLE;ENRADIUS is Disable" in "Security Settings" router screen
		#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
		#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		