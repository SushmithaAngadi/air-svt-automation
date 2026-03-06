package com.resideo.utils.web.screens;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.resideo.commons.coreframework.FrameworkGlobalVariables;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;

public class WDRouterScreen extends WebScreens {

	private static final String screenName = "WDRouterScreen";

	public WDRouterScreen(TestCases testCase) {
		super(testCase, screenName);
	}

	public boolean changeSSID_MyNetN900(String ssid_name, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID_NAME2G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID_NAME2G_MyNetN900", ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID NAME 2.4 GHz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID_NAME5G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID_NAME5G_MyNetN900", ssid_name);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear SSID NAME 5 GHz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean NetworkMode_MyNetN900(String network_mode, String frequency) {
		WebDriver webDriver = testCase.getWebDriver();
		if (frequency.contains("2.4")) {
			WebElement findElement = webDriver.findElement(By.xpath("//*[@id='wlan_mode']"));
			return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
					network_mode);
		} else if (frequency.contains("5")) {
			WebElement findElement = webDriver.findElement(By.xpath("//*[@id='wlan_mode_Aband']"));
			return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
					network_mode);
		} else {
			return true;
		}
	}

	public boolean SecurityType_MyNetN900(String security, String frequency) {
		try {
			Thread.sleep(2000);
			WebDriver webDriver = testCase.getWebDriver();
			if (frequency.contains("2.4")) {
				WebElement findElement = webDriver.findElement(By.xpath("//*[@id='security_type']"));
				return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
						security);
			} else if (frequency.contains("5")) {
				WebElement findElement = webDriver.findElement(By.xpath("//*[@id='security_type_Aband']"));
				return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
						security);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean ChannelWidth_MyNetN900(String channel_width, String frequency) {
		WebDriver webDriver = testCase.getWebDriver();
		if (frequency.contains("2.4")) {
			WebElement findElement = webDriver.findElement(By.xpath("//*[@id='bw']"));
			return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
					channel_width);
		} else if (frequency.contains("5")) {
			WebElement findElement = webDriver.findElement(By.xpath("//*[@id='bw_Aband']"));
			return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
					channel_width);
		} else {
			return true;
		}
	}

	public boolean Channel_MyNetN900(String channel, String frequency) {
		WebDriver webDriver = testCase.getWebDriver();
			if (frequency.contains("2.4")) {
				WebElement findElement = webDriver.findElement(By.xpath("//*[@id='channel']"));
				return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
						channel);
			} else if (frequency.contains("5")) {
				WebElement findElement = webDriver.findElement(By.xpath("//*[@id='channel_Aband']"));
				return WebUtils.selectElementFromDropDown(testCase, findElement, SelectByOptions.ByVisibleText,
						channel);
			} else {
				return true;
			}
		} 

	public boolean setstartip_MyNetN900(String start_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "StartIp_MyNetN900")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "StartIp_MyNetN900", start_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Starting IP");
			return false;
		}
	}

	public boolean setendip_MyNetN900(String end_ip) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "EndIp_MyNetN900")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "EndIp_MyNetN900", end_ip);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Ending IP");
			return false;
		}
	}

	public boolean setvalueinDHCPLeaseTime_MyNetN900(String lease_time) {
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime_MyNetN900")) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "LeaseTime_MyNetN900", lease_time);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Lease Time");
			return false;
		}
	}

	public boolean RadiusIp_MyNetN900(String radius_ip, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIp2G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIp2G_MyNetN900", radius_ip);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius IP 2.4 GHz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "RadiusIp5G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "RadiusIp5G_MyNetN900", radius_ip);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius IP 5 GHz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean Radius_Port_MyNetN900(String radius_port, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radiusport2G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radiusport2G_MyNetN900", radius_port);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port 2.4 GHz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radiusport5G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radiusport5G_MyNetN900", radius_port);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Radius Port 5 GHz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean Radius_Key_MyNetN900(String radius_shared_key, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radius_Key2G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radius_Key2G_MyNetN900",
						radius_shared_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Not able to clear Radius Shared Key 2.4 GHz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Radius_Key5G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Radius_Key5G_MyNetN900",
						radius_shared_key);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE,
						"Not able to clear Radius Shared Key 5 GHz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean clickonApplybutton_MyNetN900(String screenName) {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "Save_Btn_MyNetN900");
	}

	public boolean acceptAlert() {
		if (interactWithAlert(testCase, AlertOperations.Accept, false)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean interactWithAlert(TestCases testCase, AlertOperations action, boolean isAlertManditory) {
		String AlertMsg = "";
		WebDriver driver = testCase.getWebDriver();
		boolean flag = false;
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

				} catch (org.openqa.selenium.TimeoutException e) {
					if (!isAlertManditory) {
						Keyword.ReportStep_Pass(testCase, String.format("Alert did not appear"));
						flag = true;
					} else {
						Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
								String.format("Interact with alert : %s action not happened. As alert didnt appeared.",
										action));
						return false;
					}
				}
				Keyword.ReportStep_Pass(testCase, String.format("Interact with alert : %s action successful.", action));
				Keyword.ReportStep_Pass(testCase, "\n Alert Text :" + AlertMsg);
				flag = true;

			} catch (Exception e) {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FRAMEWORK_CONFIGURATION,
						String.format("Interact with alert : [%s] action failed. Reason - %s", action, e.getMessage()));
			}
		}

		return flag;
	}

	public boolean password_MyNetN900(String password, String frequency) {
		if (frequency.contains("2.4")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password2G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password2G_MyNetN900", password);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Security Key - 24Ghz");
				return false;
			}
		} else if (frequency.contains("5")) {
			if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5G_MyNetN900")) {
				return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5G_MyNetN900", password);
			} else {
				Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear Security Key - 5 Ghz");
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean clickContbutton_MyNetN900(String screenName2) {
		if (WebUtils.isWebElementExists(testCase, fieldObjects, "ContBtn_MyNetN900")) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "ContBtn_MyNetN900");
		} else {
			return true;
		}
	}

	public boolean enable_disable_DHCP_MyNetN900(String is_dhcp) {
		String isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "StartIp_MyNetN900", "disabled");
		if (is_dhcp.contains("NO") && !(isDisabled == null) && isDisabled.equals("true")) {
			return true;
		} else if (is_dhcp.contains("YES") && isDisabled == null) {
			return true;
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "IS_DHCP_MyNetN900");
		}
	}

	public boolean enable_Frequency_MyNetN900(String is_ssid, String frequency) {
		String isDisabled;
		if (frequency.contains("2.4")) {
			isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "SSID_NAME2G_MyNetN900", "disabled");
			if (is_ssid.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
				return true;
			} else if (is_ssid.contains("Enable") && isDisabled == null) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Freq_24_MyNetN900");
			}
		} else if (frequency.contains("5")) {
			isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "SSID_NAME5G_MyNetN900", "disabled");
			if (is_ssid.contains("Disable") && !(isDisabled == null) && isDisabled.equals("true")) {
				return true;
			} else if (is_ssid.contains("Enable") && isDisabled == null) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "Freq_5_MyNetN900");
			}
		}
		return false;
	}

	public boolean changeSSIDBroadcast_MyNetN900(String is_ssid, String frequency) {
		String isDisabled;
		if (frequency.contains("2.4")) {
			isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "SSID_Broad24Ghz", "style");
			if (is_ssid.contains("NO") && isDisabled.toUpperCase().contains("OFF")) {
				return true;
			} else if (is_ssid.contains("YES") && !isDisabled.toUpperCase().contains("OFF")) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID_Broad24Ghz");
			}
		} else if (frequency.contains("5")) {
			isDisabled = WebUtils.getAttribute(testCase, fieldObjects, "SSID_Broad5Ghz", "style");
			if (is_ssid.contains("NO") && isDisabled.toUpperCase().contains("OFF")) {
				return true;
			} else if (is_ssid.contains("YES") && !isDisabled.toUpperCase().contains("OFF")) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID_Broad5Ghz");
			}
		}
		return false;
	}
}