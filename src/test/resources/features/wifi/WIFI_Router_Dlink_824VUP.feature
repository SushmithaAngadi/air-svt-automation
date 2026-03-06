@General_DLink_824VUP_router_Settings_with_NA_Thermostats
Feature: Thor Amped Router settings for wifi testing 

@DLink_824VUP_Wifi_Router_SecurtyType_Mode
Scenario: Verify Wifi Standard SecurtyType_Mode

#	Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router
	When user edit router settings as "IS SSID to NO;SSID name is DLINK;Channel is 1;security is WPA-PSK;PRESHARED KEY is @resideo" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	When user edit router settings as "IS SSID to YES;SSID name is dlink;Channel is 2;security is WEP;WEPENCRYPTION is 64;KEYMODE is HEX;WEPKEY is home123@" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP

@DLink_824VUP_Wifi_Router_SecurtyType_WEP
Scenario: verify wifi standard with wifi_SecurtyType_WEP

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is DLINK;Channel is 1;security is WEP;WEPENCRYPTION is 64;KEYMODE is HEX;WEPKEY is home123@" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is DLINK;Channel is 2;security is WEP;WEPENCRYPTION is 128;KEYMODE is HEX;WEPKEY is home123@" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is DLINK;Channel is 3;security is WEP;WEPENCRYPTION is 64;KEYMODE is HEX;WEPKEY is home123@" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is DLink;Channel is 4;security is WEP;WEPENCRYPTION is 128;KEYMODE is HEX;WEPKEY is home@123" in "wireless settings" router screen
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLink;Channel is 5;security is WEP;WEPENCRYPTION is 128;KEYMODE is HEX;WEPKEY is home@123" in "wireless settings" router screen
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLink;Channel is 6;security is WEP;WEPENCRYPTION is 128;KEYMODE is HEX;WEPKEY is home@123" in "wireless settings" router screen
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is dlink;Channel is 7;security is WEP;WEPENCRYPTION is 256;KEYMODE is HEX;WEPKEY is Home@123" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is dlink;Channel is 8;security is WEP;WEPENCRYPTION is 256;KEYMODE is HEX;WEPKEY is Home@123" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is dlink;Channel is 9;security is WEP;WEPENCRYPTION is 256;KEYMODE is HEX;WEPKEY is Home@123" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP

@DLink_824VUP_Wifi_Router_standard_wifi_SecurtyType_WPA_PSK
Scenario: verify wifi standard with wifi_SecurtyType_WPA_PSK

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is DLink;Channel is 1;security is WPA-PSK;PRESHARED KEY is Resideo@" in "wireless settings" router screen
	# Then verify the connection status as "disconnected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is dlink;channel is 2;security is WPA-PSK;PRESHARED KEY is home123@" in "wireless settings" router screen 
	# Then verify the connection status as "disconnected" from thermostat IP
	Then user edit router settings as "SSID name is DLINK;channel is 3;security is WPA-PSK;PRESHARED KEY is home@123" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is DLINK;channel is 4;security is WPA-PSK;PRESHARED KEY is @resideo" in "wireless settings" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 

@DLink_824VUP_Wifi_Router_standard_wifi_Channel_Radius
Scenario: Verify channel in wireless_settings_Radius

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP"
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Dlink;channel to 1;security to 802.1X;KEY LENG is 64 bit;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is home@123" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "SSID name is dink;channel to 2;security to 802.1X;KEY LENG is 128 bit;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is Home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLINK;channel to 3;security to 802.1X;KEY LENG is 64 bit;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is dlink;channel to 4;security to 802.1X;KEY LENG is 128 bit;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is Dlink;channel to 5;security to 802.1X;KEY LENG is 64 bit;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is Home@123" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "SSID name is dink;channel to 6;security to 802.1X;KEY LENG is 128 bit;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is Home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLINK;channel to 7;security to 802.1X;KEY LENG is 64 bit;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is HOME@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is dlink;channel to 8;security to 802.1X;KEY LENG is 128 bit;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@DLink_824VUP_Wifi_Router_standard_wifi_Channel_WPA
Scenario: Verify channel in wireless_settings_WPA

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router
	When user edit router settings as "SSID name is Dlink;channel to 1;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is Home@123" in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	Then user edit router settings as "SSID name is dlink;channel to 2;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is home123@" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLINK;channel to 3;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is home@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is dlink;channel to 4;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is resideo@123" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is DLINK;channel to 5;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is resideo@" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is Dlink;channel to 6;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1912;RADIUS SHARED KEY is reside@" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "SSID name is Dlink;channel to 7;security to WPA;Radius IP is 192.168.10.1;Radius Port is 1812;RADIUS SHARED KEY is Resideo@" in "wireless settings" router screen  
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
	
@DLink_824VUP_Wifi_Router_Change_DHCP_lease_time
Scenario: DLink_824VUP_Wifi_Router_Change_DHCP_lease_time

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router 
	When user edit router settings as "SSID name is Dlink;channel to 1;security to WPA-PSK;PRESHARED KEY is Home@123" in "wireless settings" router screen 
#	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""  
#	#	Then verify the connection status as "connected" from thermostat IP 
#	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#	Then user edit router settings as "is DHCP to Yes" in "DHCP" router screen
	Then user edit router settings as "DHCP LEASE is 1 HOUR" in "DHCP" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	##	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "DHCP LEASE is 2 DAYS" in "DHCP" router screen 
	Then user edit router settings as "DHCP LEASE is 1 WEEK" in "DHCP" router screen 
	
	
@DLink_Wifi_Router_Change_DHCP_disable
Scenario: DLink_824VUP_Wifi_Router_Change_DHCP_disable

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router 
  When user edit router settings as "SSID name is DLINK;channel to 2;security to WPA-PSK;PRESHARED KEY is Home@123." in "wireless settings" router screen 
	#  Then configure the thermostat "valid" wifi ssid name "use router data" ,password "" and security type as ""
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to Yes" in "DHCP" router screen 
	#Then #Set Stat Command to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
	# Then verify the connection status as "disconnected" from thermostat IP
	#Then verify Link local IP "169." in WIFI log
	Then user edit router settings as "is DHCP to No" in "DHCP" router screen 
	#	Then verify the connection status as "connected" from thermostat IP
	#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	
@DLink_Wifi_Router_Change_DHCP_IP
Scenario: DLink_824VUP_Wifi_Router_Change_DHCP_IP

	#Given start wifi intigeration with switch and turn "on DLink" router and the model is "824VUP" 
	Given Launch browser and login to the router
	When user edit router settings as "is DHCP to Yes" in "DHCP" router screen
	Then user edit router settings as "DHCP Start IP Address is 102" in "DHCP" router screen
	Then user edit router settings as "DHCP End IP Address is 200" in "DHCP" router screen

	
	