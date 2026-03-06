		@Denali_Feature_DIY_FanCoil_HomeScreen 
		Feature: Denali_DIY_FanCoil_HomeScreen 
		
		
		# Set 1 : Denali_Feature_DIY_FanCoil_1H1C_4PipeFanCoil_HomeScreen
			
			
		@Denali_Trade_DIY_1_FromHomeScreen_FanCoil_4_PipeFanCoil_1H1C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6299
		Scenario: Denali_6299_Trade_DIY_1_FromHomeScreen_FanCoil_4_PipeFanCoil_1H1C_ConfigureISU_ConfigureWiFi 
			
			
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI" 
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
					
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "4 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "MEDIUM SPEED WIRING" to ISUValue "THERMOSTAT Y2" 
			Then Set configuration on First Alert APP ISUType "HIGH SPEED WIRING" to ISUValue "THERMOSTAT U"
			 
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND MULTIPLE SPEED" 
			Then Set configuration on First Alert APP ISUType "START FAN ON HIGH SPEED" to ISUValue "DISABLED" 
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
			 
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "4 PIPE FAN COIL" with "1" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
		
		# Set 2 : Denali_Feature_DIY_FanCoil_1H1C_2H1C_2PipeFanCoil_HomeScreen
		
		@Denali_Trade_DIY_1_FromHomeScreen_FanCoil_2PipeFanCoil_10K_Sensor_1H1C_1_BackupHeat_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6300
		Scenario: Denali_6300_Trade_DIY_1_FromHomeScreen_FanCoil_2PipeFanCoil_10K_Sensor_1H1C_1_BackupHeat_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			
 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "2 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR" to ISUValue "10K SENSOR" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR WIRING" to ISUValue "THERMOSTAT S" 
			Then Set configuration on First Alert APP ISUType "Fan Coil Stages" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "Backup Heat Stages" to ISUValue "1" 
			
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "MEDIUM SPEED WIRING" to ISUValue "THERMOSTAT Y2" 

			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG" 
			
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9" 
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"
			
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND MULTIPLE SPEED" 
			Then Set configuration on First Alert APP ISUType "START FAN ON HIGH SPEED" to ISUValue "DISABLED"
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE"
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "FAN COIL CHANGEOVER TEMPERATURE SENSOR" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "Pipe Sensor Threshold for Cooling" to ISUValue "60" 
			Then Set configuration on First Alert APP ISUType "Pipe Sensor Threshold for Heating" to ISUValue "80" 
			
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "2 PIPE FAN COIL" with "2" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
		
		
		
		@Denali_Trade_DIY_2_FromHomeScreen_FanCoil_2PipeFanCoil_20K_Sensor_1H1C_No_BackupHeat_ConfigureISU_SkipWiFi
		@--xrayid:DENALI-6301
		Scenario: Denali_6301_Trade_DIY_2_FromHomeScreen_FanCoil_2PipeFanCoil_20K_Sensor_1H1C_No_BackupHeat_ConfigureISU_SkipWiFi 
			
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			
			
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "2 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR" to ISUValue "20K SENSOR" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR WIRING" to ISUValue "THERMOSTAT S" 
			
			Then Set configuration on First Alert APP ISUType "Fan Coil Stages" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "Backup Heat Stages" to ISUValue "None" 
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "3"
			Then Set configuration on First Alert APP ISUType "MEDIUM SPEED WIRING" to ISUValue "THERMOSTAT Y2"
			Then Set configuration on First Alert APP ISUType "HIGH SPEED WIRING" to ISUValue "THERMOSTAT U" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3"" 
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND MULTIPLE SPEED" 
			Then Set configuration on First Alert APP ISUType "START FAN ON HIGH SPEED" to ISUValue "DISABLED" 
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "FAN COIL CHANGEOVER TEMPERATURE SENSOR" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "Pipe Sensor Threshold for Cooling" to ISUValue "60" 
			Then Set configuration on First Alert APP ISUType "Pipe Sensor Threshold for Heating" to ISUValue "80"
			
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "2 PIPE FAN COIL" with "1" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
		
		
		
		@Denali_Trade_DIY_3_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Cool_1H1C_1_BackUpHeat_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6302
		Scenario: Denali_6302_Trade_DIY_3_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Cool_1H1C_1_BackUpHeat_ConfigureISU_ConfigureWiFi 
		
		
			Given user launches and logs in to the "first alert" app 
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			

			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO"
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET"
			 
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL"     
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "2 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR" to ISUValue "DRY CONTACT SWITCH" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACT SWITCH" to ISUValue "OPEN IN COOL" 
			
			Then Set configuration on First Alert APP ISUType "FAN COIL STAGES" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT STAGES" to ISUValue "1"
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "MEDIUM SPEED WIRING" to ISUValue "THERMOSTAT Y2" 
			Then Set configuration on First Alert APP ISUType "HIGH SPEED WIRING" to ISUValue "THERMOSTAT U" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG"
			
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 			
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9"
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5"	
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND MULTIPLE SPEED" 
			Then Set configuration on First Alert APP ISUType "START FAN ON HIGH SPEED" to ISUValue "DISABLED" 
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE"   
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
#			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "88"
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
#			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "55"
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "2 PIPE FAN COIL" with "2" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
		@Denali_Trade_DIY_4_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Heat_1H1C_1_BackUpHeat_ConfigureISU_SKIPWiFi
		@--xrayid:DENALI-6303 
		Scenario: Denali_6303_Trade_DIY_4_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Heat_1H1C_1_BackUpHeat_ConfigureISU_SKIPWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			

			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "2 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR" to ISUValue "DRY CONTACT SWITCH" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACT SWITCH" to ISUValue "OPEN IN HEAT"
			 
			Then Set configuration on First Alert APP ISUType "Fan Coil Stages" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "Backup Heat Stages" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "MEDIUM SPEED WIRING" to ISUValue "THERMOSTAT Y2" 
			Then Set configuration on First Alert APP ISUType "HIGH SPEED WIRING" to ISUValue "THERMOSTAT U" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT DIFFERENTIAL" to ISUValue "2 DEG" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT CYCLES PER HOUR" to ISUValue "9" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND MULTIPLE SPEED" 
			Then Set configuration on First Alert APP ISUType "START FAN ON HIGH SPEED" to ISUValue "DISABLED" 
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF"
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			Then First Alert app wifi "SKIP" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "2 PIPE FAN COIL" with "2" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
			
		@Denali_Trade_DIY_5_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Cool_1H1C_No_BackUpHeat_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6304
		Scenario: Denali_6304_Trade_DIY_5_FromHomeScreen_FanCoil_2PipeFanCoil_Dry_Contact_Switch_Open_In_Cool_1H1C_No_BackUpHeat_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			

			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "2 PIPE FAN COIL" 
			Then Set configuration on First Alert APP ISUType "CHANGEOVER SENSOR" to ISUValue "DRY CONTACT SWITCH" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACT SWITCH" to ISUValue "OPEN IN COOL"
			
			Then Set configuration on First Alert APP ISUType "Fan Coil Stages" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "Backup Heat Stages" to ISUValue "None" 
			Then Set configuration on First Alert APP ISUType "FAN STAGES" to ISUValue "1" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "4" 

			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "ALLOWED FAN MODES" to ISUValue "AUTO AND ON" 
			Then Set configuration on First Alert APP ISUType "FAN RESET TIMER" to ISUValue "INACTIVE"
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES"
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF"
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "2 PIPE FAN COIL" with "1" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
			
			# Set 3 : Denali_Feature_DIY_FanCoil_1H1C_HWFanCoil_HomeScreen
			
			@Denali_Trade_DIY_1_FromHomeScreen_FanCoil_HWFanCoil_2H4C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6305
		Scenario: Denali_6305_Trade_DIY_1_FromHomeScreen_FanCoil_HWFanCoil_2H4C_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app 
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			

			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "4"
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "COOL STAGE 3 WIRING" to ISUValue "THERMOSTAT L"
			Then Set configuration on First Alert APP ISUType "COOL STAGE 4 WIRING" to ISUValue "THERMOSTAT U"
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 2 Differential" to ISUValue "COMFORT"
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 3 Differential" to ISUValue "COMFORT"
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 4 Differential" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 3" to ISUValue "3"
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 4" to ISUValue "3"
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "2" heat and "4" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
		
			
		@Denali_Trade_DIY_2_FromHomeScreen_FanCoil_HWFanCoil_2H1C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6306
		Scenario: Denali_6306_Trade_DIY_2_FromHomeScreen_FanCoil_HWFanCoil_2H1C_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 2" to ISUValue "COMFORT" 
			
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "2" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
		@Denali_Trade_DIY_3_FromHomeScreen_FanCoil_HWFanCoil_3H1C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6307
		Scenario: Denali_6307_Trade_DIY_3_FromHomeScreen_FanCoil_HWFanCoil_3H1C_ConfigureISU_ConfigureWiFi 
			
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 			
			
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE 3 WIRING" to ISUValue "THERMOSTAT U" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 			
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 2" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 3" to ISUValue "COMFORT"
			 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 3" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "3" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
		@Denali_Trade_DIY_4_FromHomeScreen_FanCoil_HWFanCoil_3H2C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6308
		Scenario: Denali_6308_Trade_DIY_4_FromHomeScreen_FanCoil_HWFanCoil_3H2C_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			

			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE 3 WIRING" to ISUValue "THERMOSTAT U" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 2 Differential" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 2" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 3" to ISUValue "COMFORT" 
			
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 3" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "3" heat and "2" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
		@Denali_Trade_DIY_5_FromHomeScreen_FanCoil_HWFanCoil_2H2C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6309
		Scenario: Denali_6309_Trade_DIY_5_FromHomeScreen_FanCoil_HWFanCoil_2H2C_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI" 
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			
 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "2" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 2 Differential" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 2" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 	
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "2" heat and "2" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			@Denali_Trade_DIY_6_FromHomeScreen_FanCoil_HWFanCoil_3H3C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6310
		Scenario: Denali_6310_Trade_DIY_6_FromHomeScreen_FanCoil_HWFanCoil_3H3C_ConfigureISU_ConfigureWiFi 
		
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
			
			
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "EQUIPMENT TYPE" to ISUValue "HOT WATER - FAN COIL" 
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL STAGE 3 WIRING" to ISUValue "THERMOSTAT U"
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE 3 WIRING" to ISUValue "THERMOSTAT L" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "COOL STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "HEAT STAGING CONTROL" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 2 Differential" to ISUValue "COMFORT"

			Then Set configuration on First Alert APP ISUType "Staging Control - Cool Stage 3 Differential" to ISUValue "COMFORT"
			Then Set configuration on First Alert APP ISUType "STAGING CONTROL - FAN COIL HEAT DIFFERENTIAL STAGE 2" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "Staging Control - Fan Coil Heat Differential Stage 3" to ISUValue "COMFORT" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF"
			 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 3" to ISUValue "3"
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 2" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 3" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "3" heat and "3" cool stages in FA App 
			Then Delete registered device from First alert APP 
			
			
			@Denali_Trade_DIY_7_FromHomeScreen_FanCoil_HWFanCoil_1H1C_ConfigureISU_ConfigureWiFi
		@--xrayid:DENALI-6311
		Scenario: Denali_6311_Trade_DIY_7_FromHomeScreen_FanCoil_HWFanCoil_1H1C_ConfigureISU_ConfigureWiFi 
			
			Given user launches and logs in to the "first alert" app
			Given user runs "MQTT" command "factory reset without WIFI"
			Given user broadCast the device from "Home Screen" 
			Then Add new device to Configure in First Alert App 
			Then Setup Device "Location and name" for DIY 
			Then Perform initial installation setup for "BLE" mode in First Alert APP 
			Then Connect with Thermostat in "Ble" mode in First Alert App 
			Then First Alert app "always" configure the ISU, is device factory reset "NO" 
				
			Then Set configuration on First Alert APP ISUType "TEMPERATURE SCALE" to ISUValue "FAHRENHEIT" 
			Then Set configuration on First Alert APP ISUType "FLOOR SENSOR" to ISUValue "NO" 
			Then Set configuration on First Alert APP ISUType "OUTDOOR AIR" to ISUValue "INTERNET" 
			
			Then Set configuration on First Alert APP ISUType "HEATING SYSTEM" to ISUValue "FAN COIL" 
			Then Set configuration on First Alert APP ISUType "Equipment Type" to ISUValue "HOT WATER - FAN COIL" 			
			Then Set configuration on First Alert APP ISUType "COOL STAGES" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT STAGE" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "FAN OPERATION IN HEAT" to ISUValue "THERMOSTAT CONTROLS FAN" 
			Then Set configuration on First Alert APP ISUType "BACKUP HEAT TYPE" to ISUValue "NONE"
			
			Then Set configuration on First Alert APP ISUType "OCCUPANCY SENSING" to ISUValue "NO REMOTE SETBACK" 
			Then Set configuration on First Alert APP ISUType "SYSTEM CHANGEOVER" to ISUValue "AUTOMATIC" 
			Then Set configuration on First Alert APP ISUType "AUTO CHANGEOVER DIFFERENTIAL" to ISUValue "0 DEG" 
			Then Set configuration on First Alert APP ISUType "LOCKOUT FAN AFTER A COOL CALL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "COOL CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			Then Set configuration on First Alert APP ISUType "FAN COIL HEAT CYCLES PER HOUR-STAGE 1" to ISUValue "3" 
			
			Then Set configuration on First Alert APP ISUType "COMPRESSOR PROTECTION" to ISUValue "5" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN COOL" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "EXTENDED FAN RUN TIME IN HEAT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "TEMPERATURE BALANCING" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "ADAPTIVE INTELLIGENT RECOVERY" to ISUValue "YES" 
			
			Then Set configuration on First Alert APP ISUType "MAXIMUM COOL SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM COOL SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "MAXIMUM HEAT SETPOINT" to ISUValue "90" 
			Then Set configuration on First Alert APP ISUType "MINIMUM HEAT SETPOINT" to ISUValue "50" 
			Then Set configuration on First Alert APP ISUType "HIGH TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW TEMPERATURE ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "HIGH HUMIDITY ALERT" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "LOW HUMIDITY ALERT" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "WIRED SENSORS" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "FREEZE PROTECTION" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 1" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "DRY CONTACTS 2" to ISUValue "" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER TYPE" to ISUValue "MEDIA" 
			Then Set configuration on First Alert APP ISUType "NUMBER OF AIR FILTERS" to ISUValue "1" 
			Then Set configuration on First Alert APP ISUType "AIR FILTER 1 REPLACEMENT REMINDER" to ISUValue "OFF" 
			
			Then Set configuration on First Alert APP ISUType "HUMIDIFIER TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "HUMIDIFICATION PAD REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFICATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "DEHUMIDIFIER FILTER REPLACEMENT REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "VENTILATION TYPE" to ISUValue "NONE" 
			Then Set configuration on First Alert APP ISUType "VENTILATION FILTER CLEANING REMINDER" to ISUValue "OFF" 
			Then Set configuration on First Alert APP ISUType "UV DEVICES" to ISUValue "0" 
			
			Then Set configuration on First Alert APP ISUType "CLOCK FORMAT" to ISUValue "12 HOUR" 
			Then Set configuration on First Alert APP ISUType "DAYLIGHT SAVING TIME" to ISUValue "ON" 
			Then Set configuration on First Alert APP ISUType "INDOOR TEMPERATURE DISPLAY OFFSET" to ISUValue "0.0DEG F" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY DISPLAY OFFSET" to ISUValue "0%" 
			Then Set configuration on First Alert APP ISUType "INDOOR HUMIDITY" to ISUValue "YES" 
			Then Confirm ISU summary in FirstAlert APP 
			
			Then First Alert app wifi "ALWAYS" configure the wifi with "CORRECT Password", is device factory reset "NO" 
			Then user verifies for data synch after registration on First Alert APP 
			And user verifies thermostat configuration as "ELECTRIC HEAT" with "1" heat and "1" cool stages in FA App 
			Then Delete registered device from First alert APP 
		