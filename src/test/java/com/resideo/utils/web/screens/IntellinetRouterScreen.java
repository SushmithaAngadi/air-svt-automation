package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.function.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class IntellinetRouterScreen extends WebScreens {

	private static final String screenName = "IntellinetRouterScreen";

	public IntellinetRouterScreen(TestCases testCase) {
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

	public boolean clickOnGeneralSetup() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "GenralSetupBT");
	}

	public boolean switchToDefaultFrame() {
		return WebUtils.switchBackToDefaultContext(testCase);
	}

	public boolean AfterloginFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, fieldObjects, "mainFrame");
	}

	public boolean WiFISettingFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, fieldObjects, "WIFIsettingFrame");
	}

	public boolean ClickonApplybutton() {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "ApplyBT")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBT");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find apply button");
			return false;
		}
	}

	public boolean ClickonOKbutton(int timeOut) {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OKBT")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OKBT");
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.FUNCTIONAL_FAILURE, "Not able to find Ok button");
			return false;
		}
	}

	public boolean ClickonOKbutton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "OKBT");
	}

	public boolean ClickonBandbutton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BandBT");
	}

	public boolean ClickonChannelbutton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ChanBT");
	}

	public boolean ClickonSecuritybutton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecuritySetBT");
	}

	public boolean ClickonBasicButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSettingBT");
	}

	public boolean ClickonWEPFormButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPKeyFormBT");
	}

	public boolean ClickonWEPLenButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPKeyLenBT");
	}

	public boolean ClickonWEPKeyButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPKeyBT");
	}

	public boolean changeMode(String Mode) {
		WebElement ModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "BandDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, ModeDropDown, SelectByOptions.ByVisibleText, Mode);
	}

	public boolean changeChannel(String Channel) {
		WebElement ChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ChannelDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, ChannelDropDown, SelectByOptions.ByVisibleText, Channel);
	}

	public boolean changeSecurity(String SecurityType) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "SecuritySetBT");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText,
				SecurityType);
	}

	public boolean changeWEP_Keylength(String WEPLen) {
		WebElement WEPLenDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPKeyLenBT");
		return WebUtils.selectElementFromDropDown(testCase, WEPLenDropDown, SelectByOptions.ByVisibleText, WEPLen);
	}


	public boolean changeWEPFormat(String wepFormat) {
		WebElement wepFormatDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPKeyFormBT");
		return WebUtils.selectElementFromDropDown(testCase, wepFormatDropDown, SelectByOptions.ByVisibleText,
				wepFormat);
	}

	public boolean changeWEPkey(String WEPKey) {
		WebElement WEPKeyDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPKeyBT");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyDropDown, SelectByOptions.ByVisibleText, WEPKey);
	}

	public boolean setValue_WepPassword(String password) {
		if (ClearPasswordWEP()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPPassKey", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean setValueinWPAPassword(String password) {
		if (ClearPasswordWPA()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAPassKey", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}

	}

	public boolean ClearPasswordWPA() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAPassKey");
	}

	public boolean ClearPasswordWEP() {

		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPPassKey");
	}

	public boolean ClickonWPATKIPCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPATKIPckb");
	}

	public boolean enable_disableWPATKIP(boolean isWPATKIP) {
		WebElement isWPATKIPEN = WebUtils.getWebElement(testCase, fieldObjects, "WPATKIPckb");
		boolean currentcheckBxStatus = isWPATKIPEN.isSelected();
		if (isWPATKIP) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPATKIPEN);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPATKIPEN);
			} else
				return true;
		}

	}

	public boolean changeWPA_suite(String suiteName) {
		if (suiteName.contains("TKIP")) {
			return enable_disableWPATKIP(true);
		} else if (suiteName.contains("AES")) {
			return enable_disableWPA2AES(true);
		} else if (suiteName.contains("MIXED")) {
			return enable_disableWPA2MIXED(true);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User expected Suite name is not available update feature file");
			return false;
		}

	}

	public boolean ClickonWPA2AESCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA2AESckb");
	}

	public boolean enable_disableWPA2AES(boolean isWPA2AES) {
		WebElement isWPA2AESEN = WebUtils.getWebElement(testCase, fieldObjects, "WPA2AESckb");
		boolean currentcheckBxStatus = isWPA2AESEN.isSelected();
		if (isWPA2AES) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPA2AESEN);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPA2AESEN);
			} else
				return true;
		}

	}

	public boolean enable_disableWPA2MIXED(boolean isWPA2Mixed) {
		WebElement isWPA2MIXEDEN = WebUtils.getWebElement(testCase, fieldObjects, "WPA2Mixedckb");
		boolean currentcheckBxStatus = isWPA2MIXEDEN.isSelected();
		if (isWPA2Mixed) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPA2MIXEDEN);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isWPA2MIXEDEN);
			} else
				return true;
		}

	}

	public boolean isWPA2AESEnabled(boolean selectstate) {
		WebElement isWPATKIP = WebUtils.getWebElement(testCase, fieldObjects, "WPA2AESckb");
		boolean selectstate1 = isWPATKIP.isSelected();
		if (selectstate == true) {
		}
		return selectstate1;
	}

	public boolean ClickonWPA2MixedCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA2Mixedckb");
	}

	public boolean isWPA2MixedEnabled(boolean selectstate) {
		WebElement isWPATKIP = WebUtils.getWebElement(testCase, fieldObjects, "WPA2Mixedckb");
		boolean selectstate1 = isWPATKIP.isSelected();
		if (selectstate == true) {
		}
		return selectstate1;
	}

	public boolean isWPA2Mixedenable() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "WPA2Mixedckb");
	}

	public boolean ClickonSecurityFrameButton() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityBT");
	}

	public boolean Clickon_setup_basicsetting() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessBT");
	}

	public boolean Clickon_setup_securitysetting() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SecuritytabBT");
	}

	public boolean enable_disable20MHZ(boolean is20MHZ) {
		WebElement is20MHzEN = WebUtils.getWebElement(testCase, fieldObjects, "BW20MHz");
		boolean currentcheckBxStatus = is20MHzEN.isSelected();
		if (is20MHZ) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, is20MHzEN);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, is20MHzEN);
			} else
				return true;
		}

	}

	public boolean ClickonBW20Checkbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BW20MHz");
	}

	public boolean ClickonBWAutoCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BWAuto");
	}

	public boolean enable_disableAutoMHZ(boolean isAutoMHZ) {
		WebElement isAutoEN = WebUtils.getWebElement(testCase, fieldObjects, "BWAuto");
		boolean currentcheckBxStatus = isAutoEN.isSelected();
		if (isAutoMHZ) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isAutoEN);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, isAutoEN);
			} else
				return true;
		}

	}

	public boolean changeChannelWidth(String channelWidth) {
		if (channelWidth.contains("AUTO") || channelWidth.contains("20/40")) {
			return enable_disableAutoMHZ(true);
		} else if (channelWidth.contains("20")) {
			return enable_disable20MHZ(true);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
					"User expected channel width is not available update feature file");
			return false;
		}

	}

	public boolean isBWAutoenable(boolean selectstate) {
		WebElement isBWAuto = WebUtils.getWebElement(testCase, fieldObjects, "BWAuto");
		boolean selectstate1 = isBWAuto.isSelected();
		if (selectstate == true) {
		}
		return selectstate1;
	}

	public boolean ClickonSSIDEnableCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDEnable");
	}

	public boolean SSIDEnable_Disable(String status) {
		boolean isSSIDEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement SSIDEN = WebUtils.getWebElement(testCase, fieldObjects, "SSIDEnable");
		WebElement SSIDDS = WebUtils.getWebElement(testCase, fieldObjects, "SSIDdisable");
		boolean currentEnablecheckBxStatus = SSIDEN.isSelected();
		boolean currentDisablecheckBxStatus = SSIDDS.isSelected();
		if (isSSIDEn) {
			if (!currentEnablecheckBxStatus && currentDisablecheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, SSIDEN);
			} else
				return true;
		} else {
			if (currentEnablecheckBxStatus && !currentDisablecheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, SSIDDS);
			} else
				return true;
		}

	}

	public boolean SSIDisable(boolean isSSIDDis) {
		WebElement SSIDDS = WebUtils.getWebElement(testCase, fieldObjects, "SSIDdisable");
		boolean currentcheckBxStatus = SSIDDS.isSelected();
		if (isSSIDDis) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, SSIDDS);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, SSIDDS);
			} else
				return true;
		}

	}

	public boolean isSSIDEnable(boolean selectstate) {
		WebElement isEnable = WebUtils.getWebElement(testCase, fieldObjects, "SSIDEnable");
		boolean selectstate1 = isEnable.isSelected();
		if (selectstate == true) {
		}
		return selectstate1;
	}

	public boolean ClickonSSIDDisableCheckbox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDdisable");
	}

	public boolean isSSIDDisable(boolean selectstate) {
		WebElement isDisable = WebUtils.getWebElement(testCase, fieldObjects, "SSIDdisable");
		boolean selectstate1 = isDisable.isSelected();
		if (selectstate == true) {
		}
		return selectstate1;
	}

	public boolean enable_disableBandwidthCheckBox(String Action) {
		boolean flag = false;
		if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//input[@name='QoSCtrl']")) {
			WebElement webElement = WebUtils.getWebElement(testCase, WebObjectLocators.By_XPATH,
					"//input[@name='QoSCtrl']");
			if (Action.toUpperCase().equals("DISABLE") && webElement.isSelected()) {
				webElement.click();
				flag = true;
			}
			if (Action.toUpperCase().equals("ENABLE") && !webElement.isSelected()) {
				webElement.click();
				flag = true;

			}
			flag = true;
		}

		return flag;
	}

	public boolean AfterLoginFrame() {
		return WebUtils.switchToFrameByWebElement(testCase, fieldObjects, "mainFrame");
	}

	public boolean setSSIDName(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName", ssid_name);
		}
		return false;
	}

	public boolean setRadiusIPAddress(String radiusIPAdd) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIPAdd")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIPAdd", radiusIPAdd);
		}
		return false;
	}

	public boolean changeWEP_Key(String wEP_key) {
		WebElement WEPKeyDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPKeyDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyDropDown, SelectByOptions.ByVisibleText, wEP_key);
	}

	public boolean DHCPEnable_Disable(String is_dhcpEnable) {
		
			if (isExpectedElementPresent("DHCPDrpDwn")) {

				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPDrpDwn")) {

					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//option[text()='" +is_dhcpEnable + "']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the DHCP DropDown");
					return false;
				}
			} else {
				return false;
			}
	}

	public boolean changeDHCPLeaseTime(String leaseTime) {
		WebElement LeaseTimeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "LeaseTimeDrpDwn");
		return WebUtils.selectElementFromDropDown(testCase, LeaseTimeDropDown, SelectByOptions.ByVisibleText,
				leaseTime);
	}

	public boolean setDHCPStartIP(String dhcpStartIP) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPStartIP", dhcpStartIP);
		}
		return false;
	}

	public boolean setDHCPEndIP(String dhcpEndIP) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DHCPEndIP", dhcpEndIP);
		}
		return false;
	}

}