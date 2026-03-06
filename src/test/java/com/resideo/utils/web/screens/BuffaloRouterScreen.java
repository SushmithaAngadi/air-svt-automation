package com.resideo.utils.web.screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class BuffaloRouterScreen extends WebScreens {
	private static final String screenName = "BuffaloRouterScreen";

	public BuffaloRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isPageLoading() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "PageLoading");
	}

	public boolean clickOnWirelessTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessTab");
	}

	public boolean clickOnWirelessSecurityTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessSecurityTab");
	}

	public boolean selectSecurity2GType(String security) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security2GOptions");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean selectSecurity5GType(String security) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security5GOptions");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean selectWpaAlgo2GType(String WpaAlgo) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "WpaAlgo2GOptions");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, WpaAlgo);
	}

	public boolean selectWpaAlgo5GType(String WpaAlgo) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "WpaAlgo5GOptions");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, WpaAlgo);
	}

	public boolean setSharedKey2G(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "ClearserverPassword2G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "ClearserverPassword2G", password);
		} else {
			return false;
		}
	}

	public boolean setSharedKey5G(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "ClearserverPassword5G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "ClearserverPassword5G", password);
		} else {
			return false;
		}
	}

	public boolean setKeyRenInterval2G(String keyRenInterval) {
		boolean flag = true;
		String n = Keys.chord(Keys.CONTROL, "A");
		WebElement KeyRenInterval2G = WebUtils.getWebElement(testCase, fieldObjects, "KeyRenInterval2G");
		KeyRenInterval2G.sendKeys(n, keyRenInterval);
		return flag;
	}

	public boolean clearAndSetValue(String FieldName, String value) {
		WebElement element = WebUtils.getWebElement(testCase, fieldObjects, FieldName);
		if (element != null) {
			try {
				String ControlAll = Keys.chord(Keys.CONTROL, "A");
				element.sendKeys(ControlAll, value);
				Keyword.ReportStep_Pass(testCase,
						String.format("Set Value to Web Element : %s set to element name [%s]", element, FieldName));
				return true;
			} catch (Exception e) {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						String.format("Set Value to Web Element : %s set to element named [%s]  failed. Reason - %s",
								value, FieldName, e.getMessage()));
				return false;
			}

		} else {
			return false;
		}

	}

	public boolean setKeyRenInterval5G(String keyRenInterval) {
		boolean flag = true;
		String n = Keys.chord(Keys.CONTROL, "A");
		WebElement KeyRenInterval2G = WebUtils.getWebElement(testCase, fieldObjects, "KeyRenInterval5G");
		KeyRenInterval2G.sendKeys(n, keyRenInterval);
		return flag;
	}

	public boolean selectWirelessMode2G(String wirelessMode) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "WirelessMode2G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, wirelessMode);
	}

	public boolean selectWirelessMode5G(String wirelessMode) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "WirelessMode5G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, wirelessMode);
	}

	public boolean selectNetworkMode2G(String networkMode) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "NetworkMode2G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, networkMode);
	}

	public boolean selectNetworkMode5G(String networkMode) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "NetworkMode5G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, networkMode);
	}

	public boolean selectBandWidth2G(String bandWidth) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandWidth2G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, bandWidth);
	}

	public boolean selectBandWidth5G(String bandWidth) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandWidth5G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, bandWidth);
	}

	public boolean selectChannel2G(String channel) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel2G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean selectChannel5G(String channel) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel5G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, channel);
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

	public boolean clickOnBroadCastSSID2GDisable() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2GDisable");
	}

	public boolean clickOnBroadCastSSID5GDisable() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5GDisable");
	}

	public boolean setvalueinSSID24(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID24")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID24", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean setvalueinSSID5(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID5")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID5", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean clickOnBasicSetupTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSetupTab");
	}

	public boolean scrollToDhcp() {
		WebElement DHCP_on = WebUtils.getWebElement(testCase, WebObjectLocators.By_NAME, "dhcpfwd_enable");
		WebDriver driver = testCase.getWebDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", DHCP_on);
		return true;
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP_on = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOncheckbox");
		WebElement DHCP_off = WebUtils.getWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
		if (isDHCPEn) {
			if (!DHCP_on.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOncheckbox");
			} else {
				return true;
			}
		} else {
			if (!DHCP_off.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPOffcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean setStartIpAdress(String startIPAddress) {
		String[] startIPAdd = startIPAddress.split("\\.");
		return clearAndSetValue("StartIPAddress", startIPAdd[3]);
	}

	public boolean setMaxNoUsers(String maxNoUsers) {
		return clearAndSetValue("MaxNoUsers", maxNoUsers);
	}

	public boolean setClientLeaseTime(String clientLeaseTime) {
		return clearAndSetValue("ClientLeaseTime", clientLeaseTime);

	}

	public boolean setstaticDNS1(String staticDNS1) {
		String[] StaticDNS1 = staticDNS1.split("\\.");
		boolean flag = false;
		flag = clearAndSetValue("StaticDNS1_1", StaticDNS1[0]);
		flag = flag && clearAndSetValue("StaticDNS1_2", StaticDNS1[1]);
		flag = flag && clearAndSetValue("StaticDNS1_3", StaticDNS1[2]);
		flag = flag && clearAndSetValue("StaticDNS1_4", StaticDNS1[3]);
		return flag;
	}

	public boolean clickOnApplyChangesBTN() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "ApplyChanges")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyChanges");
		} else {
			return false;
		}
	}

	public boolean isAuthIsSharedKEy2G() {
		WebElement SharedKEy = WebUtils.getWebElement(testCase, fieldObjects, "AuthToShared");
		return SharedKEy.getAttribute("class").contains("checked");
	}

	public boolean setAuthToShared2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AuthToShared");
	}

	public boolean setAuthToOpen2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AuthToOpen");
	}

	public boolean isAuthIsSharedKEy5G() {
		WebElement SharedKEy = WebUtils.getWebElement(testCase, fieldObjects, "AuthToShared5G");
		return SharedKEy.getAttribute("class").contains("checked");
	}

	public boolean setAuthToShared5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AuthToShared5G");
	}

	public boolean setAuthToOpen5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AuthToOpen5G");
	}

	public boolean selectEncryption2GType(String encryption) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Encryption2G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, encryption);
	}

	public boolean selectEncryption5GType(String encryption) {
		WebElement DropDown = WebUtils.getWebElement(testCase, fieldObjects, "Encryption5G");
		return WebUtils.selectElementFromDropDown(testCase, DropDown, SelectByOptions.ByVisibleText, encryption);
	}

	public boolean setPassphrase2G(String passphrase) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Passphrase2G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Passphrase2G", passphrase);
		} else {
			return false;
		}
	}

	public boolean setPassphrase5G(String passphrase) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Passphrase5G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Passphrase5G", passphrase);
		} else {
			return false;
		}
	}

	public boolean clickonGenerate2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate2G");
	}

	public boolean clickonGenerate5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate5G");
	}
	public boolean clickOnBasicSettingsTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSettingTab");
	}

	public String getPasswordWEP() {
		return WebUtils.getWebElement(testCase, fieldObjects, "Key1Value").getAttribute("value");
	}

	public boolean clickOnKey1() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Key1RadioBtn");
		
	}
	public boolean iselementPresent(int timeOut) {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}

}