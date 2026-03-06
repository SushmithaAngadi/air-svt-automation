package com.resideo.utils.api.dfc;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.system.utils.LCC_Admin;

public class CustomCommands {
	/*
	 * 48A2E65CEA38 B82CA0630D88
	 */

	public static void doRestart_OverApi(TestCases testCase, TestCaseInputs inputs, String... macIDs) {

		for (int i = 0; i < 10; i++) {
			timer(testCase, 2);
			LCC_Admin.restartDevice(testCase, inputs, macIDs);
//			timer(testCase, 2);
		}

	}

	public static boolean reg_device(TestCases testCase, TestCaseInputs inputs, String... macIDs) {
		boolean flag = false;

		return flag;
	}

	public static void timer(TestCases testCase, int mins) {
		String time_Add = getTime_Add(mins);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(4));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = getCurrentTime();
						if (currentTime.contains(time_Add)) {
							return true;
						} else {
							System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
							return false;
						}
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
			}
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
		}
	}

	public static void timer(TestCases testCase, Duration dur, int mins) throws InterruptedException {
		String time_Add = getTime_Add(mins);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(30));
			fWait.withTimeout(dur);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = getCurrentTime();
						if (currentTime.contains(time_Add)) {
							return true;
						} else {
							System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, e.getMessage());
						return false;
					} catch (Exception e) { 
						if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
							Thread.currentThread().interrupt();
							Keyword.ReportStep_Pass(testCase, "Exception occured inside the fluent due to " + e.getMessage());
						}
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
						return false;
					}
				}
			});
			System.out.println(isEventReceived);
		} catch (Exception e) {
			if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
				Thread.currentThread().interrupt();
				Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
				System.out.println("Second ins started");
				Keyword.ReportStep_Pass(testCase, "Exception occured due to Second ins started " + e.getMessage());
				try {
					FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
					fWait.pollingEvery(Duration.ofSeconds(30));
					fWait.withTimeout(dur);
					boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean flag1) {
							try {
								String currentTime = getCurrentTime();
								if (currentTime.contains(time_Add)) {
									return true;
								} else {
									System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
									return false;
								}
							} catch (TimeoutException e) {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
								return false;
							} catch (StaleElementReferenceException e) {
								Keyword.ReportStep_Pass(testCase, e.getMessage());
								return false;
							} catch (Exception e) { 
								if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
									Thread.currentThread().interrupt();
									
									Keyword.ReportStep_Pass(testCase, "Exception occured inside the fluent due to " + e.getMessage());
								}
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0, e.getMessage());
								return false;
							}
						}
					});
					System.out.println(isEventReceived);
				} catch (Exception e1) {
					if (e1.getMessage().contains("InterruptedException") || e1.getMessage().contains("sleep")) {
						Thread.currentThread().interrupt();
						Keyword.ReportStep_Pass(testCase, "Exception occured due to second stoped " + e.getMessage());
					}
				}
				
				
			}
		}
	}

	public static void timer(Duration dur, int mins) {
		String time_Add = getTime_Add(mins);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(30));
			fWait.withTimeout(dur);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = getCurrentTime();
						if (currentTime.contains(time_Add)) {
							return true;
						} else {
							System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
							return false;
						}
					} catch (TimeoutException e) {
						System.out.println(e.getMessage());
						return false;
					} catch (StaleElementReferenceException e) {
						System.out.println(e.getMessage());
						return false;

					} catch (Exception e) {
						System.out.println(e.getMessage());
						return false;
					}
				}
			});
			System.out.println(isEventReceived);
		} catch (Exception e) {
			if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
				Thread.currentThread().interrupt();
				System.out.println(e.getMessage());
			}
		}
	}

	public static void timer_(TestCases testCase, int mins) {
		String time_Add = getTime_Add(mins);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofMinutes(4));
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = getCurrentTime();
						if (currentTime.contains(time_Add)) {
							return true;
						} else {
							System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
							return false;
						}
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
			}
			Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
		}
	}

	public static void timer_(TestCases testCase, Duration dur, int mins) {
		String time_Add = getTime_Add(mins);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.pollingEvery(Duration.ofSeconds(50));
			fWait.withTimeout(dur);
			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag1) {
					try {
						String currentTime = getCurrentTime();
						if (currentTime.contains(time_Add)) {
							return true;
						} else {
							System.out.println("Current time " + currentTime + " ::::: Wait until  " + time_Add);
							return false;
						}
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
				Keyword.ReportStep_Pass(testCase, "Exception occured due to " + e.getMessage());
			}
		}
	}

//	public static void main(String[] args) throws ParseException {
//		
//		timer(null, 2);
//	}

	public static String getTime_Add(int mins) {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String currentTime = myDateObj.plusMinutes(mins).format(myFormatObj);
		return currentTime;
	}

	public static String getCurrentTime() {
		LocalDateTime myDateObj = LocalDateTime.now();
//		    System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		String formattedDate = myDateObj.format(myFormatObj);
//		    System.out.println("After formatting: " + formattedDate);

		return formattedDate;
	}

	public static void SchedulerHandler(TestCases testCase, String timerType, int dr) {
//		long counterLoop = 0;
//		Duration deadLift = null;
		Duration deadLift =  Duration.ofMinutes(dr);
//		if (timerType.contains("MINUTE")) {
//			if (dr > 4) {
//				counterLoop = dr / 4;
//				deadLift = Duration.ofMinutes(4);
//			} else {
//				deadLift = Duration.ofMinutes(dr + 2);
//			}
//
//		} else if (timerType.contains("SECONDS")) {
//			if (dr > 200) {
//				Duration convt = Duration.ofSeconds(dr);
//				long minutes = convt.toMinutes();
//				counterLoop = minutes / 4;
//				deadLift = Duration.ofMinutes(4);
//			} else {
//				deadLift = Duration.ofSeconds(dr);
//			}
//		} else if (timerType.contains("Hour")) {
//			Duration conv = Duration.ofHours(dr);
//			long minutes = conv.toMinutes();
//
//			if (minutes > 4) {
//				counterLoop = minutes / 4;
//				deadLift = Duration.ofMinutes(4);
//			} else {
//				deadLift = Duration.ofMinutes(minutes);
//			}
//
//		}
//		counterLoop = Math.round(counterLoop);
//		if (counterLoop > 0) {
//			for (int i = 0; i < counterLoop; i++) {
//				try {
//					timer(testCase, deadLift, 4);
//					Keyword.ReportStep_Pass(testCase, "Thread extender, ID is " + (i + 1));
//				} catch (Exception e) {
//					if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
//						Thread.currentThread().interrupt();
//					}
//					Keyword.ReportStep_Pass(testCase,
//							"Exception occured due to " + e.getMessage() + " but its recoverable...");
//				}
//
//			}
//		} else {
			try {
				timer(testCase, deadLift, dr);
				Keyword.ReportStep_Pass(testCase, "Thread extender finished, ID is 231");
			} catch (InterruptedException e1) {
				System.out.println("Interupted Exception occured, Skipping..");
				Thread.currentThread().interrupt();
				Keyword.ReportStep_Pass(testCase,
						"Exception occured due to " + e1.getMessage() + " but its not recoverable...");
			} catch (Exception e) {
				if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
					Thread.currentThread().interrupt();
				}
				Keyword.ReportStep_Pass(testCase,
						"Exception occured due to " + e.getMessage() + " but its not recoverable...");
			}
//		}

	}

	public static void SchedulerHandler(String timerType, int dr) {
		long counterLoop = 0;
		Duration deadLift = null;
		if (timerType.contains("MINUTE")) {
			if (dr > 4) {
				counterLoop = dr / 4;
				deadLift = Duration.ofMinutes(4);
			} else {
				deadLift = Duration.ofMinutes(dr + 2);
			}

		} else if (timerType.contains("SECONDS")) {
			if (dr > 200) {
				Duration convt = Duration.ofSeconds(dr);
				long minutes = convt.toMinutes();
				counterLoop = minutes / 4;
				deadLift = Duration.ofMinutes(4);
			} else {
				deadLift = Duration.ofSeconds(dr);
			}
		} else if (timerType.contains("Hour")) {
			Duration conv = Duration.ofHours(dr);
			long minutes = conv.toMinutes();

			if (minutes > 4) {
				counterLoop = minutes / 4;
				deadLift = Duration.ofMinutes(4);
			} else {
				deadLift = Duration.ofMinutes(minutes);
			}

		}
		counterLoop = Math.round(counterLoop);
		if (counterLoop > 0) {
			for (int i = 0; i < counterLoop; i++) {
				try {
					timer(deadLift, 4);
					System.out.println("Thread extender, ID is " + (i + 1));
				} catch (Exception e) {
					if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
						Thread.currentThread().interrupt();
					}
					System.out.println("Exception occured due to " + e.getMessage() + " but its recoverable...");
				}

			}
		} else {
			try {
				timer(deadLift, dr);
				System.out.println("Thread extender finished, ID is 231");
			} catch (Exception e) {
				if (e.getMessage().contains("InterruptedException") || e.getMessage().contains("sleep")) {
					Thread.currentThread().interrupt();
				}
				System.out.println("Exception occured due to " + e.getMessage() + " but its not recoverable...");
			}
		}

	}

//	public static void main(String[] args) {
//		SchedulerHandler(null, "Minutes".toUpperCase(), 54);
//	}
}
