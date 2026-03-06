package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class AmpedRouterScreen extends WebScreens {

	private static final String screenName = "AmpedRouterScreen";

	public AmpedRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean selectMode(String mode) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ModeDropDown");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText, mode);
	}

	public boolean clickOnBroadCastSSID() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast");
	}

	public boolean isBroadCastSSIDGEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast").isSelected();
	}

	public boolean setSSIDName(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSIDName");
			return false;
		}
	}

	public boolean changeBandwidth(String bandwidth) {
		WebElement BandwidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandwidthDropDown");
		return WebUtils.selectElementFromDropDown(testCase, BandwidthDropDown, SelectByOptions.ByVisibleText,
				bandwidth);
	}

	public boolean changeChannel(String channel) {
		WebElement ChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ChannelDropDown");
		return WebUtils.selectElementFromDropDown(testCase, ChannelDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean selectSecurity(String security) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "SecurityDropDown");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean selectWEPAuthontication(String authontication) {
		if (authontication.toUpperCase().contains("OPEN")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OpenSystemWEP");
		} else if (authontication.toUpperCase().contains("SHARED")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SharedKeyWEP");
		} else if (authontication.toUpperCase().contains("AUTO")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AutoWEP");
		}
		return false;
	}

	public boolean changeWEPKeyLength(String keyLength) {
		WebElement WEPKeyLengthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "KeyLengthDropDown");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyLengthDropDown, SelectByOptions.ByVisibleText,
				keyLength);
	}

	public boolean changeWEPKeyFormat(String keyFormat) {
		WebElement WEPKeyFormatDropDown = WebUtils.getWebElement(testCase, fieldObjects, "KeyFormatDropDown");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyFormatDropDown, SelectByOptions.ByVisibleText,
				keyFormat);
	}

	public boolean setWEPEncryptionKey(String keyFormat) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "KeyFormat")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "KeyFormat", keyFormat);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KeyFormat");
			return false;
		}
	}

	public boolean selectAutonticationModeWAP(String authonticationMode) {
		if (authonticationMode.toUpperCase().contains("ENTERPRISE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "EnterpriseWPA");
		} else if (authonticationMode.toUpperCase().contains("PERSONAL")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "PersonalWPA");
		}
		return false;
	}

	public boolean setWPARadiusIPAdd(String radiusIPAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIPAdd")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIPAdd", radiusIPAdd);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusIPAdd");
			return false;
		}
	}

	public boolean setWPARadiusPass(String radiusPass) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPass")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPass", radiusPass);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusPass");
			return false;
		}
	}

	public boolean setPassword(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Password");
			return false;
		}
	}

	public boolean clickonApplybutton(String screenName) {
		if (screenName.contains("BASIC")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtn");
		} else if (screenName.contains("SECURITY") || screenName.contains("DHCP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtnSecurity");
		} else {
			return true;
		}
	}

	public boolean clickOnRebootNoeBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "RebootNowBtn");
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean switchToSSIDAuthModeFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "SSIDAuthMode");
	}

	public boolean enable_disable_802_1xAuth(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE") || status.contains("ENABLE")) {
			isDHCPEn = true;
		}
		if (isDHCPEn) {
			if (!WebUtils.isWebElementExists(testCase, fieldObjects, "EnableDisable")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "EnableDisableAuth");
			} else {
				return true;
			}
		} else {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "EnableDisable")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "EnableDisableAuth");
			} else {
				return true;
			}
		}
	}

	public boolean acceptAlert() {
		if (WebUtils.interactWithAlert(testCase, AlertOperations.Accept)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean setDHCPStartIPAdd(String dhcpStartIP) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPStartIP", dhcpStartIP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DHCPStartIP");
			return false;
		}
	}

	public boolean setDHCPEndIPAdd(String dhcpEndIP) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPEndIP", dhcpEndIP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DHCPEndIP");
			return false;
		}
	}

	public boolean setLeaseTime(String leaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime", leaseTime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear LeaseTime");
			return false;
		}
	}

	public boolean iselementPresent(int timeOut) {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}

	public boolean changeDHCP(String is_dhcpEnable) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "DHCP");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText, is_dhcpEnable);
	}

	public boolean selectPreSharedKeyFormat(String preSharedKeyFormat) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "PresharedFormatDropDown");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText,
				preSharedKeyFormat);
	}

	public boolean clickOnBasicSettings2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSetting2G");
	}

	public boolean clickOnBasicSettings5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSetting5G");
	}

	public boolean clickOnSecuritySettings2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecuritySetting2G");
	}

	public boolean clickOnSecuritySettings5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecuritySetting5G");
	}

	public boolean clickonApplybutton_RTA15(String screenName) {
		if (screenName.contains("BASIC")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtn_RTA15");
		} else if (screenName.contains("SECURITY") || screenName.contains("DHCP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtn_RTA15");
		} else {
			return true;
		}
	}

	public boolean clickOnRebootNoeBtn_RTA15() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "RebootNowBtn_RTA15");
	}
}