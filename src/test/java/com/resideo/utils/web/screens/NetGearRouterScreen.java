package com.resideo.utils.web.screens;

import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.FrameworkGlobalVariables;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebObject;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class NetGearRouterScreen extends WebScreens {

	private static final String screenName = "NetGearRouterScreen";

	public NetGearRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean switchToBodyContentFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "page");
	}

	public boolean clickOnBroadCastSSID2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G");
	}

	public boolean clickOnBroadCastSSID5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G");
	}

	public boolean isBroadCastSSID5GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast5G").isSelected();
	}

	public boolean isBroadCastSSID2GEnabled() {
		return WebUtils.getWebElement(testCase, fieldObjects, "CheckBoxSSIDBroadcast2G").isSelected();
	}

	public boolean clickOnNoneSecurity5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeNone5GHZ");
	}

	public boolean clickOnAESSecurity5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeAES5GHZ");
	}

	public boolean clickOnWpaWpa2MixedSecurity5G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeWPAWPA2Mixed5GHZ");
	}

	public boolean isWpaWpa2MixedSecurity5G() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "SecurityTypeWPAWPA2Mixed5GHZ");
//				clickOnElement(fieldObjects, testCase, "SecurityTypeWPAWPA2Mixed5GHZ");
	}

//	public boolean isMixedAlertOKSecurity5G() {
//		return WebUtils.isWebElementExists(testCase, fieldObjects,"SecurityTypeWPAWPA2Mixed5GHZ");
////				clickOnElement(fieldObjects, testCase, "SecurityTypeWPAWPA2Mixed5GHZ");
//	}

	public boolean clickOnMixedAlertOKSecurity5G() {
		return WebUtils.interactWithAlert(testCase, AlertOperations.Accept);
	}

	public boolean clickOnNoneSecurity2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeNone2GHZ");
	}

	public boolean clickOnAESSecurity2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeAES2GHZ");
	}

	public boolean clickOnWpaWpa2MixedSecurity2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeWPAWPA2Mixed2GHZ");
	}

	public boolean clickOnWEPSecurity2G() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityTypeWEP2GHZ");
	}

	public boolean clickOnBasicTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSettingTab");
	}

	public boolean clickOnAdvanceTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvanceSettingTab");
	}

	public boolean clickOnFWUpdateTab() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "FirmWareUpdateBTN");
	}

	public boolean clickOnBasicHomeBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuHomeBTN");
	}

	public boolean clickOnBasicInternetBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuInternetBTN");
	}

	public boolean clickOnBasicWirelessBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuWirelessBTN");
	}

	public boolean clickOnBasicAttachedDevicesBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuAttachedDevicesBTN");
	}

	public boolean clickOnBasicParentalControlBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuParentalControlsBTN");
	}

	public boolean clickOnBasicReadyShareBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuReadyShareBTN");
	}

	public boolean clickOnBasicGuestNetworkBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicMenuGuestNetworkBTN");
	}

	public boolean isPageLoading() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "LoadingIcon");
	}

	public boolean select2GChannelNumber(String channelNumber) {
//		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ChannelNumber2GHZ");
//		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channelNumber);
		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "ChannelNumber2GHZ",
				SelectByOptions.ByVisibleText, channelNumber);
	}

	public boolean select2GModeType(String modeType) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ModeType2GHZ");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, modeType);
	}

	public boolean select5GChannelNumber(String channelNumber) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ChannelNumber5GHZ");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channelNumber);

	}

	public boolean select5GModeType(String modeType) {
//		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "ModeType5GHZ");

		return WebUtils.selectElementFromDropDown(testCase, fieldObjects, "ModeType5GHZ", SelectByOptions.ByVisibleText,
				modeType);
//		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, modeType);
	}

	public boolean clickOnApplyChangesBTN() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyChangesBTN");
	}

	public boolean setValueinPassword24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password24");
	}

	public boolean setValueinPassword24(String password) {
		if (setValueinPassword24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password24", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinPassword5() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5");
	}

	public boolean setValueinPassword5(String password) {
		if (setValueinPassword24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5", password);
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

	public boolean clickOnAdvSetupBT() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvSetupBT");
	}

	public boolean clickOnAdvLANSetupBT() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvLANSetupBT");
	}

	public boolean clickOnInternetSetupBT() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvInternetSetupBT");
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "DHCPcheckbox");
		if (isDHCPEn) {
			if (!DHCP.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox");
			} else {
				return true;
			}
		} else {
			if (DHCP.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox");
			} else {
				return true;
			}
		}
	}

	public boolean isExpectedElementPresent(String objectName, String id) {
		WebDriver driver = testCase.getWebDriver();

		try {
			FluentWait<Boolean> fWait = new FluentWait<Boolean>(false);
			fWait.withTimeout(Duration.ofSeconds(30));
			fWait.pollingEvery(Duration.ofSeconds(3));
			fWait.ignoring(IOException.class);

			boolean isEventReceived = fWait.until(new Function<Boolean, Boolean>() {
				public Boolean apply(Boolean input) {
					try {

						if (WebUtils.isWebElementExists(testCase, fieldObjects, objectName)) {
							System.out.println(objectName + " present");
							return true;
						} else {
							JavascriptExecutor j = (JavascriptExecutor) driver;
							// j.executeScript("window.scrollBy(0,100)");
							j.executeScript("document.getElementById(\"" + id + "\").scrollIntoView(true)");
							if (WebUtils.isWebElementExists(testCase, fieldObjects, objectName)) {
								System.out.println(objectName + "  present after srolling");
								return true;
							} else {
								System.out.println(objectName + " Not  present ");
								return false;
							}

						}

					} catch (Exception e) {
//						Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
//								"Fluent wait for Downtime Got Exception, Exception is ++>>> " + e.getMessage());
						return false;
					}
				}

			});
			return isEventReceived;
		} catch (TimeoutException e) {
			return false;
		} catch (Exception e) {
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"Exception is occured due to " + e.getMessage());
			return false;
		}

	}

	public boolean changeWEPAuthenctication(String WEPAUth) {
		if (isExpectedElementPresent("WEPAuthtype", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPAuthtype")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='authAlgm']//option[@value='" + WEPAUth + "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeWEPEncryption(String WEPEnc) {
		if (isExpectedElementPresent("WEPENCtype", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPENCtype")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wepenc']//option[@value='" + WEPEnc + "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean clearPasswordWEP() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPPassword");
	}

	public boolean setValueinWEP1PasswordTB(String password) {
		if (clearPasswordWEP()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPPassword", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean enableDisableSSID2G_R6250(String is_ssid) {
		boolean isSSID = false;
		boolean SSDEnable_Disable = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE")) {
			isSSID = true;
		}
		WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSID2GEnableDisable_R6250");
		try {
			String value = SSID.getAttribute("checked");
			if (value != null) {
				SSDEnable_Disable = true;
			}
		} catch (Exception e) {
		}
		if (isSSID) {
			if (!SSDEnable_Disable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID2GEnableDisable_R6250");
			} else {
				return true;
			}
		} else {
			if (SSID.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID2GEnableDisable_R6250");
			} else {
				return true;
			}
		}
	}

	public boolean setSSIDName2G_R6250_WNDR3800CH_R7000(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDNAme2G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDNAme2G_R6250", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSIDNAme2G_R6250");
			return false;
		}
	}

	public boolean selectChannel2G_R6250_WNDR3800CH_R7000(String channel) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "Channel2G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channel);
	}

	public boolean enableDisableSSID5G_R6250_WNDR3800CH_R7000(String is_ssid) {
		boolean isSSID = false;
		boolean SSDEnable_Disable = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE")) {
			isSSID = true;
		}
		WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSID5GEnableDisable_R6250");
//		String a = SSID.getAttribute("checked");
		try {
			String value = SSID.getAttribute("checked");
			if (value != null) {
				SSDEnable_Disable = true;
			}
		} catch (Exception e) {
		}
		if (isSSID) {
			if (!SSDEnable_Disable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID5GEnableDisable_R6250");
			} else {
				return true;
			}
		} else {
			if (SSID.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID5GEnableDisable_R6250");
			} else {
				return true;
			}
		}
	}

	public boolean setSSIDName5G_R6250_WNDR3800CH_R7000(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDNAme5G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDNAme5G_R6250", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSIDNAme5G_R6250");
			return false;
		}
	}

	public boolean selectChannel5G_R6250_WNDR3800CH_R7000(String channel) {
		WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "Channel5G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channel);
	}

	public boolean selectMode2G_R6250_WNDR3800CH_R7000(String mode) {
		WebElement modeSel = WebUtils.getWebElement(testCase, fieldObjects, "Mode2G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, modeSel, SelectByOptions.ByVisibleText, mode);
	}

	public boolean selectMode5G_R6250_WNDR3800CH_R7000(String mode) {
		WebElement modeSel = WebUtils.getWebElement(testCase, fieldObjects, "Mode5G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, modeSel, SelectByOptions.ByVisibleText, mode);
	}

	public boolean selectSecurity2G_R6250(String security) {
		if (security.toUpperCase().contains("NONE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "None2G_R6250");
		} else if (security.toUpperCase().contains("TKIP") && security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Mixed2G_R6250");
		} else if (security.toUpperCase().contains("WEP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP2G_R6250");
		} else if (security.toUpperCase().contains("TKIP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "TKIP2G_R6250");
		} else if (security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AES2G_R6250");
		} else if (security.toUpperCase().contains("ENTERPRISE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Enterprise2G_R6250");
		}
		return false;
	}

	public boolean selectSecurity5G_R6250(String security) {
		if (security.toUpperCase().contains("NONE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "None5G_R6250");
		} else if (security.toUpperCase().contains("TKIP") && security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Mixed5G_R6250");
		} else if (security.toUpperCase().contains("TKIP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "TKIP5G_R6250");
		} else if (security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AES5G_R6250");
		} else if (security.toUpperCase().contains("ENTERPRISE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Enterprise5G_R6250");
		}
		return false;
	}

	public boolean selectWEPAuth2G_R6250_WNDR3800CH_R7000(String wEPAuth) {
		WebElement wEPAuthSel = WebUtils.getWebElement(testCase, fieldObjects, "WEPAuth2G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, wEPAuthSel, SelectByOptions.ByVisibleText, wEPAuth);
	}

	public boolean selecWEPencrpytion2G_R6250_WNDR3800CH_R7000(String wEPencrpytion) {
		WebElement wEPencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WEPencrpytion2G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, wEPencrpytionSel, SelectByOptions.ByVisibleText,
				wEPencrpytion);
	}

	public boolean setWEPPassword2G_R6250(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPPassword2G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPPassword2G_R6250", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEPPassword2G_R6250");
			return false;
		}
	}

	public boolean setWPAPassword2G_R6250_WNDR3800CH_R7000(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAPassword2G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAPassword2G_R6250", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WPAPassword2G_R6250");
			return false;
		}
	}

	public boolean setWPAPassword5G_R6250(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAPassword5G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAPassword5G_R6250", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WPAPassword5G_R6250");
			return false;
		}
	}

	public boolean selecWPAencrpytion2G_R6250(String encrpytion) {
		WebElement WPAencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WPAencrpytion2G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, WPAencrpytionSel, SelectByOptions.ByVisibleText,
				encrpytion);
	}

	public boolean selecWPAencrpytion5G_R6250(String encrpytion) {
		WebElement WPAencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WPAencrpytion5G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, WPAencrpytionSel, SelectByOptions.ByVisibleText,
				encrpytion);
	}

	public boolean setWPAEnterpriseInterval2G_R6250_WNDR3800CH_R7000(String wPAEnterpriseInterval) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseInterval2G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseInterval2G_R6250",
					wPAEnterpriseInterval);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseInterval2G_R6250");
			return false;
		}
	}

	public boolean setWPAEnterpriseInterval5G_R6250_WNDR3800CH_R7000(String wPAEnterpriseInterval) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseInterval5G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseInterval5G_R6250",
					wPAEnterpriseInterval);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseInterval5G_R6250");
			return false;
		}
	}

	public boolean setRadiusIP2G_R6250(String radiusIP) {
		String[] serverValue = radiusIP.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue12G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue12G_R6250", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue22G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue22G_R6250", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue32G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue32G_R6250", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue42G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue42G_R6250", serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusIP5G_R6250(String radiusIP) {
		String[] serverValue = radiusIP.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue15G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue15G_R6250", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue25G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue25G_R6250", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue35G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue35G_R6250", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue45G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue45G_R6250", serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusPort2G_R6250(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseradiusPort2G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseradiusPort2G_R6250", radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort2G_R6250");
			return false;
		}
	}

	public boolean setRadiusPort5G_R6250(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseradiusPort5G_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseradiusPort5G_R6250", radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort5G_R6250");
			return false;
		}
	}

	public boolean enableDisableis_dhcp_R6250_WNDR3800CH_R7000(String is_dhcp) {
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "DHCP_R6250");
		boolean isDHCPEn = false;
		if (is_dhcp.contains("YES") || is_dhcp.contains("TRUE")) {
			isDHCPEn = true;
		}
		if (isDHCPEn) {
			if (!DHCP.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_R6250");
			} else {
				return true;
			}
		} else {
			if (DHCP.isSelected()) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_R6250");
			} else {
				return true;
			}
		}
	}

	public boolean setDHCPStartIP_R6250_WNDR3800CH_R7000(String dhcpStartIPAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIpAdd_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPStartIpAdd_R6250",
					dhcpStartIPAdd.substring(dhcpStartIPAdd.lastIndexOf(".") + 1));
		}
		return false;
	}

	public boolean setDHCPEndIP_R6250_WNDR3800CH_R7000(String dhcpEndIPAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIpAdd_R6250")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPEndIpAdd_R6250",
					dhcpEndIPAdd.substring(dhcpEndIPAdd.lastIndexOf(".") + 1));
		}
		return false;
	}

	public boolean clickOnApplyBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Apply_R6250");
	}

	public boolean clickOnGenerateBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Generate_R6250");
	}

	public boolean clickOnInternetBtn_WNDR3800CH() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "InternetBtn_WNDR3800CH");
	}

	public boolean clickOnSetupInAdvanceSetup_WNDR3800CH_R7000() {
		boolean flag = false;
		if (WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvanceBtn_WNDR3800CH")) {
			flag = true;
			Keyword.ReportStep_Pass(testCase, "Successfuly clicked on AdvanceBtn_WNDR3800CH");
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SetupBtn_WNDR3800CH")) {
				flag = true;
				Keyword.ReportStep_Pass(testCase, "Successfuly clicked on SetupBtn_WNDR3800CH");
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
						"Not able to click on SetupBtn_WNDR3800CH");
				flag = false;
			}
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
					"Not able to click on AdvanceBtn_WNDR3800CH");
			flag = false;
		}
		return flag;
	}

	public boolean clickLanSetup_WNDR3800CH_R7000() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "LanSetup_WNDR3800CH");
	}

	public boolean switchToTopFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "topframe");
	}

	public boolean switchToFormFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "formframe");
	}

	public boolean setIPAdrees_R6250_WNDR3800CH_R7000(String ipAdd) {
		boolean flag = false;
		String[] ipAddress = ipAdd.split("\\.");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPIpAdd1_R6250")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPIpAdd1_R6250", ipAddress[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPIpAdd2_R6250")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPIpAdd2_R6250", ipAddress[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPIpAdd3_R6250")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPIpAdd3_R6250", ipAddress[2]);
		}
		return flag;
	}

	public boolean clickOnWirelessSetup_WNDR3800CH_R7000() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessSetup_WNDR3800CH");
	}

	public boolean enableDisableSSID2G_WNDR3800CH_R7000(String is_ssid) {
		boolean isSSID = false;
		boolean SSDEnable_Disable = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE")) {
			isSSID = true;
		}
		WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "SSID2GEnableDisable_WNDR3800CH");
		try {
			String value = SSID.getAttribute("checked");
			if (value != null) {
				SSDEnable_Disable = true;
			}
		} catch (Exception e) {
		}
		if (isSSID) {
			if (!SSDEnable_Disable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID2GEnableDisable_WNDR3800CH");
			} else {
				return true;
			}
		} else {
			if (SSID.getAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID2GEnableDisable_WNDR3800CH");
			} else {
				return true;
			}
		}
	}

	public boolean selectSecurity2G_WNDR3800CH_R7000(String security) {
		if (security.toUpperCase().contains("NONE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "None2G_WNDR3800CH");
		} else if (security.toUpperCase().contains("TKIP") && security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Mixed2G_WNDR3800CH");
		} else if (security.toUpperCase().contains("WEP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP2G_WNDR3800CH");
		} else if (security.toUpperCase().contains("TKIP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "TKIP2G_WNDR3800CH");
		} else if (security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AES2G_WNDR3800CH");
		} else if (security.toUpperCase().contains("ENTERPRISE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Enterprise2G_WNDR3800CH");
		}
		return false;
	}

	public boolean selectSecurity5G_WNDR3800CH_R7000(String security) {
		if (security.toUpperCase().contains("NONE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "None5G_WNDR3800CH");
		} else if (security.toUpperCase().contains("TKIP") && security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Mixed5G_WNDR3800CH");
		} else if (security.toUpperCase().contains("WEP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP5G_WNDR3800CH");
		} else if (security.toUpperCase().contains("TKIP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "TKIP5G_WNDR3800CH");
		} else if (security.toUpperCase().contains("AES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AES5G_WNDR3800CH");
		} else if (security.toUpperCase().contains("ENTERPRISE")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Enterprise5G_WNDR3800CH");
		}
		return false;
	}

	public boolean selecWPAencrpytion2G_WNDR3800CH_R7000(String encrpytion) {
		WebElement WPAencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WPAencrpytion2G_WNDR3800CH");
		return WebUtils.selectElementFromDropDown(testCase, WPAencrpytionSel, SelectByOptions.ByVisibleText,
				encrpytion);
	}

	public boolean selecWPAencrpytion5G_WNDR3800CH_R7000(String encrpytion) {
		WebElement WPAencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WPAencrpytion5G_WNDR3800CH");
		return WebUtils.selectElementFromDropDown(testCase, WPAencrpytionSel, SelectByOptions.ByVisibleText,
				encrpytion);
	}

	public boolean setRadiusIP2G_WNDR3800CH_R7000(String radiusIP) {
		String[] serverValue = radiusIP.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue12G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue12G_WNDR3800CH",
					serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue22G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue22G_WNDR3800CH",
					serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue32G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue32G_WNDR3800CH",
					serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue42G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue42G_WNDR3800CH",
					serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusIP5G_WNDR3800CH_R7000(String radiusIP) {
		String[] serverValue = radiusIP.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue15G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue15G_WNDR3800CH",
					serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue25G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue25G_WNDR3800CH",
					serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue35G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue35G_WNDR3800CH",
					serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "clearserverValue45G")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "clearserverValue45G_WNDR3800CH",
					serverValue[3]);
		}
		return flag;
	}

	public boolean setRadiusPort2G_WNDR3800CH_R7000(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseradiusPort2G_WNDR3800CH")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseradiusPort2G_WNDR3800CH",
					radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort2G_WNDR3800CH");
			return false;
		}
	}

	public boolean setRadiusPort5G_WNDR3800CH_R7000(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterpriseradiusPort5G_WNDR3800CH")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterpriseradiusPort5G_WNDR3800CH",
					radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort5G_WNDR3800CH");
			return false;
		}
	}

	public boolean setWPAEnterprisePassword2G_WNDR3800CH_R7000(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterprisePassword2G_WNDR3800CH")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterprisePassword2G_WNDR3800CH",
					password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterprisePassword2G_WNDR3800CH");
			return false;
		}
	}

	public boolean setWPAEnterprisePassword5G_WNDR3800CH_R7000(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAEnterprisePassword5G_WNDR3800CH")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAEnterprisePassword5G_WNDR3800CH",
					password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterprisePassword5G_WNDR3800CH");
			return false;
		}
	}

	public boolean selectWEPAuth5G_R6250(String wEPAuth) {
		WebElement wEPAuthSel = WebUtils.getWebElement(testCase, fieldObjects, "WEPAuth5G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, wEPAuthSel, SelectByOptions.ByVisibleText, wEPAuth);
	}

	public boolean selecWEPencrpytion5G_R6250(String encrpytion) {
		WebElement wEPencrpytionSel = WebUtils.getWebElement(testCase, fieldObjects, "WEPencrpytion5G_R6250");
		return WebUtils.selectElementFromDropDown(testCase, wEPencrpytionSel, SelectByOptions.ByVisibleText,
				encrpytion);
	}

	public boolean setWEPKey12G_R6250_WNDR3800CH_R7000(String wEPKey1) {
		if (WebUtils.clickOnWebElement(testCase, fieldObjects, "Key12GRadioBtn_WNDR3800CH")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key12GTxtBox_WNDR3800CH")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key12GTxtBox_WNDR3800CH", wEPKey1);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Not able to clear Key12GTxtBox_WNDR3800CH");
				return false;
			}
		}
		return false;
	}

	public boolean setWEPKey15G_R6250(String wEPKey1) {
		if (WebUtils.clickOnWebElement(testCase, fieldObjects, "Key15GRadioBtn_WNDR3800CH")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key15GTxtBox_WNDR3800CH")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key15GTxtBox_WNDR3800CH", wEPKey1);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Not able to clear Key15GTxtBox_WNDR3800CH");
				return false;
			}
		}
		return false;
	}

	public boolean switchToPage2Frame() {
		return WebUtils.switchToFrameByWebElement(testCase, WebObjectLocators.By_NAME, "page2");
	}

	public boolean ClickOnSaveBtn_handleAlert(String screenName) {
		boolean flag = false;
		if (screenName.contains("WIRELESS") || (screenName.contains("DHCP"))) {
			if (clickOnApplyBtn()) {
				if (interactWithAlert(testCase, AlertOperations.Accept, 2)) {
					Keyword.ReportStep_Pass(testCase, "Settings saved");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Alert.");
				}
				if (isSettingsAppled()) {
					Keyword.ReportStep_Pass(testCase, "Settings Applied Succesfully");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE,
							"Settings Not Applied. TimeOut Exceeded");
				}
			} else {
				Keyword.ReportStep_Pass(testCase, "There is not reboot button, so alert will not be expected");
				flag = true;
			}
		} else if (screenName.contains("DNS")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Apply_Btn_RBR20");
		}
		return flag;
	}

	private boolean isSettingsAppled() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "Apply_R6250");
	}

	public static boolean interactWithAlert(TestCases testCase, AlertOperations action, int noOfAlert) {
		String AlertMsg = "";
		WebDriver driver = testCase.getWebDriver();
		boolean flag = false;
		for (int i = 0; i < noOfAlert; i++) {
			if (driver != null) {
				try {
					FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
					fWait.withTimeout(Duration.ofMillis(FrameworkGlobalVariables.LONG_WAIT));
					fWait.pollingEvery(Duration.ofMillis(3));
					fWait.ignoring(NoSuchElementException.class);
					try {
						fWait.until(ExpectedConditions.alertIsPresent());
						AlertMsg = driver.switchTo().alert().getText();
						switch (action) {
						case Accept:
							driver.switchTo().alert().accept();
							break;
						case Dismiss:
							driver.switchTo().alert().dismiss();
							break;
						}

					} catch (TimeoutException e) {
						Keyword.ReportStep_Pass(testCase, String.format("Alert did not appear"));
						flag = true;
					}
					Keyword.ReportStep_Pass(testCase,
							String.format("Interact with alert : %s action successful.", action));
					Keyword.ReportStep_Pass(testCase, "\n Alert Text :" + AlertMsg);
					flag = true;
				} catch (Exception e) {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION, String
							.format("Interact with alert : [%s] action failed. Reason - %s", action, e.getMessage()));
				}
			}
		}

		return flag;
	}

	public boolean selectRegion(String region) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "Region");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, region);
	}

	public boolean select_WPA_Mode_RAX10(String wpa_mode) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "WPAMode_RAX10");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, wpa_mode);
	}

	public boolean setRadiusPort2G_RAX10(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPort_RAX10")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPort_RAX10", radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort2G_RAX10");
			return false;
		}
	}

	public boolean setRadiusSharedKey2G_RAX10(String radius_shared_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusKey_RAX10")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusKey_RAX10", radius_shared_key);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"Not able to clear WPAEnterpriseradiusPort2G_RAX10");
			return false;
		}
	}

	@Deprecated
	// Javascript method will be handled in Core framework
	public boolean selectSecurity5G_RAX10(String security) {
		WebElement findElement = null;
		WebDriver webDriver = testCase.getWebDriver();
		List<WebElement> findElements = webDriver.findElements(By.id("formframe"));
		WebDriver frame = webDriver.switchTo().frame(findElements.get(0));
		if (security.toUpperCase().contains("WPA/WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_an_wpa_enter']"));
		} else if (security.toUpperCase().contains("WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_an_wpa2']"));
		} else if (security.toUpperCase().contains("WPA") && security.toUpperCase().contains("WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_an_auto']"));
		} else if (security.toUpperCase().contains("WPA3")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_an_wpa3']"));
		}
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].click();", findElement);
		return true;
	}

	public boolean select_WPA_Mode_5G_RAX10(String wpa_mode) {
//		boolean a = WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//*[@name='wpae_mode_an']");
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "WPA_MODE_5G_RAX10");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, wpa_mode);
	}

	public boolean setRadiusPort5G_RAX10(String radiusPort) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPort_5G_RAX10")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPort_5G_RAX10", radiusPort);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusPort_5G_RAX10");
			return false;
		}
	}

	public boolean setRadiusSharedKey5G_RAX10(String radius_shared_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusKey_5G_RAX10")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusKey_5G_RAX10", radius_shared_key);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear RadiusKey_5G_RAX10");
			return false;
		}
	}

	@Deprecated
	// Javascript method will be handled in Core framework
	public boolean enable_disable_dhcp_RAX10(String is_dhcp) {
		String isDisabled;
		WebElement findElement = null;
		WebDriver webDriver = testCase.getWebDriver();
		List<WebElement> findElements = webDriver.findElements(By.id("formframe"));
		WebDriver frame = webDriver.switchTo().frame(findElements.get(0));
		findElement = frame.findElement(By.xpath("//*[@name='dhcp_server']"));
		isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "DHCPStartIpAdd_R6250", "disabled");
		if (is_dhcp.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
			return true;
		} else if (is_dhcp.contains("Enable") && isDisabled == null) {
			return true;
		} else {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript("arguments[0].click();", findElement);
			return true;
		}
	}

	@Deprecated
	// Javascript method will be handled in Core framework

	public boolean selectSecurity2G_RAX10(String security) {
		WebElement findElement = null;
		WebDriver webDriver = testCase.getWebDriver();
		List<WebElement> findElements = webDriver.findElements(By.id("formframe"));
		WebDriver frame = webDriver.switchTo().frame(findElements.get(0));
		if (security.toUpperCase().contains("WPA/WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_wpa_enter']"));
		} else if (security.toUpperCase().contains("WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_wpa2']"));
		} else if (security.toUpperCase().contains("WPA") && security.toUpperCase().contains("WPA2")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_auto']"));
		} else if (security.toUpperCase().contains("WPA3")) {
			findElement = frame.findElement(By.xpath("//*[@id='security_wpa3']"));
		}
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("arguments[0].click();", findElement);
		return true;
	}

	public boolean setLeaseTime_RAX10(String lease_time) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime_RAX10")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime_RAX10", lease_time);
		}
		return false;
	}
	
	public boolean clickOnAdvSetup_WNDR4300v2_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Adv_Setup_RBR20");
	}

	public boolean clickDNS_WNDR4300v2_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "DNS_RBR20");
	}
	
	public boolean setIsDns_WNDR4300v2(String is_dns) {
		String isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "DNS_Password_WNDR4300v2", "disabled");
		if (is_dns.contains("NO") && !(isDisabled == null) && isDisabled.equals("true")) {
			return true;
		} else if (is_dns.contains("YES") && isDisabled == null) {
			return true;
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DnsCheck_WNDR4300v2");
		}
	}

	public boolean setHostName_WNDR4300v2(String host_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "HostName_WNDR4300v2")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "HostName_WNDR4300v2", host_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear host_name");
			return false;
		}
	}

	public boolean setEmail_WNDR4300v2(String email) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "EmailDNS_WNDR4300v2")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "EmailDNS_WNDR4300v2", email);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear email");
			return false;
		}
	}

	public boolean setPassKey_WNDR4300v2(String passkey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNS_Password_WNDR4300v2")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNS_Password_WNDR4300v2", passkey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNS_Password_WNDR4300v2");
			return false;
		}
	}
	
	public boolean clickLanSetup_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "LanSetup_RBR20");
	}

	public boolean clickOnWirelessSetup_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessSetup_WNDR3800CH");
	}

	public boolean setSSIDName_RBR20(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID_NAME_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID_NAME_RBR20", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID_NAME_RBR20");
			return false;
		}
	}

	public boolean setPassword_RBR20(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password_RBR20", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Password_RBR20");
			return false;
		}
	}

	public boolean selectChannel_RBR20(String channel,String frequency) {
		if(frequency.contains("2.4")) {
			WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "Channel2G_RBR20");
			return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channel);
		}else if (frequency.contains("5")) {
			WebElement chanSel = WebUtils.getWebElement(testCase, fieldObjects, "Channel5G_RBR20");
			return WebUtils.selectElementFromDropDown(testCase, chanSel, SelectByOptions.ByVisibleText, channel);
		}else {
			return false;
		}
	}

	public boolean setDHCPStartIP_RBR20(String start_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIP_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIP_RBR20", start_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear start_ip");
			return false;
		}
	}

	public boolean setDHCPEndIP_RBR20(String end_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "EndIP_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "EndIP_RBR20", end_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear end_ip");
			return false;
		}
	}

	public boolean enableDisableis_dhcp_RBR20(String is_dhcp) {
		String isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "StartIP_RBR20", "disabled");
		if (is_dhcp.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
			return true;
		} else if (is_dhcp.contains("Enable") && isDisabled == null) {
			return true;
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_R6250");
		}
	}

	public boolean clickOnWPA_WPA2() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA_WPA2_RBR20");
	}

	public boolean clickOnWPA2_PSK_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA2_PSK_RBR20");
	}

	public boolean clickOnNoneSecurity_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "NoneSec_RBR20");
	}

	public boolean ClickOnApply_handleAlert(String screenName) {
		if (screenName.contains("WIRELESS")) {
			boolean flag = false;
			if (clickOnApplyBtn_RBR20()) {
				if (interactWithAlert(testCase, AlertOperations.Accept, 2)) {
					Keyword.ReportStep_Pass(testCase, "Alert handled for apply button");
					flag = true;
				} else {
					flag = false;
					Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to click Alert.");
				}
			}
		}else if (screenName.contains("DNS")) {
			AgreeButton();
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Register_RBR20");
		}
		return true;
	}

	private boolean AgreeButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Agree_Btn_RBR20");
	}

	private boolean clickOnApplyBtn_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Apply_Btn_RBR20");
	}

	public boolean clickAdvanceSetup_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvanceBtn_WNDR3800CH");
	}

	public boolean clickSetup_RBR20() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SetupBtn_WNDR3800CH");
	}

	public boolean setHostName_RBR20(String host_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "HostName_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "HostName_RBR20", host_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear host_name");
			return false;
		}
	}

	public boolean setEmail_RBR20(String email) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "EmailDNS_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "EmailDNS_RBR20", email);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear email");
			return false;
		}
	}

	public boolean setPassKey_RBR20(String passkey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNS_Password_RBR20")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNS_Password_RBR20", passkey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear DNS_Password_RBR20");
			return false;
		}
	}

	public boolean setIsDns_RBR20(String is_dns) {
		String isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "DNS_Password_RBR20", "disabled");
		if (is_dns.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
			return true;
		} else if (is_dns.contains("Enable") && isDisabled == null) {
			return true;
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "Agree_Btn_RBR20");
		}
	}

	public boolean setService_WNDR4300v2(String service) {
		if(service.contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "YesAccount_WNDR4300v2");
		}else if (service.contains("NO")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "NoAccount_WNDR4300v2");
		}else {
			return false;
		}
	}
	
	public boolean isElemetPresent(int time) {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "NoAccount_WNDR4300v2");
	}

}