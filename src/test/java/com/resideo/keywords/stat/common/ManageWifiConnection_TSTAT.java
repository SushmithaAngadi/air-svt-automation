package com.resideo.keywords.stat.common;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.StatCommonCommandUtils;
import io.cucumber.java.en.Given;

public class ManageWifiConnection_TSTAT extends Keyword {

	private TestCases testCase;
	public boolean flag = true;

	public ManageWifiConnection_TSTAT(TestCases testCase, TestCaseInputs inputs) {
		this.testCase = testCase;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return flag;
	}

	@Given(value = "^User verify the thermostat having Wifi configuration, if not configure WIFI through AAT$")
	@Override
	@KeywordStep(gherkins = "^User verify the thermostat having Wifi configuration, if not configure WIFI through AAT$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				if (StatCommonCommandUtils.isThermostatConnectedWith_Wifi(testCase)) {
					ReportStep_Pass(testCase, "Wifi Already Configured");
					flag = true;
				} else {
					if (StatCommonCommandUtils.connectwithWIfiUsing_AAT(testCase)) {
						ReportStep_Pass(testCase, "Wifi Configured sucessfully");
						flag = true;
					} else {
						flag = false;
						ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
								"Not able to configure Wifi, please check wifi logs for more details");
					}
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to configure Wifi, please check wifi logs for more details..Device GRPC Commands Failed ::" + e.getMessage());
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to configure Wifi, please check wifi logs for more details");
			SystemState.getStatus().setStatDeletedFromApp(false);
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}

}
