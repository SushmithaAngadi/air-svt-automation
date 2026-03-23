package com.resideo.utils.api.dfc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;

@SuppressWarnings("unused")
public class TabascoUtils implements AutoCloseable {

	/**
	 * @param args
	 */

	private String tobascoURL;
	private HashMap<String, String> envDetails;
	private boolean isConnected;
	private HttpURLConnection tabascoConnection;
	private String cookie;

	private HashMap<String, Long> locations;
	private int userID;
	private String verificationToken;
	private String bodyToken;
	private String sessionID;
	private TestCaseInputs inputs;
	public static String chapiDeviceId;
	public static String thermostatUnit = "";
	public static String startTime = "";
	public static String endTime = "";
	public static String tokenRequestURL;
	public static String tabascoRegistrationURL;
	public static String Ocp_Apim_Subscription_Key;

	@SuppressWarnings("unchecked")
	public TabascoUtils() throws Exception {
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(getEnvironmentDetails().getJSONObject("Tabasco_QA").toString(),
				Map.class);
		System.out.println(map);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.putAll(map);
		envDetails = hashMap;
		tobascoURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TABASCO_QA");
		tokenRequestURL = "https://login.microsoftonline.com/4722b4c2-6388-4c69-9cfb-f950ea762665/oauth2/v2.0/token";
	}

	public boolean isConnected() {
		return isConnected;
	}

	public HttpURLConnection getCHILConnection() {
		return tabascoConnection;
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

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> getEnvMap(String envDetail) {
		Gson gson = new Gson();
		Map<String, String> map = null;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		try {
			map = gson.fromJson(getEnvironmentDetails().getJSONObject(envDetail).toString(), Map.class);
			hashMap.putAll(map);
		} catch (JsonSyntaxException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hashMap;
	}

	public TabascoUtils(TestCaseInputs inputs) throws Exception {

		String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
		environment = environment.replaceAll("\\s", "");
		if (environment.equalsIgnoreCase("Production")) {
			envDetails = getEnvMap("Tabasco_Prod");
			tobascoURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TABASCO_PRODUCTION");
			tokenRequestURL = "https://login.microsoftonline.com/39dae6b5-c8a3-44b3-9fd6-0da71b99bf59/oauth2/v2.0/token";
			tabascoRegistrationURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"TABASCO_REGISTRATION_PRODUCTION");
			Ocp_Apim_Subscription_Key = "b5b41bc69f114e2f8b092c702958d51f";
		} else if (environment.equalsIgnoreCase("CHILStage(Azure)")) {
			envDetails = getEnvMap("Tabasco_Stage");
			tobascoURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TABASCO_STAGE");
			tokenRequestURL = "https://login.microsoftonline.com/87df9e29-606d-43bf-9edb-5cc6e613ecbf/oauth2/v2.0/token";
			tabascoRegistrationURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"TABASCO_REGISTRATION_STAGE");
			Ocp_Apim_Subscription_Key = "63d9953db0e0491189dd80376150ebcd";
		} else if (environment.equalsIgnoreCase("ChilDas(QA)")) {
			envDetails = getEnvMap("Tabasco_QA");
			tobascoURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TABASCO_QA");
			tokenRequestURL = "https://login.microsoftonline.com/4722b4c2-6388-4c69-9cfb-f950ea762665/oauth2/v2.0/token";
			tabascoRegistrationURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"TABASCO_REGISTRATION_QA");
			Ocp_Apim_Subscription_Key = "a5df5670e6a644e9aa9014529e4bf672";
		}
		this.inputs = inputs;
		this.isConnected = false;
//		locations = new HashMap<String, Long>();
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

	public static String getValueByJsonPath(String responseBody, String xpath) {
		return JsonPath.read(responseBody, xpath).toString();
	}

	public static String updateJsonValues(String jsonString, String jPath, String updateObject) {

		Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
				.mappingProvider(new JacksonMappingProvider()).build();
		DocumentContext json = JsonPath.using(configuration).parse(jsonString);
		return json.set(jPath, updateObject).jsonString();
	}

	public static JSONObject getEnvironmentDetails() {

		JSONParser parser = new JSONParser();
		try {
			File currentDir = new File(".");
			String basePath = currentDir.getCanonicalPath();
			Object obj = parser.parse(new FileReader(basePath + "/src/test/resources/Cloud_Datas/TabascoData.json"));
			JSONObject json = new JSONObject(obj.toString());
			return json;
		} catch (IOException | ParseException | JSONException e) {
			return null;
		}
	}

	private String getDataString(HashMap<String, String> getMap) throws UnsupportedEncodingException {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (Map.Entry<String, String> entry : getMap.entrySet()) {
			if (first)
				first = false;
			else
				result.append("&");
			result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
			result.append("=");
			result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
		}
		return result.toString();
	}

	public boolean getConnectionToken() throws Exception {
		try {
			disableSSLCertificateChecking();
			byte[] postData = getDataString(envDetails).getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			URL url = URI.create(tokenRequestURL).toURL();
			HttpURLConnection tabascoConnection = (HttpURLConnection) url.openConnection();
			tabascoConnection.setDoOutput(true);
			tabascoConnection.setInstanceFollowRedirects(false);
			tabascoConnection.setRequestMethod("POST");
			tabascoConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			tabascoConnection.setRequestProperty("charset", "utf-8");
			tabascoConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			tabascoConnection.setUseCaches(false);
			try (DataOutputStream wr = new DataOutputStream(tabascoConnection.getOutputStream())) {
				wr.write(postData);
				wr.flush();
			}
			System.out.println(tabascoConnection.getResponseMessage());

			if (tabascoConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(tabascoConnection.getInputStream()));

				String inputLine;
				StringBuilder html = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					html.append(inputLine);
				}

				in.close();

				JSONObject jsonObj = new JSONObject(html.toString().trim());

				cookie = tabascoConnection.getHeaderField("Set-Cookie");

				bodyToken = jsonObj.get("access_token").toString();

				isConnected = true;
			} else {
				isConnected = false;
			}

		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		return isConnected;
	}

	@Override
	public void close() throws Exception {
		disconnect();
	}

	public boolean disconnect() {
		if (isConnected) {
			if (tabascoConnection != null) {
				try {
					tabascoConnection.disconnect();
					isConnected = false;
				} catch (Exception e) {
					isConnected = true;
				}

			} else {
				isConnected = false;
			}
		} else {
			isConnected = false;
		}

		return !isConnected;
	}

	public boolean unRegisterDeviceFromDFC(String macID) {
		boolean flag = false;

		return flag;
	}

	public HttpURLConnection doPostRequest(String urlString, String headerData)
			throws MalformedURLException, IOException {
		disableSSLCertificateChecking();
		HttpURLConnection postResponse = null;
		URL url = URI.create(urlString).toURL();
		byte[] postData = headerData.getBytes(StandardCharsets.UTF_8);
		int postDataLength = postData.length;
		postResponse = (HttpURLConnection) url.openConnection();
		postResponse.setRequestMethod("POST");
		postResponse.setRequestProperty("Content-Length", Integer.toString(postDataLength));
		postResponse.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		postResponse.setDoOutput(true);
		postResponse.setDoInput(true);
		postResponse.setRequestProperty("Authorization", "bearer " + bodyToken);
		postResponse.setRequestProperty("X-Forced-ScaleUnit", "lcc02");

		postResponse.setUseCaches(false);
		try (DataOutputStream wr = new DataOutputStream(postResponse.getOutputStream())) {
			wr.write(postData);
			wr.flush();
		}

//		if (!headerData.equals("")) {
//			postResponse.setRequestProperty("Content-Length", Integer.toString(postDataLength));
//			OutputStream os = postResponse.getOutputStream();
//			os.write(headerData.getBytes("UTF-8"));
//			os.flush();
//		}

		return postResponse;
	}

	public HttpURLConnection doGetRequest(String urlString) throws MalformedURLException, IOException {
		disableSSLCertificateChecking();
		HttpURLConnection getResponse = null;
		URL url = URI.create(urlString).toURL();
		getResponse = (HttpURLConnection) url.openConnection();
		getResponse.setRequestProperty("Content-Type", "application/json");
		getResponse.setRequestProperty("Authorization", "bearer " + bodyToken);
//		getResponse.setRequestProperty("Authorization", "bearer " + bodyToken);
		getResponse.setRequestProperty("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
		getResponse.setDoOutput(true);
		getResponse.setRequestMethod("GET");
		return getResponse;
	}

	public HashMap<String, String> checkDeviceRegisterStatus(TestCases testCase, TabascoUtils tsUtil, String urlPath,
			String macID) {
		HashMap<String, String> deviceStatus = new HashMap<String, String>();

		try {
			String url = tobascoURL + urlPath;
			HttpURLConnection connection = tsUtil.doGetRequest(url);
			if (connection != null) {
				int responseCode = connection.getResponseCode();
				System.out.println(connection.getResponseMessage());
				if (responseCode == 200 || responseCode == 201 || responseCode == 202) {
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String inputLine;
					StringBuilder html = new StringBuilder();
					while (!in.ready()) {
					}

					while ((inputLine = in.readLine()) != null) {
						html.append(inputLine);
					}

					in.close();

					JSONObject jsonObj = new JSONObject(html.toString().trim());
					if (jsonObj.has("DeviceId")) {
						String DeviceID = jsonObj.get("DeviceId").toString();
						if (DeviceID.toUpperCase().equals(macID.toUpperCase())) {
							String isOnline = jsonObj.get("Online").toString();
							if (Boolean.valueOf(isOnline)) {
								deviceStatus.put("DEVICE_STATUS", "DATASYNC_COMPLETE");
								deviceStatus.put("RESPONSE_CODE", String.valueOf(responseCode));
							} else {
								deviceStatus.put("DEVICE_STATUS", "DATASYNC_INCOMPLETE");
								deviceStatus.put("RESPONSE_CODE", String.valueOf(responseCode));
							}

						} else {
							deviceStatus.put("DEVICE_STATUS", "MAC_ID_NOTAVAILABLE");
							deviceStatus.put("RESPONSE_CODE", String.valueOf(responseCode));
						}

					} else {
						deviceStatus.put("DEVICE_STATUS", "DEVICE_NOTAVAILABLE");
						deviceStatus.put("RESPONSE_CODE", String.valueOf(responseCode));
					}
				} else {
					deviceStatus.put("DEVICE_STATUS", "DEVICE_NOTREGISTERED");
					deviceStatus.put("RESPONSE_CODE", String.valueOf(responseCode));
				}

			}
		} catch (IOException | JSONException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to :" + e.getMessage());
			deviceStatus.put("DEVICE_STATUS", "EXCEPTION_OCCURED");
			deviceStatus.put("RESPONSE_CODE", "-1");
		}
		return deviceStatus;

	}

	public HttpURLConnection doPutRequest(String urlString, String headerData)
			throws MalformedURLException, IOException {
		disableSSLCertificateChecking();

		HttpURLConnection postResponse = null;
		URL url = URI.create(urlString).toURL();
		postResponse = (HttpURLConnection) url.openConnection();

		postResponse.setRequestMethod("POST");
		postResponse.setDoOutput(true);

		postResponse.setRequestProperty("Authorization", "bearer " + bodyToken);
		postResponse.setRequestProperty("content-type", "application/json");

		if (!headerData.equals("")) {
			postResponse.setRequestProperty("content-length", String.valueOf(headerData.length()));
			OutputStream os = postResponse.getOutputStream();
			os.write(headerData.getBytes("UTF-8"));
			os.flush();
		}

		if (postResponse.getResponseCode() == HttpURLConnection.HTTP_CREATED) {
			System.out.println("Success");
		} else {
			// System.out.println(postResponse.getResponseCode());
		}
		return postResponse;
	}

	public boolean unRegisterDeviceFromCloud(TestCases testCase, TabascoUtils tsUtil, String urlPath, String macID) {
//		HashMap<String, String> response = new HashMap<String, String>();
		boolean flag = false;
		try {
			String url = tabascoRegistrationURL + urlPath;
			JSONObject body = new JSONObject();
			body.put("DeviceId", macID);
			body.put("ResponseChannelId", "Chapi");
			HttpURLConnection connection = tsUtil.doPostRequest(url, body.toString());
			if (connection != null) {
				int responseCode = connection.getResponseCode();
				if (responseCode == 200 || responseCode == 201 || responseCode == 202) {
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					String inputLine;
					StringBuilder html = new StringBuilder();
					while (!in.ready()) {
					}

					while ((inputLine = in.readLine()) != null) {
						html.append(inputLine);
					}
					in.close();

					JSONObject jsonObj = new JSONObject(html.toString().trim());
					if (jsonObj.has("TransactionId")) {
						Keyword.ReportStep_Pass(testCase,
								"Device Unregister from cloud, Cloud response is: Transaction ID = "
										+ jsonObj.get("TransactionId").toString() + ", Response Code is = "
										+ responseCode);
						flag = true;
					} else {
						Keyword.ReportStep_Pass(testCase,
								"Device Unregister from cloud, Cloud response is: Transaction detail = Failed , Response object is = "
										+ jsonObj.toString());
						flag = false;
					}

				} else {
					Keyword.ReportStep_Pass(testCase,
							"Device Unregister from cloud, Cloud response is: Transaction detail = Failed , Response Code is = "
									+ responseCode);
					flag = false;
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to :" + e.getMessage());
			flag = false;
		}
		return flag;
	}
}
