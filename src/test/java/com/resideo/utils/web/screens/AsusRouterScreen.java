package com.resideo.utils.web.screens;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.function.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class AsusRouterScreen extends WebScreens {

	private static final String screenName = "AsusRouterScreen";

	public AsusRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean _RTAC68UisExpectedElementPresent(String objectName, String id) {
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

	public boolean _RTAC68U_select_frequency(String frequecy) {
		if (_RTAC68UisExpectedElementPresent("FrequencyDropdown", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "FrequencyDropdown")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_unit']/option[text()='"+frequecy+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_select_bandwidth(String bandwidth) {
		if (_RTAC68UisExpectedElementPresent("ChannelBandwidth", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelBandwidth")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_bw']/option[text()='"+bandwidth+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the bandwidth DropDown");
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_select_WirelessMode(String mode) {
		if (_RTAC68UisExpectedElementPresent("WirelessMode", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessMode")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_nmode_x']/option[text()='"+mode+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the WirelessMode DropDown");
				return false;
			}
		} else {
			return false;
		}
	}


	public boolean _RTAC68U_enable_disable_bgProtection(boolean isEnable) {
		WebElement b_g = WebUtils.getWebElement(testCase, fieldObjects, "B_G_Protection");
		if (_RTAC68UisExpectedElementPresent("WirelessMode", "")) {
			if (isEnable) {
				if (!b_g.getAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "B_G_Protection");
				} else {
					return true;
				}
			} else {
				if (b_g.getAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "B_G_Protection");
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_select_Channel(String channel) {
		if (_RTAC68UisExpectedElementPresent("Channel", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "Channel")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_channel']/option[text()='"+channel+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the WirelessMode DropDown");
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_select_Security(String security) {
		if (_RTAC68UisExpectedElementPresent("SecurityType", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityType")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_auth_mode_x']/option[text()='"+security+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_changeWPAEncrpytion(String encrpytion) {
		if (_RTAC68UisExpectedElementPresent("WPA_EncryptionDropdown", "")) {

				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA_EncryptionDropdown")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//select[@name='wl_crypto']/option[text()='"+encrpytion+"']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the encryption DropDown");
					return false;
				}
			}
		 else {
			return false;
		}
	}
	
	public boolean _RTAC68U_changeWEPEncrpytion(String WEPencrpytion) {
		if (_RTAC68UisExpectedElementPresent("WEP_EncryptionDropdown", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP_EncryptionDropdown")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//select[@name='wl_wep_x']/option[text()='"+WEPencrpytion+"']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_changeWEPKeyIndex(String WEPKey) {
		if (_RTAC68UisExpectedElementPresent("WEP_KeyDropdown", "")) {

				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP_KeyDropdown")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//select[@name='wl_key']/option[text()='"+WEPKey+"']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the encryption DropDown");
					return false;
				}
	
		} else {
			return false;
		}
	}
	
	public boolean _RTAC68U_SSIDEnable_Disable(String status) {
		boolean isSSIDEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement SSIDEN = WebUtils.getWebElement(testCase, fieldObjects, "HideSSIDEnable");
		WebElement SSIDDS = WebUtils.getWebElement(testCase, fieldObjects, "HideSSIDdisable");
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
 
	public boolean _RTAC68U_setValueinWEP2PasswordTB(String WEPpassword) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_Key2Password", WEPpassword);
	}
	
	public boolean _RTAC68U_setValueinWEP3PasswordTB(String WEPpassword) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_Key3Password", WEPpassword);
	}
	
	public boolean _RTAC68U_setValueinWEP4PasswordTB(String WEPpassword) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_Key4Password", WEPpassword);
	}
	
	public boolean _RTAC68U_setvalueinNetworkKey(String networkkey) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "NetworkKeyRotation", networkkey);
	}
		
	public boolean _RTAC68U_clickApplyBT() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBT");
	}

	public boolean _RTAC68U_iselementPresent() {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}
	
	public boolean _RTAC68U_DHCPEnable_Disable(String status) {
		boolean isSSIDEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement DHCPEN = WebUtils.getWebElement(testCase, fieldObjects, "DHCPEnable");
		WebElement DHCPDS = WebUtils.getWebElement(testCase, fieldObjects, "DHCPDisable");
		boolean currentEnablecheckBxStatus = DHCPEN.isSelected();
		boolean currentDisablecheckBxStatus = DHCPDS.isSelected();
		if (isSSIDEn) {
			if (!currentEnablecheckBxStatus && currentDisablecheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, DHCPEN);
			} else
				return true;
		} else {
			if (currentEnablecheckBxStatus && !currentDisablecheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, DHCPDS);
			} else
				return true;
		}

	}
	
	public boolean _RTAC68U_ClearPasswordWPA() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password");
	}
	
	public boolean _RTAC68U_setValueinWPAPasswordTB(String password) {
		if (_RTAC68U_ClearPasswordWPA()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}
	
	public boolean _RTAC68U_ClearPasswordWEP() {
    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_Key1Password");
	}
	
	public boolean _RTAC68U_setValueinWEP1PasswordTB(String password) {
		if (_RTAC68U_ClearPasswordWEP()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_Key1Password", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}
	
	public boolean _RTAC68U_ClearSSIDName() {
	    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDvalue");
		}
	
	public boolean _RTAC68U_setvalueinSSID(String SSID) {
		if (_RTAC68U_ClearSSIDName()) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDvalue", SSID);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean _RTAC68U_setvalueinDHCP_IP_PoolRange(String DHCP_IPRange) {
		boolean flag=false;
		String[] ipRange = DHCP_IPRange.split("-");
		if (ipRange.length == 2) {
            String ipRangeStart = ipRange[0];
            String ipRangeEnd = ipRange[1];
            _RTAC68U_setvalueinDHCPStartrange(ipRangeStart);
            _RTAC68U_setvalueinDHCPendrange(ipRangeEnd);
            flag=true;
            }
		else{
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,"invalid input format");
			flag=false;
		}
		return flag;
	}
	
	public boolean _RTAC68U_ClearDHCPStartrange() {
	    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "IP_Pool_Start");
		}
	
	public boolean _RTAC68U_setvalueinDHCPStartrange(String DHCP_start_IP) {
		if(_RTAC68U_ClearDHCPStartrange()) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "IP_Pool_Start", DHCP_start_IP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dhcp start range");
			return false;
		}
	}
	
	public boolean _RTAC68U_ClearDHCPendrange() {
	    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "IP_Pool_End");
	}
	
	public boolean _RTAC68U_setvalueinDHCPendrange(String DHCP_end_IP) {
		if(_RTAC68U_ClearDHCPendrange()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "IP_Pool_End", DHCP_end_IP);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear end dhcp start range");
				return false;
			}
		}
	
	public boolean _RTAC68U_ClearDNSServerIP_1() {
	    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSServer1");
	}
	
	public boolean _RTAC68U_setvalueinDNSServerIP_1(String DNS_IP) {
		if(_RTAC68U_ClearDNSServerIP_1()) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSServer1", DNS_IP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dns ip");
			return false;
		}
		}
	
	public boolean _RTAC68U_ClearDHCPLeaseTime() {
	    return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DhcpLeaseinSeconds");
	}

	public boolean _RTAC68U_setvalueinDHCPLeaseTime(String Leasetime) {
		if(_RTAC68U_ClearDHCPLeaseTime()) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DhcpLeaseinSeconds", Leasetime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear lease time");
			return false;
		}
	}
	
}