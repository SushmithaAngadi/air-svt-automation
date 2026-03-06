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
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.WifiCfgStatusModeMsg;

import io.cucumber.java.en.Then;

public class SetAPMode extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public SetAPMode(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Then(value = "^Setting AP mode on$")
	@Override
	@KeywordStep(gherkins = "^Setting AP mode on$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			KeepAppActive appActive = new KeepAppActive(testCase);

			appActive.start();
			boolean eventRec = false;
			try {
				FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
				fwait1.pollingEvery(Duration.ofSeconds(5));
				fwait1.withTimeout(Duration.ofMinutes(1));
				boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean input) {
						WifiCfgStatusModeMsg WifiStatus = StatCommands.getInstance().cattCommandsStub
								.getWiFiStatus(String_Msg.newBuilder().build());
						String Status = WifiStatus.toString();
						try {
							StatCommands.getInstance().cattCommandsStub
									.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(true).build());
							Thread.sleep(30000);
							Boolean_Msg APMode = StatCommands.getInstance().cattCommandsStub
									.getAPModeState(String_Msg.newBuilder().build());
							if (APMode.getBoolVal()) {
								Keyword.ReportStep_Pass(testCase, "AP Mode set successfully.");
								System.out.println("WiFi State 1: " + Status);
								return true;
							} else {
								System.out.println("WiFi State 2: " + Status);
								Keyword.ReportStep_Pass(testCase, "APMode state is false, Retrying to set AP Mode");
								return false;
							}

						} catch (Exception e) {
							try {
								System.out.println("WiFi State 3: " + Status);
								Keyword.ReportStep_Pass(testCase,
										"Failed to set AP mode to ON. Exception raised : " + e.getMessage());
								Keyword.ReportStep_Pass(testCase, "Retrying to set AP mode after waiting 40 Sec");
								Thread.sleep(40000);
								StatCommands.getInstance().cattCommandsStub
										.setAPModeState(Boolean_Msg.newBuilder().setBoolVal(true).build());
//								FCDeviceUtils.getInstance().Set_APModeState(true);
								Thread.sleep(30000);
								Boolean_Msg APMode = StatCommands.getInstance().cattCommandsStub
										.getAPModeState(String_Msg.newBuilder().build());
								if (APMode.getBoolVal()) {
									Keyword.ReportStep_Pass(testCase, "AP Mode set successfully.");
									System.out.println("WiFi State 4: " + Status);
									return true;
								} else {
									Keyword.ReportStep_Pass(testCase, "Failed to set AP mode to ON. Retrying...");
									System.out.println("WiFi State 5: " + Status);
									return false;
								}

							} catch (Exception e1) {
								Keyword.ReportStep_Pass(testCase,
										"Failed to set AP mode to ON. Exception raised : " + e1.getMessage());
								Keyword.ReportStep_Pass(testCase, "Retrying...");
								System.out.println("WiFi State : 6" + Status);
								return false;
							}

						}
					}

				});
				if (isEventReceived1) {
					Keyword.ReportStep_Pass(testCase, "AP mode set successfull.");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed set AP mode");
				}

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

			if (appActive.isAlive())
				appActive.requestStop();
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
