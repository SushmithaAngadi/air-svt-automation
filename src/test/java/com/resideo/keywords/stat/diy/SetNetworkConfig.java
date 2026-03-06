package com.resideo.keywords.stat.diy;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
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
import com.resideo.system.utils.DeviceEnums.A_FC_WifiSecurity;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;

import io.cucumber.java.en.Then;

import com.resideo.system.utils.KeepAppActive;

public class SetNetworkConfig extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	private TestCaseInputs inputs;

	public SetNetworkConfig(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Then(value = "^Setting network configuration$")
	@Override
	@KeywordStep(gherkins = "^Setting network configuration$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			KeepAppActive appActive = new KeepAppActive(testCase);

			try {
				if (inputs.isInputAvailable("NETWORK_NAME") && inputs.isInputAvailable("NETWORK_PASSWORD")) {

					String WifiName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID");
					String WifiPassword = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
							"WIFI_PASSWORD");
					appActive.start();
					if (StatCommands.getInstance().cattCommandsStub
							.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(true).build()).getBoolVal()) {
						ReportStep_Pass(testCase, "AP mode status enabled as true, for connecting wifi");
						StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(8));
						if (StatCommands
								.getInstance().cattCommandsStub
								.setNetworkName(String_Msg.newBuilder().setStrVal(WifiName).build())
								.getResponseState()) {
							StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(2));

							if (StatCommands.getInstance().cattCommandsStub
									.setNetworkPassword(String_Msg.newBuilder().setStrVal(WifiPassword).build())
									.getResponseState()) {
								StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(2));
								if (StatCommands.getInstance().cattCommandsStub.setNetworkSecurity(
										WifiSecurityModeMsg.newBuilder().setMode(WifiSecurityMode.WPA2_AES_PSK).build())
										.getResponseState()) {
									StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(2));
									Keyword.ReportStep_Pass(testCase, "Network configurations...");
									Keyword.ReportStep_Pass(testCase, "Network name : " + WifiName);
									Keyword.ReportStep_Pass(testCase, "Network password : " + WifiPassword);
									Keyword.ReportStep_Pass(testCase,
											"Network security : " + A_FC_WifiSecurity.WPA2_AES_PSK.toString());
									flag = true;
								} else {
									ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
											"Not able to set wifi Security type for Wifi configuration");
									flag = false;
								}
							} else {
								ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
										"Not able to set wifi password for Wifi configuration");
								flag = false;
							}
						} else {
							ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Not able to set Wifi network name for Wifi configuration");
							flag = false;
						}

					} else {
						ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set Ap mode as true for Wifi configuration");
						flag = false;
					}

					if (StatCommands.getInstance().cattCommandsStub
							.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(false).build()).getBoolVal()) {
						ReportStep_Pass(testCase,
								"AP mode status enabled as false, for wifi running after wifi credential shared");
						StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(5));
					} else {
						ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to set Ap mode as false for Wifi configured confirmation");
						flag = false;
					}

					boolean eventRec = false;
					try {
						FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
						fwait1.pollingEvery(Duration.ofSeconds(5));
						fwait1.withTimeout(Duration.ofMinutes(4));
						boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
							public Boolean apply(Boolean input) {
								try {
									String_Msg IP = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
											DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
									String routerIP = IP.getStrVal();
									if (!routerIP.equalsIgnoreCase("Invalid") || !routerIP.equalsIgnoreCase("0.0.0.0")
											|| routerIP.contains("192.168."))
										return true;
									else {
										Keyword.ReportStep_Pass(testCase,
												"Waitting for WiFi to verify credentials. Current IPV4 address : "
														+ routerIP);
										return false;
									}
								} catch (Exception e) {
									Keyword.ReportStep_Pass(testCase, "Failed to read IPV4 address...");
									return false;
								}
							}

						});
						if (isEventReceived1)
							Keyword.ReportStep_Pass(testCase, "Credentials Verified");

						flag = isEventReceived1;

					} catch (TimeoutException e) {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to set Network configuration. Wait time : 2 minutes");
						appActive.requestStop();

					} catch (Exception e) {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to set Network configuration. Exception raised : " + e.getMessage());
						appActive.requestStop();
					}

					if (flag) {
						try {
							FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
							fwait1.pollingEvery(Duration.ofSeconds(5));
							fwait1.withTimeout(Duration.ofMinutes(2));
							boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
								public Boolean apply(Boolean input) {
									try {
										String_Msg IP = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
												DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
										String routerIP = IP.getStrVal();
										if (!routerIP.equalsIgnoreCase("Invalid"))
//										if (!FCDeviceUtils.getInstance().Get_DeviceInfo(A_DeviceInfoItem.IPV4_ADRESS)
//												.equalsIgnoreCase("Invalid"))
											return true;
										else {
											Keyword.ReportStep_Pass(testCase,
													"Waitting for WiFi to connect to router ...");
											return false;
										}
									} catch (Exception e) {
										Keyword.ReportStep_Pass(testCase, "failed to read IPV4 address...");
										return false;
									}
								}

							});
							if (isEventReceived1) {

								String_Msg IP = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(
										DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
								String routerIP = IP.getStrVal();
								Keyword.ReportStep_Pass(testCase, "Conncted to router : " + routerIP);
								Thread.sleep(15000);
							}

							flag = isEventReceived1;

							appActive.requestStop();

						} catch (TimeoutException e) {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to set AP mode. Wait time : 2 minutes");
							appActive.requestStop();

						} catch (Exception e) {
							flag = false;
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
									"Failed to set AP mode. Exception raised : " + e.getMessage());
							appActive.requestStop();
						}

					}

					if (appActive.isAlive())
						appActive.requestStop();

				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"No network configuration added in requirement file.");
				}

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to set network configuration");
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());

				if (appActive.isAlive())
					appActive.requestStop();
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
