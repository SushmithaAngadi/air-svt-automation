package com.resideo.utils.firstalert_app.screen;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

import com.resideo.utils.W3CTouchActions;

public class FADeviceDetailsScreen extends MobileScreens {
	private static final String screenName = "FADeviceDetailsScreen";

	public FADeviceDetailsScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public String getHeatingSystem() {
		String HeatingSystem = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (scroolToExpectedElement("HeatingSystem")) {
				HeatingSystem = MobileUtils.getAttribute(testCase, objectDefinition, "HeatingSystem", "content-desc")
						.toUpperCase();
			}
		} else {
			if (scroolToExpectedElement("HeatingSystem")) {
				HeatingSystem = MobileUtils.getAttribute(testCase, objectDefinition, "HeatingSystem", "name")
						.toUpperCase();
			}
		}
		return HeatingSystem;
	}

	public String getHeatingStages() {
		String HeatingStages = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (scroolToExpectedElement("HeatingStages")) {
				return MobileUtils.getAttribute(testCase, objectDefinition, "HeatingStages", "content-desc")
						.toUpperCase();
			}
		} else {
			if (scroolToExpectedElement("HeatingStages")) {
				return MobileUtils.getAttribute(testCase, objectDefinition, "HeatingStages", "name").toUpperCase();
			}
		}
		return HeatingStages;
	}
	public boolean isHeatingStagesPresent() {
		return scroolToExpectedElement("HeatingStages");
	}

	public String getCoolingStages() {
		String CoolingStages = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (scroolToExpectedElement("CoolingStages")) {
				return MobileUtils.getAttribute(testCase, objectDefinition, "CoolingStages", "content-desc")
						.toUpperCase();
			}
		} else {
			if (scroolToExpectedElement("CoolingStages")) {
				return MobileUtils.getAttribute(testCase, objectDefinition, "CoolingStages", "name").toUpperCase();
			}
		}
		return CoolingStages;
	}
	
	public boolean isCoolingStagesPresent() {
		return scroolToExpectedElement("CoolingStages");
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

	public boolean isHeatingSystemPresent() {
		return scroolToExpectedElement("HeatingSystem");
	}

}