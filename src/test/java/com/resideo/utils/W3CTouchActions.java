package com.resideo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Collections;

/**
 * W3C Actions replacement for the deprecated TouchAction API (removed in Appium Java Client 9.x).
 * Provides static helper methods for common touch gestures: swipe, tap, and long press.
 */
public class W3CTouchActions {

    private W3CTouchActions() {
        // utility class
    }

    /**
     * Performs a swipe gesture from (startX, startY) to (endX, endY).
     *
     * @param driver   the WebDriver (AppiumDriver / RemoteWebDriver)
     * @param startX   starting X coordinate
     * @param startY   starting Y coordinate
     * @param endX     ending X coordinate
     * @param endY     ending Y coordinate
     * @param duration how long the swipe takes (controls speed)
     */
    public static void swipe(WebDriver driver, int startX, int startY, int endX, int endY, Duration duration) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(duration, PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Collections.singletonList(swipe));
    }

    /**
     * Performs a tap gesture at the given coordinates.
     *
     * @param driver the WebDriver
     * @param x      X coordinate
     * @param y      Y coordinate
     */
    public static void tap(WebDriver driver, int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Collections.singletonList(tap));
    }

    /**
     * Performs a long press at the given coordinates.
     *
     * @param driver   the WebDriver
     * @param x        X coordinate
     * @param y        Y coordinate
     * @param holdTime how long to hold the press
     */
    public static void longPress(WebDriver driver, int x, int y, Duration holdTime) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 1);
        longPress.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, holdTime));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((RemoteWebDriver) driver).perform(Collections.singletonList(longPress));
    }
}
