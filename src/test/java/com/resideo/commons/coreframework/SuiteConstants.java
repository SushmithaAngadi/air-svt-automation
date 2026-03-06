package com.resideo.commons.coreframework;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * Local override of SuiteConstants from Core_Framework 1.0.1.
 * Adds missing enum values (NETWORK_TRAFFIC_PERFORMANCE, ROUTER_IOP_AUTOMATION)
 * and the setConstantValue method that the project requires.
 */
public class SuiteConstants {

    private static int MAX_RETRY;
    private static final java.util.HashMap<SuiteConstantTypes, Properties> constantsMap = new java.util.HashMap<>();

    public enum SuiteConstantTypes {
        SELENIUM_GRID("SeleniumGrid"),
        XRAY("XRay"),
        APPIUM("Appium"),
        MOBILE_APP("MobileApp"),
        SAUCELABS("SauceLabs"),
        PERFECTO("Perfecto"),
        PCLOUDY("pCloudy"),
        TEST_SUITE("TestSuite"),
        XLTV_SERVER("XLTVServer"),
        PROJECT_SPECIFIC("ProjectSpecific"),
        WEB_APP("WebApp"),
        APP_NAME_FORMAT("AppNameFormat"),
        RESULT_EMAIL_RECIPIENTS("ResultEmailRecipients"),
        DESIRED_CAPABILITIES_PROPERTIES("DesiredCapabilities"),
        POST_TESTCASE_STEPS("PostTestCaseSteps"),
        DEVICE_POOL_FILTERS("DevicePoolFilters"),
        POST_GROUP_EXECUTION("PostGroupExecution"),
        PRE_GROUP_EXECUTION("PreGroupExecution"),
        MOBILE_DRIVER_INSTANTIATOR("MobileDriverInstantiators"),
        LAMBDATEST("LambdaTest"),
        // Additional constants required by the project
        NETWORK_TRAFFIC_PERFORMANCE("NetworkTrafficPermance"),
        ROUTER_IOP_AUTOMATION("RouterIOPAutomation"),
        ROBOTIC_ARM("RoboticSpec"),
        RESULT_UPLOAD("ResultUpload"),
        THERMOSTAT_SPECIFIC("ThermostatSpecific");

        private final String constantType;

        SuiteConstantTypes(String constantType) {
            this.constantType = constantType;
        }

        public String getConstantType() {
            return constantType;
        }
    }

    public SuiteConstants() {
    }

    public static int getMAX_RETRYCount() {
        return MAX_RETRY;
    }

    public static void setMAX_RETRY(int maxRetry) {
        MAX_RETRY = maxRetry;
    }

    public static Set<Object> getAvailableKeys(SuiteConstantTypes type) throws Exception {
        Properties props = getOrLoadProperties(type);
        return props.keySet();
    }

    public static String getConstantValue(SuiteConstantTypes type, String key) throws Exception {
        Properties props = getOrLoadProperties(type);
        return props.getProperty(key, "");
    }

    public static String setConstantValue(SuiteConstantTypes type, String key, String value) {
        Properties props = constantsMap.computeIfAbsent(type, k -> {
            try {
                return loadProperties(k);
            } catch (Exception e) {
                return new Properties();
            }
        });
        props.setProperty(key, value);
        return value;
    }

    private static Properties getOrLoadProperties(SuiteConstantTypes type) throws Exception {
        return constantsMap.computeIfAbsent(type, k -> {
            try {
                return loadProperties(k);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static Properties loadProperties(SuiteConstantTypes type) throws Exception {
        Properties props = new Properties();
        String fileName = type.getConstantType() + ".properties";
        InputStream is = SuiteConstants.class.getClassLoader().getResourceAsStream("Properties/" + fileName);
        if (is != null) {
            props.load(is);
            is.close();
        }
        return props;
    }

    static {
        // Pre-load all property files
        for (SuiteConstantTypes type : SuiteConstantTypes.values()) {
            try {
                constantsMap.put(type, loadProperties(type));
            } catch (Exception e) {
                constantsMap.put(type, new Properties());
            }
        }
    }
}
