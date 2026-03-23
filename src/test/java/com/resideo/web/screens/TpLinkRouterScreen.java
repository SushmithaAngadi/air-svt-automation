package com.resideo.utils.web.screens;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.resideo.commons.coreframework.Keyword;
import com.resideo.commons.coreframework.TestCases;
import com.resideo.commons.report.FailType;
import com.resideo.commons.web.WebScreens;
import com.resideo.commons.web.WebUtils;
import com.resideo.commons.web.WebUtils.AlertOperations;
import com.resideo.commons.web.WebUtils.SelectByOptions;
import com.resideo.commons.web.WebUtils.WebObjectLocators;

public class TpLinkRouterScreen extends WebScreens {

	private static final String screenName = "TpLinkRouterScreen";

	public TpLinkRouterScreen(TestCases testCase) {
		super(testCase, screenName);
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

	public boolean enable_disable_SSID_24GhZ(String status) {
		boolean isSSIDEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "24GhzSSID");
		if (isExpectedElementPresent("24GhzSSID", "wireless-setting-2g")) {
			if (isSSIDEn) {
				if (!SSID.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "24GhzSSID");
				} else {
					return true;
				}
			} else {
				if (SSID.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "24GhzSSID");
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}

	public boolean enable_disable_SSID_5GhZ(String status) {
		boolean isSSIDEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isSSIDEn = true;
		}
		WebElement SSID = WebUtils.getWebElement(testCase, fieldObjects, "5GhzSSID");
		if (isExpectedElementPresent("5GhzSSID", "wireless-setting-5g1")) {
			if (isSSIDEn) {
				if (!SSID.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "5GhzSSID");
				} else {
					return true;
				}
			} else {
				if (SSID.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "5GhzSSID");
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}

	public boolean setValueinPasswordTB(String password) {
		return WebUtils.setValueOnWebElement(testCase, fieldObjects, "PasswordTB", password);
	}

	public boolean clickOnLoginBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "LoginBtn");
	}

	public boolean iselementPresent() {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "");
	}

	public boolean clickOnAdvanceSettingsBtn() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "AdvancedBtn");
	}

	public boolean isAdvanceSettingsOptionAvailable(int timeOut) {
		return WebUtils.isWebElementExists(testCase, fieldObjects, "AdvancedBtn");
	}

	public boolean clickOnWireless() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessBtn");
	}

	public boolean clickOnWirelessSettings() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "WirelessSettingsBtn");

	}

	public void scrollToTwoFrequency() {
		WebElement m = WebUtils.getWebElement(testCase, fieldObjects, "TwoGDiv");
		((JavascriptExecutor) testCase.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", m);
	}

	public void scrollToFiveFrequency() {
		((JavascriptExecutor) testCase.getWebDriver()).executeScript(
				"arguments[0].scrollTo(0, arguments[0].scrollHeight)",
				WebUtils.getWebElement(testCase, fieldObjects, "FiveGDiv"));
	}

	public boolean isSmartConnectionEnabled() {
//		WebElement SmartConnection = WebUtils.getWebElement(testCase, fieldObjects, "SmartConnectionChBx");
		if (isExpectedElementPresent("SmartConnectionChBx", "wirelessAdv-view")) {
			if (WebUtils.getWebElement(testCase, fieldObjects, "SmartConnectionChBx").getDomAttribute("class")
					.equals("checkbox-label  checked")) {
				return true;
			}
		}
		return false;
	}

	public boolean smartConnectCheckBox() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SmartConnectionChBx");
	}

	public boolean enable24GHZ() {
		WebElement TwoGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "24GhzChBx");
		if (TwoGEnabled.getDomAttribute("class").toUpperCase().contains("checked".toUpperCase())) {
			return true;
		} else {
			return WebUtils.clickOnWebElement(testCase, TwoGEnabled);
		}
	}

	public boolean enable24GHZ_5GHZband(String frequency) {
		if (frequency.contains("2.4")) {
			if (isExpectedElementPresent("24GhzChBx", "wireless-setting-5g1")) {
				WebElement TwoGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "24GhzChBx");
				if (TwoGEnabled.getDomAttribute("class").toUpperCase().contains("checked".toUpperCase())) {
					return true;
				} else {
					return WebUtils.clickOnWebElement(testCase, TwoGEnabled);
				}
			}
		} else if (frequency.contains("5")) {
			if (isExpectedElementPresent("5GhzChBx", "wireless-setting-5g1")) {
				WebElement FiveGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "5GhzChBx");
				if (FiveGEnabled.getDomAttribute("class").contains("checked")) {
					return true;
				} else {
					return WebUtils.clickOnWebElement(testCase, FiveGEnabled);
				}
			}
		}
		return false;
	}

	public boolean enable_disable5Ghz(boolean isEnable) {
		WebElement FiveGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "5GhzChBx");
		boolean currentcheckBxStatus = FiveGEnabled.getDomAttribute("class").equals("checkbox-label  checked");
		if (isEnable) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, FiveGEnabled);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, FiveGEnabled);
			} else
				return true;
		}

	}

	public boolean enable_disable24Ghz(boolean isEnable) {
		WebElement TwoGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "24GhzChBx");
		boolean currentcheckBxStatus = TwoGEnabled.getDomAttribute("class").equals("checkbox-label  checked");
		if (isEnable) {
			if (!currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, TwoGEnabled);
			} else
				return true;
		} else {
			if (currentcheckBxStatus) {
				return WebUtils.clickOnWebElement(testCase, TwoGEnabled);
			} else
				return true;
		}

	}

	public boolean enable_disable24GhZ(boolean isEnable) {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "");
	}

	public boolean isenable_disable24Ghz(boolean isEnabled) {

		boolean currentcheckBxStatus = WebUtils.getWebElement(testCase, WebObjectLocators.By_XPATH,
				"//*[text()='2.4GHz']/parent::div/parent::div/following-sibling::div/child::div/ul/li/div/label")
				.getDomAttribute("class").equals("checkbox-label  checked");
		if (isEnabled && currentcheckBxStatus) {
			return true;
		} else {
			return false;
		}

	}

	public boolean enable5GHZ() {
		if (isExpectedElementPresent("5GhzChBx", "wireless-setting-5g1")) {
			WebElement FiveGEnabled = WebUtils.getWebElement(testCase, fieldObjects, "5GhzChBx");
			if (FiveGEnabled.getDomAttribute("class").contains("checked")) {
				return true;
			} else {
				return WebUtils.clickOnWebElement(testCase, FiveGEnabled);
			}
		} else {
			return false;
		}
	}

	public boolean changeSecurity24Ghz(String Security) {

		if (isExpectedElementPresent("SecurityDrpDwn24Ghz", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityDrpDwn24Ghz")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Security
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeVersion24Ghz(String Version) {
		if (isExpectedElementPresent("VersionDrpDwn24Ghz", "")) {

			WebElement s = WebUtils.getWebElement(testCase, fieldObjects, "SecurityDrpDwn");
			String security = s.getDomAttribute("value");

			if (security.equals("WPA/WPA2-Personal") || security.equals("WPA2/WPA3-Personal")) {
				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "VersionDrpDwn24Ghz")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Version
									+ "']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the Version DropDown");
				}
			}
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"For security type:" + security + " Version DropDown is not available ");
			return false;
		} else {
			return false;
		}

	}

	public boolean changeEncryption24Ghz(String Encryption,String security) {
		boolean flag=false;
		if(security.contains("PERSONAL")) {
			flag=isExpectedElementPresent("EncryptionDrpDwn24Ghz", "personal-encryption-2g");
		}else {
			flag=isExpectedElementPresent("EncryptionDrpDwn24Ghz", "enterprise-encryption-2g");
		}
		if (flag) {
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "EncryptionDrpDwn24Ghz")) {
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Encryption
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Encryption DropDown");
			}

			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					 " Encryption DropDown is not available ");
			return false;
		} else {
			return false;
		}
	}

	public boolean changeChannelWidth24Ghz(String ChannelWidth) {
		if (isExpectedElementPresent("ChannelWidthDrpDwn24Ghz", "channelwidth-2g")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelWidthDrpDwn24Ghz")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + ChannelWidth
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the ChannelWidth DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeChannel24Ghz(String Channel) {
		if (isExpectedElementPresent("ChannelDrpDwn24Ghz", "channel-2g")) {

			boolean flag = false;
			WebDriver driver = testCase.getWebDriver();
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelDrpDwn24Ghz")) {
				if (WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel
							+ "']/parent::label")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel
									+ "']/parent::label");
				} else {
//						if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelDrpDwn24Ghz")) {
//							try {
//								Thread.sleep(4000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//						Actions action = new Actions(driver);
//						WebElement element= driver.findElement(By.xpath("//*[@id='global-combobox-options']/div/div/div/div/ul[@class='combobox-list']/li/label[@class='combobox-label single']/span[@class='text' and text()='"+Channel+"']"));
//						action.moveToElement(element);

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",
							driver.findElement(By.xpath("//*[@id='global-combobox-options']/div/div[3]/div/div")),
							driver.findElement(By.xpath(
									"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='"
											+ Channel + "']/parent::label")));
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel
									+ "']/parent::label");
//						if (!WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH,
//								"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel
//								+ "']",
//						1)) {
//							changeChannel24Ghz(Channel);
//						}
//						else
//						{
//							return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel+ "']");
//						}
//						flag=true;

				}

			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Channel DropDown");
				flag = false;
			}
			return flag;
		} else {
			return false;
		}
	}

	public boolean changeMode24Ghz(String Mode) {
		if (isExpectedElementPresent("ModeDrpDwn24Ghz", "mode-2g")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ModeDrpDwn24Ghz")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Mode
								+ "']");
			} else {
				// isExpectedElementPresent(testCase,"ModeDrpDwn24Ghz","mode-2g");
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Mode DropDown");
				return false;
			}
		} else {

			return false;

		}
	}

	public boolean changeSecurity5Ghz(String Security) {
		if (isExpectedElementPresent("SecurityDrpDwn5Ghz", "")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "SecurityDrpDwn5Ghz")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Security
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Security DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeVersion5Ghz(String Version) {
		if (isExpectedElementPresent("VersionDrpDwn5Ghz", "")) {

			WebElement s = WebUtils.getWebElement(testCase, fieldObjects, "SecurityDrpDwn5Ghz");
			String security = s.getDomAttribute("value");

			if (security.equals("WPA/WPA2-Personal") || security.equals("WPA2/WPA3-Personal")) {
				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "VersionDrpDwn5Ghz")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Version
									+ "']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the Version DropDown");
				}
			}
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"For security type:" + security + " Version DropDown is not available ");
			return false;
		} else {
			return false;
		}

	}

	public boolean changeEncryption5Ghz(String Encryption) {
		if (isExpectedElementPresent("EncryptionDrpDwn5Ghz", "")) {

			WebElement s = WebUtils.getWebElement(testCase, fieldObjects, "SecurityDrpDwn5Ghz");
			String security = s.getDomAttribute("value");
			if (security.equals("WPA/WPA2-Personal")) {
				if (WebUtils.clickOnWebElement(testCase, fieldObjects, "EncryptionDrpDwn5Ghz")) {
					return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
							"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='"
									+ Encryption + "']");
				} else {
					Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
							"Failed to click the Encryption DropDown");
				}
			}
			Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
					"For security type:" + security + " Encryption DropDown is not available ");
			return false;
		} else {
			return false;
		}
	}

	public boolean changeChannelWidth5Ghz(String ChannelWidth) {
		if (isExpectedElementPresent("ChannelWidthDrpDwn5Ghz", "channelwidth-5g1")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelWidthDrpDwn5Ghz")) {

				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + ChannelWidth
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the ChannelWidth DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeChannel5Ghz(String Channel) {
		if (isExpectedElementPresent("ChannelDrpDwn5Ghz", "channel-5g1")) {

			WebDriver driver = testCase.getWebDriver();
			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ChannelDrpDwn5Ghz")) {
				iselementPresent();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop=arguments[1].offsetTop",
						driver.findElement(By.xpath("//*[@id='global-combobox-options']/div/div[3]/div/div")),
						driver.findElement(By
								.xpath("//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='"
										+ Channel + "']/parent::label")));
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[contains(@class,'combobox-list')]/li/label/span[@class='text' and text()='" + Channel
								+ "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Channel DropDown");
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean changeMode5Ghz(String Mode) {
		if (isExpectedElementPresent("ModeDrpDwn5Ghz", "mode-5g1")) {

			if (WebUtils.clickOnWebElement(testCase, fieldObjects, "ModeDrpDwn5Ghz")) {
				iselementPresent();
				return WebUtils.clickOnWebElement(testCase, WebObjectLocators.By_XPATH,
						"//ul[@class='combobox-list']//span[text()='" + Mode + "']");
			} else {
				Keyword.ReportStep_Fail_WithOut_ScreenShot(testCase, FailType.FUNCTIONAL_FAILURE,
						"Failed to click the Mode DropDown");
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean clickOnSaveBtn() {
		if (isExpectedElementPresent("SaveBtn", "save-data")) {

			return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveBtn");
		} else {

			return false;
		}
	}

	public boolean clickOnOkBtn() {
		if (isExpectedElementPresent("OkBtn", "")) {

			return WebUtils.clickOnWebElement(testCase, fieldObjects, "OkBtn");
		} else {
			return false;
		}
	}

	public boolean clearSSIDName24() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID24_GHz");
	}

	public boolean setvalueinSSID24(String SSID) {
		if (clearSSIDName24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID24_GHz", SSID);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean clearSSIDName5() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSID5_GHz");
	}

	public boolean setvalueinSSID5(String SSID) {
		if (clearSSIDName5()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "SSID5_GHz", SSID);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to SSID Name");
			return false;
		}
	}

	public boolean clearPassword24() {
		if (isExpectedElementPresent("Password24GHz", "personal-password-2g")) {
			return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password24GHz");
		} else {
			return true;
		}
	}

	public boolean setValueinPassword24(String password) {
		if (clearPassword24()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password24GHz", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean clearPassword5() {
		if (isExpectedElementPresent("Password24GHz", "personal-password-5g1")) {
			return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5GHz");
		} else {
			return true;
		}
	}

	public boolean setValueinPassword5(String password) {
		if (clearPassword5()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5GHz", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean enable_disable_DHCP(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "DHCP_checkbox");
		if (isExpectedElementPresent("DHCP_checkbox",
				"widget--cb2f18cd-5134-b2f7-ce2a-e4bb5b8b4f43-checkbox-749478344")) {
			if (isDHCPEn) {
				if (!DHCP.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox");
				} else {
					return true;
				}
			} else {
				if (DHCP.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox");
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}

	public boolean clearDHCPLeaseTime() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Leasetimeminutes");
	}

	public boolean setvalueinDHCPLeaseTime(String Leasetime) {
		WebElement leaseTime = WebUtils.getWebElement(testCase, fieldObjects, "Leasetimeminutes");
		if (clearDHCPLeaseTime()) {
			return WebUtils.setValueOnWebElement(testCase, leaseTime, Leasetime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear lease time");
			return false;
		}
	}

	public boolean clearDNSServerIP_1() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSIP_1");
	}

	public boolean setvalueinDNSServerIP_1(String DNS_IP) {

		if (clearDNSServerIP_1()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSIP_1", DNS_IP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dns ip");
			return false;
		}
	}

	public boolean clearDNSServerIP_2() {
		return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DNSIP_2");
	}

	public boolean setvalueinDNSServerIP_2(String DNS_IP) {
		if (clearDNSServerIP_2()) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "DNSIP_2", DNS_IP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dns ip");
			return false;
		}
	}

	public boolean isTPLinkIDpopPresent() {
		return WebUtils.isWebElementExists(testCase, WebObjectLocators.By_XPATH, "TPLinkIDpopup");
	}

	public boolean clickonTPLinkIDpop() {
//				WebElement SmartConnection = WebUtils.getWebElement(testCase, fieldObjects, "SmartConnectionChBx");
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "TPLinkIDpopup");
	}

	public boolean clearPassword24_AX1800(String security) {
		boolean flag = false;
		if (security.toUpperCase().contains("WPA/WPA2-Personal".toUpperCase())) {
			flag = isExpectedElementPresent("Password24GHz", "personal-password-2g");
		} else {
			flag = isExpectedElementPresent("Password24GHz", "wpa3-personal-password-2g");
		}
		if (flag) {
			return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password24GHz");
		} else {
			return true;
		}
	}

	public boolean setValueinPassword24_AX1800(String password, String security) {
		if (clearPassword24_AX1800(security)) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password24GHz", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean clearPassword5_AX1800(String security) {
		boolean flag = false;
		if (security.toUpperCase().contains("WPA/WPA2-Personal".toUpperCase())) {
			flag = isExpectedElementPresent("Password5GHz", "personal-password-5g1");
		} else {
			flag = isExpectedElementPresent("Password5GHz", "wpa3-personal-password-5g1");
		}
		if (flag) {
			return com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "Password5GHz");
		} else {
			return true;
		}
	}

	public boolean setValueinPassword5_AX1800(String password, String security) {
		if (clearPassword5_AX1800(security)) {
			return WebUtils.setValueOnWebElement(testCase, fieldObjects, "Password5GHz", password);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear password");
			return false;
		}
	}

	public boolean enable_disable_DHCP_AX1800(String status) {
		boolean isDHCPEn = false;
		if (status.contains("YES") || status.contains("TRUE")) {
			isDHCPEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "DHCP_checkbox_AX1800");
		if (isExpectedElementPresent("DHCP_checkbox_AX1800", "dhcp-server-setting-loader")) {
			if (isDHCPEn) {
				if (!DHCP.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox_AX1800");
				} else {
					return true;
				}
			} else {
				if (DHCP.getDomAttribute("class").contains("checked")) {
					return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_checkbox_AX1800");
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
	}

	public boolean enable_disable_DHCP_TLWR740N(String is_dhcp) {
		boolean isDHCPEn = false;
		if (is_dhcp.contains("YES") || is_dhcp.contains("TRUE")) {
			isDHCPEn = true;
		}
		if (isDHCPEn) {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_Enable_TLWR740N");
		} else {
			return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_Disable_TLWR740N");
		}

	}

	public boolean clickOnDHCP_TLWR740N() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "DHCP_TLWR740N");
	}

	public boolean setvalueinDHCPLeaseTime_TLWR740N(String LeaseTime) {
		WebElement leaseTime = WebUtils.getWebElement(testCase, fieldObjects, "LeaseTime_TLWR740N");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "LeaseTime_TLWR740N")) {
			return WebUtils.setValueOnWebElement(testCase, leaseTime, LeaseTime);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear lease time");
			return false;
		}
	}

	public boolean setDHCPStartIP_TLWR740N(String dHCPStartIP) {
		WebElement element = WebUtils.getWebElement(testCase, fieldObjects, "DHCPStartIP_TLWR740N");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPStartIP_TLWR740N")) {
			return WebUtils.setValueOnWebElement(testCase, element, dHCPStartIP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dHCPStartIP");
			return false;
		}
	}

	public boolean setDHCPEndIP_TLWR740N(String dHCPEndIP) {
		WebElement element = WebUtils.getWebElement(testCase, fieldObjects, "DHCPEndIP_TLWR740N");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "DHCPEndIP_TLWR740N")) {
			return WebUtils.setValueOnWebElement(testCase, element, dHCPEndIP);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear dHCPEndIP");
			return false;
		}
	}

	public boolean clickOnWireless_TLWR740N() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "wiireless_TLWR740N");
	}

	public boolean enable_disable_SSID_TLWR740N(String is_ssid) {
		boolean is_ssidEn = false;
		if (is_ssid.contains("YES") || is_ssid.contains("TRUE")) {
			is_ssidEn = true;
		}
		WebElement DHCP = WebUtils.getWebElement(testCase, fieldObjects, "SSID_checkbox_TLWR740N");
		if (is_ssidEn) {
			if (!DHCP.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID_checkbox_TLWR740N");
			} else {
				return true;
			}
		} else {
			if (DHCP.getDomAttribute("class").contains("checked")) {
				return WebUtils.clickOnWebElement(testCase, fieldObjects, "SSID_checkbox_TLWR740N");
			} else {
				return true;
			}
		}

	}

	public boolean setvalueinSSID24_TLWR740N(String ssid_name) {
		WebElement element = WebUtils.getWebElement(testCase, fieldObjects, "SSIDname_TLWR740N");
		if (com.resideo.utils.web.HHWebUtils.clearTextField(fieldObjects, testCase, "SSIDname_TLWR740N")) {
			return WebUtils.setValueOnWebElement(testCase, element, ssid_name);
		} else {
			Keyword.ReportStep_Fail(testCase, FailType.COSMETIC_FAILURE, "Not able to clear ssid_name");
			return false;
		}
	}

	public boolean changeChannel24Ghz__TLWR740N(String channel) {
		WebElement DrpDwn = WebUtils.getWebElement(testCase, fieldObjects, "Channel_TLWR740N");
		return WebUtils.selectElementFromDropDown(testCase, DrpDwn, SelectByOptions.ByVisibleText, channel);
	}

	public boolean changeMode24Ghz_TLWR740N(String mode) {
		WebElement DrpDwn = WebUtils.getWebElement(testCase, fieldObjects, "Mode_TLWR740N");
		return WebUtils.selectElementFromDropDown(testCase, DrpDwn, SelectByOptions.ByVisibleText, mode);
	}

	public boolean changeChannelWidth24Ghz_TLWR740N(String bandwidth) {
		WebElement DrpDwn = WebUtils.getWebElement(testCase, fieldObjects, "Bandwidth_TLWR740N");
		return WebUtils.selectElementFromDropDown(testCase, DrpDwn, SelectByOptions.ByVisibleText, bandwidth);
	}

	public boolean clickOnSaveBtn_TLWR740N() {
		return WebUtils.clickOnWebElement(testCase, fieldObjects, "SaveBtn_TLWR740N");
	}

	public boolean AcceptRequest() {
		return WebUtils.interactWithAlert(testCase, AlertOperations.Accept);
	}
}