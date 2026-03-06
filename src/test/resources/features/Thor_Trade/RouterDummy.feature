@DummyRouter0001
Feature: Thor Asus Router settings for wifi testing 

#When user edit router settings as "frequency to 5GHz;SSID name is ASUS_5G;is SSID to No;mode to Auto;channel to Auto;security to WPA2-Personal;WPA Encryption to AES;password is Home@123." in "advance wireless settings" router screen
@DummyRouter0001_Demo
Scenario: verify wifi standard b_g_n with channels for 2_4 Ghz band demo
	Given Launch browser and login to the router 
	