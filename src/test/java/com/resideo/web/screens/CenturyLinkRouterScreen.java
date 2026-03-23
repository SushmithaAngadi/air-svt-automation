package com.resideo.utils.web.screens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class CenturyLinkRouterScreen extends WebScreens {
	private static final String screenName = "CenturyLinkRouterScreen";

	public CenturyLinkRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean enable_disable_Wireless(String enableDisable) {
		if (enableDisable.toUpperCase().contains("ENABLE")||enableDisable.toUpperCase().contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessRadioEnable_ZYXELC3000Z");
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessRadioDisable_ZYXELC3000Z");
		}
	}

	public boolean setvalueinSSID_ZYXELC3000Z(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID_ZYXELC3000Z")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID_ZYXELC3000Z", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear ssid_name");
			return false;
		}
	}

	public boolean selectSecurity_ZYXELC3000Z(String security) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "SecurityDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, security);
	}

	public boolean setValueinPassword_ZYXELC3000Z(String password) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "PasswordTxtBox_ZYXELC3000Z")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordTxtBox_ZYXELC3000Z", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean clickOnCustomSecurityKey_ZYXELC3000Z() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "CustomRadioEnable_ZYXELC3000Z");
	}

	public boolean selectChannel_ZYXELC3000Z(String channel) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "ChannelDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, channel);
	}

	public boolean selectChannelWidth_ZYXELC3000Z(String channelWidth) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "ChannelWidthDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, channelWidth);
	}

	public boolean selectMode_ZYXELC3000Z(String mode) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "ModeDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, mode);
	}

	public boolean selectPowerLevel_ZYXELC3000Z(String powerLevel) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "PowerLevelDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, powerLevel);
	}

	public boolean selectAggregation_ZYXELC3000Z(String aggregation) {
		WebElement Element = WebUtils.getWebElement(testCase, fieldObjects, "AggregationDrpDwn_ZYXELC3000Z");
		return WebUtils.selectElementFromDropDown(testCase, Element, SelectByOptions.ByVisibleText, aggregation);
	}

	public boolean enable_disable_MMIO_ZYXELC3000Z(String is_MMIO) {
		if (is_MMIO.toUpperCase().contains("ENABLE") || is_MMIO.toUpperCase().contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "MMIOEnable_ZYXELC3000Z");
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "MMIODisable_ZYXELC3000Z");
		}
	}

	public boolean enable_disable_SSID_ZYXELC3000Z(String is_ssid) {
		if (is_ssid.toUpperCase().contains("ENABLE") ||is_ssid.toUpperCase().contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDBroadcastEnable_ZYXELC3000Z");
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDBroadcastDisable_ZYXELC3000Z");
		}
	}

	public boolean setvalueinSSIDName_ZYXELC3000Z(String ssid_name) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDName_ZYXELC3000Z")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSIDName_ZYXELC3000Z", ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean enable_disable_DHCP_ZYXELC3000Z(String is_dhcp) {
		if (is_dhcp.toUpperCase().contains("ENABLE") || is_dhcp.toUpperCase().contains("YES")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPEnable_ZYXELC3000Z");
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPDisable_ZYXELC3000Z");
		}
	}

	public boolean setvalueinDHCPLeaseTime_ZYXELC3000Z(String leaseTime) {
		boolean flag = false;
		String lease_Time = "";
		if (leaseTime.toUpperCase().contains("DAY")) {
			Pattern daysPattern = Pattern.compile("(\\d+)\\s*(?i)day");
			Matcher daysMatcher = daysPattern.matcher(leaseTime);
			if (daysMatcher.find()) {
				lease_Time = daysMatcher.group(1);
			}
			return clearAndSetValue("DaysinLeaseTime_ZYXELC3000Z", lease_Time);
		}
		if (leaseTime.toUpperCase().contains("HOURS")) {
			Pattern hoursPattern = Pattern.compile("(\\d+)\\s*(?i)hour");
			Matcher daysMatcher = hoursPattern.matcher(leaseTime);
			if (daysMatcher.find()) {
				lease_Time = daysMatcher.group(1);
			}
			return clearAndSetValue("HoursinLeaseTime_ZYXELC3000Z", lease_Time);
		}
		if (leaseTime.toUpperCase().contains("MINUTES")) {
			Pattern minutesPattern = Pattern.compile("(\\d+)\\s*(?i)minute");
			Matcher daysMatcher = minutesPattern.matcher(leaseTime);
			if (daysMatcher.find()) {
				lease_Time = daysMatcher.group(1);
			}
			return clearAndSetValue("MinutesinLeaseTime_ZYXELC3000Z", lease_Time);
		}
		return false;
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

	public boolean setDHCPStartIP_ZYXELC3000Z(String dhcpStartIPAdd) {
		return clearAndSetValue("DHCPStartIPAdd_ZYXELC3000Z", dhcpStartIPAdd);
	}

	public boolean setDHCPEndIP_ZYXELC3000Z(String dhcpEndIPAdd) {
		return clearAndSetValue("DHCPEndIPAdd_ZYXELC3000Z", dhcpEndIPAdd);
	}

	public boolean clickOnSaveBtn(String screename,String frequency) {
		if(frequency.contains("2.4")) {
			if (screename.contains("BASIC")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("DHCP")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("WIRELESS")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("RADIO")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "RadioApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("SSID")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDApplyBtn_ZYXELC3000Z");
			}
		}else {
			if (screename.contains("BASIC")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "BasicApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("DHCP")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCPApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("WIRELESS")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessApplyBtn_ZYXELC3000Z");
			} else if (screename.contains("RADIO")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "RadioApplyBtn5G_ZYXELC3000Z");
			} else if (screename.contains("SSID")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSIDApplyBtn_ZYXELC3000Z");
			}
		}
		return false;
	}

	public boolean isOkBtnPresent() {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "OkBtn_ZYXELC3000Z");
	}

	public boolean clickOnOkBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "OkBtn_ZYXELC3000Z");
	}

}