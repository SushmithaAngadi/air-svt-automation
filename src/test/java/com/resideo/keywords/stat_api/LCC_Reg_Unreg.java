package com.resideo.keywords.stat_api;

import java.time.Duration;
import java.util.ArrayList;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.system.scheduler.SchedulerMain;
import com.resideo.system.utils.LCC_Admin;
import com.resideo.utils.api.dfc.CustomCommands;

import io.cucumber.java.en.Given;

public class LCC_Reg_Unreg extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
	ArrayList<String> exampleData;

	public boolean flag = true;
	String reg_unreg;
	String cloudType;
	String macID = "B82CA0FE0A08";

	public LCC_Reg_Unreg(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		reg_unreg = exampleData.get(0).toUpperCase();
		cloudType = exampleData.get(1).toUpperCase();
		return flag;
	}

	@Given(value = "^(.+) user defined device in (.+)$")
	@Override
	@KeywordStep(gherkins = "^(.+) user defined device in (.+)$")
	public boolean keywordSteps() {
//		, "B82CA0630D88"
//		if (reg_unreg.equals("REGISTER")) {
//			flag = LCC_Admin.doRegisterLCCDeviceInAdminPortal(testCase, inputs, "Jasper", macID);
//		} else if (reg_unreg.equals("UNREGISTER")) {
//			flag = LCC_Admin.doUnRegisterLCCDeviceInAdminPortal(testCase, inputs, "Jasper", macID);
//		}
//		for (int i = 0; i < 2; i++) {
//			SchedulerMain._SchedulerJob(testCase, macID, 2000, 54, 5);
//		}
		
		
		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {

		if (reg_unreg.equals("REGISTER")) {
			CustomCommands.SchedulerHandler(testCase, "MINUTE", 100);
		} else if (reg_unreg.equals("UNREGISTER")) {
			CustomCommands.SchedulerHandler(testCase, "MINUTE", 1);
			LCC_Admin.getdeviceInfo(testCase, inputs, macID);
			CustomCommands.SchedulerHandler(testCase, "MINUTE", 4);
		}

//		if (reg_unreg.equals("REGISTER")) {
//			CustomCommands.timer(testCase, Duration.ofMinutes(3), 2);
//		} else if (reg_unreg.equals("UNREGISTER")) {
//			CustomCommands.timer(testCase, Duration.ofMinutes(2), 1);
//			LCC_Admin.getdeviceInfo(testCase, inputs, macID);
//			CustomCommands.timer(testCase, Duration.ofMinutes(10), 4);
//		}
//		SchedulerMain.timer(testCase, Duration.ofMinutes(80));
		
		return flag;

	}

}