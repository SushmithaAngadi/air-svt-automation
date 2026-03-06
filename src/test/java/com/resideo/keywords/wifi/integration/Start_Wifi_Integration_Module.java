package com.resideo.keywords.wifi.integration;

import java.util.ArrayList;

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
import com.resideo.utils.ipcontroller.IpControllerUtils;
import io.cucumber.java.en.Given;

/*
 * @link
 * @notes : Relay table need to seperate from this class
 * #Valid : Change format string to json
 * @Event : Change Router time as per page load, use retry flow for reducing time consume.
 * 
 */

public class Start_Wifi_Integration_Module extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;

	public Start_Wifi_Integration_Module(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {

		return flag;
	}

//	start wifi intigeration with switch and turn "on netgear" router and the model is ""

	@Given(value = "^start wifi intigeration with switch and turn on (.+) router and the model is (.+)$")
	@Override
	@KeywordStep(gherkins = "^start wifi intigeration with switch and turn on (.+) router and the model is (.+)$")
	public boolean keywordSteps() throws KeywordException {
//		String routerBrand = exampleData.get(0).toUpperCase();
//		String routerModel = exampleData.get(1).toUpperCase();
		String routerBrand = exampleData.get(0);
		String routerModel = exampleData.get(1);

		if (testCase.isTestSuccessful()) {
			try {
				String routerModelName = SuiteConstants.getConstantValue(SuiteConstantTypes.ROUTER_IOP_AUTOMATION, "ROUTER_NAME");
				if (!routerModelName.isEmpty() && routerModel.contains(routerModelName)) {
					flag = true;
					ReportStep_Pass(testCase, "Already router brand " + routerBrand + " and router model is "
							+ routerModel + " is connected with system");
				} else {
					flag = IpControllerUtils._Controller_IP_Monitor(testCase, routerBrand, routerModel);
				}
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"router brnad " + routerBrand + " , router model is " + routerModel + " ,failed");
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
//		try {
////			Thread.sleep(90000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return flag;
	}
}
