package com.resideo.utils.stat;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.KeepAppActive;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.PhysicalRelayMsg.Relays;

public class SystemTestStatRelayUtils {

	public static boolean verifyRelays(TestCases testCase, List<Relays> relays, String OnOffStatus) {
		boolean flag = false;
		KeepAppActive appActive = new KeepAppActive(testCase);
		appActive.start();
		try {

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.withTimeout(Duration.ofMinutes(20));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				@SuppressWarnings("unlikely-arg-type")
				public Boolean apply(Boolean flag) {
					try {
						PhysicalRelayMsg physicalRelays = StatCommands.getInstance().cattCommandsStub
								.getPhysicalRelays(String_Msg.newBuilder().build());

						if (OnOffStatus.toUpperCase().contains("ON")) {
							if (new HashSet<>(physicalRelays.getRelayList()).equals(new HashSet<>(relays))) {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are turned on as expected.");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Expected Relays to turn on " + relays.toString()
										+ ", observed : " + physicalRelays.getRelayList().toString());
								return false;
							}
						} else if (OnOffStatus.toUpperCase().contains("OFF")) {
							if (!physicalRelays.getRelayList().contains(relays)) {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are turned Off as expected.");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are not turned Off. ");
								Keyword.ReportStep_Pass(testCase,
										"Currently " + physicalRelays.getRelayList().toString()
												+ " relays are turned on. Rechecking...");
								return false;
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
									"Invalid On Off Status String. Expected : 'ON' or 'OFF'");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to verify relays. Execption raised : " + e.getMessage());

						return false;
					}
				}
			});

			flag = isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Execption raised : " + e.getMessage());
			flag = false;

			if (appActive.isAlive())
				appActive.requestStop();

		}
		appActive.requestStop();
		return flag;
	}
	public static boolean verifyRelays(TestCases testCase, List<Relays> relays, String OnOffStatus,int timeout) {
		boolean flag = false;
		KeepAppActive appActive = new KeepAppActive(testCase);
		appActive.start();
		try {

			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.withTimeout(Duration.ofSeconds(timeout));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				@SuppressWarnings("unlikely-arg-type")
				public Boolean apply(Boolean flag) {
					try {
						PhysicalRelayMsg physicalRelays = StatCommands.getInstance().cattCommandsStub
								.getPhysicalRelays(String_Msg.newBuilder().build());

						if (OnOffStatus.toUpperCase().contains("ON")) {
							if (new HashSet<>(physicalRelays.getRelayList()).equals(new HashSet<>(relays))) {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are turned on as expected.");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Expected Relays to turn on " + relays.toString()
										+ ", observed : " + physicalRelays.getRelayList().toString());
								return false;
							}
						} else if (OnOffStatus.toUpperCase().contains("OFF")) {
							if (!physicalRelays.getRelayList().contains(relays)) {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are turned Off as expected.");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase,
										"Expected Relays" + relays.toString() + " are not turned Off. ");
								Keyword.ReportStep_Pass(testCase,
										"Currently " + physicalRelays.getRelayList().toString()
												+ " relays are turned on. Rechecking...");
								return false;
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
									"Invalid On Off Status String. Expected : 'ON' or 'OFF'");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to verify relays. Execption raised : " + e.getMessage());

						return false;
					}
				}
			});

			flag = isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Execption raised : " + e.getMessage());
			flag = false;

			if (appActive.isAlive())
				appActive.requestStop();

		}
		appActive.requestStop();
		return flag;
	}

	
}
