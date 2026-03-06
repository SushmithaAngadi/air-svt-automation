package com.resideo.keywords.stat.common;

import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordException;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.utils.aat.AATManager;
import com.resideo.utils.aat.AatCommandHandler;
import com.resideo.utils.aat.ThermostatController;
import com.resideo.utils.aat.ThermostatConstant.ResetType;
import com.resideo.utils.stat.FujiUtils;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg;
import com.resideo.utils.stat.cattgrpccommands.ButtonMsg.Fuji_Buttons;
import com.resideo.utils.stat.mqtt.MqttManager;

import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.Given;

public class RunAATCommand extends Keyword {

	private TestCases testCase;
	public boolean flag = true;
	ArrayList<String> keywordData;

	public RunAATCommand(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
		this.testCase = testCase;
		this.keywordData = data;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() throws KeywordException {
		return true;
	}

	/** 
	 * And user runs "AAT" command "factory reset without WIFI"
	 * Given user runs "MQTT" command "factory reset without WIFI"
	 * Then user runs "AAT" command "DEFAULT NVM RESET"
	 * Then user runs "AAT" command "PRESERVE NVM RESET"
	 * Then user runs "AAT" command "FACTORY RESET"
	 **/
	
	@Given(value = "^user runs (.+) command (.+)$")
	@Override
	@KeywordStep(gherkins = "^user runs (.+) command (.+)$")
	public boolean keywordSteps() throws KeywordException {
		if (testCase.isTestSuccessful()) {
			try {
				String aatOrMqtt = keywordData.get(0).toUpperCase();
				String command = keywordData.get(1).toUpperCase();
				String device = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC,
						"DEVICE_UNDER_TEST");
				if (aatOrMqtt.contains("AAT")) {
					if (device.toUpperCase().contains("GLENEAGLES")) {
						ThermostatController controller = new ThermostatController(AATManager.getHandler());
						flag = controller.setReset(testCase, ResetType.fromText(command), 120000);
					} else {
						flag = FujiUtils.runPerticularAATCommand(command);
						if ((command.contains("FACTORY RESET") && command.contains("WITHOUT WIFI"))) {
							for (int i = 0; i < 13; i++) {
								flag = flag
										&& StatCommands.getInstance().cattCommandsStub
												.setButtonsClick(ButtonMsg.newBuilder()
														.addFjButton(Fuji_Buttons.BUTTON_LEFT_BOTTOM).build())
												.getBoolVal();
								TimeUnit.SECONDS.sleep(1);
							}
							flag = flag && StatCommands.getInstance().cattCommandsStub
									.setButtonsClick(
											ButtonMsg.newBuilder().addFjButton(Fuji_Buttons.BUTTON_LEFT_TOP).build())
									.getBoolVal();
						}
					}
				} else if (aatOrMqtt.contains("MQTT")) {
					if ((command.contains("FACTORY RESET"))) {
						if (command.contains("WITHOUT WIFI")) {
							flag = MqttManager.setReset(testCase, "DefaultReset", "true");
						} else if (command.contains("WITH WIFI")) {
							flag = MqttManager.setReset(testCase, "FactoryReset", "true");
						}
					} else if ((command.contains("SCHEDULE"))) {
						flag = MqttManager.setReset(testCase, "ScheduleReset", "true");
					}
				}
			} catch (Exception e) {
				flag = false;
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to Run the Stat Command : " + keywordData.get(0).toUpperCase());
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
			}
		}
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		return flag;
	}
}