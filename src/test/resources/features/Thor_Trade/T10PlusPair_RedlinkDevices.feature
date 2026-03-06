@Thor_DIY_realDevice_HTA-1638_HTA_1633 @--xrayid:HTA-1638 @--xrayid:HTA-1633 
Feature: T10 plus Enhancement verifying the redlink pairing with eim and thermostat
	
@Pair_Redlink_devices_with_EIM_and_Thermostat 
Scenario: Verify the EIM and Thermostat pairing with Redlink devices without issue 

	When user navigate to "Add redlink device screen" 
	Then user enrolls "1" oas and "3" ias with eim and thermostat, is random pairing time needed "no" 
	Then user unenrolls "1" oas and "3" ias with eim and thermostat, is random unpairing time needed "no"