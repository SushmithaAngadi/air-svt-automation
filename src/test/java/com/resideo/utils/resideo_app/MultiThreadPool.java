package com.resideo.utils.resideo_app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileObject;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.WebObjectLocators;
import com.resideo.system.utils.CommonState;
import com.resideo.system.utils.CommonUtils;
import com.resideo.system.utils.SystemPerformanceTest;

public class MultiThreadPool extends Thread {
	TestCases testcases1 = null;
	private volatile boolean exit = false;
	HashMap<String, MobileObject> fieldObjects;

	public MultiThreadPool(TestCases testcase) {
		this.testcases1 = testcase;
	}

	public void run() {

		while (!exit) {
//			
//			if(CommonState.isMobileDriverNeedtoAwake()) {
//				MobileUtils.isMobElementExists("ID", "My DAy", testcases1);
//			}
//			
			
			
		}

	}

	public void requestStop() {
		exit = true;
	}
}
