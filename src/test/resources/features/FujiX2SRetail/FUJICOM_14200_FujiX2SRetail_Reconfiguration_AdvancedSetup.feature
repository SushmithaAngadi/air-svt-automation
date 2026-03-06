@FUJICOM_14200_FujiX2SRetail_Reconfiguration_AdvancedSetup
Feature: Advanced Setup features

#1
	@Fuji_Thermostat_Verify_AdvancedSetup_Conv_ElecHt_H1C2
  Scenario: FUJICOM-14201_To verify Advanced Setup in Thermostat and in Mobile app_Conv_ElecHt_H1C2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
#  	Then user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "ELECTRIC"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES RCH" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	Given user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
	
#2	
		@Fuji_Thermostat_Verify_AdvancedSetup_Conv_ElecHt_H1C2_to_HP_O_B_On_Cool_H2C1
  Scenario: FUJICOM-14202_To verify Advanced Setup in Thermostat and in Mobile app_Conv_ElecHt_H1C2_to_HP_O_B_On_Cool_H2C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Electric Heat" with "1" heat and "2" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
	Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
	#Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1" // needed later- issue now
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "MANUAL"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
	
#3	
		@Fuji_Thermostat_Verify_AdvancedSetup_HP_O_B_On_Cool_H2C1_to_Rad_Steam_H1C1
  Scenario: FUJICOM-14203_To verify Advanced Setup in Thermostat and in Mobile app_HP_O_B_On_Cool_H2C1_to_Rad_Steam_H1C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
   	Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "STEAM"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
#	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App


#4
		@Fuji_Thermostat_Verify_AdvancedSetup_Rad_Steam_H1C1_to_Conv_HighEffGas_H1C1
  Scenario: FUJICOM-14204_To verify Advanced Setup in Thermostat and in Mobile app_Rad_Steam_H1C1_to_Conv_HighEffGas_H1C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
 	Then user verifies thermostat configuration as "Hydronic Heat" with "1" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS HIGH EFFICIENCY"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
	
	
#5
		@Fuji_Thermostat_Verify_AdvancedSetup_Conv_HighEffGas_H1C1_to_CoolOnly_C1
  Scenario: FUJICOM-14205_To verify Advanced Setup in Thermostat and in Mobile app_Conv_HighEffGas_H1C1_to_CoolOnly_C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
#   	Then user verifies thermostat configuration as "Gas" with "1" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
	
	
#6	
	@Fuji_Thermostat_Verify_AdvancedSetup_CoolOnly_C1_to_Conv_Electric_H2C2
  Scenario: FUJICOM-14206_To verify Advanced Setup in Thermostat and in Mobile app_CoolOnly_C1_to_Conv_Electric_H2C2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Other" with "0" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "ELECTRIC"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES RCH" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MAXIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
	
	
##7	
	 	@Fuji_Thermostat_Verify_AdvancedSetup_Conv_Electric_H2C2_to_HP_O_B_On_Heat_H1C1
  Scenario: FUJICOM-14207_To verify Advanced Setup in Thermostat and in Mobile app_Conv_Electric_H2C2_to_HP_O_B_On_Heat_H1C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Electric Heat" with "2" heat and "2" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
	Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
	#Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1" // needed later- issue now
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "NONE"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
	
	
#8	
		@Fuji_Thermostat_Verify_AdvancedSetup_HP_O_B_On_Heat_H1C1_to_CoolOnly_C2
  Scenario: FUJICOM-14208_To verify Advanced Setup in Thermostat and in Mobile app_HP_O_B_On_Heat_H1C1_to_CoolOnly_C2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
#   	And user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "NONE COOL ONLY"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Other" with "0" heat and "2" cool stages in FA App
	

#9
  @Fuji_Thermostat_Verify_AdvancedSetup_CoolOnly_C2_to_Conv_HWFanCoil_H1C1
  Scenario: FUJICOM-14209_To verify Advanced Setup in Thermostat and in Mobile app_CoolOnly_C2_to_Conv_HWFanCoil_H1C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Other" with "0" heat and "2" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER FAN COIL"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES RCH" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
	
	
#10	
	@Fuji_Thermostat_Verify_AdvancedSetup_Conv_HWFanCoil_H1C1_to_Rad_HotWater_H2C1
  Scenario: FUJICOM-14210_To verify Advanced Setup in Thermostat and in Mobile app_ConvHWFanCoil_H1C1_to_Rad_HotWater_H2C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Electric Heat" with "1" heat and "1" cool stages in FA App
   	Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES RCH" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App
	
	
#11	
	@Fuji_Thermostat_Verify_AdvancedSetup_Rad_HotWater_H2C1_to_Conv_StdGas_H2C2
  Scenario: FUJICOM-14211_To verify Advanced Setup in Thermostat and in Mobile app_Rad_HotWater_H2C1_to_Conv_StdGas_H2C2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "GAS STANDARD EFFICIENCY"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
	
	
#12	
 	@Fuji_Thermostat_Verify_AdvancedSetup_Conv_StdGas_H2C2_to_HP_O_B_On_Heat_H2C1
  Scenario: FUJICOM-14212_ To verify Advanced Setup in Thermostat and in Mobile app_Conv_StdGas_H2C2_to_HP_O_B_On_Heat_H2C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	Then user verifies thermostat configuration as "Gas" with "2" heat and "2" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
	Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE B OB ON HEAT"
	#Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "2" // needed later
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App

	
#13	
	@Fuji_Thermostat_Verify_AdvancedSetup_HP_O_B_On_Heat_H2C1_to_Conv_Oil_H2C1
  Scenario: FUJICOM-14213_To verify Advanced Setup in Thermostat and in Mobile app_HP_O_B_On_Heat_H2C1_to_Conv_Oil_H2C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	And user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
	

#14
		@Fuji_Thermostat_Verify_AdvancedSetup_Conv_Oil_H2C1_to_HP_O_B_On_Cool_H1C1
  Scenario: FUJICOM-14214_To verify Advanced Setup in Thermostat and in Mobile app_Conv_Oil_H2C1_to_HP_O_B_On_Cool_H1C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	Then user verifies thermostat configuration as "Gas" with "2" heat and "1" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
	Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
	#Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1" // needed later- issue now
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "None"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "SETPOINT SHOWN ON IDLE SCREEN"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App	



#15
		 @Fuji_Thermostat_Verify_AdvancedSetup_HP_O_B_On_Cool_H1C1_to_Rad_HotWater_H2C2
  Scenario: FUJICOM-14215_To verify Advanced Setup in Thermostat and in Mobile app_HP_O_B_On_Cool_H1C1_to_Rad_HotWater_H2C2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
#   	And user verifies thermostat configuration as "Compressor Heat" with "1" heat and "1" cool stages in FA App
   	Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "BOILER"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "HOT WATER"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES RCH" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
#	Then Confirm ISU summary in FirstAlert APP
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
	
	
#16	
		@Fuji_Thermostat_Verify_AdvancedSetup_Rad_HotWater_H2C2_to_Conv_Oil_H2
  Scenario: FUJICOM-14216_To verify Advanced Setup in Thermostat and in Mobile app_Rad_HotWater_H2C2_to_Conv_Oil_H2
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	Then user verifies thermostat configuration as "Hydronic Heat" with "2" heat and "2" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "CONVENTIONAL FORCED AIR"
	Then Set configuration on First Alert APP ISUType "FUEL SOURCE RETAIL" to ISUValue "OIL"
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "NONE"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "2"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "CONTINUOUS"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "INDOOR HUMIDITY"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Gas" with "2" heat and "0" cool stages in FA App
	
	
#17

		@Fuji_Thermostat_Verify_AdvancedSetup_Conv_Oil_H2_to_HP_O_B_On_Cool_H2C1
  Scenario: FUJICOM-14217_To verify Advanced Setup in Thermostat and in Mobile app_Conv_Oil_H2_to_HP_O_B_On_Cool_H2C1
  	And user broadcast FUJI device for registration from "HOME" screen
   	Given user launches and logs in to the "first alert" app
   	Then user verifies thermostat configuration as "Gas" with "2" heat and "0" cool stages in FA App
    Then user select advanced setup in First alert APP
	Then Connect with Thermostat in "Ble" mode in First Alert App
	Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT"
	Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "HEAT PUMP"
	Then Set configuration on First Alert APP ISUType "REVERSING VALVE" to ISUValue "REVERSING VALVE O OB ON COOL"
	#Then Set configuration on First Alert APP ISUType "COMPRESSOR STAGES" to ISUValue "1" // needed later- issue now
	Then Set configuration on First Alert APP ISUType "COOLING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "HEATING STAGES" to ISUValue "1"
	Then Set configuration on First Alert APP ISUType "BACKUP HEAT" to ISUValue "ELECTRIC FORCED AIR"
	Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC"
	Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
	Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "40"
	Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
	Then Set configuration on First Alert APP ISUType "BACKLIGHTING" to ISUValue "ON DEMAND"
	Then Set configuration on First Alert APP ISUType "BACKLIGHT BRIGHTNESS" to ISUValue "5"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN SELECTION" to ISUValue "MINIMUM"
	Then Set configuration on First Alert APP ISUType "IDLE SCREEN CUSTOMIZATION" to ISUValue "TIME"
	Then Set configuration on First Alert APP ISUType "HOME SCREEN CUSTOMIZATION" to ISUValue "OUTDOOR TEMPERATURE"
	Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR"
	Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON"
	Then Confirm ISU summary in Retail Advance Setup in FirstAlert APP
	And user launches and logs in to the "first alert" app
	Then user verifies thermostat configuration as "Compressor Heat" with "2" heat and "1" cool stages in FA App
	

	
	

	
	