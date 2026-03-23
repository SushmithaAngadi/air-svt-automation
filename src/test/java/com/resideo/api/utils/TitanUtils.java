package com.resideo.utils.api.ufc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

import org.json.JSONArray;
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

public class TitanUtils implements AutoCloseable {

	/**
	 * @param args
	 */
	private static String jsonFileUpdate;
	private String titanURL;
	private HashMap<String, String> envDetails;
	private boolean isConnected;
	private HttpURLConnection titanConnection;
	private HashMap<String, Long> locations;
	private String verificationToken;
	private String accessToken;
	private String sessionID;
	public static String chapiDeviceId;
	public static String thermostatUnit = "";
	public static String startTime = "";
	public static String endTime = "";
	public static String tokenRequestURL;
	public static String titanRegistrationURL;
	public static String Ocp_Apim_Subscription_Key;
	private String titanDeviceID;
	private static String expression = "";

	public boolean isConnected() {
		return isConnected;
	}

	public HttpURLConnection getCHILConnection() {
		return titanConnection;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public String getBodyToken() {
		return accessToken;
	}

	public String getSessionID() {
		return sessionID;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, String> getEnvMap(String envDetail) throws JsonSyntaxException, JSONException {
		Gson gson = new Gson();
		Map<String, String> map = gson.fromJson(getEnvironmentDetails().getJSONObject(envDetail).toString(), Map.class);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.putAll(map);
		return hashMap;
	}

	public TitanUtils(TestCaseInputs inputs) throws Exception {

		String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
		environment = environment.replaceAll("\\s", "");
		if (environment.equalsIgnoreCase("Production")) {
			envDetails = getEnvMap("Titan_Prod");
			titanURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TITAN_PRODUCTION");
			tokenRequestURL = "https://lyricprod.b2clogin.com/lyricprod.onmicrosoft.com/oauth2/v2.0/token?p=B2C_1A_SIGNIN_MOB_HH";
			Ocp_Apim_Subscription_Key = "cbdd9447db514da3ba56a217c9e5c0e3";
		} else if (environment.equalsIgnoreCase("CHILStage(Azure)")) {
			envDetails = getEnvMap("Titan_Stage");
			titanURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TITAN_STAGE");
			tokenRequestURL = "https://lyricprod.b2clogin.com/lyricprod.onmicrosoft.com/oauth2/v2.0/token?p=B2C_1A_SIGNIN_MOB_HH";
			Ocp_Apim_Subscription_Key = "cbdd9447db514da3ba56a217c9e5c0e3";
		} else if (environment.equalsIgnoreCase("ChilDas(QA)")) {
			envDetails = getEnvMap("Titan_QA");
			titanURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "TABASCO_QA");
			tokenRequestURL = "https://login.microsoftonline.com/4722b4c2-6388-4c69-9cfb-f950ea762665/oauth2/v2.0/token";
			titanRegistrationURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
					"TABASCO_REGISTRATION_QA");
			Ocp_Apim_Subscription_Key = "a5df5670e6a644e9aa9014529e4bf672";
		}
//		this.inputs = inputs;
		this.isConnected = false;
		locations = new HashMap<String, Long>();
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
			Object obj = parser.parse(new FileReader(basePath + "/src/test/resources/Cloud_Datas/TitanData.json"));
			JSONObject json = new JSONObject(obj.toString());
			jsonFileUpdate = json.toString();
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

	public boolean getConnectionToken(TestCases testCase) throws Exception {
		try {
			disableSSLCertificateChecking();
			byte[] postData = getDataString(envDetails).getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			URL url = URI.create(tokenRequestURL).toURL();
			HttpURLConnection titanConnection = (HttpURLConnection) url.openConnection();
			titanConnection.setDoOutput(true);
			titanConnection.setInstanceFollowRedirects(false);
			titanConnection.setRequestMethod("POST");
			titanConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			titanConnection.setRequestProperty("charset", "utf-8");
			titanConnection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			titanConnection.setUseCaches(false);
			try (DataOutputStream wr = new DataOutputStream(titanConnection.getOutputStream())) {
				wr.write(postData);
				wr.flush();
			}
//			System.out.println(titanConnection.getResponseMessage());

			if (titanConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(titanConnection.getInputStream()));

				String inputLine;
				StringBuilder html = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					html.append(inputLine);
				}

				in.close();

				JSONObject jsonObj = new JSONObject(html.toString().trim());

//				cookie = titanConnection.getHeaderField("Set-Cookie");

				accessToken = jsonObj.get("access_token").toString();
				String refreshToken = jsonObj.get("refresh_token").toString();
				String filePath = new File(".").getCanonicalPath() + "/src/test/resources/Cloud_Datas/TitanData.json";
				updateAndWriteIntoJsonFile(testCase, filePath, "$.Titan_Prod.refresh_token", refreshToken);
				isConnected = true;
			} else {
				isConnected = false;
			}

		} catch (Exception e) {
			throw new Exception("Error Occured: " + e.getMessage());
		}
		return isConnected;
	}

	public static boolean updateAndWriteIntoJsonFile(TestCases testCase, String path, String jsonPath,
			String newValue) {
		try {
			Gson gson = new Gson();
			DocumentContext doc = JsonPath.parse(jsonFileUpdate.toString()).set(jsonPath, newValue);
			Object json = doc.json();
//			System.out.println(doc.jsonString());
			FileWriter file = new FileWriter(path);
			gson.toJson(json, file);
			file.close();
			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Raised in Titan Utils , Update and Write into json File methos, Exception due to "
							+ e.getMessage());
			return false;
		}

	}

	@Override
	public void close() throws Exception {
		disconnect();
	}

	public boolean disconnect() {
		if (isConnected) {
			if (titanConnection != null) {
				try {
					titanConnection.disconnect();
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

	public HashMap<String, String> checkDeviceRegisterStatus(TestCases testCase, TitanUtils tsUtil, String urlPath,
			String macID) {
		HashMap<String, String> deviceStatus = new HashMap<String, String>();

		try {
			String url = titanURL + urlPath;
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

	public boolean getDeviceLocation(TestCases testCase, TitanUtils tsUtil, String urlPath) {
		String url = titanURL + urlPath;
		boolean flag = false;
		try {
			HttpURLConnection connection = tsUtil.doGetRequest(url);
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
					JSONArray jsonobjArray = new JSONArray(html.toString().trim());
					if (((JSONObject) jsonobjArray.get(0)).get("id").toString() != null) {
						for (int i = 0; i < jsonobjArray.length(); i++) {
							JSONObject object = (JSONObject) jsonobjArray.get(i);
							String locationID = object.get("id").toString();
							String locationName = object.get("name").toString();
							locations.put(locationName, Long.valueOf(locationID));
						}
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"There is no Location under this Credential, Check if the device Has Proper location");
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Error Occured in API, Error is " + connection.getResponseMessage());
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Error Occured in API, HTTP URL CONNECTION method got failed");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured in TitalUtil Class => getDeviceLocation() method, Due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public boolean getTitanDeviceID(TestCases testCase, TitanUtils tsUtil, String urlPath, String macID) {
		int size = locations.size();
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			try {
				String url = titanURL + "locations/" + locations.get(locations.keySet().toArray()[i])
						+ "/devices/info?supportedtypes=[L5leakprotectionvalve]";

				HttpURLConnection connection = tsUtil.doGetRequest(url);
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
						JSONArray jsonobjArray = new JSONArray(html.toString().trim());
						if (jsonobjArray.length() == 0) {
							expression = "NO VALVE DEVIE FOUND IN THIS ACCOUNT";
							flag = true;
						} else {
							for (int j = 0; j < jsonobjArray.length(); j++) {
								JSONObject object = (JSONObject) jsonobjArray.get(j);
								String valueByJsonPath = getValueByJsonPath(object.toString(),
										"$.identifier.serialText");
								if (valueByJsonPath.equals(macID)) {
									Keyword.ReportStep_Pass(testCase,
											"Expected Device Available in this Location : "
													+ locations.get(locations.keySet().toArray()[i])
													+ ", Registered Device Name is " + valueByJsonPath);
									titanDeviceID = getValueByJsonPath(object.toString(), "$.id");
									flag = true;
									expression = "DEVICE FOUND";
//								break;
								} else {
									flag = false;
									expression = "NOT FOUND";
								}
							}
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Error Occured in API, Error is " + connection.getResponseMessage());
						flag = false;
					}
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Error Occured in API, HTTP URL CONNECTION method got failed");
					flag = false;
				}
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Exception Occured in TitalUtil Class => getTitanDeviceID() method, Due to " + e.getMessage());
				flag = false;
			}

			if (expression.equals("DEVICE FOUND"))
				break;
		}

		if (expression.equals("NOT FOUND")) {
			Keyword.ReportStep_Pass(testCase, "NO Device found in any location");
			flag = true;
		} else if (expression.equals("NO VALVE DEVIE FOUND IN THIS ACCOUNT")) {
			Keyword.ReportStep_Pass(testCase, "NO Valve Device Found in this Account");
			flag = true;
		} else if (expression.equals("DEVICE FOUND")) {
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION, "NO Device found in any location");
			flag = false;
		}
		return flag;
	}

	public boolean deleteTitanDevicefromTitan(TestCases testCase, TitanUtils tsUtil, String macID) {
		boolean flag = false;
		try {
			String url = titanURL + "/devices/" + titanDeviceID;
			HttpURLConnection connection = tsUtil.doDeleteRequest(url);
			if (connection != null) {
				int responseCode = connection.getResponseCode();
				if (responseCode == 204) {
					flag = true;
					Keyword.ReportStep_Pass(testCase,
							"Device is Unregister from Titan Cloud, Response code is " + responseCode
									+ ", unregistered Device Mac ID is " + macID + ", Titan device ID Is "
									+ titanDeviceID);
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Error Occured in API, Error is " + connection.getResponseMessage());
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Error Occured in API, HTTP URL CONNECTION method got failed");
				flag = false;
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured in TitalUtil Class => getDeviceLocation() method, Due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public HttpURLConnection doGetRequest(String urlString) throws MalformedURLException, IOException {
		disableSSLCertificateChecking();
		HttpURLConnection getResponse = null;
		URL url = URI.create(urlString).toURL();
		getResponse = (HttpURLConnection) url.openConnection();
		getResponse.setRequestProperty("Content-Type", "application/json");
		getResponse.setRequestProperty("Authorization", "Bearer " + accessToken);
//					getResponse.setRequestProperty("Authorization",
//							"bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6ImxLZVJKYS1selNyOXdVYlladmsxelF6TEg5N0ZleGdhbVVhb1ctYS1lcm8ifQ.eyJpc3MiOiJodHRwczovL2x5cmljcHJvZC5iMmNsb2dpbi5jb20vMzlkYWU2YjUtYzhhMy00NGIzLTlmZDYtMGRhNzFiOTliZjU5L3YyLjAvIiwiZXhwIjoxNjM4OTQ1MTY1LCJuYmYiOjE2Mzg5NDQyNjUsImF1ZCI6IjQ5ZThlMjY5LWE3NjAtNDBiNy05NmM3LWZmZGVhOWViZWFjYyIsIm9pZCI6IjBjNjJiY2U4LTc1OTQtNDAwNS04NTZhLTRkMThhNzdlODllOSIsInN1YiI6IjBjNjJiY2U4LTc1OTQtNDAwNS04NTZhLTRkMThhNzdlODllOSIsImZpcnN0X25hbWUiOiJDYXNwaWFuIiwibGFzdF9uYW1lIjoiQXV0bWF0aW9uIiwiY291bnRyeSI6IlVTIiwidXBuIjoiMGM2MmJjZTgtNzU5NC00MDA1LTg1NmEtNGQxOGE3N2U4OWU5QGx5cmljcHJvZC5vbm1pY3Jvc29mdC5jb20iLCJjcmVhdGlvbnNvdXJjZSI6IkhIQXBwIiwibGFuZ3VhZ2VfY29kZSI6ImVuIiwic2NwIjoidXNlcl9pbXBlcnNvbmF0aW9uIiwiYXpwIjoiNzdkN2NhNWItNmY5Ny00ZTc3LTlkMjYtYjAxNDg3NDIwMmI1IiwidmVyIjoiMS4wIiwiaWF0IjoxNjM4OTQ0MjY1fQ.R9jltwLBV6eAKlBGx57nxvPq0b40NhAM0VjtE3ClpJ95TEqZJV3-rXnyY1zpVAMRlAgU32TUS2X6leVeiJNKEloCWNZMdE-oYVqd_7qBMktVioTyPArZOFNTZ3bZpY0Ow4ua7VIQ09vpeILA0o5qGPDNcrQ5mz5kn9F7QjTYcUEykAlKYK3RVOp2bwkm7ZmI3Xx2O8Xr9lXwn3WDQ9TqN5PK6rkh_oxn0BDtyJPqmz3waeOIulXDZRWpwvTp_vYV46EUCoD1buGLPtkaxwgFJfvb7EBAKXBHuaFLmCNPWpaAazF62JTFBFo1y84slHlEN7afazVHGq3vyMtPzENu_w");
		getResponse.setRequestProperty("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
		getResponse.setDoOutput(true);
		getResponse.setRequestMethod("GET");
		return getResponse;
	}

	public HttpURLConnection doDeleteRequest(String urlString) throws MalformedURLException, IOException {
		disableSSLCertificateChecking();
		HttpURLConnection deleteResponse = null;
		URL url = URI.create(urlString).toURL();
		deleteResponse = (HttpURLConnection) url.openConnection();
		deleteResponse.setRequestProperty("Content-Type", "application/json");
		deleteResponse.setRequestProperty("Authorization", "Bearer " + accessToken);
		deleteResponse.setRequestProperty("Ocp-Apim-Subscription-Key", Ocp_Apim_Subscription_Key);
		deleteResponse.setDoOutput(true);
		deleteResponse.setRequestMethod("DELETE");
		return deleteResponse;
	}

	public HttpURLConnection doPutRequest(String urlString, String headerData)
			throws MalformedURLException, IOException {
		disableSSLCertificateChecking();

		HttpURLConnection postResponse = null;
		URL url = URI.create(urlString).toURL();
		postResponse = (HttpURLConnection) url.openConnection();

		postResponse.setRequestMethod("POST");
		postResponse.setDoOutput(true);

		postResponse.setRequestProperty("Authorization", "bearer " + accessToken);
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
		postResponse.setRequestProperty("Authorization", "bearer " + accessToken);
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

	public static boolean unregisterDeviceFromTitanCloud(TestCases testCase, TestCaseInputs inputs, String macID) {
		boolean flag = false;
		try {
			TitanUtils titanClass = new TitanUtils(inputs);
			flag = titanClass.getConnectionToken(testCase);
			flag = flag && titanClass.getDeviceLocation(testCase, titanClass, "locations");
			if (titanClass.getTitanDeviceID(testCase, titanClass,
					"/devices/info?supportedtypes=[L5leakprotectionvalve]", macID)) {
				if (expression.equals("DEVICE FOUND")) {
					flag = flag && titanClass.deleteTitanDevicefromTitan(testCase, titanClass, macID);
					flag = true;
				} else if (expression.equals("NO VALVE DEVIE FOUND IN THIS ACCOUNT")) {
					Keyword.ReportStep_Pass(testCase,
							"There is no Valve device in any location for this Account, if its not a case, check with app log for more information");
					flag = true;
				} else if (expression.equals("NOT FOUND")) {
					Keyword.ReportStep_Pass(testCase,
							"Device is not register in any location for this Account, if its not a case, check with app log for more information");
					flag = true;
				} else {
					flag = false;
				}
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception Occured in TitalUtil Class => unregisterDeviceFromTitanCloud() method, Due to "
							+ e.getMessage());
			flag = false;
		}

		return flag;
	}

}
