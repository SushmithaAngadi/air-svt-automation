package com.resideo.utils.stat.screens_Gui;

import java.time.Duration;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;

public class ScreenNavigationUtils {

	public static boolean screenNavigationFromAnyScreen(TestCases testCase, String ScreenName) {
		boolean flag = false;
		if (ScreenName.contains("REDLINK") && ScreenName.contains("ADD")) {
			if (StatCommands.getInstance().cattCommandsStub
					.t10PlusNavigateTo(NavigateTo.newBuilder()
							.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_INSTALLER_OPTIONS_ADD_EIM).build())
					.getBoolVal()) {
				SetUpDevice_T9_T10_T0Plus setUpDevice_T9_T10_T0Plus = new SetUpDevice_T9_T10_T0Plus();

				if (setUpDevice_T9_T10_T0Plus.getScreenwithValidation(testCase, Duration.ofSeconds(10), 18, 257, 301,
						311, 1, "reset this")
						|| setUpDevice_T9_T10_T0Plus.getScreenwithValidation(testCase, Duration.ofSeconds(10), 18, 257,
								301, 311, 1, "factory")) {
					if (StatCommands.getInstance().cattCommandsStub
							.t10PlusNavigateTo(NavigateTo.newBuilder()
									.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_DEVICES_ASKTOADD).build())
							.getBoolVal()) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Successfully navigated to Add Redlink add device screen");

					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to navigate to Add redlink device from Home screen");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"EIM is not paried with Thermostat");
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to navigate to ADD Eim Screen");
				flag = false;
			}

		} else if (ScreenName.contains("REDLINK") && ScreenName.contains("ADD")) {

		} else {

		}

		return flag;
	}

}
