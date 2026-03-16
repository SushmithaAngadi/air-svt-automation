package com.resideo.utils.firstalert_app.screen;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomAndroidDriver;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.system.utils.SystemState;
import com.resideo.utils.stat.StatCommands;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg;
import com.resideo.utils.stat.cattgrpccommands.DeviceInfoMsg.DeviceInfoItem;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayArea;
import com.resideo.utils.stat.cattgrpccommands.JasperDisplayTextMsg.DisplayMethod;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg;
import com.resideo.utils.stat.cattgrpccommands.PairingPinMsg.PairingPinMode;
import com.resideo.utils.stat.mqtt.MqttManager;
import com.resideo.utils.stat.mqtt.MqttSerialController;
import com.resideo.commons.mobile.W3CTouchActions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class FirstAlertDIYScreen extends MobileScreens {
    private static final String screenName = "FirstAlertDIYScreen";

    public FirstAlertDIYScreen(TestCases testCase) {
        super(testCase, screenName);
    }

    public static String getScreenName_FirstAlert(String src) {
        String screenName = null;
        if (src.contains("Sign in".toUpperCase()) && src.contains("Create account".toUpperCase())
                && src.contains("Environment: ".toUpperCase())) {
            screenName = "main screen";
        } else if (src.contains("Email".toUpperCase()) && src.contains("Password".toUpperCase())
                && src.contains("SIGN IN".toUpperCase()) && src.contains("Forgot password".toUpperCase())
                && src.contains("New User? Create an Account".toUpperCase())) {
            screenName = "sign in screen";
        } else if ((src.contains("Add Device".toUpperCase()) || src.contains("Air".toUpperCase()))) {
            screenName = "dashboard";
        } else if (src.contains("Dashboard".toUpperCase()) && src.contains("Add Device".toUpperCase())
                && src.contains("All Devices".toUpperCase()) && src.contains("Fuji (In Progress) Add".toUpperCase())
                && src.contains("T5/T6 Smart Thermostat Add".toUpperCase())) {
            screenName = "product list";
        } else if (src.contains("My Account".toUpperCase()) && src.contains("Sign Out".toUpperCase())
                && src.contains("Home".toUpperCase()) && src.contains("Vacation".toUpperCase())
                && src.contains("My Services".toUpperCase()) && src.contains("Activity".toUpperCase())) {
            screenName = "settings";
        } else {
            screenName = "unknown";
        }

        return screenName;
    }

    public static boolean chooseNetworktoConnectYourThermostat(TestCases testCase, FirstAlertDIYScreen diy,
            Boolean InvalidPIN, Integer setValue) {
        boolean flag = false;
        boolean isrefreshdone = false, screenLoadedAfterRefresh = true;
        try {
            int count = 0;
            String wifiSSID = SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SSID").trim();
            String wifiCorrectPwd = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_PASSWORD").trim();
            String wifiPassword;
            wifiPassword = SuiteConstants.getConstantValue(
                    SuiteConstantTypes.PROJECT_SPECIFIC,
                    InvalidPIN ? "WIFI_INCORRECTPASSWORD" : "WIFI_PASSWORD").trim();
            for (int i = 5; i >= 0; i--) {
                if (diy.isSelectNetworkScreen(30)) {
                    if (diy.isexpectedNetworkPresent(wifiSSID)) {
                        if (diy.selectNetworkName(wifiSSID)) {
                            if (diy.clickOnNextButton()) {
                                do {
                                    if (diy.setNetworkPassword(wifiPassword)) {
                                        flag = true;
                                        count++;
                                        if (InvalidPIN) {
                                            if (diy.isWifiErrorPopupExists(50)) {
                                                Keyword.ReportStep_Pass(testCase,
                                                        "Wifi Error Pop-up is displayed for Incorrect Password entered");
                                                flag = true;
                                                if (diy.getTextOfWifiErrorMessage().contains(diy.WiFiErrorMessage())) {
                                                    Keyword.ReportStep_Pass(testCase,
                                                            "Wifi Error Message is displayed properly for Incorrect PIN entered as "
                                                                    + diy.WifiInvalidPINErrorMessage()
                                                                            .getDomAttribute("content-desc"));
                                                    flag = true;
                                                } else {
                                                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                                            "Wifi Error Message is not displayed properly for Incorrect PIN entered as "
                                                                    + diy.WifiInvalidPINErrorMessage()
                                                                            .getDomAttribute("content-desc"));
                                                    flag = false;
                                                }
                                                diy.clickWifiPasswordTryAgainButton();
                                            } else {
                                                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                                        "Wifi Error Pop-up is not displayed for Incorrect Password entered");
                                                flag = false;
                                            }
                                        }

                                    } else {
                                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                                "successfully wifi password in textbox, Wifi name :: " + wifiPassword);
                                        flag = false;
                                    }
                                } while (count <= setValue);

                                if (InvalidPIN) {
                                    if (diy.setNetworkPassword(wifiCorrectPwd)) {
                                        flag = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                        "Not able to click on button");
                                flag = false;
                            }
                        } else {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                    "Not able to click on wifi ssid name, Wifi name is :: " + wifiSSID);
                            flag = false;
                        }
                    } else {
                        isrefreshdone = diy.ClickOnRefreshButton();
                        Keyword.ReportStep_Pass(testCase,
                                "Expected wifi is not visible, Is refresh the wifi scan list ?" + isrefreshdone);
                        flag = false;
                    }
                } else {
                    screenLoadedAfterRefresh = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Fetching the wifi list is taking more than 20 Seconds....");
                    flag = false;
                }
            }

            if (!flag && screenLoadedAfterRefresh) {
                try {
                    if (diy.ClickOnOtherNetworkButton()) {
                        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                            if (diy.setNetworkName(wifiSSID) && diy.clickOnNextButton()) {
                                if (diy.isSecurityScreen(3)) {
                                    String wifi_Security = SuiteConstants
                                            .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "WIFI_SECURITY")
                                            .trim();
                                    if (diy.clickOnSecurityType(wifi_Security)) {
                                        if (diy.setNetworkPassword(wifiPassword)) {
                                            flag = true;
                                            System.out.println("Wifi manually set " + flag);
                                            Keyword.ReportStep_Pass(testCase,
                                                    "Manually selected Wifi Name :: " + wifiSSID
                                                            + " , Wifi password :: " + wifiPassword
                                                            + " , in add network");
                                        } else {
                                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                                    "Not able to set Wifi Password");
                                            flag = false;
                                        }
                                    } else {
                                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                                "Not able to select Securitytype in list");
                                        flag = false;
                                    }
                                } else {
                                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                            "Not able to see security screen");
                                    flag = false;
                                }

                            } else {
                                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                        "Not able to set Wifi SSID Name");
                                flag = false;
                            }
                        } else {
                            // IOS need to develop
                            // if (diy.clickOnSecurityTypeFromList()) {
                            // if (MobileUtils.setValueToElement(testCase, "XPATH",
                            // "//XCUIElementTypeTextField[1]",
                            // wifiSSID)) {
                            // if (MobileUtils.setValueToElement(testCase, "XPATH",
                            // "//XCUIElementTypeSecureTextField[1]", wifiPassword)) {
                            // flag = LyricUtils.hideKeyboard(testCase);
                            // flag = true;
                            // System.out.println("Wifi manually set " + flag);
                            // Keyword.ReportStep_Pass(testCase, "Manually selected Wifi Name :: " +
                            // wifiSSID
                            // + " , Wifi password :: " + wifiPassword + " , in add network");
                            // } else {
                            // Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            // "Wifi ssid Password not able to set");
                            // flag = false;
                            // }
                            // } else {
                            // Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            // "Wifi ssid Name not able to set");
                            // flag = false;
                            // }
                            // } else {
                            // Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            // "Not able to click on Wifi security network manually");
                            // flag = false;
                            // }
                        }
                    } else {
                        flag = false;
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able  to click on add network manually");
                    }
                } catch (Exception e) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
                    flag = false;
                }
                flag = diy.clickOnNextButton();
            }
            if (flag)
                Keyword.ReportStep_Pass(testCase, "Successfully connected to wifi, waiting for confirmation");

        } catch (

        Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Exception Occured Due to " + e);
            flag = false;
        }
        return flag;
    }

    public static boolean confirmWifiConfigurationIsCompleted(TestCases testCase, FirstAlertDIYScreen diy) {
        boolean flag = false;
        try {
            FluentWait<Boolean> fWait = new FluentWait<Boolean>(true);
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(5));
            Boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
                public Boolean apply(Boolean driver) {
                    try {
                        if (diy.isSetupCompleteScreen(10) || diy.isRegisteredandConnectedToWIFIScreen(5)) {
                            SystemState.getStatus().isWifiNetworkError(false);
                            SystemState.getStatus().isDeviceNotRegisteredError(false);
                            return true;
                        } else if (diy.isConnectingToWifiPopUp(4)) {
                            return false;
                        } else if (diy.isRegisteringDevicePopUp(4)) {
                            return false;
                        } else if (diy.isAlreadyRegisteredPopUp(2)) {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                    "Device Already Registered Error");
                            SystemState.getStatus().isDeviceAlreadyRegisteredError(true);
                            return true;
                        } else if (diy.isWifiErrorPopUp(2)) {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "WIFI Error");
                            SystemState.getStatus().isWifiNetworkError(true);
                            return true;
                        } else if (diy.isDeviceNotRegisteredPopUp(2)) {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device Not registered");
                            SystemState.getStatus().isDeviceNotRegisteredError(true);
                            return true;
                        } else {
                            return false;
                        }
                    } catch (TimeoutException e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Exception occured in confirmWifiConfigurationIsCompleted() because of Timeout and more details "
                                        + e.getMessage());
                        return false;
                    } catch (StaleElementReferenceException e) {
                        Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
                        return false;
                    } catch (Exception e) {
                        e.printStackTrace();
                        Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Exception Occured in confirmWifiConfigurationIsCompleted() Due to " + e);
                        return false;
                    }
                }
            });
            if (SystemState.getStatus().isWifiNetworkError()) {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "During WIFI configuration Error Occured< Error WIfi Error");
            } else if (SystemState.getStatus().isDeviceAlreadyRegisteredError()) {
                flag = false;
                flag = diy.ClickOnDoneButton();
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device Already registered");
            } else if (SystemState.getStatus().isDeviceNotRegisteredError()) {
                flag = false;
                flag = diy.ClickOnDoneButton();
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Device Not registered");
            } else if (!SystemState.getStatus().isWifiNetworkError()
                    && !SystemState.getStatus().isDeviceAlreadyRegisteredError()
                    && !SystemState.getStatus().isDeviceNotRegisteredError() && isEventReceived) {
                flag = true;
                Keyword.ReportStep_Pass(testCase,
                        "Sucessfully Wifi Configuration completed and DIY will continue on Stat Location installation");
                flag = diy.ClickOnDoneButton();
            } else {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "During WIFI configuration Error Occured");
            }
        } catch (TimeoutException e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occured in confirmWifiConfigurationIsCompleted() because of Timeout and more details "
                            + e.getMessage());
            flag = false;
        } catch (StaleElementReferenceException e) {
            Keyword.ReportStep_Pass(testCase, "Stale element exception occured , Skipping....");
            flag = false;
        } catch (Exception e) {
            e.printStackTrace();
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception Occured in confirmWifiConfigurationIsCompleted() Due to " + e);
            flag = false;
        }
        return flag;
    }

    public boolean clickOnAddDeviceButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AddDevice");
    }

    public boolean clickOnT5T6Thermostat() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "T5T6Thermostat");
    }

    public boolean clickOnT9T10T10PlusThermostat() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "T9T10T10PlusThermostat");
    }

    public boolean clickOnFujiThermostat() {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        if (navigateTo.scrollToExpectedElement("FujiThermostat")) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "FujiThermostat");
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to scroll to Fuji Thermostat element.");
            return false;
        }
    }

    public boolean clickOnNextButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
    }

    public boolean isNextButton(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "NextButton", timeout);
    }

    public boolean clickOnExitButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ExitButton");
    }

    public boolean clickOnExitSetup() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ExitButton");
    }

    public boolean clickOnBackButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackButton");
    }

    public boolean clickOnYesButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
    }

    public boolean clickOnNoButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
    }

    public boolean clickOnAddLocationButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AddLocationButton");
    }

    public List<String> getLocationNames() {

        List<String> locationNames = null;
        List<WebElement> locationsElements = MobileUtils.getMobElements(objectDefinition, testCase, "LocationElements");
        for (WebElement element : locationsElements) {
            String locationName = null;
            if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                locationName = element.getDomAttribute("content-desc");
            } else {
                locationName = element.getDomAttribute("name");
            }
            if (locationName != null) {
                locationNames.add(locationName);
            }
        }
        return locationNames;
    }

    public boolean isChooseDeviceScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ChooseDevice");
    }

    public boolean isLocationNameAvailable(String locationName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//*[@content-desc='" + locationName + "']", testCase);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//*[@name='" + locationName + "']", testCase);

        }
    }

    public boolean isDeviceNameTaken(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeviceNameTaken", timeout);
    }

    public boolean selectLocationName(String locationName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@content-desc='" + locationName + "']");
        } else {
            return MobileUtils.clickOnElement(testCase, "XPATH", "//*[@name='" + locationName + "']");

        }

    }

    public boolean setDeviceName(String deviceName) {

        boolean flag = false;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "DeviceNameInput", 3)) {
                Keyword.ReportStep_Pass(testCase, "DeviceNameInput is present.");
                WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "DeviceNameInput");
                mobElement.click();
                mobElement.sendKeys(deviceName);
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "DeviceNameInput is not present");
            }
            if (isDeviceNameTaken(3)) {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Device name already taken try to change the device name in the list");
                return false;
            }
            ((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            flag = true;
        } else {
            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "DeviceNameInput");
            mobElement.click();
            mobElement.sendKeys(deviceName);
            if (isDeviceNameTaken(3)) {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "Device name already taken try to change the device name in the list");
                return false;
            }
            flag = true;
        }
        return flag;
    }

    public boolean isConfigureDeviceScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfigureDeviceScreen",
                "Currently in Configure device Screen");
    }

    public boolean isStepsToAddDeviceScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StepsToAddDeviceScreen",
                "Currently in steps for adding device Screen");
    }

    public boolean isLocationSelectScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "LocationSelectScreen",
                "Currently in Location select Screen");
    }

    public boolean isDeviceNameScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeviceNameScreen", 2);
    }

    public boolean isThermostatOnWallScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ThermostatOnWallScreen");
    }

    public boolean isConnectAppStepsFUJIScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectAppStepsFUJIScreen");
    }

    public boolean isCheckDisplayForBleFUJIScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CheckDisplayForBleFUJIScreen");
    }

    public boolean isTwoMoreStepScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "TwoMoreStepScreen");
    }

    public boolean isTemperatureDisplayScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "TemperatureDisplayScreen");
    }

    public boolean isPrepareDeviceJasperScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PrepareDeviceJasperScreen");
    }

    public boolean isConfirmNetworkNameScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfirmNetworkNameScreen");
    }

    public boolean isConfirmBluetoothScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfirmBluetoothScreen");
    }

    public boolean isBluetoothScanScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BluetoothScanScreen");
    }

    public boolean isBluetoothScanScreen1() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BluetoothScanScreen1");
    }

    public boolean isBluetoothScanning() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BluetoothScanning", 3);
    }

    public boolean isNoThermostatFoundBlePopUp() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "NoThermostatFoundBlePopUp", 3);
    }

    public boolean isNeedToKeepCurrentConfigurationPopUp() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "NeedToKeepCurrentConfigurationPopUp");
    }

    public boolean clickTryAgainButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "TryAgainButton");
    }

    public boolean isOneMoreStepScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "OneMoreStepScreen");
    }

    public boolean isPrepareThermostatT9T10T10PlusScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PrepareThermostatT9T10T10PlusScreen");
    }

    public boolean isQRCodeT9T10T10PlusScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "QRCodeT9T10T10PlusScreen");
    }

    public boolean isPhoneSameNetworkT9T10Screen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PhoneSameNetworkT9T10Screen");
    }

    public boolean isIsThermostatReadyT9T10Screen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsThermostatReadyT9T10Screen");
    }

    public boolean isLookingForThermostatPopup() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "LookingForThermostatPopup");
    }

    public boolean isExitSetupPopup() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExitSetupPopup");
    }

    public boolean isIncorrectPinErrorMsg1Present() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IncorrectPinErrorMsg1");
    }

    public WebElement getIncorrectPinErrorMsg1() {
        return MobileUtils.getMobElement(objectDefinition, testCase, "IncorrectPinErrorMsg1");
    }

    public boolean isIncorrectPinErrorMsg2Present() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IncorrectPinErrorMsg2");
    }

    public WebElement getIncorrectPinErrorMsg2() {
        return MobileUtils.getMobElement(objectDefinition, testCase, "IncorrectPinErrorMsg2");
    }

    public boolean isConnectionFailedMsgPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectionFailed");
    }

    public WebElement getConnectionFailedMsg() {
        return MobileUtils.getMobElement(objectDefinition, testCase, "ConnectionFailed");
    }

    public List<WebElement> getSecurityPinElements() {
        return MobileUtils.getMobElements(objectDefinition, testCase, "SecurityCode4DigitPin");
    }

    public boolean clickOnTryAgainButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "TryAgain");
    }

    public boolean clickContinueButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ContinueButton");
    }

    public boolean isBLEDeviceIsPresent(String macname) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH",
                    "//*[contains(@content-desc,'" + macname + "') or contains(@content-desc,'"
                            + macname.replaceAll("(.{2})", "$1:").replaceAll(":$", "") + "') ]",
                    testCase);
        } else {
            return MobileUtils.isMobElementExists( "XPATH",
                    "//*[contains(@label,'" + macname + "') or contains(@label,'"
                            + macname.replaceAll("(.{2})", "$1:").replaceAll(":$", "") + "') ]",testCase);
        }
    }

    public boolean clickOnParticularDiscoveredDevice(String macname) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.clickOnElement(testCase, "XPATH",
                    "//*[contains(@content-desc,'" + macname + "') or contains(@content-desc,'"
                            + macname.replaceAll("(.{2})", "$1:").replaceAll(":$", "") + "') ]");
        } else {
            return MobileUtils.clickOnElement(testCase, "XPATH",
                    "//*[contains(@label,'" + macname + "') or contains(@label,'"
                            + macname.replaceAll("(.{2})", "$1:").replaceAll(":$", "") + "') ]");
        }
    }

    public boolean isConnectingToThermostatSpinning() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToThermostatSpinning", 1);
    }

    public boolean isConnectingToThermostatSpinning(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToThermostatSpinning", timeout);
    }

    public boolean isErrorOccuredDuringBLEDeviceConnecting() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ErrorOccuredDuringBLEDeviceConnecting", 1);
    }

    public boolean isConnectionFailedDuringBLEDeviceConnecting() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectionFailedDuringBLEDeviceConnecting",
                1);
    }

    public boolean isSecurityCodeScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SecurityCodeScreen", 30);
    }

    public boolean isSecurityCodeScreen(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SecurityCodeScreen", timeout);
    }

    public boolean clickOnOkButton() {
        if (MobileUtils.isMobElementExists(objectDefinition, testCase, "OkButton", 4)) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "OkButton");
        }
        return false;

    }

    public boolean isExpectedScreen(TestCases testCase, String expectedtext) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(1));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
                        String screename = getScreenName_FirstAlert(pageSource);
                        if (screename.toUpperCase().contains(expectedtext.toUpperCase())) {
                            Keyword.ReportStep_Pass(testCase,
                                    "Expected screen appeared, Screen name is " + expectedtext);
                            return true;
                        } else {
                            System.out.println("Current status is " + screename);
                            return false;
                        }

                    } catch (StaleElementReferenceException e) {
                        Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
                        return false;
                    } catch (TimeoutException e) {
                        Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                        return false;
                    } catch (StackOverflowError e) {
                        Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                        return false;
                    } catch (NoSuchElementException e) {
                        Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                        return false;
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able to login or might need to check the app flow");
                        return false;
                    }
                }
            });
            if (isEventReceived) {
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to find expected screen");
                flag = false;
            }

        } catch (StaleElementReferenceException e) {
            Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
            flag = false;
        } catch (TimeoutException e) {
            Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
            flag = false;
        } catch (StackOverflowError e) {
            Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
            flag = false;
        } catch (NoSuchElementException e) {
            Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
            flag = false;
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;
    }

    public String diyScreenNavigation() {
        String screenName = null;
        String pgsrc = testCase.getMobileDriver().getPageSource().toUpperCase();
        if (pgsrc.contains("ADD THERMOSTAT") && pgsrc.contains("ADD YOUR THERMOSTAT TO THE RESIDEO APP")
                && pgsrc.contains("GET STARTED")) {
            screenName = "resideo app 3 step";
        } else if (pgsrc.contains("IS THE THERMOSTAT ON THE WALL") && pgsrc.contains("YES") && pgsrc.contains("NO")) {
            screenName = "thermostat on wall";
        } else if (pgsrc
                .contains("IS YOUR THERMOSTAT DISPLAYING THE MESSAGE USE APP WITH BLINKING BLUETOOTH AND WI-FI ICONS")
                && pgsrc.contains("YES") && pgsrc.contains("NO")) {
            screenName = "thermostat displaying use app";
        } else if (pgsrc.contains("CHOOSE LOCATION") && pgsrc.contains("CANCEL")
                && pgsrc.contains("CREATE NEW LOCATION")) {
            screenName = "select location";
        } else if (pgsrc.contains("SELECT ROOM") && pgsrc.contains("WHERE IS YOUR THERMOSTAT LOCATED")) {
            screenName = "select room";
        } else if (pgsrc.contains("IS IT DISPLAYING A TEMPERATURE") && pgsrc.contains("YES") && pgsrc.contains("NO")
                && pgsrc.contains("CANCEL") && pgsrc.contains("INSTALLATION")) {
            screenName = "displaying thermostat";
        } else if (pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING A NETWORK NAME LIKE THE EXAMPLE BELOW")
                && pgsrc.contains("YES") && pgsrc.contains("NO") && pgsrc.contains("CANCEL")
                && pgsrc.contains("INSTALLATION") && !pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING BLE AT THE TOP")
                && !pgsrc.contains("PRESS AND HOLD THE THERMOSTAT NETWORK NAME FOR 5 SECONDS")
                && !(pgsrc.contains("CONNECT TO THE THERMOSTAT WI-FI NETWORK")
                        || pgsrc.contains("CONNECT TO YOUR THERMOSTAT'S WI-FI NETWORK"))) {
            screenName = "displaying network name";
        } else if (pgsrc.contains("IS YOUR THERMOSTAT DISPLAYING BLE AT THE TOP") && pgsrc.contains("YES")
                && pgsrc.contains("NO") && pgsrc.contains("CANCEL") && pgsrc.contains("INSTALLATION")) {
            screenName = "displaying ble";
        } else if (pgsrc.contains("CONNECT") && pgsrc.contains("NEXT") && pgsrc.contains("CANCEL")
                && pgsrc.contains("PRESS AND HOLD THE THERMOSTAT NETWORK NAME FOR 5 SECONDS")) {
            screenName = "enable ap mode";
        } else if (pgsrc.contains("CONNECT") && (pgsrc.contains("CANCEL") || pgsrc.contains("NEXT"))
                && (pgsrc.contains("CONNECT TO THE THERMOSTAT WI-FI NETWORK")
                        || pgsrc.contains("CONNECT TO YOUR THERMOSTAT'S WI-FI NETWORK"))) {
            screenName = "connect to thermostat network";
        } else if (pgsrc.contains("START THERMOSTAT NETWORK")
                && pgsrc.contains(
                        "PRESS THE CENTER TEMPERATURE ON YOUR THERMOSTAT FOR 5 SECONDS UNTIL YOU SEE LYRIC OR TSTAT")
                && pgsrc.contains("INSTALLATION") && pgsrc.contains("CANCEL")) {
            screenName = "start thermostat network";
        } else if (pgsrc.contains("LOCAL NETWORK") && pgsrc.contains("IOS SETTINGS")
                && pgsrc.contains("I HAVE ENABLED LOCAL NETWORK")
                && pgsrc.contains("SEARCHING FOR DEVICES REQUIRES LOCAL NETWORK PERMISSIONS")) {
            screenName = "local network permission";
        } else if (pgsrc.contains("TURN ON PRECISE LOCATION") && pgsrc.contains("TURN ON LOCATION")
                && pgsrc.contains("NOT NOW")) {
            screenName = "turn on location";
        } else if (pgsrc.contains("HAS THE WIRELESS RECEIVER BOX AND THERMOSTAT BEEN INSTALLED")
                && pgsrc.contains("YES") && pgsrc.contains("NO") && pgsrc.contains("CANCEL")
                && pgsrc.contains("INSTALLATION")) {
            screenName = "thermostat on wall";
        } else if (pgsrc.contains("CONTINUE WITH FULL SETUP") && pgsrc.contains("CANCEL")
                && pgsrc.contains("CONFIRM")) {
            screenName = "continue with full setup";
        } else if (pgsrc.contains("ARE YOU A PROFESSIONAL CONTRACTOR") && pgsrc.contains("YES") && pgsrc.contains("NO")
                && pgsrc.contains("CANCEL")) {
            screenName = "are you contractor";
            // } else if (pgsrc.contains("") && pgsrc.contains("") && pgsrc.contains("") &&
            // pgsrc.contains("")) {
        } else {
            screenName = "unknown";
        }
        return screenName;
    }

    public boolean SelectBLEDevicefromBluetooth() {
        String macID = null;
        boolean flag = false;
        try {
            String deviceNeedToInstall = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
            if (deviceNeedToInstall.contains("DENALI")) {
                macID = MqttManager.getMacId();
                macID = "TSTAT " + macID.substring(6, 12);
            } else if (deviceNeedToInstall.contains("GLENEAGLES")) {
                macID = MqttSerialController.getDeviceInformation("MACID");
                macID = macID.substring(6, 12);
            } else {
                macID = StatCommands.getInstance().cattCommandsStub
                        .getDeviceInfo(DeviceInfoMsg.newBuilder().setItem(DeviceInfoItem.MAC_ID).build()).getStrVal();
            }
            System.out.println(macID);
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            try {
                String MacID = macID;
                Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
                    public Boolean apply(CustomDriver driver) {
                        try {
                            if (isBluetoothScanning()) {
                                System.out.println("Searching device .....");
                                return false;
                            } else if (isBLEDeviceIsPresent(MacID)) {
                                return true;
                            } else if (checkForNoThermostatFoundBlePopUp(1)) {
                                SystemState.getStatus().isDeviceNotFound(true);
                                return true;
                            } else if (isConnectionFailedPopUp(2)) {
                                clickOnTryAgainButton();
                                return false;
                            } else {
                                return false;
                            }
                        } catch (StaleElementReferenceException e) {
                            Keyword.ReportStep_Pass(testCase,
                                    "Stale element reference exceotion, skipping for retry..");
                            return false;
                        } catch (TimeoutException e) {
                            Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                            return false;
                        } catch (StackOverflowError e) {
                            Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                            return false;
                        } catch (NoSuchElementException e) {
                            Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                            return false;
                        } catch (Exception e) {
                            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                    "Not able to login or might need to check the app flow");
                            return false;
                        }
                    }
                });

                if (success && SystemState.getStatus().isDeviceNotFound()) {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Device not found pleasee check if device is broadcasting");
                } else if (success) {
                    flag = true;
                    Keyword.ReportStep_Pass(testCase,
                            "SucessFully Identificed stat maci ID in discovered Devices screen");
                } else {
                    flag = false;
                }

            } catch (StaleElementReferenceException e) {
                Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
                flag = false;
            } catch (TimeoutException e) {
                Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                flag = false;
            } catch (StackOverflowError e) {
                Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                flag = false;
            } catch (NoSuchElementException e) {
                Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                flag = false;
            } catch (Exception e) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Ble not able to identify exact mac ID");
                flag = false;
            }
            flag = clickOnParticularDiscoveredDevice(macID);
            if (flag) {
                try {
                    Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {

                        public Boolean apply(CustomDriver driver) {
                            try {
                                if (isConnectingToThermostatSpinning()) {
                                    return false;
                                } else if (isErrorOccuredDuringBLEDeviceConnecting()) {
                                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                            "Not able to connect with Thermostat BLE ");
                                    SystemState.getStatus().isBleErrorConnectingtoThermostat(true);
                                    clickOnOkButton();
                                    return true;
                                } else if (deviceNeedToInstall.contains("GLENEAGLES") && isConfirmConnectionScreen()) {
                                    return true;
                                } else if (isSecurityCodeScreen()) {
                                    return true;
                                } else {
                                    return false;
                                }
                            } catch (StaleElementReferenceException e) {
                                Keyword.ReportStep_Pass(testCase,
                                        "Stale element reference exceotion, skipping for retry..");
                                return false;
                            } catch (TimeoutException e) {
                                Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                                return false;
                            } catch (StackOverflowError e) {
                                Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                                return false;
                            } catch (NoSuchElementException e) {
                                Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                                return false;
                            } catch (Exception e) {
                                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                        "Ble not able to identify exact mac ID");
                                return false;
                            }
                        }
                    });

                    if (success && !SystemState.getStatus().isBleErrorConnectingtoThermostat()) {
                        flag = true;
                        Keyword.ReportStep_Pass(testCase,
                                "SucessFully Identificed stat maci ID in discovered Devices screen");
                    } else {
                        flag = false;
                    }

                } catch (

                StaleElementReferenceException e) {
                    Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
                    flag = false;
                } catch (TimeoutException e) {
                    Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                    flag = false;
                } catch (StackOverflowError e) {
                    Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                    flag = false;
                } catch (NoSuchElementException e) {
                    Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                    flag = false;
                } catch (Exception e) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Ble not able to identify exact mac ID");
                    flag = false;
                }
            } else {
                flag = false;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Ble not able to identify exact mac ID");
            flag = false;
        }
        return flag;
    }

    // from here all ISU Screens verification methods

    protected boolean isConfirmConnectionScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConfirmConnectionScreen", 10);
    }

    public boolean set4_DigitPin() {
        boolean flag = false;

        String deviceNeedToInstall;
        try {
            deviceNeedToInstall = SuiteConstants
                    .getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "DEVICE_UNDER_TEST").trim();
            char[] pinFromThermostat = getPinFromThermostat(deviceNeedToInstall);
            if (isSecurityCodeScreen()) {
                List<WebElement> mobElements = MobileUtils.getMobElements(objectDefinition, testCase,
                        "SecurityCode4DigitPin");
                for (int i = 0; i < mobElements.size(); i++) {
                    Actions a = new Actions(testCase.getMobileDriver());
                    a.sendKeys(String.valueOf(pinFromThermostat[i]));
                    a.perform();
                    flag = true;
                }
            }
            if (flag) {
                flag = clickOnOkButton();
                SystemState.getStatus().pairingStartTime(System.currentTimeMillis() / 1000);
                Keyword.ReportStep_Pass(testCase,
                        "Pairing completed, current time stamp is " + SystemState.getStatus().pairingStartTime());
                Keyword.ReportStep_Pass(testCase,
                        "Sucessfully set pin into mobile the 4Digit pins are <<< " + pinFromThermostat[0]
                                + pinFromThermostat[1] + pinFromThermostat[2] + pinFromThermostat[3] + " >>>");
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to enter pin in APP");
            }

        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occured in set4_DigitPin() due to " + e.getMessage());
            flag = false;
        }
        return flag;
    }

    public char[] getPinFromThermostat(String deviceModel) {
        String pin = "";
        String finalPin = "";
        int total = 10;
        String Counter = "";
        String previousPin = SystemState.getStatus().getPreviousPin();
        for (int i = 0; i <= total; i++) {

            if (deviceModel.contains("JASPER")) {
                pin = StatCommands.getInstance().cattCommandsStub
                        .jasperGetDisplayText(JasperDisplayTextMsg.newBuilder().setTextArea(DisplayArea.Multitext)
                                .setTextMethod(DisplayMethod.Numbers).build())
                        .getStrVal().trim().toUpperCase().replace(" ", "").trim();
            } else if (deviceModel.contains("DENALI")) {
                pin = MqttManager.getAuthCode();
                if (pin != null && !pin.isEmpty()) {
                    finalPin = pin;
                    System.out.println(finalPin);
                    SystemState.getStatus().setPreviousPin(finalPin);
                    break;
                }
            } else {
                pin = StatCommands.getInstance().cattCommandsStub
                        .getPairingPin(PairingPinMsg.newBuilder().setPinMode(PairingPinMode.RADIO).build()).getStrVal();
            }

            // System.out.println("Current Pin is " + pin);
            // System.out.println("Previous Pin is " + previousPin);
            if (pin.equals("") || pin.toUpperCase().contains("INVALID")) {

                System.out.println("Retry Pin, Pin is:: " + pin);
            } else if (!SystemState.getStatus().getPreviousPin().isEmpty() && previousPin.contains(pin)) {
                System.out.println("Same pin Found, Retry Pin, Pin is:: " + pin);
            } else {
                if (i == 4 || i == 8) {
                    Counter = pin;
                } else if (Counter.contains(pin) && (!pin.isEmpty())) {
                    finalPin = pin;
                    System.out.println(finalPin);
                    SystemState.getStatus().setPreviousPin(finalPin);
                    break;
                }
            }
        }

        return finalPin.toCharArray();
    }

    public boolean isTemperatureScaleScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isTemperatureScaleScreen", timeOut);
    }

    public boolean isOutDoorSensorScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutDoorSensorScreen", timeOut);
    }

    public boolean isHeatingSystemScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingSystemScreen", timeOut);
    }

    public boolean isFuelSourceScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FuelSourceScreen", timeOut);
    }

    public boolean isCompressorStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorStageScreen", timeOut);
    }

    public boolean isCoolingStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolingStageScreen", timeOut);
    }

    public boolean isHeatingStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingStageScreen", timeOut);
    }

    public boolean isSystemChangeOverScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSystemChangeOverScreen", timeOut);
    }

    public boolean isAutoChangeoverDifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAutoChangeoverDifferentialScreen",
                timeOut);
    }

    public String getValueinAutoChangeOverDiff() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "GetAutoChangeOverDiffValue")
                    .getDomAttribute("content-desc").replace("°", "");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "GetAutoChangeOverDiffValue")
                    .getDomAttribute("name").replace("°", "");
        }
    }

    public boolean ClickOnDecreaseDownButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "DecreaseDownButton");
    }

    public boolean ClickOnIncreaseUpButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "IncreaseUpButton");
    }

    public boolean ClickOnAuxHeatDifferentialDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxHeatDifferentialDecrease");
    }

    public boolean ClickOnAuxHeatDifferentialIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxHeatDifferentialIncrease");
    }

    public boolean isReversingValveScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ReversingValveScreen", timeOut);
    }

    public boolean isAuxETerminalControlScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AuxETerminalControlScreen", timeOut);
    }

    public boolean isAuxBackUpHeatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AuxBackUpHeatScreen", timeOut);
    }

    public boolean isEmergencyHeatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatScreen", timeOut);
    }

    public boolean isStagingControlHighCoolStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StagingControlHighCoolStageScreen", timeOut);
    }

    public boolean isStagingControlHighHeatStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StagingControlHighHeatStageScreen", timeOut);
    }

    public boolean isStagingControlBackupHeatDifferential(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AuxBackUpHeatDifferentialScreen", timeOut);
    }

    public String getAuxBackUpHeatDifferential() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "AuxHeatDifferentialValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "AuxHeatDifferentialValue")
                    .getDomAttribute("name");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public String getISUDropDownValue() {
        String val;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            val = MobileUtils.getMobElement(objectDefinition, testCase, "ISUDropDownValue")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        } else {
            val = MobileUtils.getMobElement(objectDefinition, testCase, "ISUDropDownValue").getDomAttribute("resource-id")
                    .replace("ISU", "").replace("_", "").trim();
        }
        if (val == null) {
            return "";
        }
        return val;
    }

    public boolean isBackupHeatUpStageTimerScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatUpStageTimerScreen", timeOut);
    }

    public boolean isCompressorLockoutScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorLockoutScreen", timeOut);
    }

    public boolean isBackupHatLockOutScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isBackupHeatLockOutScreen", timeOut);
    }

    public boolean isLockOutFanAfterCoolScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isLockOutFanAfterCoolScreen", timeOut);
    }

    public boolean isCompressorCyclePerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage1Screen",
                timeOut);
    }

    public boolean isCompressorCyclePerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCyclePerHourStage2Screen",
                timeOut);
    }

    public boolean isBackupHeatCyclesPerHourScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatCyclesPerHourScreen", timeOut);
    }

    public String getBackUpHeatCyclePerHourValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatCyclePerHourValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatCyclePerHourValue")
                    .getDomAttribute("label");

        }
        return getText;
    }

    public boolean ClickOnBackUpHeatCyclePerHourDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatCyclePerHourDecrease");
    }

    public boolean ClickOnBackUpHeatCyclePerHourIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatCyclePerHourIncrease");
    }

    public boolean isCompressorMinimumOffTimeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isCompressorOffMinimumTimeScreen", timeOut);
    }

    public boolean isAdaptiveIntelligentRecoveryScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAdaptiveIntelligentRecoveryScreen",
                timeOut);
    }

    public boolean isMaximumCoolSetPointScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMaximumCoolSetPointScreen", timeOut);
    }

    public boolean isMinimumCoolSetPointScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMinimumCoolSetPointScreen", timeOut);
    }

    public boolean isMaximumHeatSetPointScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMaximumHeatSetPointScreen", timeOut);
    }

    public boolean isMinimumHeatSetPointScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isMinimumHeatSetPointScreen", timeOut);
    }

    public String getMaxMinSetpointValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "MaxMinSetpointValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "MaxMinSetpointValue")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean ClickOnMaxMinSetpointDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinSetpointDecrease");
    }

    public boolean ClickOnMaxMinSetpointIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinSetpointIncrease");
    }

    public boolean isNumberOfAirFiltersScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isNumberOfAirFiltersScreen", timeOut);
    }

    public boolean isAirFilter1ReplacementReminder(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAirFilter1ReplacementReminder", timeOut);
    }

    public boolean isAirFilter2ReplacementReminder(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isAirFilter2ReplacementReminder", timeOut);
    }

    public boolean isBacklightingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isBacklightingScreen", timeOut);
    }

    public boolean isIdleScreenSelectionScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isIdleScreenSelectionScreen", timeOut);
    }

    public boolean isIdleScreenCustomizationScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isIdleScreenCustomizationScreen", timeOut);
    }

    public boolean isHomeScreenCustomizationScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isHomeScreenCustomizationScreen", timeOut);
    }

    public boolean isClockFormatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isClockFormatScreen", timeOut);
    }

    public boolean isDayLightSavingTimescreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isDayLightSavingTimescreen", timeOut);
    }

    public boolean isIndoorTemperatureDisplayOffsetScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isIndoorTemperatureDisplayOffsetScreen",
                timeOut);
    }

    public boolean isEmergencyHeatCyclesPerHourScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatCyclesPerHourScreen", timeOut);
    }

    public String getEmergencyHeatCyclePerHourValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "EmergencyHeatCyclePerHourValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "EmergencyHeatCyclePerHourValue")
                    .getDomAttribute("label");

        }
        return getText;
    }

    public boolean ClickOnEmergencyHeatCyclePerHourDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatCyclePerHourDecrease");
    }

    public boolean ClickOnEmergencyHeatCyclePerHourIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatCyclePerHourIncrease");
    }

    public boolean isFanOperationinHeatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanOperationinHeatScreen", timeOut);
    }

    public boolean isCoolCyclesPerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage1Screen", timeOut);
    }

    public boolean isCoolCyclesPerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourStage2Screen", timeOut);
    }

    public boolean isHeatCyclePerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage1Screen", timeOut);
    }

    public boolean isHeatCyclePerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage2Screen", timeOut);
    }

    public String getHeatCyclePerHourValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "HeatCyclePerHourValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "HeatCyclePerHourValue")
                    .getDomAttribute("label");

        }
        return getText;
    }

    public boolean ClickOnHeatCyclePerHourDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatCyclePerHourDecrease");
    }

    public boolean ClickOnHeatCyclePerHourIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatCyclePerHourIncrease");
    }

    public boolean isKeypadLockoutScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "KeypadLockoutScreen", timeOut);
    }

    public boolean isBackLightBrightnessScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackLightBrightnessScreen", timeOut);
    }

    public boolean isConfigurationSummary(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ISUConfigurationSummaryScreen", timeOut);
    }

    public boolean isSelectDifferentWifiNetworkPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSelectDifferentWifiNetworkPopUp", timeOut);
    }

    public boolean isSelectNetworkScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectNetworkScreen", timeOut);
    }

    public boolean ClickOnOtherNetworkButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "OtherNetworkButton");
    }

    public boolean ClickOnRefreshButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "RefreshButton");
    }

    public boolean isexpectedNetworkPresent(String wifiName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[contains(@content-desc,'" + wifiName + "')]", testCase, 3);

        } else {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + wifiName + "')]", testCase, 3);
        }
    }

    public boolean selectNetworkName(String wifiName) {
        boolean flag = true;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            flag = MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[contains(@content-desc,'" + wifiName + "')]", testCase, 3);
            flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                    "//android.view.View[contains(@content-desc,'" + wifiName + "')]");
        } else {
            flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + wifiName + "')]", testCase, 3);
            flag = flag && MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + wifiName + "')]");
        }
        return flag;
    }

    public boolean setNetworkPassword(String networkPassword) {
        boolean flag = false;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "NetworkPasswordInput");
            mobElement.click();
            mobElement.clear();
            mobElement.sendKeys(networkPassword);
            ((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            flag = true;
        } else {
            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "NetworkPasswordInput");
            mobElement.click();
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "NetworkPasswordInput")) {
                mobElement.sendKeys(networkPassword);

                MobileUtils.getMobElement(objectDefinition, testCase, "NetworkPasswordInputAfterClick")

                        .sendKeys(networkPassword);
            } else {
                mobElement.sendKeys(networkPassword);
            }
            if (isNextButton(3)) {
                flag = clickOnNextButton();
            } else {
                flag = MobileUtils.clickOnElement(testCase, "NAME", "go");
            }
        }
        return flag;
    }

    public boolean setNetworkName(String networkName) {

        boolean flag = false;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "NetworkNameInput");
            mobElement.click();
            mobElement.sendKeys(networkName);
            ((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            flag = true;
        } else {
            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "NetworkNameInput");
            mobElement.click();
            mobElement.sendKeys(networkName);
            ((CustomAndroidDriver) testCase.getMobileDriver()).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
            flag = true;
        }
        return flag;
    }

    public boolean isSecurityScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SecurityScreen", timeOut);
    }

    public boolean clickOnSecurityType(String securityType) {
        boolean flag = true;

        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            flag = MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[contains(@content-desc,'" + securityType + "')]", testCase, 3);
            flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                    "//android.view.View[contains(@content-desc,'" + securityType + "')]");
        } else {
            flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + securityType + "')]", testCase, 3);
            flag = flag && MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + securityType + "')]");
        }
        return flag;
    }

    public boolean isNetworkPasswordScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "NetworkPasswordScreen", timeOut);
    }

    public boolean isWifiErrorPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "WifiError", timeOut);
    }

    public boolean isConnectingToWifiPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectingToWifiPopUp", timeOut);
    }

    public boolean isSetupCompleteScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SetupCompleteScreen", timeOut);
    }

    public boolean ClickOnAddAnotherDeviceButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AddAnotherDeviceButton");
    }

    public boolean ClickOnDoneButton() {
        if (MobileUtils.isMobElementExists(objectDefinition, testCase, "DoneButton", 20))
            return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
        return false;
    }

    public boolean isAlreadyRegisteredPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AlreadyRegisteredPopUp", timeOut);
    }

    public boolean isDeviceNotRegisteredPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeviceNotRegisteredPopUp", timeOut);
    }

    public boolean isRegisteringDevicePopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "RegisteringDevicePopUp", timeOut);
    }

    public boolean isDeviceSyncComplete(String DeviceName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//android.view.View[contains(@content-desc,'" + DeviceName
                    + "')]/*[(contains(@content-desc,'Currently') or contains(@resource-id,'current_label')) or (contains(@content-desc,'"
                    + DeviceName + "') and contains(@resource-id,'indoor_temperature_readout'))]", testCase, 2);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//android.view.View[contains(@name,'" + DeviceName
                    + "')]/*[(contains(@name,'Currently') or contains(@resource-id,'current_label')) or (contains(@name,'"
                    + DeviceName + "') and contains(@resource-id,'indoor_temperature_readout'))]", testCase, 2);
        }
    }

    public boolean isDeviceSyncInProgress(String DeviceName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//android.view.View[contains(@content-desc,'" + DeviceName
                    + "') and contains(@resource-id,'device_sync_progress')]", testCase, 2);
        } else {
            return MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[contains(@name,'" + DeviceName
                            + "') and contains(@resource-id,'device_sync_progress')]",
                    testCase, 2);
        }
    }

    public boolean isDeviceSyncError(String DeviceName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + DeviceName
                    + "') and contains(@content-desc,'An error occurred while syncing your device.') or contains(@content-desc,'Contact Customer Support')]",
                    testCase, 2);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + DeviceName
                    + "') and contains(@name,'An error occurred while syncing your device.') or contains(@name,'Contact Customer Support')]",
                    testCase, 2);
        }
    }

    public boolean isDeviceAvailableOnDashboard(String DeviceName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + DeviceName + "')]",
                    testCase, 2);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + DeviceName + "')]", testCase, 2);
        }
    }

    public boolean ClickOnDeviceNameOnDashboard() {
        Point cordinates;
        // String deviceName =
        // testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");
        String deviceName = SystemState.getStatus().getTstatName();
        Dimension size;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            WebElement ele = MobileUtils.getMobElement(testCase, "xpath",
                    "(//*[contains(@content-desc,'" + deviceName + "') ])[last()]");
            cordinates = ele.getLocation();
            size = ele.getSize();
        } else {
            WebElement ele = MobileUtils.getMobElement(testCase, "xpath",
                    "(//*[contains(@name,'" + deviceName + "')])[last()]");
            cordinates = ele.getLocation();
            size = ele.getSize();
        }
        return MobileUtils.clickOnCoordinate(testCase, (cordinates.x + (size.width / 4)),
                (cordinates.y + (size.height / 2)));

    }

    public boolean ClickOnSettingsIcon() {
        List<WebElement> elements;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            elements = MobileUtils.getMobElements(testCase, "XPATH", "//android.widget.ImageView");
        } else {
            elements = MobileUtils.getMobElements(testCase, "XPATH", "//XCUIElementTypeButton");
        }
        return MobileUtils.clickOnElement(testCase, (WebElement) elements.get(elements.size() - 1),
                "Clicked on Settings button");
    }

    public boolean ClickOnDeleteButton() {
        List<WebElement> elements;
        String locatorVal;
        boolean flag = false;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            locatorVal = "//*[@content-desc='Delete Device']";
        } else {
            locatorVal = "//*[@name='Delete Device']";
        }
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();

        int x = (int) (dimens.getWidth() * 0.5);
        int endY = (int) (dimens.getHeight() * 0.2);
        int startY = (int) (dimens.getHeight() * 0.75);
        for (int i = 0; i <= 5; i++) {
            if (MobileUtils.isMobElementExists("XPATH", locatorVal, testCase, 5)) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully Scrolled to Expected Element");
                break;
            } else {
                W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
            }
        }
        if (flag) {
            flag = true;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                    "Not able to scroll to expected delete button");
            flag = false;
        }
        return MobileUtils.clickOnElement(testCase, "XPATH", locatorVal);
    }

    public boolean ClickOnConfirmDeleteButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteButton");
    }

    public boolean ClickOnCancelButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButton");
    }

    // value selection methods

    public boolean ClickOndeviceDetailsButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "DoneButton");
    }

    public boolean isDeleteDevicePopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "RegisteringDevicePopUp", timeOut);
    }

    public boolean ISUTemperatureScale(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "FAHRENHEIT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureScaleFahrenheit");
            }
            case "CELSIUS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "TemperatureScaleCelsius");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUOutDoorSensor(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "DONT SHOW": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorNo");
            }
            case "WIRED":
            case "WIRED SENSOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorWired");
            }
            case "INTERNET": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "OutDoorSensorInternet");
            }
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available in OutDoor Air Sensor, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }

    }

    public boolean ISUHeatingSystem(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "CONVENTIONAL FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalForcedAir");
            }
            case "HEAT PUMP": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPump");
            }
            case "BOILER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Boiler");
            }
            case "NONE COOL ONLY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneCoolOnly");
            }
            case "FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoil");
            }
            case "PACKAGED TERMINAL AIR CONDITIONER (PTAC)": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "PTAC");
            }
            case "RADIANT HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "RadiantHeat");
            }
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean ISUFuelSource(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "GAS STANDARD EFFICIENCY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasStandardEfficiency");
            }
            case "GAS HIGH EFFICIENCY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasHighEfficiency");
            }
            case "OIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalOil");
            }
            case "ELECTRIC": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalElectric");
            }
            case "HOT WATER FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalHotWaterFanCoil");
            }
            case "AIR TO AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpAirToAir");
            }
            case "GEOTHERMAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpGeothermal");
            }
            case "HOT WATER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerHotWater");
            }
            case "STEAM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerSteam");
            }
            case "HOT WATER RADIANT HEAT":
            case "HOT WATER - RADIANT HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantHeat");
            }
            case "HOT WATER RADIANT FLOOR HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantFloorHeat");
            }
            default: {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Fuel Source System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
            }
        }
    }

    public boolean ISUReversingValve(String ISUValue) {

        switch (ISUValue.toUpperCase()) {
            case "REVERSING VALVE O OB ON COOL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnCool");
            }
            case "REVERSING VALVE B OB ON HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ReversingValveOBOnHeat");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUCooling_HeatingStages(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "StageNone");
            }
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
            }
            case "3": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage3");
            }
            case "4": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoilCoolStage4");

            }
            default:
                return false;
        }

    }

    public boolean ISUCompressorStages(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
            }
            default:
                return false;
        }
    }

    public boolean ISUSystemChangeOver(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "MANUAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemChangeOverManual");
            }
            case "AUTOMATIC": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemChangeOverAutomatic");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUAutoChangeoverDifferential(String ISUValue) {
        boolean flag = false;
        String isuValue = ISUValue.toUpperCase();
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            isuValue = "0 DEG";
        }
        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (!ISUValue.contains("DEFAULT")) {
            Integer valueOf = Integer.valueOf(isuValue);
            Integer currentValue = Integer.valueOf(getValueinAutoChangeOverDiff());
            if (valueOf == currentValue) {
                flag = true;
            } else if (Integer.valueOf(isuValue) >= 0 && Integer.valueOf(isuValue) <= 5) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnIncreaseUpButton();
                        currentValue = Integer.valueOf(getValueinAutoChangeOverDiff());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnDecreaseDownButton();
                        currentValue = Integer.valueOf(getValueinAutoChangeOverDiff());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 0 to 5, User entered value is : "
                                + isuValue);
                flag = false;
            }
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Need to development this scenario");
            System.out.println("Need to developemnt for this scenario");

        }
        return flag;
    }

    public boolean clickOnISUDropDownButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ISUDropDownButton");
    }

    public boolean ISUAUXPerE_TerminalControl(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "DRIVE BOTH AUX AND E TOGETHER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxETerminalControlDriveBothAuxE");
            }
            case "AUX AND E ARE INDEPENDENT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "AuxETerminalControlDriveAuxEIndependent");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUAuxBackupHeat(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "ELECTRIC FORCED":
            case "ELECTRIC FORCED AIR":
            case "ELECTRIC": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxBackUpHeatElectricForced");
            }
            case "STANDARD EFFICIENCY GAS FORCED AIR":
            case "GAS FORCED AIR":
            case "GAS STANDARD": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxBackUpHeatStandardEfficiency");
            }
            case "HIGH EFFICIENCY GAS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxBackUpHeatHighEfficiency");
            }
            case "OIL FORCED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxBackUpHeatOilForced");
            }
            case "HOT WATER RADIANT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxBackUpHeatHotWaterRadiant");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUEmergencyHeat(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "ELECTRIC FORCED":
            case "ELECTRIC FORCED AIR":
            case "ELECTRIC": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatElectricForced");
            }
            case "STANDARD EFFICIENCY GAS FORCED AIR":
            case "GAS FORCED AIR":
            case "GAS STANDARD": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatStandardEfficiency");
            }
            case "HIGH EFFICIENCY GAS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatHighEfficiency");
            }
            case "OIL FORCED":
            case "OIL FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatOilForced");
            }
            case "HOT WATER RADIANT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatHotWaterRadiant");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUStagingControlHighCoolHeatStage(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NO": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
            }
            case "YES": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUStagingControlBackupHeatDifferential(String ISUValue) {

        boolean flag = false;
        String isuValue = ISUValue;
        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (ISUValue.toUpperCase().contains("COMFORT")) {
            // To enable this option need to have ID for the element
        } else {
            Integer valueOf = Integer.valueOf(isuValue);
            Integer currentValue = Integer.valueOf(getAuxBackUpHeatDifferential());
            if (Integer.valueOf(isuValue) <= 2 && Integer.valueOf(isuValue) >= 0) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnAuxHeatDifferentialIncreaseButton();
                        currentValue = Integer.valueOf(getAuxBackUpHeatDifferential());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnAuxHeatDifferentialDecreaseButton();
                        currentValue = Integer.valueOf(getAuxBackUpHeatDifferential());
                    }
                }
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 0,2 to 15, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUCompressorLockout(String ISUValue) {
        boolean flag = false;
        if (ISUValue.contains("DEG")) {
            ISUValue = ISUValue.replace("DEG", "°");
        }
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (getISUDropDownValue().toUpperCase().contains(ISUValue.toUpperCase())) {
            flag = true;
        } else {
            if (clickOnISUDropDownButton()) {
                if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                    flag = MobileUtils.isMobElementExists("XPATH",
                            "//*[contains(@content-desc,'" + getDropDownValuesByDefault(ISUValue) + "')]", testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@content-desc,'" + getDropDownValuesByDefault(ISUValue) + "')]");

                } else {
                    flag = MobileUtils.isMobElementExists("XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]", testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]");
                }
            } else {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
            }
        }
        return flag;
    }

    public boolean ISUBackUpHeatLockout(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            // need to develop this after the check ID is available till then only default
            // works
        }
        return flag;
    }

    public boolean ISUBackUpHeatCyclePerHour(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
            if (valueOf <= 12 && valueOf >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUAdaptiveIntelligentRecovery(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NO": {
                return clickOnNoButton();
            }
            case "YES": {
                return clickOnYesButton();
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUMinimumCoolSetPoint(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getMaxMinSetpointValue().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 90 || Integer.valueOf(ISUValue) >= 50) {
                while (!(valueOf == currentValue)) {

                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnMaxMinSetpointIncrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnMaxMinSetpointDecrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 50 to 90, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUMaximumCoolSetPoint(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getMaxMinSetpointValue().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 99 || Integer.valueOf(ISUValue) >= 50) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnMaxMinSetpointIncrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnMaxMinSetpointDecrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 50 to 99, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUMaximumHeatSetPoint(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getMaxMinSetpointValue().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 99 || Integer.valueOf(ISUValue) >= 50) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnMaxMinSetpointIncrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnMaxMinSetpointDecrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 50 to 90, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUMinimumHeatSetPoint(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getMaxMinSetpointValue().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 90 || Integer.valueOf(ISUValue) >= 40) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnMaxMinSetpointIncrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnMaxMinSetpointDecrease();
                        currentValue = Integer.valueOf(getMaxMinSetpointValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 40 to 90, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUNumberOfAirFilters(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilter1");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilter2");
            }
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilterNone");
            }
            default: {
                return false;
            }
        }

    }

    public boolean ISUBacklighting(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "ON DEMAND": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BacklightingOnDemand");
            }
            case "CONTINUOUS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BacklightingContinuous");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUIdleScreenSelection(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "MINIMUM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IdleScreenSelectionMinimum");
            }
            case "SETPOINT SHOWN ON IDLE SCREEN": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "IdleScreenSelectionSetpointShownonIdleScreen");
            }
            case "MAXIMUM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IdleScreenSelectionMaximum");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUIdleScreenCustomization(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "TIME": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IdleScreenCustomizationTime");
            }
            case "OUTDOOR TEMPERATURE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "IdleScreenCustomizationOutdoorTemperature");
            }
            case "OUTDOOR HUMIDITY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IdleScreenCustomizationOutdoorHumidity");
            }
            case "INDOOR HUMIDITY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IdleScreenCustomizationIndoorHumidity");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUHomeScreenCustomization(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "TIME": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeScreenCustomizationTime");
            }
            case "OUTDOOR TEMPERATURE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "HomeScreenCustomizationOutdoorTemperature");
            }
            case "OUTDOOR HUMIDITY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeScreenCustomizationOutdoorHumidity");
            }
            case "INDOOR HUMIDITY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HomeScreenCustomizationIndoorHumidity");
            }
            default: {
                return false;
            }
        }
    }

    public boolean ISUClockFormat(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "12 HOUR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "12HourFormat");
            }
            case "24 HOUR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "24HourFormat");
            }

            default: {
                return false;
            }
        }

    }

    public boolean ISUDayLightSavingTime(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "OFF": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOff");
            }
            case "ON": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOn");
            }

            default: {
                return false;
            }
        }

    }

    public boolean ISUTemperatureDisplayOffset(String ISUValue) {
        boolean flag = false;
        ISUValue = ISUValue.toUpperCase().replace(" ", "");
        if (ISUValue.contains("DEG")) {
            ISUValue = ISUValue.toUpperCase().replace("DEG", "°");
        } else if (ISUValue.toUpperCase().contains("OFF")) {
            ISUValue = "Off";
        }
        if (ISUValue.contains("F")) {
            ISUValue = ISUValue.toUpperCase().replace("F", "") + " " + "F";
        } else if (ISUValue.contains("C")) {
            ISUValue = ISUValue.toUpperCase().replace("C", "") + " " + "C";
        }

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            if (isISUDropDownButtonPresent()) {
                if (getISUDropDownValue().toUpperCase().contains(ISUValue.toUpperCase())) {
                    flag = true;
                } else if (!clickOnISUDropDownButton()) {
                    flag = false;
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
                }
            }
            if (!flag) {
                if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + ISUValue + "')]",
                            testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@content-desc,'" + ISUValue + "')]");
                } else {
                    flag = MobileUtils.isMobElementExists("XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]", testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]");
                }
            }
        }
        return flag;
    }

    public boolean ISUEmergencyHeatCyclePerHour(String ISUValue, int maxLimit) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
            if (valueOf <= 12 && valueOf >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUKeypadLockout(String ISUValue) {

        switch (ISUValue.toUpperCase()) {
            case "ENABLED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "KeypadLockoutEnabled");
            }
            case "DISABLED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "KeypadLockoutDisabled");
            }
            case "FULL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "KeypadLockoutFull");
            }
            default: {
                return false;
            }
        }

    }

    public boolean ISUFanOperationInHeat(String ISUValue) {

        switch (ISUValue.toUpperCase()) {
            case "EQUIPMENT CONTROLS FAN": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanOperationinHeatEquipmentControlsFan");
            }
            case "THERMOSTAT CONTROLS FAN": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "FanOperationinHeatThermostatControlsFan");
            }
            default: {
                return false;
            }
        }

    }

    public boolean setCyclePerHourForStage(String ISUValue, int maxLimit) {
        boolean flag = false;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getHeatCyclePerHourValue());
            if (currentValue == valueOf) {
                return true;
            }
            if (valueOf <= maxLimit) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public String getDropDownValuesByDefault(String isuValue) {
        isuValue = isuValue.toUpperCase();
        if (isuValue.contains("RUN TIME DAYS") || isuValue.contains("CALENDAR DAYS")
                || isuValue.contains("CALENDAR MONTHS")) {
            return isuValue.toLowerCase();
        } else if (isuValue.contains("MINUTES") || isuValue.contains("HOURS")) {
            return isuValue.toLowerCase();
        } else if (isuValue.contains("OFF")) {
            return "Off";
        } else {
            return isuValue;
        }
    }

    public boolean isCoolCyclePerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourScreen1", timeOut);
    }

    public boolean isBackupHeatSatgesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatSatgesScreen", timeOut);
    }

    public boolean isCoolSatgesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolSatgesScreen", timeOut);
    }

    public boolean cWireAdapter(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "YES":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "YesOption");
            case "NO":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoOption");
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean heatType(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "FORCED AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ForcedAir");
            case "RADIANT":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Radiant");
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean fuelSourceRetail(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "GAS":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Gas");

            case "ELECTRIC":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Electric");

            case "HOT WATER FAN COIL":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterFanCoil");

            case "OIL":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Oil");

            case "HOT WATER":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Hot Water");

            case "STEAM":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Steam");

            case "GAS HIGH EFFICIENCY":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "RetailHighEfficiency");

            case "GAS STANDARD EFFICIENCY":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Gas");

            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean efficiencyRetail(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "STANDARD EFFIECIENCY":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "RetailStandardEfficiency");

            case "HIGH EFFIECIENCY":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "RetailHighEfficiency");

            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating Efficiency, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean electricHeatStripsRetail(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "ELECTRIC HEAT STRIPS":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ElectricHeatStrips");

            case "GAS OR OIL FURNACE":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Need to update");

            case "ELECTRIC FORCED AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ElectricForcedAir");

            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heat Pump Backup Heat, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public String getCheckConfigurationRetailContnt() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CheckConfigurationContent")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CheckConfigurationContent")
                    .getDomAttribute("name");

        }
        return getText;
    }

    public boolean verificationHPRetail(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "WARM AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WarmAir");

            case "COOL AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "CoolAir");

            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Verification of Air, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean isCWireAdapterScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isCWireAdapterScreen", timeOut);
    }

    public boolean isHeatTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatTypeScreen", timeOut);
    }

    public boolean isFuelSourceScreenRetail(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FuelSourceScreenRetail", timeOut);
    }

    public boolean isEfficiencyScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "EfficiencyScreen", timeOut);
    }

    public boolean isBackupHeatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatScreen", timeOut);
    }

    public boolean isCheckConfigurationScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CheckConfiguration", timeOut);
    }

    public boolean isVerificationScreenAvailable(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "VerificationScreen", timeOut);
    }

    public boolean isOneMoreStepScreenAvailable(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "MoreStepScreen", timeout);
    }

    public boolean isAdvancedSetupBtnPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AdvancedSetupBtn");
    }

    public boolean clickOnAdvancedSetupBtn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AdvancedSetupBtn");
    }

    public boolean verificationRetail(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "WARM AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WarmAir");
            case "COOL AIR":
                return MobileUtils.clickOnElement(objectDefinition, testCase, "CoolAir");
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Verification of Air, User Expected ISU Value is :"
                                + ISUValue);
                return false;
        }
    }

    public boolean isConnectAppScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectAppScreen");
    }

    public boolean isCheckDisplayScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CheckDisplayScreen");
    }

    public boolean isHeatingSystemScreenRch(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingSystemScreenRch", timeOut);
    }

    public boolean iSUCooling_HeatingStagesRCH(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatCoolStageNone");
            }
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatCoolStageOne");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatCoolStageTwo");
            }
            default:
                return false;
        }
    }

    public boolean isRadiantHeatStagesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingStageScreen", timeOut);
    }

    public boolean ISURadiantHeatStages(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage1");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Stage2");
            }
            default:
                return false;
        }
    }

    public boolean isRadiantHeatCyclesPerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage1Screen", timeOut);
    }

    public boolean ISURadiantHeatCyclesPerHour_Stage1(String ISUValue, int maxLimit) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (getHeatCyclePerHourValue().contains(ISUValue)) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getHeatCyclePerHourValue());
            if (currentValue == valueOf) {
                return true;
            }
            if (valueOf <= maxLimit) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean clickOnBackupHeatUpstageIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "UpstageTimerIncreaseButton");
    }

    public boolean clickOnBackupHeatUpstageDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "UpstageTimerDecreaseButton");
    }

    public int getCurrentBackUpHeatUpStageTimer() {
        try {
            String currentValue = null;
            if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                currentValue = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentUpstageTimerValue")
                        .getDomAttribute("content-desc");
            } else {
                currentValue = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentUpstageTimerValue")
                        .getDomAttribute("name");
            }
            if (currentValue.equalsIgnoreCase("Off")) {
                return 0;
            }
            try {
                int numericValue = Integer.parseInt(currentValue);
                return numericValue <= 90 ? numericValue : numericValue * 60;
            } catch (NumberFormatException e) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to parse the current Backup Heat Upstage Timer value: " + currentValue);
                return -1;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred while getting current timer value: " + e.getMessage());
            return -1;
        }
    }

    public boolean ISUBackUpHeatUpStageTimer(String ISUValue) {
        boolean flag = false;
        try {
            int targetValueInMinutes = -1;
            if (ISUValue.toUpperCase().contains("DEFAULT")) {
                return true;
            } else if (ISUValue.equalsIgnoreCase("OFF")) {
                targetValueInMinutes = 0;
            } else if (ISUValue.contains("MINUTES")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.replace("MINUTES", "").replace("MINUTE", "").trim());
            } else if (ISUValue.contains("MINUTE")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.replace("MINUTE", "").trim());
            } else if (ISUValue.contains("HOURS")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.replace("HOURS", "").trim()) * 60;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Invalid format for ISUValue: " + ISUValue);
                return false;
            }
            int currentValueInMinutes = getCurrentBackUpHeatUpStageTimer();

            if (currentValueInMinutes < 0 || targetValueInMinutes < 0) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Invalid current or target value: Current - " + currentValueInMinutes + ", Target - "
                                + targetValueInMinutes);
                return false;
            }
            while (currentValueInMinutes != targetValueInMinutes) {
                if (currentValueInMinutes < targetValueInMinutes) {
                    flag = clickOnBackupHeatUpstageIncreaseButton();
                } else {
                    flag = clickOnBackupHeatUpstageDecreaseButton();
                }
                currentValueInMinutes = getCurrentBackUpHeatUpStageTimer();
            }
            if (currentValueInMinutes == targetValueInMinutes) {
                Keyword.ReportStep_Pass(testCase, "Successfully set Backup Heat Upstage Timer to: " + ISUValue);
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to set Backup Heat Upstage Timer to: " + ISUValue);
                flag = false;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred while setting Backup Heat Upstage Timer: " + e.getMessage());
            flag = false;
        }

        return flag;
    }

    public boolean ISULockOutFanAfterCoolCall(String ISUValue) {
        boolean flag = false;
        try {
            int targetValueInMinutes = -1;
            if (ISUValue.toUpperCase().contains("OFF")) {
                targetValueInMinutes = 0;
            } else if (ISUValue.toUpperCase().contains("MINUTES")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.replace("MINUTES", "").replace("MINUTE", "").trim());
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Invalid ISU Value provided: " + ISUValue);
                return false;
            }
            if (targetValueInMinutes < 0 || targetValueInMinutes > 120) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "ISU Value is out of bounds. It must be between Off (0) and 120 Minutes.");
                return false;
            }
            int currentValueInMinutes = getCurrentLockOutFanValueInMinutes();
            if (currentValueInMinutes < 0) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to retrieve the current value for Lockout Fan After Cool Call.");
                return false;
            }
            while (currentValueInMinutes != targetValueInMinutes) {
                if (currentValueInMinutes < targetValueInMinutes) {
                    flag = clickOnLockOutFanIncreaseButton();
                    currentValueInMinutes = getCurrentLockOutFanValueInMinutes();
                } else if (currentValueInMinutes > targetValueInMinutes) {
                    flag = clickOnLockOutFanDecreaseButton();
                    currentValueInMinutes = getCurrentLockOutFanValueInMinutes();
                }
            }
            if (currentValueInMinutes == targetValueInMinutes) {
                Keyword.ReportStep_Pass(testCase, "Successfully set the Lockout Fan After Cool Call to: " + ISUValue);
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to set the Lockout Fan After Cool Call to: " + ISUValue);
                flag = false;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "An exception occurred while setting the Lockout Fan After Cool Call: " + e.getMessage());
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public int getCurrentLockOutFanValueInMinutes() {
        try {
            String currentValue = null;
            if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                currentValue = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentLockOutFanValueInMinutes")
                        .getDomAttribute("content-desc");
            } else {
                currentValue = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentLockOutFanValueInMinutes")
                        .getDomAttribute("name");

            }
            if (currentValue.equalsIgnoreCase("Off")) {
                return 0;
            } else {
                return Integer.parseInt(currentValue);
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "An exception occurred while retrieving the current value: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public boolean clickOnLockOutFanIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "LockOutFanIncreaseButton");
    }

    public boolean clickOnLockOutFanDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "LockOutFanDecreaseButton");
    }

    public boolean ISUCompressorCyclesPerHour_Stage(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (getCurrentCompressorCyclesValue().contains(ISUValue)) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
            if (valueOf <= 12 && valueOf >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should be between 1 to 6, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public String getCurrentCompressorCyclesValue() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentCompressorCyclesValue")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentCompressorCyclesValue")
                    .getDomAttribute("name");
        }
    }

    public boolean clickOnCompressorMinOffTimeIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorMinOffTimeIncreaseButton");
    }

    public boolean clickOnCompressorMinOffTimeDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorMinOffTimeDecreaseButton");
    }

    public boolean ISUCompressorMinimumOffTime(String ISUValue) {
        boolean flag = false;
        int targetValue = -1;
        try {
            if (ISUValue.toUpperCase().contains("DEFAULT")) {
                Keyword.ReportStep_Pass(testCase, "Default value is accepted.");
                return true;
            } else if (ISUValue.toUpperCase().contains("OFF")) {
                targetValue = 0;
            } else if (ISUValue.toUpperCase().matches(".*\\d+.*")) {
                targetValue = Integer.parseInt(ISUValue.replaceAll("[^\\d]", ""));
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Invalid format for ISUValue: " + ISUValue);
                return false;
            }
            int currentValue = getCurrentCompressorMinOffTimeValue();
            if (targetValue < 0 || targetValue > 5) {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Invalid ISU Value: " + ISUValue + ". Supported values are Off, 1 Minute to 5 Minutes.");
                return false;
            }

            while (currentValue != targetValue) {
                if (currentValue < targetValue) {
                    flag = clickOnCompressorMinOffTimeIncreaseButton();
                } else if (currentValue > targetValue) {
                    flag = clickOnCompressorMinOffTimeDecreaseButton();
                }
                currentValue = getCurrentCompressorMinOffTimeValue();
                if (!flag) {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                            "Failed to adjust the value to " + ISUValue);
                    return false;
                }
            }

            if (currentValue == targetValue) {
                Keyword.ReportStep_Pass(testCase, "Successfully set the Compressor Minimum Off Time to: " + ISUValue);
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to set the Compressor Minimum Off Time to: " + ISUValue);
                flag = false;
            }
        } catch (NumberFormatException e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Failed to parse numeric value from ISUValue: " + ISUValue + ". Exception: " + e.getMessage());
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred while setting Compressor Minimum Off Time: " + e.getMessage());
            flag = false;
        }
        return flag;
    }

    public int getCurrentCompressorMinOffTimeValue() {
        String currentValueText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            currentValueText = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentCompressorMinOffTimeValue")
                    .getDomAttribute("content-desc");
        } else {
            currentValueText = MobileUtils.getMobElement(objectDefinition, testCase, "CurrentCompressorMinOffTimeValue")
                    .getDomAttribute("name");

        }
        if (currentValueText.equalsIgnoreCase("Off")) {
            return 0;
        } else {
            return Integer.parseInt(currentValueText);
        }
    }

    public boolean ISUAirFilterReplacementReminder(String ISUValue) {
        boolean flag = false;
        int targetValueInMinutes = -1;
        int currentValueInMinutes = -1;

        try {
            if (ISUValue.toUpperCase().contains("DEFAULT")) {
                Keyword.ReportStep_Pass(testCase, "Default value is accepted.");
                return true;
            }
            if (ISUValue.contains("OFF")) {
                targetValueInMinutes = 0;
            } else if (ISUValue.contains("RUN TIME DAYS")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.split(" ")[0]);
            } else if (ISUValue.contains("CALENDAR DAYS")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.split(" ")[0]) * 24 * 60;
            } else if (ISUValue.contains("CALENDAR MONTHS")) {
                targetValueInMinutes = Integer.parseInt(ISUValue.split(" ")[0]) * 30 * 24 * 60;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Invalid ISU Value: " + ISUValue);
                return false;
            }
            currentValueInMinutes = getCurrentAirFilterValueInMinutes();

            while (currentValueInMinutes != targetValueInMinutes) {
                if (currentValueInMinutes < targetValueInMinutes) {
                    if (!clickOnAirFilterIncreaseButton()) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Failed to click on the increase button.");
                        return false;
                    }
                } else if (currentValueInMinutes > targetValueInMinutes) {
                    if (!clickOnAirFilterDecreaseButton()) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Failed to click on the decrease button.");
                        return false;
                    }
                }
                currentValueInMinutes = getCurrentAirFilterValueInMinutes();
            }
            if (currentValueInMinutes == targetValueInMinutes) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully set Air Filter Replacement Reminder to: " + ISUValue);
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Failed to set Air Filter Replacement Reminder to: " + ISUValue);
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Exception occurred while setting Air Filter Replacement Reminder: " + e.getMessage());
            e.printStackTrace();
        }

        return flag;
    }

    public int getCurrentAirFilterValueInMinutes() {
        String currentFilterLabel = "";
        String currentFilterValue = getCurrentAirFilterValue();
        if (!currentFilterValue.toUpperCase().contains("OFF")) {
            currentFilterLabel = getCurrentAirFilterLabel();
        }
        if (currentFilterValue.equalsIgnoreCase("OFF")) {
            return 0;
        } else if (currentFilterLabel.equalsIgnoreCase("RUN TIME DAYS")) {
            return Integer.parseInt(currentFilterValue);
        } else if (currentFilterLabel.equalsIgnoreCase("CALENDAR DAYS")) {
            return Integer.parseInt(currentFilterValue) * 24 * 60;
        } else if (currentFilterLabel.equalsIgnoreCase("CALENDAR MONTHS")) {
            return Integer.parseInt(currentFilterValue) * 30 * 24 * 60;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Invalid current value retrieved: " + currentFilterValue + " " + currentFilterLabel);
            return -1;
        }
    }

    public String getCurrentAirFilterValue() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentAirFilterRemiderValue")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentAirFilterRemiderValue")
                    .getDomAttribute("name");

        }
    }

    public String getCurrentAirFilterLabel() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentLabelAirFilterReminder")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentLabelAirFilterReminder")
                    .getDomAttribute("name");

        }
    }

    public boolean clickOnAirFilterIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilterIncreaseButton");
    }

    public boolean clickOnAirFilterDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilterDecreaseButton");
    }

    public boolean ISUBackLightBrightness(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (getCurrentBackLightBrightnessValue().contains(ISUValue)) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getCurrentBackLightBrightnessValue());
            if (valueOf <= 5 && valueOf >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = clickOnBackLightBrightnessIncrease();
                        currentValue = Integer.valueOf(getCurrentBackLightBrightnessValue());
                    } else if (valueOf < currentValue) {
                        flag = clickOnBackLightBrightnessDecrease();
                        currentValue = Integer.valueOf(getCurrentBackLightBrightnessValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should be between 1 to 6, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public String getCurrentBackLightBrightnessValue() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentBackLightBrightnessValue")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentBackLightBrightnessValue")
                    .getDomAttribute("name");

        }
    }

    public boolean clickOnBackLightBrightnessIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackLightBrightnessIncreaseButton");
    }

    public boolean clickOnBackLightBrightnessDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackLightBrightnessDecreaseButton");
    }

    public boolean isCoolCyclePerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesPerHourScreen2", timeOut);
    }

    public boolean isInvalidWiring(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "InvalidWiring", timeOut);
    }

    public boolean clickOnManuallyEnterWires() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ManuallyEnterWires");
    }

    public boolean clickOnAL_A() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireAL_A");
    }

    public boolean clickOnR() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireR");
    }

    public boolean clickOnC() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireC");
    }

    public boolean clickOnRc() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireRc");
    }

    public boolean clickOnOB() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireOB");
    }

    public boolean clickOnY2() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireY2");
    }

    public boolean clickOnY1() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireY1");
    }

    public boolean clickOnK() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireK");
    }

    public boolean clickOnW2() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireW2");
    }

    public boolean clickOnG() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireG");
    }

    public boolean clickOnW() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireW");
    }

    public boolean clickOnE() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WireE");
    }

    public boolean clickOnValidateWiringBtn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ValidateWiringBtn");
    }

    public boolean isWiresAreValid(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "WiresAreValid", timeOut);
    }

    public boolean isValidatingCombination(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ValidatingCombination", timeOut);
    }

    public boolean clickOnDenaliRetailThermostat() {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        if (navigateTo.scrollToExpectedElement("DenaliThermostat")) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "DenaliThermostat");
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to scroll to Fuji Thermostat element.");
            return false;
        }
    }

    public boolean isConnected() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isConnected", 1);
    }

    public boolean completeRegisteration() {
        boolean flag = false;
        FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
        fWait.pollingEvery(Duration.ofSeconds(1));
        fWait.withTimeout(Duration.ofMinutes(3));
        try {
            Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (isRegistering()) {
                            System.out.println("Registering device .....");
                            return false;
                        } else
                            return isSetupCompleteScreen();
                    } catch (StaleElementReferenceException e) {
                        Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
                        return false;
                    } catch (TimeoutException e) {
                        Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
                        return false;
                    } catch (StackOverflowError e) {
                        Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
                        return false;
                    } catch (NoSuchElementException e) {
                        Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
                        return false;
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able to login or might need to check the app flow");
                        return false;
                    }
                }
            });

            if (success) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "SucessFully Identificed stat maci ID in discovered Devices screen");
            } else {
                flag = false;
            }

        } catch (StaleElementReferenceException e) {
            Keyword.ReportStep_Pass(testCase, "Stale element reference exceotion, skipping for retry..");
            flag = false;
        } catch (TimeoutException e) {
            Keyword.ReportStep_Pass(testCase, "Timeout exceotion, skipping for retry..");
            flag = false;
        } catch (StackOverflowError e) {
            Keyword.ReportStep_Pass(testCase, "Stackover flow exceotion, skipping for retry..");
            flag = false;
        } catch (NoSuchElementException e) {
            Keyword.ReportStep_Pass(testCase, "no such element exceotion, skipping for retry..");
            flag = false;
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Ble not able to identify exact mac ID");
            flag = false;
        }
        flag = flag && ClickOnDoneButton();
        return flag;
    }

    public boolean isRegistering() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isRegisteringDevice", 3);
    }

    public boolean isSetupCompleteScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isSetupCompleteScreen", 3);
    }

    public boolean isConnectAppStepsDenaliScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectAppStepsDenaliScreen", 2);
    }

    public boolean isExtendedFanRunTimeInHeatScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExtendedFanRunTimeInHeatScreen", 2);
    }

    public boolean selectExtendeFanRunTimeInHEatFromDrpDwn(String ISUValue) {
        boolean flag = false;
        String ExistingDrpDwnValue = getExtendedFanRunTimeInHeatDrpDwnValue().toUpperCase();
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = ExistingDrpDwnValue.contains("5 MINUTES");
        } else if (ExistingDrpDwnValue.contains(ISUValue.toUpperCase())) {
            flag = true;
        } else {
            if (clickOnExtendedFanRunTimeInHeatDrpDwn()) {
                String DrpDwnVal = getCurrentDrpDwnValForExtendedFanRunTimeInHeat(ISUValue);
                if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + DrpDwnVal + "')]",
                            testCase, 3);
                    if (flag) {
                        flag = MobileUtils.clickOnElement(testCase, "XPATH",
                                "//*[contains(@content-desc,'" + DrpDwnVal + "')]");
                    } else {
                        // if(ExistingDrpDwnValue.contains("OFF")) {
                        // ExistingDrpDwnValue="0";
                        // }
                        // if(Integer.parseInt(ExistingDrpDwnValue)< Integer.parseInt(DrpDwnVal)) {
                        // NavigatingScreenToScreeninFA navigateTo = new
                        // NavigatingScreenToScreeninFA(testCase);
                        // if (navigateTo.scrollToExpectedElement("FujiThermostat","")) {
                        //
                        // }
                        // //Scroll down
                        // }else if(Integer.parseInt(ExistingDrpDwnValue)> Integer.parseInt(DrpDwnVal))
                        // {
                        // //Scroll up
                        // }
                    }
                    // flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                    // "//*[contains(@content-desc,'" + DrpDwnVal + "')]");

                } else {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + DrpDwnVal + "')]", testCase,
                            3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@name,'" + DrpDwnVal + "')]");
                }
            } else {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
            }
        }
        return flag;
    }

    public String getCurrentDrpDwnValForExtendedFanRunTimeInHeat(String time) {
        time = time.toUpperCase().split("SECONDS")[0].trim().split("MINUTES")[0].trim();
        if (time.contains("OFF")) {
            return time.toLowerCase();
        } else if (Integer.parseInt(time) <= 16) {
            return time + " minutes";
        } else if (Integer.parseInt(time) == 30 || Integer.parseInt(time) == 60 || Integer.parseInt(time) == 90) {
            return time + " seconds";
        } else {
            return null;
        }
    }

    public boolean clickOnExtendedFanRunTimeInHeatDrpDwn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeatDrpDwn");
    }

    public String getExtendedFanRunTimeInHeatDrpDwnValue() {
        String val;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            val = MobileUtils.getMobElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeatDrpDwn")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        } else {
            val = MobileUtils.getMobElement(objectDefinition, testCase, "ExtendedFanRunTimeInHeatDrpDwn")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        }
        return val;
    }

    public boolean isAirFilterTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AirFilterTypeScreen", 2);
    }

    public boolean selectAirFilterType(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneInAirFilterType");
            }
            case "MEDIA": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "MediaInAirFilterType");
            }
            case "ELECTRONIC AIR CLEANER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ElectronicAirCleanerInAirFilterType");
            }
            default:
                return false;
        }
    }

    public boolean isHumidificationPadReplacementReminderScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HumPadReplacementRemScreen", 2);
    }

    public boolean selectHumPadReplReminder(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "OFF": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "isAirFilter1ReplacementReminderValueRch");
            }
            case "6 CALENDER MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "SixCalMonths");
            }
            case "12 CALENDER MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "TwelveCalMonths");
            }
            default:
                return false;
        }
    }

    public boolean isDehumFilterReplReminderScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DehumFilReplRemScreen", 2);
    }

    public boolean selectDehumFilterReplReminder(String ISUValue) {
        boolean flag = false;
        String ExistingDrpDwnValue = getExistingValOfDehumFilterReplRemDrpDwn().toUpperCase();
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (ExistingDrpDwnValue.toUpperCase().contains(ISUValue.toUpperCase())) {
            flag = true;
        } else {
            if (clickOnDehumFilterReplReminderDrpDwn()) {
                String DrpDwnVal = getDehumFilterReplRemDrpDwnValValue(ISUValue);
                if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + DrpDwnVal + "')]",
                            testCase, 3);
                    if (flag) {
                        flag = MobileUtils.clickOnElement(testCase, "XPATH",
                                "//*[contains(@content-desc,'" + DrpDwnVal + "')]");
                    } else {
                        // if(ExistingDrpDwnValue.contains("OFF")) {
                        // ExistingDrpDwnValue="0";
                        // }
                        // if(Integer.parseInt(ExistingDrpDwnValue)< Integer.parseInt(DrpDwnVal)) {
                        // NavigatingScreenToScreeninFA navigateTo = new
                        // NavigatingScreenToScreeninFA(testCase);
                        // if (navigateTo.scrollToExpectedElement("FujiThermostat","")) {
                        //
                        // }
                        // //Scroll down
                        // }else if(Integer.parseInt(ExistingDrpDwnValue)> Integer.parseInt(DrpDwnVal))
                        // {
                        // //Scroll up
                        // }
                    }
                    // flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                    // "//*[contains(@content-desc,'" + DrpDwnVal + "')]");

                } else {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + DrpDwnVal + "')]", testCase,
                            3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@name,'" + DrpDwnVal + "')]");
                }
            } else {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
            }
        }
        return flag;
    }

    private boolean clickOnDehumFilterReplReminderDrpDwn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "DehumFilterReplReminderDrpDwn");
    }

    public String getExistingValOfDehumFilterReplRemDrpDwn() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "DehumFilterReplReminderDrpDwn")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "DehumFilterReplReminderDrpDwn")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        }
    }

    public String getDehumFilterReplRemDrpDwnValValue(String iSUValue) {
        iSUValue = iSUValue.toUpperCase().split("CALENDER DAYS")[0].trim().split("CALENDER MONTHS")[0].trim();
        if (iSUValue.contains("OFF")) {
            return iSUValue.toLowerCase();
        } else if (Integer.parseInt(iSUValue) > 2 && Integer.parseInt(iSUValue) <= 12) {
            return iSUValue + " Calendar Months";
        } else if (Integer.parseInt(iSUValue) == 30 || Integer.parseInt(iSUValue) == 60) {
            return iSUValue + " Calendar Days";
        } else {
            return null;
        }
    }

    public boolean isVentilationTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentilationTypeScreen", 2);
    }

    public boolean selectVentilationType(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneInAirFilterType");
            }
            case "ERV/HRV": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ErvHrvOption");
            }
            case "PASSIVE":
            case "FAN ONLY":
            case "PASSIVE(FAN ONLY)": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "PassiveFanOnlyOption");
            }
            case "FRESH AIR DAMPER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FreshAirDamperOption");
            }
            default:
                return false;
        }
    }

    public boolean isVentFilterCleaningRemScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "VentFilterCleaningRemScreen", 2);
    }

    public boolean selectVentFilterCleaningReminder(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "OFF": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "isAirFilter1ReplacementReminderValueRch");
            }
            case "3 CALENDAR MONTHS":
            case "3 MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ThreeMonthCal");
            }
            case "6 CALENDAR MONTHS":
            case "6 MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "SixMonthCal");
            }
            case "9 CALENDAR MONTHS":
            case "9 MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NineMonthCal");
            }
            case "12 CALENDAR MONTHS":
            case "12 MONTHS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "TwelveMonthCal");
            }
            default:
                return false;
        }
    }

    public boolean isUVDevicesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "UVDeviceScreen", 2);
    }

    public boolean selectUvDevices(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "0": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "UVValue0");
            }
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "UVValue1");
            }
            case "2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "UVValue2");
            }
            default:
                return false;
        }
    }

    public boolean setLanguage(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "ENGLISH": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "LanguageEnglish");
            }
            case "ESPANOL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "LanguageEspanol");
            }
            case "NEDERLANDS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "LanguageNederlands");
            }
            default:
                return false;
        }
    }

    public boolean selectHumidifierType(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HumTypeNone");
            }
            case "STEAM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HumTypeSteam");
            }
            case "BYPASS":
            case "FAN POWER":
            case "BYPASS OR FAN POWER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HumTypeBypassorPoweed");
            }
            default:
                return false;
        }
    }

    public boolean selectDehumidifierType(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DehumTypeNone");
            }
            case "A/C WITH HIGH SPEED FAN": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DehumTypeACwithFan");
            }
            case "WHOLE HOUSE DEHUMIDIFIER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DehumTypeWholeHouseDehum");
            }
            default:
                return false;
        }
    }

    public boolean selectDrpDwnForIndoorHumidityOffset(String ISUValue) {
        boolean flag = false;
        if (ISUValue.contains("%")) {
            ISUValue = ISUValue.replace("%", "");
        }
        if (getIndoorHumOffsetDropDownValue().toUpperCase().contains(ISUValue.toUpperCase())) {
            flag = true;
        } else {
            if (clickOnISUDropDownButton()) {
                if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
                    flag = MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + ISUValue + "')]",
                            testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@content-desc,'" + ISUValue + "')]");
                } else {
                    flag = MobileUtils.isMobElementExists("XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]", testCase, 3);
                    flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                            "//*[contains(@name,'" + getDropDownValuesByDefault(ISUValue) + "')]");
                }
            } else {
                flag = false;
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
            }
        }
        return flag;
    }

    public String getIndoorHumOffsetDropDownValue() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "IndoorHumOffsetDropDownValue")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "IndoorHumOffsetDropDownValue")
                    .getDomAttribute("resource-id").replace("ISU", "").replace("_", "").trim();
        }
    }

    public boolean isLanguageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "LanguageScreen", 2);
    }

    public boolean isHumidifierTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HumidifierTypeScreen", 2);
    }

    public boolean isDehumidifierTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DehumidifierTypeScreen", 2);
    }

    public boolean isIndoorHumidityOffsetScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorHumidityOffsetScreen", 2);
    }

    public boolean isWireSelected(String wire) {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        if (navigateTo.scrollToExpectedElement("XPATH", "(//android.view.View[@content-desc='" + wire + "']/*)[1]")) {
            return MobileUtils.isMobElementExists("XPATH",
                    "//android.view.View[@content-desc='" + wire + "']/android.widget.ImageView", testCase, 1);
        }
        return false;
    }

    public boolean isDeviceNameDisplayingOnDashBoard() {
        // String deviceName =
        // testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");
        String deviceName = SystemState.getStatus().getTstatName();
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("xpath",
                    "(//*[contains(@content-desc,'" + deviceName + "') ])[last()]", testCase);
        } else {
            return MobileUtils.isMobElementExists("xpath", "(//*[contains(@name,'" + deviceName + "') ])[last()]",
                    testCase);
        }
    }

    public boolean isDeleteErrorPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DeleteErrorPopUp", 2);
    }

    public boolean isManuallyEnterWiresPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ManuallyEnterWires", 3);
    }

    public boolean isRegisteredandConnectedToWIFIScreen(int i) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "RegisteredandConnectedToWIFI", 3);
    }

    public boolean checkForNoThermostatFoundBlePopUp(int noOfRetry) {
        int cnt = 0;
        boolean flag = false;
        try {
            do {
                if (isNoThermostatFoundBlePopUp()) {
                    clickOnTryAgainButton();
                    clickOnYesButton();
                    cnt++;
                    flag = true;
                }
            } while ((flag && cnt < noOfRetry));
            if (flag) {
                Thread.sleep(35000);
                flag = isNoThermostatFoundBlePopUp();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean selectIndoorAirQualityEquipment(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorAirTypeNone");
            }
            case "HUMIDIFIER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HumidifierOpt");
            }
            case "DEHUMIDIFIER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DehumidifierOpt");
            }
            case "VENTILATOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "VentilatorOpt");
            }
            default:
                return false;
        }
    }

    public boolean isIndoorAirQualityEquipmentScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorAirQualityEquipmentScreen", 2);
    }

    public boolean isSettingsIconPresent() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//android.widget.ImageView", testCase);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//XCUIElementTypeButton", testCase);
        }
    }

    public boolean isWifiErrorPopupExists(int timeout) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "WifiInvalidPINErrorPopup", timeout);
    }

    public String getTextOfWifiErrorMessage() {
        return MobileUtils.getMobElement(objectDefinition, testCase, "WifiInvalidPINErrorMessage")
                .getDomAttribute("content-desc");
    }

    public WebElement WifiInvalidPINErrorMessage() {
        return MobileUtils.getMobElement(objectDefinition, testCase, "WifiInvalidPINErrorMessage");
    }

    public boolean clickWifiPasswordTryAgainButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "WifiPasswordTryAgainButton");
    }

    public String WiFiErrorMessage() {
        return "Make sure password is entered correctly";
    }

    public boolean isConnectionFailedPopUp(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ConnectionFailed", 2);
    }

    public boolean isApplicationtScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ApplicationtScreen");
    }

    public boolean selectApplication(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "RESIDENTIAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Residential");
            }
            case "COMMERCIAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Commercial");
            }
            default:
                return false;
        }
    }

    public boolean selectFloorSensor(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NO": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FloorSensorNO");
            }
            case "WIRED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FloorSensorWired");
            }
            default:
                return false;
        }
    }

    public boolean isFloorSensorScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorSensorScreen", 2);
    }

    public boolean isBackupHeatTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "isBackupHeatScreen");
    }

    public boolean selectBackupHeatTypeScreen(String iSUValue) {
        if (clickOnBackupHeatingSystemDrpDwn()) {
            switch (iSUValue.toUpperCase()) {
                case "NONE": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "HumTypeNone");
                }
                case "STANDARD EFFICIENCY GAS FORCED AIR": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "StandardEffGasForcedAir");
                }
                case "HIGH EFFICIENCY GAS FORCED AIR": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "HighEffGasForcedAir");
                }
                case "OIL FORCED AIR": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "OilForcedAir");
                }
                case "HOT WATER FAN COIL": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterFanCoil");
                }
                case "HOT WATER RADIANT HEAT": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantHeat");
                }
                case "OTHER": {
                    return MobileUtils.clickOnElement(objectDefinition, testCase, "Other");
                }
                default:
                    Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                            "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                    + iSUValue);
                    return false;
            }
        }
        return false;

    }

    public boolean clickOnBackupHeatingSystemDrpDwn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatTypeDrpDwn");
    }

    public boolean isExtendedFanRunTimeInCoolScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatTypeScreen");
    }

    public boolean selectYesOrNo(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "YES": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "YesButton");
            }
            case "NO": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoButton");
            }
            default:
                return false;
        }
    }

    public boolean isIndoorHumidityScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorHumidityScreen");
    }

    public boolean ISUHeatingSystemFromDrpDwn(String iSUValue) {
        // if (clickOnHeatingSystemDrpDwn()) {
        switch (iSUValue.toUpperCase()) {
            case "CONVENTIONAL FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalForcedAir");
            }
            case "HEAT PUMP": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPump");
            }
            case "BOILER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Boiler");
            }
            case "OTHER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Other");
            }
            case "NONE COOL ONLY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoneCoolOnly");
            }
            case "FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoil");
            }
            case "PACKAGED TERMINAL AIR CONDITIONER (PTAC)": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "PTAC");
            }
            case "RADIANT HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "RadiantHeat");
            }
            default:
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Heating System, User Expected ISU Value is :"
                                + iSUValue);
                return false;
        }
        // }
        // return false;
    }

    private boolean clickOnHeatingSystemDrpDwn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatingSystemDrpDwn");
    }

    public boolean isOccupancySensingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "OccupancySensingScreen");
    }

    public boolean selectTemperatureBalancing(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "OFF": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOff");
            }
            case "ON": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DayLightSavingOn");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isTemperatureBalancingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "TemperatureBalancingScreen");
    }

    public boolean isWiredSensorsScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "WiredSensorsScreen");
    }

    public boolean selectWiredSensors(String iSUValue) {
        boolean flag = true;
        try {
            if (iSUValue.contains("INDOOR AIR TEMPERATURE")) {
                if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorAirTemperatureChecked", 1)) {
                    flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorAirTemperature");
                    flag = flag && MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "IndoorAirTemperatureChecked", 1);
                }
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "IndoorAirTemperatureChecked", 1)) {
                    flag = MobileUtils.clickOnElement(objectDefinition, testCase, "IndoorAirTemperature");
                    flag = flag && !MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "IndoorAirTemperatureChecked", 1);
                }
            }
            if (iSUValue.contains("RETURN AIR TEMPERATURE SENSOR")) {
                if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "ReturnAirTemperatureSensorChecked",
                        1)) {
                    flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "ReturnAirTemperatureSensor");
                    flag = flag && MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "ReturnAirTemperatureSensorChecked", 1);
                }
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ReturnAirTemperatureSensorChecked",
                        1)) {
                    flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "ReturnAirTemperatureSensor");
                    flag = flag && !MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "ReturnAirTemperatureSensorChecked", 1);
                }
            }
            if (iSUValue.contains("DISCHARGE AIR TEMPERATURE SENSOR")) {
                if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "DischargeAirTemperatureSensorChecked",
                        1)) {
                    flag = flag
                            && MobileUtils.clickOnElement(objectDefinition, testCase, "DischargeAirTemperatureSensor");
                    flag = flag && MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "DischargeAirTemperatureSensorChecked", 1);
                }
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "DischargeAirTemperatureSensorChecked",
                        1)) {
                    flag = flag
                            && MobileUtils.clickOnElement(objectDefinition, testCase, "DischargeAirTemperatureSensor");
                    flag = flag && !MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "DischargeAirTemperatureSensorChecked", 1);
                }
            }
            if (iSUValue.contains("FLOOR TEMPERATURE SENSOR")) {
                if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorTemSensorChecked", 1)) {
                    flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "FloorTemSensor");
                    flag = flag
                            && MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorTemSensorChecked", 1);
                }
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorTemSensor", 1)) {
                    if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorTemSensorChecked", 1)) {
                        flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "FloorTemSensor");
                        flag = flag && !MobileUtils.isMobElementExists(objectDefinition, testCase,
                                "FloorTemSensorChecked", 1);
                    }
                }
            }
            if (iSUValue.contains("FAN COIL CHANGEOVER TEMPERATURE SENSOR")) {
                if (!MobileUtils.isMobElementExists(objectDefinition, testCase,
                        "FanCoilChangeoverTemperatureSensorChecked", 1)) {
                    flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase,
                            "FanCoilChangeoverTemperatureSensor");
                    flag = flag && MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "FanCoilChangeoverTemperatureSensorChecked", 1);
                }
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilChangeoverTemperatureSensor",
                        1)) {
                    if (MobileUtils.isMobElementExists(objectDefinition, testCase,
                            "FanCoilChangeoverTemperatureSensorChecked", 1)) {
                        flag = MobileUtils.clickOnElement(objectDefinition, testCase,
                                "FanCoilChangeoverTemperatureSensor");
                        flag = flag && !MobileUtils.isMobElementExists(objectDefinition, testCase,
                                "FanCoilChangeoverTemperatureSensorChecked", 1);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isFreezeProtectionScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FreezeProtectionScreen");
    }

    public boolean isDryContacts1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DryContacts1Screen");
    }

    public boolean isDryContacts2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DryContacts2Screen");
    }

    public boolean selectDryContacts1(String iSUValue) {
        boolean flag = true;
        if (iSUValue.contains("FULL DRAIN PAN ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "FullDrainPanAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "FullDrainPanAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FullDrainPanAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "FullDrainPanAlert");
            }
        }
        if (iSUValue.contains("DIRTY FILTER ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "DirtyFilterAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "DirtyFilterAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "DirtyFilterAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DirtyFilterAlert");
            }
        }
        if (iSUValue.contains("WATER LEAK ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "WaterLeakAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "WaterLeakAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "WaterLeakAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "WaterLeakAlert");
            }
        }
        if (iSUValue.contains("SYSTEM SHUTDOWN ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "SystemShutdownAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "SystemShutdownAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SystemShutdownAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "SystemShutdownAlert");
            }
        }
        if (iSUValue.contains("SERVICE NEEDED ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "ServiceNeededAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "ServiceNeededAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ServiceNeededAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "ServiceNeededAlert");
            }
        }
        if (iSUValue.contains("FAN FAILURE ALERT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "FanFailureAlertChecked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "FanFailureAlert");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "FanFailureAlertChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "FanFailureAlert");
            }
        }
        return flag;
    }

    public boolean selectDryContacts2(String iSUValue) {
        boolean flag = true;
        if (iSUValue.contains("CUSTOM DRY CONTACT 1")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact1Checked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact1");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact1Checked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact1");
            }
        }
        if (iSUValue.contains("CUSTOM DRY CONTACT 2")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact2Checked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact2");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact2Checked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact2");
            }
        }
        if (iSUValue.contains("CUSTOM DRY CONTACT 3")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact3Checked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact3");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact3Checked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact3");
            }
        }
        if (iSUValue.contains("CUSTOM DRY CONTACT 4")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact4Checked", 1)) {
                flag = flag && MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact4");
            }
        } else {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CustomDryContact4Checked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "CustomDryContact4");
            }
        }
        return flag;
    }

    public boolean ISUAirFilterReplacementReminderDrpDwn(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("OFF")) {
            ISUValue = "Off";
        } else {
            ISUValue = ISUValue.toLowerCase();
        }
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        if (clickOnAirFilterReplacementReminderDrpDwn()) {
            if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {

                flag = navigateTo.scrollToExpectedElementVertically("XPATH",
                        "//*[contains(@content-desc,'" + ISUValue + "')]", "UP");
                flag = flag && MobileUtils.clickOnElement(testCase, "XPATH",
                        "//*[contains(@content-desc,'" + ISUValue + "')]");
            } else {
                flag = navigateTo.scrollToExpectedElementVertically("XPATH", "//*[contains(@name,'" + ISUValue + "')]",
                        "UP");
                flag = flag && MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + ISUValue + "')]");
            }
        } else {
            flag = false;
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to click on Element, Pls check the screenshot, Whether Drop Down available or not? ");
        }
        return flag;

    }

    private boolean clickOnAirFilterReplacementReminderDrpDwn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AirFilterReplacementReminderDrpDwn");
    }

    public boolean selectISUValue(TestCases testCase, String ISUValue) {
        if (MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatTypeDrpDwn", 1))
            MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatTypeDrpDwn");
        String isuValueXpath = getDynamicLocatorAndroidIOS(testCase, ISUValue);
        return MobileUtils.clickOnElement(testCase, "XPATH", isuValueXpath);
    }

    public boolean isStagingControlPrimaryHeatDifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StagingControlPrimaryHeatDifferentialScreen",
                timeOut);
    }

    public boolean isStagingControlCoolDifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StagingControlCoolDifferentialScreen",
                timeOut);
    }

    public boolean isHeatingStage3WiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatingStage3WiringScreen", timeOut);
    }

    public boolean isStagingControlPrimaryHeatDifferential3Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase,
                "StagingControlPrimaryHeatDifferential3Screen", timeOut);
    }

    public boolean isHeatCyclePerHourStage3Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatCyclePerHourStage3Screen", timeOut);
    }

    public boolean isMinNonCompressorOnTimeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "MinNonCompressorOnTimeScreen", timeOut);
    }

    public boolean setMinNonCompressorOnTime(TestCases testCase, String ISUValue) {
        ISUValue = ISUValue.toUpperCase();
        boolean flag = false;
        String currentVal = getCurrentMinNonCompressorOnTime().toUpperCase();
        Integer currentValue = currentVal.toUpperCase().replace("MINUTES", "").replace("MINUTE", "").replace("MIN", "")
                .contains("OFF") ? 0
                        : Integer.valueOf(currentVal);
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "OFF";
        }
        if (currentVal.contains(ISUValue)) {
            flag = true;
        } else {
            Integer valueOf;
            if (ISUValue.contains("OFF")) {
                valueOf = 0;
            } else {
                ISUValue = ISUValue.toUpperCase().replace("MINUTES", "").replace("MINUTE", "").replace("MIN", "")
                        .trim();
                valueOf = Integer.parseInt(ISUValue);
            }
            if (valueOf <= 15 && valueOf >= 0) {
                while (!flag) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnMinNonCompressorOnTimeIncrease();
                        currentVal = getCurrentMinNonCompressorOnTime();
                    } else if (valueOf < currentValue) {
                        flag = ClickOnMinNonCompressorOnTimeDecrease();
                        currentVal = getCurrentMinNonCompressorOnTime();
                    }
                    currentValue = currentVal.toUpperCase().replace("MINUTES", "").replace("MINUTE", "")
                            .replace("MIN", "").trim().contains("OFF") ? 0
                                    : Integer.valueOf(currentVal);
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should be between off to 15Min, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ClickOnMinNonCompressorOnTimeDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MinNonCompressorOnTimeDecrease");
    }

    public boolean ClickOnMinNonCompressorOnTimeIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MinNonCompressorOnTimeIncrease");
    }

    public String getCurrentMinNonCompressorOnTime() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMinNonCompressorOnTime")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMinNonCompressorOnTime")
                    .getDomAttribute("label");
        }
    }

    public boolean selectRadiantFloorHeatSensing(TestCases testCase, String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "AIR SENSOR ONLY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AirSensorOnly");
            }
            case "AIR AND FLOOR SENSORS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "AirandFloorSensor");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isRadiantFloorHeatSensingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "RadiantFloorHeatSensingScreen", timeOut);
    }

    public boolean setFloorSensorWiringAssignment(TestCases testCase, String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "ISU_TEMP_SENSOR_WIRING_ASSIGNMENT_1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "IsuTempSensorWiringAssg1");
            }
            case "THERMOSTAT S":
            case "THERMOSTAT S1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatS1");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isFloorSensorWiringAssignmentScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorSensorWiringAssignmentScreen", timeOut);
    }

    public boolean isMinFloorTempLimitScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "MinFloorTempLimitScreen", timeOut);
    }

    public boolean isMaxFloorTempLimitScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "MaxFloorTempLimitScreen", timeOut);
    }

    public boolean setMinFloorTempLimit(TestCases testCase, String iSUValue) {
        boolean flag = true;
        Integer valueOf = Integer.valueOf(iSUValue.toUpperCase().replace("°", "").replace("DEG", ""));
        Integer currentValue = Integer.valueOf(getMinFloorTempLimit());
        if (Integer.valueOf(iSUValue) >= 40) {
            while (!flag) {
                if (valueOf == currentValue) {
                    flag = true;
                    break;
                } else if (valueOf > currentValue) {
                    flag = ClickMinFloorTempLimitIncrease();
                    currentValue = Integer.valueOf(getMinFloorTempLimit());
                } else if (valueOf < currentValue) {
                    flag = ClickOnMinFloorTempLimitDecrease();
                    currentValue = Integer.valueOf(getMinFloorTempLimit());
                }
            }
        }
        return flag;
    }

    private boolean ClickOnMinFloorTempLimitDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MinFloorTempLimitDecrease");
    }

    private boolean ClickMinFloorTempLimitIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MinFloorTempLimitIncrease");
    }

    private String getMinFloorTempLimit() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMinFloorTempLimit")
                    .getDomAttribute("content-desc").replace("°", "");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMinFloorTempLimit")
                    .getDomAttribute("label").replace("°", "");
        }
    }

    public boolean setMaxFloorTempLimit(TestCases testCase, String iSUValue) {
        boolean flag = true;
        Integer valueOf = Integer.valueOf(iSUValue.toUpperCase().replace("°", "").replace("DEG", ""));
        Integer currentValue = Integer.valueOf(getMaxFloorTempLimit());
        if (Integer.valueOf(iSUValue) <= 99) {
            while (!(valueOf == currentValue)) {
                if (valueOf == currentValue) {
                    flag = true;
                    break;
                } else if (valueOf > currentValue) {
                    flag = ClickMaxFloorTempLimitIncrease();
                    currentValue = Integer.valueOf(getMinFloorTempLimit());
                } else if (valueOf < currentValue) {
                    flag = ClickOnMaxFloorTempLimitDecrease();
                    currentValue = Integer.valueOf(getMinFloorTempLimit());
                }
            }
        }
        return flag;
    }

    private boolean ClickOnMaxFloorTempLimitDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxFloorTempLimitDecrease");
    }

    private boolean ClickMaxFloorTempLimitIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxFloorTempLimitIncrease");
    }

    private String getMaxFloorTempLimit() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMaxFloorTempLimit")
                    .getDomAttribute("content-desc").replace("°", "");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentMaxFloorTempLimit")
                    .getDomAttribute("label").replace("°", "");
        }
    }

    public boolean isFloorEconomyModeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FloorEconomyModeScreen", timeOut);
    }

    public boolean clickOnDenaliTradeThermostat() {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        String model_Name = MqttManager.getModelNumber();
        if (model_Name.contains("X12") || model_Name.contains("X8V")) {
            model_Name = "S1200";
        } else if (model_Name.contains("X11") || model_Name.contains("X8S")) {
            model_Name = "S1100";
        } else if (model_Name.contains("X10") || model_Name.contains("X7S")) {
            model_Name = "S1000";
        } else if (model_Name.contains("X9") || model_Name.contains("X7B")) {
            model_Name = "S900";
        }
        if (navigateTo.scrollToExpectedElement("XPATH",
                "//*[contains(@content-desc,'ElitePRO') and contains(@content-desc,'" + model_Name + "')]")) {
            return MobileUtils.clickOnElement(testCase, "XPATH",
                    "//*[contains(@content-desc,'ElitePRO') and contains(@content-desc,'" + model_Name + "')]");
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to scroll to Fuji Thermostat element.");
            return false;
        }
    }

    public boolean isControlModeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ControlModeScreen", timeOut);
    }

    public boolean ISUEquipmentType(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "GAS STANDARD EFFICIENCY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasStandardEfficiency");
            }
            case "GAS HIGH EFFICIENCY": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalGasHighEfficiency");
            }
            case "OIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalOil");
            }
            case "ELECTRIC": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalElectric");
            }
            case "HOT WATER FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ConventionalHotWaterFanCoil");
            }
            case "AIR TO AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpAirToAir");
            }
            case "GEOTHERMAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpGeothermal");
            }
            case "HOT WATER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerHotWater");
            }
            case "STEAM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BoilerSteam");
            }
            case "HOT WATER RADIANT HEAT":
            case "HOT WATER - RADIANT HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantHeat");
            }
            case "HOT WATER RADIANT FLOOR HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantFloorHeat");
            }
            case "HOT WATER - FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FCHotWaterFanCoil");
            }
            case "2 PIPE FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "2PipeFanCoil");
            }
            case "4 PIPE FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "4PipeFanCoil");
            }
            default: {
                Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                        "User Expected ISU Value not available For Fuel Source System, User Expected ISU Value is :"
                                + ISUValue);
                return false;
            }
        }
    }

    public boolean selectOccupancySensing(String iSUValue) {
        switch (iSUValue.toUpperCase()) {
            case "NO REMOTE SETBACK": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "NoRemoteSetbackOccupancySensing");
            }
            case "DRY CONTACT OR L TERMINAL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DryContactOrLTerminal");
            }
            case "WIRELESS SENSOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WirelessSensor");
            }
            case "THERMOSTAT INTERNAL SENSOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatInternalSensor");
            }
            case "Wireless and Internal sensors": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WirelessInternalSensor");
            }
            default:
                return false;
        }
    }

    public boolean turnOffOnTempAlert(TestCases testCase, String isuType, String ISUValue) {
        // boolean currentTempStatus = MobileUtils.isMobElementExists(objectDefinition,
        // testCase, "MaxMinSetpointValue");

        String ObjectFileVariableName = isuType.toUpperCase().contains("HIGH") ? "HighTemAlertCheckBox"
                : "LowTemAlertCheckBox";
        boolean currentTempStatus = MobileUtils.isMobElementExists(objectDefinition, testCase, ObjectFileVariableName);
        System.out.println(
                "ObjectFileVariableName:" + ObjectFileVariableName + ",currentTempStatus:" + currentTempStatus);
        boolean flag = false;
        if (!currentTempStatus) {
            System.out.println("Turn off checkbox of ISU Type: " + isuType + ": was disabled");
            switch (ISUValue.toUpperCase()) {
                case "DEFAULT":
                case "OFF":
                case "":
                    MobileUtils.clickOnElement(objectDefinition, testCase, ObjectFileVariableName);
                    // return !MobileUtils.isMobElementExists(objectDefinition, testCase,
                    // ObjectFileVariableName);
                    return !MobileUtils.isMobElementExists(objectDefinition, testCase, "MaxMinAlertValue");
                default:
                    Integer valueOf = Integer.valueOf(ISUValue);
                    Integer currentValue = Integer.valueOf(getMaxMinAlertValue().replace(",", ""));
                    if (Integer.valueOf(ISUValue) <= 99 || Integer.valueOf(ISUValue) >= 40) {
                        while (!(valueOf == currentValue)) {
                            if (valueOf == currentValue) {
                                flag = true;
                                break;
                            } else if (valueOf > currentValue) {
                                flag = clickOnMaxMinAlertValueIncrease();
                                currentValue = Integer.valueOf(getMaxMinAlertValue());
                            } else if (valueOf < currentValue) {
                                flag = clickOnMaxMinAlertValueDecrease();
                                currentValue = Integer.valueOf(getMaxMinAlertValue());
                            }
                        }
                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                                "User Entered ISU Value not applicable. its should not be exceed 40 to 90, User entered value is : "
                                        + ISUValue);
                        flag = false;
                    }
                    return flag;
            }
        } else {
            switch (ISUValue.toUpperCase()) {
                case "DEFAULT":
                case "OFF":
                case "":
                    return true;
                default:
                    MobileUtils.clickOnElement(objectDefinition, testCase, ObjectFileVariableName);
                    MobileUtils.isMobElementExists(objectDefinition, testCase, "MaxMinAlertValue");
                    Integer valueOf = Integer.valueOf(ISUValue);
                    Integer currentValue = Integer.valueOf(getMaxMinAlertValue().replace(",", ""));
                    if (Integer.parseInt(ISUValue) <= 90 || Integer.parseInt(ISUValue) >= 40) {
                        while (!(valueOf == currentValue)) {
                            if (valueOf == currentValue) {
                                flag = true;
                                break;
                            } else if (valueOf > currentValue) {
                                flag = clickOnMaxMinAlertValueIncrease();
                                currentValue = Integer.valueOf(getMaxMinAlertValue());
                            } else if (valueOf < currentValue) {
                                flag = clickOnMaxMinAlertValueDecrease();
                                currentValue = Integer.valueOf(getMaxMinAlertValue());
                            }
                        }
                    } else {
                        Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                                "User Entered ISU Value not applicable. its should not be exceed 40 to 90, User entered value is : "
                                        + ISUValue);
                        flag = false;
                    }
                    return flag;
            }
        }
    }

    public boolean clickDropDownAndSelectISUValue(TestCases testCase, String ISUValue) {
        ISUValue = ISUValue.toUpperCase();
        ISUValue = ISUValue.contains("DEG") ? ISUValue.replace("DEG", "°") : ISUValue;
        String platform = testCase.getMobileDriver().getPlatformName().toUpperCase();
        String dropDownLocator;
        if (ISUValue.isEmpty() || ISUValue.equalsIgnoreCase("DEFAULT"))
            return true;
        if (platform.contains("ANDROID")) {
            dropDownLocator = "(//*[@class='android.widget.ImageView'])[last()]";
        } else {
            dropDownLocator = "//*[@type='XCUIElementTypeButton' and not(@label='Next') and not(@label='Exit') and not(@label='Back') and not(@label='More Info')][1]";
        }
        MobileUtils.clickOnElement(testCase, "XPATH", dropDownLocator);
        String isuValueXpath = getDynamicLocatorAndroidIOS(testCase, ISUValue);
        return MobileUtils.clickOnElement(testCase, "XPATH", isuValueXpath);
    }

    public String getDynamicLocatorAndroidIOS(TestCases testCase, String value) {
        String platform = Objects.requireNonNull(testCase.getMobileDriver().getPlatformName()).toUpperCase();
        String locatorXpath;
        if (platform.contains("ANDROID")) {
            locatorXpath = "//*[contains(translate(@content-desc, ''ABCDEFGHIJKLMNOPQRSTUVWXYZ'', ''abcdefghijklmnopqrstuvwxyz''), ''{0}'')]";
        } else {
            locatorXpath = "//*[contains(translate(@name, ''ABCDEFGHIJKLMNOPQRSTUVWXYZ'', ''abcdefghijklmnopqrstuvwxyz''), ''{0}'')]";
        }
        return MessageFormat.format(locatorXpath, value.toLowerCase());
    }

    public boolean isEquipmentTypeScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "EquipmentTypeScreen", timeOut);
    }

    public boolean isISUScreenPresent(String iSUType, int timeOut) {
        String xpath = getDynamicLocatorAndroidIOS(testCase, iSUType);
        return MobileUtils.isMobElementExists("XPATH", xpath, testCase, 1);
    }

    public boolean isISUDropDownButtonPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ISUDropDownButton");
    }

    public boolean selectRoomName() {
        String roomName = testCase.getTestCaseInputs().getInputValue("LOCATION1_DEVICE1_NAME");
        boolean flag = false;
        if (isRoomSelectScreen()) {
            NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
            if (navigateTo.scrollToExpectedElementVertically("XPATH", "//*[contains(@content-desc,'" + roomName + "')]",
                    "UP")) {
                flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@content-desc,'" + roomName + "')]");
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AddRoomBtn")) {
                    if (MobileUtils.clickOnElement(objectDefinition, testCase, "AddRoomBtn")) {
                        if (MobileUtils.isMobElementExists(objectDefinition, testCase, "RoomNameInput", 3)) {
                            Keyword.ReportStep_Pass(testCase, "DeviceNameInput is present.");
                            WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase,
                                    "RoomNameInput");
                            mobElement.click();
                            mobElement.sendKeys(roomName);
                            flag = true;
                        } else {
                            Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
                                    "DeviceNameInput is not present");
                        }
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Add Room Btn is Not Present.");
                }
            }
            SystemState.getStatus().setTstatName(roomName);
            flag = flag && clickOnNextButton();
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Room Screen is Not Present.");
        }
        return flag;
    }

    public boolean isRoomSelectScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SelectRoomScreen");
    }

    public String getMaxMinAlertValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "MaxMinAlertValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "MaxMinAlertValue").getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean clickOnMaxMinAlertValueDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinAlertValueDecrease");
    }

    public boolean clickOnMaxMinAlertValueIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinAlertValueIncrease");
    }

    public boolean isOutdoorHumidityOffsetScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutdoorHumidityOffsetScreen", 2);
    }

    public boolean isOutdoorTempOffsetScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "OutdoorTempOffsetScreen", 2);
    }

    public boolean isLTerminalAlertScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "LTerminalAlertScreen", timeOut);
    }

    public boolean ISULTerminalAlert(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HPFailNone");
            }
            case "HEAT PUMP FAILURE INDICATION": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpFailureIndication");
            }

            default: {
                return false;
            }
        }

    }

    public boolean isBackupHeatWiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatWiringScreen", timeOut);
    }

    public boolean ISUBackupHeatWiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "THERMOSTAT U": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatWiringThermostatU");
            }
            case "THERMOSTAT L": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatWiringThermostatL");
            }
            case "THERMOSTAT AUX": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatWiringThermostatAux");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isHeatPumpStage2WiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatPumpStage2WiringScreen", timeOut);
    }

    public boolean ISUHeatPumpStage2Wiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "None": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpStage2WiringNone");
            }
            case "THERMOSTAT U": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpStage2WiringThermostatU");
            }
            case "THERMOSTAT L": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatPumpStage2WiringThermostatL");
            }

            default: {
                return false;
            }
        }

    }

    public boolean ISUHeatStagingControl(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NO": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatStagingControlNo");
            }
            case "YES": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatStagingControlYes");
            }
            default: {
                return false;
            }
        }
    }

    public boolean selectBackupHeatTypeNewISUValue(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HumTypeNone");
            }
            case "STANDARD EFFICIENCY GAS FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "StandardEffGasForcedAir");
            }
            case "HIGH EFFICIENCY GAS FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HighEffGasForcedAir");
            }
            case "OIL FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "OilForcedAir");
            }
            case "HOT WATER FAN COIL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterFanCoil");
            }
            case "HOT WATER RADIANT HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "HotWaterRadiantHeat");
            }
            case "OTHER": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "Other");
            }
            case "ELECTRIC FORCED AIR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BckupHtElectricForcedAir");
            }
            default:
                return false;
        }
    }

    public boolean isHeatStagingControlScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatStagingControlScreen", timeOut);
    }

    public boolean isBackupHeatOperationScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatOperationScreen", timeOut);
    }

    public boolean ISUBackupHeatOperation(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NOT ALLOWED TO RUN WITH PRIMARY HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatNotAllowedWithPrimaryHeat");
            }
            case "ALLOWED TO RUN WITH PRIMARY HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "BackupHeatAllowedWithPrimaryHeat");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isEmergencyHeatOperationScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmergencyHeatOperationScreen", timeOut);
    }

    public boolean ISUEmergencyHeatOperation(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NOT ALLOWED TO RUN WITH PRIMARY HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatNotAllowedWithPrimaryHeat");
            }
            case "ALLOWED TO RUN WITH PRIMARY HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "EmergencyHeatAllowedWithPrimaryHeat");
            }

            default: {
                return false;
            }
        }

    }

    public boolean isBackupHeatStage2DifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatStage2DifferentialScreen",
                timeOut);
    }

    public String getBackUpHeatStage2Differential() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackupHeatStage2DifferentialValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackupHeatStage2DifferentialValue")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean clickOnBackupHeatStage2DifferentialDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxHeatDifferentialDecrease");
    }

    public boolean clickOnBackupHeatStage2DifferentialIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AuxHeatDifferentialIncrease");
    }

    public boolean ISUBackupHeatStage2Differential(String ISUValue) {
        boolean flag = false;
        String isuValue = ISUValue;
        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (ISUValue.toUpperCase().contains("DEFAULT") || ISUValue.toUpperCase().contains("COMFORT")) {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "ComfortChecked", 1)) {
                flag = MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
            } else {
                flag = true;
            }
        } else {
            Integer valueOf = Integer.valueOf(isuValue);
            Integer currentValue = Integer.valueOf(getBackUpHeatStage2Differential());
            if (Integer.valueOf(isuValue) <= 2 && Integer.valueOf(isuValue) >= 0) {
                while (!(valueOf == currentValue)) {
                    if (valueOf > currentValue) {
                        flag = clickOnBackupHeatStage2DifferentialIncreaseButton();
                        currentValue = Integer.valueOf(getBackUpHeatStage2Differential());
                    } else if (valueOf < currentValue) {
                        flag = clickOnBackupHeatStage2DifferentialDecreaseButton();
                        currentValue = Integer.valueOf(getBackUpHeatStage2Differential());
                    }
                }
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 0,2 to 16, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean isBackupHeatCyclesPerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackupHeatCyclesPerHourStage2Screen",
                timeOut);
    }

    public String getBackUpHeatCyclePerHourStage2Value() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatCyclePerHourStage2Value")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "BackUpHeatCyclePerHourStage2Value")
                    .getDomAttribute("label");

        }
        return getText;
    }

    public boolean ClickOnBackUpHeatCyclePerHourStage2Decrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatCyclePerHourStage2Decrease");
    }

    public boolean ClickOnBackUpHeatCyclePerHourStage2Increase() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackUpHeatCyclePerHourStage2Increase");
    }

    public boolean setISUBackUpHeatCyclePerHourStage2(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getBackUpHeatCyclePerHourStage2Value());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "9";
        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 12 || Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourStage2Increase();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourStage2Value());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourStage2Decrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourStage2Value());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean isExternalFossilFuelKitScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExternalFossilFuelKitScreen", timeOut);
    }

    public boolean ISUExternalFossilFuelKit(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "THERMOSTAT CONTROLS BACKUP HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ThermostatControlsBackupHeat");
            }
            case "EXTERNAL FOSSIL FUEL KIT CONTROLS BACKUP HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase,
                        "ExternalFossilFuelKitControlsBackupHeat");
            }

            default: {
                return false;
            }
        }

    }

    public boolean isCoolStagingControlScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolStagingControlScreen", timeOut);
    }

    public boolean ISUCoolStagingControl(String ISUValue) {
        return selectISUValue(testCase, ISUValue);

    }

    public boolean isStagingControlCompressorCoolStage2DifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCoolStage2DifferentialScreen",
                timeOut);
    }

    public boolean ClickOnCompressorCoolStage2DifferentialDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorCoolStage2DifferentialDecrease");
    }

    public boolean ClickOnCompressorCoolStage2DifferentialIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorCoolStage2DifferentialIncrease");
    }

    public String getCompressorCoolStage2Differential() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage2DifferentialValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CompressorCoolStage2DifferentialValue")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean ISUStagingControlCompressorCoolStage2Differential(String ISUValue) {

        boolean flag = false;
        String isuValue = ISUValue;
        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (ISUValue.toUpperCase().contains("COMFORT")) {
            // To enable this option need to have ID for the element
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
                flag = true;
                System.out.println("Set to Default Settings : Comfort ");
            } else {
                System.out.println("Already set as Default Settings : Comfort ");
                flag = true;
            }
        } else {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
            }
            Integer valueOf = Integer.valueOf(isuValue);
            Integer currentValue = Integer.valueOf(getCompressorCoolStage2Differential());
            if (Integer.valueOf(isuValue) <= 1 && Integer.valueOf(isuValue) >= 0) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnAuxHeatDifferentialIncreaseButton();
                        currentValue = Integer.valueOf(getCompressorCoolStage2Differential());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnAuxHeatDifferentialDecreaseButton();
                        currentValue = Integer.valueOf(getCompressorCoolStage2Differential());
                    }
                }
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. User entered value is : " + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean isStagingControlCompressorHeatDifferentialStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Screen",
                timeOut);
    }

    public boolean ClickOnCompressorHeatDifferentialStage2DecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorHeatDifferentialStage2Decrease");
    }

    public boolean ClickOnCompressorHeatDifferentialStage2IncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CompressorHeatDifferentialStage2Increase");
    }

    public String getCompressorHeatDifferentialStage2() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean ISUStagingControlCompressorHeatDifferentialStage2(String ISUValue) {

        boolean flag = false;
        String isuValue = ISUValue;
        String getText = null;

        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (ISUValue.toUpperCase().contains("COMFORT")) {
            // To enable this option need to have ID for the element
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
                flag = true;
                System.out.println("Set to Default Settings : Comfort ");
            } else {
                System.out.println("Already set as Default Settings : Comfort ");
                flag = true;
            }
        } else {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
            }
            Integer valueOf = Integer.valueOf(isuValue);
            Integer currentValue = Integer.valueOf(getCompressorHeatDifferentialStage2());
            if (Integer.valueOf(isuValue) <= 1 && Integer.valueOf(isuValue) >= 0) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnCompressorHeatDifferentialStage2IncreaseButton();
                        currentValue = Integer.valueOf(getCompressorHeatDifferentialStage2());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnCompressorHeatDifferentialStage2DecreaseButton();
                        currentValue = Integer.valueOf(getCompressorHeatDifferentialStage2());
                    }
                }
                flag = true;
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 0,2 to 15, User entered value is : "
                                + ISUValue);
                flag = false;
            }

            return flag;
        }
        return flag;
    }

    public boolean isChangeoverSensorScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ChangeoverSensorScreen", timeOut);
    }

    public boolean ISUChangeoverSensor(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "None": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensorNone");
            }
            case "DRY CONTACT SWITCH": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensorDryContactSwitch");
            }
            case "10K SENSOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensor10KSensor");
            }
            case "20K SENSOR": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensor20KSensor");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isDryContactSwitchScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DryContactSwitchScreen", timeOut);
    }

    public boolean ISUDryContactSwitch(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "OPEN IN COOL": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DryContactSwitchOpenInCool");
            }
            case "OPEN IN HEAT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "DryContactSwitchOpenInHeat");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isChangeoverSensorWiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "ChangeoverSensorWiringScreen", timeOut);
    }

    public boolean ISUChangeoverSensorWiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensorWiringNone");
            }
            case "THERMOSTAT S": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "ChangeoverSensorWiringThermostatS");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isFanCoilStagesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilStagesScreen", timeOut);
    }

    public boolean ISUFanCoilStages(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "1": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoilStage1");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isFanStagesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanStagesScreen", timeOut);
    }

    public boolean clickOnFanSpeedIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedIncreaseButton");
    }

    public boolean clickOnFanSpeedDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedDecreaseButton");
    }

    public String getFanSpeedValue() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "FanSpeedValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "FanSpeedValue").getDomAttribute("label");

        }
        return getText;
    }

    public boolean setISUFanStages(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getFanSpeedValue());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "3";
        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 3 || Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = clickOnFanSpeedIncreaseButton();
                        currentValue = Integer.valueOf(getFanSpeedValue());
                    } else if (valueOf < currentValue) {
                        flag = clickOnFanSpeedDecreaseButton();
                        currentValue = Integer.valueOf(getFanSpeedValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "UUser Entered ISU Value not applicable. its should not be exceed between 1 to 3, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }

        return flag;
    }

    public boolean isFanMediumSpeedWiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanMediumSpeedWiringScreen", timeOut);
    }

    public boolean ISUMediumSpeedWiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "THERMOSTAT Y2": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanMediumSpeedWiringThermostatY2");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isFanHighSpeedWiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanHighSpeedWiringScreen", timeOut);
    }

    public boolean ISUHighSpeedWiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringNone");
            }
            case "THERMOSTAT U": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatU");
            }
            case "THERMOSTAT L": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatL");
            }
            default: {
                return false;
            }
        }
    }

    public boolean isAllowedFanModesScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "AllowedFanModesScreen", timeOut);
    }

    public boolean ISUAllowedFanModes(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "AUTO": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedAuto");
            }
            case "MULTIPLE SPEEDS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedMultipleSpeeds");
            }
            case "AUTO AND MULTIPLE SPEED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedAutoAndMultipleSpeed");
            }
            case "ON": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedOn");
            }
            case "AUTO AND ON": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanSpeedAutoAndOn");
            }

            default: {
                return false;
            }
        }

    }

    public boolean isStartFanonHighSpeedScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "StartFanonHighSpeedScreen", timeOut);
    }

    public boolean ISUStartFanonHighSpeed(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "DISABLED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "StartFanonHighSpeedDisabled");
            }
            case "ENABLED": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "StartFanonHighSpeedEnabled");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isFanResetTimerScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanResetTimerScreen", timeOut);
    }

    public boolean ISUFanResetTimer(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "INACTIVE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanResetTimerInactive");
            }
            case "RESET AFTER 2 HOURS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanResetTimerAfter2Hours");
            }
            case "ALL RESET AFTER 4 HOURS": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanResetTimerAfter4Hours");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isPipeSensorThresholdforCoolingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PipeSensorThresholdforCoolingScreen",
                timeOut);
    }

    public boolean isPipeSensorThresholdforHeatingScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PipeSensorThresholdforHeatingScreen",
                timeOut);
    }

    public String getPipeSensorThresholdValueForCoolingAndHeating() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils
                    .getMobElement(objectDefinition, testCase, "PipeSensorThresholdValueForCoolingAndHeating")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils
                    .getMobElement(objectDefinition, testCase, "PipeSensorThresholdValueForCoolingAndHeating")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean ClickOnPipeSensorThresholdValueForCoolingAndHeatingDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase,
                "PipeSensorThresholdValueForCoolingAndHeatingDecrease");
    }

    public boolean ClickOnPipeSensorThresholdValueForCoolingAndHeatingIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase,
                "PipeSensorThresholdValueForCoolingAndHeatingIncrease");
    }

    public boolean ISUPipeSensorThresholdforCooling(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 72 || Integer.valueOf(ISUValue) >= 50) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnPipeSensorThresholdValueForCoolingAndHeatingIncrease();
                        currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnPipeSensorThresholdValueForCoolingAndHeatingDecrease();
                        currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed between 50 to 72, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean ISUPipeSensorThresholdforHeating(String ISUValue) {
        boolean flag = true;

        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating().replace(",", ""));
            if (Integer.valueOf(ISUValue) <= 90 || Integer.valueOf(ISUValue) >= 75) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnPipeSensorThresholdValueForCoolingAndHeatingIncrease();
                        currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnPipeSensorThresholdValueForCoolingAndHeatingDecrease();
                        currentValue = Integer.valueOf(getPipeSensorThresholdValueForCoolingAndHeating());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed between 75 to 90, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean isFanCoilHeatStageScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatStageScreen", timeOut);
    }

    public boolean isCoolStage3WiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolStage3WiringScreen", timeOut);
    }

    public boolean isCoolStage4WiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolStage4WiringScreen", timeOut);
    }

    public boolean ISUCoolStage3Wiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringNone");
            }
            case "THERMOSTAT U": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatU");
            }
            case "THERMOSTAT L": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatL");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isFanCoilHeatStage3WiringScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatStage3WiringScreen", timeOut);
    }

    public boolean ISUFanCoilHeatStage3Wiring(String ISUValue) {
        switch (ISUValue.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringNone");
            }
            case "THERMOSTAT U": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatU");
            }
            case "THERMOSTAT L": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "FanHighSpeedWiringThermostatL");
            }
            default: {
                return false;
            }
        }

    }

    public boolean isStagingControlCompressorCoolStage3DifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCoolStage3DifferentialScreen",
                timeOut);
    }

    public boolean isStagingControlCompressorCoolStage4DifferentialScreen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorCoolStage4DifferentialScreen",
                timeOut);
    }

    public boolean iSStagingControlFanCoilHeatDifferentialStage2(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatDifferentialStage2Screen",
                timeOut);
    }

    public boolean iSStagingControlFanCoilHeatDifferentialStage3(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatDifferentialStage3Screen",
                timeOut);
    }

    public boolean isCoolCyclePerHourStage3Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesStage3PerHourScreen", timeOut);
    }

    public boolean isCoolCyclePerHourStage4Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolCyclesStage4PerHourScreen", timeOut);
    }

    public boolean isFanCoilHeatCyclePerHourStage1Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatCyclesPerHourStage1Screen",
                timeOut);
    }

    public boolean isFanCoilHeatCyclePerHourStage2Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatCyclesPerHourStage2Screen",
                timeOut);
    }

    public boolean isFanCoilHeatCyclePerHourStage3Screen(int timeOut) {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "FanCoilHeatCyclesPerHourStage3Screen",
                timeOut);
    }

    public boolean ISUFanCoilHeatCyclePerHour_Stage(String ISUValue) {
        boolean flag = false;
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            flag = true;
        } else if (getCurrentFanCoilHeatCyclesValue().contains(ISUValue)) {
            flag = true;
        } else {
            Integer valueOf = Integer.valueOf(ISUValue);
            Integer currentValue = Integer.valueOf(getCurrentFanCoilHeatCyclesValue());
            if (valueOf <= 12 && valueOf >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = clickOnFanCoilHeatCyclesValueIncreaseButton();
                        currentValue = Integer.valueOf(getCurrentFanCoilHeatCyclesValue());
                    } else if (valueOf < currentValue) {
                        flag = clickOnFanCoilHeatCyclesValueDecreaseButton();
                        currentValue = Integer.valueOf(getCurrentFanCoilHeatCyclesValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. User entered value is : " + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public String getCurrentFanCoilHeatCyclesValue() {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentFanCoilHeatCyclesValue")
                    .getDomAttribute("content-desc");
        } else {
            return MobileUtils.getMobElement(objectDefinition, testCase, "CurrentFanCoilHeatCyclesValue")
                    .getDomAttribute("label");
        }
    }

    public boolean clickOnFanCoilHeatCyclesValueIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoilHeatCyclesValueIncreaseButton");
    }

    public boolean clickOnFanCoilHeatCyclesValueDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "FanCoilHeatCyclesValueDecreaseButton");
    }

    public boolean setCyclePerHourForHeatStage(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getHeatCyclePerHourValue());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "4";
        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 12 || Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 40 to 90, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }

        return flag;
    }

    public boolean ISUCompressorCyclesPerHour_Stage1(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "3";

        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 12 && Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getCurrentCompressorCyclesValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should be between 1 to 6, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public static boolean isDeviceConfiguration_Valid(TestCases testCase, String heatingSystem, String heatingStages,
            String coolingStages) {
        boolean flag = false;
        FADeviceDetailsScreen dviceDetails = new FADeviceDetailsScreen(testCase);
        String heating_System;
        if (dviceDetails.isHeatingSystemPresent()) {
            heating_System = dviceDetails.getHeatingSystem().toUpperCase().replace("HEATING_SYSTEM", "")
                    .replace("_", " ").trim();
        } else {
            // heating_System = "NONE";
            heating_System = "OTHER";
        }

        String heating_Stages;
        if (dviceDetails.isHeatingStagesPresent()) {
            heating_Stages = dviceDetails.getHeatingStages();
        } else {
            heating_Stages = "0";
        }

        String cooling_Stages;
        if (dviceDetails.isCoolingStagesPresent()) {
            cooling_Stages = dviceDetails.getCoolingStages();
        } else {
            cooling_Stages = "0";
        }

        if (heatingSystem.toUpperCase().equals(heating_System.toUpperCase())) {
            Keyword.ReportStep_Pass(testCase, "Current configured System is " + heating_System);
            System.out.println("Current configured System is : " + heating_System);
            flag = true;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
                    "Expected Heating system is " + heatingSystem + ", Actual heating system is " + heating_System);
            System.out.println("Current configured System is : " + heating_System);
            flag = false;
        }
        if (heatingStages.toUpperCase().equals(heating_Stages.toUpperCase())) {
            Keyword.ReportStep_Pass(testCase, "Current configured heating stages is " + heatingStages);
            System.out.println("Current configured heating stages is : " + heatingStages);
            flag = true;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
                    "Expected Heating system is " + heatingStages + ", Actual heating system is " + heating_Stages);
            System.out.println("Current configured heating stages is : " + heatingStages);
            flag = false;
        }
        if (coolingStages.toUpperCase().equals(cooling_Stages.toUpperCase())) {
            Keyword.ReportStep_Pass(testCase, "Current configured Cooling stages is " + cooling_Stages);
            System.out.println("Current configured cooling stages is : " + cooling_Stages);
            flag = true;
        } else {
            Keyword.ReportStep_Fail(testCase, FailType.PASSWITH_FAILURE,
                    "Expected Cooling system is " + coolingStages + ", Actual heating system is " + cooling_Stages);
            System.out.println("Current configured cooling stages is : " + cooling_Stages);
            flag = false;
        }
        return flag;
    }

    public String getHeatingSystem() {
        String HeatingSystem = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            if (scroolToExpectedElement("HeatingSystem")) {
                HeatingSystem = MobileUtils.getDomAttribute(testCase, objectDefinition, "HeatingSystem", "resource-id")
                        .toUpperCase();
            }
        } else {
            if (scroolToExpectedElement("HeatingSystem")) {
                HeatingSystem = MobileUtils.getDomAttribute(testCase, objectDefinition, "HeatingSystem", "resource-id")
                        .toUpperCase();
            }
        }
        return HeatingSystem;
    }

    public boolean scroolToExpectedElement(String locatorType) {
        boolean flag = false;
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int endY = (int) (dimens.getHeight() * 0.2);
        int startY = (int) (dimens.getHeight() * 0.75);
        for (int i = 0; i <= 5; i++) {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, locatorType, 5)) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully Scrolled to Expected Element");
                break;
            } else {
                W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
            }
        }
        if (flag) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean ClickOnMaxMinAlertValueDecrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinAlertValueDecrease");
    }

    public boolean ClickOnMaxMinAlertValueIncrease() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "MaxMinAlertValueIncrease");
    }

    public boolean ClickOnHPBackUpHeatDifferentialValueDecreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "HPBackUpHeatDifferentialValueIncreaseButton");
    }

    public boolean ClickOnHPBackUpHeatDifferentialValueIncreaseButton() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "HPBackUpHeatDifferentialValueDecreaseButton");
    }

    public boolean setISUBackupHeatDifferentialFanCoil(String ISUValue) {
        boolean flag = false;
        float epsilon = 0.00001f;
        String isuValue = ISUValue;
        Float currentValue = Float.valueOf(getAuxBackUpHeatDifferential());

        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            isuValue = "2";
        } else if (ISUValue.toUpperCase().contains("COMFORT")) {
            // To enable this option need to have ID for the element
        }
        Float valueOf = Float.valueOf(isuValue.replace("°", "").replace("DEG", ""));
        if (Math.abs(valueOf - currentValue) < epsilon) {
            flag = true;
        } else {
            if (Float.valueOf(valueOf) <= 15 || Float.valueOf(valueOf) >= 2) {
                while (!(valueOf == currentValue)) {
                    System.out.println("valueOf :" + valueOf + ", currentValue:" + currentValue);
                    if (valueOf > currentValue) {
                        flag = ClickOnAuxHeatDifferentialIncreaseButton();
                        currentValue = Float.valueOf(getAuxBackUpHeatDifferential());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnAuxHeatDifferentialDecreaseButton();
                        currentValue = Float.valueOf(getAuxBackUpHeatDifferential());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 0,2 to 15, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }

        return flag;
    }

    public boolean setISUBackUpHeatCyclePerHour(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "9";
            // flag = true;
        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 12 || Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnBackUpHeatCyclePerHourDecrease();
                        currentValue = Integer.valueOf(getBackUpHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean setISUEmergencyHeatCyclePerHour(String ISUValue) {
        boolean flag = false;
        Integer currentValue = Integer.valueOf(getEmergencyHeatCyclePerHourValue());
        if (ISUValue.toUpperCase().contains("DEFAULT")) {
            ISUValue = "5";
            // flag = true;
        }
        Integer valueOf = Integer.valueOf(ISUValue);
        if (valueOf == currentValue) {
            flag = true;
        } else {
            if (Integer.valueOf(ISUValue) <= 12 || Integer.valueOf(ISUValue) >= 1) {
                while (!(valueOf == currentValue)) {
                    if (valueOf == currentValue) {
                        flag = true;
                        break;
                    } else if (valueOf > currentValue) {
                        flag = ClickOnEmergencyHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getEmergencyHeatCyclePerHourValue());
                    } else if (valueOf < currentValue) {
                        flag = ClickOnEmergencyHeatCyclePerHourIncrease();
                        currentValue = Integer.valueOf(getEmergencyHeatCyclePerHourValue());
                    }
                }
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                        "User Entered ISU Value not applicable. its should not be exceed 12, User entered value is : "
                                + ISUValue);
                flag = false;
            }
        }
        return flag;
    }

    public boolean setISUBackupHeatDifferentialHP(String ISUValue) {

        boolean flag = false;
        float epsilon = 0.00001f;
        String isuValue = ISUValue;

        if (isuValue.contains("DEG")) {
            isuValue = isuValue.split("DEG")[0].trim();
        }

        if (ISUValue.toUpperCase().contains("COMFORT")) {
            // To enable this option need to have ID for the element
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
                flag = true;
                System.out.println("Set to Default Settings for HP : Comfort ");
            } else {
                if (MobileUtils.isMobElementExists(objectDefinition, testCase, "ComfortCheckBox")) {

                    System.out.println("Already set as Default Settings : Comfort ");
                    flag = true;
                }
            }
        } else {
            if (!MobileUtils.isMobElementExists(objectDefinition, testCase, "CompressorHeatDifferentialStage2Value")) {
                MobileUtils.clickOnElement(objectDefinition, testCase, "ComfortCheckBox");
            }
            Float currentValue = Float.valueOf(getHPBackUpHeatDifferential());
            Float valueOf = Float.valueOf(isuValue.replace("°", "").replace("DEG", ""));
            if (Math.abs(valueOf - currentValue) < epsilon) {
                flag = true;
            } else {
                if (Float.valueOf(valueOf) <= 15 || Float.valueOf(valueOf) >= 2) {
                    while (!(valueOf == currentValue)) {
                        System.out.println("valueOf :" + valueOf + ", currentValue:" + currentValue);
                        if (valueOf > currentValue) {
                            flag = ClickOnHPBackUpHeatDifferentialValueIncreaseButton();
                            currentValue = Float.valueOf(getHPBackUpHeatDifferential());
                        } else if (valueOf < currentValue) {
                            flag = ClickOnHPBackUpHeatDifferentialValueDecreaseButton();
                            currentValue = Float.valueOf(getHPBackUpHeatDifferential());
                        }
                    }
                } else {
                    Keyword.ReportStep_Fail(testCase, FailType.FALSE_POSITIVE,
                            "User Entered ISU Value not applicable. its should not be exceed 0,2 to 15, User entered value is : "
                                    + ISUValue);
                    flag = false;
                }

            }

        }
        return flag;
    }

    public String getHPBackUpHeatDifferential() {
        String getText = null;
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "HPBackUpHeatDifferentialValue")
                    .getDomAttribute("content-desc");
        } else {
            getText = MobileUtils.getMobElement(objectDefinition, testCase, "HPBackUpHeatDifferentialValue")
                    .getDomAttribute("label");

        }
        if (getText.contains("°")) {
            getText = getText.replace("°", "");
        }
        return getText;
    }

    public boolean clickOnGleneaglesControlHub() {
        NavigatingScreenToScreeninFA navigateTo = new NavigatingScreenToScreeninFA(testCase);
        try {
            if (navigateTo.scrollToExpectedElement("GleneaglesControlHubTab")) {
                TimeUnit.SECONDS.sleep(2);
                return MobileUtils.clickOnElement(objectDefinition, testCase, "GleneaglesControlHubTab");
            } else {
                Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                        "Not able to scroll to Gleneagles element.");
                return false;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to scroll to Gleneagles element due to exception: " + e.getMessage());
            return false;
        }
    }

    public boolean isPrepareHardwareScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "PrepareHardwareScreen");
    }

    public boolean isInitiateParingScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "InitiateParingScreen");
    }

    public boolean clickonSkipBtn() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "SkipBtnTab");
        // return MobileUtils.isMobElementExists("XPATH", "//*[@content-desc=\"Skip\"]",
        // testCase);

    }

    public boolean isUsingNxtScreenPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "UsingNxtScreen");
    }

    public boolean isInstallNxtScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "InstallNxtScreen");
    }

    public boolean BindNxtScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BindNxtScreen");
    }

    public boolean isSuccess() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SuccessPopUp");
    }

    public boolean isDemandControlScreenPresent() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "DemandControlScreen");
    }

    public boolean selectDemandControlOpt(String valueToConfigure) {
        switch (valueToConfigure.toUpperCase()) {
            case "NONE": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "StageNone");
            }
            case "WIRED VIA NXT":
            case "NXT": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WiredViaNxtOpt");
            }
            case "WIRED VIA EIM":
            case "EIM": {
                return MobileUtils.clickOnElement(objectDefinition, testCase, "WiredViaEIMOpt");
            }
            default:
                return false;
        }
    }

    public boolean isInstallControlModuleScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "InstallControlModuleScreen", 7);
    }

    public boolean BindControlModuleScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "BindControlModule");
    }

    public boolean isTextPresent(String reqText) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@content-desc,'" + reqText + "')]", testCase);
        } else {
            return MobileUtils.isMobElementExists("XPATH", "//*[contains(@name,'" + reqText + "')]", testCase);
        }
    }

    public boolean isSetUpNxtSmartThermostatKitScreen() {
        return MobileUtils.isMobElementExists(objectDefinition, testCase, "SetUpNxtSmartThermostatKitScreen");
    }

}