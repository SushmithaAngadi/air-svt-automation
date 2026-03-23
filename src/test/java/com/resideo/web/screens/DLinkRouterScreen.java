package com.resideo.utils.web.screens;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class DLinkRouterScreen extends WebScreens {

	private static final String screenName = "DLinkRouterScreen";

	public DLinkRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean isExpectedElementPresent(String objectName) {
		WebDriver driver = testCase.getWebDriver();

		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.withTimeout(Duration.ofSeconds(60));
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.ignoring(IOException.class);

			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {

						if (WebUtils.isWebElementExists(testCase, fieldObjects, objectName)) {
							return true;
						} else {
							JavascriptExecutor j = (JavascriptExecutor) driver;
							j.executeScript("window.scrollBy(0,100)");
							return false;
						}
					} catch (Exception e) {
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception is occured due to " + e.getMessage());
			return false;
		}
	}

	public boolean isExpectedElementPresent(WebObjectLocators locaterType, String LocatorVAlue) {
		WebDriver driver = testCase.getWebDriver();

		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.withTimeout(Duration.ofSeconds(60));
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.ignoring(IOException.class);

			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {

						if (WebUtils.isWebElementExists(testCase, locaterType, LocatorVAlue)) {
							return true;
						} else {
							JavascriptExecutor j = (JavascriptExecutor) driver;
							j.executeScript("window.scrollBy(0,100)");
							return false;
						}
					} catch (Exception e) {
						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
								"Fluent wait for Downtime Got Exception, Exception is ++>>> " + e.getMessage());
						return false;
					}
				}
			});
			return isEventReceived;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception is occured due to " + e.getMessage());
			return false;
		}
	}

	public boolean setPasswordTB(String password) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordTB", password);
	}

	public boolean clickOnLoginBTN() {
		if (isExpectedElementPresent("LoginBTN")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "LoginBTN");
		} else {
			return false;
		}
	}

	public boolean isSmartConnectTogBTNEnabled() {
		if (isExpectedElementPresent("SmartConnectTogBTN")) {
			WebElement smartConnectTogBTN = WebUtils.getWebElement(testCase, fieldObjects, "SmartConnectTogBTN");
			if (!smartConnectTogBTN.isEnabled()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean smartConnectTogBTN() {
		if (isExpectedElementPresent("SmartConnectTogBTN")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SmartConnectTogBTN");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Smart Connect");
			return false;
		}
	}

	public boolean is2GHzToggleBTNEnabled() {
		if (isExpectedElementPresent("Status2GHzToggleBTN")) {
			WebElement statusTogBTN = WebUtils.getWebElement(testCase, fieldObjects, "Status2GHzToggleBTN");
			if (statusTogBTN.isEnabled()) {
				return true;
			} else {

				return WebUtils.clickOnWebElement(testCase, statusTogBTN);
			}
		} else {
			return false;
		}
	}

	public boolean is5GHzToggleBTNEnabled() {
		if (isExpectedElementPresent("Status5GHzToggleBTN")) {
			WebElement statusTogBTN = WebUtils.getWebElement(testCase, fieldObjects, "Status5GHzToggleBTN");
			if (statusTogBTN.isEnabled()) {
				return WebUtils.clickOnWebElement(testCase, statusTogBTN);

			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public boolean check5GHZToogleButton() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "Status5GHzToggleDisabledBTN")) {
			return false;
		} else if (WebUtils.isWebElementExists(testCase, fieldObjects, "Status5GHzToggleEnabledBTN")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean clickOnAdvancedSettings2GHz() {
		if (isExpectedElementPresent("AdvancedSettings2GHz")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettings2GHz");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Advanced Settings2GHz");
			return false;
		}
	}

	public boolean clickOnAdvancedSettings5GHz() {
		if (isExpectedElementPresent("AdvancedSettings5GHz")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettings5GHz");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Advanced Settings5GHz");
			return false;
		}
	}

	public boolean changeSecurityMode2GHzBTN(String security) {
		if (isExpectedElementPresent("SecurityMode2GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityMode2GHzBTN")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='security_24']/following-sibling::div//li/a[text()='" + security + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Security Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeMode2GHzBTN(String mode) {
		if (isExpectedElementPresent("Mode2GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "Mode2GHzBTN")) {
				if (isExpectedElementPresent(WebObjectLocators.By_XPATH,
						"//*[@id='show_80211Mode_24G']//li/a[text()='" + mode + "']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@id='show_80211Mode_24G']//li/a[text()='" + mode + "']");
				} else {
					return false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Mode Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeWiFiChannel2GHzBTN(String channelNumber) throws InterruptedException {
		if (isExpectedElementPresent("WiFiChannel2GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WiFiChannel2GHzBTN")) {
				Thread.sleep(3000);
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='channel_24']/following-sibling::div//li/a[text()='" + channelNumber + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Wifi Channel Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changebandWidth2GHzBTN(String channelWidth) throws InterruptedException {
		isElementPresent(5);
		if (isExpectedElementPresent("ChannelWidth2GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelWidth2GHzBTN")) {
				if (isExpectedElementPresent(WebObjectLocators.By_XPATH,
						"//*[@name='channelWidth_24']/following-sibling::div/ul//a[.='" + channelWidth + "']")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//*[@name='channelWidth_24']/following-sibling::div/ul//a[.='" + channelWidth + "']");
				} else {
					return false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the channel Width Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeSecurityMode5GHzBTN(String security) {
		if (isExpectedElementPresent("SecurityMode5GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityMode5GHzBTN")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='security_5']/following-sibling::div//li/a[text()='" + security + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security Mode Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeMode5GHzBTN(String mode) {
		if (isExpectedElementPresent("SecurityMode5GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "Mode5GHzBTN")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='80211Mode_5']/following-sibling::div//li/a[text()='" + mode + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Mode Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeWiFiChannel5GHzBTN(String channelNumber) {
		if (isExpectedElementPresent("WiFiChannel5GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WiFiChannel5GHzBTN")) {
				if(isExpectedElementPresent( WebObjectLocators.By_XPATH,
						"//*[@id='channel_5']/following-sibling::div//li/a[text()='" + channelNumber + "']")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='channel_5']/following-sibling::div//li/a[text()='" + channelNumber + "']");
				}else {
					return false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Wifi Channel Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changebandWidth5GHzBTN(String channelWidth) {
		if (isExpectedElementPresent("ChannelWidth5GHzBTN")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelWidth5GHzBTN")) {
				if(isExpectedElementPresent( WebObjectLocators.By_XPATH,
						"//*[@id='channelWidth_5']/following-sibling::div//li/a[text()='" + channelWidth + "']")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='channelWidth_5']/following-sibling::div//li/a[text()='" + channelWidth + "']");
				}else {
					return false;
				}
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Channel Width Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean clickOnWirelessTab_824VUP() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WIRELESS_824VUP");
	}

	public boolean changeChannel_824VUP(String channel) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "CHANNEL_824VUP");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean setvalueinSSID_824VUP(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDNAME_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDNAME_824VUP", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPKEy Mode");
			return false;
		}

	}

	public boolean changeSecurity_824VUP(String security) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "SECURITY_824VUP");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean selectWEPKeyEncryption_824VUP(String wep_encryption) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPEncryption_824VUP");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				wep_encryption);
	}

	public boolean setWEPKey_824VUP(String wep_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPKey1_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPKey1_824VUP", wep_key);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPKEy1");
			return false;
		}
	}

	public boolean selectWEPKeyMode_824VUP(String key_mode) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPKeyMode_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPKeyMode_824VUP", key_mode);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPKEy Mode");
			return false;
		}

	}

	public boolean setRadiusIP_824VUP(String radiusip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RADIUSIP_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RADIUSIP_824VUP", radiusip);
		} else {
			return false;
		}
	}

	public boolean setRadiusPort_824VUP(String radiusport) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RADIUSPORT_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RADIUSPORT_824VUP", radiusport);
		} else {
			return false;
		}

	}

	public boolean selectRadiusKeyLength_824VUP(String key_leng) {
		if (key_leng.contains("64")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "EncryptionKeyLength64_824VUP");
		} else if (key_leng.contains("128")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "EncryptionKeyLength128_824VUP");
		}
		return false;
	}

	public boolean setRadiusSharedKey_824VUP(String radius_shared_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RADIUSHAREDKEY_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RADIUSHAREDKEY_824VUP", radius_shared_key);
		} else {
			return false;
		}

	}

	public boolean setPreSharedKey_824VUP(String preshared_key_mode) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PreShareKey_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PreShareKey_824VUP", preshared_key_mode);
		} else {
			return false;
		}
	}

	public boolean enable_disable_DHCP_824VUP(String is_dhcp) {
		if (is_dhcp.contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPENABLE_824VUP");
		} else if (is_dhcp.contains("NO")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPDISALE_824VUP");
		}
		return false;
	}

	public boolean setvalueinDHCPLeaseTime_824VUP(String dhcplease) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "LeaseTime_824VUP");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, dhcplease);
	}

	public boolean setDHCPStartIPAdd_824VUP(String dhcp_start_ip_add) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIPAdd_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIPAdd_824VUP", dhcp_start_ip_add);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DHCPStartIP");
			return false;
		}
	}

	public boolean setDHCPEndIPAdd_824VUP(String dhcp_end_ip_add) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIP_824VUP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPEndIP_824VUP", dhcp_end_ip_add);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DHCPStartIP");
			return false;
		}
	}

	public boolean clickOnWirelessSecurityTab_824VUP() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_824VUP");
	}

	public boolean acceptAlert_824VUP() {
		if (WebUtils.interactWithAlert(testCase, AlertOperations.Accept)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean clickonApplybutton_824VUP(String screenName) {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "APPLYBTN_824VUP");
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean switchToMainFrame_824VUP() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "main");
	}

	public boolean clickOnContinueBTN_824VUP() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CONTBTN_824VUP");
	}

	public boolean iselementPresent_824VUP(int timeOut) {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}

	public boolean is_ssid_824VUP(String is_ssid) {
		if (is_ssid.contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ISSSIDON_824VUP");
		} else if (is_ssid.contains("NO")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ISSSIDOFF_824VUP");
		}
		return false;
	}

	public boolean enable_disableSmartConnectTogBTN(String enable_disable) {
		if (enable_disable.contains("DIS")) {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "WirelessLable_DIR1750")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SmartConnectTogBTN_Enable_DIR1750");

			} else {
				return true;
			}
		} else {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "WirelessLable_DIR1750")) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SmartConnectTogBTNDisable_DIR1750");
			}
		}
	}

	public boolean is2GHzToggleBTNEnabledDisable(String enable_disable) {
		boolean isEnable = true;
		String isDisable = "";
		if (isExpectedElementPresent("Status2GHzToggleBTN")) {
			WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSIDName2G_DIR1750");
			isDisable = SSID.getDomAttribute("disabled");
			if (isDisable != null && isDisable.toUpperCase().contains("TRUE")) {
				isEnable = false;
			}
		}
		if (enable_disable.contains("DIS") || enable_disable.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status2GHzToggleBTN");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status2GHzToggleBTN");

			}
		}
	}

	public boolean clickOnSaveBTN() {
		if (isExpectedElementPresent("rightFun_DIR1750")) {
			if (WebUtils.isWebElementExists(testCase, fieldObjects, "SaveBTN_DIR1750")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveBTN_DIR1750");
			} else {
				return WebUtils.isWebElementExists(testCase, fieldObjects, "SaveDisableBTN_DIR1750");
			}
		} else {
			return false;
		}
	}

	public boolean setSSIDName2G_DIR1750(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName2G_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName2G_DIR1750", ssid_name);
		}
		return false;
	}

	public boolean setPassword2G_DIR1750(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password2G_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password2G_DIR1750", password);
		}
		return false;
	}

	public boolean is5GHzToggleBTNEnabledDisable(String is_ssid) {
		boolean isEnable = true;
		String isDisable = "";
		if (isExpectedElementPresent("Status5GHzToggleBTN_DIR1750")) {
			WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSIDName5G_DIR1750");
			isDisable = SSID.getDomAttribute("disabled");
			if (isDisable != null && isDisable.toUpperCase().contains("TRUE")) {
				isEnable = false;
			}
		}
		if (is_ssid.contains("DIS") || is_ssid.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5GHzToggleBTN");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5GHzToggleBTN");

			}
		}
	}

	public boolean setSSIDName5G_DIR1750(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName5G_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName5G_DIR1750", ssid_name);
		}
		return false;
	}

	public boolean setPassword5G_DIR1750(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5G_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5G_DIR1750", password);
		}
		return false;
	}

	public boolean clickOnOkBtn() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OkBtn_DIR1750")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OkBtn_DIR1750");
		}
		return true;
	}

	public boolean clickOnAdvancedSettingsDHCP() {
		if (isExpectedElementPresent("AdvancedSettingsDHCP_DIR1750")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettingsDHCP_DIR1750");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Failed to click the AdvancedSettingsDHCP_DIR1750");
			return false;
		}
	}

	public boolean isDHCPToggleBTNEnabledDisable(String is_ssid) {
		boolean isEnable = false;
		String isDisable = "";
		if (isExpectedElementPresent("StatusDHCPToggleBTN_DIR1750")) {
			WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "StatusDHCPToggleBTN_DIR1750");
			isDisable = DHCP.getDomAttribute("class");
			if (isDisable != null && isDisable.toUpperCase().contains("ON")) {
				isEnable = true;
			}
		}
		if (is_ssid.contains("DIS") || is_ssid.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "StatusDHCPToggleBTN_DIR1750");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "StatusDHCPToggleBTN_DIR1750");

			}
		}
	}

	public boolean setDHCPstartIpAdd_DIR1750(String startIpAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIpAdd_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPStartIpAdd_DIR1750",
					startIpAdd.substring(startIpAdd.lastIndexOf(".") + 1));
		}
		return false;
	}

	public boolean setDHCPendIpAdd_DIR1750(String endIpAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIpAdd_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPEndIpAdd_DIR1750",
					endIpAdd.substring(endIpAdd.lastIndexOf(".") + 1));
		}
		return false;
	}

	public boolean setDHCPleaseTime_DIR1750(String leaseTime) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPleaseTime_DIR1750")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPleaseTime_DIR1750", leaseTime);
		}
		return false;
	}

//	public boolean setIPAdrees_DIR1750(String ipAdd) {
////		String a = ipAdd.substring(0, ipAdd.lastIndexOf('.')) + ".1";
//		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LanIp_DIR1750")) {
//			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LanIp_DIR1750",
//					ipAdd.substring(0, ipAdd.lastIndexOf('.')) + ".1");
//		}
//		return false;
//	}

	public boolean clickOnOkPopUpBTN() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OkNotificationBTN_DIR1750")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OkNotificationBTN_DIR1750");
		}
		return true;
	}

	public boolean enable_disableWifiMeshTogBTN(String enable_disable) {
		boolean isWifiMeshEnable = false;
		boolean isWifiMeshDisable = false;
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "WifiMeshEnable_DIR1750")) {
			isWifiMeshEnable = true;
			isWifiMeshDisable = false;
		}
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "WifiMeshDisable_DIR1750")) {
			isWifiMeshEnable = false;
			isWifiMeshDisable = true;
		}
		if (enable_disable.contains("DIS")) {
			if (isWifiMeshEnable && !isWifiMeshDisable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "WifiMeshInput_DIR1750");
			} else {
				return true;
			}
		} else {
			if (isWifiMeshDisable && !isWifiMeshEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "WifiMeshInput_DIR1750");
			} else {
				return true;
			}
		}

	}

	public boolean clickOnAdvancedSettings5SGHz() {
		if (isExpectedElementPresent("AdvancedSettings5SG_890L")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettings5SG_890L");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Advanced Settings5GHz");
			return false;
		}
	}

	public boolean changeSecurityMode5SGHzBTN(String security) {
		if (isExpectedElementPresent("SecurityMode5SGHzBTN_890L")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityMode5SGHzBTN_890L")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='security_5hi']/following-sibling::div//li/a[text()='" + security + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security Mode Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeMode5SGHzBTN(String mode) {
		if (isExpectedElementPresent("SecurityMode5SGHzBTN_890L")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ModeType5SGHz_890L")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@name='80211Mode_5hi']/following-sibling::div//li/a[text()='" + mode + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Mode Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeWiFiChannel5SGHzBTN(String channelNumber) {
		if (isExpectedElementPresent("WiFiChannel5SGHzBTN_890L")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WiFiChannel5SGHzBTN_890L")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='channel_5hi']/following-sibling::div//li/a[text()='" + channelNumber + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Wifi Channel Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changebandWidth5SGHzBTN(String channelWidth) {
		if (isExpectedElementPresent("ChannelWidth5SGHzBTN_890L")) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelWidth5SGHzBTN_890L")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//*[@id='channelWidth_5hi']/following-sibling::div//li/a[text()='" + channelWidth + "']");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Channel Width Dropdown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean setSSIDName5SG_890L(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName5SG_890L")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName5SG_890L", ssid_name);
		}
		return false;
	}

	public boolean setPassword5SG_890L(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5SG_890L")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5SG_890L", password);
		}
		return false;
	}

	public boolean is2GHzToggleBTNEnabledDisable_890L(String enable_disable) {
		boolean isEnable = true;
		String isDisable = "";
		if (isExpectedElementPresent("Status2GHzToggleBTN_890L")) {
			WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSIDName2G_DIR1750");
			isDisable = SSID.getDomAttribute("disabled");
			if (isDisable != null && isDisable.toUpperCase().contains("TRUE")) {
				isEnable = false;
			}
		}
		if (enable_disable.contains("DIS") || enable_disable.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status2GHzToggleBTN_890L");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status2GHzToggleBTN");

			}
		}
	}

	public boolean is5GHzToggleBTNEnabledDisable_890L(String is_ssid) {
		boolean isEnable = true;
		String isDisable = "";
		if (isExpectedElementPresent("Status5GHzToggleBTN_890L")) {
			WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSIDName5G_DIR1750");
			isDisable = SSID.getDomAttribute("disabled");
			if (isDisable != null && isDisable.toUpperCase().contains("TRUE")) {
				isEnable = false;
			}
		}
		if (is_ssid.contains("DIS") || is_ssid.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5GHzToggleBTN_890L");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5GHzToggleBTN");

			}
		}
	}

	public boolean is5SGHzToggleBTNEnabledDisable(String is_ssid) {
		boolean isEnable = true;
		String isDisable = "";
		if (isExpectedElementPresent("Status5SGHzToggleBTN_890L")) {
			WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSIDName5SG_890L");
			isDisable = SSID.getDomAttribute("disabled");
			if (isDisable != null && isDisable.toUpperCase().contains("TRUE")) {
				isEnable = false;
			}
		}
		if (is_ssid.contains("DIS") || is_ssid.contains("NO")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5SGHzToggleBTN_890L");

			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Status5GHzToggleBTN");

			}
		}
	}

	public boolean clickOnAdvancedSettings2GHz_890L() {
		if (isExpectedElementPresent("AdvancedSettings2GHz_890L")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettings2GHz_890L");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Advanced Settings2GHz");
			return false;
		}
	}

	public boolean clickOnAdvancedSettings5GHz_890L() {
		if (isExpectedElementPresent("AdvancedSettings5GHz_890L")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSettings5GHz_890L");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Failed to click the Advanced Settings2GHz");
			return false;
		}
	}

	public boolean clickOnOkPopUpBTN_DIR890L() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OKBTN_890L")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OKBTN_890L");
		}
		return true;
	}
	
	public void isElementPresent(int time) {
		WebUtils.isWebElementExists(testCase, fieldObjects, "OKBTN_890L");
	}

	public boolean isAdminPasswordBoxPresent() {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='admin_Password']");
	}

}