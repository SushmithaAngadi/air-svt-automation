package com.resideo.keywords.networkSimulator;

import java.util.ArrayList;
import com.resideo.commons.coreframework.AfterKeyword;
import com.resideo.commons.coreframework.BeforeKeyword;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.KeywordStep;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.system.utils.CommonState;
import com.resideo.system.utils.MultiThreadRunning;
import com.resideo.system.utils.MultiThreadRunning.ThreadInitializeOnCondition;
import com.resideo.utils.networksimulator.EchoClient;
import com.resideo.utils.resideo_app.screen.PrimaryCardScreen;

import io.cucumber.java.en.Given;

public class DHCPServerRun extends Keyword {

	private TestCases testCase;
	private TestCaseInputs inputs;
//	KeepAppActive appActive;
	public boolean flag = true;
	String deviceName = "Tstat A122C9";
	EchoClient client;
	PrimaryCardScreen pm;
//	ArrayList<String> exampleData;
	String IPaddress;
	int totalTrails;

	public DHCPServerRun(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
		this.inputs = inputs;
		this.testCase = testCase;
//		this.exampleData = exampleData;
	}

	@Override
	@BeforeKeyword
	public boolean preCondition() {
//		CommonState.getStatus().initforNetwork();
//		IPaddress = exampleData.get(0);
//		totalTrails = Integer.valueOf(exampleData.get(1));
//		pm = new PrimaryCardScreen(testCase);
//		DashboardScreen dash = new DashboardScreen(testCase);
//		client = new EchoClient(IPaddress, null, null, null, null);
//		if (dash.isDashboardScreen()) {
//			flag = dash.clickOndevice(deviceName);
//			if (PrimaryCardUtils.isPrimaryCardVisible(testCase, pm)) {
//				flag = true;
//			} else {
//				flag = false;
//			}
//		}

		return flag;
	}

	@Given(value = "Check Long Run DHCP Server")
	@Override
	@KeywordStep(gherkins = "^Check Long Run DHCP Server$")
	public boolean keywordSteps() {
		Keyword.ReportStep_Pass(testCase, "<b> Check Long Run DHCP Server </b>");
		if (testCase.isTestSuccessful()) {

			try {
				MultiThreadRunning mlThread = new MultiThreadRunning(testCase);
				ThreadInitializeOnCondition threadInitializeOnCondition = mlThread.new ThreadInitializeOnCondition();
				CommonState.getStatus().threadInitializationCondition(threadInitializeOnCondition);
				Thread threadInitializationCondition = new Thread(threadInitializeOnCondition);
				threadInitializationCondition.start();
				CommonState.getStatus().isMobileDriverNeedtoWait(true);

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
		return flag;
	}

}
