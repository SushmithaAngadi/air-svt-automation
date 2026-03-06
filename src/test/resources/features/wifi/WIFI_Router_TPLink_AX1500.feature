@General_TPLINK_AX1500_router_Settings_with_NA_Thermostats_with_AAT
Feature: Jasper TPLINK Router settings for wifi testing

  @TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_SSID_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_SSID_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK2G;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK2G" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
    
    
    @TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_SSID_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_SSID_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink@2024;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink@2024" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 
 
 @TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_Password_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_Password_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
   	When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Tplink@24" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Tplink@24" and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is tplink!2024" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "tplink!2024" and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    @TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_Password_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_Password_24Ghz
  	Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
  	Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is tplink@wp3" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "tplink@wp3" and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is tp123" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "tp123" and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    @TPLINK_AX1500_Wifi_Router_wifi_SecurityType_WPA_WPA2_PERSONAL_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_SecurityType_WPA_WPA2_PERSONAL_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
   	When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    
     @TPLINK_AX1500_Wifi_Router_wifi_SecurityType_WPA2_WPA3_PERSONAL_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_SecurityType_WPA2_WPA3_PERSONAL_24Ghz
  	Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
  	Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    Then user edit router settings as "frequency to 2.4GHz;SSID name is tplink24;Is SSID to NO;mode to B_G_N_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink24" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    
   
   
    
    
    @TPLINK_AX1500_NegativeScenario_Wifi_Router_mode_AX_Only_24Ghz @TPLINK_AX1500_24GHZ
    Scenario: TPLINK_AX1500_NegativeScenario_Wifi_Router_mode_AX_Only_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to  AX Only;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "invalid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
 
 
    
     @TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_B_G_N_MIXED_channels_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_B_G_N_MIXED_channels_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    @TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_BGN_AX_MIXED_channels_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_BGN_AX_MIXED_channels_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_AX_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 2.4GHz;channel to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 1" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 2" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 3" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 4" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 5" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 6" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 7" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 8" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 9" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 10" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;channel to 11" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  @TPLINK_AX1500_Wifi_Router_standard_bgn_with_Bandwidth_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_with_Bandwidth_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_AX_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  #@TPLINK_AX1500_Wifi_Router_Security_type_NONE_24Ghz @TPLINK_AX1500_24GHZ
  #Scenario: TPLINK_AX1500_Wifi_Router_Security_type_NONE_24Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123."" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;mode to AX ONLY;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_AX_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  #@TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_ENTERPRISE_24Ghz @TPLINK_AX1500_24GHZ
  #Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_ENTERPRISE_24Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL"
    #Then verify the connection status as "connected" from thermostat IP
 

  #@TPLINK_AX1500_Wifi_Router_Security_type_NONE_24Ghz_Hidden_SSID @TPLINK_AX1500_24GHZ
  #Scenario: TPLINK_AX1500_Wifi_Router_Security_type_NONE_24Ghz_Hidden_SSID
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to AX ONLY;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 2.4GHz;mode to B_G_N_AX_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "None"
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
     @TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_Hidden_SSID_24GHZ @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_Hidden_SSID_24GHZ
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to YES;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK_24;Is SSID to YES;mode to B_G_N_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK_24" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  @TPLINK_AX1500_Wifi_Router_Security_type_WPA3_WPA2_24Ghz_Hidden_SSID @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA3_WPA2_24Ghz_Hidden_SSID
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to YES;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK24GHZ;Is SSID to YES;mode to B_G_N_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK24GHZ" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
        
		
    

  @TPLINK_AX1500_Wifi_Router_Change_DHCP_lease_time_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with Change_DHCP_lease_time_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "is DHCP to YES" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "DHCPLease time is 1" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		 Then user edit router settings as "is DHCP to NO" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    And set stat to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
     Then verify the connection status as "disconnected" from thermostat IP
     Then user edit router settings as "is DHCP to YES" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "DHCPLease time is 120" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
     
  
  
  
  @TPLINK_AX1500_Wifi_Router_Change_DNS_IP1_2_valid_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with Change_DNS_IP1_2_valid_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "is DHCP to YES;DNS IP1 is 8.8.4.4" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "DNS IP2 is 8.8.8.8" in "DHCP settings" router screen
   Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then verify the connection status as "connected" from thermostat IP
    #Then verify "DNS-Srv Addr:8.8.4.4" in WIFI log
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  @TPLINK_AX1500_Wifi_Router_Change_DNS_IP1_2_invalid_24Ghz @TPLINK_AX1500_24GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with Change_DNS_IP1_2_invalid_24Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 2.4GHz;SSID name is TPLINK;Is SSID to NO;mode to B_G_N_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "is DHCP to YES;DNS IP1 is 12.1.168.192" in "DHCP settings" router screen
    Then verify the connection status as "disconnected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not " sync with cloud 
    Then user edit router settings as "DNS IP2 is 13.1.168.192" in "DHCP settings" router screen
    Then verify the connection status as "disconnected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should not" sync with cloud 
    #Then verify "DNS-Srv Addr:12.1.168.192" in WIFI log
    #Then verify google ip "DNS-Srv Addr:8.8.8.8" in WIFI lof
    Then user edit router settings as "DNS IP1 is 8.8.4.4;DNS IP2 is 8.8.8.8" in "DHCP settings" router screen
    Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
		
		
		@TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_SSID_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_SSID_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5GHZ;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5GHZ" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5G;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5G" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "frequency to 5GHz;SSID name is tplink5_auto;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink5_auto" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    @TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_SSID_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_SSID_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 5GHz;SSID name is tplink5;Is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;SSID name is tplink@5Ghz;Is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink@5Ghz" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
 
 
 @TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_Password_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA_WPA2_PERSONAL_Password_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is Tplink@24" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Tplink@24" and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;Is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;Version to WPA_PSK_WPA2_PSK;ENCRYPTION to AES;password is tplink!2024" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "tplink!2024" and security type as "WPA_WPA2_PERSONAL_AES"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    @TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_Password_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_wifi_WPA2_WPA3_PERSONAL_Password_5Ghz
  	Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
  	Then user edit router settings as "frequency to 5GHz;SSID name is tplink5;Is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;SSID name is tplink5;Is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is tplink@wp3" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink5" ,password "tplink@wp3" and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;SSID name is tplink5;Is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is tp123" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "tplink5" ,password "tp123" and security type as "WPA2_WPA3_PERSONAL"
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
	

  #@TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_AX_Only_channel_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_AX_Only_channel_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to AX Only;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    #Then user edit router settings as "frequency to 5GHz;mode to AX Only" in "advance wireless settings" router screen
    #	Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to Auto" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 36" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 149" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 153" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 157" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;channel to 161" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    @TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_A_N_AC_MIXED_MIXED_channel_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_A_N_AC_MIXED_MIXED_channel_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 5GHz;channel to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 36" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 149" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 153" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 157" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 161" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    @TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_A_N_AC_AX_MIXED_channel_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_standard_bgn_wifi_A_N_AC_AX_MIXED_channel_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_AX_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 5GHz;channel to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 36" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 44" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 48" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 149" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 153" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 157" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;channel to 161" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  @TPLINK_AX1500_Wifi_Router_standard_bgn_with_Bandwidth_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with standard b_g_n with BANDWIDTH for 5 Ghz band3
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    #Then user edit router settings as  "frequency to 5GHz;mode to AX Only" in "advance wireless settings" router screen
    #Then user edit router settings as "frequency to 5GHz;bandwidth to Auto" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 5GHz;bandwidth to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_AX_MIXED" in "advance wireless settings" router screen
    Then user edit router settings as "frequency to 5GHz;bandwidth to Auto" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;bandwidth to 20 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;bandwidth to 40 MHz" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
  	And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  	
  	
  @TPLINK_AX1500_Wifi_Router_Security_type_NONE_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with Security_type_NONE_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123."" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    #Then user edit router settings as "frequency to 5GHz;mode to AX ONLY;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_AX_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
		
		
		@TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL @TPLINK_AX1500_5GHZ
		 Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
		Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    
    @TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL @TPLINK_AX1500_5GHZ
		 Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_MIXED;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud 
#		When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to AX Only;channel to Auto;security to WPA_WPA2_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud  
		Then user edit router settings as "frequency to 5GHz;channel to 40" in "advance wireless settings" router screen
    Then verify the connection status as "connected" from thermostat IP
    And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    
    @TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL @TPLINK_AX1500_5GHZ
		 Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 5GHz;is SSID to NO;mode to A_N_AC_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#		Then user edit router settings as "frequency to 5GHz;is SSID to NO;mode to AX Only;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud


		
#		@TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL @TPLINK_AX1500_5GHZ
#		 Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #Then user edit router settings as "frequency to 5GHz;is SSID to NO;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#		Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#		Then user edit router settings as "frequency to 5GHz;mode to AX Only;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    
    

  @TPLINK_AX1500_Wifi_Router_Security_type_NONE_5Ghz_Hidden_SSID @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500 - verify connectivity with type_NONE_5Ghz_Hidden_SSID
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to YES;mode to A_N_AC_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "frequency to 5GHz;is SSID to NO;mode to AX ONLY;security to None for AX1500 model" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_AX_MIXED;security to None for AX1500 model" in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "None"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud

  @TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_Hidden_SSID_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA_WPA2_PERSONAL_Hidden_SSID_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;mode to A_N_AC_AX_MIXED;security to WPA_WPA2_PERSONAL;is SSID to YES;Version to WPA_PSK_WPA2_PSK;Encryption to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 5GHz;mode to A_N_AC_MIXED;security to WPA_WPA2_PERSONAL;is SSID to YES;Version to WPA_PSK_WPA2_PSK;Encryption to AES;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA_WPA2_PERSONAL_AES"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		
		 @TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL_Hidden_SSID_5Ghz @TPLINK_AX1500_5GHZ
  Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_PERSONAL_Hidden_SSID_5Ghz
    Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    Given Launch browser and login to the router
    Then user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to YES;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		Then user edit router settings as "frequency to 5GHz;is SSID to YES;mode to A_N_AC_MIXED;security to WPA2_WPA3_PERSONAL ;password is Home@123." in "advance wireless settings" router screen
    Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
		Then verify the connection status as "connected" from thermostat IP 
		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
#		@TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_ENTERPRISE_Hidden_SSID_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500_Wifi_Router_Security_type_WPA2_WPA3_ENTERPRISE_Hidden_SSID_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #Then user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to YES;mode to A_N_AC_AX_MIXED;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#		Then user edit router settings as "frequency to 5GHz;is SSID to YES;mode to A_N_AC_MIXED;security to WPA2_WPA3_ENTERPRISE" in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "" and security type as "WPA2_WPA3_ENTERPRISE"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
    
    

  #@TPLINK_AX1500_Wifi_Router_Change_DHCP_disable_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500 - verify connectivity with Change_DHCP_disable_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "is DHCP to Yes" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then #Set Stat Command to "PRESERVE NVM" with thread state is "true" and thread need to continue "false"
    # Then verify the connection status as "disconnected" from thermostat IP
    #Then verify Link local IP "169." in WIFI log
    #Then user edit router settings as "is DHCP to No" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#
  #@TPLINK_AX1500_Wifi_Router_Change_DHCP_lease_time_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500 - verify connectivity with Change_DHCP_lease_time_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "DHCPLease time is 600" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#
  #Then user verify after "300" seconds in WIFI log for IPRenewal message
  #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
  #
  #@TPLINK_AX1500_Wifi_Router_Change_DNS_IP1_2_valid_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500 - verify connectivity with Change_DNS_IP1_2_valid_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "DNS IP1 is 8.8.4.4" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "DNS IP2 is 8.8.8.8" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then verify the connection status as "connected" from thermostat IP
    #Then verify "DNS-Srv Addr:8.8.4.4" in WIFI log
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
#
  #@TPLINK_AX1500_Wifi_Router_Change_DNS_IP1_2_invalid_5Ghz @TPLINK_AX1500_5GHZ
  #Scenario: TPLINK_AX1500 - verify connectivity with Change_DNS_IP1_2_invalid_5Ghz
    #Given start wifi intigeration with switch and turn on "tplink" router and the model is "AX1500"
    #Given Launch browser and login to the router
    #When user edit router settings as "frequency to 5GHz;SSID name is TPLINK5;is SSID to NO;mode to A_N_AC_AX_MIXED;channel to Auto;security to WPA2_WPA3_PERSONAL;password is Home@123." in "advance wireless settings" router screen
    #Then configure the thermostat "valid" wifi ssid name "TPLINK5" ,password "Home@123." and security type as "WPA2_WPA3_PERSONAL"
#		Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "DNS IP1 is 12.1.168.192" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then user edit router settings as "DNS IP2 is 13.1.168.192" in "DHCP settings" router screen
    #Then verify the connection status as "connected" from thermostat IP 
#		And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
    #Then verify the connection status as "connected" from thermostat IP
    #Then verify "DNS-Srv Addr:12.1.168.192" in WIFI log
    #Then verify google ip "DNS-Srv Addr:8.8.8.8" in WIFI lof
    #And user change the "heat" setpoint from cloud using "chil" ,thermostat "should" sync with cloud
		
		
		
		
		
 