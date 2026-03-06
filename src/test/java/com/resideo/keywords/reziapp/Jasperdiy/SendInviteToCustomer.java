package com.resideo.keywords.reziapp.Jasperdiy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.resideoPro_app.CustomerUtils;
import com.resideo.utils.resideoPro_app.screen.CustomerInfoScreen;

import io.cucumber.java.en.Given;

public class SendInviteToCustomer extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	public boolean flag = true;
	ArrayList<String> exampleData;
//	CustomerInfoScreen cuscreen;
	String userName;

	public SendInviteToCustomer(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
		this.inputs = inputs;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		try {
			String mailID = exampleData.get(0);
			if(mailID.toUpperCase().contains("DEFAULT")) {
				userName = inputs.getInputValue("USERID").toString();
			}else {
				userName = mailID;
			}
			
			if (testCase.isTestSuccessful()) {
				Keyword.ReportStep_Pass(testCase,
						"<b>Start Executing Pre Condition for Check the Existing customer "+userName+" , and Send Invite to the Customer </b>");
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
					"Exception Occured due to " + e.getMessage());
		} finally {
		}

		return flag;
	}

	@Given(value = "^Check the Existing customer (.+) , and Send Invite to the Customer$")
	@Override
	@KeywordStep(gherkins = "^Check the Existing customer (.+) , and Send Invite to the Customer$")
	public boolean keywordSteps() {

		if (testCase.isTestSuccessful()) {
			Keyword.ReportStep_Pass(testCase,
					"<b> Start Executing Check the Existing customer "+userName+" , and Send Invite to the Customer </b>");
			try {
				if (SystemState.getStatus().ble_Ap_flow().contains("AP")) {
					flag = CustomerUtils.CheckthePopup_sendInvite(testCase);
				}
//				flag = flag && CustomerUtils.sendInvitationToExistingCustomer(testCase, new CustomerInfoScreen(testCase),userName);
				flag = flag && CustomerUtils.sendInviteToTheCustomer(testCase, new CustomerInfoScreen(testCase),userName);
				SystemState.getStatus().isInvitationSentToCustomer(flag);
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