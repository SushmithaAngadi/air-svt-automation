package com.resideo.keywords.app.common;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.api.dfc.CHILUtil;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommonCommandUtils;


import io.cucumber.java.en.And;
public class CheckDeviceIsAvailableInCloud extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	private TestCaseInputs inputs;
	KeepAppActive appActive;

	public CheckDeviceIsAvailableInCloud(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@And(value = "^check thermostat is unregister(.+) in cloud, if not delete from cloud using cloud wrapper API$")
	@Override
	@KeywordStep(gherkins = "^check thermostat is unregister(.+) in cloud, if not delete from cloud using cloud wrapper API$")
	public boolean keywordSteps() {
//		try {
//			appActive = new KeepAppActive(testCase);
//			appActive.start();
//			String macID = StatCommands.getInstance().cattCommandsStub
//					.getDeviceInformation(String_Msg.newBuilder().setStrVal("MAC_ID").build()).getStrVal();
////			String macID ="48A2E64C90F0";
//			System.out.println(macID);
//			flag = LCC_Admin.getdeviceInfo(testCase, inputs, macID);
//		} catch (Exception e) {
//			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION,
//					"LCC ADMIN Unregistration flow having exception , Exception are " + e.getMessage());
//			flag = false;
//		}

		try {
			appActive = new KeepAppActive(testCase);

			appActive.start();
			String macID=StatCommonCommandUtils.getStatMacID();
			
			if (exampleData.get(0).toUpperCase().contains("TRUE")) {

				if ((SystemState.getStatus().IsThermostatLocationSet() || SystemState.getStatus().IsThermostatNameSet())
						&& !SystemState.getStatus().IsDeviceDeletedFromApp()) {
					FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
					fWait.pollingEvery(Duration.ofSeconds(2));
					fWait.withTimeout(Duration.ofMinutes(2));
					boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean flag1) {
							try {
								if (LyricUtils.isMacIDInformationAvailable(testCase, inputs, macID)) {
									String deviceID = LyricUtils.deviceID;
									long locationID = LyricUtils.locationID;
									CHILUtil ch = new CHILUtil(inputs);
									ch.getConnection();
									int deleteDevice = ch.deleteDevice(locationID, deviceID, false);
									if (deleteDevice == 200) {
										ReportStep_Pass(testCase,
												"Thermostat Successfully deleted from Cloud by using cloud wrapper API, Rsponse Code is "+deleteDevice);
										ch.close();
										return true;
									} else {
										ReportStep_Fail(testCase, FailType.NO_FAILURE,
												"Thermosat not able to unregister by using Cloud API, Rsponse Code is "+deleteDevice);
										ch.close();
										return false;
									}
								} else {
									ReportStep_Pass(testCase,
											"Thermostat Not available in provided account, pls verify its register in proper account , which one provided in requirement file, or might be deleted from APP side ");
									return true;
								}

							} catch (Exception e) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"failed due to : " + e.getMessage());
								return false;
							}

						}
					});
					if (isEventReceived) {
						flag = true;
					} else {
						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Thermosat not able to unregister by using Cloud API");
						flag = false;
					}

				} else {
					FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
					fWait.pollingEvery(Duration.ofSeconds(1));
					fWait.withTimeout(Duration.ofSeconds(1));
					boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean flag1) {
							try {
								if (LyricUtils.isMacIDInformationAvailable(testCase, inputs, macID)) {
									String deviceID = LyricUtils.deviceID;
									long locationID = LyricUtils.locationID;
									CHILUtil ch = new CHILUtil(inputs);
									ch.getConnection();
									int deleteDevice = ch.deleteDevice(locationID, deviceID, false);
									if (deleteDevice == 200) {
										ReportStep_Pass(testCase,
												"Thermostat Successfully deleted from Cloud by using cloud wrapper API");
										ch.close();
										return true;
									} else {
										ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
												"Thermosat not able to unregister by using Cloud API");
										ch.close();
										return false;
									}
								} else {
									ReportStep_Pass(testCase,
											"Thermostat Not available in provided account, pls verify its register in proper account , which one provided in requirement file, or might be deleted from APP side ");
									return true;
								}

							} catch (Exception e) {
								Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
										"failed due to : " + e.getMessage());
								return false;
							}

						}
					});
					if (isEventReceived) {
						flag = true;
					} else {
						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Thermosat not able to unregister by using Cloud API");
						flag = false;
					}
				}
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		appActive.requestStop();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			ReportStep_Pass(testCase, e.getMessage());
		}
		if (appActive.isAlive()) {
			appActive.requestStop();
		}
		System.out.println(appActive.isAlive());
		SystemState.getStatus().IsThermostatLocationSet(false);
		SystemState.getStatus().IsThermostatNameSet(false);
		SystemState.getStatus().IsDeviceDeletedFromApp(false);
		return flag;
	}
}
