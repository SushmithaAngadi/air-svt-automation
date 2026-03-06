package com.resideo.keywords.stat.wifi;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.KeepAppActive;
import com.resideo.system.utils.DeviceEnums.A_FC_WifiModuleState;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;

import io.cucumber.java.en.Then;

import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.web.WebController;

public class VerifyWiFiState extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public VerifyWiFiState(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Then(value = "^user verifies current WiFi state of stat$")
	@Override
	@KeywordStep(gherkins = "^user verifies current WiFi state of stat$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			KeepAppActive appActive = new KeepAppActive(testCase);
			appActive.start();
			String router_SSID_Name = WebController.router_SSID_Name();
			try {
				String_Msg Device = StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_STATUS).build());
				String Wifi = Device.getStrVal();
				if(Wifi == A_FC_WifiModuleState.ON.toString()) 
				{
					boolean eventRec = false;
					try {
						FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
						fwait1.pollingEvery(Duration.ofSeconds(5));
						fwait1.withTimeout(Duration.ofMinutes(2));
						boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
							public Boolean apply(Boolean input) {
								try {
									String ipAddress = StatCommands.getInstance().cattCommandsStub
											.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build())
											.getStrVal();
									String WifiName = StatCommands.getInstance().cattCommandsStub
											.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_NETWORK).build())
											.getStrVal();
									if (ipAddress == null) {
										Keyword.ReportStep_Pass(testCase,
												"Wifi not connected, wait for sometime if thermostat try to connect to the wifi");
										return false;
									} else if (ipAddress.contains("invalid")) {
										if (WifiName == null || WifiName.isEmpty()) {
											Keyword.ReportStep_Pass(testCase, "WIFI not configured");
											return true;
										} else {
											Keyword.ReportStep_Pass(testCase,
													"WIFI IP is invalid, wifi name is not empty or null, WIfi name is " + WifiName);
											return false;
										}
									} else if ((ipAddress.substring(0, 2).contains("0."))
											|| (ipAddress.substring(0, 1).contains("0"))) {
										Keyword.ReportStep_Pass(testCase,
												"Wifi not connected, wait for sometime if thermostat try to connect to the wifi. IP from device is "
														+ ipAddress);
										return false;
									} else if (ipAddress.substring(0, 3).contains("169")) {
										Keyword.ReportStep_Pass(testCase,
												"WIFI configured may be its in link local, IP address is " + ipAddress);
										return false;
									} else if (!ipAddress.substring(0, 3).contains("169") && WifiName.contains(router_SSID_Name)) {
										Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
										Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
										return true;
									} else if (WifiName.contains(router_SSID_Name)) {
										Keyword.ReportStep_Pass(testCase, "WIFI configured, IP address is " + ipAddress);
										Keyword.ReportStep_Pass(testCase, "WIFI configured, Wifi Name is " + WifiName);
										Keyword.ReportStep_Pass(testCase, "Thermostat wifi is not in link local");
										return true;
									} else {
										Keyword.ReportStep_Pass(testCase, "Current IP address is " + ipAddress);
										Keyword.ReportStep_Pass(testCase, "Current Wifi Name is " + WifiName);
										return false;
									}
								
								} catch (Exception e) {
									Keyword.ReportStep_Pass(testCase, "Failed to read IPV4 address...");
									return false;
								}
							}
						});
						if (isEventReceived1)
							Keyword.ReportStep_Pass(testCase, "Current WiFi State is 'On & Conncted to Router'");

						flag = true;

					} catch (TimeoutException e) {
						flag = true;
						Keyword.ReportStep_Pass(testCase, "Current WiFi State is 'On & Not Conncted to Router'");
						appActive.requestStop();

					} catch (Exception e) {
						flag = false;
						Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Failed to set Network configuration. Exception raised : " + e.getMessage());
						appActive.requestStop();
					}
				}
				else 
				{
					Keyword.ReportStep_Pass(testCase, "Current WiFi state is 'OFF'");
					flag = true;
				}
				
				if (appActive.isAlive())
					appActive.requestStop();

			} catch (Exception e) {
				if (appActive.isAlive())
					appActive.requestStop();

				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised while initializing MDNS... " + e.getMessage());
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
		return flag;
	}
}
