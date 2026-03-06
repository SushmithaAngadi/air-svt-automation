package com.resideo.keywords.app.diy_common;

import java.util.ArrayList;
import java.util.Set;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.api.dfc.CHILUtil;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.StatCommonCommandUtils;

import io.cucumber.java.en.Given;

public class ChilRegistration_Unregister extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String devicename;
	String macID;
	String deviceType;
	String modelName;

	public ChilRegistration_Unregister(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			macID = StatCommonCommandUtils.getStatMacID();
			Keyword.ReportStep_Pass(testCase, "<b>Start Executing precondition </b>");
			try {
				modelName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
						.toUpperCase().trim();
				if (modelName.contains("JASPER")) {
					deviceType = "Jasper";
				} else if (modelName.contains("FLY") || modelName.contains("THOR")) {
					deviceType = "Flycatcher";
				}
				devicename = "Tstat " + macID.substring(6, 12);
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.toString());
			}
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;
	}

	@Given(value = "^user thermostat should be (.+) in cloud$")
	@Override
	@KeywordStep(gherkins = "^user thermostat should be (.+) in cloud$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful()) {

			String register_unregister = exampleData.get(0).toUpperCase();
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				if (register_unregister.contains("UNREGISTER")) {
					if (LyricUtils.isMacIDInformationAvailable(testCase, testCase.getTestCaseInputs(), macID)) {
						String deviceID = LyricUtils.deviceID;
						long locationID = LyricUtils.locationID;
						CHILUtil ch = new CHILUtil(testCase.getTestCaseInputs());
						ch.getConnection();
						int deleteDevice = ch.deleteDevice(locationID, deviceID, false);
						if (deleteDevice == 200) {
							ReportStep_Pass(testCase,
									"Thermostat Successfully deleted from Cloud by using cloud wrapper API, Rsponse Code is "
											+ deleteDevice);
							ch.close();
							flag = true;
						} else {
							ReportStep_Fail(testCase, FailType.NO_FAILURE,
									"Thermosat not able to unregister by using Cloud API, Rsponse Code is "
											+ deleteDevice);
							ch.close();
							flag = false;
						}
					} else {
						ReportStep_Pass(testCase, "Thermostat already unregister from the cloud.");
						flag = true;
					}

				} else {
					if (LyricUtils.isMacIDInformationAvailable(testCase, testCase.getTestCaseInputs(), macID)) {
						ReportStep_Pass(testCase, "Thermostat already register from the cloud.");
						flag = true;
					} else {
						CHILUtil ch = new CHILUtil(testCase.getTestCaseInputs());
						if (ch.getConnection()) {

							Set<String> locationNames = ch.getLocationNames();
							String first = locationNames.stream().findFirst().get();
							long locationID = ch.getLocationID(first);

							if (ch.registerChilThermostat(locationID, macID, devicename, deviceType)) {
								ReportStep_Pass(testCase,
										"Thermostat registered successfully, location name is " + first
												+ " , mac ID is " + macID + " ,Device name is " + devicename
												+ " ,device type is " + deviceType);
								flag = true;
								ch.close();
							} else {
								ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to register, check the account or already register in other account and internet is working or not..");
								flag = false;
								ch.close();
							}

						} else {
							ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Fail to connect with cloud");
							flag = false;
							ch.close();
						}

					}
				}

			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e);
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

		return flag;
	}
}
