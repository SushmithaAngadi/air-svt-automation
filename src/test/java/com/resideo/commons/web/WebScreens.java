package com.resideo.commons.web;

import java.util.HashMap;

import com.resideo.commons.coreframework.TestCases;

/**
 * Base class for web-based screen objects (e.g., router configuration screens).
 * Mirrors the pattern of MobileScreens but for web UI testing.
 * Loads WebObject definitions from JSON files in objects_definition/WebObjectDefinition/.
 */
public class WebScreens {

    protected TestCases testCase;
    protected HashMap<String, WebObject> fieldObjects;
    private String screenName;

    public WebScreens(TestCases testCase, String screenName) {
        this.testCase = testCase;
        this.screenName = screenName;
        this.fieldObjects = WebUtils.loadObjectFile(testCase, screenName);
    }

    public WebScreens(TestCases testCase) {
        this.testCase = testCase;
        this.screenName = "";
        this.fieldObjects = new HashMap<>();
    }

    public String getScreenName() {
        return screenName;
    }

    public HashMap<String, WebObject> getFieldObjects() {
        return fieldObjects;
    }
}
