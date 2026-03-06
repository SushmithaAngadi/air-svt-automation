package com.resideo.utils.relay;

import java.util.HashMap;

import com.fazecast.jSerialComm.SerialPort;

public class WireSensingRelayConstant {

	protected static SerialPort port = null;
	protected static String G_Relay_ON = "Relay_22:ON";
	protected static String G_Relay_OFF = "Relay_22:OFF";
	protected static String Y_Relay_ON = "Relay_23:ON";
	protected static String Y_Relay_OFF = "Relay_23:OFF";
	protected static String K_Relay_ON = "Relay_24:ON";
	protected static String K_Relay_OFF = "Relay_24:OFF";
	protected static String W_AUX_Relay_ON = "Relay_25:ON";
	protected static String W_AUX_Relay_OFF= "Relay_25:OFF";
	protected static String Y2_Relay_ON = "Relay_26:ON";
	protected static String Y2_Relay_OFF = "Relay_26:OFF";
	protected static String W_Relay_ON = "Relay_27:ON";
	protected static String W_Relay_OFF = "Relay_27:OFF";
	protected static String O_B_Relay_ON = "Relay_28:ON";
	protected static String O_B_Relay_OFF = "Relay_28:OFF";
	protected static String U_Relay_ON = "Relay_29:ON";
	protected static String U_Relay_OFF = "Relay_29:OFF";
	protected static String L_Relay_ON = "Relay_30:ON";
	protected static String L_Relay_OFF = "Relay_30:OFF";
	protected static String Thermostat_Relay_ON = "Relay_31:ON";
	protected static String Thermostat_Relay_OFF = "Relay_31:OFF";
	protected static String Sensor1_Relay_ON = "Relay_32:ON";
	protected static String Sensor1_Relay_OFF = "Relay_32:OFF";
	protected static String Sensor2_Relay_ON = "Relay_33:ON";
	protected static String Sensor2_Relay_OFF = "Relay_33:OFF";
	protected static String Sensor3_Relay_ON = "Relay_34:ON";
	protected static String Sensor3_Relay_OFF = "Relay_34:OFF";
	protected static String Sensor4_Relay_ON = "Relay_35:ON";
	protected static String Sensor4_Relay_OFF = "Relay_35:OFF";
	protected static String Sensor5_Relay_ON = "Relay_36:ON";
	protected static String Sensor5_Relay_OFF = "Relay_36:OFF";
	
	
	/*
	 * WireSensing Relay Constant Method
	 * 
	 * According to System Type and Stage it will Execute from Starting Wire sensing
	 */
	
//	protected static String[] ConventionalInvalid= {"Y2_W2","Y2_W2_G","Y_Y2_W2_G","Y2_W_W2_G","Y_Y2_W_W2"};
////	protected static String Conventional1H1C=""
//	protected static String[] HeatPumpInvalid= {"Y_Y2_W_W2","G_Y_W2", "G_Y2_W" ,"G_Y_Y2","G_Y_Y2_W2","G_Y_W_W2", "G_W_W2"};
//	protected static String HeatPump1H1C="";
	
	
	protected static HashMap<String, String> InvalidWireSensing(String SysytemType){
		
		HashMap<String, String> hs = new HashMap<String, String>();
		
		
		return hs;
		
	}
	
	
	
	
}
