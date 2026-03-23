package com.resideo.system.utils;

public class AppSystemState {
	private static  String mailid=null;
	private static String password=null;
	private static  String passcode=null;
	private static  String username=null;
	
	
	public static void setmailID(String mail) {
		mailid=mail ;
	}
	public static String getmailID() {
		return mailid;
	}
	public static void setPassword(String Password) {
		password=Password ;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPasscode(String Passcode) {
		passcode=Passcode ;
	}
	public static String getPasscode() {
		return passcode;
	}
	public static void setUsername(String Username) {
		username=Username ;
	}
	public static String getUsername() {
		return username;
	}
}
