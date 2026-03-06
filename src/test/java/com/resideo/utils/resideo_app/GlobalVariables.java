package com.resideo.utils.resideo_app;

public class GlobalVariables {
    
    public static final String LOCATION_SERVICES = "adb shell settings put secure location_providers_allowed network";
    
    public static String forceStopApp="adb shell am force-stop com.resideo.acs.startapp";
    
    public static String FAHRENHEIT="Fahrenheit";
    
    public static final String CELSIUS = "Celsius"; 
    
    public static final String RelayURL="192.168.1.4/30000/";
  
}
