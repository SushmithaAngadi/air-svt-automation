package com.resideo.keywords.stat.common;

import java.time.Duration;
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
import com.resideo.utils.stat.cattgrpccommands.NavigateTo;
import com.resideo.utils.stat.screens_Gui.SetUpDevice_T9_T10_T0Plus;
import com.resideo.utils.stat.cattgrpccommands.NavigateTo.DisplayNavigation;

import io.cucumber.java.en.Given;

public class VerifyWifiScanList extends Keyword {

    private TestCases testCase;
    public boolean flag = true;
    ArrayList<String> keywordData;

    public VerifyWifiScanList(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
        this.testCase = testCase;
        this.keywordData = data;
    }

    @Override
    @BeforeKeyword
    public boolean preCondition() throws KeywordException {
        return true;
    }

    @Given(value = "^user navigate to (.+) and verify (.+) present or not$")
    @Override
    @KeywordStep(gherkins = "^user navigate to (.+) and verify (.+) present or not$")
    public boolean keywordSteps() throws KeywordException {

        try {
        	StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
					NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build());
			StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
					NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build());
			if (StatCommands.getInstance().cattCommandsStub
					.t10PlusNavigateTo(NavigateTo.newBuilder()
							.setDisplaynavigation(DisplayNavigation.AAT_SCREEN_WIFI_SELECTNETWORK).build())
					.getBoolVal()) {
				if (new SetUpDevice_T9_T10_T0Plus().isWifi_ScanList_Available(testCase,Duration.ofMinutes(5))) {
					Keyword.ReportStep_Pass(testCase, "Device in AP Mode, Further process will proceed");
					flag = true;
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, 0,
							"Device not in AP Mode, wifi scan list is listed");
					flag = false;
				}
			}else {
				ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to navigate to Wifi scan list");
				flag =false;
			}
        } catch (Exception e) {
            flag = false;
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to reset Stat");
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Raised : " + e.getMessage());
        }
        return flag;
    }

    @Override
    @AfterKeyword
    public boolean postCondition() {
    	StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
				NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_IDLE).build());
		StatCommands.getInstance().cattCommandsStub.t10PlusNavigateTo(
				NavigateTo.newBuilder().setDisplaynavigation(DisplayNavigation.AAT_SCREEN_HOME).build());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return flag;
    }
}