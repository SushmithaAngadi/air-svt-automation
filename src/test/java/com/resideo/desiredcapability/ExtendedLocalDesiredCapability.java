package com.resideo.desiredcapability;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.resideo.commons.coreframework.SuiteConstants;
import com.resideo.commons.coreframework.SuiteConstants.SuiteConstantTypes;
import com.resideo.commons.coreframework.TestCaseInputs;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.deviceCloudProviders.LocalExecutionDesiredCapability;
import com.resideo.commons.mobile.Mobile;

public class ExtendedLocalDesiredCapability extends LocalExecutionDesiredCapability {

	private TestCaseInputs inputs;
	DesiredCapabilities desiredCapabilities;
	public ExtendedLocalDesiredCapability(TestCases testCase, TestCaseInputs inputs) {
		super(testCase, inputs);
		this.inputs = inputs;
		
	}

	@Override
	public void additionalDesiredCapabilities() {
		try {
			desiredCapabilities = getDesiredCapabilities();
			desiredCapabilities.setCapability("browserName", "");
			desiredCapabilities.setCapability("appium:noReset", true);
			desiredCapabilities.setCapability("appium:fullReset", false);
			desiredCapabilities.setCapability("appium:commandTimeout", 3000000);
			desiredCapabilities.setCapability("appium:idleTimeout", 3000000);
			desiredCapabilities.setCapability("appium:newCommandTimeout", 50000);

			if (inputs.getInputValue(TestCaseInputs.OS_NAME).equalsIgnoreCase(Mobile.IOS)) {
				if (inputs.isRealDevice()) {
					desiredCapabilities.setCapability("appium:autoAcceptAlerts", false);
					desiredCapabilities.setCapability("appium:autoDismissAlerts", false);
					desiredCapabilities.setCapability("appium:realDeviceLogger",
							SuiteConstants.getConstantValue(SuiteConstantTypes.PROJECT_SPECIFIC, "IOS_DEVICE_CONSOLE_PATH"));
					try {
						String wdaBundleId = SuiteConstants.getConstantValue(SuiteConstantTypes.APP_NAME_FORMAT, "WDA_BUNDLE_ID");
						if (wdaBundleId != null && !wdaBundleId.trim().isEmpty()) {
							desiredCapabilities.setCapability("appium:updatedWDABundleId", wdaBundleId.trim());
						}
					} catch (Exception ignored) { }
					desiredCapabilities.setCapability("appium:useNewWDA", false);
					desiredCapabilities.setCapability("appium:wdaLocalPort", 8100);
					desiredCapabilities.setCapability("appium:showXcodeLog", true);
					desiredCapabilities.setCapability("appium:usePrebuiltWDA", true);
					desiredCapabilities.setCapability("appium:preventWDAAttachments", true);
					desiredCapabilities.setCapability("appium:wdaStartupRetries", 0);
					desiredCapabilities.setCapability("appium:preventWDAUninstall", true);
					desiredCapabilities.setCapability("appium:skipInstall", true);
					desiredCapabilities.setCapability("appium:derivedDataPath", "/tmp/WebDriverAgent-derived");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
