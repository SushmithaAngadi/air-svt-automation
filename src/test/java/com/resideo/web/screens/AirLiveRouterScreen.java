package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class AirLiveRouterScreen extends WebScreens {
	private static final String screenName = "AirLiveRouterScreen";

	public AirLiveRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean enable_disable_DHCP(String is_dhcp) {
		boolean isDHCPEn = false;
		if (is_dhcp.contains("YES") || is_dhcp.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP_on = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOncheckbox");
		WebElement DHCP_off = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
		if (isDHCPEn) {
			if (!DHCP_on.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOncheckbox");
			} else {
				return true;
			}
		} else {
			if (!DHCP_off.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean setvalueinDHCPLeaseTime(String leaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime", leaseTime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear lease time");
			return false;
		}
	}

	public boolean enable_disable_SSID(String is_ssid) {
		boolean isSSIDEn = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement SSID_on = WebUtils.getWebElement(testCase, fieldObjects, "SSIDOncheckbox");
		WebElement SSID_off = WebUtils.getWebElement(testCase, fieldObjects, "SSIDOffcheckbox");
		if (isSSIDEn) {
			if (!SSID_on.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDOncheckbox");
			} else {
				return true;
			}
		} else {
			if (!SSID_off.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDOffcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean setvalueinSSID(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID");
			return false;
		}
	}

	public boolean enable_disable_Wireless(String is_wireless) {
		boolean iswirelessEn = false;
		if (is_wireless.toUpperCase().contains("YES") || is_wireless.toUpperCase().contains("TRUE") || is_wireless.toUpperCase().contains("ENABLE")) {
			iswirelessEn = true;
		}
		WebElement wireless_on = WebUtils.getWebElement(testCase, fieldObjects, "wirelessOncheckbox");
		WebElement wireless_off = WebUtils.getWebElement(testCase, fieldObjects, "wirelessOffcheckbox");
		if (iswirelessEn) {
			if (!wireless_on.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "wirelessOncheckbox");
			} else {
				return true;
			}
		} else {
			if (!wireless_off.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "wirelessOffcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean changeMode(String mode) {
		if (mode.toUpperCase().contains("B_G_N")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "BGNMode");
		} else if (mode.toUpperCase().contains("G ONLY")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "GMode");
		} else if (mode.toUpperCase().contains("B ONLY")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "BMode");
		}
		return false;
	}

	public boolean changeChannel(String channel) {
		WebElement channelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ChannelOptions");
		return WebUtils.selectElementFromDropDown(testCase, channelDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean changeSecurity(String SecurityType) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "SecurityOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				SecurityType);
	}

	public boolean selectWEPKeyMode(String wEPKeyMode) {
		WebElement selectWEPKeyMode = WebUtils.getWebElement(testCase, fieldObjects, "WEPKeyOptions");
		return WebUtils.selectElementFromDropDown(testCase, selectWEPKeyMode, SelectByOptions.ByVisibleText,
				wEPKeyMode);
	}

	public boolean selectWEPKeyLength(String KeyLength) {
		if (KeyLength.contains("64")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP64");
		} else if (KeyLength.contains("128")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP128");
		}
		return false;
	}

	public boolean setWEPKey1(String wEPKey1) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPKEy1")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPKEy1", wEPKey1);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPKEy1");
			return false;
		}
	}

	public boolean selectRadiusKeyLength(String KeyLength) {
		if (KeyLength.contains("64")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Radius64");
		} else if (KeyLength.contains("128")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Radius128");
		}
		return false;
	}

	public boolean setRadiusIP(String radiusIP) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP", radiusIP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusIP");
			return false;
		}
	}
	public boolean setRadiusPort(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPort")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPort", radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusPort");
			return false;
		}
	}

	public boolean selectWPA_PSK_Encrpytion(String encrpytion) {
		if (encrpytion.contains("TKIP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA_PSK_TKIP");
		} else if (encrpytion.contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA_PSK_AES");
		}
		return false;
	}

	public boolean selectPresharedKeyMode(String presharedKeyMode) {
		WebElement selectPresharedKeyMode = WebUtils.getWebElement(testCase, fieldObjects, "PresharedKeyMode");
		return WebUtils.selectElementFromDropDown(testCase, selectPresharedKeyMode, SelectByOptions.ByVisibleText,
				presharedKeyMode);
	}

	public boolean setValueinPassword_WPAPSK(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAPSKPassword")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAPSKPassword", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPKEy1");
			return false;
		}
	}

	public boolean clickOnSaveBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveBtn");
	}

	public boolean ClickOnReboot() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "RebootBtn");
	}
	public boolean clickOnAlertOK() {
		return WebUtils.interactWithAlert(testCase, AlertOperations.Accept);
	}
}