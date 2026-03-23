package com.resideo.keywords.networkSimulator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.system.utils.MultiThreadRunning;
import com.resideo.system.utils.MultiThreadRunning.NetworkTraffic;
import com.resideo.system.utils.MultiThreadRunning.ThreadInitializeOnCondition;
import com.resideo.system.utils.SystemPerformanceTest;
import com.resideo.system.utils.CommonState;
import com.resideo.system.utils.CommonUtils;
import com.resideo.utils.networksimulator.EchoClient;
import com.resideo.utils.resideo_app.PrimaryCardUtils;
import com.resideo.utils.resideo_app.screen.DashboardScreen;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;

import io.cucumber.java.en.Given;

public class SetpointModeChangesWithHighTraffic extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
//	KeepAppActive appActive;
	public boolean flag = true;
	String deviceName = "Tstat A122C9";
	EchoClient client;
	PrimaryCardScreen pm;
	ArrayList<String> exampleData;
	String IPaddress;
	int totalTrails;

	public SetpointModeChangesWithHighTraffic(TestCases testCase, TestCaseInputs inputs,
			ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
		CommonState.getStatus().initforNetwork();
		IPaddress = exampleData.get(0);
		totalTrails = Integer.valueOf(exampleData.get(1));
		pm = new PrimaryCardScreen(testCase);
		DashboardScreen dash = new DashboardScreen(testCase);
		client = new EchoClient(IPaddress, null, null, null, null);
		if (dash.isDashboardScreen()) {
			flag = dash.clickOndevice(deviceName);
			if (PrimaryCardUtils.isPrimaryCardVisible(testCase, pm)) {
				flag = true;
			} else {
				flag = false;
			}
		}

		return flag;
	}

	@Given(value = "Set Setpoint and mode changes with or without High Traffic on Random, IP is (.+) and Trail No (.+)")
	@Override
	@KeywordStep(gherkins = "^Set Setpoint and mode changes with or without High Traffic on Random, IP is (.+) and Trail No (.+)$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase,
				"<b> Set Setpoint and mode changes with or without High Traffic on Random  </b>");
		if (testCase.isTestSuccessful()) {

			try {
				MultiThreadRunning mlThread = new MultiThreadRunning(testCase);
				ThreadInitializeOnCondition threadInitializeOnCondition = mlThread.new ThreadInitializeOnCondition();
				CommonState.getStatus().threadInitializationCondition(threadInitializeOnCondition);
				SystemPerformanceTest.alternateRunCommand(testCase, client, 120, "Hi hi hi", 40, 1, TimeUnit.SECONDS);
				Thread threadInitializationCondition = new Thread(threadInitializeOnCondition);
				threadInitializationCondition.start();
				CommonState.getStatus().totaltrailforExecution(totalTrails);
				CommonState.getStatus().isMobileDriverNeedtoWait(true);
				CommonUtils.startExecutionForTraffic(testCase, pm);

			} catch (Exception e) {

			}

		} else {

		}

		return flag;
	}

	@Override
	@AfterKeyword
	public boolean postCondition() {
		CommonState.getStatus().threadInitializeOnCondition().requestStop();
		CommonState.getStatus().schedulerForRunCommand().shutdown();
		while (!CommonState.getStatus().isTrafficCodeRunning() == false) {
			System.out.println("waiting for Traffic APP close");
		}

		return flag;
	}

}
