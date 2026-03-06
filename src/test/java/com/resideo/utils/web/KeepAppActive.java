package com.resideo.utils.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileObject;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.WebObjectLocators;
import com.resideo.system.utils.CommonUtils;

public class KeepAppActive extends Thread {
	TestCases testcases1 = null;
	private volatile boolean exit = false;
	HashMap<String, MobileObject> fieldObjects;

	public KeepAppActive(TestCases testcase) {
		this.testcases1 = testcase;
	}

	public void run() {

		while (!exit) {
			if (CommonUtils.getStatus().isMobileThread()) {
				MobileUtils.isMobElementExists("id", "Passsword", testcases1, 5);
			}
			if (CommonUtils.getStatus().isWebThread()) {
				WebUtils.isWebElementExists(testcases1, WebObjectLocators.By_ID, "PasswordNull");

			}
			if (CommonUtils.getStatus().isSetpointThread()) {
				String currenttime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
				System.out.println("end time :" + CommonUtils.getDatatime() + "epected current time :" + currenttime);
				if (CommonUtils.getDatatime().equals(currenttime)) {
					CommonUtils.StatSetpointThread();
					CommonUtils.setDataTime(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
							.format(LocalDateTime.now().plusSeconds(2)));
				}
			}
		}

	}

	public void requestStop() {
		exit = true;
	}
}
