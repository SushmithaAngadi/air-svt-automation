package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.firstAlertapp.screen.FAPrimaryCardScreen;
import cucumber.api.java.en.Then;


public class VerifyBluetoothExpiryTimeout extends Keyword {

    private TestCases testCase;
    ArrayList<String> exampleData;
    public boolean flag = false;
    private TestCaseInputs inputs;
    Integer setValue = -1;

    public VerifyBluetoothExpiryTimeout(TestCases testcase, TestCaseInputs inputs, ArrayList<String> exampleData) {
        this.testCase = testcase;
        this.inputs = inputs;
        this.exampleData = exampleData;
    }
    @Override
    @BeforeKeyword
    public boolean preCondition() {
        Keyword.ReportStep_Pass(testCase, "<b>Start Executing Pre Condition for Connect with WI-FI network  </b>");
        if (testCase.isTestSuccessful()) {
            try {
                if (NavigateToAnyScreeninFA.NavigateAndVerify_IsExpectedScreen(testCase, inputs, "RESET WI-FI")) {
                    Keyword.ReportStep_Pass(testCase, "Navigating to Reset Wifi Screen");
                    System.out.println("Navigating to Reset Wifi Screen");
                    flag = true;
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Unable to Navigate to Reset Wifi Screen.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
                    + this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
        }
        return flag;
    }
    //Verify the bluetooth expiry Timeout of Denali device
    @Then(value = "^Verify the bluetooth expiry Timeout of Denali device$")
    @Override
    @KeywordStep(gherkins = "^Verify the bluetooth expiry Timeout of Denali  device$")
    public boolean keywordSteps() {
        Keyword.ReportStep_Pass(testCase, "<b> Connect with WI-FI network  </b>");
        if (testCase.isTestSuccessful())
        {
            flag = FAPrimaryCardUtils.perFormInstallationWithSecurityPINTimeout(testCase, "BLE", false, false,
                    setValue);

        } else {
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping "
                    + this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
        }

        return flag;
    }

    @Override
    @AfterKeyword
    public boolean postCondition() {

        return flag;
    }


}