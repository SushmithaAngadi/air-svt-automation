package com.resideo.suiteExecutor;

import com.resideo.system.utils.SystemPerformanceTest;
import com.resideo.utils.networksimulator.EchoClient;

public class HighTrafficSimulator {

	public static void main(String[] args) {
		EchoClient client = new EchoClient("192.168.0.110", null, null, null, null);
		for (int i = 0; i < 10; i++) {
			SystemPerformanceTest.runCommand(null, client, 20, "HIHIHIHIHIHIHIHIHIH HIHIHIHIHIHIHI HIHIHIHIHIHIHIHIHIH HIHIHIHIHIHIHI HIHIHIHIHIHIHIHIHIH HIHIHIHIHIHIHI HIHIHIHIHIHIHIHIHIH HIHIHIHIHIHIHI HIHIHIHIHIHIHIHIHIH HIHIHIHIHIHIHI");
		}
//		for (int i = 0; i < 4; i++) {
////			String macID = "B82CA0FE0A08";
//			String macID = "48A2E67C9A53";
//			SchedulerMain._SchedulerJob(macID, 2000, 54, 5);
//			SchedulerMain.timer(Duration.ofMinutes(80));
//		}
//		

	}
}
