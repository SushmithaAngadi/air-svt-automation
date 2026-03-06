package com.resideo.utils.resideo_app.screen;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;

import org.openqa.selenium.WebElement;

public class LoginScreen extends MobileScreens {

	private static final String screenName = "LoginScreen";

	public LoginScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isLoginButtonVisible() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginButton", 15)) {
			return true;
		} else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginBT", 15)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isLyricLogoVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "LyricLogo", 3);
	}

	public boolean longPressOnSecretMenuImage() {
		boolean flag = true;
		WebElement element = null;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			element = MobileUtils.getMobElement(objectDefinition, testCase, "HoneywellRosette");
			flag = flag & MobileUtils.longPress(testCase, element, 8000);
		} else {
			element = MobileUtils.getMobElement(objectDefinition, testCase, "SecretMenuImage");
			flag = flag & MobileUtils.longPress(testCase, element, 8000);
		}
		return flag;
	}

	public boolean isSkipButtonVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SkipIntroButton", 3);
	}

	public boolean clickOnSkipIntroButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SkipIntroButton");
	}

	public boolean clickOnLyricLogo() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LyricLogo");
	}

	public boolean isHonUnexpectedQuitPopupVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HoneywellUnexpectedQuitPopup", timeOut);
	}

	public boolean clickOnAlwaysSendButton() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AlwaysSendButton1", 3))
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AlwaysSendButton1");
		else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "AlwaysSendButton2", 3))
			return MobileUtils.clickOnElement(objectDefinition, testCase, "AlwaysSendButton2");
		else
			return false;
	}

	public boolean isEmailAddressTextFieldVisible() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmailAddress", 3);
	}

	public boolean isEmailAddressTextFieldVisible(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmailAddressTB", timeOut);
	}

	public boolean clickOnLoginButton() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "LoginBT", 3)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "LoginBT");
		} else {
			return false;
		}
	}

	public boolean setEmailAddressValue(String value) {
		boolean flag = MobileUtils.clickOnElement(objectDefinition, testCase, "EmailAddressTB");
		return flag && MobileUtils.setValueToElement(objectDefinition, testCase, "EmailAddressTB", value);
	}

	public boolean setPasswordValue(String value) {
		boolean flag = MobileUtils.clickOnElement(objectDefinition, testCase, "PasswordTB");
		return flag && MobileUtils.setValueToElement(objectDefinition, testCase, "PasswordTB", value);
	}

	public String getPresentScreenName() {
		String screenNameFromPage = "";
		String pageSource = testCase.getMobileDriver().getPageSource();
		if (pageSource.contains("Create Account") && pageSource.contains("Log In")) {
			screenNameFromPage = "intialscreen";
		} else if (pageSource.contains("signInName") && pageSource.contains("password")
				&& pageSource.contains("Forgot your password?")) {
			screenNameFromPage = "loginscreen";
		} else if (pageSource.contains("security_pin_title_tv") && pageSource.contains("pin_editbox")
				|| pageSource.toUpperCase().contains("app passcode".toUpperCase())) {
			screenNameFromPage = "securitypinscreen";
		} else if (pageSource.contains("coach_mark_layout") && pageSource.contains("msg_layout")
				&& pageSource.contains("btn_positive_got_it")) {
			screenNameFromPage = "coachscreen";
		} else if (pageSource.contains("Main Menu") && pageSource.contains("dashboard_recyclerview")
				&& pageSource.contains("weather_header_message") && pageSource.contains("device_view")
				&& pageSource.contains("dashboard_add_device")) {
			screenNameFromPage = "dashboard_withdevice_addnewdevice";
		} else if (pageSource.contains("Main Menu") && pageSource.contains("dashboard_recyclerview")
				&& pageSource.contains("weather_header_message") && pageSource.contains("dashboard_add_device")) {
			screenNameFromPage = "dashboard_addnewdevice";
		} else if ((pageSource.contains("Main Menu") && pageSource.contains("dashboard_recyclerview")
				&& pageSource.contains("weather_header_message"))
				|| (pageSource.contains("menu") && pageSource.contains("Add New Device"))) {
			screenNameFromPage = "dashboard";
		} else if (pageSource.contains("Improve the app") && pageSource.contains("button_allow")
				&& pageSource.contains("Don't Allow")) {
			screenNameFromPage = "improvetheappscreen";
		}
		return screenNameFromPage;
	}

	public boolean isHoneywellAccountCreate_LoginScreen() {
		String pageSource = testCase.getMobileDriver().getPageSource();
		if (pageSource.contains("Create Account") || pageSource.contains("Log In")) {
			return true;
		} else {
			return false;
		}

	}

}
