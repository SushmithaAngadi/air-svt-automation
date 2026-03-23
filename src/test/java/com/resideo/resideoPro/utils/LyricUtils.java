package com.resideo.utils.resideo_app;

import java.io.BufferedReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.tesseract.PAGE_RES;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;
import com.google.common.collect.ImmutableMap;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.deviceCloudProviders.PCloudyExecutionDesiredCapability.PCloudyDeviceInformation;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.CustomIOSDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import com.resideo.commons.mobile.MobileObject;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.perfecto.PerfectoLabUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.FirstAlertSystemState;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.api.device_Information.LocationInformation;
import com.resideo.utils.api.dfc.CHILUtil;
import com.resideo.utils.firstalert_app.screen.FirstAlertLoginScreen;
import com.resideo.utils.resideoPro_app.screen.ReziDIYScreen;
import com.resideo.utils.resideo_app.screen.CoachMarks;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.resideo_app.screen.DashboardScreen;
import com.resideo.utils.resideo_app.screen.LoginScreen;
import com.resideo.utils.resideo_app.screen.OSPopUps;
import com.resideo.utils.resideo_app.screen.SchedulingScreen;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import com.resideo.commons.mobile.W3CTouchActions;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings({ "rawtypes", "unused" })
public class LyricUtils {

	public static final String Startlogin = null;
	public static final String EndLogin = null;
	static boolean SYSTEM_INITIALISED = false;
	static boolean APP_SESSION_CREATED = false;
	static int testFailCount;
//	private static boolean isCountryselectedBeforeTrail = false;
//	private static HashMap<Object, Object> countrySelection = null; // iscountrySelected - boolean; selectedCountry -
//																	// String
//
//	public static void setIsCountryselectedBeforeTrail(boolean setState) {
//		isCountryselectedBeforeTrail = setState;
//	}
//
//	public static boolean IsCountryselectedBeforeTrail() {
//		return isCountryselectedBeforeTrail;
//	}
//
//	public static void setcountrySelectionBeforeTrail(HashMap<Object, Object> countrySelect) {
//		countrySelection = countrySelect;
//	}
//
//	public static HashMap<Object, Object> countrySelectionBeforeTrail() {
//		return countrySelection;
//	}

	/**
	 * <h1>Take Screenshot</h1>
	 * <p>
	 * The takeScreenShot method takes a screen shot on the device and stores it in
	 * the path given through the the parameter
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param path   Path to where the screen shot has to be saved
	 * @param driver The driver instantiated to run the test case
	 * @return String File name of the screen shot
	 * 
	 *         Modified On: 21/02/2018 by Surendar
	 */
	public static long locationID = 0;
	public static String deviceID = null;

	public static String takeScreenShot(String path, WebDriver driver) {
		String scrName = "#";
		if (driver == null) {
			return scrName;
		} else {
			try {
				File scrSht = ((TakesScreenshot) new Augmenter().augment((RemoteWebDriver) driver))
						.getScreenshotAs(OutputType.FILE);
				String temp = scrSht.getName();

				File scrFolder = new File(path);

				FileUtils.copyFileToDirectory(scrSht, scrFolder);
				scrName = temp;
			} catch (Exception e) {
				scrName = scrName + "Error : " + e.getCause();
			}
		}
		return scrName;
	}

	/**
	 * <h1>Get Location Information</h1>
	 * <p>
	 * The getLocationInformation method gets location details stored in CHIL of the
	 * location name provided to the test case.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return JSONObject Location details of the location name
	 */
	public static JSONObject getLocationInformation(TestCases testCase, TestCaseInputs inputs) {
		JSONObject jsonObject = null;
		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				locationID = chUtil.getLocationID(inputs.getInputValue("LOCATION1_NAME"));

				if (locationID == -1) {
					return jsonObject;
				}

				if (chUtil.isConnected()) {
					String chilURL = getCHILURL(testCase, inputs);
					String url = chilURL + "api/v3/locations/" + locationID;
					HttpURLConnection connection = chUtil.doGetRequest(url);

					try {

						if (connection != null) {

							BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

							String inputLine;
							StringBuilder html = new StringBuilder();

							while (!in.ready()) {
							}

							while ((inputLine = in.readLine()) != null) {
								html.append(inputLine);
							}

							in.close();

							jsonObject = new JSONObject(html.toString().trim());

						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Location Information : Location not found by name - "
											+ inputs.getInputValue("LOCATION1_NAME"));
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Get StatLocation Information  : Error occured - " + e.getMessage());
						jsonObject = null;
					}
				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Get Location Information  : Unable to connect to CHIL.");
			}

		} catch (Exception e) {

			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Location Information  : Unable to get location. Error occured - " + e.getMessage());
			jsonObject = null;
		}

		return jsonObject;
	}

	/**
	 * <h1>Get Device Information</h1>
	 * <p>
	 * The getDeviceInformation method gets device details stored in CHIL of the
	 * device name and location name provided to the test case.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return JSONObject Device details of the device name and location name
	 */
	public static JSONObject getDeviceInformation(TestCases testCase, TestCaseInputs inputs) {
		JSONObject jsonObject = null;

		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				locationID = chUtil.getLocationID(inputs.getInputValue("LOCATION1_NAME"));

				if (locationID == -1) {
					return jsonObject;
				}

				if (chUtil.isConnected()) {
					String chilURL = getCHILURL(testCase, inputs);
					String url = chilURL + "api/v3/locations/" + locationID;

					HttpURLConnection connection = chUtil.doGetRequest(url);

					try {

						if (connection != null) {

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

							JSONArray array = (JSONArray) jsonObj.get("devices");

							JSONObject tempJSONObject = null;

							boolean elementFound = false;

							for (int counter = 0; counter < array.length(); counter++) {
								tempJSONObject = array.getJSONObject(counter);

								if (inputs.getInputValue("LOCATION1_DEVICE1_NAME")
										.equalsIgnoreCase(tempJSONObject.getString("userDefinedDeviceName"))) {

									jsonObject = array.getJSONObject(counter);
									elementFound = true;
									break;
								}
							}

							if (elementFound) {
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Get Stat Information : Stat not found by name - "
												+ inputs.getInputValue("LOCATION1_DEVICE1_NAME"));
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Stat Information : Location not found by name - "
											+ inputs.getInputValue("LOCATION1_NAME"));
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Get Stat Information  : Error occured - " + e.getMessage());
						jsonObject = null;
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Get Stat Information  : Unable to connect to CHIL.");
				}
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

	/**
	 * <h1>Get Device Information</h1>
	 * <p>
	 * The getDeviceInformation method gets device details stored in CHIL of the
	 * device name and location name provided to the test case.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return JSONObject Device details of the device name and location name
	 */
	public static JSONObject getDeviceInformation(TestCases testCase, TestCaseInputs inputs, String macID) {
		JSONObject jsonObject = null;

		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				locationID = chUtil.getlocationIDByMacID(testCase, chUtil, getCHILURL(testCase, inputs), macID);
//				locationID = chUtil.getLocationID(inputs.getInputValue("LOCATION1_NAME"));

				if (locationID == -1) {
					return jsonObject;
				}

				if (chUtil.isConnected()) {
					String chilURL = getCHILURL(testCase, inputs);
					String url = chilURL + "api/v3/locations/" + locationID;

					HttpURLConnection connection = chUtil.doGetRequest(url);

					try {

						if (connection != null) {

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

							JSONArray array = (JSONArray) jsonObj.get("devices");

							JSONObject tempJSONObject = null;

							boolean elementFound = false;

							for (int counter = 0; counter < array.length(); counter++) {
								tempJSONObject = array.getJSONObject(counter);

								if (macID.equalsIgnoreCase(tempJSONObject.getString("macID"))) {

									jsonObject = array.getJSONObject(counter);
									elementFound = true;
									deviceID = jsonObject.getString("deviceID");
									break;
								}
							}

							if (elementFound) {
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Get Stat Information : Stat not found by name - "
												+ inputs.getInputValue("LOCATION1_DEVICE1_NAME"));
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Stat Information : Location not found by name - "
											+ inputs.getInputValue("LOCATION1_NAME"));
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Get Stat Information  : Error occured - " + e.getMessage());
						jsonObject = null;
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Get Stat Information  : Unable to connect to CHIL.");
				}
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

	public static JSONObject getDeviceInformation(TestCases testCase, TestCaseInputs inputs, long locationID,
			String macID) {
		JSONObject jsonObject = null;

		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				if (chUtil.isConnected()) {
					String chilURL = getCHILURL(testCase, inputs);
					String url = chilURL + "api/locations/" + locationID + "/devices/" + macID;
//					String url = chilURL + "api/v3/locations/" + locationID;
					HttpURLConnection connection = chUtil.doGetRequest(url);
					try {
						if (connection != null) {
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
							boolean elementFound = false;
							if (macID.equalsIgnoreCase(jsonObj.getString("macID"))
									|| macID.equalsIgnoreCase("LCC-" + jsonObj.getString("macID"))) {
								deviceID = jsonObj.getString("deviceID");
								jsonObject = jsonObj;
								elementFound = true;
							}
							if (elementFound) {
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Get Stat Information : Stat not found by name - "
												+ inputs.getInputValue("LOCATION1_DEVICE1_NAME"));
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Stat Information : Location not found by name - "
											+ inputs.getInputValue("LOCATION1_NAME"));
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Get Stat Information  : Error occured - " + e.getMessage());
						jsonObject = null;
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Get Stat Information  : Unable to connect to CHIL.");
				}
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

	public static boolean isDeviceInformationAvailable(TestCases testCase, TestCaseInputs inputs) {

		JSONObject jsonObject = null;
		boolean flag = false;
		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				locationID = chUtil.getLocationID(inputs.getInputValue("LOCATION1_NAME"));

				if (locationID == -1) {
					flag = false;
				}

				if (chUtil.isConnected()) {
					String chilURL = getCHILURL(testCase, inputs);
					String url = chilURL + "api/v3/locations/" + locationID;

					HttpURLConnection connection = chUtil.doGetRequest(url);

					try {

						if (connection != null) {

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

							JSONArray array = (JSONArray) jsonObj.get("devices");

							JSONObject tempJSONObject = null;

							boolean elementFound = false;

							for (int counter = 0; counter < array.length(); counter++) {
								tempJSONObject = array.getJSONObject(counter);

								if (inputs.getInputValue("LOCATION1_DEVICE1_NAME")
										.equalsIgnoreCase(tempJSONObject.getString("userDefinedDeviceName"))) {

									jsonObject = array.getJSONObject(counter);
									elementFound = true;
									break;
								}
							}

							if (elementFound) {
								flag = true;
							} else {
								flag = false;
							}
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Stat Information : Location not found by name - "
											+ inputs.getInputValue("LOCATION1_NAME"));
							flag = false;
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								"Get Stat Information  : Error occured - " + e.getMessage());
						jsonObject = null;
						flag = false;
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Get Stat Information  : Unable to connect to CHIL.");
					flag = false;
				}
			}
		} catch (Exception e) {

			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Stat Information  : Unable to get information for Stat - "
							+ inputs.getInputValue("LOCATION1_DEVICE1_NAME") + " at location - "
							+ inputs.getInputValue("LOCATION1_NAME") + " : Error occured - " + e.getMessage());
			jsonObject = null;
			flag = false;
		}
		return flag;

	}

	public static void getLocationIDByMacID(TestCases testCase, CHILUtil chUtil, String url, String macID) {
		JSONObject jsonObject = null;
		try {
			HttpURLConnection connection = chUtil.doGetRequest(url);
			try {

				if (connection != null) {

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

					JSONArray array = (JSONArray) jsonObj.get("devices");

					JSONObject tempJSONObject = null;

					boolean elementFound = false;

					for (int counter = 0; counter < array.length(); counter++) {
						tempJSONObject = array.getJSONObject(counter);

						if (macID.equalsIgnoreCase(tempJSONObject.getString("macID"))) {

							jsonObject = array.getJSONObject(counter);
							elementFound = true;
							break;
						}
					}

					if (elementFound) {
					} else {
					}
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
							"Get Stat Information : Location not found by name - ");
				}

			} catch (IOException | JSONException e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Get Stat Information  : Error occured - " + e.getMessage());
				jsonObject = null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isMacIDInformationAvailable(TestCases testCase, TestCaseInputs inputs, String macID) {
		JSONObject jsonObject = null;
		boolean flag = false;
		System.out.println("Mac ID " + macID);
		try (CHILUtil chUtil = new CHILUtil(inputs)) {

			if (chUtil.getConnection()) {
				// getLocationIDByMacID(testCase,chUtil, getCHILURL(testCase,
				// inputs) + "api/v3/locations", macID);
				// locationID =
				// chUtil.getLocationID(inputs.getInputValue("LOCATION1_NAME"));
				locationID = chUtil.getlocationIDByMacID(testCase, chUtil, getCHILURL(testCase, inputs), macID);
				if (locationID == -1) {
					flag = false;
				}

				System.out.println("Location ID " + locationID);
				if (chUtil.isConnected()) {

					if (locationID != 0) {
						String chilURL = getCHILURL(testCase, inputs);
						String url = chilURL + "api/v3/locations/" + locationID;

						HttpURLConnection connection = chUtil.doGetRequest(url);

						try {

							if (connection != null) {

								BufferedReader in = new BufferedReader(
										new InputStreamReader(connection.getInputStream()));

								String inputLine;
								StringBuilder html = new StringBuilder();

								while (!in.ready()) {
								}

								while ((inputLine = in.readLine()) != null) {
									html.append(inputLine);
								}

								in.close();

								JSONObject jsonObj = new JSONObject(html.toString().trim());

								JSONArray array = (JSONArray) jsonObj.get("devices");

								JSONObject tempJSONObject = null;

								boolean elementFound = false;

								for (int counter = 0; counter < array.length(); counter++) {
									tempJSONObject = array.getJSONObject(counter);

									if (macID.equalsIgnoreCase(tempJSONObject.getString("macID"))) {

										jsonObject = array.getJSONObject(counter);
										deviceID = jsonObject.getString("deviceID");
										elementFound = true;
										break;
									}
								}

								if (elementFound) {
									flag = true;
								} else {
									flag = false;
								}
							} else {
								Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
										"Get Stat Information : Location not found by name - "
												+ inputs.getInputValue("LOCATION1_NAME"));
								flag = false;
							}

						} catch (IOException e) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"Get Stat Information  : Error occured - " + e.getMessage());
							jsonObject = null;
							flag = false;
						}
					}

				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Get Stat Information  : Unable to connect to CHIL. or Mac ID not availble from Any location");
					flag = false;
				}
			} else {
				System.out.println("Connection Get connected is failed");
				flag = false;
			}
		} catch (Exception e) {

			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Stat Information  : Unable to get information for Stat - "
							+ inputs.getInputValue("LOCATION1_DEVICE1_NAME") + " at location - "
							+ inputs.getInputValue("LOCATION1_NAME") + " : Error occured - " + e.getMessage());
			jsonObject = null;
			flag = false;
		}
		return flag;

	}

	/**
	 * <h1>Get CHIL Url</h1>
	 * <p>
	 * The getCHILURL method returns the url of the environment provided to the test
	 * case
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return String URL of the environment provided to the test case
	 */
	public static String getCHILURL(TestCases testCase, TestCaseInputs inputs) throws Exception {
		String chilURL = " ";
		try {
			String environment = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
			environment = environment.replaceAll("\\s", "");
			if (environment.equalsIgnoreCase("Production")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_URL_PRODUCTION");
			} else if (environment.equalsIgnoreCase("CHILInt(Azure)")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_INT");
			} else if (environment.equalsIgnoreCase("ChilDev(Dev2)")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_DEV2");
			} else if (environment.equalsIgnoreCase("CHILStage(Azure)")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_URL_STAGING");
			} else if (environment.equalsIgnoreCase("LoadTesting")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_LOAD_TESTING");
			} else if (environment.equalsIgnoreCase("ChilDas(QA)")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_DAS_QA");
			} else if (environment.equalsIgnoreCase("ChilDas(Test)")) {
				chilURL = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "CHIL_DAS_TEST");
			} else {
				throw new Exception("Invalid URL");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
//		System.out.println(inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT) + " Url " + chilURL);

		return chilURL;
	}

	/**
	 * <h1>Login in to the Lyric Application</h1>
	 * <p>
	 * The loginToLyricApp method click on the login button post launch/Application
	 * Environment Setup, inputs the email ID and password, and taps on the login
	 * button
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return boolean Returns 'true' if all the button clicks and values were set
	 *         properly. Returns 'false' if there was an error on clicking any
	 *         buttons or setting any values
	 */
	public static boolean loginToLyricApp_OLD(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		LoginScreen ls = new LoginScreen(testCase);
		if (ls.isLoginButtonVisible() && !ls.isEmailAddressTextFieldVisible()) {
			flag = flag & ls.clickOnLoginButton();
		}
		if (ls.setEmailAddressValue(inputs.getInputValue("USERID").toString())) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				MobileUtils.hideKeyboard(testCase.getMobileDriver());
			}
			Keyword.ReportStep_Pass(testCase,
					"Login To Lyric : Email Address set to - " + inputs.getInputValue("USERID"));
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Not able to set Email Address.");
			flag = false;
		}
		if (ls.setPasswordValue(inputs.getInputValue("PASSWORD").toString())) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				MobileUtils.hideKeyboard(testCase.getMobileDriver());
			} else {
				ls.clickOnLyricLogo();
			}
			Keyword.ReportStep_Pass(testCase, "Login To Lyric : Password set to - " + inputs.getInputValue("PASSWORD"));
			flag = true;
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Not able to set Password.");
			flag = false;
		}
		if (ls.isLoginButtonVisible()) {
			flag = flag & ls.clickOnLoginButton();
		} else {
			MobileUtils.hideKeyboardIOS(testCase.getMobileDriver(), "Go");
		}
		return flag;
	}

	public static boolean loginToLyricApp(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = false;
		LoginScreen ls = new LoginScreen(testCase);
		if (ls.isHoneywellAccountCreate_LoginScreen()) {
			if (ls.clickOnLoginButton()) {
				if (ls.isEmailAddressTextFieldVisible(30)) {
					String userName = inputs.getInputValue("USERID").toString();
					String password = inputs.getInputValue("PASSWORD").toString();
					flag = ls.setEmailAddressValue(userName);
					flag = flag && ls.setPasswordValue(password);
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						MobileUtils.hideKeyboard(testCase.getMobileDriver());
					} else {
						if (MobileUtils.hideKeyboardIOS(testCase.getMobileDriver(), "Go")) {
							flag = true;
						} else if (MobileUtils.hideKeyboardIOS(testCase.getMobileDriver(), "return")) {
							flag = true;
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
									"KeyBoard failed to close");
						}
					}
					flag = flag && ls.clickOnLoginButton();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to navigate to Login Screen");
					flag = false;
				}
			} else {
				String presentScreenName = ls.getPresentScreenName();
				if (!presentScreenName.contains("intialscreen") || !presentScreenName.contains("loginscreen")) {
					Keyword.ReportStep_Pass(testCase, "Loading took more time");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click on Login button");
					flag = false;
				}
			}
		} else {
			String presentScreenName = ls.getPresentScreenName();
			if (!presentScreenName.contains("intialscreen") || !presentScreenName.contains("loginscreen")) {
				Keyword.ReportStep_Pass(testCase,
						"Loading took more time" + "  , Current screen name is " + presentScreenName);
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"HH App User login/Create Account screen is Not available " + "  , Current screen name is "
								+ presentScreenName);
				flag = false;
			}
		}
		return flag;
	}

	public static boolean loginToReziApp(TestCases testCase, TestCaseInputs inputs, ReziDIYScreen diy, String userName,
			String password) {
		boolean flag = false;

		if (diy.setEmailAddressInLogin(userName)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				MobileUtils.hideKeyboard(testCase.getMobileDriver());
			}
			Keyword.ReportStep_Pass(testCase,
					"Login To Resideo Pro : Email Address set to - " + inputs.getInputValue("USERID"));

			if (diy.setSignPassword(password)) {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					MobileUtils.hideKeyboard(testCase.getMobileDriver());
				}
				if (diy.clickOnSignINButton()) {
					Keyword.ReportStep_Pass(testCase,
							"Login To Resideo Pro : clicked on Login Button, Waiting for Primary card");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Login To Resideo Pro : Not able to Click on login button.");
					flag = false;

				}

				Keyword.ReportStep_Pass(testCase,
						"Login To Resideo Pro : Password set to - " + inputs.getInputValue("PASSWORD"));
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Login To Resideo Pro : Not able to set Password.");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Resideo Pro : Not able to set Email Address.");
			flag = false;
		}
		return flag;
	}

	/**
	 * <h1>Verify If Login Is Successful</h1>
	 * <p>
	 * The verifyLoginSuccessful method verifies the if the user has successfully
	 * logged in by checking the presence of the weather icon on the dash board.
	 * Timeout of locating the weather icon is 2 minutes
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return boolean Returns 'true' if weather icon is found. Returns 'false' if
	 *         weather icon is not located.
	 */
	public static boolean verifyLoginSuccessful(TestCases testCase, TestCaseInputs inputs, boolean... closeCoachMarks) {
		boolean flag = false;
		OSPopUps os = new OSPopUps(testCase);
		CoachMarks cm = new CoachMarks(testCase);
		DashboardScreen d = new DashboardScreen(testCase);
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(5));
		fWait.withTimeout(Duration.ofMinutes(3));
		try {
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					if (testCase.getPlatform().toUpperCase().contains("IOS")) {
						try {
							((CustomIOSDriver) testCase.getMobileDriver()).switchTo().alert().accept();
							return false;
						} catch (Exception e) {
							if (os.isNotNowButtonVisible(1)) {
								os.clickOnNotNowButton();
								return false;
							} else if (cm.isGotitButtonVisible(1)) {
								if (closeCoachMarks.length > 0 && !closeCoachMarks[0]) {
									return true;
								} else {

									return LyricUtils.closeCoachMarks(testCase);
								}

							}
						}
					} else {
						if (os.isCloseButtonVisible(1) || os.isIgnoreButtonVisible(2)) {
							if (os.isIgnoreButtonVisible(2)) {
								os.clickOnIgnoreButton();
								return false;
							}
							if (os.isCloseButtonVisible(1)) {
								os.clickOnCloseButton();
								return false;
							}

						}
					}
					if (testCase.getPlatform().toUpperCase().contains("IOS")) {
						return d.isGlobalDrawerButtonVisible(5);
					} else {
						if (!d.isSplashScreenVisible(2) && !d.isProgressBarVisible(2)) {
							if (closeCoachMarks.length > 0 && !closeCoachMarks[0]) {
								return true;
							} else {
								return CoachMarkUtils.closeCoachMarks(testCase);
							}

						} else {
							return false;
						}
					}
				}
			});
			if (isEventReceived) {
				if (testCase.getPlatform().toUpperCase().contains("IOS"))
					if (os.isNotNowButtonVisible(15))
						os.clickOnNotNowButton();
				Keyword.ReportStep_Pass(testCase, "Login to Lyric : Successfully navigated to HomeScreen");
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Login To Lyric : Unable to navigate to homepage. Could not find notification icon on homepage");
			}

		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Timed out while loading. Wait time : 2 minutes");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
		}
		return flag;
	}

	/**
	 * <h1>Close Application Launch Pop Ups</h1>
	 * <p>
	 * The closeAppLaunchPopups method closes all the application pop ups displayed
	 * on the device post the application launch.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @return boolean Returns 'true' if all the pop ups have been closed
	 *         successfully. Returns 'false' if any of the pop up fails to close
	 */
	public static boolean closeAppLaunchPopups(TestCases testCase) {
		boolean flag = false;
		LoginScreen login = new LoginScreen(testCase);
		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(3));
			Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean flag) {
					try {
						String presentScreenName = login.getPresentScreenName();
						String pageSource = testCase.getMobileDriver().getPageSource();
						if (pageSource.toUpperCase().contains("WHAT DO YOU THINK OF RESIDEO APP")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Close']", false, false);
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']", false, false);
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Performance Issues".toUpperCase())
								|| pageSource.toUpperCase().contains("Performance Issue".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton[@name='Okay']",
										testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//XCUIElementTypeButton[@name='Okay']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Okay']");
							}
							return false;

						} else if (pageSource.toUpperCase().contains("Deeplink".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH",
										"//XCUIElementTypeButton[@name='close_button']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH",
											"//XCUIElementTypeButton[@name='close_button']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@content-desc='close_button']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Partial outage".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "name", "Okay");
							} else {
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='Okay']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Unexpectedly Quit".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "name", "Send report");
							} else {
								MobileUtils.clickOnElement(testCase, "xpath",
										"//*[@text='ALWAYS SEND' or @text='Always Send']");
							}
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"App crashed due to 'Unexpectedly Quit'");
							return false;
						} else if (pageSource.toUpperCase().contains("Partial outage".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.clickOnElement(testCase, "name", "Okay");
							} else {
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='Okay']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Planned Maintenance".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Okay']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Okay']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Okay']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Server Under".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Retry']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Retry']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button[@text='Retry']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("Disable App Hibernation".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								if (MobileUtils.isMobElementExists("XPATH", "//*[@name='Not Now']", testCase, 2))
									MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Not Now']");
							} else {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Not Now']");
							}
							return false;
						} else if (pageSource.toUpperCase().contains("ERROR".toUpperCase())
								&& pageSource.toUpperCase().contains("RETRY")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to open Dashboad, passcode error shows");
							SystemState.getStatus().isError(true);
							return true;
						} else if (presentScreenName.contains("intialscreen")) {
							SystemState.getStatus().setLoggedIn(false);
							return true;
						} else if (presentScreenName.contains("dashboard")) {
							SystemState.getStatus().setLoggedIn(true);
							SystemState.getStatus().setDashBoardScreenVisible(true);

							if ((pageSource.contains("XCUIElementTypeCell"))
									|| (presentScreenName.contains("dashboard_withdevice_addnewdevice")))
								SystemState.getStatus().setDeviceShownOnDashboard(true);
							else
								SystemState.getStatus().setDeviceShownOnDashboard(false);

							if (pageSource.contains("dashboard_add_device")
									|| presentScreenName.contains("dashboard_withdevice_addnewdevice"))
								SystemState.getStatus().setAddNewDeviceButtonVisible(true);
							else if (pageSource.contains("rebates_available")) {
								MobileUtils.clickOnElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/close_btn']");
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@resource-id='android:id/button1']");
							} else
								SystemState.getStatus().setAddNewDeviceButtonVisible(false);
							return true;
						} else if ((pageSource.contains("value=\"Add New Device\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS"))
								|| (pageSource.contains("name=\"Add New Device\"")
										&& testCase.getPlatform().toUpperCase().contains("IOS"))) {
							SystemState.getStatus().setAddNewDeviceScreenVisible(true);
							SystemState.getStatus().setLoggedIn(true);

							return true;
							/////////////// passcode///////////////
						} else if (pageSource.contains("Please enter your Honeywell Home App passcode")) {

							if (!SystemState.getStatus().ismfa_firstAttempt()
									|| SystemState.getStatus().mfaCount() == 7) {
								if (testCase.getPlatform().toUpperCase().contains("IOS")) {
									MobileUtils.setValueToElement(testCase, "XPATH",
											"(//XCUIElementTypeSecureTextField)[1]", "1470");
									Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
									if (MobileUtils.isMobElementExists("NAME", "Invalid Passcode", testCase, 2))
										MobileUtils.clickOnElement(testCase, "NAME", "Forgot?");
								} else {
									MobileUtils.setValueToElement(testCase, "XPATH",
											"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
//									if (MobileUtils.isMobElementExists("ID", "security_pin_forgot_pin_tv", testCase))
//										MobileUtils.clickOnElement(testCase, "ID", "security_pin_forgot_pin_tv");
									Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
								}
							}
							SystemState.getStatus().mfaCount(SystemState.getStatus().mfaCount() + 1);
							SystemState.getStatus().ismfa_firstAttempt(true);
							return false;
						} else if (pageSource.contains("Please enter your Resideo App passcode")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"(//XCUIElementTypeSecureTextField)[1]", "1470");
								if (MobileUtils.isMobElementExists("NAME", "Invalid Passcode", testCase, 2))
									MobileUtils.clickOnElement(testCase, "NAME", "Forgot?");
								Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
								return false;
							} else {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
//								if (MobileUtils.isMobElementExists("ID", "security_pin_forgot_pin_tv", testCase))
//									MobileUtils.clickOnElement(testCase, "ID", "security_pin_forgot_pin_tv");

								Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
								return false;
							}
						} else if (pageSource.contains("com.resideo.android.lyric:id/btn_positive_got_it")) {
							MobileUtils.clickOnElement(testCase, "id", "btn_positive_got_it");
							return false;

						} else if (pageSource.toUpperCase().contains("What do you think of Honeywell".toUpperCase())
								|| pageSource.toUpperCase().contains("CLOSE")) {
							if (MobileUtils.isMobElementExists("XPATH", "//*[@text='Close']", testCase, 2)) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']");
							}
							return false;
						} else if (pageSource.contains("com.android.packageinstaller:id/permission_allow_button")) {
							MobileUtils.clickOnElement(testCase, "id",
									"com.android.packageinstaller:id/permission_allow_button");
							return false;
						} else if (pageSource.contains("name=\"OK\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "OK");
							return false;
						} else if (pageSource.contains("name=\"Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Allow");
							return false;
						} else if (pageSource.contains("name=\"Always Allow\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Always Allow");
							return false;
						} else if (pageSource.contains("name=\"Next\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Next");
							return false;
						} else if (pageSource.contains("name=\"Done\"")
								&& testCase.getPlatform().toUpperCase().contains("IOS")) {
							MobileUtils.clickOnElement(testCase, "name", "Done");
							return false;
						} else if (pageSource.contains("btn_close")) {
							MobileUtils.clickOnElement(testCase, "id", "btn_close");
							return false;
						} else if (pageSource.contains("text=\"Ignore\"") || pageSource.contains("name=\"Ignore\"")) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID"))
								MobileUtils.clickOnElement(testCase, "xpath", "//*[@text='Ignore']");
							else
								MobileUtils.clickOnElement(testCase, "name", "Ignore");

							return false;
						} else if (pageSource.contains("com.resideo.android.lyric:id/rebates_available")) {
							MobileUtils.clickOnElement(testCase, "XPATH",
									"//*[@resource-id='com.resideo.android.lyric:id/close_btn']");
							return false;
						} else if (testCase.getPlatform().toUpperCase().contains("ANDROID")
								&& pageSource.contains("Rebates Available")) {
							if (MobileUtils.clickOnElement(testCase, "XPATH",
									"//*[@resource-id='com.resideo.android.lyric:id/close_btn']")) {
								MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							}
							return false;
						}

						////////////////////////// ios Not
						////////////////////////// nOW/////////////////////////////////////
						else if (pageSource.contains("Would Like to Access Your Home Data")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "OK");
							return false;
						} else if (pageSource.contains("Would Like to Send You Notifications")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow");
							return false;
						} else if (pageSource.contains(" to use your location")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow While Using App");
							return false;
						} else if (pageSource.contains("Status Area")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								;
							MobileUtils.clickOnElement(testCase, "name", "Next");
							return false;
						} else if (pageSource.contains("Tap for More")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								;
							MobileUtils.clickOnElement(testCase, "name", "Done");
							return false;
						} else if (pageSource.toUpperCase()
								.contains("Would Like to Access Your Home Data".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "OK");
							return false;
						} else if (pageSource.toUpperCase().contains("ENJOYING RESIDEO")
								|| pageSource.toUpperCase().contains("ENJOY RESIDEO")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not Now");
							return false;
						} else if (pageSource.contains("text=\"Not Now\"") || pageSource.contains("Not Now")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Not Now");
							return false;
						} else if (pageSource.contains("Increase Security")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								if (MobileUtils.isMobElementExists("NAME", "No", testCase, 1)) {
									MobileUtils.clickOnElement(testCase, "name", "No");
								}
							return false;
						} else if (pageSource.contains("Would Like to Send You Notifications")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow");
							return false;
						} else if (pageSource.contains("to use your location?".toUpperCase())
								|| pageSource.contains("name=\"Not now\"")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS"))
								MobileUtils.clickOnElement(testCase, "name", "Allow While Using App");
							return false;
						} else if (pageSource.toUpperCase().contains("Pro Invitation".toUpperCase())) {
							if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
								if (testCase.getTestCaseName().toUpperCase().contains("DIY")) {
									SystemState.getStatus().isInvitationIsVisibleDuringLogin(
											MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='CONNECT']"));
									if (pageSource.contains("Is the thermostat on the wall")) {
										Keyword.ReportStep_Pass(testCase, "Thermostat On Wall");
										SystemState.getStatus().isThermostatOnWallorIosNetwork(true);
										return true;
									} else {
										return false;
									}
								} else {
									SystemState.getStatus().isInvitationIsVisibleDuringLogin(
											MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='DISMISS']"));
									return false;
								}
							} else {
								SystemState.getStatus().isInvitationIsVisibleDuringLogin(
										MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='Connect']"));
								if (pageSource.contains("Start thermostat network")) {
									Keyword.ReportStep_Pass(testCase, "Start thermostat network");
									SystemState.getStatus().isStartThermostatNetwork(true);
									return true;
								} else {
									return false;
								}
							}
						} else if (pageSource.contains("Passcode verification failed due to a validation error")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='OK']");
							Keyword.ReportStep_Pass(testCase, "<b style=\"color:red\"> Validation error popup </b>");
							return false;
						} else if (pageSource.contains("Create a Passcode")) {
							if (testCase.getPlatform().toUpperCase().contains("IOS")) {
								MobileUtils.setValueToElement(testCase, "XPATH",
										"(//XCUIElementTypeSecureTextField)[1]", "1470");
								if (MobileUtils.isMobElementExists("NAME", "Verify Passcode", testCase))
									MobileUtils.setValueToElement(testCase, "XPATH",
											"(//XCUIElementTypeSecureTextField)[1]", "1470");
								Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
								return false;
							} else {
								if (MobileUtils.isMobElementExists("XPATH",
										"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", testCase))
									MobileUtils.setValueToElement(testCase, "XPATH",
											"//*[@resource-id='com.resideo.android.lyric:id/pin_editbox']", "1470");
								Keyword.ReportStep_Pass(testCase, "MFA Passcode Entered");
								return false;
							}
						} else if (pageSource.contains("Add Fingerprint Unlock")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='NO']");
							return false;
						} else if (pageSource.contains("Honeywell Home app")) {
							MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='Close']");
							return false;
						} else if (pageSource.contains("Is the thermostat on the wall")) {
							Keyword.ReportStep_Pass(testCase, "Thermostat On Wall");
							SystemState.getStatus().isThermostatOnWallorIosNetwork(true);
							return true;
						} else if (pageSource.contains("Start thermostat network")) {
							Keyword.ReportStep_Pass(testCase, "Start thermostat network");
							SystemState.getStatus().isStartThermostatNetwork(true);
							return true;
						}

						///////////////////////////////////////////////////////////////
						else if (pageSource.contains("hh_intro_skip_textview")) {
							MobileUtils.clickOnElement(testCase, "id", "hh_intro_skip_textview");
							return false;
						} else if (pageSource.contains("text=\"Honeywell Home Unexpectedly Quit\"")
								|| pageSource.contains("Honeywell Unexpectedly Quit")
								|| pageSource.contains("SEND REPORT") || pageSource.contains("DON'TSEND")
								|| pageSource.contains("ALWAYS SEND") || pageSource.contains("text=\"Always Send\"")
								|| pageSource.contains("text=\"ALWAYS SEND\"")) {
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"App crashed due to 'Honeywell Unexpectedly Quit'");
							MobileUtils.clickOnElement(testCase, "xpath",
									"//*[@text='ALWAYS SEND' or @text='Always Send']");
							return false;
						} else {
//							if (testCase.getPlatform().toUpperCase().contains("IOS"))
//								((CustomIOSDriver) testCase.getMobileDriver()).switchTo().alert().dismiss();

							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			});

			if (isEventReceived && SystemState.getStatus().isError()) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed due to Error after providing passcode");
				flag = false;
			} else if (isEventReceived) {
				Keyword.ReportStep_Pass(testCase, "App Popups are closed");
				flag = true;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Login To Lyric : Closing App Popups failed");
			}

		} catch (TimeoutException e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups Timed out while loading. Wait time : 2 minutes");
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To Lyric : Closing App Popups error Occured : " + e.getMessage());
		}

		return flag;
	}

	public static boolean closeAppRandomPopups(TestCases testCase) {

		boolean flag = false;
		OSPopUps os = new OSPopUps(testCase);
		LoginScreen ls = new LoginScreen(testCase);
		DashboardScreen dBoard = new DashboardScreen(testCase);
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

			if (ls.isSkipButtonVisible()) {
				flag = flag & ls.clickOnSkipIntroButton();
			}

			if (os.isAllowButtonVisible(5)) {
				flag = flag & os.clickOnAllowButton();
			}
			if (os.isIgnoreButtonVisible(5)) {
				os.clickOnIgnoreButton();
			}

			if (os.isCloseButtonVisible(5)) {
				os.clickOnCloseButton();
			}

			closeCoachMarks(testCase);

			flag = true;
		} else {
			try {
				Thread.sleep(3000);
				FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
				fWait.pollingEvery(Duration.ofSeconds(2));
				fWait.withTimeout(Duration.ofMinutes(2));
				Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
					public Boolean apply(CustomDriver driver) {
						try {
							System.out.println("Inside Fluent wait for closing app popups");
							if (ls.isLyricLogoVisible()) {
								return true;
							}
							if (dBoard.isGlobalDrawerButtonVisible(2)) {
								return true;
							}
							if (os.isIgnoreButtonVisible(3)) {
								System.out.println("Clicked on ignore");
								os.clickOnIgnoreButton();
								return false;
							}
							if (ls.isSkipButtonVisible()) {
								ls.clickOnSkipIntroButton();
								return true;
							}
							/*
							 * if (os.isCancelButtonVisible()) { os.clickOnCancelButton(); return false; }
							 */
							else {

								((CustomIOSDriver) testCase.getMobileDriver()).switchTo().alert().dismiss();
								;
								return false;
							}
						} catch (Exception e) {
							return false;
						}
					}
				});
				if (isEventReceived) {
					Keyword.ReportStep_Pass(testCase, "Closing App Launch popups finished");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Login To Lyric : Unable to navigate to homepage. Could not find notification icon on homepage");
				}

			} catch (TimeoutException e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Timed out while loading. Wait time : 2 minutes");
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
			}
		}

		if (ls.isHonUnexpectedQuitPopupVisible(10)) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"App crashed due to 'Honeywell Unexpectedly Quit'");
			flag = ls.clickOnAlwaysSendButton();
		}

		return flag;
	}

	/**
	 * <h1>Set Application Environment</h1>
	 * <p>
	 * The set application environment method navigates to the secret menu from the
	 * login screen, set the application environment provided to the test case, and
	 * navigates back to the login screen
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return boolean Returns 'true' if the environment is successfully set.
	 *         Returns 'false' if the environment is not set successfully
	 */
	public static boolean setAppEnvironment(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = true;
		try {
			String environmentToSelect = inputs.getInputValue(TestCaseInputs.APP_ENVIRONMENT);
			LoginScreen ls = new LoginScreen(testCase);
			SecretMenu sm = new SecretMenu(testCase);
			SchedulingScreen sc = new SchedulingScreen(testCase);
			if (sc.isSkipButtonVisible(10)) {
				sc.clickOnSkipButton();
			}
			flag = flag & ls.longPressOnSecretMenuImage();
			if (!testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (sm.isFeatureTweaksVisible()) {
					flag = flag & sm.clickOnFeatureTweaks();
					flag = flag & sm.clickOnSetAccessibilityToggle();
					// flag = flag & sm.clickOnSetDasDIYV2Toggle();
					flag = flag & sm.clickOnNavigateUp();
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Unable to find Feature tweaks to set Accessibility");
					return false;
				}
			}
//				else {
//				flag = flag & sm.clickOnSetDasDIYV2Toggle();
//			}
			if (sm.isWebServerURLVisible()) {
				flag = flag & sm.clickOnWebServerURL();
				// Keeping this explicit wait because sometimes the environment selection fails
				// on ANDROID
				TimeUnit.SECONDS.sleep(1);
				// Thread.sleep(1000);
			}
			environmentToSelect = environmentToSelect.replaceAll("\\s", "");
			if (environmentToSelect.equalsIgnoreCase("ChilDas(QA)")) {
				flag = flag & sm.clickOnCHILDASQAOption();
			} else if (environmentToSelect.equalsIgnoreCase("Production")) {
				flag = flag & sm.clickOnProductionOption();
			} else if (environmentToSelect.equalsIgnoreCase("CHILStage(Azure)")) {
				flag = flag & sm.clickOnCHILStageAzureOption();
			} else if (environmentToSelect.equalsIgnoreCase("CHILInt(Azure)")) {
				flag = flag & sm.clickOnCHILIntAzureOption();
			} else if (environmentToSelect.equalsIgnoreCase("ChilDev(Dev2)")) {
				flag = flag & sm.clickOnCHILDevDev2Option();
			} else if (environmentToSelect.equalsIgnoreCase("LoadTesting")) {
				flag = flag & sm.clickOnCHILLoadTestingOption();
			} else if (environmentToSelect.equalsIgnoreCase("ChilDas(Test)")) {
				flag = flag & sm.clickOnCHILDASTestOption();
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Invalid Environment");
				return false;
			}
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

				if (sm.isCHILFRTweakOptionAvailable()) {
					flag = flag & sm.clickOnFRTweak();

				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Unable to find Feature tweaks to set Accessibility");
					return false;
				}
			}
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				flag = flag & MobileUtils.pressBackButton(testCase);
			} else {
				flag = flag & sm.clickOnDoneButton();
			}
			flag = flag & ls.isLyricLogoVisible();
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Set App Environment :  Error Occured - " + e.getMessage());
			flag = false;
		}

		return flag;
	}

	/**
	 * <h1>Launch And Login to Lyric Application</h1>
	 * <p>
	 * The launchAndLoginToApplication method launches the lyric application, closes
	 * all pop ups post application launch, sets the application environment, logs
	 * in the the application, and verifies whether the user has successfully logged
	 * in or not.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return boolean Returns 'true' if all the operations mentioned in the
	 *         description have been performed successfully. Returns 'false' if any
	 *         of the operations mentioned in the description fails.
	 */

	public static boolean launchAndLoginToApplication(TestCases testCase, TestCaseInputs inputs,
			boolean... closeCoachMarks) {
		boolean flag = true;
		DIYScreen diy = new DIYScreen(testCase);
		System.out.println("          App launch initiated...");
		if (MobileUtils.launchApplication(inputs, testCase, false)) {
			System.out.println("          App launched successfully");
			System.out.println("          Closing the Coach Marks, If any >.......");
			LyricUtils.closeCoachMarks(testCase);
			flag = flag && LyricUtils.closeAppLaunchPopups(testCase);
			if (SystemState.getStatus().isLoggedIn() || SystemState.getStatus().isAddNewDeviceScreenVisible())
				System.out.println("          Logged In already");
			else {
//	                flag = flag & LyricUtils.setAppEnvironment(testCase, inputs);
				System.out.println("          Logging in...");
				if (LyricUtils.loginToLyricApp(testCase, inputs)) {
					if (LyricUtils.closeAppLaunchPopups(testCase)) {
						if (SystemState.getStatus().isLoggedIn()) {
						} else {
							if (diy.isDashboard(20)) {
								Keyword.ReportStep_Pass(testCase, "Login skipped Dashboard is visible");
								flag = true;
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Logging in Failed");
								flag = false;
							}

						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"App Launch popup feiled to close");
						flag = false;
					}
				} else {
					if (diy.isDashboard(20)) {
						Keyword.ReportStep_Pass(testCase, "Login skipped Dashboard is visible");
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to login");
						flag = false;
					}
				}
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION, "Not able to lauch the APP");
			flag = false;
		}
		return flag;
	}

	public static void launchApplication(TestCases testCase, TestCaseInputs inputs) {

		System.out.println("		  App launch initiated...");
		MobileUtils.launchApplication(inputs, testCase, false);
		System.out.println("		  App launched successfully");

	}

	public static boolean launchAndLoginToReziApplication(TestCases testCase, TestCaseInputs inputs, String userName,
			String Password, boolean... closeCoachMarks) {
		boolean flag = true;
		System.out.println("		  App launch initiated...");
		if (MobileUtils.launchApplication(inputs, testCase, false)) {
			System.out.println("		  App launched successfully");
			ReziDIYScreen diy = new ReziDIYScreen(testCase);
			flag = LogintoResideoPro(testCase, inputs, diy, userName, Password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Not able to launch the resideo pro app");
			flag = false;
		}
		return flag;
	}

	public static boolean isloggedInReziApp(TestCases testCase, ReziDIYScreen diy) {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(1));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					if (diy.IswelcomeToResideoPro(1)) {
						Keyword.ReportStep_Pass(testCase, "Already Application LoggedIn");
						SystemState.getStatus().setLoggedIn(true);
						return true;
					} else if (diy.isLoginToResideoPro()) {
						Keyword.ReportStep_Pass(testCase, "Application not in LoggedIn");
						SystemState.getStatus().setLoggedIn(false);
						return true;
					} else {
						System.out.println("Checking Loging in or not");
						return false;
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find, Whether LoggedIn or not");
					return false;
				}
			}
		});
		return isEventReceived;
	}

	public static boolean LogintoResideoPro(TestCases testCase, TestCaseInputs inputs, ReziDIYScreen diy,
			String userName, String password) {
		boolean flag = false;
		try {
//			String userName = inputs.getInputValue("USERID").toString();
//			String password = inputs.getInputValue("PASSWORD").toString();
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(6));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						String screename = getPageContain(pageSource);
						if (!SystemState.getStatus().isClickedResideoProAccountBtn()
								&& screename.equals("main screen")) {
							if (diy.clickOnReisdeoProloginButton()) {
								Keyword.ReportStep_Pass(testCase, "Clicked on Resideo Pro Account btn");
								SystemState.getStatus().isClickedResideoProAccountBtn(true);
							}
							System.out.println("main screen, clicked login button");
							return false;
						} else if (!SystemState.getStatus().isSignIndone() && screename.equals("sign in screen")) {
							if (loginToReziApp(testCase, inputs, diy, userName, password)) {
								System.out.println("sign in screen, clicked login button");
								SystemState.getStatus().isSignIndone(true);
							}
							return false;
						} else if (screename.equals("dashboard")) {
							Keyword.ReportStep_Pass(testCase, "signin Successfully, and navigated to Dashbaord");
							System.out.println("Dashboard screen, singin sucessfully");
							return true;
						} else if (screename.equals("product list")) {
							if (diy.clickOnBackButton()) {
								System.out.println("product lists moving back....");
							}
							return false;
						} else if (screename.equals("settings")) {
							if (diy.clickOnBackButton()) {
								System.out.println("Settings screen moving back....");
							}
							return false;
						} else if (screename.equals("unknown")) {
							System.out.println("unknown.. trying to find screen .......");
							return false;
						} else {
							System.out.println("nothing able to find,, wait......");
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to login or might need to check the app flow");
						return false;
					}
				}
			});
			if (isEventReceived) {
				flag = true;
			}
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to login or might need to check the app flow");
			flag = false;
		}
		return flag;
	}

	public static String getPageContain(String src) {
		String screenName = null;
//		System.out.println(src);
		if (src.contains("Settings".toUpperCase()) && src.contains("AN360 Account".toUpperCase())
				&& src.contains("Resideo Pro Account".toUpperCase())
				&& src.contains("How to create an account".toUpperCase()) && !src.contains(
						"NAME=\"SETTINGS\" LABEL=\"SETTINGS\" ENABLED=\"TRUE\" VISIBLE=\"FALSE\"".toUpperCase())) {
			screenName = "main screen";
		} else if (src.contains("Email".toUpperCase()) && src.contains("Password".toUpperCase())
				&& src.contains("SIGN IN".toUpperCase()) && src.contains("Forgot password".toUpperCase())) {

			screenName = "sign in screen";

		} else if (src.contains("Hello".toUpperCase()) && src.contains("Send Feedback".toUpperCase())
				&& src.contains("Settings".toUpperCase()) && src.contains("Set Up Product".toUpperCase())
				&& src.contains("Customers".toUpperCase())) {

			screenName = "dashboard";

		} else if (src.contains("Set Up Product".toUpperCase()) && src.contains("Thermostat".toUpperCase())
				&& src.contains("Pro Security Panel".toUpperCase())) {
			screenName = "product list";
		} else if (src.contains("Log Out".toUpperCase()) && src.contains("Version".toUpperCase())
				&& src.contains("Send Logs".toUpperCase())) {
			screenName = "settings";
		} else {
			screenName = "unknown";
		}

		return screenName;
	}

	public static String getScreenName_FirstAlert(String src) {
		String screenName = null;
		src = src.toUpperCase();
		if (src.contains("Sign in".toUpperCase()) && src.contains("Create account".toUpperCase())) {
			screenName = "main screen";
		} else if (src.contains("Email".toUpperCase()) && src.contains("Password".toUpperCase())
				&& src.contains("SIGN IN".toUpperCase()) && src.contains("Forgot password".toUpperCase())
				&& src.contains("New User? Create an Account".toUpperCase())) {
			screenName = "sign in screen";
		} else if (src.contains("Air".toUpperCase()) && src.contains("Safety".toUpperCase())) {
			screenName = "dashboard";
		} else if (src.contains("Dashboard".toUpperCase()) && src.contains("Add Device".toUpperCase())
				&& src.contains("All Devices".toUpperCase()) && src.contains("Fuji (In Progress) Add".toUpperCase())
				&& src.contains("T5/T6 Smart Thermostat Add".toUpperCase())) {
			screenName = "product list";
		} else if (src.contains("My Account".toUpperCase()) && src.contains("Sign Out".toUpperCase())
				&& src.contains("Vacation".toUpperCase()) && src.contains("My Services".toUpperCase())
				&& src.contains("Activity".toUpperCase())) {
			screenName = "account menu";
		} else if (src.contains("Details".toUpperCase()) && src.contains("Settings".toUpperCase())
				&& src.contains("Name".toUpperCase())
				&& src.contains("Location".toUpperCase())) {
			screenName = "device settings";
		} else if (src.contains("Dashboard".toUpperCase()) && src.contains("Modes".toUpperCase())
				|| src.contains("Fan".toUpperCase())
				|| (src.contains("CONTACT CUSTOMER SUPPORT") && src.contains("ERROR OCCURRED WHILE SYNCING"))
				|| (src.contains("SYNCING") && src.contains("NOT STARTED"))) {
			screenName = "primary card";
		} else if (src.contains("will be removed from your account. This cannot be undone.".toUpperCase()) && src.contains("Delete Device?".toUpperCase())) {
			screenName = "delete popup";
		} else if (src.contains("Model".toUpperCase()) && src.contains("Settings".toUpperCase())
				&& src.contains("MAC ID".toUpperCase()) && src.contains("Firmware Version".toUpperCase())
				&& src.contains("System Configuration".toUpperCase())) {
			screenName = "device details";
		}else if (src.contains("Device Deleted".toUpperCase()) && src.contains("You no longer have access to".toUpperCase())) {
			screenName = "device deleted";
		} else {
			screenName = "unknown";
		}

		return screenName;
	}

	public static boolean launchAndLoginTo_Application(TestCases testCase, TestCaseInputs inputs,String appName,
			boolean... closeCoachMarks) {
		boolean flag = true;
		System.out.println("		  App launch initiated...");
		if (MobileUtils.launchApplication(inputs, testCase, false)) {
			System.out.println("		  App launched successfully");
			FirstAlertLoginScreen diy = new FirstAlertLoginScreen(testCase);
			if(appName.contains("FIRST")) {
				flag = Loginto_FristAlert(testCase, inputs, diy);
			}else if(appName.contains("PRO")) {
				flag = Loginto_ResideoPro(testCase, inputs, diy);
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Not able to launch the resideo pro app");
			flag = false;
		}
		return flag;
	}

	public static boolean isloggedIn_FristAlert(TestCases testCase, ReziDIYScreen diy) {

		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofSeconds(2));
		fWait.withTimeout(Duration.ofMinutes(1));
		Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
			public Boolean apply(CustomDriver driver) {
				try {
					if (diy.IswelcomeToResideoPro(1)) {
						Keyword.ReportStep_Pass(testCase, "Already Application LoggedIn");
						SystemState.getStatus().setLoggedIn(true);
						return true;
					} else if (diy.isLoginToResideoPro()) {
						Keyword.ReportStep_Pass(testCase, "Application not in LoggedIn");
						SystemState.getStatus().setLoggedIn(false);
						return true;
					} else {
						System.out.println("Checking Loging in or not");
						return false;
					}

				} catch (Exception e) {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Not able to find, Whether LoggedIn or not");
					return false;
				}
			}
		});
		return isEventReceived;
	}

	public static boolean Loginto_FristAlert(TestCases testCase, TestCaseInputs inputs, FirstAlertLoginScreen diy) {
		boolean flag = false;
		try {
//			FirstAlertLoginScreen login = new FirstAlertLoginScreen(testCase);
			String userName = inputs.getInputValue("USERID").toString();
			String password = inputs.getInputValue("PASSWORD").toString();
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(1));
			fWait.withTimeout(Duration.ofMinutes(6));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if(diy.isMaintenanceScreenPresent()) {
							diy.clickOnOkBtn();
						}
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						String screename = getScreenName_FirstAlert(pageSource);
						if (!FirstAlertSystemState.getStatus().isClickedFirstAlertAccountBtn()
								&& screename.equals("main screen")) {

							if (diy.clickOnFirstAlertloginButton()) {
								Keyword.ReportStep_Pass(testCase, "Clicked on Resideo Pro Account btn");
								FirstAlertSystemState.getStatus().isClickedFirstAlertAccountBtn(true);
							}
							System.out.println("main screen, clicked login button");
							return false;
						} else if (!SystemState.getStatus().isSignIndone() && screename.equals("sign in screen")) {
							if (loginToFirstAlertApp(testCase, inputs, diy, userName, password)) {
								System.out.println("sign in screen, clicked login button");
								SystemState.getStatus().isSignIndone(true);
							}
							return false;
						} else if (screename.equals("dashboard")) {
							Keyword.ReportStep_Pass(testCase, "signin Successfully, and navigated to Dashbaord");
							System.out.println("Dashboard screen, singin sucessfully");
							return true;
						} else if (screename.equals("Signed info")) {
							Keyword.ReportStep_Pass(testCase, "signin Successfully, and navigated to Dashbaord");
							System.out.println("Dashboard screen, singin sucessfully");
							return true;
						} else if (screename.equals("product list")) {
							if (diy.clickOnBackButton()) {
								System.out.println("product lists moving back to home screen....");
							}
							return false;
						} else if (screename.equals("settings")) {
							if (diy.clickOnBackButton()) {
								System.out.println("Settings screen moving back to home screen....");
							}
							return false;
						} else if (screename.equals("unknown")) {
							System.out.println("unknown.. trying to find screen .......");
							return false;
						} else {
							System.out.println("nothing able to find,, wait......");
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to login or might need to check the app flow");
						return false;
					}
				}
			});
			if (isEventReceived) {
				flag = true;
			}
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to login or might need to check the app flow");
			flag = false;
		}
		return flag;
	}

	public static String get_FristAlert_PageContain(String src) {
		String screenName = null;
		if (src.contains("Settings".toUpperCase()) && src.contains("AN360 Account".toUpperCase())
				&& src.contains("Resideo Pro Account".toUpperCase())
				&& src.contains("How to create an account".toUpperCase()) && !src.contains(
						"NAME=\"SETTINGS\" LABEL=\"SETTINGS\" ENABLED=\"TRUE\" VISIBLE=\"FALSE\"".toUpperCase())) {
			screenName = "main screen";
		} else if (src.contains("Sign in".toUpperCase()) && src.contains("Create account".toUpperCase())) {
			screenName = "sign in screen";
		} else if (src.contains("Hello".toUpperCase()) && src.contains("Send Feedback".toUpperCase())
				&& src.contains("Settings".toUpperCase()) && src.contains("Set Up Product".toUpperCase())
				&& src.contains("Customers".toUpperCase())) {

			screenName = "dashboard";

		} else if (src.contains("Set Up Product".toUpperCase()) && src.contains("Thermostat".toUpperCase())
				&& src.contains("Pro Security Panel".toUpperCase())) {
			screenName = "product list";
		} else if (src.contains("Log Out".toUpperCase()) && src.contains("Version".toUpperCase())
				&& src.contains("Send Logs".toUpperCase())) {
			screenName = "settings";
		} else if ((src.contains("Skip".toUpperCase()) && src.contains("Logout".toUpperCase())
				&& src.contains("We help you protect what matters".toUpperCase()))
				|| (src.contains("Skip".toUpperCase()) && src.contains("Logout".toUpperCase())
						&& src.contains("Air Controlling temperature".toUpperCase()))
				|| (src.contains("Skip".toUpperCase()) && src.contains("Logout".toUpperCase())
						&& src.contains("Water Water systems are a".toUpperCase()))
				|| (src.contains("Skip".toUpperCase()) && src.contains("Logout".toUpperCase())
						&& src.contains("Security Our solutions help".toUpperCase()))
				|| (src.contains("Skip".toUpperCase()) && src.contains("Logout".toUpperCase())
						&& src.contains("Energy Monitor and manage".toUpperCase()))) {
			screenName = "Signed info";
		} else {
			screenName = "unknown";
		}

		return screenName;
	}

	public static boolean loginToFirstAlertApp(TestCases testCase, TestCaseInputs inputs, FirstAlertLoginScreen diy,
			String userName, String password) {
		boolean flag = false;

		if (diy.setEmailAddressInLogin(userName)) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				MobileUtils.hideKeyboard(testCase.getMobileDriver());
			}
			Keyword.ReportStep_Pass(testCase,
					"Login To First Alert : Email Address set to - " + inputs.getInputValue("USERID"));

			if (diy.setSignPassword(password)) {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					MobileUtils.hideKeyboard(testCase.getMobileDriver());
				}
				if (diy.clickOnSignINButton()) {
					Keyword.ReportStep_Pass(testCase,
							"Login To First Alert : clicked on Login Button, Waiting for Primary card");
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Login To First Alert : Not able to Click on login button.");
					flag = false;

				}

				Keyword.ReportStep_Pass(testCase,
						"Login To First Alert : Password set to - " + inputs.getInputValue("PASSWORD"));
				flag = true;
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Login To First Alert : Not able to set Password.");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Login To First Alert : Not able to set Email Address.");
			flag = false;
		}
		return flag;
	}

	/*
	 * public static boolean launchAndLoginToApplicationintead(TestCases testCase,
	 * TestCaseInputs inputs, boolean... closeCoachMarks) { boolean flag = true;
	 * 
	 * System.out.println("		  App launch initiated...");
	 * 
	 * if (MobileUtils.launchApplication(inputs, testCase, false)) {
	 * Keyword.ReportStep_Pass(testCase, "App launched successfully.");
	 * 
	 * FlyCatcherPrimaryCard fly = new FlyCatcherPrimaryCard(testCase); // flag =
	 * fly.setValueToDeHumSlider // VacationHoldScreen vc= new
	 * VacationHoldScreen(testCase); // vc.enableVacation();
	 * 
	 * // SystemModeScreen sc= new SystemModeScreen(testCase); ////
	 * System.out.println(testCase.getMobileDriver().getPageSource()); //
	 * sc.getListMode1Name();
	 * 
	 * // ScheduleOrVacationSetPointUpdateInAppUtils.setSetPointUsingAPI(testCase,
	 * inputs, null, null);
	 * 
	 * if (testCase.getPlatform().toUpperCase().contains("IOS")) {
	 * 
	 * } if (LyricUtils.closeAppLaunchPopups(testCase)) {
	 * Keyword.ReportStep_Pass(testCase, "App launch popups closed successfully.");
	 * boolean loginsuccess = false; if (isLoggedIn(testCase)) {
	 * Keyword.ReportStep_Pass(testCase, "App is logged in already...");
	 * loginsuccess = true; } else if (LyricUtils.loginToLyricApp(testCase, inputs))
	 * { Keyword.ReportStep_Pass(testCase, "App logged in successfully.");
	 * loginsuccess = true; } else { Keyword.ReportStep_Fail(testCase,
	 * FailType.COSMETIC_FAILURE, "Failed to login into app..."); flag = false; }
	 * 
	 * if (loginsuccess) { if (closeCoachMarks.length > 0) { if
	 * (LyricUtils.verifyLoginSuccessful(testCase, inputs, closeCoachMarks[0])) {
	 * Keyword.ReportStep_Pass(testCase, "Successful login verified..."); } else {
	 * Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
	 * "Failed to login successful login"); flag = false; } } else { if
	 * (LyricUtils.verifyLoginSuccessful(testCase, inputs)) {
	 * Keyword.ReportStep_Pass(testCase, "Successful login verified..."); } else {
	 * Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
	 * "Failed to login successful login"); flag = false; } } } else flag = false; }
	 * else { Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
	 * "Failed to close app launch popups."); flag = false; } } else {
	 * Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
	 * "Failed to launch app."); flag = false; }
	 * 
	 * // System.out.println("		  App launched successfully"); // //
	 * System.out.println("		  Closing the app launch popups if any"); // flag =
	 * flag && LyricUtils.closeAppLaunchPopups(testCase); // // if
	 * (isLoggedIn(testCase)) // System.out.println("		  Logged In already");
	 * // else // { //// flag = flag & LyricUtils.setAppEnvironment(testCase,
	 * inputs); // System.out.println("		  Logging in..."); // flag = flag &&
	 * LyricUtils.loginToLyricApp(testCase, inputs); // } // //
	 * System.out.println("		  Verifying for successfull Login..."); // if
	 * (closeCoachMarks.length > 0) { // flag = flag &&
	 * LyricUtils.verifyLoginSuccessful(testCase, inputs, closeCoachMarks[0]); // }
	 * else { // flag = flag && LyricUtils.verifyLoginSuccessful(testCase, inputs);
	 * // } return flag; }
	 */

	public static boolean launchAndClosePopups(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = true;

		System.out.println("		  App launch initiated...");
		flag = MobileUtils.launchApplication(inputs, testCase, true);
		System.out.println("		  App launched successfully");

		System.out.println("		  Closing the app launch popups if any");
		flag = flag & LyricUtils.closeAppLaunchPopups(testCase);

		return flag;
	}

	/**
	 * Check if it's already login
	 */

	public static boolean isLoggedIn(TestCases testCase) {
		DashboardScreen dBaord = new DashboardScreen(testCase);
		LoginScreen ls = new LoginScreen(testCase);
		boolean flag = false;
		try {
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(1));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if (dBaord.isGlobalDrawerButtonVisible(1))
							return true;
						else if (ls.isLoginButtonVisible())
							return true;
						else
							return false;
					} catch (Exception e) {
						return false;
					}
				}
			});

			if (isEventReceived) {
				if (dBaord.isGlobalDrawerButtonVisible(1))
					flag = true;
				else if (ls.isLoginButtonVisible())
					flag = false;
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to verify isLoggedIn, returned flase");
			}
		} catch (TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to verify isLoggedIn due to timeout : 1 Min");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to verify isLoggedIn due to Exception : " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	public static boolean scrolliOSbyClassNameWithPredicateString(TestCases testCase, String className,
			String PredicateString) {
		boolean flag = false;
		try {
			CustomDriver mobileDriver = testCase.getMobileDriver();
			for (int i = 2; i <= 0; i--) {
				WebElement parent = mobileDriver.findElement(By.className(className));
				String parentID = ((RemoteWebElement) parent).getId();
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("element", parentID);
				// Use the predicate that provides the value of the label attribute

				scrollObject.put("predicateString", "name == '" + PredicateString + "'");
				mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
				Keyword.ReportStep_Pass(testCase, "scroll to predicated value ::" + PredicateString);

				if (MobileUtils.isMobElementExists("NAME", PredicateString, testCase)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Trying to scroll from top to predicate String, its failed.... Exception raised >>> message is ="
							+ e.getMessage());
		}
		return flag;
	}

	public static boolean scrolliOSbyClassNameWithName(TestCases testCase, String className, String nameProperty) {
		boolean flag = false;
		try {
			CustomDriver mobileDriver = testCase.getMobileDriver();
			for (int i = 2; i <= 0; i--) {
				WebElement parent = mobileDriver.findElement(By.className(className));
				String parentID = ((RemoteWebElement) parent).getId();
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("element", parentID);
				// Use the predicate that provides the value of the label attribute

				scrollObject.put("name", nameProperty);
				mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
				Keyword.ReportStep_Pass(testCase, "scroll to exact name ::" + nameProperty);

				if (MobileUtils.isMobElementExists("NAME", nameProperty, testCase)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Trying to scroll from top to exact NAME String, its failed.... Exception raised >>> message is ="
							+ e.getMessage());
		}
		return flag;
	}

	public boolean scrolliOSbyClassNameWithtoVisible(TestCases testCase, String className, String nameProperty) {
		boolean flag = false;
		try {
			CustomDriver mobileDriver = testCase.getMobileDriver();
			for (int i = 2; i <= 0; i--) {
				WebElement parent = mobileDriver.findElement(By.className(className));
				String parentID = ((RemoteWebElement) parent).getId();
				HashMap<String, String> scrollObject = new HashMap<String, String>();
				scrollObject.put("element", parentID);
				// Use the predicate that provides the value of the label attribute

				scrollObject.put("toVisible", nameProperty);
				mobileDriver.executeScript("mobile:scroll", scrollObject); // scroll to the target element
				Keyword.ReportStep_Pass(testCase, "scroll to exact name ::" + nameProperty);

				if (MobileUtils.isMobElementExists("NAME", nameProperty, testCase)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
					"Trying to scroll from top to Visible String, its failed.... Exception raised >>> message is ="
							+ e.getMessage());
		}
		return flag;
	}

	/**
	 * <h1>Get Device Time zone</h1>
	 * <p>
	 * The getDeviceTimeZone method returns the TimeZone the device is configured
	 * to.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return TimeZone Returns the timezone of the device
	 */
	public static TimeZone getDeviceTimeZone(TestCases testCase, TestCaseInputs inputs) throws Exception {
		TimeZone timeZone = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			String zone = new String();
			try {
				if (inputs.isRunningOn("Local")) {
					if (inputs.isInputAvailable("ANDROID_UDID")) {
						zone = ADBUtils.getAndroidMobileDeviceTimeZone(inputs.getInputValue("ANDROID_UDID"));
					} else {
						zone = ADBUtils.getAndroidMobileDeviceTimeZone();
					}
				} else if (inputs.isRunningOn("Perfecto")) {
					zone = PerfectoLabUtils.getTimeZoneAndroidOnly(testCase.getMobileDriver());
				} else if (inputs.isRunningOn("pCloudy")) {
					PCloudyDeviceInformation deviceInfo = testCase.getPcloudyDeviceInformation();
					zone = deviceInfo.getpCloudySession().getConnector().executeAdbCommand(deviceInfo.getAuthToken(),
							deviceInfo.getBookingDtoDevice(), "adb shell getprop persist.sys.timezone");
				} else if (inputs.isRunningOn("TestObject")) {
					zone = "CET";
				} else if (inputs.isRunningOn("Saucelabs")) {
					zone = "CET";
				}
				zone = zone.trim();
				timeZone = TimeZone.getTimeZone(zone);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		} else {
			try {
				if (inputs.isRunningOn("Local")) {
					timeZone = TimeZone.getDefault();
				} else if (inputs.isRunningOn("Perfecto")) {
					timeZone = TimeZone.getTimeZone("US/Eastern");
				} else if (inputs.isRunningOn("Saucelabs")) {
					timeZone = TimeZone.getTimeZone("US/Pacific");
				} else if (inputs.isRunningOn("TestObject")) {
					timeZone = TimeZone.getTimeZone("CET");
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return timeZone;
	}

	/**
	 * <h1>Get Device Time</h1>
	 * <p>
	 * The getDeviceTime method gets the time on the device
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return String Device time in the format 'yyyymmddThh:mm:a'
	 */
	public static String getDeviceTime(TestCases testCase, TestCaseInputs inputs) {
		String time = " ";
		try {
			Calendar date = Calendar.getInstance(LyricUtils.getDeviceTimeZone(testCase, inputs));
			String ampm;
			if (date.get(Calendar.AM_PM) == Calendar.AM) {
				ampm = "AM";
			} else {
				ampm = "PM";
			}
			String hour;
			if (date.get(Calendar.HOUR) == 0) {
				hour = "12";
			} else {
				hour = String.valueOf(date.get(Calendar.HOUR));
			}
			String minute;
			if (date.get(Calendar.MINUTE) < 10) {
				minute = "0" + date.get(Calendar.MINUTE);
			} else {
				minute = String.valueOf(date.get(Calendar.MINUTE));
			}
			int month = date.get(Calendar.MONTH) + 1;
			time = String.valueOf(date.get(Calendar.YEAR) + "-" + month + "-" + date.get(Calendar.DAY_OF_MONTH) + "T"
					+ hour + ":" + minute + " " + ampm);
		} catch (Exception e) {
			time = "";
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Android Device Time : Error Occured : " + e.getMessage());
		}

		return time;
	}

	/**
	 * <h1>Get Device Time</h1>
	 * <p>
	 * The addMinutesToDate method gets the time on the device with added minutes
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-03-17
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return String Device time in the format 'yyyymmddThh:mm:a'
	 */
	public static String addMinutesToDate(TestCases testCase, String date, int noOfMins) {
		String dateAfterAddition = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'h:mm a");
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(date));
			c.add(Calendar.MINUTE, noOfMins);
			dateAfterAddition = dateFormat.format(c.getTime());
		} catch (Exception e) {
			dateAfterAddition = " ";
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Add days to date : Error Occured : " + e.getMessage());
		}
		return dateAfterAddition;
	}

	/**
	 * <h1>Get All Alerts through CHIL</h1>
	 * <p>
	 * The getAllAlertsThroughCHIL method gets all the alerts of the location name
	 * provided to the test case through CHIL.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase.
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance.
	 * @return JSONObject Alert details of the location name provided to the test
	 *         case.
	 */
	public static JSONObject getAllAlertsThroughCHIL(TestCases testCase, TestCaseInputs inputs) {
		JSONObject jsonObject = null;
		try (CHILUtil chUtil = new CHILUtil(inputs)) {
			if (chUtil.getConnection()) {
				if (chUtil.isConnected()) {
					LocationInformation locInfo = new LocationInformation(testCase, inputs);
					String chapiURL = getCHILURL(testCase, inputs);
					String url = chapiURL + "api/v2/users/" + locInfo.getUserID() + "/Alerts";
					HttpURLConnection connection = chUtil.doGetRequest(url);

					try {
						if (connection != null) {
							BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
							String inputLine;
							StringBuilder html = new StringBuilder();
							while (!in.ready()) {
							}
							while ((inputLine = in.readLine()) != null) {
								html.append(inputLine);
							}
							in.close();
							jsonObject = new JSONObject(html.toString().trim());
						} else {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Get All Alerts : Failed to get all Alerts");
						}

					} catch (IOException e) {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Get All Alerts : Failed to get all Alerts. Error occured - " + e.getMessage());
						jsonObject = null;
					}
				}
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Get All Alerts  : Unable to connect to CHAPI.");
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get All Alerts : Unable to get alerts. Error occured - " + e.getMessage());
			jsonObject = null;
		}
		return jsonObject;
	}

	/**
	 * <h1>Get All Alert IDs</h1>
	 * <p>
	 * The getAllAlertIDS method gets all the alerts through CHIL, extracts the IDS
	 * for each alert from the JSONObject, and stores the ids in a list
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase.
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance.
	 * @return List<Long> List of all alert IDS
	 */
	public static List<Long> getAllAlertIDS(TestCases testCase, TestCaseInputs inputs) {
		List<Long> alertIDS = new ArrayList<Long>();
		try {
			JSONObject jsonObj = getAllAlertsThroughCHIL(testCase, inputs);
			JSONArray jsonArray = jsonObj.getJSONArray("userAlerts");
			for (int i = 0; i < jsonArray.length(); i++) {
				alertIDS.add(jsonArray.getJSONObject(i).getLong("id"));
			}
		} catch (JSONException e) {
			System.out.println("No Alerts found");
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
		}
		return alertIDS;
	}

	/**
	 * <h1>Dismiss All Alerts through CHIL</h1>
	 * <p>
	 * The dismissesAllAlertsThroughCHIL method dismisses all the alerts of the
	 * location name provided to the test case through CHIL.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase.
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance.
	 * @return boolean Returns 'true' if all the alerts have been dismissed
	 *         successfully. Returns 'false' if error occurs while dismissing
	 *         alerts.
	 */
	public static boolean dismissAllAlertsThroughCHIL(TestCases testCase, TestCaseInputs inputs) {
		boolean flag = true;
		try {
			@SuppressWarnings("resource")
			CHILUtil chUtil = new CHILUtil(inputs);
			if (chUtil.getConnection()) {
				if (chUtil.isConnected()) {
					List<Long> alertIDS = LyricUtils.getAllAlertIDS(testCase, inputs);
					int result = chUtil.dismissAllAlerts(alertIDS);
					if (result == 200) {
						Keyword.ReportStep_Pass(testCase, "Successfully dismissed alerts with ids : " + alertIDS);
					} else {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to dismiss alerts with ids : " + alertIDS);
					}
				}
			} else {
				flag = false;
				throw new Exception("Failed to connect to CHIL");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error Occured : " + e.getMessage());
		}
		return flag;
	}

	/**
	 * <h1>Scroll To The List</h1>
	 * <p>
	 * The scrollUpAList method scrolls to an element using swipe gestures.
	 * </p>
	 *
	 * @author Midhun Gollapalli (H179225)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase  Instance of the TestCases class used to create the testCase.
	 *                  testCase instance.
	 * @param attribute Attribute of the value used to locate the element
	 * @param value     Value of the attribute used to locate the element
	 * @return boolean Returns 'true' if the element is found. Returns 'false' if
	 *         the element is not found.
	 */
	public static boolean scrollUpAList(TestCases testCase, WebElement devieListWebEle) throws Exception {
		Dimension d1;
		Point p1;
		int startx = -1;
		int starty = -1;
		int endy = -1;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			d1 = devieListWebEle.getSize();
			p1 = devieListWebEle.getLocation();
			startx = p1.getX();
			starty = (int) (d1.height * 0.80) + p1.getY();
			endy = (int) (d1.height * 0.50) + p1.getY();
		} else {
			d1 = devieListWebEle.getSize();
			p1 = devieListWebEle.getLocation();
			starty = (int) (d1.height * 0.80);
			endy = (int) -((d1.height * 0.50) + p1.getY());
			startx = d1.width / 2;
		}
		return MobileUtils.swipe(testCase, startx, starty, startx, endy);
	}

	/**
	 * <h1>Scroll To Element Using Exact Attribute Value</h1>
	 * <p>
	 * The scrollToElementUsingExactAttributeValue method scrolls to an element
	 * using the attribute and exact value passed to the method in the parameters.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase  Instance of the TestCases class used to create the testCase.
	 *                  testCase instance.
	 * @param attribute Attribute of the value used to locate the element
	 * @param value     Value of the attribute used to locate the element
	 * @return boolean Returns 'true' if the element is found. Returns 'false' if
	 *         the element is not found.
	 */
	public static boolean scrollToElementUsingExactAttributeValue(TestCases testCase, String attribute, String value)
			throws Exception {
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (testCase.getMobileDriver()
						.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
								+ "new UiSelector()." + attribute + "(\"" + value + "\"));")) != null) {
					return true;
				} else {
					return false;
				}
			} else {
				JavascriptExecutor js = (JavascriptExecutor) testCase.getMobileDriver();
				HashMap<Object, Object> scrollObject = new HashMap<>();
				scrollObject.put("predicateString", attribute + " == '" + value + "'");
				try {
					js.executeScript("mobile:scroll", scrollObject);
				} catch (Exception e) {
					if (e.getMessage().contains("Failed to find scrollable visible")) {
						js.executeScript("mobile:scroll", scrollObject);
					}
				}
				WebElement element = testCase.getMobileDriver()
						.findElement(AppiumBy.iOSNsPredicateString(attribute + " == '" + value + "'"));
				if (element.getDomAttribute(attribute).equals(value)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (NoSuchElementException e) {
			throw new Exception(
					"Element with text : '" + value + "' not found. Exception Type: No Such Element Exception");
		} catch (Exception e) {
			throw new Exception("Element with text : '" + value + "' not found. Exception Message: " + e.getMessage());
		}
	}

	/**
	 * <h1>Scroll To Element Using Attribute Sub String Value</h1>
	 * <p>
	 * The scrollToElementUsingAttributeSubStringValue method scrolls to an element
	 * using the attribute and attribute substring value passed to the method in the
	 * parameters.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase  Instance of the TestCases class used to create the testCase.
	 *                  testCase instance.
	 * @param attribute Attribute of the value used to locate the element
	 * @param value     Substring value of the attribute used to locate the element
	 * @return boolean Returns 'true' if the element is found. Returns 'false' if
	 *         the element is not found.
	 */
	public static boolean scrollToElementUsingAttributeSubStringValue(TestCases testCase, String attribute,
			String value) throws Exception {
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (testCase.getMobileDriver()
						.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
								+ "new UiSelector().textContains(\"" + value + "\"));")) != null) {
					return true;
				} else {
					return false;
				}
			} else {
				JavascriptExecutor js = (JavascriptExecutor) testCase.getMobileDriver();
				HashMap<Object, Object> scrollObject = new HashMap<>();
				try {
					scrollObject.put("predicateString", attribute + " CONTAINS '" + value + "'");
					js.executeScript("mobile:scroll", scrollObject);
				} catch (Exception e) {
					scrollObject.clear();
					scrollObject.put("direction", "down");
					js.executeScript("mobile:scroll", scrollObject);
				}
				WebElement element = MobileUtils.getMobElement(testCase, "xpath",
						"//*[contains(@" + attribute + ",'" + value + "')]");
				// WebElement element = testCase.getMobileDriver()
				// .findElement(AppiumBy.iOSNsPredicateString(attribute + " CONTAINS '" + value
				// + "'"));
				if (element.getDomAttribute(attribute).contains(value)) {
					return true;
				} else {
					return false;
				}

			}

		} catch (NoSuchElementException e) {
			throw new Exception("Element with text/value containing : '" + value
					+ "' not found. Exception Type : No Such Element Exception");
		} catch (Exception e) {
			throw new Exception("Element with text/value containing : '" + value + "' not found. Exception Message: "
					+ e.getMessage());
		}
	}

	/**
	 * 
	 * 
	 */
	/*
	 * public static String getToastMessage(TestCases testCase) {
	 * 
	 * String fileName= takeScreenShot( System.getProperty("user.dir") +
	 * File.separator + "ToastMessages", testCase.getMobileDriver()); String str =
	 * ""; BytePointer outText; TessBaseAPI api = new TessBaseAPI();
	 * 
	 * if (api.Init(".", "ENG") != 0) {
	 * System.err.println("Could not initialize tesseract."); System.exit(1); }
	 * String fileNamePath=System.getProperty("user.dir") + File.separator +
	 * "ToastMessages"+File.separator+fileName; PIX image = pixRead(fileNamePath);
	 * api.SetImage(image);
	 * 
	 * // Get OCR result outText = api.GetUTF8Text(); str = outText.getString(); //
	 * System.out.println("OCR output:\n" + str);
	 * 
	 * // Destroy used object and release memory api.End(); outText.deallocate();
	 * pixDestroy(image);
	 * 
	 * api.close(); return str; }
	 * 
	 * 
	 * 
	 * /** <h1>Verify Device Displayed On Dashboard</h1> <p> The
	 * verifyDeviceDisplayedOnDashboard method verifies the device name passed in
	 * the parameters is present on the Dashboard. </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * 
	 * @version 1.0
	 * 
	 * @since 2018-02-15
	 * 
	 * @param testCase Instance of the TestCases class used to create the testCase.
	 * testCase instance.
	 * 
	 * @param deviceName Device name whose presence has to be verified on the dash
	 * board
	 * 
	 * @return boolean Returns 'true' if the device is present on the dash board.
	 * Returns 'false' if the device is not present on the dash board.
	 */
	public static boolean verifyDeviceDisplayedOnDashboard(TestCases testCase, String deviceName) {
		boolean flag = true;
		DashboardScreen d = new DashboardScreen(testCase);
		if (d.isDevicePresentOnDashboard(deviceName)) {
			Keyword.ReportStep_Pass(testCase, "Device : " + deviceName + " is present on the dashboard.");
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Device : " + deviceName + " is not present on the dashboard.");
		}
		return flag;
	}

	/**
	 * <h1>Verify if Device is still displayed in dashboard after deleting it</h1>
	 * <p>
	 * The verifyDeviceNotDisplayedOnDashboard method verifes if device is still
	 * displayed in dashboard after deleting it.
	 * </p>
	 *
	 * @author Pratik P. Lalseta (H119237)
	 * @version 1.0
	 * @since 2018-02-19
	 * @param testCase Instance of the TestCases class used to create the testCase.
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance.
	 * @return boolean Returns 'true' if device is not displayed in dashboard
	 *         screen. Returns 'false' if device is still displayed in dashboard
	 *         screen.
	 */
	public static boolean verifyDeviceNotDisplayedOnDashboard(TestCases testCase, TestCaseInputs inputs,
			String expectedDevice) {
		boolean flag = true;
		HashMap<String, MobileObject> fieldObjects = MobileUtils.loadObjectFile(testCase, "DAS_InstallationScreen");
		if (MobileUtils.isMobElementExists(fieldObjects, testCase, "GlobalDrawerButton", 30, false)) {
			if (MobileUtils.isMobElementExists(fieldObjects, testCase, "DashboardIconText", 5)) {
				List<WebElement> dashboardIconText = MobileUtils.getMobElements(fieldObjects, testCase,
						"DashboardIconText");
				if (MobileUtils.isMobElementExists("id", "name", testCase, 3, false)) {
					dashboardIconText.addAll(MobileUtils.getMobElements(testCase, "id", "name"));
				}
				boolean f = false;
				String deviceName = "";
				for (WebElement e : dashboardIconText) {
					String displayedText;
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						displayedText = e.getText();
					} else {
						displayedText = e.getDomAttribute("value");
					}
					if (expectedDevice.equalsIgnoreCase("Switch")) {
						deviceName = inputs.getInputValue("LOCATION1_SWITCH1_NAME");
					} else if (expectedDevice.equalsIgnoreCase("Dimmer")) {
						deviceName = inputs.getInputValue("LOCATION1_DIMMER1_NAME");
					}
					if (displayedText.equals(deviceName)) {
						f = true;
						break;
					}
				}
				if (f) {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Device : " + deviceName + " is present on the dashboard.");
				} else {
					Keyword.ReportStep_Pass(testCase, "Device : " + deviceName + " is not present on the dashboard.");
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "No devices found on the dashboard");
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "User is not on the dashboard");
		}
		return flag;
	}

	public static boolean closeCoachMarks(TestCases testCase) {
		boolean flag = true;
		CoachMarks cm = new CoachMarks(testCase);
		int counter = 0;
		if (cm.isNextButtonVisible(1)) {
			while (cm.isNextButtonVisible(1) && counter < 7) {
				flag = flag & cm.clickOnNextButton();
				if (cm.isDoneButtonVisible(1)) {
					flag = flag & cm.clickOnDoneButton();
				}
				counter++;
			}
		} else {
			if (testCase.getPlatform().toUpperCase().contains("IOS")) {
				if (MobileUtils.isMobElementExists("NAME", "Not Now", testCase)) {
					flag = flag && MobileUtils.clickOnElement(testCase, "NAME", "Not Now");
				}
			}
		}
		return flag;
	}

	/**
	 * <h1>Get Location Time</h1>
	 * <p>
	 * The getLocationTime method returns the location time
	 * </p>
	 *
	 * @author Midhun Gollapalli (H179225)
	 * @version 1.0
	 * @since 2018-02-15
	 * @param testCase Instance of the TestCases class used to create the testCase
	 * @param inputs   Instance of the TestCaseInputs class used to pass inputs to
	 *                 the testCase instance
	 * @return TimeZone Returns the location time
	 */
	public static String getLocationTime(TestCases testCase, TestCaseInputs inputs, String timeFormat) {
		LocationInformation locInfo = new LocationInformation(testCase, inputs);
		String time = " ";
		try {
			TimeZone timeZone = TimeZone.getTimeZone(locInfo.getIANATimeZone());
			System.out.println("@@@@@@@@timeZone: " + timeZone);

			Calendar date = Calendar.getInstance(timeZone);
			String ampm;
			if (date.get(Calendar.AM_PM) == Calendar.AM) {
				ampm = "AM";
			} else {
				ampm = "PM";
			}
			String hour;
			if (date.get(Calendar.HOUR) == 0) {
				hour = "12";
			} else {
				hour = String.valueOf(date.get(Calendar.HOUR));
			}
			String minute;
			if (date.get(Calendar.MINUTE) < 10) {
				minute = "0" + date.get(Calendar.MINUTE);
			} else {
				minute = String.valueOf(date.get(Calendar.MINUTE));
			}
			int month = date.get(Calendar.MONTH) + 1;
			switch (timeFormat) {
			case "TIMEINYYMMHHMMFORMAT": {
				time = String.valueOf(date.get(Calendar.YEAR) + "-" + month + "-" + date.get(Calendar.DAY_OF_MONTH)
						+ "T" + hour + ":" + minute + " " + ampm);
				break;
			}
			case "TIMEINHHMMFORMAT": {
				time = String.valueOf(hour + ":" + minute + " " + ampm);
				break;
			}
			}
		} catch (Exception e) {
			time = "";
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Get Android Device Time : Error Occured : " + e.getMessage());
		}
		return time;
	}

	@SuppressWarnings("unchecked")
	public static boolean changeLocationSettings(TestCases testCase, TestCaseInputs inputs, String status) {
		boolean flag = true;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			// In Appium 9.x, startActivity was removed from AndroidDriver; use mobile: startActivity extension
			java.util.Map<String, Object> activityArgs = new java.util.HashMap<>();
			activityArgs.put("appPackage", "com.android.settings");
			activityArgs.put("appActivity", "com.android.settings.Settings");
			((AndroidDriver) testCase.getMobileDriver()).executeScript("mobile: startActivity", activityArgs);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error - " + e.getMessage());
				e.printStackTrace();
			}
			WebElement elem = ((CustomDriver) testCase.getMobileDriver()).scrollTo("Location");
			elem = ((AndroidDriver) testCase.getMobileDriver())
					.findElement(By.xpath("//android.widget.TextView[@text='Location']"));
			if (elem != null) {
				elem.click();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error - " + e.getMessage());
				e.printStackTrace();
			}
			elem = ((AndroidDriver) testCase.getMobileDriver())
					.findElement(By.id("com.android.settings:id/switch_widget"));
			if (elem != null) {
				if (status.equalsIgnoreCase("On")) {
					if (elem.getText().equalsIgnoreCase("Off")) {
						elem.click();
						Keyword.ReportStep_Pass(testCase, "Location toggle is on");
						elem = ((AndroidDriver) testCase.getMobileDriver())
								.findElement(By.xpath("//android.widget.Button[@text='AGREE']"));
						if (elem != null) {
							elem.click();
							Keyword.ReportStep_Pass(testCase, "Location services is turned on");
						}
					} else {
						Keyword.ReportStep_Pass(testCase, "Location services is already on");
					}
				} else if (status.equalsIgnoreCase("Off")) {
					if (elem.getText().equalsIgnoreCase("On")) {
						elem.click();
						inputs.setInputValue(InputVariables.MOBILE_LOCATION_OFF, "true");
						Keyword.ReportStep_Pass(testCase, "Location services is turned off");
					} else {
						inputs.setInputValue(InputVariables.MOBILE_LOCATION_OFF, "true");
						Keyword.ReportStep_Pass(testCase, "Location services is already off");
					}
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to locate Location services switch");
			}
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Error - " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			boolean success = false;
			if (!MobileUtils.launchSettingsAppOnIOS(testCase)) {
				flag = false;
			} else {
				Dimension dimension = testCase.getMobileDriver().manage().window().getSize();

				for (int i = 0; i < 5; ++i) {
					if (success) {
						break;
					}
					try {
//						action.press(10, (int) (dimension.getHeight() * .5))
//								.moveTo(0, (int) (dimension.getHeight() * -.2)).release().perform();
						W3CTouchActions.swipe(testCase.getMobileDriver(), 10, (int) (dimension.getHeight() * .5), 10, (int) (dimension.getHeight() * .3), Duration.ofMillis(500));
					} catch (Exception e) {
					}

					FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
					fWait.pollingEvery(Duration.ofMillis(500));
					fWait.withTimeout(Duration.ofSeconds(5));
					try {
						WebElement elem = fWait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@label='Privacy']")));
						if (elem != null) {
							elem.click();
							success = true;
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Scroll to Privacy : Privacy option not found");
						}
					} catch (TimeoutException e) {
						// Retry again
					}
				}

				if (MobileUtils.isMobElementExists("name", "Location Services", testCase, 5)) {
					if (!MobileUtils.clickOnElement(testCase, "name", "Location Services")) {
						flag = false;
					} else {
						List<WebElement> locServ = MobileUtils.getMobElements(testCase, "xpath",
								"//*[@name='Location Services']");
						WebElement toggleSwitch = null;
						toggleSwitch = locServ.get(4);
						/*
						 * for (WebElement locSer : locServ) {
						 * System.out.println(locSer.getDomAttribute("value")); if
						 * (locSer.getDomAttribute("value").equalsIgnoreCase("0") ||
						 * locSer.getDomAttribute("value").equalsIgnoreCase("1")) { toggleSwitch = locSer;
						 * break; } else { toggleSwitch = null; } }
						 */
						if (toggleSwitch != null) {
							if (status.equalsIgnoreCase("off")) {
								if (toggleSwitch.getDomAttribute("value").equalsIgnoreCase("1")) {
									toggleSwitch.click();
									if (MobileUtils.isMobElementExists("name", "Turn Off", testCase, 5)) {
										if (!MobileUtils.clickOnElement(testCase, "name", "Turn Off")) {
											flag = false;
										} else {
											inputs.setInputValue(InputVariables.MOBILE_LOCATION_OFF, "true");
											Keyword.ReportStep_Pass(testCase, "Turned off Location Services");
										}
									}
								} else {
									inputs.setInputValue(InputVariables.MOBILE_LOCATION_OFF, "true");
									Keyword.ReportStep_Pass(testCase, "Location Services is already turned off");
								}
							} else {
								if (toggleSwitch.getDomAttribute("value").equalsIgnoreCase("0")) {
									toggleSwitch.click();
									Keyword.ReportStep_Pass(testCase, "Turned on Location Services");
								} else {
									Keyword.ReportStep_Pass(testCase, "Location Services is already turned on");
								}
							}
						} else {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to locate the Location Services switch");
						}
					}
				}
				MobileUtils.closeSettingsAppOnIOS(testCase);
			}
		}
		return flag;
	}

	public static String[][] getAllAlerts(TestCases testCase) throws Exception {

		String alerts[][] = new String[1][1];
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("id", "ll_history_msg_container", testCase, 10)) {
					List<WebElement> linearLayouts = new ArrayList<WebElement>();
					linearLayouts = MobileUtils.getMobElements(testCase, "id", "ll_history_msg_container");
					alerts = new String[linearLayouts.size()][2];
					int i = 0;
					for (WebElement e : linearLayouts) {
						List<WebElement> alertDetails = e.findElements(By.className("android.widget.TextView"));
						int j = 0;
						for (WebElement details : alertDetails) {
							if (j > 1) {
								break;
							}
							alerts[i][j] = details.getDomAttribute("text");
							j++;
						}
						i++;
					}
				} else {
					throw new Exception("No Alerts found");
				}
			} else {
				if (MobileUtils.isMobElementExists("name", "alerts_cell", testCase, 10)) {

					List<WebElement> tableCells = new ArrayList<WebElement>();
					// tableCells = MobileUtils.getMobElements(testCase,
					// "xpath","//XCUIElementTypeCell");
					tableCells = testCase.getMobileDriver().findElements(By.name("alerts_cell"));
					alerts = new String[tableCells.size()][2];
					int i = 0;
					for (WebElement e : tableCells) {
						List<WebElement> alertDetails = e.findElements(By.xpath("//XCUIElementTypeStaticText"));
						int j = 0;
						for (WebElement details : alertDetails) {
							if (j > 1) {
								break;
							}
							alerts[i][j] = details.getDomAttribute("value");
							j++;
						}
						i++;
					}
				} else {
					throw new Exception("No Alerts found");
				}

			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return alerts;
	}

	public static boolean hideKeyboard(TestCases testCase) {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			MobileUtils.hideKeyboard(testCase.getMobileDriver(), "try to hide kayboard in mobile");
			flag = true;
		} else {
			if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Done", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "Done");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "DONE", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "DONE");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Return", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "Return");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "RETURN", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "RETURN");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "return", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "return");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "done", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "done");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "Ok", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "Ok");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "OK", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "OK");
			} else if (MobileUtils.isMobElementExists("ACCESSIBILITY ID", "ok", testCase, 1)) {
				flag = MobileUtils.clickOnElement(testCase, "ACCESSIBILITY ID", "ok");
			} else {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
						"Not able to close keyboard in iOS");
			}
		}
		if (flag) {
			Keyword.ReportStep_Pass(testCase, "Keyboard closed successfully");
		}

		return flag;
	}

	public static boolean CloseKeyboard(TestCases testCase) {
		try {
			testCase.getMobileDriver().executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
			Keyword.ReportStep_Pass(testCase, "Keyboard closed");
			return true;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(null, FailType.FUNCTIONAL_FAILURE, "not able to close Keyboard");
			return false;
		}
	}

	public static boolean isNumeric(String string) {
		int intValue;
		System.out.println(String.format("Parsing string: \"%s\"", string));
		if (string == null || string.equals("")) {
			System.out.println("String cannot be parsed, it is null or empty.");
			return false;
		}
		try {
			intValue = Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("Input String cannot be parsed to Integer.");
		}
		return false;
	}
	
	public static boolean Loginto_ResideoPro(TestCases testCase, TestCaseInputs inputs, FirstAlertLoginScreen diy) {
		boolean flag = false;
		try {
			String env =  testCase.getTestCaseInputs().getInputValue(TestCaseInputs.APP_ENVIRONMENT);
			String userName = inputs.getInputValue("USERID").toString();
			String password = inputs.getInputValue("PASSWORD").toString();
			FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
			fWait.pollingEvery(Duration.ofSeconds(2));
			fWait.withTimeout(Duration.ofMinutes(3));
			Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					try {
						if(diy.isMaintenanceScreenPresent()) {
							diy.clickOnOkBtn();
						}
						String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
						String screename = getScreenName_ResideoPro(pageSource);
						if (screename.equals("MAIN SCREEN")) {
							if(setEnvironmentResideoPro(testCase,env)) {
								System.out.println("Succesfully set the environment to :"+env);
								if (diy.clickOnResideoProloginButton()) {
									Keyword.ReportStep_Pass(testCase, "Clicked on Resideo Pro Account btn");
									SystemState.getStatus().isClickedResideoProAccountBtn(true);
								}
								System.out.println("main screen, clicked login button");
							}else {
								System.out.println("Failed to set the environment to :"+env);
							}
							return false;
						} else if (!SystemState.getStatus().isSignIndone() && screename.equals("SIGN IN SCREEN")) {
							if (loginToFirstAlertApp(testCase, inputs, diy, userName, password)) {
								System.out.println("sign in screen, clicked login button");
								SystemState.getStatus().isSignIndone(true);
							}
							return false;
						} else if (screename.equals("SETTINGS")) {
							if (diy.clickOnBackButton()) {
								System.out.println("Settings screen moving back to home screen....");
							}
							return false;
						} else if (screename.equals("DASHBOARD")) {
							System.out.println("Present Screen is dashboard.");
							return true;
						} else if (screename.equals("UNKNOWN")) {
							System.out.println("unknown.. trying to find screen .......");
							return false;
						} else {
							System.out.println("nothing able to find,, wait......");
							return false;
						}
					} catch (StaleElementReferenceException e) {
						Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
						return false;
					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
						return false;
					} catch (StackOverflowError e) {
						Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
						return false;
					} catch (NoSuchElementException e) {
						Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
						return false;
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to login or might need to check the app flow");
						return false;
					}
				}
			});
			if (isEventReceived) {
				flag = true;
			}
		} catch (StaleElementReferenceException e) {
			Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
			flag = false;
		} catch (TimeoutException e) {
			Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
			flag = false;
		} catch (StackOverflowError e) {
			Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
			flag = false;
		} catch (NoSuchElementException e) {
			Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
			flag = false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to login or might need to check the app flow");
			flag = false;
		}
		return flag;
	}

	public static boolean setEnvironmentResideoPro(TestCases testCase, String env) {
		boolean flag = false;
		FirstAlertLoginScreen screen = new FirstAlertLoginScreen(testCase);
		if (screen.isSettingBtnPresent()) {
			Keyword.ReportStep_Pass(testCase, "Setting Icon is Present is Main Screen.");
			if (screen.clickOnSettingBtn()) {
				if (!screen.verifyLoginEnv(env)) {
					if (screen.clickOnLoginEnvTab()) {
						flag = screen.clickOnReqEnv(env);
						flag = flag && screen.clickOnOkBtn();
						if (flag) {
							flag=screen.verifyLoginEnv(env);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Rquired Environment is Not Set.");
						}
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Failed to click on Login Environment Tab");
					}
				} else {
					flag = true;
					Keyword.ReportStep_Pass(testCase, "Env is already set to:" + env);
				}
				flag = flag && screen.clickOnBackButton();
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Failed to click on Settings Btn");
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Setting Icon Is not present in the main Screen");
		}
		return flag;
	}

	public static String getScreenName_ResideoPro(String pageSource) {
		String screenName = null;
		pageSource = pageSource.toUpperCase();
		if (pageSource.contains("SIGN IN WITH") && pageSource.contains("CREATE ACCOUNT")) {
			screenName = "MAIN SCREEN";
		}else if (pageSource.contains("SETTINGS") && pageSource.contains("USE LOCAL AUTHORIZATION") && pageSource.contains("USER SETTINGS")) {
			screenName = "SETTINGS";
		}  else if (pageSource.contains("EMAIL") && pageSource.contains("PASSWORD")) {
			screenName = "SIGN IN SCREEN";
		} else if (pageSource.contains("SET UP PRODUCT") && pageSource.contains("FEATURED PRODUCT".toUpperCase())) {
			screenName = "DASHBOARD";
		} 
		return screenName;
	}
}