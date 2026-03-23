package com.resideo.utils.networksimulator;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.stat.StatCommonCommandUtils;

public class DHCPConnect {

//	public static boolean 

	public static void ChangeSetpointFromAPI_MobileApp(TestCases testCase, String mobile_API) {
		boolean flag = false;
		if (mobile_API != null && mobile_API.toUpperCase().contains("API")) {

		} else {
//			if()

		}

	}

	public static void getScreenShotFromRouterDHCPList(TestCases testCase, String RouterName) {

	}

	public static void startListeningWifiLogToConfirmDataExists() {

		
		
	}

	public static boolean changeSetPointChangeFromStat(TestCases testCase, String mode, float setpoint) {
		return StatCommonCommandUtils.setPoint_Heat_Cool(testCase, mode, setpoint);
	}
	
	
	

}
