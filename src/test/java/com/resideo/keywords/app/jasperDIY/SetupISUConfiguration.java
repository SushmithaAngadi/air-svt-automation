package com.resideo.keywords.app.jasperDIY;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.resideo_app.screen.DIYScreen;

import io.cucumber.java.en.Given;

public class SetupISUConfiguration extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String ISUType = "";
	String ISUValue = "";
	DIYScreen diy;

	public SetupISUConfiguration(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		if (testCase.isTestSuccessful()) {

			try {
				diy = new DIYScreen(testCase);
//				String ISUType = exampleData.get(0);
				ISUType = exampleData.get(0);
				ISUValue = exampleData.get(1);
				Keyword.ReportStep_Pass(testCase,
						"<b>Executing Pre-Condition Will check this ISU Type ::::" + ISUType + " </b>");
				if (ISUType.contains("BACKUP HEAT CYCLE PER HOUR")) {
					if (!testCase.getPlatform().toUpperCase().contains("IOS")) {
						flag = flag && DIYUtils.isISUPerformScreen(testCase, diy, ISUType);
					}
				} else {
					flag = flag && DIYUtils.isISUPerformScreen(testCase, diy, ISUType);
				}

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception raised : " + e.getMessage());
			}

		} else {
			flag = false;
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Scenario steps failed already, hence skipping the verification");
		}
		return flag;

	}

	@Given(value = "^Set ISUType (.+) to ISUValue (.+)$")
	@Override
	@KeywordStep(gherkins = "^Set ISUType (.+) to ISUValue (.+)$")
	public boolean keywordSteps() {
		if (testCase.isTestSuccessful() && flag) {

			String ISUType = exampleData.get(0);
			String ISUValue = exampleData.get(1);
			Keyword.ReportStep_Pass(testCase, "<b>Executing Keyword Steps</b>");
			try {
				if (ISUType.contains("BACKUP HEAT CYCLE PER HOUR")) {
					if (!testCase.getPlatform().toUpperCase().contains("IOS")) {
						flag = flag && DIYUtils.ISUPerformInDif(diy, ISUType, ISUValue);
					} else {
						Keyword.ReportStep_Pass(testCase, "Back up heat is skiping from iOS due to unavailability");
					}
				} else {
					flag = flag && DIYUtils.ISUPerformInDif(diy, ISUType, ISUValue);
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception raised : " + e.getMessage());
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
		System.out.println("Exceution is " + flag);
		if (flag) {
			Keyword.ReportStep_Pass(testCase,
					"ISU configuration is Done, ISU Type is  " + ISUType + "ISU Value is " + ISUValue);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"ISU configuration is Failed, ISU Type is  " + ISUType + "ISU Value is " + ISUValue);
		}

		return flag;
	}
}