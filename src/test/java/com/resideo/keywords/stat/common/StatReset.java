package com.resideo.keywords.stat.common;

import java.time.Duration;
import java.util.ArrayList;
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
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.Stat_Reset.ResetMode;
import com.resideo.utils.stat.cattgrpccommands.TimeSpanMsg;

import io.cucumber.java.en.Given;

/**
 * <h1>Stat Reset</h1>
 * <p>
 * This keyword is to reset the thermostat
 * </p>
 * <b>Author : HariHaran M (247185)</b></br>
 * 
 * Pre-condition :NA </br>
 * Keyword-steps : </br>
 * 1.Depending upon the keyword input, stat will reset.</br>
 * Post-condition : NA </br>
 * </br>
 * <b>Keyword Inputs</b> : </br>
 * testCase - Instance of the 'TestCases' class used to create the testCase
 * </br>
 * inputs - Instance of the TestCaseInputs class used to pass inputs to the
 * testCase instance </br>
 * data - ArrayList of string, keyword data </br>
 * </br>
 * <b>Returns</b> : Boolean</br>
 * Returns 'true' if succeeded. Returns 'false' if any exception, previous
 * keyword failed or if any mobile element not found. </br>
 * </br>
 * <b>Gherkin Code</b> : </br>
 * [ Reset stat to "DEFAULT NVM" using CATT ] [ Reset stat to "PRESERVE NVM"
 * using CATT ] [ Reset stat to "FACTORY DEFAULTS" using CATT ]
 */
public class StatReset extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	ArrayList<String> keywordData;

	public StatReset(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.keywordData = data;
	}
	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return true;
	}
	@Given(value = "^reset stat to (.+) using CATT$")
	@Override
	@KeywordStep(gherkins = "^reset stat to (.+) using CATT$")
	public boolean keywordSteps() throws KeywordException 
	{
		try {
			if (keywordData.get(0).toUpperCase().equalsIgnoreCase("DEFAULT NVM")) {
				StatCommands.getInstance().cattCommandsStub.setReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_SYSTEM_RESET_DEFAULT_NVM).build());
			} else if (keywordData.get(0).toUpperCase().equalsIgnoreCase("FACTORY DEFAULTS")) {				
				StatCommands.getInstance().cattCommandsStub.setReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_FACTORY_RESET).build());					
				flag = true;					
			} else if (keywordData.get(0).toUpperCase().equalsIgnoreCase("PRESERVE NVM")) {
				StatCommands.getInstance().cattCommandsStub.setReset(Stat_Reset.newBuilder().setResetMode(ResetMode.AAT_SYSTEM_RESET_PRESERVE_NVM).build());
				flag = true;					
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to reset Stat");
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}	
		return flag;
	}
	@Override
	@AfterKeyword
	public boolean postCondition() 
	{

		try 
		{
			KeepAppActive appActive = new KeepAppActive(testCase);

			appActive.start();

			if (keywordData.get(0).toUpperCase().equalsIgnoreCase("DEFAULT NVM")) {
				boolean eventRec = false;
				try {
					FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
					fwait1.pollingEvery(Duration.ofSeconds(5));
					fwait1.withTimeout(Duration.ofMinutes(2));
					boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean input) {
							try {
								if (!StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(DeviceInfoMsg.newBuilder()
												.setItem(DeviceInfoItem.IPV4_ADRESS).build())
										.getStrVal().equalsIgnoreCase("Invalid"))
									return true;
								else {
									Keyword.ReportStep_Pass(testCase, "Waitting to connect to router...");
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
						Keyword.ReportStep_Pass(testCase, "Connected to router.");
						Keyword.ReportStep_Pass(testCase, "System reset to default NVM");
						Keyword.ReportStep_Pass(testCase, "Default ISU & Schedule values are set");
					}
						
					flag = isEventReceived1;

				} catch (TimeoutException e) {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to connect to router after default nvm reset : 2 minutes");
					appActive.requestStop();

				} catch (Exception e) {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to connect to router after default nvm reset. Exception raised : "
									+ e.getMessage());
					appActive.requestStop();
				}
			}
			else if(keywordData.get(0).toUpperCase().equalsIgnoreCase("FACTORY DEFAULTS") || 
					keywordData.get(0).toUpperCase().equalsIgnoreCase("PRESERVE NVM")) 
			{
//				StatCommands.getInstance().cattCommandsStub.waitForEventDEVICERESET(TimeSpanMsg.newBuilder().setHours(0).setMinutes(20).setSeconds(0).build());/
				
				boolean eventRec = false;
				try {
					FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
					fwait1.pollingEvery(Duration.ofSeconds(5));
					fwait1.withTimeout(Duration.ofMinutes(2));
					boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean input) {
							try {
								if (!StatCommands.getInstance().cattCommandsStub
										.getDeviceInfo(DeviceInfoMsg.newBuilder()
												.setItem(DeviceInfoItem.MAC_ID).build())
										.getStrVal().equalsIgnoreCase("000000000000"))
									return true;
								else {
									Keyword.ReportStep_Pass(testCase, "Waitting to connect to router...");
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
						Keyword.ReportStep_Pass(testCase, "Connected to router.");
						Keyword.ReportStep_Pass(testCase, "System reset to default NVM");
						Keyword.ReportStep_Pass(testCase, "Default ISU & Schedule values are set");
					}
						
					flag = isEventReceived1;

				} catch (TimeoutException e) {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to connect to router after default nvm reset : 2 minutes");
					appActive.requestStop();

				} catch (Exception e) {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to connect to router after default nvm reset. Exception raised : "
									+ e.getMessage());
					appActive.requestStop();
				}
				
				
				if(!keywordData.get(0).toUpperCase().equalsIgnoreCase("FACTORY DEFAULTS"))
					Keyword.ReportStep_Pass(testCase, "System restarted with preserve NVM");
				else
					Keyword.ReportStep_Pass(testCase, "System restarted with Factory Defaults");
			}
			
			if (flag) {
				
				 Keyword.ReportStep_Pass(testCase, "Device Model : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MODEL).build()));
				 Keyword.ReportStep_Pass(testCase, "Device MAC ID : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()));
				 Keyword.ReportStep_Pass(testCase, "Device Collection Version : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.COLLECTION_VERSION).build()));
				 Keyword.ReportStep_Pass(testCase, "Thermostat Version : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.THERMOSTAT_VERSION).build()));
				 Keyword.ReportStep_Pass(testCase, "Thermostat Boot Version : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.THERMOSTAT_BOOT_VERSION).build()));
				 Keyword.ReportStep_Pass(testCase, "Wifi Version : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_VERSION).build()));
				 Keyword.ReportStep_Pass(testCase, "Wifi Boot Version : " +
						 StatCommands.getInstance().cattCommandsStub.getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.WIFI_BOOT_VERSION).build()));
			}

			appActive.requestStop();

			Thread.sleep(100);

			if (appActive.isAlive())
				appActive.requestStop();

		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Stat Reset post-condition failed.");
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}

		return flag;
	}
}
