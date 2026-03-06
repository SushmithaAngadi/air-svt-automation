package com.resideo.system.scheduler;

import java.time.Duration;
import java.util.Timer;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.api.dfc.CustomCommands;

public class SchedulerMain {

	public static String schedulerName;
	public static String afterRegistrationWaitTime;
	public static String afterUnregistrationWaitTime;
	public static boolean isRegistered;
	public static boolean isUnregistered;

	public static Timer time;
	public static ScheduledTask scheduler;

	public static int afterRegistrationCoolingTime;
	public static int afterUnRegistrationCoolingTime;
	static int scheduler_Timer;
	public static TestCases testCases;
	public static String macId;
	public static int fluentWaitTimer;
	public static String fluentWaitStopTime;
	public static boolean isFluentAssigned;


	public static void _SchedulerJob(TestCases testCase, String macID, int schedulerTimer, int reg_PoolTime,
			int unreg_poolTime) {
		
		try {
			isRegistered = false;
			isUnregistered = false;
			isFluentAssigned=false;
			testCases = testCase;
			macId = macID;
			scheduler_Timer = schedulerTimer;
			afterRegistrationCoolingTime = reg_PoolTime;
			afterUnRegistrationCoolingTime = unreg_poolTime;
			schedulerName = "registration cooling Period";
			afterRegistrationWaitTime = CustomCommands.getTime_Add(SchedulerMain.afterRegistrationCoolingTime);
			time = new Timer(); // Instantiate Timer Object
			scheduler = new ScheduledTask(); // Instantiate SheduledTask class
			time.schedule(scheduler, 0, scheduler_Timer); // Create Repetitively task for every 1 secs
			

		} catch (Exception e) {
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
		}
	}

	public static void _SchedulerJob(String macID, int schedulerTimer, int reg_PoolTime, int unreg_poolTime) {
		try {
			isFluentAssigned=false;
			isRegistered = false;
			isUnregistered = false;
			macId = macID;
			scheduler_Timer = schedulerTimer;
			afterRegistrationCoolingTime = reg_PoolTime;
			afterUnRegistrationCoolingTime = unreg_poolTime;
			schedulerName = "registration cooling Period";
			afterRegistrationWaitTime = CustomCommands.getTime_Add(SchedulerMain.afterRegistrationCoolingTime);
			time = new Timer(); // Instantiate Timer Object
			scheduler = new ScheduledTask(); // Instantiate SheduledTask class
			time.schedule(scheduler, 0, scheduler_Timer); // Create Repetitively task for every 1 secs

		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
		}
	}

	public static void timer(Duration dur) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(dur);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = CustomCommands.getCurrentTime();
						if (schedulerName.contains("Timer Stop")) {
							if (!isFluentAssigned) {
								fluentWaitStopTime = CustomCommands.getTime_Add(1);
								isFluentAssigned = true;
							}
							return false;
						} else if (currentTime.contains(fluentWaitStopTime)) {
							return true;
						} else {
							System.out.println(schedulerName);
							return false;
						}
					} catch (TimeoutException e) {
						return false;
					} catch (StaleElementReferenceException e) {
						return false;

					} catch (Exception e) {
						return false;
					}
				}
			});
			System.out.println(isEventReceived);
		} catch (Exception e) {
			if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
				Thread.currentThread().interrupt();
				System.out.println("Intereupted the execution");
				System.out.println("Exception occured due to " + e.getMessage());
			}
		}
	}

	public static void timer(TestCases testCase, Duration dur) {
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(30));
			fWait.withTimeout(dur);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = CustomCommands.getCurrentTime();
						if (schedulerName.contains("Timer Stop")) {
							if (!isFluentAssigned) {
								fluentWaitStopTime = CustomCommands.getTime_Add(1);
								isFluentAssigned = true;
							}
							return false;
						} else if (currentTime.contains(fluentWaitStopTime)) {
							return true;
						} else {
							return false;

						}
					} catch (NullPointerException e) {
						System.out.println("null pointer");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, e.getMessage());
						return false;

					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
						return false;
					}
				}
			});
			
			
			System.out.println(isEventReceived);
		} catch (Exception e) {
			if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
				Thread.currentThread().interrupt();
				System.out.println("Intereupted the execution");
				Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
			}
		}
	}

}
