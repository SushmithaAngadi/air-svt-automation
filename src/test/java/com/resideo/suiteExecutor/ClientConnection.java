package com.resideo.suiteExecutor;

import java.time.Duration;

import com.resideo.system.scheduler.SchedulerMain;

public class ClientConnection {

	public static void main(String[] args) {
		
		for (int i = 0; i < 4; i++) {
//			String macID = "B82CA0FE0A08";
			String macID = "48A2E67C9A53";
			SchedulerMain._SchedulerJob(macID, 2000, 54, 5);
			SchedulerMain.timer(Duration.ofMinutes(80));
		}
		
		
	}
}
