package com.resideo.utils.firstalert_app.screen;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;
import com.resideo.utils.resideo_app.LyricUtils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import com.resideo.utils.W3CTouchActions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;
import java.util.function.Function;

public class NavigatingScreenToScreeninFA extends MobileScreens {
    private static final String screenName = "FAScreenNavigation";

    public NavigatingScreenToScreeninFA(TestCases testCase) {
        super(testCase, screenName);
    }

    public String getScreenName() {
        String screenName = null;
        String pageSource = testCase.getMobileDriver().getPageSource().toUpperCase();
        if (pageSource == null) {
            try {
                Thread.sleep(1000);
                pageSource = testCase.getMobileDriver().getPageSource();
                if (pageSource == null) {
                    Thread.sleep(2000);
                    pageSource = testCase.getMobileDriver().getPageSource();
                }
            } catch (InterruptedException e) {
            }
        }
        if (pageSource.contains("Sign in".toUpperCase()) && pageSource.contains("Create account".toUpperCase())) {
            screenName = "main screen";
        } else if (pageSource.contains("Email".toUpperCase()) && pageSource.contains("Password".toUpperCase())
                && pageSource.contains("SIGN IN".toUpperCase()) && pageSource.contains("Forgot password".toUpperCase())
                && pageSource.contains("New User? Create an Account".toUpperCase())) {
            screenName = "sign in screen";
        } else if (pageSource.contains("Video".toUpperCase()) && pageSource.contains("Air".toUpperCase())) {
            screenName = "dashboard";
        } else if (pageSource.contains("Dashboard".toUpperCase()) && pageSource.contains("Add Device".toUpperCase())
                && pageSource.contains("All Devices".toUpperCase())
                && pageSource.contains("Fuji (In Progress) Add".toUpperCase())
                && pageSource.contains("T5/T6 Smart Thermostat Add".toUpperCase())) {
            screenName = "product list";
        } else if (pageSource.contains("My Account".toUpperCase()) && pageSource.contains("Sign Out".toUpperCase())
                && pageSource.contains("Vacation".toUpperCase()) && pageSource.contains("My Services".toUpperCase())
                && pageSource.contains("Activity".toUpperCase())) {
            screenName = "account menu";
        } else if (pageSource.contains("Details".toUpperCase()) && pageSource.contains("Settings".toUpperCase())
                && pageSource.contains("Name".toUpperCase()) && pageSource.contains("Location".toUpperCase())) {
            screenName = "device settings";
        } else if (pageSource.contains("Dashboard".toUpperCase()) && (pageSource.contains("Modes".toUpperCase())
                || pageSource.contains("An error occurred while syncing your device.".toUpperCase()))) {
            screenName = "primary card";
        } else if (pageSource.contains("will be removed from your account. This cannot be undone.".toUpperCase())
                && pageSource.contains("Delete Device?".toUpperCase())) {
            screenName = "delete popup";
        } else if (pageSource.contains("Model".toUpperCase()) && pageSource.contains("Settings".toUpperCase())
                && pageSource.contains("MAC ID".toUpperCase()) && pageSource.contains("Firmware Version".toUpperCase())
                && pageSource.contains("System Configuration".toUpperCase())) {
            screenName = "device details";
        } else if (pageSource.contains("Device Deleted".toUpperCase())
                && pageSource.contains("You no longer have access to".toUpperCase())) {
            screenName = "device deleted";
        } else if (pageSource.contains("Alert Management")
                && pageSource.contains("Indoor Temperature Alerts".toUpperCase())) {
            screenName = "alert management";
        } else if (pageSource.contains("Schedule".toUpperCase()) && pageSource.contains("Grouped Days".toUpperCase())) {
            screenName = "schedule";
        } else if (pageSource.contains("Use Vacation".toUpperCase())) {
            screenName = "vacation setting";
        } else if (pageSource.contains("Activity Feed".toUpperCase())) {
            screenName = "activity feed";
        } else if (pageSource.contains("Locations".toUpperCase())
                && pageSource.contains("Add Location".toUpperCase())) {
            screenName = "my location";
        } else if (pageSource.contains("Settings".toUpperCase()) && pageSource.contains("App Feedback".toUpperCase())
                && pageSource.contains("Acknowledgements".toUpperCase())) {
            screenName = "app settings";
        } else if (pageSource.contains("Details".toUpperCase()) && pageSource.contains("Settings".toUpperCase())
                && pageSource.contains("Model".toUpperCase()) && pageSource.contains("MAC ID".toUpperCase())) {
            screenName = "device details";
        } else if (pageSource.contains("Air Solution".toUpperCase())
                && pageSource.contains("Air Devices".toUpperCase())) {
            screenName = "air solutions";
        } else if (pageSource.contains("AccuWeather".toUpperCase())
                && pageSource.contains("Now".toUpperCase())) {
            screenName = "weather";

        } else if (pageSource.contains("Installation".toUpperCase())
                && pageSource.contains("Temperature".toUpperCase())) {
            screenName = "advanced setup";
		} else if (pageSource.contains("Dashboard".toUpperCase()) && pageSource.contains("All Devices".toUpperCase())
				&&pageSource.contains("ADD")) {
			 screenName = "choose device";
		} else {
			screenName = "unknown";
		}

        return screenName;
    }

    public boolean clickOnBackToDashBoardTab() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "BackToDashBoardTab");
    }

    public boolean clickOnBackToDashBoardBtn() {
        boolean flag = false;
        WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "BackToDashBoard");
        for (int fraction : new int[]{4, 5, 6}) {
            MobileUtils.clickOnCoordinate(testCase, ele.getSize().getWidth() / 4, ele.getSize().getHeight() / fraction);

            if (getScreenName().contains("DASHBOARD")) {
                flag = true;
                break;
            }
        }
        if (!getScreenName().contains("DASHBOARD")) {
            W3CTouchActions.tap(testCase.getMobileDriver(), ele.getSize().getWidth() / 4, ele.getSize().getHeight() / 2);
            if (getScreenName().contains("DASHBOARD")) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean clickOnCrossBtninAccountMenu() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "CrossBtninAccountMenu");
    }

    public boolean clickOnAlertManagment() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "AlertManagment");
    }

    public boolean clickOnVacationOption() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "VacationOption");
    }

    public boolean clickOnActivityOption() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ActivityOption");
    }

    public boolean clickOnMyLocationOption() {
        if (scrollToExpectedElement("MyLocationOption")) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "MyLocationOption");
        } else {
            return false;
        }
    }

    public boolean clickAppSettingsOption() {
        if (scrollToExpectedElement("AppSettingsOption")) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "AppSettingsOption");
        } else {
            return false;
        }
    }

    public boolean clickOnHamburgerinDashboard(String locationName) {
        if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
            if (MobileUtils.isMobElementExists("XPATH",
                    "//*[contains(@content-desc,'" + locationName + "')]//preceding-sibling::*", testCase)) {
                return MobileUtils.clickOnElement(testCase, "XPATH",
                        "//*[contains(@content-desc,'" + locationName + "')]//preceding-sibling::*");
            } else {
                return MobileUtils.clickOnElement(testCase, "XPATH", "//android.widget.Button");
            }
        } else {
            if (MobileUtils.isMobElementExists("XPATH",
                    "(//*[contains(@name,'" + locationName + "')]//preceding-sibling::*)[2]", testCase)) {
                return MobileUtils.clickOnElement(testCase, "XPATH",
                        "(//*[contains(@name,'" + locationName + "')]//preceding-sibling::*)[2]");
            } else {
                return MobileUtils.clickOnElement(testCase, "XPATH",
                        "(//XCUIElementTypeButton)[1]");
            }
        }
    }

    public boolean navigateToDashboard(String presentScreenName, String locationName) {
        boolean flag = false;
        try {
            FAPrimaryCardScreen pm = new FAPrimaryCardScreen(testCase);
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        String screename = getScreenName();
                        if (screename.toUpperCase().contains("DASHBOARD")) {
                            return true;
                        } else if (screename.toUpperCase().contains("PRIMARY CARD")) {
                            clickOnBackToDashBoardBtn();
                            return false;
                        } else if (screename.toUpperCase().contains("ACCOUNT MENU")) {
                            clickOnCrossBtninAccountMenu();
                            return false;
                        } else if (screename.toUpperCase().contains("AIR SOLUTIONS")) {
                            clickOnBackToDashBoardTab();
                            return false;
                        } else if (screename.toUpperCase().contains("ACTIVITY FEED")) {
                            clickOnHamburgerinDashboard(locationName);
                            clickOnBackToDashBoardTab();
                            return false;
                        } else if (screename.toUpperCase().contains("ACCOUNT MENU")) {
                            clickOnBackToDashBoardTab();
                            return false;
                        } else if (screename.toUpperCase().contains("MAIN SCREEN")) {
                        	LyricUtils.Loginto_FristAlert(testCase, testCase.getTestCaseInputs(), new FirstAlertLoginScreen(testCase));
                            return false;
                        } else {
                            for (int i = 0; i < 6; i++) {
                                screename = getScreenName();
                                if (screename.toUpperCase().contains("PRIMARY CARD")|| screename.toUpperCase().contains("CHOOSE DEVICE")) {
                                    return clickOnBackToDashBoardTab();

                                } else if (screename.toUpperCase().contains("DASHBOARD")) {
                                    return true;
                                }
                                if (pm.isBackBtnPresent())
                                    pm.clickOnBackBtn();
                                if (pm.isExitBtnPresent())
                                    pm.clickOnExitBtn();
                                if (pm.isBackToDashBoardBtnPresent())
                                    pm.clickOnDashboardTab();
                                if (pm.isCancel())
                                    pm.clickOnCancel();
                                if (pm.isOk())
                                    pm.clickOnOk();
                                if (pm.isTryAgainPopUp())
                                    pm.clickOnTryAgainPopUp();
                                if (pm.isDone())
                                    pm.clickOnDone();
                                if (pm.isDismissBtn())
                                    pm.clickOnDismissBtn();

                            }
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

    public boolean clickOnSettingsIcon() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "SettingsIcon");
    }

    public boolean navigateToDeviceSettings(String presentScreenName, String deviceName, String locationName) {

        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToPrimaryCard(presentScreenName, deviceName, locationName)) {
                            return clickOnSettingsIcon();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean navigateToPrimaryCard(String presentScreenName, String deviceName, String locationName) {
        boolean flag = false;
        try {
            FAPrimaryCardScreen pm = new FAPrimaryCardScreen(testCase);
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(2));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        String screename = getScreenName();
                        if (screename.contains("primary card")) {
                            return true;
                        } else if (screename.equals("air solutions")) {
                            System.out.println("air solutions");
                            clickOnBackToDashBoardTab();
                            return false;
                        } else if (screename.equals("weather")) {
                            System.out.println("weather");
                            clickOnBackToDashBoardTab();
                            return false;
                        } else if (screename.equals("dashboard")) {
                            pm.clickOnLocationNameFromDashboard(locationName);
                            pm.clickOnDeviceNameFromDashboard(deviceName);
                            return false;

                        } else if (screename.equals("Schedule")) {
                            System.out.println("Currently in Schedule Screen.");
                            pm.clickOnBackBtn();
                            return false;
                        } else if (screename.equals("device settings")) {
                            System.out.println("Currently in Device Setting Screen.");
                            pm.clickOnBackBtn();
                            return false;
                        } else {
                            pm.clickOnBackBtn();
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

    public boolean navigateToAlertManagement(String presentScreenName, String deviceName, String locationName) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToDeviceSettings(presentScreenName, deviceName, locationName)) {
                            return clickOnAlertManagment();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;
    }

    public boolean navigateToVacation(String presentScreenName, String locationName) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToAccountMenu(presentScreenName, locationName)) {
                            return clickOnVacationOption();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean navigateToActivityFeed(String presentScreenName, String locationName) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToAccountMenu(presentScreenName, locationName)) {
                            return clickOnActivityOption();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean navigateToAccountMenu(String presentScreenName, String locationName) {

        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToDashboard(presentScreenName, locationName)) {
                            return clickOnHamburgerinDashboard(locationName);
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean navigateToMyLocation(String presentScreenName, String locationName) {

        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToAccountMenu(presentScreenName, locationName)) {
                            return clickOnMyLocationOption();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean scrollToExpectedElement(String locatorType) {
        boolean flag = false;
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int endY = (int) (dimens.getHeight() * 0.2);
        int startY = (int) (dimens.getHeight() * 0.65);
        for (int i = 0; i <= 5; i++) {
            if (MobileUtils.isMobElementExists(objectDefinition, testCase, locatorType, 5)) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully Scrolled to Expected Element");
                break;
            } else {
                if (testCase.getMobileDriver().getPlatformName().toUpperCase().contains("ANDROID")) {
                    W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
                } else {
                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                    Sequence swipe = new Sequence(finger, 1);
                    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
                    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, endY));
                    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    ((AppiumDriver) testCase.getMobileDriver()).perform(Collections.singletonList(swipe));
                }
            }
        }
        flag = flag;
        return flag;
    }

    public boolean scrollToExpectedElement(String locatortype, String locatorValue) {
        boolean flag = false;
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int endY = (int) (dimens.getHeight() * 0.3);
        int startY = (int) (dimens.getHeight() * 0.6);
        for (int i = 0; i <= 5; i++) {
            if (MobileUtils.isMobElementExists(locatortype, locatorValue, testCase, 2)) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully Scrolled to Expected Element");
                break;
            } else {
                W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
            }
        }
        flag = flag;
        return flag;
    }

    public boolean navigateToAppSettings(String presentScreenName, String locationName) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToAccountMenu(presentScreenName, locationName)) {
                            return clickAppSettingsOption();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    public boolean navigateToDeviceDetails(String presentScreenName, String deviceName, String locationName) {

        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToDeviceSettings(presentScreenName, deviceName, locationName)) {
                            return clickOnDetailsTab();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    protected Boolean clickOnDetailsTab() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "DetailsTab");
    }

    public boolean navigateToScheduleScreen(String presentScreenName, String deviceName, String locationName) {

        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(2));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToPrimaryCard(presentScreenName, deviceName, locationName)) {
                            if (scrollToExpectedElement("ScheduleNowTab")) {
                                return clickOnScheduleNowTab();
                            }
                            return false;
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen.");
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Not able to login or might need to check the app flow");
            flag = false;
        }
        return flag;

    }

    protected Boolean clickOnScheduleNowTab() {
        return MobileUtils.clickOnElement(objectDefinition, testCase, "ScheduleNowTab");
    }

    public boolean navigateToAdvancedSetup(String presentScreenName, String deviceName, String locationName) {
        boolean flag = false;
        try {
            FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
            fWait.pollingEvery(Duration.ofSeconds(1));
            fWait.withTimeout(Duration.ofMinutes(3));
            Boolean isEventReceived = fWait.until(new Function<CustomDriver, Boolean>() {
                public Boolean apply(CustomDriver driver) {
                    try {
                        if (navigateToDeviceSettings(presentScreenName, deviceName, locationName)) {
                            return clickAdvancedSetupOption();
                        }
                    } catch (Exception e) {
                        Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                                "Not able navigate to Device setting Screen." + e.getMessage());
                        return false;
                    }
                    return false;
                }
            });
            if (isEventReceived) {
                flag = true;
            }
        } catch (Exception e) {
            Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
                    "Unexpected error during navigation: " + e.getMessage());
            flag = false;
        }
        return flag;

    }

    public boolean clickAdvancedSetupOption() {
        if (scrollToExpectedElement("AdvancedSetupBtn")) {
            return MobileUtils.clickOnElement(objectDefinition, testCase, "AdvancedSetupBtn");
        } else {
            return false;
        }
    }

    public boolean scrollToExpectedElementVertically(String locatortype, String locatorValue, String scrollDirection) {
        boolean flag = false;
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int startY, endY;
        if (scrollDirection.equalsIgnoreCase("down")) {
            startY = (int) (dimens.getHeight() * 0.3);
            endY = (int) (dimens.getHeight() * 0.6);
        } else if (scrollDirection.equalsIgnoreCase("up")) {
            startY = (int) (dimens.getHeight() * 0.6);
            endY = (int) (dimens.getHeight() * 0.3);
        } else {
            throw new IllegalArgumentException("Invalid direction. Use 'up' or 'down'.");
        }
        for (int i = 0; i <= 5; i++) {
            if (MobileUtils.isMobElementExists(locatortype, locatorValue, testCase, 2)) {
                flag = true;
                Keyword.ReportStep_Pass(testCase, "Successfully Scrolled to Expected Element");
                break;
            } else {
                if (testCase.getMobileDriver().getPlatformName().toUpperCase().contains("ANDROID")) {
                    W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
                } else {
                    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                    Sequence swipe = new Sequence(finger, 1);
                    swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
                    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, endY));
                    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
                    ((AppiumDriver) testCase.getMobileDriver()).perform(Collections.singletonList(swipe));
                }

            }
        }
        return flag;
    }

    public void scrollUp() {
        boolean flag = false;
        Dimension dimens = testCase.getMobileDriver().manage().window().getSize();
        int x = (int) (dimens.getWidth() * 0.5);
        int startY, endY;
        startY = (int) (dimens.getHeight() * 0.3);
        endY = (int) (dimens.getHeight() * 0.6);
        if (testCase.getMobileDriver().getPlatformName().toUpperCase().contains("ANDROID")) {
            W3CTouchActions.swipe(testCase.getMobileDriver(), x, startY, x, endY, Duration.ofMillis(2000));
        } else {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            ((AppiumDriver) testCase.getMobileDriver()).perform(Collections.singletonList(swipe));
        }
    }
}