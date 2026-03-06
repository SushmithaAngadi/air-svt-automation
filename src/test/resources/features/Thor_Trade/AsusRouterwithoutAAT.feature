@General_Asus_router_Settings_with_NA_Thermostats_without_AAT 
Feature: Thor Asus Router settings for wifi testing 

#When user edit router settings as "frequency to 5GHz;SSID name is ASUS_5G;is SSID to No;mode to Auto;channel to Auto;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen
@Asus_RTAC68U_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz_demo_2 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band demo new 
	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 13" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_SSID_Password_2_4Ghz_demo_2 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz demo new_ 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Asus_24;security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "SSID name is ASUS" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "security to WPA2-Personal;password is home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "security to WPA2-Personal;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	
@Asus_RTAC68U_Wifi_Router_standard_bgn_wifi_channel_2_4Ghz 
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 12" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "channel to 13" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 12" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "channel to 13" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "channel to Auto" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 1" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 2" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 3" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 4" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 5" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 6" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 7" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 8" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 9" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 10" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 11" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "channel to 12" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "channel to 13" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_standard_bgn_with_Bandwidth_2_4Ghz 
Scenario: verify connectivity with standard b_g_n with Bandwidth for 2_4 Ghz band 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Auto" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 40 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 20_40 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to N Only" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 40 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "bandwidth to 20_40 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "mode to Legacy" in "advance wireless settings" router screen 
	Then user edit router settings as "bandwidth to 20 MHz" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_SSID_Password_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Security_type_WPA2_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "SSID name is Asus_24;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "SSID name is ASUS" in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "password is home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
	Then user edit router settings as "password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DHCP_disable_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_Disable_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then verify the connection status as "disconnected" from thermostat IP 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify link local "IP:169.XX.XX.XX" in WIFI log 
	Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DHCP_lease_time_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_DHCP_lease_time_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DHCPLease time is 600" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then user verify after "300" seconds in WIFI log for IPRenewal message
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DNS_IP1_2_valid_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_DNS_IP1_2_valid_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DNS IP1 is 8.8.4.4" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify "DNS-Srv Addr:8.8.4.4" in WIFI log 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
@Asus_RTAC68U_Wifi_Router_Change_DNS_IP1_2_invalid_2_4Ghz 
Scenario: verify connectivity with Wifi_Router_Change_DNS_IP1_2_invalid_2_4Ghz 

	Given Launch browser and login to the router 
	When user edit router settings as "frequency to 2.4GHz;SSID name is ASUS;is SSID to No;mode to Auto;channel to 6;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	Then user edit router settings as "DNS IP1 is 12.1.168.192" in "DHCP settings" router screen 
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	#Then verify "DNS-Srv Addr:12.1.168.192" in WIFI log
	#Then verify "DNS-Srv Addr:8.8.8.8"  in WIFI log
	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
	
	