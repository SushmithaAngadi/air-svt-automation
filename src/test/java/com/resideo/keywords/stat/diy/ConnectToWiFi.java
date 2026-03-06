package com.resideo.keywords.stat.diy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
import com.resideo.system.utils.DeviceEnums.A_DeviceInfoItem;
import com.resideo.system.utils.DeviceEnums.A_FC_WifiSecurity;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg;
import com.resideo.utils.stat.cattgrpccommands.WifiSecurityModeMsg.WifiSecurityMode;

import io.cucumber.java.en.Then;

import com.resideo.system.utils.KeepAppActive;

public class ConnectToWiFi extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
//	private TestCaseInputs inputs;
	ArrayList<String> keywordInputs;

	public ConnectToWiFi(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
//		this.inputs = inputs;
		this.keywordInputs = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Then(value = "^user connects stat to WiFi \"(.+)\" with password \"(.+)\" and expected to \"(.+)\" to WiFi$")
	@Override
	@KeywordStep(gherkins = "^user connects stat to WiFi \"(.+)\" with password \"(.+)\" and expected to \"(.+)\" to WiFi$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			KeepAppActive appActive = new KeepAppActive(testCase);

			try {
				
				StatCommands.getInstance().cattCommandsStub.setNetworkSecurity(WifiSecurityModeMsg.newBuilder()
						.setMode(WifiSecurityMode.WPA2_AES_PSK).build());
				
				StatCommands.getInstance().cattCommandsStub.setNetworkName(String_Msg.newBuilder()
						.setStrVal((keywordInputs.get(0).trim())).build());
				
				StatCommands.getInstance().cattCommandsStub.setNetworkPassword(String_Msg.newBuilder()
						.setStrVal((keywordInputs.get(1).trim())).build());
				Keyword.ReportStep_Pass(testCase, "Network configurations...");
				Keyword.ReportStep_Pass(testCase, "Network name : " + keywordInputs.get(0).trim());
				Keyword.ReportStep_Pass(testCase, "Network password : " + keywordInputs.get(1).trim());
				Keyword.ReportStep_Pass(testCase, "Network password : " + keywordInputs.get(1).trim());
				Keyword.ReportStep_Pass(testCase,
						"Network security : " + A_FC_WifiSecurity.WPA2_AES_PSK.toString());

				appActive.start();
				boolean eventRec = false;
				try {
					FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
					fwait1.pollingEvery(Duration.ofSeconds(5));
					fwait1.withTimeout(Duration.ofMinutes(2));
					boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean input) {
							try {
								String_Msg IP = StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
								String val = IP.getStrVal(); 
								if(!val.equalsIgnoreCase("Invalid"))
//								if (!FCDeviceUtils.getInstance().Get_DeviceInfo(A_DeviceInfoItem.IPV4_ADRESS)
//										.equalsIgnoreCase("Invalid"))
									return true;
								else {
									Keyword.ReportStep_Pass(testCase,
											"Waitting for WiFi to verify credentials ...");
									return false;
								}
							} catch (Exception e) {
								Keyword.ReportStep_Pass(testCase, "Failed to read IPV4 address...");
								return false;
							}
						}

					});
					if (isEventReceived1) 						
					{
						if(keywordInputs.get(2).trim().equalsIgnoreCase("Connect")) 
						{
							Keyword.ReportStep_Pass(testCase, "Device connected to WiFi as expected");
							flag = true;
						}
						else 
						{
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device connected to WiFi");
							flag = false;
						}
					}							
					else 
					{
						if(keywordInputs.get(2).trim().equalsIgnoreCase("Not Connect")) 
						{
							Keyword.ReportStep_Pass(testCase, "Device not connected to WiFi as expected.");
							flag = true;
						}
						else 
						{
							Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device not connected to WiFi");
							flag = false;
						}
					}
					
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
									String_Msg IP = StatCommands.getInstance().cattCommandsStub
											.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
									String val = IP.getStrVal(); 
									if(!val.equalsIgnoreCase("Invalid"))
//									if (!FCDeviceUtils.getInstance().Get_DeviceInfo(A_DeviceInfoItem.IPV4_ADRESS)
//											.equalsIgnoreCase("Invalid"))
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
							String_Msg IP = StatCommands.getInstance().cattCommandsStub
									.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.IPV4_ADRESS).build());
							String val = IP.getStrVal();
							Keyword.ReportStep_Pass(testCase, "Conncted to router : "
									+ val);
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
