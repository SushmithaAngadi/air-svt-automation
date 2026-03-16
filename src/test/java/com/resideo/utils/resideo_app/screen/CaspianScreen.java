package com.resideo.utils.resideo_app.screen;

import org.openqa.selenium.interactions.Actions;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.system.utils.SystemState;

import org.openqa.selenium.WebElement;

public class CaspianScreen extends MobileScreens {

	private static final String screenName = "CaspianScreen";

	public CaspianScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public String getDeviceStatusFromDashboard() {
		String status=null;
		try {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + SystemState.getStatus().getTstatName()
						+ "']/following-sibling::android.widget.TextView", testCase, 1)) {
					status= MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='"
							+ SystemState.getStatus().getTstatName() + "']/following-sibling::android.widget.TextView")
							.getText();
				} else if (MobileUtils.isMobElementExists("XPATH",
						"//android.widget.TextView[contains(@resource-id,'secondary_text')]", testCase, 1)) {
					status= MobileUtils.getMobElement(testCase, "XPATH",
							"//android.widget.TextView[contains(@resource-id,'secondary_text')]").getText();

				} else {
					status= null;
				}

			} else {
				status= MobileUtils.getMobElement(testCase, "XPATH", "//XCUIElementTypeButton[@value='"
						+ SystemState.getStatus().getTstatName() + "']/following-sibling::XCUIElementTypeStaticText")
						.getDomAttribute("name");
			}
		} catch (Exception e) {
			System.out.println("Exception Raised due to " + e.getStackTrace());
			status= null;
		}
		return status;
	}
	// *[@text='Garage']/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.TextView

	public String getDeviceMessageFromDashboard() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists("XPATH", "//*[@text='" + SystemState.getStatus().getTstatName()
					+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.TextView",
					testCase, 2)) {

				return MobileUtils.getMobElement(testCase, "XPATH", "//*[@text='"
						+ SystemState.getStatus().getTstatName()
						+ "']/parent::android.widget.LinearLayout/following-sibling::android.widget.RelativeLayout/android.widget.TextView")
						.getText();

			} else if (MobileUtils.isMobElementExists("XPATH",
					"//android.widget.TextView[contains(@resource-id,'status')]", testCase, 1)) {
				return MobileUtils
						.getMobElement(testCase, "XPATH", "//android.widget.TextView[contains(@resource-id,'status')]")
						.getText();
			} else {
				return null;
			}

		} else {
			if (MobileUtils
					.isMobElementExists("XPATH",
							"//XCUIElementTypeButton[@value='" + SystemState.getStatus().getTstatName()
									+ "']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText",
							testCase, 2)) {
				return MobileUtils
						.getMobElement(testCase, "XPATH",
								"//XCUIElementTypeButton[@value='" + SystemState.getStatus().getTstatName()
										+ "']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText")
						.getDomAttribute("name");
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@name='title']/preceding-sibling::XCUIElementTypeStaticText", testCase, 3)) {
				return MobileUtils.getMobElement(testCase, "XPATH",
						"//*[@name='title']/preceding-sibling::XCUIElementTypeStaticText").getDomAttribute("name");
			} else if (MobileUtils.isMobElementExists("XPATH",
					"//*[@name='title']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText", testCase,
					3)) {
				return MobileUtils
						.getMobElement(testCase, "XPATH",
								"//*[@name='title']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText")
						.getDomAttribute("name");
			} else {
				return null;
			}
		}
	}

	public String getDeviceMessageFromDashboardinIOS() {
		return MobileUtils
				.getMobElement(testCase, "XPATH",
						"(//*[@name='" + SystemState.getStatus().macIDName() + "']/XCUIElementTypeStaticText)[1]")
				.getDomAttribute("name");
	}

	// XCUIElementTypeButton[@value='VALVE
	// 1D8AEB']/following-sibling::XCUIElementTypeButton/XCUIElementTypeStaticText
	public boolean clickOnExactDeviceName() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//*[@text='" + SystemState.getStatus().getTstatName() + "']");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH",
					"//XCUIElementTypeButton[contains(@value,'" + SystemState.getStatus().getTstatName() + "')]");
		}

	}

	public boolean clickOnfirstDeviceName() {
		return MobileUtils.clickOnElement(testCase, "ID", "dashboard_device_name");
	}

	public boolean clickonSettingButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "PrimarycardSettingsButton");
	}

	public boolean clickonValveconfigurationButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ValveconfigurationButton");
	}

	public boolean clickOnDeleteValveButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteValveButton");
	}

	public boolean clickOnDeleteValvePopupButton() {
		boolean flag = false;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DeleteValvePopupButton");
		} else {
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "DeleteValvePopupButton");
			Actions ac = new Actions(testCase.getMobileDriver());
			ac.click(mobElement).perform();
			flag = true;
		}
		return flag;
	}

	public boolean clickOnGetStartedScreen() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "GetStartedScreen");
	}

	public boolean clickOnNextButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "NextButton");
	}

//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
	public boolean clickOn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
	}

	public boolean isPrimarycardSettingsButton(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "PrimarycardSettingsButton", timeOut);
	}

	public boolean isDeleteValvePopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDeleteValvePopUp", 40);
	}

	public boolean isDashboardScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsDashboardScreen", 120);
	}

	public boolean isGetStartedScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "GetStartedScreen", 10);
	}

	public boolean isMaintenanceCycleScreen() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "IsMaintenanceCycleScreen", 6);
	}

	public boolean isFirstDeviceName() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "dashboard_device_name");
	}

	public boolean isExactDevicePresent() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[@text='" + SystemState.getStatus().getTstatName() + "']", testCase, 4);
		} else {
			return MobileUtils.isMobElementExists("XPATH",
					"//*[contains(@value,'" + SystemState.getStatus().getTstatName() + "')]", testCase, 4);
		}
	}

	public boolean is() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
	}
}