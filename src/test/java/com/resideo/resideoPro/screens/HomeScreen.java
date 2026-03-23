package com.resideo.utils.resideo_app.screen;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;

public class HomeScreen extends MobileScreens {

	private static final String screenName = "HomeScreen";

	public HomeScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isHomeScreen() {
		boolean flag = false;

		return flag;
	}

	public boolean enterPasscode(String passcode) {
		return MobileUtils.setValueToElement(objectDefinition, testCase, "Passcode", passcode,
				"Entered is Passcode : " + passcode);
	}

	public boolean closeWelcomeBackPopUP() {
		boolean flag = false;
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "WelcomeBackMessage"))
			flag = MobileUtils.clickOnElement(objectDefinition, testCase, "DontAskAgainButton");
		return flag;
	}

	public boolean allowAndroidDeviceLocationAccess() {
		boolean flag = false;
		if (MobileUtils.isMobElementExists("ID", "permission_message", testCase))
			flag = MobileUtils.clickOnElement(testCase, "XPATH", "//*[@text='While using the app']");
		return flag;
	}

}
