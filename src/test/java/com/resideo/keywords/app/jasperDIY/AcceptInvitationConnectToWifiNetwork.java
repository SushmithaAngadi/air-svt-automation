package com.resideo.keywords.app.jasperDIY;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

//User Accept Invitation (.+) Then Connect To Thermostat Wifi Network
public class AcceptInvitationConnectToWifiNetwork  extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	DIYScreen diy;
	public boolean flag = true;

	public AcceptInvitationConnectToWifiNetwork(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			
			diy = new DIYScreen(testCase);
			
			if(!SystemState.getStatus().isInvitationIsVisibleDuringLogin()) {
				flag = diy.clickOnAddNewDeviceFromDashboard();
				if(diy.isInvitationFromResideoPro(10)) {
					flag = diy.clickOnAcceptResideoProInvitation();
					if(testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						flag = diy.isTheThermostatOnWall();
						}else {
//							need to implement for IOS
							//flag = diy.netw
						}
				}else if(diy.clickOnBackButton()) {
//					flag = diy.clickOnBackButton();
					flag = diy.clickOnAddNewDeviceFromDashboard();
					if(diy.isInvitationFromResideoPro(10)) {
						flag = diy.clickOnAcceptResideoProInvitation();
						if(testCase.getPlatform().toUpperCase().contains("ANDROID")) {
							flag = diy.isTheThermostatOnWall();
							}else {
//								need to implement for IOS
								//flag = diy.netw
							}
					}
			
				}else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Invitation is not visible for select");
					flag = false;
				}
				
			}
			
			
//			if(testCase.getPlatform().toUpperCase().contains("ANDROID")) {
//			}else {
//			}
		
			
			
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "^User Accept Invitation then Connect To Thermostat Wifi Network$")
	@Override
	@KeywordStep(gherkins = "^User Accept Invitation then Connect To Thermostat Wifi Network$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			try {
					flag = DIYUtils.performInstallationFromInstallerInvitation(testCase, diy);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		System.out.println("Exceution is " + flag);

		return flag;
	}



}
