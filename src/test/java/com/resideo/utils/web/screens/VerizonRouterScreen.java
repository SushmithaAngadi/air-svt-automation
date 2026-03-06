package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class VerizonRouterScreen extends WebScreens {
	public static final String screenName = "VerizonRouterScreen";

	public VerizonRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean clickOnWirlessSetting_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Wireless_MI424WR");
	}

	public boolean clickBasicSecuritySettings_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicSecurity_MI424WR");
	}

	public boolean changeChannel_MI42424(String channel) {
		WebElement ChannelDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Channel_MI424WR");
		return WebUtils.selectElementFromDropDown(testCase, ChannelDropDown, SelectByOptions.ByVisibleText, channel);
	}

	public boolean setSSIDName_MI42424(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName_MI424WR")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName_MI424WR", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID NAME");
			return false;
		}
	}

	public boolean ClickOnApplyBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "ApplyBtn_MI424WR");
	}

	public boolean setWirlessStatus_MI42424(String wireless_status) {
		if (wireless_status.contains("ON")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessON_MI42RWR");
		} else if (wireless_status.contains("OFF")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessOFF_MI424WR");
		} else {
			return true;
		}
	}

	public boolean clickAttentionApply_MIM424WR(String screenName2) {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "AttentionAPPLY_MIM424WR")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "AttentionAPPLY_MIM424WR");
		} else {
			return true;
		}
	}

	public boolean SetWEPStatus_MI42424(String wep_status) {
		if (wep_status.contains("ON")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPStatusON");
		} else if (wep_status.contains("OFF")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEPStatusOFF");
		} else {
			return true;
		}
	}

	public boolean SetWEPBit_MI42424(String wep_bit) {
		WebElement WEPBitDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEPBit");
		return WebUtils.selectElementFromDropDown(testCase, WEPBitDropDown, SelectByOptions.ByVisibleText, wep_bit);
	}

	public boolean SetWEPMode_MI42424(String wep_mode) {
		WebElement WEPModeDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WEP_MODE");
		return WebUtils.selectElementFromDropDown(testCase, WEPModeDropDown, SelectByOptions.ByVisibleText, wep_mode);
	}

	public boolean SetKeyCode_MI42424(String key_code, String wep_bit, String wep_mode) {
		if ((wep_bit.contains("64") || wep_bit.contains("40")) && wep_mode.contains("Hex")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key64_40_Hex")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key64_40_Hex", key_code);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_bit.contains("64") || wep_bit.contains("40")) && wep_mode.contains("ASCII")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key64_40_ASCII")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key64_40_ASCII", key_code);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_bit.contains("128") || wep_bit.contains("104")) && wep_mode.contains("Hex")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key128_104_Hex")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key128_104_Hex", key_code);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_bit.contains("128") || wep_bit.contains("104")) && wep_mode.contains("ASCII")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key128_104_ASCII")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key128_104_ASCII", key_code);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean SetSecurity_MI42424(String security) {
		if (security.contains("WEP")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WEP_MIM424WR");
		} else if (security.contains("WPA")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA_MIM424WR");
		} else if (security.contains("WPA2")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WPA2_MIM424WR");
		} else {
			return true;
		}

	}

	public boolean SetAuthWPA_MI42424(String auth_wpa) {
		WebElement AuthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPA_AUTH_MODE");
		return WebUtils.selectElementFromDropDown(testCase, AuthDropDown, SelectByOptions.ByVisibleText, auth_wpa);
	}

	public boolean SetEncryAlgo_WPA_MI42424(String encry_algo) {
		WebElement EncryDropDown = WebUtils.getWebElement(testCase, fieldObjects, "ENCRY_ALGO_WPA");
		return WebUtils.selectElementFromDropDown(testCase, EncryDropDown, SelectByOptions.ByVisibleText, encry_algo);
	}

	public boolean SetWPA_PSK_MODE_MI42424(String wpa_psk_mode) {
		WebElement PSKDropDown = WebUtils.getWebElement(testCase, fieldObjects, "WPA_PSK_MODE");
		return WebUtils.selectElementFromDropDown(testCase, PSKDropDown, SelectByOptions.ByVisibleText, wpa_psk_mode);
	}

	public boolean SetWPAkey_MI42424(String wpa_psk_mode, String wpa_key) {
		if (wpa_psk_mode.contains("Hex")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPA_KEY_HEX_MIM424WR")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPA_KEY_HEX_MIM424WR", wpa_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WPA KEY HEX IN SECURITY");
				return false;
			}
		}else if (wpa_psk_mode.contains("ASCII")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WPA_KEY_MIM424WR")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WPA_KEY_MIM424WR", wpa_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear WPA KEY ASCII IN SECURITY");
				return false;
			}
		}else {
			return true;
		}
	}

	public boolean clickAdvancedSecuritySettings_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedSecurity");
	}

	public boolean setRadiusPort_MIM424WR(String radius_port) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radius_Port_MIM424WR")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radius_Port_MIM424WR", radius_port);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setRadiusPassword_MIM424WR(String radius_password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radius_Key_MIM424WR")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radius_Key_MIM424WR", radius_password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setRadiusIP_MIM424WR(String radius_ip) {
		String[] serverValue = radius_ip.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP0")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP0", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP1")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP1", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP2")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP2", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIP3")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIP3", serverValue[3]);
		}
		return flag;
	}

	public boolean setAdvanceWEP_MIM424WR(String adv_wep_mode) {
		WebElement AdvDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Adv_WEP_MODE");
		return WebUtils.selectElementFromDropDown(testCase, AdvDropDown, SelectByOptions.ByVisibleText, adv_wep_mode);
	}

	public boolean setNetworkAuth_MIM424WR(String network_auth) {
		WebElement AuthDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Network_Auth");
		return WebUtils.selectElementFromDropDown(testCase, AuthDropDown, SelectByOptions.ByVisibleText, network_auth);
	}

	public boolean setWEPLength_MIM424WR(String wep_length) {
		WebElement LengDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Adv_WEP_Length");
		return WebUtils.selectElementFromDropDown(testCase, LengDropDown, SelectByOptions.ByVisibleText, wep_length);
	}

	public boolean setEntryMethod_MIM424WR(String entry_method) {
		WebElement EntryDropDown = WebUtils.getWebElement(testCase, fieldObjects, "Entry_Method");
		return WebUtils.selectElementFromDropDown(testCase, EntryDropDown, SelectByOptions.ByVisibleText, entry_method);
	}

	public boolean setWEPKey_MIM424WR(String wep_key , String wep_length, String entry_method) {
		if ((wep_length.contains("64") || wep_length.contains("40")) && entry_method.contains("Hex")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_HEX_64")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_HEX_64", wep_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_length.contains("64") || wep_length.contains("40")) && entry_method.contains("ASCII")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_ASCII_64")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_ASCII_64", wep_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_length.contains("128") || wep_length.contains("104")) && entry_method.contains("Hex")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_HEX_128")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_HEX_128", wep_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else if ((wep_length.contains("128") || wep_length.contains("104")) && entry_method.contains("ASCII")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_ASCII_128")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_ASCII_128", wep_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear KEY CODE");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean setRadiusPort_WEP_MIM424WR(String radius_port) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_RadiusPort")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_RadiusPort", radius_port);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setRadiusIP_WEP_MIM424WR(String radius_ip) {
		String[] serverValue = radius_ip.split("\\.");
		boolean flag = false;
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_RadiusIP0")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_RadiusIP0", serverValue[0]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_RadiusIP1")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_RadiusIP1", serverValue[1]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_RadiusIP2")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_RadiusIP2", serverValue[2]);
		}
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "WEP_RadiusIP3")) {
			flag = WebUtils.setValueOnWebElement(testCase, fieldObjects, "WEP_RadiusIP3", serverValue[3]);
		}
		return flag;
	}

	public boolean clickOnAdvanced_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Advanced_MI424WR");
	}

	public boolean EnterDHCPSettings_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Yes_MI424WR");
	}

	public boolean clickIPAddressAllocation_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_BTN");
	}

	public boolean clickEdit_MI42424() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Edit_Btn");
	}

	public boolean IS_DHCP_MI424WR(String is_dhcp) {
		WebElement dhcpDropDown = WebUtils.getWebElement(testCase, fieldObjects, "DHCP");
		return WebUtils.selectElementFromDropDown(testCase, dhcpDropDown, SelectByOptions.ByVisibleText, is_dhcp);
	}

	public boolean setstartip_MI424WR(String start_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "START_IP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "START_IP", start_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setendip_MI424WR(String end_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "END_IP")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "END_IP", end_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean setvalueinDHCPLeaseTime__MI424WR(String lease_time) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LEASE_TIME")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LEASE_TIME", lease_time);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port");
			return false;
		}
	}

	public boolean ClickClose(String screenName2) {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "close")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "close");
		} else {
			return true;
		}
	}

	
}