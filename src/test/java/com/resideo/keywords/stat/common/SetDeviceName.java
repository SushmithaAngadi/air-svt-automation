package com.resideo.keywords.stat.common;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.DIYUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.Stat_SetRoomName;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import io.cucumber.java.en.Given;

public class SetDeviceName extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	ArrayList<String> keywordData;
	String statName;

	public SetDeviceName(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.keywordData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return true;
	}

	@Given(value = "^user set room name as (.+)$")
	@Override
	@KeywordStep(gherkins = "^user set room name as (.+)$")
	public boolean keywordSteps() throws KeywordException {

		statName = keywordData.get(0).toUpperCase();
		try {
			if (statName.contains("DEFAULT")) {
				statName = DIYUtils.get_T9_T10_T10Plus_ThermostatNameForRoom(testCase);
			} else {
				statName = keywordData.get(0).trim();
			}
			String oldRoomName = StatCommands.getInstance().cattCommandsStub
					.getRoomName(String_Msg.newBuilder().setStrVal("0").build()).getRoomName().trim();
			if (StatCommands.getInstance().cattCommandsStub
					.setRoomName(Stat_SetRoomName.newBuilder().setRoomID(0).setRoomName(statName).build())
					.getBoolVal()) {
				String roomName = StatCommands.getInstance().cattCommandsStub
						.getRoomName(String_Msg.newBuilder().setStrVal("0").build()).getRoomName().trim();
				if (roomName.trim().equals(statName)) {
					Keyword.ReportStep_Pass(testCase,
							"Passed : Room name is changed from " + oldRoomName + " to " + roomName);
					flag = true;
				} else {
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "old room name is " + oldRoomName
							+ " , expected room name is " + statName + " . After changes room name is " + roomName);
					flag = false;
				}
			}else {
				ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to change room name");
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to set Stat Name");
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		if (statName == null || statName.isEmpty()) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Mac ID is empty or Null, Actual Mac ID is " + statName);
			flag = false;
		}
		return flag;
	}
}