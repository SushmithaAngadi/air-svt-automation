package com.resideo.commons.mobile;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Local override of CustomDriver from Core_Framework 1.0.1.
 * Adds missing methods (getPlatformName, terminateApp, activateApp, closeApp)
 * that the project requires for Appium operations.
 */
public interface CustomDriver extends WebDriver {

    // Existing methods from Core_Framework
    WebElement scrollTo(String text);

    WebElement scrollToExact(String text);

    void swipe(int startX, int startY, int endX, int endY, int... duration);

    Capabilities getCapabilities();

    boolean tap(int fingers, int x, int y, int... duration);

    Object executeScript(String command, Map<String, String> params);

    Set<String> getContextHandles();

    // Additional methods required by the project (Appium-specific)
    default String getPlatformName() {
        Capabilities caps = getCapabilities();
        if (caps != null && caps.getCapability("platformName") != null) {
            return caps.getCapability("platformName").toString();
        }
        return "";
    }

    default void terminateApp(String bundleId) {
        // Delegates to Appium's terminateApp via executeScript
        java.util.Map<String, String> params = new java.util.HashMap<>();
        params.put("bundleId", bundleId);
        try {
            executeScript("mobile: terminateApp", params);
        } catch (Exception e) {
            // Fallback: try with appId parameter
            params.clear();
            params.put("appId", bundleId);
            executeScript("mobile: terminateApp", params);
        }
    }

    default void activateApp(String bundleId) {
        java.util.Map<String, String> params = new java.util.HashMap<>();
        params.put("bundleId", bundleId);
        try {
            executeScript("mobile: activateApp", params);
        } catch (Exception e) {
            params.clear();
            params.put("appId", bundleId);
            executeScript("mobile: activateApp", params);
        }
    }

    default void closeApp() {
        // Deprecated in Appium 2.x - use terminateApp instead
        try {
            Capabilities caps = getCapabilities();
            if (caps != null) {
                Object appPackage = caps.getCapability("appPackage");
                Object bundleId = caps.getCapability("bundleId");
                String appId = appPackage != null ? appPackage.toString()
                        : (bundleId != null ? bundleId.toString() : "");
                if (!appId.isEmpty()) {
                    terminateApp(appId);
                }
            }
        } catch (Exception e) {
            // Best effort
        }
    }
}
