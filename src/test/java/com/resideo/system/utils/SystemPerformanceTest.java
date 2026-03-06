package com.resideo.system.utils;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.networksimulator.EchoClient;

public class SystemPerformanceTest {

//	TImer related variables
	static long startTimer = 0;
	static long endTimer = 0;

	public static long startTimer() {
		return startTimer = System.currentTimeMillis();
	}

	public static long totalTimer() {
		return (endTimer = System.currentTimeMillis()) - startTimer;
	}

	public static long endTimer() {
		return endTimer;
	}

//	Thread Methods for Individual Scenario
	public static void checkChangesFromStatAndApp(final int totalExcecutionTime, int timePerExecution,
			TimeUnit timeUnit) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable runnable = new Runnable() {
			int countdownStarter = totalExcecutionTime;

			public void run() {
				try {
					countdownStarter--;
					if (countdownStarter < 1) {
//					System.out.println("Start ReCheck setpoint/mode from app/stat");
						CommonState.getStatus().reVerifyCheckSumAgainstChanges(true);
						scheduler.shutdown();
					}
				} catch (Exception e) {
					System.out.println(
							"Method name is checkChangesFromStatAndApp, Exception raised due to " + e.getMessage());
					CommonState.getStatus().reVerifyCheckSumAgainstChanges(true);
					scheduler.shutdown();
				}
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
	}

	public static void checktimeClose(final int totalExcecutionTime, int timePerExecution, TimeUnit timeUnit) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable runnable = new Runnable() {
			int countdownStarter = totalExcecutionTime;

			public void run() {
				try {
					countdownStarter--;
					if (countdownStarter < 1) {
						System.out.println("Start ReCheck setpoint/mode from app/stat");
						CommonState.getStatus().isWaitingTimerClose(true);
						scheduler.shutdown();
					}

					if (countdownStarter == 10) {
						CommonState.getStatus().isTimeForDataCollect_beforeTrailStart(true);
					}
				} catch (Exception e) {
					System.out.println("Method name is checktimeClose, Exception raised due to " + e.getMessage());
					CommonState.getStatus().isWaitingTimerClose(true);
					scheduler.shutdown();
				}
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
	}

	public static void runHighTrafficTimer(final int totalExcecutionTime, int timePerExecution, TimeUnit timeUnit,
			String traffic_nonTraffic) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable runnable = new Runnable() {
			int countdownStarter = totalExcecutionTime;

			public void run() {
				try {
					countdownStarter--;
					if (traffic_nonTraffic.equals("RUN")) {
						CommonState.getStatus().isTrafficStarted(true);
						if (countdownStarter < 1) {
							CommonState.getStatus().isTrafficStarted(false);
							CommonState.getStatus().isTrafficStop(true);
							scheduler.shutdown();
						}
					} else if (traffic_nonTraffic.equals("COOLING")) {
						CommonState.getStatus().isNonTrafficCoolingStarted(true);
						if (countdownStarter < 1) {
							CommonState.getStatus().isNonTrafficCoolingStarted(false);
							CommonState.getStatus().isCoolingPeriodStop(true);
							scheduler.shutdown();
						}
					}
				} catch (Exception e) {
					System.out.println("Method name is checktimeClose, Exception raised due to " + e.getMessage());
					if (traffic_nonTraffic.equals("RUN")) {
						CommonState.getStatus().isTrafficStarted(true);
						CommonState.getStatus().isTrafficStarted(false);
						CommonState.getStatus().isTrafficStop(true);
						scheduler.shutdown();
					} else if (traffic_nonTraffic.equals("COOLING")) {
						CommonState.getStatus().isNonTrafficCoolingStarted(true);
						CommonState.getStatus().isNonTrafficCoolingStarted(false);
						CommonState.getStatus().isCoolingPeriodStop(true);
						scheduler.shutdown();
					}
				}
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
	}

	public static boolean runHighTrafficFluentThread(TestCases testCase, Duration TimeOutDuration, Duration PoolingTime,
			String Run_Cooling, final EchoClient echoClient, String messagebytes) {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(PoolingTime);
			fWait.withTimeout(TimeOutDuration);
			fWait.ignoring(TimeoutException.class);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (Run_Cooling.equals("RUN")) {
							if (CommonState.getStatus().isTrafficStop()) {
								System.out.println("Traffic End");
								return true;
							} else {
								echoClient.sendEcho(messagebytes);
								return false;
							}
						} else {

							if (CommonState.getStatus().isCoolingPeriodStop()) {
								System.out.println("Cooling Period Stoped");
								return true;
							} else {
								return false;
							}

						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						echoClient.sendEcho(messagebytes);
						return true;
					}
				}
			});
			flag = isEventReceived;

		} catch (Exception e) {
//			System.out.println("Method Name  runHighTrafficFluentThread, exception caused due to " + e.getMessage());
			flag = false;
//			Thread.currentThread().interrupt(); // Here!
//			throw new RuntimeException(e);
		}
		return flag;
	}

	public static boolean waitTraffic_nonTrafficUpdate(TestCases testCase, Duration TimeOutDuration,
			Duration PoolingTime, String traffic_nontraffic) throws InterruptedException {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(PoolingTime);
			fWait.withTimeout(TimeOutDuration);
			fWait.ignoring(TimeoutException.class);
			fWait.ignoring(InterruptedException.class);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (traffic_nontraffic.equals("TRAFFIC")) {
							if (CommonState.getStatus().isTrafficStarted()) {
								TrailData.getStatus().trafficStartTime(String.valueOf(System.currentTimeMillis()));
								return true;
							} else {
								return false;
							}

						} else {
							if (CommonState.getStatus().isNonTrafficCoolingStarted()) {
								TrailData.getStatus().trafficStartTime(String.valueOf(System.currentTimeMillis()));
								return true;
							} else {
								return false;
							}

						}

					} catch (Exception e) {
						System.out.println(
								"Method Name inside fluent waitTraffic_nonTrafficUpdate, exception caused due to "
										+ e.getStackTrace());
						return true;
					}
				}
			});
			flag = isEventReceived;

		} catch (Exception e) {
			System.out
					.println("Method Name waitTraffic_nonTrafficUpdate, exception caused due to " + e.getStackTrace());
			flag = false;
//			Thread.currentThread().interrupt(); // Here!
//			throw new RuntimeException(e);
			waitTraffic_nonTrafficUpdate(testCase, TimeOutDuration, PoolingTime, traffic_nontraffic);
		}
		return flag;
	}

	public static boolean threadForWaitingForRevertBack(TestCases testCase, Duration TimeOutDuration,
			Duration PoolingTime) {
		boolean flag = false;
		try {
			CommonState.getStatus().reVerifyCheckSumAgainstChanges(false);
			checkChangesFromStatAndApp(15, 1, TimeUnit.SECONDS);
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(PoolingTime);
			fWait.withTimeout(TimeOutDuration);
			fWait.ignoring(TimeoutException.class);
			fWait.ignoring(InterruptedException.class);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						if (CommonState.getStatus().reVerifyCheckSumAgainstChanges()) {
							System.out.println("Relaxation changes stoped");
							return true;
						} else {
							System.out.println("setpoint/mode Relaxation changes started, will wait for 15 seconds");
							return false;
						}
					} catch (Exception e) {
						System.out.println(
								"Method Name is inside fluent threadForWaitingForRevertBack; Exception raised due to "
										+ e.getMessage());
						return false;
					}
				}
			});
			flag = isEventReceived;

		} catch (Exception e) {

			System.out.println(
					"Method Name is threadForWaitingForRevertBack; Exception raised due to " + e.getStackTrace());
			flag = false;
			Thread.currentThread().interrupt(); // Here!
			throw new RuntimeException(e);
		}
		return flag;
	}

	public static boolean threadForWaitingNextTrailToStart(TestCases testCase, Duration TimeOutDuration,
			Duration PoolingTime, long UntilTime) throws InterruptedException {
		boolean flag = false;
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(PoolingTime);
			fWait.withTimeout(TimeOutDuration);
			fWait.ignoring(TimeoutException.class);
			fWait.ignoring(InterruptedException.class);
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean driver) {
					try {
						long currentTimeMillis = System.currentTimeMillis();
						if (currentTimeMillis > UntilTime) {
							return true;
						} else {
							return false;
						}
					} catch (Exception e) {
						System.out.println(
								"line no 252; Method Name is inside fluent threadForWaitingNextTrailToStart; Exception raised due to "
										+ e.getMessage());
						return true;
					}
				}
			});
			flag = isEventReceived;

		} catch (Exception e) {
			System.out.println("line no 260,Method Name is threadForWaitingNextTrailToStart; Exception raised due to "
					+ e.getMessage());
			flag = false;
			Thread.currentThread().interrupt(); // Here!
//			throw new RuntimeException(e);threadForWaitingNextTrailToStart
			threadForWaitingNextTrailToStart(testCase, TimeOutDuration, PoolingTime, UntilTime);
		}
		return flag;
	}

//	public static boolean threadForTimerClose(TestCases testCase, Duration TimeOutDuration, Duration PoolingTime) {
//		boolean flag = false;
//		try {
//			CommonState.getStatus().isWaitingTimerClose(false);
////			checktimeClose(15, 1, TimeUnit.SECONDS);
//			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//			fWait.pollingEvery(PoolingTime);
//			fWait.withTimeout(TimeOutDuration);
//			fWait.ignoring(TimeoutException.class);
//			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//				public Boolean apply(Boolean driver) {
//					try {
//						if (CommonState.getStatus().isWaitingTimerClose()) {
//							System.out.println("waiting time closed by Next trail initializer");
//							return true;
//						} else {
//							System.out.println("Next Trail waiting time is started by Close timer");
//							return false;
//						}
//					} catch (Exception e) {
//						System.out.println("Exception raised due to " + e.getMessage());
//						return true;
//					}
//				}
//			});
//			flag = isEventReceived;
//
//		} catch (Exception e) {
//			System.out.println("Exception raised due to " + e.getMessage());
//			flag = false;
//		}
//		return flag;
//	}

	public static void runCommand(TestCases testCase, final EchoClient echoClient, int LongRunTime,
			final String Message, int threadSleep) {
		for (int i = 0; i < LongRunTime; i++) {
			try {
				CommonState.getStatus().isTrafficCodeRunning(true);
				CommonState.getStatus().InitNetworkTraffic(false, false);
				runHighTrafficTimer(40, 1, TimeUnit.SECONDS, "RUN");
				runHighTrafficFluentThread(testCase, Duration.ofSeconds(25), Duration.ofNanos(56000), "RUN", echoClient,
						Message);
				runHighTrafficTimer(20, 1, TimeUnit.SECONDS, "COOLING");
				runHighTrafficFluentThread(testCase, Duration.ofSeconds(45), Duration.ofMillis(500), "STOP", echoClient,
						Message);
				CommonState.getStatus().isTrafficCodeRunning(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		CommonState.getStatus().networkTraffic().requestStop();
//		CommonState.getStatus().isTrailLoopFinished(true);
//		CommonState.getStatus().threadInitializeOnCondition().requestStop();

	}

	public static void runCommand(TestCases testCase, final EchoClient echoClient, int LongRunTime,
			final String Message) {
//		for (int i = 0; i < LongRunTime; i++) {
			try {
				CommonState.getStatus().isTrafficCodeRunning(true);
				CommonState.getStatus().InitNetworkTraffic(false, false);
				runHighTrafficTimer(40, 1, TimeUnit.SECONDS, "RUN");
				runHighTrafficFluentThread(testCase, Duration.ofSeconds(25), Duration.ofNanos(56000), "RUN", echoClient,
						Message);
				runHighTrafficTimer(20, 1, TimeUnit.SECONDS, "COOLING");
				runHighTrafficFluentThread(testCase, Duration.ofSeconds(45), Duration.ofMillis(500), "STOP", echoClient,
						Message);
				CommonState.getStatus().isTrafficCodeRunning(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		}

	}

	public static void alternateRunCommand(TestCases testCase, final EchoClient echoClient, int LongRunTime,
			final String Message, int threadSleep, int timePerExecution, TimeUnit timeUnit) {
		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		CommonState.getStatus().schedulerForRunCommand(scheduler);
		final Runnable runnable = new Runnable() {
//			int countdownStarter = totalExcecutionTime;

			public void run() {
				try {

					if (!CommonState.getStatus().isTrailLoopFinished()) {
						runCommand(testCase, echoClient, LongRunTime, Message, threadSleep);
					} else {
						System.out.println("Command for traffic scheduler need to stop");
						scheduler.shutdown();
					}

				} catch (Exception e) {
					System.out.println("Method name is aternateRunCommand, Exception raised due to " + e.getMessage());
					scheduler.shutdown();
				}
			}
		};
		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
	}

//	public static void waitUntilTimerClose(TestCases testCase) {
//		System.out.println("Wait time Started");
//		int timerInMinutes = CommonState.getStatus().nextTrailStartingTime();
//		int timerInSeconds = timerInMinutes * 60;
//		if (timerInSeconds == 0) {
//			timerInSeconds = 6;
//		}
//		checktimeClose((timerInSeconds - 5), 1, TimeUnit.SECONDS);
//		threadForTimerClose(testCase, Duration.ofSeconds(timerInSeconds), Duration.ofMillis(200));
//		System.out.println("Wait time Stoped");
//	}

	public static boolean traffic_nonTraffic(String traffic_nontraffic) {
		boolean flag = true;

		if (traffic_nontraffic.equals("TRAFFIC")) {
			while (!CommonState.getStatus().isTrafficStarted()) {

			}

		} else {
			while (!CommonState.getStatus().isNonTrafficCoolingStarted()) {
			}
		}
		TrailData.getStatus().trafficStartTime(String.valueOf(System.currentTimeMillis()));
		return flag;
	}

}
