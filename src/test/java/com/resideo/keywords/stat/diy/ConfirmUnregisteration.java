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
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.KeepAppActive;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.AlertMsg;
import com.resideo.utils.stat.cattgrpccommands.AlertMsg.AlertState;
import com.resideo.utils.stat.cattgrpccommands.AlertMsg.AlertType;

import io.cucumber.java.en.Given;

public class ConfirmUnregisteration extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public ConfirmUnregisteration(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^verify stat is unregistered from cloud$")
	@Override
	@KeywordStep(gherkins = "^verify stat is unregistered from cloud$")
	public boolean keywordSteps() throws KeywordException {
		if (SystemState.getStatus().isDeviceRegistered() && SystemState.getStatus().isStatDeletedFromApp()) {
			KeepAppActive appActive = new KeepAppActive(testCase);
			appActive.start();

			Keyword.ReportStep_Pass(testCase,
					"Checking in stat for Connect App notification to confirm complete unregistration.");
			boolean alertState = false;
			AlertMsg request = AlertMsg.newBuilder().setAlert(AlertType.ALERT_NEED_TO_REGISTER_ONLINE)
					.setState(AlertState.ALERTS_STATE_ACTIVE).build();
			try {

				FluentWait<Boolean> fWait = new FluentWait<Boolean>(alertState);
				fWait.pollingEvery(Duration.ofSeconds(10));
				fWait.withTimeout(Duration.ofMinutes(3));
				boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
					public Boolean apply(Boolean flag1) {
						try {
							if (StatCommands.getInstance().cattCommandsStub.verifyAlert(request).getBoolVal())
								return true;
							else {
								Keyword.ReportStep_Pass(testCase, "Waiting for stat to unregister from cloud.");
								return false;
							}

						} catch (NullPointerException e) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Null Pointer Exception Raised.");
							return false;
						} catch (Exception e) {
							Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
									"Exception Raised : " + e.getMessage());
							return false;
						}
					}
				});
				if (isEventReceived)
					Keyword.ReportStep_Pass(testCase, "Device Unregistered successfully in cloud.");

			} catch (TimeoutException e) {
				flag = false;
				Keyword.ReportStep_Pass(testCase, "Connect App alert is not activated even after 7 mins wait.");
//				AppRegistrationUtils.isStatDeletedFromApp = false;
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception Raised : " + e.getMessage());
//				AppRegistrationUtils.isStatDeletedFromApp = false;
			}

			if (appActive.isAlive())
				appActive.requestStop();
		} else {
			Keyword.ReportStep_Pass(testCase,
					"Device is not deleted from app or device is not registered. Hence skipping the verification...");
			SystemState.getStatus().setStatDeletedFromApp(false);
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		try {
			String devicename = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
			if (SystemState.getStatus().isRegError()) {
//			if(SystemState.getStatus().first_regFailure()&& SystemState.getStatus().Reg_failureCount()==1) {
				StatCommonCommandUtils.ThreadLock(testCase, Duration.ofMinutes(5));
				Keyword.ReportStep_Pass(testCase, "Waiting time 5 mins for GDR Issue , Registrstion error");
			}
//			if (SystemState.getStatus().isThermostatCloudSynError()) {
////				if(SystemState.getStatus().first_regFailure()&& SystemState.getStatus().Reg_failureCount()==1) {
//					StatCommonCommandUtils.ThreadLock(testCase, Duration.ofMinutes(5));
//					Keyword.ReportStep_Pass(testCase, "Waiting time 5 mins for GDR Issue , Registrstion error");
//				}
			ReportStep_Pass(testCase, "Is Test is Passed or not " + flag);
			if((devicename.contains("FLYCATCHER")||devicename.contains("THOR"))&&!SystemState.getStatus().isStatRegistrationStatus()) {
				StatCommonCommandUtils.ThreadLock(testCase, Duration.ofSeconds(30));
				Keyword.ReportStep_Pass(testCase, "Waiting for registration status to delete");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception Raised : " + e.getMessage());
			}
//			
			return flag;
		}

	}
