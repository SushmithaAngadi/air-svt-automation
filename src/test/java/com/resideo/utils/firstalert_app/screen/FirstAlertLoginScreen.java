package com.resideo.utils.firstalert_app.screen;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;

public class FirstAlertLoginScreen extends MobileScreens {
	private static final String screenName = "FirstAlertLoginScreen";

	public FirstAlertLoginScreen(TestCases testCase) {
		super(testCase, screenName);
	}
	
	public boolean clickOnFirstAlertloginButton() {
		if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SignInTOFristAlertProdcution", 10)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInTOFristAlertProdcution");
		} else if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SignInTOFristAlertNonProd", 10)) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInTOFristAlertNonProd");
		} else {
			Keyword.ReportStep_Fail(testCase, 0,
					"Testcase failed the element is not matching with definition, pls check the login screen");
			return false;
		}
	}
	
	public boolean setEmailAddressInLogin(String userName) {
		return MobileUtils.setValueToElement(objectDefinition, testCase, "SIgnEmailTextBox", userName);
	}

	public boolean setSignPassword(String password) {
		return MobileUtils.setValueToElement(objectDefinition, testCase, "SignPasswordTextBox", password);
	}

	public boolean clickOnSignINButton() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
		} else {
			if (MobileUtils.isMobElementExists("name", "Done", testCase, 2)) {
				MobileUtils.clickOnElement(testCase, "name", "Done");
				return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
			} else {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "SignInButton");
			}
		}
	}
	
	public boolean clickOnBackButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackButton");
	}

	public boolean clickOnCancelButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelButton");
	}
	
	
	public boolean clickOnSkipButton() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SkipButton");
	}
	
	public boolean clickOnL5LeakProtectionValve() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "L5LeakProtectionValve");
	}
	
	public boolean clickOnT5_T6_SmartThermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "T5T6_SmartThermostat");
	}
	
	public boolean clickOnL2_Wifi_WaterSensorAndSwitch() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "L2WifiSmartSensorSwitch");
	}
	
	public boolean clickOnL1_Wifi_WaterSensorAndSwitch() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "L1WifiSmartensorSwitch");
	}
	
	public boolean clickOnT9_T10_SmartThermostat() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "T9T10SmartThermostat");
	}
	
	public boolean clickOnVX1_HD_Video_DoorBell() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VX1HDVideoDoorBell");
	}

	public boolean isMaintenanceScreenPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "MaintenanceScreenPresent");
	}

	public boolean clickOnOkBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OkBtn");
		
	}
	
	public boolean isSettingBtnPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SettingBtn");
	}

	public boolean clickOnSettingBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SettingBtn");
	}

	public boolean clickOnLoginEnvTab() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LoginEnvTab");
	}

	public boolean clickOnReqEnv(String env) {
		if(env.toUpperCase().contains("QA") || env.toUpperCase().contains("DEV")) {
			env="Development";
		}else if(env.toUpperCase().contains("STAGE") ) {
			env="Stage";
		}else if(env.toUpperCase().contains("PROD") ) {
			env="Production";
		}
		return MobileUtils.clickOnElement(testCase,"XPATH", "(//*[@content-desc='" + env + "']/following-sibling::android.widget.RadioButton)[1]");
	}

	public boolean verifyLoginEnv(String env) {
		if(env.toUpperCase().contains("QA") || env.toUpperCase().contains("DEV")) {
			env="dev";
		}else if(env.toUpperCase().contains("STAGE") ) {
			env="stage";
		}else if(env.toUpperCase().contains("PROD") ) {
			env="prod";
		}
		return MobileUtils.isMobElementExists("XPATH", "//*[contains(@resource-id,'login_environment') and contains(@content-desc,'" + env + "') ]", testCase);
	}

	public boolean clickOnResideoProloginButton() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ResideoProloginButton");
	}
	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
//	
//	public boolean clickOn() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//	}
	
}
