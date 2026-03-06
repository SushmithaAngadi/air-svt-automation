package com.resideo.utils.api.DeviceServices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.json.JSONArray;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.api.dfc.DefaultTrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Response;

public class DeviceServicesUtil {

	/**
	 * @param args
	 */
	private final static OkHttpClient client = DefaultTrustManager.getUnsafeOkHttpClient().newBuilder().build();

	private String tobascoURL;
	private static boolean isConnected;
	private static HttpURLConnection tobascoConnection;
	private String verificationToken;
	private String bodyToken;
	private static String accessToken;
	private String sessionID;
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

	private static String deviceInformation;
	private String deviceConfigurationDetails;
	private TestCases testCase;

	private static String clientID = null;
	private static String clientSecret = null;
	private static String tenant = null;
	private static String tabasco_url = null;
	private static String scope = null;
	private static String channelId = null;

	private static String stage_tabasco_url = "";
	private static String stage_clientID = "";
	private static String stage_clientSecret = "";
	private static String stage_scope = "";
	private static String stage_tenant = "";
	private static String stage_ChannelId = "";

	private static String qa_tabasco_url = "https://tabasco-api.qa.titans.cloud/api/";
	private static String qa_clientID = "2c2d4608-aa50-474d-833e-95feaed55de8";
	private static String qa_clientSecret = "X5w8Q~Ieg8iAgaV.wSo3yJQrJdo6gzgJCD9O-ahi";
	private static String qa_scope = "api://2c2d4608-aa50-474d-833e-95feaed55de8/.default";
	private static String qa_tenant = "4f6e5b01-f21e-4e15-bb88-1a6a36557818";
	private static String qa_ChannelId = "TC-QA-DS";

	private static String prod_tabasco_url = "";
	private static String prod_clientID = "";
	private static String prod_clientSecret = "";
	private static String prod_scope = "";
	private static String prod_tenant = "";
	private static String prod_ChannelId = "";

	public DeviceServicesUtil(TestCases testCase, TestCaseInputs inputs, String macID) throws Exception {
		this.testCase = testCase;
		if (deviceServices_api(inputs)) {
			if (getConnection_Http_creation(testCase, inputs)) {
				deviceInformation = getDeviceDetails(testCase, macID);
				deviceConfigurationDetails = getDeviceConfigurationDetails(testCase, macID);
			}
		}
	}

	public String getTobascoURL() {
		return tobascoURL;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public HttpURLConnection getTobascoConnection() {
		return tobascoConnection;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public String getBodyToken() {
		return bodyToken;
	}

	public String getSessionID() {
		return sessionID;
	}

	private static void disableSSLCertificateChecking() {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// Not implemented
			}

			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				// Not implemented
			}
		} };

		try {
			SSLContext sc = SSLContext.getInstance("TLS");

			sc.init(null, trustAllCerts, new java.security.SecureRandom());

			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static boolean deviceServices_api(TestCaseInputs inputs) throws Exception {
		boolean flag = false;
		try {
			String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
//			String environment = "Production";
			environment = environment.replaceAll("\\s", "");
			if (environment.equalsIgnoreCase("PRODUCTION")) {
				tabasco_url = prod_tabasco_url;
				clientID = prod_clientID;
				clientSecret = prod_clientSecret;
				tenant = prod_tenant;
				scope = prod_scope;
				channelId = prod_ChannelId;
				flag = true;
			} else if (environment.equalsIgnoreCase("STAGE")) {
				tabasco_url = stage_tabasco_url;
				clientID = stage_clientID;
				clientSecret = stage_clientSecret;
				tenant = stage_tenant;
				scope = stage_scope;
				channelId = stage_ChannelId;
				flag = true;
			} else if (environment.equalsIgnoreCase("QA")) {
				tabasco_url = qa_tabasco_url;
				clientID = qa_clientID;
				clientSecret = qa_clientSecret;
				tenant = qa_tenant;
				scope = qa_scope;
				channelId = qa_ChannelId;
				flag = true;
			}
		} catch (Exception e) {
			new Throwable("Provided Environment not available");
			flag = false;
		}

		return flag;
	}

	public static boolean getConnection_Http_creation(TestCases testCase, TestCaseInputs inputs) throws Exception {
		try {
			if (deviceServices_api(inputs)) {

				URL url = new URL("https://login.microsoftonline.com/" + tenant + "/oauth2/v2.0/token");

				List<NameValuePair> params = new ArrayList<>();
				params.add(new BasicNameValuePair("client_id", clientID));
				params.add(new BasicNameValuePair("client_secret", clientSecret));
				params.add(new BasicNameValuePair("grant_type", "client_credentials"));
				params.add(new BasicNameValuePair("scope", scope));
				params.add(new BasicNameValuePair("Client credentials in Body", "Client Authentication"));

				UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(params);

				tobascoConnection = (HttpURLConnection) url.openConnection();

				tobascoConnection.setDoOutput(true);
				tobascoConnection.setRequestMethod("POST");
				tobascoConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
				tobascoConnection.setRequestProperty("content-length",
						String.valueOf(urlEncodedFormEntity.getContentLength()));

				OutputStream os = tobascoConnection.getOutputStream();

				urlEncodedFormEntity.writeTo(os);
				os.flush();
//			 	System.out.println(chilConnection.getResponseCode());

				if (tobascoConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(tobascoConnection.getInputStream()));

					String inputLine;
					StringBuffer html = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						html.append(inputLine);
					}

					in.close();

					JSONObject jsonObj = new JSONObject(html.toString().trim());
					accessToken = jsonObj.get("access_token").toString();
//					System.out.println(accessToken);
					isConnected = true;
				} else {
					isConnected = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Provided environment showing wrong");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured due to " + e.getMessage());
		}
		return isConnected;
	}

	public static String doGetRequest(String urlString) throws MalformedURLException, IOException {
//		urlString=tabasco_url + "v1/device/" + "B82CA0002B12" + "/schedule";
		HttpURLConnection getResponse = null;
		URL url = new URL(urlString);
		getResponse = (HttpURLConnection) url.openConnection();
		getResponse.setDoOutput(true);
		getResponse.setRequestMethod("GET");
		getResponse.setRequestProperty("Authorization", "Bearer " + accessToken);

		if (getResponse.getResponseCode() == HttpURLConnection.HTTP_CREATED
				|| getResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {

			BufferedReader in = new BufferedReader(new InputStreamReader(getResponse.getInputStream()));

			String inputLine;
			StringBuffer html = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				html.append(inputLine);
			}
//			System.out.println(html.toString());
			return html.toString();
		} else {
			System.out
					.println("Connection to Chapi is not successFul Response Code - " + getResponse.getResponseCode());
			return null;
		}

	}

	public static boolean doPutRequest(String urlString, String headerData) throws MalformedURLException, IOException {
		HttpURLConnection putResponse = null;
		URL url = new URL(urlString);

		putResponse = (HttpURLConnection) url.openConnection();
		putResponse.setDoOutput(true);
		putResponse.setRequestMethod("PUT");
		putResponse.setRequestProperty("Authorization", "Bearer " + accessToken);
		putResponse.setRequestProperty("content-type", "application/json");
		putResponse.setRequestProperty("content-length", String.valueOf(headerData.length()));

		OutputStream os = putResponse.getOutputStream();
		os.write(headerData.getBytes("UTF-8"));
		os.flush();

		System.out.println(putResponse.getResponseCode());

		if (putResponse.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED
				|| putResponse.getResponseCode() == HttpURLConnection.HTTP_OK) {
			System.out.println("Success");
			return true;
		} else {
			// System.out.println(postResponse.getResponseCode());
		}
		return false;
	}

	public static String getSchedule(TestCases testCase, TestCaseInputs inputs, String macID) {
		try {
			String urlString = tabasco_url + "v1/device/" + macID + "/schedule";
			String response = doGetRequest(urlString);
			if (response != null) {
				return response;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired");
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "response message " + response);
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Response setDeviceSchedule(TestCases testCase, TestCaseInputs inputs, String macID) {

		return null;
	}

	public static boolean enable_disableDeviceSchedule(TestCases testCase, TestCaseInputs inputs, String macID,
			boolean enableSchedule) {
		try {
			String headerData = "{\r\n" + "  \"ScheduleEnabled\": " + enableSchedule + ",\r\n" + "  \"ChannelId\": \""
					+ channelId + "\" \r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/schedule/enabled";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setScheduleCapabilities(TestCases testCase, TestCaseInputs inputs, String macID,
			boolean thermostatExcludeTemp) {
		try {
			String headerData = "{\r\n" + "  \"ThermostatExcludeTemp\": " + thermostatExcludeTemp + ",\r\n"
					+ "  \"ChannelId\": \"" + channelId + "\" \r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/scheduleCapabilities";

			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static String getDeviceDetails(TestCases testCase, String macID) {
		try {
			String urlString = tabasco_url + "v1/device/" + macID;
			String response = doGetRequest(urlString);
			if (response != null) {
				return response;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired");
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "response message " + response);
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String getDeviceConfigurationDetails(TestCases testCase, String macID) {
		try {
			String urlString = tabasco_url + "v1/device/" + macID + "/configuration";
			String response = doGetRequest(urlString);
			if (response != null) {
				return response;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired");
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "response message " + response);
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String getThermostatInformation(TestCases testCase, TestCaseInputs inputs, String macID) {
		try {
			String urlString = tabasco_url + "v1/device/" + macID + "/thermostatInformation";
			String response = doGetRequest(urlString);
			if (response != null) {
				return response;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired");
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "response message " + response);
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static boolean setAwayMode(TestCases testCase, TestCaseInputs inputs, String macID, String setpoint) {

		return true;
	}

	public static boolean setHeatSetpoint(TestCases testCase, TestCaseInputs inputs, String macID,
			String heatSetpoint) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + heatSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"TemporaryHold\",\r\n" + "  \"ChannelId\": \"" + channelId + "\"\r\n"
					+ "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/heatSetpoint";

			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setHeatSetpointWithTempHold(TestCases testCase, TestCaseInputs inputs, String macID,
			String heatSetpoint, String holdUntilTime) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + heatSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"TemporaryHold\",\r\n " + " \"HoldUntil\": \"" + holdUntilTime + ",\r\n"
					+ "  \"ChannelId\": \"" + channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/heatSetpoint";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setHeatSetpointWithPermanentHold(TestCases testCase, TestCaseInputs inputs, String macID,
			String heatSetpoint) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + heatSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"PermanentHold\",\r\n" + "  \"ChannelId\": \"" + channelId + "\"\r\n"
					+ "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/heatSetpoint";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setPointCapabilities(TestCases testCase, TestCaseInputs inputs, String macID,
			String setpoint) {
//		try {
//			MediaType mediaType = MediaType.parse("application/json");
//			RequestBody body = RequestBody.create(mediaType,
//					"{\r\n" + "  \"maxHeatSetpoint\": 0,\r\n" + "  \"minHeatSetpoint\": 0,\r\n"
//							+ "  \"maxCoolSetpoint\": 0,\r\n" + "  \"minCoolSetpoint\": 0,\r\n"
//							+ "  \"deadBnd\": 0,\r\n" + "  \"channelId\": \"string\"\r\n" + "}");
//			Request request = new Request.Builder()
//					.url("https://tabasco-api.qa.titans.cloud/api/v1/device/" + macID + "/heatSetpoint")
//					.method("PUT", body).addHeader("Authorization", "Bearer " + accessToken).build();
//			Response response = client.newCall(request).execute();
//			System.out.println(response.code());
//			System.out.println(response.body().string());
//			if (response.code() == 202) {
//				return true;
//			} else {
//				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
//						"Unable to connect to the URL or token  expired ");
//				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "response message " + response);
//				return false;
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return false;
//		}

		return true;
	}

	public static boolean setCoolSetpoint(TestCases testCase, TestCaseInputs inputs, String macID,
			String coolSetpoint) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + coolSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"TemporaryHold\",\r\n" + "  \"ChannelId\": \"" + channelId + "\"\r\n"
					+ "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/coolSetpoint";

			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setCoolSetpointWithPermanentHold(TestCases testCase, TestCaseInputs inputs, String macID,
			String coolSetpoint) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + coolSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"PermanentHold\",\r\n" + "  \"ChannelId\": \"" + channelId + "\"\r\n"
					+ "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/coolSetpoint";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public static boolean setCoolSetpointWithTempHold(TestCases testCase, TestCaseInputs inputs, String macID,
			String coolSetpoint, String holdUntilTime) {
		try {
			String headerData = "{\r\n" + "  \"SetpointValue\": " + coolSetpoint + ",\r\n"
					+ "  \"SetpointStatus\": \"TemporaryHold\",\r\n " + " \"HoldUntil\": \"" + holdUntilTime + ",\r\n"
					+ "  \"ChannelId\": \"" + channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/coolSetpoint";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setFanSwitch(TestCases testCase, TestCaseInputs inputs, String macID, String fanMode) {
		try {
			String headerData = "{\r\n" + "  \"FanSwitch\": {\r\n" + "    \"Position\": \"" + fanMode + "\",\r\n"
					+ "    \"Speed\": 0 \r\n" + "  },\r\n" + "  \"ChannelId\": \"" + channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/fanSwitch";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setSystemSwitch(TestCases testCase, TestCaseInputs inputs, String macID, String systemMode) {
		try {
			String headerData = "{\r\n" + "  \"SystemSwitchValue\": \"" + systemMode + "\",\r\n" + "  \"ChannelId\": \""
					+ channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/systemSwitch";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

//	Ventilation and vacation related need to include

	public static boolean setAdaptiveRecovery(TestCases testCase, TestCaseInputs inputs, String macID,
			String recoveryMode) {
		try {
			String headerData = "{\r\n" + "  \"Mode\": \"" + recoveryMode + "\",\r\n" + "  \"ChannelId\": \""
					+ channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/adaptiveIntelligentRecovery";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static boolean setBackLightIntensity(TestCases testCase, TestCaseInputs inputs, String macID,
			int backLight) {
		try {
			String headerData = "{\r\n" + "  \"BacklightIntensity\": " + backLight + ",\r\n" + "  \"ChannelId\": \""
					+ channelId + "\"\r\n" + "}";
			String urlString = tabasco_url + "v1/device/" + macID + "/backlightIntensity";
			if (doPutRequest(urlString, headerData)) {
				return true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Unable to connect to the URL or token  expired ");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<String> getSystemSwitchCapabilitiesList(TestCases testCase2, TestCaseInputs input, String macID) {
		List<String> systemSwitchCapabilitiesList = new ArrayList<String>();
		if (deviceConfigurationDetails != null  && !deviceConfigurationDetails.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceConfigurationDetails);
			if (jsonObject.has("SystemSwitchCapabilities")) {

				JSONArray systemSwitchCapabilitiesArray = jsonObject.getJSONArray("SystemSwitchCapabilities");

				for (int i = 0; i < systemSwitchCapabilitiesArray.length(); i++) {
					systemSwitchCapabilitiesList.add(systemSwitchCapabilitiesArray.getString(i).toUpperCase());
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
						"Fetched Json Object dosent contain Key 'SystemSwitchCapabilities' ");
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceConfigurationDetails' is null or empty");
		}
		return systemSwitchCapabilitiesList;
	}

	public String getHeatSetpoint() {
		int HeatSetpoint = 0;
		if (deviceInformation != null  && !deviceInformation.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceInformation);
			HeatSetpoint = jsonObject.getJSONObject("Setpoint").getInt("HeatSetpoint");
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceInformation' is null or empty");
		}
		return String.valueOf(HeatSetpoint);
	}

	public String getMin_HeatSetpoint() {
		String minHeatSetpoint = null;
		if (deviceConfigurationDetails != null  && !deviceConfigurationDetails.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceConfigurationDetails);
			minHeatSetpoint = jsonObject.get("MinimumHeatSetpointAllowed").toString();
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceConfigurationDetails' is null or empty");
		}
		return minHeatSetpoint;
	}

	public String getMax_HeatSetpoint() {
		String maxHeatSetpoint = null;
		if (deviceConfigurationDetails != null  && !deviceConfigurationDetails.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceConfigurationDetails);
			maxHeatSetpoint = jsonObject.get("MaximumHeatSetpointAllowed").toString();
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceConfigurationDetails' is null or empty");
		}
		return maxHeatSetpoint;
	}

	public String getCoolSetpoint() {
		int coolSetpoint = 0;
		if (deviceInformation != null  && !deviceInformation.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceInformation);
			coolSetpoint = jsonObject.getJSONObject("Setpoint").getInt("CoolSetpoint");
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceInformation' is null or empty");
		}
		return String.valueOf(coolSetpoint);
	}

	public String getMin_CoolSetpoint() {
		String minCoolSetpoint = null;
		if (deviceConfigurationDetails != null  && !deviceConfigurationDetails.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceConfigurationDetails);
			minCoolSetpoint = jsonObject.get("MinimumCoolSetpointAllowed").toString();
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceConfigurationDetails' is null or empty");
		}
		return minCoolSetpoint;

	}

	public String getMax_CoolSetpoint() {
		String maxCoolSetpoint = null;
		if (deviceConfigurationDetails != null && !deviceConfigurationDetails.isEmpty()) {
			JSONObject jsonObject = new JSONObject(deviceConfigurationDetails);
			maxCoolSetpoint = jsonObject.get("MaximumCoolSetpointAllowed").toString();
		}else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.COSMETIC_FAILURE,
					"Failed because 'deviceConfigurationDetails' is null or empty");
		}
		return maxCoolSetpoint;
	}

}