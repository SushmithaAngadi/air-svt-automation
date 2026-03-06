@Thor_Power_reset_Scenario 
Feature: As a User Do multiple power reset either Tstat or Wifi Need to analysis behavious of device 

@Thermostat_power_reset 
Scenario: Wifi reset in multiple time to understand device condition 
	Given User try mulitple "Wifi" reset using "Arduino"
	
@MFI_chip_initialiation_fail 
Scenario: Wifi reset in multiple time to understand device condition 

	Given set stat to "factory default" with thread state is "true" and thread need to continue "false"
	Then Verify is AP mode is "true" 
	
	 
@Firmware_Upgrade_Fail 
Scenario: Firmware after upgrade Failure do soft restart

	Given Restart devices from LCC
