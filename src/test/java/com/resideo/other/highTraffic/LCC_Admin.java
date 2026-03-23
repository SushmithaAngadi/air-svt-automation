package com.resideo.system.utils;

import java.time.Duration;

import org.json.JSONObject;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.utils.api.dfc.DefaultTrustManager;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LCC_Admin {

	private final static OkHttpClient client = DefaultTrustManager.getUnsafeOkHttpClient().newBuilder().build();
//	private final static OkHttpClient client = TrustAllCertsClient.getTrustAllCertsClient();
//	private final static OkHttpClient client = new OkHttpClient().newBuilder().build();

	@SuppressWarnings("unused")
	private static String lcc01_url = null;
	@SuppressWarnings("unused")
	private static String lcc02_url = null;
	private static String GDR_url = null;
	private static String Registration_url = null;
	private static String FirmwareUpgrade_url = null;
	private static String clientID = null;
	private static String clientSecret = null;
	private static String Device_resource = null;
	private static String tenant = null;
	private static String Registration_resource = null;
	private static String GDR_resource = null;
	private static String FirmwareUpgrade_resource = null;
	private static String scaleUnit_url = null;
	private static String currentURL = null;

	private static String device_AccessToken = null;
	private static String registration_AccessToken = null;
	private static String gdr_AccessToken = null;
	private static String firmwareUpgrade_AccessToken = null;

	private static String stage_lcc01_url = "https://lcc01.stage.cloudenv.net";
	private static String stage_lcc02_url = "https://lcc02.stage.cloudenv.net";
	private static String stage_GDR_url = "https://registry.stage.cloudenv.net";
	private static String stage_Registration_url = "https://reg.stage.cloudenv.net";
	private static String stage_FirmwareUpgrade_url = "https://fwu.stage.cloudenv.net";
	private static String stage_clientID = "03e55594-9f83-4c0f-a2c4-82c2cd912bdd";
	private static String stage_clientSecret = "2~h8Q~ZstrfjdSSmn182m9jyhqGHh4WzUe3fzctt";
	private static String stage_Device_resource = "https://lyricwlddev.onmicrosoft.com/lcc.stage.lccsu";
	private static String stage_tenant = "lyricwlddev.onmicrosoft.com";
	private static String stage_Registration_resource = "https://lyricwlddev.onmicrosoft.com/lcc.stage.reg";
	private static String stage_GDR_resource = "https://lyricwlddev.onmicrosoft.com/lcc.stage.registry";
	private static String stage_FirmwareUpgrade_resource = "https://lyricwlddev.onmicrosoft.com/lcc.stage.fwu";

	private static String qa_lcc01_url = "https://lcc01.qa.cloudenv.net";
	private static String qa_lcc02_url = "https://lcc02.qa.cloudenv.net";
	private static String qa_GDR_url = "https://registry.qa.cloudenv.net";
	private static String qa_Registration_url = "https://reg.stage.cloudenv.net";
	private static String qa_FirmwareUpgrade_url = "https://fwu.qa.cloudenv.net";
	private static String qa_clientID = "f0cfd3d7-f03d-4202-8963-6716dee2259f";
	private static String qa_clientSecret = "~2O9qDJwlZgawI6.ln0a3T-Zi-an8YWT0t";
	private static String qa_Device_resource = "https://lyricwlddev.onmicrosoft.com/lcc.qa.lccsu";
	private static String qa_tenant = "lyricwlddev.onmicrosoft.com";
	private static String qa_Registration_resource = "https://lyricwlddev.onmicrosoft.com/lcc.qa.reg";
	private static String qa_GDR_resource = "https://lyricwlddev.onmicrosoft.com/lcc.qa.registry";
	private static String qa_FirmwareUpgrade_resource = "https://lyricwlddev.onmicrosoft.com/lcc.qa.fwu";

	private static String prod_lcc01_url = "https://lcc01.clouddevice.io";
	private static String prod_lcc02_url = "https://lcc02.clouddevice.io";
	private static String prod_GDR_url = "https://registry.clouddevice.io";
	private static String prod_Registration_url = "https://reg.clouddevice.io";
	private static String prod_FirmwareUpgrade_url = "https://fwuprod.clouddevice.io";
	private static String prod_clientID = "6ce36880-d65f-40d5-ae20-aa111629e484";
	private static String prod_clientSecret = "Ujx8Q~.fJstMNKXoen9pQ8Al~x92VpLzpun_Kdnl";
	private static String prod_Device_resource = "https://LyricEcosystemProd.onmicrosoft.com/lcc.prodsf.lccsu";
	private static String prod_tenant = "LyricEcosystemProd.onmicrosoft.com";
	private static String prod_Registration_resource = "https://LyricEcosystemProd.onmicrosoft.com/lcc.prodsf.reg";
	private static String prod_GDR_resource = "https://LyricEcosystemProd.onmicrosoft.com/lcc.prodsf.registry";
	private static String prod_FirmwareUpgrade_resource = "https://LyricEcosystemProd.onmicrosoft.com/lcc.prodsf.fwu";

	public static enum Enum_Token {
		Device_Access, Registration, GDR, FWU
	}

	public static String getEnumToken(Enum_Token accessToken) {
		switch (accessToken) {
		case Device_Access:
			currentURL = scaleUnit_url;
			return device_AccessToken;
		case Registration:
			currentURL = Registration_url;
			return registration_AccessToken;
		case GDR:
			currentURL = GDR_url;
			return gdr_AccessToken;
		case FWU:
			currentURL = FirmwareUpgrade_url;
			return firmwareUpgrade_AccessToken;
		default:
			return null;
		}
	}

	public static boolean lcc_Admin(TestCaseInputs inputs) throws Exception {
		boolean flag = false;
		try {
			String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
//			String environment = "Production";
			environment = environment.replaceAll("\\s", "");
			if (environment.equalsIgnoreCase("Production")) {

				lcc01_url = prod_lcc01_url;
				lcc02_url = prod_lcc02_url;
				GDR_url = prod_GDR_url;
				Registration_url = prod_Registration_url;
				FirmwareUpgrade_url = prod_FirmwareUpgrade_url;
				clientID = prod_clientID;
				clientSecret = prod_clientSecret;
				Device_resource = prod_Device_resource;
				tenant = prod_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = prod_lcc01_url;
				} else {
					scaleUnit_url = prod_lcc02_url;
				}

				Registration_resource = prod_Registration_resource;
				GDR_resource = prod_GDR_resource;
				FirmwareUpgrade_resource = prod_FirmwareUpgrade_resource;

				flag = true;
			} else if (environment.equalsIgnoreCase("CHILInt(Azure)")) {
				lcc01_url = qa_lcc01_url;
				lcc02_url = qa_lcc02_url;
				GDR_url = qa_GDR_url;
				Registration_url = qa_Registration_url;
				FirmwareUpgrade_url = qa_FirmwareUpgrade_url;
				clientID = qa_clientID;
				clientSecret = qa_clientSecret;
				Device_resource = qa_Device_resource;
				tenant = qa_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = qa_lcc01_url;
				} else {
					scaleUnit_url = qa_lcc02_url;
				}

				Registration_resource = qa_Registration_resource;
				GDR_resource = qa_GDR_resource;
				FirmwareUpgrade_resource = qa_FirmwareUpgrade_resource;
				flag = true;
			} else if (environment.equalsIgnoreCase("CHILStage(Azure)")) {
				lcc01_url = stage_lcc01_url;
				lcc02_url = stage_lcc02_url;
				GDR_url = stage_GDR_url;
				Registration_url = stage_Registration_url;
				FirmwareUpgrade_url = stage_FirmwareUpgrade_url;
				clientID = stage_clientID;
				clientSecret = stage_clientSecret;
				Device_resource = stage_Device_resource;
				tenant = stage_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = stage_lcc01_url;
				} else {
					scaleUnit_url = stage_lcc02_url;
				}

				Registration_resource = stage_Registration_resource;
				GDR_resource = stage_GDR_resource;
				FirmwareUpgrade_resource = stage_FirmwareUpgrade_resource;
				flag = true;
			}
		} catch (Exception e) {
			new Throwable("Provided Environment not available");
			flag = false;
		}

		return flag;
	}

	public static boolean lcc_Admin(String environment) throws Exception {
		boolean flag = false;
		try {
			if (environment.equalsIgnoreCase("Production")) {

				lcc01_url = prod_lcc01_url;
				lcc02_url = prod_lcc02_url;
				GDR_url = prod_GDR_url;
				Registration_url = prod_Registration_url;
				FirmwareUpgrade_url = prod_FirmwareUpgrade_url;
				clientID = prod_clientID;
				clientSecret = prod_clientSecret;
				Device_resource = prod_Device_resource;
				tenant = prod_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = prod_lcc01_url;
				} else {
					scaleUnit_url = prod_lcc02_url;
				}

				Registration_resource = prod_Registration_resource;
				GDR_resource = prod_GDR_resource;
				FirmwareUpgrade_resource = prod_FirmwareUpgrade_resource;

				flag = true;
			} else if (environment.equalsIgnoreCase("CHILInt(Azure)")) {
				lcc01_url = qa_lcc01_url;
				lcc02_url = qa_lcc02_url;
				GDR_url = qa_GDR_url;
				Registration_url = qa_Registration_url;
				FirmwareUpgrade_url = qa_FirmwareUpgrade_url;
				clientID = qa_clientID;
				clientSecret = qa_clientSecret;
				Device_resource = qa_Device_resource;
				tenant = qa_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = qa_lcc01_url;
				} else {
					scaleUnit_url = qa_lcc02_url;
				}

				Registration_resource = qa_Registration_resource;
				GDR_resource = qa_GDR_resource;
				FirmwareUpgrade_resource = qa_FirmwareUpgrade_resource;
				flag = true;
			} else if (environment.equalsIgnoreCase("CHILStage(Azure)")) {
				lcc01_url = stage_lcc01_url;
				lcc02_url = stage_lcc02_url;
				GDR_url = stage_GDR_url;
				Registration_url = stage_Registration_url;
				FirmwareUpgrade_url = stage_FirmwareUpgrade_url;
				clientID = stage_clientID;
				clientSecret = stage_clientSecret;
				Device_resource = stage_Device_resource;
				tenant = stage_tenant;

				scaleUnit_url = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "LCC_SU");
				if (scaleUnit_url.equalsIgnoreCase("LCC01")) {
					scaleUnit_url = stage_lcc01_url;
				} else {
					scaleUnit_url = stage_lcc02_url;
				}

				Registration_resource = stage_Registration_resource;
				GDR_resource = stage_GDR_resource;
				FirmwareUpgrade_resource = stage_FirmwareUpgrade_resource;
				flag = true;
			}
		} catch (Exception e) {
			new Throwable("Provided Environment not available");
			flag = false;
		}

		return flag;
	}

//	@SuppressWarnings("unused")
	public static boolean request_Device_AccessToken(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		try {
			if (lcc_Admin(inputs)) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials")
						.addFormDataPart("resource", Device_resource).build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					device_AccessToken = json.get("access_token").toString();
					System.out.println(device_AccessToken);
					flag = true;
				} else {
					device_AccessToken = null;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_Device_AccessToken() {
		boolean flag = false;
		try {
			if (lcc_Admin("CHILStage(Azure)")) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials")
						.addFormDataPart("resource", Device_resource).build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					device_AccessToken = json.get("access_token").toString();
					System.out.println(device_AccessToken);
					flag = true;
				} else {
					device_AccessToken = null;
					System.out.println("Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				System.out.println("Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_Registration_AccessToken(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		try {
			if (lcc_Admin(inputs)) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials")
						.addFormDataPart("resource", Registration_resource).build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
//					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					registration_AccessToken = json.get("access_token").toString();
//					System.out.println(registration_AccessToken);
					flag = true;
				} else {
					registration_AccessToken = null;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_Registration_AccessToken() {
		boolean flag = false;
		try {
			if (lcc_Admin("CHILStage(Azure)")) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials")
						.addFormDataPart("resource", Registration_resource).build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
//					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					registration_AccessToken = json.get("access_token").toString();
//					System.out.println(registration_AccessToken);
					flag = true;
				} else {
					registration_AccessToken = null;
					System.out.println("Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				System.out.println("Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_GDR_AccessToken(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		try {
			if (lcc_Admin(inputs)) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials").addFormDataPart("resource", GDR_resource)
						.build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					gdr_AccessToken = json.get("access_token").toString();
					System.out.println(gdr_AccessToken);
					flag = true;
				} else {
					gdr_AccessToken = null;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_GDR_AccessToken() {
		boolean flag = false;
		try {
			if (lcc_Admin("CHILStage(Azure)")) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials").addFormDataPart("resource", GDR_resource)
						.build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					gdr_AccessToken = json.get("access_token").toString();
					System.out.println(gdr_AccessToken);
					flag = true;
				} else {
					gdr_AccessToken = null;
					System.out.println("Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				System.out.println("Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean request_FWU_AccessToken(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		try {
			if (lcc_Admin(inputs)) {
//				MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
						.addFormDataPart("client_id", clientID).addFormDataPart("client_secret", clientSecret)
						.addFormDataPart("grant_type", "client_credentials")
						.addFormDataPart("resource", FirmwareUpgrade_resource).build();
				Request request = new Request.Builder()
						.url("https://login.microsoftonline.com/" + tenant + "/oauth2/token").method("POST", body)
//						.addHeader("Cookie",
//								"fpc=AjyGVrYieWtBhRkTmUn5N35n1EtUAQAAAIDqqNoOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
						.build();
				Response response = client.newCall(request).execute();
				int code = response.code();
				String response_api = response.body().string();
				if (code == 200) {
					System.out.println(response_api);
					JSONObject json = new JSONObject(response_api);
					firmwareUpgrade_AccessToken = json.get("access_token").toString();
					System.out.println(firmwareUpgrade_AccessToken);
					flag = true;
				} else {
					firmwareUpgrade_AccessToken = null;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Status code is mismatch , Status code is " + code);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Provided environment showing wring");
				flag = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static void getDevice(TestCases testCase, TestCaseInputs inputs) {
		try {
			System.out.println();
//			OkHttpClient client = new OkHttpClient().newBuilder().build();
//			MediaType mediaType = MediaType.parse("text/plain");
//			RequestBody body = RequestBody.create("", mediaType);
			Request request = new Request.Builder().url(scaleUnit_url + "/api/v1/device/48A2E64C90F2").get()
					.addHeader("Authorization", "Bearer " + device_AccessToken).build();
			Response response = client.newCall(request).execute();
			System.out.println(response.code());
			System.out.println(response.body().string());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static Response get(TestCases testCase, Enum_Token accessToken_Type, String pathurl) {
		try {
			String accessTk = getEnumToken(accessToken_Type);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + pathurl).get()
					.addHeader("Authorization", "Bearer " + accessTk).build();
			return client.newCall(request).execute();
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			return null;
		}
	}

	private static Response get(Enum_Token accessToken_Type, String pathurl) {
		try {
			String accessTk = getEnumToken(accessToken_Type);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + pathurl).get()
					.addHeader("Authorization", "Bearer " + accessTk).build();
			return client.newCall(request).execute();
		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
			return null;
		}
	}

	public static Response put(TestCases testCase, Enum_Token accessToken_Type, String pathurl) {
		try {
			String accessTk = getEnumToken(accessToken_Type);
			MediaType mediaType = MediaType.parse("text/plain");
			RequestBody body = RequestBody.create("", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + pathurl)
//			  .put()
					.method("PUT", body).addHeader("Authorization", "Bearer " + accessTk).build();
			Response response = client.newCall(request).execute();
			return response;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			return null;
		}
	}

	public static boolean changeDevice_RegistrationState(TestCases testCase, TestCaseInputs inputs,
			Enum_Token getEnumToken, String macID, String ChannelId) {
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(
					"{\r\n  \"DeviceId\": \"" + macID + "\",\r\n  \"ResponseChannelId\": \"" + ChannelId + "\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/unregistration").method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {

				if (getRegistrationInfo(testCase, inputs, "device/" + macID, "DeviceNotInScaleUnit")) {
					Keyword.ReportStep_Pass(testCase,
							"Registration status chaged to Unregistered, Reponse body is " + repsonseBody);
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Registration Status Change failed to " + repsonseBody);
					flag = false;
				}
			} else if (code == 403) {
				flag = false;
				Keyword.ReportStep_Pass(testCase, "Device in locked state, Need some time to revocer back");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to change Registration State, Response code is : " + code + " , Reponse Body is "
								+ repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean changeDevice_RegistrationState(Enum_Token getEnumToken, String macID, String ChannelId) {
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(
					"{\r\n  \"DeviceId\": \"" + macID + "\",\r\n  \"ResponseChannelId\": \"" + ChannelId + "\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/unregistration").method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {

				if (getRegistrationInfo("device/" + macID, "DeviceNotInScaleUnit")) {
					System.out.println("Registration status chaged to Unregistered, Reponse body is " + repsonseBody);
					flag = true;
				} else {
					System.out.println("Registration Status Change failed to " + repsonseBody);
					flag = false;
				}
			} else if (code == 403) {
				flag = false;
				System.out.println("Device in locked state, Need some time to revocer back");
			} else {
				System.out.println("Unable to change Registration State, Response code is : " + code
						+ " , Reponse Body is " + repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean checkAndDelete_Registration(TestCases testCase, TestCaseInputs inputs, String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken(testCase, inputs)) {
			if (!getRegistrationInfo(testCase, inputs, "device/" + macID, "DeviceNotInScaleUnit")) {
				flag = changeDevice_RegistrationState(testCase, inputs, Enum_Token.Registration, macID, "CHAPI");
			} else {
				Keyword.ReportStep_Pass(testCase, "Device Already unregister during DIY");
				flag = true;
			}

		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to get Access Token from LCC Admin");
			flag = false;
		}

		return flag;

	}

	public static boolean checkAndDelete_Registration(String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken()) {
			if (!getRegistrationInfo("device/" + macID, "DeviceNotInScaleUnit")) {
				flag = changeDevice_RegistrationState(Enum_Token.Registration, macID, "CHAPI");
			} else {
				System.out.println("Device Already unregister during DIY");
				flag = true;
			}

		} else {
			System.out.println("Failed to get Access Token from LCC Admin");
			flag = false;
		}

		return flag;

	}

	public static boolean getdeviceInfo(TestCases testCase, TestCaseInputs inputs, String macID) {
		boolean flag = false;
		if (checkAndDelete_Registration(testCase, inputs, macID)) {
			if (checkAndDelete_GDRInfo(testCase, inputs, macID)) {
				Keyword.ReportStep_Pass(testCase, "Device Unregistered from cloud");
				flag = true;
			}
		}
		return flag;

	}

	public static boolean getdeviceInfo(String macID) {
		boolean flag = false;
		if (checkAndDelete_Registration(macID)) {
			if (checkAndDelete_GDRInfo(macID)) {
				System.out.println("Device Unregistered from cloud");
				flag = true;
			}
		}
		return flag;

	}

	public static boolean restartDevice(TestCases testCase, TestCaseInputs inputs, String... macID) {

		boolean flag = true;
		try {
			if (request_Device_AccessToken(testCase, inputs)) {
//		for (int i = 0; i < macID.length; i++) {
//			String mac = macID[i];
				try {
//				if(request_Device_AccessToken(testCase, inputs)) {

					for (int i = 0; i < macID.length; i++) {
						String mac = macID[i];

						flag = request_deviceRestart(testCase, Enum_Token.Device_Access, "admin/RestartDeviceRemotely/",
								mac);
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Exception occured due to " + e.getMessage());
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to get Access Token from LCC Admin");
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
		}
		return flag;
	}

	public static boolean doRegisterLCCDeviceInAdminPortal(TestCases testCase, TestCaseInputs inputs, String modelname,
			String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken(testCase, inputs)) {

			if (post_RegisterDevice(testCase, inputs, Enum_Token.Registration, "registration", macID)) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Registration failed for this model name " + modelname + " , Mac ID : " + macID);
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to get Registration Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean doRegisterLCCDeviceInAdminPortal(String modelname, String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken()) {

			if (post_RegisterDevice(Enum_Token.Registration, "registration", macID)) {
				flag = true;
			} else {
				System.out.println("Registration failed for this model name " + modelname + " , Mac ID : " + macID);
				flag = false;
			}

		} else {
			System.out.println("Not able to get Registration Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean doUnRegisterLCCDeviceInAdminPortal(TestCases testCase, TestCaseInputs inputs,
			String modelname, String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken(testCase, inputs)) {

			if (post_UnRegisterDevice(testCase, inputs, Enum_Token.Registration, "unregistration", macID)) {
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Registration failed for this model name " + modelname + " , Mac ID : " + macID);
				flag = false;
			}

		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to get Registration Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean doUnRegisterLCCDeviceInAdminPortal(String modelname, String macID) {
		boolean flag = false;
		if (request_Registration_AccessToken()) {

			if (post_UnRegisterDevice(Enum_Token.Registration, "unregistration", macID)) {
				flag = true;
			} else {
				System.out.println("UnRegistration failed for this model name " + modelname + " , Mac ID : " + macID);
				flag = false;
			}

		} else {
			System.out.println("Not able to get unRegistration Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean getRegistrationInfo(TestCases testCase, TestCaseInputs inputs, String url,
			String expectedString) {
		boolean flag = false;
		try {
			request_Device_AccessToken(testCase, inputs);
			FluentWait<String> fWait = new FluentWait<String>(url);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(11));
			Boolean isEventReceived = fWait.until(new Function<String, Boolean>() {
				public Boolean apply(String str) {
					try {
						Response response = get(testCase, Enum_Token.Device_Access, url);

						System.out.println(response.body().string());
						int code = response.code();
						String body = response.body().string();
						if (code == 404) {

							if (body.toUpperCase().contains(expectedString.toUpperCase())) {
								Keyword.ReportStep_Pass(testCase, "Device unregistered from cloud, Get Device Details");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Device Current Registration State is " + body
										+ " , Expected state is " + expectedString);
								System.out.println("Reponse body is " + body + "  Mismatch. retry ......");
								return false;
							}
						} else {

//							if (code == 200) {
//								request_Registration_AccessToken(testCase, inputs);
//								return false;
//							}
							return false;
						}
					} catch (TimeoutException e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Retry Over, Failed to change device GDR State");
						return false;
					} catch (Exception e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to find, Whether LoggedIn or not");
						return false;
					}
				}
			});

			flag = isEventReceived;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static boolean getRegistrationInfo(String url, String expectedString) {
		boolean flag = false;
		try {
			request_Device_AccessToken();
			FluentWait<String> fWait = new FluentWait<String>(url);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(11));
			Boolean isEventReceived = fWait.until(new Function<String, Boolean>() {
				public Boolean apply(String str) {
					try {
						Response response = get(Enum_Token.Device_Access, url);

						System.out.println(response.body().string());
						int code = response.code();
						String body = response.body().string();
						if (code == 404) {

							if (body.toUpperCase().contains(expectedString.toUpperCase())) {
								System.out.println("Device unregistered from cloud, Get Device Details");
								return true;
							} else {
								System.out.println("Device Current Registration State is " + body
										+ " , Expected state is " + expectedString);
								System.out.println("Reponse body is " + body + "  Mismatch. retry ......");
								return false;
							}
						} else {

//							if (code == 200) {
//								request_Registration_AccessToken(testCase, inputs);
//								return false;
//							}
							return false;
						}
					} catch (TimeoutException e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Retry Over, Failed to change device GDR State");
						return false;
					} catch (Exception e) {
//					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
//							"Not able to find, Whether LoggedIn or not");
						return false;
					}
				}
			});

			flag = isEventReceived;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static boolean checkAndDelete_GDRInfo(TestCases testCase, TestCaseInputs inputs, String macID) {
		boolean flag = false;
		if (request_GDR_AccessToken(testCase, inputs)) {
			if (getGDR_Status(testCase, inputs, "globalRegistry/deviceState/" + macID, "Unregistered")) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Already GDR state Updated in LCC Admin");
			} else {
				flag = changeDevice_GDRState(testCase, inputs, Enum_Token.GDR, "globalRegistry/deviceState/", macID,
						"Unregistered");
			}
		} else {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to get Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean checkAndDelete_GDRInfo(String macID) {
		boolean flag = false;
		if (request_GDR_AccessToken()) {
			if (getGDR_Status("globalRegistry/deviceState/" + macID, "Unregistered")) {
				flag = true;
				System.out.println("Already GDR state Updated in LCC Admin");
			} else {
				flag = changeDevice_GDRState(Enum_Token.GDR, "globalRegistry/deviceState/", macID, "Unregistered");
			}
		} else {
			System.out.println("Failed to get Access Token from LCC Admin");
			flag = false;
		}

		return flag;
	}

	public static boolean getGDR_Status(TestCases testCase, TestCaseInputs inputs, String url, String expectedString) {
		try {
			FluentWait<String> fWait = new FluentWait<String>(expectedString);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(10));
			Boolean isEventReceived = fWait.until(new Function<String, Boolean>() {
				public Boolean apply(String str) {
					try {
						Response response = get(testCase, Enum_Token.GDR, url);
						int code = response.code();
						if (code == 200) {
							String body = response.body().string();
							if (body.toUpperCase().contains(expectedString.toUpperCase())) {
								Keyword.ReportStep_Pass(testCase, "Device Current GDR State is " + body
										+ " , Expected state is " + expectedString + " State us unregistered");
								return true;
							} else {
								Keyword.ReportStep_Pass(testCase, "Device Current GDR State is " + body
										+ " , Expected state is " + expectedString);
								System.out.println("Reponse body is " + body + "  Mismatch. retry ......");
								return false;
							}
						} else {
							if (code == 401) {
//							request_GDR_AccessToken(testCase, inputs);
								return false;
							}
							return false;
						}
					} catch (TimeoutException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Retry Over, Failed to change device GDR State");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find, Whether LoggedIn or not");
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean getGDR_Status(String url, String expectedString) {
		try {
			FluentWait<String> fWait = new FluentWait<String>(expectedString);
			fWait.pollingEvery(Duration.ofSeconds(5));
			fWait.withTimeout(Duration.ofSeconds(10));
			Boolean isEventReceived = fWait.until(new Function<String, Boolean>() {
				public Boolean apply(String str) {
					try {
						Response response = get(Enum_Token.GDR, url);
						int code = response.code();
						if (code == 200) {
							String body = response.body().string();
							if (body.toUpperCase().contains(expectedString.toUpperCase())) {
								System.out.println("Device Current GDR State is " + body + " , Expected state is "
										+ expectedString + " State us unregistered");
								return true;
							} else {
								System.out.println("Device Current GDR State is " + body + " , Expected state is "
										+ expectedString);
								System.out.println("Reponse body is " + body + "  Mismatch. retry ......");
								return false;
							}
						} else {
							if (code == 401) {
//							request_GDR_AccessToken(testCase, inputs);
								return false;
							}
							return false;
						}
					} catch (TimeoutException e) {
						System.out.println("Retry Over, Failed to change device GDR State");
						return false;
					} catch (Exception e) {
						System.out.println("Not able to find, Whether LoggedIn or not");
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean changeDevice_GDRState(TestCases testCase, TestCaseInputs inputs, Enum_Token getEnumToken,
			String url, String macID, String state) {
		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create("{\r\n  \"NewState\": \"" + state + "\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url + macID).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 204) {

				if (getGDR_Status(testCase, inputs, "globalRegistry/deviceState/" + macID, "Unregistered")) {
					Keyword.ReportStep_Pass(testCase, "GDR Status changed to " + state);
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"GDR Status Chage failed from Registered to " + state);
					flag = false;
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to change GDR State, Response code is : " + code + " , Reponse Body is "
								+ repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean changeDevice_GDRState(Enum_Token getEnumToken, String url, String macID, String state) {
		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create("{\r\n  \"NewState\": \"" + state + "\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url + macID).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 204) {

				if (getGDR_Status("globalRegistry/deviceState/" + macID, "Unregistered")) {
					System.out.println("GDR Status changed to " + state);
					flag = true;
				} else {
					System.out.println("GDR Status Chage failed from Registered to " + state);
					flag = false;
				}

			} else {
				System.out.println("Unable to change GDR State, Response code is : " + code + " , Reponse Body is "
						+ repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean post_RegisterDevice(TestCases testCase, TestCaseInputs inputs, Enum_Token getEnumToken,
			String url, String macID) {
//		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create("{\r\n    \"DeviceId\": \"" + macID
					+ "\",\r\n    \"DeviceName\":\"" + macID
					+ "\",\r\n    \"DeviceType\": \"Thermostat\",\r\n    \"ResponseChannelId\": \"CHAPI\",\r\n    \"SubsystemSpecificData\": {\r\n    \"Thermostat.ConnectivityChangeChannelId\": \"CHAPI\",\r\n    \"Thermostat.ThermostatAlertsChannelId\": \"CHAPI\",\r\n    \"Thermostat.DemandResponseChannelId\": \"CHAPI\",\r\n    \"Thermostat.DataSyncChannelId\": \"CHAPI\",\r\n    \"Thermostat.DefaultChannelId\": \"CHAPI\",\r\n    \"Thermostat.WeatherApiLocationId\": \"12345\",\r\n    \"Thermostat.ClientId\": \"12345\"\r\n      }\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {
				Keyword.ReportStep_Pass(testCase, "Registered successfully");
				System.out.println("registered sucessfully");
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to register device, Response code is : " + code + " , Reponse Body is " + repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean post_RegisterDevice(Enum_Token getEnumToken, String url, String macID) {
//		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create("{\r\n    \"DeviceId\": \"" + macID
					+ "\",\r\n    \"DeviceName\":\"" + macID
					+ "\",\r\n    \"DeviceType\": \"Thermostat\",\r\n    \"ResponseChannelId\": \"CHAPI\",\r\n    \"SubsystemSpecificData\": {\r\n    \"Thermostat.ConnectivityChangeChannelId\": \"CHAPI\",\r\n    \"Thermostat.ThermostatAlertsChannelId\": \"CHAPI\",\r\n    \"Thermostat.DemandResponseChannelId\": \"CHAPI\",\r\n    \"Thermostat.DataSyncChannelId\": \"CHAPI\",\r\n    \"Thermostat.DefaultChannelId\": \"CHAPI\",\r\n    \"Thermostat.WeatherApiLocationId\": \"12345\",\r\n    \"Thermostat.ClientId\": \"12345\"\r\n      }\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
//			OkHttpClient client = new OkHttpClient();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {
				System.out.println("Response correct");
				flag = true;
			} else {
				System.out.println(
						"Unable to register device, Response code is : " + code + " , Reponse Body is " + repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean post_UnRegisterDevice(TestCases testCase, TestCaseInputs inputs, Enum_Token getEnumToken,
			String url, String macID) {
//		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(
					"{\r\n  \"DeviceId\": \"" + macID + "\",\r\n  \"ResponseChannelId\": \"CHAPI\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {
				Keyword.ReportStep_Pass(testCase, "Device unregistered successfully");
				System.out.println("Device unregistered successfully");
				flag = true;
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to register device, Response code is : " + code + " , Reponse Body is " + repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean post_UnRegisterDevice(Enum_Token getEnumToken, String url, String macID) {
//		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(
					"{\r\n  \"DeviceId\": \"" + macID + "\",\r\n  \"ResponseChannelId\": \"CHAPI\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {
				System.out.println("Device unregistered successfully");
				flag = true;
			} else {
				System.out.println(
						"Unable to register device, Response code is : " + code + " , Reponse Body is " + repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			System.out.println("Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	public static boolean request_deviceRestart(TestCases testCase, Enum_Token getEnumToken, String url_path,
			String macID) {
		System.out.println();
		boolean flag = false;
		try {
			String accessTk = getEnumToken(getEnumToken);
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(
					"{\r\n  \"ReasonCode\": 42,\r\n  \"Reason\": \"check sum\"\r\n}", mediaType);
			Request request = new Request.Builder().url(currentURL + "/api/v1/" + url_path + macID).method("POST", body)
					.addHeader("Content-Type", "application/json").addHeader("Authorization", "Bearer " + accessTk)
					.build();
			Response response = client.newCall(request).execute();
			int code = response.code();
			String repsonseBody = response.body().string();
			if (code == 202) {
				Keyword.ReportStep_Pass(testCase, "Restart device accepted by LCC to device");
				flag = true;

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Unable to send device restart State, Response code is : " + code + " , Reponse Body is "
								+ repsonseBody);
				flag = false;
			}

		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception occured due to " + e.getMessage());
			flag = false;
		}

		return flag;
	}

//	public static void main(String[] args) throws IOException {
//		request_Device_AccessToken(null, null);
//		Response response = get(null, Enum_Token.Device_Access, "device/48A2E64C90F2");
//		System.out.println(response.code());
//		System.out.println(response.body().string().toString());
//		Response put = put(null, Enum_Token.Device_Access, "admin/EnableAcrmConsole/48A2E64C90F2");
//		System.out.println(put.code());
//		System.out.println(put.body().string().toString());
//		request_GDR_AccessToken(null, null);
//		response = get(null, Enum_Token.GDR, "globalRegistry/deviceState/48A2E64C90F2");
//		System.out.println(response.code());
//		System.out.println(response.body().string().toString());
//	}

}
