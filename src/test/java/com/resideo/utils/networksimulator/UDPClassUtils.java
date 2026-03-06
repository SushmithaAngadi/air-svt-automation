package com.resideo.utils.networksimulator;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

public class UDPClassUtils {
	static boolean runcommand = false;

	public static void activateInterval(final int totalExcecutionTime, int timePerExecution, TimeUnit timeUnit) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable runnable = new Runnable() {
			int countdownStarter = totalExcecutionTime;

			public void run() {
//				System.out.println(countdownStarter);
				countdownStarter--;

				if (countdownStarter < 1) {
//					System.out.println("Timer Over!");
					runcommand = true;
					scheduler.shutdown();
				}
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
	}

	public static void runCommand(final EchoClient echoClient, int LongRunTime, final String Message,int threadSleep) {
		for (int i = 0; i < LongRunTime; i++) {
			activateInterval(20, 1, TimeUnit.SECONDS);
			System.out.println("Initiating Network Traffic for 20 seconds");
			System.out.println("Network Traffic Started");
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofNanos(56000));
			fWait.withTimeout(Duration.ofSeconds(20));
			fWait.ignoring(TimeoutException.class);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {

						if (runcommand) {
							System.out.println("Network Traffic Finished");
							return true;
						} else {
							echoClient.sendEcho(Message);
							return false;
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						echoClient.sendEcho(Message);
						return true;
					}
				}
			});
			runcommand = false;
			try {
				System.out.println("Thread Sleep Activated for 40 seconds");
				Thread.sleep(threadSleep*1000);
				System.out.println("Thread Sleep Deactivated Sucessfully");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Completed Trial Number : " + (i+1));
		}

	}

}
