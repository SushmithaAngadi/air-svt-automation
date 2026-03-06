package com.resideo.utils.api.tcc;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;

public class DeviceInformation {

	private JSONObject deviceInformation;
	private TestCases testCase;
	String locationName;
	String statName;

	public DeviceInformation(TestCases testCase, TestCaseInputs inputs, String macID) {
		this.testCase = testCase;
		deviceInformation= TCC_CommonUtils.getDeviceInformation(testCase, inputs, macID);
	}

	public DeviceInformation(TestCases testCase, TestCaseInputs inputs, long deviceID) {
		this.testCase = testCase;
		deviceInformation= TCC_CommonUtils.getDeviceInformation_deviceID(testCase, inputs, deviceID);
	}
	
	public void printStatJSON() throws Exception {
		if (deviceInformation != null) {
			System.out.println(deviceInformation);
		} else {
			throw new Exception("Device Information not found");
		}
	}

	public Boolean isOnline() throws Exception {
		if (deviceInformation != null) {
			return (Boolean) deviceInformation.get("isAlive");
		} else {
			throw new Exception("Device Information not found");
		}
	}

	public String getDeviceID() throws Exception {
		if (deviceInformation != null) {
			return deviceInformation.getString("deviceID");
		} else {
			throw new Exception("Device Information not found");
		}
	}

	public String getThermostatUnits() throws Exception {
		String units = " ";
		if (deviceInformation != null) {
			units = deviceInformation.getJSONObject("thermostat").getString("units");
		} else {
			throw new Exception("Device Information not found");
		}
		return units;
	}

	public String getThermoStatScheduleType() throws Exception {
		String scheduleType = "";
		if (deviceInformation != null) {
			scheduleType = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues").getString("status");
		} else {
			throw new Exception("Device Information not found");
		}
		return scheduleType;
	}

	public List<String> getAllowedModes() throws Exception {
		List<String> allowedModes = new ArrayList<String>();
		if (deviceInformation != null) {
			JSONArray temp = new JSONArray();
			temp = deviceInformation.getJSONObject("thermostat").getJSONArray("allowedModes");
			for (int i = 0; i < temp.length(); i++) {
				allowedModes.add(temp.getString(i));
			}
		} else {
			throw new Exception("Device Information not found");
		}
		return allowedModes;
	}

	public List<String> getAllowedModes_upperCase() throws Exception {
		List<String> allowedModes = new ArrayList<String>();
		if (deviceInformation != null) {
			JSONArray temp = new JSONArray();
			temp = deviceInformation.getJSONObject("thermostat").getJSONArray("allowedModes");
			for (int i = 0; i < temp.length(); i++) {
				allowedModes.add(temp.getString(i).toUpperCase());
			}
		} else {
			throw new Exception("Device Information not found");
		}
		return allowedModes;
	}

	public String getThermostatType() {
		String type = "";
		if (deviceInformation != null) {
			try {
				type = deviceInformation.get("deviceType").toString();
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
			}
		}
		return type;
	}

	public String getThermostatModelType() {
		String type = "";
		if (deviceInformation != null) {
			try {
				type = deviceInformation.get("thermostatModelType").toString();
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
			}
		}
		return type;
	}
	
	public String getThermoStatMode() {
		String systemMode = "";
		if (deviceInformation != null) {
			try {
				systemMode = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues")
						.getString("mode");
			} catch (Exception e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Get Stat Information  : Unable to get Current System mode for Stat - " + statName
								+ " at location - " + locationName + " : Error occured - " + e.getMessage());
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get System Mode : Not Connected to CHAPI. Returning \"\" value");
			return "";
		}
		return systemMode;
	}

	public String getThermostatModeWhenAutoChangeOverActive() {
		String systemMode = "";
		if (deviceInformation != null) {
			try {
				systemMode = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues")
						.getString("heatCoolMode");
			} catch (Exception e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Get Stat Information  : Unable to get Current System mode for Stat - " + statName
								+ " at location - " + locationName + " : Error occured - " + e.getMessage());
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get System Mode : Not Connected to CHAPI. Returning \"\" value");
			return "";
		}
		return systemMode;
	}

	public String getOverrrideSetpoint() {
		String OverrideMode = "";
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideMode = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues")
						.get("mode").toString();

				if (OverrideMode.equals("Heat")) {
					OverrideSet = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues").getJSONObject("heatSetpoint")
							.get("value").toString();
				} else
					OverrideSet = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues").getJSONObject("coolSetpoint")
							.get("value").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getHeatSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues").getJSONObject("heatSetpoint")
						.get("value").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getCoolSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues").getJSONObject("coolSetpoint")
						.get("value").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getMin_HeatSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").get("minHeatSetpoint").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getMin_CoolSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").get("minCoolSetpoint").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getMax_HeatSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").get("maxHeatSetpoint").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getMax_CoolSetpoint() {
		String OverrideSet = "";
		if (deviceInformation != null) {
			try {
				OverrideSet = deviceInformation.getJSONObject("thermostat").get("maxCoolSetpoint").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
		}
		return OverrideSet;
	}

	public String getHoldUntilTime() {
		String holdUntil = "";
		if (deviceInformation != null) {
			try {
				holdUntil = deviceInformation.getJSONObject("thermostat").getJSONObject("changeableValues")
						.get("holdUntil").toString();
			} catch (JSONException e) {
				
				e.printStackTrace();
			}
			return holdUntil;
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Stat Information is null");
		}
		return holdUntil;
	}

	public String getscheduleStatus() throws Exception {
		String status = " ";
		if (deviceInformation != null) {
			status = deviceInformation.getString("scheduleStatus");
		} else {
			throw new Exception("Device Information not found");
		}
		return status;

	}

}
