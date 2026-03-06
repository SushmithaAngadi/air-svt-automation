package com.resideo.utils.api.tcc;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.utils.api.common.ApiCommonUtil;

public class TCCUtils implements AutoCloseable {

	private String tccURL;
	private String applicationID;
	private boolean isConnected;
//	private HashMap<String, Long> locations;
	private int userID;
	private String bodyToken;
	private String sessionID;
	private TestCaseInputs inputs;
	private long comTaskID = 0;
	public static String chapiDeviceId;
	public static int coolSetPoints = 0;
	public static int heatSetPoints = 0;
	public static Double maxHeat;
	public static Double minHeat;
	public static Double maxCool;
	public static Double minCool;
	public static String thermostatUnit = "";
	public static String startTime = "";
	public static String endTime = "";
	public static int setPointInPrimaryCard = 0;
	public static int setPointInVacationCard = 0;
	public static int vacationHeatSetPoint = 0;
	public static int vacationCoolSetPoint = 0;
	public static JSONObject SensorList;

	public TCCUtils(TestCaseInputs inputs) throws Exception {
		String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
		environment = environment.replaceAll("\\s", "");
		if (environment.equalsIgnoreCase("Production")) {
			tccURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TCC_PRODUCTION");
			applicationID = "e5e5e8c6-09aa-44e0-90b6-1d384a9ccbeb";
		} else if (environment.equalsIgnoreCase("Stage")) {
			tccURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TCC_PRODUCTION");
			applicationID = "e5e5e8c6-09aa-44e0-90b6-1d384a9ccbeb";
		}
		this.inputs = inputs;
		this.isConnected = false;
//		locations = new HashMap<String, Long>();
	}

	public TCCUtils() throws Exception {
	}

	public boolean isConnected() {
		return isConnected;
	}

	public String getBodyToken() {
		return bodyToken;
	}

	public String getSessionID() {
		return sessionID;
	}

	public boolean getConnection() throws Exception {
		try {
			RequestSpecification spec = RestAssured.given()
					.contentType("application/x-www-form-urlencoded; charset=utf-8")
					.formParam("username", inputs.getInputValue("USERID"))
					.formParam("password", inputs.getInputValue("PASSWORD")).formParam("applicationId", applicationID)
					.when().relaxedHTTPSValidation().baseUri(this.tccURL).basePath("api/session");
			Response response = spec.post();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				JSONObject json = new JSONObject(responseBody);
				sessionID = json.get("sessionId").toString();
				userID = json.getJSONObject("userInfo").getInt("userID");
				isConnected = true;
			} else {
				isConnected = false;
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		return isConnected;
	}

	public boolean getConnection_rest(String environment, String url) throws Exception {
		try {
			this.tccURL = url;
			RequestSpecification spec = RestAssured.given()
					.contentType("application/x-www-form-urlencoded; charset=utf-8")
					.formParam("username", "srividya.araja@resideo.com").formParam("password", "ResideoComfort1!")
					.formParam("applicationId", environment).when().relaxedHTTPSValidation().baseUri(url)
					.basePath("api/session");
			Response response = spec.post();

			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				JSONObject json = new JSONObject(responseBody);
				sessionID = json.get("sessionId").toString();
				userID = json.getJSONObject("userInfo").getInt("userID");
				isConnected = true;
			} else {
				isConnected = false;
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		return isConnected;
	}

	public void getJsonData(String locationdata) {
		String macid = "48A2E6B924B9";
		String listofDevices = ApiCommonUtil.getValueByJsonPath(locationdata, "$.devices[*]");
		String deviceDetails = null;
		JSONArray deviceList = new JSONArray(listofDevices);
		for (int i = 0; i < deviceList.length(); i++) {
			String devicedetails = deviceList.get(i).toString();
			String macID = ApiCommonUtil.getValueByJsonPath(devicedetails, "$.macID");
			if (macid.equals(macID)) {

//				JSONObject device_Details_Json= new JSONObject(deviceDetails);
				String deviceID = ApiCommonUtil.getValueByJsonPath(devicedetails, "$.deviceID");
//				String gatewayID = ApiCommonUtil.getValueByJsonPath(devicedetails, "$.gatewayId");
				System.out.println(deviceID);
			}

		}
	}

	public long getDeviceIDFromLocation(String locationDetails, String macid) {
		long deviceID = -1;
		String listofDevices = ApiCommonUtil.getValueByJsonPath(locationDetails, "$.devices[*]");
		JSONArray deviceList = new JSONArray(listofDevices);
		for (int i = 0; i < deviceList.length(); i++) {
			String devicedetails = deviceList.get(i).toString();
			String macID = ApiCommonUtil.getValueByJsonPath(devicedetails, "$.macID");
			if (macid.equals(macID)) {
				deviceID = TCC_CommonUtils.deviceID = Long
						.parseLong(ApiCommonUtil.getValueByJsonPath(devicedetails, "$.deviceID"));
				break;
			}
		}
		return deviceID;
	}

	public JSONObject getDeviceJson_FromLocation(String locationDetails, String macid) {
		JSONObject deviceJSon = new JSONObject();
		String listofDevices = ApiCommonUtil.getValueByJsonPath(locationDetails, "$.devices[*]");
		JSONArray deviceList = new JSONArray(listofDevices);
		for (int i = 0; i < deviceList.length(); i++) {
			String devicedetails = deviceList.get(i).toString();
			String macID = ApiCommonUtil.getValueByJsonPath(devicedetails, "$.macID");
			if (macid.equals(macID)) {
				deviceJSon = new JSONObject(devicedetails);
				TCC_CommonUtils.deviceID = deviceJSon.getLong("deviceID");
				break;
			}
		}
		return deviceJSon;
	}

	public JSONObject getDeviceInformation(String macid) throws Exception {
		JSONObject deviceJSon = new JSONObject();
		try {
			if (!isConnected) {
				getConnection();
			}
			RequestSpecification spec = RestAssured.given().queryParam("userId", userID).queryParam("allData", "true")
					.queryParam("include", "all").header("userId", userID).header("sessionId", sessionID).when()
					.relaxedHTTPSValidation().baseUri(this.tccURL).basePath("api/locations");
			Response response = spec.get();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				JSONArray locationArray = new JSONArray(responseBody);
				for (int i = 0; i < locationArray.length(); i++) {

					String locationDetail = locationArray.get(i).toString();
					TCC_CommonUtils.locationID = new JSONObject(locationDetail).getLong("locationID");
					TCC_CommonUtils.deviceID = getDeviceIDFromLocation(locationDetail, macid);
					if (TCC_CommonUtils.deviceID > 1) {
						deviceJSon = getDeviceJson_FromLocation(locationDetail, macid);
						break;
					}
				}
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return deviceJSon;
	}

	public JSONObject getDeviceInformation_deviceID(long deviceID) throws Exception {
		JSONObject deviceJSon = new JSONObject();
		try {
			if (!isConnected) {
				getConnection();
			}
			RequestSpecification spec = RestAssured.given().queryParam("allData", "true").queryParam("include", "all")
					.header("userId", userID).header("sessionId", sessionID).when().relaxedHTTPSValidation()
					.baseUri(this.tccURL).basePath("api/devices/" + deviceID);
			Response response = spec.get();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				deviceJSon = new JSONObject(responseBody);
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return deviceJSon;
	}

	public int changeSytemMode(String mode) throws Exception {
		comTaskID = 0;
		int statusCode = 0;
		try {
			if (!isConnected) {
				getConnection();
			}
			String requestBody = "\"" + mode + "\"";
			RequestSpecification spec = RestAssured.given().header("sessionId", sessionID).header("userId", userID)
					.contentType(ContentType.JSON).body(requestBody).when().relaxedHTTPSValidation()
					.baseUri(this.tccURL);
			Response response = spec.put(
					"api/devices/" + TCC_CommonUtils.deviceID + "/thermostat/changeableValues/mode?changeTag=null");
			statusCode = response.statusCode();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				comTaskID = new JSONObject(responseBody).getLong("id");
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return statusCode;
	}

	public int changeFanMode(String mode) throws Exception {
		comTaskID = 0;
		int statusCode = 0;
		try {
			if (!isConnected) {
				getConnection();
			}
			RequestSpecification spec = RestAssured.given().header("sessionId", sessionID).header("userId", userID)
					.contentType(ContentType.URLENC).formParam("mode", mode).when().relaxedHTTPSValidation()
					.baseUri(this.tccURL);
			Response response = spec.put("/WebApi/api/devices/" + TCC_CommonUtils.deviceID + "/fan/changeableValues");
			statusCode = response.statusCode();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				comTaskID = new JSONObject(responseBody).getLong("id");
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return statusCode;
	}

	public int setCoolSetPoint(float setpoint) throws Exception {
		comTaskID = 0;
		int statusCode = 0;
		try {
			if (!isConnected) {
				getConnection();
			}
			String requestBody = "{ \"value\": " + setpoint + ", \"status\": \"Temporary\", \"nextTime\": \""
					+ ApiCommonUtil.getTimeWithAddedHours() + "\" }";
			RequestSpecification spec = RestAssured.given().header("sessionId", sessionID).header("userId", userID)
					.contentType(ContentType.JSON).body(requestBody).when().relaxedHTTPSValidation()
					.baseUri(this.tccURL);
			Response response = spec.put("api/devices/" + TCC_CommonUtils.deviceID
					+ "/thermostat/changeableValues/coolSetpoint?changeTag=null");
			statusCode = response.statusCode();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				comTaskID = new JSONObject(responseBody).getLong("id");
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return statusCode;
	}

	public int setHeatSetPoint(float setpoint) throws Exception {
		comTaskID = 0;
		int statusCode = 0;
		try {
			if (!isConnected) {
				getConnection();
			}
			String requestBody = "{ \"value\": " + setpoint + ", \"status\": \"Temporary\", \"nextTime\": \""
					+ ApiCommonUtil.getTimeWithAddedHours() + "\" }";
			RequestSpecification spec = RestAssured.given().header("sessionId", sessionID).header("userId", userID)
					.contentType(ContentType.JSON).body(requestBody).when().relaxedHTTPSValidation()
					.baseUri(this.tccURL);
			Response response = spec.put("api/devices/" + TCC_CommonUtils.deviceID
					+ "/thermostat/changeableValues/heatSetpoint?changeTag=null");
			statusCode = response.statusCode();
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				comTaskID = new JSONObject(responseBody).getLong("id");
			} else {
				throw new Exception("Error Occured: response from api is " + response.statusCode());
			}
		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		close();
		return statusCode;
	}

	public boolean getComTaskStatus(long comtaskID) {
		boolean flag = false;
		try {
			Response response = RestAssured.given().queryParam("commTaskId", comtaskID).header("sessionId", sessionID)
					.header("userId", userID).when().get("/WebApi/api/commTasks");
			if (response.statusCode() == 201 || response.statusCode() == 200) {
				String responseBody = response.body().asString();
				JSONObject json = new JSONObject(responseBody);
				try {
					String state = json.get("state").toString();
					if (state.contains("Succeeded")) {
						flag = true;
					} else {
						flag = false;
					}
				} catch (Exception e) {
					flag = false;
				}
			} else {
				flag = false;
			}
		} catch (Exception e) {
			new Throwable("Exception occured, due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	@Override
	public void close() throws Exception {
		isConnected = false;
	}

}
