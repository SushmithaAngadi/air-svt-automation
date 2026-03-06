package com.resideo.keywords.app.caspianDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.CaspianUtils;
import com.resideo.utils.resideo_app.LyricUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;
import com.resideo.utils.stat.KeepAppActive;

import io.cucumber.java.en.Given;

@SuppressWarnings("unused")
public class ConfirmDataSynInCaspianWithUserTimeInput extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	KeepAppActive appActive;

	public ConfirmDataSynInCaspianWithUserTimeInput(TestCases testCase, TestCaseInputs inputs,
			ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {
		flag = flag && LyricUtils.closeAppLaunchPopups(testCase);
		DIYScreen diy = new DIYScreen(testCase);
		if (diy.isUnknownPopUP()) {
			flag = diy.clickOnUnknownPopUP("Dashboard");
		}
		}else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;

	}

	// *[@text='Basement']/following-sibling::android.widget.TextView
	@Given(value = "User wait for data sync upto (.+) mins")
	@Override
	@KeywordStep(gherkins = "^User wait for data sync upto (.+) mins$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String timeOut = exampleData.get(0);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				flag = flag && CaspianUtils.dataSyncProcessAndStatus(testCase, Integer.valueOf(timeOut));

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
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
