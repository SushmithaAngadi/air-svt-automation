package com.resideo.system.utils;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.utils.networksimulator.EchoClient;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;

public class MultiThreadRunning {

	TestCases testcases1 = null;

//	private volatile boolean exit = false;
//	HashMap<String, MobileObject> fieldObjects;
//
	public MultiThreadRunning(TestCases testcase) {
		this.testcases1 = testcase;
	}

	public class NetworkTraffic implements Runnable {
		public EchoClient echoClient;
		int longRunTime;
		String Message;
		int coolingTimeInSeconds;
		private volatile boolean exit = false;

		public NetworkTraffic(EchoClient echoClient, int longRuntime, String Message, int coolingTimeInSecond) {
			this.echoClient = echoClient;
			this.longRunTime = longRuntime;
			this.Message = Message;
			this.coolingTimeInSeconds = coolingTimeInSecond;
		}

		@Override
		public void run() {
//			System.out.println("................................................t");
			while (!exit) {
//				System.out.println("................................................t");
//				System.out.println("High traffic Code Started");
				try {
					SystemPerformanceTest.runCommand(testcases1, echoClient, longRunTime, Message,
							coolingTimeInSeconds);
				} catch (Exception e) {
					System.out.println(
							"Exception raised in class name NetworkTraffic, exception due to  " + e.getStackTrace());
					SystemPerformanceTest.runCommand(testcases1, echoClient, longRunTime, Message,
							coolingTimeInSeconds);
				}
			}
		}

		public void requestStop() {
			exit = true;
		}

	}

	public class ThreadInitializeOnCondition implements Runnable {
		private volatile boolean exit = false;

		@Override
		public void run() {

			while (!exit) {
				try {
					if (CommonState.getStatus().isMobileDriverNeedtoWait()) {
						MobileUtils.isMobElementExists("ID", "My DAy", testcases1);
					}
				} catch (Exception e) {
					System.out.println("Exception raised in Method name ThreadInitializeOnCondition, exception due to  "
							+ e.getStackTrace());
					MobileUtils.isMobElementExists("ID", "My DAy", testcases1);
				}
			}

		}

		public void requestStop() {
			exit = true;
		}
	}

	public class GetDataBeforeNextTrailStart implements Runnable {
		private volatile boolean exit = false;
		TestCases testCase;
		PrimaryCardScreen pm;

		public GetDataBeforeNextTrailStart(TestCases testCase, PrimaryCardScreen pm) {
			this.testCase = testCase;
			this.pm = pm;
		}

		@Override
		public void run() {
			while (!exit) {

				if (CommonState.getStatus().isTimeForDataCollect_beforeTrailStart()) {
					CommonUtils.getCurrentRunningSetPointFromBothEnd_WithMode(testCase, pm);
					CommonState.getStatus().isTimeForDataCollect_beforeTrailStart(false);
				}

			}
		}

		public void requestStop() {
			exit = true;
		}
	}

}