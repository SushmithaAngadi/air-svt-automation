package com.resideo.keywords.stat.T9_T10_T10Plus;

import java.util.ArrayList;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.relay.AAT_RelayConfiguration;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;
import com.resideo.utils.stat.screens_Gui.GUI_Screen_Utils;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;

import io.cucumber.java.en.Given;

public class Enroll_IAS_OAS_Sensors extends Keyword {

	private TestCases testCase;
	ArrayList<String> exampleData;
	public boolean flag = true;
	int eimCount;
	int oasCount;
	int iasCount;
	SetUpDevice_T9_T10_T0Plus gui;
	boolean isRandomTimeNeed = false;

	public Enroll_IAS_OAS_Sensors(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.exampleData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		try {
			gui = new SetUpDevice_T9_T10_T0Plus();
			oasCount = Integer.valueOf(exampleData.get(0));
			iasCount = Integer.valueOf(exampleData.get(1));

			if (exampleData.get(2).toUpperCase().contains("YES")) {
				isRandomTimeNeed = true;
			}
			if ((SystemState.getStatus().iasCounterTrail() == 0 || SystemState.getStatus().oasCounterTrail() == 0)
					&& (oasCount > 0 || iasCount > 0)) {

				int iasCounterTrail = SystemState.getStatus().iasCounterTrail();
				SystemState.getStatus().iasCounterTrail(iasCounterTrail + 1);

				int oasCounterTrail = SystemState.getStatus().oasCounterTrail();
				SystemState.getStatus().oasCounterTrail(oasCounterTrail + 1);

				flag = AAT_RelayConfiguration.resetIAS_OAS(testCase, oasCount, iasCount);

			} else {
				int iasCounterTrail = SystemState.getStatus().iasCounterTrail();
				SystemState.getStatus().iasCounterTrail(iasCounterTrail + 1);

				int oasCounterTrail = SystemState.getStatus().oasCounterTrail();
				SystemState.getStatus().oasCounterTrail(oasCounterTrail + 1);
			}
		} catch (Exception e) {
			ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
			flag = false;
		}
		return flag;
	}

	@Given(value = "^user enrolls (.+) oas and (.+) ias with eim and thermostat, is random pairing time needed (.+)$")
	@Override
	@KeywordStep(gherkins = "^user enrolls (.+) oas and (.+) ias with eim and thermostat, is random pairing time needed (.+)$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				flag = GUI_Screen_Utils.addEiqupment_SensorsInDIY_DummyEIMPlaceHolder_ForPairing(testCase, gui, 1, oasCount, iasCount,
						isRandomTimeNeed);
			} catch (Exception e) {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception occured due to " + e.getMessage());
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
		try {
			Thread.sleep(10000);
			StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
					NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build());
			Thread.sleep(60000);
		} catch (Exception e) {

		}
		return flag = true;
	}
}
