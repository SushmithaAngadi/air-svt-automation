package com.resideo.keywords.app.homeKit;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.HomeKitUtils;

import io.cucumber.java.en.Given;

public class SystemModeChangeAndVerification extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;

	public boolean flag = true;

	public SystemModeChangeAndVerification(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
			flag = HomeKitUtils.navigateToHomeKitPrimaryCard(testCase);
		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
					+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
		}
		return flag;
	}

	@Given(value = "User set System mode to (.+) from (.+) ,Verify from (.+)")
	@Override
	@KeywordStep(gherkins = "^User set System mode to (.+) from (.+) ,Verify from (.+)$")
	public boolean keywordSteps() {
		String mode = exampleData.get(0);
		String Changesplatform = exampleData.get(1);
		String VerificationPlatform = exampleData.get(2);
		if (testCase.isTestSuccessful()) {

			if (Changesplatform.toUpperCase().contains("STAT".toUpperCase())) {
				flag = HomeKitUtils.changeSystemModeFromStatVerifyFromHomeKit(testCase, mode);

			} else {
				flag = HomeKitUtils.changeSystemModeFromHomeKitVerifyFromStat(testCase, mode);
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

		return flag;

	}

}
