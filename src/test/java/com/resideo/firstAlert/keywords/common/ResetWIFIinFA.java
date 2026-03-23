package com.honeywell.keywords.firstAlertapp.common;

import java.util.ArrayList;

import com.honeywell.commons.coreframework.AfterKeyword;
import com.honeywell.commons.coreframework.BeforeKeyword;
import com.honeywell.commons.coreframework.Keyword;
import com.honeywell.commons.coreframework.KeywordException;
import com.honeywell.commons.coreframework.KeywordStep;
import com.honeywell.commons.coreframework.SuiteConstants;
import com.honeywell.commons.coreframework.TestCaseInputs;
import com.honeywell.commons.coreframework.TestCases;
import com.honeywell.commons.report.FailType;
import com.honeywell.utils.firstAlertapp.FAPrimaryCardUtils;
import com.honeywell.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.honeywell.utils.firstAlertapp.NavigateToAnyScreeninFA;
import com.honeywell.utils.firstAlertapp.screen.FAPrimaryCardScreen;

import cucumber.api.java.en.Given;

public class ResetWIFIinFA extends Keyword {

    private TestCases testCase;
    ArrayList<String> exampleData;
    public boolean flag = true;
    String wifiConnected_Status;
    boolean isInvalidPIN = false;
    private TestCaseInputs inputs;
    Integer setValue = -1;
    FAPrimaryCardScreen pm;
    boolean otherNetwork = false;
    Boolean unsecured = false;
    String gigaHertz = "Default";

    public ResetWIFIinFA(TestCases testcase, TestCaseInputs inputs, ArrayList<String> exampleData) {
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
                    Keyword.ReportStep_Pass(testCase, "Navigated to Reset Wifi Screen");
                    System.out.println("Navigated to Reset Wifi Screen");
                } else {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Unable to Navigate to Reset Wifi Screen.");

                }
                if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim()
                        .toUpperCase().contains("DENALI")) {
                    flag = FAPrimaryCardUtils.performInitialInstallationStepsForDenali(testCase, "BLE", false, false,
                            setValue);
                } else if (SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST")
                        .trim().toUpperCase().contains("FUJI")) {
                    flag = FAPrimaryCardUtils.performIntialInstallationStepsForFuji(testCase);
                    if (pm.isOneMoreStepScreenAvailable(10)) {
                        flag = flag && pm.clickOnNextButton();
                    }
                }

                boolean isFactoryReset = false;
                boolean iswifiNeedconfigured = exampleData.get(0).toUpperCase().contains("ALWAYS") ? true : false;
                try {
                    if (exampleData.get(1).toUpperCase().contains("INCORRECT")) {
                        isInvalidPIN = true;
                        setValue = Integer
                                .parseInt(exampleData.get(1).replaceAll("\\D+", " ").trim().replaceAll(" +", " "));
                    }
                } catch (Exception e) {

                    setValue = 0;
                }
                if (exampleData.get(1).toUpperCase().contains("OTHERNETWORK")) {
                    otherNetwork = true;
                } else if (exampleData.get(1).toUpperCase().contains("UNSECURED")) {
                    unsecured = true;
                } else if (exampleData.get(1).toUpperCase().contains("2.5GHZ")) {
                    gigaHertz = "2.5GHZ";
                } else if (exampleData.get(1).toUpperCase().contains("5GHZ")) {
                    gigaHertz = "5GHZ";
                }
                if (exampleData.get(2).toUpperCase().contains("YES")
                        || exampleData.get(1).toUpperCase().contains("TRUE")) {
                    isFactoryReset = true;
                } else if (exampleData.get(2).toUpperCase().contains("NO")
                        || exampleData.get(2).toUpperCase().contains("FALSE")) {
                    isFactoryReset = false;
                }
                wifiConnected_Status = FAPrimaryCardUtils._Do_Action_ThermostatConnectedWithExpectedNetwork(testCase,
                        iswifiNeedconfigured, isFactoryReset);
                if (wifiConnected_Status.equals("change") || wifiConnected_Status.equals("not configured")) {
                    flag = true;
                } else if (wifiConnected_Status.contains("should not connect with wifi") && isFactoryReset) {
                    Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
                            "failed due to wifi already configured, app should show the wifi scan list for factory device");
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            flag = false;
            Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FALSE_POSITIVE, "Skipping pre condtion"
                    + this.getClass().getName() + " execution, since previous Scenario/Keyword steps failed.");
        }
        return flag;
    }

    //Given First Alert app wifi "ALWAYS" configure the wifi with "CORRECT PASSWORD", is device factory reset "NO"
    //Given First Alert app wifi "ALWAYS" configure the wifi with "INCORRECT PASSWORD", is device factory reset "NO"

    @Given(value = "^First Alert app wifi (.+) configure the wifi with (.+), is device factory reset (.+)$")
    @Override
    @KeywordStep(gherkins = "^First Alert app wifi (.+) configure the wifi with (.+), is device factory reset (.+)$")
    public boolean keywordSteps() {
        Keyword.ReportStep_Pass(testCase, "<b> Connect with WI-FI network  </b>");
        if (testCase.isTestSuccessful()) {
            try {
                flag = flag && FAPrimaryCardUtils.chooseNetworktoConnectYourThermostat(testCase, isInvalidPIN, setValue,
                        otherNetwork, unsecured, gigaHertz);
                flag = flag && FAPrimaryCardUtils.confirmWifiConfigurationIsCompleted(testCase);
            } catch (Exception e) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able connect with wifi, Exception occured, Exception is :" + e.getMessage());
                flag = false;

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

        return flag;
    }

}