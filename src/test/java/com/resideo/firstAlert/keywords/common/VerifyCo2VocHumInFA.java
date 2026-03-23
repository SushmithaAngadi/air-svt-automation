package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;
import cucumber.api.java.en.Then;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;


public class VerifyCo2VocHumInFA extends Keyword {

    private TestCases testCase;
    private TestCaseInputs inputs;
    ArrayList<String> exampleData;
    public boolean flag = true;

    public VerifyCo2VocHumInFA(TestCases testCase, TestCaseInputs inputs, ArrayList<String> exampleData) {
        this.inputs = inputs;
        this.testCase = testCase;
        this.exampleData = exampleData;
    }

    @Override
    @BeforeKeyword
    public boolean preCondition() {
        if (testCase.isTestSuccessful()) {
            Keyword.ReportStep_Pass(testCase, "<b>Executing PreCondition</b>");
            try {
                flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "IAQ");
            } catch (Exception e) {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "ModifyFanMode Pre condition failed due to Exception : " + e.getMessage());
            }
        } else {
            flag = false;
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
                    + this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
        }

        return flag;
    }

    /**
     * And user verifies CO2 as "Very Low", VOC as "Very Low", and Humidity as "Ideal" in FA App
     And user verifies CO2 as "Low", VOC as "Low", and Humidity as "Fair" in FA App
     And user verifies CO2 as "Fair", VOC as "Fair", and Humidity as "Dry" in FA App
     And user verifies CO2 as "High", VOC as "High", and Humidity as "Dry" in FA App
     */

    @Then(value = "^user verifies CO2 as (.+), VOC as (.+), and Humidity as (.+) in FA App$")
    @Override
    @KeywordStep(gherkins = "^user verifies CO2 as (.+), VOC as (.+), and Humidity as (.+) in FA App$")
    public boolean keywordSteps() {
        if (testCase.isTestSuccessful()) {
            Keyword.ReportStep_Pass(testCase, "<b>Executing Keywordstep</b>");
            try {
                String expectedCO2 = exampleData.get(0);
                String expectedVOC = exampleData.get(1);
                String expectedHumidity = exampleData.get(2);
                flag = FAPrimaryCardUtils.verifyCo2VocHumValues(testCase, expectedCO2, expectedVOC, expectedHumidity);
            } catch (Exception e) {
                flag = false;
                Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Error Occured : " + e.getMessage());
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
        if (testCase.isTestSuccessful() && flag) {
            ReportStep_Pass(testCase, "Verify co2,voc and Humidity Keyword successfully executed");
            flag = NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "DASHBOARD");
        } else {

            ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Verify co2,voc and Humidity Keyword failed during execution");
        }
        return flag;
    }
}