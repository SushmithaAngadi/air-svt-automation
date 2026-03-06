@General_Ubee_router_Settings_with_NA_Thermostats
Feature: Thor Ubee Router settings for wifi testing 


@Ubee_EVW320B_
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

#	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router	
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
		When user edit router settings as "SSID name is UBEE;security to WEP;Encryption to 64bit;PassPhrase is UbeeWEP" in "wireless primary network settings" router screen 
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is 3700;DHCP Start IP Address is 192.168.178.12" in "DHCP settings" router screen 
		
@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA2;Encryption to Mixed;" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PSK_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA2 PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 2_4 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WEP;Encryption to 64bit;PassPhrase is UbeeWEP" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




@Ubee_EVW320B_Wifi_Router_Change_SSID_Password_2_4Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz demo new_ 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
  When user edit router settings as "SSID name is Ubee_24;is SSID to YES;" in "wireless primary network settings" router screen
 #	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is Ubee;is SSID to YES;" in "wireless primary network settings" router screen
 #	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Ubee_EVW320B_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Ubee_EVW320B_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Password for 2.4Ghz

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Ubee_24;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	When user edit router settings as "SSID name is Ubee;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
@Ubee_EVW320B_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Ubee_EVW320B_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is 3500" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Ubee_EVW320B_Wifi_Router_Change_StartIPAddress_2_4Ghz 
Scenario: verify connectivity with Change_StartIPAddress_2_4Ghz  

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
		When user edit router settings as "frequency to 2.4Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Start IP Address is 192.168.178.12" in "DHCP settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
			
@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 5 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 2" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 3" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 5 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA2;Encryption to Mixed;" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 5" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA_PSK_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 5 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WPA2_PSK_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 5 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA2 PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 6" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 7" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_SecurtyType_WEP_24Ghz
Scenario: verify wifi standard b_g_n with wifi_SecurtyType_WPA_PSK for 5 Ghz band demo2 Ubee 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WEP;Encryption to 64bit;PassPhrase is UbeeWEP" in "wireless primary network settings" router screen 
	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Home@123." and security type as "" 
	Then verify the connection status as "connected" from thermostat IP 
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 1" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "channel to 4" in "wireless radio settings" router screen 
	Then verify the connection status as "connected" from thermostat IP
#	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud




@Ubee_EVW320B_Wifi_Router_Change_SSID_Password_5Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_5Ghz demo new_ 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
  When user edit router settings as "SSID name is Ubee_24;is SSID to YES;" in "wireless primary network settings" router screen
 #	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is Ubee;is SSID to YES;" in "wireless primary network settings" router screen
 #	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
	
@Ubee_EVW320B_Wifi_Router_standard_bgn_wifi_channel_5Ghz 
Scenario: verify wifi standard b_g_n with channels for 5 Ghz band 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	Then user edit router settings as "channel to Auto" in "wireless radio settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 36" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 44" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 52" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 60" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 100" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 108" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 116" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 124" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 132" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	Then user edit router settings as "channel to Auto" in "wireless radio settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 36" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 44" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 52" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 60" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 100" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 108" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 116" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 124" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 132" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	Then user edit router settings as "channel to Auto" in "wireless radio settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 36" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 44" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 52" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 60" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 100" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 108" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 116" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 124" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 132" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to Auto" in "wireless radio settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 36" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 44" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 52" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 60" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 100" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 108" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 116" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 124" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 132" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Ubee_EVW320B_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 5 Ghz band 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11h" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz" in "wireless radio settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	

	
@Ubee_EVW320B_Wifi_Router_Change_SSID_Password_5Ghz 
Scenario: verify connectivity with Password for 5Ghz

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is Ubee_24;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	When user edit router settings as "SSID name is Ubee;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should not" sync with cloud 
 When user edit router settings as "SSID name is UBEE;security to WPA PSK;Encryption to MIXED;password is Home@123." in "wireless primary network settings" router screen 
#	And user change the "heat" setpoint from cloud using "tcc" ,thermostat "should" sync with cloud 
	
@Ubee_EVW320B_Wifi_Router_Change_DHCP_disable_5Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_5Ghz 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 40 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Ubee_EVW320B_Wifi_Router_Change_DHCP_lease_time_5Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_5Ghz 

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
	When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	Then user edit router settings as "is DHCP to YES;DHCP Lease Time is 3500" in "DHCP settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	@Ubee_EVW320B_Wifi_Router_Change_StartIPAddress_5Ghz 
Scenario: verify connectivity with Change_StartIPAddress_5Ghz  

	Given start wifi intigeration with switch and turn "on Ubee" router and the model is "EVW320B" 
	Given Launch browser and login to the router
		When user edit router settings as "frequency to 5Ghz;Bandwidth to 20 Mhz;channel to 4;Mode to 802.11d" in "wireless radio settings" router screen 
	When user edit router settings as "SSID name is UBEE;security to WPA;Encryption to AES;" in "wireless primary network settings" router screen 
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to YES;DHCP Start IP Address is 192.168.178.12" in "DHCP settings" router screen
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	#And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 