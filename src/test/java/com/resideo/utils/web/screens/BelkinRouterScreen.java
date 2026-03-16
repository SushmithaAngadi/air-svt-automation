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

public class BelkinRouterScreen extends WebScreens {
	private static final String screenName = "BelkinRouterScreen";

	public BelkinRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean clickOnWireless() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Wireless")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Wireless");
		} else {
			return false;
		}
	}

	public boolean clickOnSecurity2GType(String SecurityType) {

		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security2GTypeOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				SecurityType);
	}

	public boolean clickOnSecurity() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Security")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Security");
		} else {
			return false;
		}
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean switchToMainFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "mainFrame");
	}

	public boolean switchToiFrame2Ghz() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "wireless_24G_sec");
	}

	public boolean switchToiFrame5Ghz() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "wireless_5G_sec");
	}

	public boolean switchToiFrameId5Ghz() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "wireless_id_5");
	}

	public boolean changeWAPAuthenctication(String wPA_WPA_2_Auth) {
		WebElement AuthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Auth2GTypeOptions");
		return WebUtils.selectElementFromDropDown(testCase, AuthDropDown, SelectByOptions.ByVisibleText,
				wPA_WPA_2_Auth);
	}

	public boolean acceptAlert() {
		if (WebUtils.interactWithAlert(testCase, AlertOperations.Accept)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean enable_disable_PassPhrase(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "PassPhraseCheckbox");
		if (isDHCPEn) {
			if (!DHCP.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "PassPhraseCheckbox");
			} else {
				return true;
			}
		} else {
			if (DHCP.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "PassPhraseCheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean setPassPhrase(String PassPhrase) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PassPhrase")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PassPhrase", PassPhrase);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear PassPhrase");
			return false;
		}
	}

	public boolean clickOnGenerate() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Generate")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate");
		} else {
			return false;
		}
	}

	public boolean setPreSharedKey(String preSharedKey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "preSharedKey")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "preSharedKey", preSharedKey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear sharedKey2G");
			return false;
		}
	}

	public boolean select2GChannelNumber(String channel) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel2GOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean select5GChannelNumber(String channel) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel5GOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean select2GModeType(String mode) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Mode2GOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, mode);
	}

	public boolean select5GModeType(String mode) {
		boolean flag = false;
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Mode2GOptions");
		flag = WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, mode);
		return flag;
	}

	public boolean clickOnChannelSssid() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "ChannelSsid")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelSsid");
		} else {
			return false;
		}
	}

	public boolean isBroadCastSSID5GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G").isSelected();

	}

	public boolean isBroadCastSSID2GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G").isSelected();
	}

	public boolean clickOnBroadCastSSID2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G");
	}

	public boolean clickOnBroadCastSSID5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G");
	}

	public boolean setValueinPassword24(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "preSharedKey")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "preSharedKey", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear sharedKey2G");
			return false;
		}
	}

	public boolean setValueinPassword5(String password) {
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "preSharedKey")) {
			flag = flag & WebUtils.setValueOnWebElement(testCase, fieldObjects, "preSharedKey", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear sharedKey2G");
			return false;
		}
		return flag;
	}

	public boolean setvalueinSSID24(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "ssid")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "ssid", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear ssid");
			return false;
		}
	}

	public boolean setvalueinSSID5(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "ssid")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "ssid", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear ssid");
			return false;
		}
	}

	public boolean clickOnapplyChangesMade() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "ApplyChanges")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyChanges");
		} else {
			return false;
		}
	}

	public boolean clickOnLanSettings() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "LanSettings")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "LanSettings");
		} else {
			return false;
		}
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP_on = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOncheckbox");
		WebElement DHCP_off = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
		if (isDHCPEn) {
			if (!DHCP_on.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOncheckbox");
			} else {
				return true;
			}
		} else {
			if (!DHCP_off.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean set_Ip_Starting_Add(String ip_Starting_Add) {
		String[] IPStartAdd = ip_Starting_Add.split("\\.");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "IpStartingAdd")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "IpStartingAdd", IPStartAdd[3]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear PassPhrase");
			return false;
		}
	}

	public boolean set_Ip_Ending_Add(String Ip_Ending_Add) {
		String[] IPStartAdd = Ip_Ending_Add.split("\\.");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "IpEndingAdd")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "IpEndingAdd", IPStartAdd[3]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear PassPhrase");
			return false;
		}
	}

	public boolean selectDhcpLeaseTime(String dhcp_LeaseTime) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "DhcpLeaseTime");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				dhcp_LeaseTime);
	}

	public boolean isApplyingChanges() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "ApplyingChanges");
	}

}