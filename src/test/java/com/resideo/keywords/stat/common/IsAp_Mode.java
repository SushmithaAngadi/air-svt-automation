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
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.Boolean_Msg;
import com.resideo.utils.stat.cattgrpccommands.String_Msg;
import io.cucumber.java.en.Given;

public class IsAp_Mode extends Keyword {

    private TestCases testCase;
    public boolean flag = true;
    ArrayList<String> keywordData;

    public IsAp_Mode(TestCases testCase, TestCaseInputs inputs, ArrayList<String> data) {
        this.testCase = testCase;
        this.keywordData = data;
    }

    @Override
    @BeforeKeyword
    public boolean preCondition() throws KeywordException {
        return true;
    }

    @Given(value = "^Verify is AP mode is (.+)$")
    @Override
    @KeywordStep(gherkins = "^Verify is AP mode is (.+)$")
    public boolean keywordSteps() throws KeywordException {

        boolean isAP = Boolean.parseBoolean(keywordData.get(0));
        try {

            if (isAP) {

                FluentWait<Boolean> fwait1 = new FluentWait<Boolean>(false);
                fwait1.pollingEvery(Duration.ofSeconds(5));
                fwait1.withTimeout(Duration.ofMinutes(30));
                boolean isEventReceived1 = fwait1.until(new Function<Boolean, Boolean>() {
                    public Boolean apply(Boolean input) {
                        Boolean_Msg APMode = StatCommands.getInstance().cattCommandsStub
                                .getAPModeState(String_Msg.newBuilder().build());
                        if (APMode.getBoolVal()) {
                            Keyword.ReportStep_Pass(testCase, "AP Mode On successfully.");
                            System.out.println("AP Mode Pass");
                            return true;
                        } else {
                            System.out.println("AP Mode is ON Failed");
                            Keyword.ReportStep_Pass(testCase, "APMode state is false, Retrying to set AP Mode");
                            return false;
                        }
                    }
                });
                if (isEventReceived1) {
                    Keyword.ReportStep_Pass(testCase, "AP mode set successfull.");
                    flag = true;
                } else {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed set AP mode");
                }

            } else {

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
        return flag;
    }
}