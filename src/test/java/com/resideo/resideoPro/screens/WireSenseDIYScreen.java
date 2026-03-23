package com.resideo.utils.resideo_app.screen;

import java.time.Duration;
import java.util.function.Function;

import javax.annotation.CheckForNull;

import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.CustomDriver;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

import org.openqa.selenium.WebElement;

public class WireSenseDIYScreen extends MobileScreens {

	private static final String screenName = "HoudiniDIYScreen";

	public WireSenseDIYScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean is_AL_A_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "ALPerACheckBX").isSelected();
	}

	public boolean is_R_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "RCheckBX").isSelected();
	}

	public boolean is_C_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "CCheckBX").isSelected();
	}

	public boolean is_Rc_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "RcCheckBX").isSelected();
	}

	public boolean is_E_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "ECheckBX").isSelected();
	}

	public boolean is_W_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "WCheckBX").isSelected();
	}

	public boolean is_G_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "GCheckBX").isSelected();
	}

	public boolean is_W2_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "w2CheckBX").isSelected();
	}

	public boolean is_K_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "KCheckBX").isSelected();
	}

	public boolean is_Y1_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "Y1CheckBX").isSelected();
	}

	public boolean is_O_B_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "OperBCheckBX").isSelected();
	}

	public boolean is_Y2_Checked() {
		return MobileUtils.getMobElement(objectDefinition, testCase, "Y2CheckBX").isSelected();
	}

	public boolean isManualWiringBtn(int timeOut) {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ManualWiringBtn", timeOut);
	}

	public boolean ClickOnValidWireSensing() {
		FluentWait<CustomDriver> fWait = new FluentWait<CustomDriver>(testCase.getMobileDriver());
		fWait.pollingEvery(Duration.ofMillis(600));
		fWait.withTimeout(Duration.ofSeconds(30));
		try {
			Boolean success = fWait.until(new Function<CustomDriver, Boolean>() {
				public Boolean apply(CustomDriver driver) {
					if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
						return MobileUtils.isMobElementExists("XPATH", "//*[@text='Wires are valid']", testCase, 1);
					} else {
						return MobileUtils.isMobElementExists("XPATH", "//*[@name='Wires are valid']", testCase, 1);
					}
				}
			});
			if (success) {
				return MobileUtils.clickOnElement(objectDefinition, testCase, "NextBtn",
						"Next Button enabled, clicked on Next Button ");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Next Button not Enabled / not in visible ");
				return false;
			}
		} catch (org.openqa.selenium.TimeoutException e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"failed due to time out : 30 seconds" + e.getMessage());
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "failed due to : " + e.getMessage());
			return false;
		}
	}

	public boolean clickOn_AL_A_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ALPerACheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_R_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "RCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "RCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_C_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "CCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "CCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_Rc_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "RcCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "RcCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_E_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "ECheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "ECheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_W_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "WCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "WCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_G_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "GCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "GCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_W2_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "w2CheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "w2CheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_K_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "KCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "KCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_Y1_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Y1CheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "Y1CheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_O_B_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "OperBCheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "OperBCheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOn_Y2_CheckBX() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "Y2CheckBX");
		} else {
			@CheckForNull
			WebElement mobElement = MobileUtils.getMobElement(objectDefinition, testCase, "Y2CheckBX");
			int x = mobElement.getLocation().x + mobElement.getSize().width / 2;
			int y = mobElement.getLocation().y + mobElement.getSize().height / 2;
			return MobileUtils.clickOnCoordinate(testCase, x, y);
		}
	}

	public boolean clickOnValidateWiring() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ValidateWiringBtn");

	}

	public boolean clickOnManualWiringBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ManualWiringBtn");
	}

	public boolean clickOn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}
//	public boolean clickOn() {
//		return MobileUtils.clickOnElement(objectDefinition, testCase, "");
//	}

//	
//	public boolean is(int timeOut) {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//		
//	}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	public boolean is(int timeOut) {
//	return MobileUtils.isMobElementExists(objectDefinition, testCase, "",timeOut);
//	
//}
//	
//	public boolean is() {
//		return MobileUtils.isMobElementExists(objectDefinition, testCase, "");
//		
//	}

//	public boolean 

}
