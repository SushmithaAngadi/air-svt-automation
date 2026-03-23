package com.resideo.utils.web.screens;

import org.openqa.selenium.WebElement;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class VizioRouterScreen extends WebScreens {

	private static final String screenName = "VizioRouterScreen";

	public VizioRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean changeSSID_XWR100(String ssid_name, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID24_XWR100")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID24_XWR100", ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID Name - 24 Ghz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID5_XWR100")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID5_XWR100", ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID Name - 5 Ghz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean SecurityType_XWR100(String security_type, String frequency) {
		if (frequency.contains("2.4")) {
			WebElement SecurityType24DropDown = WebUtils.getWebElement(testCase, fieldObjects, "SecType24_XWR100");
			return WebUtils.selectElementFromDropDown(testCase, SecurityType24DropDown, SelectByOptions.ByVisibleText,
					security_type);
		} else if (frequency.contains("5")) {
			WebElement SecurityType5DropDown = WebUtils.getWebElement(testCase, fieldObjects, "SecType5_XWR100");
			return WebUtils.selectElementFromDropDown(testCase, SecurityType5DropDown, SelectByOptions.ByVisibleText,
					security_type);
		} else {
			return true;
		}
	}

	public boolean SecurityKey_XWR100(String security_key, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key24_XWR100")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key24_XWR100", security_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Security Key - 24Ghz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Key5_XWR100")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Key5_XWR100", security_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Security Key - 5 Ghz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean setstartip_HW2R1(String start_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIP_XWR100")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIP_XWR100", start_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Starting IP");
			return false;
		}
	}

	public boolean setvalueinDHCPLeaseTime_XWR100(String lease_time) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime_XWR100")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime_XWR100", lease_time);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Lease Time");
			return false;
		}
	}

	public boolean enable_disable_ssid_XWR100(String is_ssid, String frequency) {
		String isDisabled;
		if (frequency.contains("2.4")) {
			isDisabled = WebUtils.getDomAttribute(testCase, fieldObjects, "SSID24_XWR100", "disabled");
			if (is_ssid.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
				return true;
			} else if (is_ssid.contains("Enable") && isDisabled == null) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "IS_SSID24_XWR100");
			}
		} else if (frequency.contains("5")) {
			isDisabled = WebUtils.getDomAttribute(testCase, fieldObjects, "SSID5_XWR100", "disabled");
			if (is_ssid.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
				return true;
			} else if (is_ssid.contains("Enable") && isDisabled == null) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "IS_SSID5_XWR100");
			}
		}
		return false;
	}

	public boolean enable_disable_DHCP_HW2R1(String is_dhcp) {
		if (is_dhcp.contains("Enable")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPenable_XWR100");
		} else if (is_dhcp.contains("Disable")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPdisable_XWR100");
		}
		return false;
	}

	public boolean clickonApplybutton_XWR100(String screenName) {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveBtn_XWR100");
	}
}