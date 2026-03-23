package com.resideo.utils.firstalert_app;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.firstalert_app.screen.FADeviceDetailsScreen;

public class FADeviceDetailsUtils {

	public static boolean isDeviceConfiguration_Valid(TestCases testCase, String heatingSystem, String heatingStages,
			String coolingStages) {
		boolean flag = false;
		FADeviceDetailsScreen dviceDetails = new FADeviceDetailsScreen(testCase);
		String heating_System;
		if (dviceDetails.isHeatingSystemPresent()) {
			heating_System = dviceDetails.getHeatingSystem().toUpperCase().replace("HEATING_SYSTEM", "").replace("_", " ").trim();
		} else {
//			heating_System = "NONE";
			heating_System = "OTHER";
		}

		String heating_Stages;
		if (dviceDetails.isHeatingStagesPresent()) {
			heating_Stages = dviceDetails.getHeatingStages();
		} else {
			heating_Stages = "0";
		}

		String cooling_Stages;
		if (dviceDetails.isCoolingStagesPresent()) {
			cooling_Stages = dviceDetails.getCoolingStages();
		} else {
			cooling_Stages = "0";
		}

		if (heatingSystem.toUpperCase().equals(heating_System.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured System is " + heating_System);
			System.out.println("Current configured System is : " + heating_System);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Heating system is " + heatingSystem + ", Actual heating system is " + heating_System);
			System.out.println("Current configured System is : " + heating_System);
			flag = false;
		}
		if (heatingStages.toUpperCase().equals(heating_Stages.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured heating stages is " + heatingStages);
			System.out.println("Current configured heating stages is : " + heatingStages);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Heating system is " + heatingStages + ", Actual heating system is " + heating_Stages);
			System.out.println("Current configured heating stages is : " + heatingStages);
			flag = false;
		}
		if (coolingStages.toUpperCase().equals(cooling_Stages.toUpperCase())) {
			Keyword.ReportStep_Pass(testCase, "Current configured Cooling stages is " + cooling_Stages);
			System.out.println("Current configured cooling stages is : " + cooling_Stages);
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
					"Expected Cooling system is " + coolingStages + ", Actual heating system is " + cooling_Stages);
			System.out.println("Current configured cooling stages is : " + cooling_Stages);
			flag = false;
		}
		return flag;
	}

}
