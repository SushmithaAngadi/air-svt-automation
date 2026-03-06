@General_Verizon_MI424WR_Router_Settings
Feature: Thor Amped Router settings for wifi testing 


@Verizon_MI424WR_Wifi_Router_standard_wifi_Wireless_status
Scenario: verify wifi standard with wifi_Wireless_status

  #Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1;WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "VERIZON" ,password "Home@1234567." and security type as "WEP" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "WIRELESS_STATUS is OFF" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "WIRELESS_STATUS is ON" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	

@Verizon_MI424WR_Wifi_Router_standard_wifi_SSID_NAME
Scenario: verify wifi standard with wifi_SSID_NAME

  #Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON" in "Security Settings" router screen
		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "SSID NAME is VeriZon" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "SSID NAME is verizon" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
@Verizon_MI424WR_Wifi_Router_standard_wifi_CHANNEL
Scenario: verify wifi standard with wifi_CHANNEL

  #Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is Auto" in "Security Settings" router screen
		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 1" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 2" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 3" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 4" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 5" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 6" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 7" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 8" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 9" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 10" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	Then user edit router settings as "CHANNEL is 11" in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
@Verizon_MI424WR_WIFI_ROUTER_DHCP
Scenario: Verizon_MI424WR_WIFI_ROUTER_DHCP

#	Given start wifi intigeration with switch and turn "on Verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "IS_DHCP as DHCP_SERVER;START_IP is 7;END_IP is 250;LEASE TIME is 1100" in "DHCP" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "IS_DHCP as DHCP_SERVER;START_IP is 4;END_IP is 201;LEASE TIME is 1200" in "DHCP" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "IS_DHCP as DHCP_SERVER;START_IP is 5;END_IP is 202;LEASE TIME is 1300" in "DHCP" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA_PRESHARED_KEY
Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA_PRESHARED_KEY
	
	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is TKIP;WPA_KEY is home@123." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is AES;WPA_KEY is Home@123." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is TKIP_AES;WPA_KEY is Home123@." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP

@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA2_PRESHARED_KEY
Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA2_PRESHARED_KEY
	
	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
	Given Launch browser and login to the router
	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1,WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is TKIP;WPA_KEY is home@123." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is AES;WPA_KEY is Home@123." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is PRESHARED KEY;WPA_PSK_MODE is ASCII;ENCRY_ALGO is TKIP_AES;WPA_KEY is Home123@." in "Advanced Security Settings" router screen
	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
#@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA_RADIUS
#Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA_RADIUS
#	
#	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
#	Given Launch browser and login to the router
#	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
#		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is TKIP;RADIUS_IP is 192.168.10.2;RADIUS_PORT is 1819;RADIUS_SHARED_KEY is Home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is AES;RADIUS_IP is 192.168.10.3;RADIUS_PORT is 1912;RADIUS_SHARED_KEY is home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is TKIP_AES;RADIUS_IP is 192.168.10.4;RADIUS_PORT is 1916;RADIUS_SHARED_KEY is home123@." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
#@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA2_RADIUS
#Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_WPA2_RADIUS
#	
#	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
#	Given Launch browser and login to the router
#	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
#		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is TKIP;RADIUS_IP is 192.168.10.2;RADIUS_PORT is 1819;RADIUS_SHARED_KEY is Home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is AES;RADIUS_IP is 192.168.10.3;RADIUS_PORT is 1912;RADIUS_SHARED_KEY is home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WPA2;AUTHENTICATION_WPA is 802.1X;ENCRY_ALGO is TKIP_AES;RADIUS_IP is 192.168.10.4;RADIUS_PORT is 1916;RADIUS_SHARED_KEY is home123@." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
	#	Then verify the connection status as "connected" from thermostat IP
	
#@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_ADVANCED_WEP_RADIUS
#Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_ADVANCED_WEP_RADIUS
#
#	Given start wifi intigeration with switch and turn "on Verizon" router and the model is "MI424WR" 
#	Given Launch browser and login to the router
#	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
#	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is 802.1X;RADIUS_IP is 192.168.10.3;RADIUS_PORT is 1819;RADIUS_SHARED_KEY is Home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is 802.1X;RADIUS_IP is 192.168.10.4;RADIUS_PORT is 1912;RADIUS_SHARED_KEY is home@123." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is 802.1X;RADIUS_IP is 192.168.10.5;RADIUS_PORT is 1918;RADIUS_SHARED_KEY is home123@." in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP

#@Verizon_MI424WR_Wifi_Router_standard_WEP
#Scenario: verify wifi standard with wifi_WEP
#
#	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
#	Given Launch browser and login to the router
#	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON" in "Security Settings" router screen
#		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is HEX;KEY_CODE is ECD7274827" in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 128_104;WEP_MODE is ASCII;KEY_CODE is home@12345678" in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 128_104;WEP_MODE is HEX;KEY_CODE is 486f6d6540313233343536372e" in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	
#@Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_ADVANCED_WEP
#Scenario: Verizon_MI424WR_WIFI_ROUTER_SECURITY_TYPE_ADVANCED_WEP
#
#	#Given start wifi intigeration with switch and turn on "verizon" router and the model is "MI424WR" 
#	Given Launch browser and login to the router
#	When user edit router settings as "WIRELESS_STATUS is ON;SSID NAME is VERIZON;CHANNEL is 1" in "Security Settings" router screen
#		When user edit router settings as "WEP_STATUS is ON;WEP_BIT is 64_40;WEP_MODE is ASCII;KEY_CODE is Home@1234567." in "Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is WEP ONLY;NETWORK_AUTH is BOTH;ENTRY_METHOD is ASCII;WEP_LENGTH is 64_40;WEP_KEY is home@" in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is WEP ONLY;NETWORK_AUTH is OPEN SYSTEM;ENTRY_METHOD is ASCII;WEP_LENGTH is 128_104;WEP_KEY is Home@12345678" in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
#	When user edit router settings as "SECURITY is WEP;ADV_WEP_MODE is WEP ONLY;NETWORK_AUTH is SHARED KEY;ENTRY_METHOD is ASCII;WEP_LENGTH is 64_40;WEP_KEY is home12" in "Advanced Security Settings" router screen
#	#	Then configure the thermostat "valid" wifi ssid name "use router data" ,password "Password@1" and security type as "" 
#	#	Then verify the connection status as "connected" from thermostat IP
