package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.screens_Gui.GUI_Screen_Utils;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class SelectOptionFromScreen extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = false;

	public SelectOptionFromScreen(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag = true;
	}

	@Given(value = "^User select GUI option (.+) from (.+) screen$")
	@Override
	@KeywordStep(gherkins = "^User select GUI option (.+) from (.+) screen$")
	public boolean keywordSteps() throws KeywordException {
		String option = exampleData.get(0);
		String screenName = exampleData.get(1);
		SetUpDevice_T9_T10_T0Plus gui = new SetUpDevice_T9_T10_T0Plus();
		if (testCase.isTestSuccessful()) {
			try {
				switch (screenName.toUpperCase()) {
				case "WELCOME":
					if (gui.isTextIsPresentInScreen(testCase, Duration.ofSeconds(10), Duration.ofSeconds(90), 20, 10,
							287, 75, 1, "Welcome")) {
						flag = gui.clickOnGetStartedButton();
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Welcome screen after factory reset");
						flag = false;
					}

					break;
				case "LANGUAGE":
					if (option.toUpperCase().contains("ENGLISH")) {
						flag = gui.clickOnNextButton();
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"English only applicable, Please configure only english");
						flag = false;
					}
					break;
				case "APPLICATION":

					if (gui.isApplicationScreen()) {
						if (gui.chooseApplicationType(option.toUpperCase())) {
							flag = gui.clickOnNextButton();
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"Bedroom or Living Space only applicable, Please configure Available room");
							flag = false;
						}

					} else {
						ReportStep_Pass(testCase,
								"Application screen is not available, Need to check in New Requirements");
						flag = true;
					}

					break;
				case "ROOM TYPE":

					if (gui.isTextIsPresentInScreen(testCase, Duration.ofSeconds(30), 33, 48, 287, 75, 1,
							"what type of room")) {
						flag = gui.clickOnTypeRoom_Selection(testCase, option);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Room type screen, Room type is " + option);
						flag = false;
					}
					break;
				case "ROOM NAME":
					if (gui.isTextIsPresentInScreen(testCase, Duration.ofSeconds(30), 120, 3, 200, 30, 1, "Room")) {
						flag = gui.chooseRoomInAddingIASSensor(testCase, option);
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to find Room name screen after selecting the room type. Room name is "
										+ option);
						flag = false;
					}
					break;
				case "RETAIL ROOM TYPE":
				case "RETAIL ROOM NAME":

					if (gui.clickOnretailRoomName(testCase, option.toUpperCase())) {
						flag = true;
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Master, Guest , Family , Living, Rec Room only applicable, Please configure Available room");
						flag = false;
					}
					break;
				case "REDLINK":
					if (option.toUpperCase().contains("SETUP LATER") || option.toUpperCase().contains("SETUPLATER")) {
						flag = gui.clickOnRedlinkSetUpLaterButton();
					} else {
						flag = gui.clickOnRedlinkAddDeviceButton();
					}
					break;
				case "EXIT INSTALLER SETUP":
					if (gui.isExitInstallerScreen()) {
						if (option.toUpperCase().contains("EXIT SETUP") || option.contains("DON'T EXIT")) {
							flag = gui.exitInstallerSetup(option);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"exit or don't exit options only applicable, select any one these option only");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Exit installer setup? screen is not visible");
						flag = false;
					}
					break;
				case "CONNECT APP":
					if (gui.isConnectAppScreen()) {
						if (option.toUpperCase().contains("CONNECT APP") || option.contains("SET UP LATER")
								|| option.contains("SETUP LATER")) {
							flag = gui.connectApp(option);
						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"connect app orset up later options only applicable, select any one these option only");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"connect app screen is not visible");
						flag = false;
					}
					break;
				case "IS RESIDEO APP INSTALLED":
					if (gui.isConnectApp_AppAvailablityScreen()) {
						if (option.toUpperCase().contains("YES, I HAVE THE APP")
								|| option.toUpperCase().contains("NO, I NEED TO DOWNLOAD")) {
							if (gui.connectApp_AppAvailability(option)) {
								if (option.contains("YES, I HAVE THE APP")) {
									{
										String timestamp = GUI_Screen_Utils.timestamp();
										flag = gui.verifyQRScanScreenAndTakeQRScreenShot(testCase, timestamp);
									}
								}
							} else {
								Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
										"Failed to tap on " + option);
								flag = false;
							}

						} else {
							Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
									"yes, i have the app or no, i need to download options only applicable, select any one these option only");
							flag = false;
						}
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"connect app screen is not visible");
						flag = false;
					}
					break;
				case "RETAIL SENSOR":
					if (option.toUpperCase().contains("SETUP LATER") || option.toUpperCase().contains("SETUPLATER")) {
						flag = gui.clickOnRetailSensorSetUpLaterButton();
					} else {
						flag = gui.clickOnRetailSensorAddDeviceButton();
					}
					break;
				case "ISU":
					if (option.toUpperCase().contains("DONE")) {
						flag = gui.clickOnDoneButton();
					} else if (option.toUpperCase().contains("NEXT")) {
						flag = gui.clickOnNextButton();
					}
					break;
				case "WIFI":
					if (option.toUpperCase().contains("SETUP LATER") || option.toUpperCase().contains("SETUPLATER")) {
						flag = gui.clickOnWIFISetUpLaterButton();
					} else {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Wifi connect is not available, Select wifi later");
						flag = false;
					}
					break;
				case "CURRENT DATE":
					String ParseStatTime = gui._unixToDateTime(new Date().getTime(), "yyyy-MM-dd HH:mm");
					StatCommands.getInstance().cattCommandsStub
							.setDateTime(String_Msg.newBuilder().setStrVal(ParseStatTime).build()).getResponseState();
					flag = gui.clickOnDoneButton();
					break;
//				
				case "Scheduling":
				case "SCHEDULING":
					if (option.toUpperCase().contains("SETUP LATER") || option.toUpperCase().contains("SETUPLATER")) {
						flag = gui.clickOnWIFISetUpLaterButton();
					} else {
						flag = gui.clickOnCreateScheduleButton();
					}
					break;
				case "C-wire Adapter":
				case "C-WIRE ADAPTER":
					flag = gui.selectCWireAdapter(option);
					break;
				case "WIFI CONFIGURATION":
					if (option.toUpperCase().contains("SETUP LATER") || option.toUpperCase().contains("SETUPLATER")) {
						flag = gui.clickOnWIFISetUpLaterButton();
					} else {
						String wifiSSID = SuiteConstants
								.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
						String wifiSecurity = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
								"WIFI_SECURITY");
						String wifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
								"WIFI_PASSWORD");
						String wifiBandwidth = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
								"WIFI_BANDWIDTH");
						flag = gui.wifiConfiguration(testCase, wifiSSID, wifiBandwidth, wifiSecurity, wifiPassword);
					}
					break;
				default:
					break;
				}

				if (flag) {
					Keyword.ReportStep_Pass(testCase,
							"Isu type " + screenName + " , ISU Value is " + option + " ,Successfully saved");
					flag = true;
				} else {
					ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Isu type " + screenName + " , ISU Value is " + option + " ,failed");
					flag = false;
				}
			} catch (

			Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Isu type " + screenName + " , ISU Value is " + option + " ,failed");
				flag = false;
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag = true;
	}
}