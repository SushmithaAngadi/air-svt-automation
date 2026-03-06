@Jasper_PowerCycle_Scenarios
Feature: Verify Power cycle scenarios

  @Jasper_verify_TimeSync_afterPowerCycle
  Scenario: Verify Time sync between thermostat and app after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "5" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "10" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "20" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "30" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid

  @Jasper_verify_TimeSync_afterPowerCycle_OneHour
  Scenario: Verify Time sync between thermostat and app after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "60" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid

  @Jasper_verify_TimeSync_afterPowerCycle_SixHours
  Scenario: Verify Time sync between thermostat and app after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "360" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid

  @Jasper_verify_TimeSync_afterPowerCycle_12Hours
  Scenario: Verify Time sync between thermostat and app after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    Then Power "OFF" the thermostat for "720" min
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid

  @Jasper_verify_TBS_afterPowerReCycle
  Scenario: Verify Tstat should follow time based schedule after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    When user create "TBS_Everyday_4Period" schedule with "Default" values in app
    Then user verifies "TBS_Everyday_4Period" schedule is in sync with app and stat
    Then Set the time to "5Min_BeforeNextPeriod"
    Then Power "OFF" the thermostat for "10" min
    Then user verifies "TBS_Everyday_4Period" schedule is in sync with app and stat
    And user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid

  @Jasper_verify_GeofenceSchedule_afterPowerReCycle
  Scenario: Verify Tstat should follow Geofence schedule after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    And user launches and logs in to the Lyric application
    When user changes system mode to "Heat" in APP
    Then set geofence location as "Home"
    Then Update geofence location info in app
    When user create "Geofence with Sleep" schedule with "Default" values in app
    Then user verifies "System" is as per "Geofence" and in sync between app and stat
    Then Set the time to "5Min_BeforeSleepPeriod"
    Then Power "OFF" the thermostat for "10" min
    Then User verifies "Geofence Sleep" label in app Primary card, With wait time "60:SECONDS"
    Then user verifies "System" is as per "Geofence" and in sync between app and stat

  @Jasper_verify_GeofenceSchedule_afterPowerReCycle
  Scenario: Verify Tstat should follow Geofence schedule after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    When user create "TBS_Everyday_4Period" schedule with "Default" values in app
    Then user verifies "TBS_Everyday_4Period" schedule is in sync with app and stat
    When user changes system mode to "Heat" in APP
    Then user modifies "Heat" setpoint value "PLUS 2" in "app"
    Then User verifies "Hold until" label in app Primary card, With wait time "Default"
    Then User verifies "HOLD UNTIL" on the stat
    Then Power "OFF" the thermostat for "5" min
    Then User verifies "HOLD UNTIL" on the stat
    Then User verifies "Hold until" label in app Primary card, With wait time "Default"

  @Jasper_verify_GeofenceSchedule_afterPowerReCycle
  Scenario: Verify Tstat should follow Geofence schedule after power recycle
    #register thermostat
    Given user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    When user create "TBS_Everyday_4Period" schedule with "Default" values in app
    Then user verifies "TBS_Everyday_4Period" schedule is in sync with app and stat
    When user changes system mode to "Heat" in APP
    Then user modifies "Heat" setpoint value "PLUS 2" in "app"
    Then User verifies "Hold until" label in app Primary card, With wait time "Default"
    Then User verifies hold until time is next period time
    Then user Selects "PERMANENTLY" overide option in app primary card
    Then user Verifies "PERMANENTLY" options in App Primary card
    Then User verifies "PERMANENT HOLD" on the stat
    Then Power "OFF" the thermostat for "5" min
    Then User verifies "PERMANENT HOLD" on the stat
    Then user Verifies "PERMANENTLY" options in App Primary card
    Then user verifies to check "TIMESYNC:STAT_DETAILS:DEVICE_DATA" are valid
    
 @Jasper_verify_HomekitPairingRetain_afterPowerReCycle_IOS
  Scenario: Verify that Homekit Pairing should retain on both Thermostat and Home app after power recycle 
  And set stat to "factory default" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SETUP_THERMOSTAT" with thread state is "true" and thread need to continue "false" 
	And Set Stat Command to "SCHEDULE_OFF" with thread state is "true" and thread need to continue "false" 
	Given user launches Honeywell Home application 
	Then Launch and Confirm "HOME KIT" third party application 
	Then Check stat is paired with HomeKit 
	When Set Jasper NA Thermostat to Broadcast Mode, Mode type is "WAC MODE" 
	Then Initiate HomeKit Select Thermostat from Add Accessory 
	Then Pair Thermostat with Homekit 
	Then Select Default location and Device Name, Complete AccessorySetup 
	When User set System mode to "Heat" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Heat" Setpoint "75" from "STAT" ,Verify from "HOMEKIT" 
	When User set System mode to "Cool" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Cool" Setpoint "68" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Heat" from "HOMEKIT" ,Verify from "STAT" 
	Then Set "Heat" Setpoint "70" from "HOMEKIT" ,Verify from "STAT" 
	When User set System mode to "Cool" from "STAT" ,Verify from "HOMEKIT" 
	Then Set "Cool" Setpoint "82" from "STAT" ,Verify from "HOMEKIT" 
	Then Delete Device from HomeKit
	
      
