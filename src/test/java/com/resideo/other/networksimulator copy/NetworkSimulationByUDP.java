//package com.resideo.utils.networksimulator;
//
//import java.net.SocketException;
//import java.net.UnknownHostException;
//import java.time.Duration;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
//
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.support.ui.FluentWait;
//
//import com.resideo.commons.coreframework.TestCases;
//import com.resideo.system.utils.CommonUtils;
//import com.resideo.utils.stat.StatCommands;
//import com.resideo.utils.stat.cattgrpccommands.String_Msg;
//
//public class NetworkSimulationByUDP {
//	private static int count = 0;
//	static boolean runcommand = false;
//
//	public static void setCount(int i) {
//		count = i;
//	}
//
//	public static int getcount() {
//		return count;
//	}
//
//	public static boolean startListenerClient(TestCases testase, int sendPerMessage, int sentMessagetoLong,
//			int messageInterval) throws SocketException, UnknownHostException {
//		boolean flag = false;
//		String StatIP = StatCommands.getInstance().cattCommandsStub
//				.getDeviceInformation(String_Msg.newBuilder().setStrVal("ip_address").build()).getStrVal();
//		EchoClient echoclient = new EchoClient(StatIP);
//
//		for (int i = messageInterval; i >= 0; i--) {
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//			LocalDateTime now = LocalDateTime.now();
//			System.out.println(dtf.format(now));
//			CommonUtils.getStatus().isSetpointThread(true);
//			runcommand(sendPerMessage, sentMessagetoLong, dtf.format(now), echoclient);
//			CommonUtils.getStatus().isSetpointThread(false);
//			try {
//				Thread.sleep(40000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return flag;
//	}
//
//	public static void runcommand(int permessage, int perlong, String startTime, EchoClient echoClient) {
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		LocalDateTime plusSeconds = now.plusSeconds(perlong);
//		String format = dtf.format(plusSeconds);
//
//		LocalDateTime LocalTimecattData = now.plusSeconds(2);
//		CommonUtils.setDataTime(dtf.format(LocalTimecattData));
//
//		FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//		fWait.pollingEvery(Duration.ofNanos(permessage));
//		fWait.withTimeout(Duration.ofSeconds(perlong));
//		fWait.ignoring(TimeoutException.class);
//		Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//			public Boolean apply(Boolean driver) {
//				try {
//					if (format.equals(dtf.format(LocalDateTime.now()))) {
//						System.out.println("total exceution is " + String.valueOf(getcount()));
//						return true;
//					} else {
//						echoClient.sendEcho(
//								"If You want to specify a more decent range, like from 10 to 100 ( both are in the range )");
////						System.out.println("End time is :::" + format + "   : Current time is ::::: "
////								+ dtf.format(LocalDateTime.now()));
//						setCount(getcount() + 1);
//
//						return false;
//					}
//
//				} catch (Exception e) {
//					echoClient.sendEcho(
//							"If You want to specify a more decent range, like from 10 to 100 ( both are in the range )");
//					return false;
//				}
//			}
//		});
//		if (isEventReceived) {
//			System.out.println("PASS");
//		}
//
//	}
//
//	public static void activateInterval(final int totalExcecutionTime, int timePerExecution, TimeUnit timeUnit) {
//		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//
//		final Runnable runnable = new Runnable() {
//			int countdownStarter = totalExcecutionTime;
//
//			public void run() {
////				System.out.println(countdownStarter);
//				countdownStarter--;
//
//				if (countdownStarter < 1) {
////					System.out.println("Timer Over!");
//					runcommand = true;
//					scheduler.shutdown();
//				}
//			}
//		};
//		scheduler.scheduleAtFixedRate(runnable, 0, timePerExecution, timeUnit);
//
//	}
//
//	public static void runCommand(final EchoClient echoClient, int LongRunTime, final String Message, int threadSleep) {
//		for (int i = 0; i < LongRunTime; i++) {
//			activateInterval(20, 1, TimeUnit.SECONDS);
//			System.out.println("Initiating Network Traffic for 20 seconds");
//			System.out.println("Network Traffic Started");
//			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
//			fWait.pollingEvery(Duration.ofNanos(56000));
//			fWait.withTimeout(Duration.ofSeconds(20));
//			fWait.ignoring(TimeoutException.class);
//			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
//				public Boolean apply(Boolean driver) {
//					try {
//
//						if (runcommand) {
//							System.out.println("Network Traffic Finished");
//							return true;
//						} else {
//							echoClient.sendEcho(Message);
//							return false;
//						}
//
//					} catch (Exception e) {
//						System.out.println(e.getMessage());
//						echoClient.sendEcho(Message);
//						return true;
//					}
//				}
//			});
//			runcommand = false;
//			try {
//				System.out.println("Thread Sleep Activated for 40 seconds");
//				Thread.sleep(threadSleep * 1000);
//				System.out.println("Thread Sleep Deactivated Sucessfully");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("Completed Trial Number : " + (i + 1));
//		}
//
//	}
//}
