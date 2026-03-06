package com.resideo.keywords.stat.diy;

import java.time.Duration;
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
import com.resideo.system.utils.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import com.resideo.utils.stat.cattgrpccommands.String_Msg;

public class InitializeMDNS extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public InitializeMDNS(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Then(value = "Initialize Stat MDNS using CATT")
	@Override
	@KeywordStep(gherkins = "^Initialize Stat MDNS using CATT$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			KeepAppActive appActive = new KeepAppActive(testCase);
			appActive.start();

			try {
				StatCommands.getInstance().cattCommandsStub.setMDNSState(Boolean_Msg.newBuilder()
						.setBoolVal(true).build());
				Keyword.ReportStep_Pass(testCase, "DIY Server started...");
				boolean eventRec = false;
				try {
					FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(eventRec);
					fwait1.pollingEvery(Duration.ofSeconds(5));
					fwait1.withTimeout(Duration.ofMinutes(1));
					boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
						public Boolean apply(Boolean input) {
							try {
								Boolean_Msg MDSN = StatCommands.getInstance().cattCommandsStub.getMDNSState(String_Msg.newBuilder().build());
								return MDSN.getBoolVal();
							} catch (Exception e) {
								Keyword.ReportStep_Pass(testCase, "failed to read IPV4 address...");
								return false;
							}
						}

					});
					if (isEventReceived1) {
						Keyword.ReportStep_Pass(testCase, "MDNS Initialized...");
						Thread.sleep(10000);
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
