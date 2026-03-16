package com.resideo.utils.firstalert_app.screen;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Point;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.mobile.MobileScreens;
import com.resideo.commons.mobile.MobileUtils;
import com.resideo.commons.report.FailType;

import org.openqa.selenium.WebElement;

public class FAPrimaryCardScreen extends MobileScreens {

	private static final String screenName = "FAPrimaryCardScreen";

	public FAPrimaryCardScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public String getCurrentRunningModeINPrimaryCardScreen() {
		String mode = null;
		String currentMode = "";
		for (int i = 0; i < 2; i++) {
			try {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					mode = MobileUtils.getDomAttribute(testCase, objectDefinition, "SystemSwitchButton", "content-desc")
							.toUpperCase();
				} else {
					mode = MobileUtils.getDomAttribute(testCase, objectDefinition, "SystemSwitchButton", "name")
							.toUpperCase();
				}
				if (mode != null)
					break;
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception occured in getCurrentRunningModeINPrimaryCardScreen due to " + e.getMessage());
			}
		}
		if (mode.contains("COOL")) {
			currentMode = "COOL";
		} else if (mode.contains("EMERGENCY HEAT")) {
			currentMode = "EMERGENCY HEAT";
		} else if (mode.contains("HEAT")) {
			currentMode = "HEAT";
		} else if (mode.contains("AUTO")) {
			currentMode = "AUTO";
		} else if (mode.contains("OFF")) {
			currentMode = "OFF";
		} else {
			Keyword.ReportStep_Fail(testCase, 0, "Not Able to find current mode name from PrimaryCard");
		}
		return currentMode;

	}

	public boolean clickOnSystemModes() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SystemSwitchButton");
	}

	public boolean clickOnHeatSystemMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "HeatSystemMode");

	}

	public boolean clickOnCoolSystemMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CoolSystemMode");

	}

	public boolean clickOnOffSystemMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OffSystemMode");

	}

	public boolean clickOnAutoSystemMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AutoSystemMode");

	}

	public boolean clickOnSaveBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SaveBtn");
	}

	public boolean clickOnDeviceNameFromDashboard(String deviceName) {
		Point cordinates;
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			WebElement ele = MobileUtils.getMobElement(testCase, "xpath",
					"//*[contains(@content-desc,'" + deviceName + "')][last()]");
			cordinates = ele.getLocation();
		} else {
			WebElement ele = MobileUtils.getMobElement(testCase, "xpath",
					"//*[contains(@name,'" + deviceName + "')]");
			cordinates = ele.getLocation();
		}
		return MobileUtils.clickOnCoordinate(testCase, cordinates.x + 50, cordinates.y + 20);
	}

	public boolean clickOnEmergencyHeatSystemMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "EmHeatSystemMode");

	}

	public boolean clickOnBackToDashBoardBtn() {
		WebElement ele = MobileUtils.getMobElement(objectDefinition, testCase, "BackToDashBoard");
		MobileUtils.clickOnCoordinate(testCase, ele.getSize().getWidth() / 4, ele.getSize().getHeight() / 4);
		return true;
	}

	public boolean clickOnBackBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackBtn");
	}

	public boolean clickOnLocationNameFromDashboard(String locationName) {
		String currentLocationName = getLocationNameFromDashboard().toUpperCase();
		if (!currentLocationName.toUpperCase().contains(locationName.toUpperCase())) {
			if (clickOnLocationListFromDashboard()) {
				return clickOnLocationNameFromDropDown(locationName);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Location not available in this account, Expecting Locations is " + locationName);
				return false;
			}
		} else {
			Keyword.ReportStep_Pass(testCase, "Already Location Selected, Location name is " + locationName);
			return true;
		}
	}

	public boolean clickOnLocationNameFromDropDown(String locationName) {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@content-desc,'" + locationName + "')]");
		} else {
			return MobileUtils.clickOnElement(testCase, "XPATH", "//*[contains(@name,'" + locationName + "')]");
		}

	}

	public boolean clickOnLocationListFromDashboard() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "LocationName");
	}

	public String getLocationNameFromDashboard() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getDomAttribute(testCase, objectDefinition, "LocationName", "content-desc").toUpperCase();
		} else {
			return MobileUtils.getDomAttribute(testCase, objectDefinition, "LocationName", "name").toUpperCase();
		}
	}

	public String getCurrentSetpoint(String systemMode) {
		String setpoint;
		String mode;
		if (systemMode.contains("HEAT")) {
			mode = "Heat";
		} else {
			mode = "Cool";
		}
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			setpoint = MobileUtils.getDomAttribute(testCase, "XPATH",
					"//*[contains(@content-desc,'" + mode + "') and contains(@content-desc,'To')]", "content-desc");
		} else {
			setpoint = MobileUtils.getDomAttribute(testCase, "XPATH",
					"//*[contains(@name,'" + mode + "') and contains(@name,'To')]", "name");
		}
		Pattern heatPattern = Pattern.compile("Heat(i(n?)|ing)? To\\s*(\\d{2})");
		Pattern coolPattern = Pattern.compile("Cool(i(n?)|ing)? To\\s*(\\d{2})");

		Matcher heatMatcher = heatPattern.matcher(setpoint);
		String heatSetpoint = heatMatcher.find() ? heatMatcher.group(3) : "Not found";

		Matcher coolMatcher = coolPattern.matcher(setpoint);
		String coolSetpoint = coolMatcher.find() ? coolMatcher.group(3) : "Not found";

		if (systemMode.contains("HEAT")) {
			return heatSetpoint;
		} else {
			return coolSetpoint;
		}
	}

	public boolean clickOnTempIncreaseButton(String systemMode) {
		String mode;
		if (systemMode.contains("HEAT")) {
			mode = "Heat";
		} else {
			mode = "Cool";
		}
		if ((systemMode.contains("AUTO") && systemMode.contains("HEAT")) || (!systemMode.contains("AUTO"))) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@content-desc,'" + mode
						+ "') and contains(@content-desc,'To')]//following-sibling::*)[2]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@content-desc,'" + mode
							+ "') and contains(@content-desc,'To')]//following-sibling::*)[2]");
				}
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@name,'" + mode
						+ "') and contains(@name,'To')]//following-sibling::*)[2]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@name,'" + mode
							+ "') and contains(@name,'To')]//following-sibling::*)[2]");
				}
			}
		} else {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@content-desc,'" + mode
						+ "') and contains(@content-desc,'To')]/following-sibling::*)[4]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@content-desc,'" + mode
							+ "') and contains(@content-desc,'To')]/following-sibling::*)[4]");
				}
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@name,'" + mode
						+ "') and contains(@name,'To')]//following-sibling::*)[4]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@name,'" + mode
							+ "') and contains(@name,'To')]//following-sibling::*)[4]");
				}
			}

		}
		return false;
	}

	public boolean clickOnTempDecreaseButton(String systemMode) {
		String mode;
		if (systemMode.contains("HEAT")) {
			mode = "Heat";
		} else {
			mode = "Cool";
		}
		Keyword.ReportStep_Pass(testCase, "mode:" + mode + ",systemMode:" + systemMode);
		if ((systemMode.contains("AUTO") && systemMode.contains("HEAT")) || (!systemMode.contains("AUTO"))) {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@content-desc,'" + mode
						+ "') and contains(@content-desc,'To')]//following-sibling::*)[1]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@content-desc,'" + mode
							+ "') and contains(@content-desc,'To')]//following-sibling::*)[1]");
				}
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@name,'" + mode
						+ "') and contains(@name,'To')]//following-sibling::*)[1]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@name,'" + mode
							+ "') and contains(@name,'To')]//following-sibling::*)[1]");
				}
			}
		} else {
			if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@content-desc,'" + mode
						+ "') and contains(@content-desc,'To')]//following-sibling::*)[3]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@content-desc,'" + mode
							+ "') and contains(@content-desc,'To')]//following-sibling::*)[3]");
				}
			} else {
				if (MobileUtils.isMobElementExists("XPATH", "(//*[contains(@name,'" + mode
						+ "') and contains(@name,'To')]//following-sibling::*)[3]", testCase, 2)) {
					return MobileUtils.clickOnElement(testCase, "XPATH", "(//*[contains(@name,'" + mode
							+ "') and contains(@name,'To')]//following-sibling::*)[3]");
				}
			}

		}
		return false;
	}

	public String getCurrentRunningFan() {
		String fanMode = null;
		String currentMode = "";
		for (int i = 0; i < 2; i++) {
			try {
				if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
					fanMode = MobileUtils.getDomAttribute(testCase, objectDefinition, "FanModeBtn", "content-desc")
							.toUpperCase();
				} else {
					fanMode = MobileUtils.getDomAttribute(testCase, objectDefinition, "FanModeBtn", "name").toUpperCase();
				}
				if (fanMode != null)
					break;
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Exception occured in getCurrentRunningModeINPrimaryCardScreen due to " + e.getMessage());
			}
		}
		if (fanMode.contains("ON")) {
			currentMode = "ON";
		} else if (fanMode.contains("CIRCULATE")) {
			currentMode = "CIRCULATE";
		} else if (fanMode.contains("AUTO")) {
			currentMode = "AUTO";
		} else {
			Keyword.ReportStep_Fail(testCase, 0, "Not Able to find current mode name from PrimaryCard");
		}
		return currentMode;
	}

	public boolean clickOnFanBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanModeBtn");
	}

	public boolean clickonONFanMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanModeOn");
	}

	public boolean clickonCirculateFanMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanModeCirculate");
	}

	public boolean clickonAutoFanMode() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "FanModeAuto");
	}

	public boolean isSaveBtnEnable() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SaveBtn", 2))
				return Boolean.valueOf(MobileUtils.getDomAttribute(testCase, objectDefinition, "SaveBtn", "enabled"));
		} else {
			if (MobileUtils.isMobElementExists(objectDefinition, testCase, "SaveBtn", 2))
				return Boolean.valueOf(MobileUtils.getDomAttribute(testCase, objectDefinition, "SaveBtn", "enabled"));
		}
		return false;
	}

	public boolean clickOnCrossBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CrossBtn");
	}

	public boolean isSaveChangespopUpPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "SaveChangespopUp", 3);
	}

	public boolean clickOnSaveChangesPopUp(String save_dontSave) {
		if (save_dontSave.contains("DONT") || save_dontSave.contains("DO NOT")) {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "DontSaveBtnInSaveChangesPopup");
		} else {
			return MobileUtils.clickOnElement(objectDefinition, testCase, "SaveBtnInSaveChangesPopup");
		}
	}

	public String getCurrentStatusofAdaptiveRecovery() {
		if (testCase.getPlatform().toUpperCase().contains("ANDROID")) {
			return MobileUtils.getDomAttribute(testCase, objectDefinition, "AdaptiveRecoveryTglBtn", "checked")
					.toUpperCase();
		} else {
			return MobileUtils.getDomAttribute(testCase, objectDefinition, "AdaptiveRecoveryTglBtn", "value")
					.toUpperCase();
		}
	}

	public boolean ClickOnSettingsIcon() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "SettingsIconBtn");
	}

	public boolean clickOnAdaptiveRecoveryToggleBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "AdaptiveRecoveryTglBtn");
	}

	public ArrayList<String> getlistOfModesAvailableInCurrentSettings() {
		ArrayList<String> AvailableModes = new ArrayList<String>();
		if (clickOnSystemModes()) {
			if (isEmergencyHeatSystemModePresent()) {
				AvailableModes.add("EMERGENCY HEAT");
			}
			if (isHeatSystemModePresent()) {
				AvailableModes.add("HEAT");
			}
			if (isECoolSystemModePresent()) {
				AvailableModes.add("COOL");
			}
			if (isOffSystemModePresent()) {
				AvailableModes.add("OFF");
			}
			if (isAutoSystemModePresent()) {
				AvailableModes.add("AUTO");
			}
		}
		clickOnCrossBtn();
		return AvailableModes;
	}

	public boolean isAutoSystemModePresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "AutoSystemMode");
	}

	public boolean isOffSystemModePresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OffSystemMode");
	}

	public boolean isECoolSystemModePresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CoolSystemMode");
	}

	public boolean isHeatSystemModePresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HeatSystemMode", 3);
	}

	public boolean isEmergencyHeatSystemModePresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "EmHeatSystemMode", 3);
	}

	public Boolean isHoldUntilLabelisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "HoldUntilLabel", 3);
	}

	public Boolean isPermanentHoldLabelisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "PermanentLabel", 3);
	}

	public Boolean isVacationHoldLabelisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "VacationLabel", 3);
	}

	public Boolean isFolllowingScheduleLabelisPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "FollowingScheduleLabel", 3);
	}
	
	public boolean isBackBtnPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackBtn", 2);
	}
	
	public boolean isExitBtnPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "ExitBtn", 2);
	}
	public boolean clickOnExitBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "ExitBtn");
	}

	public boolean isBackToDashBoardBtnPresent() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "BackToDashBoard", 2);
	}
	
	public boolean clickOnDashboardTab() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "BackToDashBoard");
	}
	
	public boolean isCancel() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "CancelBtn", 2);
	}
 
	public boolean clickOnCancel() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "CancelBtn");
	}
 
	public boolean isOk() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "OkBtn", 2);
	}
 
	public boolean clickOnOk() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "OkBtn");
	}
 
	public boolean isTryAgainPopUp() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "TryAgainPopUp", 2);
	}
 
	public boolean clickOnTryAgainPopUp() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "TryAgainPopUp");
	}
 
	public boolean isDone() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DonePopUp", 2);
	}
 
	public boolean clickOnDone() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DonePopUp");
	}

	public boolean isDismissBtn() {
		return MobileUtils.isMobElementExists(objectDefinition, testCase, "DismissBtn", 2);
	}

	public boolean clickOnDismissBtn() {
		return MobileUtils.clickOnElement(objectDefinition, testCase, "DismissBtn");
		
	}

}
