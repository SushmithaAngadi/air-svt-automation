package com.resideo.system.utils;

import java.util.HashMap;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileObject;
import com.resideo.commons.mobile.MobileUtils;

public class KeepAppActive extends Thread
{
	TestCases testcases1 = null;
	private volatile boolean exit = false;
	HashMap<String, MobileObject> fieldObjects;
	
	public KeepAppActive(TestCases testcase)
	{
		this.testcases1 = testcase;
	}
	
	public void run()
	{
		
		while(!exit)
		{			
			MobileUtils.isMobElementExists("id", "Passsword", testcases1, 5);
		}
		
	}
	
	public void requestStop()
	{
		exit = true;
	}
}
