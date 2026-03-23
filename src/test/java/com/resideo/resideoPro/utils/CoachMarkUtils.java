package com.resideo.utils.resideo_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.screen.CoachMarks;

public class CoachMarkUtils {


	public static final String[] ThermostatDashboardCoachMarkHeaders = new String[] { "Access More Information",
			"Quick Controls" };
	public static final String[] ThermostatDashboardCoachMarkDescriptions = new String[] {
			"Access controls and options for any device by tapping on the device name.",
			"Quickly change the temperature that your thermostat is set to" };

	public static final String[] NASolutionCardCoachMarkHeaders = new String[] { "Indoor Temperature Reading",
			"Temp Stepper", "Mode", "Fan", "Schedule" };
	public static final String[] NASolutionCardCoachMarkDescriptions = new String[] {
			"Displays current temperature in your home", "Change the temperature that your thermostat is set to.",
			"Change thermostat mode between Heat, Cool, Auto and Off", "Change the fan mode your system is using",
			"View, edit or create a new schedule for your thermostat" };

	public static final String[] EMEASolutionCardCoachMarkHeaders = new String[] { "Indoor Temperature Reading",
			"Temp Stepper", "Mode", "Schedule" };
	public static final String[] EMEASolutionCardCoachMarkDescriptions = new String[] {
			"Displays current temperature in your home", "Change the temperature that your thermostat is set to.",
			"Change thermostat mode between Heat, Cool, Auto and Off",
			"View, edit or create a new schedule for your thermostat" };

	public static final String WLD = "wld";
	public static final String THERMOSTAT = "thermostat";
	public static final String THERMOSTATNA = "thermostatna";
	public static final String THERMOSTATEMEA = "thermostatemea";

	public static boolean verifyDashboardCoachMarks(TestCases testCase, String deviceType) {
		boolean flag = true;
		CoachMarks cm = new CoachMarks(testCase);
		switch (deviceType) {
		case CoachMarkUtils.THERMOSTAT: {
			for (int i = 0; i < CoachMarkUtils.ThermostatDashboardCoachMarkHeaders.length; i++) {
				if (cm.getCoachMarkHeaderText()
						.equalsIgnoreCase(CoachMarkUtils.ThermostatDashboardCoachMarkHeaders[i])) {
					Keyword.ReportStep_Pass(testCase, "Thermostat Dashboard Coach Mark " + (i + 1)
							+ " Header is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Thermostat Dashboard Coach Mark Header  " + (i + 1)
									+ " is not correctly displayed on the dashboard");
				}
				if (cm.getCoachMarkDescription()
						.equalsIgnoreCase(CoachMarkUtils.ThermostatDashboardCoachMarkDescriptions[i])) {
					Keyword.ReportStep_Pass(testCase, "Thermostat Dashboard Coach Mark " + (i + 1)
							+ " Description is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Thermostat Dashboard Coach Mark Description " + (i + 1)
									+ "  is not correctly displayed on the dashboard");
				}
				flag = flag & cm.clickOnGotitButton();
			}

			break;
		}
		default: {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Invalid device type passed in the argument");
		}
		}

		return flag;
	}
	
	public static boolean verifySolutionCardCoachMarks(TestCases testCase, String deviceType) {
		boolean flag = true;
		CoachMarks cm = new CoachMarks(testCase);
		switch (deviceType) {
		
		case CoachMarkUtils.THERMOSTATNA: {
			for (int i = 0; i < CoachMarkUtils.NASolutionCardCoachMarkHeaders.length; i++) {
				if (cm.getCoachMarkHeaderText().equalsIgnoreCase(CoachMarkUtils.NASolutionCardCoachMarkHeaders[i])) {
					Keyword.ReportStep_Pass(testCase, "NA thermostat Solution Card Coach Mark " + (i + 1)
							+ " Header is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"NA thermostat Solution Card Coach Mark Header  " + (i + 1)
									+ " is not correctly displayed on the dashboard");
				}
				if (cm.getCoachMarkDescription()
						.equalsIgnoreCase(CoachMarkUtils.NASolutionCardCoachMarkDescriptions[i])) {
					Keyword.ReportStep_Pass(testCase, "NA thermostat Solution Card Coach Mark " + (i + 1)
							+ " Description is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"NA thermostat Solution Card Coach Mark Description " + (i + 1)
									+ "  is not correctly displayed on the dashboard");
				}
				flag = flag & cm.clickOnGotitButton();
			}
			break;
		}

		case CoachMarkUtils.THERMOSTATEMEA: {
			for (int i = 0; i < CoachMarkUtils.EMEASolutionCardCoachMarkHeaders.length; i++) {
				if (cm.getCoachMarkHeaderText().equalsIgnoreCase(CoachMarkUtils.EMEASolutionCardCoachMarkHeaders[i])) {
					Keyword.ReportStep_Pass(testCase, "EMEA thermostat Solution Card Coach Mark " + (i + 1)
							+ " Header is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"EMEA thermostat Solution Card Coach Mark Header  " + (i + 1)
									+ " is not correctly displayed on the dashboard");
				}
				if (cm.getCoachMarkDescription()
						.equalsIgnoreCase(CoachMarkUtils.EMEASolutionCardCoachMarkDescriptions[i])) {
					Keyword.ReportStep_Pass(testCase, "EMEA thermostat Solution Card Coach Mark " + (i + 1)
							+ " Description is correctly displayed on the dashboard");
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"EMEA thermostat Solution Card Coach Mark Description " + (i + 1)
									+ "  is not correctly displayed on the dashboard");
				}
				flag = flag & cm.clickOnGotitButton();
			}
			break;
		}

		default: {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Invalid device type passed in the argument");
		}
		}

		return flag;
	}

	public static boolean closeCoachMarks(TestCases testCase) {
		boolean flag = true;
		CoachMarks cm = new CoachMarks(testCase);
		int counter = 0;
		if (cm.isNextButtonVisible(1)) {
			while (cm.isNextButtonVisible(1) && counter < 5) {
				flag = flag & cm.clickOnNextButton();
				if (cm.isDoneButtonVisible(1)) {
					flag = flag & cm.clickOnDoneButton();
				}
				counter++;
			}
		}
		return flag;
	}
	
}
