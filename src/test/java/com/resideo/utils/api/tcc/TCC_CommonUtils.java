package com.resideo.utils.api.tcc;

import org.json.JSONObject;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;

public class TCC_CommonUtils {

	public static long locationID = 0;
	public static long deviceID = 0;

	public static JSONObject getDeviceInformation(TestCases testCase, TestCaseInputs inputs, String macID) {
		JSONObject jsonObject = null;
		try {
			try (TCCUtils tcc = new TCCUtils(inputs)) {
				jsonObject = tcc.getDeviceInformation(macID);
			} catch (Exception e) {
				new Throwable("Failed to get device information, due to " + e.getMessage());
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Stat Information  : Unable to get information for Stat - "
							+ inputs.getInputValue("LOCATION1_DEVICE1_NAME") + " at location - "
							+ inputs.getInputValue("LOCATION1_NAME") + " : Error occured - " + e.getMessage());
			jsonObject = null;
		}
		return jsonObject;
	}

	public static JSONObject getDeviceInformation_deviceID(TestCases testCase, TestCaseInputs inputs,long deviceID){
		JSONObject jsonObject = null;
		try {
			try (TCCUtils tcc = new TCCUtils(inputs)) {
				jsonObject = tcc.getDeviceInformation_deviceID(deviceID);
			} catch (Exception e) {
				new Throwable("Failed to get device information, due to " + e.getMessage());
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Stat Information  : Unable to get information for Stat - "
							+ inputs.getInputValue("LOCATION1_DEVICE1_NAME") + " at location - "
							+ inputs.getInputValue("LOCATION1_NAME") + " : Error occured - " + e.getMessage());
			jsonObject = null;
		}
		return jsonObject;
	}
	
	public static String getTccURL(TestCases testCase, TestCaseInputs inputs) throws Exception {
		String tccURL = " ";
		try {
			String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
			environment = environment.replaceAll("\\s", "");
			if (environment.equalsIgnoreCase("Production")) {
				tccURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TCC_PRODUCTION");
			} else if (environment.equalsIgnoreCase("Stage")) {
				tccURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TCC_PRODUCTION");
			} else {
				throw new Exception("Invalid URL");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return tccURL;
	}

	public static String getTccApplicationID(TestCases testCase, TestCaseInputs inputs) throws Exception {
		String applicationID = " ";
		try {
			String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
			environment = environment.replaceAll("\\s", "");
			if (environment.equalsIgnoreCase("Production")) {
				applicationID = "e5e5e8c6-09aa-44e0-90b6-1d384a9ccbeb";
			} else if (environment.equalsIgnoreCase("Stage")) {
				applicationID = "e5e5e8c6-09aa-44e0-90b6-1d384a9ccbeb";
			} else {
				throw new Exception("Invalid URL");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return applicationID;
	}


}
