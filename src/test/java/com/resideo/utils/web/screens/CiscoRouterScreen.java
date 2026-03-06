package com.resideo.utils.web.screens;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class CiscoRouterScreen extends WebScreens {
	private static final String screenName = "CiscoRouterScreen";

	public CiscoRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean clickOnWireless() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Wireless")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Wireless");
		} else {
			return false;
		}
	}

	public boolean clickOnBasicWirelessTab() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "WirelessTab")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessTab");
		} else {
			return false;
		}
	}

	public boolean clickOnSecurity2GType(String SecurityType) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security2GTypeOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				SecurityType);
	}

	public boolean clickOnSecurity5GType(String SecurityType) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security5GTypeOptions");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				SecurityType);
	}

	public boolean select2GChannelNumber(String channelNumber) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ChannelNumber2GHZ");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channelNumber);
	}

	public boolean select5GChannelNumber(String channelNumber) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ChannelNumber5GHZ");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channelNumber);
	}

	public boolean select2GModeType(String modeType) {
		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "ModeType2GHZ", SelectByOptions.ByVisibleText,
				modeType);
	}

	public boolean select5GModeType(String modeType) {
		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "ModeType5GHZ", SelectByOptions.ByVisibleText,
				modeType);
	}

	public boolean clickOnApplyChangesBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyChangesBTN");
	}

	public boolean isBroadCastSSID2GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G").isSelected();
	}

	public boolean isBroadCastSSID5GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G").isSelected();
	}

	public boolean clickOnBroadCastSSID2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G");
	}

	public boolean clickOnBroadCastSSID5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G");
	}

	public boolean setValueinPasswordWEP24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordWEP24");
	}

	public boolean setValueinPasswordWEP24(String password) {
		if (setValueinPasswordWEP24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordWEP24", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinPasswordEnterprise24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordEnterprise24");
	}

	public boolean setValueinPasswordEnterprise24(String password) {
		if (setValueinPasswordEnterprise24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordEnterprise24", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinPasswordPersonal24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordPersonal24");
	}

	public boolean setValueinPasswordPersonal24(String password) {
		if (setValueinPasswordPersonal24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordPersonal24", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinPasswordEnterprise5() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordEnterprise5");
	}

	public boolean setValueinPasswordEnterprise5(String password) {
		if (setValueinPasswordEnterprise5()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordEnterprise5", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinPasswordPersonal5() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordPersonal5");
	}

	public boolean setValueinPasswordPersonal5(String password) {
		if (setValueinPasswordPersonal5()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordPersonal5", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean clearSSIDName24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID24");
	}

	public boolean setvalueinSSID24(String SSID) {
		if (clearSSIDName24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID24", SSID);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean clearSSIDName5() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID25");
	}

	public boolean setvalueinSSID5(String SSID) {
		if (clearSSIDName5()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID25", SSID);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean isPageLoading() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "LoadingIcon");
	}

	public boolean UpdateNetworkSettings() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "YesBtn")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "YesBtn");
		} else {
			Keyword.ReportStep_Pass(testCase, "Same Settings, Yes Button Skipped");
			return true;
		}
	}

	public boolean clickOnOkBtn() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OkBtn")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OkBtn");
		} else {
			Keyword.ReportStep_Pass(testCase, "Same Settings, Ok Button Skipped");
			return true;
		}
	}

	public boolean acceptWarning() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "AcceptWarning")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AcceptWarning");
		} else {
			return false;
		}
	}

	public boolean clickOnWepEncryption2G(String Encryption2GType) {
		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "Encryption2GType",
				SelectByOptions.ByVisibleText, Encryption2GType);
	}

	public boolean clickOnWepEncryption5G(String Encryption5GType) {
		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "Encryption5GType",
				SelectByOptions.ByVisibleText, Encryption5GType);
	}

	public boolean clickOnGenerate2G() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Generate2GBtn")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate2GBtn");
		} else {
			return false;
		}
	}

	public boolean clickOnGenerate5G() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Generate5GBtn")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate5GBtn");
		} else {
			return false;
		}
	}

	public boolean setRadiusServer2G(String radiusServerValaue) {
		String[] serverValue = radiusServerValaue.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue12G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue12G", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue22G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue22G", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue32G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue32G", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue42G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue42G", serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusServer5G(String radiusServerValaue) {
		String[] serverValue = radiusServerValaue.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue15G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue15G", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue25G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue25G", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue35G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue35G", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue45G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue45G", serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusPort2G(String radiusPortValue) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "radiusPortValue2G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "radiusPortValue2G", radiusPortValue);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear radiusPortValue2G");
			return false;
		}
	}

	public boolean setRadiusPort5G(String radiusPortValue) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "radiusPortValue5G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "radiusPortValue5G", radiusPortValue);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear radiusPortValue5G");
			return false;
		}
	}

	public boolean setSharedKey5G(String sharedKey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "sharedKey5G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "sharedKey5G", sharedKey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear sharedKey5G");
			return false;
		}

	}

	public boolean setSharedKey2G(String sharedKey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "sharedKey2G")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "sharedKey2G", sharedKey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear sharedKey2G");
			return false;
		}
	}

	public boolean clickOnConnectivity() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Connectivity")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Connectivity");
		} else {
			return false;
		}
	}

	public boolean clickOnLocalNetworkTab() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "LocalNetworkTab")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "LocalNetworkTab");
		} else {
			return false;
		}
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "DHCPcheckbox");
		if (isDHCPEn) {
			if (!DHCP.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPcheckbox");
			} else {
				return true;
			}
		} else {
			if (DHCP.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPcheckbox");
			} else {
				return true;
			}
		}
	}

	public boolean setStartIpAdress(String startIPAddress) {
		String[] startIPAdd = startIPAddress.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "startIPAddress_3")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "startIPAddress_3", startIPAdd[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "startIPAddress_4")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "startIPAddress_4", startIPAdd[3]);
		}
		return flag;
	}

	public boolean setMaxNoUsers(String maxNoUsers) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "maxNoUsers")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "maxNoUsers", maxNoUsers);
		}
		return false;
	}

	public boolean setClientLeaseTime(String clientLeaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clientLeaseTime")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "clientLeaseTime", clientLeaseTime);
		}
		return false;
	}

	public boolean changeScreenToHome() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "crossMark")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "crossMark");
		} else {
			return false;
		}
	}

	public boolean enable_disable_DHCP_WRT120N(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCPEnable = WebUtils.getWebElement(testCase, fieldObjects, "DHCPEnable_WRT120N");
		String DHCPEnableDisable = DHCPEnable.getAttribute("checked");
		if (DHCPEnableDisable == null) {
			WebElement DHCPDisable = WebUtils.getWebElement(testCase, fieldObjects, "DHCPDisable_WRT120N");
			DHCPEnableDisable = DHCPDisable.getAttribute("checked");
			DHCPEnableDisable = DHCPEnableDisable + " :Disable";
		}
		if (isDHCPEn) {
			if (DHCPEnableDisable.contains("Dis")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPEnable_WRT120N");
			} else {
				return true;
			}
		} else {
			if (!DHCPEnableDisable.contains("Dis")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPDisable_WRT120N");
			} else {
				return true;
			}
		}
	}

	public boolean setLeaseTime_WRT120N(String leaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime_WRT120N", leaseTime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear LeaseTime_WRT120N");
			return false;
		}
	}

	public boolean setMAxNoUser_WRT120N(String MAxNoUser) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "MAxNoUser_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "MAxNoUser_WRT120N", MAxNoUser);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear MAxNoUser_WRT120N");
			return false;
		}
	}

	public boolean setStartIpAdd_WRT120N(String startIpAdd) {
		String[] startIPAdd = startIpAdd.split("\\.");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIpAdd_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIpAdd_WRT120N", startIPAdd[4]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear StartIpAdd_WRT120N");
			return false;
		}
	}

	public boolean setDNSip1_WRT120N(String dNSip1) {
		String[] DNSip1 = dNSip1.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSip1_1_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSip1_1_WRT120N", DNSip1[0]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNSip1_1_WRT120N");
			flag = false;
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSip1_2_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSip1_2_WRT120N", DNSip1[1]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNSip1_2_WRT120N");
			flag = false;
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSip1_3_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSip1_3_WRT120N", DNSip1[2]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNSip1_3_WRT120N");
			flag = false;
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSip1_4_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSip1_4_WRT120N", DNSip1[3]);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNSip1_4_WRT120N");
			flag = false;
		}
		return flag;
	}

	public boolean setMode_WRT120N(String mode) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Mode_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText, mode);
	}

	public boolean SSIDBroadCast_WRT120N(String is_ssid) {
		boolean isDHCPEn = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE") || is_ssid.contains("ENABLE")) {
			isDHCPEn = true;
		}
		WebElement SSIDEnable = WebUtils.getWebElement(testCase, fieldObjects, "SSIDEnable_WRT120N");
		String DHCPEnableDisable = SSIDEnable.getAttribute("checked");
		if (DHCPEnableDisable == null) {
			WebElement DHCPDisable = WebUtils.getWebElement(testCase, fieldObjects, "SSIDDisable_WRT120N");
			DHCPEnableDisable = DHCPDisable.getAttribute("checked");
			DHCPEnableDisable = DHCPEnableDisable + " :Disable";
		}
		if (isDHCPEn) {
			if (DHCPEnableDisable.contains("Dis")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDEnable_WRT120N");
			} else {
				return true;
			}
		} else {
			if (!DHCPEnableDisable.contains("Dis")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDDisable_WRT120N");
			} else {
				return true;
			}
		}
	}

	public boolean setSSIDName_WRT120N(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName_WRT120N", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSIDName_WRT120N");
			return false;
		}
	}

	public boolean selectBandwidth_WRT120N(String bandwidth) {
		WebElement BandWidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandWidth_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, BandWidthDropDown, SelectByOptions.ByVisibleText,
				bandwidth);
	}

	public boolean selectStandardChannel_WRT120N(String channel) {
		WebElement StandardChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "StandardChannel_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, StandardChannelDropDown, SelectByOptions.ByVisibleText,
				channel);
	}

	public boolean selectWideChannel_WRT120N(String channel) {
		WebElement WideChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WideChannel_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, WideChannelDropDown, SelectByOptions.ByVisibleText,
				channel);
	}

	public boolean clickOnManual_WIFIProtected(String Manual_WIFIProtected) {
		if (Manual_WIFIProtected.toUpperCase().contains("MANUAL")) {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "Manual_WRT120N")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Manual_WRT120N");
			} else {
				return false;
			}
		} else {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "WIFIProtected_WRT120N")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "WIFIProtected_WRT120N");
			} else {
				return false;
			}
		}
	}

	public boolean selectSecurity_WRT120N(String security) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Security_WRT120N");
		if (security.contains("WEP")) {
			return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByValue, "wep");
		}else if(security.toUpperCase().contains("DIS")) {
			return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByValue, "disabled");
		}
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean acceptAlert() {
		if (WebUtils.interactWithAlert(testCase, AlertOperations.Accept)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean selectEncryption_WRT120N(String encryption) {
		WebElement EncryptionDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Encryption_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, EncryptionDropDown, SelectByOptions.ByVisibleText,
				encryption);
	}

	public boolean clickOnGenerate() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Generate_WRT120N")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate_WRT120N");
		} else {
			return false;
		}
	}

	public boolean setPassword_WRT120N(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordWPA_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordWPA_WRT120N", password);
		} else {
			return false;
		}
	}

	public boolean setKeyRenew_WRT120N(String keyRenew) {
		WebElement keyRenewElement = WebUtils.getWebElement(testCase, fieldObjects, "KeyRenewWPA_WRT120N");
		return setAttribute("value", keyRenew, keyRenewElement);
	}

	private boolean setAttribute(String attribute, String keyRenew, WebElement Element) {
		WebDriver driver = testCase.getWebDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.evaluate(\"//*[@name='group_key_second']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.setAttribute('"
						+ attribute + "', '" + keyRenew + "')");
		if (Element.getAttribute(attribute).contains(keyRenew)) {
			return true;
		}
		return false;
	}

	public boolean selectEncryptionWPA2_WRT120N(String encryption) {
		WebElement EncryptionDropDown = WebUtils.getWebElement(testCase, fieldObjects, "EncryptionWPA2_WRT120N");
		return WebUtils.selectElementFromDropDown(testCase, EncryptionDropDown, SelectByOptions.ByVisibleText,
				encryption);
	}

	public boolean setRadiusServer_WRT120N(String radiusServer) {
		String[] serverValue = radiusServer.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusServer1_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusServer1_WRT120N", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusServer2_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusServer2_WRT120N", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusServer3_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusServer3_WRT120N", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusServer4_WRT120N")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusServer4_WRT120N", serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusPort_WRT120N(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPort_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPort_WRT120N", radiusPort);
		} else {
			return false;
		}
	}

	public boolean clickOnSaveSettings() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "SaveSettings_WRT120N")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveSettings_WRT120N");
		} else {
			return false;
		}
	}

	public boolean setPasswordWEP_WRT120N(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PassPhrase_WRT120N")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PassPhrase_WRT120N", password);
		} else {
			return false;
		}
	}
	
	public boolean select2Gbandwidth(String bandwidth) {
		WebElement bandwidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Bandwidth24_EA6900V1");
		return WebUtils.selectElementFromDropDown(testCase, bandwidthDropDown, SelectByOptions.ByVisibleText,
				bandwidth);
	}

	public boolean select5Gbandwidth(String bandwidth) {
		WebElement bandwidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Bandwidth5_EA6900V1");
		return WebUtils.selectElementFromDropDown(testCase, bandwidthDropDown, SelectByOptions.ByVisibleText,
				bandwidth);
	}
	
	public boolean setDnsIpAdress(String dnsIPAddress) {
		String[] Value = dnsIPAddress.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DnsIp1")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DnsIp1", Value[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DnsIp2")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DnsIp2", Value[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DnsIp3")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DnsIp3", Value[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DnsIp4")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DnsIp4", Value[3]);
		}
		return flag;
	}

	public boolean ClickRetryButton() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "RetryBtn")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "RetryBtn");
		}
		else {
			Keyword.ReportStep_Pass(testCase, "No need to click Retry Button !");
			return true;
		}
	}
	public boolean iselementPresent(int timeOut) {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}

}