package com.resideo.system.utils;

public class ResilientSleep {
	private static boolean isCriticalTask = true; // Hypothetical flag indicating task criticality

	public static void silentSleep(int totalSleepTime) {
//        int totalSleepTime = 30000; // Total time to sleep in milliseconds (30 seconds)
		long timeRemaining = totalSleepTime; // Initialize with total time to sleep
		long startTime = System.currentTimeMillis(); // Starting time
		while (true) {
			try {
				long timeElapsed = System.currentTimeMillis() - startTime; // Time already elapsed
				timeRemaining = totalSleepTime - timeElapsed; // Time remaining to sleep

				if (timeRemaining <= 0) {
					break; // Exit loop if the total time has elapsed
				}

				System.out.println("Sleeping for " + timeRemaining + " milliseconds...");
				Thread.sleep(timeRemaining); // Wait for the remaining time
			} catch (InterruptedException e) {
				System.out.println("Interrupted.");
				if (isCriticalTask) {
					System.out.println("Interrupted during a critical task. Adjusting for remaining sleep time...");
					// Adjust the start time based on the time already slept and continue the loop
					startTime = System.currentTimeMillis() - (totalSleepTime - timeRemaining);
				} else {
					System.out.println("Interrupted during a non-critical task. Exiting...");
					break;
				}
			}
		}

		System.out.println("Completed the designated sleep time.");
	}
}
