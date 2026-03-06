package com.resideo.system.utils;

import java.util.HashMap;

public class FirstAlertSystemState {
	private static FirstAlertSystemState instance = null;

	private FirstAlertSystemState() {
	}

	public static FirstAlertSystemState getStatus() {
		if (instance == null)
			instance = new FirstAlertSystemState();
		return instance;
	}

/*
 * Jasper Device First Alert DIY Data
 */
	boolean isClickedFirstAlertAccountBtn = false;
	
	
	public void isClickedFirstAlertAccountBtn(boolean value) {
		this.isClickedFirstAlertAccountBtn = value;
	}

	public boolean isClickedFirstAlertAccountBtn() {
		return isClickedFirstAlertAccountBtn;
	}
	
	
	
	
}