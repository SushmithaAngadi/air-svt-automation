package com.resideo.keywords.stat.isu;

import java.util.ArrayList;
import java.util.List;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.FlycatcherUtils;
import com.resideo.utils.stat.JasperUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.ThorUtils;

import io.cucumber.java.en.Given;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.EnumValueDescriptor;

public class SetIsu extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	String deviceName;

	public SetIsu(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		try {
			deviceName = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
					.trim().toUpperCase();
		} catch (Exception e) {

		}
		return flag;
	}

	@Given(value = "^user configures isu (.+) with value (.+)$")
	@Override
	@KeywordStep(gherkins = "^user configures isu (.+) with value (.+)$")
	public boolean keywordSteps() throws KeywordException {
		try {
			if (testCase.isTestSuccessful()) {
				String isuType = exampleData.get(0).trim();
				String isuVal = exampleData.get(1).trim();

				if (exampleData.get(0) != "" || exampleData.get(0) != " " || exampleData.get(1) != ""
						|| exampleData.get(1) != " ") {

					if (deviceName.contains("JASPER_SENIOR")) {
						flag = JasperUtils.setISU(testCase, isuType, isuVal);
					} else if (deviceName.contains("FLYCATCHER")) {
						flag = FlycatcherUtils.setISU(testCase, isuType, isuVal);
					} else if (deviceName.contains("THOR")) {
						flag = ThorUtils.setISU(testCase, isuType, isuVal);
					}

				} else {
					flag = false;
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE,
							"Keyword test data is empty");
				}
			} else {
				flag = false;
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
						+ this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
			}
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FRAMEWORK_CONFIGURATION, "Exception occured in, Due to " + e);
			flag = false;
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}
