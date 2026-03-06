package com.resideo.keywords.stat.diy;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.StatCommonCommandUtils;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;

import io.cucumber.java.en.Given;

public class BroadCast_T5_T6_NA_EMEA_ContinuousTimePeriod extends Keyword {

	private TestCases testCase;
	ArrayList<String> keywordData;
	public boolean flag = false;

	public BroadCast_T5_T6_NA_EMEA_ContinuousTimePeriod(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.keywordData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		
		if(StatCommands.getInstance().cattCommandsStub.jasperSetHomeScr(String_Msg.newBuilder().setStrVal("").build()).toString().contains("true")) {
			ReportStep_Pass(testCase, "Change any Screen to Thermostat Home Screen");
			flag = true;
		}else {
			String initialname = StatCommands.getInstance().cattCommandsStub
					.jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
							.setTextMethod(DisplayMethod.AlphabeticalUpperAndSpecialChars).build())
					.getStrVal();
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Absorbed text From Thermostat Screen, Messages from screen ::"+initialname.toString() );
			flag = false;
		}
		
		return flag;
	}

	@Given(value = "^User need to perform AP mode in the interval of (.+) minutes with (.+) consequence$")
	@Override
	@KeywordStep(gherkins = "^User need to perform AP mode in the interval of (.+) minutes with (.+) consequence$")
	public boolean keywordSteps() throws KeywordException {
		if (flag) {
			int interval = Integer.valueOf(keywordData.get(0));
			int repeat =  Integer.valueOf(keywordData.get(1));
			try {
				Keyword.ReportStep_Pass(testCase, "<b> Executing keyword steps </b>");
				
				flag = flag && StatCommonCommandUtils.performAPModeScenario(testCase, interval, repeat);

			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
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
		if(flag && StatCommands.getInstance().cattCommandsStub.jasperSetHomeScr(String_Msg.newBuilder().setStrVal("").build()).toString().contains("true")) {
			ReportStep_Pass(testCase, "AP Mode Simulation End, Trail was Sucessfully passed, More Details Check in Stat and Wifi Logs");
			flag = true;
		}
		else {
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to navigate to Thermostat Home Screen");
			flag= false;
		}
		return flag;
	}
}
