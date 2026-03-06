package com.resideo.utils.web.screens;
import org.openqa.selenium.WebElement;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class HawkingRouterScreen extends WebScreens {

	private static final String screenName = "HawkingRouterScreen";

	public HawkingRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean changeChannel_HW2R1150M_HAW2R1300N(String channel) {
		WebElement ChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, ChannelDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean changeBand_HW2R1150M_HAW2R1300N(String band) {
		WebElement BandwidthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Band_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, BandwidthDropDown, SelectByOptions.ByVisibleText, band);
	}

	public boolean setSSIDName_HW2R1150M_HAW2R1300N(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID_HW2R1150M", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSIDName");
			return false;
		}
	}

	public boolean changeSecurity_HW2R1150M_HAW2R1300N(String security) {
		WebElement SecurityDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Encryption_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, SecurityDropDown, SelectByOptions.ByVisibleText, security);
	}

	public boolean setRadiusIP_HW2R1150M_HAW2R1300N(String radius_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP_HW2R1150M", radius_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius IP");
			return false;
		}
	}

	public boolean setRadiusPort_HW2R1150M_HAW2R1300N(String radius_port) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPort_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPort_HW2R1150M", radius_port);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setRadiusPassword_HW2R1150M_HAW2R1300N(String radius_password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusPass_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusPass_HW2R1150M", radius_password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Password");
			return false;
		}
	}

	public boolean selectWEPKeyLength_HW2R1150M_HAW2R1300N(String wepkey_length) {
		WebElement WEPKeyLengthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPLENGTH_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyLengthDropDown, SelectByOptions.ByVisibleText,
				wepkey_length);
	}

	public boolean KeyFormat_HW2R1150M_HAW2R1300N(String wepkey_format) {
		WebElement WEPKeyFormatDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPFORMAT_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, WEPKeyFormatDropDown, SelectByOptions.ByVisibleText,
				wepkey_format);
	}

	public boolean TxKey_HW2R1150M_HAW2R1300N(String txkey) {
		WebElement TxkeyDropDown = WebUtils.getWebElement(testCase, fieldObjects, "TxKey_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, TxkeyDropDown, SelectByOptions.ByVisibleText, txkey);
	}

	public boolean setWEPKey1_HW2R1150M_HAW2R1300N(String wep_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEPKEY1")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEPKEY1", wep_key);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WEP KEY1");
			return false;
		}
	}

	public boolean PresharedKey_HW2R1150M_HAW2R1300N(String presharedkey) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPAPSK_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPAPSK_HW2R1150M", presharedkey);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear PreShared Key");
			return false;
		}
	}

	public boolean WPAFormat_HW2R1150M_HAW2R1300N(String wpa_format) {
		if(wpa_format.contains("Pas")) {
			wpa_format="0";
		}else {
			wpa_format="1";
		}
		WebElement WPAFormatDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPAFORMAT_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, WPAFormatDropDown, SelectByOptions.ByValue,
				wpa_format);
	}

	public boolean enable_disable_DHCP_HW2R1150M_HAW2R1300N(String is_dhcp) {
		if(is_dhcp.toUpperCase().contains("DIS")) {
			is_dhcp="0";
		}else {
			is_dhcp="2";
		}
		WebElement DhcpDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ISDHCP_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, DhcpDropDown, SelectByOptions.ByValue, is_dhcp);
	}

	public boolean setvalueinDHCPLeaseTime_HW2R1150M_HAW2R1300N(String leaseTime) {
		WebElement LeaseTimeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "LeaseTime_HW2R1150M");
		return WebUtils.selectElementFromDropDown(testCase, LeaseTimeDropDown, SelectByOptions.ByVisibleText,
				leaseTime);
	}

	public boolean setstartip_HW2R1150M_HAW2R1300N(String startip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIP_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIP_HW2R1150M", startip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Start IP");
			return false;
		}
	}

	public boolean setendip_HW2R1150M_HAW2R1300N(String endip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "EndIP_HW2R1150M")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "EndIP_HW2R1150M", endip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear End IP");
			return false;
		}
	}

	public boolean WPASUITE_HW2R1150M_HAW2R1300N(String wpa_suite) {
		if (wpa_suite.toUpperCase().contains("WPA(TKIP)"))
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPATKIP_HW2R1150M");
		else if (wpa_suite.toUpperCase().contains("WPA2(AES)"))
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPAAES_HW2R1150M");
		else
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPAMIXED_HW2R1150M");
	}

	public boolean clickonApplybutton1_HW2R1150M_HAW2R1300N(String screename) {
		if (screename.contains("BASIC WIRELESS") || screename.contains("DHCP") || screename.contains("SAVED SETTINGS")
				|| screename.contains("SECURITY SETTINGS")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBTN_HW2R1150M");
		}else {
			return true;
		}

	}
	
	public boolean clickonApplybutton2_HW2R1150M_HAW2R1300N(String screename) {
		if (screename.contains("BASIC WIRELESS") || screename.contains("DHCP") || screename.contains("SAVED SETTINGS")
				|| screename.contains("SECURITY SETTINGS")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBTN2_HW2R1150M");
		}else {
			return true;
		}

	}
	
	public boolean setEnableradius_HW2R1150M_HAW2R1300N(String enable_radius) {
		boolean isEnable = false;
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "RadiusIP_HW2R1150M")) {
			isEnable = true;
		}
		if (enable_radius.contains("Dis")) {
			if (isEnable) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "EnRadius_HW2R1150M");
 
			} else {
				return true;
			}
		} else {
			if (isEnable) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "EnRadius_HW2R1150M");
 
			}
		}
	}

	public boolean clickonOk_HW2R1150M_HAW2R1300N(String screename) {
		boolean isEnable = false;
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "OK_BTN")) {
			isEnable = true;
			Keyword.ReportStep_Pass(testCase, "Ok Button Enabled");
		}
		if (isEnable) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OK_BTN");

		} else {
			return true;
		}
	}
	
	public boolean is_dns_Hawking(String is_dns) {
		if (is_dns.contains("Disable")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DNS_Disable");
		} else if (is_dns.contains("Enable")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DNS_Enable");
		} else {
			return false;
		}
	}

	public boolean set_Provider(String provider) {
		WebElement ProviderDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Provider_Hawking");
		return WebUtils.selectElementFromDropDown(testCase, ProviderDropDown, SelectByOptions.ByVisibleText, provider);
	}

	public boolean SetDomain(String domain) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Domain_Hawking")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Domain_Hawking", domain);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Domain in DNS");
			return false;
		}
	}

	public boolean SetAccount(String account) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Account_Hawking")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Account_Hawking", account);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear account in DNS");
			return false;
		}
	}

	public boolean SetDnsKey(String dns_key) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNS_PASSWORD_Hawking")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNS_PASSWORD_Hawking", dns_key);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dns_key in DNS");
			return false;
		}
	}
}