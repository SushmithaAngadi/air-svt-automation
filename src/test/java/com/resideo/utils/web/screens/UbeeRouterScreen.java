package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class UbeeRouterScreen extends WebScreens {
	public static final String screenName = "UbeeRouterScreen";

	public UbeeRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean changeFrequency(String frequency) {
		WebElement FrequencyDropDown = WebUtils.getWebElement(testCase, fieldObjects, "FrequencyDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, FrequencyDropDown, SelectByOptions.ByVisibleText,
				frequency);
	}

	public boolean changeBandWidth(String bandWidth) {
		WebElement BandWidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandWidthDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, BandWidthDropDown, SelectByOptions.ByVisibleText,
				bandWidth);
	}

	public boolean changeMode(String mode) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ModeDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText, mode);
	}

	public boolean changeChannel(String channel) {
		WebElement ChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ChannelDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, ChannelDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean enable_disable_Wireless(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WirelessEnaDisDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setSSIDName(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName", ssid_name);
		}
		return false;
	}

	public boolean isWPA_PSK_Enable_Disable(String enable_disable) {
		if (enable_disable.toUpperCase().contains("ENABLE"))
			return WebUtils.getWebElement(testCase, fieldObjects, "WPAPSKEnable").isSelected();
		else
			return WebUtils.getWebElement(testCase, fieldObjects, "WPAPSKDisable").isSelected();
	}

	public boolean isWPA2_PSK_Enable_Disable(String enable_disable) {
		if (enable_disable.toUpperCase().contains("ENABLE"))
			return WebUtils.getWebElement(testCase, fieldObjects, "WPA2PSKEnable").isSelected();
		else
			return WebUtils.getWebElement(testCase, fieldObjects, "WPA2PSKDisable").isSelected();
	}

	public boolean isWEP_Enable_Disable(String enable_disable) {
		if (enable_disable.toUpperCase().contains("DISABLE"))
			return WebUtils.getWebElement(testCase, fieldObjects, "WEPDisable").isSelected();
		else
			return true;
	}

	public boolean isWPA_Enable_Disable(String enable_disable) {
		if (enable_disable.toUpperCase().contains("ENABLE"))
			return WebUtils.getWebElement(testCase, fieldObjects, "WPAEnable").isSelected();
		else
			return WebUtils.getWebElement(testCase, fieldObjects, "WPADisable").isSelected();
	}

	public boolean isWPA2_Enable_Disable(String enable_disable) {
		if (enable_disable.toUpperCase().contains("ENABLE"))
			return WebUtils.getWebElement(testCase, fieldObjects, "WPA2Enable").isSelected();
		else
			return WebUtils.getWebElement(testCase, fieldObjects, "WPA2Disable").isSelected();
	}

	public boolean setAllSecuritytypeTo(String enable_disable) {
		if (enable_disable.toUpperCase().contains("DISABLE")) {
			if (setWEPto("Disabled")) {
				if (setWPA_PSKto("Disabled") && setWPA2_PSKto("Disabled")) {
					if (setWPAto("Disabled") && setWPA2to("Disabled")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean setWPA2to(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPA2DrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setWPAto(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPADrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setWPA2_PSKto(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPA2PSKDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setWPA_PSKto(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPAPSKDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setWEPto(String enable_disable) {
		WebElement enable_disableDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, enable_disableDropDown, SelectByOptions.ByVisibleText,
				enable_disable);
	}

	public boolean setPassPhrase(String passPhrase) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PassPhrase")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PassPhrase", passPhrase);
		}
		return false;
	}

	public boolean clikOnGenerate() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "GenerateBtn");
	}

	public boolean selectEncryption(String encryption) {
		WebElement EncryDropDown = WebUtils.getWebElement(testCase, fieldObjects, "EncryptionDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, EncryDropDown, SelectByOptions.ByVisibleText, encryption);
	}

	public boolean setPassword(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PreShareKey")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PreShareKey", password);
		}
		return false;
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.toUpperCase().contains("ENABLE") || status.toUpperCase().contains("YES")
				|| status.toUpperCase().contains("TRUE")) {
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

	public boolean setDHCPLeaseTime(String leaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPLEaseTime")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPLEaseTime", leaseTime);
		}
		return false;
	}

	public boolean setDHCPStartIP(String dhcpStartIP) {
		String[] startIPAdd = dhcpStartIP.split("\\.");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIPAddress")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPStartIPAddress", startIPAdd[3]);
		}
		return false;
	}

	public boolean clickonApplybutton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtn");
	}

	public boolean clickOnAlertOK() {
		return WebUtils.interactWithAlert(testCase, AlertOperations.Accept);
	}

}